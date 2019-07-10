package com.prakat.Exide.TestScripts;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.prakat.Exide.Pages.CreditcardDetails;
import com.prakat.Exide.Pages.CustomerAddressDetails;
import com.prakat.Exide.Pages.CustomerOccupationDetails;
import com.prakat.Exide.Pages.CustomerPersonalDetails;
import com.prakat.Exide.Pages.HomePage;
import com.prakat.Exide.Pages.LoginPage;
import com.prakat.Exide.Pages.NomineeDetails;
import com.prakat.Exide.Pages.NonebillingDetails;
import com.prakat.Exide.Pages.PlanDetails;
import com.prakat.Exide.Pages.ProductSelection;
import com.prakat.Exide.Pages.Questionnarie;
import com.prakat.Exide.Pages.ReceiptCash;
import com.prakat.Exide.Pages.ReceiptCheque;
import com.prakat.Exide.Pages.Summary;
import com.prakat.Generic.Helper.BaseTest;
import com.prakat.Generic.Helper.ConstantHelper;
import com.prakat.Generic.Helper.DropdownHelper;
import com.prakat.Generic.Helper.ExcelDataProvider;
import com.prakat.Generic.Helper.ExcelHelper;
import com.prakat.Generic.Helper.ScreenshotHelper;
import com.prakat.Generic.Helper.WaitHelper;

@Listeners(ScreenshotHelper.class)
public class PFMonthly extends BaseTest {
	
	@DataProvider
	public Object[][] getProductData(){
		Object data[][] = ExcelDataProvider.getTestData("PFMonthly");
		return data;
	}

	@Test(dataProvider = "getProductData")
	public void ProductDetails(String caseNo,String targetGroupName,String productName, String proposalNo, String advisorCode, String accountNum,
			String custRelationship, String day, String month, String year, String pan,String customerTitle, String ageProof,
			String insuredFN, String insuredMN, String insuredLN, String idProof, String idProofNum, String education,
			String maritalStatus, String fatherFN, String fatherMN, String fatherLN, String nationality,
			String cAddress1, String cAddress2, String cAddress3, String cLandmark, String cPincode,
			String addressProof, String mobileNum, String email, String preferedLang, String insuredOccupation,
			String insuredDesignation, String OccuDesc, String insuredEmployer, String insuredIncome,
			String fatherIncome, String fatherWork, String nmDOBday, String nmDOBmonth, String nmDOByear, String nomRelation,
			String nmMaritalStatus, String nomShare, String sumAssured, String policyTerm, String FreqPayment, String PSDay, String PSMonth, String PSYear, String MedClass, String IndAccountNo, String IndConfirmAccNo,
			String AccType, String AccHoldersName, String IndIfscCode, String DebitDate, String ManDateAmount,
			String Comment, String FreqPayHalfYearly, String CredCardHolder, String CredCardBrand,
			String CreditCardNo, String ExpiryMonth, String ExpiryYear, String CardIssuer, String Height, String Weight,
			String PayType, String BankTieUp, String EnterAmount, String IncomeProofType, String FinYear, String Income,
			String SmokeHab, String payType, String BankTie, String ChequeNo, String ChequeAmt,
			String CheqDay, String CheqMon, String CheqYr, String PaymentCheckType, String CheqBankName, String BankBrancName,
			String BnkAccNo, String BnkAccConf, String BnkHoldName)
			throws IOException, Throwable {
		
        test = extent.createTest("PFMonthly");
        String testResult = "Case No: " + caseNo + " &nbsp; <br /> &nbsp; Group Name: " + targetGroupName;
        test.info(MarkupHelper.createLabel(testResult, ExtentColor.BLUE));
        System.out.println(testResult);
		
		
		
		WaitHelper wait = new WaitHelper();
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		wait.implicitWait(30);
		
		xlib = new ExcelHelper();
		prodSel = new ProductSelection(driver);
		cpdetail = new CustomerPersonalDetails(driver);
		cadetail = new CustomerAddressDetails(driver);
		codetails = new CustomerOccupationDetails(driver);
		nomdetails = new NomineeDetails(driver);
		plndetails = new PlanDetails(driver);
		credcarddetails = new CreditcardDetails(driver);
		drop = new DropdownHelper();
		questionnarie = new Questionnarie(driver);
		receiptcash = new ReceiptCash(driver);
		summary = new Summary(driver);
		receiptcheque = new ReceiptCheque(driver);
		//nonebilling = new NonebillingDetails(driver);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		loginPage.login();
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, ConstantHelper.ExpPageTitle);
		System.out.println("Login success");

		Thread.sleep(3000);
		homePage.getAddNewBtn().click();


		prodSel.getSelectProductSearch().sendKeys(productName);

