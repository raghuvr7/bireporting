<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Billing</title>
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
</head>
<body>
	<div class = "layout">
<div style=padding-left:500px><h1 class="vzh1">BI Reporting</h1></div>
<img id="copy" src="bars2.jpg" alt="Bars" style="width:304px;height:auto;padding-top: 109px;">
<img id="paste" src="piechart.jpg" alt="Bars" style="width:404px;height:300px; padding-top:100px;">
<div style=padding-left:500px>
<a class="vzlink" href="NumberOfBillsEnter.jsp">Total Number Of Bills</a><br>
<a class="vzlink" href="TotalAmountOfPaymentsEnter.jsp">Total Amount Of Payments</a><br>
<a class="vzlink" href="TotalBillAmountEnter.jsp">Total Bill Amount</a><br>
</body>
</html>