package com.demo2.demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

	private static Connection con;

    private DBconnection() {

    }

    public static Connection getDBConnection() throws ClassNotFoundException, SQLException {

        if(con==null ||con.isClosed()) {

            String url = "jdbc:mysql://localhost:3306/patientdb";
            String username = "root";
            String password = "";
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, username, password);
            }catch (Exception e){
                System.out.println(e);
            }
            
            System.out.println("Connected to DB");
            
        }
            
            return con;

        }
}
