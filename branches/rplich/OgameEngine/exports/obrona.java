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

public class obrona extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://uni116.ogame.pl/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testObrona() throws Exception {
		selenium.open("/game/index.php?page=galaxy");
		selenium.click("//ul[@id='menuTable']/li[7]/a/span");
		selenium.waitForPageToLoad("30000");
		// wr
		selenium.click("id=details401");
		// ll
		selenium.click("id=details402");
		// cl
		selenium.click("id=details403");
		// dg
		selenium.click("id=details404");
		// dj
		selenium.click("id=details405");
		// wp
		selenium.click("id=details406");
		// mp
		selenium.click("id=details407");
		// dp
		selenium.click("id=details408");
		// pr
		selenium.click("id=details502");
		// pr
		selenium.click("id=details503");
		selenium.click("css=a.build-it_disabled > span.textlabel");
		selenium.click("id=details401");
		selenium.selectWindow("name=fbMainContainer");
		selenium.click("id=fbCloseButton");
		selenium.selectWindow("null");
		selenium.click("css=span.textlabel");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
