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
	table {
		width:80%;
	}
</style>
</head>
<body>
	<input type="hidden" id="writer" value=""/>
	<h3>상세보기</h3>
		<table>
			<tr>
				<th>글번호</th>
				<td>${bbs.idx}</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${bbs.bHit}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${bbs.subject}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${bbs.user_name}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${bbs.reg_date}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${bbs.content}</td>
			</tr>
			<tr>
				<th colspan="2">
					<input type="button" id="update" value="수정하기" style="display:none" onclick="goUpdate()"/>
					<input type="button" value="리스트" onclick="javascript:history.back()"/>
				</th>
			</tr>
		</table>
</body>
<script>
var msg = "${msg}";
if(msg !=""){
	alert(msg);
}

var writer = $("#writer").val();
var loginId = "${loginId}";

//만약 로그인ID와 작성자가 같다면..
if(writer == loginId){
	$("#update").show();
}


</script>
</html>