package com.vin.testscripts;
import com.vin.pages.ChocolateToxicityPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.LoginPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class ChocolateToxicityHappyPath extends BaseTest {

	private String SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName;

	public ChocolateToxicityHappyPath() {
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
	 * Test Case Name: ChocolateToxicityHappyPath
	 * ====================================================================================================================
	 * 
	 * @throws Exception
	 * @throws ParseException
	 */

	@Test

	public void chocolateToxicityHappyPath() throws Exception {

		reportLog("1.1: Navigate to Chocolate Toxicity");
		loginPage = promoPage.verifyPromoPageForLogin(LoginPage.class);

		reportLog("1.2: Navigate to LongLink @ beta.vin.com...");
		reportLog("1.3: Log in to the Portal ");
		securityQuestionPage = loginPage.loginForChocolateToxicity(UserID, UserPswrd);

		reportLog("2.1: Verify Security Question Page displayed");
		securityQuestionPage.verifySecurityQuestionPageDisplayed();

		reportLog("2.2: Enter Security Answer and Login if Security Question Page displayed");
		chocolatetoxicitypage = securityQuestionPage.enterSecurityAnswerAndLogin(
				ChocolateToxicityPage.class, SecurityAnswerSecoreIDNumber,
				SecurityAnswerMothersMaidenName);

		reportLog("2.3: User should be directed to Chocolate Toxicity Calculator");
		chocolatetoxicitypage.verifyChocolateToxicityPage(Constants.chocolatetoxicityPage);

		reportLog("2.4: Dismiss Notification if displayed");
		chocolatetoxicitypage.dismissNotifications();

		reportLog("3.1: Enter 28lb weight for dog");
		chocolatetoxicitypage.enterWeightInTheTextBox("28");

		reportLog("3.2: User is able to enter a numeric amount for weight");
		chocolatetoxicitypage.verifyValuesInTheKgTextBox();
		chocolatetoxicitypage.verifyNumericTextInTheWeightLbTextBox();

		reportLog("4.1: Select White Chocolate");
		chocolatetoxicitypage.clickDropDownAndSelectWhiteChocolate();

		reportLog("4.2: User is able to select white chocolate from drop down");
		chocolatetoxicitypage.verifyUserIsAbleToSelectWhiteChocolateDropDownValues();

		reportLog("5.1: Enter '3333'");
		chocolatetoxicitypage.enterQuantityText("3333");

		reportLog("5.2: User is able to enter the text amount");
		chocolatetoxicitypage.verifyNumericValuesInTheQuantityTextBox();

		reportLog("6.1: Select 'oz' from amount unit drop down");
		chocolatetoxicitypage.selectQuantityDropDown();

		reportLog("6.2: User is able to select oz");
		chocolatetoxicitypage.verifyQuantityValueFromtheDropDown();

		reportLog("7.1: Select radio button");
		chocolatetoxicitypage.selectAnimationOnRadioButton();

		reportLog("7.2: Verify User is able to make a selection");
		chocolatetoxicitypage.verifyRadioButtonIsSelected();

		reportLog("8.1: User is able to select  Calcualte button");
		chocolatetoxicitypage.selectCalculateButton();

		reportLog("8.2: Verify Dog animation should result in potential death on scale canvas");
		//chocolatetoxicitypage.verifyPotentialDeathScaleCanvas();
		chocolatetoxicitypage.verifyScaleCanvasValues(Constants.triangleStyle);

		reportLog("9.1: Select Reset");
		chocolatetoxicitypage.selectResetButton();

		reportLog("9.2: Pop up modal asking to confirm reset, select Yes, I want to clear them all");
		chocolatetoxicitypage.VerifyRestPopup();
		chocolatetoxicitypage.clickOnYesButtonAfterReset();

		reportLog("9.3: Verify Values are reset");
		chocolatetoxicitypage.VerifyValuesAreReset();

		reportLog("10.1: Logout ");
		logoutPage = chocolatetoxicitypage.logout();

		reportLog("10.2: Verify Logging off from VIN is successful");
		logoutPage.verifyLogoutPageDisplayed();
	}
	
}
