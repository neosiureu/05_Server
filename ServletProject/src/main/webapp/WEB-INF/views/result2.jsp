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