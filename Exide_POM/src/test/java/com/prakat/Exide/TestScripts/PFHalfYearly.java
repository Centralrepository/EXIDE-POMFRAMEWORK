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
public class PFHalfYearly extends BaseTest {

	@DataProvider
	public Object[][] getProductData(){
		Object data[][] = ExcelDataProvider.getTestData("HalfYear");
		return data;
	}

	@Test(dataProvider = "getProductData")
	public void ProductDetails(String productName, String proposalNo, String advisorCode,
			String custRelationship, String day, String month, String year, String customerTitle, String insuredFN,
			String insuredMN, String insuredLN, String ageProof, String idProof, String idProofNum, String education,
			String maritalStatus, String fatherFN, String fatherMN, String fatherLN, String nationality,
			String cAddress1, String cAddress2, String cAddress3, String cPincode, String addressProof,
			String mobileNum, String email, String preferedLang, String insuredOccupation,
			String insuredDesignation, String OccuDesc, String insuredEmployer, String insuredIncome,
			String IncomeProofType, String FinYear, String Income, String fatherIncome, String fatherWork,
			String nmDOBday, String nmDOBmonth, String nmDOByear, String nomRelation,
			String nmMaritalStatus, String nomShare, String sumAssured, String policyTerm, String FreqPayHalfYearly,
			String PSDay, String PSMonth, String PSYear, String MedClass, String Comment,
			String Height, String Weight, String SmokeHab, String PayType, String BankTieUp, String EnterAmount)
			throws IOException, Throwable {
		BaseTest.logger = BaseTest.report.createTest("Click on add new");
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
		
		// JavascriptExecutor js = (JavascriptExecutor) driver;

		System.out.println("vanitha");
		loginPage.login();
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, ConstantHelper.ExpPageTitle);
		System.out.println("Login success");
		
		
		Thread.sleep(10000);
		homePage.getAddNewBtn().click();
		// loginPage.getSkipForMobileLink().click();
		// String actTitle = driver.getTitle();
		// Assert.assertEquals(actTitle, ConstantHelper.ExpPageTitle);
		// System.out.println("Login success");

		// sel.getSingleProduct().click();

		// String productName=xlib.getExcelData("ProductName", 1, 0);
		System.out.println(productName);
		// WebElement SelectProductSearch=sel.getSelectProductSearch();

		prodSel.getSelectProductSearch().sendKeys(productName);
		// wait.waitForElementPresent(SelectProductSearch, 20);
		Thread.sleep(2000);
		prodSel.getSelectProductSearch().sendKeys(Keys.ARROW_DOWN);
		prodSel.getSelectProductSearch().sendKeys(Keys.ENTER);

		// String proposalNo=xlib.getExcelData("ProductName", 1, 1);
		System.out.println(proposalNo);

		prodSel.getProposalFormNo().sendKeys(proposalNo);

		Thread.sleep(5000);

/*		if (prodSel.getProposalErrorMsg().isDisplayed()) {
			System.out.println("Invalid Proposal Number");
		} else {
			String actualProposalMsg = prodSel.getValidProposalMsg().getText();
			System.out.println(actualProposalMsg);
			Assert.assertEquals(actualProposalMsg, " Valid Proposal No ");
		}*/
		
		
		if (prodSel.getValidProposalMsg().isDisplayed()) {
			System.out.println("valid Proposal Number");
		} else {
			System.out.println("Invalid Proposal Number");
		}		
		
		prodSel.getPlanSaveProceedBtn().click();
		Thread.sleep(2000);
		// String advcode=xlib.getExcelData("ProductName", 2, 0);
		System.out.println(advisorCode);
		prodSel.getAdvisorCode().sendKeys(advisorCode);
		Thread.sleep(2000);
		prodSel.getStatusText().click();
		
		if (prodSel.getValidAdvisorMsg().isDisplayed()) {
			System.out.println(" Valid Agent No ");
		} else {
			System.out.println(" Invalid Agent No ");
		}		
		
		Thread.sleep(5000);
		prodSel.getAgentSaveProceed().click();
		prodSel.getEPolicyNoBtn().click();
		prodSel.getEPolicySaveProceed().click();
		
		
		
