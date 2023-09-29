package main.java.com.alura.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionLink {
    public Connection retrieveConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:admin:///var/lib/mysql?useTimeZone=true&serverTimeZone=UTC","root","");

    }
}
