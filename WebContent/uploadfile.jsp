<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>WELCOME TO RESUME RANKER</h1>
<h4>--Making sorting easy--</h4>

  <br>
  <br>
<form method="post" action="<%=request.getContextPath() %>/Uploader" enctype="multipart/form-data">

<input type="file" name="file" >
<input type="submit" name="submit" value="Upload" >
</form>
</body>

</html>
