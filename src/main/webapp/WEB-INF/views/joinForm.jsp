<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
	table,th,td {
		border:1px solid black;
		border-collapse:collapse;
	}
	th,td {
		padding:5px 10px;
	}
/* 	table {
		width:80%;
	}
	input[type='text'] {
			width:100%;
		} */
		
	textarea {
		width: 100%;
		height: 150px;
		resize: none;
	}
</style>
</head>
<body>
	<form action="join" method="post">
		<table>
			<tr>
				<th>* ID</th>
				<td><input type="text" name="id"/></td>
			</tr>
			<tr>
				<th>* PW</th>
				<td><input type="password" name="pw"/></td>
			</tr>
			<tr>
				<th>* NAME</th>
				<td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<th>EMAIL</th>
				<td><input type="text" name="email"/></td>
			</tr>
			<tr>
				<th colspan="2">
					<input type="submit" value="회원가입"/>
					<input type="button" value="뒤로가기" onclick="javascript:history.back()"/>
				</th>
			</tr>
		</table>
	</form>
</body>
<script>
</script>
</html>