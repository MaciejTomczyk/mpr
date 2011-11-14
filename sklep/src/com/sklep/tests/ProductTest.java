package com.sklep.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sklep.project.Client;
import com.sklep.project.PriceException;
import com.sklep.project.Product;
import com.sklep.project.ProductMarks;

public class ProductTest {

	
	private Client c=new Client("Maciej Tomczyk");
	private Product p=new Product(ProductMarks.Gorzka,15);
	
	
	
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
		assertTrue(p.getPrice()==55);
	}


	@Test
	public void testGetName() {
		p.setName(ProductMarks.Malibu);
		assertTrue(p.getName().equals(ProductMarks.Malibu));
	}

	@Test
	public void testGetPrice() throws PriceException {
		p.setPrice(55);
		assertTrue(p.getPrice()==55);
	}

	@Test
	public void testSetName() {
		
		p.setName(ProductMarks.Glenfiddich);
		assertTrue(p.getName().equals(ProductMarks.Glenfiddich));
	}

	@Test
	public void testGetCode() {
		p.getCode();
	}

	@Test
	public void testSetCode() {
		p.setCode(11112222);
		assertTrue(p.getCode()==11112222);
	}

	
	@Test
	public void testToString() {
		System.out.println(p);
	}

	

}
