package com.taxes.calculation.data;

public interface IProduct {

	public abstract String getId();

	public abstract void setId(String id);

	public abstract double getTaxes();

	public abstract void setTaxes(double taxes);

	public abstract double getTotalPrice();

	public abstract void setTotalPrice(double totalPrice);

	public abstract String getDescription();

	public abstract void setDescription(String description);

	public abstract double getPrice();

	public abstract void setPrice(double price);

	public abstract boolean getImported();

	public abstract void setImported(boolean imported);

	public abstract ProductCategory getCategory();

	public abstract void setCategory(ProductCategory category);

}