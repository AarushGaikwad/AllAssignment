package com.sunbeam.cpmc;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class UserOperations {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try (UserDao dao = new UserDaoImpl()) {

            int choice;

            do {
                choice = UserMenu.menu(sc);

                switch (choice) {

                case 1: // Find by ID
                    System.out.print("Enter User ID: ");
                    int id = sc.nextInt();

                    User user = dao.findById(id);
                    if (user == null)
                        System.out.println("User not found.");
                    else
                        System.out.println(user);
                    break;

                case 2: // Find all
                    List<User> list = dao.findAll();
                    list.forEach(System.out::println);
                    break;

                case 3: // Find by email
                    sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();

                    User u = dao.findByEmail(email);
                    if (u == null)
                        System.out.println("User not found.");
                    else
                        System.out.println(u);
                    break;

                case 4: // Insert
                    sc.nextLine();

                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter password: ");
                    String password = sc.nextLine();

                    System.out.print("Enter email: ");
                    String email1 = sc.nextLine();

                    System.out.print("Enter address: ");
                    String addr = sc.nextLine();

                    System.out.print("Enter role: ");
                    String role = sc.nextLine();

                    System.out.print("Enter birth (yyyy-MM-dd): ");
                    String birthStr = sc.nextLine();

                    Date birth = Date.valueOf(birthStr);

                    User newUser = new User(0, name, password, email1, addr, role, birth);

                    int count = dao.save(newUser);
                    System.out.println("User inserted: " + count);
                    break;

                case 5: // Update
                    System.out.print("Enter user id: ");
                    int uid = sc.nextInt();

                    sc.nextLine();
                    System.out.print("Enter name: ");
                    String name2 = sc.nextLine();

                    System.out.print("Enter password: ");
                    String pass2 = sc.nextLine();

                    System.out.print("Enter email: ");
                    String email2 = sc.nextLine();

                    System.out.print("Enter address: ");
                    String addr2 = sc.nextLine();

                    System.out.print("Enter role: ");
                    String role2 = sc.nextLine();

                    System.out.print("Enter birth (yyyy-MM-dd): ");
                    String birthStr2 = sc.nextLine();

                    Date birth2 = Date.valueOf(birthStr2);

                    User updatedUser = new User(uid, name2, pass2, email2, addr2, role2, birth2);

                    int count2 = dao.update(updatedUser);

                    if (count2 == 0)
                        System.out.println("User not found.");
                    else
                        System.out.println("User updated successfully.");
                    break;

                case 6: // Change password
                    System.out.print("Enter user id: ");
                    int id3 = sc.nextInt();

                    sc.nextLine();
                    System.out.print("Enter new password: ");
                    String newPass = sc.nextLine();

                    int count3 = dao.changePassword(id3, newPass);

                    if (count3 == 0)
                        System.out.println("User not found.");
                    else
                        System.out.println("Password updated.");
                    break;

                case 7: // Delete
                    System.out.print("Enter user id to delete: ");
                    int id4 = sc.nextInt();

                    int count4 = dao.deleteById(id4);

                    if (count4 == 0)
                        System.out.println("User not found.");
                    else
                        System.out.println("User deleted successfully.");
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
                }

            } while (choice != 0);

        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }
}