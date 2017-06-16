<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>

		<form action="uploadeFile" method="post" enctype="multipart/form-data">
			<!-- 
 FileNmae:<input type="text" name="fileName"plceholder="Enter File Name">
 <br><br> -->
			Uploade<input type="file" name="Containt" required> <br>
			<br> <input type="submit" value="uploadeFile" style="margin-right: 9%">
		</form>
		<br>
		<a href="Display" style="margin-right: 9%">Click To Display List</a>

	</center>

</body>
</html>