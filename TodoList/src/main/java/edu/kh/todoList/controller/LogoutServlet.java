package edu.kh.todoList.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(); //이 안에도 로그인 멤버가 있다
		// 세션 객체 하나에 여러 정보들이 키 값으로 있는 상태일 수 있음
		// 정확히 loginMember만 딱 없애는 방법
		
		// session.removeAttribute("loginMemeber");
		// 해당 키에 해당하는 값만 삭제
		
		System.out.println(session.getAttribute("loginMemeber"));

		// 다만 세션 자체를 무효화하는 방법 session.invalidate()메서드 => 전체 세션을 초기화시킴
		// -> 해당 클라이언트가 저장한 세션에 저장된 모든 속성이 전부 삭제
		
		session.invalidate();
		
		resp.sendRedirect("/");
		
	}
	
}
