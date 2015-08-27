<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib   uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reports on Purchased Products</title>
</head>
<body>
<table border=2>
<tr>
<th>Product Name</th><th>Number Of Products</th><th>Month</th>
</tr>
<c:forEach var="e" items="${purchasedP}">
<tr>
<td><c:out value="${e.PName}"></c:out></td>
<td><c:out value="${e.countPro}"></c:out>
<td><c:out value="${e.getMonthName()}"></c:out>
</tr>
</c:forEach> 
</table>
</body>
</html>