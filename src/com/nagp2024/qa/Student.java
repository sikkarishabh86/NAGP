package com.nagp2024.qa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exceptions.RecordNotFoundException;
import utilities.DBConnection;

public class Student extends Person{

	String rollNumber;
	double marks;
	Scanner scanner = new Scanner(System.in);
	DBConnection dbConnection = new DBConnection();

	public void addStudent() {
		System.out.println("Enter the student first name");
		super.firstName=scanner.next();
		String fn = super.firstName;
		System.out.println("Enter the student middle name");
		super.middleName=scanner.next();
		String mn = super.middleName;
		System.out.println("Enter the student last name");
		super.lastName=scanner.next();
		String ln = super.lastName;
		System.out.println("Enter the student contact number");
		super.contactNumber=scanner.next();
		String cn = super.contactNumber;
		System.out.println("Enter the student address");
		scanner.nextLine();
		super.address=scanner.nextLine();
		String add = super.address;
		System.out.println("Enter the student roll number");
		this.rollNumber=scanner.next();
		String rn = rollNumber;
		System.out.println("Enter the student marks");
		this.marks=scanner.nextDouble();
		double mks = marks;
//		System.out.println(fn+" "+mn+" "+ln+" "+cn+" "+add+" "+rn+" "+mks);
		String query = "Insert into student values (\""+fn+"\",\""+mn+"\",\""+ln+"\",\""+cn+"\",\""+add+"\",\""+rn+"\",\""+mks+"\")";
		//		System.out.println(query);
		try {

			Statement stmt = dbConnection.connectToDB().createStatement();
			stmt.execute(query);
			System.out.println("Student "+fn+" added successfully");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteStudent() {
		System.out.println("Enter the student roll number you wish to delete");
		String rnumber = scanner.next();
		String selectQuery = "select roll_number from student;";
		String deleteQuery = "Delete from student where roll_number = '"+rnumber+"'";
		boolean flag=false;
		List<String> rnList = new ArrayList<>();
		try {
			Statement stmt = dbConnection.connectToDB().createStatement();
			ResultSet rs = stmt.executeQuery(selectQuery);
			while (rs.next()) {
				rnList.add(rs.getString("roll_number"));
			}
			System.out.println(rnList);
			for (String string : rnList) {
				if (string.equals(rnumber)) {
					stmt.execute(deleteQuery);
					flag=true;
					System.out.println("Student removed successfully");
					break;
				}
				else {
					
					continue;
					
				}
			}
			if (!flag) {
				throw new RecordNotFoundException("Record not found with roll number : "+rnumber);
			}


		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}




