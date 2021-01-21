package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.IsleHappyPathPage;
import com.vin.pages.LoginPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class IsleHappyPath extends BaseTest {
	
	private String SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName;
	

	public IsleHappyPath() {
		super();
	}

	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());

		SecurityAnswerSecoreIDNumber = RegressionTestData.getProperty("SecurityAnswerSecoreIDNumber");
		SecurityAnswerMothersMaidenName = RegressionTestData.getProperty("SecurityAnswerMothersMaidenName");

	}
	
	
	/**
	 * ====================================================================================================================
	 * Test Case Name: ISLE Happy path
	 * ====================================================================================================================
	 * 
	 * @throws Exception
	 */

	@Test

	public void isleHappyPath() throws Exception {

		reportLog("1.1: Navigate to In School Loan Estimator https://beta.vin.com/studentdebtcenter/default.aspx?pId=14352&id=8696383");
		loginPage = promoPage.verifyPromoPageForLogin(LoginPage.class);
        securityQuestionPage = loginPage.loginForIsleHappyPath(UserID, UserPswrd);
        securityQuestionPage.verifySecurityQuestionPageDisplayed();
        islehappypathpage = securityQuestionPage.enterSecurityAnswerAndLogin(
				IsleHappyPathPage.class, SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName);

        reportLog("1.2: Dismiss Alert Notifications if displayed");
        islehappypathpage.dismissNotifications();
		
		reportLog("1.3: Verify In School Loan Estimator page is displayed");
		islehappypathpage.verifyStudentLoanSimPage(Constants.StudentDebtCentre);

		reportLog("1.4: Select 'Auburn University College of Veterinary Medicine' from the drop down option under Veterinary Program");
		islehappypathpage.selectAuburnUniversityFromDropDown();
		
		reportLog("2.1: Select 'Resident' radio button");
		islehappypathpage.selectResidentRadioButton();
		
		reportLog("3.1: Select any future date under 'Veterinary Program Start Date'");
		islehappypathpage.selectAnyFutureDate();
		
		reportLog("3.2: Verify user can select date");
		islehappypathpage.verifyUserCanSelectDate();
		 
	    reportLog("4.1: Verify 'Graduation date' populated automatically");
		islehappypathpage.verifyGraduationDateFilledAutomatically();
		 
		reportLog("5.1: Select 'Click to fill in estimates based in School data above'");
		islehappypathpage.clickOnFillInEstimatesButton();
		 
		reportLog("5.1: Verify data is automatically populated in the table below");
		islehappypathpage.verifyEstimatesValuesInTable(Constants.Estimates);
		 
		reportLog("6.1: Select 'Generate Loan Details'");
		islehappypathpage.selectgenerateLoanDetailsButton();
		 
		reportLog("6.2: Verify loan details were loaded");
		islehappypathpage.verifyLoanDetailsAreLoaded();

        reportLog("7.3: Select 'Reset'");
       	islehappypathpage.resetButtonClick();
       	
       	reportLog("8.1: 'Reset Options' pop up window is displayed");
       	islehappypathpage.verifyResetOptionPopupDisplayed();
       	
       	reportLog("8.2: Select 'Reset everything'");
       	islehappypathpage.clickResetEverything();
       	
       	reportLog("8.3: Dismiss Alert Notifications if displayed");
       	islehappypathpage.dismissNotifications();
       	
       	reportLog("9.1: Close In School Loan Estimator page");
       	islehappypathpage.closeDriver();
	}



}
