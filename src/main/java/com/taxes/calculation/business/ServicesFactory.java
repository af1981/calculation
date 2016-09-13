package com.taxes.calculation.business;

public class ServicesFactory implements IServicesFactory {
	
	private ITaxesCalculator taxesCalculator=null;
	
	public ServicesFactory(){
		//PER DISACCOPPIARE L'IMPLEMENTAZIONE DALL'INTERFACCIA E' MEGLIO ISTANZIARE VIA FILE XML SPRING (IOC)
		taxesCalculator = new TaxesCalculator();
	}

	/* (non-Javadoc)
	 * @see com.taxes.calculation.business.IServicesFactory#getTaxesCalculator()
	 */
	public ITaxesCalculator getTaxesCalculator() {
		return taxesCalculator;
	}

	/* (non-Javadoc)
	 * @see com.taxes.calculation.business.IServicesFactory#setTaxesCalculator(com.taxes.calculation.business.ITaxesCalculator)
	 */
	public void setTaxesCalculator(ITaxesCalculator taxesCalculator) {
		this.taxesCalculator = taxesCalculator;
	}
	
	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("ServicesFactory [taxesCalculator=");
		builder.append(taxesCalculator);
		builder.append("]");
		return builder.toString();
	}	

}
