package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class budowanie extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://uni116.ogame.pl/");
		selenium.start();
	}

	@Test
	public void testBudowanie() throws Exception {
		selenium.open("/game/index.php?page=overview");
		// przejscie na surowce
		selenium.click("//ul[@id='menuTable']/li[2]/a/span");
		selenium.waitForPageToLoad("30000");
		
		// przejscie na stacja
		selenium.click("//ul[@id='menuTable']/li[3]/a/span");
		selenium.waitForPageToLoad("30000");
		
		// Wyłaczony przycisk
		selenium.click("//a[@class='build-it_disabled']");
		selenium.waitForPageToLoad("30000");
		// Włączony przycisk
		selenium.click("//a[@class='build-it']");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
