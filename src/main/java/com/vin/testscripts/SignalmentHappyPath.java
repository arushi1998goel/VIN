package com.vin.testscripts;

import org.testng.annotations.Test;
import com.vin.pages.FrontPage;
import com.vin.selenium.core.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class SignalmentHappyPath extends BaseTest {

    private String SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName, parentWin;
    private List<String> multiplewindow;

    public SignalmentHappyPath() {
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
     * Test Case Name: Signalment
     * ====================================================================================================================
     *
     * @throws Exception
     */


    @Test
    public void signalment() throws Exception {

        reportLog("1.1:verify VIN Promo page is loaded");
        promoPage.verifyPromoPage();

        reportLog("1.2: Select the LOGIN button");
        loginPage = promoPage.clickOnLoginButton();

        reportLog("1.3: Verify login page is displayed");
        loginPage.verifyUserLoginPage();

        reportLog("1.4: Log in to the Portal ");
        securityQuestionPage = loginPage.loginInApplication(UserID, UserPswrd);

        reportLog("1.5: Verify Security Question Page displayed");
        securityQuestionPage.verifySecurityQuestionPageDisplayed();

        reportLog("1.6: Enter Security Answer and Login if Security Question Page displayed");
        frontPage = securityQuestionPage.enterSecurityAnswerAndLogin(FrontPage.class, SecurityAnswerSecoreIDNumber,
                SecurityAnswerMothersMaidenName);

        reportLog("1.7: Verify Front Page displayed");
        frontPage.verifyFrontPageDisplayed();

        reportLog("1.8 Dismiss Notifications");
        frontPage.dismissNotifications();

        reportLog("2.1: Select 'Message Boards' from the toolbar");
        messageboards = frontPage.clickOnMessageBoards();

        reportLog("3.1: Select dropdown icon for Vet-to-Vet board) ");
        messageboards.clickOnVetToVetFolder();

        reportLog("4.1 Select  MBtest folder from the list under ‘Filter by Boards/folder (optional)’ section");
        messageboards.selectMBTestFolderFromDropDown();

        reportLog(" 4.2 Select ‘Post New’ orange button located on the left upper corner of the page");
        messageboards.clickOnPostNewButton();

        reportLog("4.3 Select ‘Continue’ button from the ‘You Are Posting In’ pop up");
        messageboards.clickOnContinueButton();

        reportLog("4.4 Enter Name/patient ID: Leo,");
        parentWin = switchToChildWindow();
        messageboards.checkChildWindowElementPresent();
        messageboards.enterTextInTheNameBox(com.vin.utilities.Constants.LeoText);

        reportLog("4.5 Location: Davis, California, USA,");
        messageboards.enterLocationTextBox(com.vin.utilities.Constants.Location);

        reportLog("4.6 Limit type of animal to: Dogs,");
        messageboards.selectDogFromLimitTypeOfAnimal();

        reportLog("4.7 Breed or Type of Animal (be specific): start typing ‘mal’ and then pick ‘Matlese’ from the autosuggest list");
        messageboards.enterTextInBreedType();

        reportLog("4.8 Sex: male, neutered");
        messageboards.selectMaleNeuteredFromDropDown();

        reportLog("4.9 Weight (lb): 16.2 (tab to ‘OR Weight (kg) field to get data in it");
        messageboards.enterLbInTheWeightField();

        reportLog("4.10 Age Years: 3");
        messageboards.selectAgeFromDropDown();

        reportLog("4.11 Months: 6");
        messageboards.selectMonthsFromTheMonthDropDown();

        reportLog("4.12 Weeks: 2");
        messageboards.selectWeeksFromTheDropDown();

        reportLog("4.13 Or DOB: make sure that the  DOB is populated \r\n" +
                "Chief complaint: This is a test for selenium");
        messageboards.enterTextInTheChiefComplaintBox();
        String Value = messageboards.getDateTextFromTheTextBox();
        System.out.println(Value);

        reportLog("5.1 Select Save");
        messageboards.selectSaveButton();

        reportLog("5.2 Enter ‘Selenium test for signalment’ in ‘Discussion title’ field");
        messageboards.enterTextInTheDiscussionTitleBox();

        reportLog("5.3 field accepts entry value");
        messageboards.verifyValuesInTextBox();

        reportLog("6.1 Enter ‘This is a test for signalment’ in the message are");
        messageboards.enterTextInTheMessageBodyTextBox();

        reportLog("7.1 Select ‘Post Message’ button");
        messageboards.clickonPostMessageButton();

        reportLog("8.1  Click on ‘Yes (same New Tab/Window’ option for ‘View Your New Discussion’ pop up");
        messageboards.clickYesSameTabButton();

        reportLog("9.1 Click on 'OK' from the message posted confirmation. (if displayed)");
        messageboards.clickOk();

        reportLog("10.1 Verify that the red text for signalment is displayed in the discussion");
        switchToWindow(parentWin);
        switchToChildWindow();
        messageboards.verifyTextFromTheSignalmentDiscussion(Value);

        reportLog("11.1 Now select ‘Post New’");
        messageboards.clickOnPostNew();
        messageboards.switchToDefaultContent();

        reportLog("12.1 Select ‘Not a clinical case – skip’");
        multiplewindow = getAllWindowsOpenInUI();
        String mainWindow = multiplewindow.get(0);
        String window2 = multiplewindow.get(1);
        String window3 = multiplewindow.get(2);
        switchToWindow(window3);
        messageboards.clickOnNotAClinicalCaseButton();

        reportLog("13.1 Select ‘Cancel’ from the post window.");
        messageboards.clickOnCancelButton();

        reportLog("14.1 Select ‘OK’ to a pop up message asking ‘Are you sure you want to cancel your post?’");
        messageboards.acceptAlertPresent();

        reportLog("15.1 Select a dropdown icon next to ‘Hi Selenium’ and then select logout");
        List<String> multiplewindow1 = getAllWindowsOpenInUI();

        switchToWindow(multiplewindow1.get(1));
        logoutPage = frontPage.logoutApplication();

        reportLog("15.2 Member is logged out");
        logoutPage.verifyLogoutPageDisplayed();

        messageboards.closeCurrentWindow();
        switchToWindow(multiplewindow1.get(0));
        messageboards.closeCurrentWindow();

    }
}
