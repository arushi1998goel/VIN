package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.FrontPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class MyVINProfileCertificationsAndHonorsHappyPath extends BaseTest {

	public MyVINProfileCertificationsAndHonorsHappyPath() {
		super();
	}
	
	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());

	}
	/**
	 * ====================================================================================================================
	 * Test Case Name: MyVINProfileCertificationsAndHonorsHappyPath
	 * ====================================================================================================================
	 * 
	 * @throws Exception
	 * 
	 * 
	 */
	
	@Test
	public void verifyMyVINProfileCertificationsAndHonorsHappyPath() throws Exception {
		
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
		reportLog("2.2: Click on 'Certifications & Honors'");
		frontPage.selectProfileFromDropDown(Constants.CertificationsAndHonorsText);

		reportLog("2.3: Select 'Add Certification'");
		frontPage.ClickOnButtons(Constants.AddCertificationText);
		
		reportLog("2.4: Verify 'Add Certification' pop up window is displayed");
		frontPage.verifyPopUpAreDisplayd(Constants.AddCertificationText);

		reportLog("2.5: Select 'AABP' from the 'Board' drop down option");
		frontPage.selectDropDownAndThereValuesInPopupModel(Constants.CertificationBoardInputID,Constants.AABPText);
		
		reportLog("2.6: Verify that 'Subject' drop down is automatically greyed out and displays 'Not Required'");
		frontPage.verifySubjectDropDownIsGreyedOutAutomaticallyInCertificationPopUp(Constants.notRequiredText);
		
		reportLog("2.7: Select 'Jan' from the 'Month' drop down option");
		frontPage.selectDropDownAndThereValuesInPopupModel(Constants.CertificationMonthInputID,Constants.JanMonth);

		reportLog("2.8: Select '2016' from the 'Year' drop down option");
		frontPage.selectDropDownAndThereValuesInPopupModel(Constants.CertificationYearInputID,Constants.Year2016);

		reportLog("2.9: Select 'Add'");
		frontPage.clickOnAddCertification();

		reportLog("3.1: Verify that 'AABP' has been added under 'Board'");
		frontPage.verifyEnteredTextIsAdded(Constants.AABPText);

		reportLog("3.2: Select the edit button next to 'AABP'");
		frontPage.clickOnEditButton(Constants.AABPText);

		reportLog("3.3: Verify 'Update Certification' pop up window is displayed");
		frontPage.verifyPopUpAreDisplayd(Constants.UpdateCertification);

		reportLog("3.4: Select 'ACAW' from the 'Board' drop down option");
		frontPage.selectDropDownAndThereValuesInPopupModel(Constants.CertificationBoardInputID,Constants.ACAWText);

		reportLog("3.5: Verify that 'Subject' drop down is automatically populated and displays 'Animal Welfare Science, Ethics and Law'");
		frontPage.verifySubjectDropDownIsGreyedOutAutomaticallyInCertificationPopUp(Constants.AnimalWelfareText);

		reportLog("3.6: Select 'Apr' from the 'Month' drop down option");
		frontPage.selectDropDownAndThereValuesInPopupModel(Constants.CertificationMonthInputID,Constants.AprMonth);

		reportLog("3.7: Select '2018' from the 'Year' drop down option");
		frontPage.selectDropDownAndThereValuesInPopupModel(Constants.CertificationYearInputID,Constants.Year2018);

		reportLog("3.8: Select 'Update'");
		frontPage.clickOnAddCertification();

		reportLog("3.9: Verify that 'AABP' has been updated to 'ACAW' under 'Board'");
		frontPage.verifyEnteredTextIsAdded(Constants.ACAWText);
		
		reportLog("4.1: Delete 'ACAW' by clicking on the red 'X'");
		frontPage.clickOnDeleteButton(Constants.ACAWText);

		reportLog("4.2: Select 'Ok' on the pop up message box");
		frontPage.selectOkOnAlert();
		
		reportLog("5.1: Select 'Add Honor'");
		frontPage.ClickOnButtons(Constants.AddHonorText);

		reportLog("5.2: Verify 'Add Honor' pop up window is displayed");
		frontPage.verifyPopUpAreDisplayd(Constants.AddHonorText);
		
		reportLog("5.3: Select 'AAAS' from the 'Board' drop down option");
		frontPage.selectDropDownAndThereValuesInPopupModel(Constants.HonorBoardInputID,Constants.AAASText);

		reportLog("5.4: Verify that 'Subject' drop down is automatically populated and displays 'Science and Technology Fellow'");
		frontPage.verifySubjectDropDownIsGreyedOutAutomaticallyInHonorPopUp(Constants.ScienceandTechnologyText);
		
		reportLog("5.5: Select 'Jan' from the 'Month' drop down option");
		frontPage.selectDropDownAndThereValuesInPopupModel(Constants.HonorMonthInputID,Constants.JanMonth);
		
		reportLog("5.6: Select '2015' from the 'Year' drop down option");
		frontPage.selectDropDownAndThereValuesInPopupModel(Constants.HonorYearInputID,Constants.Year2015);

		reportLog("5.7: Select 'Add'");
		frontPage.clickOnAddButtonOnForAddHonor();
		
		reportLog("5.8: Verify that 'AAAS' has been added under 'Board'");
		frontPage.verifyEnteredTextIsAdded(Constants.AAASText);

		reportLog("6.1: Select the edit button next to 'AAAS'");
		frontPage.clickOnEditButton(Constants.AAASText);

		reportLog("6.2: Verify 'Edit Honor' pop up window is displayed");
		frontPage.verifyPopUpAreDisplayd(Constants.UpdateHonorText);

		reportLog("6.3: Select 'AHG' from the 'Board' drop down option");
		frontPage.selectDropDownAndThereValuesInPopupModel(Constants.HonorBoardInputID,Constants.AHGText);

		reportLog("6.4: Verify that 'Subject' drop down is automatically populated and displays 'Herbal Medicine'");
		frontPage.verifySubjectDropDownIsGreyedOutAutomaticallyInHonorPopUp(Constants.HerbalMedicineText);
		
		reportLog("6.5: Select 'July' from the 'Month' drop down option");
		frontPage.selectDropDownAndThereValuesInPopupModel(Constants.HonorMonthInputID,Constants.JulyMonth);

		reportLog("6.6: Select '2019' from the 'Year' drop down option");
		frontPage.selectDropDownAndThereValuesInPopupModel(Constants.HonorYearInputID,Constants.Year2019);

		reportLog("6.7: Select 'Update'");
		frontPage.clickOnAddButtonOnForAddHonor();

		reportLog("6.8: Verify that 'AAAS' has been updated to 'AHG' under 'Board'");
		frontPage.verifyEnteredTextIsAdded(Constants.AHGText);

		reportLog("7.1: Delete 'AHG' by clicking on the red 'X'");
		frontPage.clickOnDeleteButton(Constants.AHGText);
		frontPage.selectOkOnAlert();

		reportLog("7.2: Verify that 'AHG' has been deleted");
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
