package com.example.lesson06;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.UserBO;

@RequestMapping("/lesson06")
@Controller
public class Lesson06Controller {

	@Autowired
	UserBO userBO;
	
	// http://localhost/lesson06/ex01/add_user_view
	@GetMapping("/ex01/add_user_view")
	public String addUserView() {
		return "lesson06/addUser";
	}
	
	// AJAX 통신으로 오는 요청 결과는 반드시 String(꼭 리턴해야)이다, 또한 responsebody도 꼭 어노 붙이기 / ajax결과는 화면수가없다고 우선 봐야
	@PostMapping("/ex01/add_user")
	@ResponseBody 
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam(value="email", required=false) String email, // 비필수(db타입보고) (value, required=false붙이기)
			@RequestParam(value="introduce", required=false) String introduce) { // 비필수 
			
		// insert
		userBO.addUserAsField(name, yyyymmdd, email, introduce);
		
		return "성공";
	}
	
	@GetMapping("/ex01/result_view")
	public String resultView() {
		return "lesson06/result";
	}
	
	
	// 회원가입 화면
	// http://localhost/lesson06/ex02/add_name_view
	@GetMapping("/ex02/add_name_view")
	public String addNameView() {
		return "lesson06/addName";
	}
	
	// AJAX의 요청
	@ResponseBody
	@GetMapping("/ex02/is_duplication") // 에러 404 - 주소창 오류! (lesson06중복으로 여기다 씀 ㅠ)
	public Map<String, Boolean> isDuplication(
			@RequestParam("name") String name) {
			
		Map<String, Boolean> result = new HashMap<>();
		result.put("isDuplication", userBO.existUserByName(name));
		return result;
			
		
	}
	
	
	
	
}
