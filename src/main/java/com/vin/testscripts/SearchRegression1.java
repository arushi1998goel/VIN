package com.vin.testscripts;

import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.FrontPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class SearchRegression1 extends BaseTest {

	private String parentwin, parentWindow,myVinWindow, preferenceWindow;
    private List<String> multipleWindows;
    
	public SearchRegression1() {

		super();
	}
	
	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());
		
	}


	/**
	 * ====================================================================================================================
	 * Test Case Name: SearchRegression1
	 * ====================================================================================================================
	 * @throws Exception
	 * 
	 * @throws ParseException
	 */
	
	@Test
	public void verifySearchRegression1() throws Exception {
		

		reportLog("1.1: Navigate to https://www.vin.com");
		promoPage.verifyPromoPage();
		
		reportLog("1.2: Call Login method");
		loginPage = promoPage.clickOnLoginButton();
		loginPage.verifyUserLoginPage();
		frontPage=loginPage.loginInApplication(FrontPage.class,UserID, UserPswrd);
		
		reportLog("1.3: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();


		reportLog("2.1: Select 'Search' from the navigation menu");
        searchPage = frontPage.clickOnSearchButton();

		reportLog("2.2: Dismiss Alert Notifications if displayed");
		searchPage.dismissNotifications();
		
		reportLog("2.3: Verify Search page is displayed");
		searchPage.verifySearchPageDisplayed();
		
		reportLog("2.4: Enter 'Taurine' in the search field");
        searchPage.searchTermInTheSearchBox(Constants.TextTaurine);

		reportLog("2.5: Click on Search icon");
        searchPage.clickOnSearchButton();

		reportLog("2.6: Verify page reloads and displays results");
		searchPage.verifySearchResultIsDisplayed();

		reportLog("2.7: Dismiss Alert Notifications if displayed");
		searchPage.dismissNotifications();

		reportLog("2.8: Select the 'Clear' button");
		searchPage.clickOnClearButton();
		
		reportLog("2.9: Verify the page reloads and the results have been cleared");
        searchPage.verifySearchFilterIsNotApplied();

		reportLog("2.10: Dismiss Alert Notifications if displayed");
		searchPage.dismissNotifications();


		reportLog("3.1: Enter 'Tau' in the search field");
        searchPage.searchTermInTheSearchBox(Constants.TextTau);

		reportLog("3.2: Verify that a drop down menu appears with a list of suggested search terms");
		searchPage.verifyDropDownListIsDisplayed(Constants.TextTau);

		reportLog("3.3: Select 'Taurine Deficiency' from the drop down list");
		searchPage.selectTaurineDeficiency(Constants.TextDeficiency);
		
		reportLog("3.4: Verify that the page reloads and displays the results for 'Taurine Deficiency'");
		searchPage.VerifyTheResultOfSearchText(Constants.TextDeficiency);

		reportLog("3.5: Dismiss Alert Notifications if displayed");
		searchPage.dismissNotifications();

		reportLog("3.6: Select the 'Clear' button");
		searchPage.clickOnClearButton();

		reportLog("3.7: Verify the page reloads and the results have been cleared");
        searchPage.verifySearchFilterIsNotApplied();

		reportLog("3.8: Dismiss Alert Notifications if displayed");
		searchPage.dismissNotifications();

		reportLog("4.1: Enter 'Tarine' in the search field and hit enter on your keyboard");
        searchPage.searchTermInTheSearchBox(Constants.TextTarine);
        searchPage.clickEnter();

		reportLog("4.2: Verify page reloads and displays results");
		searchPage.verifySearchResultIsDisplayed();

	    reportLog("4.3: Dismiss Alert Notifications if displayed");
		searchPage.dismissNotifications();

	    reportLog("4.4: Verify a 'Warning: You May Have Spelling Errors' text box is displayed under the search field");
	    searchPage.verifyWarningIsDisplayed();
	    
	    reportLog("4.5: From the 'Warning' text box, select 'Tacrine'");
	    searchPage.selectButtonsInWarningBox(Constants.Texttacrine);
	    
	    reportLog("4.6: Verify that the page reloads and displays the results for 'Tacrine'");
		searchPage.VerifyTheResultOfSearchText(Constants.ResultTacrine);

	    reportLog("4.7: Dismiss Alert Notifications if displayed");
		searchPage.dismissNotifications();

	    reportLog("4.8: Select the 'Clear' button");
		searchPage.clickOnClearButton();

	    reportLog("4.9 Dismiss Alert Notifications if displayed");
		searchPage.dismissNotifications();

	    reportLog("5.1: Enter 'Tarine' in the search field and hit enter on your keyboard");
	    searchPage.searchTermInTheSearchBox(Constants.TextTarine);
        searchPage.clickEnter();
        
	    reportLog("5.2: Verify page reloads and displays results");
		searchPage.verifySearchResultIsDisplayed();

	    reportLog("5.3: Dismiss Alert Notifications if displayed");
		searchPage.dismissNotifications();

	    reportLog("5.4: Verify a 'Warning: You May Have Spelling Errors' text box is displayed under the search field");
	    searchPage.verifyWarningIsDisplayed();

	    reportLog("5.5: From the 'Warning' text box, select 'Taurine'");
	    searchPage.selectButtonsInWarningBox(Constants.Texttaurine);

	    reportLog("5.6: Verify that the page reloads and displays the results for 'Taurine'");
		searchPage.VerifyTheResultOfSearchText(Constants.TextTaurine);

	    reportLog("5.7: Dismiss Alert Notifications if displayed");
		searchPage.dismissNotifications();

	    reportLog("5.8: Select the 'Clear' button");
		searchPage.clickOnClearButton();

	    reportLog("5.9: Dismiss Alert Notifications if displayed");
		searchPage.dismissNotifications();

			 

	    reportLog("6.1: Enter 'Tarine' in the search field and hit enter on your keyboard");
	    searchPage.searchTermInTheSearchBox(Constants.TextTarine);
        searchPage.clickEnter();
        
	    reportLog("6.2: Verify page reloads and displays results");
		searchPage.verifySearchResultIsDisplayed();

	    reportLog("6.3: Dismiss Alert Notifications if displayed");
		searchPage.dismissNotifications();

	    reportLog("6.4: Verify a 'Warning: You May Have Spelling Errors' text box is displayed under the search field");
	    searchPage.verifyWarningIsDisplayed();

	    reportLog("6.5: From the 'Warning' text box, select 'Taruine'");
	    searchPage.selectButtonsInWarningBox(Constants.Texttaruine);

	    reportLog("6.6: Verify that the page reloads and displays the results for 'Taruine'");
		searchPage.verifySearchResultIsDisplayed();

	    reportLog("6.7: Dismiss Alert Notifications if displayed");
		searchPage.dismissNotifications();

	    reportLog("6.8: Select the 'Clear' button");
		searchPage.clickOnClearButton();

	    reportLog("6.9: Dismiss Alert Notifications if displayed");
		searchPage.dismissNotifications();

			 

	    reportLog("7.1: Enter 'Tarine' in the search field and hit enter on your keyboard");
	    searchPage.searchTermInTheSearchBox(Constants.TextTarine);
        searchPage.clickEnter();
        
	    reportLog("7.2: Verify page reloads and displays results");
		searchPage.verifySearchResultIsDisplayed();

	    reportLog("7.3: Dismiss Alert Notifications if displayed");
		searchPage.dismissNotifications();

	    reportLog("7.4: Verify a 'Warning: You May Have Spelling Errors' text box is displayed under the search field");
	    searchPage.verifyWarningIsDisplayed();

	    reportLog("7.5: From the 'Warning' text box, select 'More Suggestions'");
	    searchPage.selectMoreSuggestion();
	    
	    reportLog("7.6: Under 'More Suggestions', select 'Taine'");
	    searchPage.selectAnyItemFromMoreSuggestionList(Constants.TextTaine);
	    
	    reportLog("7.7: Verify that the page reloads and displays the results for 'Taine'");
		searchPage.verifySearchResultIsDisplayed();

	    reportLog("7.8: Dismiss Alert Notifications if displayed");
		searchPage.dismissNotifications();

	    reportLog("7.9: Select the 'Clear' button");
		searchPage.clickOnClearButton();

	    reportLog("7.10: Dismiss Alert Notifications if displayed");
		searchPage.dismissNotifications();

	    reportLog("8.1: Enter 'Tarine' in the search field and hit enter on your keyboard");
	    searchPage.searchTermInTheSearchBox(Constants.TextTarine);
        searchPage.clickEnter();
        
	    reportLog("8.2: Verify page reloads and displays results");
		searchPage.verifySearchResultIsDisplayed();

	    reportLog("8.3: Dismiss Alert Notifications if displayed");
		searchPage.dismissNotifications();

	    reportLog("8.4: Verify a 'Warning: You May Have Spelling Errors' text box is displayed under the search field");
	    searchPage.verifyWarningIsDisplayed();

	    reportLog("8.5: From the 'Warning' text box, select 'Ignore'");
	    searchPage.selectButtonsInWarningBox(Constants.TextIgnore);

	    reportLog("8.6: Verify page reloads and the 'Warning' text box is no longer displayed");
	   searchPage.verifyWarningIsNotDisplayed();
	    
	    reportLog("8.7: Select the 'Clear' button");
		searchPage.clickOnClearButton();

	    reportLog("8.8: Dismiss Alert Notifications if displayed");
		searchPage.dismissNotifications();

			 
	    reportLog("9.1: Enter 'Physiologic Stress Parameters in Cats and Using Gabapentin to Facilitate Veterinary Visits' in the search field");
	    searchPage.searchTermInTheSearchBox(Constants.TextPhysiologic);
        searchPage.clickEnter();
        
	    reportLog("9.2: Verify page reloads and displays results");
		searchPage.verifySearchResultIsDisplayed();

	    reportLog("9.3: Select the 'Match ALL Terms' link under the search field");
	    searchPage.selectMatchAllTerms();
	    
	    reportLog("9.4: Verify page reloads and 'Match All Terms' filter is displayed under the search field");
	    searchPage.verifyMatchAllTermsFilterIsDisplayed(Constants.TextMatchAll);
	    
	    reportLog("9.5: Select the 'Clear' button");
		searchPage.clickOnClearButton();

	    reportLog("9.6: Dismiss Alert Notifications if displayed");
		searchPage.dismissNotifications();
			 
	    reportLog("10.1: Enter 'Taurine' in the 'Search' field");
	    searchPage.searchTermInTheSearchBox(Constants.TextTaurine);
        searchPage.clickEnter();

	    reportLog("10.2: Verify page reloads and displays results");
		searchPage.verifySearchResultIsDisplayed();
		
	    reportLog("10.3: Dismiss Alert Notifications if displayed");
		searchPage.dismissNotifications();

	    reportLog("10.4: Select 'Copy to Clipboard' link");
	    searchPage.selectCopyToClipboard();
	    
	    reportLog("10.5: Verify small pop up that reads 'The item was successfully copied to the clipboard' is displayed");
	    searchPage.verifySmallCopyToClipboardPopUpIsDisplayed();
	    
	    reportLog("10.6: Select 'Next'");
	    searchPage.selectPageselectionsButtons(Constants.TextNext);
	    
	    reportLog("10.7  Dismiss Alert Notifications if displayed");
		searchPage.dismissNotifications();

	    reportLog("10.8: Verify page reloads and displays results for page #2");
	    searchPage.varifyResultIsDisplayedForSelecedPage(Constants.Text2650);
	    
	    reportLog("10.9: Select 'Prev'");
	    searchPage.selectPageselectionsButtons(Constants.TextPrev);

	    reportLog("10.10:  Dismiss Alert Notifications if displayed");
		searchPage.dismissNotifications();

	    reportLog("10.11: Verify page reloads and displays results for page # 1");
	    searchPage.varifyResultIsDisplayedForSelecedPage(Constants.Text125);

	    reportLog("10.12: Select 'Last'");
	    searchPage.selectPageselectionsButtons(Constants.TextLast);

	    reportLog("10.13  Dismiss Alert Notifications if displayed");
		searchPage.dismissNotifications();

	    reportLog("10.14: Verify page reloads and displays results");
	    searchPage.varifyPageIsDisplayed(Constants.TextLast);
	    
	    reportLog("10.15: Select 'First'");
	    searchPage.selectPageselectionsButtons(Constants.TextFirst);

	    reportLog("10.16  Dismiss Alert Notifications if displayed");
		searchPage.dismissNotifications();

	    reportLog("10.17: Verify page reloads and displays results");
	    searchPage.varifyPageIsDisplayed(Constants.TextFirst);

	    reportLog("10.18: Enter '10' in the text field next to 'Jump to Page'");
	    searchPage.inputTextToJumpOnOtherPage(Constants.Number10);
	    
	    reportLog("10.19: Select 'Jump'");
	    searchPage.clickOnJumpButton();
	    
	    reportLog("10.20: Dismiss Alert Notifications if displayed");
		searchPage.dismissNotifications();

	    reportLog("10.21: Verify page reloads and displays results");
	    searchPage.verifyResultIsDisplayedAsPerSearchWithJumpToPage(Constants.value10);
	    
	    reportLog("10.22: Select the 'Clear' button");
		searchPage.clickOnClearButton();

	    reportLog("10.23  Dismiss Alert Notifications if displayed");
		searchPage.dismissNotifications();

	    reportLog("11.1: Select the 'Search' button without entering a search term");
        searchPage.clickOnSearchButton();

	    reportLog("11.2: Verify a 'Please enter a search term in the search box' pop up window is displayed");
	    searchPage.verifyVerifyEnterSearchItemIsDisplayed();
	    
	    reportLog("11.3: Close the pop up window by selecting the 'Close' button");
	    searchPage.clickOnCloseForErrorPopup();

	    reportLog("12.1: Call Logout method");
        logoutPage = searchPage.logoutApplication();
        logoutPage.verifyLogoutPageDisplayed();


}
}