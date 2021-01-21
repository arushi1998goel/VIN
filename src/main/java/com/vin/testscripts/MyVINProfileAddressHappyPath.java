package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.FrontPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class MyVINProfileAddressHappyPath extends BaseTest {

	public MyVINProfileAddressHappyPath() {
		super();
	}
	
	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());

	}
	/**
	 * ====================================================================================================================
	 * Test Case Name: MyVINProfileAddressHappyPath
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
		reportLog("2.2: Click on 'Address'");
		frontPage.selectProfileFromDropDown(Constants.adressOption);

		reportLog("2.3: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();
		
		reportLog("2.3: Select 'Add Address'");
		frontPage.ClickOnButtons(Constants.addAdressButton);

		reportLog("2.4: Verify that 'Add Address' pop up window is displayed");
		frontPage.verifyPopUpAreDisplayd(Constants.addAdressButton);

		reportLog("2.5: Select the checkboxes next to 'Work', 'Home', 'Billing', and 'Mailing'");
		frontPage.selectCheckbox(Constants.addressWork);
		frontPage.selectCheckbox(Constants.addressHome);
		frontPage.selectCheckbox(Constants.addressBilling);
		frontPage.selectCheckbox(Constants.addressMailing);

		reportLog("2.6: Enter 'Selenium' in the 'Business Name' text box");
		frontPage.enterAddressInfoIntoInputFields(Constants.addressBusinessField,Constants.seleniumText);
		
		reportLog("2.7: Enter '555 w. vin ave' in the 'Address Line 1' text box");
		frontPage.enterAddressInfoIntoInputFields(Constants.addressLine1Field,Constants.addressLine1Text);
		
		reportLog("2.8: Enter 'Davis' in the 'City' text box");
		frontPage.enterAddressInfoIntoInputFields(Constants.addressCityField ,Constants.addressCityText);

		reportLog("2.9: Select 'California' in the 'State' drop down option");
		frontPage.selectStateFromDropDownInAdress(Constants.stateText);
		
		reportLog("2.10: Enter '95616' in the 'Zip/Postal' text box");
		frontPage.enterAddressInfoIntoInputFields(Constants.addressZipCodeField ,Constants.addressZipText);

		reportLog("2.11: Verify 'USA' is automatically populated in the 'Country' drop down option");
		frontPage.verifyCountryIsSelectedAutomatically(Constants.countryText);
		
		reportLog("2.12: Select 'Add'");
		frontPage.clickOnAddAddressButton();
		
		reportLog("2.13: Verify that 'Selenium' has been added under 'Business Name'");
		frontPage.verifyEnteredTextIsAdded(Constants.seleniumText);

		reportLog("3.1: Select the edit button next to 'Selenium'");
		frontPage.clickOnEditButton(Constants.seleniumText);

		reportLog("3.2: Verify that 'Update Address' pop up window is displayed");
		frontPage.verifyPopUpAreDisplayd(Constants.updateAddress);

		reportLog("3.3: Select the checkboxes next to 'Work', 'Home', 'Billing', and 'Mailing' to remove the checkmarks");
		frontPage.selectCheckbox(Constants.addressWork);
		frontPage.selectCheckbox(Constants.addressHome);
		frontPage.selectCheckbox(Constants.addressBilling);
		frontPage.selectCheckbox(Constants.addressMailing);
		
		reportLog("3.4: Enter 'Selenium4vin' in the 'Business Name' text box");
		frontPage.enterAddressInfoIntoInputFields(Constants.addressBusinessField,Constants.Selenium4vinText);

		reportLog("3.5: Enter '123 s. vin ave' in the 'Address Line 1' text box");
		frontPage.enterAddressInfoIntoInputFields(Constants.addressLine1Field,Constants.addressLine1Text2);
		
		reportLog("3.6: Enter 'Stockton' in the 'City");
		frontPage.enterAddressInfoIntoInputFields(Constants.addressCityField ,Constants.StocktonText);
		
		reportLog("3.7: Select 'California' in the 'State' drop down option");
		frontPage.selectStateFromDropDownInAdress(Constants.stateText);

		reportLog("3.8: Enter '95205' in the 'Zip/Postal' text box");
		frontPage.enterAddressInfoIntoInputFields(Constants.addressZipCodeField ,Constants.addressZipText2);

		reportLog("3.9: Verify 'USA' is automatically populated in the 'Country' drop down option");
		frontPage.verifyCountryIsSelectedAutomatically(Constants.countryText);

	    reportLog("3.10: Select 'Update'");
		frontPage.clickOnAddAddressButton();

		reportLog("3.11: Verify that 'Selenium' has been updated to 'Selenium4vin'");
		frontPage.verifyEnteredTextIsAdded(Constants.Selenium4vinText);

		reportLog("4.1: Delete 'Selenium4vin' by clicking on the red 'X' button");
		frontPage.clickOnDeleteButton(Constants.Selenium4vinText);

		reportLog("4.2: Select 'Ok' on the pop up message box");
		frontPage.selectOkOnAlert();

		reportLog("4.3: Verify that 'Selenium4vin' has been deleted");
		frontPage.verifyCertificationDeleted();

		reportLog("5.1: Select 'Colleagues View'");
		frontPage.ClickOnButtons(Constants.colleaguesViewButton);

		reportLog("5.2: Verify Page refreshes and loads 'Colleagues View' successfully");
		frontPage.verifyPageRefreshesAndLoadsSuccessfully(Constants.colleaguesViewTitle);

		reportLog("5.3: Select Vinners view");
		frontPage.ClickOnButtons(Constants.VINersViewButton);

		reportLog("5.4: Verify Page refreshes and loads 'Vinners View' successfully");
		frontPage.verifyPageRefreshesAndLoadsSuccessfully(Constants.VINersViewTitle);

		reportLog("6.1: Select 'X' to close MyVIN");
        switchParentWindowByClosingChild(parentWindow);

		reportLog("6.2: Call Logout method");
		logoutPage = frontPage.logoutApplication();

}
}