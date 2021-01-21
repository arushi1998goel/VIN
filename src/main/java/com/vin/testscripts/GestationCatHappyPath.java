package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.CalculatorPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class GestationCatHappyPath extends BaseTest {

	public GestationCatHappyPath() {
		super();
	}
	/**
	 * ====================================================================================================================
	 * Test Case Name: Gestation Cat Happy Path
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
	public void GestationCatHappyPath() throws Exception{
		
		reportLog("1: Vin page loaded ");
		promoPage.verifyPromoPage();
		
		reportLog("1.1: Navigate to:  https://www.vin.com/members/cms/project/defaultadv1.aspx?pid=618&id=8965152");
		loginPage=promoPage.GestationCalculatorHappyPath();
		
		reportLog("1.2: Call login script");
		loginPage.verifyUserLoginPage();
		
		reportLog("1.3: User should be directed to GestationCalculator");
		calculatorpage=loginPage.loginInApplication(CalculatorPage.class,UserID, UserPswrd);

		reportLog("1.4: Dismiss Alert Notification if displayed");
	    calculatorpage.dismissNotifications();
	    
	    reportLog("2.1: Select cat from species drop down");
	    calculatorpage.selectGestationSpecies(Constants.CatSpecies);
	    
	    reportLog("2.2: Verify user is able to select species");
	    calculatorpage.verifyGestationSpeciesDropDown(Constants.CatSpecies);

	    reportLog("3.1: Select date in calendar");
	    calculatorpage.selectDateFromCalender();

	    reportLog("3.2: Verify user is able to select date");
	    calculatorpage.verifyuserIsAbleToSelectTheDate();

	    reportLog("4.1: Select Calculate");
	    calculatorpage.selectCalculatebutton();
	    
	    reportLog("4.2: Verify user is able to select calculate and results are calculated below");
	    calculatorpage.verifyuserIsAbleToCalculate();

	    reportLog("4.3: Select Reset");
	    calculatorpage.selectreset();

	    reportLog("5.1: Dismiss Alert Notification if displayed");
	    calculatorpage.dismissNotifications();

	    reportLog("5.2: Select pig from species drop down");
	    calculatorpage.selectGestationSpecies(Constants.PigSpecies);

	    reportLog("5.3: Verify user is able to select species");
	    calculatorpage.verifyGestationSpeciesDropDown(Constants.PigSpecies);

	    reportLog("6.1: Select date in calendar");
	    calculatorpage.selectDateFromCalender();

	    reportLog("6.2: Verify user is able to select date");
	    calculatorpage.verifyuserIsAbleToSelectTheDate();

	    reportLog("7.1: Select Calculate");
	    calculatorpage.selectCalculatebutton();

	    reportLog("7.2: Verify user is able to select calculate and results are calculated below");
	    calculatorpage.verifyuserIsAbleToCalculate();

	    reportLog("7.3: Select Reset");
	    calculatorpage.selectreset();

	    reportLog("7.4: Verify user is able to reset");
	    calculatorpage.verifyResultAreReset();
 
	    reportLog("8.1: Call logout script");
	    logoutPage=calculatorpage.logoutApplication();
		logoutPage.verifyLogoutPageDisplayed();


	    
	    
	    
	    

		
	}
}
