package com.ekomera.gox.todoservice.controllers.loginoper;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ekomera.gox.todoservice.services.LoginService;

@WebServlet (urlPatterns="/login.do")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		System.out.println(request.getSession().getId());
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		System.out.println(request.getSession().getId());
		String name = request.getParameter("username");
		String key= request.getParameter("key");

		if(LoginService.isUserValid(name, key)) {
			request.getSession().setAttribute("username", name);
			request.getSession().setAttribute("userid", LoginService.getUserId(name) );
			request.getSession().setAttribute("isloggedin","yes");
			response.sendRedirect("/list-todo.do");
		}else {

			request.setAttribute("errorMessage" ,"Wrong Identicals!");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}



	}
}
