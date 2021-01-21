package com.vin.testscripts;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.FrontPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class NewsHappyPath extends BaseTest {
	
	private String SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName, parentWin,text;
	String text1;

	public NewsHappyPath() {
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
	 * Test Case Name: NewsHappyPath
	 * ====================================================================================================================
	 * 
	 * @throws Exception
	 * 
	 * @throws ParseException
	 */
	
	@Test
	public void verifyNewsHappyPath() throws Exception {

		reportLog("1.1: verify VIN Promo page is loaded ");
		promoPage.verifyPromoPage();

		reportLog("1.2: Select the LOGIN button");
		loginPage = promoPage.clickOnLoginButton();

		reportLog("1.3: Verify login page is displayed");
		loginPage.verifyUserLoginPage();

		reportLog("1.4: Log in to the Portal ");
		securityQuestionPage = loginPage.loginInApplication(UserID, UserPswrd);

		reportLog("1.5: Verify Security Question Page displayed");
		securityQuestionPage.verifySecurityQuestionPageDisplayed();

		reportLog("1.6: Enter Security Answer and Login if Security Question Page displayed");
		frontPage = securityQuestionPage.enterSecurityAnswerAndLogin(FrontPage.class, SecurityAnswerSecoreIDNumber,
				SecurityAnswerMothersMaidenName);

		reportLog("1.7: Verify Front Page displayed");
		frontPage.verifyFrontPageDisplayed();

		reportLog("1.8 Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();
		
		reportLog("2.1: Navigate to News through Navigation bar: Library");
		newsPage=frontPage.navigateToNewsThroughNavigationBar();
		
		reportLog("2.2: Select the first article under ‘VIN News Service’");
		reportLog("2.3: Selected news article is displayed in the same tab");
        newsPage.selectTheFirstArticleUnderVINNewsService();
		
		reportLog("2.4: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();
		
		reportLog("3.1 Click on the VIN News Service logo on the top of the page");
		newsPage.clickOnVinNewsServiceLogo();
		
		reportLog("3.2  Verify News main page is displayed");
		newsPage.verifyUserISLandedBackToLatestNewsPage();
		
		reportLog("3.3: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();
		
		
		reportLog("4.1: Select ‘Read article’ from the top of the page for a story");
		reportLog("4.2 Selected article is displayed");
       newsPage.clickOnReadArticleLinkAndVerifySelectedAricleIsDisplayed();
		
		
		reportLog("4.3: Click on the VIN News Service logo on the top of the page");
		newsPage.clickOnVinNewsServiceLogo();
		
		reportLog("4.4: Verify user is back on VIN News Home Page" );
		newsPage.verifyUserISLandedBackToLatestNewsPage();

		
		reportLog("4.5: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();

	
		reportLog("5.1  Click on a News article link under 'Latest News' ");
		reportLog("5.2 The page loads the selected news article successfully. ");
		newsPage.clickOnFirstLinkUnderLatestNewsAndverifyCorrectPageLoad();
				
		reportLog("5.3: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();
		
		
		reportLog("6.1: Type in 'AVMA' on the text box under 'Search VIN News Service'");
		reportLog("6.2: AVMA is populated in the search bar");
		newsPage.TypeAVMAOnTheTextBoxUnderSearchVINNewsService(Constants.AVMAText);
		
		
		reportLog("6.3: Click the ‘Go’ button");
		newsPage.clickOnGoButton();
		
		reportLog("6.4: Search results are displayed");
		newsPage.verifySearchResultsAreDisplayed(Constants.AVMAText);
		
		reportLog("6.5: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();
		
		reportLog("6.6: Verify Each result marked with number and uncheck check box icon");
		newsPage.verifyEachResultMarkedWithNumberAndUncheckCheckBoxIcon();
		
		reportLog("7.1: Click on the 'Sort by relevance' button and then select ‘Sort by Date’");
		newsPage.selectSortByRelevanceButton(Constants.relevanceText,Constants.dateText);
		
		reportLog("7.2: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();
		
		reportLog("8.1: Click on the VIN News Service logo on the top of the page");
		newsPage.clickOnVinNewsServiceLogo();
		
		reportLog("8.2: VIN News Service page loaded successfully");
		newsPage.verifyUserISLandedBackToLatestNewsPage();

		reportLog("8.3:Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();
		
		reportLog("9.1: Scroll down and click on 'View all articles'");
		newsPage.selectViewAllArtciles();
		
		reportLog("9.2: The page expands the list of News articles");
		newsPage.verifyArticlesPageIsOpened();
		
		reportLog("9.3:Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();
		
		reportLog("10.1: logout application");
        logoutPage = frontPage.logoutApplication();

		reportLog("10.2: Logging off from VIN is successful");
        logoutPage.verifyLogoutPageDisplayed();

}
}
