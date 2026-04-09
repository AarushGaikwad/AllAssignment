package com.sunbeam.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Test {
	public static final String db_driver = "com.mysql.cj.jdbc.Driver";
	public static final String db_url = "jdbc:mysql://localhost:3306/webjava";
	public static final String db_user = "test";
	public static final String db_pass = "test";
	static {
		//load driver
		try {
			Class.forName(db_driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try(Connection con = DriverManager.getConnection(db_url, db_user, db_pass)){
			// 1) display all users
			System.out.println("---All Users---");
			displayAllUsers(con);
			
			// 2) insert new user
			System.out.println("Enter name: ");
			String name = sc.nextLine();
			System.out.println("Enter email: ");
			String email = sc.nextLine();
			System.out.println("Enter password: ");
			String password = sc.nextLine();
			System.out.println("Enter role: ");
			String role = sc.nextLine();
			System.out.println("Enter birth: ");
			String dateStr = sc.nextLine();
			// convert string to java.sql.date
			Date dob = Date.valueOf(dateStr);
			
			insertUser(con, name, email, password, role, dob);
			
			// 3) changes password for the user id
			System.out.println("Enter user id: ");
			int a = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter new password: ");
			String newPass = sc.nextLine();
			
			changePassword(con, newPass, a);
			
			// 4)delete user with given id
			System.out.println("Enter user id: ");
			int x = sc.nextInt();
			sc.nextLine();
			
			deleteUser(con, x);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	//1) Display all Users
	public static void displayAllUsers(Connection con) throws SQLException{
		String sql = "SELECT * FROM users";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			try(ResultSet rs = stmt.executeQuery()){
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String email = rs.getString("email");
					String role = rs.getString("role");
					String birth = rs.getString("birth");
					
					System.out.println(id + " " + name + " " + email + " " + role + " " + birth);
				}
			}
		}
	}
	
	//2) Insert New User
	public static void insertUser(Connection con, String name, String email, String password, String role, Date dob) throws SQLException{
		String sql = "INSERT INTO users(name, email, password, role, birth) VALUES (?, ?, ?, ?, ?)";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setString(3, password);
			stmt.setString(4, role);
			stmt.setDate(5, dob);
			
			int count = stmt.executeUpdate();
			System.out.println("user added succesfully");
		}
	}
	
	//3) Change Password
	public static void changePassword(Connection con, String newPass, int id) throws SQLException{
		String sql = "UPDATE users SET password = ? WHERE id = ?";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, newPass);
			stmt.setInt(2, id);
			
			int count = stmt.executeUpdate();
			System.out.println("password changed for the user id " + id);
		}
	}
	
	public static void deleteUser(Connection con, int id) throws SQLException{
		String sql = "DELETE FROM users WHERE id = ?";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, id);
			
			int count = stmt.executeUpdate();
			System.out.println("user id " + id + " deleted");
		}
	}

}
