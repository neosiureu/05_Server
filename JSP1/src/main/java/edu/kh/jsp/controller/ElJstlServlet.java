package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


// web.xml에 있던 매핑역할을 함 ,즉 html에서 만들었던 명령이 왔을 때 자동으로 이 클래스로 오게 하는 방법

// @WebServlet("/el_jstl") 소괄호 안쪽의 문자열은 매핑될 주소임
// 주소 작성 시 반드시 맨 앞에 "/"로 시작해야 함
// -> 미작성 시 서버가 켜지지 않음.

@WebServlet("/el_jstl")
public class ElJstlServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// JSP에게 오직 화면을 만들어달라고만 하면 됨
		
		// 1) JSP의 경로를 지정한다. webapp폴더 기준으로 작성해야 한다.
		String path = "/WEB-INF/views/el_jstl.jsp";
		
		// 2) 요청 대리인을 얻어와서 JSP로 명령어를 전달한다. 

		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
		dispatcher.forward(req, resp);
		
	}
	
	

}
