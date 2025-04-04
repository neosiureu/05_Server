package edu.kh.jsp2.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/jstl/test")
public class JSTLTestServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 나중에 c:forEach를 이용할 것인데 연습을 위해서는 미리 List가 있어야 한다
		
		List<String> nameList = new ArrayList<String>();
		
		nameList.add("짱구");
		nameList.add("훈이");
		nameList.add("유리");
		nameList.add("철수");
		nameList.add("맹구");
		
		nameList.add("진구");
		nameList.add("비실이");
		nameList.add("퉁퉁이");
		nameList.add("이슬이");
		nameList.add("도라에몽");
	 	
		// requst scope 객체에 속성으로 이 리스트의 주소를 세팅한다
		
		// request scope는 현재 서블릿에서 위임된 JSP까지 유효하다.
		
		req.setAttribute("nameList", nameList);
		
		req.getRequestDispatcher("/WEB-INF/views/jstl/test.jsp").forward(req, resp);
		
		
		
	}
	

}
