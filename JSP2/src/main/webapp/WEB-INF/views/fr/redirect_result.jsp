<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>/fr/redirect 요청 시 재요청 되어 보여지는 페이지</h3>
	
	<h3>request scope로 전달된 값이 존재하는지 확인한다</h3>

	<ul>
		<li>redirectInput1: ${param.redirectInput1} <- 없어졌을듯</li> 
		<li>redirectInput2: ${param.redirectInput2}<- 없어졌을듯</li>
		<li>str2: ${str2}<- 없어졌을듯</li>
	</ul>
	
	<h3>session scope로 전달된 값이 존재하는지 확인한다</h3>
	${sessionNum} <- 이것만 살아남을듯


	<br><br><br><br>

	JS에서 현재 url에 보이는 주소를 얻어오는 방법:

	<h3 id="print" > </h3>

	<script>
		// JS로부터 현재 url경로를 얻어내는 방법: location내장객체를 이용한다
		// location.pathname
		document.querySelector("#print").innerHTML = location.pathname;


	</script>
	

</body>
</html>