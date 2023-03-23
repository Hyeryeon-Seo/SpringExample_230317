package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
// UPDATE 

@RestController
public class Lesson03Ex03RestController {

	@Autowired
	private ReviewBO reviewBO;
	
	// ex03
	// UPDATE문 - 리뷰 내용 변경하기
	// http://localhost/lesson03/ex03?id=24&review=역시 도미노 피자!
	// id와 review 받아오기
	@RequestMapping("/lesson03/ex03")
	public String ex03(
		@RequestParam("id") int id,
		@RequestParam("review") String review) { // 이 두 개를 bo에게 넘긴다
		
		int rowCount = reviewBO.updateReviewById(id, review);
		return "변경 완료 : " + rowCount;
				
	}
	
}
