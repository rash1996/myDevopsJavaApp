<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<style>
form {
    border: 3px inset #f1f1f1;
	width: 75%;
	margin: auto;
}
h1 {
	font-size:35px;
	text-align: center;
	text-shadow: 3px 2px LightGoldenRodYellow ;
}
input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: 2px;
    cursor: pointer;
    width: 100%;

}

button:hover {
	background-color: #45a049 ;
    opacity: 0.8;
}

.container {
background-color: #f2f2f2;
    padding: 16px;
}

body {
  background-image: url("https://cdn1.sph.harvard.edu/wp-content/uploads/sites/30/2018/11/shutterstock_723278326-1200x882.jpg");
  background-repeat: no-repeat;
  background-position: right bottom;
  background-attachment: fixed;
background-color: Azure;
}

span.psw {
    float: right;
    padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
}
</style>
</head>
<body>
	<h1>Registration Form</h1>
	<form action="Register" method="post">
	  <div class="container">
	    
		<label><b>First Name</b></label>
	    <input type="text" placeholder="Enter First Name" name="firstname" required>
	    
	    <label><b>Last Name</b></label>
	    <input type="text" placeholder="Enter Last Name" name="lastname" required>

		<label><b>User Name</b></label>
	    <input type="text" placeholder="Enter Login User Name" name="uName" required>
	    
	    <label><b>Password</b></label>
	    <input type="password" placeholder="Enter Password" name="pass" required>
	    
	    <label><b>Confirm Password</b></label>
	    <input type="password" placeholder="Enter Confirm Password" name="confirmpass" required>
	    
	    <label><b>Email</b></label>
	    <input type="text" placeholder="Enter Email" name="email" required>        
	    <button type="submit">Register</button>
	  </div>
</form>
</body>
</html>