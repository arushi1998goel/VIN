package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.FrontPage;
import com.vin.selenium.core.BaseTest;

import com.vin.utilities.Constants;

public class ProfileLicensureHappyPath extends BaseTest {
	public ProfileLicensureHappyPath() {
		super();
	}
	
	/**
	 * ====================================================================================================================
	 * Test Case Name: Profile Licensure Happy Path
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
	public void VerifyProfileLicensureHappyPath() throws Exception{
		
		
		reportLog("1.1: Go to VIN Promo Page");
		reportLog("1.2: Vin page loaded ");
		promoPage.verifyPromoPage();
		
		reportLog("2.1: Run Selenium login script ");
		loginPage = promoPage.clickOnLoginButton();
		loginPage.verifyUserLoginPage();

		reportLog("2.2:selenium user logged in successfully");
		frontPage = loginPage.loginInApplication(FrontPage.class, UserID, UserPswrd);
		frontPage.verifyFrontPageDisplayed();

		reportLog("3.1: Dismiss alert pop up");
		frontPage.dismissNotifications();
		
		reportLog("4.1: Open MyVIN by clicking on MyVIN tab on the top of navigation bar");
		frontPage.clickOnMyVin();
		
		reportLog("4.2:MyStuff page opens up in new window");
		frontPage.switchToNewWindow();

		reportLog("5.1: Dismiss alert pop up");
		frontPage.dismissNotifications();
		
		reportLog("6.1: Expand Profile drop down and choose Licensure");
		frontPage.selectProfileFromDropDown(Constants.licnsureValue);
        
		reportLog("6.2:Profile Licensure page loaded with option to add Licensure and checkbox  with content message allowing user to check ");
		frontPage.vrifyProfileLicensurePage();
		
		reportLog("7.3:Dismiss alert pop up");
		frontPage.dismissNotifications();

		reportLog("8.1:Click on Add Licensure button");
		frontPage.clickOnAddLensure();
		
		reportLog("8.2:add licensure pop up window opened");
	    frontPage.verifyAddLicensurePopup();
		
		reportLog("9.1:in State/Province , pick California state from listed value");
		frontPage.selectStateFromDropDown(Constants.californiaState);

		reportLog("9.2:State/Province saved with California value");
        frontPage.verifyState(Constants.californiaState);
         
		reportLog("10.1:type 708634 in License Number text box");
		frontPage.enterLicenseNo(Constants.licenseNo);
		
		reportLog("10.2:License Number set with 708634 license number");
		frontPage.verifyLicenseNo(Constants.licenseNo);
		
    	reportLog("11.1: Click on Add Licensure button");
		frontPage.AddLicensureButton();
		
		reportLog("12.1: Click on x icon next to added licensure record to delete");
		frontPage.clickOnCroseIcontoDeleteTheRecord();
			
		reportLog("12.2: Record deleted");
		frontPage.verifyCertificationDeleted();
		
		reportLog("13: Call logout script");
	    logoutPage=frontPage.logoutFromLicensePage();
	    logoutPage.verifyLogoutPageDisplayed();


		
		
		
	}

}
