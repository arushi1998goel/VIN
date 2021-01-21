package com.vin.testscripts;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.vin.pages.LoginPage;
import com.vin.pages.SearchHappyPathPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class SearchHappyPath  extends BaseTest {
	
	private String SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName;
	

	public SearchHappyPath() {
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
	 * Test Case Name: Search Happy path
	 * ====================================================================================================================
	 * 
	 * @throws Exception
	 */


	@Test

	public void verifySearchHappyPath() throws Exception {

		reportLog("1.1: verify VIN Promo page is loaded (Title: Veterinary Information Network®, Inc. – VIN)");
		loginPage = promoPage.verifyPromoPageForLogin(LoginPage.class);
		
		reportLog("1.2: Select the LOGIN button");
		loginPage = promoPage.clickOnLoginButton();

		reportLog("1.3:Verify login page is displayed (Title: Login)");
		loginPage.verifyUserLoginPage();


		reportLog("1.4: Log in to the Portal ");
		securityQuestionPage = loginPage.loginInApplication(UserID, UserPswrd);

		reportLog("1.5:Verify Security Question Page displayed (Title: VIN – Security Question)");
		securityQuestionPage.verifySecurityQuestionPageDisplayed();

		reportLog("1.6: Enter Security Answer and Login if Security Question Page displayed");
		searchhappypath = securityQuestionPage.enterSecurityAnswerAndLogin(
				SearchHappyPathPage.class, SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName);
		
		reportLog("1.7:  Verify Front Page displayed");
		searchhappypath.verifyFrontPageDisplayed();

		
		reportLog("1.8 If Alert noticiation modal displays, dismiss alert notification window by selecting \"Dismiss\" ");
		searchhappypath.dismissNotifications();

		reportLog("2.1:  Click on Search from the top navigation bar");
        searchhappypath.clickOnSearchButton();
		
		
		reportLog("2.2 Verify Search page is  loaded");
		searchhappypath.verifySearchPageIsLoaded(Constants.pageTitle_SearchPage);
		String mainWindowHandle = searchhappypath.getDriver().getWindowHandle();

	
		
		reportLog("3.1 Verify If Alert noticiation modal displays, dismiss alert notification window by selecting \"Dismiss\"");
		searchhappypath.dismissNotifications();

	
		
		reportLog("4.1 Enter  in 'taurine' in search bar");
		searchhappypath.searchTermInTheSearchBox(Constants.TextTaurine);
		
		reportLog("4.2 Verify field accepts entry, auto-suggestion list availble as user types in. ");
	    searchhappypath.verifyFieldsAcceptEntriesAndAutosuggestionListAvailable();
	    
	    reportLog("4.3 verify search word is displayed first in the list as the most relevant");
	    searchhappypath.verifyFirstSuggestion();
		
		reportLog("5.1  click on search icon magnifyer ");
		searchhappypath.clickOnMagnifier();
		

		reportLog("5.2 Verify search results displayed and listed with hyperlinks on page. ");
        searchhappypath.verifySearchResultsDisplayed();
        searchhappypath.verifyHyperlinkDislpayed();
        
        reportLog("5.3: Dismiss Notifications if displayed");
		searchhappypath.dismissNotifications();

	
		
        reportLog("6.1 click on very first search result: Taurine");
        searchhappypath.clickOnFirstLink();
	
		
		reportLog("6.2 6.2 Verify The selected document is displayed in a same tab");
		searchhappypath.switchToNewWindow();
		searchhappypath.verifyTaurineIsDisplayed();
		
		reportLog("6.3: Dismiss Notifications if displayed");
		searchhappypath.dismissNotifications();

		reportLog("6.4: Close the document tab and return back to search result page");
		searchhappypath.getDriver().close();
		searchhappypath.getDriver().switchTo().window(mainWindowHandle);
		searchhappypath.verifySearchPageIsLoaded(Constants.pageTitle_SearchPage);
	
		
		reportLog("7.1 Expand drop down list of Any Species and choose Cats or Dogs filter");
		searchhappypath.clickAndOpenSpeciesDropDown();
		
		reportLog("7.2 Verify page refreshes automatically. Search results refresh to results that has cat or doc in Keyword tag");
		searchhappypath.selectOptionDisplayedUnderSpeciesDropDown("1011");
		
		reportLog("7.3  Dismiss Notifications if displayed");
		searchhappypath.dismissNotifications();

		reportLog("8.1: select the checkbox for first 2 results in the list");
		searchhappypath.selectTheFirstTwoCheckbox();
		
		reportLog("8.2: Select ‘View Checked’");
		searchhappypath.selectViewCheckedControl();
		
		reportLog("8.3: Select the first option from the list: ‘View Checked Results’");
		searchhappypath.selectViewCheckedResults();
		
		reportLog("8.4: New window is displayed with selected results");
		searchhappypath.switchToNewWindow();
		searchhappypath.verifyViewCheckedWindow();
		
		reportLog("8.5: Dismiss Notifications if displayed");
		searchhappypath.dismissNotifications();

		reportLog("8.6: Close the window and return to the search results page");
		searchhappypath.getDriver().close();
		searchhappypath.getDriver().switchTo().window(mainWindowHandle);
		searchhappypath.verifySearchPageIsLoaded(Constants.pageTitle_SearchPage);
		
		reportLog("9.1: Select MySearches button from the top of the page");
		searchhappypath.selectMySearches();
		
		reportLog("9.2: Verify MyActivities pop up window is displayed and My Searches tab is selected");
		String	parentWin=switchToChildWindow();
		searchhappypath.verifyMyActivitiesPopUp();
		searchhappypath.verifyMySearchHistoryIsSelected();
		
		reportLog("9.3: Dismiss Notifications if displayed");
		searchhappypath.dismissNotifications();


		reportLog("9.4: Select the very first result from My Searches list");
		searchhappypath.selectFirstLinkFromMySearchesPopup();
		
		reportLog("9.5: Verify Search result page is displayed");
		switchToWindow(parentWin);
		searchhappypath.verifySearchPageIsLoaded(Constants.pageTitle_SearchPage);
		
		reportLog("9.6: Dismiss Notifications if displayed");
		searchhappypath.dismissNotifications();

		
		reportLog("10.1: logout application");
		logoutPage = searchhappypath.logoutApplication();

		reportLog("10.2: Logging off from VIN is successful");
		logoutPage.verifyLogoutPageDisplayed();


	

	}
}

