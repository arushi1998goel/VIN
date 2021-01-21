package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.NewsPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class eVetSitesHappyPath extends BaseTest{
	public eVetSitesHappyPath() {
		super();
	}
		/**
		 * ====================================================================================================================
		 * Test Case Name: eVetSitesHappyPathextends
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
		public void eVetSitesHappyPathextends() throws Exception{
			
			reportLog("1.1: Navigate to eVetSites https://www.evetsites.com/");
			newsPage=promoPage.navigateToGivenURL(NewsPage.class,Constants.eVetSitesURL);

			reportLog("2.1: Click 'Sign Up Now' from the top of the page");
			newsPage.clickOnSignUpButton();
	        String parentWindow = switchToChildWindow();

			reportLog("2.2: Verify 'Sign Up Now' page loads successfully");
			newsPage.verifyPageTitle(Constants.signUpeVetTitle);

			reportLog("2.3: Select X to close the 'Sign Up Now' page");
	        switchParentWindowByClosingChild(parentWindow);

			reportLog("3.1: Select the 'About' drop down");
			newsPage.selectAboutDropDown();
			
			reportLog("3.2: From the drop down select 'About EVetSites'");
			newsPage.selectEvetSiteFromAboutDropDown();
			
			reportLog("3.3: Verify the 'About EVetSites' page loads successfully");
			newsPage.verifyPageTitle(Constants.eVetSiteTitle);

			reportLog("4.1: On the search bar enter 'Web Hosting'");
			newsPage.inputIntoSearchField();
			
	    	reportLog("4.2: Click on an article link");
	    	newsPage.selectArticleLink();
	    	
			reportLog("4.3: Verify the selected article loads successfully");
			newsPage.verifyPageTitle(Constants.domainTitle);

			reportLog("5.1: Select the Facebook icon");
			newsPage.selectFacebookButton();
			switchToChildWindow();

		    reportLog("5.2: Verify the Facebook page loads successfully");
			newsPage.verifyPageTitle(Constants.evetSiteFacebbokTitle);

			reportLog("5.3: Select X to close the Facebook page");
	        switchParentWindowByClosingChild(parentWindow);

		}
}
