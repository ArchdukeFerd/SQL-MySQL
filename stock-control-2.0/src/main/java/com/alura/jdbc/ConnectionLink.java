package main.java.com.alura.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoadDriver {
    public static void main(String[] args) {
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
    }
}

public class ConnectionLink {
    public Connection retrieveConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/stock_control?useTimeZone=true&serverTimeZone=UTC","archdukeferdinand","Chuu2koi!");

    }
}
