package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Controllerr extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	
	
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String action=request.getParameter("action");
if(action==null){
	request.setAttribute("email",null);
	request.setAttribute("msg1", null);
	request.setAttribute("msg2", null);
	request.getRequestDispatcher("index.jsp").forward(request, response);
}
else{
	doPost(request,response);
}

	 request.getRequestDispatcher("index.jsp").forward(request, response);
 }

	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String action=request.getParameter("action");
	if(action=="form1"){
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		if(id=="Dinesh" && password=="random12345"){
			
		request.getRequestDispatcher("welcome.jsp");
		}
		else{
			if(id!="Dinesh"){
				request.setAttribute("msg1","Please enter a valid id");
				request.setAttribute("id", id);
				request.setAttribute("msg2", null);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			if(password!="random12345"){
				request.setAttribute("msg2","Please enter a correct password");
				request.setAttribute("id", id);
				request.setAttribute("msg1",null);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
				
		}
		
	}
	
	
	}

}
