<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>영화 결제</title>
</head>
<body>
<a href="action?command=logout">로그 아웃</a>
<a href="action?command=home">홈으로 돌아가기</a>
<h3>영화 결제</h3>
<table>
	<tr>
		<th>영화 제목</th>
		<th colspan="2">상영 기간</th>
		<th>예약일</th>
		<th>좌석 번호</th>
		<th>예약 상황</th>
		<th colspan="2">결제 및 취소</th>
	</tr>
	<c:forEach var="reserve" items="${reserveList }">
		<tr>
			<td>${reserve.film_name }</td>
			<td>${reserve.date }</td>
			<td>${reserve.enddate }</td>
			<td>${reserve.resv_date }</td>
			<td>${reserve.num }</td>
			<td>${reserve.status }</td>
			<td><a href="action?command=card_pay&id=${reserve.id_resv}">결제</a></td>
			<td><a href="action?command=remove_reserve&id=${reserve.id_resv}">예매내역 삭제</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>