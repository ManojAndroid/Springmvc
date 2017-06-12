<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style="color: green">Welcome ${sucess}</h1>
	<form action="LoginUser" method="post">
	email: <input type="text" name="email" placeholder="enter the email" required>
	<br>
	<br> 
	password:<input type="password" name="password" placeholder="enter the password" required> 
	<br> <br> 
	<div style="color: red">${error}</div>
	<div style="color: red">${errormsg}</div>
	<input type="submit" value="click to login">
	
	</form>


</body>
</html>