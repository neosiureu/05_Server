<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 확인 1</title>
</head>
<body>
	<h3>전달받은 파라미터를 출력한다</h3>
	
	<pre>
		-  \${param.key}: key에 일치하는 파라미터 벨류 값을 가져옴
		-   \${praramValues.key}: 를 통해 키가 일치하는 파라미터 벨류 값들을 전부 배열형으로 가져옴
	</pre>
	
	<h4>존재하는 파라미터 얻어오기</h4>
	<p> EL구문으로 str파라미터 얻어오기, 즉 name="str"인거 얻어오기: 
	${param.str}</p>
	
	<h4>없는 파라미터 얻어오기</h4>
	
	<p> EL구문으로 temp파라미터 얻어오기, 즉 name="temp"인거 사실 없는거지만 얻어오기: 
	${param.temp}</p>
	
	
	<br><hr><br>
	
	<h3> EL은 자동적으로 자료형을 알맞게 바꿔준다 </h3>
	
	
	<ul>
		<%-- 문자열 비교 역시 el에서는 ==과 같이 사용 가능하다. --%>
		<li>${param.str == "ㅇㅎㅇ"}</li>
		<li>${param.intNum == 100} </li> <%--사실 문자열로 오는 ${와 100을 비교하는 것은 말이 안됨. 
		원래는 HTML에서 얻어온 데이터는 모두 String형 
		하지만 EL에서 연산되는 자료형이 다를 경우 자동으로 형변환 됨--%>
		<li>${param.doubleNum == 3.14} </li>
	</ul>
	
	<br><hr><br>
	
	
	<h3> 같은 name속성을 갖는, 즉 key값이 같은 모든 태그의 파라미터 값들을 el로 얻어오는 방법 </h3>
	<ul>
		<li>param.check: ${param.check}</li>
		
		: check라는 파라미터가 여러 개 전달된 경우 첫 번째 파라미터값 출력
		
		<li>paramValues.check : ${paramValues.check}</li>
		
		:check라는 파라미터가 여러 개 전달된 경우 모든 파라미터의 값을 모아 String[]로 반환. 물론 배열이므로 일단 주소만 뜸
		
		<li>paramValues.check[0] : ${paramValues.check[0]}</li>
		<li>paramValues.check[1] : ${paramValues.check[1]}</li> 
		<li>paramValues.check[2] : ${paramValues.check[2]}</li> 
	</ul>
	
	
	
	
		
	
</body>
</html>