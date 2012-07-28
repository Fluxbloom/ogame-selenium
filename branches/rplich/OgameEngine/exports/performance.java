package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class performance {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://uni116.ogame.pl/");
		selenium.start();
	}

	@Test
	public void testPerformance() throws Exception {
		selenium.click("//ul[@id='menuTable']/li[2]/a/span");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Ustawienia surowców");
		selenium.waitForPageToLoad("30000");
		selenium.select("name=last1", "label=10%");
		selenium.select("name=last2", "label=20%");
		selenium.select("name=last3", "label=30%");
		selenium.select("name=last4", "label=40%");
		selenium.select("name=last12", "label=50%");
		selenium.select("name=last212", "label=60%");
		selenium.click("css=input.button188");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
