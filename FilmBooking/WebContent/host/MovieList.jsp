<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상영 영화 리스트</title>
</head>
<body>
<table class="boardlist">
	<tr>
	<h2>상영 영화 리스트</h2>
	</tr>
	<tr>
		<th>타이틀</th>
		<th>관람가</th>
		<th>총 좌석 수</th>
		<th colspan="2">상영 기간</th>
		<th>예매</th>
	</tr>
	<c:forEach var="movie" items="${movieList }">
		<tr>
			<td>${movie.film_name }</td>
			<td>${movie.age_phase }</td>
			<td>${movie.seat_num }</td>
			<td>${movie.date }</td>
			<td>${movie.enddate }</td>
			<td><a href="action?command=choice_movie&num=${movie.id_film}">예매</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>