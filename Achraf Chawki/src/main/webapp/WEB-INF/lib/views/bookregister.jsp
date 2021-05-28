<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1>Enregistrement d'un livre</h1>
<form action="<%=request.getContextPath() %>/registerb" method="post">
<table style="with: 80%">
<tr>
<td>Author :</td>
<td><input type="text" name="author"/></td>
</tr>
<tr>
<td>Title :</td>
<td><input type="text" name="title"/></td>
</tr>
<tr>
<td>Category :</td>
<td><input type="text" name="category"/></td>
</tr>
</table><input type="submit" value="Submit"/>
</form>
</div>
</body>
</html>