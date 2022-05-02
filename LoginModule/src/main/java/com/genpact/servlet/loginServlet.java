package com.genpact.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.genpact.service.Service;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		
		System.out.println(uname);
		System.out.println(upass);
		
		String registerMessage = Service.loginUser(uname, upass);
		
		System.out.println(registerMessage);
		
		
		if(registerMessage.equals("EXISTED")) {
			String message = "Login Sucessfull";
			request.setAttribute("message", message);
			request.setAttribute("uname",uname);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("dash.jsp");
			requestDispatcher.forward(request, response);
			
			
		}else if(registerMessage.equals("NOT EXISTED")) {
			String message = "User Registered...";
			request.setAttribute("message", message);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.include(request, response);
		}
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
