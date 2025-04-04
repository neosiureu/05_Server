<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- prefix = 접두사: 앞에 붙는 단어 

가령 if문은 태그로 <c:if>라고 써야 함. 이 때 prefix = "c"
가령 함수는 태그로 <fn:...>라고 써야 함. 이 때 prefix = "fn"


--%>



<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL/JSTL 사용법</title>
</head>
<body>
<h1>a태그 get 요청으로 응답받은 페이지입니다.</h1>

<h2>what is EL? "표현 언어"</h2>



<%-- 
 <%= %>가 표현식이었지
 --%>

JSP 표현식을 좀 더 간단하고 효율적으로 작성할 수 있도록 보완된 언어 
=> JSP내부에 기본적으로 내장

<%--기본 작성법: "\${key}" (백슬래시는 제거하고 사용) --%>

<h3>전달받은 파라미터를 출력하는 방법</h3>

<p style = "color:red;"> 
주소 뒤에 쿼리스트르링을 직접 작성하면서 테스트 (/el_jstl?name=홍길동&age=20를 주소창에 추가하자고)
</p>

<h4>1. JSP 표현식</h4>
</p>

<div>
   name: <%= request.getParameter("name") %>
   age: <%= request.getParameter("age") %>
   

</div>

<h4>2.EL</h4>

<%-- el특징 : null이나 nullpointerException이 나는 것은 전부 빈칸 취급 
게다가 get이라는 언어를 사용하지 않는다.

--%>


<div>name: ${param.name} </div>

<%-- EL에서 파라미터를 얻어오는 방법: $(param.key) --%>

<div>name: ${param.age} </div>
    
</p>



<hr><br>

<%-- JSTL을 쓰는 이유?  --%>

<h1>JSTL (JSP Standard Tag Library)</h1>

<pre>
   JSP에서 자주 사용하는 자바 코드를 
   스크립틀릿이 아닌 HTML태그와 같은 형태로 작성하게 함
   즉 태그 제공라이브러리가 JSTL
   
   뭘 자주 사용하는데? 조건 분기 반복 + 변수

   [라이브러리 추가 방법]
   1. 필요한 jar 파일을 드라이브 내에서 다운 받고
   2. 프로젝트 webapp/WEB_INF/lib 폴더에 다운로드받은 라이브러리 추가 (copy paste또는 drag drop)
   3. 다만 사용할 JSP파일 맨 위에 taglib라는 추가 구문을 작성해야 진짜 JSTL을 사용 가능
</pre>





<h3>JSTL c:if문 사용하지 않을때와 사용할떄의 편의성 차이</h3>

<% 

   int age = Integer.parseInt(request.getParameter("age"));

   if(age>20){

%>

   <h3>성인입니다 (JSP스크립틀릿으로 이렇게 출력한 것)</h3>

<% } 

   else if(age<=20){

%>

   <h3>성인이 아닙니다. (JSP스크립틀릿으로 이렇게 출력한 것)</h3>

<% } %>




<c:if test="${param.age>20}">
   <h3>성인입니다 (JSTL로 이렇게 출력한 것)</h3>
</c:if> 

<c:if test="${param.age<=20}">
   <h3>성인이 아닙니다. (JSTL로 이렇게 출력한 것)</h3>
</c:if> 

조건문을 써주는 test 속성


</body>
</html>