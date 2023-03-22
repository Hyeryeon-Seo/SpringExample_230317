package com.example.lesson03.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.model.Review;

@Repository // .xml과 맵핑
public interface ReviewMapper {
	
	public Review selectReview(@Param("id") int id);
	// @Param annotation - controller에서 쓰는 것과 다르다 혼동 x - 이건 mybatis
	// 요청 아님.  request쓰면 안됨
}
