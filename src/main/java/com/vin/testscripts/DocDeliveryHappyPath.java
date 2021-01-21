package com.vin.testscripts;

import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.FrontPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class DocDeliveryHappyPath extends BaseTest {

	private String parentwin, parentWindow,myVinWindow, preferenceWindow;
    private List<String> multipleWindows;
    
	public DocDeliveryHappyPath() {

		super();
	}
	
	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());
		
	}


	/**
	 * ====================================================================================================================
	 * Test Case Name: DiscussionViewerHappyPath
	 * ====================================================================================================================
	 * @throws Exception
	 * 
	 * @throws ParseException
	 */
	
	@Test
	public void verifyDocDeliveryHappyPath() throws Exception {
		

		reportLog("1.1: Navigate to https://www.vin.com");
		promoPage.verifyPromoPage();
		loginPage = promoPage.clickOnLoginButton();
		loginPage.verifyUserLoginPage();
		frontPage=loginPage.loginInApplication(FrontPage.class,UserID, UserPswrd);
		frontPage.dismissNotifications();
		
		reportLog("1.2: Select 'Search' from the navigation menu");
        searchPage = frontPage.clickOnSearchButton();

		reportLog("1.3: Dismiss Alert Notifications if displayed by clicking on 'X' on the Alert Notification");
		searchPage.dismissNotifications();

		reportLog("2.1: Enter 'Taurine' in the search text field");
        searchPage.searchTermInTheSearchBox(Constants.TextTaurine);

		reportLog("2.2: User should see a drop down list");
		searchPage.verifyDropDownListIsDisplayed(Constants.TextTaurine);
		
		reportLog("2.3: From the drop down list select 'Taurine'");
		searchPage.selectTaurineInSearchList();
		
		reportLog("2.4: Verify page refreshes and displays search results");
		searchPage.verifySearchResultIsDisplayed();
		
		reportLog("2.5: Dismiss Alert Notifications if displayed by clicking on 'X' on the Alert Notification");
		searchPage.dismissNotifications();

		reportLog("2.6: Select the 'Journals' radio button under 'Filter by Sources'");
		searchPage.selectRadioButtonUnderFilterBySources(Constants.journalsText);
		
		reportLog("2.7: Verify the page refreshes and displays a list of search results");
		searchPage.verifyListOfSearchResltIsDisplayed();
		
		reportLog("2.8: Dismiss Alert Notifications if displayed by clicking on 'X' on the Alert Notification");
		searchPage.dismissNotifications();

		reportLog("2.9: Select the first link that DOES NOT have 'Full Free Text' next to it (NOTE: If needed select 'NEXT' on the results page until a link without 'Full Free Text' is displayed)");
		searchPage.selectTheFirstLinkWhichDoesNotHaveFullFreeText();
		switchToChildWindow();
		
		reportLog("2.10: Verify a new tab loads successfully");
		searchPage.verifyNewTabLoadSuccessfully();
		
		reportLog("2.11: Dismiss Alert Notifications if displayed by clicking on 'X' on the Alert Notification");
		searchPage.dismissNotifications();

		reportLog("3.1: Select 'Order This Article' under 'Article Tools'");
		searchPage.selectOrderThisArticle();
		multipleWindows = getAllWindowsOpenInUI();
		parentWindow = multipleWindows.get(0);
		myVinWindow = multipleWindows.get(1);
		preferenceWindow = multipleWindows.get(2);
				
		switchToWindowWithBrowser(preferenceWindow); 
		
		reportLog("3.2: User should be navigated Doc Delivery Request Form page");
		searchPage.verifyUserIsNavigatedToDocDeliveryRequestFormPage();
		
		reportLog("3.3: Dismiss Alert Notifications if displayed by clicking on 'X' on the Alert Notification");
		searchPage.dismissNotifications();

		reportLog("4.1: Verify '777 W Covell Blvd' is populated on the 'Street Address' text box");
		searchPage.verifyStreetAddress(Constants.covellBlvdAddress);
		
		reportLog("4.2: Verify 'Davis' is populated on the 'City' text box");
		searchPage.verifyEnteredCity(Constants.DavisText);
		
		reportLog("4.3: Verify 'California' is populated on the 'State' text box");
		searchPage.verifyStateSelection(Constants.californiaState);

		reportLog("4.4: Verify 'USA' is populated on the 'Country' text box");
		searchPage.verifyCountrySelection(Constants.countryText);
		
		reportLog("4.5: Verify '95616' is populated on the 'Postal/Zip code' text box");
		searchPage.verifyEnteredZipCode(Constants.zipCodeText);
		
		reportLog("4.6: Verify '(800)700-4636' is populated on the 'Phone' text box");
		searchPage.verifyEnteredPhoneNumber(Constants.phone);

		reportLog("4.7: Verify 'selenium@vin.com' is populated on the 'Email Address' text box");
		searchPage.verifyEnteredEmail(Constants.Email);

		reportLog("5.1: Select the 'Front Page' link on the top right of page");
		frontPage=searchPage.clickONFrontPageButton();
		
		reportLog("5.2: Verify page loads successfully");
		frontPage.verifyFrontPageDisplayed();
		
		reportLog("5.3: Dismiss Alert Notifications if displayed by clicking on 'X' on the Alert Notification");
		frontPage.dismissNotifications();

		reportLog("6.1: Call Logout Method");
		logoutPage=frontPage.logoutApplication();
	    logoutPage.verifyLogoutPageDisplayed();



}
}
