package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javacoderanch.Account2;
import com.model.Account;


public class student_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String action=request.getParameter("action");
if(action==null){
	request.setAttribute("email","");
	request.setAttribute("msg","");
	request.getRequestDispatcher("s_login.jsp").forward(request, response);                                                                                                               
	
}
else{
	doPost(request,response);
}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		PrintWriter out=response.getWriter();
		Boolean check=false;
		
		out.print(action);
		if(action.equals("newLogin")){
			request.setAttribute("email","");
			request.setAttribute("msg","");
			request.getRequestDispatcher("s_login.jsp").forward(request, response);
			
		}
		if(action.equals("logout")){
			request.getSession().invalidate();
			request.getRequestDispatcher("logout.jsp").forward(request, response);

			
		}
		
		
		if(action.equals("doLogin")){
			
			String email=request.getParameter("email");
			String password=request.getParameter("password");
		
			Account account=new Account();
			Account2 acc2=new Account2();
			try{
				String pass=acc2.newpass(password);
			check=account.logindbcheck(email,pass);
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
				request.getRequestDispatcher("welcome.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg","Incorrect Id or password");
			request.setAttribute("email","");
			request.getRequestDispatcher("s_login.jsp").forward(request, response);
			}
		}
		if(action.equals("doSignup")){
			request.setAttribute("msg1","");
			request.setAttribute("msg2","");
			request.setAttribute("msg3","");
			request.setAttribute("msg4","");
			request.setAttribute("msg5","");
			request.setAttribute("msg6","");
			request.setAttribute("msg7","");
			request.setAttribute("email","");
			request.setAttribute("name","");
		
			request.getRequestDispatcher("s_signnup.jsp").forward(request, response);
		}
			
			
			
		
		String email=request.getParameter("email");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String password_confirmation=request.getParameter("password_confirmation");
		String stream=request.getParameter("stream");
		String year=request.getParameter("year");
		Boolean check1=true,check2=true,check3=true,check4=true,check5=true,check6=true;
		if(action.equals("new_student")){
//			String email=request.getParameter("email");
	//		String name=request.getParameter("name");
		//	String password=request.getParameter("password");
			//String password_confirmation=request.getParameter("password_confirmation");
			//String stream=request.getParameter("stream");
			//String year=request.getParameter("year");
			if((name.equals(""))){
				request.setAttribute("msg1","Please enter your name");
				request.setAttribute("msg2","");
				request.setAttribute("msg3","");
				request.setAttribute("msg4","");
				request.setAttribute("msg5","");
				request.setAttribute("msg6","");
				request.setAttribute("msg7","");
				request.setAttribute("email",email);
				request.setAttribute("name","");
				check1=false;
				request.getRequestDispatcher("s_signnup.jsp").forward(request, response);
			}
			 String regx ="^[A-Z]{4,}(?: [a-zA-Z]+){0,2}$";
			    Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
			    Matcher matcher = pattern.matcher(name);
			    Boolean a=matcher.find();
			if(!(a)&&!(name.equals(""))){
				request.setAttribute("msg1","Please enter valid name");
				request.setAttribute("msg2","");
				request.setAttribute("msg3","");
				request.setAttribute("msg4","");
				request.setAttribute("msg5","");
				request.setAttribute("msg6","");
				request.setAttribute("msg7","");
				request.setAttribute("email",email);
				request.setAttribute("name","");
				check2=false;
				request.getRequestDispatcher("s_signnup.jsp").forward(request, response);
				
			}
			else{
				//String regx ="^[\\p{L} .'-]+$";
			    //Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
			    //Matcher matcher = pattern.matcher(name);
			    //Boolean a=matcher.find();
			
			if((email.equals("")&& check1&&check2&&check3&&check4&&check5&&check6)){
				
				request.setAttribute("name",name);
				request.setAttribute("email","");
				request.setAttribute("msg2","Please enter your email");
				request.setAttribute("msg1","");
				request.setAttribute("msg3","");
				request.setAttribute("msg4","");
				request.setAttribute("msg5","");
				request.setAttribute("msg6","");
				request.setAttribute("msg7","");
				check3=false;
				request.getRequestDispatcher("s_signnup.jsp").forward(request, response);
			}
			
					String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
					Boolean b = email.matches(EMAIL_REGEX);
					if(!b &&(!(email.equals("")))){
					request.setAttribute("name",name);
					request.setAttribute("email","");
					request.setAttribute("msg2","Please enter valid email");
					request.setAttribute("msg1","");
					request.setAttribute("msg3","");
					request.setAttribute("msg4","");
					request.setAttribute("msg5","");
					request.setAttribute("msg6","");
					request.setAttribute("msg7","");
					check4=false;
					request.getRequestDispatcher("s_signnup.jsp").forward(request, response);
					}
							
		    else{
		    	
			if((year.equals("false")&& check1&&check2&&check3&&check4&&check5&&check6)){
				request.setAttribute("msg3","Please select your year");
				request.setAttribute("msg1","");
				request.setAttribute("msg2","");
				request.setAttribute("msg4","");
				request.setAttribute("msg5","");
				request.setAttribute("msg6","");
				request.setAttribute("email",email);
				request.setAttribute("name",name);
				request.setAttribute("msg7","");
				request.getRequestDispatcher("s_signnup.jsp").forward(request, response);
			}
			else{
				if((stream.equals("false"))&& check1&&check2&&check3&&check4&&check5&&check6){
					request.setAttribute("msg4","Please select your stream");
					request.setAttribute("msg1","");
					request.setAttribute("msg2","");
					request.setAttribute("msg3","");
					request.setAttribute("msg5","");
					request.setAttribute("msg6","");
					request.setAttribute("email",email);
					request.setAttribute("name",name);
					request.setAttribute("msg7","");
					request.getRequestDispatcher("s_signnup.jsp").forward(request, response);
				}
				else
				{
			if((password.equals(""))&& check1&&check2&&check3&&check4&&check5&&check6){
				request.setAttribute("email",email);
				request.setAttribute("name",name);
				request.setAttribute("msg5","Please enter your password");
				request.setAttribute("msg1","");
				request.setAttribute("msg2","");
				request.setAttribute("msg3","");
				request.setAttribute("msg4","");
				request.setAttribute("msg6","");
				request.setAttribute("msg7","");
				check5=false;
				request.getRequestDispatcher("s_signnup.jsp").forward(request, response);
				}
					    String PASSWORD_PATTERN = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
				       	Boolean c=password.matches(PASSWORD_PATTERN);
						if(!c && !(password.equals(""))){
							request.setAttribute("name",name);
							request.setAttribute("email",email);
							request.setAttribute("msg2","");
							request.setAttribute("msg1","");
							request.setAttribute("msg3","");
							request.setAttribute("msg4","");
							request.setAttribute("msg5","Please enter a strong password");
							request.setAttribute("msg6","");
							request.setAttribute("msg7","");
							check6=false;
							request.getRequestDispatcher("s_signnup.jsp").forward(request, response);
							}
				
			else{
			
			
			if(!(password.equals(password_confirmation))&& check1&&check2&&check3&&check4&&check5&&check6){
				out.print("step4");
				request.setAttribute("email",email);
				request.setAttribute("name",name);
				request.setAttribute("msg6","Entered passwords does not match");
				request.setAttribute("msg1","");
				request.setAttribute("msg2","");
				request.setAttribute("msg3","");
				request.setAttribute("msg4","");
				request.setAttribute("msg5","");
				request.setAttribute("email",email);
				request.setAttribute("name",name);
				request.setAttribute("msg7","");
				request.getRequestDispatcher("s_signnup.jsp").forward(request, response);
			}
			//	String PASSWORD_PATTERN = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
				//Boolean c=password.matches(PASSWORD_PATTERN);
			
			/*	if(!c){
					request.setAttribute("name",name);
					request.setAttribute("email",email);
					request.setAttribute("msg2","");
					request.setAttribute("msg1","");
					request.setAttribute("msg3","");
					request.setAttribute("msg4","");
					request.setAttribute("msg5","Please should be alphanumeric and atleast of length 8");
					request.setAttribute("msg6","");
					request.setAttribute("msg7","");
					request.getRequestDispatcher("s_signnup.jsp").forward(request, response);
					
			}*/
			else{
				Account account=new Account();
				try{
				check=account.dbcheck(email);
				}
				catch(ClassNotFoundException e){
					out.print("Problem with driver");
				}
				catch(SQLException e){
					out.print("Query problem");
				}
		if(!check&&check1&&check2&&check3&&check4&&check5&&check6){
	//				HttpSession session=request.getSession();
				
			
			Account acc=new Account();
			Account2 acc2=new Account2();
			try {
			String epass=	acc2.newpass(password);
				acc.insert(name, email, epass,year,stream);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		request.getRequestDispatcher("reg-success.jsp").forward(request, response);	
			}
				else{
				if((check)&& check1&&check2&&check3&&check4&&check5)
				{
					request.setAttribute("msg7","Account already exists");
					request.setAttribute("email","");
					request.setAttribute("name","");
					request.setAttribute("msg6","");
					request.setAttribute("msg1","");
					request.setAttribute("msg2","");
					request.setAttribute("msg3","");
					request.setAttribute("msg4","");
					request.setAttribute("msg5","");
					request.getRequestDispatcher("s_signnup.jsp").forward(request, response);
				
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
}

