<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
<h3>로그인</h3>
<table class="loginform">
	<form name="fm" method="post" action="action">
	<input type="hidden" name="command" value="login">
	<input type="hidden" name="num" value="${num }">
	<tr>
	</tr>
	<tr>
		<td>ID</td>
		<td colspan="2"><input id="log1" type="text" size="12" name="id"></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td colspan="2"><input id="log2" type="text" size="12" name="pwd"></td>
	</tr>
	<tr>
		<td><a href="action?command=to_sign_in&num=${num }">회원 가입</a></td>
		<td><input id="login" type="submit" value="로그인"></td>
		<td><input id="reset" type="reset" value="초기화"></td>
	</tr>
	</form>
</table>
<c:if test="${ip eq 1 }">
	id와 비밀번호를 확인해 주세요.
</c:if>
</body>
</html>