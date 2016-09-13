package com.taxes.calculation.dataaccess;

import java.util.List;

import com.taxes.calculation.data.ProductCategory;

public interface IDataAccess {

	/**
	 * 
	 * Function to get import tax Percentage
	 * 
	 * @return
	 * @throws Exception
	 */
	public abstract double getImportTaxPercentage() throws Exception;

	/**
	 * 
	 * Function to get default tax Percentage
	 * 
	 * @return
	 * @throws Exception
	 */
	public abstract double getDefaultTaxesPercentage() throws Exception;

	/**
	 * 
	 * Function to get the product categories that have got the default tax exclusion
	 * 
	 * @return
	 * @throws Exception
	 */
	public abstract List<ProductCategory> getDefaultTaxExclusions() throws Exception;

}