package com.vin.testscripts;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class MyCEHappyPath extends BaseTest {

	private String SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName;
	

	public MyCEHappyPath() {
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
	 * Test Case Name: MyCEHappyPath
	 * ====================================================================================================================
	 * 
	 * @throws Exception
	 * @throws ParseException
	 */

	@Test

	public void myCEHappyPath() throws Exception {

		reportLog("verify VIN Promo page is loaded ");
		promoPage.verifyPromoPage();

		reportLog("1: Navigate to https://beta.vin.com/CE/");
		continualEducationpage = promoPage.navigateToMyCePage();
		
		reportLog("2. Continual education portal page is loaded");
		continualEducationpage.verifyContinualEducationPortalPage();

		reportLog("3. Locate login link and click to login");
		loginPage = continualEducationpage.clickOnLoginLink();
		

		reportLog("4. Enter Selenium user credentials");
		securityQuestionPage = loginPage.loginInApplication(UserID, UserPswrd);

		reportLog("5. If Security Question Page displayed enter Security Answer and Login");
		securityQuestionPage.verifySecurityQuestionPageDisplayed();

		reportLog("5.1:  Enter Security Answer and Login if Security Question Page displayed");
		continualEducationpage = securityQuestionPage.enterSecurityAnswerAndLogin(
				com.vin.pages.ContinualEducationPage.class, SecurityAnswerSecoreIDNumber,
				SecurityAnswerMothersMaidenName);
		
		reportLog("6. Selenium successfully logged in");
		continualEducationpage.verifySeleniumUser(Constants.seleniumUserText);
		

		reportLog("7. If Dismiss Notification if displayed dismiss alert by clicking on dismiss button");
		reportLog("8. Alert pop-up dismissed");
		continualEducationpage.dismissNotifications();

		reportLog("9. Go to additional records tab");
		continualEducationpage.clickOnAdditionalRecordTab();

		reportLog("10. Click on add button");
		continualEducationpage.clickOnAdditionalCourseButton();

		reportLog("11. Add course pop-up opened up");
		continualEducationpage.verifyAdditionalCoursePopUpDisplayed();

		reportLog("12. type VIN in Organization text box");
		continualEducationpage.EnterTextInTheOrganizationalField(Constants.VINText);

		reportLog("13. type Osha in Program text box");
		continualEducationpage.EnterTextInTheProgramField(Constants.oshaText);
		
		reportLog("14. Click on Calendar icon");
		continualEducationpage.clickOnCalenderIcon();
		
		reportLog("15. Calendar popped up");
		continualEducationpage.verifyCalendarPopup();
		
		reportLog("16. type https://beta.vin.com in URL text box");
		continualEducationpage.typeInURLTextbox();
		
		reportLog("17. Click on add button");
		continualEducationpage.clickAddButton();
		
		reportLog("18. Click Ok to confirm pop-up message");
		continualEducationpage.verifyAlertText();
		continualEducationpage.acceptAlertPresent();
		continualEducationpage.clickOnCross();
		//continualEducationpage.verifyCertificationPopUp();
		
		reportLog("19. Record added to additional records and displayed under tab");
		continualEducationpage.verifyRecordsAddedInTheTable(Constants.VINText);
		String mainWindow=continualEducationpage.getDriver().getWindowHandle();
		
		reportLog("20. Click on visit course link - green arrow");
		continualEducationpage.clickOnVisitCourseLink();
		continualEducationpage.switchToNewWindow();
		
		reportLog("21. VIN promo page opened up in new window");
		continualEducationpage.verifyPromoPageInNewWindow();
		
		reportLog("22. Close VIN Promo page");
		continualEducationpage.getDriver().close();
		continualEducationpage.getDriver().switchTo().window(mainWindow);
		
		reportLog("23. Selenium is back to MyCE");
		continualEducationpage.verifyContinualEducationPortalPage();
		
		reportLog("24. Delete added record by clicking on x icon under actions");
		continualEducationpage.deleteRecordsIfPresentInAddedCourse();
		
		reportLog("25. Added record deleted");
		continualEducationpage.verifyAddedCourseDeleted();
		
		reportLog("26. Logout Selenium user by clicking on logout link");
		continualEducationpage.selectLogout();
		
		reportLog("27. Selenium user logged out");
		continualEducationpage.verifySeleniumUserLoggedOut();
	}
}
