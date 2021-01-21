package com.vin.testscripts;

import com.vin.pages.FrontPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class PostAndReplyHappyPath extends BaseTest {

    private String SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName, parentWin;

    public PostAndReplyHappyPath() {
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
     * Test Case Name: PostAndReply
     * ====================================================================================================================
     *
     * @throws Exception
     * @throws ParseException
     */

    @Test
    public void postAndReply() throws Exception {

        reportLog("1.1:Verify VIN Promo page is loaded (Title: Veterinary Information Network®, Inc. – VIN)");
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
        frontPage = securityQuestionPage.enterSecurityAnswerAndLogin(FrontPage.class, SecurityAnswerSecoreIDNumber,
                SecurityAnswerMothersMaidenName);

        reportLog("1.7:Verify Front Page displayed (Title: Front Page – VIN)d");
        frontPage.verifyFrontPageDisplayed();

        reportLog("1.8 Dismiss Alert Notifications if displayed");
        frontPage.dismissNotifications();

        reportLog("2.1: Select 'Message Boards' from the toolbar");
        messageboards = frontPage.clickOnMessageBoards();
        
        reportLog("2.2: Dismiss Alert Notifications if displayed");
        frontPage.dismissNotifications();

        reportLog("3.1:  Select Vet-to-Vet board under 'Filter by boards/folder (optional)' header ");
        messageboards.clickOnVetToVetFolder();

        reportLog("3.2: Verify  Radio button for Vet-to-Vet board is selected ");
        messageboards.verifyVetToVetRadioButtonSelected();

        reportLog("3.3: Select 'MBTest' folder under 'Vet-to-Vet' board.");
        messageboards.selectMBTestFolderFromDropDown();

        reportLog("3.4: verify *MBTest folder is selected ");
        messageboards.verifyMBTestFolderIsSelected(Constants.MbTestFolder);

        reportLog("4.1: Select 'Post New' button ");
        messageboards.clickOnPostNewButton();

        reportLog("4.2: You are posting in..' pop up is displayed with Vet-to-Vet board and MBTest information");
        messageboards.verifyPostingInPopUpDisplayed(Constants.postingInPopUP, Constants.VettoVetBoardMBTestText);

        reportLog("4.3: Select 'Continue'");
        messageboards.clickOnContinueButton();
        
        reportLog("4.4: Dismiss Alert Notifications if displayed");
        frontPage.dismissNotifications();

        reportLog(
                "5.1: Post New Discussion window is displayed, Signalment window is displayed on the top if signalment is turned on for a folder ");
        parentWin = switchToChildWindow();
        messageboards.verifyPostNewAndSignalmentWindowIsDisplayed(Constants.PostNewDiscussion);

        reportLog("6.1: Select 'Not a clinical case- skip' button if displayed ");
        messageboards.clickOnNotAClinicalCaseButton();

        reportLog("6.2: 'Post New Discussion' window is visible");
        messageboards.VerifyPostANewWindowDisplayed(Constants.PostNewDiscussion);

        reportLog("7.1: Provide 'VIN is awesome!!!' in discussion title text box");
        messageboards.enterTextInTheDiscussionTitle(Constants.ProvidedTextInDiscussionTitle);

        reportLog("7.2:  Verify Discussion title is populated ");
        messageboards.verifyDiscussionTitlePopulated(Constants.ProvidedTextInDiscussionTitle);

        reportLog(
                "8.1: Provide the following text in 'My Post' area: 'Since 1991, VIN has been and always will be — for veterinarians, by veterinarians'");
        messageboards.enterTextInMyPostArea(Constants.textForDiscussionTitle);

        reportLog("8.2: Verify Post content is populated ");
        messageboards.verifyTextInMYPostArea(Constants.textForDiscussionTitle);
        
        reportLog(
                "9.1: Make sure that the 'Preview Message' is checked. If the checkbox to preview message is not checked, check the checkbox ");
        messageboards.verifyThePreviewMessageCheckbox();

        reportLog("9.2: Select 'Post Message'");
        messageboards.clickonPostMessageButton();
        
        reportLog("9.3: Preview window is displayed ");
        messageboards.verifyPreviewWindowDisplayed();
        
        reportLog("10.1: Select 'Post your New Message'");
        messageboards.clickonPostNewMessageButton();
        
        reportLog("10.2: 'View your New Discussion?' pop up is displayed ");
        messageboards.verifyViewYourNewDiscussionPopUpDislpayed(Constants.viewYourNewDiscussionPopUp);
        
        reportLog("10.3: Select 'Yes (Same Tab/Window)'");
        messageboards.clickYesSameTabButton();
        
        reportLog("10.4: Verify  Message Posted confirmation is displayed if member has set up this pref.");
        messageboards.verifyMessagePostedConfirmationDisplayed();
        
        reportLog("10.5: Select 'Ok '");
        messageboards.clickOk();

        reportLog("10.6: Dismiss Alert Notifications if displayed");
        frontPage.dismissNotifications();
        
        reportLog(
                "11.1: Verify Discussion viewer is displayed, newly created discussion is highlighted in the left navigation ");
        switchToWindow(parentWin);
        switchToChildWindow();
        messageboards.verifyDiscussionViewerDisplayed();
        messageboards.newlyCreatedDiscussionHighlightedAndDisplayed(Constants.VinIsAwesomeText, Constants.colourCode);
        
        reportLog("11.2: Select 'Reply'");
        messageboards.clickOnReplyButton();
        
        reportLog("11.3: Verify 'Reply To Discussion' window is displayed");
        messageboards.switchToNewWindow();
        messageboards.verifyReplyToDiscussionWindow();
        
        reportLog("11.4: Enter the following text: 'Selenium Test' in post area");
        messageboards.enterTextInThePostArea();
        
        reportLog("11.5:  verify Post area is populated ");
        messageboards.verifyTitleIsPopulatedInThePostArea();

        reportLog("11.6:  Unselect 'Preview Message' checkbox if it is checked");
        messageboards.UnSelectPreviewMessageBoxIfIsChecked();
        
        reportLog("11.7: Verify Preview Message checkbox is unchecked ");
        messageboards.verifyPreviewMessageBoxIsUncheked();
        
        reportLog("11.8: Select 'Post Message'");
        messageboards.clickPostMessageButton();
      
        reportLog("11.9: 'Message Posted' pop up is displayed");
        messageboards.verifyMessagePostedConfirmationDisplayed();
        
        reportLog("12.1:  Select OK");
        messageboards.clickOk();
       
        reportLog("12.2: Verify Message is posted to the newly created thread");
        String messageboardwindow = getAllWindowsOpenInUI().get(1);
        switchToWindow(messageboardwindow);
        messageboards.verifyMessagePosted();
        switchToWindow(parentWin);
        
        reportLog("13.1: logout application");
        logoutPage = messageboards.logoutApplication();

        reportLog("13.2: Logging off from VIN is successful ");
        logoutPage.verifyLogoutPageDisplayed();

    }
}