		Thread.sleep(2000);
		prodSel.getSelectProductSearch().sendKeys(Keys.ARROW_DOWN);
		prodSel.getSelectProductSearch().sendKeys(Keys.ENTER);

		System.out.println(proposalNo);

		prodSel.getProposalFormNo().sendKeys(proposalNo);

		Thread.sleep(2000);

		Assert.assertTrue(prodSel.getValidProposalMsg().isDisplayed());

		
		prodSel.getPlanSaveProceedBtn().click();
		Thread.sleep(2000);

		System.out.println(advisorCode);
		prodSel.getAdvisorCode().sendKeys(advisorCode);
		Thread.sleep(2000);
		prodSel.getStatusText().click();

		Assert.assertTrue(prodSel.getValidAdvisorMsg().isDisplayed());
	
		
		Thread.sleep(2000);
		prodSel.getAgentSaveProceed().click();

		
		//=======e policy page===============
		
		prodSel.getEPolicyNoBtn().click();
		
		
		prodSel.getEPolicySaveProceed().click();


		drop.getSelectByVisibleText(cpdetail.getProposerRelationship(), custRelationship);
		cpdetail.getDateOfBirthDay().sendKeys(day);
		cpdetail.getDateOfBirthMonth().sendKeys(month);
		cpdetail.getDateOfBirthYear().sendKeys(year);
		Thread.sleep(2000);
		cpdetail.getGenderMale().click();
		Thread.sleep(1000);
		//Pan number Entry
		//cpdetail.getPANNum().sendKeys(pan);
		
		
		
		
		cpdetail.getCustNoPANCheckbox().click();
		Thread.sleep(5000);
		cpdetail.getCustNoAadharCheckbox().click();

		Thread.sleep(2000);
		EventFiringWebDriver eventFiring = new EventFiringWebDriver(driver);
		eventFiring.executeScript("document.querySelector('div[id=\"scrollContainer1\"]').scrollTop=500");

		Thread.sleep(2000);
		cpdetail.getCustSearch().click();
		
		Thread.sleep(1000);
		eventFiring.executeScript("document.querySelector('div[id=\"scrollContainer1\"]').scrollTop=500");
		Thread.sleep(1000);
		cpdetail.getCustHasNoPrevPolicyNum().click();
		Thread.sleep(1000);
		cpdetail.getPrevPolicySearch().click();
		Thread.sleep(1000);
		eventFiring.executeScript("document.querySelector('div[id=\"scrollContainer1\"]').scrollTop=500");
		Thread.sleep(1000);
		cpdetail.getAddNewCustomerRadio().click();
		Thread.sleep(1000);
		eventFiring.executeScript("document.querySelector('div[id=\"scrollContainer1\"]').scrollTop=500");

		drop.getSelectByVisibleText(cpdetail.getcustomerTitle(), customerTitle);
		cpdetail.getInsuredFirstName().sendKeys(insuredFN);
		cpdetail.getInsuredMiddleName().sendKeys(insuredMN);
		cpdetail.getInsuredLastName().sendKeys(insuredLN);
		Thread.sleep(2000);
		eventFiring.executeScript("document.querySelector('div[id=\"scrollContainer1\"]').scrollTop=1000");
		
		Thread.sleep(2000);
		cpdetail.getInsuredNoCKYC().click();
		drop.getSelectByVisibleText(cpdetail.getInsuredAgeProof(), ageProof);
		drop.getSelectByVisibleText(cpdetail.getInsuredIDProof(), idProof);
		cpdetail.getIdentityProofNo().sendKeys(idProofNum);
		drop.getSelectByVisibleText(cpdetail.getInsuredEducation(), education);
		Thread.sleep(2000);
		eventFiring.executeScript("document.querySelector('div[id=\"scrollContainer1\"]').scrollTop=500");

		drop.getSelectByVisibleText(cpdetail.getInsuredMaritalStatus(), maritalStatus);
		cpdetail.getInsuredFatherFN().sendKeys(fatherFN);
		cpdetail.getInsuredFatherMN().sendKeys(fatherMN);
		cpdetail.getInsuredFatherLN().sendKeys(fatherLN);
		drop.getSelectByVisibleText(cpdetail.getInsuredNationality(), nationality);
		cpdetail.getCustomerSaveProceed().click();
		Thread.sleep(2000);

		cadetail.getInsuredCommunicationAddress1().sendKeys(cAddress1);
		cadetail.getInsuredCommunicationAddress2().sendKeys(cAddress2);
		cadetail.getInsuredCommunicationAddress3().sendKeys(cAddress3);
		cadetail.getCAddressPincode().sendKeys(cPincode);
		cadetail.getCityText().click();
		Thread.sleep(2000);
		eventFiring.executeScript("document.querySelector('div[id=\"scrollContainer2\"]').scrollTop=200");
		
