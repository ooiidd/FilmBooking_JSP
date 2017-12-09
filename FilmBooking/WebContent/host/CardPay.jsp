<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>카드 결제</title>
</head>
<body>
<h3>결제하기</h3>
<form action="action" method="post" name="fm">
<input type="hidden" name="command" value="pay_success">
<input type="hidden" name="id_resv" value="${id_resv }">
카드 번호 : <td><input type="text" name="cardnum" size="20"></td><br>
유효 날짜 : 
<select name="month">
	<option value=1 selected>1</option>
	<c:set var="month" value="2"/>
	<c:forEach varStatus="status" begin="0" end="10" step="1">
		<option value=${month+status.index }>${month+status.index }</option>
	</c:forEach>
</select>
<select name="year">
	<option value=2017 selected>2017</option>
	<c:set var="year" value="2018"/>
	<c:forEach varStatus="stat" begin="0" end="20">
		<option value=${year+stat.index }>${year+stat.index }</option>
	</c:forEach>
</select><br>
cvc번호 <td><input type="password" name="cvc" size="5"></td>
<input type="submit" value="결제">
<a href="action?command=pay_cancel">취소</a>
</form>
</body>
</html>