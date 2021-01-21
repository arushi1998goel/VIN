package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.FrontPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class FrontPageScriptsHappyPath extends BaseTest {
	String title;
	private String SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName;

	public FrontPageScriptsHappyPath() {
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
	 * Test Case Name: FrontPageHappyPath
	 * ====================================================================================================================
	 *
	 * @throws Exception
	 * @throws ParseException
	 */

	@Test
	public void frontPage() throws Exception {

		reportLog("1.1: Verify VIN Promo page is loaded (Title: Veterinary Information Network®, Inc. – VIN)");
		promoPage.verifyPromoPage();

		reportLog("1.2: Select the LOGIN button");
		loginPage = promoPage.clickOnLoginButton();

		reportLog("1.3: Verify login page is displayed (Title: Login)");
		loginPage.verifyUserLoginPage();

		reportLog("1.4: Log in to the Portal ");
		securityQuestionPage = loginPage.loginInApplication(UserID, UserPswrd);

		reportLog("1.5: Verify Security Question Page displayed (Title: VIN – Security Question)");
		securityQuestionPage.verifySecurityQuestionPageDisplayed();

		reportLog("1.6: Enter Security Answer and Login if Security Question Page displayed");
		frontPage = securityQuestionPage.enterSecurityAnswerAndLogin(FrontPage.class, SecurityAnswerSecoreIDNumber,
				SecurityAnswerMothersMaidenName);

		reportLog("1.7: Verify Front Page displayed (Title: Front Page – VIN)");
		frontPage.verifyFrontPageDisplayed();
		String mainWindow=frontPage.getDriver().getWindowHandle();

		reportLog("1.8: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();

		reportLog("2.1: Click on left and right arrow on image carousel");
		frontPage.clickOnLeftArow();

		reportLog("2.2: Verify CE Course banner changes every time user clicks on right or left arrow");
		frontPage.verifyBannerChanges();

		reportLog("3.1: Click on CE Banner ");
		title=frontPage.getTheTitleOfTheBanner();
		System.out.println(title);
		frontPage.clickOnBannerImage();

		reportLog("3.2: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();
		
		
		reportLog("3.3: Verify Advertised CE course page opened in new tab. (Course name matches the name on ce banner)");
		frontPage.switchToNewWindow();
		frontPage.verifyPageTitleIsSameAsThePage(title);

		reportLog("4.1 Close tab and Go back to front page");
		frontPage.getDriver().close();
		frontPage.getDriver().switchTo().window(mainWindow);

		reportLog("4.2 Verify user is back on front page ");
		frontPage.verifyPreviousPage();

		reportLog("5.1 Click on first link in daily pearl ");
		frontPage.clickOnFirstLinkInDailyPearls();
		
		reportLog("5.2: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();


		reportLog("5.2 Link opens up in new tab. (Verify link source matches the link title on front page)");
		frontPage.switchToNewWindow();
		frontPage.verifyMedicalFaqsWindowIsOpenInNewWindow();

		reportLog("6.1 Close tab and Go back to front page ");
		frontPage.getDriver().close();
		frontPage.getDriver().switchTo().window(mainWindow);

		reportLog("6.2 Verify user is back on front page ");
		frontPage.verifyPreviousPage();
		
		reportLog("6.3: Scroll down at Quick Poll with answer options");
		frontPage.scrollDownAtQuickPollsWithAnswerOption();
		
		reportLog("6.4: Verify that the quickpoll is loaded");
		frontPage.verifyThatThequickPollIsLoaded();
		
		reportLog("7.1: Scroll down and Click on VIN Consultant link on front page");
		String name=frontPage.scrollDownAndClickOnVINConsultantLink();
		
		reportLog("7.2: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();

		reportLog("7.3: VIN Consultants and Editors page opens up in new tab (Consultant name matches consultant name link on front page)");
		frontPage.switchToNewWindow();
		frontPage.consultantNameMatchesConsultantNameLink(name);
		
		reportLog("8.1: Close tab and Go back to front page");
		frontPage.getDriver().close();
		frontPage.getDriver().switchTo().window(mainWindow);
		
		reportLog("8.2: User is back on front page");
		frontPage.verifyFrontPageDisplayed();

		reportLog("9.1: Enter 'Dog' in search box and select the magnifying icon");
		frontPage.enterInSearchBoxAndSelectMagnifyingIcon(Constants.searchText);
		
		reportLog("9.2: Search result for Dog is displayed in a new tab");
		frontPage.switchToNewWindow();
		frontPage.verifySearchPageInNewTab();
		frontPage.verifyCorrectSearchInNewTab(Constants.searchText);
		frontPage.getDriver().close();
		frontPage.getDriver().switchTo().window(mainWindow);
		
		reportLog("9.3: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();

		reportLog("10.1: logout application");
		logoutPage=frontPage.logoutApplication();
		
		reportLog("10.2: Logging off from VIN is successful");
		logoutPage.verifyLogoutPageDisplayed();
		
		

		
	}
}
