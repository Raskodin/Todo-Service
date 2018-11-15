package com.ekomera.gox.todoservice.services;

import com.ekomera.gox.todoservice.database.UserDataBase;
import com.ekomera.gox.todoservice.models.User;

public class LoginService {
	public static boolean isUserValid(String username, String pass) {
		User user=UserDataBase.getUserWithUsername(username);
		if(user==null)
			return false;

		if(pass.equals(user.getPassword())) {
			return true;
		}

		return false;
	}

	public static String getUserId(String username) {

		return UserDataBase.getUserWithUsername(username).getId();
	}
}
