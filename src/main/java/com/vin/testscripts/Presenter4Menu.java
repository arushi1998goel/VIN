package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.vin.pages.LoginPage;
import com.vin.pages.PresenterFourMenu;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class Presenter4Menu extends BaseTest {

	public Presenter4Menu() {
		super();
	}
	
	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());

	}
	/**
	 * ====================================================================================================================
	 * Test Case Name: Presenter4Menu
	 * ====================================================================================================================
	 * 
	 * @throws Exception
	 * 
	 * 
	 */
	
	@Test
	public void verifyPresenter4Menu() throws Exception {

		reportLog("1.1 Navigate to https://www.vin.com/p4/p4.html?documentid=8829823&initslide=8829918#!/s/t/8829823");
		loginPage=promoPage.navigateToGivenURL(LoginPage.class,Constants.presenterURL);

		reportLog("1.2 Verify user is routed to a login page");
		loginPage.verifyUserLoginPage();

		reportLog("1.3 Call Login Script");
		presenterFourMenu=loginPage.loginInApplication(PresenterFourMenu.class,UserID, UserPswrd);

		reportLog("1.4 Verify Demo for P4 displays and Dismiss Notification if displayed by selecting X");
		presenterFourMenu.verifyDemoForP4ScreenDisplayed();
		presenterFourMenu.dismissNotifications();
		
		reportLog("2.1 Select Menu");
		presenterFourMenu.selectMenu();
		
		reportLog("2.2 Verify menu can be selected by user");
		presenterFourMenu.verifyMenuCanBeSelectedByUser();
		
		reportLog("3.1 Select Enter Fullscreen in menu");
		presenterFourMenu.selectMenuItems(Constants.enterFullscreenText);
		
		reportLog("3.2 Verify user is now viewing in full screen");
		presenterFourMenu.verifyFullScreenIsDisplayed();
		
		reportLog("3.3 Select esc to exit full screen");
		presenterFourMenu.selectMenu();
		presenterFourMenu.selectMenuItems(Constants.exitFullScreenText);

		reportLog("3.4 Verify user is able to exit full screen");
		presenterFourMenu.verifyExitToFullscreen();
		
		reportLog("4.1 Select Go to thread in menu");
		presenterFourMenu.selectMenu();
		presenterFourMenu.selectGotoThread();
        String parentWindow = switchToChildWindow();
		
		reportLog("4.2 Verify user is able to select go to thread and thread opens in new window. Dismiss Notification if displayed by selecting X");
		presenterFourMenu.verifyPageDisplayed(Constants.pageTitle_DemoForP4);
		presenterFourMenu.dismissNotifications();

		reportLog("4.3 Close tab");
        switchParentWindowByClosingChild(parentWindow);

		reportLog("5.1 Select view in old presenter link in menu");
		presenterFourMenu.selectMenu();
		presenterFourMenu.selectMenuItems(Constants.oldPresenterText);
        String parentWindow1 = switchToChildWindow();

		reportLog("5.2 Verify user is able to select to view in old presenter and it opens in a new window. Dismiss Notification if displayed by selecting X");
		presenterFourMenu.verifyPageDisplayed(Constants.pageTitle_oldPresenter);
		presenterFourMenu.dismissNotifications();

		reportLog("5.3 Close tab");
        switchParentWindowByClosingChild(parentWindow1);

		reportLog("6.1 Select Help in menu");
		presenterFourMenu.selectMenu();
		presenterFourMenu.selectMenuItems(Constants.helpText);

		reportLog("6.2 Verify Help Modal display");
		presenterFourMenu.verifyHelpModelIsDisplayed();
		
		reportLog("6.3 Select Icons in Help Modal");
		presenterFourMenu.selectIconsInHelpModels();
		
		reportLog("6.4 Verify Icons menu expands within help modal");
		presenterFourMenu.verifyMenuIsExpended();
		
		reportLog("6.5 Select Icons in Help Modal to collapse menu");
		presenterFourMenu.selectIconsInHelpModels();

		reportLog("6.6 Verify Icons menu collapses");
		presenterFourMenu.verifyMenuIsCollapses();
		
		reportLog("6.7 Select Menu Items in Help modal");
		presenterFourMenu.selectMenuItems();
		
		reportLog("6.8 Verify Menu Items expands within help modal");
		presenterFourMenu.verifyMenuIsExpended();

		reportLog("6.9 Select Menu Items in Help Modal to collapse menu");
		presenterFourMenu.selectMenuItems();

		reportLog("6.10 Verify Menu Items menu collapses");
		presenterFourMenu.verifyMenuIsCollapses();

		reportLog("6.11 Close help modal by selecting close");
		presenterFourMenu.clickOnCrossIcon();

		reportLog("6.12 Verify Help modal is now closed");
		presenterFourMenu.verifyHelpModelIsNotDisplayed();
		
		reportLog("7.1 Select Show Auto Advance in Menu");
		presenterFourMenu.selectMenu();
		presenterFourMenu.selectMenuItems(Constants.ShowAdvanceText);

		reportLog("7.2 Verify Auto Advance button shows up in P4 menu bar");
		presenterFourMenu.verifyAutoButonIsShowsUp();
		
		reportLog("7.3 Select Hide Auto Advance in Menu");
		presenterFourMenu.selectMenu();
		presenterFourMenu.selectMenuItems(Constants.HideAdvanceText);

		reportLog("7.4 Verify Auto Advance button is removed from P4 menu bar");
		presenterFourMenu.verifyAutoButonIsRemoved();
		
		reportLog("8.1 Select VIN Front Page in Menu");
		presenterFourMenu.selectMenu();
		presenterFourMenu.selectMenuItems(Constants.FrontPageText);

		reportLog("8.2 Verify VIN Front Page loads. Dismiss Notification if displayed by selecting X");
		presenterFourMenu.verifyPageDisplayed(Constants.pageTitle_FrontPage);
		presenterFourMenu.dismissNotifications();
		
		reportLog("8.3 Select back arrow to get back to P4 screen");
		presenterFourMenu.navigateBack();
		presenterFourMenu.verifyDemoForP4ScreenDisplayed();
		
		reportLog("8.4 Close P4 by selecting X in browser window");
		presenterFourMenu.closeDriver();
}
}
