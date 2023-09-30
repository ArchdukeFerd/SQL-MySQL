package com.alura.jdbc.Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alura.jdbc.Factory.ConnectionFactory;

public class ProductController {

	public void modify(String Name, String Description, Integer Id) {
	}

	public void delete(Integer Id) {
	}

	public List<Map<String, String>> list() throws SQLException{
		Connection con = new ConnectionFactory().retrieveConnection();
		Statement statement = con.createStatement();
		statement.execute("select Id, Name, Description, Quantity from product");
		ResultSet resultSet = statement.getResultSet();
		List<Map<String, String>> result = new ArrayList<>();
		while(resultSet.next()){
			Map<String, String> row = new HashMap<>();
			row.put("Id", String.valueOf(resultSet.getInt("Id")));
			row.put("Name", resultSet.getString("Name"));
			row.put("Description", resultSet.getString("Description"));
			row.put("Quantity", String.valueOf(resultSet.getInt("Quantity")));

			result.add(row);
		}
		con.close();

		return result;
	}

    public void save(Map<String, String> product) throws SQLException {
		Connection con = new ConnectionFactory().retrieveConnection();
		Statement statement = con.createStatement();
		statement.execute("insert into product(Name, Description, Quantity)"+" values('"+product.get("Name")+"'', '"+product.get("Description")+"'', "+product.get("Quantity")+")", Statement.RETURN_GENERATED_KEYS);

		ResultSet resultSet = statement.getGeneratedKeys();
		while (resultSet.next()){
			System.out.println(String.format("Id product was inserted %d", resultSet.getInt(1)));
			resultSet.getInt(1);
		}
	}

    public int modify(String name, String description, Integer quantity, Integer id) {
        return 0;
    }

}
