package edu.kh.todoList.controller;

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
			// todo를 삭제하는 서비스 호출 후 결과를 반환
			
			int result = service.todoDelete(todoNo);
			
			
			// 삭제 버튼을 누른다는 행위 자체는 detail에서
			
			// 해당 todo는 삭제되며 메인으로 이동하게 된다. 
						
			
			// 리다이렉트를 위한 세션 스코프 객체
			HttpSession session = req.getSession();
			
			
			
			
		String message = null;
		
		if(result>0) message="할일이 삭제되었습니다";
		else message="삭제에 실패했습니다";
		
		session.setAttribute("message", message);
		
		resp.sendRedirect("/");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}
