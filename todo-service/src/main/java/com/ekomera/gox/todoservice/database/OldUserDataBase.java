package com.ekomera.gox.todoservice.database;

import java.util.ArrayList;

import com.ekomera.gox.todoservice.models.User;

public final class OldUserDataBase {
	private static ArrayList<User> users = new ArrayList<>();

	public static void addNewUser(User user) {

		users.add(user);
	}

	public static boolean removeUserWithId(String id) {
		User user = new User(null);
		user.setId(id);
		return users.remove(user);
	}

	public static boolean isUsernameValid(String username) {
		for (User user : users) {
			if (user.getName().equals(username)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isUserValidWithId(String id) {
		User user = new User(null);
		user.setId(id);
		return users.contains(user);
	}

	//	public static void saveUserInfo(String id) {//deprecated
	//		User user = new User(null);
	//		user.setId(id);
	//		users.get(users.indexOf(user)).setList(TodoService.retrieveTodos());
	//	}

	public static User getUserWithId(String id) {
		User user = new User(null);
		user.setId(id);
		if (!isUserValidWithId(id)) {
			return null;
		}
		return users.get(users.indexOf(user));
	}

	public static User getUserWithUsername(String username) {
		for (User user : users) {
			if (user.getName().equals(username)) {
				return user;
			}
		}
		return null;
	}
}
