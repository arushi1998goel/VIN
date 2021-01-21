package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.CalculatorPage;
import com.vin.pages.EmergencyDrugFelinePage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class FluidTherapyHappyPath extends BaseTest{
	

	public FluidTherapyHappyPath() {
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
	public void FluidTherapyHappyPath() throws Exception{
		
		reportLog("1: Vin page loaded ");
		promoPage.verifyPromoPage();
		
		reportLog("1.1: Navigate to:  https://www.vin.com/members/cms/project/defaultadv1.aspx?pid=618&id=7920317");
		loginPage=promoPage.FluidTherapyHappyPath();
		
		reportLog("1.2: Call login script");
		loginPage.verifyUserLoginPage();
		
		reportLog("1.3: User should be directed to Fluid Therapy calculator");
		emergecyDrugFeline=loginPage.loginInApplication(EmergencyDrugFelinePage.class,UserID, UserPswrd);
		 
		reportLog("1.4: Dismiss Alert Notification if displayed");
		emergecyDrugFeline.dismissNotifications();
		
		reportLog("1.5: Select ok on warning modal");
		emergecyDrugFeline.selectokonPopUp();

		reportLog("1.6: Verify user is able to close warning modal");
		emergecyDrugFeline.verifyuserIsAbleToCloseWarningModel();
		
		reportLog("2.1: Select cat radio button");
	    emergecyDrugFeline.selectCatRadioButton();
	    
	    reportLog("2.2: Verify user is able to select cat radio button");
	    emergecyDrugFeline.verifyCatRadioButtonIsSelected();
	    
	    reportLog("3.1: Enter weight amount in lbs");
	    emergecyDrugFeline.enterWeightInTextBox(Constants.weightlbs);
	    
	    reportLog("3.2: Verify user is able to enter lbs in weight field and kgs are calculated automatically");
	    emergecyDrugFeline.verifyWeightInLBSField(Constants.weightlbs);
	    emergecyDrugFeline.veifyThatKGCalculateAutoamtically(Constants.AutomaticweightinKG);
	    
	    reportLog("4.1: Select 'My patient is hydrated, I just want to get a maintenance fluid rate' radio button. (Default Selection)");
	    emergecyDrugFeline.selectHydratedCheckBox();

	    reportLog("4.2: Verify that user is able to select radio button.");
	    emergecyDrugFeline.verifyHydratedCheckBoxisselected();
	    
	    reportLog("5.1: Select calculate");
	    emergecyDrugFeline.selectFluidCalculateButton();

	    reportLog("5.2: Verify results are calculated below");
	    emergecyDrugFeline.verifyResultIsCalculated();

	    reportLog("6.1: Select reset/start over");	
	    emergecyDrugFeline.selectResetButton();

	    reportLog("6.2: Verify user is able to select reset/start over and results are cleared");
	    emergecyDrugFeline.verifyResultIsReset();
	    
	    reportLog("6.3: Call logout script");
	    logoutPage=emergecyDrugFeline.logout();
		logoutPage.verifyLogoutPageDisplayed();





}
	
}
