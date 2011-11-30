package com.sklep.project;


import java.sql.SQLException;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;

import com.sklep.events.IProductProcesses;
import com.sklep.events.Desk;
import com.sklep.events.Desk.CleanProduct;
import com.sklep.events.Desk.ChangeBoxProduct;
import com.sklep.events.Desk.PromoteProduct;
import com.sklep.events.Desk.RollbackProduct;
import com.sklep.services.ClientDBManager;

public class Main {

	private static Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) throws PriceException, SQLException, com.sklep.services.SQLException {

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
		
		
		Client d = new Client("Tadeusz Tomczyk");
		d.addProduct(new Product(ProductMarks.Johniee_Walker_Red,(double)5556643));
		d.addProduct(new Product(ProductMarks.Johniee_Walker_Blue,(double)5556643));
		d.FindAllProductsByCode(5556643);
		d.DeleteManyProductsByCode(5556643);
		System.out.println(".....................");
		d.FindAllProductsByCode(5556643);
		System.out.println(".....................");
		
	
		System.out.println(".....................");
		Desk desk =new Desk();
		IProductProcesses clean=new CleanProduct();
		IProductProcesses change=new ChangeBoxProduct();
		IProductProcesses promote=new PromoteProduct();
		IProductProcesses rollback=new RollbackProduct();
		Product z =new Product(ProductMarks.Sheridans,4);
		z.setBox();
		desk.addProcess(clean);
		desk.addProcess(change);
		desk.addProcess(promote);
		desk.addProcess(rollback);
		desk.setProduct(z);
		desk.executeProcesses();
		
		ClientDBManager db= new ClientDBManager();
		db.addClient(c);
		
		
		
		
	}

}
