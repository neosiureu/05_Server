package edu.kh.todoList.model.service;

import java.util.Map;

import edu.kh.todoList.model.dto.Todo;

/*
유지보수성 + 확장성 + 테스트 용이성
Controller는 ServiceImpl을 직접 쓰지 않고 Service 인터페이스에 의존한다. 즉 인터페이스 자체만 부르게 된다.
그러면 구현체가 바뀌어도 Controller는 그대로
*/


// 쉽게 말해 NewServiceImpl이라는 클래스라는 더 나은 서비스 파일이 만들어졌을 때 쉽게 교체가 가능하도록 하기 위해서

// 주로 서비스 과정에서 따로 뺴놓음


public interface TodoListService  {
	
	/**
	 * 할일 목록을 반환하는 서비스 
	 * @return todoList + 완료된 개수를 가지고 올 map
	 * @throws Exception 
	 */
	Map<String, Object> todoListFullView() throws Exception ;

	
	/** 할일을 추가하는 서비스단
	 * @param title
	 * @param detail
	 * @return int  => 성공 시 추가된 행의 개수가 넘어옴. 실패하면 0이 반환
	 * @throws Exception
	 */
	int todoAdd(String title, String detail) throws Exception;


	/** 할일 상세 조회 서비스
	 * @param todoNo 
	 * @return null또는 Todo 객체
	 * @throws Exception
	 */
	Todo todoDetail(int todoNo) throws Exception ;


	/** 완료여부 변경 서비스
	 * @param todoNo
	 * @return
	 * @throws Exception
	 */
	int todoComplete(int todoNo) throws Exception;


	/** 할일 삭제 서비스
	 * @param todoNo
	 * @return
	 * @throws Exception
	 */
	int todoDelete(int todoNo) throws Exception;


	/** 할일 수정 서비스
	 * @param title
	 * @param detail
	 * @param todoNo
	 * @return 수정 성공한 행의 개수
	 * @throws Exception
	 */
	int todoUpdate(String title, String detail, int todoNo) throws Exception;

	
	

	
	

}
