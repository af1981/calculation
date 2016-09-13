package com.taxes.calculation.data;

public class RowOrder implements IRowOrder {
	
	private long id;
	private long quantity;
	private IProduct product;
	
	public RowOrder(){
	}
	
	/* (non-Javadoc)
	 * @see com.taxes.calculation.data.IRowOrder#getId()
	 */
	public long getId() {
		return id;
	}
	
	/* (non-Javadoc)
	 * @see com.taxes.calculation.data.IRowOrder#setId(long)
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/* (non-Javadoc)
	 * @see com.taxes.calculation.data.IRowOrder#getQuantity()
	 */
	public long getQuantity() {
		return quantity;
	}
	
	/* (non-Javadoc)
	 * @see com.taxes.calculation.data.IRowOrder#setQuantity(long)
	 */
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
	/* (non-Javadoc)
	 * @see com.taxes.calculation.data.IRowOrder#getProduct()
	 */
	public IProduct getProduct() {
		return product;
	}
	
	/* (non-Javadoc)
	 * @see com.taxes.calculation.data.IRowOrder#setProduct(com.taxes.calculation.data.IProduct)
	 */
	public void setProduct(IProduct product) {
		this.product = product;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("RowOrder [id=");
		builder.append(id);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", product=");
		builder.append(product);
		builder.append("]");
		return builder.toString();
	}
}
