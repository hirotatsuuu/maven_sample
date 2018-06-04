package com.example;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest extends Calculator {

	@Test
	public void testAdd() {
		int actual = Calculator.add(1, 2);
		assertThat(actual, is(3));
	}

}
