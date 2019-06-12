package com.prakat.Exide.Pages;

public class Questionnarie {
	//Elements Locator For Questionnarie 51-54 For No Radio Botton
		@FindBy(xpath="(//Label[@class='radioLabel'])[2]")
		private WebElement noRadioBtn;
		public WebElement getnoRadioBtn()
		{
		return noRadioBtn;
		}

		//Elements Locator For Questionnarie 55 For No Radio Botton
		@FindBy(xpath="//label[@for='minsuranceNo']")
		private WebElement noradiobtn;
		public WebElement getnoradiobtn()
		{
		return noRadioBtn;
		}
		
		//Elements Locator For health and life save and draft
		@FindBy(xpath="(//button[@class='btn btn-default'])[1]")
		private WebElement savendraft;
		public WebElement getsavendraft()
		{
		return savendraft;
		}

		//Elements Locator For Questionnarie Save And Proceed Botton
		@FindBy(xpath="//button[@class='btn btn-primary']")
		private WebElement saveanproceed;
		public WebElement getsaveanproceed()
		{
		return saveanproceed;
		}	
		
		//Elements Locator For Any Disease Radio Botton
		@FindBy(xpath="//label[@for='diseaseNo']")
		private WebElement diseasebtn;
		public WebElement getdiseasebtn()
		{
		return diseasebtn;
		}
		
		//Elements Locator For Height Text Field
			@FindBy(xpath="//input[@placeholder='Enter height']")
			private WebElement height;
			public WebElement getheigh()
			{
			return height;
			}

			        //Elements Locator For weight Text Field
					@FindBy(xpath="//input[@placeholder='Enter weight']")
					private WebElement weight;
					public WebElement getweight()
					{
					return weight;
					}
					
					//Elements Locator For Tobacco Radio Button 
					@FindBy(xpath="//label[@for='tobaccoNo']")
					private WebElement tobbaco;
					public WebElement gettobbaco()
					{
					return tobbaco;
					}
					
					//Elements Locator For smoking habit select option
					@FindBy(xpath="//select[@class='ng-valid ng-dirty ng-touched']")
					private WebElement smoking;
					public WebElement getsmoking()
					{
					return smoking;
					}
					
					//Elements Locator For alcohol drinking check box
					@FindBy(xpath="//label[@for='noDrink']")
					private WebElement drink;
					public WebElement getdrink()
					{
					return drink;
					}
					
					//Elements Locator For 64-83 radio button
					@FindBy(xpath="(//label[@class='radioLabel'])[5]")
					private WebElement secno;
					public WebElement getsecno()
					{
					return secno;
					}
					
					//Elements Locator For vaccine radio button
					@FindBy(xpath="//label[@for='vaccineYes']")
					private WebElement vaccine;
					public WebElement getvaccine()
					{
					return vaccine;
					}
					
					//Elements Locator For political person radio button
					@FindBy(xpath="//label[@for='legalNo']")
					private WebElement political;
					public WebElement getpolitical()
					{
					return political;
					}
					
					//Elements Locator For Declaration for radio button
					@FindBy(xpath="//label[@for='premiumLegalYes']")
					private WebElement proposal;
					public WebElement getproposal()
					{
					return proposal;
					}
					
					//Elements Locator For health and life save and draft
					@FindBy(xpath="(//button[@class='btn btn-default'])[1]")
					private WebElement savedraft;
					public WebElement getsavedraft()
					{
					return savedraft;
					}
					
					//Elements Locator For health and life save and proceed
					@FindBy(xpath="(//button[@class='btn btn-primary'])[2]")
					private WebElement saveproceed;
					public WebElement getsaveproceed()
					{
					return saveproceed;
					}

}
