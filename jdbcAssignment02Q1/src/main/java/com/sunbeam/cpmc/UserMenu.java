package com.sunbeam.cpmc;

import java.util.Scanner;

public class UserMenu {

    public static int menu(Scanner sc) {
        System.out.println("\n---- USER MENU ----");
        System.out.println("1. Find User By ID");
        System.out.println("2. Find All Users");
        System.out.println("3. Find User By Email");
        System.out.println("4. Add New User");
        System.out.println("5. Update User");
        System.out.println("6. Change Password");
        System.out.println("7. Delete User");
        System.out.println("0. Exit");
        System.out.println("-------------------");
        System.out.print("Enter choice: ");

        return sc.nextInt();
    }
}