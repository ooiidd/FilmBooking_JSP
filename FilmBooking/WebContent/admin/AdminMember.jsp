<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Member management</title>
</head>
<body>
<a href="action?command=back_to_list">Back</a><br>
<h3>멤버 관리</h3>
<table>
	<tr>
		<th>ID</th>
		<th>Age</th>
		<th>Registration date</th>
		<th>Operation</th>
	</tr>
	<c:forEach var="member" items="${memberList }">
		<tr>
			<td>${member.id_mem }</td>
			<td>${member.age_mem }</td>
			<td>${member.register_date }</td>
			<td><a href="action?command=remove_member&id=${member.id_mem}">Remove</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>