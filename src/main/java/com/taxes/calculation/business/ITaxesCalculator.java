package com.taxes.calculation.business;

import com.taxes.calculation.data.IOrder;

public interface ITaxesCalculator {

	/**
	 * 
	 * Function that calculate taxes and total of a given order
	 * 
	 * @param order
	 * @throws Exception
	 */
	public abstract void calculateTotalAmounts(IOrder order) throws Exception;

}