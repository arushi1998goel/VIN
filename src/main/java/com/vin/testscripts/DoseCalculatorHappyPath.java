package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class DoseCalculatorHappyPath extends BaseTest {
	private String SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName;

	
	public DoseCalculatorHappyPath() {
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
	 * Test Case Name: DoseCalculatorHappyPath
	 * ====================================================================================================================
	 * @throws Exception
	 * 
	 * @throws ParseException
	 */
	
	@Test
	public void verifyDoseCalculatorHappyPath() throws Exception {
		
		reportLog("1.1: Bringing up VIN page");
		promoPage.verifyPromoPage();
		
		reportLog("1.2: Navigate to https://www.vin.com/members/cms/project/defaultadv1.aspx?pid=618&id=8913032");
		loginPage=promoPage.navigateToDoseCalculatorHappyPath();
		
		reportLog("1.3: Verify login page is displayed (Title: Login)");
		loginPage.verifyUserLoginPage();

		reportLog("1.4: Log in to the Portal ");
		securityQuestionPage = loginPage.loginInApplication(UserID, UserPswrd);

		reportLog("1.5: Verify Security Question Page displayed (Title: VIN – Security Question)");
		securityQuestionPage.verifySecurityQuestionPageDisplayed();
		
		reportLog("1.6: Dismiss notification if displayed");
		vvdh=securityQuestionPage.dismissNotifications();
		
		reportLog("1.7: User will naviagate to dose calculator");
		vvdh.verifyDoseCalculatorPage();
		
		reportLog("2.1: Enter Drug Name");
		vvdh.enterDrugName(Constants.drugBactrovet);
		
		reportLog("2.2: User is able to enter drug name");
		vvdh.verifyDrugName(Constants.drugBactrovet);
		
		reportLog("2.3: Auto fill for drug options will populate");
		vvdh.verifyAutofillForDrug();
		
		reportLog("3.1: Select species from drop down");
		vvdh.selectSpecies(Constants.dogSpecies);
		
		reportLog("3.2: User is able to select a species");
		vvdh.verifySpeciesSelection(Constants.dogSpecies);
		
		reportLog("4.1: Enter weight (lb)");
		vvdh.enterWeight();
		
		reportLog("4.2: User is able to enter numeric text.");
		vvdh.verifyWeightInNumericText(Constants.weightIn10lb);
		
		reportLog("4.3: KGs are calculated automatically");
		vvdh.verifyKGCalculatedAutomatically(Constants.weightInKG);

		reportLog("5.1: Select an indication from drop down");
		vvdh.selectIndication(Constants.IndicationText);
		
		reportLog("5.2: User is able to make selection from drop down list");
		vvdh.verifyIndicationText(Constants.IndicationText);
		
		reportLog("6.1: Select a dose range from drop down");
		vvdh.selectDose(Constants.doseText);
		
		reportLog("6.2: User is able to make selection from drop down list");
		vvdh.verifyDoseSelection(Constants.doseText);
		
		reportLog("7.1: Calculate");
		vvdh.selectCalculate();
		
		reportLog("7.2: Result populate below");
		vvdh.verifyResultPopulate();
		
		reportLog("8.1: Reset Calculator");
		vvdh.selectResetButton();
		
		reportLog("8.2: Values are cleared");
		vvdh.verifyValuesAreCleared();
		
		reportLog("9.1: Logout from selenium user");
		logoutPage=vvdh.logoutApplication();
		
		reportLog("9.2: Verify user is logged out successfully");
		logoutPage.verifyLogoutPageDisplayed();
		
		
		
		
	}

}
