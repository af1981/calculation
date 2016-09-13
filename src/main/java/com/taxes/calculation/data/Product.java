package com.taxes.calculation.data;

import utilities.Utilities;

public class Product implements IProduct{
	
	private String id;
	private String description;
	private ProductCategory category;
	private boolean imported=false;
	private double price;
	private double taxes;
	private double totalPrice;
	
	public Product(){
	}
	
	/* (non-Javadoc)
	 * @see com.taxes.calculation.data.IProduct#getId()
	 */
	public String getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see com.taxes.calculation.data.IProduct#setId(java.lang.String)
	 */
	public void setId(String id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see com.taxes.calculation.data.IProduct#getTaxes()
	 */
	public double getTaxes() {
		return taxes;
	}

	/* (non-Javadoc)
	 * @see com.taxes.calculation.data.IProduct#setTaxes(double)
	 */
	public void setTaxes(double taxes) {
		this.taxes = taxes;
	}

	/* (non-Javadoc)
	 * @see com.taxes.calculation.data.IProduct#getTotalPrice()
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/* (non-Javadoc)
	 * @see com.taxes.calculation.data.IProduct#setTotalPrice(double)
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	/* (non-Javadoc)
	 * @see com.taxes.calculation.data.IProduct#getDescription()
	 */
	public String getDescription() {
		return description;
	}
	
	/* (non-Javadoc)
	 * @see com.taxes.calculation.data.IProduct#setDescription(java.lang.String)
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/* (non-Javadoc)
	 * @see com.taxes.calculation.data.IProduct#getPrice()
	 */
	public double getPrice() {
		return price;
	}
	
	/* (non-Javadoc)
	 * @see com.taxes.calculation.data.IProduct#setPrice(double)
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/* (non-Javadoc)
	 * @see com.taxes.calculation.data.IProduct#getImported()
	 */
	public boolean getImported() {
		return imported;
	}
	
	/* (non-Javadoc)
	 * @see com.taxes.calculation.data.IProduct#setImported(boolean)
	 */
	public void setImported(boolean imported) {
		this.imported = imported;
	}

	/* (non-Javadoc)
	 * @see com.taxes.calculation.data.IProduct#getCategory()
	 */
	public ProductCategory getCategory() {
		return category;
	}

	/* (non-Javadoc)
	 * @see com.taxes.calculation.data.IProduct#setCategory(com.taxes.calculation.data.ProductCategory)
	 */
	public void setCategory(ProductCategory category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Product [id=");
		builder.append(Utilities.getStringToPrint(id));
		builder.append(", description=");
		builder.append(Utilities.getStringToPrint(description));
		builder.append(", category=");
		builder.append(category);
		builder.append(", imported=");
		builder.append(imported);
		builder.append(", price=");
		builder.append(price);
		builder.append(", taxes=");
		builder.append(taxes);
		builder.append(", totalPrice=");
		builder.append(totalPrice);
		builder.append("]");
		return builder.toString();
	}
	

}
