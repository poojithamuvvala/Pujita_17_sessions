package com.capgemini.employee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.employee.dto.EmployeeBean;
import com.capgemini.employee.services.EmployeeService;
import com.capgemini.employee.services.EmployeeServiceImple;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	EmployeeService service=new EmployeeServiceImple();
       @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String id=req.getParameter("id");
    	String password=req.getParameter("pwd");
    	EmployeeBean bean=service.authenticate(Integer.parseInt(id), password);
    	
    	PrintWriter out=resp.getWriter();
        out.println("<html>");
    	out.println("<head>");
    	out.println("</head>");
    	out.println("<body>");
    	out.println("<h1>");
        if(bean!=null) {
    		HttpSession session=req.getSession(true);
    		session.setAttribute("LoggedEmployee", bean);
    		RequestDispatcher dispatcher=req.getRequestDispatcher("/home.html");
    		dispatcher.include(req, resp);
    	}
    	else {
    		out.println("<h1>Invalid Credentials!!!</h1>");
    		RequestDispatcher dispatcher=req.getRequestDispatcher("/login.html");
    		dispatcher.include(req, resp);
    	}
        
    					
        out.println("</h1>"); 
        RequestDispatcher dispatcher=req.getRequestDispatcher("/Home.html");
        dispatcher.include(req, resp);
    	out.println("</body>");
    	out.println("</html>");
    	
    }
}
