package com.ekomera.gox.todoservice.database;
import java.util.ArrayList;
import java.util.HashMap;

import com.ekomera.gox.todoservice.exceptions.UserNotFoundException;
import com.ekomera.gox.todoservice.models.Todo;
import com.ekomera.gox.todoservice.models.User;



public final class OldTodoDataBase {
	private static HashMap<User, ArrayList<Todo>> todolistmap=new HashMap<User, ArrayList<Todo>>();

	public static void removeUserWithId(String id) {
		User user = new User(null);
		user.setId(id);
		todolistmap.remove(user);
	}

	public static void addNewUser(User user) {
		todolistmap.put(user, new ArrayList<Todo>());
	}

	public static ArrayList<Todo> getUsersList(String userid) throws UserNotFoundException{
		User user=new User(null);
		user.setId(userid);
		if(todolistmap.get(user)==null)
			throw new UserNotFoundException();

		return todolistmap.get(user);
	}


	public static void addTodoToUser(String userid, Todo todo) {
		User user=new User(null);
		user.setId(userid);
		todolistmap.get(user).add(todo);
	}

	public static Todo getTodoWithId(String userid,String todoid) {
		User user=new User(null);
		user.setId(userid);
		for(Todo todo: todolistmap.get(user)) {
			if(todo.getId().equals(todoid))
				return todo;
		}
		return null;
	}

	public static void updateTodoWithId( String userid, String todoid, String newname, String newcateg) {
		getTodoWithId(userid, todoid).setDescription(newname);
		getTodoWithId(userid, todoid).setCategory(newcateg);
	}

	public static void deleteTodoWithId(String userid, String todoid) {

		try {

			Todo todo=null;
			ArrayList<Todo> usersList = getUsersList(userid);
			for(Todo temp: usersList ) {
				if(temp.getId().equals(todoid)) {
					todo=temp;
					break;
				}
			}
			usersList.remove(todo);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
