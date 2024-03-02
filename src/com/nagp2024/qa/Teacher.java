package com.nagp2024.qa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exceptions.RecordNotFoundException;
import utilities.DBConnection;

public class Teacher {
	
	String employeeId;
	double salary;
	double bonus;
	Teacher teacher;
	DBConnection dbConnection;
	
	public double calculateSalary() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of hours teacher worked in the nearst whole number");
		int hours = scanner.nextInt();
		System.out.println("Enter the payrate of the teacher");
		double rate = scanner.nextDouble();
		salary = hours*rate;
		
		
		return salary;
	}
	
	public double calculateBonus() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of hours teacher worked extra");
		int hours = scanner.nextInt();
		System.out.println("Enter the rate of extra hours");
		double rate = scanner.nextDouble();
		bonus = hours*rate;
		
		return bonus;
	}
	
	public void addTeacher() {
		teacher = new Teacher();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the employeeId of the teacher");
		employeeId = scanner.next();
		String query = "Insert into teacher values (\""+employeeId+"\",\""+teacher.calculateSalary()+"\",\""+teacher.calculateBonus()+"\")";
		System.out.println(query);
		dbConnection = new DBConnection();
		try {

			Statement stmt = dbConnection.connectToDB().createStatement();
			stmt.execute(query);
			System.out.println("Teacher "+employeeId+" added successfully");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void removeTeacher() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Employee Id of the teacher you wish to remove");
		employeeId = scanner.next();
		String selectQuery = "select employee_id from teacher;";
		String deleteQuery = "Delete from teacher where employee_id = '"+employeeId+"'";
		boolean flag=false;
		List<String> empidList = new ArrayList<>();
		try {
			Statement stmt = dbConnection.connectToDB().createStatement();
			ResultSet rs = stmt.executeQuery(selectQuery);
			while (rs.next()) {
				empidList.add(rs.getString("employee_id"));
			}
			System.out.println(empidList);
			for (String string : empidList) {
				if (string.equals(employeeId)) {
					stmt.execute(deleteQuery);
					System.out.println("Teacher "+employeeId+" removed successfully");
					flag=true;
					break;
				}
				else {
					
					continue;
					
				}
			}
			if (!flag) {
				throw new RecordNotFoundException("Record not found with roll number : "+employeeId);
			}


		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
