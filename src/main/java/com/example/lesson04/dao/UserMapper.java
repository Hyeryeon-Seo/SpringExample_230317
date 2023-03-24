package com.example.lesson04.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson04.model.User;

@Repository
public interface UserMapper {

	public int insertUserAsField( 
			//t - 그냥 void (돌려주지않고), insertUser (int는 행개수 리턴시 가능)
			// @Param("id") int id,  id는 할 필요가 없음 자동 등록
			@Param("name") String name,
			@Param("yyyymmdd") String yyyymmdd,
			@Param("email") String email,
			@Param("introduce") String introduce
			);
	
	public User selectLatestUser(); 
	// 하나의 유저 받기
	
	
	
}
