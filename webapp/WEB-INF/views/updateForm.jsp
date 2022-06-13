<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>전화번호 수정</h1>

<form action = "./update" method = "get">
	<label for = "name">이름(name): </label>
	<input type = "text" name = "name" value = "${personVo.name}"></input>
	
	<br>
	
	<label for = "hp">핸드폰(hp): </label>
	<input type = "text" name = "hp" value = "${personVo.hp}"></input>
	
	<br>
	
	<label for = "company">회사(company): </label>
	<input type = "text" name = "company" value = "${personVo.company}"></input>
	
	<br>
	<input type = "hidden" name = "personId" value = "${personVo.personId}"></input>
	<button type = "submit">등록</button>

</form>


</body>
</html>