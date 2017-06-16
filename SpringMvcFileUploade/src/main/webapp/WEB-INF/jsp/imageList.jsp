<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 
<c:forEach var="temp" items="${imageList}">
	${temp.getId()}   
	${temp.getFileName()}<br>
</c:forEach> --%>


	<table width="50%" border="1" align="center">
		<tr>
			<th>ImageId</th>
			<th>ImageName</th>
			<th>View</th>
		</tr>
		<tbody>

			<c:forEach var="temp" items="${imageList}">
				<tr>
					<%--<c:url var="editCUrl" value="/item/edit?bid=${categoryAttribute.categoryId}&cid=${item.itemId}" />--%>
					<c:url var="deleteCUrl" value="/imageDisplay?id=${temp.getId()} " />
					<td><c:out value="${temp.getId()}" /></td>
					<td><c:out value="${temp.getFileName()}" /></td>
					<td><a href="${deleteCUrl}">View</a></td>
					<%--  <td><c:out value="${item.itemImage}"/></td> --%>
				</tr>
			</c:forEach>
		</tbody>
</body>
</html>