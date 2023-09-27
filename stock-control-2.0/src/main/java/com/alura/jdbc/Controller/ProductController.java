package com.alura.jdbc.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductController {

	public void modify(String Name, String Description, Integer Id) {
		// TODO
	}

	public void delete(Integer Id) {
		// TODO
	}

	public List<?> list() throws SQLException{
/* 		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/stock_control?useTimeZone=true&serverTimeZone=UTC","root","root");
		Statement statement = con.createStatement();
		boolean result = statement.execute("SELECT Id, Name, Description, Quantity FROM PRODUCT");
		System.out.println(result);
		con.close(); */
		return new ArrayList<>();
	}

    public void save(Object Product) {
		// TODO
	}

}
