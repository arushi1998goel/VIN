package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.CalculatorPage;
import com.vin.pages.LoginPage;
import com.vin.pages.FrontPage;

import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class VSPNFrontPageHappyPath extends BaseTest {
	

	public VSPNFrontPageHappyPath() {
		super();
	}
	
	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());

		
	}


	/**
	 * ====================================================================================================================
	 * Test Case Name: VSPNFrontPageHappyPath
	 * ====================================================================================================================
	 * 
	 * @throws Exception
	 * 
	 * 
	 */
	
	@Test
	public void verifyVSPNFrontPageHappyPath() throws Exception {
		

		reportLog("1.1: Navigate to https://www.vin.com/vspn/default.aspx");
		promoPage.navigateToUrl(Constants.vspnPageURL);
        loginPage = promoPage.clickOnLoginButton();

		reportLog("1.2: Call Login method (Note: Please use Login info for Selenium VSPN)");
		frontPage=loginPage.loginInApplication(FrontPage.class,UserID, UserPswrd);

		reportLog("1.3: User should be directed to VSPN Front Page");
		frontPage.verifyPageTitle(Constants.pageTitle_VSPNFrontPage);
		
		reportLog("1.4: Verify page loads successfully");
		frontPage.verifyVSPNPageLoadSuccessfully();
		
		reportLog("1.5: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();
		
		reportLog("2.1: Click 'Learn More' from the rotating banner on the top");
		frontPage.clickOnLearnMoreButton();
        String parentWindow = switchToChildWindow();
		
		reportLog("2.2: Verify a new tab opens and loads successfully");
		frontPage.verifyPageTitle(Constants.pageTitle_VETzInsight);

		reportLog("2.3: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();

		reportLog("2.4: Close tab and return to VSPN Front Page");
		switchParentWindowByClosingChild(parentWindow);

		reportLog("3.1: Click on the image above 'What's Happening in VSPN'");
		frontPage.clickOnTheImage(Constants.image1);
		switchToChildWindow();
		
		reportLog("3.2: Verify a new tab opens and loads successfully");
		frontPage.verifyPageTitle(Constants.pageTitle_VSPNHappening);
		
		reportLog("3.3: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();

		reportLog("3.4: Close tab and return to VSPN Front Page");
		switchParentWindowByClosingChild(parentWindow);

		reportLog("4.1: Click on the image above 'Message Boards'");
		frontPage.clickOnTheImage(Constants.image2);
		switchToChildWindow();

		reportLog("4.2: Verify a new tab opens and loads successfully");
		frontPage.verifyPageTitle(Constants.vspnMessgeBoardTitle);
		
		reportLog("4.3: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();

		reportLog("4.4: Close the tab and return to VSPN Front Page");
		switchParentWindowByClosingChild(parentWindow);

		reportLog("5.1: Click on the image above 'VSPN Notebook'");
		frontPage.clickOnTheImage(Constants.image3);
		switchToChildWindow();

		reportLog("5.2: Verify a new tab opens and loads successfully");
		frontPage.verifyPageTitle(Constants.VSPNnotebookTitle);

		reportLog("5.3: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();

		reportLog("5.4: Close tab and return to VSPN Front Page");
		switchParentWindowByClosingChild(parentWindow);

		reportLog("6.1: Scroll down and select the Continual Education (CE) link");
		frontPage.scrollDownAndSelectliVSPNlink(Constants.CELink);
		switchToChildWindow();
		
		reportLog("6.2: Verify a new tab opens and loads successfully");
		frontPage.verifyPageTitle(Constants.ContinualEducationPage);

		reportLog("6.3: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();

		reportLog("6.4: Close the tab and return to VSPN Front Page");
		switchParentWindowByClosingChild(parentWindow);

		reportLog("7.1: Scroll down and select the Upcoming Rounds link");
		frontPage.scrollDownAndSelectliVSPNlink(Constants.upcomingLink);
		switchToChildWindow();

		reportLog("7.2: Verify a new tab opens and loads successfully");
		frontPage.verifyPageTitle(Constants.upcomingTitle);

		reportLog("7.3: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();

		reportLog("7.4: Close the tab and return to VSPN Front Page");
		switchParentWindowByClosingChild(parentWindow);

		reportLog("8.1: Select any radio button under 'Quick Poll' (Note: If a radio button has been selected from a previous run, then verify that a graph is displayed and skip to step 9.1)");
		reportLog("8.2: Click on the 'Vote and View Results' button");
		reportLog("8.3: Verify the 'Quick Poll' section refreshes and updates displaying a graph of the survey results");
        frontPage.verifyQuickPollSection();
		
		reportLog("9.1: Call Logout method");
		logoutPage = frontPage.logoutApplication();
		logoutPage.verifyLogoutPageDisplayed();

}
}
