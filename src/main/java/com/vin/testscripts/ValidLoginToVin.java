package com.vin.testscripts;

import com.vin.pages.FrontPage;
import com.vin.selenium.core.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.vin.dataproviders.DataProviders;


public class ValidLoginToVin extends BaseTest {

	private String SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName;

//	@Factory(dataProvider = "Browsers", dataProviderClass = DataProviders.class)
	public ValidLoginToVin() {
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
	 * Test Case Name: Valid Login To Vin
	 * ====================================================================================================================
	 * 
	 * @throws InterruptedException
	 *

	 */

	@Test
	public void validLoginToVin() throws InterruptedException {

		reportLog("1: verify VIN Promo page is loaded ");

		promoPage.verifyPromoPage();

		reportLog("2: Select the LOGIN button");
		loginPage = promoPage.clickOnLoginButton();

		reportLog("3: Verify login page is displayed");
		loginPage.verifyUserLoginPage();

		reportLog("4: Log in to the Portal ");

		securityQuestionPage = loginPage.loginInApplication(UserID, UserPswrd);


		reportLog("5: Verify Security Question Page displayed");
		securityQuestionPage.verifySecurityQuestionPageDisplayed();

		reportLog("6: Enter Security Answer and Login if Security Question Page displayed");
		frontPage = securityQuestionPage.enterSecurityAnswerAndLogin(FrontPage.class, SecurityAnswerSecoreIDNumber,SecurityAnswerMothersMaidenName);

		reportLog("7: Verify Front Page displayed");
		frontPage.verifyFrontPageDisplayed();

		reportLog("8: Dismiss Notifications");
		frontPage.dismissNotifications();

		reportLog("9: Logout application");
		logoutPage = frontPage.logoutApplication();
		
		reportLog("10: Verify Logout Page displayed");
		logoutPage.verifyLogoutPageDisplayed();

	}
}
