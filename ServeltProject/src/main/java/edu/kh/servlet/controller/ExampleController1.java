package edu.kh.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/* "/example1"이라는 클라이언트의 요청을 받아서 처리한 후 응답을 해줄 서블릿 클래스를 만든다
 그 서블릿의 이름이 ExampleController1이고 extends한다



import jakarta.servlet.http.HttpServlet; => http프로토콜 서비스를 지원하는 추상클래스
-> 상속 받아서 사용해야 한다
클래스만 만들어도 아직 그 자체가 서블릿이 된 것은 아님

[Servelt 등록 절차]
1. web.xml에 이 클래스가 서블릿이라고 직접 작성하는 것이 하나의 방법
"/example1"이 오면 이 클래스가 처리하겠다고 말함

2. @WebServlet()이라는 방식을 이용하는 방법


*/



// controller의 역할: request에 따른 어떤 service를 호출하지 제어하며 어떻게 응답할지 제어하는 역할

public class ExampleController1 extends HttpServlet {
	
	/*
	 * what is doGet()?
	 * get방식의 요청이 왔을 때 처리하는 요청
	 * HttpServlet이 제공하는 메서드를 오버라이딩하여 스스로 정의
	 * */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		// HttpServeltRequest
		/* -클라이언트가 요청 시 생성되는 객체
		요청 시 전달된 데이터, 또는 요청한 클라이언트의 정보와 같은 유연한 요청 처리를 하기 위한 객체를 제공*/		
		
		
		
		// HttpServletResponse
		/* -클라이언트가 요청 시 생성되는 객체
		서버가 클라이언트에게 응답하기 위한 방법을 제공*/
		//ex) 서버에서 클라이언트로 연결된 출력용 스트림. 특히 printWriter
		
		System.out.println("----이름, 나이를 입력받아 처리하는 서블릿 코드---");
		
		// 요청 시 입력 된 이름과 나이를 전달받아 오기
		
		// 요청 시 전해주는 데이터 자체는 parameter라 한다. 클라이언트와 서비스의 매개체가 된다.
		
		// 다른곳에 값을 전달 받아올 때 사용
		
		// 메서드 이름이 getParameter => 요청에 대한 모든 데이터는 HttpServeltRequest이고 데이터 역시 가지고 있음. 따라서 이렇게 해야함
		// req.getParameter("name 속성값");
		// 요청 시 전달된 데이터 중 name속성값이 일치하는 데이터의 value를 얻어와 String형태로 반환
		
		// HTML파일에서 얻어오는 모든 값은 String형이다. 
		
		
		String name = req.getParameter("inputName"); //name속성값을 그대로
		String age = req.getParameter("inputAge"); //name속성값을 그대로
		// req안에 ?inputName=홍길동&inputAge=20이 들어옴
		
		
		System.out.println("입력받은 이름: " + name);
		System.out.println("입력받은 나이: " + age);
		
		// 서버에서 클라이언트로 응답을 처리하는 코드
		// 1) 서버에서 응답해줄 HTML 코드를 만들어 클라이언트에게 전달해준다. (response)  <- 이제 이 부분을 해야 함. 
		// 서버 자체에서 응답할 때 클라이언트에게 뭔가를 표시해줘야 함

		// 2) 클라이언트의 브라우저가 응답받은 HTML코드를 해석하여 화면에 출력해줌
		
		
		
		
		
		
		
		// 서버에서 클라이언트에 응답하려면 HttpServletResponse 객체 이용
		
		// 응답처리 과정1) 응답하는 문서 형식과 인코딩을 지정 마치 html파일 제일 처음에 했던것처럼 
		resp.setContentType("text/html; charset=UTF-8"); // reponse객체의 참조변수
		
		
		// 응답처리 과정2) 서버에서 클라이언트로 연결될 PrintWriter와 같은 출력용 스트림을 얻어온다
		
		PrintWriter out = resp.getWriter();
		
		
		// 응답처리 과정3) 출력할 HTML코드를 만들기
		StringBuilder sb = new StringBuilder();
		
		sb.append("<!DOCTYPE html>");
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>서버 응답 페이지</title>");
		sb.append("</head>");
		
		sb.append("<body>");
		sb.append("<h1>응답페이지입니다</h1>");
		sb.append("<p>입력 받은 이름: " + name + "</p>");
		sb.append("<p>입력 받은 나이: " + age + "</p>");		
		sb.append("</body>");
		
		
		sb.append("</html>");
		
		
		
		
		// 응답처리4: 출력 스트림을 이용해 클라이언트에게 HTML코드를 출력하여 응답한다.
		
		out.write(sb.toString()); // sb의 내용을 다 전달
		
	}
	

}
