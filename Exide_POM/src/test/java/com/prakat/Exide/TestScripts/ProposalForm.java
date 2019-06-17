package com.prakat.Exide.TestScripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.prakat.Exide.Pages.CustomerAddressDetails;
import com.prakat.Exide.Pages.CustomerOccupationDetails;
import com.prakat.Exide.Pages.CustomerPersonalDetails;
import com.prakat.Exide.Pages.HomePage;
import com.prakat.Exide.Pages.LoginPage;
import com.prakat.Exide.Pages.NomineeDetails;
import com.prakat.Exide.Pages.ProductSelection;
import com.prakat.Generic.Helper.BaseTest;
import com.prakat.Generic.Helper.ConstantHelper;
import com.prakat.Generic.Helper.DropdownHelper;
import com.prakat.Generic.Helper.ExcelDataProvider;
import com.prakat.Generic.Helper.ExcelHelper;
import com.prakat.Generic.Helper.ScreenshotHelper;
import com.prakat.Generic.Helper.WaitHelper;

@Listeners(ScreenshotHelper.class)
public class ProposalForm extends BaseTest {

	@DataProvider
	public Object[][] getProductData() {
		Object data[][] = ExcelDataProvider.getTestData("ProposalForm");
		return data;
	}

	@Test(dataProvider = "getProductData")
	public void ProductDetails(String productName, String proposalNo, String advisorCode, String accountNum,
			String custRelationship, String day, String month, String year, String customerTitle, String ageProof,
			String insuredFN, String insuredMN, String insuredLN, String idProof, String idProofNum, String education,
			String maritalStatus, String fatherFN, String fatherMN, String fatherLN, String nationality,
			String cAddress1, String cAddress2, String cAddress3, String cLandmark, String cPincode,
			String addressProof, String mobileNum, String email, String preferedLang, String insuredOccupation,
			String insuredDesignation, String OccuDesc, String insuredEmployer, String insuredIncome,
			String fatherIncome, String fatherWork, String nmDOBday, String nmDOBmonth, String nmDOByear, String nomRelation,
			String nmMaritalStatus, String nomShare, String sumAssured)
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
		drop = new DropdownHelper();
		// JavascriptExecutor js = (JavascriptExecutor) driver;

		System.out.println("vanitha");
		loginPage.login();
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, ConstantHelper.ExpPageTitle);
		System.out.println("Login success");

		/*
		 * WebElement AddNewBtn=homePage.getAddNewBtn();
		 * wait.waitForElementPresent(AddNewBtn, 10);
		 */
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
		Thread.sleep(1000);
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
		prodSel.getStatusText().click();
		
		if (prodSel.getValidAdvisorMsg().isDisplayed()) {
			System.out.println(" Valid Agent No ");
		} else {
			System.out.println(" Invalid Agent No ");
		}		
		
		Thread.sleep(5000);
		prodSel.getAgentSaveProceed().click();

		boolean bval = false;
		// Assert.assertTrue(prodSel.getEPolicyYesBtn().isSelected());
		bval = prodSel.getEPolicyYesBtn().isEnabled();
		System.out.println("vanitha");
		if (bval == true) {
			System.out.println("vanitha");
			String expected = prodSel.getInsuranceRepoText().getText();
			System.out.println(expected);
			// Assert.assertEquals("Select Insurance Repository", expected);
			prodSel.getInsuranceRepository().click();
			WebElement insuranceRepo = prodSel.getInsuranceRepository();

			/*
			 * String expectedRepo[]=
			 * {" CAMS Repository Services "," Central Insurance Repository "
			 * ," Karvy Insurance Repository ",
			 * " NSDL Database Management Ltd "," SHCIL Projects Limited "};
			 */

			List<String> repoList = Arrays.asList("Select", " CAMS Repository Services ",
					" Central Insurance Repository ", " Karvy Insurance Repository ", " NSDL Database Management Ltd ",
					" SHCIL Projects Limited ");
			List<String> expectedOptions = new ArrayList<>();
			expectedOptions.addAll(repoList);
			/*
			 * List<String> expectedOptions=new ArrayList<String>();
			 * expectedOptions.add("Select");
			 * expectedOptions.add(" CAMS Repository Services ");
			 * expectedOptions.add(" Central Insurance Repository ");
			 * expectedOptions.add(" Karvy Insurance Repository ");
			 * expectedOptions.add(" NSDL Database Management Ltd ");
			 * expectedOptions.add(" SHCIL Projects Limited ");
			 */

			List<String> actualOptions = new ArrayList<String>();

			List<WebElement> repo = drop.getOptions(insuranceRepo);
			int reposize = repo.size();
			for (int i = 0; i < reposize; i++) {
				WebElement option = repo.get(i);
				/*
				 * String repoNames=option.getText(); System.out.println(repoNames);
				 */
				actualOptions.add(option.getText());
			}
			Assert.assertEquals(expectedOptions.toArray(), actualOptions.toArray());
			drop.getSelectByIndex(insuranceRepo, 1);
			if (prodSel.getEInsuranceAccYesBtn().isEnabled()) {
				String expectedTxt = prodSel.getEInsuranceAccText().getText();
				Assert.assertEquals("E-Insurance Account Number", expectedTxt);
				prodSel.getEAccNum().sendKeys(accountNum);
				// prodSel.getEPolicySaveProceed().click();
			} else {
				prodSel.getEInsuranceAccNoBtn().click();
			}

		} else {
			prodSel.getEPolicyNoBtn().click();
			// prodSel.getEPolicySaveProceed().click();
		}
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

		String actualEiaNum = cpdetail.getCustInitSearchEiaNum().getText();
		System.out.println(actualEiaNum);
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
		drop.getSelectByVisibleText(codetails.getInsuredDesignation(), insuredDesignation);
		codetails.getInsuredOccupationDesc().sendKeys(OccuDesc);
		drop.getSelectByVisibleText(codetails.getInsuredEmployerName(), insuredEmployer);
		codetails.getInsuredAnnualIncome().sendKeys(insuredIncome);
		codetails.getInsuredFatherAnnualIncome().sendKeys(fatherIncome);
		drop.getSelectByVisibleText(codetails.getInsuredFatherDesignation(), fatherWork);
		Thread.sleep(1000);
		codetails.getCustOccuSaveProceed().click();

		logger.pass("Proposal Form success");
		
		Thread.sleep(5000);
	
		nomdetails.getdaybox().sendKeys(nmDOBday);
		nomdetails.getmonthtextbox().sendKeys(nmDOBmonth);
		nomdetails.getyeartextbox().sendKeys(nmDOByear);
		Thread.sleep(5000);
		nomdetails.getMaleRadiobtn1().click();
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
		
		logger.pass("Nominee address & conatct details added successfully");
		Thread.sleep(5000);
		
		plandetails.getSumAssuredtbox().click();
		plandetails.getSumAssuredtbox().sendKeys(sumAssured);

		}

}

/*
 * @Test public void SelectProduct() throws IOException, Throwable { xlib=new
 * ExcelHelper(); try { ProductSelection sel=new ProductSelection();
 * sel.getSingleProduct().click(); String
 * productName=xlib.getExcelData("ProductName", 1, 0);
 * sel.getSelectProductSearch().sendKeys(productName); } finally {
 * driver.close(); }
 */
