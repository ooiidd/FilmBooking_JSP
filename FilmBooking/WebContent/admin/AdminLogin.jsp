<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Login</title>
</head>
<body>
<h3>관리자 로그인</h3>
<table class="loginform">
	<form name="fm" method="post" action="action">
	<input type="hidden" name="command" value="admin_login_action">
	<tr>
	</tr>
	<tr>
		<td>ID</td>
		<td colspan="2"><input id="log1" type="text" size="12" name="id"></td>
	</tr>
	<tr>
		<td>password</td>
		<td colspan="2"><input id="log2" type="password" size="12" name="pwd"></td>
	</tr>
	<tr>
		<td></td>
		<td><input id="login" type="submit" value="Login"></td>
	</tr>
	</form>
</table>
<c:if test="${ip eq 1 }">
	id와 비밀번호를 확인해 주세요.
</c:if>
</body>
</html>