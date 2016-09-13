package com.taxes.calculation.data;

import java.util.List;

import utilities.Utilities;

public class Order implements IOrder{
	
	private long id;
	private List<IRowOrder> rowOrders;
	private double taxes = 0;
	private double total = 0;
	
	public Order(){
	}
	
	/* (non-Javadoc)
	 * @see com.taxes.calculation.data.IOrder#getId()
	 */
	public long getId() {
		return id;
	}
	
	/* (non-Javadoc)
	 * @see com.taxes.calculation.data.IOrder#setId(long)
	 */
	public void setId(long id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see com.taxes.calculation.data.IOrder#getRowOrders()
	 */
	public List<IRowOrder> getRowOrders() {
		return rowOrders;
	}
	
	/* (non-Javadoc)
	 * @see com.taxes.calculation.data.IOrder#setRowOrders(java.util.List)
	 */
	public void setRowOrders(List<IRowOrder> rowOrders) {
		this.rowOrders = rowOrders;
	}

	/* (non-Javadoc)
	 * @see com.taxes.calculation.data.IOrder#getTaxes()
	 */
	public double getTaxes() {
		return taxes;
	}

	/* (non-Javadoc)
	 * @see com.taxes.calculation.data.IOrder#setTaxes(double)
	 */
	public void setTaxes(double taxes) {
		this.taxes = taxes;
	}

	/* (non-Javadoc)
	 * @see com.taxes.calculation.data.IOrder#getTotal()
	 */
	public double getTotal() {
		return total;
	}

	/* (non-Javadoc)
	 * @see com.taxes.calculation.data.IOrder#setTotal(double)
	 */
	public void setTotal(double total) {
		this.total = total;
	}	

	/* (non-Javadoc)
	 * @see com.taxes.calculation.data.IOrder#printToConsole(String)
	 */
	public String printToConsole() {
		final StringBuilder builder = new StringBuilder();
		for(IRowOrder rowOrder: rowOrders){
			IProduct product = rowOrder.getProduct();
			if(product!=null){
				builder.append(rowOrder.getQuantity());
				builder.append(" ");
				if(product.getImported()){
					builder.append("imported ");
				}
				builder.append(Utilities.getStringToPrint(product.getDescription()));
				builder.append(": ");
				builder.append(Utilities.currencyFormatter(rowOrder.getQuantity()*product.getTotalPrice()));
				builder.append("\n");
			}
		}
		builder.append("Sales Taxes: ");
		builder.append(Utilities.currencyFormatter(taxes));
		builder.append("\n");
		builder.append("Total: ");
		builder.append(Utilities.currencyFormatter(total));
		return builder.toString();
	}
	
	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Order [id=");
		builder.append(id);
		builder.append(", rowOrders=");
		builder.append(rowOrders);
		builder.append(", taxes=");
		builder.append(taxes);
		builder.append(", total=");
		builder.append(total);
		builder.append("]");
		return builder.toString();
	}
	
}
