package com.app.fruits;

import java.util.Scanner;

public class FruitBasket {

    public static void main(String[] args) {
        
        int counter = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the basket: ");
        int size = sc.nextInt();
        sc.nextLine();
        
        Fruit[] f = new Fruit[size];
        
        int choice;
        
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("0. EXIT");
            System.out.println("1. Add Mango");
            System.out.println("2. Add Orange");
            System.out.println("3. Add Apple");    
            System.out.println("4. Display all fruits in the basket");
            System.out.println("5. Display details (name, color, weight, freshness)");
            System.out.println("6. Display Stale fruits");
            System.out.println("7. Mark a fruit as stale");
            
            System.out.print("enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            
            switch(choice) {
            
            case 1:
                System.out.println("Enter Mango Details (name, color, weight)");
                if(counter < size) {
                    f[counter++] = new Mango(sc.next(), sc.next(), sc.nextDouble());
                } else {
                    System.out.println("Basket is full");
                }
                break; 
                    
            case 2:
                System.out.println("Enter Orange Details (name, color, weight)");
                if(counter < size) {
                    f[counter++] = new Orange(sc.next(), sc.next(), sc.nextDouble());
                } else {
                    System.out.println("Basket is full");
                }
                break;
                
            case 3:
                System.out.println("Enter Apple Details (name, color, weight)");
                if(counter < size) {
                    
                    f[counter++] = new Apple(sc.next(), sc.next(), sc.nextDouble());
                } else {
                    System.out.println("Basket is full");
                }
                break;
                
            case 4:
                System.out.println("Names of the fruits in the basket: ");
                
                for(Fruit e : f) {
                	if(e != null) {
                		System.out.println(e.getName());
                	}
                }
                break;
                
            case 5:
            	System.out.println("Details of the fruits are");
            	for(Fruit e : f) {
            		if(e != null && e.isFresh()) {
            			System.out.println(e.toString() + " " + e.taste());
            		}
            	}
            	break;
            case 6:
            	for(Fruit e : f) {
            		if(e != null && !e.isFresh()) {
            			System.out.println(e.taste());
            		}
            	}
            	break;
            	
            case 7: 
            	System.out.println("enter which fruits are stale");
            	int index = sc.nextInt();
            	if(index >= 0 && index < counter) {
            		f[index].setFresh(false);
            		System.out.println("Fruit mark as stale");
            	}
            	else {
            		System.out.println("Invalid index in the basket");
            	}
            	break;
            }
        } while(choice != 0);
        
        sc.close();
    }
}
