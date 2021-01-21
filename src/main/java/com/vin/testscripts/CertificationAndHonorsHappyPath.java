package com.vin.testscripts;

import java.awt.AWTException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.FrontPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class CertificationAndHonorsHappyPath extends BaseTest {

	private String SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName;

	public CertificationAndHonorsHappyPath() {
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
	 * Test Case Name: CertificationAndHonorsHappyPath
	 * ====================================================================================================================
	 * @throws InterruptedException 
	 * @throws AWTException 
	 * 
	 * @throws Exception
	 * 
	 * @throws ParseException
	 * 
	 */

	
	@Test
	public void verifyCertificationAndHonorsHappyPath() throws InterruptedException, AWTException {
		
		reportLog("1.1: Bringing up VIN page");
		promoPage.verifyPromoPage();
		
		reportLog("2.1: Select the LOGIN button");
		loginPage = promoPage.clickOnLoginButton();

		reportLog("2.2: Verify login page is displayed (Title: Login)");
		loginPage.verifyUserLoginPage();

		reportLog("2.3: Log in to the Portal ");
		securityQuestionPage = loginPage.loginInApplication(UserID, UserPswrd);

		reportLog("2.4: Verify Security Question Page displayed (Title: VIN – Security Question)");
		securityQuestionPage.verifySecurityQuestionPageDisplayed();

		reportLog("2.5: Enter Security Answer and Login if Security Question Page displayed");
		frontPage = securityQuestionPage.enterSecurityAnswerAndLogin(FrontPage.class, SecurityAnswerSecoreIDNumber,
				SecurityAnswerMothersMaidenName);
		
		reportLog("2.6: verify front page is displayed");
		frontPage.verifyFrontPageDisplayed();
		String mainWindow=frontPage.getDriver().getWindowHandle();
		
		reportLog("3.1: Dismiss alert pop up");
		frontPage.dismissNotifications();
		
		reportLog("4.1: Open MyVIN by clicking on MyVIN tab on the top of navigation bar");
		frontPage.clickOnMyVINTab();
		frontPage.switchToNewWindow();
		
		reportLog("4.2: MyStuff page opens up in new window");
		frontPage.verifyMyStuffInNewWindow();
		
		reportLog("5.1:Dismiss alert pop up");
		frontPage.dismissNotifications();
		
		reportLog("6.1: Click on  Profile by clicking on  profile and click on certification & honors");
		frontPage.clickOnProfile();
		frontPage.clickOnCertificationAndHonors();
		
		reportLog("6.2: certification & honors page loads");
		frontPage.certificateHonorsPageLoaded(Constants.certificationText);
		
		reportLog("7.1: Dismiss alert pop up");
		frontPage.dismissNotifications();
		
		reportLog("8.1: Click on Add Certification");
		frontPage.ClickOnButtons(Constants.AddCertificationText);
		
		reportLog("8.2: Add Certification window pops up");
		frontPage.verifyAddCertificationPopup();
		
		reportLog("9.1: Select ACVIM  board from board list");
		frontPage.selectACVIMBoard();
		
		reportLog("9.2: Selection was successful");
		frontPage.verifySuccessfullSelection(Constants.ACVIMText);
		
		reportLog("10.1: From Month field drop down select month April");
		frontPage.selectAprilMonth();
		
		reportLog("10.2: Month set to April value");
		frontPage.verifyAprilMonthSelection(Constants.AprilText);
		
		reportLog("11.1: Select Cardilog from subject field drop down list");
		frontPage.slectCardiolog();
		
		reportLog("11.2: Subject set to cardilogy");
		frontPage.verifyCardiologySelected(Constants.CardiologyText);
		
		reportLog("12.1: In year field type 2000 ");
		frontPage.SelectYear();
		
		reportLog("12.2: Year field set to 2000 value");
		frontPage.verifyYearSelection(Constants.yearText);
		
		reportLog("13.1: In year field click on down arrow");
		frontPage.clickOnDownArrow();
		
		reportLog("13.2: year value changes automatically to 2001");
		frontPage.verifyChangedYearValue(Constants.changedYear);
		
		reportLog("14.1: In year field click on up arrow");
		frontPage.clickOnUpArrow();
		
		reportLog("14.2: year value changes automatically to 2000");
		frontPage.verifyyearChangedTo2000(Constants.yearText);
		
		reportLog("15.1: Click on Add");
		frontPage.clickOnAddButtonOnPopUp();
		
		reportLog("15.2: Certification added. ");
		frontPage.verifyCertificationAdded();
		
		reportLog("16.1: Click on x to delete added cerification");
		frontPage.clickOnDeleteButton(Constants.ACVIMtext);
		frontPage.selectOkOnAlert();
		
		reportLog("16.2: Certification entry deleted");
		frontPage.verifyCertificationDeleted();
		
		reportLog("17.1: Add Honor");
		frontPage.addHonor();
		
		reportLog("17.2: Add Honor window pops up");
		frontPage.verifyAddHonorWindows();
		
		reportLog("18.1: Select CCRP board from boards list");
		frontPage.selectCCRPBoards();
		
		reportLog("18.2: Board set to CCRP value");
		frontPage.verifyCCRPSelection(Constants.CCRPText);
		
		reportLog("19.1: Subject sets automatically to Physical Rehabilitation");
		frontPage.verifySubjectSetToPhysicalRehabilitation(Constants.PhysicalText);
		
		reportLog("20.1: From Month field drop down select month April");
		frontPage.selectMonthOnAddHonor();
		
		reportLog("20.2: Month set to April value");
		frontPage.verifyAprilMonthSelectionForAddHonor(Constants.AprilText);
		
		reportLog("21.1: In year field type 2000 ");
		frontPage.SelectYearForAddHonor();

		reportLog("21.2: Year field set to 2000 value");
		frontPage.verifyYearSelectionForAddHonor(Constants.yearText);

		reportLog("22.1: In year field click on down arrow");
		frontPage.clickOnDownArrow();
		
		reportLog("22.2: year value changes automatically to 2001");
		frontPage.verifyChangedYearValueForAddHonor(Constants.changedYear);

		reportLog("23.1.1: In year field click on up arrow");
		frontPage.clickOnUpArrow();		
		
		reportLog("23.2: year value changes automatically to 2000");
		frontPage.verifyyearChangedTo2000ForAddHonor(Constants.yearText);

		reportLog("24.1: Click on Add");
		frontPage.clickOnAddButtonOnForAddHonor();

		reportLog("24.2: Honor added. ");
		frontPage.verifyCertificationAdded();
		
		reportLog("25.1: Delete Honor by clicking on delete icon");
		frontPage.clickOnDeleteButton(Constants.CCRPtext);
		frontPage.selectOkOnAlert();
		
		reportLog("25.2: Honor entry deleted. Delete was successful message displays");
		frontPage.verifyCertificationDeleted();
		
		reportLog("Close The MyVIN Window");
        switchParentWindowByClosingChild(mainWindow);

		reportLog("Logout the Selenium User");
		logoutPage=frontPage.logoutApplication();
		
		reportLog("Verify the log out page");
		logoutPage.verifyLogoutPageDisplayed();	

	}
}
