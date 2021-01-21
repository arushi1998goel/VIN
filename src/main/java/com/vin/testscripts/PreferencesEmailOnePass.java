package com.vin.testscripts;

import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.FrontPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class PreferencesEmailOnePass extends BaseTest {

	private String parentwin, parentWindow,myVinWindow, preferenceWindow;
    private List<String> multipleWindows;

	public PreferencesEmailOnePass() {
		super();
	}
	
	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());

	}
	/**
	 * ====================================================================================================================
	 * Test Case Name: PreferencesEmailOnePass
	 * ====================================================================================================================
	 * 
	 * @throws Exception
	 * 
	 * 
	 */
	
	@Test
	public void verifyPreferencesEmailOnePass() throws Exception {

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
		
		reportLog("2.4: Select Email");
		frontPage.selectfromPreferencesdropdown(Constants.EmailText);
		
		reportLog("2.5: Dismiss Alert Notifications if displayed by clicking on 'X' on the Alert Notification");
		frontPage.dismissNotifications();
		
		reportLog("2.6: Select the 'Edit Preferences' button");
		frontPage.selectEditPreferenceButton();
		frontPage.switchToNewWindow();
        
		reportLog("2.7: Verify the 'Update your preferences' pop up window is displayed");
		multipleWindows = getAllWindowsOpenInUI();
		parentWindow = multipleWindows.get(0);
		myVinWindow = multipleWindows.get(1);
		preferenceWindow = multipleWindows.get(2);
		
		switchToWindow(parentWindow);                     
		switchToWindow(myVinWindow);                
		switchToWindow(preferenceWindow);  
		
		switchToWindowWithBrowser(preferenceWindow);    
		
		
		frontPage.verifyUpdatePreferenceWindowIsDisplayed();
		
		
		reportLog("2.8: Close the 'Update your preferences' pop window by clicking on the 'X' on the window");
		frontPage.switchChildWindowByClosingParent(myVinWindow);                                   

		reportLog("2.9: Dismiss the 'Email Preference Reminder' pop up by clicking on the 'X' on the window");
		frontPage.clickOnCrossIconAndDissmissReminder();
		
		reportLog("2.10: Select 'X' to close MyVIN");
		frontPage.switchChildWindowByClosingParent( parentWindow);                                   

		reportLog("3.1: Call Logout method");
		logoutPage=frontPage.logoutApplication();
	    logoutPage.verifyLogoutPageDisplayed();
}
}
