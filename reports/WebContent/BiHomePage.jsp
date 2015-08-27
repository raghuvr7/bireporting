<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<jsp:include page="Header.jsp"></jsp:include>
<head>
  <link rel="stylesheet" type="text/css" href="styles.css">
  <link rel="stylesheet" href="theme.css">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<style>
#copy { position: absolute; top: 40px; left: 0px;}
#paste{ position: absolute; top: 40px; right: 0px;}
</style>
<meta charset="ISO-8859-1">

<title>BI Reporting</title>
</head>

<body>
<div class = "layout">
<div style=padding-left:500px><h1 class="vzh1">BI Reporting</h1></div>
<img id="copy" src="bars2.jpg" alt="Bars" style="width:304px;height:auto;padding-top: 109px;">
<img id="paste" src="piechart.jpg" alt="Bars" style="width:404px;height:300px; padding-top:100px;">
<div style=padding-left:500px>
<a class="vzlink" href="OrdersPlacedEnter.jsp">Orders Placed</a><br>
<a class="vzlink" href="OrdersProvisionedEnter.jsp">Orders Provisioned</a><br>
<a class="vzlink" href="ServiceTicketsEnter.jsp">Service Tickets Generated</a><br>
<a class="vzlink" href="BillingSub.jsp">Billing</a><br>
<a class="vzlink" href="CallsPortals.jsp">Service Calls vs Support Portal</a><br>
<a class="vzlink" href="BrokenPromisesEnter.jsp">Broken Promises</a><br>
<a class="vzlink" href="BillAmountPayment.jsp">Report on Bill amount and Payments</a><br>
<a class="vzlink" href="">Customer accessing Self service</a><br>
<a class="vzlink" href="PurchasedYear.jsp">Most purchased Products</a><br>
<a class="vzlink" href="ServiceStatus">Service Status</a>
</div>
</div>
<jsp:include page="Header2.jsp"></jsp:include>
</body>
</html>


