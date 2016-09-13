package com.taxes.calculation.dataaccess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.taxes.calculation.data.ProductCategory;

import utilities.Utilities;


public class DataAccess implements IDataAccess {

	private static final String KEY_IMPORT_TAX_PERCENTAGE ="TAXES.IMPORT.PERCENTAGE";
	private static final String KEY_DEFAULT_TAX_PERCENTAGE ="TAXES.DEFAULT.PERCENTAGE";
	
	private static final String KEY_DEFAULT_TAX_PRODUCT_EXCLUSIONS ="TAXES.DEFAULT.PRODUCT_EXCLUSIONS";
	private static final String KEY_DEFAULT_TAX_PRODUCT_EXCLUSIONS_SEPARATOR =";";

	public DataAccess(){
	}
	
	/* (non-Javadoc)
	 * @see com.taxes.calculation.dataaccess.IDataAccess#getImportTaxPercentage()
	 */
	public double getImportTaxPercentage() throws Exception{
		double retVal = 0;
		try{
			//PER SEMPLICITA', INVECE DI UN DB SI USA UN FILE DI PROPERTIES
			String strValue = PropertiesConfiguration.getPropertiesConfiguration().getProps().getProperty(KEY_IMPORT_TAX_PERCENTAGE);
			retVal=Double.parseDouble(strValue);
		}
		catch(Exception e){
			Utilities.log(e);
			throw e;
		}
		return retVal;
	}

	/* (non-Javadoc)
	 * @see com.taxes.calculation.dataaccess.IDataAccess#getDefaultTaxesPercentage()
	 */
	public double getDefaultTaxesPercentage() throws Exception{
		double retVal = 0;
		try{
			//PER SEMPLICITA', INVECE DI UN DB SI USA UN FILE DI PROPERTIES
			String strValue = PropertiesConfiguration.getPropertiesConfiguration().getProps().getProperty(KEY_DEFAULT_TAX_PERCENTAGE);
			retVal=Double.parseDouble(strValue);
		}
		catch(Exception e){
			Utilities.log(e);
			throw e;
		}
		return retVal;
	}	
	
	/* (non-Javadoc)
	 * @see com.taxes.calculation.dataaccess.IDataAccess#getDefaultTaxExclusions()
	 */
	public List<ProductCategory> getDefaultTaxExclusions() throws Exception{
		List<ProductCategory> retVal = new ArrayList<ProductCategory>();
		try{
			//PER SEMPLICITA', INVECE DI UN DB SI USA UN FILE DI PROPERTIES
			String strValue = PropertiesConfiguration.getPropertiesConfiguration().getProps().getProperty(KEY_DEFAULT_TAX_PRODUCT_EXCLUSIONS);
			String[] array=strValue.split(KEY_DEFAULT_TAX_PRODUCT_EXCLUSIONS_SEPARATOR);
			List<String> productCategoryList = Arrays.asList(array);
			for(String productCategoryItem: productCategoryList){
				ProductCategory productCategory=ProductCategory.getProductCategory(productCategoryItem);
				if(productCategory!=null){
					retVal.add(productCategory);
				}
				else{
					throw new Exception("Any category mapping for "+productCategoryItem);
				}
			}
		}
		catch(Exception e){
			Utilities.log(e);
			throw e;
		}
		return retVal;
	}
	
}
