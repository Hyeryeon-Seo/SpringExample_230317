package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.dao.UserMapper;
import com.example.lesson04.model.User;

@Service
public class UserBO {

	@Autowired
	private UserMapper userMapper;
	
	// t- void (int 안쓸수있음)
	public int addUserAsField(String name, String yyyymmdd, String email, String introduce) {
		return userMapper.insertUserAsField(name, yyyymmdd, email, introduce); 
	}
	
	// input:X(입력값없이 그냥 가져올것)   output:User(최신 가입자) 
	public User getLatestUser() {// 내가 만든 user import
		return userMapper.selectLatestUser();
	}
	
	// input:name   output:boolean (그렇다 아니다) 
	public boolean existUserByName(String name) {  // true면중복
		return userMapper.existUserByName(name);
	}
	
	
}
