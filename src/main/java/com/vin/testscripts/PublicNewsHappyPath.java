package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.NewsPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class PublicNewsHappyPath extends BaseTest{
	public PublicNewsHappyPath() {
		super();
	}
		/**
		 * ====================================================================================================================
		 * Test Case Name: PublicNewsHappyPath
		 * ====================================================================================================================
		 * 
		 * @throws Exception
		 * 
		 * 
		 */
		@BeforeMethod
		public void getTestData() throws Exception {

			System.setProperty("className", getClass().getSimpleName());

			

		}
		@Test
		public void PublicNewsHappyPath() throws Exception{
			
			reportLog("1.1: Navigate to VIN News Service http://news.vin.com/ ");
			newsPage=promoPage.navigateToGivenURL(NewsPage.class,Constants.newsUrl );
			
			reportLog("2.1: Click 'Read Article' from the rotating banner on the top ");
			reportLog("2.2: Verify selected article loads successfully ");
		    newsPage.clickOnReadArticleLinkAndVerifySelectedAricleIsDisplayed();

			reportLog("3.1: Enter 'covid-19' in 'Search VIN News Service' search box and select 'Go'");
			newsPage.TypeAVMAOnTheTextBoxUnderSearchVINNewsService(Constants.covidText);
			newsPage.clickOnGoButton();

			reportLog("3.2: Select an article link.");
			newsPage.clickOnFirstArticleLink();

			reportLog("3.3: Verify selected article loads successfully");
			newsPage.verifyPageTitle(Constants.articalTitle);

			reportLog("4.1: Select the VIN News Service button");
			newsPage.navigateBack();

			reportLog("4.2: Verify VIN News Service front page loads successfully");
			newsPage.verifyUserISLandedBackToLatestNewsPage();

			reportLog("5.1: Select 'Tweet' button");
			newsPage.selectTweetButton();
	        String parentWindow = switchToChildWindow();

	        reportLog("5.2: Verify VIN News Service Twitter page loads successfully");
			newsPage.verifyPageTitle(Constants.twitterTitle);
			
			reportLog("5.3: Select X to close the twitter window");
	        switchParentWindowByClosingChild(parentWindow);

			reportLog("6.1: Select 'Facebook' button");
			newsPage.selectFacebookButton();
			switchToChildWindow();

			reportLog("6.2: Verify VIN News Service Facebook page loads successfully");
			newsPage.verifyPageTitle(Constants.facebookTitle);

			reportLog("6.3: Select X to close the Facebook window");
	        switchParentWindowByClosingChild(parentWindow);
            
			reportLog("7.1: Select the 'Subscribe (email icon)' button");
			newsPage.selectEmailButton();
			switchToChildWindow();

			reportLog("7.2: Verify the 'Sign Up For VIN News Article Alerts' window opens successfully");
			newsPage.verifyPageTitle(Constants.signUpTitle);

			reportLog("7.3: Enter 'Selenium@VIN.com' under the Email Address text field");
			newsPage.inputEmailInEmailField();
			
			reportLog("7.4: Enter 'Selenium' under the First Name text field");
			newsPage.inputFirstNameInNameField();
			
			reportLog("7.5: Enter 'User' under the Last Name text field");
			newsPage.inputLastNameInNameField();
			
			reportLog("7.6: Select 'Plain-Text' under Preferred Format");
			newsPage.selectPlainTextRadioButton();

			reportLog("7.7: Select X to close the 'Sign Up For VIN News Article Alerts' window");
	        switchParentWindowByClosingChild(parentWindow);

			
}
	}
