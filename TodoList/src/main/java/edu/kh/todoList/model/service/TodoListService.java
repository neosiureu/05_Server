package edu.kh.todoList.model.service;

import java.util.Map;

/*
유지보수성 + 확장성 + 테스트 용이성
Controller는 ServiceImpl을 직접 쓰지 않고 Service 인터페이스에 의존한다. 즉 인터페이스 자체만 부르게 된다.
그러면 구현체가 바뀌어도 Controller는 그대로
*/


// 쉽게 말해 NewServiceImpl이라는 클래스라는 더 나은 서비스 파일이 만들어졌을 때 쉽게 교체가 가능하도록 하기 위해서

// 주로 서비스 과정에서 따로 뺴놓음


public interface TodoListService {

	
	/**
	 * 할일 목록을 반환하는 서비스 
	 * @return todoList + 완료된 개수를 가지고 올 map
	 */
	Map<String, Object> todoListFullView();
	
	

}
