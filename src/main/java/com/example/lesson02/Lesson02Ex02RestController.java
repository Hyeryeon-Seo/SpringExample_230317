package com.example.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson02.bo.UsedGoodsBO;
import com.example.lesson02.model.UsedGoods;

@RestController // json으로 리턴할거니까 restcontroller
// 여기서 응답 등 다 일어난다
public class Lesson02Ex02RestController {

	@Autowired // bo도 스프링빈이므로 오토와이어드 인젝션
	private UsedGoodsBO usedGoodsBO;
	
	// http://localhost/lesson02/ex01
	@RequestMapping("/lesson02/ex01")
	public List<UsedGoods> ex01() { // 여기서 응답, input은 없고 내릴 것은 UsedGoods
		// bo에서 만들고 import하고 catalina로 임포트 하면 안됨
		// 일단 List<UsedGoods> usedGoodsList = ; 이렇게만 써두고 
		List<UsedGoods> usedGoodsList = usedGoodsBO.getUsedgGoodsList();
		return usedGoodsList; // list 리턴 => 결과적으로는 JSON String (Response body에 들어감)
		
		
	}
	
	
	
}
