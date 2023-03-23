package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.model.Review;

@RestController // 스프링 빈 등록 (맨처음에 항상 해주기, 안그럼 null)
public class Lesson03Ex01RestController {

	@Autowired
	private ReviewBO reviewBO; // BO 거 인젝션 
	
	// http://localhost/lesson03/ex01?id=5
	@RequestMapping("/lesson03/ex01")
	public Review ex01( // 여기서 Review는 model,DTO, 이라고 한다
			// 이 controller에서 쓰이는 @RequestParam""은 입력받는 파라미터명 - 주소창에서든, lesson04에서 보듯이 jsp의 (post방식등) input 등에서 받은 파라미터든
			
			@RequestParam("id") int id // 필수 파라미터 - 여기서 id 하나만 써도 되나 여러개면 value=도 써줘야
			// @RequestParam(value="id") int id   // (int 써주면 null이될 수 없는) '필수 파라미터'
			// @RequestParam(value="id", required=true) int id  // 필수 파라미터 (위와 같음)
			// @RequestParam(value="id", required=false) Integer id   // 비필수 파라미터
			// @RequestParam(value="id", defaultValue="1") int id // 비필수 이면서 디폴트 1
			) {
		 return reviewBO.getReview(id); // bo에서 받은 것 리턴 _ list => JSON
		// return null;
	}
		
	
}
