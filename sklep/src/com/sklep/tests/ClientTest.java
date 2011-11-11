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
	}

	@Test
	public void testPrintProducts() {
		c.printProducts();
	}

	@Test
	public void testAddProduct() throws PriceException {
		c.addProduct(p);
		assertTrue(c.products.size()>0);
		
	}

	@Test
	public void testDeleteProduct() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckPrice() {
		fail("Not yet implemented");
	}

	@Test
	public void testChangeProductPrice() {
		fail("Not yet implemented");
	}

	@Test
	public void testChangeProductCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindProduct() {
		fail("Not yet implemented");
	}

	@Test
	public void testClient() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAllProducts() {
		fail("Not yet implemented");
	}

	@Test
	public void testObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClass() {
		fail("Not yet implemented");
	}

	@Test
	public void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testEquals() {
		fail("Not yet implemented");
	}

	@Test
	public void testClone() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotify() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotifyAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLongInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testWait() {
		fail("Not yet implemented");
	}

	@Test
	public void testFinalize() {
		fail("Not yet implemented");
	}
	
	@Test(expected=PriceException.class, timeout=100)
	public void testException() throws PriceException
	{
	new Product(ProductMarks.Johniee_Walker_Blue,155).setPrice(-8);
	}
	}
	


