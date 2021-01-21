package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.CRIPage;
import com.vin.pages.FeedingTubeAndTransfusionVolumePage;
import com.vin.pages.FrontPage;
import com.vin.pages.LoginPage;
import com.vin.pages.LogoutPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class CRIHappyPath extends BaseTest {

	private String SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName;

	public CRIHappyPath() {
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
	 * Test Case Name: CRIHappyPath
	 * ====================================================================================================================
	 * 
	 * @throws Exception
	 */

	@Test

	public void verifyCRIHappyPath() throws Exception {

		reportLog("1.1: Navigate to Constant Rate Infusion Calculator LongLink @ beta.vin.com...");
		reportLog("1.2: Verify login page is displayed");
		loginPage = promoPage.verifyPromoPageForLogin(LoginPage.class);

		reportLog("1.3: Log in to the Portal ");
		securityQuestionPage = loginPage.loginForCRI(UserName_VINuser, Password_VINuser);

		reportLog("1.4: Verify Security Question Page displayed");
		securityQuestionPage.verifySecurityQuestionPageDisplayed();

		reportLog("1.5: Enter Security Answer and Login if Security Question Page displayed");
		CRIPage criPage = securityQuestionPage.enterSecurityAnswerAndLogin(CRIPage.class, SecurityAnswerSecoreIDNumber,
				SecurityAnswerMothersMaidenName);

		reportLog("1.6:  Dismiss Notifications if displayed");
		criPage.dismissNotifications();
	
		reportLog("2.1: Select cat");
		
		reportLog("2.2: Verify User is able to select species. Dog is selected by default");
		criPage.verifySpeciesIsSetToDogByDefault();
		

		reportLog("3.1 Enter 35 lbs");
		criPage.enterWeightInTheTextBox();

		reportLog("3.2  Verify User is able to enter weight and kgs are converted automatically");
		criPage.verifyValuesInTheKgTextBox();
		criPage.verifyNumericTextInTheWeightLbTextBox();

		reportLog("4.1 Select single drug");
		criPage.selectSingleRadioButton();

		reportLog("4.2 Verify User is able to select single drug. Single drug is selected by default");
		criPage.verifySingleDrugRadioButtonIsSelected();

		reportLog("5.1 Select Alfaxalone");
		criPage.selectDrugFromTheDropDown();

		reportLog("5.2  Verify User is able to make drug selection. After selecting drug Infusion rate and drup concentration are auto filled with drug selection.");
		criPage.verifyValueIsSelectedFromTheDropDown();

		reportLog("6.1 Enter .2");
		criPage.enterTextInTheInfusionRateTextbox();

		reportLog("6.2 Verify User is able to enter numeric text. ");
		criPage.verifyTextIsPresentInTheInfusionRateTextbox();

		reportLog("7.1 Select 10 mg/ml ");
		criPage.selectDrugConcentrationAmountFromTheDropDown();

		reportLog("7.2 Verify User is able to make selection");
		criPage.verifyUserIsAbleToMakeASelectionFromTheDrugConcentrationAmount();

		reportLog("8.1 Select 'Adding to volume'");
		criPage.selectAddingToVolumeRadioButton();

		reportLog("8.2 Verify User is able to select the 'Adding to volume' radio button");
		criPage.addToVolumeRadioButtonIsSelected();

		reportLog("9.1 Select 1000ml from bag size drop down");
		criPage.selectOptionFromTheDropDown();

		reportLog("9.2 Verify User is able to make selection from drop down. ");
		criPage.verifyUserIsAbleToSelectOptionFromTheBagSizeDropDown();

		reportLog("10.1 Select ml/hr radio button ");
		criPage.verifyFluidRadioButtonIsSelected();

		reportLog("10.2 Verify User is able to select ml/hr radio button");
		criPage.fluidRadioButtonIsSelected();

		reportLog("11.1 Enter 100");
		criPage.EnterAmountFluidRateTextBox();

		reportLog("11.2 Verify User is able to enter fluid rate");
		criPage.verifyAmountInTheFluidRateTextBox();

		reportLog("12.1 Select calculate");
		criPage.selectCalculateButton();

		reportLog("12.2 Volume of drug to add:3.19ml  ");
		criPage.verifyVolumeOfDrugValuesIsDisplayed();

		reportLog("12.3  Verify Infusion (dose) rate: .2mg/kg/hr");
		criPage.verifyInfusionRateValuesIsDisplayed();

		reportLog("12.4 Flow rate: 100 ml/hr (2400 ml/day");
		criPage.verifyFlowRateValuesIsDisplayed();

		reportLog("12.5 Estimated time: 10 hrs (0.42 days)");
		criPage.verifyEstimatedTimeValuesIsDisplayed();

		reportLog("13.1 Select clear drug info8");
		criPage.selectClearDrugInfoButton();

		reportLog("13.2 Drug information and results are erased but species selection and weight inputs remain");
		criPage.verifyValuesAreclearedAfterSelectingClearDrugRadioButtonExcepWeightAndSpecies();

		reportLog("14.1 Select reset");
		criPage.selectResetButton();

		reportLog(
				"14.2 Pop up modal asking user if they want to clear all inputs will display. Select yes, weight and species are cleared. Dog remains selected by default. ");
		criPage.verifyAlertTexts();


		reportLog("15.1: logout Application");
	    LogoutPage logout = criPage.logout();

		reportLog("15.2: verify logout");
		logout.verifyLogoutPageDisplayed();
	}
	
	
}
