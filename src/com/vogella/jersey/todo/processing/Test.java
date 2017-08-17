package com.vogella.jersey.todo.processing;

import java.sql.SQLException;
import java.text.ParseException;

public class Test 
{

	public static void main(String[] args) throws ParseException, ClassNotFoundException, SQLException 
	{
		String text = "Dun beg, Enercon, James & Ben, T1, 3";
		
		String testOutput = TodosProcessing.Process(text);
		
		System.out.print(text);
		System.out.print(testOutput);

	}

}
