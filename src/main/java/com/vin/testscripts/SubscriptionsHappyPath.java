package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.FrontPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class SubscriptionsHappyPath extends BaseTest {

    private String SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName;

    public SubscriptionsHappyPath() {
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
     * Test Case Name: SubscriptionsHappyPath
     * ====================================================================================================================
     * @throws InterruptedException 
     *
     * @throws Exception
     */
    
    @Test

    public void subscriptionHappyPath() throws InterruptedException {
    	
    	
    	reportLog("1.1: Verify VIN Promo page is loaded (Title: Veterinary Information Network�, Inc. � VIN)");
		promoPage.verifyPromoPage();

		reportLog("1.2: Select the LOGIN button");
		loginPage = promoPage.clickOnLoginButton();

		reportLog("1.3:Verify login page is displayed (Title: Login)");
		loginPage.verifyUserLoginPage();

		reportLog("1.4: Log in to the Portal ");
		securityQuestionPage = loginPage.loginInApplication(UserID, UserPswrd);

		reportLog("1.5: Verify Security Question Page displayed (Title: VIN � Security Question)");
		securityQuestionPage.verifySecurityQuestionPageDisplayed();

		reportLog("1.6: Enter Security Answer and Login if Security Question Page displayed");
		frontPage = securityQuestionPage.enterSecurityAnswerAndLogin(FrontPage.class, SecurityAnswerSecoreIDNumber,SecurityAnswerMothersMaidenName);

		reportLog("1.7: Verify Front Page displayed (Title: Front Page � VIN)");
		frontPage.verifyFrontPageDisplayed();
		
		reportLog("1.8: Dismiss Alert Notifications if displayed");
	    frontPage.dismissNotifications();

	    reportLog("2.1: Select 'Message Boards' from the toolbar");
	    messageboards = frontPage.clickOnMessageBoards();
	    
	    reportLog("2.2: Dismiss Alert Notifications if displayed");
	    frontPage.dismissNotifications();

	    reportLog("3.1: Select Vet-to-Vet board under 'Filter by boards/folder (optional)' header ");
	    messageboards.clickOnVetToVetFolder();

	    reportLog("3.2: Verify  Radio button for Vet-to-Vet board is selected ");
	    messageboards.verifyVetToVetRadioButtonSelected();

	    reportLog("3.3: Select 'MBTest' folder under 'Vet-to-Vet' board.");
	    messageboards.selectMBTestFolderFromDropDown();

	    reportLog("3.4: verify 'MBTest' folder is selected ");
	    messageboards.verifyMBTestFolderIsSelected(Constants.MbTestFolder);
	    
	    reportLog("4.1: Select the Drop down button next to 'Find Since'.");
	    messageboards.selectFindSinceDropDown();
	    
	    reportLog("4.2: Select '30 Days' from the drop down list.");
	    messageboards.selectDaysFromTheDropDwown(Constants.days30);
	    
	    reportLog("4.3: Verify 30 days is populated on the drop down menu option");
	    messageboards.verifyDaysOptionIsShownInTheDropDown(Constants.days30);
	    
	    reportLog("4.4: Select 'Find Since'");
	    messageboards.clickOnFindSinceButton();
	    
	    reportLog("5.1: 'You PRE-SELECTED...' pop up window if displayed");
		messageboards.verifyPreSelectedPopUpMessage(Constants.preSelectedText,Constants.messageDescription);
		
    //  reportLog("5.2: Select 'Continue'");
//	    messageboards.clickOnContinueButton();

	    reportLog("5.3: Dismiss Alert Notifications if displayed");
	    frontPage.dismissNotifications();

	    reportLog("6.1: Select the first discussion from the list");
	    String linkName=messageboards.selectFirstDiscussionFromList();
	    
	    reportLog("6.2: Verify The selected discussion thread is displayed in the right pane");
    	messageboards.verifySelectedDiscussionThreadisDisplayed(linkName);
	    
	    reportLog("6.3: Select the 'Subscribe' button on the top left of the page");
    	messageboards.clickOnSubscribeButton();

	    reportLog("6.4: Verify Message board subscription pop up window is displayed");
    	messageboards.verifySubscribeModalWillDisplay();

	    reportLog("6.5: Select 'Subscribe to this Discussion'");
    	messageboards.selectSubscribeToThisModalPopup();

	    reportLog("6.6: Verify member is subscribed to discussion thread and subscribe button on top left is now yellow and labelled as unsubscribe.");
    	messageboards.verifySubscribeButtonIsYellowed();

	    reportLog("7.1: Click on the Unsubscribe button");
    	messageboards.clickOnSubscribeButton();
	    
	    reportLog("7.2  Verify Message board subscriptions pop up window is displayed");
        messageboards.verifyMessageBoardIsDisplayed();
        
        reportLog("7.3: Select 'Unsubscribe to this Discussion'");
    	messageboards.selectSubscribeToThisModalPopup();
        
        reportLog("7.4: Verify member is unsubscribe from discussion thread");
        messageboards.verifySubscribeButtonIsOranged();
        
        reportLog("8.1: Logout Application");
        logoutPage=messageboards.logoutApplication();

        reportLog("8.2: Logging off from VIN is successful");
        logoutPage.verifyLogoutPageDisplayed();
    }
    
   
}
