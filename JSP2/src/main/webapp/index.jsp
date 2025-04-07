<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<pre>
		index.html과 index.jsp차이	
		.html파일은 html,css,js 코드 작성 가능
		+ 정적 페이지, 즉 미리 만들어뒀던 페이지만 뜨게 되는 것이고 페이지가 변하지는 않는다
		
		.jsp파일은 내부에 html css js 거기다가 자바 코드, el, jstl작성법
		+ 이미 메인페이지부터 동적 페이지가 됨. 즉 요청에 따라 응답 화면이 변하는 것이 가능
		
		왜 이렇게 해야하는가? 가령 네이버 같은 웹브라우저에 들어가도 새로고침할때마다 응답하는 화면이 달라짐. 
		이미 메인페이지에 요청할 때부터 DB에 접근해서 가지고온 데이터가 뜬다는 말.
		
		즉 welcome에서 처음에 접근하는 파일의 확장자가 .html이면 이럴 수 없다는 것	
	</pre>
	
	<hr><br>
	
	<form action ="/el/test1">
	
	<!-- form의 method속성 생략 시 기본 값은 get --> 
	
	문자열 입력: <input type="text" name="str">
	
	<br><hr>
	
	정수 입력: <input type="number" name="intNum">
	
	<br><hr>
	
	실수 입력: <input type="text" name="doubleNum"> <%-- input태그의 number타입은 정수만 된다!! --%>
	
	<br><hr>
	
	<div>
		A <input type="checkbox" name = "check" value = "A">
		B <input type="checkbox" name = "check" value = "B">
		C <input type="checkbox" name = "check" value = "C">
	</div>	
	<button>제출하기</button>	
	
	</form> 
	
	
	<br><hr>
	
	<h1>
		<a href="/el/scope">Servlet/JSP범위 (scope)별 내장객체 + EL의 사용법</a>
		<%--a태그 클릭 시 보내지는 요청은 GET방식 요청이다. --%>		
	</h1>
	
	
	<hr><br>
	
	<h1>
		<a href="/jstl/test">JSTL 간단히 다뤄보기</a>
	</h1>
	
	
	<hr><br>
	
	<h1>
		<a href = "/book/list"> 책 목록 조회하기 </a>
	
	
	</h1>
	
</body>
</html>