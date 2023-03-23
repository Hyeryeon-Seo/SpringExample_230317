package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.model.Review;

@RequestMapping("/lesson03/ex02") // Insert할 예제
@RestController // responsebody가 붙어있는 restcontroller
public class Lesson03Ex02RestController {

	@Autowired
	private ReviewBO reviewBO; // null아닌 상태
	
	// http://localhost/lesson03/ex02/1
	// 객체를 활용해 insert
	@RequestMapping("/1")
	public String ex02_1() { // request parameter비어있어서(안받을거) ()안에 안 넣어도 됨
		Review review = new Review(); // 일반 java bean으로 만든다 (new ..)
		review.setStoreId(7); // model안 Review클래스의 set메소드
		review.setMenu("삼겹혼밥세트");
		review.setUserName("바다고양이");
		review.setPoint(3.5);
		review.setReview("혼자 먹기 적당하네요");
		// 나머지 칼럼 id, createdAt, updatedAt 빼고
		// 객체 하나 만들었고 채우는 것 까지 함
		// bo에게 인서트 요청하기
		
		int rowCount = reviewBO.addReview(review);
		
		return "성공된 행의 개수 : " + rowCount; // responsebody에 이문장이 통으로 들어가게 된다
	}
	
	
	// 파라미터 하나씩 쪼개서 넘기기
	// http://localhost/lesson03/ex02/2
	@RequestMapping("/2")
	public String ex02_2() {
		
		int rowCount = reviewBO.addReviewAsField(4, "콤비네이션R", "마이켈", 5.0, "역시 콤비네이션 맛있어요ㅠㅠ"); // add하되 field를 따로따로
		return "성공한 행의 개수 : " + rowCount;
	}
	
	
	
	
	
}
