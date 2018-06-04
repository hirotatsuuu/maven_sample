package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumMain {

	public static void main(String[] args) {
		final String PATH = "/Users/tatsuya_hirota/dev/inc/eclipse_workspace/maven_sample/src/main/resources/chromedriver";
		System.setProperty("webdriver.chrome.driver", PATH);
		WebDriver driver = new ChromeDriver();

		final String URL = "http://www.google.com";
		driver.get(URL);

		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("selenium");
		element.submit();

		new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith("selenium");
			}
		});

		System.out.println("Page title is: " + driver.getTitle());
		driver.quit();
	}
}
