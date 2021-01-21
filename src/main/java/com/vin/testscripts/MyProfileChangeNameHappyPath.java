package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.FrontPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class MyProfileChangeNameHappyPath extends BaseTest {

	public MyProfileChangeNameHappyPath() {
		super();
	}
	
	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());

	}
	/**
	 * ====================================================================================================================
	 * Test Case Name: MyProfileChangeNameHappyPath
	 * ====================================================================================================================
	 * 
	 * @throws Exception
	 * 
	 * 
	 */
	
	@Test
	public void verifyMyProfileChangeNameHappyPath() throws Exception {
		
		reportLog("1.1: Navigate to https://www.vin.com/");
		promoPage.verifyPromoPage();

		reportLog("1.2: Call Login method");
		loginPage = promoPage.clickOnLoginButton();
		loginPage.verifyUserLoginPage();
		frontPage = loginPage.loginInApplication(FrontPage.class, UserID, UserPswrd);
		frontPage.verifyFrontPageDisplayed();
		
		reportLog("1.3: Select 'MyVIN' from the navigation menu");
		frontPage.clickOnMyVin();
        String parentWindow = switchToChildWindow();

		reportLog("1.4: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();

		reportLog("2.1: Select Profile");
		frontPage.clickOnProfile();

		reportLog("2.2: Verify profile drop down menu has loaded");
		frontPage.dropDownMenuIsDisplayed(Constants.ProfileText);
		
		reportLog("2.3: Select Change Name");
		frontPage.selectValueFromDropDown(Constants.changeNameText);
		
		reportLog("2.4: Verify Change Name page has loaded");
		frontPage.verifyPageRefreshesAndLoadsSuccessfully(Constants.changeNameText);
		
		reportLog("2.5: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();

		reportLog("3.1: Close MyProfile window by selecting X");
        switchParentWindowByClosingChild(parentWindow);

		reportLog("3.2: Verify MyProfile window has closed");
		frontPage.verifyFrontPageDisplayed();
		
		reportLog("3.3: Call log out script");
		logoutPage = frontPage.logoutApplication();

}
}
