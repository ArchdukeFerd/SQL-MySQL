package src.main.java.com.alura.jdbc.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import src.main.java.com.alura.jdbc.ConnectionLink;

public class ProductController {

	public void modify(String Name, String Description, Integer Id) {
		// TODO
	}

	public void delete(Integer Id) {
		// TODO
	}

	public List<Map<String, String>> list() throws SQLException{
		Connection con = new ConnectionLink().retrieveConnection();
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

    public void save(Object Product) {
		// TODO
	}

}
