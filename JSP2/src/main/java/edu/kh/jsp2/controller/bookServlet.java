package edu.kh.jsp2.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jsp2.dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




@ WebServlet("/book/list")
public class bookServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청 처리
		// Book으로 제네릭 된 리스트를 생성한다.
		
		List<Book> bookList = new ArrayList<Book>();
		
		
		// bookList에 데이터 추가
		// (이 부분에서 DB가 연결되어 있다면 여기서 service로 연결함 service => dao => db)
		
		bookList.add(new Book("자바란 무엇인가","둘리",10000));
		bookList.add(new Book("HTML이란 무엇인가","홍길동",20000));
		bookList.add(new Book("JS 무엇인가","이순신",15000));
		bookList.add(new Book("CSS란 무엇인가","짱구",50000));
		bookList.add(new Book("서블릿이란 무엇인가","훈이",40000));
		bookList.add(new Book("JSP란 무엇인가","둘리",80000));
		bookList.add(new Book("스프링이란 무엇인가","유리",60000));
		
		// 위 bookList를 request 위임된 JSP객체에서도 유지하여 사용할 수 있도록 request scope의 객체에 속성을 통해 추가한다
		// 이 서블릿단에서 임의로 만들었기 때문에 반드시 setAttribute해야 다음 JSP에서 알아먹을 수 있다
		
		req.setAttribute("bookList", bookList); // 이제 req범위의 변수가 bookList가 키이며 리스트가 그 값으로 들어감
		
		// 응답 처리
		// JSP로 요청 위임 webapp폴더 기준 어디로 위임해야 하는가
		
		req.getRequestDispatcher("/WEB-INF/views/book/bookList.jsp").forward(req, resp);
		
	}

}
