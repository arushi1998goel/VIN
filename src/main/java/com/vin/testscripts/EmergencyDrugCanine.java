package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.EmergencyDrugFelinePage;
import com.vin.pages.LoginPage;
import com.vin.selenium.core.BaseTest;

public class EmergencyDrugCanine extends BaseTest {

    private String SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName;

    public EmergencyDrugCanine() {
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
     * Test Case Name: Emergency Drug Canine
     * ====================================================================================================================
     *
     * @throws Exception
     *
     */

    @Test
    public void emergencyDrugCanine() throws Exception {
    	
    	reportLog("1.0: Bringing VIN Page");
		promoPage.verifyPromoPage();
		
		reportLog("1.1:Navigate to Emergency Drugs Calculator");
    	reportLog("1.2 Navigate to https://beta.vin.com/members/cms/project/defaultadv1.aspx?pid=618&id=7135485");
    	loginPage=promoPage.navigateToEmergencyDrugCalculator();


        reportLog("1.2: Log in to the Portal ");
        securityQuestionPage = loginPage.loginForEmergencyDrugCanine(UserID, UserPswrd);

        reportLog("1.3: Verify Security Question Page displayed");
        securityQuestionPage.verifySecurityQuestionPageDisplayed();

        reportLog("1.4: Enter Security Answer and Login if Security Question Page displayed");
        emergecyDrugFeline = securityQuestionPage.enterSecurityAnswerAndLogin(EmergencyDrugFelinePage.class,
                SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName);
        
        reportLog("2.1: Dismiss Notifications if displayed");
        emergecyDrugFeline.dismissNotifications();
        
        reportLog("2.2: Navigate to Emergency Drugs Calculator");
        emergecyDrugFeline.navigateToEmergencyDrugsCalculatorPage();
        
        reportLog("2.3: Verify  Species is set to dog by default");
        emergecyDrugFeline.verifySpeciesIsSetToDogByDefault();
        
        reportLog("3.1: Enter 18.7lbs weight for dog");
        emergecyDrugFeline.enterWeightInLbsForDogWeightTextBox();
        
        reportLog("3.2 User is able to enter numeric text. Kgs are calculated automatically");
        emergecyDrugFeline.verifyValuesInTheKgTextBox();
        
        reportLog("3.3: Verify check box is unselected by default");
        emergecyDrugFeline.verifyEpniphrineCheckBoxIsUnselectedByDefault();
        
        reportLog("4.1: Select  Epinephrine Drug Check Box");
        emergecyDrugFeline.selecEpniphrineCheckBox();
        
        reportLog("4.2:  Verify User is able to select check box");
        emergecyDrugFeline.verifyEpniPhrineCheckboxIsSelected();
        
        reportLog("4.3: Enter Epinephrine Dose drop down");
        emergecyDrugFeline.enterEpniePhrineDoseForDog();
        
        reportLog("5.1: Enter  Atropine Drug Check Box");
        emergecyDrugFeline.selecAtropineCheckBox();
        
        reportLog("5.2: Verify User is able to select check box");
        emergecyDrugFeline.verifyAtropineCheckboxIsSelected();
        
        reportLog("5.3: Enter Atropine Conc drop down :: Enter 0.5");
        emergecyDrugFeline.enterAtropineConcTextBox();
        
        reportLog("5.4: Verify User is able to enter Numeric text ");
        emergecyDrugFeline.verifyNumericTextInAtropineConcTextBox();
        
        reportLog("5.5:  Select Atropine Dose drop down ::  Enter .8");
        emergecyDrugFeline.enterAtropineDoseForDogTextBox();
        
        reportLog("6.1: Verify  check box is unselected by default");
        emergecyDrugFeline.verifyMagensiumChlorideCheckBoxIsUnselectedByDefault();
        
        reportLog("6.2: Select Magnesium Chloride Check Box");
        emergecyDrugFeline.selectMagensiumChlorideCheckBox();
        
        reportLog("6.3: Verify User is able to select check box");
        emergecyDrugFeline.verifyMagnesiumChlorideCheckboxIsSelected();
        
        reportLog("7.1: Magnesium Chloride Conc drop down  :: Enter 2");
        emergecyDrugFeline.enterMagensiumChlorideConcTextBox();
        
        reportLog("7.2: Magnesium Chloride Dose drop down ::  Enter .8");
        emergecyDrugFeline.enterMagnesiumDoseValuesForDog();
        
        reportLog("8.1: Select   Naloxone Check Box Drug Check Box");
        emergecyDrugFeline.enterNaloxeneCheckbox();
        
        reportLog("8.2: Verify User is able to select check box");
        emergecyDrugFeline.verifyNaloxoneCheckboxIsSelected();
        
        reportLog("8.3: Enter Naloxone Conc drop down :: Enter 0.7");
        emergecyDrugFeline.enetrNaloxoneConcTextboxValues();
        
        reportLog("8.4: Select Naloxone Dose drop down ::  Enter .08");
        emergecyDrugFeline.enterNaloxoneDoseValuesForDog();
        
        reportLog("9.1:  Select   Lidocaine  Check Box");
        emergecyDrugFeline.selectLidocaineCheckBox();
        
        reportLog("9.2: Verify User is able to select check box");
        emergecyDrugFeline.verifyLidocaineCheckboxIsSelected();

        reportLog("9.3: Lidocaine Conc drop down :: enter 27");
        emergecyDrugFeline.enterLidocaineConcValuesForDog();

        reportLog("9.4: Select Lidocaine Dose drop down ::  Enter 5");
        emergecyDrugFeline.enterLidocaineDoseTextBoxValue("5");

        reportLog("10.1: Select Diazepam Check Box");
        emergecyDrugFeline.selectDiazepanCheckobox();

        reportLog("10.2: Verify User is able to select check box");
        emergecyDrugFeline.verifyDiazepamCheckboxIsSelected();
        
        reportLog("10.3: Diazepam Conc drop down :: Enter 7");
        emergecyDrugFeline.enterDaizepamConcValuesForDog();

        reportLog("10.4: Diazepam Dose drop down :: Enter  .6");
        emergecyDrugFeline.enterDaizepamDoseValuesForDog();
        
        reportLog("11.1:  Select   Calcium Chloride  Check Box");
        emergecyDrugFeline.selectCalciumChlorideCheckbox();
        
        reportLog("11.2: Verify User is able to select check box");
        emergecyDrugFeline.verifyCalciumChlorideCheckboxIsSelected();

        reportLog("11.3: Enter  Calcium Chloride Conc Textbox:: Enter 107");
        emergecyDrugFeline.enterValuesInTheCalciumChlorideConcForDog();

        reportLog("11.4:  Select Calcium Chloride Dose drop down ::  Enter 12 ");
        emergecyDrugFeline.enterValuesInTheCalciumChlorideDoseForDog();
        
        reportLog("12.1: Select Glucose Check Box");
        emergecyDrugFeline.selectGlucoseCheckBox();

        reportLog("12.2: Verify User is able to select check box");
        emergecyDrugFeline.verifyGlucoseCheckboxIsSelected();

        reportLog("12.3: Glucose Conc drop down :: Enter 507");
        emergecyDrugFeline.enterGlucoseConcValuesForDog();

        reportLog("12.4: Glucose Dose drop down :: Enter  507 ");
        emergecyDrugFeline.enterGlucoseDoseValuesForDog();
        
        reportLog("13.1: Select Vasopressin Check Box");
        emergecyDrugFeline.selectVasopressinCheckBox();

        reportLog("13.2: Verify User is able to select check box");
        emergecyDrugFeline.verifyVassopressinCheckBoxIsSelected();

        reportLog("13.3: Vasopressin Conc drop down :: Enter 27");
        emergecyDrugFeline.enterVasopressinConcTextBox();

        reportLog("13.4: Vasopressin Dose drop down :: Enter  1 ");
        emergecyDrugFeline.enterVasopRessinDoseValuesForDogInTheTextBox();
        
        reportLog("14.1: Select Option Check Box");
        emergecyDrugFeline.selectOptionCheckbox();

        reportLog("14.2: no information entered by user");
        emergecyDrugFeline.verifyOptionConcTextBox();

        reportLog("15.1: Select Option Check Box");
        emergecyDrugFeline.selectOptionCheckbox2();

        reportLog("15.2: no information entered by user");
        emergecyDrugFeline.verifyOptionConcTextBox();
        
        reportLog("16.1: Colloid resuscitation check Box ");
        emergecyDrugFeline.selectColloidCheckBox();

        reportLog("16.2: Verify User is able to select check box");
        emergecyDrugFeline.verifyColloidCheckBoxIsSelected();
        
        reportLog("17.1: Leave at default 20");
        emergecyDrugFeline.verifyColloidDefaultValues();

        reportLog("18.1: Select Defibrillation Check Box");
        emergecyDrugFeline.selectDefebrillationCheckBox();
        
        reportLog("18.2:  Verify User is able to select check box");
        emergecyDrugFeline.verifyDefebrillationCheckBoxIsSelected();

        reportLog("18.3: Defibrillation (external) Dose ::  Leave at default 4  ");
        emergecyDrugFeline.verifyDefibrillationDefaultValues();
        
        reportLog("19.1: Total shock volume of fluids check box");
        emergecyDrugFeline.selectVolumeFluidsCheckBox();

        reportLog("19.2:  Verify User is able to select check box");
        emergecyDrugFeline.verifyVolumeFluidsIsSelected();
        
        reportLog("20.1: Total shock volume of fluids dose :: Set at 90");
        emergecyDrugFeline.verifyFluidsDoseDefaultValues();

        reportLog("20.2: Verify Numeric Text  for each Text Box ");
        emergecyDrugFeline.verifyNumericInTextBoxes();
        
        reportLog("21.1: Select Calculate");
        emergecyDrugFeline.selectCalculateButton();

        reportLog("21.2: Verify User is able to calculate");
        emergecyDrugFeline.verifyResultsAreDisplayed();
        
        reportLog(
                "21.3: Expected Results:Epinephrine Volume - 1.53/Atropine Volume - 13.6/Magnesium Chloride - 3.4/ Naloxone Volume - .97/Lidocane Volume - 1.57/ Diazapam Volume - .73/Calcium Chloride - .95/Glucose - 8.5/ Vasopressin - .31/ Colloid resuscitation - 170/ Defibrillation 34J/Total Shock Volume of Fluids - 765");
        emergecyDrugFeline.verifyContentInTheRightPane(com.vin.utilities.Constants.VolumeContents);
        
        reportLog("22.1: Select Reset");
        emergecyDrugFeline.selectResetButton();

        reportLog("23.1: Pop Up Modal will display asking the user if they are sure they ");
        emergecyDrugFeline.verifyAlertTexts();
        
        reportLog("24.1: Select ok");
        emergecyDrugFeline.clickEnter();

        reportLog("25.1: Logout ");
        logoutPage = emergecyDrugFeline.logout();

        reportLog("26.1:  Verify Logging off from VIN is successful");
        logoutPage.verifyLogoutPageDisplayed();

    }

}
