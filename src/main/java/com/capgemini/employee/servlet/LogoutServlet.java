package com.capgemini.employee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		
		if(session != null) {
			session.invalidate();
		}
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h1> you are succefully logout!!</h1>");
			
		
		out.print("<html>");
		out.print("<body>");
		RequestDispatcher dispatcher= req.getRequestDispatcher("/login.html");
		dispatcher.include(req,resp);
	
		
	}
}
