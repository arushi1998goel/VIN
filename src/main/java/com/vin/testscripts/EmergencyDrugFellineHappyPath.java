package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.EmergencyDrugFelinePage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class EmergencyDrugFellineHappyPath extends BaseTest{

	private String SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName;
	
	public EmergencyDrugFellineHappyPath() {

		super();
	}
	
	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());

		SecurityAnswerSecoreIDNumber = RegressionTestData.getProperty("SecurityAnswerSecoreIDNumber");
		SecurityAnswerMothersMaidenName = RegressionTestData.getProperty("SecurityAnswerMothersMaidenName");

	}

	/**
	 * ====================================================================================================================
	 * Test Case Name: Emergency Drug Felline Happy Path
	 * ====================================================================================================================
	 * @throws Exception
	 *
	 */
	
	@Test
	public void verifyEmergencyDrugFellineHappyPath() throws Exception
	{
		reportLog("1.0: Bringing VIN Page");
		promoPage.verifyPromoPage();

		reportLog("1.1: Navigate to https://beta.vin.com/members/cms/project/defaultadv1.aspx?pid=618&id=7135485");	
    	loginPage=promoPage.navigateToEmergencyDrugCalculator();


        reportLog("1.2: Log in to the Portal ");
        securityQuestionPage = loginPage.loginForEmergencyDrugCanine(UserID, UserPswrd);

		reportLog("1.2.1: Verify Security Question Page displayed");
		securityQuestionPage.verifySecurityQuestionPageDisplayed();

		reportLog("1.2.2: Enter Security Answer and Login if Security Question Page displayed");
		emergecyDrugFeline = securityQuestionPage.enterSecurityAnswerAndLogin(EmergencyDrugFelinePage.class,
				SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName);
		
		 reportLog("1.3: Navigate to Emergeny Drug Calculator");
         emergecyDrugFeline.navigateToEmergencyDrugsCalculatorPage();
         
         reportLog("1.4: User should be directed to Emergency Drug Calculator");
         emergecyDrugFeline.userShouldBeDirectedToEmergencyDrugCalculator();
         
         reportLog("1.5: Dismiss Alert Notification if displayed");
         emergecyDrugFeline.dismissNotifications();
         
         reportLog("2.1: Verify Species is set to dog by default");
         emergecyDrugFeline.verifySpeciesIsSetToDogByDefault();
         
         reportLog("2.2: Select Cat for species");
         emergecyDrugFeline.selectCatRadioButton();
         
         reportLog("2.3: Verify cat is selected");
         emergecyDrugFeline.verifyCatRadioButtonIsSelected();
         
         reportLog("2.4: Enter Weight in lbs Text Field");
         emergecyDrugFeline.enterWeightInLbsForDogWeightTextBox();
         
         reportLog("2.5: Verify User is able to enter numeric text. KGs are calculated automatically");
         emergecyDrugFeline.verifyValuesInTheKgTextBox();
         
         reportLog("3.1: Select Calculate");
         emergecyDrugFeline.selectCalculateButton();

         reportLog("3.2: Verify results are calculated in the table below");
         emergecyDrugFeline.verifyContentInTheRightPane(com.vin.utilities.Constants.VolumeContentForFellinehappyPath);
         
         reportLog("3.3: Select Reset");
         emergecyDrugFeline.selectResetButton();
         
         reportLog("3.4 Pop up modal will display asking the user if they want to clear results. Select ok");
         emergecyDrugFeline.verifyAlertTexts();
         emergecyDrugFeline.clickEnter();
         
         reportLog("4..1: Logout ");
         logoutPage = emergecyDrugFeline.logout();

         reportLog("4.2:  Verify Logging off from VIN is successful");
         logoutPage.verifyLogoutPageDisplayed();


	}

}
