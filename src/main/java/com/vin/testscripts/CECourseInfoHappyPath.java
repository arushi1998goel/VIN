package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.CECourseInfoPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class CECourseInfoHappyPath extends BaseTest {

	private String SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName;
	
	public CECourseInfoHappyPath() {
		super();
	}
	
	
	/**
	 * ====================================================================================================================
	 * Test Case Name: CE Course Info
	 * ====================================================================================================================
	 * 
	 * @throws Exception
	 * 
	 * @throws ParseException
	 */
	
	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());

		SecurityAnswerSecoreIDNumber = RegressionTestData.getProperty("SecurityAnswerSecoreIDNumber");
		SecurityAnswerMothersMaidenName = RegressionTestData.getProperty("SecurityAnswerMothersMaidenName");

	}
	
	@Test
	public void VerifyCECourseInfo() throws Exception
	{
		
		reportLog(" verify VIN Promo page is loaded ");
		promoPage.verifyPromoPage();

		reportLog("1: Navigate to https://beta.vin.com/CE/ ");
		continualEducationpage = promoPage.navigateToMyCePage();
		
		reportLog("2: Continual education portal page is loaded");
		continualEducationpage.verifyContinualEducationPortalPage();

		reportLog("2.1: Login to Acess MyCE");
		loginPage = continualEducationpage.clickOnLoginLink();

		reportLog("2.2: Log in to the Portal ");
		courseInfoPage = loginPage.loginInApplication(CECourseInfoPage.class,UserID, UserPswrd);
		
		reportLog("3: Click on any open for enrollment course listed under Open for Enrollment");
		courseInfoPage=continualEducationpage.clickOnAnyLinkInOpenForEnrollmentVeterinarians();
		
		reportLog("4: Course Info Page successfully loaded in new opened window");
		courseInfoPage.switchToNewWindow();
		courseInfoPage.verifyCourseInfoPageSuccessfullyDisplayedInNewWindow();
		String mainWindowHandle = courseInfoPage.getDriver().getWindowHandle();
		
		reportLog("5: Click on Enroll Now button");
		courseInfoPage.clickOnEnrollNowButton();
		
		reportLog("6:VIN CE Enrollment wizard page opens up in new window");
		courseInfoPage.switchToNewWindow();
		courseInfoPage.verifyVINCERegistrationPageInNewWindow();
		
		reportLog("7: Close CE Enrollment wizard  by clicking on x icon");
		courseInfoPage.getDriver().close();
		courseInfoPage.getDriver().switchTo().window(mainWindowHandle);
		
		reportLog("8: CE Enrollment wizard is closed. User is back on Course Info Page");
		courseInfoPage.verifyCourseInfoPageSuccessfullyDisplayedInNewWindow();
		        
        reportLog("9: Click on Presenter name link");
        String name=courseInfoPage.clickOnPresenternameLink();
        courseInfoPage.switchToNewWindow();
        
        reportLog("10: VIN consultants and editors page opened up in new window");
        courseInfoPage.verifyVINFrontPageIsLoadedInNewWindow(Constants.VINPageTitle);
      
        reportLog("11: Verify presenter name displayed matched presenter name on course info page");
        courseInfoPage.verifyPresenterNameMatchedOnCourseInfoPage(name);
        
        reportLog("12: Close vin consultants and editors page");
        courseInfoPage.getDriver().close();
        courseInfoPage.getDriver().switchTo().window(mainWindowHandle);
        
        reportLog("13: User is back on course info page");
		courseInfoPage.verifyCourseInfoPageSuccessfullyDisplayedInNewWindow();
		
		reportLog("14: Close the browser windows");
		courseInfoPage.closeDriver();
		
       
}


}
