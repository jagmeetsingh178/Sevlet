package com.jspider.jdbc_prepared_statement_crud_operation.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProductConnection {
	public static Connection getProductConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			return DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-a3", "root", "jaggi@74041313");

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
			return null;
		}
	}
}
