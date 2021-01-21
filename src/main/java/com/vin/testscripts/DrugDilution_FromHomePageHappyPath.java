package com.vin.testscripts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.vin.pages.DrugDilution_Page;
import com.vin.pages.FrontPage;
import com.vin.pages.LoginPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;



public class DrugDilution_FromHomePageHappyPath extends BaseTest {

	private String SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName, parentWin;

	public DrugDilution_FromHomePageHappyPath() {
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
	 * Test Case Name: DrugDilution_FromHomePage
	 * ====================================================================================================================
	 * 
	 * @throws InterruptedException

	 */

	@Test
	public void drugDilution_FromHomePage() throws InterruptedException {

		reportLog("1: verify VIN Promo page is loaded ");
		promoPage.verifyPromoPage();

		reportLog("2: Select the LOGIN button");
		loginPage = promoPage.clickOnLoginButton();

		reportLog("3: Verify login page is displayed");
		loginPage.verifyUserLoginPage();

		reportLog("4: Log in to the Portal ");
        securityQuestionPage = loginPage.loginInApplication(UserID, UserPswrd);

		reportLog("5: Verify Security Question Page displayed");
		securityQuestionPage.verifySecurityQuestionPageDisplayed();

		reportLog("5.1: Enter Security Answer and Login if Security Question Page displayed");
		frontPage = securityQuestionPage.enterSecurityAnswerAndLogin(FrontPage.class,SecurityAnswerSecoreIDNumber,
				SecurityAnswerMothersMaidenName);

		reportLog("6 : Verify Front Page displayed");
		frontPage.verifyFrontPageDisplayed();

		reportLog("6.1 : Dismiss Notifications");
		frontPage.dismissNotifications();

		reportLog("7 : Select the drop down arrow next to library");
		frontPage.clickOnLibraryDropDown();

		reportLog("7.1 : The drop down menu will populate");
		frontPage.verifyLibraryDropDown();

		reportLog("8 :Select Calculators from Library Quick Links");
		calculatorpage = frontPage.selectCalculatorsFromLibraryDrpDwn();

		reportLog("8.1 User is taken to the Calculator page");
		calculatorpage.verifyCalculatorPageIsOpen(Constants.CalculatorPageTitle);

		reportLog("9 Select Drug Dilution from list of calculators");
		drugDilutionPage = calculatorpage.clickOnDrugDilutionFromCalculatorMenu(Constants.drugDilutionCalculatorText);

		reportLog("9.1 User is taken to drug dilution calculator");
		parentWin = switchToChildWindow();
		drugDilutionPage.verifyDrugDilutionPageTitle(Constants.drugDilutionCalculatorText);

		reportLog("10.1 Enter drug name");
		drugDilutionPage.enterDrugTextField(Constants.DrugLidocaine);

		reportLog("10.2 Verify user is able to enter a starting drug name in the calculator");
		drugDilutionPage.verifyDrugTextBoxIsEnabled(Constants.DrugLidocaine);

		reportLog("11.1 Enter a drug concentration amount ");
		drugDilutionPage.enterConcentrationAmountInConcentrationTextField(Constants.LidocaineDrugConcentrationAmount);

		reportLog("11.2 User is able to enter the drug concentration amount");
		drugDilutionPage.verifyConcentrationAmountFieldIsEnabled(Constants.LidocaineDrugConcentrationAmount);

		reportLog("12.1 Select a unit measurement from drop down");
		drugDilutionPage.selectMeasurementFromConcentrationDropDown();

		reportLog("12.2 User is able to select from drop down");
		drugDilutionPage.verifyUserIsAbleToSelectFromDropDown("mg");

		reportLog("13.1 Select a volume unit measurement from drop down ");
		drugDilutionPage.selectVolumeFromDropDown();

		reportLog("13.2 User is able to select from drop down");
		drugDilutionPage.verifyUserIsAbleToSelectFromVolumeDropDown("ml");

		reportLog("14.1 Enter volume amount ");
		drugDilutionPage.enterVolumeTextField(Constants.VolumeAmount);

		reportLog("14.2 Volume Anount entered is present in Text Box");
		drugDilutionPage.verifyUserIsAbleToEnterAmountInTheVolumeField(Constants.VolumeAmount);

		reportLog("15.1 Select a unit of measurement from drop down ");
		drugDilutionPage.selectVolumeFromDropDown();

		reportLog("5.2 User is able to select from drop down");
		drugDilutionPage.verifyUserIsAbleToSelectFromVolumeDropDown("ml");

		reportLog("16.1 Enter dilutant name");
		drugDilutionPage.clickOnDiluentTextBox(Constants.DiluentTextBox);

		reportLog("16.2  User is able to enter a dilutant name");
		drugDilutionPage.verifyUserIsAbleToEnterInTheDiluentTextBox(Constants.DiluentTextBox);

		reportLog("17.1 Enter dilutant volume amount");
		drugDilutionPage.enterDilutantVolumeValue(Constants.VolumeAmount);

		reportLog("17.2 User is able to enter a volume amount");
		drugDilutionPage.verifyUserIsAbleToEnterInTheDiluentVolumeTextBox(Constants.VolumeAmount);

		reportLog("18.1 Select dilutent volume measurement from drop down");
		drugDilutionPage.selectDiutantVolumeFromDropDown();

		reportLog("18.2 Verify User is able to select a unit volume measurement");
		drugDilutionPage.verifyUserIsAbleToSelectFromDilutantVolumeDropDown("ml");

		reportLog("19.1 Select Add to Volume");
		reportLog("19.2 User is able to add to volume");
		drugDilutionPage.veridyAddToVolumeRadioButton();

		reportLog("20.1 Select Calculate");
		drugDilutionPage.clickOnCalculateButton();

		reportLog("20.2 User is able to select the calculate button an results will display under final drug section");
		drugDilutionPage.verifyUserIsAbleToSelectCalculateButton();
		drugDilutionPage.verifyResultDisplayedUnderFinalDrugSection();

		reportLog("21.1 Select Reset");
		drugDilutionPage.clickOnResetButton();

		reportLog("21.2 User is able to reset the calculations");
		drugDilutionPage.verifyValuesIsReset();

		reportLog("23.1: Logout application");
		logoutPage = frontPage.logoutApplication();

		reportLog("23.2: Verify Logout Page displayed");
		logoutPage.verifyLogoutPageDisplayed();

	}
}
