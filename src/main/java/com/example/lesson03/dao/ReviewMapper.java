package com.example.lesson03.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.model.Review;

@Repository // .xml과 맵핑
public interface ReviewMapper {
	
	// ex01
	public Review selectReview(@Param("id") int id);
	// @Param annotation - controller에서 쓰는 것과 다르다 혼동 x - 이건 mybatis
	// 요청 아님.  request쓰면 안됨

	// ex02_1
	public int insertReview(Review review); // 파라미터 하나니 그냥 내린다
	
	// ex02_2
	// @Param 이 있기 때문에 하나의 맵이 xml로 넘어간다
	public int insertReviewAsField(
			@Param("storeId") int storeId24,  
			// 여기서도 뒤에 이름은 아무렇게 짓든 상관없는데, 
			// *** 앞의 param이름은 지었으면 그건 .xml에서도 #{}에서 맞춰줘야한다 
			/// 변수명은 레이어에서 그냥 지어주는거 그때그때 다른 레이어와 상관없음
			// 키 밸류 쌍으로 들어있는 ..맵
			@Param("menu") String menu43, 
			@Param("userName") String userName32, 
			@Param("point") Double point341, 
			@Param("review") String review2323);
	
}
