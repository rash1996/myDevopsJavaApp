<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Purchase Success</title>
<style>
form {
	width: 750px;
    border: 3px inset Gainsboro ;
	margin: auto;	
}
img {
  width: 750px;
  height: 600px;
  margin: auto;
}
body {
  background-image: url("<url>");
  background-repeat: no-repeat;
  background-position: right bottom;
  background-attachment: fixed;
  background-color: Azure;
}
.topleft {
  position: absolute;
  top: 8px;
  left: 16px;
  font-size: 18px;
  padding:15px 25px;
}
.topright{
  position: absolute;
  top: 8px;
  right: 16px;
  font-size: 18px;
  padding:15px 25px;
}
</style>
<script type="text/javascript">
</script>

</head>
<body>
<%String sess[] = session.getValueNames();
String user = (String)session.getAttribute("uname");
%>
<div class="topleft">Hello <%=user%></div>
<a class="topright" title="Logout" href="logout.jsp">Logout</a>
<form>
<img src="https://www.picclickimg.com/d/l400/pict/152804039444_/24-Fall-Tree-Thank-You-For-Shopping-Favor.jpg">
	  
</form>
</body>
</html>