package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.FrontPage;
import com.vin.selenium.core.BaseTest;


public class JournalsHappyPath extends BaseTest {

    private String SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName;

    public JournalsHappyPath() {
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
     * Test Case Name: JournalsHappyPath
     * ====================================================================================================================
     *
     * @throws Exception
     */
    
    @Test

    public void journalsTC1() throws Exception {

    	reportLog("1.1: Verify VIN Promo page is loaded (Title: Veterinary Information Network®, Inc. – VIN");
		promoPage.verifyPromoPage();

		reportLog("1.2: Select the LOGIN button");
		loginPage = promoPage.clickOnLoginButton();

		reportLog("1.3:  Verify login page is displayed (Title: Login)");
		loginPage.verifyUserLoginPage();

		reportLog("1.4: Log in to the Portal ");
		securityQuestionPage = loginPage.loginInApplication(UserID, UserPswrd);

		reportLog("1.5: Verify Security Question Page displayed (Title: VIN – Security Question)");
		securityQuestionPage.verifySecurityQuestionPageDisplayed();

		reportLog("1.6: Enter Security Answer and Login if Security Question Page displayed");
		frontPage = securityQuestionPage.enterSecurityAnswerAndLogin(FrontPage.class, SecurityAnswerSecoreIDNumber,SecurityAnswerMothersMaidenName);

		reportLog("1.7: Verify Front Page displayed (Title: Front Page – VIN)");
		frontPage.verifyFrontPageDisplayed();
		
		reportLog("1.8 Dismiss Notifications");
	    frontPage.dismissNotifications();

		reportLog("2.1: Select 'Library' on top navigation bar");
		frontPage.selectLibraryDropDwon();
		
		reportLog("2.2: A 'Library Home' window is displayed.");
		frontPage.verifyLibraryHomeWindowIsDisplayed();
		
		reportLog("2.3: Select 'Journals' under 'Library Quick Links'");
		journalsPage=frontPage.selectJournalsLink();
		
		reportLog("2.4: Journals Home page loaded successfully (Title: Journals – VIN)");
		journalsPage.verifyJournalsPageDisplayed();
		
		reportLog("2.5: Dismiss Alert Notifications if displayed");
	    frontPage.dismissNotifications();

		reportLog("3.1:  type in Pit Bull in search bar");
		journalsPage.enterTextInTheSearchJournals();
		
		reportLog("3.2:  Field accepts entry");
		journalsPage.verifyTextInTheTextBox();
		
		reportLog("3.3: click on search icon magnifyer ");
		journalsPage.selectSearcgIconMagnifier();
		
		reportLog("3.4: Search results open a new tab displaying results and are listed with hyperlinks on page.");
		String parentwin=switchToChildWindow();
		journalsPage.verifyLinksIsDisplayedOnThePages();
		
		reportLog("3.5: Dismiss Alert Notifications if displayed");
	    frontPage.dismissNotifications();

		reportLog("3.6:  Verify Each result marked with number and uncheck check box icon");
		journalsPage.verifyCheckBoxIsUnchecked();
		
		reportLog("3.7: Close the tab displaying the search results");
        switchParentWindowByClosingChild(parentwin);

		reportLog("3.8: The tab displaying the search results is closed.");
		journalsPage.verifyJournalsPageDisplayed();
		
		reportLog("4.1 Select the 'Clear' button");
		journalsPage.seletClearButton();
		
		reportLog("4.2: The text in the search field is now cleared");
		journalsPage.verifyNoTextIsPresentInTheTextBox();
		
		reportLog("4.3: Dismiss Alert Notifications if displayed");
	    frontPage.dismissNotifications();

		reportLog("5.1 Select 'Browse Journals List' button if displayed else go to step 6.1");
		reportLog("5.2 Verify Journals page displays the option to browse by title");
		journalsPage.selectBrowseJournalList();
		
		reportLog("6.1 Select 'J'");
		journalsPage.selectJButton();
		
		reportLog("6.2 Select the drop down button for 'Choose Collection' and Select 'Current Veterinary' from the drop down option");
		journalsPage.selectCurrentFromTheList();
		
		reportLog("6.3: Verify The Journals page displays with all the Journals starting with 'J'");
		journalsPage.verifyTheTextInTheListStartsWithJ();
		
		reportLog("6.4: Dismiss Alert Notifications if displayed");
	    frontPage.dismissNotifications();

		reportLog("7.1 Select the 'Password vault' button next to ‘Journal of the American Veterinary Medical Association’");
		journalsPage.selectpasswordVaultButton();
		
		reportLog("7.2: Verify A new tab opens displaying the Journal for ‘Journal of the American Veterinary Medical Association’");
		String parentWin1=switchToChildWindow();
		journalsPage.verifyPasswordVaultPageIsDisplayed();
		
		reportLog("7.3: Dismiss Alert Notifications if displayed");
	    frontPage.dismissNotifications();

		reportLog("7.4: Close the tab for American Veterinary Medical Association");
        switchParentWindowByClosingChild(parentWin1);

		reportLog("7.5: Verify The tab for American Veterinary Medical Association Journal is closed");
		journalsPage.verifyJournalsPageDisplayed();

		reportLog("8.1: Select the 'Open link in a new tab' button next to a link under 'Clinical Updates'.");
		String linkName=journalsPage.selectClinicalUpdatesLink();

		reportLog("8.2: A new tab opens displaying the selected link");
		String parentwin5 = switchToChildWindow();
		journalsPage.verifyClincalPageeIsDisplayed(linkName);
		
		reportLog("8.3: Dismiss Alert Notifications if displayed");
	    frontPage.dismissNotifications();

		reportLog("8.4: Close the tab for the selected Journal");
        switchParentWindowByClosingChild(parentwin5);

		reportLog("8.5: The tab for the selected Journal is closed");
		journalsPage.verifyTitleOfTheJournalsPAge();
		
		reportLog("9.1: Logout Applicatuon");
		logoutPage=journalsPage.logoutApplication();
		
		reportLog("9.2: Logging off from VIN is successful");
		logoutPage.verifyLogoutPageDisplayed();
		
		
    }  
}


