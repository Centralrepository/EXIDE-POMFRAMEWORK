package com.prakat.Exide.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerAddressDetails {

	@FindBy(id="communicationAddress1")
	private WebElement Address1;
	public WebElement getAddress1(){
		return Address1;
	}

	@FindBy(id="pincode")
	private WebElement pincode;
	public WebElement getpincode(){
		return pincode;
	}	
	
	
	WebDriver driver;
	
	public CustomerAddressDetails(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}	
}
