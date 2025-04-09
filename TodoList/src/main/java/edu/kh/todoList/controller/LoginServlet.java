package edu.kh.todoList.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;



@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");
		String userPw = req.getParameter("userPw");
		
		//service 요청. 즉 userId와 userPw가 둘 다 일치하는 회원이 있는지 일단 DB에서 조회하게 됨 => 
		// 그에따른 결과를 반환받아 alert로 띄워주는 것이 로그인
		// 결과값을 반환하는 (User객체 & null)
		
		HttpSession session = req.getSession();
		// 세션 스코프에 로그인한 회원의 정보를 저장
		// 브라우저 종료 및 세션 만료 외에는 모든 페이지에서 로그인한 정보를 이용할 수 있게 함
	
		session.setAttribute("loginMember", userId);
		
		resp.sendRedirect("/");	
	}
}
