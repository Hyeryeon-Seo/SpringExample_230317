package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.dao.UsedGoodsMapper;
import com.example.lesson02.model.UsedGoods;

@Service  
public class UsedGoodsBO { // bo는 맵퍼를 불러서 - 달라고 해야함

	@Autowired // spring bean을 가져오고 싶을때 new로 들고오는게 아니고, 네모 컨테이너 에 다 있는데  이 어노테이션으로 스프링 빈 들고올 수 있다 
	// DI(Dependency Injection): spring container에 있는 spring bean을 주입 -> 그러면 null되지않고 그대로 온다 / 사실 (더 좋은?) 다른 여러 방식도 있다
	// dao의 Mapper
	private UsedGoodsMapper usedGoodsMapper;
	
	// input (파라미터) : X 
	// output (리턴타입): List<UsedGoods>
	public List<UsedGoods> getUsedgGoodsList() {
		List<UsedGoods> usedGoodsList = usedGoodsMapper.selectUsedGoodsList(); 
		return usedGoodsList; // dao한테 받은 걸 다시 controller에게 돌려줌
	}
	
	
}
