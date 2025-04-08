package edu.kh.todoList.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import edu.kh.todoList.model.dto.Todo;
import edu.kh.todoList.model.service.TodoListService;
import edu.kh.todoList.model.service.TodoListServiceImpl;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/todo/detail")
public class DetailServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// a태그는 get방식밖에 할 수 없음
		// 할일의 디테일을 조회하는 서블릿
		
		try {
			// 서비스 객체 생성
			TodoListService service = new TodoListServiceImpl();
		
			int todoNo = Integer.parseInt(req.getParameter("todoNo"));
			
			// 알맞은 서비스 메서드 호출 후 결과를 반환
			
			Todo todo =  service.todoDetail(todoNo);
			// TODO_NO 컬럼 값이 todoNo와 같은 todo가 존재한다면 해당 todo 객체를 반환
			// 없다면 NULL값 반환
			
			// 매핑된 todo가 존재하지 않는 경우에는
			// 상세 페이지를 보여줄 것이 없으므로 다시 메인 페이지로 리다이렉트
			// 후에 알맞은 할 일이 존재하지 않는다는 alert를 출력한다.
		
			if(todo==null) {
				// req로부터 세션 객체를 생성하고 메시지를 세팅한다
				HttpSession session = req.getSession();
				session.setAttribute("message", "알맞은 할 일이 존재하지 않습니다");
				resp.sendRedirect("/");
				return;
			}
			
			// 반면 todo가 존재 하는 경우 상세 페이지로 실제 이동한다.
			// detail.jsp 페이지를 만들어 forward
			
			// 먼저 todo 값을 넘겨야 하므로 뿌려줄 값을 세팅한다
			req.setAttribute("todo", todo);
			
			
			//5단계
			String path = "/WEB-INF/views/detail.jsp";
			
			//6단계 + 7단계
			req.getRequestDispatcher(path).forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}
	
}
