package com.nagp2024.qa;

import java.io.IOException;
import java.util.Scanner;

import utilities.PropertyFileReader;

public class PasswordAuthenticator {
	
	static PropertyFileReader prp;
	
	public boolean authenticator() {
		boolean flag=false;
		try {
			final String CORRECT_PASSWORD = prp.getAppPassword();
			final int MAX_TRIES = 4;
			Scanner scanner = new Scanner(System.in);
			int tries = 0;
			while (tries<MAX_TRIES) {
				System.out.println("Enter Password");
				String passwordString = scanner.next();
				if (passwordString.equals(CORRECT_PASSWORD)) {
					System.out.println("Access granted");
					flag=true;
					break;
				}else {
					tries++;
					System.out.println("Incorrect password. Tries left: "+(MAX_TRIES-tries));
				}
			}
			if (tries==MAX_TRIES) {
				System.out.println("Access denied. Too many attempts");
			}

			
					
		} catch (IOException e) {
			e.printStackTrace();
		}
		return flag;
	}

}
