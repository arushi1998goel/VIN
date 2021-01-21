package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.CalculatorPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class BromideCalculatorNaBrHappyPath extends BaseTest {
	
	private String SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName;
	
	public BromideCalculatorNaBrHappyPath() {

		super();
	}
	
	 @BeforeMethod
	    public void getTestData() throws Exception {

	        System.setProperty("className", getClass().getSimpleName());

	        SecurityAnswerSecoreIDNumber = RegressionTestData.getProperty("SecurityAnswerSecoreIDNumber");
	        SecurityAnswerMothersMaidenName = RegressionTestData.getProperty("SecurityAnswerMothersMaidenName");

	    }

	    /**
	     * ====================================================================================================================
	     * Test Case Name: Bromide Calculator NaBr Happy Path
	     * ====================================================================================================================
	     * @throws Exception
	     *
	     */
	    
	    @Test
	    public void verifyBromideCalculatorNaBrHappyPath() throws Exception
	    {
	    	reportLog("1.0: Bringing VIN Page");
			promoPage.verifyPromoPage();
			
			reportLog("1.1: Go to https://www.vin.com/members/cms/project/defaultadv1.aspx?pid=618&id=9435010");
		    loginPage = promoPage.navigateToBromideCalculatorKBrHappyPath();
		    
		    reportLog("1.2: Login to portal");
		    securityQuestionPage=loginPage.loginInApplication(UserID, UserPswrd);
		     

		     reportLog("1.2.1: Verify Security Question Page displayed");
		     securityQuestionPage.verifySecurityQuestionPageDisplayed();

		     reportLog("1.2.2: Enter Security Answer and Login if Security Question Page displayed");
		     calculatorpage = securityQuestionPage.enterSecurityAnswerAndLogin(CalculatorPage.class,
		                SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName);
		     
		     reportLog("1.3: User should be directed to BromideCalculator");
		     calculatorpage.verifyBromideCalculatorPage();
		     
		     reportLog("1.4: Dismiss Alert Notification if displayed");
		     calculatorpage.dismissNotifications();
		     
		     reportLog("2.1: KBr tab should be selected by default");
		     calculatorpage.KbrTabShouldBeSelectedByDefault();
		     
		     reportLog("2.2: Select NaBr tab");
		     calculatorpage.selectNaBrTab();
		     
		     reportLog("2.3: Verify user is able to select NaBr tab");
		     calculatorpage.verifyNaBrTab();
		     
		     reportLog("2.2: Enter Weight in lbs Text Field");
		     calculatorpage.enterWeightNaBr(Constants.weight10lb);

		     reportLog("2.3: Verify user is able to enter numeric text. KGs are calculated automatically");
		     calculatorpage.verifyWeightInLBSFieldNaBr(Constants.weight10lb);
		     calculatorpage.veifyThatKGCalculateAutoamticallyNaBr(Constants.KGTextDog);
		     
		     reportLog("2.6: Enter 300 in mg/ml text field");
		     calculatorpage.enterValueInMgMlTextFieldNa(Constants.mgmlData);

		     reportLog("2.7: Verify user is able to enter numeric text");
		     calculatorpage.verifyMgMlDataNa(Constants.mgmlData);

		     reportLog("3.1: Select 'yes' on the Phenobarbital radio buttons");
		     calculatorpage.selectYesRadioButtonOrVerifyRadioButtonIsSelected();
		     
		     reportLog("3.2: Verify user is able to select radio button");
		     calculatorpage.selectYesRadioButtonOrVerifyRadioButtonIsSelected();

		     
		     reportLog("3.3: Select 382mg/kg from total load drop down");
		     calculatorpage.selectmgKgDropDownValueNa(Constants.mgKgValue2);

		     
		     reportLog("3.4: Verify user is able to select from total load drop down");
		     calculatorpage.verifyDropDownValueForMgKgNa(Constants.mgKgValue2);

		     reportLog("4.1: Select '4' from Days to Load drop down");
		     calculatorpage.selectFromDaysToLoadDropdownNa(Constants.daysValue2);

		     reportLog("4.2: Verify user is able to select from days to load drop down");
		     calculatorpage.verifydaysToSelectNa(Constants.daysValue2);

		     reportLog("5.1: Select '3' from Number of doses per day drop down");
		     calculatorpage.selectFromNimberOfDosesPerDayDropDownNa(Constants.dosesDropDownValue2);

		     reportLog("5.2: Verify user is able to select from number of doses");
		     calculatorpage.verifyValuePfDosesDropdownNa(Constants.dosesDropDownValue2);

		     
		     reportLog("6.1: Select Calculate");
		     calculatorpage.selectCalculate();

		     reportLog("6.2: Verify results are calculated in the table below");
		     calculatorpage.verifyResults();

		     reportLog("6.3: Select Reset");
		     calculatorpage.selectReset();

		     reportLog("6.4: Verify user is able to reset");
		     calculatorpage.verifyResetOperation();

		     reportLog("7.1: Call logout script");
		     logoutPage=calculatorpage.logoutApplication();
		     logoutPage.verifyLogoutPageDisplayed();
		     
	    }

}
