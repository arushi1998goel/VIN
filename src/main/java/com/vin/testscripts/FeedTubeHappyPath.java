package com.vin.testscripts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.vin.pages.FeedingTubeAndTransfusionVolumePage;
import com.vin.pages.LoginPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;


public class FeedTubeHappyPath extends BaseTest {
	private String SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName;

	public FeedTubeHappyPath() {
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
	 * Test Case Name: FeedingTubeHappyPath
	 * ====================================================================================================================
	 * 
	 * @throws Exception

	 *
	 * 
	 * @throws ParseException

	 */

	@Test
	public void feedTubeHappyPath() throws Exception {
		
		reportLog("1.0: Bringing VIN Page");
		promoPage.verifyPromoPage();
		
		reportLog("1.1: Navigate to Feeding Tube calculator https://beta.vin.com/members/cms/project/defaultadv1.aspx?pid=618&id=8212093");
		loginPage=promoPage.navigateToFeedTubeHappyPath();

		reportLog("1.2: Verify login page is displayed");
		loginPage.verifyUserLoginPage();
		//loginPage=promoPage.verifyPromoPageForLogin(LoginPage.class);

		reportLog("1.3: Log in to the Portal ");
		securityQuestionPage = loginPage.loginForFeedingTube(UserName_VINuser, Password_VINuser);

		reportLog("1.4: Verify Security Question Page displayed");
		securityQuestionPage.verifySecurityQuestionPageDisplayed();

		reportLog("1.5: Enter Security Answer and Login if Security Question Page displayed");
		feedintubeAndTransfusionPage = securityQuestionPage.enterSecurityAnswerAndLogin(
				FeedingTubeAndTransfusionVolumePage.class, SecurityAnswerSecoreIDNumber,
				SecurityAnswerMothersMaidenName);

		reportLog("1.6: Dismiss Notifications");
		feedintubeAndTransfusionPage.dismissNotifications();



		reportLog(
				"1.7: User should be directed to Feeding Tube Calculator and a pop up modal will display. Select ok. ");
		feedintubeAndTransfusionPage.verifyFeedingTubePageAndSelectOk(Constants.feedingTubeCalculatorTitle);
		
		reportLog("2.1: Enter weight");
		feedintubeAndTransfusionPage.enterWeightInLb(Constants.weight10lb);
		

		reportLog("2.2: User is able to enter a numeric amount for weight");
		feedintubeAndTransfusionPage.verifyWeightInLb(Constants.weight10lb);
		
//		reportLog("2.2 KGs are calculated automatically");
//		feedintubeAndTransfusionPage.verifyAmountInWeightBoxAndKgValuesAreChangedAutomatically(Constants.weight28lbss);

		reportLog("3: Verify 1 is selected by default");
		feedintubeAndTransfusionPage.verifyDropDownValuesSelected(Constants.dropdownValue);

		reportLog("3.1: Select 1 from drop down");
		feedintubeAndTransfusionPage.selectValuesFromDaysUntilReferenceDropDown(Constants.dropdownValue);

		reportLog("3.2:  Verify User is able to select from drop down");
		feedintubeAndTransfusionPage.verifyDropDownValuesSelected(Constants.dropdownValue);

		reportLog("4.1: Select 4 from drop down");
		feedintubeAndTransfusionPage.selectValuesFromFeedingPerDayDropDown(Constants.feedingPerDayValue);

		reportLog("4.2: Verify User is able to select from drop down");
		feedintubeAndTransfusionPage.verifyFeedingPerDayDropDownValuesSelected(Constants.feedingPerDayValue);

		reportLog("5.1: Select Hills Prescription Diet a/d canine/feline canned");
		feedintubeAndTransfusionPage.selectValuesFromSelectArecoveryDiet(Constants.recoveryDietValue);

		reportLog("5.2: Verify User is able to select from drop down");
		feedintubeAndTransfusionPage.verifyrecoveryDietValueSelected(Constants.recoveryDietValue);

		reportLog("6.1: Select the 'No' radio button");
		feedintubeAndTransfusionPage.selectNoRadioButton();

		reportLog("6.2:  Verify User is able to select from  radio button");
		feedintubeAndTransfusionPage.verifyradioButtonSelected();

		reportLog("7.1: Select calculate button");
		feedintubeAndTransfusionPage.selectCalculate();

		reportLog("7.2: User is able to select button");
		feedintubeAndTransfusionPage.verifyCalculatebuttonSelected();

		reportLog("7.3:  Verify Results are calculated");
		feedintubeAndTransfusionPage.verifyResultValue(Constants.result);

		reportLog("8.1: Select Reset button");
		feedintubeAndTransfusionPage.selectresetbutton();

		reportLog("8.2: Pop up modal will display asking the user if they want to clear all inputs. Select ok");
		feedintubeAndTransfusionPage.verifyAlertText();

		reportLog("8.3: Verify Reset Button is selected");
		feedintubeAndTransfusionPage.verifyResetButtonIsSelected();

		reportLog("9.1: Logout Application");
		logoutPage = feedintubeAndTransfusionPage.logoutApplication();

		reportLog("9.2: Verify Logging off from VIN is successful");
		logoutPage.verifyLogoutPageDisplayed();

	}



}
