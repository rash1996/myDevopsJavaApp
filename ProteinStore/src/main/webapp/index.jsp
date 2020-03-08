<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>
form {
	width: 750px;
    	border: 3px inset Gainsboro ;
	margin: auto;	
}
h1 {
	font-size: 50px;
	text-align: center;
	text-shadow: 3px 2px BurlyWood ;
}
input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px groove Beige;
    box-sizing: border-box;
}
button {
    background-color: #4CAF50 ;
    color: Beige;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}
button:hover {
	background-color: #45a049 ;
    	opacity: 0.8;
}
.container {
background-color: #f2f2f2;
    padding: 25px;

}
body {
  background-image: url("https://guardian.ng/wp-content/uploads/2017/10/protein-1.jpg");
  background-repeat: no-repeat;
  background-position: right bottom;
  background-attachment: fixed;
background-color: Azure;
}
span.psw {
    float: right;
}
/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
}
</style>

<script type="text/javascript">
</script>

</head>
<body>

<div class="Left">
	<h1>Protein Store</h1>
	<form action="Login" method="post">
	  <div class="container" >
	    <label><b>UserName</b></label>
	    <input type="text" placeholder="Enter UserName" name="uName" id="uName" required>
	
	    <label><b>Password</b></label>
	    <input type="password" placeholder="Enter Password" name="password" id="password" required>
	        
	    <button type="submit">LOGIN</button>
	  </div>
	
	  <div class="container" style="background-color:#f1f1f1">
	    <span class="psw"><a href="forgotpassword.jsp">Forgot password?</a>&nbsp &nbsp <a href="register.jsp" id="register">New User ?</a> </span>
	  </div>
</form>
</div>
</body>
</html>
