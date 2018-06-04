package com.example.dao;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.util.List;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Test;

import com.example.dto.FruitsDto;

public class FruitsDaoTest extends DBTestCase {

	public FruitsDaoTest(String name) {
		super(name);
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost/maven_sample?useSSL=false");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "admin");
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataSetBuilder().build(new FileInputStream("dataset.xml"));
	}

	@Test
	public void test_findAll() throws Exception{
		int expectedRowCount = 3;
		FruitsDao sut = new FruitsDao();
		List<FruitsDto> actual = sut.findAll();
		assertThat(actual.size(), is(expectedRowCount));
	}

}
