package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.CalculatorPage;
import com.vin.pages.EmergencyDrugFelinePage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class FleaandTickProductFinderHappyPath extends BaseTest {
	public FleaandTickProductFinderHappyPath() {
		super();
	}
	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());
	}
	/**
	 * ====================================================================================================================
	 * Test Case Name: Fleaand Tick Product Finder Happy Path
	 * ====================================================================================================================
	 * 
	 * @throws Exception
	 *
	 */

	@Test
	public void FleaandTickProductFinderHappyPath() throws Exception{
		
		reportLog("1.0: Bringing VIN Page");
		promoPage.verifyPromoPage();
		
		reportLog("1.1: Navigate to https://www.vin.com/members/cms/project/defaultadv1.aspx?pid=618&id=8063704");	
		loginPage=promoPage.FleaandTickProductFinderHappyPath();
		
		reportLog("1.2: 1.2: Call login script");
		loginPage.verifyUserLoginPage();
		
		reportLog("1.3: User should be directed to Flea and Tick Product Finder");
		emergecyDrugFeline=loginPage.loginInApplication(EmergencyDrugFelinePage.class,UserID, UserPswrd);
		 
		reportLog("1.4: Dismiss Alert Notification if displayed");
		emergecyDrugFeline.dismissNotifications();
		
		reportLog("2.1: Select cat from species button");
	    emergecyDrugFeline.selectCatRadioButton();

		reportLog("2.2: Verify user is able to select species");
	    emergecyDrugFeline.verifyCatRadioButtonIsSelected();

		reportLog("3.1: Select parasite from parasite drop down");
		emergecyDrugFeline.selectFromParasiteDropDown(Constants.fleavalue);

		reportLog("3.2: Verify user is able to make selection in parasite drop down");
		emergecyDrugFeline.verifysecondconditionDropdown(Constants.fleavalue);

		reportLog("4.1: Select Topical Products radio button");
		emergecyDrugFeline.selecttopicalRadioButton();
		
		reportLog("4.2: Verify user is able to select radio button");
		emergecyDrugFeline.verifytopicalButtonIsSelected();

		reportLog("5.1: Select Calculate");
	    emergecyDrugFeline.selectCalculateButton();

		reportLog("5.2: Verify user is able to calculate");
		emergecyDrugFeline.verifyuserIsAbleTocalculate();

		reportLog("5.3: Select ok on Search Successful pop up modal");
		emergecyDrugFeline.selectokonPopUp();

		reportLog("5.4: Verify user is able to select ok and results are displayed");
		emergecyDrugFeline.verifytableResult();

		reportLog("5.1: Select Reset");
	    emergecyDrugFeline.selectResetButton();

		reportLog("5.2: Verify user is able to reset");
        emergecyDrugFeline.verifytableResultAreReset();

		reportLog("6.1: Call logout script");
        logoutPage = emergecyDrugFeline.logout();
		logoutPage.verifyLogoutPageDisplayed();


	}
}
