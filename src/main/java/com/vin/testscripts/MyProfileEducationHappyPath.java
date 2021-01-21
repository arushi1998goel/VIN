package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.FrontPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class MyProfileEducationHappyPath extends BaseTest {

	public MyProfileEducationHappyPath() {
		super();
	}
	
	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());

	}
	/**
	 * ====================================================================================================================
	 * Test Case Name: MyProfileEducationHappyPath
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
		reportLog("2.2: Click on 'Education'");
		frontPage.selectProfileFromDropDown(Constants.EducationText);
		
		reportLog("2.3: Select 'Add Education'");
		frontPage.ClickOnButtons(Constants.AddEducationText);

		reportLog("2.4: Verify 'Add Education' pop up window is displayed");
		frontPage.verifyPopUpAreDisplayd(Constants.AddEducationText);

		reportLog("2.5: Enter 'Selenium University' on the 'School' text box");
		frontPage.enterSchoolnameInTextField(Constants.SeleniumUniversity);
		
		reportLog("2.6: Select 'AAS' from the 'Degree' drop down option");
	    frontPage.selectDropDownAndThereValuesInPopupModel(Constants.DegreeEducation,Constants.AASDegree);

		reportLog("2.7: Select 'Jan' from the 'Month' drop down option");
	    frontPage.selectDropDownAndThereValuesInPopupModel(Constants.MonthEducation,Constants.JanMonth);

		reportLog("2.8: Select '2012' from the 'Year' drop down option");
	    frontPage.selectDropDownAndThereValuesInPopupModel(Constants.YearEducation,Constants.Year2012);

		reportLog("2.9: Select 'Add'");
		frontPage.clickOnAddButton();
		
		reportLog("2.10: Verify that 'Selenium University' has been added under 'School'");
		frontPage.verifyEnteredTextIsAdded(Constants.SeleniumUniversity);

		reportLog("3.1: Select the edit button next to 'Selenium University'");
		frontPage.clickOnEditButton(Constants.SeleniumUniversity);

		reportLog("3.2: Verify 'Edit Education' pop up window is displayed");
		frontPage.verifyPopUpAreDisplayd(Constants.UpdateEducation);

		reportLog("3.3: Enter 'Selenium College' on the 'School' text box");
		frontPage.enterSchoolnameInTextField(Constants.SeleniumCollege);

		reportLog("3.4: Select 'BA' from the 'Degree' drop down option");
	    frontPage.selectDropDownAndThereValuesInPopupModel(Constants.DegreeEducation,Constants.BADegree);

		reportLog("3.5: Select 'May' from the 'Month' drop down option");
	    frontPage.selectDropDownAndThereValuesInPopupModel(Constants.MonthEducation,Constants.MayMonth);

		reportLog("3.6: Select '2014' from the 'Year' drop down option");
	    frontPage.selectDropDownAndThereValuesInPopupModel(Constants.YearEducation,Constants.Year2014);

		reportLog("3.7: Select 'Update'");
		frontPage.clickOnAddButton();

		reportLog("3.8: Verify that 'Selenium University' has been updated to 'Selenium College'");
		frontPage.verifyEnteredTextIsAdded(Constants.SeleniumCollege);

		reportLog("4.1: Delete 'Selenium College' by clicking on the red 'X' button");
		frontPage.clickOnDeleteButton(Constants.SeleniumCollege);

		reportLog("4.2: Select 'OK' on the pop up window");
		frontPage.selectOkOnAlert();

		reportLog("4.3: Verify that 'Selenium College' has been deleted.");
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
