package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.FrontPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class MyVINProfileInterestsHappyPath extends BaseTest {

	public MyVINProfileInterestsHappyPath() {
		super();
	}
	
	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());

	}
	/**
	 * ====================================================================================================================
	 * Test Case Name: MyVINProfileInterestsHappyPath
	 * ====================================================================================================================
	 * 
	 * @throws Exception
	 * 
	 * 
	 */
	
	@Test
	public void verifyMyVINProfileInterestsHappyPath() throws Exception {
		
	
		reportLog("1.1: Navigate to https://www.vin.com/vin/");
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
		reportLog("2.2: Click on 'Interests'");
		frontPage.selectProfileFromDropDown(Constants.InterestsText);
		
		reportLog("2.3: Select 'Anatomy Pathology' under 'Complete List of Interests'");
		frontPage.selectOptionUnderCompleteListofInterests(Constants.AnatomicPathologyText);
		
		reportLog("2.4: Select 'Add'");
		frontPage.selectAddAndRemoveButton(Constants.AddText);
		
		reportLog("2.5: Verify that 'Anatomy Pathology' is now listed under 'Your Interests'");
		frontPage.verifySelectedOptionIsVisibleInYourInterestArea(Constants.AnatomicPathologyText);
		
		reportLog("3.1: Select 'Colleagues View'");
		frontPage.ClickOnButtons(Constants.colleaguesViewButton);

		reportLog("3.2: Verify Page refreshes and loads 'Colleagues View' successfully");
		frontPage.verifyPageRefreshesAndLoadsSuccessfully(Constants.colleaguesViewTitle);

		reportLog("3.3: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();

		reportLog("3.4: Verify that 'Anatomy Pathology' is listed next to 'Interests'");
		frontPage.verifySelectedOptionIsPresentInInterestsArea(Constants.AnatomicPathologyText);
		
		reportLog("3.5: Select Vinners view");
		frontPage.ClickOnButtons(Constants.VINersViewButton);

		reportLog("3.6: Verify Page refreshes and loads 'Vinners View' successfully");
		frontPage.verifyPageRefreshesAndLoadsSuccessfully(Constants.VINersViewTitle);

		reportLog("3.7: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();

		reportLog("3.8: Verify that 'Anatomy Pathology' is listed next to 'Interests'");
		frontPage.verifySelectedOptionIsPresentInInterestsArea(Constants.AnatomicPathologyText);

		reportLog("4.1: Select Profile");
		reportLog("4.2: Click on 'Interests'");
		frontPage.selectProfileFromDropDown(Constants.InterestsText);

		reportLog("4.3: Select 'Anatomy Pathology' under 'Your Interests'");
		frontPage.SelectOptionInYourInterestArea(Constants.AnatomicPathologyText);

		reportLog("4.4: Select 'Remove'");
		frontPage.selectAddAndRemoveButton(Constants.RemoveText);

		reportLog("4.5: Verify that 'Anatomy Pathology' is no longer listed under 'Your Interests'");
		frontPage.verifyRemovedOptionIsNotDisplayedInYourInterestArea(Constants.AnatomicPathologyText);

		reportLog("5.1: Select 'Colleagues View'");
		frontPage.ClickOnButtons(Constants.colleaguesViewButton);

		reportLog("5.2: Verify Page refreshes and loads 'Colleagues View' successfully");
		frontPage.verifyPageRefreshesAndLoadsSuccessfully(Constants.colleaguesViewTitle);

		reportLog("5.3: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();

		reportLog("5.4: Verify that 'Anatomy Pathology' is no longer listed next to 'Interests'");
		frontPage.verifySelectedOptionIsNotPresentInInterestsArea(Constants.AnatomicPathologyText);

		reportLog("5.5: Select Vinners view");
		frontPage.ClickOnButtons(Constants.VINersViewButton);
		
		reportLog("5.6: Verify Page refreshes and loads 'Vinners View' successfully");
		frontPage.verifyPageRefreshesAndLoadsSuccessfully(Constants.VINersViewTitle);

		reportLog("5.7: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();

		reportLog("5.8: Verify that 'Anatomy Pathology' is no longer listed next to 'Interests'");
		frontPage.verifySelectedOptionIsNotPresentInInterestsArea(Constants.AnatomicPathologyText);

		reportLog("6.1: Select 'X' to close MyVIN");
        switchParentWindowByClosingChild(parentWindow);

		reportLog("6.2: Call Logout method");
		logoutPage = frontPage.logoutApplication();

}
}
