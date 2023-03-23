package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.dao.UserMapper;

@Service
public class UserBO {

	@Autowired
	private UserMapper userMapper;
	
	public int addUserAsField(String name, String yyyymmdd, String email, String introduce) {
		return userMapper.insertUserAsField(name, yyyymmdd, email, introduce); 
	}
	
}
