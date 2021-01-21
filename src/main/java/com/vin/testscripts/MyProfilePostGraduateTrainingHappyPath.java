package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.FrontPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class MyProfilePostGraduateTrainingHappyPath extends BaseTest {

	public MyProfilePostGraduateTrainingHappyPath() {
		super();
	}
	
	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());

	}
	/**
	 * ====================================================================================================================
	 * Test Case Name: MyProfilePostGraduateTrainingHappyPath
	 * ====================================================================================================================
	 * 
	 * @throws Exception
	 * 
	 * 
	 */
	
	@Test
	public void verifyMyProfilePostGraduateTrainingHappyPath() throws Exception {
		
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
		reportLog("2.2: Click 'Post Graduate Training'");
		frontPage.selectProfileFromDropDown(Constants.PostGraduateTrainingText);
		
		reportLog("2.3: Select 'Add Internship'");
		frontPage.ClickOnButtons(Constants.AddInternshipText);

		reportLog("2.4: Verify 'Add Internship' pop up window is displayed");
		frontPage.verifyPopUpAreDisplayd(Constants.AddInternshipText);

		reportLog("2.5: Select 'Argentina' in the 'Country' drop down option");
	    frontPage.selectDropDownAndThereValuesInPopupModel(Constants.AddIntershipCountry,Constants.ArgentinaCountry);

		reportLog("2.6: Select 'Aquatic' in the 'Subject' drop down option");
	    frontPage.selectDropDownAndThereValuesInPopupModel(Constants.AddIntershipSubject,Constants.AquaticSuject);

		reportLog("2.7: Enter 'Selenium College' on the 'School/Organization/Institution' text box");
		frontPage.enterSchoolOrganizationInstitutionInTextField(Constants.SeleniumCollege);
		
		reportLog("2.8: Select 'Jan' and '2012' on the drop down options under 'Completion (Month/Year)'");
	    frontPage.selectDropDownAndThereValuesInPopupModel(Constants.AddIntershipMonth,Constants.JanMonth);
	    frontPage.selectDropDownAndThereValuesInPopupModel(Constants.AddIntershipYear,Constants.Year2012);

		reportLog("2.9: Select 'Add'");
		frontPage.clickOnAddInternshipButton();
		
		reportLog("2.10: Verify 'Selenium College' has been added under 'School/Organization/Institution'");
		frontPage.verifyEnteredTextIsAdded(Constants.SeleniumCollege);

		reportLog("3.1: Select the edit button next to 'Selenium College'");
		frontPage.clickOnEditButton(Constants.SeleniumCollege);

		reportLog("3.2: Verify 'Update Institution' pop up window is displayed");
		frontPage.verifyPopUpAreDisplayd(Constants.UpdateInternship);

		reportLog("3.3: Select 'Austria' in the 'Country' drop down option");
	    frontPage.selectDropDownAndThereValuesInPopupModel(Constants.AddIntershipCountry,Constants.AustriaCountry);

		reportLog("3.4: Select 'Animal Welfare/Laws' in the 'Subject' drop down option");
	    frontPage.selectDropDownAndThereValuesInPopupModel(Constants.AddIntershipSubject,Constants.AnimalSubject);

		reportLog("3.5: Enter 'Selenium University' on the 'School/Organization/Institution' text box");
		frontPage.enterSchoolOrganizationInstitutionInTextField(Constants.SeleniumUniversity);

		reportLog("3.6: Select 'May' and '2014' on the drop down options under 'Completion (Month/Year)'");
		frontPage.selectDropDownAndThereValuesInPopupModel(Constants.AddIntershipMonth,Constants.MayMonth);
	    frontPage.selectDropDownAndThereValuesInPopupModel(Constants.AddIntershipYear,Constants.Year2014);

		reportLog("3.7: Select 'Update'");
		frontPage.clickOnAddInternshipButton();

		reportLog("3.8: Verify 'Selenium College' has been updated to 'Selenium University'");
		frontPage.verifyEnteredTextIsAdded(Constants.SeleniumUniversity);
		
		reportLog("4.1: Delete 'Selenium College' by clicking on the red 'X'");
		frontPage.clickOnDeleteButton(Constants.SeleniumUniversity);

		reportLog("4.2: Select 'OK' on the pop up window");
		frontPage.selectOkOnAlert();

		reportLog("5.1: Select 'Add Residency'");
		frontPage.ClickOnButtons(Constants.AddResidencyText);

		reportLog("5.2: Verify 'Add Residency' pop up window is displayed");
		frontPage.verifyPopUpAreDisplayd(Constants.AddResidencyText);

		reportLog("5.3: Select 'Algeria' in the 'Country' drop down option");
	    frontPage.selectDropDownAndThereValuesInPopupModel(Constants.AddIntershipCountry,Constants.AlgeriaCountry);

		reportLog("5.4: Select 'Animal Control' in the 'Subject' drop down option");
	    frontPage.selectDropDownAndThereValuesInPopupModel(Constants.AddIntershipSubject,Constants.AnimalSubject);

		reportLog("5.5: Enter 'Selenium Residency' on the 'School/Organization/Institution' text box");
		frontPage.enterSchoolOrganizationInstitutionInTextField(Constants.SeleniumResidency);

		reportLog("5.6: Select 'Mar' and '2010' on the drop down options under 'Completion (Month/Year)'");
		frontPage.selectDropDownAndThereValuesInPopupModel(Constants.AddIntershipMonth,Constants.MonthMar);
	    frontPage.selectDropDownAndThereValuesInPopupModel(Constants.AddIntershipYear,Constants.Year2010);

		reportLog("5.7: Select 'Add'");
		frontPage.clickOnAddInternshipButton();

		reportLog("5.8: Verify 'Selenium Residency' has been added under 'School/Organization/Institution'");
		frontPage.verifyEnteredTextIsAdded(Constants.SeleniumResidency);

		reportLog("6.1: Select the edit button next to 'Selenium Residency'");
		frontPage.clickOnEditButton(Constants.SeleniumResidency);

		reportLog("6.2: Verify 'Update Residency' pop up window is displayed");
		frontPage.verifyPopUpAreDisplayd(Constants.UpdateResidency);

		reportLog("6.3: Select 'Armenia' in the 'Country' drop down option");
	    frontPage.selectDropDownAndThereValuesInPopupModel(Constants.AddIntershipCountry,Constants.ArmeniaCountry);

		reportLog("6.4: Select 'Behavior' in the 'Subject' drop down option");
	    frontPage.selectDropDownAndThereValuesInPopupModel(Constants.AddIntershipSubject,Constants.BehaviorSubject);

		reportLog("6.5: Enter 'VIN Residency' on the 'School/Organization/Institution' text box");
		frontPage.enterSchoolOrganizationInstitutionInTextField(Constants.VINResidency);

		reportLog("6.6: Select 'July' and '2012' on the drop down options under 'Completion (Month/Year)'");
		frontPage.selectDropDownAndThereValuesInPopupModel(Constants.AddIntershipMonth,Constants.JulyMonth);
	    frontPage.selectDropDownAndThereValuesInPopupModel(Constants.AddIntershipYear,Constants.Year2012);

		reportLog("6.7: Select 'Update'");
		frontPage.clickOnAddInternshipButton();

		reportLog("6.8: Verify 'Selenium Residency' has been updated to 'VIN Residency'");
		frontPage.verifyEnteredTextIsAdded(Constants.VINResidency);

		reportLog("7.1: Delete 'VIN Residency' by clicking on the 'X'");
		frontPage.clickOnDeleteButton(Constants.JulyMonth);

		reportLog("7.2: Select 'OK' on the pop window");
		frontPage.selectOkOnAlert();

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