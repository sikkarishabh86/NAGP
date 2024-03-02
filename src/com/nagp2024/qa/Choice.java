package com.nagp2024.qa;

import java.sql.SQLException;
import java.util.Scanner;

import exceptions.InvalidQueryException;

public class Choice {
	
	Student student = new Student();
	Teacher teacher = new Teacher();
	QueryData qd = new QueryData();

	public int choice() throws ClassNotFoundException, SQLException, InvalidQueryException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose from the above menu");
		int choice = sc.nextInt();
		switch (choice) {
		case 1: student.addStudent();;

		break;

		case 2: student.deleteStudent();

		break;

		case 3: teacher.addTeacher();

		break;

		case 4: teacher.removeTeacher();

		break;

		case 5: qd.queryData();

		break;

		case 6: exit();

		break;

		default:
			System.out.println("invalid choice");
			break;
		
		}
		return choice;
	}
	
	public boolean exit() {
		System.out.println("Logged out successfully");
		return true;
	}

}
