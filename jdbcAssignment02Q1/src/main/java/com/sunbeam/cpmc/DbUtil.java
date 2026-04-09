package com.sunbeam.cpmc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	public static final String db_driver = "com.mysql.cj.jdbc.Driver";
	public static final String db_url = "jdbc:mysql://localhost:3306/webjava";
	public static final String db_user = "test";
	public static final String db_pass = "test";
	
	static {
		try {
			Class.forName(db_driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public static Connection connect() throws Exception{
		Connection con = DriverManager.getConnection(db_url, db_user, db_pass);
		return con;
	}
}
