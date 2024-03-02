package com.nagp2024.qa;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import exceptions.InvalidQueryException;
import utilities.DBConnection;

public class QueryData {
	
	DBConnection dbConnection = new DBConnection();
	
	public void queryData() throws ClassNotFoundException, SQLException, InvalidQueryException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the SQL query");
		String query = scanner.nextLine();
			if (dbConnection.regexValidator(query)) {
//				System.out.println("regex validated");
				Statement stmt = dbConnection.connectToDB().createStatement();
				ResultSet rs = stmt.executeQuery(query);
				ResultSetMetaData rsmd = rs.getMetaData();
				int colnum = rsmd.getColumnCount();
				while (rs.next()) {
//					System.out.println(rs.next());
					for (int i = 1; i <= colnum; i++) {
						System.out.print(rs.getString(i)+" || ");					
					}
					System.out.println();
				}
			}
		
	}

}
