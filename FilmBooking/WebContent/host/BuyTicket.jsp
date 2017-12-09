<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>영화 예매 화면</title>
</head>
<body>
<a href="action?command=to_member_change&num=${num }">회원 정보 변경</a>
<a href="action?command=logout">로그 아웃</a><br>
<h3>좌석 선택</h3>
<table>
	<tr>
		<th>좌석 번호</th>
		<th>좌석 현황</th>
		<th>예매</th>
	</tr>
	<c:forEach var="seat" varStatus="status" items="${seatList }">
		<tr>
			<td>${seat.num}</td>
			
				<c:choose>
					<c:when test="${seat.possible==1}">
						<td>예매 가능</td>
						<td><a href="action?command=pay&movie=${num }&seat=${seat.id_seat }&num=${seat.num}">영화 예매</a></td>
					</c:when>
					
					<c:otherwise>
						<td>예매 불가능</td>
						<td></td>
					</c:otherwise>
				</c:choose>
			
			
		</tr>
	</c:forEach>

</table>
</body>
</html>