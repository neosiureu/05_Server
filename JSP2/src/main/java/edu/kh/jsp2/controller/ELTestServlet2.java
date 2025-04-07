package edu.kh.jsp2.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/el/scope")
public class ELTestServlet2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// a태그로 요청하면 post는 없다
		
		//4) 요청처리 => 이번에 해봄
		
		
		// 스코프 내장객체는 네 단계의 범위가 존재한다
		
		
		// a) page scope => 서블릿에서는 이 객체를 사용하지 못하며 위임받은 JSP파일에서만 확인이 가능하다. 그 JSP파일 위임받은 한 페이지. 
		
		
		// b) request scope => 요청받은 servlet과 요청이 위임된 해당 JSP에서까지 유지되는 객체
		
		
		// b-1) 객체에 값을 추가하는 방법: 범위객체.setAttribute("key",주고 싶은 value);
		// b-2) 객체에서 값을 얻어오는 방법: Object 범위객체.getAttribute("key");
		// 반환형이 최상위 클래스이기 때문에 특정 객체의 메서드 필요 시에는 다운캐스팅해야 함
		
		
		req.setAttribute("requestValue", "request scope 객체에 세팅한 값");
		// 사실 이는 requestValue =  request scope 객체에 세팅한 값 <- 이런 수식을 쓴 것과 마찬가지
		
		
		System.out.println(req.getAttribute("requestValue"));
		// 객체를 html에서 얻어와서 getParameter를 해봤지만 set은 처음 해봄
		
		
		
		
		/* c) session scope => 클라이언트가 서버에 첫 요청했을 때 서버쪽에 생성되는 객체. (index.html 메인 페이지 보여달라고 할 당시에)
		 클라이언트가 브라우저를 종료하거나 지정된 세션 만료 시간이 지나면 사라진다
		 위 둘이 아니면 모든 페이지에서 지속적으로 유지된다.*/
		
		
		// c-1) session scope: 세션스코프 객체는 자기보다 작은 범위인 page 또는 request에서 뽑아낼 수 있다.
		HttpSession session =  req.getSession();
		// c-2) session scope에 값을 세팅한다
		session.setAttribute("sessionValue", "session scope객체에 세팅한 값");
		
		
		
		
		/* d) application scope 
		서버 전체에 단 하나만 존재 => 모든 클라이언트가 공유
		서버 시작시에 태어나며 서버를 꺼야만 소멸		
		*/
		
		
		// d-1) application scope 객체 얻어오기
		// requset session page 모두 가능
		 ServletContext applicaiton = req.getServletContext(); // ServeltContext가 어플리케이션 범위 객체랑 사실 똑같은거임
		
		 
		 
		// d-2) 값 세팅
		 
		 applicaiton.setAttribute("applicationValue", "application scope객체에 세팅한 값");
		 
		
		//5) 응답처리 경로 설정
		String path = " ";
		
		
		
		
		// 범위별 우선순위 확인
		// 좁은 범위가 우선순위 높음
		// page > request > session > application
		
		// 그러면 key가 같은 네가지 범위의 객체를 준비해서 범위별로 값을 추가해봐야겠다. (page는 여기서 어차피 못다룸)
		
		req.setAttribute("menu", "짬뽕(request)");
		session.setAttribute("menu", "짜장(session)");
		session.setAttribute("menu", "볶음밥(application)");
		
		
		
		
		
		
		
		// 6) 디스패쳐
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/el/scope.jsp");
		
		
		
		
		
		// 7) 포워딩
		
		dispatcher.forward(req, resp);
		
		
		
	}
	

}
