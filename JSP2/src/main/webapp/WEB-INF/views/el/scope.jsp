<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet/JSP 범위 별 내장 객체</title>
</head>
<body>


<h1>Servlet/JSP 범위별 내장 객체</h1>
	
	<pre>
		Servlet/JSP 에는 4종류 범위를 나타낸 내장 객체가 존재한다
		-> 각 종류마다 영향을 끼치는 범위가 달라진다
		
		
		<h3>1. page : 현재 페이지</h3>
		-> 현재 JSP에서만 사용 가능한 객체 (Servlet X)
		
		<h3>2. request (요청) == HttpServletRequest</h3>
		
		-> 요청 받은 페이지(Servlet/JSP)와
		위임받은 페이지(Servlet/JSP)에서 유지되는 객체
		
		<h3>3. session (입회, 접속)</h3>
		
		- session : 서버에 접속한 클라이언트를 나타내거나,
					관련 정보를 get/set 할 수 있는 객체
					(session 객체는 서버에서 관리함)
					
		- [중요!] session은 클라이언트마다 하나씩 생성된다!!
		
		- [유지 범위]
		사이트 접속 ~ 브라우저 종료 || 세션 만료
		브라우저 종료란 모든 탭이 다 종료
		
		- session이 유지되는 상태에서는
		아무곳에서나 가져다가 사용할 수 있다.
		
		-maxage를 서버단에서 지정해줄 수 있다. 
		
		
		<h3>4. application (ServletContext)</h3>
		
		- 하나의 웹 애플리케이션 마다 1개만 생성되는 객체
		(Server를 키면 1개만 생성되는 객체)
		
		- application 객체는 어디서든 사용 가능
		
		- [유지 범위]
		서버 실행 ~ 서버 종료
		
		
		<h3>내장 객체의 우선 순위 : page > request > session > application </h3>
		좁을수록 같은 key 여도 우선적으로 el에 작성하여 get set 했을 때 이 순서로 띄워 줌
	
	</pre>
	
	<hr><hr>












	<h3>범위별 객체에 세팅된 값, 속성을 얻어온다</h3>
	<pre>
		- 제출된 파라미터를 얻어오는 EL문법: \${param.key}
		
		- 범위에 한정하여 객체에 세팅된 값 얻어오는 EL은 따로 있다
		
		1) \${requestScope.key}과 같이 쓴다 (pageScope.key) (applicationScope.key)
		
		2) \${key}
		=> 다만 이때는 좁은 범위부터 (page scope 순으로) 탐색하여 일치하는 key가 있으면 얻어온다.		
	</pre>




<% // page scope 객체에 값을 세팅 
	pageContext.setAttribute("pageValue", "page scope 객체에 세팅한 값");
%>

	<p>page scope : ${pageValue} </p>

	<p>request scope에서 얻은 값: ${requestScope.requestValue}</p>
	
	<p>session scope에서 얻은 값: ${sessionScope.sessionValue}</p>
	
	<p>applicaion scope에서 얻은 값: ${applicationScope.applicationValue}</p>
	
	


	<a href="/el/check"> request 객체 범위에 대한 확인을 위해 이동 </a>
	
	<h2>쉽게 말해 ELTestServlet2라는 서블릿 => scope.jsp (지금) => ELTestCheck라는 서블릿을 또 만들 것이다. </h2>
	
	
	<hr><br>
	
	
	<h1>범위별 객체 우선순위 확인</h1>
	
	어쩔수없이 스크립틀릿 < 와 % 이용

<%  
	pageContext.setAttribute("menu", "짬짜면(page)");
%>	
	

	<h3>menu: ${menu}</h3>	
	
	다만 풀네임을 적으면 원하는 스코프의 세팅된 값을 얻어올 수 있다.
	
	<p>${pageScope.menu}</p>
	<p>${requestScope.menu}</p>
	<p>${sessionScope.menu}</p>
	<p>${applicationScope.menu}</p>

</body>
</html>