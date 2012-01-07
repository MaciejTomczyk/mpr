package com.sklep.tests;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sklep.project.Client;
import com.sklep.services.ClientDBManager;

public class ClientDBManagerTest {

	ClientDBManager cdb = new ClientDBManager();
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
		cdb.deleteAllClients();
	}


	@Test
	public void testAddClient() throws SQLException {
		cdb.addClient(new Client("MM"));
		assertEquals(1, cdb.getAllClients().size());
	}

	@Test
	public void testGetAllClients() throws SQLException {
		cdb.addClient(new Client("MM"));
		cdb.addClient(new Client("MM"));
		cdb.addClient(new Client("MM"));
		assertEquals(3, cdb.getAllClients().size());
	}
	
	@Test
	public void testclear() throws SQLException {
		cdb.clear();
		assertEquals(0, cdb.getAllClients().size());
	}

	@Test
	public void testFindClientByName() throws SQLException {
		cdb.addClient(new Client("MML"));
		assertEquals(1, cdb.FindClientByName("MML").size());
		assertTrue(cdb.FindClientByName("MML").size() == 1);
	}
	@Test
	public void testdeleteAllClients() throws SQLException 
	{
		cdb.addClient(new Client("MML"));
		cdb.addClient(new Client("MML"));
		cdb.deleteAllClients();
		assertEquals(0, cdb.getAllClients().size());
	}




}
