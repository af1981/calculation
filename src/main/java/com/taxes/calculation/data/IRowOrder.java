package com.taxes.calculation.data;

public interface IRowOrder {

	public abstract long getId();

	public abstract void setId(long id);

	public abstract long getQuantity();

	public abstract void setQuantity(long quantity);

	public abstract IProduct getProduct();

	public abstract void setProduct(IProduct product);

}