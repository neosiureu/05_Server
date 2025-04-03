package edu.kh.servlet.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//서블릿 관련 코드를 작성해기 위해서는 HttpServlet클래스를 상속받아야 하지만
//상속을 받는다고 바로 서블릿이 되는 것은 아니다.
// web.xml작성하기 싫다면 @WebServlet()이라는 주석을 사용한다.


@WebServlet("/signUp")
public class ExampleController2 extends HttpServlet {
	/*
	 -> 주석이 달려있는 해당 클래스를 Servlet으로 등록하고 ()안에 작성된 매핑할 주소와 연결하라고 지시하는 어노테이션
	 어노테이션은 컴파일러가 알아듣는 주석이므로 이 클래스와 singUp과 매핑된다는 것을 알게 됨
	 서벗 실행 시 자동으로 web.xml에 <servlet> <servletMapping>를 작성하는 효과 
	 * */
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

	    // Post 요청 처리 메서드 오버라이딩
	    String inputId = req.getParameter("inputId");
	    String inputPw = req.getParameter("inputPw");
	    String inputName = req.getParameter("inputName");
	    String intro = req.getParameter("intro");

		// 응답화면 만들기
		// -> Java에서 응답화면을 작성하기 번거롭고 힘들다..
		// -> JSP가 대신 화면을 만들어달라! (Servlet이 JSP에게 요청/응답을 위임)

		// JSP가 대신 응답 화면을 만들어 주기 위해서는
		// Servlet이 어떤 요청을 받았는지 알아야한다 ! (req, resp)

	    RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/result.jsp"); // webapp 폴더 기준

	 // -> webapp 폴더는 웹 어플리케이션의 루트(root) 디렉토리로,
	 //	브라우저를 통해 접근 가능한 정적 및 동적 리소스들이 위치하는 폴더
	 // -> webapp 폴더가 컨텍스트 루트(/)로 설정되기 때문에,
	 // 해당 경로가 webapp 내부 경로로 해석되는 것.

	 // WEB-INF 폴더에 있는 파일들은 클라이언트가 직접적으로 접근할 수 없는 영역,
	 // 서블릿을 통해서만 접근 가능

	 dispatcher.forward(req, resp);
	 // RequestDispatcher 객체를 사용하여 현재 요청(req)와 응답(resp)을
	 // 지정한 JSP 페이지(result.jsp)로 전달하는 작업
	 // -> 즉, 현재 서블릿(ExampleController2)에서 처리하던 요청을 result.jsp로 전달하고
	 //	 제어권을 그쪽으로 넘김(== 위임하다)

		
	}
	
	

}
