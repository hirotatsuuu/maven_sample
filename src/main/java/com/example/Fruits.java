package com.example;

import java.util.List;

import com.example.dao.FruitsDao;
import com.example.dto.FruitsDto;

public class Fruits {
	public static void main(String[] args) {
		for (FruitsDto fruitsDto: getFruits()) {
			System.out.println(fruitsDto.getId());
			System.out.println(fruitsDto.getName());
			System.out.println(fruitsDto.getPrice());
		}
	}

	public static List<FruitsDto> getFruits () {
		FruitsDao fruitsDao = new FruitsDao();
		List<FruitsDto> fruits = fruitsDao.findAll();
		return fruits;
	}
}
