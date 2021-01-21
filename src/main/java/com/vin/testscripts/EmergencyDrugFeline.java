package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.EmergencyDrugFelinePage;
import com.vin.pages.FeedingTubeAndTransfusionVolumePage;
import com.vin.pages.LoginPage;
import com.vin.pages.TransfusionVolumePage;
import com.vin.selenium.core.BaseTest;

import bsh.org.objectweb.asm.Constants;

public class EmergencyDrugFeline extends BaseTest {

	private String SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName;

	public EmergencyDrugFeline() {
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
	 * Test Case Name: Emergency Drug Feline
	 * ====================================================================================================================
	 * 
	 * @throws Exception
	 * 
	 *
	 */

	@Test

	public void emergencyDrugFeline() throws Exception {

    	reportLog("1.0: Bringing VIN Page");
		promoPage.verifyPromoPage();

		reportLog("1.1: Navigate to https://beta.vin.com/members/cms/project/defaultadv1.aspx?pid=618&id=7135485");	
    	loginPage=promoPage.navigateToEmergencyDrugCalculator();


        reportLog("1.2: Log in to the Portal ");
        securityQuestionPage = loginPage.loginForEmergencyDrugCanine(UserID, UserPswrd);

		reportLog("1.3: Verify Security Question Page displayed");
		securityQuestionPage.verifySecurityQuestionPageDisplayed();

		reportLog("1.4: Enter Security Answer and Login if Security Question Page displayed");
		emergecyDrugFeline = securityQuestionPage.enterSecurityAnswerAndLogin(EmergencyDrugFelinePage.class,
				SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName);

		reportLog("2.1: Navigate to Emergency Drugs Calculator");
		emergecyDrugFeline.verifyEmergencyDrugFelinePage(com.vin.utilities.Constants.EmergencyDrugsCalculator);

		reportLog("2.2: Dismiss Notifications if displayed");
		emergecyDrugFeline.dismissNotifications();

		reportLog("2.3: Verify  Species is set to dog by default");
		emergecyDrugFeline.verifySpeciesIsSetToDogByDefault();

		reportLog("2.4: Select cat for species");
		emergecyDrugFeline.selectCatRadioButton();

		reportLog("2.5: User is able to select the cat  radio button");
		emergecyDrugFeline.verifyCatRadioButtonIsSelected();

		reportLog("3.1: Enter 20.5 lbs weight for cat");
		emergecyDrugFeline.enterWeightInTheTextBox();

		reportLog("3.2: Verify  User is able to enter numeric text. Kgs are calculated automatically");
		emergecyDrugFeline.verifyValuesInTheKgTextBox();
		emergecyDrugFeline.verifyNumericTextInTheWeightLbTextBox();

		reportLog("4.1: Verify check box is unselected by default");
		emergecyDrugFeline.verifyEpniphrineCheckBoxIsUnselectedByDefault();

		reportLog("4.2: Select  Epinephrine Drug Check Box");
		emergecyDrugFeline.selecEpniphrineCheckBox();

		reportLog("4.3:  Verify User is able to select check box");
		emergecyDrugFeline.verifyEpniPhrineCheckboxIsSelected();

		reportLog("5.1: Select Epinephrine Conc drop down  :: Select 1");
		emergecyDrugFeline.verifyEpniPhrineDropDownvalue();

		reportLog("5.2: Select Epinephrine Dose drop down :: Enter .01");
		emergecyDrugFeline.enterEpniphrineDoseTextBox();

		reportLog("5.3: Verify  User is able to enter numeric text");
		emergecyDrugFeline.verifyNumericTextInEpniphrineDoseTextBox();

		reportLog("6.1: Select  Atropine Drug Check Box");
		emergecyDrugFeline.selecAtropineCheckBox();

		reportLog("6.2: Verify User is able to select check box");
		emergecyDrugFeline.verifyAtropineCheckboxIsSelected();

		reportLog("7.1: Enter Atropine Conc drop down :: Enter 0.5");
		emergecyDrugFeline.enterAtropineConcTextBox();

		reportLog("7.2: Verify User is able to enter Numeric text ");
		emergecyDrugFeline.verifyNumericTextInAtropineConcTextBox();

		reportLog("8.1:  Select Atropine Dose drop down ::  Enter .05");
		emergecyDrugFeline.enterAtropineDoseTextBox();
		emergecyDrugFeline.verifyNumericTextInAtropineDoseTextBox();

		reportLog("9.1: Verify  check box is unselected by default");
		emergecyDrugFeline.verifyMagensiumChlorideCheckBoxIsUnselectedByDefault();

		reportLog("9.2: Select Magnesium Chloride Check Box");
		emergecyDrugFeline.selectMagensiumChlorideCheckBox();

		reportLog("9.3: Verify User is able to select check box");
		emergecyDrugFeline.verifyMagnesiumChlorideCheckboxIsSelected();

		reportLog("9.4: Magnesium Chloride Conc drop down  :: Enter 2 ");
		emergecyDrugFeline.enterMagensiumChlorideConcTextBox();
		emergecyDrugFeline.verifyNumericTextInMagensiumChlorideConcTextBox();

		reportLog("9.5: Magnesium Chloride Dose drop down ::  Enter .15");
		emergecyDrugFeline.enterMagensiumChlorideDoseTextBox();
		emergecyDrugFeline.verifyNumericTextInMagensiumChlorideDoseTextBox();

		reportLog("10.1:  Select   Naloxone  Check Box");
		emergecyDrugFeline.enterNaloxeneCheckbox();

		reportLog("10.2: Verify User is able to select check box");
		emergecyDrugFeline.verifyNaloxoneCheckboxIsSelected();

		reportLog("11.1: Select  Naloxone Conc drop down :: Enter 0.7");
		emergecyDrugFeline.enterNaloxoneConcTextBox();

		reportLog("12.1:  Select Naloxone Dose drop down ::  Enter .04");
		emergecyDrugFeline.enterNaloxoneDoseTextBox();

		reportLog("12.2: Verify  check box is unselected by default");
		emergecyDrugFeline.verifyLidocaineCheckBoxIsUnselectedByDefault();

		reportLog("13.1:  Select   Lidocaine  Check Box");
		emergecyDrugFeline.selectLidocaineCheckBox();

		reportLog("13.1.1: Verify User is able to select check box");
		emergecyDrugFeline.verifyLidocaineCheckboxIsSelected();

		reportLog("13.2: Lidocaine Conc drop down :: enter 20");
		emergecyDrugFeline.enterLidocaineConcTextBoxValue();

		reportLog("13.3: Select Lidocaine Dose drop down ::  Enter .2");
		emergecyDrugFeline.enterLidocaineDoseTextBoxValue("0.2");

		reportLog("14.1: Select Diazepam Check Box");
		emergecyDrugFeline.selectDiazepanCheckobox();

		reportLog("14.2: Verify User is able to select check box");
		emergecyDrugFeline.verifyDiazepamCheckboxIsSelected();

		reportLog("15.1: Diazepam Conc drop down :: Enter 7");
		emergecyDrugFeline.enterDaizepamConcValuesInTheTextBox();

		reportLog("15.2: Diazepam Dose drop down :: Enter  .75");
		emergecyDrugFeline.enterDaizepamDoseValuesInTheTextBox();

		reportLog("16.1:  Select   Calcium Chloride  Check Box");
		emergecyDrugFeline.selectCalciumChlorideCheckbox();

		reportLog("16.2: Verify User is able to select check box");
		emergecyDrugFeline.verifyCalciumChlorideCheckboxIsSelected();

		reportLog("17.1: Enter  Calcium Chloride Conc Textbox:: Enter 177");
		emergecyDrugFeline.enterValuesInTheCalciumChlorideConcTextBox();

		reportLog("17.2:  Select Calcium Chloride Dose drop down ::  Enter 10 ");
		emergecyDrugFeline.enterValuesInTheCalciumChlorideConcTextBox();

		reportLog("18.1: Select Glucose Check Box");
		emergecyDrugFeline.selectGlucoseCheckBox();

		reportLog("18.2: Verify User is able to select check box");
		emergecyDrugFeline.verifyGlucoseCheckboxIsSelected();

		reportLog("19.1: Glucose Conc drop down :: Enter 522");
		emergecyDrugFeline.enterGlucoseConcTextbox();

		reportLog("19.2: Glucose Dose drop down :: Enter  507 ");
		emergecyDrugFeline.enterGlucoseDoseTextBox();

		reportLog("20.1: Select Vasopressin Check Box");
		emergecyDrugFeline.selectVasopressinCheckBox();

		reportLog("20.2: Verify User is able to select check box");
		emergecyDrugFeline.verifyVassopressinCheckBoxIsSelected();

		reportLog("20.3: Vasopressin Conc drop down :: Enter 27");
		emergecyDrugFeline.enterVasopressinConcTextBox();

		reportLog("20.4: Vasopressin Dose drop down :: Enter  .8 ");
		emergecyDrugFeline.enterVasopRessinDoseValuesInTheTextBox();

		reportLog("21.1: Select Option Check Box");
		emergecyDrugFeline.selectOptionCheckbox();

		reportLog("21.2: no information entered by user");
		emergecyDrugFeline.verifyOptionConcTextBox();

		reportLog("22.1: Colloid resuscitation check Box ");
		emergecyDrugFeline.selectColloidCheckBox();

		reportLog("22.2: Verify User is able to select check box");
		emergecyDrugFeline.verifyColloidCheckBoxIsSelected();

		reportLog("23.1: Colloid resuscitation Dose Drop down :: Set at 14");
		emergecyDrugFeline.enterValuesInColloidDoseTextBox();

		reportLog("24.1: Select Defibrillation Check Box");
		emergecyDrugFeline.selectDefebrillationCheckBox();

		reportLog("24.2:  Verify User is able to select check box");
		emergecyDrugFeline.verifyDefebrillationCheckBoxIsSelected();

		reportLog("24.3: Defibrillation (external) Dose :: Set at 8  ");
		emergecyDrugFeline.enterValuesInTheDefebrillationDoseTextBox();

		reportLog("25.1: Total shock volume of fluids check box");
		emergecyDrugFeline.selectVolumeFluidsCheckBox();

		reportLog("25.2: Verify User is able to select check box");
		emergecyDrugFeline.verifyVolumeFluidsIsSelected();

		reportLog("26: Total shock volume of fluids dose :: Set at 56");
		emergecyDrugFeline.enterValueInVolumeFluidTextBox();

		reportLog("27:  Verify Numeric Text  for each Text Box ");
		emergecyDrugFeline.verifyNumericInTextBoxes();

		reportLog("28: Select Calculate");
		emergecyDrugFeline.selectCalculateButton();

		reportLog("28.1: Verify User is able to calculate");
		emergecyDrugFeline.verifyResultsAreDisplayed();

		reportLog(
				"28.2: Expected Results:Epinephrine Volume - .09/Atropine Volume - .93/Magnesium Chloride - .7/ Naloxone Volume - .53/Lidocane Volume - .09/ Diazapam Volume - 1/Calcium Chloride - .53/Glucose - 9.03/ Vasopressin - .28/ Colloid resuscitation - 130.2/ Defibrillation 74.4J/Total Shock Volume of Fluids - 520.8");
		emergecyDrugFeline.verifyContentInTheRightPane(com.vin.utilities.Constants.contents);

		reportLog("29: Select Reset");
		emergecyDrugFeline.selectResetButton();

		reportLog("30: Pop Up Modal will display asking the user if they are sure they ");
		emergecyDrugFeline.verifyAlertTexts();

		reportLog("31: Select ok");
		emergecyDrugFeline.clickEnter();

		reportLog("32: Logout ");
		logoutPage = emergecyDrugFeline.logout();

		reportLog("33: Verify Logging off from VIN is successful");
		logoutPage.verifyLogoutPageDisplayed();
	}

}