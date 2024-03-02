package com.nagp2024.qa;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import exceptions.InvalidQueryException;
import utilities.PropertyFileReader;

public class SchoolSimpleDataQuerySystem {

	static PropertyFileReader prp;
	static SchoolSimpleDataQuerySystem pwd = new SchoolSimpleDataQuerySystem();
	static PasswordAuthenticator pa = new PasswordAuthenticator();
	static DisplayMenu dm = new DisplayMenu();
	static Choice choice = new Choice();

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, InvalidQueryException {

		boolean flag = pa.authenticator();
		if (flag) {
			while (flag) {
				dm.menu();
				if (choice.choice()==6) {
					flag=false;
					break;
				}

			}
		}
	}
}


