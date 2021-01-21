package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.vin.pages.VINxPage;

import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class VINxHappyPath extends BaseTest{
	public VINxHappyPath() {
		super();
	}
		/**
		 * ====================================================================================================================
		 * Test Case Name: VINxHappyPath
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
		public void VINxHappyPath() throws Exception{
			
			reportLog("1.1: Navigate to VINx https://www.vin.com/vinx/");
			vinXPage=promoPage.navigateToGivenURL( VINxPage.class,Constants.VINxURL);

			reportLog("	1.2: Select the 'Features' drop down");
			vinXPage.hoverOnNavigateDropDown(Constants.featureText);
			
			reportLog("	1.3: Select 'VetTools Buddy' from the drop down");
			vinXPage.clickOnNavigateItems(Constants.vetToolsText);

			reportLog("	1.4: Verify the 'VetTools Buddy' pages loads successfully");
			vinXPage.verifyThePagetitle(Constants.vetToolBuddyTitle);
			
			reportLog("	2.5: Select the 'Add-On Services' drop down");
			vinXPage.hoverOnNavigateDropDown(Constants.addOnServicesText);

			reportLog("	2.2: Select 'Add-On Services Overview'");
			vinXPage.clickOnNavigateItems(Constants.overviewText);

			reportLog("2.3: Verify the 'Add-On Services' page loads successfully");
			vinXPage.verifyThePagetitle(Constants.AddonServiceTitle);

			reportLog("3.1: Select the 'FAQs' button from the navigation menu");
			vinXPage.clickOnNavigateItems(Constants.fAQText);

			reportLog("3.2: Verify the 'Frequently Asked Questions' page loads successfully");
			vinXPage.verifyThePagetitle(Constants.FAQTitle);

			reportLog("3.3: Scroll down and select the arrow button next to 'How often will you sync my data?'");
			vinXPage.scrollDownAndclickOnArrowButton(Constants.arrowtext);
			
			reportLog("3.4: Verify the section under 'How often will you sync my data?' is expanded");
			vinXPage.verifyPanelIsExpended();
			
			reportLog("4.1: Select 'Our Story' from the navigation menu");
			vinXPage.clickOnNavigateItems(Constants.storyText);

			reportLog("4.2: Verify the 'Our Story' page loads successfully");
			vinXPage.verifyThePagetitle(Constants.OurStoryTitle);

			reportLog("5.1: Scroll up and click the 'VetTools a Product of VINx' button");
			vinXPage.clickOnVetToolLogo();
			
		}
		}
