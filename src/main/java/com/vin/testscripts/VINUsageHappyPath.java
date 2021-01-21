package com.vin.testscripts;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.vin.pages.FrontPage;
import com.vin.pages.LoginPage;
import com.vin.pages.VIN_UsagePage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class VINUsageHappyPath extends BaseTest {

	private String SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName, parentWin;

	public VINUsageHappyPath() {
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
	 * Test Case Name: VIN_UsageHappyPath
	 * ====================================================================================================================
	 * 
	 * @throws Exception

	 */

	@Test
	public void vinUsage() throws Exception {
		reportLog("1.1: go to https://beta.vin.com");
		reportLog("1.2: verify VIN Promo page is loaded ");
		promoPage.verifyPromoPage();

		reportLog("1.3: Call Login method");
		loginPage = promoPage.clickOnLoginButton();
		loginPage.verifyUserLoginPage();
        securityQuestionPage = loginPage.loginInApplication(UserID, UserPswrd);


		reportLog("1.4: Verify Security Question Page displayed");
		securityQuestionPage.verifySecurityQuestionPageDisplayed();

		reportLog("1.5: Enter Security Answer and Login if Security Question Page displayed");
		frontPage = securityQuestionPage.enterSecurityAnswerAndLogin(FrontPage.class,SecurityAnswerSecoreIDNumber,
				SecurityAnswerMothersMaidenName);

		reportLog("2.1: Verify Front Page displayed");
		frontPage.verifyFrontPageDisplayed();
		String mainWindow=frontPage.getDriver().getWindowHandle();


		reportLog("2:2: if alert notification displayed Dismiss Notification");
		frontPage.dismissNotifications();

		reportLog("3.1:  Navigate to Account Info and User should see account info menu > VIN Usage");
       vinUsage = frontPage.verifyVinUsageDisplayed();

		reportLog("3.2: Click VIN Usage");
		vinUsage.selectVinUsageFromAccountInfo();
		vinUsage.switchToNewWindow();

		reportLog("4:1: Verify VIN Usage page loaded in new pop up window");
		vinUsage.verifyPopWindowForVinUsage(Constants.VinUSage_Beta);
		
		reportLog("5.1: Click on Start Date");
		vinUsage.clickOnStartDate();
		
		reportLog("5.2: Pick previous month in month drop down in start date");
		vinUsage.pickPreviousMonth();
		
		reportLog("5.3: Verify popup message Please select a day to complete your date");
		vinUsage.verifyErrorMessageOnStartDateTextBox();
		
		reportLog("5.3: Click 1st day of selected month in calendar in start date");
		vinUsage.selectFirstDateOfSelectedMonth();
		
		reportLog("5.4: Verify start date has selected date");
		vinUsage.verifyStartDateHasSelectedDate();
		
		reportLog("5.5: Click on end date");
		vinUsage.clickOnEndDate();
		
		reportLog("5:6: Pick previous month in month drop down in end date");
		vinUsage.pickPreviousMonth();
		
		reportLog("5:7: Verify popup message Please select a day to complete your date");
		vinUsage.verifyErrorMessageOnEndDateTextBox();
		
		reportLog("5.8: Click last day of selected month in calendar in end date");
		vinUsage.clickLastDateOfSelectedMonth();

		reportLog("5:9: Click Calculate Button");
		vinUsage.clickCalculateButton();
		
		reportLog("6:1: Verify VIN Usage is calculated with message; 'You've used VIN a total of..¦' ;");
		vinUsage.verifyCalculatedMessage();
		
		reportLog("7:1: Click on Generate PDF");
		vinUsage.clickGeneratePdfButton();
		
		reportLog("7:2: PDF is generated and downloaded automatically into downloads");
		vinUsage.verifyDownloadedPdfFile(Constants.File_Name, Constants.FileType_PDF);
		
		reportLog("8:1: Click on Export to MyCE button");
		vinUsage.clickExportMyCEButton();
		
		reportLog("8.2: Verify message: 'Your Time on VIN was successfully exported to MyCE'");
		vinUsage.verifyExportMyCEMessage(Constants.ExportToMyCEText);
		
		reportLog("9.1: Click Reset");
		vinUsage.clickOnResetButton();
		
		reportLog("9.2: Verify User is able to select button; date fields clear and Generate and Export buttons are unavailable");
		vinUsage.verifyDateFieldsAreEmpty();
		vinUsage.verifyGenerateAndExportButtonsUnAvailable();
		vinUsage.getDriver().close();
		vinUsage.getDriver().switchTo().window(mainWindow);
		
		
		reportLog("10.1: Call Logout method");
		logoutPage = frontPage.logoutApplication();

	    reportLog("10.2: Verify Logout Page displayed");
	    logoutPage.verifyLogoutPageDisplayed();

	}
}
		


		


	

