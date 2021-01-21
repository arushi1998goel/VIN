package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.EmergencyDrugFelinePage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class NSAIDHappyPath extends BaseTest {
	
	public NSAIDHappyPath() {
		super();
	}
	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());

		
	}
	/**
	 * ====================================================================================================================
	 * Test Case Name: NSAIDHappyPath
	 * ====================================================================================================================
	 * 
	 * @throws Exception
	 * 
	 * 
	 */
	@Test
	public void NSAIDHappyPath() throws Exception {
		reportLog("1: Bringing up VIN page");
		promoPage.verifyPromoPage();
		
		reportLog("1.1: Go to:  https://www.vin.com/members/cms/project/defaultadv1.aspx?pid=618&id=8345052");
		loginPage=promoPage.navigateToNSAIDHappyPath();
		
		reportLog("1.2: Call login script");
		loginPage.verifyUserLoginPage();

		reportLog("1.3: User should be directed to Premedication calculator");
		emergecyDrugFeline=loginPage.loginInApplication(EmergencyDrugFelinePage.class,UserID, UserPswrd);

		reportLog("1.4: Dismiss Alert Notification if displayed");
		emergecyDrugFeline.dismissNotifications();
		
		reportLog("1.5: Select close on notes modal");
		emergecyDrugFeline.clickOnClose();
		
		reportLog("1.6: Verify user is able to close notes modal");
		emergecyDrugFeline.verifyUserIsAbleToCloseNotesModel();

		reportLog("2.1: Select dog radio button");
	    emergecyDrugFeline.selectFromSpeciesDropDown(Constants.dogSpeciestext);

		reportLog("2.2: Verify user is able to select cat radio button");
	    emergecyDrugFeline.verifyValueIsSelectedFromDropDown(Constants.dogSpeciestext);

		reportLog("3.1: Enter weight amount in lbs");
	    emergecyDrugFeline.enterWeightInTextBox(Constants.weightlbs);

		reportLog("3.2: Verify user is able to enter lbs in weight field and kgs are calculated automatically");
		emergecyDrugFeline.verifyWeightInLBSField(Constants.weightlbs);
	    emergecyDrugFeline.veifyThatKGCalculateAutoamtically(Constants.AutomaticweightinKG);
	    
		reportLog("4.1: Select Nonsteroidal Anti-inflammatory drug from drop down list");
		emergecyDrugFeline.selectAntiInflammatoryDrug(Constants.ketorolacValue);

		reportLog("4.2: Verify that user is able to make selection from drop down list");
		emergecyDrugFeline.verifyAntiInflammatoryDrugIsSelectedFromDropDown(Constants.ketorolacValue);

		reportLog("5.1: Select 'enter quantity' radio button. ( selected by default )");
		emergecyDrugFeline.SelectEnterQualityRadioButton();

		reportLog("5.2: Verify user is able to select 'enter quantity' radio button");
		emergecyDrugFeline.verifyEnterQualityRaduioButtonIsSelected();

		reportLog("6.1: Enter quantity amount");
		emergecyDrugFeline.EnterQualityAmount(Constants.qualityValue);

		reportLog("6.2: Verify user is able to enter quantity amount");
		emergecyDrugFeline.verifyUserIsAbleToEnterQualityAmount(Constants.qualityValue);
		
		reportLog("7.1: Select calculate");
	    emergecyDrugFeline.selectCalculateButton();

		reportLog("7.2: Verify results are calculated below");
		emergecyDrugFeline.verifyResultAreaDisplayed();
		
		reportLog("8.1: Select reset");
	    emergecyDrugFeline.selectResetButton();

		reportLog("8.2: Select ok on 'Do you want to clear all your inputs?' modal");
        emergecyDrugFeline.selectOkbuttoninAlert();

		reportLog("8.3: Verify user is able to select ok and results are cleared");
        emergecyDrugFeline.verifyResetOperation();

		reportLog("8.4: Call logout script");
        logoutPage = emergecyDrugFeline.logout();
	    logoutPage.verifyLogoutPageDisplayed();

}
	
}
