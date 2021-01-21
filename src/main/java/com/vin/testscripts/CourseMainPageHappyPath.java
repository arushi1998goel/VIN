package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.ContinualEducationPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class CourseMainPageHappyPath extends BaseTest {
		
	public CourseMainPageHappyPath() {
		super();
	}
	
	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());
	}

	/**
	 * ====================================================================================================================
	 * Test Case Name: CourseMainPageHappyPath
	 * ====================================================================================================================
	 * @throws Exception 
	 * 
	 */
	
	
	@Test
	public void VerifyCourseMainPageHappyPath() throws Exception {
		
		reportLog("1: Navigate to https://beta.vin.com/CE/");
		promoPage.verifyPromoPage();
		continualEducationpage = promoPage.navigateToMyCePage();

		reportLog("1.2: Continual education portal page is loaded");
		continualEducationpage.verifyContinualEducationPortalPage();

		reportLog("1.3: Dismiss Notification if displayed");
		
		reportLog("2.1: Call Login Script");
		loginPage = continualEducationpage.clickOnLoginLink();
		continualEducationpage=loginPage.loginInApplication(ContinualEducationPage.class,UserID, UserPswrd);

		reportLog("2.2: Dismiss Notification if displayed");
		
		reportLog("3.1: Select Participation Resource Center Button Link");
		continualEducationpage.clickOnLargeButtonsOnContinualEducationPage(Constants.ParticipantLink);
        String parentWindow = switchToChildWindow();

		reportLog("3.2: Verify page loads, dismiss notification if displayed, close tab");
		continualEducationpage.verifyPageTitle(Constants.ParticipantResourcePageTitle);
		continualEducationpage.dismissNotifications();
        switchParentWindowByClosingChild(parentWindow);

		
		reportLog("4.1: Select Instructor Resource Center Button Link");
		continualEducationpage.clickOnLargeButtonsOnContinualEducationPage(Constants.InstructorLink);
		switchToChildWindow();

		reportLog("4.2: Verify page loads, dismiss notification if displayed, close tab");
		continualEducationpage.verifyPageTitle(Constants.InstructorResourcePageTitle);
		continualEducationpage.dismissNotifications();
        switchParentWindowByClosingChild(parentWindow);
        
		reportLog("5.1: Select Archived CE Courses Button Link");
		continualEducationpage.clickOnLargeButtonsOnContinualEducationPage(Constants.ArchivedLink);
		switchToChildWindow();
		
		reportLog("5.2: Verify page loads, dismiss notification if displayed, close tab");
		continualEducationpage.verifyPageTitle(Constants.CourseArchivesPageTitle);
		continualEducationpage.dismissNotifications();
        switchParentWindowByClosingChild(parentWindow);
        
		reportLog("6.1: Select Course Suggestions Button Link");
		continualEducationpage.clickOnLargeButtonsOnContinualEducationPage(Constants.CourseSuggestionsLink);
		switchToChildWindow();
		
		reportLog("6.2: Verify page loads, dismiss notification if displayed, close tab");
		continualEducationpage.verifyCourseSuggestionPageIsLoaded();
		continualEducationpage.dismissNotifications();
        switchParentWindowByClosingChild(parentWindow);
        
		reportLog("7.1: Select VIN CE Catalog Button Link");
		continualEducationpage.clickOnBottomLinkOnContinualEducationPage(Constants.VINCECatalogLink);
		switchToChildWindow();

		reportLog("7.2: Verify page loads, dismiss notification if displayed, close tab");
		continualEducationpage.verifyPageTitle(Constants.CoursecatalogPageTitle);
		continualEducationpage.dismissNotifications();
        switchParentWindowByClosingChild(parentWindow);
        
		reportLog("8.1: Select VSPN CE Catalog Button Link");
		continualEducationpage.clickOnBottomLinkOnContinualEducationPage(Constants.VSPNCECatalogLink);
		switchToChildWindow();
		
		reportLog("8.2: Verify page loads, dismiss notification if displayed, close tab");
		continualEducationpage.verifyPageTitle(Constants.CoursecatalogPageTitle);
		continualEducationpage.dismissNotifications();
        switchParentWindowByClosingChild(parentWindow);
        
		reportLog("9.1: Select MyVIN tab Button Link");
		continualEducationpage.clickOnBottomLinkOnContinualEducationPage(Constants.MyVINLink);
		switchToChildWindow();
		
		reportLog("9.2: Verify page loads, dismiss notification if displayed, close tab");
		continualEducationpage.verifyPageTitle(Constants.MyVINPageTitle);
		continualEducationpage.dismissNotifications();
        switchParentWindowByClosingChild(parentWindow);
        
		reportLog("10.1: Select MyVSPN tab Button Link");
		continualEducationpage.clickOnBottomLinkOnContinualEducationPage(Constants.MyVSPNLink);
		switchToChildWindow();
		
		reportLog("10.2: Verify page loads, dismiss notification if displayed, close tab");
		continualEducationpage.verifyPageTitle(Constants.MyVINPageTitle);
		continualEducationpage.dismissNotifications();
        switchParentWindowByClosingChild(parentWindow);
        
		reportLog("11.1: Select Non-Interactive Tab Button Link");
		continualEducationpage.clickOnBottomLinkOnContinualEducationPage(Constants.NonInteractiveCatalogLink);
		switchToChildWindow();
		
		reportLog("11.2: Verify page loads, dismiss notification if displayed, close tab");
		continualEducationpage.verifyPageTitle(Constants.CoursecatalogPageTitle);
		continualEducationpage.dismissNotifications();
        switchParentWindowByClosingChild(parentWindow);
        
		reportLog("12.1: Select CE Demo Button Link");
		continualEducationpage.clickOnBottomLinkOnContinualEducationPage(Constants.CEDEMOLink);
		switchToChildWindow();
		
		reportLog("12.2: Verify page loads, dismiss notification if displayed, close tab");
		continualEducationpage.verifyPageTitle(Constants.CEDemoPageTitle);
		continualEducationpage.dismissNotifications();
        switchParentWindowByClosingChild(parentWindow);
        
		reportLog("13.1: Call log out script");
		continualEducationpage.selectLogout();
		
		reportLog("13.2: Verify user is logged out");
		continualEducationpage.verifySeleniumUserLoggedOut();

}
	
}
