package edu.kh.todoList.model.dao;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.module.ModuleDescriptor.Builder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Properties;

import static edu.kh.todoList.common.JDBCTemplate.*;
import edu.kh.todoList.model.dto.Todo;

public class TodoListDAOImpl implements TodoListDAO {
	
	// JDBC 객체를 참조하는 참조변수 선언 + Properties 객체를 참조할 변수를 선언
	// TodoListDAOImpl 기본 생성자 내부에서 해야하는 일
	// /xml/sql/xml 경로를 읽어온다.
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop; // xml을 쉽게 읽어오기 위한 객체가 Properties
	
	
	public TodoListDAOImpl() {
		// 생성되자마자 sql.xml을 뽑기 위해 이미 읽어놓은 상태여야 한다.
		// 따라서 기본 생성자 필수
		
		// TodoListDAOImpl 객체가 생성되는 순간은 
		//ServiceImpl파일에서 처음에 private TodoListDAO dao = new TodoListDAOImpl(); 할때임
		
		// 파일의 내용을 읽어와 prop객체에 k:v로서 세팅한다
		
		
		// src-main resources을 기준으로 사고한다.
		// 경로상의 내용을 절대경로로 얻어와 문자열로 저장한다.
		
		try {
			String filepath = TodoListDAOImpl.class.getResource("/xml/sql.xml").getPath();
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filepath));
		} catch (Exception e) {
			System.out.println("sql.xml로드 중 예외 발생");
			e.printStackTrace();
		}
		

	}
	
	
	@Override
	public List<Todo> todoListFullView(Connection conn) throws Exception {
		// 결과저장용 변수 선언
		
		List<Todo> todoList = new ArrayList<Todo>(); // 일단 add를 하던가 해야하므로 초기값 자체가 arrayList여야 함
		
		try {
			// sql작성 => 여기서 작성 안 한다며. sql.xml에서 entry태그를 만들어 뽑아쓰자
			// 함수이름하고 키 값을 똑같이 entry에 설정해야 헷갈리지 않는다.
			
			String sql  = prop.getProperty("todoListFullView"); // 인자로 들어온 문자열의 키를 가진 태그 사이의 내용이 들어옴
			
			stmt  = conn.createStatement(); // conn은 서비스단에서 받음
			
			rs = stmt.executeQuery(sql); // result set, 즉 한 셀의 값을 반환한다. SELECT할 때 쓴다 
			// 반면 DML을 할 때는 결과 행의 개수를 반환한다.
					
			
			while(rs.next()) {
				// 아예 rs의 값을 전부 뽑아 todo객체를 새로 만들어 List에 담는다는 계획
				
				// TODO_COMPLETE의 값이 int 0이나 1로 나올테니 그 결과가 1이면 boolean1이, 0이면 boolean0이 나온다.
				boolean complete  = rs.getInt("TODO_COMPLETE") ==1;
				
				
				// Builder패턴 => 특정 값으로 초기화 된 객체를 쉽게 만드는 방법
				// -> Lombok에서 제공하는 @builder 어노테이션을 DTO에 작성한다
				
				Todo todo = Todo.builder().todoNo(rs.getInt("TODO_NO"))
						.todoTitle(rs.getString("TODO_TITLE"))
						.todoComplete(complete)
						.regDate(rs.getString("REG_DATE"))
						.build();
				todoList.add(todo);
			}
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		return todoList;
	}

	
	@Override
	public int getCompleteCount(Connection conn) throws Exception {
		int completeCount =0;
		
		
		try {
			String sql  = prop.getProperty("getCompleteCount");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				completeCount = rs.getInt(1); // 조회된 내용들 중 첫 컬럼의 rs를 가지고 오겠다.
				//COUNT(*)이라는 값을 그대로 가져와도 되지만 별칭을 주거나 컬럼의 순서 번호를 적는다
			}
					
		} finally {
			close(rs);
			close(stmt);
		}
		
		return completeCount;
	}


	
	@Override
	public int todoAdd(Connection conn, String title, String detail) throws Exception {
		int result =0;
		try {
			String sql = prop.getProperty("todoAdd"); 
			pstmt = conn.prepareStatement(sql);
	
			pstmt.setString(1, title);
			pstmt.setString(2, detail);
			
			result = pstmt.executeUpdate(); // 인자 없이 전달
			
			
		} finally {
			
			close(pstmt);			
		}
		
		
		
		return result;
	}


	@Override
	public Todo todoDetail(Connection conn, int todoNo) throws Exception {
		Todo todo = null; // 결과저장용 변수 선언
		try {
			String sql = prop.getProperty("todoDetail");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, todoNo);
			
		    rs=	pstmt.executeQuery(); //todoNo가 일치하는 딱 한 행만
		    
		    if(rs.next()) {
		    	boolean complete = rs.getInt("TODO_COMPLETE") ==1;
		    	todo = Todo.builder()
		    			.todoNo(todoNo)
		    			.todoTitle(rs.getString("TODO_TITLE"))
		    			.todoDetail(rs.getString("TODO_DETAIL"))
		    			.todoComplete(complete)
		    			.regDate(rs.getString("REG_DATE"))
		    			.build();
		    }
		} 

		finally {
			close(rs);
			close(pstmt);
		}
		return todo;
	}


	@Override
	public int todoComplete(Connection conn, int todoNo) throws Exception {
		int result=0;
		try {
			String sql = prop.getProperty("todoComplete");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, todoNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
			
		return result;
	}


	@Override
	public int todoDelete(Connection conn, int todoNo) throws Exception {
		
		int result=0;
		
		try {
			String sql = prop.getProperty("todoDelete");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, todoNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
			
		return result;
	}


	@Override
	public int todoUpdate(Connection conn, int todoNo, String title, String detail) throws Exception {
		
		int result=0;
		

		try {
			String sql = prop.getProperty("todoUpdate");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, detail);
			pstmt.setInt(3, todoNo);	
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	
	
	
	
	
	
	

	
}
