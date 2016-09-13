package com.taxes.calculation.business;

public interface IServicesFactory {

	public abstract ITaxesCalculator getTaxesCalculator();

	public abstract void setTaxesCalculator(ITaxesCalculator taxesCalculator);

}