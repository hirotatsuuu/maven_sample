package com.example.service;

import com.example.dao.FruitsDao;
import com.example.dto.FruitsDto;

public class FruitsService {

	private FruitsDao fruitsDao;

	public void setFruitsDao (FruitsDao fruitsDao) {
		this.fruitsDao = fruitsDao;
	}

	public boolean isExist (int id) {
		FruitsDto fruitsDto = this.fruitsDao.selectById(id);
		System.out.println(fruitsDto);
		return fruitsDto != null;
	}

}
