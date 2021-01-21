package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.FrontPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class MyProfileLicensureHappyPath  extends BaseTest {

	public MyProfileLicensureHappyPath() {
		super();
	}
	
	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());

	}
	/**
	 * ====================================================================================================================
	 * Test Case Name: MyProfileLicensureHappyPath
	 * ====================================================================================================================
	 * 
	 * @throws Exception
	 * 
	 * 
	 */
	
	@Test
	public void verifyMyProfileEducationHappyPath() throws Exception {
		
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
		reportLog("2.3: Select 'Add Licensure'");
		frontPage.selectProfileFromDropDown(Constants.licnsureValue);
		
		reportLog("2.3: Select 'Add Licensure'");
		frontPage.ClickOnButtons(Constants.AddLicensureText);

		reportLog("2.4: Verify 'Add Licensure' pop up is displayed");
		frontPage.verifyPopUpAreDisplayd(Constants.AddLicensureText);

		reportLog("2.5: Select 'California' from the 'State/Province' drop down");
		frontPage.selectStateFromDropDown(Constants.californiaState);

		reportLog("2.6: Enter 'ABC123' in the 'License Number' text box");
		frontPage.enterLicenseNo(Constants.LicensureABC123);

		reportLog("2.7: Select 'Add'");
		frontPage.AddLicensureButton();

	    reportLog("2.8: Verify that 'California' is populated under 'State/Province' and 'ABC123' is populated under 'License Number'");
        frontPage.verifyStateAndLicensureIsPopulated(Constants.californiaState,Constants.LicensureABC123);

	    reportLog("3.1: Select the edit button under the 'Action' section");
		frontPage.clickOnEditButton(Constants.californiaState);

	    reportLog("3.2: Verify that 'Update Licensure' pop up is displayed");
		frontPage.verifyPopUpAreDisplayd(Constants.UpdateLicensureText);

	    reportLog("3.3: Select 'Arizona' from the 'State/Province' drop down");
		frontPage.selectStateFromDropDown(Constants.ArizonaState);

	    reportLog("3.4: Enter 'ZZZ456' in the 'License Number' text box");
		frontPage.enterLicenseNo(Constants.LicensureZZZ456);

	    reportLog("3.5: Select 'Update'");
		frontPage.AddLicensureButton();

		reportLog("3.6: Verify that 'California' has been updated to 'Arizona' under 'State/Province' and 'ABC123' has been updated to 'ZZZ456' under 'License Number'");
        frontPage.verifyStateAndLicensureIsPopulated(Constants.ArizonaState,Constants.LicensureZZZ456);

		reportLog("3.7: Delete 'Arizona' by clicking on the 'X'");
		frontPage.clickOnDeleteButton(Constants.ArizonaState);

		reportLog("3.8: Select 'OK' on the pop window");
		frontPage.selectOkOnAlert();

		reportLog("4.1: Select 'X' to close MyVIN");
        switchParentWindowByClosingChild(parentWindow);

        reportLog("5.1: Call Logout method");
		logoutPage = frontPage.logoutApplication();

}
}
