package com.sklep.tests;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sklep.Client;
import com.sklep.PriceException;
import com.sklep.Product;
import com.sklep.ProductMarks;

public class ClientTest {
	
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
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testClearlist() {
		c.clearlist();
		assertTrue(c.products.size()<=0);
	}

	@Test
	public void testAddProduct() throws PriceException {
		c.addProduct(p);
		assertTrue(c.products.size()>0);
		
	}

	@Test
	public void testDeleteProduct() {
		c.deleteProduct(p);
		assertTrue(c.products.size()<=0);
	}

	@Test
	public void testCheckPrice() throws PriceException {
		c.checkPrice(p);
		assertTrue(p.getPrice()>0);
	}

	@Test
	public void testChangeProductPrice() throws PriceException {
		c.changeProductPrice(p, 5);
		assertTrue(p.getPrice()==5);
	}

	@Test
	public void testChangeProductCode() throws PriceException {
		c.changeProductCode(p, 11114444);
		assertTrue(p.getCode()==11114444);
		
	}

	@Test
	public void testFindProduct() {
		c.findProduct(ProductMarks.Glenfiddich);
	}

	@Test
	public void testClient() throws PriceException {
		Client n=new Client("Lol");
		n.addProduct(p);
		assertTrue(n.products.size()>0);
	}

	@Test
	public void testFindAllProducts() {
		c.FindAllProducts(ProductMarks.Gorzka);
		
	}



	@Test(expected=PriceException.class, timeout=100)
	public void testPriceException() throws PriceException
	{
	new Product(ProductMarks.Johniee_Walker_Blue,155).setPrice(-8);
	}
	}
	


