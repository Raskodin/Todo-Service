package com.ekomera.gox.todoservice.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseConnector {
	static final String DB_URL = "jdbc:mysql://localhost:3306/todo_service_db";

	static final String USER = "firstadmin";
	static final String PASS = "Admin.password";

	private static Connection connect = null;

	static {

		try {

			connect = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("connected to database todo");


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static Connection getConnection(){
		return connect;
	}
	static void reconnect() {
		try {
			connect.close();
			connect=DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
