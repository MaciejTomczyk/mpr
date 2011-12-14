package com.sklep.services;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.sklep.project.Client;
public class ClientDBManager {

	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement addClientStmt;
	private PreparedStatement getClientStmt;

	private PreparedStatement deleteClientStmt;
	
	public ClientDBManager() throws java.sql.SQLException, SQLException
	{
	
		
			Properties props=new Properties();

			try {
				props.load(ClassLoader.getSystemResourceAsStream("com/sklep/jdbc.properties"));
			} catch (IOException e) {
				e.printStackTrace();
			}

		conn= DriverManager.getConnection(props.getProperty("url"),props);
		boolean clientTableExists=false;
		
	

		ResultSet rs= conn.getMetaData().getTables(null, null,null, null);
		stmt=conn.createStatement();
		
		
		
		while(rs.next()){
			if("Client".equalsIgnoreCase(rs.getString("TABLE_NAME")))
			{clientTableExists=true;
			break;
			}
				
		}
		if(!clientTableExists)
		{
			
		
			stmt.executeUpdate("" +
					"CREATE TABLE client(" +
					"id bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY," +
					"name varchar(20)," +
					"" +
					")");
				
		}
		
		
		
		
		
			
			
		
			addClientStmt=conn.prepareStatement("" +
			"INSERT INTO Client (name) VALUES (?)" +
			"");

			getClientStmt=conn.prepareStatement("" +
			"SELECT * FROM Client" +
			"");
			
	
			
	
			deleteClientStmt=conn.prepareStatement("" +
					"DELETE FROM Client" +
					"");
		
			
			
			
			
	
	
		}
		public void addClient(Client c) throws java.sql.SQLException, SQLException
		{
			addClientStmt.setString(1, c.getName());

			addClientStmt.executeUpdate();

		}
		

		
		

		public List<Client> getAllClients() throws java.sql.SQLException, SQLException
		{
			List<Client> Clients=new ArrayList<Client>();

			ResultSet rs= getClientStmt.executeQuery();

			while(rs.next())
			{
				Clients.add(new Client(rs.getString("name")));
			}

			return Clients;
		}
	
		public void clear() throws java.sql.SQLException{
			ResultSet rs= getClientStmt.executeQuery();
			while(rs.next())deleteClientStmt.executeUpdate();
			
		
		}
		
		
		
}
