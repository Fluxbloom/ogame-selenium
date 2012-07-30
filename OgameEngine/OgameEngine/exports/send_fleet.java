package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class send_fleet extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://uni116.ogame.pl/game/index.php?page=overview");
		selenium.start();
	}

	@Test
	public void testSend_fleet() throws Exception {
		selenium.click("link=Flota");
		selenium.waitForPageToLoad("30000");

		// ALL
		selenium.click("");
		selenium.click("");
		selenium.waitForPageToLoad("30000");
		// Drugie okno
		// Najpierw kordy
		selenium.type("", "2");
		selenium.type("", "244");
		selenium.type("", "8");
		// Ustaw SPEED
		selenium.select("", "40");
		selenium.click("");
		selenium.waitForPageToLoad("30000");
		// Lub
		selenium.click("");
		selenium.waitForPageToLoad("30000");
		// Czy zasiedlona
		verifyTrue(selenium.isElementPresent(""));
		// Okno Trzecie
		// Ekspedycja
		selenium.click("");
		// Kolonizuj
		selenium.click("");
		// Recykler
		selenium.click("");
		// Transportuj
		selenium.click("");
		// Stacjonuj
		selenium.click("");
		// Szpieguj
		selenium.click("");
		// Zatrzymaj
		selenium.click("");
		// Atakuj
		selenium.click("");
		// Atak Związku
		selenium.click("");
		// Niszczenie moona
		selenium.click("");
		// Zapasy
		selenium.type("", "100");
		selenium.type("", "200");
		selenium.type("", "300");
		// Wszystkie
		selenium.click("");
		selenium.click("");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
