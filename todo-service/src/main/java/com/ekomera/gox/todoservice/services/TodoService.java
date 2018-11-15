package com.ekomera.gox.todoservice.services;

import java.util.ArrayList;

import com.ekomera.gox.todoservice.database.TodoDataBase;
import com.ekomera.gox.todoservice.exceptions.UserNotFoundException;
import com.ekomera.gox.todoservice.models.Todo;

public class TodoService {

	public static ArrayList<Todo> retrieveTodos(String userid) throws UserNotFoundException {

		return TodoDataBase.getUsersList(userid);

	}

	public static void addTodoToUser(String userid,Todo todo) {

		if(todo.getDescription() != null && !todo.getDescription().equals("")) {
			TodoDataBase.addTodoToUser(userid, todo);
		}

	}

	public static Todo getTodoWithId(String userid, String todoid) {

		return TodoDataBase.getTodoWithId(userid ,todoid);
	}

	/**
	 *
	 * @param newname
	 * @param newcateg
	 * @param id  The Id of the Todo which will be updated
	 */
	public static void updateTodo(String userid, String todoid, String newname, String newcateg) {

		TodoDataBase.updateTodoWithId(userid, todoid, newname, newcateg);

	}

	public static void deleteTodoWithId(String userid, String todoid) {

		TodoDataBase.deleteTodoWithId(userid,todoid);

	}
}
