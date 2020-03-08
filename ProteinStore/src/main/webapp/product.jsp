<%@page import="java.util.Iterator, java.util.Map, java.util.Set, 
devops.obs.db.ProductDb, devops.obs.model.Product, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Product</title>
<style>
* {
  box-sizing: border-box;
}
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: Azure;
}
/* Float three columns side by side */
.column {
  float: left;
  width: 33%;
  padding: 0 10px;
}
/* Remove extra left and right margins, due to padding */
.row {margin: 0 -5px;}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}
/* Responsive columns */
@media screen and (max-width: 600px) {
  .column {
    width: 100%;
    display: block;
    margin-bottom: 20px;
  }
}
/* Style the counter cards */
.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  padding: 16px;
  text-align: center;
  background-color: #f1f1f1;
}
.price {
  color: grey;
  font-size: 22px;
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
h1 {
	font-size:35px;
	text-align: center;
	color: Black;
	text-shadow: 3px 2px Cornsilk  ;
}
h4 {
	float: right;
	margin: 10px 65px;
}
select {
	float: left;
	margin: 10px 65px;
  	border: 3px solid DimGray ;
}
img {
  width: 300px;
  height: 300px;
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
<h1>Product Page</h1>
<%String sess[] = session.getValueNames();
String user = (String)session.getAttribute("uname");
%>
<form action="Product" method="post">
<div class="row">

		<%
			ProductDb product = new ProductDb();
			ArrayList<Product> prodList = new ArrayList<Product>();
			Set entrySet = product.productData.entrySet();
			Iterator it = entrySet.iterator();
			while(it.hasNext()){
				Map.Entry pr = (Map.Entry)it.next();
				prodList.add((Product)pr.getValue());
			}
		%>
		
		<% for(Product prod: prodList){ %>
		
  <div class="column">
    <div class="card">
	<img src="<%=prod.getProductImage()%>"  style="width:75%">
  	<h1><%=prod.getProduct()%></h1>
  	<label><input type="checkbox" name="items" value="<%=prod.getProduct()%>"/></label>
	<select name="quantity">
		<option value="0"> </option>
  		<option value="0.5">500gm</option>
  		<option value="1">1Kg</option>
	</select>
	<h4>Rs<%=prod.getPrice()%>/Kg</h4>
    </div>
  </div>
  
  <%} %>

</div>
<button type="submit" class="btn">Add to cart</button>  
</form>

<div class="topleft">Hello <%=user%></div>
<a class="topright" title="Logout" href="logout.jsp">Logout</a>

</body>
</html>