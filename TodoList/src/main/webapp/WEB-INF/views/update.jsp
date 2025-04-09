<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>${todo.todoTitle} 수정 페이지</title>
            </head>

            <body>
                <h1>${sessionScope.loginMember}</h1>
                <h4>할 일 수정</h4>

                <!-- /todo/update 서블릿을 향해 post방식요청
                 -> 같은 어노테이션을 가진 UpdateServelt클래스에 doPost()를 또 오버라이딩
                 
                -->
                <form action="/todo/update" method="post" id="updateForm">
                    <!-- 같은 서블릿에서 doGet이 아닌 doPost로 처리하겠다 -->
                    <div>
                        제목: <input type="text" name="title" value="${todo.todoTitle}">
                    </div>

                    <div>
                        <!-- input처럼 할 수 없다. textarea는 속성으로 value값은 없지만 아래처럼 태그 사이에 값을 넣으면 됨 -->
                        <textarea name="detail" rows="3" cols="50" placeholder="상세내용..">${todo.todoDetail}</textarea>
                    </div>
                    <!-- 수정된 내용 뿐 아니라 todo번호까지 서버에 넘겨줘야 db까지 도달할 때 where문에서 쓸 수 있다 
                    어떤 todoNo를 가진 행을 수정하고자 하는 것인지 SQL where절 조건식에 이용해야 하기 때문
                    
                    param. =>url에 있는 ?todoNo=1 가 있다
                     EL표현식에서 ${param.key} => ${param.todoNo} => 1반환 (todoNo가 키이므로 그에 맞는 값인 1이 반환되는 것)
                    -->
                    <input type="hidden" name="todoNo" value="${param.todoNo}">
                    <!-- todoNo 제목 textarea이 있지만 todoNo는 안 보임. 하지만 제출은 됨!!  -->

                    <button>수정 완료</button>


                </form>


                <!-- 세션 범위에 message가 있을 경우 선택 -->
                <c:if test="${not empty sessionScope.message}">
                    <script>
                        alert("${message}");
                    </script>
                    <!-- message는 일회용으로 쓰고 바로 없앤다 -->
                    <c:remove var="message" scope="session" />
                </c:if>

            </body>

            </html>