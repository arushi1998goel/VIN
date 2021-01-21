package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.LoginPage;
import com.vin.pages.LibraryQuickLink;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class IVALAHappyPath extends BaseTest {
	

	public IVALAHappyPath() {
		super();
	}
	
	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());

		
	}


	/**
	 * ====================================================================================================================
	 * Test Case Name: IVALAHappyPath
	 * ====================================================================================================================
	 * 
	 * @throws Exception
	 * 
	 * 
	 */
	
	
	@Test
	public void verifyIVALAHappyPath() throws Exception {
		
		reportLog("1.1 Navigate to https://www.vin.com/members/cms/project/defaultadv1.aspx?pid=549");
		loginPage=promoPage.navigateToGivenURL(LoginPage.class,Constants.IVALAURL);

		reportLog("1.2 Veryfy user is routed to a login page");
		loginPage.verifyUserLoginPage();

		reportLog("1.3 Call Login Script");
		libraryQuickLink=loginPage.loginInApplication(LibraryQuickLink.class,UserID, UserPswrd);

		reportLog("1.4 Verify Learning Anatomy in 3D page loads. Dismiss Notification if displayed by selecting X");
		libraryQuickLink.verifyAnatomyPageDisplayed();
		
		reportLog("2.1 Select 'Start using 3D content' button link");
		libraryQuickLink.clickOnStartUsing3DContent();
		
		reportLog("2.2 Verify button link can be selected and user is routed to https://www.vin.com/members/cms/project/defaultadv1.aspx?pId=549&id=9271778.Dismiss Notification if displayed by selecting X");
		libraryQuickLink.verifyURL(Constants.SuperProject);
		
		reportLog("3.1 Select the 3D super project play button");
		libraryQuickLink.select3DsuperProjectButton();
		
		reportLog("3.2 Verify user can select play button and Ivala VIN page loads. (Loading time takes awhile)");
		libraryQuickLink.verifyLoadingStartedForIvalaModule();
		
		reportLog("3.3 Verify Ivala module is displayed");
		libraryQuickLink.verifyIvalaModuleIsDisplayed();
		
		reportLog("4.1 Select outside of the Ivala module");
		libraryQuickLink.select3DsuperProjectButton();

		reportLog("4.2 Verify Ivala module closes and user is viewing 3D super project page https://www.vin.com/members/cms/project/defaultadv1.aspx?pId=549&id=9271778");
		libraryQuickLink.verifyIvalaModuleClosedAndUserIsViewingViewAll3DLink();
		
		reportLog("5.1 Call logout script");
		logoutPage=libraryQuickLink.logout();
	    logoutPage.verifyLogoutPageDisplayed();

  }
}
