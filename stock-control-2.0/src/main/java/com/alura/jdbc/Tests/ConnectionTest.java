package src.main.java.com.alura.jdbc.Tests;

import java.sql.Connection;
import java.sql.SQLException;

import src.main.java.com.alura.jdbc.Factory.ConnectionFactory;

public class ConnectionTest {
    public static void main(String[] args) throws SQLException {
		Connection con = new ConnectionFactory().retrieveConnection();


        System.out.println("Closing Connection");

        con.close();
    }

}
