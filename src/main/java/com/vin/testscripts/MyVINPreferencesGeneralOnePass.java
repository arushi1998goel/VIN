package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.FrontPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class MyVINPreferencesGeneralOnePass extends BaseTest {
	public MyVINPreferencesGeneralOnePass() {
		super();
	}
	/**
	 * ====================================================================================================================
	 * Test Case Name: MyVINPreferencesGeneralOnePass
	 * ====================================================================================================================
	 * 
	 * @throws Exception
	 * 
	 * 
	 */
	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());

	}
	@Test
	public void VerifyMyVINPreferencesGeneralOnePass() throws Exception{
		reportLog("1.1: Navigate to www.vin.com");
		promoPage.verifyPromoPage();
		
		reportLog("1.2: Call Login method");
		loginPage = promoPage.clickOnLoginButton();
		loginPage.verifyUserLoginPage();
		frontPage = loginPage.loginInApplication(FrontPage.class, UserID, UserPswrd);
		frontPage.verifyFrontPageDisplayed();
		
		reportLog("1.3: Dismiss Alert Notifications if displayed");
        frontPage.dismissNotifications();

		reportLog("2.1: Select 'MyVIN' from the navigation menu");
		frontPage.clickOnMyVin();
        String parentWindow = switchToChildWindow();

        reportLog("2.2: Dismiss Alert Notifications if displayed");
        frontPage.dismissNotifications();
		
		reportLog("2.3: Select 'Preferences");
		frontPage.selectPreferencesDropDown();
		
		reportLog("2.4: Select 'General' from the Preferences drop down options.");
		frontPage.selectfromPreferencesdropdown(Constants.GeneralPage);

		reportLog("2.5: Select the check box next to Make MyFavorites the default tab in VINDEX.");
		frontPage.selectCheckBoxNextToMakeMyFavorites();
		
		reportLog("2.6: Select X to close MyVIN");
        switchParentWindowByClosingChild(parentWindow);
        
		reportLog("2.7: Dismiss Alert Notifications if displayed");
        frontPage.dismissNotifications();

		reportLog("3.1: Select 'VINdex' from the navigation menu");
		vindexPage = frontPage.clickOnVindex();
		switchToChildWindow();
		
		reportLog("3.2: Dismiss Alert Notifications if displayed");
		vindexPage.dismissNotifications();

		reportLog("3.3: Validate the MyFavorites is the default tab in VINdex");
		vindexPage.verifyFavoriteTabIsByDefault();
		
		reportLog("3.4: Select X to close VINdex");
        switchParentWindowByClosingChild(parentWindow);

		reportLog("4.1: Select 'MyVIN' from the navigation menu");
		frontPage.clickOnMyVin();
		switchToChildWindow();
		 
		reportLog("4.2: Dismiss Alert Notifications if displayed");
        frontPage.dismissNotifications();

		reportLog("4.3: Select 'Preferences'");
		frontPage.selectPreferencesDropDown();

		reportLog("4.4: Select 'General' from the Preferences drop down options.");
		frontPage.selectfromPreferencesdropdown(Constants.GeneralPage);

		reportLog("4.5: Select the check box next to Make MyFavorites the default tab in VINDEX to remove the checkmark.");
		frontPage.selectCheckBoxNextToMakeMyFavorites();

		reportLog("4.6: Select X to close MyVIN");
        switchParentWindowByClosingChild(parentWindow);

		reportLog("5.1: Call Logout method");
		logoutPage = frontPage.logoutApplication();

}
}
