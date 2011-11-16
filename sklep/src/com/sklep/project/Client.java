package com.sklep.project;

import java.util.ArrayList;

import org.apache.log4j.Category;
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

	

	public List<Product> FindAllProductsByName(ProductMarks mark){
		List<Product> results=new ArrayList<Product>();
		for(Product p: products){
			if(p.getName().equals(mark)){
				System.out.println("Name "+p.getName());
				results.add(p);
			}
		}
		
		return results;
	}
 	
	public List<Product> FindAllProductsByPrice(int price){
		List<Product> results=new ArrayList<Product>();
		for(Product p: products){
			if(p.getPrice()==price){
				System.out.println("Name " +p.getName()+" price: "+p.getPrice());
				results.add(p);
			}
		}
		
		return results;
	}
	
	public ArrayList<Product> FindAllProductsByCode(double code){
		ArrayList<Product> results=new ArrayList<Product>();
		for(Product p: products){
			if(p.getCode()==code){
				System.out.println("Name " +p.getName()+" code: "+p.getCode());
				results.add(p);
				
			}
		}
		
		return results;
	}
	

	
	
	
	
	public List<Product> DeleteManyProductsByCode(double code) throws PriceException {
		List<Product> results = new ArrayList<Product>();
		for (Product p : products) {
		if (p.getCode()==code) {
		results.add(p);
		}
		
		}
		products.removeAll(results);
		return results;
		}
		
	}
	
	
	
	
	

