package com.ekomera.gox.todoservice.controllers.todo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ekomera.gox.todoservice.exceptions.UserNotFoundException;
import com.ekomera.gox.todoservice.services.TodoService;

@WebServlet (urlPatterns="/list-todo.do")
public class ListTodoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse respond) throws ServletException, IOException{

		System.out.println(request.getSession().getId());
		String userid = (String)request.getSession().getAttribute("userid");
		try {
			request.setAttribute("todos", TodoService.retrieveTodos(userid));
		} catch (UserNotFoundException e) {

			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/views/list-todos.jsp").forward(request, respond);
	}
}
