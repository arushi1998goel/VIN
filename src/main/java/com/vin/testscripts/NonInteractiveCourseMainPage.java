package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class NonInteractiveCourseMainPage extends BaseTest {
	
	private String SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName;
	
	public NonInteractiveCourseMainPage() {
 
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
	 * Test Case Name: Non-Interactive Course Main Page
	 * ====================================================================================================================
	 * @throws Exception
	 * @throws ParseException
	 */

	@Test
	public void verifyNonInteractiveCourseMainPage() throws Exception
	{
		reportLog("verify VIN Promo page is loaded ");
		promoPage.verifyPromoPage();
		
		reportLog("1:1 Go to https://www.vin.com/ce");
		continualEducationpage = promoPage.navigateToMyCePage();
		
		reportLog("1:2: Verify CE portal is displayed");
		continualEducationpage.verifyContinualEducationPortalPage();
		
		reportLog("1:3 Call login Method");
        loginPage = continualEducationpage.clickOnLoginLink();
		

		reportLog("1.3.1 Enter Selenium user credentials");
		securityQuestionPage = loginPage.loginInApplication(UserID, UserPswrd);

		reportLog("1.3.2: If Security Question Page displayed enter Security Answer and Login");
		securityQuestionPage.verifySecurityQuestionPageDisplayed();

		reportLog("1.3.3:  Enter Security Answer and Login if Security Question Page displayed");
		continualEducationpage = securityQuestionPage.enterSecurityAnswerAndLogin(
				com.vin.pages.ContinualEducationPage.class, SecurityAnswerSecoreIDNumber,
				SecurityAnswerMothersMaidenName);
		
		reportLog("1:4 Selenium User logged in successfully");
		continualEducationpage.verifySeleniumUser(Constants.seleniumUserText);
		String mainWindowHandle = continualEducationpage.getDriver().getWindowHandle();

		
		reportLog("1:5 If alert notification is displayed, dismiss alert by clicking on dismiss button");
		continualEducationpage.dismissNotifications();
		
		reportLog("1:1 Click on green arrow under visit my course in MyCE");
		continualEducationpage.clickOnGreenArrow();
		continualEducationpage.switchToNewWindow();
		
		
		reportLog("1:2 Selenium taken to Non-Interactive Course home page");
		continualEducationpage.verifyNonInteractiveCourseHomePage();
		
		reportLog("1:3 Verify Course Title matches course title in MyCE");
		continualEducationpage.verifyCourseTitleMatches(Constants.ratBasicsText);
		
		reportLog("1:1 Click on Ham-burglar icon");
		continualEducationpage.clickOnHamBurglarIcon();
		
		reportLog("1:2 Verify Hamburglar Icon expands displaying course menu");
		continualEducationpage.verifyCourseNameDisplaying();
		
		reportLog("1:1 Click on Start the course go to module one yellow button");
		continualEducationpage.clickOnStartCourseYellowButton();
		
		reportLog("1:2.1:  Verify Course Dashboard changes to expanded Module 1");
		continualEducationpage.vrifyCourseDashboardChangesToExpandedModule();
		
		reportLog("1:2.2: video loads and starts playing automatically");
		continualEducationpage.verifyVideoPlayAutomatically();
		
		reportLog("1:4 Click on Pause icon to pause video");
		continualEducationpage.clickOnPauseIcon();
		
		reportLog("1:1 Click on square icon to play video in full screen");
		continualEducationpage.clickOnSquareIcon();
		
		reportLog("1:2 Verify video expands in full size window while continues to play");
		continualEducationpage.verifyVideoExpandsInFullSize();
		
		reportLog("1:3 Click on same icon to get back to default video screen size");
		continualEducationpage.clickOnSameIconForDefaultVideoSize();
		
		reportLog("1:4 Confirm video screen size returned to default state");
		continualEducationpage.confirmDefaultVideoSize();
		
		reportLog("1:1 Click on Course Dashboard link located under Course Code with Course Title");
		continualEducationpage.clickOnCourseDashboardLink();
		
		reportLog("1:2 Confirm UI changed to Course Dashboard with Current Progress view.");
		continualEducationpage.confirmUIChanged();
		
		reportLog("1:3 Confirm Course Dashboard link is not underlined and not a link when on course dashboard");
     	continualEducationpage.verifyDashboardIsNotALink();
     	
     	reportLog("1:1 Expand any course module from the menu and find Poll");
     	reportLog("1:2 Click on module with Poll");
     	continualEducationpage.expandAnyCourseModuleAndFindPoll();
     	
     	reportLog("1:3 Confirm Poll displayed with question and multiple choices to choose from");
     	continualEducationpage.confirmPollDisplayedWithQuestionAndMCQ();
     	
     	reportLog("1:4 Confirm each answer choice has radio button next to it to allow Selenium to pick desired answer");
     	continualEducationpage.confirmRadioButtonForMCQ();
     	
     	reportLog("1:5 Click on any radio button selecting the choice");
     	//continualEducationpage.clickOnAnyRadioButton();
     	
     	reportLog("1:6 Confirmed radio button turned blue");
     	continualEducationpage.confirmRadioButtonTurnedBlue();
     	
     	reportLog("1:1 Click on Next Segment button");
     	continualEducationpage.clickOnNextSegmentButton();
     	
     	reportLog("1:1 Confirm Selenium taken to next segment in module or next module depends on his current state");
     	continualEducationpage.confirmNextSegment();
     	
     	reportLog("1:1 Click on triangle icon next to Additional Resources");
     	continualEducationpage.clickOnTriangleIconNextToAdditionalResources();
     	
     	reportLog("1:2 Confirm Additional Resource module expands with \"This module is optional\" description");
     	continualEducationpage.confirmAdditionalResourceModuleExpansionDescription(Constants.expansionText);
     	
     	reportLog("1:3 Click on Additional Resource module");
     	continualEducationpage.clickOnAdditionalResourceModule();
     	
     	reportLog("1:1 Confirm Mark as read button displays in green color");
     	continualEducationpage.confirmReadButtonDisplaysInGreenColor();
     	
     	reportLog("1:2 Confirm on Mark as read button turns red and changes to Mark as unread");
     	continualEducationpage.markAsReadButtonChangesToMarkAsUnRead();
     	
     	reportLog("1:1 Scroll page up and find End of Course test module");
     	reportLog("1:2 Click on End of Course of test module description");
     	continualEducationpage.findAndClickOnEndOfTestModule();
     	
     	reportLog("1:3 Confirm course UI changes to No access with \"You do not have access to this module yet. Please complete the remaining modules to continue' message");
     	continualEducationpage.confirmCourseUIChanges(Constants.UIChangeMessage);
     	continualEducationpage.getDriver().close();
     	continualEducationpage.getDriver().switchTo().window(mainWindowHandle);
     	
     	
     	reportLog("1:1 Call Logout method");
     	continualEducationpage.selectLogout();
     	continualEducationpage.verifySeleniumUserLoggedOut();
     	
     	
     	
     	
     	
     	
     	
     	
     	
     	
     	
     	
     	
     	
     	
		
		
		
		
		
		
		
		
		
		
		

	}
	
	

}