		drop.getSelectByVisibleText(cpdetail.getProposerRelationship(), custRelationship);
		cpdetail.getDateOfBirthDay().sendKeys(day);
		cpdetail.getDateOfBirthMonth().sendKeys(month);
		cpdetail.getDateOfBirthYear().sendKeys(year);
		Thread.sleep(5000);
		cpdetail.getGenderMale().click();
		Thread.sleep(2000);
		cpdetail.getCustNoPANCheckbox().click();
		Thread.sleep(2000);
		cpdetail.getCustNoAadharCheckbox().click();

		// WebElement scrollelement =pdetail.getCustomScrollContainer1();
		// js.executeScript("arguments[0].scrollIntoView(true);",scrollelement);

		Thread.sleep(2000);
		EventFiringWebDriver eventFiring = new EventFiringWebDriver(driver);
		eventFiring.executeScript("document.querySelector('div[id=\"scrollContainer1\"]').scrollTop=500");

		//String actualEiaNum = cpdetail.getCustInitSearchEiaNum().getText();
		//System.out.println(actualEiaNum);
		// System.out.println(accountNum);
		// Assert.assertEquals(actualEiaNum, accountNum);
		Thread.sleep(2000);
		cpdetail.getCustSearch().click();
		
		
		
		Thread.sleep(2000);
		eventFiring.executeScript("document.querySelector('div[id=\"scrollContainer1\"]').scrollTop=500");
		Thread.sleep(2000);
		cpdetail.getCustHasNoPrevPolicyNum().click();
		Thread.sleep(2000);
		cpdetail.getPrevPolicySearch().click();
		Thread.sleep(2000);
		eventFiring.executeScript("document.querySelector('div[id=\"scrollContainer1\"]').scrollTop=500");
		Thread.sleep(2000);
		cpdetail.getAddNewCustomerRadio().click();
		Thread.sleep(2000);
		eventFiring.executeScript("document.querySelector('div[id=\"scrollContainer1\"]').scrollTop=500");

		drop.getSelectByVisibleText(cpdetail.getcustomerTitle(), customerTitle);
		cpdetail.getInsuredFirstName().sendKeys(insuredFN);
		cpdetail.getInsuredMiddleName().sendKeys(insuredMN);
		cpdetail.getInsuredLastName().sendKeys(insuredLN);
		Thread.sleep(2000);
		eventFiring.executeScript("document.querySelector('div[id=\"scrollContainer1\"]').scrollTop=1000");
		// eventFiring.executeScript("document.querySelector('div[id=\"scrollContainer1\"]').scrollTop=200");
		Thread.sleep(4000);
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
		cadetail.getInsuredMobileNum().sendKeys(mobileNum);
		cadetail.getInsuredEmail().sendKeys(email);
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

		logger.pass("Proposal Form success");
		
		
		
		
		
		

		nomdetails.getdaybox().sendKeys(nmDOBday);
		nomdetails.getmonthtextbox().sendKeys(nmDOBmonth);
		nomdetails.getyeartextbox().sendKeys(nmDOByear);
		Thread.sleep(5000);
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
		Thread.sleep(3000);
		
		logger.pass("Nominee personal details added successfully");
		
		nomdetails.getYesrdobtn().click();
		nomdetails.getNomineesharetxt().sendKeys(nomShare);
		nomdetails.getblankSpace().click();
		nomdetails.getsaveandpro().click();
		Thread.sleep(10000);
		
		
		
		plndetails.getSumAssuredtbox().sendKeys(sumAssured);
		Thread.sleep(5000);
		//plndetails.getPolicyTermtbox().click();
		Thread.sleep(2000);
		plndetails.getPolicyTermtbox().sendKeys(policyTerm);
		
