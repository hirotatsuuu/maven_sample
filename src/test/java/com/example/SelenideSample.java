package com.example;

import org.junit.Test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

public class SelenideSample {

	@Test
	public void isSelenidePage () {
		Configuration.browser = WebDriverRunner.CHROME;
		final String PATH = "/Users/tatsuya_hirota/dev/inc/eclipse_workspace/maven_sample/src/main/resources/chromedriver";
		System.setProperty("webdriver.gecko.driver", PATH);

		Selenide.open("http://selenide.org");
		Selenide.$("div.short.wiki h3").shouldHave(Condition.text("What is Selenide?"));
		Selenide.$$(".quicklinks ul.gray-boxes li").shouldHaveSize(5);
	}

}
