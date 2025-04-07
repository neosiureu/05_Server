package edu.kh.todoList.model.dao;

import java.sql.Connection;
import java.util.List;

import edu.kh.todoList.model.dto.Todo;

public class TodoListDAOImpl implements TodoListDAO {
	
	// JDBC 객체를 참조하는 참조변수 선언 + Properties 객체를 참조할 변수를 선언
	// TodoListDAOImpl 기본 생성자 내부에서 해야하는 일
	// /xml/sql/xml 경로를 읽어온다.

	
	@Override
	public List<Todo> todoListFullView(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public int getCompleteCount(Connection conn) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
