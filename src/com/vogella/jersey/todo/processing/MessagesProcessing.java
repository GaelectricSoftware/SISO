package com.vogella.jersey.todo.processing;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MessagesProcessing 
{
	public static String Process(String text) throws ParseException, ClassNotFoundException, SQLException
	{
		Boolean multiple = false;
		String teamName = "";
		String[] teamNames = null;
		String fullTeam = "";
		String texts = text;
		String[] signIn = texts.split(",");
		String windSite = signIn[0].trim();
		String company = signIn[1].trim();
		int departureTime = 0;
		
		//If the text message has more has more than one team member then it will be split each time an & symbol appears, 
		//if not then the team name is taken as one whole string
		
		if(signIn[2].contains("&") == true)
		{
			teamNames = signIn[2].trim().split("&");
			multiple = true;
		}
		else
		{
			teamName = signIn[2].trim();
		}
		
		String turbine = signIn[3].trim();
		int departure = Integer.parseInt(signIn[4].trim());
		
		Class.forName("postgresql-42.1.3");

	    Connection m_Connection = DriverManager.getConnection(
	        "dbtestinstance.cclcp0zv6ibp.eu-west.1.rds.amazonaws.com:5432;DatabaseName=OPCTrial2", "stephen", "superuser");

	    Statement m_Statement = m_Connection.createStatement();
	    String query = "SELECT ";

	    ResultSet m_ResultSet = m_Statement.executeQuery(query);
	    
	    
		
		if(windSite.replace(" ", "").compareToIgnoreCase("CarnHill") == 1)
		{
			windSite = "CHW";
		}
		else if(windSite.replace(" ", "").equalsIgnoreCase("Inishative"))
		{
			windSite = "INW";
		}
		else if(windSite.replace(" ", "").equalsIgnoreCase("Ballagh"))
		{
			windSite = "BAW";
		}
		else if(windSite.replace(" ", "").equalsIgnoreCase("Rockmarshall"))
		{
			windSite = "RMW";
		}
		else if(windSite.replace(" ", "").equalsIgnoreCase("Cloonty"))
		{
			windSite = "CLW";
		}
		else if(windSite.replace(" ", "").equalsIgnoreCase("CorbyKnowe"))
		{
			windSite = "CKW";
		}
		else if(windSite.replace(" ", "").equalsIgnoreCase("CregganconroeCrockbrack") || windSite.equalsIgnoreCase("Cregganconroe") || windSite.equalsIgnoreCase("Crockbrack"))
		{
			windSite = "CRW";
		}
		else if(windSite.replace(" ", "").equalsIgnoreCase("Dunbeg"))
		{
			windSite = "DUW";
		}
		else if(windSite.replace(" ", "").equalsIgnoreCase("Faughary"))
		{
			windSite = "FAW";
		}
		else if(windSite.replace(" ", "").equalsIgnoreCase("Monnaboy"))
		{
			windSite = "MBW";
		}
		else if(windSite.replace(" ", "").equalsIgnoreCase("Smulgedon"))
		{
			windSite = "SMW";
		}
		else if(windSite.replace(" ", "").equalsIgnoreCase("Tullyneill"))
		{
			windSite = "TNW";
		}
		else if(windSite.replace(" ", "").equalsIgnoreCase("Skrine"))
		{
			windSite = "SKW";
		}
		else if(windSite.replace(" ", "").equalsIgnoreCase("Ballybay"))
		{
			windSite = "BBWF";
		}
		else if(windSite.replace(" ", "").equalsIgnoreCase("Roosky"))
		{
			windSite = "GACL";
		}
		else if(windSite.replace(" ", "").equalsIgnoreCase("Cnoc"))
		{
			windSite = "GNOC";
		}
		else if(windSite.replace(" ", "").equalsIgnoreCase("Leabeg"))
		{
			windSite = "FCML";
		}
		else if(windSite.replace(" ", "").equalsIgnoreCase("Ballyhanedin"))
		{
			windSite = "BHW";
		}
		else if(windSite.replace(" ", "").equalsIgnoreCase("CAES"))
		{
			windSite = "CAES";
		}
		else if(windSite.replace(" ", "").equalsIgnoreCase("Cloghboola"))
		{
			windSite = "CLOGHBOOLA";
		}
		else if(windSite.replace(" ", "").equalsIgnoreCase("Foyle"))
		{
			windSite = "FOYLE";
		}
		else if(windSite.replace(" ", "").equalsIgnoreCase("Cashla"))
		{
			windSite = "CASHLA";
		}
		else if(windSite.replace(" ", "").equalsIgnoreCase("Portlaoise"))
		{
			windSite = "PORT";
		}
		else if(windSite.replace(" ", "").equalsIgnoreCase("Corracon"))
		{
			windSite = "CORR";
		}
		else if(windSite.replace(" ", "").equalsIgnoreCase("DunbegExt"))
		{
			windSite = "DUWE";
		}
		else if(windSite.replace(" ", "").equalsIgnoreCase("Ballywater"))
		{
			windSite = "BWWL";
		}
		else if(windSite.replace(" ", "").equalsIgnoreCase("Castledockrell"))
		{
			windSite = "CDWG";
		}
		
		
		String value = (windSite + " " + company + " " + fullTeam + turbine + " " + departure);
		
		return value;
	}

}
