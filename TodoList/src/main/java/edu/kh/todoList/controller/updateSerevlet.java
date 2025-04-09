package edu.kh.todoList.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import edu.kh.todoList.model.dto.Todo;
import edu.kh.todoList.model.service.TodoListService;
import edu.kh.todoList.model.service.TodoListServiceImpl;

/**
 * Servlet implementation class updateSerevlet
 */

@WebServlet("/todo/update")
public class updateSerevlet extends HttpServlet {
	//수정은 title과 detail부분만 바꾸도록 한다

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 수정화면을 전환하라고 요청받은 것을 처리
		
		try {
			
			// 기존 제목과 상세내용이 input이나 textarea에 이미 채워진 상태
			// -> 수정 전 제목과 내용을 일단 조회, 즉 상세조회 select했던 서비스를 재호출
			
			int todoNo = Integer.parseInt(req.getParameter("todoNo"));
			
			TodoListService service = new TodoListServiceImpl();
			// 기존에 만들어놓은 todoDetail을 재요청;
			
			Todo todo = service.todoDetail(todoNo);
			
			if(todo ==null) {
				resp.sendRedirect("/");
				return;
			}
			// null이 아니면 requset scope에 todo객체를 세팅한다
			req.setAttribute("todo", todo); //이게 향하는 JSP에서 이걸 쓸 일이 있겠구나
			
			req.getRequestDispatcher("/WEB-INF/views/update.jsp").forward(req, resp);
			// 새로운 jsp를 만들어 수정할 수 있는 페이지를 만들겠다
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}
	
	
	/**
	 * 요청 주소는 같으나 데이터 전달, 제출 방식이 다르면 하나의 서블릿 클래스에서도 
	 * 각각의 메서드 doGet doPost를 만들어 처리할 수 있다.
	 * 할일의 제목과 내용을 수정하는 post 요청 처리를 한 것이다.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String title= req.getParameter("title");
			String detail = req.getParameter("detail");
			int todoNo = Integer.parseInt(req.getParameter("todoNo"));
			
			TodoListService service = new TodoListServiceImpl();

			int result=service.todoUpdate(title,detail,todoNo);
			
			
			String url = null;
			String message = null;
			
			// 수정 성공 시 상세조회 페이지로 redirect
			// 후 수정되었다는 메시지를 alert를 출력
			
			if(result>0) {
				// url이 다르고 메시지가 달라야 함=> 두 변수를 선언하자
				url = "/todo/detail?todoNo=" + todoNo;
				message= "수정 되었습니다";
				
			}
			
			// 반면 수정에 실패했을 때는 다시 수정 화면으로 redirect
			// 이후 alert로 수정 실패 메시지를 출력
			
			else {
				// url이 다르고 메시지가 달라야 함=> 두 변수를 선언하자
				url = "/todo/update?todoNo=" + todoNo;
				// 현재 서블릿의 get방식 요청을 다시 보내겠다. 
				// 즉 수정화면을 다시 보여준다
				message = "수정 실패";
			}
			
			// session객체에 속성을 추가
			req.getSession().setAttribute("message", message);
			
			
			// 이후 get방식 요청으로 redirect
			resp.sendRedirect(url);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
