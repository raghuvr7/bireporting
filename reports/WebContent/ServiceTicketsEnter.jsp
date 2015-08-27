<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="nofollow" type="text/css"/> 
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script> 
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script> 
<script> $(function() {
$("#datePick").datepicker({
onSelect: function() {
if (this.value === "") 
{
$("#dateText").hide();
}
else 
{
$("#dateText").fadeIn("slow");
}
}
});
});
</script> 
<script> $(function() {
$("#datePick1").datepicker({
onSelect: function() {
if (this.value === "") 
{
$("#dateText").hide();
}
else 
{
$("#dateText").fadeIn("slow");
}
}
});
});
</script>

</head>
<body>
<form action="ServiceTickets">
From Date: <input type="text" id="datePick1" name="ddate">
To Date: <input type="text" id="datePick" name="edate">
<br>
<input type="submit" value="submit">
</form> 
</body>
</html>