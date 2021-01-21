package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.FrontPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class PreferencesBoardsOnePass extends BaseTest {

	public PreferencesBoardsOnePass() {
		super();
	}
	
	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());

	}
	/**
	 * ====================================================================================================================
	 * Test Case Name: PreferencesBoardsOnePass
	 * ====================================================================================================================
	 * 
	 * @throws Exception
	 * 
	 * 
	 */
	
	@Test
	public void verifyPreferencesBoardsOnePass() throws Exception {

		reportLog("1.1: Navigate to https://www.vin.com/");
		promoPage.verifyPromoPage();

		reportLog("1.2: Call Login method");
		loginPage = promoPage.clickOnLoginButton();
		loginPage.verifyUserLoginPage();
		frontPage = loginPage.loginInApplication(FrontPage.class, UserID, UserPswrd);
		frontPage.verifyFrontPageDisplayed();
		
		reportLog("2.1: Select 'MyVIN' from the navigation menu");
		frontPage.clickOnMyVin();
        String parentWin = switchToChildWindow();

		reportLog("2.2: Dismiss Alert Notifications if displayed by clicking on 'X' on the Alert Notification");
		frontPage.dismissNotifications();
		
		reportLog("2.3: Select 'Preferences'");
		frontPage.selectPreferencesDropDown();
		
		reportLog("2.4: Select Boards");
		frontPage.selectfromPreferencesdropdown(Constants.BoardsText);
		
		reportLog("2.5: Dismiss Alert Notifications if displayed by clicking on 'X' on the Alert Notification");
		frontPage.dismissNotifications();

		reportLog("2.6: Select the drop down next to 'Find Since'");		
		reportLog("2.7: On the drop down select 4 days");
		frontPage.selectDaysInBoard(Constants.days4);

		reportLog("2.8: Select 'X' to close MyVIN");
        switchParentWindowByClosingChild(parentWin);

		reportLog("3.1: Select 'Message Boards' from the navigation menu");
	    messageboards = frontPage.clickOnMessageBoards();

		reportLog("3.2: Dismiss Alert Notifications if displayed by clicking on 'X' on the Alert Notification");
		messageboards.dismissNotifications();

		reportLog("3.3: Verify Message Boards loads successfully");
		
		reportLog("3.4: Verify Find Since set to '4 days' on the Boards landing page");
		messageboards.verifyDaysOptionIsShownInTheDropDown(Constants.days4);
		
		reportLog("4.1: Select 'MyVIN' from the navigation menu");
	    frontPage=messageboards.clickOnMyVin();
	    switchToChildWindow();
		
		reportLog("4.2: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();

		reportLog("4.3: Select 'Preferences'");
		frontPage.selectPreferencesDropDown();

		reportLog("4.4: Select 'Boards'");
		frontPage.selectfromPreferencesdropdown(Constants.BoardsText);

		reportLog("4.5: Dismiss Alert Notifications if displayed by clicking on 'X' on the Alert Notification");
		frontPage.dismissNotifications();

		reportLog("4.6: Select the drop down next to 'Find Since'");
		reportLog("4.7: On the drop down select 2 days");
		frontPage.selectDaysInBoard(Constants.days2);

		reportLog("4.8: Select 'X' to close MyVIN");
        switchParentWindowByClosingChild(parentWin);

		reportLog("5.1: Call Logout method");
		logoutPage=frontPage.logoutApplication();
	    logoutPage.verifyLogoutPageDisplayed();
		
		




}
}