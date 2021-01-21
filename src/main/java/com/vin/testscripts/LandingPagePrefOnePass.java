package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.FrontPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class LandingPagePrefOnePass extends BaseTest {
	public LandingPagePrefOnePass() {
		super();
	}
	/**
	 * ====================================================================================================================
	 * Test Case Name: Landing Page Pref One Pass 
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
	public void LandingPagePrefOnePass() throws Exception{
		reportLog("1.1: Log in to VIN");
		promoPage.verifyPromoPage();
		loginPage = promoPage.clickOnLoginButton();
		loginPage.verifyUserLoginPage();
		
		reportLog("1.2: Login to VIN is successful");
		frontPage = loginPage.loginInApplication(FrontPage.class, UserID, UserPswrd);
		frontPage.verifyFrontPageDisplayed();
		
		reportLog("2.1: Select 'MyVIN' from the navigation menu");
		frontPage.clickOnMyVin();
		
		reportLog("2.2: MyVIN' pop up window  is displayed ");
        String parentWindow = switchToChildWindow();
		
		reportLog("3.1: Select 'Preferences'");
		frontPage.selectPreferencesDropDown();
		
		reportLog("3.2: A drop down menu under Preferences is displayed");
		frontPage.verifydropdownSection();

		reportLog("4.1: Select 'Landing Page' from the Preferences drop down options.");
		frontPage.selectfromPreferencesdropdown(Constants.landingPage);

		reportLog("4.2: Landing Page is selected");
		frontPage.verifyLandingPage();

		reportLog("5.1: Select 'Student Center' from the drop down menu.");
        frontPage.SelectPreferencesFromDropDown(Constants.studentcenter);
		
		reportLog("5.2: Login Landing Page Preference is updated");
		frontPage.verifyPreferencesDropDown(Constants.studentcenter);

		reportLog("6.1: Select X to close MyVIN");
		reportLog("6.2: MyVIN pop up window is closed");
        switchParentWindowByClosingChild(parentWindow);

		reportLog("7.1: Log out of VIN");
		logoutPage=frontPage.logoutApplication();

		reportLog("7.2: Log out of VIN is successful");
	    logoutPage.verifyLogoutPageDisplayed();

		reportLog("8.1: Log in to VIN");
		promoPage=logoutPage.vinLogIn();
		promoPage.verifyPromoPage();
		loginPage = promoPage.clickOnLoginButton();
		loginPage.verifyUserLoginPage();
		
		reportLog("8.2: Login to VIN is successful");
		frontPage = loginPage.loginInApplication(FrontPage.class, UserID, UserPswrd);

		reportLog("9.1: Validate Landing is changed to Student Center");
		frontPage.verifyStudentLandingPage();
		
		reportLog("9.2:Landing Page is updated");
		frontPage.verifyLandingPageIsUpdated();
		
   	    reportLog("10.1: Select 'MyVIN' from the navigation menu");
   	    frontPage.clickOnMyVin();
		
		reportLog("10.2: MyVIN' pop up window  is displayed ");
        parentWindow = switchToChildWindow();
		
		reportLog("11.1: Select 'Preferences'");
		frontPage.selectPreferencesDropDown();
		
		reportLog("11.2: A drop down menu under Preferences is displayed");
		frontPage.verifydropdownSection();

		reportLog("12.1: Select 'Landing Page' from the Preferences drop down options.");
		frontPage.selectfromPreferencesdropdown(Constants.landingPage);

		reportLog("12.2: Landing Page is selected");
		frontPage.verifyLandingPage();

		reportLog("13.1: Select 'VIN Front Page' from the drop down menu.");
        frontPage.SelectPreferencesFromDropDown(Constants.vinfrontPage);
		
		reportLog("13.2: Login Landing Page Preference is updated");
		frontPage.verifyPreferencesDropDown(Constants.vinfrontPage);

		reportLog("14.1: Select X to close MyVIN");
		reportLog("14.2: MyVIN pop up window is closed");
        switchParentWindowByClosingChild(parentWindow);

		reportLog("15.1: Log out of VIN");
		logoutPage=frontPage.logoutApplication();

		reportLog("15.2: Log out of VIN is successful");
	    logoutPage.verifyLogoutPageDisplayed();

		
	}

}
