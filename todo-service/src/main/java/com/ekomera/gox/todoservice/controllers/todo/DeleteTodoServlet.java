package com.ekomera.gox.todoservice.controllers.todo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ekomera.gox.todoservice.services.TodoService;

@WebServlet (urlPatterns="/delete-todo.do")
public class DeleteTodoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse respond) throws ServletException, IOException{
		String userid = (String)request.getSession().getAttribute("userid");
		TodoService.deleteTodoWithId(userid, request.getParameter("todoid"));
		System.out.println(request.getSession().getId());
		respond.sendRedirect("list-todo.do");

	}



}
