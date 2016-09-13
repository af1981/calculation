package com.taxes.calculation.business;

import java.util.List;

import utilities.Utilities;

import com.taxes.calculation.data.IOrder;
import com.taxes.calculation.data.IProduct;
import com.taxes.calculation.data.IRowOrder;
import com.taxes.calculation.data.ProductCategory;
import com.taxes.calculation.dataaccess.DataAccess;
import com.taxes.calculation.dataaccess.IDataAccess;

public class TaxesCalculator implements ITaxesCalculator {
	
	private IDataAccess dataAccess = null; 
	
	public TaxesCalculator(){
		//PER DISACCOPPIARE L'IMPLEMENTAZIONE DALL'INTERFACCIA E' MEGLIO ISTANZIARE VIA FILE XML SPRING (IOC)
		dataAccess = new DataAccess(); 
	}
	
	/**
	 * 
	 * Function that update a give Product with the taxes and it total price
	 * 
	 * @param product
	 * @param defaultTaxPercentage
	 * @param importTaxPercentage
	 * @param defaultTaxExclusions
	 * @throws Exception
	 */
	private void calculateTaxes(IProduct product, double defaultTaxPercentage, double importTaxPercentage, List<ProductCategory> defaultTaxExclusions) throws Exception{
		if(product!=null){
			//Calculating the total tax percentage...
			double taxPercentage = 0;
			//...before about the default percentage...
			ProductCategory productCategory = product.getCategory();
			if(productCategory!=null){
				if(!defaultTaxExclusions.contains(productCategory)){
					taxPercentage = taxPercentage + defaultTaxPercentage;
				}
			}
			else{
				throw new Exception("The product "+product+" has NOT got a category");
			}
			//...then about the import tax percentage
			if(product.getImported()){
				taxPercentage = taxPercentage + importTaxPercentage;
			}
			//Updating the totals
			double totalTaxes = Utilities.decimalRound(product.getPrice() * (taxPercentage/100), 2);
			//Rounding up to the nearest 0.05
			double roundedTotalTaxes = Math.ceil(totalTaxes * 20.0) / 20.0; 
			//Setting the taxes of the product and the selling price
			product.setTaxes(roundedTotalTaxes); 
			product.setTotalPrice(Utilities.decimalRound(product.getPrice() + product.getTaxes(), 2));
		}
		else{
			throw new Exception("The product is empty");
		}
	}
	
	/* (non-Javadoc)
	 * @see com.taxes.calculation.business.ITaxesCalculator#calculateTotalAmounts(com.taxes.calculation.data.IOrder)
	 */
	public void calculateTotalAmounts(IOrder order) throws Exception{
		try{
			if(order!=null && order.getRowOrders()!=null && order.getRowOrders().size()>0){
				order.setTaxes(0);
				order.setTotal(0);
				//Retrieving only once data from Data Access Layer
				double defaultTaxPercentage = dataAccess.getDefaultTaxesPercentage();
				double importTaxPercentage = dataAccess.getImportTaxPercentage();
				List<ProductCategory> defaultTaxExclusions = dataAccess.getDefaultTaxExclusions();
				//Calculating taxes and selling price of each product and of the whole order
				List<IRowOrder> rowOrders = order.getRowOrders();
				for(IRowOrder rowOrder: rowOrders){
					//Calculating the final price for every product into the order, taxes included
					calculateTaxes(rowOrder.getProduct(), defaultTaxPercentage, importTaxPercentage, defaultTaxExclusions);
					//Increasing total of the taxes of the order
					double rowOrderTotalTaxes = rowOrder.getQuantity() *  rowOrder.getProduct().getTaxes();
					order.setTaxes(order.getTaxes() +  rowOrderTotalTaxes);
					//Increasing total of the order
					double rowOrderTotalPrice = rowOrder.getQuantity() *  rowOrder.getProduct().getTotalPrice();
					order.setTotal(order.getTotal() + rowOrderTotalPrice);
				}
			}
			else{
				Utilities.log("The order was empty");
			}
		}
		catch(Exception e){
			Utilities.log(e);
			throw e;
		}
	}
	
	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("TaxesCalculator [dataAccess=");
		builder.append(dataAccess);
		builder.append("]");
		return builder.toString();
	}

}
