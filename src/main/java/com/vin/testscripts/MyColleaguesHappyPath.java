package com.vin.testscripts;

import com.vin.pages.LoginPage;
import com.vin.pages.MyColleaguePage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.bcel.classfile.Constant;




public class MyColleaguesHappyPath extends BaseTest {
	private String SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName, parentwin, articletext;

	public MyColleaguesHappyPath() {
		super();
	}

	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());

		SecurityAnswerSecoreIDNumber = RegressionTestData.getProperty("SecurityAnswerSecoreIDNumber");
		SecurityAnswerMothersMaidenName = RegressionTestData.getProperty("SecurityAnswerMothersMaidenName");
	
//				setEnvironment = Configuration.readApplicationFile(targetEnvironment + "URL");

	}

	/**
	 * ====================================================================================================================
	 * Test Case Name: MyColleaguesHappyPath
	 * ====================================================================================================================
	 * @throws Exception 
	 * 
	 * @throws ParseException
	 */

	@Test
	public void myColleaguesSearch() throws Exception {

		reportLog("1.0: verify VIN Promo page is loaded ");
		promoPage.verifyPromoPage();
	
		reportLog("1.1:  go to https://beta.vin.com/Members/Tools/MyVIN/Default.aspx?View=Search");
		loginPage=promoPage.navigateToMyColleagueSearch();
		
		reportLog("1.2: verify VIN login page is loaded");
		loginPage.verifyUserLoginPage();
		
		reportLog("1.3: Call Login method");
		securityQuestionPage = loginPage.loginForMyColleague(UserID, UserPswrd);
		securityQuestionPage.verifySecurityQuestionPageDisplayed();
		myColleaguePage = securityQuestionPage.enterSecurityAnswerAndLogin(MyColleaguePage.class,
		SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName);
		
		reportLog("1.4: if alert notification displayed Dismiss Notification");
		myColleaguePage.dismissNotifications();
		
		reportLog("2.1: Verify User should see colleague search entry");
		myColleaguePage.verifyColleagueSearchEntry();
		
		reportLog("2.2: Verify Radio button All VINners is checked");
		myColleaguePage.verifyAllWinnersRadioButtonSelected();
		
		reportLog("2.3: Submit search no variables by clicking submit button");
		myColleaguePage.selectSearch();
		
		reportLog("2.4: Verify Error message modal 'Please enter a value in one of the search fields'");
		myColleaguePage.verifyErrorMessageDislpayed(Constants.ErrorMessage);
		
		reportLog("2.5: Enter 'Ava' in First Name field");
		myColleaguePage.enterNameInTheTextBox(Constants.firstName);
		
		reportLog("2.6: Verify user is able to enter the text");
		myColleaguePage.verifyUserIsAbleToEnterNameInTheFirstNameTextBox(Constants.firstName);
		
		reportLog("2.7: Enter 'Winters' in Last Name field");
		myColleaguePage.enterNameInTheLastNameTextBox(Constants.lastName);

		reportLog("2.8: Verify user is able to enter the text");
		myColleaguePage.verifyUserIsAbleToEnterNameInTheLastNameTextBox(Constants.lastName);

		reportLog("2.9: Submit Full Name Search by clicking submit button");
		myColleaguePage.selectSearch();

		reportLog("3.0: verify user should see search results 'Dr. Ava Winters'");
		myColleaguePage.verifyNameUnderSearchResultsSection(Constants.nameToBeVerified);

		reportLog("3.1: Verify message 'Search Results' popup ");
		myColleaguePage.verifyMessageSearchResultPopup();


		reportLog("4.0: Call logout method");
		myColleaguePage.clickLogout();

		reportLog("7.1 Verify logout ");
		myColleaguePage.verifyLogoutPageDisplayed();
		

	}
	
	/**
	 * ====================================================================================================================
	 * Test Case Name: MyColleague Search View Results
	 * ====================================================================================================================
	 * 
	 * @throws InterruptedException
	 * 
	 * @throws Exception
	 * 
	 * @throws ParseException
	 */
	@Test
	public void mYColleagueSearchViewResults() throws Exception {
		reportLog("1 Navigate to Colleague Search");
		loginPage=promoPage.verifyPromoPageForLogin(LoginPage.class);

		reportLog("1.1: Log in to the Portal ");
		securityQuestionPage = loginPage.loginForMyColleague(UserName_VINuser, Password_VINuser);

		reportLog("1.2: Verify Security Question Page displayed");
		securityQuestionPage.verifySecurityQuestionPageDisplayed();

		reportLog("1.3: Enter Security Answer and Login if Security Question Page displayed");
		myColleaguePage = securityQuestionPage.enterSecurityAnswerAndLogin(MyColleaguePage.class,
				SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName);


		reportLog("1.4 Dismiss Notifications");
		myColleaguePage.dismissNotifications();

		reportLog("1.5 Verify User should see colleague search entry");

		myColleaguePage.verifyColleagueSearchEntry();

		reportLog("2.1 Radio button All VINners");
		reportLog("2.2 Verify All VINners radio button is selected");
		myColleaguePage.verifyAllWinnersRadioButtonSelected();

		reportLog("3.1 Submit search no variables");
		myColleaguePage.selectSearch();

		reportLog("3.2 Verify Error message modal 'Please enter a value in one of the search fields'");
		myColleaguePage.verifyErrorMessageDislpayed(Constants.ErrorMessage);

		reportLog("4.1 Enter 'Ava'");
		myColleaguePage.enterNameInTheTextBox(Constants.firstName);

		reportLog("4.3 Verify user is able to enter the text");
		myColleaguePage.verifyUserIsAbleToEnterNameInTheFirstNameTextBox(Constants.firstName);

		reportLog("5.1 Enter 'Winters'");
		myColleaguePage.enterNameInTheLastNameTextBox(Constants.lastName);

		reportLog("5.2 Verify user is able to enter the text");
		myColleaguePage.verifyUserIsAbleToEnterNameInTheLastNameTextBox(Constants.lastName);

		reportLog("6.1 Submit Full Name Search");
		myColleaguePage.selectSearch();

		reportLog("6.2 verify  user should see search results 'Dr. Ava Winters'");
		myColleaguePage.verifyNameUnderSearchResultsSection(Constants.nameToBeVerified);

		reportLog("6.3 Verify modal 'Search Results'  | text 'Viewing 1 of 1 results'");
		myColleaguePage.verifyModalSearchResultsAndText(Constants.Viewing1Of1Results);
		
		reportLog("7.1 Submit view no selection");
		myColleaguePage.clickViewProfileButton();
		
		reportLog("7.2 Error message :: Verify modal 'Please select a colleague'");
		myColleaguePage.verifySelectAColleagueErrorMEssage(Constants.errorMessageForSelectingAColleague);
		
		reportLog("8.1 Select 'Ava Winters''");
		myColleaguePage.selectNameFromTheTextBox();
		
		reportLog("8.2  Verify user should see 'Dr. Ava Winters' highlighted");
		myColleaguePage.verifyNameIsHighlighted(Constants.highlightColor);
		
		reportLog("9.1 View Profile 'Ava Winters' ");
		myColleaguePage.clickViewProfileButton();
		
		/*Previously navigating to alpha url*/
		
		reportLog("9.2 verify browser url ");
		myColleaguePage.verifyBroswerUrl(Constants.UrlForViewProfile);
		
		reportLog("9.3 verify VINners Profile - Ava Winters");
		myColleaguePage.verifyProfile(Constants.AvaWintersProfile);
		
		reportLog("10.1 logout application");
		myColleaguePage.clickLogout();

		reportLog("10.2 Verify logout ");
		myColleaguePage.verifyLogoutPageDisplayed();
		

		
	}
}
