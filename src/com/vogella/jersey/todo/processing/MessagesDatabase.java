package com.vogella.jersey.todo.processing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

public class MessagesDatabase
{
	public void toDatabase(String windSite, String company, String team[], String areaOfWork, Time arrivalTime, Time departureTime) throws SQLException, ClassNotFoundException
	{
		 Class.forName("postgresql-42.1.3");

		    Connection m_Connection = DriverManager.getConnection(
		        "dbtestinstance.cclcp0zv6ibp.eu-west.1.rds.amazonaws.com:5432;DatabaseName=OPCTrial2", "stephen", "superuser");

		    Statement m_Statement = m_Connection.createStatement();
		    String query = "SELECT * FROM signIn";

		    ResultSet m_ResultSet = m_Statement.executeQuery(query);

		    while (m_ResultSet.next()) 
		    {
		      System.out.println(m_ResultSet.getString(1) + ", " + m_ResultSet.getString(2) + ", "
		          + m_ResultSet.getString(3) + ", " + m_ResultSet.getString(4) + ", " + m_ResultSet.getString(5) +
		          ", " + m_ResultSet.getString(6));

		      
		    }
		  }
	

}

