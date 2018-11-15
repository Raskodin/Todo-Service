package com.ekomera.gox.todoservice.database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.ekomera.gox.todoservice.exceptions.UserNotFoundException;
import com.ekomera.gox.todoservice.models.Todo;

public final class TodoDataBase {

	private static Connection connect = null;

	static {

		try {

			//			Class.forName(JDBC_DRIVER);
			connect = DatabaseConnector.getConnection();

			// Statement statement=connect.createStatement();
			// ResultSet resultset=statement.executeQuery("select*from
			// todo_service_db.users");
			// while (resultset.next()) {
			// // It is possible to get the columns via name
			// // also possible to get the columns via the column number
			// // which starts at 1
			// // e.g. resultSet.getSTring(2);
			// String userid = resultset.getString("UserID");
			// String username = resultset.getString("username");
			// String password = resultset.getString("password");
			//
			// System.out.println("User: " + userid);
			// System.out.println("name: " + username);
			// System.out.println("pass: " + password);
			//
			// }

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<Todo> getUsersList(String userid) throws UserNotFoundException {
		ArrayList<Todo> list = new ArrayList<Todo>();

		try {
			PreparedStatement statement = connect.prepareStatement("Select * from todo_list where userid=? ;");
			statement.setString(1, userid);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				Todo todo = new Todo(resultset.getString(2), resultset.getString(3));
				todo.setId(resultset.getString(1));
				list.add(todo);
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	public static void addTodoToUser(String userid, Todo todo) {
		try {
			CallableStatement statement = connect.prepareCall("{Call add_todo_to_user(?, ?, ?, ?)}");
			statement.setString(1, userid);
			statement.setString(2, todo.getId());
			statement.setString(3, todo.getDescription());
			statement.setString(4, todo.getCategory());
			statement.execute();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Todo getTodoWithId(String userid, String todoid) {
		Todo todo = null;
		try {
			PreparedStatement statement = connect.prepareStatement(" select * from todo_service_db.todo_list where userid=? and todoid=? ;");
			statement.setString(1, userid);
			statement.setString(2, todoid);
			ResultSet resultset = statement.executeQuery();

			if (resultset.next()) {
				todo = new Todo(resultset.getString(2), resultset.getString(3));
				todo.setId(resultset.getString(1));
			}
			statement.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return todo;
	}

	public static void updateTodoWithId(String userid, String todoid, String newdesc, String newcateg) {
		try {
			CallableStatement statement = connect.prepareCall("{Call update_todo(? , ? , ? , ? )}");
			statement.setString(1, userid);
			statement.setString(2, todoid);
			statement.setString(3, newdesc);
			statement.setString(4, newcateg);
			statement.execute();

			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void deleteTodoWithId(String userid, String todoid) {

		try {
			CallableStatement statement = connect.prepareCall("{Call remove_todo(? , ? )}");
			statement.setString(1, userid);
			statement.setString(2, todoid);

			statement.execute();

			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
