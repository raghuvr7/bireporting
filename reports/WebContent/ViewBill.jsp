<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib   uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reports on Bills and payments</title>
</head>
<body>
<table border=2>
<tr>
<th>Customer ID</th><th>Bill Amount</th><th>Payments</th>
</tr>
<c:forEach var="e" items="${bills}">
<tr>
<td><c:out value="${e.custId}"></c:out></td>
<td><c:out value="${e.countBill}"></c:out>
<td><c:out value="${e.countPayments}"></c:out>
</tr>
</c:forEach> 
</table>
</body>
</html>