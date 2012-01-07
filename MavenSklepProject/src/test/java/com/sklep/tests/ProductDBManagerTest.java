package com.sklep.tests;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sklep.services.*;
import com.sklep.project.*;

public class ProductDBManagerTest {

	ProductDBManager pdb = new ProductDBManager();

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
	pdb.deleteAllProducts();	
	}

	@Test
	public void testAddProduct() throws SQLException  {
		pdb.addProduct(new Product(ProductMarks.Johniee_Walker_Red,65,12112245));
		pdb.addProduct(new Product(ProductMarks.Sheridans,47,12357245));
		assertEquals(2, pdb.getAllProducts().size());
	
	}

	@Test
	public void testGetAllProducts() throws SQLException {
		pdb.addProduct(new Product(ProductMarks.Johniee_Walker_Red,65,12112245));
		assertEquals(1, pdb.getAllProducts().size());
	}

	
	

	@Test
	public void testFindProductByName() throws SQLException {
		pdb.addProduct(new Product(ProductMarks.Johniee_Walker_Red,65,12112245));
		pdb.addProduct(new Product(ProductMarks.Johniee_Walker_Red,65,12112245));
		pdb.addProduct(new Product(ProductMarks.Sheridans,47,12357245));
		assertTrue(pdb.findProductByName(ProductMarks.Sheridans).size() == 1);
	}

	@Test
	public void testFindProductByCode() throws SQLException {
		pdb.addProduct(new Product(ProductMarks.Johniee_Walker_Red,65,12112246));
		assertEquals(1, pdb.findProductByCode(12112246).size());
	}

	

}