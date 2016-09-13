package com.taxes.calculation;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import utilities.Utilities;

import com.taxes.calculation.business.IServicesFactory;
import com.taxes.calculation.business.ServicesFactory;
import com.taxes.calculation.data.IOrder;
import com.taxes.calculation.data.IProduct;
import com.taxes.calculation.data.IRowOrder;
import com.taxes.calculation.data.Order;
import com.taxes.calculation.data.Product;
import com.taxes.calculation.data.ProductCategory;
import com.taxes.calculation.data.RowOrder;

public class TaxesCalculatorUnitTests {
	
	@Test
	public void test1(){
		try {
			IOrder order = new Order();
			order.setId(1);
			int rowOrderCounter = 1;
			List<IRowOrder> rowOrderList = new ArrayList<IRowOrder>();
			{
				IRowOrder rowOrder = new RowOrder();
				IProduct product = new Product();
				product.setId("1A");
				product.setDescription("book");
				product.setCategory(ProductCategory.BOOK);
				product.setImported(false);
				product.setPrice(12.49);
				rowOrder.setProduct(product);
				rowOrder.setId(rowOrderCounter);
				rowOrderCounter++;
				rowOrder.setQuantity(1);
				rowOrderList.add(rowOrder);
			}
			{
				IRowOrder rowOrder = new RowOrder();
				IProduct product = new Product();
				product.setId("1B");
				product.setDescription("music CD");
				product.setCategory(ProductCategory.OTHERS);
				product.setImported(false);
				product.setPrice(14.99);
				rowOrder.setProduct(product);
				rowOrder.setId(rowOrderCounter);
				rowOrderCounter++;
				rowOrder.setQuantity(1);
				rowOrderList.add(rowOrder);
			}
			{
				IRowOrder rowOrder = new RowOrder();
				IProduct product = new Product();
				product.setId("1C");
				product.setDescription("chocolate bar");
				product.setCategory(ProductCategory.FOOD);
				product.setImported(false);
				product.setPrice(0.85);
				rowOrder.setProduct(product);
				rowOrder.setId(rowOrderCounter);
				rowOrderCounter++;
				rowOrder.setQuantity(1);
				rowOrderList.add(rowOrder);
			}
			order.setRowOrders(rowOrderList);
			//PER DISACCOPPIARE L'IMPLEMENTAZIONE DALL'INTERFACCIA E' MEGLIO ISTANZIARE VIA FILE XML SPRING (IOC)
			IServicesFactory serviceFactory = new ServicesFactory();
			serviceFactory.getTaxesCalculator().calculateTotalAmounts(order);
			//Log the output
			Utilities.log(order.printToConsole());
			assertEquals(order.getTaxes(),1.50, 0.001);
			assertEquals(order.getTotal(),29.83, 0.001);
		}
		catch(Exception e){
			Utilities.log(e);
		}
	}

	@Test
	public void test2(){
		try {
			IOrder order = new Order();
			order.setId(2);
			int rowOrderCounter = 1;
			List<IRowOrder> rowOrderList = new ArrayList<IRowOrder>();
			{
				IRowOrder rowOrder = new RowOrder();
				IProduct product = new Product();
				product.setId("2A");
				product.setDescription("box of chocolates");
				product.setCategory(ProductCategory.FOOD);
				product.setImported(true);
				product.setPrice(10.00);
				rowOrder.setProduct(product);
				rowOrder.setId(rowOrderCounter);
				rowOrderCounter++;
				rowOrder.setQuantity(1);
				rowOrderList.add(rowOrder);
			}
			{
				IRowOrder rowOrder = new RowOrder();
				IProduct product = new Product();
				product.setId("2B");
				product.setDescription("bottle of perfume");
				product.setCategory(ProductCategory.OTHERS);
				product.setImported(true);
				product.setPrice(47.50);
				rowOrder.setProduct(product);
				rowOrder.setId(rowOrderCounter);
				rowOrderCounter++;
				rowOrder.setQuantity(1);
				rowOrderList.add(rowOrder);
			}
			order.setRowOrders(rowOrderList);
			//PER DISACCOPPIARE L'IMPLEMENTAZIONE DALL'INTERFACCIA E' MEGLIO ISTANZIARE VIA FILE XML SPRING (IOC)
			IServicesFactory serviceFactory = new ServicesFactory();
			serviceFactory.getTaxesCalculator().calculateTotalAmounts(order);
			//Log the output
			Utilities.log(order.printToConsole());
			assertEquals(order.getTaxes(),7.65, 0.001);
			assertEquals(order.getTotal(),65.15, 0.001);
		}
		catch(Exception e){
			Utilities.log(e);
		}
	}
	
	@Test
	public void test3(){
		try {
			IOrder order = new Order();
			order.setId(3);
			int rowOrderCounter = 1;
			List<IRowOrder> rowOrderList = new ArrayList<IRowOrder>();
			{
				IRowOrder rowOrder = new RowOrder();
				IProduct product = new Product();
				product.setId("3A");
				product.setDescription("bottle of perfume");
				product.setCategory(ProductCategory.OTHERS);
				product.setImported(true);
				product.setPrice(27.99);
				rowOrder.setProduct(product);
				rowOrder.setId(rowOrderCounter);
				rowOrderCounter++;
				rowOrder.setQuantity(1);
				rowOrderList.add(rowOrder);
			}
			{
				IRowOrder rowOrder = new RowOrder();
				IProduct product = new Product();
				product.setId("3B");
				product.setDescription("bottle of perfume");
				product.setCategory(ProductCategory.OTHERS);
				product.setImported(false);
				product.setPrice(18.99);
				rowOrder.setProduct(product);
				rowOrder.setId(rowOrderCounter);
				rowOrderCounter++;
				rowOrder.setQuantity(1);
				rowOrderList.add(rowOrder);
			}
			{
				IRowOrder rowOrder = new RowOrder();
				IProduct product = new Product();
				product.setId("3C");
				product.setDescription("packet of headache pills");
				product.setCategory(ProductCategory.DRUG);
				product.setImported(false);
				product.setPrice(9.75);
				rowOrder.setProduct(product);
				rowOrder.setId(rowOrderCounter);
				rowOrderCounter++;
				rowOrder.setQuantity(1);
				rowOrderList.add(rowOrder);
			}
			{
				IRowOrder rowOrder = new RowOrder();
				IProduct product = new Product();
				product.setId("3D");
				product.setDescription("box of chocolates");
				product.setCategory(ProductCategory.FOOD);
				product.setImported(true);
				product.setPrice(11.25);
				rowOrder.setProduct(product);
				rowOrder.setId(rowOrderCounter);
				rowOrderCounter++;
				rowOrder.setQuantity(1);
				rowOrderList.add(rowOrder);
			}
			order.setRowOrders(rowOrderList);
			//PER DISACCOPPIARE L'IMPLEMENTAZIONE DALL'INTERFACCIA E' MEGLIO ISTANZIARE VIA FILE XML SPRING (IOC)
			IServicesFactory serviceFactory = new ServicesFactory();
			serviceFactory.getTaxesCalculator().calculateTotalAmounts(order);
			//Log the output
			Utilities.log(order.printToConsole());
			assertEquals(order.getTaxes(), 6.70, 0.001);
			assertEquals(order.getTotal(), 74.68, 0.001);
		}
		catch(Exception e){
			Utilities.log(e);
		}
	}	
	
}
