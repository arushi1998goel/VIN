package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.CalculatorPage;
import com.vin.pages.EmergencyDrugFelinePage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class RodenticideHappyPath extends BaseTest{
	
	public RodenticideHappyPath() {
		super();
	}
	/**
	 * ====================================================================================================================
	 * Test Case Name: Rodenticide Happy Path
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
	/**
	 * @throws Exception
	 */
	@Test
	public void RodenticideHappyPath() throws Exception{
		
		reportLog("1: Vin page loaded ");
		promoPage.verifyPromoPage();
		
		reportLog("1.1: Navigate to: https://www.vin.com/members/cms/project/defaultadv1.aspx?pid=618&id=7920309");
		loginPage=promoPage.RodenticideHappyPath();
		
		reportLog("1.2: Call login script");
		loginPage.verifyUserLoginPage();
		
		reportLog("1.3: User should be directed to Rodenticide Calculator");
		emergecyDrugFeline=loginPage.loginInApplication(EmergencyDrugFelinePage.class,UserID, UserPswrd);

		reportLog("1.4: Dismiss Alert Notification if displayed");
		emergecyDrugFeline.dismissNotifications();
	    
	    reportLog("1.5: Pop up warning modal will display select ok");
		emergecyDrugFeline.selectokonPopUp();
	    
	    reportLog("2.1: Select dog for species");
	    emergecyDrugFeline.selectDogRadioButton();

	    reportLog("2.2: Verify user is able to select species");
	    emergecyDrugFeline.verifySpeciesIsSetToDogByDefault();

	    reportLog("3.1: Enter weight in lbs");
	    emergecyDrugFeline.enterWeightInTextBox(Constants.weightlbs);

	    reportLog("3.2: Verify user is able to enter an amount");
	    emergecyDrugFeline.verifyWeightInLBSField(Constants.weightlbs);

        reportLog("4.1: Select Bromethalin radio button");
        emergecyDrugFeline.selectBromethalinRadioButton();
	    
	    reportLog("4.2: Verify user is able to select radio button");
	    emergecyDrugFeline.verifyBromethalinButtonIsSelected();

	    reportLog("5.1: Enter quantity of bait");
	    emergecyDrugFeline.EnterQuantityOfBaitInTextBox(Constants.BaitValue);

	    reportLog("5.2: Verify user is able to enter amount");
	    emergecyDrugFeline.verifyBaitField(Constants.BaitValue);
	    
	    reportLog("6.1: Select oz from quantity of bait drop down");
	    emergecyDrugFeline.selectUnitFromDropDown(Constants.ozValue);
	    
        reportLog("6.2: Verify that oz can be selected from drop down");
        emergecyDrugFeline.verifyUnitValueIsSelectedFromDropDown(Constants.ozValue);
	    
	    reportLog("7.1: Select <4 hours radio button");
	    emergecyDrugFeline.selectLeesThenFourRadioButton();

	    reportLog("7.2: Verify that <4 radio button can be selected");
	    emergecyDrugFeline.verifyLessThenFourButtonIsSelected();
	    
	    reportLog("7.3: Select Calculate");
	    emergecyDrugFeline.selectCalculateButton();
	    
	    reportLog("7.4: Verify results are calculated below");
	    emergecyDrugFeline.verifyResultAreaDisplayed();
	    
	    reportLog("8.1: Select Reset");
	    emergecyDrugFeline.selectResetButton();
	    
	    reportLog("8.2: Verify user is able to reset");
	    emergecyDrugFeline.verifyUserIsAbleToReset();
	    
	    reportLog("9.1: Select ok on 'Do you want to clear all your inputs?' modal");
        emergecyDrugFeline.clickEnter();

	    reportLog("9.2: Verify user is able to select ok and results are cleared");
	    emergecyDrugFeline.verifyResetOperation();

	    reportLog("10.1: Call logout script");
        logoutPage = emergecyDrugFeline.logout();
		logoutPage.verifyLogoutPageDisplayed();



	}
}
