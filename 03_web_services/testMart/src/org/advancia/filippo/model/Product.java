package org.advancia.filippo.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//Questo sarà il nome del nodo root element quando ci sono oggetti Product in xml
@XmlRootElement(name="Product")
@XmlType(propOrder={"price", "sku", "name"})
public class Product {
	
	private String name;
	private String sku;
	private double price;
	
	
	public Product() {
		// TODO Auto-generated constructor stub
	}


	public Product(String name, String sku, double price) {
		super();
		this.name = name;
		this.sku = sku;
		this.price = price;
	}

	//Custom name for xml element
	@XmlElement(name="productName")
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSku() {
		return sku;
	}


	public void setSku(String sku) {
		this.sku = sku;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
