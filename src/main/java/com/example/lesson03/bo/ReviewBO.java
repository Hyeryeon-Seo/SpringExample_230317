package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.dao.ReviewMapper;
import com.example.lesson03.model.Review;

@Service // (BO-비즈니스 로직) spring bean될 수 있도록 이 레이어에 맞는 이름 부여 후 import
public class ReviewBO {

	@Autowired
	private ReviewMapper reviewMapper; // DI. DAO의 맵퍼 인젝션
	
	// input: X   output: Review_리턴할 것(->Controller에게 응답)
	public Review getReview(int id) { // Integer가 되면 null도 가능해서 x
		return reviewMapper.selectReview(id); // 위에서 오토와이어드로 맵퍼 인젝션된 상태이니 리턴 써주면됨
	}
	
}
