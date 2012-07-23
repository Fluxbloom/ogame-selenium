package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class lewy_pasek extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://uni116.ogame.pl/game/index.php?page=overview");
		selenium.start();
	}

	@Test
	public void testLewy_pasek() throws Exception {
		selenium.click("link=Podgląd");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Surowce");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Stacja");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Badania");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Stocznia");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Obrona");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Flota");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
