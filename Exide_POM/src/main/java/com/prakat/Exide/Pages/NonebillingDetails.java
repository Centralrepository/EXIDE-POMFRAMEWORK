package com.prakat.Exide.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NonebillingDetails {
	
	//plan details 

	//For payment frequency yearly

	@FindBy(xpath="//select[name='payment frequency']")
	private WebElement PaymentFrequencyDropdown;
	public WebElement getPaymentFrequencyDropdown()
	{
	return PaymentFrequencyDropdown;
	}

	//Element locator product details for proposal sign date day text field

	@FindBy(xpath="//input[@name='day']")
	private WebElement daytfield;
	public WebElement getdaytfield()
	{
	return  daytfield;
	}

	//Element locator product details for proposal sign date month text field

	@FindBy(xpath="//input[@name='month']")
	private WebElement monthtfield;
	public WebElement getmonthtfield()
	{
	return  monthtfield;
	}

	//Element locator product details for proposal sign date year text field

	@FindBy(xpath="//input[@name='year']")
	private WebElement yeartfield;
	public WebElement getyeartfield()
	{
	return  yeartfield;
	}

	//Element locator product details for non medical/medical class dropdown

	@FindBy(xpath="//select[name='medical class']")
	private WebElement medicalclassDropdown;
	public WebElement medicalclassDropdown()
	{
	return medicalclassDropdown;
	}

	//Element locator product details for save and proceed button

	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement saveandproceedbtn;
	public WebElement getsaveandproceedbtn()
	{
	return saveandproceedbtn;
	}

	//RENEWAL PAYMENT


	//Element locator customer type for  none radio button

	@FindBy(xpath="//label[@for='noneBilling']")
	private WebElement noneBillingRadiobtn;
	public WebElement getnoneBillingRadiobtn()
	{
	return noneBillingRadiobtn;
	}

	//PAYOUT DETAILS


	//Element locator payout details for payout details not required check box

	@FindBy(xpath="//label[@for='payoutRequired']")
	private WebElement payoutdetailsnotrequiredCbox;
	public WebElement getpayoutdetailsnotrequiredCbox()
	{
	return payoutdetailsnotrequiredCbox;
	}

	//PREMIUM PAYER

	//Element locator premium payer for NO radio button

	@FindBy(xpath="//label[@for='isEPolicyNo']")
	private WebElement  NoRadiobutton;
	public WebElement getNoRadiobutton()
	{
	return NoRadiobutton;
	}

	//E-COMMENTS

	//Element locator E-COMMENTS for Comments textfield

	@FindBy(xpath="//textarea[@placeholder='Enter Comment']")
	private WebElement   Commentstextfield;
	public WebElement getCommentstextfield()
	{
	return Commentstextfield;
	}
	
WebDriver driver;
	
	public NonebillingDetails(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}

}
