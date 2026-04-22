package com.app.geometry;

import java.util.Scanner;

public class TestPoint {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter x co-ordinate");
		Point2D p1 = new Point2D(sc.nextDouble(), sc.nextDouble());
		System.out.println("enter y co-ordinate");
		Point2D p2 = new Point2D(sc.nextDouble(), sc.nextDouble());
		
		
		
//		Point2D p1 = new Point2D(1,4);
//		Point2D p2 = new Point2D(2,8);
		if(p1.isEqual(p2)) {
			System.out.println("Points are same");
		}
		else {
			System.out.println("the points are different.");
		    System.out.println(p1.calculateDistance(p2));
		}
	}
}
