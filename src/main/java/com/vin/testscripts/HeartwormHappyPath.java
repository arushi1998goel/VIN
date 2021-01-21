package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.CalculatorPage;
import com.vin.selenium.core.BaseTest;

public class HeartwormHappyPath extends BaseTest{
	 public HeartwormHappyPath() {
			super();
		}
		
		@BeforeMethod
		public void getTestData() throws Exception {
			System.setProperty("className", getClass().getSimpleName());
			}


		/**
		 * ====================================================================================================================
		 * Test Case Name: HeartwormHappyPath
		 * ====================================================================================================================
		 * 
		 * @throws Exception
		 * 
		 * 
		 */
		
		
		@Test
		public void HeartwormHappyPath() throws Exception {
			
			reportLog("1: Bringing up VIN page");
			promoPage.verifyPromoPage();
			
			reportLog("1.1: Go to https://www.vin.com/members/cms/project/defaultadv1.aspx?pid=618&id=7134221");
			loginPage=promoPage.navigateToHeartwormHappyPath();
			
			reportLog("1.2: Call login script");
			loginPage.verifyUserLoginPage();

			reportLog("1.3: User should be directed to Heartworm calculator");
			calculatorpage=loginPage.loginInApplication(CalculatorPage.class,UserID, UserPswrd);

			reportLog("1.4: Dismiss Alert Notification if displayed");
		    calculatorpage.dismissNotifications();
            
			reportLog("1.5: Select date 30 days prior to today");
			calculatorpage.selectpriorDate();
			
			reportLog("1.6: Verify user is able to select date");
			calculatorpage.verifyUserIsAbleToSelectDate(); 

			reportLog("2.1: Select current days date");
			calculatorpage.selectCurrentDateInpositivetest();

			reportLog("2.2: Verify user is able to select current days date");
			calculatorpage.verifyUserIsAbleToSelectpositiveTestDate(); 

			reportLog("3.1: Select calculate");
			calculatorpage.selectCalculatebutton();

			reportLog("3.2: Verify results are calculated below");
			calculatorpage.verifyResultAreaDisplayed();
			
			reportLog("4.1: Select reset");
			calculatorpage.selectreset();
			
			reportLog("4.2: Verify user is able to select reset and results are cleared");
			calculatorpage.verifyResultIsReset();

			reportLog("4.3: Call logout script");
			logoutPage=calculatorpage.logoutApplication();
		    logoutPage.verifyLogoutPageDisplayed();


}
}
