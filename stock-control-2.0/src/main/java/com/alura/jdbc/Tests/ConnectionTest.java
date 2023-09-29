package src.main.java.com.alura.jdbc.Tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import src.main.java.com.alura.jdbc.ConnectionLink;

public class ConnectionTest {
    public static void main(String[] args) throws SQLException {
		Connection con = new ConnectionLink().retrieveConnection();


        System.out.println("Closing Connection");

        con.close();
    }

}
