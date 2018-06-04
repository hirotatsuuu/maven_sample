package com.example;

import java.util.List;

import com.example.dao.FruitsDao;
import com.example.dto.FruitsDto;
import com.example.service.FruitsService;

public class FruitsMain {
	public static void main(String[] args) {
		for (FruitsDto fruitsDto: getFruits()) {
			System.out.println(fruitsDto.getId());
			System.out.println(fruitsDto.getName());
			System.out.println(fruitsDto.getPrice());
		}

		FruitsService fruitsService = new FruitsService();
		fruitsService.setFruitsDao(new FruitsDao());
		boolean flag = fruitsService.isExist(1);
		System.out.println(flag ? "存在します" : "存在しません");
	}

	public static List<FruitsDto> getFruits () {
		FruitsDao fruitsDao = new FruitsDao();
		List<FruitsDto> fruits = fruitsDao.findAll();
		return fruits;
	}
}
