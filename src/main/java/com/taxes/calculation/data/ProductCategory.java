package com.taxes.calculation.data;

import utilities.Utilities;

public enum ProductCategory {
	
	BOOK("BOOK"),
	FOOD("FOOD"),
	DRUG("DRUG"),
	OTHERS("OTHERS");
	
	private String stringValue = new String("");
	
	private ProductCategory(String stringValue){
	    this.stringValue = stringValue;
	}
	
	/**
	 * 
	 * Function that, given a string, convert it into a ProductCategory
	 * 
	 * @param productCategory
	 * @return
	 * @throws Exception
	 */
	public static ProductCategory getProductCategory(String productCategory) throws Exception {
		ProductCategory retVal = null;
		try{
			if(productCategory!=null && (!productCategory.trim().equals(""))){
				for (ProductCategory category : values()) {
					String currentString = category.getStringValue().toUpperCase().trim();
					if(productCategory.toUpperCase().trim().equals(currentString)){
						retVal = category;
						break;
					}
				}
			}
		}
		catch(Exception e){
			Utilities.log(e);
			throw e;
		}
		return retVal;
	}

	public String getStringValue() {
		return stringValue;
	}
	
	@Override
	public String toString(){
		final StringBuilder builder = new StringBuilder();
		builder.append("ProductCategory [stringValue=");
		builder.append(stringValue);
		builder.append("]");
		return builder.toString();
	}

}
