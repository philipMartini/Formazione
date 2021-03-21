package org.advancia.filippo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CurrencyConverter {
	
	//La hashMap conterrà i tassi di conversione da euro a tutte le altre valute
	//Quando un'altra valuta verrà utilizzata come input basterà convertire in euro
	//e poi effettuare la conversione
	private static Map<String, Double> currenciesRates;
	private static CurrencyConverter instance;
	private static int instancesNumber = 0;
	
	//Questa classe è un sigleton e in ogni caso essendo operazioni di Read non
	//Ci sono problemi di thread safety
	private CurrencyConverter(){
		this.currenciesRates = new HashMap<>();
		++this.instancesNumber;
		this.currenciesRates.put("USD", 1.1907);
		this.currenciesRates.put("GBP", 0.85668);
		this.currenciesRates.put("JPY", 130.02);
		this.currenciesRates.put("CHF", 1.1047);
		this.currenciesRates.put("CAD", 1.4852);
		this.currenciesRates.put("EUR", 1.00);
		
	}
	
	public static CurrencyConverter getInstance(){
		if(instance == null){instance = new CurrencyConverter(); }
		return instance;
	}
	
	public double convertCurrency(String fromCurrency, String toCurrency, double amount) 
			throws CurrencyConversionException{
		if(fromCurrency.equals(toCurrency))
			throw new CurrencyConversionException("Currencies cannot be the Same!");
		if(this.currenciesRates.get(fromCurrency) == null)
			throw new CurrencyConversionException("Cannot Convert FROM " + fromCurrency);
		if(this.currenciesRates.get(toCurrency) == null)
			throw new CurrencyConversionException("Cannot Convert TO " + fromCurrency);
		
		double amountInEuro = amount;
		if(!"EUR".equals(fromCurrency)){
			amountInEuro = amount / this.currenciesRates.get(fromCurrency);
		}
		if("EUR".equals(toCurrency))
			return amountInEuro;
		else
			return this.currenciesRates.get(toCurrency) * amountInEuro;
		
	}

	public int getNumInstances() {
		return CurrencyConverter.instancesNumber;
	}
	
	public Set<String> getCurrencies() { return CurrencyConverter.currenciesRates.keySet(); }
	

}
