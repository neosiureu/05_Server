package edu.kh.jsp2.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/fr/forward")
public class ForwardServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// requset scope에 값을 세팅한다
		
		req.setAttribute("str", "안녕하세요");
		// 5단계 => webapp폴더 기준 JSP 폴더 경로를 작성
		String path = "/WEB-INF/views/fr/forward_result.jsp";
		
		// requestDisapatcher를 이용하여 req resp 위임하기
		
		req.getRequestDispatcher(path).forward(req, resp);
		// 6단계 + 7단계
		
	}
	

}
