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
<h1>Enregistrement d'un ?tudiant</h1>
<form action="<%=request.getContextPath() %>/register" method="post">
<table style="with: 80%">
<tr>
<td>First name :</td>
<td><input type="text" name="firstname"/></td>
</tr>
<tr>
<td>Last name :</td>
<td><input type="text" name="lastname"/></td>
</tr>
<tr>
<td>Username :</td>
<td><input type="text" name="username"/></td>
</tr>
<tr>
<td>Password :</td>
<td><input type="text" name="password"/></td>
</tr>
</table><input type="submit" value="Submit"/>
</form>
</div>
</body>
</html>