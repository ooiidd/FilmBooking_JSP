<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Movie</title>
</head>
<body>
<a href="action?command=back_to_list">Back</a><br>
<h3>영화 추가하기</h3>
<form name="fm" method="post" action="action">
<input type="hidden" name="command" value="insert_film">
<table>
	<tr>
		<td>Title</td>
		<td><input type="text" name="title" size="10"></td>
	</tr>
	<tr>
		<td>Age</td>
		<td><input type="text" name="age" size="10"></td>
	</tr>
	<tr>
		<td>Total seat</td>
		<td><input type="text" name="seat" size="10"></td>
	</tr>
	<tr>
		<td>Start Date</td>
		<td><input type="text" name="sdate" size="10"></td>
	</tr>
	<tr>
		<td>End Date</td>
		<td><input type="text" name="edate" size="10"></td>
	</tr>
	<tr>
		<td><input type="submit" value="Submit"></td>
		<td><input type="reset" value="Reset"></td>
	</tr>
</table>
</form>
</body>
</html>