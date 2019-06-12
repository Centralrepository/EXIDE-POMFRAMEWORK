package com.prakat.Exide.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerDetails {
	@FindBy(name="proposerRelationship")
	private WebElement ProposerRelationship;
	
	
	WebDriver driver;
	
	public CustomerDetails(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
}
