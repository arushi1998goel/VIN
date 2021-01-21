package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class GlucosePlotterDogHappyPath extends BaseTest {
	private String SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName;

	public GlucosePlotterDogHappyPath() {

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
	 * Test Case Name: GlucoseCalculatorHappyPath
	 * ====================================================================================================================
	 * @throws Exception
	 * 
	 * @throws ParseException
	 */
	
	@Test
	public void verifyGlucosePlotterHappyPath() throws Exception {
		

		reportLog("1.1: Bringing up VIN page");
		promoPage.verifyPromoPage();
		
		reportLog("1.2:Navigate to https://www.vin.com/members/cms/project/defaultadv1.aspx?pid=618&id=7140313");
		loginPage=promoPage.navigateToGlucosePlotterHappyPath();
		
		reportLog("1.3: Verify login page is displayed (Title: Login)");
		loginPage.verifyUserLoginPage();

		reportLog("1.4: Log in to the Portal ");
		securityQuestionPage = loginPage.loginInApplication(UserID, UserPswrd);

		reportLog("1.5: Verify Security Question Page displayed (Title: VIN – Security Question)");
		securityQuestionPage.verifySecurityQuestionPageDisplayed();
		
		reportLog("1.6: Dismiss notification if displayed");
		calculatorpage=securityQuestionPage.dismissNotificationsPopUp();
		
		reportLog("1.7: User is directed to calculator");
		calculatorpage.verifyGlucosePlotterPage();
		
		reportLog("2.1: Select  5 am hour time");
		calculatorpage.selectTime(Constants._5AMTime);
		
		reportLog("2.2: User is able to select time");
		calculatorpage.verifyStatTimeSelection(Constants._5AMTime);
		
		reportLog("3.1: Select 0 for minute time");
		calculatorpage.selectMinuteTime(Constants.minuteTime);
		
		reportLog("3.2: User is able to select minute");
		calculatorpage.verifyMinuteSelection(Constants.minuteTime);
		
		reportLog("4.1: Select 12 hour time display");
		calculatorpage.selectHourTimeRadioButton();
		
		reportLog("4.2: User is able to select radio button");
		calculatorpage.verifyUserIsAbleToSelectRadioButton();
		
		reportLog("5.1: Select Dog species");
		calculatorpage.selectDogSpeciesRadioButton();
		
		reportLog("5.2: User is able to select species");
		calculatorpage.selectDogSpeciesRadioButton();

		reportLog("6.1: Enter weight ");
		calculatorpage.enterWeight(Constants.weight10lb);
		
		reportLog("6.2: User is able to enter weight and kgs are calculated automatically");
		calculatorpage.veifyThatKGCalculateAutoamtically(Constants.KGTextDog);
		
		reportLog("7.1: Select mg/dl radio button");
		calculatorpage.selectMGDLRadioButton();
		
		reportLog("7.2: User is able to select button");
		calculatorpage.selectMGDLRadioButton();

		reportLog("8.1: Enter 10 in dose text field");
		calculatorpage.enterInDoseTextFiled(Constants.doseValue);
		
		reportLog("8.2: User is able to enter text");
		calculatorpage.verifyValueInDoseTextFiled(Constants.doseValue);
		
		reportLog("9.1: Select Novolin (NPH) from drop down");
		calculatorpage.selectNovolinFromDropdown();
		
		reportLog("9.2: User is able to make selection");
		calculatorpage.verifyNovolinSelection(Constants.novolinText);
		
		reportLog("10.1: Select New untreated patient from drop down ");
		calculatorpage.selectNewUntreatedPatient();
		
		reportLog("10.2: User is able to make selection");
		calculatorpage.verifyUntreatedPatientSelection(Constants.untreatedPatientText);
		
		reportLog("11.1:Enter dose time (2)");
		calculatorpage.enterDoseTime(Constants.doseTimeValue);
		
		reportLog("11.2: User is able to enter dose time");
		calculatorpage.verifyDoseTimeValue(Constants.doseTimeValue);
		
		reportLog("12.1: Select days from drop down");
		calculatorpage.selectDaysFromDropdown();
		
		reportLog("12.2: User is able to select day from drop down");
		calculatorpage.verifyDaysSelection(Constants.daysText);
		
		reportLog("13.1: Select dry radio button");
		calculatorpage.selectDryRadioButtonOrVerifyDryRadioButtonSelection();
		
		reportLog("13.2: User is able to select radio button");
		calculatorpage.selectDryRadioButtonOrVerifyDryRadioButtonSelection();

		reportLog("14.1: Select no radio button");
		calculatorpage.selectNoRadioButtonOrVerifyNoRadioButtonSelection();
		
		reportLog("14.2: User is able to select radio button");
		calculatorpage.selectNoRadioButtonOrVerifyNoRadioButtonSelection();

		reportLog("15.1: Enter diet brand (Blue Buffalo)");
		calculatorpage.enterDietBrand(Constants.dietBrandText);
		
		reportLog("15.2: User is able to enter text");
		calculatorpage.verifyDietBrandValue(Constants.dietBrandText);
		
		reportLog("16.1: Select veterinarian radio button");
		calculatorpage.selectVeterinarianRadioButtonOrVerifyRadioButtonSelection();
		
		reportLog("16.2: User is able to select radio button");
		calculatorpage.selectVeterinarianRadioButtonOrVerifyRadioButtonSelection();

		reportLog("17.1: Select One Touch Ultra 2 from drop down");
		calculatorpage.selectOneTouchUltra2();
		
		reportLog("17.2: User is able to make selection");
		calculatorpage.verifyOnTouchValueSelection(Constants.oneTouchText);
		
		reportLog("18.1: Select Proceed to step 2");
		calculatorpage.selectProceedToStep2();
		
		reportLog("18.2: User is able to select button and directed 2 page 2");
		calculatorpage.verifyUserIsDirectedToPage2();
		
		reportLog("19.1: Select 35 lb Dog: Ideal plot from drop down");
		calculatorpage.select35lbDog();
		calculatorpage.selectokonPopUp();		

		reportLog("19.2: User is able to make selection");
		reportLog("19.3: Pop-up modal displays indicating input have been modified. Select ok");
        calculatorpage.verify35lbDogSelection(Constants.lbDogSelection);
		
		reportLog("19.3: values are populated in table above");
		calculatorpage.valuesArepopulatedInTable();
		
		reportLog("20.1: Select proceed to step 3 when data is auto filled. ");
		calculatorpage.proceedToStep3();
		
		reportLog("20.2: User is directed to page 3");
		calculatorpage.userIsDirectedToPage3();
		
		reportLog("20.3:  result calculations are displayed. ");
		calculatorpage.resultsCalculationsAreDisplayed();
		
		reportLog("21.1: Logout from selenium user");
		logoutPage=calculatorpage.logoutApplication();
		
		reportLog("21.2: Verify user is logged out successfully");
		logoutPage.verifyLogoutPageDisplayed();
		
		
		
		
	}

}
