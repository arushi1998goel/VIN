package com.vin.testscripts;

import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.FrontPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class BoardsDraftHappyPath extends BaseTest {

	private String SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName, parentWin;

	public BoardsDraftHappyPath() {
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
	 * Test Case Name: BoardsDraftHappyPath
	 * ====================================================================================================================
	 * 
	 * @throws Exception
	 * 
	 * @throws ParseException
	 */

	@Test
	public void boardsDraft() throws Exception {

		reportLog("1.1: verify VIN Promo page is loaded (Title: Veterinary Information Network®, Inc. – VIN)");
		promoPage.verifyPromoPage();

		reportLog("1.2: Select the LOGIN button");
		loginPage = promoPage.clickOnLoginButton();

		reportLog("1.3: Verify login page is displayed (Title: Login)");
		loginPage.verifyUserLoginPage();

		reportLog("1.4: Log in to the Portal ");
		securityQuestionPage = loginPage.loginInApplication(UserID, UserPswrd);

		reportLog("1.5: Verify Security Question Page displayed (Title: VIN – Security Question)");
		securityQuestionPage.verifySecurityQuestionPageDisplayed();

		reportLog("1.6: Enter Security Answer and Login if Security Question Page displayed");
		frontPage = securityQuestionPage.enterSecurityAnswerAndLogin(FrontPage.class, SecurityAnswerSecoreIDNumber,
				SecurityAnswerMothersMaidenName);

		reportLog("1.7: Verify Front Page displayed (Title: Front Page – VIN)");
		frontPage.verifyFrontPageDisplayed();

		reportLog("1.8 Dismiss Notifications");
	    frontPage.dismissNotifications();

		reportLog("2.1: Select 'Message Boards' from the toolbar");
		messageboards = frontPage.clickOnMessageBoards();
		
		reportLog("2.2: Dismiss Notifications if isplayed ");
		frontPage.dismissNotifications();
		
		reportLog("3.1 Select Vet-to-Vet board under 'Filter by boards/folder (optional)' header ");
		messageboards.clickOnVetToVetFolder();

		reportLog("3.2 Verify  Radio button for Vet-to-Vet board is selected ");
		messageboards.verifyVetToVetRadioButtonSelected();

		reportLog("4.1 Select 'MBTest' folder under 'Vet-to-Vet' board.");
		messageboards.selectMBTestFolderFromDropDown();

		reportLog("4.2 verify *MBTest folder is selected ");
		messageboards.verifyMBTestFolderIsSelected(Constants.MbTestFolder);

		reportLog("5.1: Select 'Post New' button ");
		messageboards.clickOnPostNewButton();

		reportLog("5.2 You are posting in..' pop up is displayed with Vet-to-Vet board and MBTest information");
		messageboards.verifyPostingInPopUpDisplayed(Constants.postingInPopUP, Constants.VettoVetBoardMBTestText);

		reportLog("6.1 Select 'Continue'");
		messageboards.clickOnContinueButton();

		reportLog(
				"6.2 Post New Discussion window is displayed, Signalment window is displayed on the top if signalment is turned on for a folder ");
		parentWin = switchToChildWindow();
		messageboards.verifyPostNewAndSignalmentWindowIsDisplayed(Constants.PostNewDiscussion);

		reportLog("7.1 Select 'Not a clinical case- skip' button if displayed ");
		messageboards.clickOnNotAClinicalCaseButton();

		reportLog("7.2 Post new window is visible ");
		messageboards.VerifyPostANewWindowDisplayed(Constants.PostNewDiscussion);

		reportLog("8.1 Provide 'Draft test for Selenium!!!' in discussion title text box");
		messageboards.enterTextInTheDiscussionTitle(Constants.DraftTextInDiscussionTitle);

		reportLog("8.2  Verify Discussion title is populated ");
		messageboards.verifyDiscussionTitlePopulated(Constants.DraftTextInDiscussionTitle);

		reportLog("9.1 Provide the following text in 'My Post' area: 'Testing draft functionality'");
		messageboards.enterTextInMyPostArea(Constants.textForDraftDiscussionTitle);

//		reportLog("9.1 Verify Post content is populated ");
//		messageboards.verifyTextInMYPostArea(Constants.textForDraftDiscussionTitle);

		reportLog("9.2 Click on Save Draft button");
		messageboards.clickOnSaveDrafts();

		reportLog("9.3 Verify Red 'saving draft' message is displayed  ");
		messageboards.verifySavingDraftsMessageDisplayed();

		reportLog("10.1 Click on 'Open Draft' button ");
		messageboards.selectOpenDraftsButton();
		System.out.println(getWebDriver().getTitle());
		
		reportLog("10.2: Dismiss Notifications if displayed");
		frontPage.dismissNotifications();


		reportLog(
				"10.3 Verify MyDrafts window is displayed and ‘draft test for selenium' is highlighted under 'New Discussions'. ");
		List<String> multipleWIndows = getAllWindowsOpenInUI();
		String win1 = multipleWIndows.get(0);
		String win2 = multipleWIndows.get(1);
		String win3 = multipleWIndows.get(2);
		messageboards._normalWait(3000);
		switchToWindow(win3);
		System.out.println(getWebDriver().getTitle());
		getWebDriver().manage().window().maximize();
		messageboards.VerifyMyDraftsWindowIsDisplayed();

		reportLog("10.4 Click on Select Draft button ");
		messageboards.clickOnSelectDrafts();
		

		reportLog("10.5:  If browser = firefox, then select OK to a pop up message displayed https://www.screencast.com/t/dkC29Wut16l");
        messageboards.clickEnter();

	
		reportLog(
				"11.1 Select Yes in MyDrafts pop up with message �Are you sure you want to append this draft to your current message?�");
		messageboards._normalWait(5000);
		multipleWIndows = getAllWindowsOpenInUI();
		win1 = multipleWIndows.get(0);
		win2 = multipleWIndows.get(1);
		messageboards._normalWait(3000);
		switchToWindow(win2);
		messageboards._normalWait(2000);

		System.out.println(getWebDriver().getTitle());
		messageboards._normalWait(2000);
		messageboards.selectYesButton();

		reportLog("11.2 Verify  Text from the draft is appeneded to the post ");
		messageboards.verifyTextIsAppended();

		reportLog("12.1 Click on ‘Post Message’ button");
		messageboards._normalWait(1000);
		messageboards.clickonPostMessageButton();

		reportLog("12.2  Verify  View your New Discussion?' pop up is displayed ");
		messageboards._normalWait(1000);
		messageboards.verifyViewYourNewDiscussionPopUpDislpayed(Constants.viewYourNewDiscussionPopUp);

		reportLog(
				"13.1 Would you like to view your new discussion? With the following buttons: Copy Discussion URL, Yes (New Tab/Window), Yes (same Tab/Window) and No");
		messageboards.verifytextAndButtonsFromViewYourNextDiscussionPopup(Constants.WouldYouLikeToViewYourNewDiscussion,
				Constants.CopyDiscussionUrl, Constants.YesNewTabText, Constants.YesSameTabText, Constants.NoText);

		reportLog("14.1 Select 'Yes (Same Tab/Window)'");
		messageboards.clickYesSameTabButton();

		reportLog("14.2 Verify  Message Posted confirmation is displayed if member has set up this pref.");
		messageboards.verifyMessagePostedConfirmationDisplayed();

		reportLog("15.1 Your message has been posted! With the following buttons: Copy Discussion URL, OK");
		messageboards.verifyMessagePostedConfirmationWithCopyDiscussionUrlDisplayed();

		reportLog("16.1 Select 'Ok '");
		messageboards.clickOk();
		
		reportLog("16.2: Dismiss Notifications if displayed");
		frontPage.dismissNotifications();


		reportLog(
				"16.2 Verify Discussion viewer is displayed, newly created discussion is highlighted in the left navigation ");
		switchToWindow(parentWin);
		switchToChildWindow();
		messageboards.verifyDiscussionViewerDisplayed();
		messageboards.newlyCreatedDiscussionHighlightedAndDisplayed(Constants.draftsForSeleniumText,
				Constants.colourCode);

		reportLog("17.1 logout application");
		logoutPage = frontPage.logoutApplication();

		reportLog("17.2 Logging off from VIN is successful ");
		logoutPage.verifyLogoutPageDisplayed();

	}

}