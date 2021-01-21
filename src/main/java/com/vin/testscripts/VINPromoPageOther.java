package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

	public class VINPromoPageOther extends BaseTest {
		
        public VINPromoPageOther() {
			super();
		}
		
		@BeforeMethod
		public void getTestData() throws Exception {
			System.setProperty("className", getClass().getSimpleName());
			}


		/**
		 * ====================================================================================================================
		 * Test Case Name: VINPromoPageOther
		 * ====================================================================================================================
		 * 
		 * @throws Exception
		 * 
		 * 
		 */
		
		
		@Test
		public void VINPromoPageOther() throws Exception {
			
			reportLog("1.1: Bringing up VIN page");
			promoPage.verifyPromoPage();
			
			reportLog("2.1: Select the 'Join' button");
			promoPage.clickONJoinButton();
	        String parentWindow = switchToChildWindow();

			reportLog("2.2: Close the 'Join' window");
	        switchParentWindowByClosingChild(parentWindow);

            reportLog("3.1: Select the 'CE Portal'");
			promoPage.clickONCEPortalButton();

			reportLog("3.2: Select the 'VIN' logo");
			promoPage.clickONVINLogo();

			reportLog("4.1: Select the 'Login' button");
			promoPage.clickOnLoginButton();

			reportLog("5.1: Select the back button to return to the VIN Promo page");
			promoPage.navigateBack();
			
			reportLog("6.1: Select the 'Forgot your Password?' link.");
			promoPage.clickONForgotPasswordLink();

			reportLog("6.2: Verify 'Forgot Password' window loads successfully");
			switchToChildWindow();
			promoPage.verifyPageTitle(Constants.forgotPasswordPageTitle);

			reportLog("6.3: Close the 'Forgot Password' window");
	        switchParentWindowByClosingChild(parentWindow);
	        
			reportLog("7.1: Select the 'ADA' button");
			promoPage.clickONADAButton();

			reportLog("7.2: Verify the 'ADA' menu is displayed");
			promoPage.verifyADADrawerDisplayed();

			reportLog("7.3: Select 'A-'");
			promoPage.selectZoomInButton();

			reportLog("7.4: Select 'A+'");
			promoPage.selectZoomOutButton(); 

			reportLog("7.5: Select 'Readable Font'");
			promoPage.selectADAButtons(Constants.readableFont);

			reportLog("7.6: Verify the font on the page changes");
			promoPage.verifyChangeOfThePage(Constants.arialFontOn);

			reportLog("7.7: Select 'Underline Links'");
			promoPage.selectADAButtons(Constants.underlineLinks);

			reportLog("7.8: Verify links on the page have an line underneath");
			promoPage.verifyChangeOfThePage(Constants.underline);
			
			reportLog("7.9: Select 'Greyscale page'");
			promoPage.selectADAButtons(Constants.grayscalePage);

			reportLog("7.10: Verify page is displayed in Greyscale");
			promoPage.verifyChangeOfThePage(Constants.ActiveGreyscale);

			reportLog("7.11: Select 'Greyscale page'");
			promoPage.selectADAButtons(Constants.grayscalePage);

			reportLog("7.12: Verify page is no longer displayed in Greyscale");
			promoPage.verifyChangesAreNotDisplayed(Constants.ActiveGreyscale);
			
     		reportLog("7.13: Select 'Invert Colors'");
            promoPage.selectADAButtons(Constants.invertColors);

	    	reportLog("7.14: Verify the colors on the page are displayed inverted");
		    promoPage.verifyChangeOfThePage(Constants.ActiveInvertMode);

			reportLog("7.15: Select 'Invert Colors'");
			promoPage.selectADAButtons(Constants.invertColors);
			
			reportLog("7.16: Verify the colors on the page are no longer displayed inverted");
			promoPage.verifyChangesAreNotDisplayed(Constants.ActiveInvertMode);
			
			reportLog("7.17: Select 'Reset Settings'");
			promoPage.clickOnResetSetting();

			reportLog("7.18: Select the 'ADA' button");
			promoPage.clickONADAButton();

			reportLog("7.19: Verify the 'ADA' menu is no longer displayed");
			promoPage.verifyADADrawerIsNotDisplayed(Constants.drawerValue);

			reportLog("8.1: Select the 'Help' button on the side next to the scroll bar");
			promoPage.selectHelpButton();
			
		    reportLog("8.2: If 'Chat with Us' IS displaying proceed to 8.3. If Chat with Us IS NOT displaying select the '-' button to minimize the 'Chat with us' window and do not proceed to 8.3");
			reportLog("8.3 Under the 'Name' text field, type 'Selenium'");
			reportLog("8.4: Under the 'Email' text field, type 'selenium@vin.com'");
		  //reportLog("8.5: Under the 'Department' drop down option, select 'Membership_Support (offline)'");
		    reportLog("8.6: Under the 'Message:', type 'This is a Test'");
			reportLog("8.7: Select the '-' button to minimize the 'Chat with us' window");
            promoPage.verifyChatWithUsWindow();
		   






			
}
		
	}
