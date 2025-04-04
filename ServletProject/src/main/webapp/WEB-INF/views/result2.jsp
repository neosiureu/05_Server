<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> <%= request.getParameter("orderer") %> 님의 주문 결과 </title>
</head>
<body>
	<h1> 주문사명: </h1>
	<h3> 주문한 커피: </h3>
	
	<%-- ice를 골랐으면 수식어가 차가운, hot을 골랐으면 수식어가 따뜻한의 타이틀을 붙여야 한다. --%>


	<%-- JSP 주석

    <%@ %> : 지시자 태그 (JSP 페이지의 전반적 속성을 설정하는데 사용하는 태그)

    <% %>  : 스크립틀릿 -> 자바코드 작성

    <%= %> : 표현식 -> 자바, 서버에서 받아온 값을 표현(출력)할 때 사용

    JSP ( Java Server Page ) : Java 코드가 포함된 HTML 코드

	--%>
	
	
	<% if(request.getParameter("type").equals("ice")) { %>
  차가운
<% } else { %>
  따뜻한
<% } %>
<%= request.getParameter("coffee") %>

<%= request.getParameterValues("opt") %>

<% if(request.getParameterValues("opt") != null) { %>
<ul>
  <% for(String opt : request.getParameterValues("opt")) { %>
    <li><%= opt %></li>
  <% } %>
</ul>
<% } %>
</body>
</html>

