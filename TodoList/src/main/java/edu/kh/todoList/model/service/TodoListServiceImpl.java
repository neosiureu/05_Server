package edu.kh.todoList.model.service;


import static edu.kh.todoList.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.todoList.common.JDBCTemplate;
import edu.kh.todoList.model.dao.TodoListDAO;
import edu.kh.todoList.model.dao.TodoListDAOImpl;
import edu.kh.todoList.model.dto.Todo;

public class TodoListServiceImpl implements TodoListService {
	
	private TodoListDAO dao = new TodoListDAOImpl();
	
	@Override
	public Map<String, Object> todoListFullView() throws Exception{
		
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

		// 왜 맵이라는 컬렉션을 쓰냐?
		// Map에 1,2번으로 얻어온 데이터를 세팅하여 리턴한다
		// -> 메서드에서 반환은 하나만 올 수 있으니까
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("todoList", todoList);
		map.put("completeCount", completeCount);
		
		
		close(conn);
		
		return map;
	}

	
	
	@Override
	public int todoAdd(String title, String detail) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.todoAdd(conn,title,detail);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}
		
		else {
			JDBCTemplate.rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	
	
	@Override
	public Todo todoDetail(int todoNo) throws Exception {
		
		Connection conn = getConnection();
		
		Todo todo = dao.todoDetail(conn, todoNo);
		
		close(conn);
		
		return todo;
	}

	
	
	@Override
	public int todoComplete(int todoNo) throws Exception {
		Connection conn = getConnection();
		int result = dao.todoComplete(conn, todoNo) ;
		
		if(result >0 ) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}



	
	@Override
	public int todoDelete(int todoNo) throws Exception {
		Connection conn = getConnection();
		int result = dao.todoDelete(conn, todoNo) ;

		if(result >0 ) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}



	@Override
	public int todoUpdate(String title, String detail, int todoNo) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		
		int result = dao.todoUpdate(conn, todoNo, title, detail);
		
		
		
		if(result >0 ) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		
		return result;
	}



	

}
