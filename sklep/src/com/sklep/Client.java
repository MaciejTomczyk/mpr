package com.sklep;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import java.util.List;

public class Client {

	private PropertyConfigurator logConfig = new PropertyConfigurator();
	private Logger logger = Logger.getLogger(Client.class);

	public String name;
	public List<Product> products=new ArrayList<Product>();
	

	
	public void clearlist() {
		products.clear();
		logger.info("The list has been cleared.");

	}

	public void printProducts() {
		for (Product p : products) {
			p.printProduct();
		}

	}

	public void addProduct(Product p) throws PriceException{
		checkPrice(p);
		products.add(p);
	}

	public void deleteProduct(Product product) {
		products.remove(product);
		logger.info("Deleting: " + product.getName());
	}

	

	
	public void checkPrice(Product product) throws PriceException{
		if(product.getPrice()<=0){
			product.setPrice(1);
			logger.info("New price for: "+product.getName()+" needs to be set.");
			
		}
	}
	
	
	
	public void changeProductPrice(Product product, int price) throws PriceException {
		if (price > 0) {
			product.setPrice(price);
			logger.info("Editting: " + product.getName() + " new price:  " + 
					+ price + " zl");
		}
		if (price <= 0)
			throw new PriceException("Price cannot be 0 or less");
	}

	public void changeProductCode(Product product, double code) throws PriceException {
		if (code > 0) {
			product.setCode(code);
			logger.info("Editting: " + product.getName() + " new price:  " + 
					+ code);
		}
		if (code <= 0)
			throw new PriceException("Code cannot be negative");
	}	
	
	
	
	
	public Product findProduct(ProductMarks mark) {
		for (Product p : products)
		{
		if (p.getName().equals(mark)) {
		return p;
		}
		}
		return null;
		}


	public Client(String name) {
		super();
		this.products = new ArrayList<Product>();
		this.name = name;
	}

	

	public List<Product> FindAllProducts(ProductMarks mark){
		List<Product> results=new ArrayList<Product>();
		for(Product p: products){
			if(p.getName().equals(mark)){
				results.add(p);
			}
		}
		return results;
	}
 	
}
