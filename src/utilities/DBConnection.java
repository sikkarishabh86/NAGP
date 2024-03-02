package utilities;

import java.security.PublicKey;
import java.sql.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptions.InvalidQueryException;
public class DBConnection {
	
	static String connString = "jdbc:mysql://localhost:3306/school";
	static String username = "root";
	static String password = "Rish1392@!@!";
	
	public static Connection connectToDB() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(connString, username, password);
		return connection;
	}
	
	public  boolean regexValidator(String query) throws InvalidQueryException {
		boolean flag = false;
		String regex = "^SELECT(\\s)?+\\*(\\s)?+FROM\\s+(person|teacher|student)$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(query);
		if (matcher.matches()) {
			flag=true;
		}else {
			throw new InvalidQueryException("Input query invalid");
		}
		
		return flag;
	}
	


}
