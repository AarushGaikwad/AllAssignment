package com.sunbeam.cpmc;

import java.util.Scanner;

public  class BookMenu {
	public static int menuOption(Scanner sc) {
		System.out.println("----MAIN MENU----");
		System.out.println("0. EXIT");
		System.out.println("1. Find Book By ID");
		System.out.println("2. Find All Books");
		System.out.println("3. Find Book By Name");
		System.out.println("4. Find Book By Author");
		System.out.println("5. Find Book By Subject");
		System.out.println("6. Find Book By Price Range");
		System.out.println("7. Insert New Book");
		System.out.println("8. Update Book By Id");
		System.out.println("9. Delete Book By Id");
		System.out.println("---------------------------------");
		System.out.print("Enter choice: ");
		int choice = sc.nextInt();
		return choice;
	}
	
}
