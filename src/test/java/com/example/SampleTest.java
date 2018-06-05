package com.example;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class SampleTest {

	@Before
	public void before () {
		System.out.println("@Before");
	}

	@BeforeClass
	public static void beforeClass () {
		System.out.println("@BeforeClass");
	}

	@After
	public void after () {
		System.out.println("@After");
	}

	@AfterClass
	public static void afterClass () {
		System.out.println("@AfterClass");
	}

	@Ignore
	@Test
	public void test() {
		fail("まだ実装されていません");
	}

	@Test
	public void isTest () {
		assertThat("test", is("test"));
	}

	@Test
	public void ignoreTest () {
		assertThat("ignore", is("ignore"));
	}

	@Test(timeout=1000)
	public void infinity () {
		while(true);
	}

	@Test(expected=Exception.class)
	public void exception () {
		new ArrayList<>().get(1);
	}

}
