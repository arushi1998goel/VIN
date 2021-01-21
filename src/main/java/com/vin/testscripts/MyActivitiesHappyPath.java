package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.FrontPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class MyActivitiesHappyPath extends BaseTest {
	

	public MyActivitiesHappyPath() {
		super();
	}
	
	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());
     
	}

	/**
	 * ====================================================================================================================
	 * Test Case Name: MyActivitiesHappyPath
	 * ====================================================================================================================
	 * 
	 * @throws Exception
	 * 
	 * 
	 */
	
	@Test
	public void verifyMyActivitiesHappyPath() throws Exception {
		
		reportLog("1.1: Navigate to beta.vin.com");
		promoPage.verifyPromoPage();
		loginPage = promoPage.clickOnLoginButton();
		loginPage.verifyUserLoginPage();
		
		reportLog("1.2: Call login method");
		frontPage = loginPage.loginInApplication(FrontPage.class, UserID, UserPswrd);
		frontPage.verifyFrontPageDisplayed();	
		frontPage.dismissNotifications();
		
		reportLog("1.3: Select 'MyActivities' on top navigation bar");
		myActivitiesPage=frontPage.clickOnMyActivitiesButton();
		
		reportLog("1.4: Verify 'MyActivities' pop up window loads successfully with the 'Discussions Viewed' tab selected by default");
        String parentWindow = switchToChildWindow();
		myActivitiesPage.verifyThePageLoadsSuccessfully(Constants.folderColumn);
		myActivitiesPage.verifyDiscussionViewedTabSelectedByDefault();
		String mainWindowHandle = myActivitiesPage.getDriver().getWindowHandle();

		reportLog("1.5: Select the 'StartDate' text field");
		reportLog("1.6: Enter the date 5/01/2020");
		myActivitiesPage.selectAndEnterDate(Constants.startDateField,Constants.StartDateInput);
		
		reportLog("1.7: Select the 'EndDate' text field");
		reportLog("1.8: Enter the date 7/06/2020");
		myActivitiesPage.selectAndEnterDate(Constants.endDateField,Constants.endDateInput);
		
		reportLog("1.9: Select the 'Go' button");
		myActivitiesPage.selectGoButton();
		
		reportLog("1.10: Verify the page refreshes and loads successfully");
		myActivitiesPage.verifyThePageLoadsSuccessfully(Constants.folderColumn);
		
		reportLog("2.1: Select the 'Discussions I Started' tab");
		myActivitiesPage.selectTabs(Constants.discussionIStartedTab);
		
		reportLog("2.2: Verify the page loads successfully");
		myActivitiesPage.verifyThePageLoadsSuccessfully(Constants.folderColumn);

		reportLog("2.3: Select a link under the 'Title' column");
		myActivitiesPage.selectFirstLinkUnderTitleColumn(Constants.id2);
		myActivitiesPage.switchToNewWindow();

		reportLog("2.4: Verify a new tab for Message Boards opens successfully");
		myActivitiesPage.verifyNewTabDorMessageBoardsOpened();
		
		reportLog("2.5: Close the Message Boards tab");
    	reportLog("2.6: Return to the MyActivities window");
     	switchParentWindowByClosingChild(mainWindowHandle);
		
		reportLog("3.1: Select the 'Discussions I commented on' tab");
	    myActivitiesPage.selectTabs(Constants.discussionCommentedTab);
	    
     	reportLog("3.2: Verify the page loads successfully");
		myActivitiesPage.verifyThePageLoadsSuccessfully(Constants.folderColumn);

		reportLog("3.3: Select a link under the 'Title' column");
		myActivitiesPage.selectFirstLinkUnderTitleColumn(Constants.id1);
		myActivitiesPage.switchToNewWindow();
	
		reportLog("3.4: Verify a new tab for Message Boards opens successfully");
		myActivitiesPage.verifyNewTabDorMessageBoardsOpened();

		reportLog("3.5: Close the Message Boards tab");
		reportLog("3.6: Return to the MyActivities window");
		switchParentWindowByClosingChild(mainWindowHandle);
     	
		reportLog("4.1: Select the 'MyDiscussions' tab");
		myActivitiesPage.selectTabs(Constants.MyDiscussionTab);

		reportLog("4.2: Verify the page loads successfully");
		myActivitiesPage.verifyThePageLoadsSuccessfully(Constants.folderColumn);
		
		reportLog("4.3: Select a link under the 'Title' column");
		myActivitiesPage.selectFirstLinkUnderTitleColumn(Constants.id2);
		myActivitiesPage.switchToNewWindow();
		
		reportLog("4.4: Verify a new tab for Message Boards opens successfully");
		myActivitiesPage.verifyNewTabDorMessageBoardsOpened();
		
		reportLog("4.5: Close the Message Boards tab");
		reportLog("4.6: Return to the MyActivities window");
        switchParentWindowByClosingChild(mainWindowHandle);

		reportLog("5.1: Select the 'MyPosts' tab");
		myActivitiesPage.selectTabs(Constants.MyPosttab);

		reportLog("5.2: Verify the page loads successfully");
		myActivitiesPage.verifyThePageLoadsSuccessfully(Constants.folderColumn);
		
		reportLog("5.3: Select a 'View Post' link under the 'Post' column"); 
		myActivitiesPage.selectALinkUnderTitleColumn(Constants.viewpostLink);
		myActivitiesPage.switchToNewWindow();
		
		reportLog("5.4: Verify a new tab for Message Boards opens successfully"); 
		myActivitiesPage.verifyNewTabDorMessageBoardsOpened();

		reportLog("5.5: Close the Message Boards tab");
		reportLog("5.6: Return to the MyActivities window");
		switchParentWindowByClosingChild(mainWindowHandle);

		reportLog("6.1: Select the 'MySubscriptions' tab");
		myActivitiesPage.selectTabs(Constants.subscriptionTab);

		reportLog("6.2: Verify the page loads successfully");
		myActivitiesPage.verifyThePageLoadsSuccessfully(Constants.folderColumn);
		
		reportLog("6.3: Select a link under the 'Title' column");
		myActivitiesPage.selectFirstLinkUnderTitleColumn(Constants.id3);
		myActivitiesPage.switchToNewWindow();
		
		reportLog("6.4: Verify a new tab for Message Boards opens successfully");
		myActivitiesPage.verifyNewTabDorMessageBoardsOpened();
		
		reportLog("6.5: Close the Message Boards tab");
		reportLog("6.6: Return to the MyActivities window");
		switchParentWindowByClosingChild(mainWindowHandle);

		reportLog("7.1: Select the 'My Search History' tab");
		myActivitiesPage.selectTabs(Constants.HistoryTab);

		reportLog("7.2: Verify the page loads successfully");
		myActivitiesPage.verifyThePageLoadsSuccessfully(Constants.searchLink);

		reportLog("7.3: Select a 'Search' link under the 'Search' column");
		myActivitiesPage.selectALinkUnderTitleColumn(Constants.searchLink);
		myActivitiesPage.switchToNewWindow();
		
		reportLog("7.4: Verify a new tab for Message Boards opens successfully");
		myActivitiesPage.verifyNewTabDorMessageSearchBoardsOpened();

		reportLog("7.5: Close the Message Boards tab");
		reportLog("7.6: Return to the MyActivities window");
        switchParentWindowByClosingChild(mainWindowHandle);

		reportLog("8.1: Select the 'My PDF Documents' tab");
		myActivitiesPage.selectTabs(Constants.DocumentTab);

		reportLog("8.2: Verify the page refreshes and loads successfully");
		myActivitiesPage.verifyThePageLoadsSuccessfully(Constants.filenameColumn);

		reportLog("9.1: Select 'X' to close the MyActivities window");
        switchParentWindowByClosingChild(parentWindow);

		reportLog("9.2: Call Logout method");
        logoutPage=myActivitiesPage.logoutApplication();
	    logoutPage.verifyLogoutPageDisplayed();

	
	}
}
