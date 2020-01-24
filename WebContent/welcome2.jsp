<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.io.File,java.io.IOException,java.util.*,java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Select the year</h2> <br>
<%
String email = (String)session.getAttribute("email");
if(email == null){
	request.getRequestDispatcher("error2.jsp").forward(request, response);
}
%>
<% 
File f = new File("C://Upload"); // current directory

File[] files = f.listFiles();
 for (File file : files) { 
    if (file.isDirectory()) {  
    	%>
      <a href="file:///<%=file.getAbsolutePath()%>" target="_blank"><br> <%=file.getName() %></a>
      <hr>
          <%
    } else {
        %>
        <a href="file:///<%=file.getAbsolutePath()%>" target="_blank"><br> <%=file.getName() %></a>
<hr>
    <%  
    } 
} 

 %>

<form action="<%=request.getContextPath() %>/student_login" method="post">
<input type="hidden" name="action" value="logout">
    <input type="submit" value="Logout" />
</form>

</body>
</html>