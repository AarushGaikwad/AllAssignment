package com.sunbeam.cpmc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Test {
    public static final String db_driver = "com.mysql.cj.jdbc.Driver";
    public static final String db_url = "jdbc:mysql://localhost:3306/webjava";
    public static final String db_user = "test";
    public static final String db_pass = "test";

    static {
        // load driver
        try {
            Class.forName(db_driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) {

        try (Connection con = DriverManager.getConnection(db_url, db_user, db_pass)) {

            System.out.println("---- Users Count By Role ----");

            callSP(con);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Stored Procedure Call
    public static void callSP(Connection con) throws Exception {
        String sql = "CALL sp_users_by_role()";

        try (CallableStatement stmt = con.prepareCall(sql)) {

            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    String role = rs.getString("role");
                    int count = rs.getInt("cnt");

                    System.out.println(role + " : " + count);
                }
            }
        }
    }
}