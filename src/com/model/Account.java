package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.beans.Student;

public class Account {
	private String email;
	private String password; //user Password
	private String username="root"; //DB username -default
	//private String passwd = "RBQpmy33601"; //DB password
	private String passwd = "";
	private String dbname="tpo"; //DB name
	private String url="jdbc:mysql://localhost:3306/"; //DB URL -- default
	//private String url="https://mysql28413-tpoportal.cloud.cms500.com";
	private String driver = "com.mysql.jdbc.Driver"; //Driver location 
	private Connection con;
	private String sql;
	PreparedStatement stmt;

	public boolean logindbcheck(String email,String password) throws ClassNotFoundException, SQLException{
		int count=0;
		this.email=email;
		this.password=password;
		dbConnect();
		sql="select count(*) as count from users where email = ? AND password = ?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, this.email);
		pstmt.setString(2, this.password);
		
		ResultSet rst=pstmt.executeQuery();
		if(rst.next()){
			count=rst.getInt("count");
		}
		rst.close();
		pstmt.close();
		
		if(count == 0)
		return false;
		else
		return true;
		
	}

	public boolean s_logindbcheck(String email,String password) throws ClassNotFoundException, SQLException{
		int count=0;
		this.email=email;
		this.password=password;
		dbConnect();
		sql="select count(*) as count from admin where email = ? AND password = ?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, this.email);
		pstmt.setString(2, this.password);
		
		ResultSet rst=pstmt.executeQuery();
		if(rst.next()){
			count=rst.getInt("count");
		}
		rst.close();
		pstmt.close();
		
		if(count == 0)
		return false;
		else
		return true;
		
	}


	
	
	
	public boolean dbcheck(String email) throws ClassNotFoundException, SQLException{
		int count=0;
		this.email=email;
		dbConnect();
		sql="select count(*) as count from users where email = ?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, this.email);
		
		ResultSet rst=pstmt.executeQuery();
		if(rst.next()){
			count=rst.getInt("count");
		}
		rst.close();
		pstmt.close();
		
		if(count == 0)
		return false;
		else
		return true;
		
	}
	
	
	public boolean admincheck(String email) throws ClassNotFoundException, SQLException{
		int count=0;
		this.email=email;
		dbConnect();
		sql="select count(*) as count from admin where email = ?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, this.email);
		
		ResultSet rst=pstmt.executeQuery();
		if(rst.next()){
			count=rst.getInt("count");
		}
		rst.close();
		pstmt.close();
		
		if(count == 0)
		return false;
		else
		return true;
		
	}
	
	public void insert(String name,String email,String password,String year,String stream) throws ClassNotFoundException, SQLException{
		dbConnect();
		String sql="insert into users(name,email,password,year,stream) values (?,?,?,?,?)";
		stmt=con.prepareStatement(sql); 
		stmt.setString(1, name);
		stmt.setString(2, email);
		stmt.setString(3, password);
		stmt.setString(4, year);
		stmt.setString(5, stream);
		
		stmt.executeUpdate();
		dbClose();
	}
	
	
	public void admin_insert(String email,String password) throws ClassNotFoundException, SQLException{
		dbConnect();
		String sql="insert into admin(email,password) values (?,?)";
		stmt=con.prepareStatement(sql); 
		stmt.setString(1, email);
		stmt.setString(2, password);
		stmt.executeUpdate();
		dbClose();
	}

	
	public Student fetchStudent(String email) throws Exception{
		dbConnect();
		int count = 0;
		String sql ="select * from users where email = ?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, email);
					
		ResultSet rst = pstmt.executeQuery(); 
		Student s = new Student();
		while(rst.next()){
			count = 1;
			s.setName(rst.getString("name"));
			s.setEmail(email);
			s.setYear(rst.getString("year"));
	        s.setStream(rst.getString("stream"));
				
		}
		rst.close();
		pstmt.close();
		if(count == 0){
			return null;
		}
		dbClose();
		return s;
	}
	private void dbConnect() throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		con = DriverManager.getConnection(url+dbname,username,passwd);
		
	}
	public void dbClose() throws SQLException {
		con.close();
	}
}

