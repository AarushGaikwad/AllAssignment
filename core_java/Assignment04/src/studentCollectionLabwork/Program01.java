package studentCollectionLabwork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Program01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Student> studentList = new ArrayList<>();
		int choice;
		
		do {
			System.out.println("0. EXIT");
			System.out.println("1. Add Student Details");
			System.out.println("2. Display all Students");
			System.out.println("3. Find Student by roll no");
			System.out.println("4. Delete student bu given roll no");
			System.out.println("5. Display all students sorted on roll no in asc order");
			System.out.println("6. Display all students sorted on name in asc order");
			System.out.println("7. Display all students sorted on marks in desc order");
			System.out.println("8. Display student marks and their percentage");
			System.out.println();
			System.out.println("Enter Choice:");
			choice = sc.nextInt();
			System.out.println();
			
			switch(choice) {
			
			case 1:
				System.out.println("Enter student details");
				// Student s = new Student(sc.next(), sc.nextInt(), sc.nextDouble());
				// studentList.add(s);
				
				studentList.add(new Student("Max", 4, 98));
				studentList.add(new Student("Lewis", 1, 87));
				studentList.add(new Student("George", 3, 65));
				studentList.add(new Student("Lando", 2, 105));
				studentList.add(new Student("Carlos", 5, 154));
				System.out.println();
				break;
				
			case 2:
				System.out.println("Display all students");
				for(Student std:studentList) {
					System.out.println(std);
				}
				System.out.println();
				break;
				
			case 3:
				Student s = new Student();
				System.out.println("Enter roll no to find the student:");
				int rollno = sc.nextInt();
				s.setRollNo(rollno);
				int index = studentList.indexOf(s);
				if(index != -1) {
					System.out.println("Details of the student with " + s.rollNo + " is " + studentList.get(index));
				}
				else {
					System.out.println("No Student Found");
				}
				System.out.println();
				break;
				
			case 4:
				Student s1 = new Student();
				System.out.println("Enter roll no of student you want to delete: ");
				int rollno1 = sc.nextInt();
				s1.setRollNo(rollno1);
				int index1 = studentList.indexOf(s1);
				if(index1 != -1) {
					studentList.remove(index1);
					System.out.println("Student Deleted");
				}
				else {
					System.out.println("Student already deleted");
				}
				System.out.println();
				
			case 5: 
				System.out.println("sorting of students based on roll no in asc order");
				System.out.println();
				Collections.sort(studentList);
				for(Student std :studentList) {
					System.out.println(std);
				}
				System.out.println();
				break;
				
			case 6:
				System.out.println("sorting of students based on name in asc order");
				System.out.println();
				Collections.sort(studentList, new Comparator<Student>() {
					public int compare(Student s1, Student s2) {
						return s1.name.compareTo(s2.name);
					}
				});
				for(Student std : studentList) {
					System.out.println(std);
				}
				System.out.println();
				break;
				
			case 7:
				System.out.println("sorting of students based on marks in desc order");
				System.out.println();
				Collections.sort(studentList, new Comparator<Student>() {
					public int compare(Student s1, Student s2) {
						return Double.compare(s2.marks, s1.marks);
					}
				});
				for(Student std : studentList) {
					System.out.println(std);
				}
				System.out.println();
				break;
				
			case 8:
				for(Student std : studentList) {
					System.out.println("Student name = " + std.name + " & percentage = " + std.percentage() + "%");
				}
				System.out.println();
			}
			
		} while (choice != 0);
		
	}

}
