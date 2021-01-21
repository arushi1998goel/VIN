package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.FrontPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class BoardsLanding extends BaseTest {
	
	private String SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName, parentWin;

	
	public BoardsLanding() {
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
	 * Test Case Name: Boards Landing
	 * ====================================================================================================================
	 * @throws InterruptedException 
	 * 
	 * @throws Exception
	 * 
	 * @throws ParseException
	 */
	
	
	@Test
	public void boardsLandingPage() throws InterruptedException {
		reportLog("1.1: Open bowser and run the url");
		reportLog("1.2: Vin page loaded successfully");
		promoPage.verifyPromoPage();
		
		reportLog("2.1: Select the LOGIN button");
		loginPage = promoPage.clickOnLoginButton();

		reportLog("2.2: Verify login page is displayed");
		loginPage.verifyUserLoginPage();

		reportLog("2.3: Log in to the Portal ");
		securityQuestionPage = loginPage.loginInApplication(UserID, UserPswrd);
		
		reportLog("2.4: Verify Security Question Page displayed");
		securityQuestionPage.verifySecurityQuestionPageDisplayed();

		reportLog("2.5: Enter Security Answer and Login if Security Question Page displayed");
		frontPage = securityQuestionPage.enterSecurityAnswerAndLogin(FrontPage.class, SecurityAnswerSecoreIDNumber,
				SecurityAnswerMothersMaidenName);
		
		reportLog("3.1: From the Front page click on Message Board link on the top on the navigation bar");
		messageboards=frontPage.clickOnMessageBoards();
		
		reportLog("3.2: Message Board page loaded successfully");
		messageboards.verifyMessageBoardLoadedSuccessfully(Constants.messageBoardsAttribute);
		parentWin=messageboards.getDriver().getWindowHandle();

		reportLog("4.1: Check Vet to Vet radio button under Filter by boards section");
		messageboards.verifyVetToVetRadioButtonUnderFilterByBoardsSection(Constants.VettoVetRadioButtonText);
		
		reportLog("4.2: Vet to Vet board selected");
		messageboards.verifyVetToVetRadioButtonSelected();
		
		reportLog("5.1: Observe find since set to 2 days.");
		messageboards.observeFindSinceSetTo2Days();
		
		reportLog("5.2: Find since set to 2 days");
		messageboards.findSinceDropdownSetTo2Days();
		
		reportLog("6.1: Click on Find Since button");
		messageboards.clickOnFindSinceButton();
		
		reportLog("6.2: You pre selected pop up message appearse asking to confirm board selection");
		messageboards.verifyPreSelectedPopUpMessage(Constants.preSelectedText,Constants.messageDescription);
		
		reportLog("7.1: Click on Continue button");
		messageboards.clickOnContinueButton();
		messageboards.clickOnAlertWindow();
		
		reportLog("7.2: message dismissed and search result page loaded in same tab.");
		messageboards.verifySearchResultPage();
		
		reportLog("7.3: Vet to Vet board displayed with folders listed in drop down.");
		messageboards.verifyVetToVetBoardDisplayed();
		messageboards.verifyDropdownValuesWithFolderCount();
		
		reportLog("7.4: Find Since set to 2 days on search result page.");
		messageboards.verifyFindSinceDropdownOnSearchResultPage();
	
		reportLog("8.1: Click  on Boards button");
		messageboards.clickOnBoardsButtonOnMessageBoardsPage();
		
		reportLog("8.2: Selenium user navigate to boards landing page");
		messageboards.navigateToBoardsLandingPage(Constants.VINFrontPageTitle);
		
		reportLog("9.1: Select document ID radio button");
		messageboards.selectDocumentIDRadioButton();
		
		reportLog("9.2: Document ID selected");
		messageboards.verifyDocIDSelected();
		
		reportLog("10.1: Type 9455926 in search box");
		messageboards.typeInSearchBox(Constants.documentIDValue);;
		
		reportLog("10.2: Search box has value 9455926");
		messageboards.verifySearchBoxHasExpectedValue(Constants.documentIDValue);
		
		reportLog("11.1: Click on Find Since button");
		messageboards.clickOnFindSinceButton();
		
		reportLog("11.2: You pre selected pop up message appearse asking to confirm board selection");
		messageboards.verifyPreSelectedPopUpMessage(Constants.preSelectedText,Constants.messageDescription);

		reportLog("12.1: Click on Continue button");
		messageboards.clickOnContinueButton();

		reportLog("12.2: message dismissed and search result page loaded");
        messageboards.verifySearchResultPageAfterEnterDocID();
		
		reportLog("13.1: Scroll page down to discussion tool verify document id matches ");
		messageboards.scrollPageDownToDiscussionTool();
		messageboards.verifyDocumentIDMatches(Constants.documentIDValue);
		
		reportLog("13.2: Document ID matched with document id typed in search box in previous page");
		messageboards.verifyDocumentIDMatches(Constants.documentIDValue);

		reportLog("14.1: Click  on Boards button");
		messageboards.clickOnBoardsButtonOnSearcResultPage();

		reportLog("14.2: Selenium user navigate to boards landing page");
		messageboards.navigateToBoardsLandingPage(Constants.VINFrontPageTitle);
		
		reportLog("15.1: Scroll page down and click on My most viewed discussion under My recents section");
		messageboards.scrollPageDownToVerifyMyMostViewdDiscussion();
	
		reportLog("15.2: Discussions listed under my most viewed");
		messageboards.verifyDiscussionsListedUnderMyMostViewd();
		
		reportLog("16.1: Click on first link from the list shown under my discussion");
		reportLog("16.2: Link opens in new tab with selected discussion title that matched to clicked link title");
		messageboards.clickOnFirstLinkUnderMyDiscussion(Constants.myDiscussionText);
		
		reportLog("17.1: Close new tab with my discussion");
        switchParentWindowByClosingChild(parentWin);

		reportLog("18.1: Click on Personalize your boards link");
		messageboards.clickOnPersonalizeYourBoardsLink();
		
		reportLog("18.2: Link Opend in new window");
		messageboards.switchToNewWindow();
        messageboards.verifyLinkOpenedInNewWindow();
		
		reportLog("19.1: Close personalize your boards page opened in new window");
        switchParentWindowByClosingChild(parentWin);

		reportLog("20.1: Click on All boards radio button");
		messageboards.clickOnAllBoardsRadioButton();
		
		reportLog("20.2: All Boards Radio button selected");
		messageboards.verifyAllBoardsRadioButtonIsSelected();
		
		reportLog("21.1: Click on logout");
		messageboards.clickLogout();
		
		reportLog("21.2: Selenium logged out");
		messageboards.verifyLogoutPageDisplayed();

		
		
		
		
	}

}
