<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>1scoreRegister</title>
	</head>
	<body>
		<h2>점수 입력(화면 요청 url : /service/1scoreRegister)</h2>
		<h2>Score 입력</h2>
		<form action="scoreForm" method="post">
			이름 : <input type="text" name="name"><br>
			국어 : <input type="text" name="kor"><br>
			영어 : <input type="text" name="eng"><br>
			수학 : <input type="text" name="math"><br>
			<input type="submit" value="전송">
			<input type="button" value="목록" onclick="location.href='3scoreList'">
		</form>
	</body>
</html>