package com.prakat.Exide.Pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PlanDetails {



	
	@FindBy(xpath="//select[name='payment frequency']")
	private WebElement PaymentFrequencyDropdown;
	public WebElement getPaymentFrequencyDropdown()
	{
	return PaymentFrequencyDropdown;
	}
	
	//frequecy paymet dropdown

	@FindBy(xpath="//select[@name='paymentFrequency']")
	private WebElement FrequencyPaymentDropdown;
	public WebElement getFrequencyPaymentDropdown()
	{
	return FrequencyPaymentDropdown;
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

	@FindBy(xpath="//select[@name='medicalClass']")
	private WebElement medicalclassDropdown;
	public WebElement medicalclassDropdown()
	{
	return medicalclassDropdown;
	}

	//Element locator product details for save and proceed button

	@FindBy(xpath="(//button[contains(text(),' Save and Proceed ')])[1]")
	private WebElement saveandproceedbtn;
	public WebElement getsaveandproceedbtn()
	{
	return saveandproceedbtn;
	}

	//Element locator product details for save and draft button

	@FindBy(xpath="//button[@class='btn btn-default']")
	private WebElement saveanddraftbtn;
	public WebElement getsaveanddraftbtn()
	{
	return saveanddraftbtn;
	}
	
	// element for title Bar
	@FindBy(xpath="//span[contains(text(),'BASE')]")
	private WebElement titleBar;
	public WebElement getTitleBar()
	{
	return titleBar;
	}

	//Element locator product details for Sum Assured tbox
	@FindBy(xpath="//tr[1]//td[4]//input[1]")
	private WebElement SumAssuredtbox;
	public WebElement getSumAssuredtbox()
	{
	return SumAssuredtbox;
	}


	//Element locator product details for Policy Term tbox
	@FindBy(xpath="//tr[1]//td[6]//input[1]")
	private WebElement PolicyTermtbox;
	public WebElement getPolicyTermtbox()
	{
	return PolicyTermtbox;
	}


//	RENEWAL PAYMENT

	//Element locator customer type for individual billing radio button

	@FindBy(xpath="//label[@for='indBilling']")
	//@FindBy(xpath="//span[contains(text(),'B. RENEWAL PAYMENT')]")
	private WebElement individualbillingRadiobtn;
	public WebElement getindividualBillingRadiobtn()
	{
	return individualbillingRadiobtn;
	}

	//Element locator customer type for group billing radio button

	@FindBy(xpath="//label[@for='groupBilling']")
	private WebElement grouopbillingRadiobtn;
	public WebElement getgrouopbillingRadiobtn()
	{
	return grouopbillingRadiobtn;
	}


	//Element locator customer type for  none radio button

	@FindBy(xpath="//label[@for='noneBilling']")
	private WebElement noneBillingRadiobtn;
	public WebElement getnoneBillingRadiobtn()
	{
	return noneBillingRadiobtn;
	}


	//Element locator select the renewal payment mode for debit card radio button

	@FindBy(xpath="//label[@for='debitCard']")
	private WebElement DebitCardradiobtn;
	public WebElement getDebitCardradiobtn()
	{
	return DebitCardradiobtn;
	}



	//Element locator select the renewal payment mode for Confirm Bank account number text field

	@FindBy(xpath="//input[@name='debitconfirmtAccNo']")
	private WebElement debitconfirmAccNotfield;
	public WebElement getdebitconfirmAccNotfield()
	{
	return debitconfirmAccNotfield;
	}

	//Element locator select the renewal payment mode for Account type dropdown

	@FindBy(xpath="//select[@name='debitAccType']")
	private WebElement debitAccTypeDropdown;
	public WebElement getdebitAccTypeDropdown()
	{
	return debitAccTypeDropdown;
	}


	//Element locator select the renewal payment mode for Acc holders name text field
	@FindBy(xpath="//input[@name='debitAccFname']")
	private WebElement debitAccFnametfield;
	public WebElement getdebitAccFnametfield()
	{
	return debitAccFnametfield;
	}


	//Element locator select the renewal payment mode for IFSC code text field
	@FindBy(xpath="//input[@name='ifscCodeValue']")
	private WebElement ifscCodeValuetfield;
	public WebElement getifscCodeValuetfield()
	{
	return ifscCodeValuetfield;
	}

	//Element locator select the renewal payment mode for IFSC code not available check box

	@FindBy(xpath="//label[@for='noIfsc']")
	private WebElement IFSCcodenotavailableCbox;
	public WebElement getIFSCcodenotavailableCbox()
	{
	return IFSCcodenotavailableCbox1;
	}


	//Element locator select the renewal payment mode for MICR code text field 
	@FindBy(xpath="//input[@class='ng-pristine ng-valid ng-touched'][3]")
	private WebElement  MICRcodetfield;
	public WebElement getMICRcodetfield()
	{
	return MICRcodetfield;
	}


	//Element locator select the renewal payment mode for Bank Name text field
	@FindBy(xpath="//input[@name='Bank123']")
	private WebElement  Banknametfield;
	public WebElement getBanknametfield()
	{
	return Banknametfield;
	}


	//Element locator select the renewal payment mode for Bank Branch text field
	@FindBy(xpath="//input[@placeholder='Enter branch'][1]")
	private WebElement  Bankbranchtfield;
	public WebElement getBankbranchtfield()
	{
	return Bankbranchtfield;
	}



	//Element locator select the renewal payment mode for preferred debit date Dropdown
	@FindBy(xpath="//select[@class='ng-pristine ng-valid ng-touched']")
	private WebElement  preferreddebitdateDropdown;
	public WebElement getpreferreddebitdateDropdown()
	{
	return preferreddebitdateDropdown;
	}


	//Element locator select the renewal payment mode for Mandate Amount text field
	@FindBy(xpath="//input[@placeholder='Enter Amount']")
	private WebElement  MandateAmounttextfield;
	public WebElement getMandateAmounttextfield()
	{
	return MandateAmounttextfield;
	}

	//Element locator select the renewal payment mode for is premium proposer yes radio button

	@FindBy(xpath="//label[@for='premiumProposerYes']")
	private WebElement premiumProposerYesradiobtn;
	public WebElement getpremiumProposerYesradiobtn()
	{
	return premiumProposerYesradiobtn;
	}

	//Element locator select the renewal payment mode for is premium proposer NO radio button

	@FindBy(xpath="//label[@for='premiumProposerNo']")
	private WebElement premiumProposerNoradiobtn;
	public WebElement getpremiumProposerNoradiobtn()
	{
	return premiumProposerNoradiobtn;
	}

//	PAYOUT DETAILS


	//Element locator payout details for payout details not required check box

	@FindBy(xpath="//label[@for='payoutRequired']")
	private WebElement payoutdetailsnotrequiredCbox;
	public WebElement getpayoutdetailsnotrequiredCbox()
	{
	return payoutdetailsnotrequiredCbox;
	}


	//Element locator payout details for Bank Account Number text field

	@FindBy(xpath="//input[@name='payoutAccNo']")
	private WebElement BankAccountNumbertextfield;
	public WebElement getBankAccountNumbertextfield()
	{
	return BankAccountNumbertextfield;
	}

	//Element locator payout details for Confirm Bank Account Number text field

	@FindBy(xpath="//input[@name='confirmPayoutAccNo']")
	private WebElement ConfirmBankAccountNumbertextfield;
	public WebElement getConfirmBankAccountNumbertextfield()
	{
	return ConfirmBankAccountNumbertextfield;
	}


	//Element locator payout details for  Account Holders Name textfield

	@FindBy(xpath="//input[@name='acName']")
	private WebElement AccountHoldersNametextfield;
	public WebElement getAccountHoldersNametextfield()
	{
	return AccountHoldersNametextfield;
	}

	//Element locator payout details for IFSC code textfield

	@FindBy(xpath="//input[@id='ifscCode']")
	private WebElement IFSCcodetextfield;
	public WebElement getIFSCcodetextfield()
	{
	return IFSCcodetextfield;
	}

	//Element locator payout details for IFSC code not available checkbox

	@FindBy(xpath="//label[@for='futurePaymentnoIfsc']")
	private WebElement IFSCcodenotavailableCbox1;
	public WebElement getIFSCcodenotavailableCbox1()
	{
	return IFSCcodenotavailableCbox1;
	}

//	PREMIUM PAYER

	//Element locator premium payer for NO radio button

	@FindBy(xpath="//label[@for='isEPolicyNo']")
	private WebElement  NoRadiobutton;
	public WebElement getNoRadiobutton()
	{
	return NoRadiobutton;
	}

//	E-COMMENTS

	//Element locator E-COMMENTS for Comments textfield

	@FindBy(xpath="//textarea[@placeholder='Enter Comment']")
	private WebElement   Commentstextfield;
	public WebElement getCommentstextfield()
	{
	return Commentstextfield;
	}

WebDriver driver;
	
	public PlanDetails(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
}
