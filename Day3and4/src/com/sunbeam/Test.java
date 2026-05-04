package com.sunbeam;

import java.util.*;

class Employee {
    int id;
    String name;
    double salary;
    Employee next;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.next = null;
    }
}

class EmployeeProgram {

    Employee head = null;

    void add(int id, String name, double sal) {
        Employee e = new Employee(id, name, sal);

        if (head == null) {
            head = e;
        } else {
            Employee temp = head;
            while (temp.next != null)
                temp = temp.next;

            temp.next = e;
        }
        System.out.println("Employee added successfully.");
    }

    void display() {
        if (head == null) {
            System.out.println("No employees to display.");
            return;
        }

        Employee temp = head;
        System.out.println("\n--- Employee List ---");
        while (temp != null) {
            System.out.println("ID: " + temp.id +
                               ", Name: " + temp.name +
                               ", Salary: " + temp.salary);
            temp = temp.next;
        }
    }

    void search(String name) {
        Employee temp = head;

        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("Employee Found: ID=" + temp.id +
                                   ", Salary=" + temp.salary);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Employee not found.");
    }

    void delete(int id) {
        Employee temp = head, prev = null;

        while (temp != null) {
            if (temp.id == id) {
                if (prev == null)
                    head = temp.next;
                else
                    prev.next = temp.next;

                System.out.println("Employee deleted successfully.");
                return;
            }
            prev = temp;
            temp = temp.next;
        }
        System.out.println("Employee not found.");
    }

    void update(int id, double sal) {
        Employee temp = head;

        while (temp != null) {
            if (temp.id == id) {
                temp.salary = sal;
                System.out.println("Salary updated successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Employee not found.");
    }
}

public class Test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeProgram list = new EmployeeProgram();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Search Employee by Name");
            System.out.println("4. Delete Employee by ID");
            System.out.println("5. Update Salary by ID");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter Employee Name: ");
                    String name = sc.next();

                    System.out.print("Enter Employee Salary: ");
                    double salary = sc.nextDouble();

                    list.add(id, name, salary);
                    break;

                case 2:
                    list.display();
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    String searchName = sc.next();
                    list.search(searchName);
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int delId = sc.nextInt();
                    list.delete(delId);
                    break;

                case 5:
                    System.out.print("Enter ID to update: ");
                    int updId = sc.nextInt();

                    System.out.print("Enter new salary: ");
                    double newSal = sc.nextDouble();

                    list.update(updId, newSal);
                    break;

                case 6:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}