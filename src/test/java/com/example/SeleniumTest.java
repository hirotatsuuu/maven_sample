package com.example;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

	@Test
	public void test() {
		final String PATH = "/Users/tatsuya_hirota/dev/inc/eclipse_workspace/maven_sample/src/main/resources/chromedriver";
		System.setProperty("webdriver.chrome.driver", PATH);
		WebDriver driver = new ChromeDriver();

		final String URL = "http://localhost:8080/maven_sample/index.jsp";
		driver.get(URL);

		String expectPageTitle = "Fruits Shop";
		String pageTitle = driver.getTitle();
		assertThat(pageTitle, is(expectPageTitle));

		WebElement h1 = driver.findElement(By.tagName("h1"));
		assertThat(h1.getText(), is(expectPageTitle));

		List<WebElement> liList = driver.findElements(By.tagName("li"));
		assertThat(liList.size(), is(3));
		assertThat(liList.get(0).getText(), is("Apple"));
		assertThat(liList.get(1).getText(), is("Banana"));
		assertThat(liList.get(2).getText(), is("Cherry"));

		driver.quit();
	}

}