		drop.getSelectByVisibleText(cadetail.getInsuredAddressProof(), addressProof);
		Thread.sleep(2000);
		cadetail.getSameAddressYesBtn().click();
		Thread.sleep(2000);
		eventFiring.executeScript("document.querySelector('div[id=\"scrollContainer2\"]').scrollTop=1000");
		Thread.sleep(2000);
		if(mobileNum.length()<10){
			System.out.println("Invalid Mobile Number");
		}else{
		cadetail.getInsuredMobileNum().sendKeys(mobileNum);
		Thread.sleep(1000);
		}
		

		cadetail.getInsuredEmail().sendKeys(email);
		Thread.sleep(1000);

		Thread.sleep(1000);
		cadetail.getCommModeEmail().click();
		Thread.sleep(1000);
		cadetail.getCommModeSms().click();
		drop.getSelectByVisibleText(cadetail.getPreferedLanguage(), preferedLang);
		Thread.sleep(2000);
		cadetail.getCustAddrSaveProceed().click();
		Thread.sleep(2000);

		drop.getSelectByVisibleText(codetails.getInsuredOccupation(), insuredOccupation);
		Thread.sleep(2000);
		drop.getSelectByVisibleText(codetails.getInsuredDesignation(), insuredDesignation);
		codetails.getInsuredOccupationDesc().sendKeys(OccuDesc);
		drop.getSelectByVisibleText(codetails.getInsuredEmployerName(), insuredEmployer);
		codetails.getInsuredAnnualIncome().sendKeys(insuredIncome);
		codetails.getInsuredIncomeProofCheckBox().click();
		Thread.sleep(1000);
		drop.getSelectByVisibleText(codetails.getpaytype(), IncomeProofType);
		drop.getSelectByVisibleText(codetails.getfinyear(), FinYear);
		codetails.getincome().sendKeys(Income);
		codetails.getInsuredFatherAnnualIncome().sendKeys(fatherIncome);
		drop.getSelectByVisibleText(codetails.getInsuredFatherDesignation(), fatherWork);
		Thread.sleep(1000);
		codetails.getCustOccuSaveProceed().click();

		
		
		Thread.sleep(5000);
		
		Thread.sleep(5000);
	
		nomdetails.getdaybox().sendKeys(nmDOBday);
		nomdetails.getmonthtextbox().sendKeys(nmDOBmonth);
		nomdetails.getyeartextbox().sendKeys(nmDOByear);
		Thread.sleep(1000);
		nomdetails.getMaleRadiobtn1().click();
		Thread.sleep(2000);
		nomdetails.getpanchkbox().click();
		nomdetails.getaadharchkbox().click();
		nomdetails.geteinsurancechkbox().click();
		nomdetails.getsearchbutton().click();
		nomdetails.getcsrDoesntHavePreviousPno().click();
		nomdetails.getpolicysearchbutton().click();
		nomdetails.getaddNewCustomerbutton().click();
		drop.getSelectByVisibleText(nomdetails.getcomborelation(), nomRelation);
		drop.getSelectByVisibleText(nomdetails.getTitleComboRelation(), customerTitle);
		nomdetails.getFirstNametxt().sendKeys(fatherFN);
		drop.getSelectByVisibleText(nomdetails.getmaritialstatdrop(), nmMaritalStatus);
		drop.getSelectByVisibleText(nomdetails.getnationalitydropdown(), nationality);
		nomdetails.savendproceedbtn().click();
		Thread.sleep(2000);
		
		nomdetails.getYesrdobtn().click();
		nomdetails.getNomineesharetxt().sendKeys(nomShare);

		String nomShareErr =nomdetails.getNomshareErrTxt().getText();
		Assert.assertEquals(nomShareErr, "Total share should be 100%.", "Nomination share is 100%");
		
		
		nomdetails.getblankSpace().click();
		nomdetails.getsaveandpro().click();
		Thread.sleep(3000);
		

	
		plndetails.getSumAssuredtbox().sendKeys(sumAssured);
		Thread.sleep(5000);

		Thread.sleep(2000);
		plndetails.getPolicyTermtbox().sendKeys(policyTerm);
		
		
		drop.getSelectByVisibleText(plndetails.getFrequencyPaymentDropdown(), FreqPayment);

		Thread.sleep(2000);

		plndetails.getdaytfield().sendKeys(PSDay);
        plndetails.getmonthtfield().sendKeys(PSMonth);
        plndetails.getyeartfield().sendKeys(PSYear);
        Thread.sleep(2000);
        
