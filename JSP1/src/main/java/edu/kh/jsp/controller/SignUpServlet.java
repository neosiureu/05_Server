package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


//1) HttpServlet 클래스를 상속받아 서블릿으로 동작할 수 있게 함
//HttpServlet에는 doGet(), doPost() 등 HTTP 요청을 처리하는 메서드가 정의되어 있음



@WebServlet("/signUp") //2) 해당 서블릿의 매핑 주소 지정 (클라이언트가 /signUp으로 요청 시 이 서블릿이 처리함)
 

public class SignUpServlet extends HttpServlet {
	// 3) 클라이언트가 POST 방식으로 요청했을 때 호출되는 메서드를 오버라이드
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 4) 요청을 가지고 뭐 할 것은 없으니 바로 JSP로 요청을 위임한다.
		
		// 5) JSP로 요청을 위임할 경로를 만든다
		
		// -> webapp폴더를 기준으로 작성
		
		String path = "/WEB-INF/views/signup_result.jsp";
		
		// 6) 요청을 JSP로 전해줄 발송자를 얻어와야 한다.

		RequestDispatcher  dispatcher = req.getRequestDispatcher(path);
		
		//7) JSP로 포워딩 이 때 두 객체를 요청 위임, 즉 forward할 JSP에게 넘겨준다.
		
		dispatcher.forward(req, resp);
		
	}
	

}
