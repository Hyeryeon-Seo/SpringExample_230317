package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/ex01") // 아래 모든 메소드 공통 앞 주소 써주기
@Controller // -> Spring container가 관리해주는 Spring bean이 되었다는 뜻 // Spring은 하나의 controller에 여러 메소드 만들 수 
public class Lesson01Ex01Controller { // spring bean으로 등록하기 위해서 위에 Controller 어노테이션붙이기 

	// http://localhost:8080/lesson01/ex01/1
	@RequestMapping("/1") // url path 매핑 (주소일뿐, 아래 메소드와는 상관이 없다, 별개)
	@ResponseBody    // 리턴되는 String이 통째로 ResponseBody에 담긴다 - '응답'(검사-네트워크에서 확인가능)으로 내려줌
	public String ex01_1() { // 메소드 만들기 - 리턴 타입 지정, 
		String text = "예제1번<br>문자열을 response body에 보내는 예제";  // response 자동으로 html로 해석되어 내려감
		return(text);
	}
	
	// http://localhost:8080/lesson01/ex01/2
	@RequestMapping("/2")
	public @ResponseBody Map<String, Object> ex01_2() { // 왼쪽 방식은 옛날 방식/ @ResponseBody 가 없으면 view인줄 알고 오류 404 
		// {"망고"=3, "석류"=15...}  java map
		// {"망고":3, "석류":15...} JSON String
		Map<String, Object> map = new HashMap<>();
		map.put("망고", 3);
		map.put("석류", 15);
		map.put("청포도", 20);
		map.put("블루베리", 65);
		
		// map 리턴했음에도 -> JSON으로 변환되어 내려감
		// web starter(spring boot..)안에 포함된 jackson 라이브러리가 있고 동작하기 때문
		return(map); 
		
	}
	
	
	
	
}
