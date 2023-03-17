package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/ex01")
@RestController // @Controller + @ResponseBody _responsebody가  포함된 controller 
public class Lesson01Ex01RestController {

	// http://localhost:8080/lesson01/ex01/3
	@RequestMapping("/3") // Ex01Controller의 주소와 겹치지않도록
	public String ex01_3 () { // responsebody 어노 할 필요 없음
		return "<h3>@RestController을 사용해서 String을 리턴해본다.</h3>";
	}
	
	// http://localhost:8080/lesson01/ex01/4
	@RequestMapping("/4")
	public Map<String, String> ex01_4() {
		Map<String, String> map = new HashMap<>();
		map.put("이름", "서혜련");
		map.put("생년월일", "970628");
		map.put("설명", "..");
		return map;
	}
	
	// http://localhost:8080/lesson01/ex01/5
	@RequestMapping("/5")
	public Data ex01_5() { // 필드만 있고 getter setter만 있는 클래스 만들어서 하기_ Data를 통째로 리턴 
		Data data = new Data(); // data는 어노테이션 따로없으므로 일반자바 빈 만들기 (클래스 data 자체는 빈이 아니다)
		data.setId(1);
		data.setName("서혜련");
		return data; // responsebody 어노 있는 것과 같으므로 json형식으로 리턴 (jackson lib 때문)
		// string아닌 map이나, 데이터 값(key밸류있는) 리턴 시 > json 형식으로 응답
	}

	// http://localhost:8080/lesson01/ex01/6
	@RequestMapping("/6")
	public ResponseEntity<Data> ex01_6() { // 임포트, ResponseEntity라는 객체 (스프링 내장 객체), 최종적으로 내리는 게 Data json 
		Data data = new Data(); // 자바 bean
		data.setId(1);
		data.setName("서혜련");
		
		return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR); // 500에러는 무조건 콘솔 에러 봐야: 500 internal server error
		// return new ResponseEntity<>(data, HttpStatus.OK); // 한겹감싼 respon..en 으로 객체 만들어 리턴 () 안에 내릴 것 넣어줌
		// HttpStatus 결과실패성공인지 번호 내려줌 - 200 ok 
		// ResponseEntity: 데이터도 내리면서 상태 코드 번호도 변경하고 싶을 때 (있다는 정도만 알아두기)
	}


}
