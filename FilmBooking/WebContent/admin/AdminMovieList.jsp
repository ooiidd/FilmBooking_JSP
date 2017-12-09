<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>영화 리스트</title>
</head>
<body>
<a href="action?command=to_insert_film">Insert film</a>
<a href="action?command=to_member_management">Member management</a>
<a href="action?command=logout">Go to Home</a><br>
<h3>영화 리스트</h3>
<table>
	<tr>
		<th>Title</th>
		<th>Age</th>
		<th>Total seat</th>
		<th colspan="2">Date</th>
		<th>Operation</th>
	</tr>
	<c:forEach var="movie" items="${movieList }">
		<tr>
			<td>${movie.film_name }</td>
			<td>${movie.age_phase }</td>
			<td>${movie.seat_num }</td>
			<td>${movie.date }</td>
			<td>${movie.enddate }</td>
			<td><a href="action?command=remove_movie&num=${movie.id_film}">Remove</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>