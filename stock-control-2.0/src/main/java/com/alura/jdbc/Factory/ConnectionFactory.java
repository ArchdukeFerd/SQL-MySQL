package com.alura.jdbc.Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    public Connection retrieveConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/stock_control?useTimeZone=true&serverTimeZone=UTC","root","");

    }
}
