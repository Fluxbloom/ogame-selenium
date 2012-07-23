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

public class badania1 extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://uni116.ogame.pl/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testBadania1() throws Exception {
		selenium.open("/game/index.php?page=research");
		selenium.click("link=Podgląd");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Badania");
		selenium.waitForPageToLoad("30000");
		// te
		selenium.click("id=details113");
		// tl
		selenium.click("id=details120");
		// tj
		selenium.click("id=details121");
		// tn
		selenium.click("id=details114");
		// tp
		selenium.click("id=details122");
		// selenium.ts();
		selenium.click("id=details106");
		// tk
		selenium.click("id=details108");
		// af
		selenium.click("id=details124");
		// sb
		selenium.click("id=details123");
		// rg
		selenium.click("id=details199");
		// ns
		selenium.click("id=details115");
		// ni
		selenium.click("id=details117");
		// nn
		selenium.click("id=details118");
		// tb
		selenium.click("id=details109");
		// to
		selenium.click("id=details110");
		// op
		selenium.click("id=details111");
		// DSF
		selenium.click("css=a.build-it_disabled > span.textlabel");
		selenium.click("id=details108");
		selenium.click("css=a.build-it > span.textlabel");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
