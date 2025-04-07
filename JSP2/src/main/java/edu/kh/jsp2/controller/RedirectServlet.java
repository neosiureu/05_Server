package edu.kh.jsp2.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/fr/redirect")
public class RedirectServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// request scope 속성 추가
		req.setAttribute("str2", "가나다라마바사");
		// session scope 속성 추가
		HttpSession session = req.getSession();
		
		session.setAttribute("sessionNum", 10000);
		// req로서 넘어온 input태그 내 name속성들 2개와 지금 추가한 setAttribute로 추가한 것
	
		// 여기까지가 4단계였음
		
		
		// path만들고 dispatch하고 forward하는 것이 아니라 redirect할 것이다.
		
		// resp.sendRedirect("재요청할 서블릿 주소 작성")
		// (원래는 파일 경로를 썼으며 req였음) 
		// 파일 경로가 아닌 다시 요청할 서블릿의 어노테이션에 작성된 주소를 써야 함
		// *** 리다이렉트 역시 get요청 ***
		
		resp.sendRedirect("/fr/result");
		
		
	}

}
