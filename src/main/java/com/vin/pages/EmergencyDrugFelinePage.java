package com.vin.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.vin.selenium.core.BasePage;
import com.vin.utilities.Constants;

public class EmergencyDrugFelinePage extends BasePage {

	public EmergencyDrugFelinePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "input[id='catRadio']")
	WebElement catRadioButton;

	@FindBy(css = "input[id='dogRadio']")
	private WebElement dogRadioButton;

	@FindBy(css = "input[id='txtWeight']")
	private WebElement weightInLbs;

	@FindBy(css = "input[id='selectDrug0']")
	private WebElement epinephrineheckbox;

	@FindBy(css = "input[id='txtWeightKg']")
	private WebElement weightInKGTextBox;

	@FindBy(css = "select[id='conc0']")
	private WebElement epniphrineConcValue;

	@FindBy(css = "input[id='dose0']")
	private WebElement epniphrineDoseValue;

	@FindBy(css = "input[id='selectDrug1']")
	private WebElement Atropineheckbox;

	@FindBy(css = "input[id='conc1']")
	private WebElement AtropineConcTextBox;

	@FindBy(css = "input[id='dose1']")
	private WebElement AtropineDoseTextBox;

	@FindBy(css = "input[id='selectDrug2']")
	private WebElement magnesiumChlorideCheckbox;

	@FindBy(css = "input[id='conc2']")
	private WebElement magnesiumChlorideConcTextBox;

	@FindBy(css = "input[id='dose2']")
	private WebElement magnesiumChlorideDoseTextBox;

	@FindBy(css = "input[id='selectDrug3']")
	private WebElement naloxeneCheckbox;

	@FindBy(css = "input[id='conc3']")
	private WebElement naloxeneConcTextBox;

	@FindBy(css = "input[id='dose3']")
	private WebElement naloxeneDoseTextBox;

	@FindBy(css = "input[id='selectDrug4']")
	private WebElement LidocaineCheckbox;

	@FindBy(css = "input[id='conc4']")
	private WebElement LidocaineConcTextBox;

	@FindBy(css = "input[id='dose4']")
	private WebElement LidocaineDoseTextBox;

	@FindBy(css = "input[id='selectDrug5']")
	private WebElement DiazepamCheckbox;

	@FindBy(css = "input[id='conc5']")
	private WebElement DiazepamConcTextBox;

	@FindBy(css = "input[id='dose5']")
	private WebElement DiazepamDoseTextBox;

	@FindBy(css = "input[id='selectDrug6']")
	private WebElement calciumChlorideCheckbox;

	@FindBy(css = "input[id='conc6']")
	private WebElement calciumChlorideConcTextBox;

	@FindBy(css = "input[id='dose6']")
	private WebElement calciumChlorideDoseTextBox;

	@FindBy(css = "input[id='selectDrug7']")
	private WebElement glucoseCheckbox;

	@FindBy(css = "input[id='conc7']")
	private WebElement glucoseConcTextBox;

	@FindBy(css = "input[id='dose7']")
	private WebElement glucoseDoseTextBox;

	@FindBy(css = "input[id='selectDrug8']")
	private WebElement vasoPressinCheckbox;

	@FindBy(css = "input[id='conc8']")
	private WebElement vasoPressinConcTextBox;

	@FindBy(css = "input[id='dose8']")
	private WebElement vasoPressinDoseTextBox;

	@FindBy(css = "input[id='selectDrug9']")
	private WebElement optionCheckBox;

	@FindBy(css = "input[id='selectDrug10']")
	private WebElement optionCheckBox2;

	@FindBy(css = "input[id='conc9']")
	private WebElement optionConcTextBox;

	@FindBy(css = "input[id='dose9']")
	private WebElement optionConcDoseBox;

	@FindBy(css = "input[id='selectDrug11']")
	private WebElement colloidCheckbox;

	@FindBy(css = "input[id='conc11']")
	private WebElement colloidConcTextBox;

	@FindBy(css = "input[id='dose11']")
	private WebElement colloidDoseTextBox;

	@FindBy(css = "input[id='selectDrug12']")
	private WebElement defibrillationCheckbox;

	@FindBy(css = "input[id='conc12']")
	private WebElement defibrillationConcTextBox;

	@FindBy(css = "input[id='dose12']")
	private WebElement defibrillationDoseTextBox;

	@FindBy(css = "input[id='selectDrug13']")
	private WebElement volumeFuidCheckbox;

	@FindBy(css = "input[id='conc13']")
	private WebElement volumeFuidConcTextBox;

	@FindBy(css = "input[id='dose13']")
	private WebElement volumeFuidDoseTextBox;

	@FindBy(css = "button[id='submitBtn']")
	private WebElement calculateButton;

	@FindBy(xpath = "//div[@id='resultsContent']/../following-sibling::img")
	private WebElement results;

	@FindBy(xpath = "//div[@class='resultsArea']//input[@type='number']")
	private List<WebElement> textbox;

	@FindBy(css = "div[id='drugVol']")
	private List<WebElement> resultsAfterCalucate;

	@FindBy(css = "div[id='menu'] div[id='topNav'] a[id='loginmenu']")
	private WebElement loginUserDropDown;
	
	@FindBy(css = "div[id='menu'] div[id='topNav'] ul[role='menu'] a[class='MemberProfile_Logout']")
	private WebElement logoutLinkUnderUserDropDown;

	@FindBy(css = "button[id='resetBtn']")
	private WebElement resetButton;

	@FindBy(xpath = "//button[text()='Dismiss All']")
	private WebElement dismissAllBtn;
	
	@FindBy(xpath="//div/h3[text()='Emergency Drugs Calculator v.5.2']")
	private WebElement emergencyDrugCalculatorHeading;
	
    @FindBy(xpath="//select[@id='cmbParasite']")
    private WebElement parasite;
   
    @FindBy(xpath="//input[@id='topicalRadioId']")
    private WebElement topicalRadioButton;
	  
	@FindBy(xpath="//div[contains(text(),'20 products')]")
 	private WebElement searchpopuptext;
	
	@FindBy(xpath="//input[@value='OK']")
	private WebElement modelpopup;
	
    @FindBy(xpath="//table[@id='resultsArea']")
	private WebElement tableresult;
	
	@FindBy(xpath="//div[@id='DocumentPanel']")
    private WebElement fluidPage;
	 
	@FindBy(xpath="//input[@id='rbDehydratedFalse']")
    private WebElement hydratedCheckbox;
	 
	@FindBy(xpath="//button[@id='goToPhase1Btn']")
    private WebElement FluidCalculate;
	 
	@FindBy(xpath="//div[@id='divMaintOnly']")
    private WebElement FluidResult;
	 
	@FindBy(xpath="//input[@id='chkBromethalin']")
    private WebElement bromethalinRadiobutton;
	 
	@FindBy(xpath="//input[@id='txtAmount']")
    private WebElement baitTextBox;
	 
	@FindBy(xpath="//select[@id='cmbAmountUnits']")
    private WebElement baitUnit;
	 
	@FindBy(xpath="//input[@id='chkLessThan4']")
    private WebElement LessThenFour;
	 
	@FindBy(xpath="//div[@id='resultsArea']")
    private WebElement resultSection;
	 
    @FindBy(xpath="//input[@value='close']")
    private WebElement closeButton;
	 
	@FindBy(xpath="//div[contains(@id,'NSAIDMainPage')]")
    private WebElement NSAIDMainPage;

    @FindBy(xpath="//select[@id='cmbNsaidType']")
    private WebElement antiDrugs;
	 
	@FindBy(xpath="//input[@id='chkQuantityDirectly']")
    private WebElement qualityRadioButton;
	 
	@FindBy(xpath="//input[@id='txtAmount']")
    private WebElement amountTextBox;

	@FindBy(xpath="//select[@id='speciesddm']")
    private WebElement NSAIDspecies;


	/**
	 * Select Cat Radio Button
	 */
	public void selectCatRadioButton() {
		waitAndClick(catRadioButton);
	}

	/**
	 * Verify The radio Button is Selected
	 */
	public void verifyCatRadioButtonIsSelected() {
		verifyRadioButtonIsSelected(catRadioButton);

	}

	/**
	 * Verify Species is Set to Dog By Default
	 */
	public void verifySpeciesIsSetToDogByDefault() {
		verifyRadioButtonIsSelected(dogRadioButton);

	}

	/**
	 * Enter Values in the Lb Text Box
	 */
	public void enterWeightInTheTextBox() {
		inputText(weightInLbs, "20.5");

	}

	/**
	 * Verify Numeric Text in dose text Box
	 */
	public void verifyNumericInTextBoxes() {
		boolean flag = false;
		for (WebElement we : textbox) {
			if (we.getAttribute("type").equalsIgnoreCase("number")) {
				flag = true;

			}
			Assert.assertTrue(flag);

		}

	}

	/**
	 * Verify emergency Drug feline page
	 */
	public void verifyEmergencyDrugFelinePage(String Title) {

		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(Title));

	}

	/**
	 * Verify Kgs Weight TextBox Contains Value
	 */
	public void verifyValuesInTheKgTextBox() {
		String weight = weightInKGTextBox.getAttribute("value");
		Assert.assertFalse(weight.isEmpty());

	}

	/**
	 * verify numeric values in the weight lb Textbox
	 */
	public void verifyNumericTextInTheWeightLbTextBox() {
		verifyuserIsAbleOEnterNumericAmountInTheTextBox(weightInLbs);

	}

	/**
	 * select epniphrine checkbox
	 */
	public void selecEpniphrineCheckBox() {
		selectCheckbox(epinephrineheckbox);

	}

	/**
	 * Verify User is able to select Checkbox
	 */
	public void verifyEpniPhrineCheckboxIsSelected() {
		verifyRadioButtonIsSelected(epinephrineheckbox);
	}

	/**
	 * Verify EpniPhrine CheckBox is Deselected By default
	 */
	public void verifyEpniphrineCheckBoxIsUnselectedByDefault() {
		Assert.assertFalse(epinephrineheckbox.isSelected());

	}

	/**
	 * Verify Epniphrine DropDown Value
	 */
	public void verifyEpniPhrineDropDownvalue() {
		Assert.assertTrue(epniphrineConcValue.getAttribute("value").contains("1"));
	}

	/**
	 * Enter Value in epniphrine Dose TextBox
	 */

	public void enterEpniphrineDoseTextBox() {
		inputText(epniphrineDoseValue, ".01");
	}

	/**
	 * verify numeric values in the weight lb Textbox
	 */
	public void verifyNumericTextInEpniphrineDoseTextBox() {
		verifyuserIsAbleOEnterNumericAmountInTheTextBox(epniphrineDoseValue);

	}

	/**
	 * select Atropine checkbox
	 */
	public void selecAtropineCheckBox() {
		selectCheckbox(Atropineheckbox);

	}

	/**
	 * Verify User is able to select Checkbox
	 */
	public void verifyAtropineCheckboxIsSelected() {
		verifyRadioButtonIsSelected(Atropineheckbox);
	}

	/**
	 * Enter Value in Atropine Dose TextBox
	 */

	public void enterAtropineDoseTextBox() {
		inputText(AtropineDoseTextBox, "0.05");

	}

	/**
	 * Enter Value in Atropine Conc TextBox
	 */

	public void enterAtropineConcTextBox() {
		inputText(AtropineConcTextBox, "0.5");
	}

	/**
	 * verify numeric values in the Atropine Textbox
	 */
	public void verifyNumericTextInAtropineDoseTextBox() {
		verifyuserIsAbleOEnterNumericAmountInTheTextBox(AtropineDoseTextBox);

	}

	/**
	 * verify numeric values in the Atropine Textbox
	 */
	public void verifyNumericTextInAtropineConcTextBox() {
		verifyuserIsAbleOEnterNumericAmountInTheTextBox(AtropineConcTextBox);

	}

	/**
	 *  Verify MagensiumChloride CheckBox is Deselected By default
	 */

	public void verifyMagensiumChlorideCheckBoxIsUnselectedByDefault() {
		Assert.assertFalse(magnesiumChlorideCheckbox.isSelected());

	}

	/**
	 * select MagensiumChloride checkbox
	 */
	public void selectMagensiumChlorideCheckBox() {
		selectCheckbox(magnesiumChlorideCheckbox);

	}

	/**
	 * Verify User is able to select Checkbox
	 */
	public void verifyMagnesiumChlorideCheckboxIsSelected() {
		verifyRadioButtonIsSelected(magnesiumChlorideCheckbox);
	}

	public void enterMagensiumChlorideDoseTextBox() {
		inputText(magnesiumChlorideDoseTextBox, ".15");
	}

	/**
	 * Enter Value in Atropine Conc TextBox
	 */

	public void enterMagensiumChlorideConcTextBox() {
		inputText(magnesiumChlorideConcTextBox, "2");
	}

	/**
	 * verify numeric values in the Magnesium Chloride Conc Textbox
	 */
	public void verifyNumericTextInMagensiumChlorideConcTextBox() {
		verifyuserIsAbleOEnterNumericAmountInTheTextBox(magnesiumChlorideConcTextBox);

	}

	/**
	 * verify numeric values in the Magnesium Chloride Dose Textbox
	 */
	public void verifyNumericTextInMagensiumChlorideDoseTextBox() {
		verifyuserIsAbleOEnterNumericAmountInTheTextBox(magnesiumChlorideDoseTextBox);

	}

	public void enterNaloxeneCheckbox() {
		waitAndClick(naloxeneCheckbox);
	}

	/**
	 * Verify User is able to select Checkbox
	 */
	public void verifyNaloxoneCheckboxIsSelected() {
		verifyRadioButtonIsSelected(naloxeneCheckbox);
	}

	public void enterNaloxoneDoseTextBox() {
		inputText(naloxeneDoseTextBox, ".04");
	}

	/**
	 * Enter Value in Atropine Conc TextBox
	 */

	public void enterNaloxoneConcTextBox() {
		inputText(naloxeneConcTextBox, ".7");
	}

	/**
	 * verify numeric values in the Magnesium Chloride Conc Textbox
	 */
	public void verifyNumericTextInNaloxoneConcTextBox() {
		verifyuserIsAbleOEnterNumericAmountInTheTextBox(magnesiumChlorideConcTextBox);

	}

	/**
	 * verify numeric values in the Magnesium Chloride Dose Textbox
	 */
	public void verifyNumericTextInNaloxoneDoseTextBox() {
		verifyuserIsAbleOEnterNumericAmountInTheTextBox(magnesiumChlorideDoseTextBox);

	}

	/**
	 * Select Lidocaine Text Box
	 */

	public void selectLidocaineCheckBox() {
		waitAndClick(LidocaineCheckbox);
	}

	/**
	 * Enter Lidocaine Conc DropDown Textbox
	 */

	public void enterLidocaineConcTextBoxValue() {
		inputText(LidocaineConcTextBox, "20");
	}

	/**
	 * Verify User is able to select Checkbox
	 */
	public void verifyLidocaineCheckboxIsSelected() {
		verifyRadioButtonIsSelected(LidocaineCheckbox);
	}

	/**
	 * Enter Lidocaine Conc DropDown Textbox
	 */

	public void enterLidocaineDoseTextBoxValue(String lidocaineDose) {
		inputText(LidocaineDoseTextBox, lidocaineDose);
	}

	/**
	 * 8 Verify Diazepam CheckBox is Deselected By default
	 */

	public void verifyDiazepamCheckBoxIsUnselectedByDefault() {
		Assert.assertFalse(DiazepamCheckbox.isSelected());

	}

	/**
	 * Click on Diazepam CheckBox
	 */

	public void selectDiazepanCheckobox() {
		waitAndClick(DiazepamCheckbox);
	}

	/**
	 * Enter Diazepam Conc Values
	 */
	public void enterDaizepamConcValuesInTheTextBox() {
		inputText(DiazepamConcTextBox, "7");
	}

	/**
	 * Enter Diazepam Dose Values
	 */
	public void enterDaizepamDoseValuesInTheTextBox() {
		inputText(DiazepamDoseTextBox, ".75");
	}

	public void verifyDiazepamCheckboxIsSelected() {
		verifyRadioButtonIsSelected(DiazepamCheckbox);
	}

	/**
	 * Select Calcium Chloride Checkbox
	 */

	public void selectCalciumChlorideCheckbox() {
		waitAndClick(calciumChlorideCheckbox);
	}

	/**
	 * Enter Calcium Chloride Conc Value in the textbox
	 */
	public void enterValuesInTheCalciumChlorideConcTextBox() {
		_normalWait(2000);
		inputText(calciumChlorideConcTextBox, "177");
	}

	/**
	 * Enter Calcium Chloride Conc Value in the textbox
	 */

	public void enterValuesInTheCalciumChlorideDoseTextBox() {
		_normalWait(2000);
		inputText(calciumChlorideDoseTextBox, "10");
	}

	public void verifyCalciumChlorideCheckboxIsSelected() {
		verifyRadioButtonIsSelected(calciumChlorideCheckbox);
	}

	public void selectGlucoseCheckBox() {
		waitAndClick(glucoseCheckbox);

	}

	public void verifyGlucoseCheckboxIsSelected() {
		verifyRadioButtonIsSelected(glucoseCheckbox);
	}

	public void enterGlucoseConcValuesForDog() {
		inputText(glucoseConcTextBox, "507");
	}

	public void enterGlucoseDoseValuesForDog() {
		_normalWait(1000);
		inputText(glucoseDoseTextBox, "507");
	}

	/**
	 * Select Vassopressin Check box
	 */
	public void selectVasopressinCheckBox() {
		waitAndClick(vasoPressinCheckbox);
	}

	/**
	 * Verify user is able To select Vasopressin Check Box
	 */
	public void verifyVassopressinCheckBoxIsSelected() {
		Assert.assertTrue(vasoPressinCheckbox.isSelected());
	}

	/**
	 * enter values in the vasopressin conc TextBox
	 */
	public void enterVasopressinConcTextBox() {
		inputText(vasoPressinConcTextBox, "27");

	}

	/**
	 * Enter Values in the vasopressin dose textBox
	 */
	public void enterVasopRessinDoseValuesInTheTextBox() {
		inputText(vasoPressinDoseTextBox, ".8");
	}

	/**
	 * verify Lidocaine CheckBox is Deselected By default
	 */
	public void verifyLidocaineCheckBoxIsUnselectedByDefault() {
		Assert.assertFalse(LidocaineCheckbox.isSelected());

	}

	/**
	 * Select Option checkbox
	 */
	public void selectOptionCheckbox() {
		waitAndClick(optionCheckBox);
	}

	/**
	 * Enter Option Conc Text
	 */
	public void enterOptionConcTextbox() {
		inputText(optionConcTextBox, "");
	}

	/**
	 * Enter Option Dose Text
	 */
	public void enterOptionDoseTextbox() {
		inputText(optionConcDoseBox, "");

	}

	/**
	 * No Information is Entered Bye user in the Option Box
	 */
	public void verifyOptionConcTextBox() {
		Assert.assertTrue(optionConcTextBox.getText().equalsIgnoreCase(""));
	}

	/**
	 * Select Colloid CheckBox
	 */
	public void selectColloidCheckBox() {
		waitAndClick(colloidCheckbox);
	}

	/**
	 * Enter Colloid Dose Values in the TextBox
	 */
	public void enterValuesInColloidDoseTextBox() {
		inputText(colloidDoseTextBox, "14");
	}

	/**
	 * Verify Colloid check box is Selected
	 */

	public void verifyColloidCheckBoxIsSelected() {
		Assert.assertTrue(colloidCheckbox.isSelected());
	}

	/**
	 * Select Defebrillation CheckBox
	 */
	public void selectDefebrillationCheckBox() {
		waitAndClick(defibrillationCheckbox);

	}

	/**
	 * Verify Defebrillation Checkbox is selected
	 */
	public void verifyDefebrillationCheckBoxIsSelected() {
		Assert.assertTrue(defibrillationCheckbox.isSelected());
	}

	/**
	 * Enter Defebrillation dose TextBox
	 */

	public void enterValuesInTheDefebrillationDoseTextBox() {
		inputText(defibrillationDoseTextBox, "8");

	}

	/**
	 * Selected volumeFluids CheckBox
	 */
	public void selectVolumeFluidsCheckBox() {
		_normalWait(2000);
		waitAndClick(volumeFuidCheckbox);

	}

	/**
	 * Verify Checkbox is Selected
	 */

	public void verifyVolumeFluidsIsSelected() {
		_normalWait(1000);
		Assert.assertTrue(volumeFuidCheckbox.isSelected());
	}

	/**
	 * enter Values in the Volume Fluid text Box
	 */

	public void enterValueInVolumeFluidTextBox() {
		inputText(volumeFuidDoseTextBox, "56");

	}

	/**
	 * Click on Calculate Button
	 */
	public void selectCalculateButton() {
		waitAndClick(calculateButton);
	}

	/**
	 * Verify Results are Displayed
	 */
	public void verifyResultsAreDisplayed() {
		_normalWait(5000);
		Assert.assertTrue(results.getAttribute("style").contains("none"));

	}

	public void verifyContentInTheRightPane(List<String> contents) {
		_normalWait(3000);
		List<String> reasonForChange = new ArrayList<>();
		for (WebElement reasonChangeValues : resultsAfterCalucate) {
			reasonForChange.add(getText(reasonChangeValues).trim());
		}
		Assert.assertEquals(reasonForChange, contents, "values present");

	}

	/**
	 * Select Reset Button
	 */
	public void selectResetButton() {
		waitAndClick(resetButton);
	}

	/**
	 * Verify Alert Text
	 */

	public void verifyAlertTexts() {
		_normalWait(2000);
		String alertText = getAlertText();
		System.out.println(alertText);
		logger.debug("Verify Assert Text is :" + alertText);
		Assert.assertTrue(alertText.trim().contains("clear all of your inputs"));

	}

	/**
	 * Logout Application
	 */
	public LogoutPage logout() {
		_normalWait(500);
		waitForPageLoaded();
		logger.debug("Click Logout");
		waitAndClick(loginUserDropDown);
		waitAndClick(logoutLinkUnderUserDropDown);
		return PageFactory.initElements(driver, LogoutPage.class);
	}
	

	/**
	 * Enter weight in lbs for Cat Text Box
	 */
	public void enterWeightInLbsForDogWeightTextBox() {
		inputText(weightInLbs, "18.7");

	}

	/**
	 * Enetr Epniephrine Dose Text Box Value
	 */
	public void enterEpniePhrineDoseForDog() {
		inputText(epniphrineDoseValue, ".18");
	}

	/**
	 * Enter Magnesium Conc Values for dog
	 */
	public void enterMagnesiumConcValuesForDog() {
		inputText(magnesiumChlorideConcTextBox, "2");
	}

	/**
	 * Enter Atropine Dose Values for dog
	 */
	public void enterMagnesiumDoseValuesForDog() {
		inputText(magnesiumChlorideDoseTextBox, ".8");
	}

	/**
	 * Enter Value in Atropine Dose TextBox
	 */

	public void enterAtropineDoseForDogTextBox() {
		inputText(AtropineDoseTextBox, ".8");

	}

	/**
	 * Enter Naloxone Conc TextBox values
	 */

	public void enetrNaloxoneConcTextboxValues() {
		inputText(naloxeneConcTextBox, ".7");

	}

	/**
	 * Enter Naloxone Dose TextBox Values for dog
	 */

	public void enterNaloxoneDoseValuesForDog() {
		inputText(naloxeneDoseTextBox, "12");
	}

	/**
	 * Enter Lidocaine Conc DropDown Textbox
	 */

	public void enterLidocaineConcValuesForDog() {
		inputText(LidocaineConcTextBox, "27");
	}

	/**
	 * Enter Diazepam Conc Values
	 */
	public void enterDaizepamConcValuesForDog() {
		inputText(DiazepamConcTextBox, "7");
	}

	/**
	 * Enter Diazepam Dose Values
	 */
	public void enterDaizepamDoseValuesForDog() {
		inputText(DiazepamDoseTextBox, ".6");
	}

	/**
	 * Enter Calcium Chloride Conc Value in the textbox
	 */

	public void enterValuesInTheCalciumChlorideConcForDog() {
		_normalWait(2000);
		inputText(calciumChlorideConcTextBox, "107");
	}

	/**
	 * Enter Calcium Chloride Conc Value in the textbox
	 */

	public void enterValuesInTheCalciumChlorideDoseForDog() {
		_normalWait(2000);
		inputText(calciumChlorideDoseTextBox, "12");
	}

	public void enterGlucoseConcTextbox() {
		inputText(glucoseConcTextBox, "522");
	}

	public void enterGlucoseDoseTextBox() {
		_normalWait(1000);
		inputText(glucoseDoseTextBox, "507");
	}

	/**
	 * enter values in the vasopressin conc TextBox
	 */
	public void enterVasopressinConcForDogTextBox() {
		inputText(vasoPressinConcTextBox, "27");

	}

	/**
	 * Enter Values in the vasopressin dose textBox
	 */
	public void enterVasopRessinDoseValuesForDogInTheTextBox() {
		inputText(vasoPressinDoseTextBox, "1");
	}

	/**
	 * Verifying Colloid Default Values
	 */

	public void verifyColloidDefaultValues() {
		Assert.assertEquals(colloidDoseTextBox.getAttribute("value"), "20");
	}

	/**
	 * Verifying Defibrillation Default Values
	 */

	public void verifyDefibrillationDefaultValues() {
		Assert.assertEquals(defibrillationDoseTextBox.getAttribute("value"), "4");
	}

	/**
	 * Verifying fluids dose Default Values
	 */

	public void verifyFluidsDoseDefaultValues() {
		Assert.assertEquals(volumeFuidDoseTextBox.getAttribute("value"), "90");
	}

	/**
	 * Select Option Checbox 2
	 * 
	 */
	public void selectOptionCheckbox2() {
		waitAndClick(optionCheckBox2);

	}

    public void dismissNotifications() {
		super.dismissNotifications(dismissAllBtn);
    }

    /**
     * Verify emergency drug calculator page
     */
	public void navigateToEmergencyDrugsCalculatorPage() {

		assertByPageTitle(Constants.EmergencyDrugsCalculator);
	}

	/**
	 * verify user should be redirected to emergency drug calculator page
	 * @param emergencydrugscalculatorversions
	 */
	public void userShouldBeDirectedToEmergencyDrugCalculator() {
		Assert.assertTrue(emergencyDrugCalculatorHeading.isDisplayed());
	}

	/**
	 * Select dog radio button
	 */
	public void selectDogForSpecies() {


		waitAndClick(dogRadioButton);
	}
	
	
	/**
	 *  Select flea from parasite drop down
	 *  @param parasitevalue
	 */

	
	public void selectFromParasiteDropDown(String parasitevalue) {
		selectDropDownByText(parasite, parasitevalue);
		
	}
	
	/**
	 * verify parasite drop down
	 * @param parasitevalue
	 */
	
	public void verifysecondconditionDropdown(String parasitevalue) {
		String value=returnSelectedValueFromDropdown(parasite);
		Assert.assertEquals(parasitevalue, value);
	}
	
	/**
	 * select topical redio button
	 */

	
	
	public void selecttopicalRadioButton() {
		waitAndClick(topicalRadioButton);
	}
	
	/**
	 * verify topical radio button is selected
	 */
	
     public void verifytopicalButtonIsSelected() {
	 verifyRadioButtonIsSelected(topicalRadioButton);
     }
     
     /**
  	 * verify user is able to select
  	 */
     
 	 public void verifyuserIsAbleTocalculate() {
 		 Assert.assertTrue(searchpopuptext.isDisplayed());
 	 }

 	 
     /**
	  * select Ok on popup
	  */
 	 
	 public void selectokonPopUp() {
		 waitAndClick(modelpopup);
	 }
	 
	 /**
	 * Verify table  Result 
	  */
		
	public void verifytableResult()
	{
	if(tableresult.isDisplayed()) {
	Assert.assertTrue(true);
	}
   }
		
	/**
	 * table result section not Displayed After reset 
	 */

	 public void verifytableResultAreReset() {		
	 _normalWait(1000);
	 Assert.assertFalse(tableresult.isDisplayed());
								
	}
	 
	
   /**
    * verify user is able to select ok button on warning model
    */
 
     public void verifyuserIsAbleToCloseWarningModel() {
		 if(fluidPage.isDisplayed()) {
			 Assert.assertTrue(true);
			 System.out.println("warning model is closed");
		 }
		 
    }
 
    /**
    * select hydrated check box
    */
 
    public void selectHydratedCheckBox() {
	if(hydratedCheckbox.isSelected()) {
		Assert.assertTrue(true);
		System.out.println("by default selected");
	}
	else {
		waitAndClick(hydratedCheckbox);
	}
}
 
    /**
    * verify hydrated check box is selected
    */
 
      public void verifyHydratedCheckBoxisselected() {
     Assert.assertTrue(hydratedCheckbox.isSelected());
 
      }
    /**
    * Select calculate button
     */
 
     
     public void selectFluidCalculateButton() {
	 waitAndClick(FluidCalculate);
   }

    /**
     * verify Fluid result is calculated below
     */
    public void verifyResultIsCalculated() {
     if(FluidResult.isDisplayed()){		
        Assert.assertTrue(true);
        }
       }
     /**
      * verify result is reset
      */
    
     public void verifyResultIsReset() {
       Assert.assertFalse(FluidResult.isDisplayed());		
      }

     /**
      * Enter Values in the Lb Text Box
      */
     
     public void enterWeightInTextBox(String weight10lb) {
	  inputText(weightInLbs, weight10lb);

       }
     
     /**
     * Verify weight in lbs field
     * @param weight10lb
     */
     
       public void verifyWeightInLBSField(String weight10lb) {
    	 String value=weightInLbs.getAttribute("value");
	   Assert.assertEquals(weight10lb, value);
        }

      /**
      * verify kg value calculated automatically
      * @param kgtext
      */
    
       public void veifyThatKGCalculateAutoamtically(String kgtext) {
	   waitAndClick(weightInKGTextBox);
	   String kgValue=weightInKGTextBox.getAttribute("value");
	  Assert.assertEquals(kgtext, kgValue);
     }

      /**
      * select dog species radio button
      */
       
      public void selectDogRadioButton() {
	    if(dogRadioButton.isSelected()) {
		Assert.assertTrue(true);
	       }
	   else {
		waitAndClick(dogRadioButton);
	    }
	   }

    /**
     * select bromethalin Radio button
     */

      public void selectBromethalinRadioButton() {
	    if(bromethalinRadiobutton.isSelected()) {
		Assert.assertTrue(true);
	   }
	  else {
		waitAndClick(bromethalinRadiobutton);
	   }	
       }

     /**
     * verify bromethalin radio button is selected
      */

     public void verifyBromethalinButtonIsSelected() {
		verifyRadioButtonIsSelected(bromethalinRadiobutton);

	}

     /**
     *enter quantity of bait
     */

      

      public void EnterQuantityOfBaitInTextBox(String baitValue) {
	     inputText(baitTextBox, baitValue);
       }
      
    public void verifyBaitField(String baitValue) {

	String value=baitTextBox.getAttribute("value");
	Assert.assertEquals(baitValue, value);
   }
    
    /**
    * select bait unit from drop down
     */

    public void selectUnitFromDropDown(String ozvalue) {
	  selectDropDownByText(baitUnit, ozvalue);
	
   }
    /**
     * verify bait unit is selected
     * @param ozvalue
     */

    public void verifyUnitValueIsSelectedFromDropDown(String ozvalue) {
	    String value=returnSelectedValueFromDropdown(baitUnit);
	     Assert.assertEquals(ozvalue, value);
     }

    /**
     * Select less then 4 radio button
    */

    public void selectLeesThenFourRadioButton() {
      waitAndClick(LessThenFour);		
       }


    /**
     *verify less then 4 radio button is selected
    */

     public void verifyLessThenFourButtonIsSelected() {
	    Assert.assertTrue(LessThenFour.isSelected());
     }

    /**
      * verify result is displayed
     */

   public void verifyResultAreaDisplayed(){
	if(resultSection.isDisplayed()) {
		Assert.assertTrue(true);
     }
    }

    /**
    * verify Result is not displayed
    */

   public void verifyResultAreReset() {		
     _normalWait(3000);
     Assert.assertFalse(resultSection.isDisplayed());
						
		}
 
    /**
	 * Verify reset operation
	 */
	public void verifyResetOperation() {

		String value1=weightInLbs.getAttribute("value");
		String value2=weightInKGTextBox.getAttribute("value");
		if(value1==null&&value2==null) {
			Assert.assertTrue(true);
		}
	}

 
    public void verifyUserIsAbleToReset() throws InterruptedException {
	 String alertMessage= driver.switchTo().alert().getText();		
      Thread.sleep(2000);
        if(alertMessage.contains("Do you want to clear all your inputs")) {
        	Assert.assertTrue(true);
        }
   }
 
    /**
	 * Select ok on alert
	 */

	public void selectOkbuttoninAlert() throws InterruptedException {
		Alert alert= driver.switchTo().alert();		
	      Thread.sleep(1000);
	   if((alert.getText()).contains("Do you want to clear all your inputs")) {
		   alert.accept();

	        }
	}
	
    /**
    * click on close button of the model
    */
	
     public void clickOnClose() {
	    waitAndClick(closeButton);
	
        }
     
     /** 
      * verify user is able to close note model
      */

     public void verifyUserIsAbleToCloseNotesModel() {
     	 if(NSAIDMainPage.isDisplayed()) {
     		 Assert.assertTrue(true);
     		 System.out.println("note model is closed");
     	 }		
     }

     /**
      * select Nonsteroidal Anti-inflammatory Drug from drop down
      * @param AntiValue
      */

     public void selectAntiInflammatoryDrug(String AntiValue) {
     	  selectDropDownByText(antiDrugs, AntiValue);
     	
     }
     /**
      * verify Nonsteroidal Anti-inflammatory Drug is selected
      * @param AntiValue
      */
     
     public void verifyAntiInflammatoryDrugIsSelectedFromDropDown(String AntiValue) {
     	String value=returnSelectedValueFromDropdown(antiDrugs);
     	Assert.assertEquals(AntiValue, value);
     }

     /**
      * Select Enter Quality Radio button
      */

     public void SelectEnterQualityRadioButton() {
     if(qualityRadioButton.isSelected()) {
        Assert.assertTrue(true);
     }
     else {
        waitAndClick(qualityRadioButton);
     }
     }

     /**
      * verify user is able to select Enter Quality Radio button 
      */

     public void verifyEnterQualityRaduioButtonIsSelected() {
        Assert.assertTrue(qualityRadioButton.isSelected());
     }

     /** 
      * enter Quality Amount in Text Box
      */

     public void EnterQualityAmount(String amountValue) {
     	inputText(amountTextBox, amountValue);

     }
     
     /** 
      * verify Quality Amount in Text Box
      */
     
     public void verifyUserIsAbleToEnterQualityAmount(String amountValue) {
     	String value=amountTextBox.getAttribute("value");
     	Assert.assertEquals(amountValue, value);
     }
     

 	public void selectFromSpeciesDropDown(String species) {
 		selectDropDownByText(NSAIDspecies, species);
 	}
 	
 	public void verifyValueIsSelectedFromDropDown(String species) {
	    String value=returnSelectedValueFromDropdown(NSAIDspecies);
	     Assert.assertEquals(species, value);
     }








}
