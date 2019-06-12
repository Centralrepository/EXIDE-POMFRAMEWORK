package com.prakat.Exide.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPersonalDetails {
	@FindBy(name="proposerRelationship")
	private WebElement ProposerRelationship;
	public WebElement getProposerRelationship(){
		return ProposerRelationship;
	}
	
	@FindBy(xpath="//div[text()='Customer Search']")
	private WebElement CustomerSearchText;
	public WebElement getCustomerSearchText(){
		return CustomerSearchText;
	}
	
	@FindBy(name="day")
	private WebElement DateOfBirthDay;
	public WebElement getDateOfBirthDay(){
		return DateOfBirthDay;
	}
	
	
	@FindBy(name="month")
	private WebElement DateOfBirthMonth;
	public WebElement getDateOfBirthMonth(){
		return DateOfBirthMonth;
	}
	
	
	@FindBy(name="year")
	private WebElement DateOfBirthYear;
	public WebElement getDateOfBirthYear(){
		return DateOfBirthYear;
	}	
	
	@FindBy(xpath="//label[@for='custInitSearchGenderMale']")
	private WebElement GenderMale;
	public WebElement getGenderMale(){
		return GenderMale;
	}
	
	@FindBy(xpath="//label[@for='custInitSearchGenderFemale']")
	private WebElement GenderFemale;
	public WebElement getGenderFemale(){
		return GenderFemale;
	}
	
	@FindBy(xpath="//label[@for='custInitSearchHasPAN']")
	private WebElement CustNoPANCheckbox;
	public WebElement getCustNoPANCheckbox(){
		return CustNoPANCheckbox;
	}
	
	@FindBy(xpath="//label[@for='custInitSearchHasAadhaar']")
	private WebElement CustNoAadharCheckbox;
	public WebElement getCustNoAadharCheckbox(){
		return CustNoAadharCheckbox;
	}
	
	
	@FindBy(id="custInitSearchEiaNum")
	private WebElement CustInitSearchEiaNum;
	public WebElement getCustInitSearchEiaNum() {
		return CustInitSearchEiaNum;
	}
	
	@FindBy(xpath="//button[text()=' Search ']")
	private WebElement CustSearch;
	public WebElement getCustSearch(){
		return CustSearch;
	}
	
	@FindBy(id="scrollContainer1")
	private WebElement CustomScrollContainer1;
	public WebElement getCustomScrollContainer1(){
		return CustomScrollContainer1;
	}
	
	
	
	@FindBy(xpath="//label[@for='custInitSearchHasPrevPolicyNum']")
	private WebElement CustHasNoPrevPolicyNumCheckbox;
	public WebElement getCustHasNoPrevPolicyNum(){
		return CustHasNoPrevPolicyNumCheckbox;
	}	
	
	
	@FindBy(xpath="//button[text()=' Search']")
	private WebElement PrevPolicySearch;
	public WebElement getPrevPolicySearch(){
		return PrevPolicySearch;
	}	
	
	WebDriver driver;
	
	public CustomerPersonalDetails(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
}
