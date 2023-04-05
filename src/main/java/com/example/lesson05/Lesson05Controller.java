package com.example.lesson05;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson05")
@Controller
public class Lesson05Controller {

	@GetMapping("/ex01") //주소 치고 들어갈 것이라서 getMapping이든 requestMapping이든 가능
	public String ex01() {
		return "lesson05/ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(Model model) { // 리스트를 만들고 Model에 담아 jsp에서 사용하도록 함
		// 이전처럼 jsp에서 자바문법으로 list만드는게 아니라 
		// 이제는 여기controller에서 - 서버가 무조건 데이터를 관리하고, 모델에 담아주면, jsp에서 그것만 쓸 수 있게 한다
		
		// List<String>
		List<String> fruitList = new ArrayList<>();
		fruitList.add("사과");
		fruitList.add("포도");
		fruitList.add("망고");
		fruitList.add("블루베리");
		fruitList.add("딸기");
		model.addAttribute("fruits", fruitList); // jsp에서 이 리스트를 꺼낼 key는 "fruits"
		
		// List<Map> (실제로는 리스트자체보단 리스트안의맵 형식으로 내려주는 경우가 많아)
		List<Map<String, Object>> userList = new ArrayList<>();
		Map<String, Object> user = new HashMap<>();
		user.put("name", "서혜련");  // map(user)에 key, value 넣기
		user.put("age", 27);
		user.put("hobby", "피아노, 작곡");
		userList.add(user); // 유저리스트에 이 user 한 사람의 정보 map 담아주기 
		
		// (새로운 user담을시, 같은 'user'라는 map명 쓰더라도 new해주면 됨)
		user = new HashMap<>();
		user.put("name", "서혜단");
		user.put("age", 25);
		user.put("hobby", "베이킹");
		userList.add(user); // 방금 새로 만든 user 넣기
		
		model.addAttribute("users", userList);
		
		
		return "lesson05/ex02";
	}
	
	
	@GetMapping("/ex03") 
	public String ex03(Model model) {
		Date today = new Date(); // Date객체, jsp에서 만들지말고 controller에서 만들어서 전달해야 /java.util.Date import 
		model.addAttribute("today", today); // today라는 객체를 model에 담아야 사용 가능
		return "lesson05/ex03";
	}
	
	@GetMapping("/ex04")
	public String ex04() {
		return "lesson05/ex04";
	}
	
	
}