		/*
		drop.getSelectByVisibleText(plndetails.getFrequencyPaymentDropdown(), FreqPayment);
		//drop.getSelectByVisibleTex
		Thread.sleep(2000);
		//eventFiring.executeScript("document.querySelector('div[id=\"scrollContainer1\"]').scrollTop=500");
        //Thread.sleep(2000);
		plndetails.getdaytfield().sendKeys(PSDay);
        plndetails.getmonthtfield().sendKeys(PSMonth);
        plndetails.getyeartfield().sendKeys(PSYear);
        Thread.sleep(2000);
        
        drop.getSelectByVisibleText(plndetails.medicalclassDropdown(), MedClass);
        plndetails.getsaveandproceedbtn().click();
        plndetails.getindividualBillingRadiobtn().click();
        plndetails.getDebitCardradiobtn().click();
        plndetails.getDebitAccNo().sendKeys(IndAccountNo);
        plndetails.getdebitconfirmAccNotfield().sendKeys(IndConfirmAccNo);
        drop.getSelectByVisibleText(plndetails.getdebitAccTypeDropdown(), AccType);
        plndetails.getdebitAccFnametfield().sendKeys(AccHoldersName);
        Thread.sleep(2000);
        plndetails.getifscCodeValuetfield().sendKeys(IndIfscCode);
        Thread.sleep(5000);
        //plndetails.getMICRcodetfield().click();
        
        //Thread.sleep(1000);
        drop.getSelectByVisibleText(plndetails.getpreferreddebitdateDropdown(), DebitDate);
        plndetails.getMandateAmounttextfield().sendKeys(ManDateAmount);
        Thread.sleep(2000);
        plndetails.getpremiumProposerNoradiobtn().click();
        plndetails.getsaveAndProceedForRenewalPayment().click();
        Thread.sleep(2000);
      
        
        //Payout details
        plndetails.getpayoutdetailsnotrequiredCbox().click();
        plndetails.getsaveAndProceedForPayoutDetails().click();
        Thread.sleep(2000);
        
        //premier details
        plndetails.getNoRadiobutton().click();;
        plndetails.getsaveAndProceedForPremierPayer().click();
        Thread.sleep(2000);
        
        //E comments
        plndetails.getCommentstextfield().sendKeys(Comment);
        plndetails.getsaveAndProceedForEcomment().click();
        Thread.sleep(2000);
        
        //Non reneval Half yearly
        plndetails.getPlanDeatails().click();
        Thread.sleep(3000);
        */
        
        //Half yearly
        drop.getSelectByVisibleText(plndetails.getFrequencyPaymentDropdown(), FreqPayHalfYearly);
        plndetails.getdaytfield().sendKeys(PSDay);
        plndetails.getmonthtfield().sendKeys(PSMonth);
        plndetails.getyeartfield().sendKeys(PSYear);
        Thread.sleep(2000);
        
        drop.getSelectByVisibleText(plndetails.medicalclassDropdown(), MedClass);
        Thread.sleep(1000);
        plndetails.getsaveandproceedbtn().click();
        plndetails.getnoneBillingRadiobtn().click();
        
        
        nonebilling.getsaveandproceedreneval().click();
        
        nonebilling.getpayoutdetailsnotrequiredCbox().click();
        nonebilling.getsaveandproceedpayout().click();
        nonebilling.getNoRadiobutton().click();
        nonebilling.getsaveandproceedPremiun().click();
        Thread.sleep(1000);
        //nonebilling.getsaveandproceedForCredPremiumt().click();
        
        //E comments
        plndetails.getCommentstextfield().sendKeys(Comment);
        nonebilling.getsaveandprocedforEcomments().click();
        Thread.sleep(8000);
		
		
        
//Questionaries
       
        
        //questionnarie.getExitingInsuranceDetailsText().click();
        questionnarie.getsaveandproceedQuestionInsuCover().click();
        Thread.sleep(4000);
        
        questionnarie.gethealthHeight().sendKeys(Height);
        questionnarie.gethealthWeight().sendKeys(Weight);
       //Thread.sleep(4000);
        eventFiring.executeScript("document.querySelector('section[id='section2']').scrollTop=1000");
        //Thread.sleep(5000);
        drop.getSelectByVisibleText(questionnarie.getnonsmoke(), SmokeHab);
        
        questionnarie.getdrink().click();
        Thread.sleep(2000);
        questionnarie.getsaveandproceedQuestionHealth().click();
        
        
      //Reciept cash
        drop.getSelectByVisibleText(receiptcash.getcash(), PayType);
        Thread.sleep(2000);
        drop.getSelectByVisibleText(receiptcash.getbanktieup(), BankTieUp);
        receiptcash.getcashamt().sendKeys(EnterAmount);
        receiptcash.getproceedReciept().click();
        Thread.sleep(2000);
        
        //summary
        summary.getprocedwithchkbox().click();
        summary.getsaveandvalidate().click();
        //completed
        
		
	}
}

