package edu.kh.todoList.controller;

import java.io.IOException;

import edu.kh.todoList.model.service.TodoListService;
import edu.kh.todoList.model.service.TodoListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/todo/complete")
public class CompleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			// 전달받은 파라미터를 얻어오자.
			
			int todoNo = Integer.parseInt(req.getParameter("todoNo"));
			// getParameter의 값은 무조건 문자열이기 떄문
			
			TodoListService service = new TodoListServiceImpl();
			
			// 할일여부를 변경하는 서비스 호출 후 결과를 반환
			
			int result = service.todoComplete(todoNo);
			
			// 리다이렉트를 위한 세션 스코프 객체
			HttpSession session = req.getSession();
			
			
			if(result>0) {
				// 변경 성공 -> 보고있던 상세 페이지로 리다이렉트 -> alert로 "완료 여부가 변경되었다고 뜸"
				session.setAttribute("message", "완료여부가 변경되었습니다.");
				resp.sendRedirect("/todo/detail?todoNo="+todoNo); 
				//재요청 할당 시에도 이를 써줘야 함. todoNo라는 파라미터를 가지고 재요청을 보내야 하기 때문
				
				return;
				
			}
			
			else {
				// 변경 실패 -> alert로 경고하고 보고있던 상세 페이지가 아닌 메인 페이지로 리다이렉트
				// db에 전달인자로 전달한 todo 자체가 없다는 이야기
				// alert로 경고할 내용은 "그런 todo가 없다" 띄우고 돌아가야
				
				session.setAttribute("message", "그런 todo는 없다.");
				resp.sendRedirect("/"); 
				// 여기로 리다이렉트하면 main.jsp를 통해 만들어지게 됨
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
