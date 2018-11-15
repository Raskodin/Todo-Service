package com.ekomera.gox.todoservice.controllers.todo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ekomera.gox.todoservice.models.Todo;
import com.ekomera.gox.todoservice.services.TodoService;

@WebServlet(urlPatterns = "/add-todo.do")
public class AddTodoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse respond) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/add-todo.jsp").forward(request, respond);
		System.out.println(request.getSession().getId());

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse respond)
			throws ServletException, IOException {
		String userid = (String)request.getSession().getAttribute("userid");
		TodoService.addTodoToUser(userid,new Todo(request.getParameter("todo"), request.getParameter("categ")));
		System.out.println(request.getSession().getId());
		respond.sendRedirect("list-todo.do");
	}

}
