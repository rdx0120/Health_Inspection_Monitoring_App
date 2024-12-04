<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>
<%
String hcode=request.getParameter("hcode");
%>
	<form action="resetpassword" method="post">
		<input type="hidden" name="hcode" value="<%=hcode%>">
		<input type="password" name="password" required><br>
		<input type="password" name="rpassword" required>
		<input type="submit" value="submit">
	</form>
</body>
</html>