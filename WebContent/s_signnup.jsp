<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>

	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
	<link rel="icon" type="image/png" href="assets/img/favicon.png">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Sign Up Page - Material Kit by Creative Tim</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />

	<!--     Fonts and icons     -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />

	<!-- CSS Files -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="assets/css/material-kit.css" rel="stylesheet"/>

</head>

<body class="signup-page">
	<nav class="navbar navbar-transparent navbar-absolute">
    	<div class="container">
        	<!-- Brand and toggle get grouped for better mobile display -->
        	<div class="navbar-header">
        		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example">
            		<span class="sr-only">Toggle navigation</span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
        		</button>
        		<a class="navbar-brand" href="http://www.creative-tim.com">Universal College Of Engineering</a>
        	</div>

        	<div class="collapse navbar-collapse" id="navigation-example">
        		<ul class="nav navbar-nav navbar-right">
					<li>
    					
    					<font color="white">	Opening Opportunities For You </font>
    					
    				
        		</ul>
        	</div>
    	</div>
    </nav>

    <div class="wrapper">
		<div class="header header-filter" style="background-image: url('assets/img/city.jpg'); background-size: cover; background-position: top center;">
			<div class="container">
				<div class="row">
					<div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">
						<div class="card card-signup">
							<form class="form"  action="<%=request.getContextPath()%>/student_login" method="post">
								<input type="hidden" value="new_student" name="action">
								<div class="header header-primary text-center">
									<h4>Welcome Student</h4>
									<div ><h5>
										Sign Up
									</h5></div>
								</div>
								
								<div class="content">

									<div class="input-group">
										<span class="input-group-addon">
											<i class="material-icons">face</i>
											
										</span>
										<font color="red"><%=request.getAttribute("msg7") %></font>
										<input type="text" class="form-control" placeholder="Full Name..." name="name" value="<%=request.getAttribute("name")%>">
										<font color="red"><%=request.getAttribute("msg1") %></font>
									</div>

									<div class="input-group">
										<span class="input-group-addon">
											<i class="material-icons">email</i>
										</span>
										<input type="text" class="form-control" placeholder="Email..." name="email" value="<%=request.getAttribute("email") %>">
										<font color="red"><%=request.getAttribute("msg2") %></font>
									</div>
									
					<div class="input-group">	
					<div class="radio">
					&nbsp;&nbsp;&nbsp;<b><h5>Select Year :-</h5></b>
	<label>
		<input type="radio" name="year" id="Second" value="Second">
		Second
	</label>
	<label>
		<input type="radio" name="year" id="Third" value="Third">
		Third
	</label>
	<label>
		<input type="radio" name="year" id="Fourth" value="Fourth">
		Fourth
	</label>
	<input type="hidden" name="year" value="false" />
</div>
<font color="red"><%=request.getAttribute("msg3") %></font>
<hr>
		<div class="input-group" >
					
<div class="radio" value="false">
<b><h5>Select Stream :-</h5></b>
	<label>
		<input type="radio" name="stream" id="IT" value="IT">
		IT
	</label>
	<label>
		<input type="radio" name="stream" id="Computer" value="Computer">
		Computer
	</label>
	<label>
		<input type="radio" name="stream" id="Civil" value="Civil"> 
		Civil
	</label>
	<label>
		<input type="radio" name="stream" id="Extc" value="Extc">
		Extc
	</label>
	<label>
		<input type="radio" name="stream" id="Etrx">
		Etrx
	</label>
	<input type="hidden" name="stream" value="false" />
</div>
<font color="red"><%=request.getAttribute("msg4") %></font>
</div>
									
									
									<div class="input-group">
										<span class="input-group-addon">
											<i class="material-icons">lock_outline</i>
										</span>
										<input type="password" placeholder="Password..." class="form-control" name="password" />
										<small>Min 8 characters at least 1 Alphabet and 1 Number</small> 
									</div>
									<font color="red"><%=request.getAttribute("msg5") %></font>
										<div class="input-group">
										<span class="input-group-addon">
											<i class="material-icons">lock_outline</i>
										</span>
										<input type="password" placeholder="Confirm Password..." class="form-control" name="password_confirmation"/>
									</div>
                                    <font color="red"><%=request.getAttribute("msg6") %></font>
									<!-- If you want to add a checkbox to this form, uncomment this code

									<div class="checkbox">
										<label>
											<input type="checkbox" name="optionsCheckboxes" checked>
											Subscribe to newsletter
										</label>
									</div> -->
								</div>
								<div class="footer text-center">
									<input type="submit" class="btn btn-simple btn-primary btn-lg" value="register">
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>

					<div class="copyright pull-right">
		                &copy; 2017
		            </div>
		        </div>
		    </footer>

		</div>

    </div>


</body>
	<!--   Core JS Files   -->
	<script src="assets/js/jquery.min.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="assets/js/material.min.js"></script>

	<!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
	<script src="assets/js/nouislider.min.js" type="text/javascript"></script>

	<!--  Plugin for the Datepicker, full documentation here: http://www.eyecon.ro/bootstrap-datepicker/ -->
	<script src="assets/js/bootstrap-datepicker.js" type="text/javascript"></script>

	<!-- Control Center for Material Kit: activating the ripples, parallax effects, scripts from the example pages etc -->
	<script src="assets/js/material-kit.js" type="text/javascript"></script>

</html>