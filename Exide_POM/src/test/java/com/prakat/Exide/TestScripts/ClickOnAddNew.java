package com.prakat.Exide.TestScripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.prakat.Exide.Pages.HomePage;
import com.prakat.Exide.Pages.LoginPage;
import com.prakat.Exide.Pages.ProductSelection;
import com.prakat.Generic.Helper.BaseTest;
import com.prakat.Generic.Helper.ConstantHelper;
import com.prakat.Generic.Helper.DropdownHelper;
import com.prakat.Generic.Helper.ExcelDataProvider;
import com.prakat.Generic.Helper.ExcelHelper;
import com.prakat.Generic.Helper.ScreenshotHelper;
import com.prakat.Generic.Helper.WaitHelper;
@Listeners(ScreenshotHelper.class)
public class ClickOnAddNew extends BaseTest{
	
	@DataProvider
	public Object[][] getLoginData(){
	Object data[][] = ExcelDataProvider.getTestData("ProductName");
	return data;
	}
	
	@Test(dataProvider="getLoginData")
	public void ClickAddNew(String productName, String proposalNo,String advisorCode,String accountNum) throws IOException, Throwable {
		BaseTest.logger=BaseTest.report.createTest("Click on add new");
		WaitHelper wait=new WaitHelper();
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		wait.implicitWait(30);
		xlib=new ExcelHelper();
		prodSel=new ProductSelection(driver);
		drop=new DropdownHelper();

		loginPage.login();
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, ConstantHelper.ExpPageTitle);
		System.out.println("Login success");
		
		
		try {
/*		WebElement AddNewBtn=homePage.getAddNewBtn();
		wait.waitForElementPresent(AddNewBtn, 10);*/
		Thread.sleep(10000);	
		homePage.getAddNewBtn().click();
		//loginPage.getSkipForMobileLink().click();
		//String actTitle = driver.getTitle();
		//Assert.assertEquals(actTitle, ConstantHelper.ExpPageTitle);
		//System.out.println("Login success");
		
		
		//sel.getSingleProduct().click();

		//String productName=xlib.getExcelData("ProductName", 1, 0);
		System.out.println(productName);
		//WebElement SelectProductSearch=sel.getSelectProductSearch();

		prodSel.getSelectProductSearch().sendKeys(productName);
		//wait.waitForElementPresent(SelectProductSearch, 20);
		Thread.sleep(1000);
		prodSel.getSelectProductSearch().sendKeys(Keys.ARROW_DOWN);
		prodSel.getSelectProductSearch().sendKeys(Keys.ENTER);
		
		//String proposalNo=xlib.getExcelData("ProductName", 1, 1);
		System.out.println(proposalNo);
		
		prodSel.getProposalFormNo().sendKeys(proposalNo);
		
		Thread.sleep(10000);
		prodSel.getPlanSaveProceedBtn().click();
		Thread.sleep(2000);
		//String advcode=xlib.getExcelData("ProductName", 2, 0);
		System.out.println(advisorCode);
		prodSel.getAdvisorCode().sendKeys(advisorCode);
		prodSel.getStatusText().click();
		Thread.sleep(2000);
		prodSel.getAgentSaveProceed().click();
		
		boolean bval=false;
		//Assert.assertTrue(prodSel.getEPolicyYesBtn().isSelected());
		bval=prodSel.getEPolicyYesBtn().isEnabled();
		System.out.println("vanitha");
		if(bval==true) {
			System.out.println("vanitha");
			String expected=prodSel.getInsuranceRepoText().getText();
			Assert.assertEquals("Select Insurance Repository", expected);
			prodSel.getInsuranceRepository().click();
			WebElement insuranceRepo=prodSel.getInsuranceRepository();
			
/*			String expectedRepo[]= {" CAMS Repository Services "," Central Insurance Repository "," Karvy Insurance Repository ",
					" NSDL Database Management Ltd "," SHCIL Projects Limited "};*/
			
			List<String> repoList = Arrays.asList("Select"," CAMS Repository Services "," Central Insurance Repository "," Karvy Insurance Repository ",
					" NSDL Database Management Ltd "," SHCIL Projects Limited ");
			List<String> expectedOptions = new ArrayList<>();
			expectedOptions.addAll(repoList);   
/*			List<String> expectedOptions=new ArrayList<String>();
			expectedOptions.add("Select");
			expectedOptions.add(" CAMS Repository Services ");
			expectedOptions.add(" Central Insurance Repository ");
			expectedOptions.add(" Karvy Insurance Repository ");
			expectedOptions.add(" NSDL Database Management Ltd ");
			expectedOptions.add(" SHCIL Projects Limited ");*/
			
			
			List<String> actualOptions = new ArrayList<String>();
			
			List<WebElement> repo=drop.getOptions(insuranceRepo);
			int reposize=repo.size();
			for(int i=0;i<reposize;i++) {
				WebElement option=repo.get(i);
/*				String repoNames=option.getText();
				System.out.println(repoNames);*/
				actualOptions.add(option.getText());
			}
			Assert.assertEquals(expectedOptions.toArray(),actualOptions.toArray());
			drop.getSelectByIndex(insuranceRepo, 1);
			if(prodSel.getEInsuranceAccYesBtn().isEnabled()) {
				String expectedTxt=prodSel.getEInsuranceAccText().getText();
				Assert.assertEquals("E-Insurance Account Number", expectedTxt);
				prodSel.getEAccNum().sendKeys(accountNum);
				//prodSel.getEPolicySaveProceed().click();
			}else {
				prodSel.getEInsuranceAccNoBtn().click();
			}
			
			
		}else
		{	
			prodSel.getEPolicyNoBtn().click();
			//prodSel.getEPolicySaveProceed().click();
		}
		prodSel.getEPolicySaveProceed().click();	
		logger.pass("Login success");
		}
		finally {
			//driver.close();
		}

	}
	
/*	@Test
	public void SelectProduct() throws IOException, Throwable {
		xlib=new ExcelHelper();
		try {
		ProductSelection sel=new ProductSelection();
		sel.getSingleProduct().click();
		String productName=xlib.getExcelData("ProductName", 1, 0);
		sel.getSelectProductSearch().sendKeys(productName);
	}
		finally {
			driver.close();
		}*/

}

