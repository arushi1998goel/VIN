package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.FrontPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class MyProfileHappyPath extends BaseTest {

	public MyProfileHappyPath() {
		super();
	}
	
	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());

	}
	/**
	 * ====================================================================================================================
	 * Test Case Name: MyProfileHappyPath
	 * ====================================================================================================================
	 * 
	 * @throws Exception
	 * 
	 * 
	 */
	
	@Test
	public void verifyMyProfileHappyPath() throws Exception {
		
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
		reportLog("2.2: Select 'MyProfile'");
		frontPage.selectProfileFromDropDown(Constants.MyProfileText);

		reportLog("2.3: Select the edit button next to 'Address'");
		frontPage.selectEditButtonsOnMyProfilePage(Constants.adressOption);
		
		reportLog("2.4: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();

		reportLog("2.5: Verify that the 'Address' page is displayed");
		frontPage.verifyPageRefreshesAndLoadsSuccessfully(Constants.adressOption);

		reportLog("2.6: Select the back button to navigate back to the 'MyProfile' page");
		frontPage.clickOnGoBackButtons();
		
		reportLog("3.1: Select the edit button next to 'Phone Information'");
		frontPage.selectEditButtonsOnMyProfilePage(Constants.PhoneInfoText);

		reportLog("3.2: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();

		reportLog("3.3: Verify that the 'Phone & Fax' page is displayed");
		frontPage.verifyPageRefreshesAndLoadsSuccessfully(Constants.phoneandFax);
		
		reportLog("3.4: Select the back button to navigate back to the 'MyProfile' page");
		frontPage.clickOnGoBackButtons();

		reportLog("4.1: Select the edit button next to 'Picture'");
		frontPage.selectEditButtonsOnMyProfilePage(Constants.PictureText);

		reportLog("4.2: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();

		reportLog("4.3: Verify that the 'Picture' page is displayed");
		frontPage.verifyPageRefreshesAndLoadsSuccessfully(Constants.PictureText);

		reportLog("4.4: Select the back button to navigate back to the 'MyProfile' page");
		frontPage.clickOnGoBackButtons();

		reportLog("5.1: Select the edit button next to 'Email & Website Information'");
		frontPage.selectEditButtonsOnMyProfilePage(Constants.EmailAndWebsiteInformationText);

		reportLog("5.2: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();

		reportLog("5.3: Verify that the 'Email & Website' page is displayed");
		frontPage.verifyPageRefreshesAndLoadsSuccessfully(Constants.emailandwebsite);

		reportLog("5.4: Select the back button to navigate back to the 'MyProfile' page");
		frontPage.clickOnGoBackButtons();

		reportLog("6.1: Select 'Colleagues View'");
		frontPage.ClickOnButtons(Constants.colleaguesViewButton);

		reportLog("6.2: Verify Page refreshes and loads 'Colleagues View' successfully");
		frontPage.verifyPageRefreshesAndLoadsSuccessfully(Constants.colleaguesViewTitle);

		reportLog("7.1: Select 'X' to close MyVIN");
        switchParentWindowByClosingChild(parentWindow);

		reportLog("7.2: Call Logout method");
		logoutPage = frontPage.logoutApplication();



}
}
