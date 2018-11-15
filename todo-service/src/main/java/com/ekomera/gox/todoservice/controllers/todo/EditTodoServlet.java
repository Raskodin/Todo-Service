package com.ekomera.gox.todoservice.controllers.todo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ekomera.gox.todoservice.services.TodoService;

@WebServlet(urlPatterns = "/edit-todo.do")
public class EditTodoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse respond) throws ServletException, IOException {
		String userid = (String)request.getSession().getAttribute("userid");
		String todoid = request.getParameter("todoid");
		request.setAttribute("description", TodoService.getTodoWithId(userid, todoid).getDescription());
		request.setAttribute("categ", TodoService.getTodoWithId(userid, todoid).getCategory());
		request.setAttribute("todoid", todoid);
		System.out.println(request.getSession().getId());
		request.getRequestDispatcher("/WEB-INF/views/edit-todo.jsp").forward(request, respond);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse respond)
			throws ServletException, IOException {
		System.out.println(request.getSession().getId());
		String userid = (String)request.getSession().getAttribute("userid");
		if (request.getParameter("description").equals("")) {
			TodoService.deleteTodoWithId(userid,request.getParameter("todoid"));
		} else {
			TodoService.updateTodo(userid,request.getParameter("todoid"), request.getParameter("description"), request.getParameter("categ"));
		}
		respond.sendRedirect("list-todo.do");
	}

}
