package com.example.lesson01;

public class Data {// 이건 스프링 빈 아닌 그냥 클래스
	// 필드
	private int id; // private으로 은닉화
	private String name;  // 필드명이 key value가 된다
	
	// 메소드
	public int getId() { // 누구든 접근가능하도록 public , getter는 갖고있는걸 준다- return하기
		return this.id; // 여기서 this는 이 클래스 거라는 것, 여기서 없어도 됨
	} // 이 필드를 밖으로 내보내준다
	
	public void setId(int id) { //외부 input 받아와서 셋팅
		this.id = id; //외부 받아온 id값을 필드에 저장해 셋팅
	} // 내 필드에 셋팅해준다 ,리턴할 게 없으니 void

	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
