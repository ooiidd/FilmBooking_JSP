<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 가입</title>
<script type="text/javascript" src="js/member.js"></script>
</head>
<body>
<h3>회원 가입</h3>
<form action="action" method="post" name="frm">
	<input type="hidden" name="command" value="sign_in">
	<input type="hidden" name="num" value="${num }">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userid" size="20" id="userid"><input 
				type="hidden" name="reid" size="20"><input type="button" value="중복 체크"
				onclick="idCheck()"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwd" size="20"></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" name="pwd_check" size="20"></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="text" name="age" size="20"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="승인"
				onclick="return joinCheck()">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset" value="초기화">
			</tr>
		</table>
</form>
</body>
</html>