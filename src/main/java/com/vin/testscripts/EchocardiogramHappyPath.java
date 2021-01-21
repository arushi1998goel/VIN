package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.CalculatorPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class EchocardiogramHappyPath  extends BaseTest {
	

	public EchocardiogramHappyPath() {
		super();
	}
	
	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());

		
	}


	/**
	 * ====================================================================================================================
	 * Test Case Name: EchocardiogramHappyPath
	 * ====================================================================================================================
	 * 
	 * @throws Exception
	 * 
	 * 
	 */
	
	
	@Test
	public void verifyEchocardiogramHappyPath() throws Exception {
		
		reportLog("1.1: Bringing up VIN page");
		promoPage.verifyPromoPage();
		
		reportLog("1.1: Navigate to:  https://beta.vin.com/members/cms/project/defaultadv1.aspx?pid=618&id=7135481");
		loginPage=promoPage.NavigateToEchocardiogramHappyPath();
		
		reportLog("1.2: Verify login page is displayed (Title: Login)");
		loginPage.verifyUserLoginPage();

		reportLog("1.3: User should be directed to Echocardiogram calculator");
		calculatorpage=loginPage.loginInApplication(CalculatorPage.class,UserID, UserPswrd);
				
		reportLog("1.4: Dismiss Alert Notification if displayed");
	    calculatorpage.dismissNotifications();
	    
	    reportLog("2.1: Select dog from species drop down");
		calculatorpage.SelectDogFromDropDown(Constants.ecoSpecies);

	    reportLog("2.2: Verify user is able to select dog from drop down");
		calculatorpage.verifySpeciesDropDown(Constants.ecoSpecies);

	    reportLog("3.1: Enter 25lb weight amount in lbs");
		calculatorpage.enterWeight(Constants.ecoKgWeight);

	    reportLog("3.2: Verify user is able to enter lbs in weight field and kgs are calculated automatically");
	    calculatorpage.verifyWeightInLBSField(Constants.ecoKgWeight);
		calculatorpage.veifyThatKGCalculateAutoamtically(Constants.ecoLbsWeight);
		
	    reportLog("4.1: Enter amount in LVIDd text box = 1");
	    calculatorpage.enterMeasuredValues(Constants.measuredLVIDd,Constants.measuredValue);

	    reportLog("4.2: Verify that user is able to enter 1 in text box");
	    calculatorpage.verifyenteredMeasuredValues(Constants.measuredLVIDd,Constants.measuredValue);

	    reportLog("5.1: Enter amount in LVIDs text box = 1");
	    calculatorpage.enterMeasuredValues(Constants.measuredLVIDs,Constants.measuredValue);

	    reportLog("5.2: Verify that user is able to enter 1 in text box");
	    calculatorpage.verifyenteredMeasuredValues(Constants.measuredLVIDs,Constants.measuredValue);

        reportLog("6.1: Enter amount in IVSd text box = 1");
	    calculatorpage.enterMeasuredValues(Constants.measuredIVSd,Constants.measuredValue);

	    reportLog("6.2: Verify that user is able to enter 1 in text box");
	    calculatorpage.verifyenteredMeasuredValues(Constants.measuredIVSd,Constants.measuredValue);

	    reportLog("7.1: Enter amount in LVWd text box = 1");
	    calculatorpage.enterMeasuredValues(Constants.measuredLVWD,Constants.measuredValue);

	    reportLog("7.2: Verify that user is able to enter 1 in text box");
	    calculatorpage.verifyenteredMeasuredValues(Constants.measuredLVWD,Constants.measuredValue);

	    reportLog("8.1: Enter amount in LAs text box = 1");
	    calculatorpage.enterMeasuredValues(Constants.measuredLAs,Constants.measuredValue);

	    reportLog("8.2: Verify that user is able to enter 1 in text box");
	    calculatorpage.verifyenteredMeasuredValues(Constants.measuredLAs,Constants.measuredValue);

	    reportLog("9.1: Enter amount in Aod text box = 1");
	    calculatorpage.enterMeasuredValues(Constants.measuredAod,Constants.measuredValue);

	    reportLog("9.2: Verify that user is able to enter 1 in text box");
	    calculatorpage.verifyenteredMeasuredValues(Constants.measuredAod,Constants.measuredValue);

	    reportLog("10.1: Set echo experience level to moderate/low (selected by default)");
	    calculatorpage.verifyExperienceLevelRadioButtonIsSelected();

	    reportLog("11:1 Select calculate");
		calculatorpage.selectCalculatebutton();
		
	    reportLog("11.2: Verify results are calculated below");
	    calculatorpage.verifyEcoResultIsDisplayed();

	    reportLog("12.1: Select reset");
		calculatorpage.selectreset();

	    reportLog("13.1: Select ok on 'Do you want to clear all your inputs?' modal");
		calculatorpage.selectOkbuttoninAlert();

    	reportLog("3.2: Verify user is able to select ok and results are cleared");
    	calculatorpage.verifyResetOperation();

    	reportLog("13.3: Call logout script");
    	logoutPage=calculatorpage.logoutApplication();
	    logoutPage.verifyLogoutPageDisplayed();


}
}