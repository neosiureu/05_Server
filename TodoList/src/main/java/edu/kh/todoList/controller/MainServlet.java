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

// index.jsp에서 처음으로 요청을 매핑하여 처리하는 서블릿 => 서블릿이면 무조건 3단계까지는 한다

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	@Override
	
	// 왜 index.jsp에서 메인페이지 코드를 작성하지 않고 하필 /main요청을 처리하는 서블릿을 만들었는가? => DB에 접근하려고
	
	// Servlet, 즉 백엔드에서 추가한, 그리고 DB로부터 조회한 데이터를 메인 페이지로부터 사용할 수 있도록 하기 위해
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// db로 접근하자: 
		// 요청이 오면 Controller 가 받고 => service => DAO => DB => DAO => service => Controller => view를 결정하여 567단계로 forward (어떻게 응답할래?)	
		
		
		
		
		
		// 1)같은 패키지 service를 호출한다.
		TodoListService service = new TodoListServiceImpl();
		
		// 전체 할일의 목록을 조회할 것 + 완료된 todo개수를 얻어와
		//          List                       Interger
		
		Map<String, Object> map = service.todoListFullView() ; 
		
		
		
		
	}
	
	

}
