package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.FrontPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class DiscussionViewerHappyPath extends BaseTest {

	public DiscussionViewerHappyPath() {

		super();
	}
	
	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());
		
	}


	/**
	 * ====================================================================================================================
	 * Test Case Name: DiscussionViewerHappyPath
	 * ====================================================================================================================
	 * @throws Exception
	 * 
	 * @throws ParseException
	 */
	
	@Test
	public void verifyDiscussionViewerHappyPath() throws Exception {
		

		reportLog("1.1: Bringing up VIN page");
		promoPage.verifyPromoPage();
		
		reportLog("1.2: Call Login method");
		loginPage = promoPage.clickOnLoginButton();
		loginPage.verifyUserLoginPage();
		frontPage=loginPage.loginInApplication(FrontPage.class,UserID, UserPswrd);
		frontPage.dismissNotifications();

		reportLog("2.1: Select 'Message Boards' on the top navigation menu");
	    messageboards = frontPage.clickOnMessageBoards();

		reportLog("2.2: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();
		
		reportLog("2.3: Select Vet-to-Vet board under 'Filter by boards/folder (optional)' section");
	    messageboards.clickOnVetToVetFolder();

		reportLog("2.4: Select 'MBTest' folder under 'Vet-to-Vet' board drop down");
	    messageboards.selectMBTestFolderFromDropDown();

		reportLog("2.5: Select '6 Days' from the drop down list next to 'Find Since'");
	    messageboards.selectFindSinceDropDown();
	    messageboards.selectDaysFromTheDropDwown(Constants.days6);

		reportLog("2.6: Select the 'Find Since' button");
		messageboards.dismissNotifications();

	    messageboards.clickOnFindSinceButton();

		reportLog("2.7: Select 'Continue' on the 'YOU PRE-SELECTED' pop up window");
		messageboards.verifyPreSelectedPopUpMessage(Constants.preSelectedText,Constants.messageDescription);

		reportLog("2.8: Dismiss Alert Notifications if displayed");
		messageboards.dismissNotifications();

		reportLog("2.9: Verify Message Board Discussion page loads successfully");
		messageboards.verifyMessageBoardIsDisplayed();
		
		reportLog("3.1: Select the 'Expanded' radio button under the 'Pick a Discussion' section");
		messageboards.selectExpandedRadioButton();
		
		reportLog("3.2: Select the top discussion link under 'About This Folder'");
	    messageboards.selectFirstDiscussionFromList();
		
		reportLog("3.4 Dismiss Alert Notifications if displayed");
		messageboards.dismissNotifications();

		reportLog("3.4: Verify the discussion thread loads successfully");
		messageboards.verifyMessageBoardIsDisplayed();

		reportLog("4.1: Select the check box next to 'View Checked'");
		messageboards.selectTheCheckBoxNextToViewChecked();
		
		reportLog("4.2: Select the 'View Checked' button");
		messageboards.slectViewCheckButton();
		
		reportLog("4.3: Dismiss Alert Notifications if displayed");
		messageboards.dismissNotifications();

		reportLog("4.3: Verify the discussion thread refreshes and shows only the selected post");
		messageboards.verifySelectedPostIsDisplayed();
		
		reportLog("4.4: Select the '1' button next to 'Return to normal view, Page:'");
		messageboards.selectOneButton();
		
		reportLog("4.5: Dismiss Alert Notifications if displayed");
		messageboards.dismissNotifications();

		reportLog("4.6: Verify the discussion thread refreshes and shows all posts in the thread again");
		messageboards.verifyAllPostAreDisplayed();
	
		reportLog("4.7: Select the check box next to 'View Checked' again to remove the check mark");
		messageboards.selectTheCheckBoxNextToViewChecked();
		
		reportLog("4.7: Select '1.' link next to the 'Posted By' text");
		messageboards.selectonelink();
        String parentWindow = switchToChildWindow();

		reportLog("4.8: Dismiss Alert Notifications if displayed");
		messageboards.dismissNotifications();

		reportLog("4.9: Verify a new tab opens and loads successfully");
		messageboards.verifyNewTabDorMessageBoardsOpened();
		
		reportLog("4.10: Close the new tab");
        switchParentWindowByClosingChild(parentWindow);

		reportLog("5.1: Scroll down and select the 'Copy to Clipboard' button next to 'Discussion URL'");
		messageboards.scrollDownAndSelectCopyToClipboard();
		
		reportLog("5.2: Select the 'Jump to Top' button");
		messageboards.selectJumpToTop();
		
		reportLog("5.3: Call Logout method");
        logoutPage=messageboards.logoutApplication();
        logoutPage.verifyLogoutPageDisplayed();


}
}