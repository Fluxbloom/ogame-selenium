package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class ataki {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://www.ogame.pl/");
		selenium.start();
	}

	@Test
	public void testAtaki() throws Exception {
		// ACS nadchodzący
		verifyTrue(selenium.isElementPresent("));
		// format czasu ataku: "22:38:37 Czas"
		String C = selenium.getText();
		String C = selenium.getText();
		String C = selenium.getAttribute("//table[@id=\"eventContent\"]/tbody/tr[@class=\"allianceAttack\"]/td[contains(@class,\"mission\")]/img@title");
		// cel floty, trimować wiodące i kończące spacje
		String A = selenium.getText("//table[@id=\"eventContent\"]/tbody/tr[@class=\"allianceAttack\"]/td[@class=\"destFleet\"]");
		// kordy
		String B = selenium.getText("//table[@id=\"eventContent\"]/tbody/tr[@class=\"allianceAttack\"]/td[@class=\"destCoords\"]/a");
		// własne floty
		verifyTrue(selenium.isElementPresent("//table[@id=\"eventContent\"]/tbody/tr[@class=\"eventFleet\"]"));
		// ATAK
		// Sondowanie
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
