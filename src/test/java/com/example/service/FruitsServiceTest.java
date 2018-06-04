package com.example.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import com.example.dao.FruitsDao;
import com.example.dto.FruitsDto;

public class FruitsServiceTest {

	@Test
	public void test() {
		FruitsDao mockDao = mock(FruitsDao.class);
		when(mockDao.selectById(anyInt())).thenReturn(new FruitsDto(1, "apple", 100));
		FruitsService sut = new FruitsService();
		sut.setFruitsDao(mockDao);
		boolean actual = sut.isExist(1);
		assertThat(actual, is(true));
		verify(mockDao).selectById(1);
	}

}
