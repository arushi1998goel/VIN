package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.FrontPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class MyVINProfileemailAndwebsiteHappyPath extends BaseTest {

	public MyVINProfileemailAndwebsiteHappyPath() {
		super();
	}
	
	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());

	}
	/**
	 * ====================================================================================================================
	 * Test Case Name: MyVINProfileemailAndwebsiteHappyPath
	 * ====================================================================================================================
	 * 
	 * @throws Exception
	 * 
	 * 
	 */
	
	@Test
	public void verifyMyVINProfileemailAndwebsiteHappyPath() throws Exception {
		
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
		reportLog("2.2: Click on Email & Website");
		frontPage.selectProfileFromDropDown(Constants.emailandwebsite);

		reportLog("2.3: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();

		reportLog("2.4: Select 'Add Email'");
		frontPage.ClickOnButtons(Constants.addEmailButton);
		
		reportLog("2.5: Verify that 'Add Email' pop up is displayed");
		frontPage.verifyPopUpAreDisplayd(Constants.addEmailButton);
		
		reportLog("2.6: Enter 'seleniumtester@test.com' in the email text box");
		frontPage.enterEmailInTextBox(Constants.email1);
		
		reportLog("2.7: Select the checkboxes next to 'Work', 'Home', 'Profile'");
		frontPage.selectCheckbox(Constants.workCheckBox);
		frontPage.selectCheckbox(Constants.homeCheckBox);
		frontPage.selectCheckbox(Constants.profileCheckBox);

		reportLog("2.8: Enter Selenium user's password in the 'As an extra security measure, please confirm your VIN password') text box");
		frontPage.enterInputIntoConfirmPassword(UserPswrd);
		
		reportLog("2.9: Select the 'add' button");
		frontPage.selectAddEmailButton();
		
		reportLog("2.10: Verify 'seleniumtester@test.com' has been added to the email list");
		frontPage.verifyEnteredTextIsAdded(Constants.email1);
		
		reportLog("3.1: Select the edit button next to 'seleniumtester@test.com'");
		frontPage.clickOnEditButton(Constants.email1);
		
		reportLog("3.2: Verify the 'Edit email' pop up is displayed");
		frontPage.verifyPopUpAreDisplayd(Constants.updateEmail);

		reportLog("3.3: Enter 'seleniumtester123@test.com' in the email text box");
		frontPage.enterEmailInTextBox(Constants.email2);

		reportLog("3.4: Select the checkboxes next to 'Work', 'Home', 'Profile' to remove the checkmark");
		frontPage.selectCheckbox(Constants.workCheckBox);
		frontPage.selectCheckbox(Constants.homeCheckBox);
		frontPage.selectCheckbox(Constants.profileCheckBox);

		reportLog("3.5: Enter Selenium user's password in the 'As an extra security measure, please confirm your VIN password' text box");
		frontPage.enterInputIntoConfirmPassword(UserPswrd);

		reportLog("3.6: Select the 'Update' button");
		frontPage.selectAddEmailButton();

		reportLog("3.7: Verify that the email address has been updated to 'seleniumtester123@test.com'");
		frontPage.verifyEnteredTextIsAdded(Constants.email2);

		reportLog("4.1: Delete 'seleniumtester123@test.com' by clicking on the red x button");
		frontPage.clickOnDeleteButton(Constants.email2);
		
		reportLog("4.2: Select 'Ok' on the pop up message box");
		frontPage.selectOkOnAlert();
		
		reportLog("4.3: Verify that 'seleniumtester123@test.com' has been deleted");
		frontPage.verifyCertificationDeleted();

		reportLog("5.1: Select 'Add website'");
		frontPage.ClickOnButtons(Constants.addWebsiteButton);

		reportLog("5.2: Verify that 'Add website' pop up is displayed");
		frontPage.verifyPopUpAreDisplayd(Constants.addWebsiteButton);

		reportLog("5.3: Enter 'selenium4vin.com' in the 'website' text box");
		frontPage.enterWebsiteInWebsiteField(Constants.website1);
		
		reportLog("5.4: Select the checkboxes next to 'Work', 'Home', 'Profile'");
		frontPage.selectCheckbox(Constants.workWebsiteCheckBox);
		frontPage.selectCheckbox(Constants.homeWebsiteCheckBox);
		frontPage.selectCheckbox(Constants.profileWebsiteCheckBox);
		
		reportLog("5.5: Select the 'add' button");
		frontPage.selectAddWebsiteButton();
		
		reportLog("5.6: Verify 'selenium4vin.com' has been added under 'Website URL'");
		frontPage.verifyEnteredTextIsAdded(Constants.website1);

		reportLog("6.1: Select the edit button next to 'selenium4vin.com'");
		frontPage.clickOnEditButton(Constants.website1);

		reportLog("6.2: Verify the 'Edit website' pop up is displayed");
		frontPage.verifyPopUpAreDisplayd(Constants.updateWebsite);

		reportLog("6.3: Enter 'seleniumscripts4vin.com' in the 'Website' text box");
		frontPage.enterWebsiteInWebsiteField(Constants.website2);

		reportLog("6.4: Select the checkboxes next to 'Work', 'Home', 'Profile' to remove the checkmark");
		frontPage.selectCheckbox(Constants.workWebsiteCheckBox);
		frontPage.selectCheckbox(Constants.homeWebsiteCheckBox);
		frontPage.selectCheckbox(Constants.profileWebsiteCheckBox);
		
		reportLog("6.5: Select the 'Update' button");
		frontPage.selectAddWebsiteButton();

		reportLog("6.7: Verify the website has been updated to 'seleniumscripts4vin.com'");
		frontPage.verifyEnteredTextIsAdded(Constants.website2);

		reportLog("7.1: Delete 'seleniumscripts4vin.com' by clicking on the red x button");
		frontPage.clickOnDeleteButton(Constants.website2);

		reportLog("7.2: Select 'Ok' on the pop up message box");
		frontPage.selectOkOnAlert();

		reportLog("7.3: Verify that 'seleniumscripts4vin.com' has been deleted");
		frontPage.verifyCertificationDeleted();

		reportLog("8.1: Select 'Colleagues View'");
		frontPage.ClickOnButtons(Constants.colleaguesViewButton);

		reportLog("8.2: Verify Page refreshes and loads 'Colleagues View' successfully");
		frontPage.verifyPageRefreshesAndLoadsSuccessfully(Constants.colleaguesViewTitle);
		
		reportLog("8.3: Select Vinners view");
		frontPage.ClickOnButtons(Constants.VINersViewButton);

		reportLog("8.4: Verify Page refreshes and loads 'Vinners View' successfully");
		frontPage.verifyPageRefreshesAndLoadsSuccessfully(Constants.VINersViewTitle);

		reportLog("9.1: Select 'X' to close MyVIN");
        switchParentWindowByClosingChild(parentWindow);

		reportLog("9.2: Call Logout method");
		logoutPage = frontPage.logoutApplication();

	}

}
