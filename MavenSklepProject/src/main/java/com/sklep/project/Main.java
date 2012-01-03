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
import com.sklep.services.ClientProductDBManager;
import com.sklep.services.ProductDBManager;

public class Main {

	private static Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) throws PriceException, SQLException, com.sklep.services.SQLException {

		PropertyConfigurator.configure("Log4J.properties");

		


		Client c = new Client("Maciej Tomczyk");

		c.addProduct(new Product(ProductMarks.Glenfiddich,(double) 199));
		c.addProduct(new Product(ProductMarks.Johniee_Walker_Blue,(double) 399));
		c.addProduct(new Product(ProductMarks.Malibu,(double) 55));
		c.printProducts();
		System.out.println(".....................");
		try {
			c.addProduct(new Product(ProductMarks.Glenfiddich,(double) -5));
			
		} catch (PriceException e) {
			logger.error(e.getMessage());
		}
		c.printProducts();
		System.out.println(".....................");
		c.addProduct(new Product(ProductMarks.Johniee_Walker_Red,(double) 0));
		c.checkPrice(c.findProduct(ProductMarks.Johniee_Walker_Red));
		c.deleteProduct(c.findProduct(ProductMarks.Glenfiddich));
		c.printProducts();
		System.out.println(".....................");
		
		Product p= new Product(ProductMarks.Gorzka,(double)15);
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
		d.addProduct(new Product(ProductMarks.Johniee_Walker_Red,(float)5556643));
		d.addProduct(new Product(ProductMarks.Johniee_Walker_Blue,(float)5556643));
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
		Product z =new Product(ProductMarks.Sheridans,(double)4);
		Product x =new Product(ProductMarks.Johniee_Walker_Red,(float)5556643);
		try {
			z.setCode(11112222);
		} catch (CodeException e) {
		
			e.printStackTrace();
		}
		z.setBox();
		desk.addProcess(clean);
		desk.addProcess(change);
		desk.addProcess(promote);
		desk.addProcess(rollback);
		desk.setProduct(z);
		desk.executeProcesses();
		ClientDBManager cdb= new ClientDBManager();
		cdb.addClient(c);
		cdb.addClient(d);
		for(Client client: cdb.getAllClients())
		{
			System.out.println(client.getName());
		}
		//cdb.clear();
		System.out.println(".....................");

		ProductDBManager pdb= new ProductDBManager();
		pdb.addProduct(z);
		pdb.addProduct(x);
		x.setPrice((double)45);
		//pdb.droptableproduct();
		
		ClientProductDBManager dbClientProduct = new ClientProductDBManager();
		
		dbClientProduct.addProductToClient(cdb.findClientByName(c.getName()), pdb.findProductByName(ProductMarks.Sheridans));
		dbClientProduct.addProductToClient(cdb.findClientByName(d.getName()), pdb.findProductByCode(5556643));
		
		for (Product product : dbClientProduct.getClientProduct(cdb.findClientByName("Maciej Tomczyk")))
		{
		System.out.println("Name: " + product.getName() + "\tCode: " + product.getCode() + "\tPrice: " + product.getPrice());
		System.out.println("cos");
		}
		
		
	}

}