        drop.getSelectByVisibleText(plndetails.medicalclassDropdown(), MedClass);
        Thread.sleep(1000);
        plndetails.getsaveandproceedbtn().click();
        Thread.sleep(1000);
        plndetails.getindividualBillingRadiobtn().click();
        plndetails.getDebitCardradiobtn().click();
        Thread.sleep(1000);
        plndetails.getDebitAccNo().sendKeys(IndAccountNo);
        plndetails.getdebitconfirmAccNotfield().sendKeys(IndConfirmAccNo);
        drop.getSelectByVisibleText(plndetails.getdebitAccTypeDropdown(), AccType);
        plndetails.getdebitAccFnametfield().sendKeys(AccHoldersName);
        Thread.sleep(2000);
        plndetails.getifscCodeValuetfield().sendKeys(IndIfscCode);
        Thread.sleep(3000);

        drop.getSelectByVisibleText(plndetails.getpreferreddebitdateDropdown(), DebitDate);
        plndetails.getMandateAmounttextfield().sendKeys(ManDateAmount);
        Thread.sleep(2000);
        plndetails.getpremiumProposerNoradiobtn().click();
        plndetails.getsaveAndProceedForRenewalPayment().click();
        Thread.sleep(2000);
      
        
        //Payout details
        plndetails.getpayoutdetailsnotrequiredCbox().click();
        Thread.sleep(1000);
        plndetails.getsaveAndProceedForPayoutDetails().click();
        Thread.sleep(2000);
        
        //premier details
        plndetails.getNoRadiobutton().click();;
        Thread.sleep(1000);
        plndetails.getsaveAndProceedForPremierPayer().click();
        Thread.sleep(2000);
        
        //E comments
        plndetails.getCommentstextfield().sendKeys(Comment);
        plndetails.getsaveAndProceedForEcomment().click();
        Thread.sleep(2000);
        
        
        //Questionaries

        questionnarie.getsaveandproceedQuestionInsuCover().click();
        Thread.sleep(3000);
        
        questionnarie.gethealthHeight().sendKeys(Height);
        questionnarie.gethealthWeight().sendKeys(Weight);

        Thread.sleep(1000);
        
        WebElement drinkChk = eventFiring.findElement(By.cssSelector("[for='noDrink']"));
        js.executeScript("arguments[0].scrollIntoView(true);", drinkChk); 
        Thread.sleep(500);
        questionnarie.getdrink().click();
        Thread.sleep(2000);

        questionnarie.getsaveandproceedQuestionHealth().click();
        
       
        
        //Cheque
        drop.getSelectByVisibleText(receiptcheque.getpaytype(), payType);
        drop.getSelectByVisibleText(receiptcheque.gettieup(), BankTie);
        receiptcheque.getchequeno().sendKeys(ChequeNo);
        receiptcheque.getchequeamt().sendKeys(ChequeAmt);
        receiptcheque.getday().sendKeys(CheqDay);
        receiptcheque.getmonth().sendKeys(CheqMon);
        receiptcheque.getyear().sendKeys(CheqYr);
        drop.getSelectByVisibleText(receiptcheque.getchequetype1(), PaymentCheckType);
        Thread.sleep(1000);
        
        receiptcheque.getbank().sendKeys(CheqBankName);
        Thread.sleep(2000);
        
        receiptcheque.getbank().sendKeys(Keys.ARROW_DOWN);
        receiptcheque.getbank().sendKeys(Keys.ENTER);
        receiptcheque.getbankbr().sendKeys(BankBrancName);
        receiptcheque.getbankaccno().sendKeys(BnkAccNo);
        receiptcheque.getbankno().sendKeys(BnkAccConf);
        receiptcheque.getname().sendKeys(BnkHoldName);
        receiptcheque.getproceed().click();
        
        //summary
        Thread.sleep(1000);
        
        WebElement proceedperchk = eventFiring.findElement(By.xpath("//label[@for='proceedPercentage']"));
        js.executeScript("arguments[0].scrollIntoView(true);", proceedperchk);        
        Thread.sleep(1000);
        summary.getprocedwithchkbox().click();
        Thread.sleep(1000);
        summary.getsaveandvalidate().click();
        Thread.sleep(2000);
        WebElement requiredDocsChk = eventFiring.findElement(By.xpath("//label[@for='4']"));
        js.executeScript("arguments[0].scrollIntoView(true);", requiredDocsChk); 
        Thread.sleep(2000);
        List<WebElement> list1 = driver.findElements(By.xpath("//*[@class='list-group-item']/label"));
        int listlenth= list1.size();
        for(int i=0;i<=listlenth-1;i++)
        {
        	Thread.sleep(1000);
        	list1.get(i).click();
        	
        }
        Thread.sleep(1000);
        summary.getsubmitButton().click();
        //completed
        
        Thread.sleep(15000);

        loginPage.getProfileDropdown().click();
        Thread.sleep(1000);
        loginPage.getLogoutButton().click();
        
        
		}
	  

}



