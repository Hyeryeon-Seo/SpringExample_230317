package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.dao.ReviewMapper;
import com.example.lesson03.model.Review;

@Service // (BO-비즈니스 로직) spring bean될 수 있도록 이 레이어에 맞는 이름 부여 후 import
public class ReviewBO {

	@Autowired
	private ReviewMapper reviewMapper; // DI. DAO의 맵퍼 인젝션
	
	// ex01
	// input: X (DAO에게서)   output: Review_리턴할 것(->Controller에게 응답)
	public Review getReview(int id) { // Integer가 되면 null도 가능해서 x
		return reviewMapper.selectReview(id); // 위에서 오토와이어드로 맵퍼 인젝션된 상태이니 리턴 써주면됨
	}
	
	// ex02_1
	// input : Review   output: int (성공한 행의 개수)
	public int addReview(Review review) { // (자료형 이름)
		return reviewMapper.insertReview(review);
	}
	
	// ex02_2
	// addReviewAsField(4, "콤비네이션R", "마이켈", 5.0, "역시 콤비네이션 맛있어요ㅠㅠ");
	public int addReviewAsField(
			int storeId12, String menu33, String userName44, 
			Double point33, String review21) { 
		// db의 칼럼명과 다르게 할 수 있지만-그냥 아래 return에 써줄거랑만 맞추면 됨
		// (의미없는 이름으로 써도.. 됨- 여기서만 사용하므로 컨트롤러, 맵퍼와도 상관없음) 보통 맞춘다 
		
		return reviewMapper.insertReviewAsField(storeId12, menu33, userName44, point33, review21);
	}
	
	// ex03 - update
	// input : id, review     output : 성공된 행의 개수 int
	public int updateReviewById(int id, String review) { // by id - by 뒤는 where절 내용 주로
		return reviewMapper.updateReviewById(id, review);
	}
	
	// ex04 - delete
	// int해도 되지만 (삭제된 행 개수 받을 수 ) 그냥 안돌려줘도 됨 - void (아무것도 리턴 x)
	public void deleteReviewById(int id) {
		reviewMapper.deleteReviewById(id);
	}
	
	
	
}
