package edu.kh.todoList.model.service;


import static edu.kh.todoList.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import edu.kh.todoList.common.JDBCTemplate;
import edu.kh.todoList.model.dao.TodoListDAO;
import edu.kh.todoList.model.dao.TodoListDAOImpl;
import edu.kh.todoList.model.dto.Todo;

public class TodoListServiceImpl implements TodoListService {
	private TodoListDAO dao = new TodoListDAOImpl();
	

	@Override
	public Map<String, Object> todoListFullView() {
		
		Connection conn = getConnection();
		
		// 커넥션을 생성한다. 템플릿에 있던 jdbcTemlplate.getconnecion
		
		// dao 호출 및 반환하기
	
		// 1) 할일 목록을 얻어오는 DAO를 호출한다
		// 2) 완료된 할일 개수 카운트
		// 3) Map에 각 데이터를 모아 리턴
		
		// 1) 할일 목록을 얻어오는 DAO를 호출한다
		
		List<Todo> todoList = dao.todoListFullView(conn);
		
		
		
		// 2) 완료된 할일 개수 카운트
		
		int completeCount = dao.getCompleteCount(conn);
		
		
		// 3) Map에 각 데이터를 모아 리턴
		
		
		
		
		return null;
	}
	
	
	

}
