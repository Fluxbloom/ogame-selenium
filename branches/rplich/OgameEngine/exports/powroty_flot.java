package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class powroty_flot {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://uni116.ogame.pl/");
		selenium.start();
	}

	@Test
	public void testPowroty_flot() throws Exception {
		// ilosc flot
		String A = selenium.getText("");
		String B = selenium.getText("");
		// ekspedycje
		String C = selenium.getText("");
		String D = selenium.getText("");
		// dostep do kolejnych flot
		String E = selenium.getText("");
		String F = selenium.getText("//div[contains(@id,\"fleet\")]/span[@class=\"absTime\"]");
		String G = selenium.getText("//div[contains(@id,\"fleet\")]");
		// zawracanie
		String a = selenium.getText("//div[contains(@id,\"fleet\")][2]/span[contains(@class,\"reversal\")]/a");
		// z atrybutem title Zawróć:| 30.07.2012<br>18:43:22
		// powrót
		String a = selenium.getText("//div[contains(@id,\"fleet\")][2]/span[contains(@class,\"nextabsTime\")]");
		// pierwszy kord
		// selenium.StoreText("//div[contains(@id,\"fleet\")][2]//span[contains(@class,\"originCoords\")]/a", "a");
		String a = selenium.getText("//div[contains(@id,\"fleet\")][2]//span[contains(@class,\"originPlanet\")]");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
