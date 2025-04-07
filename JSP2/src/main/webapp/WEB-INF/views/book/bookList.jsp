<%-- c: 자주 사용하는 자바 코드, 변수의 사용, 제거, if, switch, for, 함수  --%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- fn: 컬렉션/ 문자열 관련 기능  --%>

<%@ taglib prefix = "fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 목록 조회</title>

<%-- css js파일은 브라우저에서 요청하는 정적 파일이다. 이러한 정적 리소스들은 클라이언트, 
즉 브라우저에서 직접 접근 가능해야 하므로 webapp폴더나 그 하위폴더에 반드시 있어야 한다 
만약 WEB-INF에 있다면 인식할 수 없다.
--%>
<link rel="stylesheet" href="/resources/css/book.css"> <%-- 경로에서 webapp이 루트다  --%>
</head>
<body>

	<h1>책 목록 조회</h1>
	<hr>
	<h3>전체 책의 수량: ${fn:length(bookList)}권</h3>
	
	
	<table border="1">
	<thead>
		<tr> 
			<th>번호</th>
			<th>제목</th>
			<th>저자</th>
			<th>가격</th>
		</tr>
	</thead>  
	<tbody>
	
	
	<c:forEach var="book" items="${bookList}" varStatus = "vs">
		<tr>
			<th>${vs.count}</th>
			<td>${book.title}</td>
			<td>${book.writer}</td>
			<td>${book.price}</td>
		</tr>
		<%--3, 6, 9번째마다 회색으로된 새로운 여백을 표시하겠다--%>
		<c:if test="${vs.count %3 == 0}">
			<tr>
				<td class="blank" colspan=4>&nbsp;</td>
			</tr>
		</c:if>
	</c:forEach>
		
		
	</tbody>
	
	</table>
	
<script src="/resources/js/book.js"></script>

	
</body>
</html>