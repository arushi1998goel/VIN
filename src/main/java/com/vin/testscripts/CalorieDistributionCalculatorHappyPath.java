package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.vin.utilities.Constants;


import com.vin.pages.CalculatorPage;
import com.vin.selenium.core.BaseTest;


public class CalorieDistributionCalculatorHappyPath extends BaseTest{
	
	public CalorieDistributionCalculatorHappyPath() {
		super();
	}
	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());

}
	/**
	 * ====================================================================================================================
	 * Test Case Name: CalorieDistributionCalculatorHappyPath
	 * ====================================================================================================================
	 * @throws Exception
	 */
	
	@Test
	public void CalorieDistributionCalculatorHappyPath() throws Exception {
		
		reportLog("verify VIN Promo page is loaded ");
		promoPage.verifyPromoPage();
		
		reportLog("1:1 Go to : https://www.vin.com/members/cms/project/defaultadv1.aspx?pid=618&id=8424020");
		loginPage=promoPage.navigateToCalorieDistributionCalculatorPath();
		
		reportLog("1.2: Call login script");
		loginPage.verifyUserLoginPage();
		
		reportLog("1.3: User should be directed to Calorie DistributionCalculator");
		calculatorpage=loginPage.loginInApplication(CalculatorPage.class,UserID, UserPswrd);
  
		 reportLog("1.4: Dismiss Alert Notification if displayed");
	     calculatorpage.dismissNotifications();
	        
		 reportLog("2.1: Enter any amount in moisture");
		 calculatorpage.inputmoistureValue(Constants.moistureValue);
			
		reportLog("2.2: Verify user is able to enter an amount");
		calculatorpage.verifymoistureValue(Constants.moistureValue);
		
		reportLog("3.1: Enter any amount in crude protein");
		calculatorpage.inputcrudeProteinValue(Constants.crudeProteinValue);
		
		reportLog("3.2: Verify user is able to enter an amount");
		calculatorpage.verifycrudeProteinValue(Constants.crudeProteinValue);
		
		reportLog("4.1: Enter any amount in crude fat");
		calculatorpage.inputcrudefatValue(Constants.crudeFatValue);
		
		
		reportLog("4.2: Verify user is able to enter an amount");
		calculatorpage.verifycrudefatValue(Constants.crudeFatValue);
		
		reportLog("5.1: Enter any amount of crude fiber");
		calculatorpage.inputcrudeFiberValue(Constants.crudeFiberValue);
		
		reportLog("5.2: Verify user is able to enter an amount");
		calculatorpage.verifycrudefiberValue(Constants.crudeFiberValue);
		
		reportLog("6.1: Enter any amount of Ash");
		calculatorpage.inputAshValue(Constants.AshValue);
		
		reportLog("6.2: Verify user is able to enter an amount");
		calculatorpage.verifyashValue(Constants.AshValue);

		reportLog("7.1: Select Calculate");
		calculatorpage.selectCalculatebutton();

        reportLog("7.4: Verify results are calculated in the chart");
        calculatorpage.verifyResult(Constants.carbsumVlue);

		reportLog("8.1: Select Reset");
		calculatorpage.selectreset();
		calculatorpage.selectOkbuttoninAlert();

        reportLog("8.2: Verify user is able to reset");
        calculatorpage.verifyUserIsAbleToReset();
        
		reportLog("9.1: Call logout script");
		logoutPage=calculatorpage.logoutApplication();
	    logoutPage.verifyLogoutPageDisplayed();

		


		
		}
	
}
