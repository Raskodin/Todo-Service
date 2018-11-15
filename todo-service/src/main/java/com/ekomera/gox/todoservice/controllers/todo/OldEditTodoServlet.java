package com.ekomera.gox.todoservice.controllers.todo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ekomera.gox.todoservice.exceptions.UserNotFoundException;
import com.ekomera.gox.todoservice.models.Todo;
import com.ekomera.gox.todoservice.services.TodoService;

@WebServlet (urlPatterns="/old-edit-todo.do")
public class OldEditTodoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse respond) throws ServletException, IOException{
		String action=request.getParameter("action");
		String userid = (String)request.getSession().getAttribute("userid");
		if(action.equals("delete")) {
			TodoService.deleteTodoWithId(userid,request.getParameter("todoid"));
			respond.sendRedirect("list-todo.do");
		}else if(action.equals("add")){
			request.setAttribute("action", "add");
			request.getRequestDispatcher("/WEB-INF/views/old-add-todo.jsp").forward(request, respond);
		}else if(action.equals("edit")) {
			int todoid = Integer.valueOf(request.getParameter("todoid"));
			request.setAttribute("action", "edit");
			try {
				request.setAttribute("description", TodoService.retrieveTodos(userid).get(todoid).getDescription() );
				request.setAttribute("categ", TodoService.retrieveTodos(userid).get(todoid).getCategory());
			} catch (UserNotFoundException e) {

				e.printStackTrace();
			}

			request.setAttribute("todoid", todoid);
			request.getRequestDispatcher("/WEB-INF/views/old-add-todo.jsp").forward(request, respond);

		}


	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse respond) throws ServletException, IOException {
		String action=request.getParameter("action");
		String userid = (String)request.getSession().getAttribute("userid");
		if(action.equals("add")){
			TodoService.addTodoToUser(userid, (new Todo(request.getParameter("description"),request.getParameter("categ"))));

		}else if(action.equals("edit")) {
			if (request.getParameter("description").equals("")) {
				TodoService.deleteTodoWithId(userid,request.getParameter("todoid"));
			}else {
				TodoService.updateTodo(userid, request.getParameter("todoid"), request.getParameter("description"), request.getParameter("categ"));
			}
		}
		respond.sendRedirect("list-todo.do");
	}

}
