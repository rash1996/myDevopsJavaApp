<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="devops.obs.model.Order, java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Checkout</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
  font-family: Arial;
  font-size: 17px;
  padding: 8px;
background-color: Azure;
}
* {
  box-sizing: border-box;
}
.row {
  display: -ms-flexbox; /* IE10 */
  display: flex;
  -ms-flex-wrap: wrap; /* IE10 */
  flex-wrap: wrap;
  margin: 0 -16px;
}
.col-25 {
  -ms-flex: 25%; /* IE10 */
  flex: 25%;
}
.col-50 {
  -ms-flex: 50%; /* IE10 */
  flex: 50%;
}
.col-75 {
  -ms-flex: 75%; /* IE10 */
  flex: 75%;
}
.col-25,
.col-50,
.col-75 {
  padding: 0 16px;
}
.container {
  background-color: #f2f2f2;
  padding: 5px 20px 15px 20px;
  border: 1px solid lightgrey;
  border-radius: 3px;
}
input[type=text] {
  width: 100%;
  margin-bottom: 20px;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 3px;
}
label {
  margin-bottom: 10px;
  display: block;
}
.icon-container {
  margin-bottom: 20px;
  padding: 7px 0;
  font-size: 24px;
}
.btn {
  background-color: #4CAF50;
  color: white;
  padding: 12px;
  margin: 10px 0;
  border: none;
  width: 100%;
  border-radius: 3px;
  cursor: pointer;
  font-size: 17px;
}
.btn:hover {
  background-color: #45a049;
}
a {
  color: #2196F3;
}
hr {
  border: 1px solid lightgrey;
}
span.price {
  float: right;
  color: grey;
}
@media (max-width: 800px) {
  .row {
    flex-direction: column-reverse;
  }
  .col-25 {
    margin-bottom: 20px;
  }
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

<h1 style="text-align:center;text-shadow:3px 2px Cornsilk;font-size:35px;">Checkout Page</h1>
<%String sess[] = session.getValueNames();
String user = (String)session.getAttribute("uname");
%>

<div class="row">
  <div class="col-75">
    <div class="container">
      <form action="/action_page.php">
      
        <div class="row">
          <div class="col-50">
            <h3>Billing Address</h3>
            <label for="fname"><i class="fa fa-user"></i> Full Name</label>
            <input type="text" id="fname" name="firstname" placeholder="P. Mathuraa">
            <label for="email"><i class="fa fa-envelope"></i> Email</label>
            <input type="text" id="email" name="email" placeholder="pmathuraa@example.com">
            <label for="adr"><i class="fa fa-address-card-o"></i> Address</label>
            <input type="text" id="adr" name="address" placeholder="124A, Schollingannaur">

            <div class="row">
              <div class="col-50">
                <label for="state">State</label>
                <input type="text" id="state" name="state" placeholder="Tamil Nadu">
              </div>
              <div class="col-50">
                <label for="zip">Zip</label>
                <input type="text" id="zip" name="zip" placeholder="600119">
              </div>
            </div>
          </div>

          <div class="col-50">
            <h3 style="margin:28px 3px">Payment</h3>
            <label>Only Cash on delivery (COD) is available</label>
	    <img src="https://regal-software.com/site/gallery/news/shutterstock_219004666_1024x768_0.jpg" style="width:300px;height:200px;margin-top:20px">
	
      </div>
      
          
        </div>
        <label>
          <input type="checkbox" checked="checked" name="sameadr"> Shipping address same as billing
        </label>
      </form>
    </div>
  </div>

  <div class="col-25">
    <div class="container">
    <%
		ArrayList<Order> orderList  = (ArrayList<Order>)request.getAttribute("finalOrderList");
	%>
      <h4>Cart <span class="price" style="color:black"><i class="fa fa-shopping-cart"></i> </span></h4>
      
    <%
       for(Order ord: orderList){
    %>
      <p><a href="#"><%=ord.getProduct()%></a> <span class="price"><%=ord.getFinalPrice()%></span></p>
      <hr>
      <%}%>
      <%  
		double sum = 0.0;
		for(Order ord1: orderList){
			sum += ord1.getFinalPrice();
		}%>      
      <p>Total <span class="price" style="color:black"><b><%=sum %></b></span></p>
    </div>
  </div>
</div>

<form action="Checkout" method="post">
<button type="submit" class="btn">Proceed to complete your order</button>
</form>

<div class="topleft">Hello <%=user%></div>
<a class="topright" title="Logout" href="logout.jsp">Logout</a>

</body>
</html>
