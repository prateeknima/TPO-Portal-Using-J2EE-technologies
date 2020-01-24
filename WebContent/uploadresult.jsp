<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<div id="result">
       <h3><%=request.getAttribute("message") %></h3>
<a href="welcome.jsp">Click here to upload again</a>
        </div>
        <br>
<br>
<form action="<%=request.getContextPath() %>/student_login" method="post">
<input type="hidden" name="action" value="logout">
    <input type="submit" value="Logout" />
</form>
        
</body>
</html>