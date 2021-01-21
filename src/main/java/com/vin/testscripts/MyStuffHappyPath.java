package com.vin.testscripts;
import java.awt.AWTException;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.vin.pages.FrontPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;


import java.awt.*;

public class MyStuffHappyPath extends BaseTest {
    private String SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName, parentwin, articletext;


    public MyStuffHappyPath() {
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
     * Test Case Name: MyStuffHappyPath
     * ====================================================================================================================
     *
     * @throws InterruptedException
     * @throws AWTException
     */

    @Test
    public void myStuffHappyPath() throws InterruptedException, AWTException {

        reportLog("1.1: verify VIN Promo page is loaded ");
//        promoPage.verifyPromoPage();

        reportLog("1.2: Call Loging Method");
        loginPage = promoPage.clickOnLoginButton();
        loginPage.verifyUserLoginPage();
        securityQuestionPage = loginPage.loginInApplication(UserID, UserPswrd);

        reportLog("1.3: Verify Security Question Page displayed");
        securityQuestionPage.verifySecurityQuestionPageDisplayed();

        reportLog("1.4: Enter Security Answer and Login if Security Question Page displayed");
        frontPage = securityQuestionPage.enterSecurityAnswerAndLogin(FrontPage.class, SecurityAnswerSecoreIDNumber,
                SecurityAnswerMothersMaidenName);
        
        reportLog("2.1: Dismiss Notifications");
        frontPage.dismissNotifications();

       reportLog("2.2: Verify Front Page displayed");
       frontPage.verifyFrontPageDisplayed();
       
        reportLog("3.1 Select the second article from the 'Clinical Updates'  section");
        addStuffPage = frontPage.clickArticleInVinNewsSection();
        String mainWindow=addStuffPage.getDriver().getWindowHandle();

        reportLog("3.2 Clinical  article is displayed  ");
        articletext = addStuffPage.getTheTextOfTheNewsArticle();
        addStuffPage.verifyNewsArticleDisplayed();

        reportLog("4.1 Select the red heart from the VIN toolbar");
        addStuffPage.clickOnRedHeartIcon();
        addStuffPage.switchToNewWindow();

        reportLog("5.1: 'You are adding' pop up window is displayed");
        reportLog("6.1 Select  'Ok' ");
        addStuffPage.verifyAddToMYSTuffPopUpDisplayed();


        reportLog("7.1: Add to MyStuff window is displayed");
        addStuffPage.verifyWindowOpenInStuffTab();
        
        reportLog("8.1 Select 'Add Link' button to save news article to MyStuff ");
        addStuffPage.addLinkButton();
        
        reportLog("9.1: Scroll down and select the recently added article under the 'MyStuff' section");
        reportLog("9.2: Select 'Delete'");
        addStuffPage.selectArticleFromTheList();
//        addStuffPage.ClickAndDeleteOnRecentlyAddedArticle(Constants.article);
        addStuffPage.selectDeleteControl();
        
        
        reportLog("9.3: 'Are you sure you want to delete this bookmark?' pop up window is displayed.");
        reportLog("9.4: Select 'Ok'");
        addStuffPage.verifyPopUpDisplayedDeleteBookmark();
        
        reportLog("9.5: Selected bookmark is deleted");
        addStuffPage.verifyBookMarkDeleted(Constants.article);
        
        reportLog("10.1: Select another link under MyStuff section");
        addStuffPage.selectAnotherBookMarkList();
        
        reportLog("10.2: Select 'Modify'");
        addStuffPage.selectModiFy();
        
        reportLog("10.3: 'Edit Bookmark' pop up window is displayed");
        addStuffPage.verifyBooKmarkpopupWindow();
        
        reportLog("10.4: Select 'Add Notes and keywords'");
        addStuffPage.selectAddNotesAndKeywords();
        
        reportLog("10.5: Enter 'This is a test' in the 'Notes' text field");
        addStuffPage.EnterTextInNotesSection(Constants.enterTextInNotes);
        
        reportLog("10.6: Enter 'Selenium test' in the 'Keywords' text field");
        addStuffPage.EnterTextInKeywordSection(Constants.enterTextInKeywords);
        
        reportLog("10.7: Select 'Save'");
        addStuffPage.saveEditBookMarks();
        
        reportLog("11.1: Select 'New' listed under 'My Folders' list");
        addStuffPage.selectNewListedUnderMyFolder();
        
        reportLog("11.2: 'Create New Folder' pop up window is displayed");
        addStuffPage.verifyCreateNewFolderPopUp();
        
        reportLog("11.3: Enter 'Selenium' in the 'Folder Name' text field");
        addStuffPage.enterTextInFolderNameTextField(Constants.seleniumText);
        
        reportLog("11.4: Select 'Save'");
        addStuffPage.selectSave();
        
        reportLog("12.1: Select the 'Selenium' folder");
        addStuffPage.selectSeleniumFolder();
        
        reportLog("12.2: Select the 'Delete' listed under 'My Folders' list ");
        addStuffPage.selectDeleteUnderMyFolder();
        
        reportLog("12.3: 'Are you sure you want to delete this folder?' pop up window is displayed");
        reportLog("12.4: Select 'Ok'");
        addStuffPage.verifyDeleteThisFolder();        
        
        reportLog("13.1: Close MyVIN window");
        addStuffPage.getDriver().close();
        addStuffPage.getDriver().switchTo().window(mainWindow);
        
        reportLog("13.2: Call Logout Method");
        logoutPage= frontPage.logoutApplication();
        logoutPage.verifyLogoutPageDisplayed();
        
        
        
        
        

    }
}