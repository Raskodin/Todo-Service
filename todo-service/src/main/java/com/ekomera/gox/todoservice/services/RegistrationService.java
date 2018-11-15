package com.ekomera.gox.todoservice.services;

import com.ekomera.gox.todoservice.database.UserDataBase;
import com.ekomera.gox.todoservice.models.User;

public class RegistrationService {
	public static boolean addNewUser(String username, String password) {
		if(UserDataBase.isUsernameValid(username))
			return false;

		User user = new User(username);
		while (UserDataBase.isUserValidWithId(user.getId())) {
			user = new User(username);
		}
		user.setPassword(password);

		UserDataBase.addNewUser(user);
		//		TodoDataBase.addNewUser(user);

		return true;
	}

	public static boolean removeUserWithId(String id) {

		//		TodoDataBase.removeUserWithId(id);
		return UserDataBase.removeUserWithId(id);

	}
}
