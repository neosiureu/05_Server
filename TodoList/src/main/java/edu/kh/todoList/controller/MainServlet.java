package edu.kh.todoList.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import edu.kh.todoList.model.dto.Todo;
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
		
		
		try {
		
		// 1)같은 패키지 service를 호출한다.
		TodoListService service = new TodoListServiceImpl();
		
		// 전체 할일의 목록을 조회할 것 + 완료된 todo개수를 얻어와
		//          List                       Interger
		
		Map<String, Object> map = service.todoListFullView() ; 
		
		// 맵에 저장된 각 값들, 즉 리스트와 해당하는 int를 풀어서 request 스코프 객체에 실어서 forwading할 것
		
		List<Todo> todoList =  (List<Todo>) map.get("todoList");
		
		
		int completeCount = (int)map.get("completeCount");
		
		req.setAttribute("todoList",todoList);
		req.setAttribute("completeCount",completeCount); // 다른 JSP에서 이걸 쓸 일이 있겠구나
		
		
		// 마지막으로 메인페이지의 응답을 담당하는 JSP를 만들어 대신 만들어달라고 하는 일
		String path = "/WEB-INF/views/main.jsp"; //이게 이제부터 메인 페이지다. 이 서블릿은 더이상 할 게 없다.
		req.getRequestDispatcher(path).forward(req, resp);
		
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
