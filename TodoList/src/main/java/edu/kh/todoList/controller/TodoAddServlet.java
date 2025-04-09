package edu.kh.todoList.controller;

import java.io.IOException;
import java.util.Map;

import edu.kh.todoList.model.service.TodoListService;
import edu.kh.todoList.model.service.TodoListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/todo/add")
public class TodoAddServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 할일을 추가하는 메서드
		
		try {
			// 1. TodoListServiceImpl이라는 객체를 생성한다. db쪽으로 내려가야 하니
			TodoListService service = new TodoListServiceImpl();
			
			// jsp로부터 폼 태그에서 넘어온 title 그리고 detail이라는 name 값이 넘어 옴
			
			// 2. 요청 시 전달받은 req로부터 데이터를 얻어온다
			String title = req.getParameter("title");
			String detail = req.getParameter("detail");
			
			// 3. 서비스 메서드로 인자를 넘겨준다. 호출 후 결과를 반환 받는다
			
			int result =service.todoAdd(title,detail);
			
			// 4. 추가에 성공 혹은 실패했다는 메시지를 세팅
			
			String message  = null;
			
			if(result >0) {
				message = "추가 성공";
			}
			else {
				message = "추가 실패";
			}
			
			
			// 5. 기존 req를 사용할 수 없으므로 세션 스코프 객체를 이용하여 메시지를 세팅한다
			// 그 다음에야 리다이렉트 할 수 있다
			
			HttpSession session = req.getSession();
			session.setAttribute("message",message);
		
			
			// 이제 리다이렉트 후에도 message 문자열을 키로 message가 올 수 있음
			
			// 6. 그대로 메인 페이지에 있었으면 하니 리다이렉트
			
			resp.sendRedirect("/"); // "/main"이랑 똑같은거임. 어차피 index.jsp에서 보냈으니
			// 최상위 경로로 재 요청을 보냈다.
			// "/"를 처리하는 서블릿이 재요청된다 
			//  "/" => "/main" (GET)방식
			// redirect는 무조건 GET방식만		
			// 리다이렉트 했으므로 MainServlet.java의 doGet이 다시한번 수행된다.
			

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
