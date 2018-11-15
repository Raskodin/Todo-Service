package com.ekomera.gox.todoservice.services;

import java.util.ArrayList;
import com.ekomera.gox.todoservice.models.Todo;

public class OldTodoService {

	private static ArrayList<Todo> todolist = new ArrayList<Todo>();

	public static void newList(ArrayList<Todo> list) {
		todolist=list;

	}

	public static ArrayList<Todo> retrieveTodos() {

		return todolist;

	}

	public static void addTodo(Todo todo) {

		if(todo.getDescription() != null && !todo.getDescription().equals("")) {
			todolist.add(todo);
		}

	}
	public static Todo getTodoWithId(String id) {

		for(Todo todo:todolist) {
			if(todo.getId().equals(id)) {
				return todo;
			}
		}
		return null;
	}
	/**
	 *
	 * @param newname
	 * @param newcateg
	 * @param id  The Id of the Todo which will be updated
	 */
	public static void updateTodo(String newname, String newcateg, String id) {

		getTodoWithId(id).setDescription(newname);
		getTodoWithId(id).setCategory(newcateg);

	}

	public static void deleteTodoWithId(String id) {

		todolist.remove(getTodoWithId(id));

	}
}
