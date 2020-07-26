package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.*;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javacoderanch.Account2;
import com.model.Account;
/**
 * Servlet implementation class Myy
 */
public class Myy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action==null){
			request.setAttribute("email","");
			request.setAttribute("msg","");
			request.getRequestDispatcher("index2.jsp").forward(request,response);
		}
		else{
			doPost(request,response);
		}



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		PrintWriter out=response.getWriter();
		Boolean check=null;
		if(action.equals("newLogin")){
			request.setAttribute("email","");
			request.setAttribute("msg","");
			request.getRequestDispatcher("index2.jsp").forward(request, response);
			
		}
		
		if(action.equals("logout")){
			request.getSession().invalidate();
			request.getRequestDispatcher("logout2.jsp").forward(request, response);

			
		}	
if(action.equals("doLogin")){
			
			String email=request.getParameter("email");
			String password=request.getParameter("password");
		
			Account account=new Account();
			Account2 acc2=new Account2();
			try{
				String pass=acc2.newpass(password);
			check=account.s_logindbcheck(email,pass);
			}
			catch(ClassNotFoundException e){
				out.print("Problem with driver");
			}
			catch(SQLException e){
				out.print("Query problem");
			}
			if(check){
				HttpSession session=request.getSession();
				session.setAttribute("email",email);
				request.getRequestDispatcher("welcome2.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg","Incorrect Id or password");
			request.setAttribute("email","");
			request.getRequestDispatcher("index2.jsp").forward(request, response);
			}
		}
		
		
				if((action.equals("doSignup"))){
					request.setAttribute("msg1","");
					request.setAttribute("msg2","");
					request.setAttribute("msg3","");
					request.setAttribute("msg4","");
					request.setAttribute("msg5","");
					request.setAttribute("email","");
					
					request.getRequestDispatcher("a_signup.jsp").forward(request, response);
				}
				
					if(action.equals("new_admin")){
						String s_pass=request.getParameter("s_pass");
						String email=request.getParameter("email");
						String password=request.getParameter("password");
						String password_confirmation=request.getParameter("password_confirmation");
						if((email.equals(""))){
							request.setAttribute("email","");
							request.setAttribute("msg1","Please enter your email");
							request.setAttribute("msg2","");
							request.setAttribute("msg3","");
							request.setAttribute("msg4","");
							request.setAttribute("msg5","");
							request.getRequestDispatcher("a_signup.jsp").forward(request, response);
						}
						
								/*String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
								Boolean b = email.matches(EMAIL_REGEX);
								if(!b){
								request.setAttribute("email","");
								request.setAttribute("msg2","Please enter valid email");
								request.setAttribute("msg1","");
								request.setAttribute("msg3","");
								request.setAttribute("msg4","");
								request.setAttribute("msg5","");
								request.getRequestDispatcher("a_signnup.jsp").forward(request, response);
								} */
								else{
									if((s_pass.equals(""))){
										
										request.setAttribute("email",email);
										request.setAttribute("msg2","Please enter Security Password");
										request.setAttribute("msg1","");
										request.setAttribute("msg3","");
										request.setAttribute("msg4","");
										request.setAttribute("msg5","");
										request.getRequestDispatcher("a_signup.jsp").forward(request, response);
									}
									else{
										if(!(s_pass.equals("admin090"))){
											request.setAttribute("email",email);
											request.setAttribute("msg2","Invalid Security Password");
											request.setAttribute("msg1","");
											request.setAttribute("msg3","");
											request.setAttribute("msg4","");
											request.setAttribute("msg5","");
											request.getRequestDispatcher("a_signup.jsp").forward(request, response);
										
											
										}
										else{
											if((password.equals(""))){
												request.setAttribute("email",email);
												request.setAttribute("msg3","Please enter your password");
												request.setAttribute("msg1","");
												request.setAttribute("msg2","");
												request.setAttribute("msg4","");
												request.setAttribute("msg5","");
												request.getRequestDispatcher("a_signup.jsp").forward(request, response);
												}
											else{
												if(!(password.equals(password_confirmation))){
													request.setAttribute("email",email);
													request.setAttribute("msg4","Entered passwords does not match");
													request.setAttribute("msg1","");
													request.setAttribute("msg2","");
													request.setAttribute("msg3","");
													request.setAttribute("msg5","");
													request.getRequestDispatcher("a_signup.jsp").forward(request, response);
												}
												else{
													Account account=new Account();
													try{
													check=account.admincheck(email);
													}
													catch(ClassNotFoundException e){
														out.print("Problem with driver");
													}
													catch(SQLException e){
														out.print("Query problem");
													}
												
												if(!check){
													//				HttpSession session=request.getSession();
																
															
															Account acc=new Account();
															Account2 acc2=new Account2();
															try {
															String epass=	acc2.newpass(password);
																acc.admin_insert(email,epass);
															} catch (ClassNotFoundException e) {
																// TODO Auto-generated catch block
																e.printStackTrace();
															} catch (SQLException e) {
																// TODO Auto-generated catch block
																e.printStackTrace();
															}
														request.getRequestDispatcher("a_regsuccess.jsp").forward(request, response);	
															}
												else{
													
														if(check)
														{
															request.setAttribute("msg5","Account already exists");
															request.setAttribute("email","");
															request.setAttribute("msg1","");
															request.setAttribute("msg2","");
															request.setAttribute("msg3","");
															request.setAttribute("msg4","");
															request.getRequestDispatcher("a_signup.jsp").forward(request, response);
														
														}
											
												}

												
											}
										}
									}
								}
						
					}
				
				}	
			}
			
		}
