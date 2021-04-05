package org.advancia.filippo.buisness;

import java.util.ArrayList;
import java.util.List;

import org.advancia.filippo.model.Product;

public class ProductService {
	
	
	private List<String> bookList = new ArrayList<>();
	private List<String> musicList = new ArrayList<>();
	private List<String> movieList = new ArrayList<>();

	public ProductService() {
		this.bookList.add("Inferno");
		this.bookList.add("JoyLand");
		this.bookList.add("The Game");
		
		this.musicList.add("RAM");
		this.musicList.add("Studio sessions");
		this.musicList.add("Miles ahed");
		
		this.movieList.add("Matrix");
		this.movieList.add("Terminator");
		this.movieList.add("GreenBook");
	}
	
	public List<String> getProductCategories(){
		List<String> categories = new ArrayList<>();
		categories.add("Books");
		categories.add("Music");
		categories.add("Movies");
		return categories;
	}
	
	public List<String> getProducts(String category){
		switch(category.toLowerCase()){
			case "books":
				return this.bookList;
			case "music":
				return this.musicList;
			case "movies":
				return this.movieList;
		}
		return null;
	}
	
	public boolean addProduct(String category, String product){
		switch(category.toLowerCase()){
			case "books":
				return this.bookList.add(product);
				
			case "music":
				return this.musicList.add(product);
				
			case "movies":
				return this.movieList.add(product);
				
			default:
				return false;
		}
		
		}

	public List<Product> getProductsv2(String category) {
		// TODO Auto-generated method stub
		List<Product> productList = new ArrayList<>();
		productList.add(new Product("Java Tutorial","1234", 99.99));
		productList.add(new Product("C++ Tutorial","1234", 89.00));
		return productList;
		
	}
	
}
