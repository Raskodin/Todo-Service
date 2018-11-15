package com.ekomera.gox.todoservice.controllers.registration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ekomera.gox.todoservice.services.RegistrationService;

@WebServlet(urlPatterns = "/remove-user.do")
public class RemoveUserServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse respond) throws ServletException, IOException {

		if(RegistrationService.removeUserWithId(request.getParameter("userid"))) {
			request.getSession().invalidate();
			respond.sendRedirect("/login.do");
		}else {
			PrintWriter writer=respond.getWriter();
			writer.println("Something went wrong! Please reach your provider.");
			writer.close();
		}


	}
}
