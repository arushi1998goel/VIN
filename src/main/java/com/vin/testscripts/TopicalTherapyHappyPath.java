package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.CalculatorPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class TopicalTherapyHappyPath extends BaseTest{
	
	public TopicalTherapyHappyPath() {
		super();
	}
	/**
	 * ====================================================================================================================
	 * Test Case Name: Topical Therapy Happy Path
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
	public void TopicalTherapyHappyPath() throws Exception{
		
		reportLog("1: Vin page loaded ");
		promoPage.verifyPromoPage();
		
		reportLog("1.1: Navigate to:  https://www.vin.com/members/cms/project/defaultadv1.aspx?pid=618&id=8375301");
		loginPage=promoPage.TopicalTherapyHappyPath();
		
		reportLog("1.2: Call login script");
		loginPage.verifyUserLoginPage();
		
		reportLog("1.3: User should be directed to Topical Therapy product finder");
		calculatorpage=loginPage.loginInApplication(CalculatorPage.class,UserID, UserPswrd);

		reportLog("1.4: Dismiss Alert Notification if displayed");
	    calculatorpage.dismissNotifications();
	    
	    reportLog("2.1: Select ok on introduction modal");
	    calculatorpage.selectokonPopUp();

	    reportLog("2.2: Verify user is able to select ok on introduction modal");
	     calculatorpage.okPopUpIsSelected();

	    reportLog("3.1: Select dog from species check box");
	    calculatorpage.selectDogsCheckbox();

	    reportLog("3.2: Verify user is able to select the dog check box");
	    calculatorpage.dogsCheckBoxIsSelected();
	    
	    reportLog("4.1: Select skin products radio button");
	    calculatorpage.selectskinradioButton();

	    reportLog("4.2: Verify user is able to select radio button");
	    calculatorpage.verifySkinRadioButtonIsSelected();

	    reportLog("5.1: Select active ingredients check box");
	    calculatorpage.selectActiveIngredientCheckBox();

	    reportLog("5.2: Verify user is able to select active ingredients check box and ingredient drop down populates");
	    calculatorpage.ingredientDropdownPopulates();
	    
	    reportLog("6.1: Select acetic acid from ingredients drop down");
	    calculatorpage.SearchingrediabtFromDropDown(Constants.AceticAcidValue);

	    reportLog("6.2: Verify user is able to make selection from ingredients drop down");
	    calculatorpage.ingredientIsSelected(Constants.AceticAcidValue);
	    
	    reportLog("7.1: Select search");
	    calculatorpage.ClickonSearchButton();
	    
	    reportLog("7.2: Verify search results are calculated below");
	    calculatorpage.verifyresultCalulatedBelow();
	    
	    reportLog("8.1: Select Reset");
	    calculatorpage.selectreset();

	    reportLog("8.2: Verify user is able to select reset and results are cleared");
        calculatorpage.verifyResultGotClean();
	    
	    reportLog("9.1: Call logout script");
	    logoutPage=calculatorpage.logoutApplication();
		logoutPage.verifyLogoutPageDisplayed();



}
}
