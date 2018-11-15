package com.ekomera.gox.todoservice.database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.ekomera.gox.todoservice.models.User;

public final class UserDataBase {

	private static Connection connect = null;

	static {

		try {

			connect = DatabaseConnector.getConnection();
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

	public static void addNewUser(User user) {

		try {
			CallableStatement statement = connect.prepareCall("{Call add_new_user(?, ?, ?)}");
			statement.setString(1, user.getId());
			statement.setString(2, user.getName());
			statement.setString(3, user.getPassword());
			statement.execute();
			statement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean removeUserWithId(String id) {
		boolean result = false;
		try {
			CallableStatement statement = connect.prepareCall("{Call remove_user_with_id(?)}");
			statement.setString(1, id);
			statement.execute();
			statement.close();
			result=true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static boolean isUsernameValid(String username) {
		boolean result = false;
		try {
			CallableStatement statement = connect.prepareCall("{Call is_username_taken(?,?)}");
			statement.setString(1, username);
			statement.registerOutParameter(2, java.sql.Types.CHAR);
			statement.execute();
			if (statement.getString(2) != null && statement.getString(2).equals("1"))
				result = true;
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static boolean isUserValidWithId(String id) {
		boolean result = false;
		try {
			CallableStatement statement = connect.prepareCall("{Call is_userid_taken(?,?)}");
			statement.setString(1, id);
			statement.registerOutParameter(2, java.sql.Types.CHAR);
			statement.execute();
			if (statement.getString(2) != null && statement.getString(2).equals("1"))
				result = true;
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static User getUserWithId(String id) {

		User user = null;
		try {
			PreparedStatement statement = connect
					.prepareStatement("select*from todo_service_db.users where userid=? ;");
			statement.setString(1, id);
			ResultSet resultset = statement.executeQuery();

			if (resultset.next()) {
				user = new User(resultset.getString(2));
				user.setId(id);
				user.setPassword(resultset.getString(3));
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public static User getUserWithUsername(String username) {
		User user = null;
		try {
			PreparedStatement statement = connect
					.prepareStatement("select*from todo_service_db.users where username=? ;");
			statement.setString(1, username);
			ResultSet resultset = statement.executeQuery();

			if (resultset.next()) {
				user = new User(resultset.getString(2));
				user.setId(resultset.getString(1));
				user.setPassword(resultset.getString(3));
			}
			statement.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return user;
	}
}
