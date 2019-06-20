package com.prakat.Generic.Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ScrollWithinElements extends BaseTest {
	public void getScrollElements() {
EventFiringWebDriver eventFiring=new EventFiringWebDriver(driver);
eventFiring.executeScript("document.querySelector('div[id=\"scrollContainer1\"]').scrollTop=500");

	}
}
