<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<style>
body,h1 {font-family: "Raleway", sans-serif}
body, html {height: 100%}
.bgimg {
    background-image: url("15.jpg");
    min-height: 100%;
    background-position: center;
    background-size: cover;
    
}
</style>
<body>

<div class="bgimg w3-display-container w3-animate-opacity w3-text-black">
  <div class="w3-display-topleft w3-padding-large w3-xlarge w3-padding-24">
   <u>UCOE</u>
  </div>
  <h1 class="w3-xxxlarge w3-animate-top w3-center w3-padding-16 "><i><u>Welcome</u> <u>to</u> <u>TPO</u> <u>Portal</u></i></h1>
  <div class="w3-display-middle">
 <h3 class="w3-hover-opacity w3-xlarge w3-left w3-padding-24 w3-margin-center "> <a href="<%=request.getContextPath() %>/student_login">Click here for Student login/signup</a></h3>

  
    <hr class="w3-border-grey" style="margin:auto;width:40%">
<h3 class="w3-hover-opacity w3-padding-24 w3-xlarge w3-margin-center"> <a href="<%=request.getContextPath() %>/Myy">Click here for TPO login</a></h3>

  </div>
  <div class="w3-display-bottomleft w3-padding-large">
     <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">@2017</a>
  </div>
</div>

</body>
</html>
