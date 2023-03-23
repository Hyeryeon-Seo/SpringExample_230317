package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;

@RestController
public class Lesson03Ex04RestController {

	@Autowired
	private ReviewBO reviewBO;
	
	// DELETE
	// http://localhost/lesson03/ex04?id=22
	@RequestMapping("/lesson03/ex04")
	public String ex04(
			@RequestParam("id") int id) {
		
		reviewBO.deleteReviewById(id); // 삭제된 행 개수 받을 수도 있지만 굳이 안해도 됨 어쩌피 수행한거라서 (rowCount 따로 안써도)
		return "삭제 완료";
		
	}
	
	
}
