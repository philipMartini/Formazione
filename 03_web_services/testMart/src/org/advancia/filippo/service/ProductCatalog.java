package org.advancia.filippo.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.advancia.filippo.buisness.ProductService;
import org.advancia.filippo.model.Product;

@WebService(endpointInterface="org.advancia.filippo.service.ProductCatalogInterface",
portName="TestMartCataloguePort", 
serviceName="TestMartCatalogueService")
public class ProductCatalog implements ProductCatalogInterface {
	
	private ProductService productService;
	//Il costruttore viene chiamato SOLO all'inizializzazione
	public ProductCatalog() {
		this.productService = new ProductService();
	}
	
	/* (non-Javadoc)
	 * @see org.advancia.filippo.service.ProductCatalogInterface#getProductCategories()
	 */
	@Override
	public List<String> getProductCategories(){
		return productService.getProductCategories();
	}
	
	/* (non-Javadoc)
	 * @see org.advancia.filippo.service.ProductCatalogInterface#getProducts(java.lang.String)
	 */
	@Override
	public List<String> getProducts(String category){
		return this.productService.getProducts(category);
	}
	
	/* (non-Javadoc)
	 * @see org.advancia.filippo.service.ProductCatalogInterface#addProduct(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean addProduct(String category, String product){
		return this.productService.addProduct(category, product);
	}
	
	/* (non-Javadoc)
	 * @see org.advancia.filippo.service.ProductCatalogInterface#getProductsv2(java.lang.String)
	 */
	@Override
	public List<Product> getProductsv2(String category){
		return this.productService.getProductsv2(category);
	}
}
