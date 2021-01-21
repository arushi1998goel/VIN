package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.EmergencyDrugFelinePage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class PremedicationDogDrugHappyPath extends BaseTest {

	public PremedicationDogDrugHappyPath() {
		super();
	}
	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());

		
	}
	/**
	 * ====================================================================================================================
	 * Test Case Name: PremedicationDogDrugHappyPath
	 * ====================================================================================================================
	 * 
	 * @throws Exception
	 * 
	 * 
	 */
	@Test
	public void verifyPremedicationDogDrugHappyPath() throws Exception {
		reportLog("1: Bringing up VIN page");
		promoPage.verifyPromoPage();
		
		reportLog("1.1: Go to:  https://www.vin.com/Members/cms/project/defaultadv1.aspx?pid=618&id=8383804");
		loginPage=promoPage.navigateToPremedicationDrugHappyPath();
		
		reportLog("1.2: Call login script");
		loginPage.verifyUserLoginPage();

		reportLog("1.3: User should be directed to Premedication calculator");
		emergecyDrugFeline=loginPage.loginInApplication(EmergencyDrugFelinePage.class,UserID, UserPswrd);

		reportLog("1.4: Dismiss Alert Notification if displayed");
		emergecyDrugFeline.dismissNotifications();
	    
	    reportLog("2.1: Select dog radio button. Dog selected by default");
	    emergecyDrugFeline.verifySpeciesIsSetToDogByDefault();

	    reportLog("2.2: Verify user is able to select dog radio button");
	    emergecyDrugFeline.verifySpeciesIsSetToDogByDefault();

	    reportLog("3.1: Enter weight amount in lbs");
	    emergecyDrugFeline.enterWeightInTextBox(Constants.weightlbs);
	    
	    reportLog("3.2: Verify user is able to enter lbs in weight field and kgs are calculated automatically");
	    emergecyDrugFeline.verifyWeightInLBSField(Constants.weightlbs);
	    emergecyDrugFeline.veifyThatKGCalculateAutoamtically(Constants.AutomaticweightinKG);
	    
	    reportLog("4.1: Select calculate");
	    emergecyDrugFeline.selectCalculateButton();
	    
	    reportLog("4.2: Verify results are calculated in volume column");
		emergecyDrugFeline.verifyContentInTheRightPane(Constants.premedicationDogcontents);

	    reportLog("5.1: Select reset");
	    emergecyDrugFeline.selectResetButton();

	    reportLog("5.2: Select ok on 'Do you want to clear all your inputs?' modal");
        emergecyDrugFeline.selectOkbuttoninAlert();

	    reportLog("5.3: Verify user is able to select ok and results are cleared");
        emergecyDrugFeline.verifyResetOperation();

	    reportLog("6.1: Call logout script");
        logoutPage = emergecyDrugFeline.logout();
	    logoutPage.verifyLogoutPageDisplayed();

	    
		
}
}
