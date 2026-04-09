package com.sunbeam.cpmc;

import java.util.List;
import java.util.Scanner;

public class BookOperations {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try (BookDao dao = new BookDaoImpl()) {

            int choice;

            do {
                choice = BookMenu.menuOption(sc);

                switch (choice) {

                case 1: // Find by ID
                    System.out.print("Enter book id: ");
                    int id1 = sc.nextInt();

                    BookPojo book = dao.findById(id1);
                    if (book == null)
                        System.out.println("Book not found.");
                    else
                        System.out.println(book);
                    break;

                case 2: // Find all
                    List<BookPojo> list = dao.findAll();
                    list.forEach(System.out::println);
                    break;

                case 3: // Find by name
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter book name: ");
                    String name = sc.nextLine();

                    List<BookPojo> list1 = dao.findByName(name);
                    list1.forEach(System.out::println);
                    break;

                case 4: // Find by author
                    sc.nextLine();
                    System.out.print("Enter author name: ");
                    String author = sc.nextLine();

                    List<BookPojo> list2 = dao.findByAuthor(author);
                    list2.forEach(System.out::println);
                    break;

                case 5: // Find by subject
                    sc.nextLine();
                    System.out.print("Enter subject: ");
                    String subject = sc.nextLine();

                    List<BookPojo> list3 = dao.findBySubject(subject);
                    list3.forEach(System.out::println);
                    break;

                case 6: // Price range
                    System.out.print("Enter min price: ");
                    double min = sc.nextDouble();

                    System.out.print("Enter max price: ");
                    double max = sc.nextDouble();

                    List<BookPojo> list4 = dao.findByPriceBetween(min, max);
                    list4.forEach(System.out::println);
                    break;

                case 7: // Insert
                    sc.nextLine();
                    System.out.print("Enter book name: ");
                    String name1 = sc.nextLine();

                    System.out.print("Enter author: ");
                    String author1 = sc.nextLine();

                    System.out.print("Enter subject: ");
                    String subject1 = sc.nextLine();

                    System.out.print("Enter price: ");
                    double price1 = sc.nextDouble();

                    BookPojo newBook = new BookPojo(0, name1, author1, subject1, price1);
                    int count1 = dao.saveBook(newBook);

                    System.out.println("Book inserted: " + count1);
                    break;

                case 8: // Update
                    System.out.print("Enter book id: ");
                    int id2 = sc.nextInt();

                    sc.nextLine();
                    System.out.print("Enter new name: ");
                    String name2 = sc.nextLine();

                    System.out.print("Enter new author: ");
                    String author2 = sc.nextLine();

                    System.out.print("Enter new subject: ");
                    String subject2 = sc.nextLine();

                    System.out.print("Enter new price: ");
                    double price2 = sc.nextDouble();

                    BookPojo updatedBook = new BookPojo(id2, name2, author2, subject2, price2);
                    int count2 = dao.update(updatedBook);

                    if (count2 == 0)
                        System.out.println("Book not found.");
                    else
                        System.out.println("Book updated successfully.");
                    break;

                case 9: // Delete
                    System.out.print("Enter book id to delete: ");
                    int id3 = sc.nextInt();

                    int count3 = dao.deleteById(id3);

                    if (count3 == 0)
                        System.out.println("Book not found.");
                    else
                        System.out.println("Book deleted successfully.");
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