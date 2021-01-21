package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.vin.pages.LoginPage;
import com.vin.pages.TransfusionVolumePage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;


public class TransfusionVolumeHappyPath extends BaseTest {
	private String SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName;

	public TransfusionVolumeHappyPath() {
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
	 * Test Case Name: TransfusionVolumeHappyPath
	 * ====================================================================================================================
	 * 
	 * @throws Exception

	 */

	@Test

	public void transfusionVolumeHappyPath() throws Exception {

	


		reportLog("1.1: Verify promo page");
		loginPage=promoPage.verifyPromoPageForLogin(LoginPage.class);

		reportLog("1.2: Call Login Method");
		securityQuestionPage = loginPage.loginForTransfusionVolume(UserID, UserPswrd);

		reportLog("1.3: Verify Security Question Page displayed");
		securityQuestionPage.verifySecurityQuestionPageDisplayed();

		reportLog("1.4: Enter Security Answer and Login if Security Question Page displayed");
		transfusionVolume = securityQuestionPage.enterSecurityAnswerAndLogin(TransfusionVolumePage.class,
				SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName);
		
		reportLog("2.1: Dismiss Alert Notifications if displayed");
		transfusionVolume.dismissNotifications();
		
		reportLog("3.1: Select 'Library' from the toolbar");
		transfusionVolume.selectLibraryFromToolbar();
		
		reportLog("3.2: Select 'Calculators & Conversion Tables'");
		transfusionVolume.selectCalculatorsConversionTables();
		String mainWindow=transfusionVolume.getDriver().getWindowHandle();
		
		reportLog("3.3: Dismiss Alert Notifications if displayed");
		transfusionVolume.dismissNotifications();
		
		reportLog("3.4: 3.4: Select 'Transfusion Volume Calculator'");
		transfusionVolume.selectTransFusionVolumeCalculator();
		transfusionVolume.switchToNewWindow();
		
		reportLog("4.1: Dismiss Alert Notifications if displayed");
		transfusionVolume.dismissNotifications();

		reportLog("4.2: Verify 'Species' radio button is set to dog by default");
		transfusionVolume.verifySpeciesRadioButtonSetToDog();
		
		reportLog("4.3: Enter '25' in the kg text field: ");
		transfusionVolume.enter25InTextField();
		
		reportLog("4.4: Verify Lbs calculated automatically");
		transfusionVolume.verifyAmountInKGBoxAndLbsValuesAreChangedAutomatically(Constants.weight25Kg);
		
		reportLog("4.5: Enter '18' in the Actual (current) hematocrit (HCTa) text field");
		transfusionVolume.enterActualHemacrotic(Constants.actualHemacrotic18);
		
		reportLog("4.6: Enter '20' in the Desired (target) hematocrit (HCTt) text field");
		transfusionVolume.EnterDesiredHemotocritAmount(Constants.desiredHemocraticAmountForDog);

		reportLog("4.7: 4.7: Enter '66' in the Donor hematocrit (HCTd) text field");
		transfusionVolume.EnterDonorHemotocritAmount(Constants.donorHemocraticAmountForDog);
		
		reportLog("5.1: Select 'Calculate'");
		transfusionVolume.clickOnCalculateAndResetButton(Constants.calculateButton);
		
		reportLog("5.2: Verify Results are calculated");
		transfusionVolume.verifyResultsAreCalculatedForBloodVolume("2249", "68", "23");

		reportLog("6.1: Select 'Reset'");
		transfusionVolume.clickOnCalculateAndResetButton(Constants.resetButton);

		reportLog("6.2: 6.2: 'Do you want to clear all your inputs' pop up window will display");
		reportLog("6.3: Select 'OK'");
		transfusionVolume.verifyAlertText();
		
		reportLog("7.1: Dismiss Alert Notifications if displayed");
		transfusionVolume.dismissNotifications();

		reportLog("8.1:  Select the 'Cat' radio button");
		transfusionVolume.selectCatRadiouButton();
		
		reportLog("8.2: Enter '5' in the lb text field");
		transfusionVolume.enter5InTextField();
		
		reportLog("8.3: Verify kg calculated automatically");
		transfusionVolume.verifyKgCalculatedAutomaticallly(Constants.weight5Kg);
		
		reportLog("8.4: Enter '19' in the Actual (current) hematocrit (HCTa) text field");
		transfusionVolume.enterActualHemacrotic(Constants.actualHemacrotic19);
		
		reportLog("8.5: Enter '20' in the Desired (target) hematocrit (HCTt) text field");
		transfusionVolume.EnterDesiredHemotocritAmount(Constants.desiredHemocraticAmountForCat);
		
		reportLog("8.6: Enter '62' in the Donor hematocrit (HCTd) text field");
		transfusionVolume.EnterDonorHemotocritAmount(Constants.donorHemocraticAmountForCat);
		
		reportLog("9.1: Select 'Calculate'");
		transfusionVolume.clickOnCalculateAndResetButton(Constants.calculateButton);

		reportLog("9.2: Verify Results are calculated");
		transfusionVolume.verifyResultsAreCalculatedForBloodVolume("159", "3", "1");
		
		reportLog("10.1: Select 'Reset'");
		transfusionVolume.clickOnCalculateAndResetButton(Constants.resetButton);
		
		reportLog("10.2: 'Do you want to clear all your inputs' pop up window will display");
		reportLog("10.3: Select 'OK'");
        transfusionVolume.verifyAlertText();
		
        reportLog("11.1: Dismiss Alert Notifications if displayed");
		transfusionVolume.dismissNotifications();
		
		reportLog("11.2: Close the 'Transfusion Volume Calculator' tab");
        switchParentWindowByClosingChild(mainWindow);

		reportLog("12.1: Call Logout Method");
		logoutPage = transfusionVolume.logoutApplication();

		reportLog(" VIN Logout page is displayed. ");
		logoutPage.verifyLogoutPageDisplayed();
		
	}



	}

