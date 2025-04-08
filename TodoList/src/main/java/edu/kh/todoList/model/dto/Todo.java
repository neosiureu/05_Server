package edu.kh.todoList.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Todo {
	private int todoNo; //번호
	private String todoTitle; //제목
	private String todoDetail; //상세내용
	private boolean todoComplete; // 완료여부
	private String regDate; // 등록일
}
