package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.vin.utilities.Constants;


import com.vin.pages.CalculatorPage;
import com.vin.selenium.core.BaseTest;

public class BodySurfaceHappyPath extends BaseTest {
	

	public BodySurfaceHappyPath() {
		super();
	}
	
	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());

		
	}


	/**
	 * ====================================================================================================================
	 * Test Case Name: BodySurfaceHappyPath
	 * ====================================================================================================================
	 * 
	 * @throws Exception
	 * 
	 * 
	 */
	
	
	@Test
	public void verifyBodySurfaceHappyPath() throws Exception {
		

		reportLog("1.1: Bringing up VIN page");
		promoPage.verifyPromoPage();
		
		reportLog("1.1: Navigate to:  https://beta.vin.com/members/cms/project/defaultadv1.aspx?pid=618&id=7131876");
		loginPage=promoPage.navigateToBodySurfaceHappyPath();
		
		reportLog("1.2: Verify login page is displayed (Title: Login)");
		loginPage.verifyUserLoginPage();

		reportLog("1.3: User should be directed to Body Surface Calculator");
		calculatorpage=loginPage.loginInApplication(CalculatorPage.class,UserID, UserPswrd);
				
		reportLog("1.4: Dismiss Alert Notification if displayed");
	    calculatorpage.dismissNotifications();
						
		reportLog("2.1: Select species from species drop down");
		calculatorpage.SelectDogFromDropDown(Constants.searchText);
							
		reportLog("2.2: Verify user is able to select species from drop down");
		calculatorpage.verifySpeciesDropDown(Constants.searchText);
										
		reportLog("3.1: Enter weights in lbs");
		calculatorpage.enterWeight(Constants.weightLBSDog);
												
		reportLog("3.2: Verify user is able to enter an amount. Kgs are calculated automatically");
		calculatorpage.verifyWeightInLBSField(Constants.weightLBSDog);
		calculatorpage.veifyThatKGCalculateAutoamtically(Constants.kgAutomaticForDog);
		
		reportLog("4.1: Select Calculate");
		calculatorpage.selectCalculatebutton();
																
		reportLog("4.2: Verify results are calculated in the chart");
		calculatorpage.verifyResult();
	
		reportLog("5.1: Select Reset");
		calculatorpage.selectreset();
																				
		reportLog("5.2: Select ok on 'Do you want to clear all your inputs?' modal");
		calculatorpage.selectOkbuttoninAlert();
																						
	    reportLog("5.3: Verify user is able to select ok and results are reset");
		calculatorpage.resultAreReset();
																								
		reportLog("6.1: Call logout script");
		logoutPage=calculatorpage.logoutApplication();
	    logoutPage.verifyLogoutPageDisplayed();


	}
}
