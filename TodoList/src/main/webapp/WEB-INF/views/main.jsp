<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

		<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


			<!DOCTYPE html>
			<html>

			<head>
				<meta charset="UTF-8">
				<title>Todo List</title>

				<%-- css파일 연결(wepapp기준으로 연결)--%>
					<link rel="stylesheet" href="/resources/css/main.css">

			</head>

			<body>
				<h1>Todo List</h1>

				<h3>전체 Todo개수: ${fn:length(todoList)} 개 /
					<!-- 키를 인자로 전달한 것  -->
					완료된 Todo개수: ${completeCount}개
				</h3>

				<hr>

				<h4>할 일 추가하는 로직</h4>
				<form action="/todo/add" method="post" id="addForm">
					<div>
						제목: <input type="text" name="title">
						<!-- 제출하려면 name이 필수 -->
						<div>
							<textarea rows="3" cols="50" name="detail" placeholder="상세 내용을 입력하세요.."></textarea>
						</div>
					</div>
					<button type="submit">추가하기</button>
				</form>

				<hr>

				<!-- 할일 목록 추가 -->

				<table id="todoList" border="1">
					<thead>
						<tr>
							<th>출력 번호</th>
							<!-- 해당 메인페이지에서 보이는 용도의 단순 출력번호. 무조건 1234순으로 -->
							<th>todo번호</th>
							<!-- 실제로 DB에 저장된 todoNo의 고유번호. 시퀀스에 따라 다르게 나옴 -->
							<th>할일 제목</th>
							<th>완료 여부</th>
							<th>등록 날짜</th>
						</tr>
					</thead>
					<!-- todoList를 대상으로 반복문 돌면서 tr을 반복적으로 만들기 위한 내용부분 -->
					<tbody>
						<c:forEach items="${todoList}" var="todo" varStatus="vs">
							<tr>
								<th>${vs.count}</th>
								<th>${todo.todoNo}</th>
								<td>
									<a href="/todo/detail?todoNo=${todo.todoNo}">${todo.todoTitle}</a>
									<!-- 제목을 클릭했을 때 다른 서버로 이동하겠다 -->
									<!-- 몇번 todo페이지에 대한 상세 페이지인지를 조회하기 위해 번호를 얻어온다 -->
									<!-- 제목 클릭 시 todoNo, 즉 고유 todo번호를 쿼리스트링 뒤의 데이터로 제출하여 서버에서 상세내용 조회 시 todoNo를 이용하게 함-->
								</td>
								<th>
									<c:if test="${todo.todoComplete}">
										O
									</c:if>
									<c:if test="${not todo.todoComplete}">
										X
									</c:if>
								</th>
								<td>${todo.regDate}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<!-- session범위에 message라는 키가 있을 경우 alert창을 띄우겠다 -->
				<c:if test="${not empty sessionScope.message}">
					<script>
						//이곳은 JS영역
						alert("${message}");
						// JSP내의 해석순위: 
						// 1순위: 자바 부분, 즉 el이나 JSP로 사용하는 구문이 가장 먼저 해석
						// 2순위: HTML CSS JS 코드
						// 꼭 el을 써야하기 때문에 js에서는 사용하지 못함

					</script>
					<!-- message는 일회용으로 쓰고 바로 없앤다 -->
					<c:remove var="message" scope="session" />

				</c:if>



				<script src="/resources/js/main.js"></script>
			</body>

			</html>