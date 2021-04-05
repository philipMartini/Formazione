package org.advancia.filippo.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
//Usare RPC style solo per WS con input output MOLTO SEMPLICI
@SOAPBinding(style=Style.RPC)
public class ShopInfo {

	public ShopInfo() {
		// TODO Auto-generated constructor stub
	}
	
	@WebMethod
	@WebResult(partName="lookupOutput")
	public String getShopInfo(@WebParam(partName="lookupInput") String property) throws InvaldPropertyException{
		String response = null;
		
		
		if("shopName".equals(property)){
			response = "Test Mart";
		}
		else if("since".equals(property))
			response = "Since 2012";
		else
			throw new InvaldPropertyException("Invalid Property!", 
					"An invalid Property " + property + " was passed in input to the getInfoShopMethod");
		return response;
	}
	

}
