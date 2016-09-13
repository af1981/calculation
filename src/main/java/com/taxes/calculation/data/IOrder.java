package com.taxes.calculation.data;

import java.util.List;

public interface IOrder {

	public abstract long getId();

	public abstract void setId(long id);

	public abstract List<IRowOrder> getRowOrders();

	public abstract void setRowOrders(List<IRowOrder> rowOrders);

	public abstract double getTaxes();

	public abstract void setTaxes(double taxes);

	public abstract double getTotal();

	public abstract void setTotal(double total);
	
	public abstract String printToConsole();

}