package com.app.geometry;
import java.lang.Math;

public class Point2D {
	private double x;
	private double y;
	
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public Point2D(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	//printing the x,y in string
	public String getDetails() {
		return ("Points are x: " + x + " y: " + y);
	}
	
	//comparing them
	public Boolean isEqual(Point2D p) {
		return this.x==p.x && this.y==p.y;
	}
	
	//if not equal then calculate
	public double calculateDistance(Point2D p) {
		double distance1 =Math.sqrt(Math.pow((this.x - p.x), 2) + Math.pow((this.y - p.y), 2));
		return distance1;
	}
}
