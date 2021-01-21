package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.CalculatorPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class MeanElectricalAxisHappyPath extends BaseTest {
	

	public MeanElectricalAxisHappyPath() {
		super();
	}
	
	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());
     
	}

	/**
	 * ====================================================================================================================
	 * Test Case Name: MeanElectricalAxisHappyPath
	 * ====================================================================================================================
	 * 
	 * @throws Exception
	 * 
	 * 
	 */
	
	@Test
	public void verifyMeanElectricalAxisHappyPath() throws Exception {
		
		reportLog("1: Bringing up VIN page");
		promoPage.verifyPromoPage();
		
		reportLog("1.1: Navigate to https://beta.vin.com/members/cms/project/defaultadv1.aspx?pId=618&id=8504280");
		loginPage=promoPage.NavigateToMeanElectricalAxisHappyPath();

		reportLog("1.2: Call Login Method");
		loginPage.verifyUserLoginPage();

		reportLog("1.3: User should be directed to Mean Electrical Axis Calculator v.2.0");
		calculatorpage=loginPage.loginInApplication(CalculatorPage.class,UserID, UserPswrd);
		
		reportLog("2.1: Enter the text 'Selenium' on the 'Name1' text field under 'Patient Name'");
		calculatorpage.enterValueIntoTextField(Constants.nameField,Constants.seleniumText);
		
		reportLog("2.2: Enter 50 in the text field under 'Lead 1'");
		calculatorpage.enterValueIntoTextField(Constants.leadIField,Constants.leadValue);
		
		reportLog("2.3: Enter 100 in the text field under 'Lead II'");
		calculatorpage.enterValueIntoTextField(Constants.leadIIField,Constants.leadIIValue);

		reportLog("2.4: Verify that 50 is automatically filled in the text field under 'Lead III'");
		calculatorpage.verifyLeadIIIfieldCalculatedAutomatically(Constants.leadIIIField,Constants.leadValue);
		
		reportLog("2.5: Select the 'get MEA' button");
		calculatorpage.clickOnMEAButton();
		
		reportLog("2.6: Verify results are calculated automatically");
		calculatorpage.verifyLeadIIIfieldCalculatedAutomatically(Constants.MEA1field,Constants.MEA1value);

		reportLog("2.7: Select the 'Reset' button");
		calculatorpage.selectReset();

	    reportLog("2.8: Verify the results are cleared on the page.");
	    calculatorpage.verifyResultIsCleaned(Constants.MEA1field);
	    
	    reportLog("3.1: Select the 'Leads I,aVF' tab");
	    calculatorpage.selectLeadIaVFtab();
	    
	    reportLog("3.2: Enter the text 'Selly' on the 'Name1' text field under 'Patient Name'");
		calculatorpage.enterValueIntoTextField(Constants.iavfnameField,Constants.iavfName);
	    
	    reportLog("3.3: Enter 20 in the text field under 'Lead 1'");
		calculatorpage.enterValueIntoTextField(Constants.leadiField,Constants.leadiFieldValue);
		
	    reportLog("3.4: Enter 40 in the text field under 'Lead aVF'");
		calculatorpage.enterValueIntoTextField(Constants.leadaVFField,Constants.aVFFieldValue);
 
	    reportLog("3.5: Select the 'get MEA' button");	
	    calculatorpage.clickOnMEAaVFButton();
	    
	    reportLog("3.6: Verify results are calculated automatically");
		calculatorpage.verifyLeadIIIfieldCalculatedAutomatically(Constants.aVFResultArea,Constants.aVFResult);

	    reportLog("3.7: Select the 'Reset' button");
		calculatorpage.selectReset();
	    
	    reportLog("3.8: Verify the results are cleared on the page.");
	    calculatorpage.verifyResultIsCleaned(Constants.aVFResultArea);
	    
	    reportLog("4.1: Call Logout Method");
	    logoutPage=calculatorpage.logoutApplication();
	    logoutPage.verifyLogoutPageDisplayed();
		

   }
}