package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.CalculatorPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class EnergyRequirementsHappyPath extends BaseTest{
	
	public EnergyRequirementsHappyPath() {
		super();
	}
	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());
	}
	/**
	 * ====================================================================================================================
	 * Test Case Name: Energy Requirements Happy Path
	 * ====================================================================================================================
	 * 
	 * @throws Exception
	 *
	 */

	@Test
	public void EnergyRequirementsHappyPath() throws Exception{
		
		reportLog("1.0: Bringing VIN Page");
		promoPage.verifyPromoPage();
		
		reportLog("1.1: Navigate to https://www.vin.com/members/cms/project/defaultadv1.aspx?pid=618&id=7134218");	
        loginPage=promoPage.navigateToEnergyRequirementsHappyPath();
        
        reportLog("1.2: 1.2: Call login script");
		loginPage.verifyUserLoginPage();
		
		 reportLog("1.3: User should be directed to Energy Requirements Calculator");
		calculatorpage=loginPage.loginInApplication(CalculatorPage.class,UserID, UserPswrd);
		
		reportLog("1.4: Dismiss Alert Notification if displayed");
	    calculatorpage.dismissNotifications();

        reportLog("2.1: Select dog from species button");
        calculatorpage.selectDogSpeciesButton();
	    
	    reportLog("2.2: Verify user is able to select species");
	    calculatorpage.DogOnOffButtonIsSelected();
	    
	    reportLog("3.1: Enter weights 20 in lbs");
	    calculatorpage.enterWeight(Constants.weightlbs);
	    
	    reportLog("3.2: Verify user is able to enter an amount. Kgs are calculated automatically");
	    calculatorpage.verifyWeightInLBSField(Constants.weightlbs);
	    calculatorpage.veifyThatKGCalculateAutoamtically(Constants.AutomaticweightinKG);
	    
	    reportLog("4.1: Select kJ/day is able to select button");
	    calculatorpage.selectKJDayButton();
	    
	    reportLog("4.2: Verify user is able to make button selection");
	    calculatorpage.KJDayButtonIsSelected();
	    
	   	reportLog("5.1: Select adult button");
	    calculatorpage.selectDogAdultButton();
	   	
	    reportLog("5.2: Verify user is able to select button");
	    calculatorpage.AdultButtonIsSelected();
	    
	    reportLog("6.1: Select working under 1st conditions drop down");
	    calculatorpage.selectFromFirstConditionDropDown();

	    reportLog("6.2: Verify user is able to select working from drop down");
	    calculatorpage.verifyfirstconditionDropdown(Constants.workingValue);
	    
	    reportLog("7.1: Select light work under 2nd conditions drop down");
	    calculatorpage.selectFromSecondConditionDropDown();
	    
	    reportLog("7.2: Verify user is able to select light work from drop down");
	    calculatorpage.verifysecondconditionDropdown(Constants.lightworkvalue);
	    
	    reportLog("8.1: Select Calculate");
		calculatorpage.selectCalculatebutton();
		calculatorpage.selectokonPopUp();
	    
	    reportLog("8.2: Verify results are calculated in the chart");
	    calculatorpage.verifyResultAreaDisplayed();
	    
	    reportLog("9.1: Select Reset");
		calculatorpage.selectreset();
	    
	    reportLog("9.2: Select ok on 'Do you want to clear all your inputs?' modal");
		calculatorpage.selectOkbuttoninAlert();
	    
	    reportLog("9.3: Verify user is able to select ok and results are reset");
	    calculatorpage.verifyResultAreReset();
	    
	    reportLog("10.1: Call logout script");
	    logoutPage=calculatorpage.logoutApplication();
	    logoutPage.verifyLogoutPageDisplayed();


		
		
}
	}
