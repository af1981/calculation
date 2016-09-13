package utilities;

import java.text.DecimalFormat;

public class Utilities {
	
	/**
	 * Funzione per la stampa nei log di una stringa
	 * 
	 * @param string
	 * @return
	 */
	public static String getStringToPrint(String string){
		String retVal = "null";
		if(string!=null){
			retVal = string;
		}
		return retVal;
	}
	
	/**
	 * 
	 * Funzione per formattare i numerici con una determinata precisione numerica dopo la virgola
	 * 
	 * @param num
	 * @return
	 */
	public static double decimalRound(double num, int precision){
		double val = Math.pow(10, precision);
		double retVal = Math.round((num*val)) / val;
		return retVal;
	}
	
	/**
	 * 
	 * Funzione per stampare le currency sempre con due cifre decimali
	 * 
	 * @param num
	 * @return
	 */
	public static String currencyFormatter(double num){
		DecimalFormat myFormatter = new DecimalFormat("###,##0.00");
		return myFormatter.format(num);
	}

	/**
	 * 
	 * Funzione centralizzata per il log, ad esempio, per cambiarlo agevolmente su Log4J magari passando come parametro il livello di logging
	 * 
	 * @param message
	 */
	public static void log(String message){
		System.out.println(message);
	}

	/**
	 * 
	 * Funzione centralizzata per il log, ad esempio, per cambiarlo agevolmente su Log4J magari passando come parametro il livello di logging
	 * 
	 * @param e
	 */
	public static void log(Exception e){
		e.printStackTrace();
	}

}
