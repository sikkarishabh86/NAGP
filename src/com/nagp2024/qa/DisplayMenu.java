package com.nagp2024.qa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DisplayMenu {
	
	public void menu() {
		List<String> menuList = new ArrayList<>();
		menuList.add("1. Add Student Details - Add the details of a new student");
		menuList.add("2. Remove student details - Remove a student from the records");
		menuList.add("3. Add teacher details - Add the details of a new teacher");
		menuList.add("4. remove teacher details - remove a teacher from records");
		menuList.add("5. Query data");
		menuList.add("6. Exit");
		
		for (String string : menuList) {
			System.out.println(string);
		}
	}

}
