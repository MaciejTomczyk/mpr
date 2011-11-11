package com.sklep;


import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;

import com.sklep.events.IProductProcesses;
import com.sklep.events.Desk;
import com.sklep.events.Desk.CleanProduct;
import com.sklep.events.Desk.ChangeBoxProduct;

public class Main {

	private static Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) throws PriceException {

		PropertyConfigurator.configure("Log4J.properties");

		


		Client c = new Client("Maciej Tomczyk");

		c.addProduct(new Product(ProductMarks.Glenfiddich, 199));
		c.addProduct(new Product(ProductMarks.Johniee_Walker_Blue, 399));
		c.addProduct(new Product(ProductMarks.Malibu, 55));
		c.printProducts();
		System.out.println(".....................");
		try {
			c.addProduct(new Product(ProductMarks.Glenfiddich, -5));
		} catch (PriceException e) {
			logger.error(e.getMessage());
		}
		c.printProducts();
		System.out.println(".....................");
		c.addProduct(new Product(ProductMarks.Johniee_Walker_Red, 0));
		c.checkPrice(c.findProduct(ProductMarks.Johniee_Walker_Red));
		c.deleteProduct(c.findProduct(ProductMarks.Glenfiddich));
		c.printProducts();
		System.out.println(".....................");
		
		Product p= new Product(ProductMarks.Gorzka,15);
		try {
			p.setPrice(-2);
			} catch (PriceException e) {

			logger.error(e);
			logger.fatal(e);
			logger.info(e);
			logger.warn(e);
			}
		System.out.println(p.getName()+" cena: "+p.getPrice());
		
		
	
		System.out.println(".....................");
		Desk desk =new Desk();
		IProductProcesses clean=new CleanProduct();
		IProductProcesses change=new ChangeBoxProduct();
		Product z =new Product(ProductMarks.Sheridans,4);    
		desk.addProcess(clean);
		desk.addProcess(change);
		desk.setProduct(z);
		desk.executeProcesses();
		
		
	}

}
