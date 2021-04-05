package org.advancia.filippo.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.advancia.filippo.model.Product;

//Meglio mettere le annotazioni nell'interfaccia piuttosto che nlla classe che la implementa

@WebService(name="TestMartCatalogue", targetNamespace="http://www.testmart.com")
public interface ProductCatalogInterface {
	
	@WebMethod(action="fetch_categories", operationName="fetchCategories")
	List<String> getProductCategories();
	
	@WebMethod
	List<String> getProducts(String category);

	@WebMethod
	boolean addProduct(String category, String product);
	
	@WebMethod
	@WebResult(name="Product", partName="Product")
	List<Product> getProductsv2(String category);

}