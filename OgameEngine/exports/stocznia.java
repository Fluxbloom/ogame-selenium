package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class stocznia extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://ogame.pl/");
		selenium.start();
	}

	@Test
	public void testStocznia() throws Exception {
		selenium.open("/");
		selenium.click("id=loginSubmit");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Stocznia");
		selenium.waitForPageToLoad("30000");
		// LM
		selenium.click("id=details204");
		// CM
		selenium.click("id=details205");
		// KRAZOWNIK
		selenium.click("id=details206");
		// OW
		selenium.click("id=details207");
		// Pancernik
		selenium.click("id=details215");
		// Bombowiec
		selenium.click("id=details211");
		// Niszczyciel
		selenium.click("id=details213");
		// Gwiazda Smierci
		selenium.click("id=details214");
		// MT
		selenium.click("id=details202");
		// DT
		selenium.click("id=details203");
		// Statek Kolonizacyjny
		selenium.click("id=details208");
		// Recykler
		selenium.click("id=details209");
		// Sonda Szpiegowska
		selenium.click("id=details210");
		// Satelita Sloneczy
		selenium.click("id=details212");
		// guzik wyszarzony
		selenium.click("//a[@class='build-it_disabled']");
		// guzik klikniecie
		selenium.click("//a[@class='build-it']");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
