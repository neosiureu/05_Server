<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h3>request scope의 객체를 이용하여 전달받은 값</h3>
        <%-- forwardInput1과 2는 req가 가져온 것 + setAttribute에서 값을 하나 세팅했으므로 총 세개가 --%> 


    <ul>
        <li>forward 입력1: ${param.forwardInput1}</li>
        <li>forward 입력2: ${param.forwardInput2}</li>
        <li>str:${str} </li>
    </ul>



</body>
</html>