<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>전화번호부</h1>

<h2>등록폼</h2>

<p>	전화번호를 등록하려면	<br>
	아래 항목을 기입하고 "등록" 버튼을 클릭하세요

</p>

<form action = "" method = "get">
	<label for = "name">이름(name)</label>
	<input type = "text" name = "name" value = "">
	
	<br>
	
	<label for = "hp">핸드폰(hp)</label>
	<input type = "text" name = "hp" value = "">
	
	<br>
	
	<label for = "company">회사(company)</label>
	<input type = "text" name = "company" value = "">
	
	<input action =""></input>
	<button type = "submit">등록</button>
</form>

</body>
</html>