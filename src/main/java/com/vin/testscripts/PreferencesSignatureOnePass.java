package com.vin.testscripts;

import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.FrontPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class PreferencesSignatureOnePass extends BaseTest {

	public PreferencesSignatureOnePass() {
		super();
	}
	
	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());

	}
	/**
	 * ====================================================================================================================
	 * Test Case Name: PreferencesSignatureOnePass
	 * ====================================================================================================================
	 * 
	 * @throws Exception
	 * 
	 * 
	 */
	
	@Test
	public void verifyPreferencesSignatureOnePass() throws Exception {

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
		
		reportLog("2.4: Select Signature");
		frontPage.selectfromPreferencesdropdown(Constants.SignatureText);

		reportLog("2.5: Dismiss Alert Notifications if displayed by clicking on 'X' on the Alert Notification");
		frontPage.dismissNotifications();

		reportLog("2.6: Verify under 'Manage your current signatures' text box it reads '- Selenium User -'");
		frontPage.verifyManageyourcurrentsignatures();
		
		reportLog("2.7: Select 'X' to close MyVIN");
		switchParentWindowByClosingChild(parentWin);
		
		reportLog("3.1: Call Logout method");
		logoutPage=frontPage.logoutApplication();
	    logoutPage.verifyLogoutPageDisplayed();

}
}
