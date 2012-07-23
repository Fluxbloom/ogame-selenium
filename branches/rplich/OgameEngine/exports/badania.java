package com.example.tests;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.SeleneseTestCase;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class badania extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://uni116.ogame.pl/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testBadania() throws Exception {
		selenium.open("/game/index.php?page=overview");
		selenium.click("//ul[@id='menuTable']/li[5]/a/span");
		selenium.waitForPageToLoad("30000");
		selenium.click("id=details113");
		selenium.click("id=details120");
		selenium.click("id=details121");
		selenium.click("id=details114");
		selenium.click("id=details122");
		selenium.click("id=details115");
		selenium.click("id=details117");
		selenium.click("id=details118");
		selenium.click("id=details106");
		selenium.click("id=details108");
		selenium.click("id=details124");
		selenium.click("id=details123");
		selenium.click("id=details199");
		selenium.click("id=details109");
		selenium.click("id=details110");
		selenium.click("id=details111");
		selenium.click("css=a.build-it > span.textlabel");
		selenium.waitForPageToLoad("30000");
		selenium.click("id=research");
		selenium.click("css=a.build-it_disabled > span.textlabel");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
