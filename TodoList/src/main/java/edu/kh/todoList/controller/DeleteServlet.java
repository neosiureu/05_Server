package edu.kh.todoList.controller;

//수정은 title과 detail부분만 바꾸도록 한다
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import edu.kh.todoList.model.service.TodoListService;
import edu.kh.todoList.model.service.TodoListServiceImpl;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/todo/delete")
public class DeleteServlet extends HttpServlet {
	// 저 주소로 일단 보낸다고 하고 실제로는 메인으로 리다이렉트하자. 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			// 전달받은 파라미터를 얻어오자.
			
			int todoNo = Integer.parseInt(req.getParameter("todoNo"));
			// getParameter의 값은 무조건 문자열이기 떄문
			
			TodoListService service = new TodoListServiceImpl();
			
			// 할일여부를 변경하는 서비스 호출 후 결과를 반환
			
			int result = service.todoDelete(todoNo);
			
			// 리다이렉트를 위한 세션 스코프 객체
			HttpSession session = req.getSession();
			
			
			if(result>0) {
				session.setAttribute("message", "해당 todo의 삭제가 완료되었습니다.");
				resp.sendRedirect("/"); 
				return;
			}
			
			else {
				// 변경 실패 -> alert로 경고하고 보고있던 상세 페이지가 아닌 메인 페이지로 리다이렉트
				// db에 전달인자로 전달한 todo 자체가 없다는 이야기
				// alert로 경고할 내용은 "그런 todo가 없다" 띄우고 돌아가야
				
				session.setAttribute("message", "todo를 삭제할 수 없다");
				resp.sendRedirect("/"); 
				// 여기로 리다이렉트하면 main.jsp를 통해 만들어지게 됨		
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}
