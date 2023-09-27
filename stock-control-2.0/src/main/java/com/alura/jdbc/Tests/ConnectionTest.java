package com.alura.jdbc.Tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost/stock_control?useTimeZone=true&serverTimeZone=UTC",
                "root",
                "root");

        System.out.println("Closing Connection");

        con.close();
    }

}
