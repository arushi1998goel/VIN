package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.CalculatorPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class FreeWaterDeficitHappyPath extends BaseTest {
	public FreeWaterDeficitHappyPath() {
		super();
	}
	/**
	 * ====================================================================================================================
	 * Test Case Name: Fluid Therapy Happy Path
	 * ====================================================================================================================
	 * 
	 * @throws Exception
	 * 
	 * 
	 */
	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());

		

	}
	@Test
	public void FreeWaterDeficitHappyPath() throws Exception{
		reportLog("1: Vin page loaded ");
		promoPage.verifyPromoPage();
		
		reportLog("1.1: Navigate to:  https://www.vin.com/members/cms/project/defaultadv1.aspx?pid=618&id=7139929");
		loginPage=promoPage.FreeWaterDeficitHappyPath();
		
		reportLog("1.2: Call login script");
		loginPage.verifyUserLoginPage();
		
		reportLog("1.3: User should be directed to Free Water Deficit calculator");
		calculatorpage=loginPage.loginInApplication(CalculatorPage.class,UserID, UserPswrd);

		reportLog("1.4: Dismiss Alert Notification if displayed");
	    calculatorpage.dismissNotifications();

		reportLog("2.1: Enter weight amount in lbs");
	    calculatorpage.enterWeight(Constants.weightlbs);

		reportLog("2.2: Verify user is able to enter lbs in weight field and kgs are calculated automatically");
		calculatorpage.verifyWeightInLBSField(Constants.weightlbs);
	    calculatorpage.veifyThatKGCalculateAutoamtically(Constants.AutomaticweightinKG);
	    
		reportLog("3.1: Select Chronic radio button");
		calculatorpage.selectchronicRadioButton();
		
		reportLog("3.2: Verify that user is able to select radio button.");
		calculatorpage.chronicButtonIsSelected();
		
		reportLog("4.1: Enter 200 in Current [Na+] text field");
		calculatorpage.enterValueInNaTextField(Constants.naField);
		
		reportLog("4.2: Verify user is able to enter an amount");
		calculatorpage.verifyNaDataField(Constants.naField);	
		
		reportLog("4.3: Leave Target [Na+] at 160mEq/L default");
		calculatorpage.verifyNaDefaultDataField(Constants.nadefaultField);
		
		reportLog("5.1: Select calculate");
		calculatorpage.selectCalculatebutton();

		reportLog("5.2: Verify results are calculated below");
	    calculatorpage.verifyResultAreaDisplayed();

		reportLog("6.1: Select reset");
		calculatorpage.selectreset();

		reportLog("6.2: Select ok on 'Do you want to clear all your inputs' modal");
		calculatorpage.selectOkbuttoninAlert();

		reportLog("6.3: Verify user is able to select ok and results are cleared");
	    calculatorpage.resetWaterDeficitCalculator();

		reportLog("7.1: Call logout script");
		logoutPage=calculatorpage.logoutApplication();
		logoutPage.verifyLogoutPageDisplayed();

	}
	


}
