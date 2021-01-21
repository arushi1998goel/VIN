package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.FrontPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class MyVINProfilePhoneAndFaxHappyPath extends BaseTest {

	public MyVINProfilePhoneAndFaxHappyPath() {
		super();
	}
	
	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());

	}
	/**
	 * ====================================================================================================================
	 * Test Case Name: MyVINProfilePhoneAndFaxHappyPath
	 * ====================================================================================================================
	 * 
	 * @throws Exception
	 * 
	 * 
	 */
	
	@Test
	public void verifyMyVINProfilePhoneAndFaxHappyPath() throws Exception {
		
	
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
		reportLog("2.2: Click on Phone & Fax");
		frontPage.selectProfileFromDropDown(Constants.phoneandFax);

		reportLog("2.3: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();

		reportLog("2.4: Select 'Add Phone'");
		frontPage.ClickOnButtons(Constants.AddPhoneText);
		
		reportLog("2.5: Verify that 'Add Phone' pop up is displayed");
		frontPage.verifyPopUpAreDisplayd(Constants.AddPhoneText);

		reportLog("2.6: Enter '5305550123' in the phone text box");
		frontPage.enterPhoneNoUnderPhoneTextField(Constants.AddPhoneNo1);
		
		reportLog("2.7: Select the checkboxes next to 'Work', 'Home', 'Mobile', and 'Profile'");
		frontPage.selectCheckbox(Constants.workCheckPhoneBox);
		frontPage.selectCheckbox(Constants.homeCheckPhoneBox);
		frontPage.selectCheckbox(Constants.mobileCheckPhoneBox);
		frontPage.selectCheckbox(Constants.profileCheckPhoneBox);

		reportLog("2.8: Select the 'add' button");
		frontPage.selectPhoneNoAddButton();
		
		reportLog("2.9: Verify '5305550123' has been added to the Phone list");
		frontPage.verifyEnteredTextIsAdded(Constants.AddedPhoneNo1);

		reportLog("3.1: Select the edit button next to '5305550123'");
		frontPage.clickOnEditButton(Constants.AddedPhoneNo1);

		reportLog("3.2: Verify the 'Edit phone' pop up is displayed");
		frontPage.verifyPopUpAreDisplayd(Constants.updatePhone);

		reportLog("3.3: Enter '2095554567' in the phone text box");
		frontPage.enterPhoneNoUnderPhoneTextField(Constants.AddPhoneNo2);

		reportLog("3.4: Select the checkboxes next to 'Work', 'Home', 'Mobile' 'Profile' to remove the checkmark");
		frontPage.selectCheckbox(Constants.workCheckPhoneBox);
		frontPage.selectCheckbox(Constants.homeCheckPhoneBox);
		frontPage.selectCheckbox(Constants.mobileCheckPhoneBox);
		frontPage.selectCheckbox(Constants.profileCheckPhoneBox);
		
		reportLog("3.5: Select the 'Update' button");
		frontPage.selectPhoneNoAddButton();

		reportLog("3.6: Verify that the phone number has been updated to '2095554567'");
		frontPage.verifyEnteredTextIsAdded(Constants.AddedPhoneNo2);

		reportLog("4.1: Delete '2095554567' by clicking on the red x button");
		frontPage.clickOnDeleteButton(Constants.AddedPhoneNo2);

		reportLog("4.2: Select 'Ok' on the pop up message box");
		frontPage.selectOkOnAlert();

		reportLog("4.3: Verify that '2095554567' has been deleted");
		frontPage.verifyCertificationDeleted();

		reportLog("5.1: Select 'Add Fax'");
		frontPage.ClickOnButtons(Constants.AddFaxText);

		reportLog("5.2: Verify that 'Add Fax' pop up is displayed");
		frontPage.verifyPopUpAreDisplayd(Constants.AddFaxText);

		reportLog("5.3: Enter '2095550012' in the 'Fax' text box");
		frontPage.enterNoInFaxTextField(Constants.FaxNo1);
		
		reportLog("5.4: Select the checkboxes next to 'Work', 'Home', 'Mobile', 'Profile'");
		frontPage.selectCheckbox(Constants.workCheckFaxBox);
		frontPage.selectCheckbox(Constants.homeCheckFaxBox);
		frontPage.selectCheckbox(Constants.mobileCheckFaxeBox);
		frontPage.selectCheckbox(Constants.profileCheckFaxBox);
		
		reportLog("5.5: Select the 'add' button");
		frontPage.selectAddFaxButton();
		
		reportLog("5.6: Verify '2095550012' has been added under 'Fax'");
		frontPage.verifyEnteredTextIsAdded(Constants.adedFaxNo1);

		reportLog("6.1: Select the edit button next to '2095550012'");
		frontPage.clickOnEditButton(Constants.adedFaxNo1);

		reportLog("6.2: Verify the 'Edit Fax' pop up is displayed");
		frontPage.verifyPopUpAreDisplayd(Constants.updateFax);

		reportLog("6.3: Enter '5305550023' in the 'Fax' text box");
		frontPage.enterNoInFaxTextField(Constants.FaxNo2);
		
		reportLog("6.4: Select the checkboxes next to 'Work', 'Home', 'Mobile', 'Profile' to remove the checkmark");
		frontPage.selectCheckbox(Constants.workCheckFaxBox);
		frontPage.selectCheckbox(Constants.homeCheckFaxBox);
		frontPage.selectCheckbox(Constants.mobileCheckFaxeBox);
		frontPage.selectCheckbox(Constants.profileCheckFaxBox);
		
		reportLog("6.5: Select the 'Update' button");
		frontPage.selectAddFaxButton();

		reportLog("6.6: Verify the Fax number has been updated to '5305550023'");
		frontPage.verifyEnteredTextIsAdded(Constants.adedFaxNo2);

		reportLog("7.1: Delete '5305550023' by clicking on the red x button");
		frontPage.clickOnDeleteButton(Constants.adedFaxNo2);

		reportLog("7.2: Select 'Ok' on the pop up message box");
		frontPage.selectOkOnAlert();

		reportLog("7.3: Verify that '5305550023' has been deleted");
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
