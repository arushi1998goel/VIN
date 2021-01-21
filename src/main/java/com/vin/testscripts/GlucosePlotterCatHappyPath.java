	package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class GlucosePlotterCatHappyPath extends BaseTest {
	private String SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName;

	public GlucosePlotterCatHappyPath() {

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
	public void verifyGlucosePlotterCatHappyPath() throws Exception {
		

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
		
		reportLog("2.1: Select start time");
		calculatorpage.selectTime(Constants._5AMTime);
		
		reportLog("2.2: User is able to select time");
		calculatorpage.verifyStatTimeSelection(Constants._5AMTime);	
		
		reportLog("2.3: Leave clock time display radio button at default 12hr");
		calculatorpage.selectHourTimeRadioButton();
		
		reportLog("5.1: Select Dog species");
		calculatorpage.selectCatSpeciesRadioButton();
		
		reportLog("5.2: User is able to select species");
		calculatorpage.CatSpeciesRadioButtonIsSelected();

		reportLog("4.1: Enter weight in lbs");
		calculatorpage.enterWeight(Constants.weight10lb);
		
		reportLog("4.2: Verify user is able to enter lbs in weight field and kgs are calculated automatically");
		calculatorpage.veifyThatKGCalculateAutoamtically(Constants.KGTextDog);
		
		reportLog("5.1: Leave blood glucose units radio button at default mg/dL");
		calculatorpage.selectMGDLRadioButton();
		
		reportLog("5.2: Enter 2 in dose given"); 
		calculatorpage.enterInDoseTextFiled(Constants.twoTime);
		
		reportLog("8.2: User is able to enter text");
		calculatorpage.verifyValueInDoseTextFiled(Constants.twoTime);
		
		reportLog("6.1: Select Novolin in Type of Insulin drop down");
		calculatorpage.selectNovolinFromDropdown();
		
		reportLog("6.2: Verify user can select Novolin");
		calculatorpage.verifyNovolinSelection(Constants.novolinText);
		
		reportLog("7.1: Select New untreated patient from Clinical Status");
		calculatorpage.selectNewUntreatedPatient();
		
		reportLog("7.2: Verify user is able to select new untreated patient");
		calculatorpage.verifyUntreatedPatientSelection(Constants.untreatedPatientText);
		
		reportLog("8.1: Enter 1 in time on current dose"); 
		calculatorpage.enterDoseTime(Constants.oneTime);
		
		reportLog("8.2: Verify user is able to enter Time on current dose");
		calculatorpage.verifyDoseTimeValue(Constants.oneTime);
		
		reportLog("8.3: Leave days as selection in time on current dose drop down");
		calculatorpage.selectDaysFromDropdown();
		
		reportLog("9.1: Select canned radio button for diet");
		calculatorpage.selectCannedRadioButton();
		
		reportLog("9.2: Verify user is able to select canned radio button");
		calculatorpage.cannedButtonIsSelected();

		reportLog("10.1: Select No radio button on Low Carb section");		
		reportLog("10.2: Verify that user is able to select radio button. No selected by default");
		calculatorpage.selectNoRadioButtonOrVerifyNoRadioButtonSelection();

		reportLog("11.1: Enter Purina in diet brand text field");
		calculatorpage.enterDietBrand(Constants.purina);
		
		reportLog("11.2: Verify user is able to enter diet brand");
		calculatorpage.verifyDietBrandValue(Constants.purina);
		
		reportLog("12.1: Select veterinarian radio button in curve done by section. Veterinarian selected by default");		
		reportLog("12.2: Verify user is able to select radio button");
		calculatorpage.selectVeterinarianRadioButtonOrVerifyRadioButtonSelection();

		reportLog("13.1: Select One Touch Ultra 2 from Glucometer");
		calculatorpage.selectOneTouchUltra2();
		
		reportLog("13.2: Verify user is able to make selection");
		calculatorpage.verifyOnTouchValueSelection(Constants.oneTouchText);
		
		reportLog("14.1: Select Proceed to step 2");
		calculatorpage.selectProceedToStep2();
		
		reportLog("14.2: Verify user is able to proceed to Step 2 and Dismiss Alert Notification if displayed");
		calculatorpage.verifyUserIsDirectedToPage2();
	     calculatorpage.dismissNotifications();
		
		reportLog("15.1: Select 8lb cat: No insulin effect from sample data drop down");
		calculatorpage.selectSampleData(Constants.cat8lb);
		calculatorpage.selectokonPopUp();		

		reportLog("15.2: Verify user is able to make selection and data is added to table above");
        calculatorpage.verifysampleDataSelection(Constants.cat8lb);
        
		reportLog("15.3: Dismiss alert 'Some of your inputs may have been modified' by selecting ok");
		reportLog("15.4: Verify user is able to select ok");
		
		reportLog("16.1: Proceed to Step 3");
		calculatorpage.proceedToStep3();
		
		reportLog("16.2: Verify user is able to proceed to step 3 and Dismiss Alert Notification if displayed");
		calculatorpage.userIsDirectedToPage3();
	    calculatorpage.dismissNotifications();
		
		reportLog("16.3: Verify results are calculated and displayed in graph");
		calculatorpage.resultsCalculationsAreDisplayed();
		
		reportLog("17.1: Call logout script");
		logoutPage=calculatorpage.logoutApplication();
		logoutPage.verifyLogoutPageDisplayed();
		
		
		
		
	}

}
