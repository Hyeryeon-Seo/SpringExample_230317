package com.example.lesson02.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.lesson02.model.UsedGoods;

@Repository // db 저장소와 가장 가까운
//interface인터페이스 로 만든다
public interface UsedGoodsMapper {
	
	// input: X, output: List<UsedGoods>
	public List<UsedGoods> selectUsedGoodsList();
	
}
