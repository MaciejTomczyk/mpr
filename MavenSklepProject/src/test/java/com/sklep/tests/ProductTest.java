package com.sklep.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sklep.project.Client;
import com.sklep.project.CodeException;
import com.sklep.project.PriceException;
import com.sklep.project.Product;
import com.sklep.project.ProductMarks;

public class ProductTest {

	
	private Client c=new Client("Maciej Tomczyk");
	private Product p=new Product(ProductMarks.Gorzka,15);
	private Product o=new Product(ProductMarks.Gorzka,16);
	
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUsp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}



	@Test
	public void testSetPrice() throws PriceException {
		p.setPrice(55);
		o.setPrice(55);
		assertTrue(p.getPrice()==o.getPrice());
	}


	@Test
	public void testGetName() {
		p.setName(ProductMarks.Malibu);
		o.setName(ProductMarks.Malibu);
		assertSame(p.getName(),o.getName());
	}

	@Test
	public void testGetPrice() throws PriceException {
		p.setPrice(55);
		o.setPrice(55);
		assertTrue(p.getPrice()==o.getPrice());
	}

	@Test
	public void testSetName() {
		
		p.setName(ProductMarks.Glenfiddich);
		assertSame(p.getName(),(ProductMarks.Glenfiddich));
	}

	@Test
	public void testGetCode() throws CodeException {
		p.setCode(11114444);
		assertTrue(p.getCode()==11114444);
	}

	@Test
	public void testSetCode() throws CodeException {
		p.setCode(111122225);
		assertTrue(p.getCode()==111122225);
	}

	

	

}
