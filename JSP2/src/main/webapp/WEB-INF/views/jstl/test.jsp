<%-- c: 자주 사용하는 자바 코드, 변수의 사용, 제거, if, switch, for, 함수  --%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- fn: 컬렉션/ 문자열 관련 기능  --%>

<%@ taglib prefix = "fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 확인하기</title>
</head>
<body>
	<h2>1. 변수 선언(== 속성 추가)- c:set 태그</h2>
	<pre>
		-원하는 scope 객체에 값을 세팅할 수 있는 태그
		== 객체.setAttribute("key",value)와 동치
		
		<h3> [set태그의 속성] </h3>
		
		1) var: 변수명(==key)
		
		2) value: 대입할 값(==value)
		
		3) scope: 범위지정 (page, request, session, appication)
		-> 디폴트는 page
		
	</pre>
	
	<%--  <c:set var="num1" value="10" scope="page" > </c:set> --%>
	<c:set var="num1" value="10" scope="page" />
	<c:set var="num2" value="20" scope="request" />
	<c:set var="num3" value="30" scope="session" />
	<c:set var="num4" value="40" scope="application" />
	
	
	
	
	<h5>page - num1: ${pageScope.num1} </h5>
	<h5>request - num2: ${requestScope.num1} </h5>
	<h5>session - num1: ${sessionScope.num1} </h5>
	<h5>application - num1: ${applicationScope.num1} </h5>

	<h3>2. 변수의 제거 (==속성을 제거)- c:remove 태그</h3>
	<pre>
		- scope 객체에 세팅된 속성을 제거
		(== 객체.removeAttribute("key"))
		key에 해당하는 속성을 삭제한다
		
		[c:remove의 속성]
		1) var: 변수명 (==key)
		2) scope: 범위 지정 (page, request, session, application)
		   -> 기본값: 전 범위의 var들을 다 없앤다.   
		
	</pre>
	
	
	
	<c:set var = "test2" scope = "page" value="페이지"/>
	<c:set var = "test2" scope = "request" value="리퀘스트"/>
	<c:set var = "test2" scope = "session" value="세션"/>
	<c:set var = "test2" scope = "application" value="어플리케이션"/>
	
	
	<ul>
		<li>page: ${pageScope.test2}</li>
		<li>request: ${requestScope.test2}</li>
		<li>session: ${sessionScope.test2}</li>
		<li>application: ${applicationScope.test2}</li>
	</ul>
	
	
	
	<c:remove var="test2" scope="session" />

	
	<ul>
		<li>page: ${pageScope.test2}</li>
		<li>request: ${requestScope.test2}</li>
		<li>session: ${sessionScope.test2}</li>
		<li>application: ${applicationScope.test2}</li>
	</ul>
	
	
	<c:remove var="test2"/>
	
	
	
	<ul>
		<li>page: ${pageScope.test2}</li>
		<li>request: ${requestScope.test2}</li>
		<li>session: ${sessionScope.test2}</li>
		<li>application: ${applicationScope.test2}</li>
	</ul>
	
	
	
	
	
	
	<h3>3. 단일 조건문- c:if</h3>
	<pre>
		-Java의 if문을 태그 형태로 만든 것
		다만 기본적으로 else가 없다
		
		[if의 속성]
		1) test: 조건식을 작성하는 속성
	
		- 작성법1: 대입되는 값은 무조건 EL구문으로 작성!
		- 작성법2: 작성된 조건식의 결과는 불리언
	
	
	</pre>
	

	
	
	
	<c:set var="test3" value="금요일"/>
	쌍따옴표 내에 쌍따옴표를 쓸 수는 없다. 반드시 바깥부분을 홑따옴표로 바꿔야 한다
	
	<c:if test='${test3== "금요일" }'> 
		<h4> ${test3} 짱좋다! </h4> 
	</c:if>
	
	else가 없으면 !로 바꾸면 된다.
	
		<c:if test='${test3!= "금요일" }'> 
		<h4> ${test3} 너무싫다! </h4> 
	</c:if>
	


	<hr><br>
	
	<h3>4. 연속된 조건문- c:choose, c:when, c:otherwise</h3>
	<h3>일종의 switch case default</h3>
	
	<pre>
		[c:choose태그]
		- 내부에 조건문 태그를 작성하겠다고 알리는 태그
		-> 내부에는 오직 태그로서 c:when, c:otherwise태그만 작성 가능
		
		* 주의사항 *
		c:when c:otherwise태그, 공백, jsp용주석을 제외한 모든 것은 에러
		
		
		
		[c:when 태그]
		- if(조건식) / else if(조건식)를 나타내는 태그
		-> 이 역시 if의 일종이므로 속성으로 test를 쓸 수 있다 
		
		[c:otherwise 태그]
		- 무속성
	</pre>
	
	
	<%--jsp내 주석. 이거 빼고 html주석쓰면 오류
	
		empty 연산자
		-EL에서 사용하는 연산자
		
		1) null인 경우 true;
		2) 피연산자가 배열, 컬렉션이지만 내부에 아무 요소도 없는경우 true
		3) 아니면 false
		<c:when test="${empty param.age==null}"> 과 같은 말
	--%>
	
	
	<c:choose>
	
	<c:when test="${empty param.age}">
		<h4> age 값이 없습니다.</h4>
	
	</c:when>
		
	<c:when test="${param.age <= 13}">
		<h4>어린이 입니다.</h4>
	
	</c:when>
	
	<c:when test="${param.age <= 19}">
		<h4>청소년 입니다.</h4>
	
	</c:when>
	
	<c:otherwise> 	
	<h4>성인 입니다.</h4> 
	</c:otherwise>
	
	</c:choose>
	
	
	
	
	<br><hr><br>
	
	
	<h2>5. 향상된 for문 + 추가 기능 - c:forEach</h2>
	<pre>
   - 속성
   1) var   : 현재 반복 횟수에 해당하는 변수 (int i)
   2) begin : 반복 시 var 시작 값
   3) end   : 반복이 종료될 var 값
   4) step  : 반복 시 마다 var의 증가 값 (기본값 1)
  
 	 -----------------이상 네가지는 일반 for문 ----------------- 
  
  
  
   5) items : 반복 접근한 객체(배열, 컬렉션 객체) => 향상 for문 하의 마지막에 묶음
  
  
   6) varStatus : 현재 반복 상태와 관련된 정보를 제공하는 변수 선언
  
  
     varStatus="변수명"
     -> c:forEach 구문 내에서 "변수명"을 통해 원하는 값을 얻을 수 있다.
  
     * varStatus에서 제공되는 값
     - current : 현재 반복 횟수(현재 var 값)
     또는 현재 반복 접근 중인 객체(컬렉션/배열 요소)
     - index : 현재 인덱스값 반환 (0부터 시작)
    
     - count : 현재 몇바퀴째인지 반복 횟수 반환 (1부터 시작)
    
     - first : 첫 번째 반복이면 true, 아니면 false
    
     - last : 마지막 반복이면 true, 아니면 false
 </pre>

	
	
	<h3> 5-1) 일반 for문 </h3>
	
	<p>1부터 6까지 1씩 증가하여 출력되는 for loop</p>
	
	<c:forEach var="i" begin = "1" end = "6" step="1">
		<h${i}>h${i}태그의 크기입니다.</h${i}>
	</c:forEach>
	
	
	<p>6부터 1까지 1씩 감소하여 출력되는 for loop(step속성이 양수만 가능하다는 것을 고려하여 작성)</p>
	
	<c:forEach var="i" begin = "1" end = "6" step="1">
		<h${7-i}>h${7-i}태그의 크기입니다.</h${7-i}>
	</c:forEach>
	
	
	
		<br><hr><br>
		
		<h3> 5-2) 일반 for 문 형태이지만 collection_list 사용하기 </h3>
		
		<ul>
			<li>nameList: ${nameList}</li>  <%--변수 자체를 출력 --%>
			<li>
			<%--EL문법에서는 컬렉션 크기도 length로 취급. size가 아님  --%>
			
			nameList의 길이 (저장된 데이터의 개수) : ${fn:length(nameList)}
			<%--Fn에서 컬렉션 문자열 등을 관리할 수 있다. 
			
			심지어 태그도 없음. 그냥 변수라고 생각하면 됨
			
			Fn은 Function의 약자로 문자열, 컬렉션 관련 기능을 제공함. 
			
			JSTL인데 EL구분 내에서만 사용하여 JSTL-EL이라 불림
			
			${fn:length(컬렉션||배열||문자열)}
			
			--%>
			
			</li>
			
			<%-- nameList 배열의 요소를 인덱스로 출력 --%>
	<c:forEach var="i" begin="0" end="${fn:length(nameList) - 1}" step="1">
		<li>${i + 1}) ${nameList[i]}</li>
	</c:forEach>
			
		</ul>
	
	
	
	<h3>5-3) 리스트와 함께 쓰는 향상된 for문</h3>
	
	<ul>   
		<c:forEach var="name" items="${nameList}" varStatus="vs">
		
			<c:if test="${vs.first}">
				<li>------------시작------------</li></c:if>
		
		
		
		
			<li>
				<ul>
					<li>현재 인덱스: ${vs.index}</li>
					<li>현재 반복 횟수: ${vs.count}</li>
					<li>현재요소: ${name}</li>
					<li>현재요소: ${vs.current}</li>
					<li>현재요소: ${nameList[vs.index]}</li>
				</ul>
			</li>
		
		<c:if test="${vs.last}">
				<li>------------마지막------------</li>
		</c:if>
		</c:forEach>
	
	</ul>
	
	
	
	



</body>
</html>