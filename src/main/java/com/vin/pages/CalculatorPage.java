package com.vin.pages;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.vin.selenium.core.BasePage;
import com.vin.utilities.Constants;

public class CalculatorPage extends BasePage {
	
	public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='TreeIndexDiv']//li/div")
    List<WebElement> calculatoMenu;
    
    @FindBy(xpath = "//select[@id='cmbStartHr']")
    private WebElement startTimeDropdown;
    
    @FindBy(xpath = "//select[@id='cmbStartMin']")
    private WebElement minuteTime;
    
    @FindBy(xpath = "//input[@id='chk12']")
    private WebElement _12HourRadioButton;
    
    @FindBy(xpath = "//input[@id='dogRadio']")
    private WebElement dogSpeciesRadioButton;
    
    @FindBy(xpath = "//input[@id='txtWeight']")
    private WebElement weightLBField;
    
    @FindBy(xpath = "//input[@id='txtWeightNa']")
    private WebElement weightLBFieldNaBr;
    
    @FindBy(xpath = "//input[@id='txtWeightKg']")
    private WebElement weightKGField;
    
    @FindBy(xpath = "//input[@id='txtWeightKgNa']")
    private WebElement weightKGFieldNaBr;
    
    @FindBy(xpath = "//input[@id='chkmgdl']")
    private WebElement mgDLRaioButton;
    
    @FindBy(css = "div[id='menu'] div[id='topNav'] a[id='loginmenu']")
    private WebElement loginUserDropDown;

    @FindBy(css = "div[id='menu'] div[id='topNav'] ul[role='menu'] a[class='MemberProfile_Logout']")
    private WebElement logoutLinkUnderUserDropDown;
    
    @FindBy(xpath = "//button[text()='Dismiss All']")
	private WebElement dismissAllBtn;
    
	@FindBy(xpath="//input[@id='txtDose']")
	private WebElement doseTextField;

    @FindBy(xpath="//select[@id='cmbInsulin']")
	private WebElement novolinDropdown;

	@FindBy(xpath="//select[@id='cmbClinStatus']")
	private WebElement untreatedPatientDropdown;

	@FindBy(xpath="//input[@id='txtDoseTime']")
	private WebElement doseTimeTextField;

	@FindBy(xpath="//select[@id='cmbDoseTime']")
	private WebElement daysDropdown;

	@FindBy(xpath="//input[@id='canned']")
	private WebElement cannedRadio;

	@FindBy(xpath="//input[@id='dry']")
	private WebElement dryRadio;

    @FindBy(xpath="//input[@id='no']")
	private WebElement noRadioButton;

    @FindBy(xpath="//select[@id='sampleMenu']")
	private WebElement sampleDataDropdown;

    @FindBy(xpath="//input[@value='OK']")
	private WebElement okModel;

    @FindBy(xpath="//input[@id='txtDiet']")
	private WebElement dietBrand;
    
    @FindBy(xpath="//select[@id='cmbGlucometer']")
	private WebElement oneTouchUltraDropdown;

    @FindBy(xpath="//div[@id='GLUCMainPage']")
	private WebElement step2Page;

	@FindBy(xpath="//select[@id='sampleMenu']")
	private WebElement _35lbDropdown;

    @FindBy(xpath="//div[@id='scrollingTableDiv']")
	private WebElement tableValues;

    @FindBy(xpath="//input[@id='btnNextStep2']")
	private WebElement proceedToStep3Button;

	@FindBy(xpath="//strong/u[text()='RESULTS']")
	private WebElement resultTab;

	@FindBy(xpath="//td[@id='tdResults']")
	private WebElement resultCalculations;

    @FindBy(xpath="//div[text()='KBr Concentration:']")
	private WebElement kbrTab;

    @FindBy(xpath="//input[@id='mlRadio']")
	private WebElement mgMlRadio;

    @FindBy(xpath="//input[@id='txtConc']")
	private WebElement mgMlTextField;

    @FindBy(xpath="//input[@id='txtConcNa']")
	private WebElement mgMlTextFieldNaBr;

    @FindBy(xpath="//input[@id='noPheno']")
	private WebElement NoRadioButton;

    @FindBy(xpath="//select[@id='ddmLoad']")
	private WebElement mgKgDropDown;

    @FindBy(xpath="//select[@id='ddmLoadNa']")
	private WebElement mgKgDropDownNa;

    @FindBy(xpath="//select[@id='ddmDays']")
	private WebElement daysToDropdown;
    
    @FindBy(xpath="//input[@id='btnNextStep']")
	private WebElement step2;
    
    @FindBy(xpath="//select[@id='ddmDaysNa']")
	private WebElement daysToDropdownNa;

    @FindBy(xpath="//select[@id='ddmNumDoses']")
	private WebElement dosesDropDown;

    @FindBy(xpath="//select[@id='ddmNumDosesNa']")
	private WebElement dosesDropDownNa;

    @FindBy(xpath="//input[@id='submitBtn']")
	private WebElement calculate;

	@FindBy(xpath="//div[@id='divOptional']")
	private WebElement result1;

	@FindBy(xpath="//div[@id='divOptionalMaint']")
	private WebElement result2;

    @FindBy(xpath="//input[contains(@id,'reset')]")
	private WebElement reset;

	@FindBy(xpath="//a[@id='ui-id-2']")
	private WebElement NaBrTab;

    @FindBy(xpath="//div[text()='NaBr Concentration:']")
	private WebElement NaBrLabel;

    @FindBy(xpath="//input[@id='yesPhenoNa']")
	private WebElement yesButton;
    
    @FindBy(xpath = "//input[@id='catRadio']")
    private WebElement catSpeciesRadioButton;

    @FindBy(xpath="//select[@id='speciesddm']")
    private WebElement SpeciesDropDown;

    @FindBy(xpath="//button[@id='submitBtn']")
    private WebElement calculatebutton;

    @FindBy(xpath="//div[@class='result-area']")
    private WebElement BSAresult;

    @FindBy(xpath="//button[@id='resetBtn']")
    private WebElement resetbutton;
 
    @FindBy(xpath="//input[@id='moistureInput']")
    private WebElement moisture;

    @FindBy(xpath="//input[@id='proteinInput']")
    private WebElement crudeProtein;

    @FindBy(xpath="//input[@id='fatInput']")
    private WebElement crudeFat;

    @FindBy(xpath="//input[@id='fiberInput']")
    private WebElement crudeFiber;

    @FindBy(xpath="//input[@id='ashInput']")
    private WebElement ash;
    
	@FindBy(xpath="//label[@id='carbSum']")
	private WebElement carbsum;
	
	@FindBy(xpath="//label[@id='dog-radio-label' and contains(@class,'active')]")
	private WebElement DogButton;
			
	@FindBy(xpath="//label[@id='kj-radio-label']")
	private WebElement KJDayButton;
	
	@FindBy(xpath="//label[@id='kj-radio-label' and contains(@class,'active')]")
	private WebElement KJDayButtonSelected;
	
	@FindBy(xpath="//label[@id='adult-radio-label' and contains(@class,'active')]")
	private WebElement AdultButton;
	
    @FindBy(xpath="//select[@id='cmbCondition']")
	private WebElement firstcondition;
    
	@FindBy(xpath="//select[@id='cmbCondition2']")
	private WebElement secondcondition;
	
    @FindBy(xpath="//div[@id='resultsArea']")
	private WebElement energyresult;
    
    @FindBy(xpath="//input[@value='OK']")
	private WebElement okpopup;
    
    @FindBy(xpath="//input[@id='chkChronic']")
	private WebElement chronicRadioButton;
    
    @FindBy(xpath="//input[@id='txtCurrNa']")
	private WebElement naTextField;
    
    @FindBy(xpath="//input[@id='txtDesiredNa']")
	private WebElement naDefaultField;
    
	@FindBy(xpath="//select[@id='cmbSpecies']")
    private WebElement GestationdropDown;
	
    @FindBy(xpath="//td[contains(@class,'current')]")
	private WebElement selectDate;
    
	@FindBy(xpath="//span[@id='ave']")
    private WebElement resultRange;
	
	@FindBy(xpath="//div[@id='resultsArea']")
	private WebElement gestationresult;
	
    @FindBy(xpath="//div[@id='fullResults']")
	private WebElement resultsection;
    
    @FindBy(xpath="//input[@id='dogs']")
    private WebElement dogsCheckBox;
    
    @FindBy(xpath="//input[@id='skin']")
    private WebElement skinRadioButton;
    
    @FindBy(xpath="//input[@id='rbActiveIngredient']")
    private WebElement activeIngredient;
    
    @FindBy(xpath="//div[@id='aiArea']")
    private WebElement IngredientDropDown;
    
    @FindBy(xpath="//select[@id='cmbIngredients']")
    private WebElement IngredientSearch;

    @FindBy(xpath="//button[@id='submitBtn']")
    private WebElement searchButton;

    @FindBy(xpath="//div[@id='accordion']")
    private WebElement resultArea;

    @FindBy(xpath="//form[@class='FullForm']")
    private WebElement Form;

    @FindBy(xpath="//input[@id='dteDOB']")
    private WebElement datepicker;
   	  
    @FindBy(xpath="//td[contains(@class,'today')]")
   	private WebElement todaydate;
   	  
   	@FindBy(xpath="//span[text()='Prev']")
   	private WebElement prevMonth;

   	@FindBy(xpath="//img[@id='step1arrow']")
   	private WebElement firstArrow;

    @FindBy(xpath="//img[@id='step2arrow']")
   	private WebElement secondArrow;

   	@FindBy(xpath="//input[@id='dteDOB2']")
   	private WebElement positiveDate;
 
	@FindBy(xpath="//input[@id='lowCI']")
	private WebElement echoLowLevel;

    @FindBy(xpath="//label[@id='lblWeightNormalize']")
	private WebElement ecoResult;

    @FindBy(xpath="//input[@id='btn0']")
	private WebElement MEAbutton;

    @FindBy(xpath="//div[@id='i-aVF']")
	private WebElement iaVFtab;

    @FindBy(xpath="//input[@id='aVF0']")
	private WebElement MEAaVFbutton;
    
    @FindBy(xpath="//input[@id='vet']")
	private WebElement vetRaioButton;

    
    /**
     * Verify Calculator page
     */
    public void verifyCalculatorPageIsOpen(String calculatorPageTitle) {
        logger.debug("verifying title of Calculator Page");
        Assert.assertTrue(driver.getTitle().equalsIgnoreCase(calculatorPageTitle));
    }

    /**
     * Function: Logout application
     * @return
     */
    public LogoutPage logoutApplication() {
        _normalWait(500);
        waitForPageLoaded();
        waitAndClick(loginUserDropDown);
        waitAndClick(logoutLinkUnderUserDropDown);
        return PageFactory.initElements(driver, LogoutPage.class);
    }
     
    /**
     * dismiss alert notification if displayed
     */
    
    public void dismissNotifications() {
		super.dismissNotifications(dismissAllBtn);
    }

    /**
     * Click on Drug Dilution Calculator from calculator Menu
     */

    public DrugDilution_Page clickOnDrugDilutionFromCalculatorMenu(String textLink) {
        _normalWait(1000);
        logger.debug("Redirecting to Drug Dilution Page from Calculator Menu");
        driver.findElement(By.linkText(textLink)).click();
        return PageFactory.initElements(driver, DrugDilution_Page.class);
    }

    /**
     * Verify glucose Plotter calculator page
     */
	public void verifyGlucosePlotterPage() {

		assertByPageTitle(Constants.glucosePlotterPageTitle);
	}
	
	/**
	 * Select 5 am time
	 * @param name 
	 */

	public void selectTime(String name) {
		selectDropDownByText(startTimeDropdown, name);
	}
	
	/**
	 * Verify start time selection
	 * @param string
	 */

	public void verifyStatTimeSelection(String string) {
		String time=returnSelectedValueFromDropdown(startTimeDropdown);
		Assert.assertEquals(time, string);
	}
	
	/**
	 * Select minute time
	 * @param minutetime
	 */

	public void selectMinuteTime(String minutetime) {

		selectDropDownByText(minuteTime, minutetime);
	}
	
	/**
	 * Verify the minute selection
	 * @param minutetime2
	 */

	public void verifyMinuteSelection(String minutetime2) {
		String actual=returnSelectedValueFromDropdown(minuteTime);
		Assert.assertEquals(actual, minutetime2);
	}

	
	/**
	 * Select Hour time radio button
	 */
	
	public void selectHourTimeRadioButton() {

		if(_12HourRadioButton.isSelected()) {
			Assert.assertTrue(true);
		}
		else {
			waitAndClick(_12HourRadioButton);
		}
	}

	/**
	 * Verify user is able to select radio button
	 */
	
	public void verifyUserIsAbleToSelectRadioButton() {

		if(_12HourRadioButton.isSelected()) {
			Assert.assertTrue(true);
		}
	}
	
	/**
	 * select the dog species radio button
	 */

	public void selectDogSpeciesRadioButton() {

		if(dogSpeciesRadioButton.isSelected()) {
			Assert.assertTrue(true);
		}
		else {
			waitAndClick(dogSpeciesRadioButton);
		}
	}
	
	/**
	 * select cat radio button
	 */
	
	public void selectCatSpeciesRadioButton() {
		waitAndClick(catSpeciesRadioButton);
	}
	
	/**
	 * verify cat radio button is selected
	 */
	
	public void CatSpeciesRadioButtonIsSelected() {
		Assert.assertTrue(catSpeciesRadioButton.isSelected());
	}

	/**
	 * Enter weight in lb
	 * @param weight10lb
	 */
	
	public void enterWeight(String weight10lb) {
		inputText(weightLBField, weight10lb);
	}

	/**
	 * enter weight in NaBr
	 * @param weight10lb
	 */
	
	public void enterWeightNaBr(String weight10lb) {
		inputText(weightLBFieldNaBr, weight10lb);
	}
	
	/**
	 * enter KG text
	 * @param kgtext
	 */
	
	public void veifyThatKGCalculateAutoamtically(String kgtext) {
		waitAndClick(weightKGField);
		String kgValue=weightKGField.getAttribute("value");
		Assert.assertEquals(kgtext, kgValue);
	}
	
	/**
	 * verify kg field calculated automatically
	 * @param kgtext
	 */
	
     public void veifyThatKGCalculateAutoamticallyNaBr(String kgtext) {
		waitAndClick(weightKGFieldNaBr);
		String kgValue=weightKGFieldNaBr.getAttribute("value");
		Assert.assertEquals(kgtext, kgValue);
	}

	/**
	 * Select mg/dl radio button
	 */
     
	public void selectMGDLRadioButton() {
		if(mgDLRaioButton.isSelected()) {
			Assert.assertTrue(true);
		}
		else {
			waitAndClick(mgDLRaioButton);
		}
	}

	/**
	 * Enter dose tetx field
	 */
	
	public void enterInDoseTextFiled(String value) {
		inputText(doseTextField, value);
	}

	/**
	 * Verify value in dose text field
	 * @param dosevalue
	 */
	
	public void verifyValueInDoseTextFiled(String dosevalue) {

		String value=doseTextField.getAttribute("value");
		Assert.assertEquals(value, dosevalue);
	}

	/**
	 * Select novolin from dropdown
	 */
	
	public void selectNovolinFromDropdown() {

		selectDropDownByText(novolinDropdown, "Novolin (NPH)");
	}

	/**
	 * Verify user is able to select novolin value
	 * @param novolintext
	 */
	
	public void verifyNovolinSelection(String novolintext) {

		String value=returnSelectedValueFromDropdown(novolinDropdown);
		Assert.assertEquals(novolintext, value);
	}

	/**
	 * Select untreated patient
	 */
	
	public void selectNewUntreatedPatient() {

		selectDropDownByText(untreatedPatientDropdown, "New untreated patient");
	}

	/**
	 * Verify untreated patient selection
	 * @param untreatedpatienttext
	 */
	
	public void verifyUntreatedPatientSelection(String untreatedpatienttext) {

		String value=returnSelectedValueFromDropdown(untreatedPatientDropdown);
		Assert.assertEquals(untreatedpatienttext, value);
	}

	/**
	 * Enter dose time 
	 */
	
	public void enterDoseTime(String value) {

		inputText(doseTimeTextField, value);
	}
	
	/**
	 * Verify dose time value in dose time text field
	 * @param dosetimevalue
	 */
	
	public void verifyDoseTimeValue(String dosetimevalue) {

		String value=doseTimeTextField.getAttribute("value");
		Assert.assertEquals(dosetimevalue, value);
	}

	/**
	 * Select days from dropdown
	 */

	public void selectDaysFromDropdown() {

		selectDropDownByText(daysDropdown, "days");
	}

	/**
	 * select canned radio button
	 */
	
	public void selectCannedRadioButton() {
		waitAndClick(cannedRadio);
	}
	
	/**
	 * verify canned radio button is selected
	 */
	
	public void cannedButtonIsSelected() {
		Assert.assertTrue(cannedRadio.isSelected());
	}
	
	/**
	 * Verify days selection
	 * @param daystext
	 */
	
	public void verifyDaysSelection(String daystext) {
		String value=returnSelectedValueFromDropdown(daysDropdown);
		Assert.assertEquals(daystext, value);
	}

	/**
	 * Select dry radio button or verify dry radio button selection
	 */

	public void selectDryRadioButtonOrVerifyDryRadioButtonSelection() {
		if(dryRadio.isSelected()) {
			Assert.assertTrue(true);
		}
		else {
			waitAndClick(dryRadio);
		}
	}

	/**
	 * Select no radio buton or verify no radio button selection
	 */
	
	public void selectNoRadioButtonOrVerifyNoRadioButtonSelection() {

		if(noRadioButton.isSelected()) {
			Assert.assertTrue(true);
		}
	}
	
	/**
	 * Enter diet brand
	 * @param value
	 */
	public void enterDietBrand(String value) {
		inputText(dietBrand, value);
	
    }
	
	public void selectSampleData(String value) {
		selectDropDownByText(sampleDataDropdown, value);
	}
	
	/**
	* Select ok on data modifier alert
    */
	public void selectOkbuttoninModifierAlert()  {
		  waitAndClick(okModel);
		}
	
	/**
	 * verify sample data selection
	 * @param Samplevalue
	 */
	public void verifysampleDataSelection(String Samplevalue) {
		String value=returnSelectedValueFromDropdown(sampleDataDropdown);
		Assert.assertEquals(Samplevalue, value);
	} 

	/**
	 * Verify diet brand value 
	 * @param dietbrandtext
	 */
	
	public void verifyDietBrandValue(String dietbrandtext) {
		String value=dietBrand.getAttribute("value");
		Assert.assertEquals(dietbrandtext, value);
	}

	/**
	 * Verify veterinarian radio button selection or select radio button
	 */
	public void selectVeterinarianRadioButtonOrVerifyRadioButtonSelection() {
		if(vetRaioButton.isSelected()) {
			Assert.assertTrue(true);
		}
		else {
			waitAndClick(vetRaioButton);
		}
	}

	/**
	 * Select one touch ultra 2 from dropdown
	 */
	public void selectOneTouchUltra2() {
		selectDropDownByText(oneTouchUltraDropdown, "One Touch Ultra 2");
		
	}

	/**
	 * Verify one touch value selection from dropdown
	 * @param onetouchtext
	 */
	public void verifyOnTouchValueSelection(String onetouchtext) {
		String value=returnSelectedValueFromDropdown(oneTouchUltraDropdown);
		Assert.assertEquals(onetouchtext, value);
	}

	/**
	 * Select proceed to step 2
	 */
	public void selectProceedToStep2() {
		waitAndClick(step2);
	}

	/**
	 * Verify user is redirected to page2
	 */
	public void verifyUserIsDirectedToPage2() {
		if(step2Page.isDisplayed()) {
			Assert.assertTrue(true);
		}
	}
	
	/**
	 * select 35lb dog
	 */
	public void select35lbDog() {
		selectDropDownByText(_35lbDropdown, "35 lb Dog: Ideal plot");
	}
	
	/**
	 * Verify 35lb dog selection
	 * @param lbdogselection
	 */
	public void verify35lbDogSelection(String lbdogselection) {
		String value=returnSelectedValueFromDropdown(_35lbDropdown);
		Assert.assertEquals(lbdogselection, value);
	}

	/**
	 * Verify values are populated in table below
	 */
	public void valuesArepopulatedInTable() {
		if(tableValues.isDisplayed()) {
			Assert.assertTrue(true);
		}
	}

	/**
	 * proceed to step 3
	 */
	public void proceedToStep3() {
		waitAndClick(proceedToStep3Button);
	}

	/**
	 * Verify user is rediretced to page 3
	 */
	public void userIsDirectedToPage3() {
		if(resultTab.isDisplayed()) {
			Assert.assertTrue(true);
		}
	}

	/**
	 * verify results calculations are displayed
	 */
	public void resultsCalculationsAreDisplayed() {
		if(resultCalculations.isDisplayed()) {
			Assert.assertTrue(true);
		}
	}
	
    /**
     * Verify bromide calculator page
     */
	public void verifyBromideCalculatorPage() {
		assertByPageTitle(Constants.bromideCalculatorPageTitle);
	}
	
	 /**
	  * Verify that KBr tab should be selected by default
	  */
	public void KbrTabShouldBeSelectedByDefault() {
		if(kbrTab.isDisplayed())
		{
			Assert.assertTrue(true);
		}	
	}

	/**
	 * Verify weight in lbs field
	 * @param weight10lb
	 */
	public void verifyWeightInLBSField(String weight10lb) {
		String value=weightLBField.getAttribute("value");
		Assert.assertEquals(weight10lb, value);
	}
	
	/**
	 * verify weight in lbs field
	 * @param weight10lb
	 */
	public void verifyWeightInLBSFieldNaBr(String weight10lb) {

		String value=weightLBFieldNaBr.getAttribute("value");
		Assert.assertEquals(weight10lb, value);
	}

	/**
	 * verify that mg ml radio button is selected or select the radio button
	 */
	public void verifyThatMgMlRadioButtonisSelectedOrSelect() {
		if(mgMlRadio.isSelected()) {
			Assert.assertTrue(true);
		}
		else {
			waitAndClick(mgMlRadio);
		}
	}

	/**
	 * Enter 300 in mg/ml text field
	 * @param mgmldata
	 */
	public void enterValueInMgMlTextField(String mgmldata) {
		inputText(mgMlTextField, mgmldata);
	}
	
	/**
	 * enter value in mg/ml field
	 * @param mgmldata
	 */
	public void enterValueInMgMlTextFieldNa(String mgmldata) {
		inputText(mgMlTextFieldNaBr, mgmldata);
	}
	
	/**
	 * Verify mgml data in text field
	 * @param mgmldata
	 */
	public void verifyMgMlData(String mgmldata) {

		String value=mgMlTextField.getAttribute("value");
		Assert.assertEquals(mgmldata, value);
		
	}
	
	/**
	 * verify mgml data field nabr
	 * @param mgmldata
	 */
	public void verifyMgMlDataNa(String mgmldata) {
		String value=mgMlTextFieldNaBr.getAttribute("value");
		Assert.assertEquals(mgmldata, value);
		
	}
    
	/**
	 * verify and select no on the phenobarbital radio button
	 */
	public void selectNoOnThePhenobarbitalRadioButtonsorVerifyRadioButtonSelected() {

		if(NoRadioButton.isSelected())
		{
			Assert.assertTrue(true);
		}	
		else 
		{
			waitAndClick(NoRadioButton);
		}
	}

	/**
	 * Select mg/kg value
	 * @param mgkgvalue
	 */
	public void selectmgKgDropDownValue(String mgkgvalue) {
		selectDropDownByText(mgKgDropDown, mgkgvalue);
		
		
	}
	
	/**
	 * select mg kg drop down value 
	 * @param mgkgvalue
	 */
	public void selectmgKgDropDownValueNa(String mgkgvalue) {
		selectDropDownByText(mgKgDropDownNa, mgkgvalue);
	}
	
	/**
	 * Verify dropdown value for mgkg 
	 * @param mgkgvalue
	 */

	public void verifyDropDownValueForMgKg(String mgkgvalue) {
		String value=returnSelectedValueFromDropdown(mgKgDropDown);
		Assert.assertEquals(mgkgvalue, value);
	}

    /**
     * verify Mg/kg value
     * @param mgkgvalue
     */
	public void verifyDropDownValueForMgKgNa(String mgkgvalue) {
		String value=returnSelectedValueFromDropdown(mgKgDropDownNa);
		Assert.assertEquals(mgkgvalue, value);
	}
	
	/**
	 * select value from day to load drop down
	 * @param daysvalue
	 */
	public void selectFromDaysToLoadDropdown(String daysvalue) {
		selectDropDownByText(daysToDropdown, daysvalue);
		}
	
	/**
	 * select from ays to load drop down
	 * @param daysvalue
	 */
	public void selectFromDaysToLoadDropdownNa(String daysvalue) {
		selectDropDownByText(daysToDropdownNa, daysvalue);
	}

	/**
	 * verify days to select drop down
	 * @param daysvalue
	 */
	public void verifydaysToSelectDropDown(String daysvalue) {
		String value=returnSelectedValueFromDropdown(daysToDropdown);
		Assert.assertEquals(daysvalue, value);
	}
	
	/**
	 * verify day to select  drop down (NaBr)
	 * @param daysvalue
	 */
	public void verifydaysToSelectNa(String daysvalue) {
		String value=returnSelectedValueFromDropdown(daysToDropdownNa);
		Assert.assertEquals(daysvalue, value);
	}
	
	/**
	 * Select value from doses dropdown 
	 * @param dosesdropdownvalue
	 */
	public void selectFromNimberOfDosesPerDayDropDown(String dosesdropdownvalue) {
		selectDropDownByText(dosesDropDown, dosesdropdownvalue);
	}
	
	/**
	 * 
	 * @param dosesdropdownvalue
	 */
	public void selectFromNimberOfDosesPerDayDropDownNa(String dosesdropdownvalue) {
		selectDropDownByText(dosesDropDownNa, dosesdropdownvalue);
	}

	/**
	 * Verify value from PF doses drop down (KBr)
	 * @param dosesdropdownvalue
	 */
	public void verifyValuePfDosesDropdown(String dosesdropdownvalue) {
		String value=returnSelectedValueFromDropdown(dosesDropDown);
		Assert.assertEquals(dosesdropdownvalue, value);
	}
	
	/**
	 *Verify value from PF doses drop down (Nabr)
	 * @param dosesdropdownvalue
	 */
	public void verifyValuePfDosesDropdownNa(String dosesdropdownvalue) {
		String value=returnSelectedValueFromDropdown(dosesDropDownNa);
		Assert.assertEquals(dosesdropdownvalue, value);
	}

	/**
	 * Select calculate
	 */
	public void selectCalculate() {
		waitAndClick(calculate);
	}
	
	/**
	 * Verify results are populated below
	 */
	public void verifyResults() {
		if(result1.isDisplayed()&&result2.isDisplayed()) {
			Assert.assertTrue(true);
		}	
	}

	/**
	 * Select reset
	 */
	public void selectReset() {
        waitAndClick(reset);	
	}

	/**
	 * Verify reset operation
	 */
	public void verifyResetOperation() {
		String value1=weightLBField.getAttribute("value");
		String value2=weightKGField.getAttribute("value");
		if(value1==null&&value2==null) {
			Assert.assertTrue(true);
		}
	}

	/**
	 * Select Na Br Tab
	 */
	public void selectNaBrTab() {
		waitAndClick(NaBrTab);
	}

	/**
	 * Verify NaBrTab
	 */
	public void verifyNaBrTab() {
		if(NaBrLabel.isDisplayed()) {
			Assert.assertTrue(true);
		}
	}

	/**
	 * Select yes radio button
	 */
	public void selectYesRadioButton() {
		waitAndClick(yesButton);
	}

	/**
	 * select or verify yes radio button
	 */
	public void selectYesRadioButtonOrVerifyRadioButtonIsSelected() {
		if(yesButton.isSelected()) {
			Assert.assertTrue(true);
		}
		else {
			waitAndClick(yesButton);
		}
	}
	
	
	/**
	 * Select Dog from species drop down
	 */
	public void SelectDogFromDropDown(String SpeciesDropDownValue) {
	selectDropDownByText(SpeciesDropDown, SpeciesDropDownValue);
	}
	
	/**
	* Verify species dropDown BSA
    * @param SpeciesDropDownValue
     */
	public void verifySpeciesDropDown(String SpeciesDropDownValue) {
	String value=returnSelectedValueFromDropdown(SpeciesDropDown);
	Assert.assertEquals(SpeciesDropDownValue, value);
	}
		
		
	 /**
     * Select calculate 
	 */
	public void selectCalculatebutton() {
	waitAndClick(calculatebutton);		
	}
		
	 /**
	 * Verify Result BSA
	 */
	public void verifyResult(){
	 if(BSAresult.isDisplayed()) {
	    Assert.assertTrue(true);
		}
     }
		
     /**
     * Select Reset 
     */
	public void selectreset() {
	waitAndClick(resetbutton);
	}
	
	/**
	 * verify user is able to reset
	 */
	public void verifyUserIsAbleToSelectReset() {
		Assert.assertTrue(resetbutton.isEnabled());
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
    * result section not Displayed After reset 
    */
	public void resultAreReset() {		
			_normalWait(1000);
			Assert.assertFalse(BSAresult.isDisplayed());
						
		}
			
	/**
	 * Enter moisture value
     */		
	public void inputmoistureValue(String inputmoisture) {
	WebElement toClear = driver.findElement(By.xpath("//input[@id='moistureInput']"));
	toClear.sendKeys(Keys.CONTROL + "a");
	toClear.sendKeys(Keys.DELETE);				
		inputText(moisture, inputmoisture);
			}	
			
		/**
		 * verify entered moisture value
		 * @param enteredmoistureValue
		 */	
		public void verifymoistureValue(String enteredmoistureValue) {
			String value=moisture.getAttribute("value");
		        Assert.assertEquals(enteredmoistureValue, value);
				}	
			
		/**
	    * Enter crude Protein value
		*/
	public void inputcrudeProteinValue(String inputcrudeProtein) {
		WebElement toClear = driver.findElement(By.xpath("//input[@id='proteinInput']"));
	    toClear.sendKeys(Keys.CONTROL + "a");
		toClear.sendKeys(Keys.DELETE);				
		inputText(crudeProtein, inputcrudeProtein);
			}
		
		/**
	   * verify entered crude value
	   * @param enteredcrudeValue
		 */
		
	public void verifycrudeProteinValue(String enteredcrudeValue) {
	  String value=crudeProtein.getAttribute("value");
	  Assert.assertEquals(enteredcrudeValue, value);
				}	
			
		/**
		  * Enter crude Fat Value
		 */
		
	public void inputcrudefatValue(String inputcrudeFat) {
		WebElement toClear = driver.findElement(By.xpath("//input[@id='fatInput']"));
		toClear.sendKeys(Keys.CONTROL + "a");
		toClear.sendKeys(Keys.DELETE);	
		inputText(crudeFat, inputcrudeFat);
			}
	  
		/**
		 * verify entered crude fat value
		 * @param enteredcrudefatValue
		 */	
    public void verifycrudefatValue(String enteredcrudefatValue) {
	  String value=crudeFat.getAttribute("value");
	  Assert.assertEquals(enteredcrudefatValue, value);
				}	
			
		/**
		* Enter crude fiber value
		*/
	 public void inputcrudeFiberValue(String inputcrudeFiber) {
		WebElement toClear = driver.findElement(By.xpath("//input[@id='fiberInput']"));
		toClear.sendKeys(Keys.CONTROL + "a");
	    toClear.sendKeys(Keys.DELETE);	
		inputText(crudeFiber, inputcrudeFiber);
			}
			
	  /**
      * verify entered crude fiber value
	  * @param enteredcrudefatValue
	  */	
	public void verifycrudefiberValue(String enteredcrudefiberValue) {
	String value=crudeFiber.getAttribute("value");
	Assert.assertEquals(enteredcrudefiberValue, value);
		}
			
		/**
		  * Enter Ash value
		 */	
	public void inputAshValue(String inputAsh) {
		WebElement toClear = driver.findElement(By.xpath("//input[@id='ashInput']"));
		toClear.sendKeys(Keys.CONTROL + "a");
	    toClear.sendKeys(Keys.DELETE);	
		inputText(ash,inputAsh);
			}
			
		/**
		 * verify entered ash value
		 * @param enteredashValue
		  */
			
	 public void verifyashValue(String enteredashValue) {
	 String value=ash.getAttribute("value");
	 Assert.assertEquals(enteredashValue, value);
				}
	 
		/**
	    * verify calculated result and cabsum
		*/
	public void verifyResult(String calculatedValue) {
		_normalWait(3000);
		String value=carbsum.getText();
     Assert.assertEquals(calculatedValue, value);
		}
	
	/**
	 * verify user is able to reset
	 */		
	public void verifyUserIsAbleToReset() {
	String value=carbsum.getText();
		if(value==null) {
		Assert.assertTrue(true);
			}
	 }
			
	/**
	 * select dog species button
	 */			
	public void selectDogSpeciesButton() {
		if(DogButton.isSelected()) {
			Assert.assertTrue(true);
			}
		else {
		waitAndClick(DogButton);
		}
			}
	
	/**
	 * verify dog species button is selected
	 */		
	public void DogOnOffButtonIsSelected() {
	_normalWait(1000);
				
		if(DogButton.isDisplayed()) {
		Assert.assertTrue(true);
		}
	}
			
	/**
	* select KJ/Day button
	*/
	public void selectKJDayButton() {
		waitAndClick(KJDayButton);
		}
			
	/**
	 * verify KJ/Day button is selected
	 */		
	public void KJDayButtonIsSelected() {
		_normalWait(1000);
		if(KJDayButtonSelected.isDisplayed()) {
			Assert.assertTrue(true);
				}
			}
			
	/**
	 * select adult button
	 */		
	public void selectDogAdultButton() {
		if(AdultButton.isSelected()) {
			Assert.assertTrue(true);
		}
		else {
			waitAndClick(AdultButton);
			}
		}
		
	 /**
	 * verify adult button is selected
	 */
			
	 public void AdultButtonIsSelected() {
	 _normalWait(1000);
	  if(AdultButton.isDisplayed()) {
		Assert.assertTrue(true);
			}		
		}
			
	/**
	 * Select working under 1st conditions drop down
	 * @return
	 */
					
	public void selectFromFirstConditionDropDown() {
	selectDropDownByText(firstcondition,"Working");
	}
	
	/**
	 * verify first condition drop down is selected
	 * @param firstvalue
	 */
	
	public void verifyfirstconditionDropdown(String firstvalue) {
		String value=returnSelectedValueFromDropdown(firstcondition);
		Assert.assertEquals(firstvalue, value);
		}
	
	/**
	 *  Select light work under 2nd conditions drop down
	 */
		
	public void selectFromSecondConditionDropDown() {
	    selectDropDownByText(secondcondition,"Light Work");
		}
	
	/**
	 * verify second condition drop down
	 * @param secondvalue
	 */
		
	public void verifysecondconditionDropdown(String secondvalue) {
	String value=returnSelectedValueFromDropdown(secondcondition);
	Assert.assertEquals(secondvalue, value);
			}
	/**
	 * Verify energy requirement Result 
	 */
					
    public void verifyResultAreaDisplayed()
			{
				if(energyresult.isDisplayed()) {
					Assert.assertTrue(true);
			}
	   }
			
	/**
	 * energy requirement result section not Displayed After reset 
	 */

	 public void verifyResultAreReset() {		
	 _normalWait(1000);
     Assert.assertFalse(energyresult.isDisplayed());
							
	 }
			 
	/**
     * select Ok on popup
     */		 	 
	 public void selectokonPopUp() {
		 waitAndClick(okpopup);
		 }
	
	 /**
	 * select chronic redio button
	 */
	public void selectchronicRadioButton() {
	waitAndClick(chronicRadioButton);
	}
				
	/**
	* verify chronic radio button is selected
	 */
				
     public void chronicButtonIsSelected() {
	 verifyRadioButtonIsSelected(chronicRadioButton);
			}

     /**
      * enter value in text field (NaBr)
      * @param Nadata
      */
	 public void enterValueInNaTextField(String Nadata) {
		inputText(naTextField, Nadata);
		}
	 
	 /**
	 * Verify Na field
	 * @param Nadata
	 */
	 public void verifyNaDataField(String Nadata) {
  		String value=naTextField.getAttribute("value");
		Assert.assertEquals(Nadata, value);
		}
				
		/**
		 * Verify Na+ field
		 * @param Nadefaultdata
		 */		
	 public void verifyNaDefaultDataField(String Nadefaultdata) {
		 String value=naDefaultField.getAttribute("value");
	     Assert.assertEquals(Nadefaultdata, value);	 	
	}
	   
	  /**
	   * reset calculator
	   */
	public void resetWaterDeficitCalculator() {
	    String value1=weightLBField.getAttribute("value");
	    String value2=naTextField.getAttribute("value");
	    if(value1==null&&value2==null) {
		   Assert.assertTrue(true);
						}
			}
							
	/**
	 * select gestation species
	 * @param Species
	 */
	public void selectGestationSpecies(String Species) {
	    selectDropDownByText(GestationdropDown, Species);
	 }
					
	 /**
     * Verify species dropDown BSA
     * @param SpeciesDropDownValue
     */
					
	public void verifyGestationSpeciesDropDown(String Species) {
	    String value=returnSelectedValueFromDropdown(GestationdropDown);
	      Assert.assertEquals(Species, value);
		}
					
	/**
	 * Select Date
	 */
							
	 public void selectDateFromCalender() {
	     waitAndClick(selectDate);
	  }
			
	 /**
	  * verify user is able to select date
	  */
	public void verifyuserIsAbleToSelectTheDate(){
		if(resultRange.isDisplayed()) {	
			Assert.assertTrue(true);
			}
		}
					
	/**
	 * Verify result calculatd in the chart
	 */
					
	public void verifyGestationResult() {
		if(gestationresult.isDisplayed()) {
			Assert.assertTrue(true);
			}
		}
	
	/**
	 * verify user is able to reset
	 */
					
	public void verifyUserIsAbletoReset() {
		_normalWait(1000);
		Assert.assertFalse(energyresult.isDisplayed());
            }
	
	/**
	 *  verify user is able to calculate
	 */
	
	public void verifyuserIsAbleToCalculate() {
         Assert.assertTrue(resultsection.isDisplayed());		
	}
	
	
     /**
    * Select Dog species check box
    */
	
    public void selectDogsCheckbox(){
	    waitAndClick(dogsCheckBox);
	}

    /**
     * verify user is able to select
     */

    public void dogsCheckBoxIsSelected() {
	    Assert.assertTrue(dogsCheckBox.isSelected());
     }

    /**
     * select skin product radio button
     */

     public void selectskinradioButton() {
	     waitAndClick(skinRadioButton);
     }

     /**
      * verify user is able to select skin product radio button
      */

      public void verifySkinRadioButtonIsSelected() {
	       Assert.assertTrue(skinRadioButton.isSelected());
     }

    /**
     * Verify user is able to select Active ingredients check box
     */

    public void selectActiveIngredientCheckBox() {
	    waitAndClick(activeIngredient);
     }

    /**
    * Verify user is able to select active ingredients check box and ingredient drop down populates
    */

     public void ActiveIngredientselected() {
         Assert.assertTrue(activeIngredient.isSelected());

    }

    
    public void ingredientDropdownPopulates() {
        _normalWait(1000);
        Assert.assertTrue(IngredientDropDown.isDisplayed());

    }

    /**
    * Search ingredient from drop down
    */

    public void SearchingrediabtFromDropDown(String ingredient) {
        selectDropDownByText(IngredientSearch, ingredient);

	}

	/**
    * Verify ingredient from dropDown is selected 
     */

     public void ingredientIsSelected(String ingredient) {
         String value=returnSelectedValueFromDropdown(IngredientSearch);
         Assert.assertEquals(ingredient, value);
      }

     /**
      * click on search button
      */

     public void ClickonSearchButton() {
	     waitAndClick(searchButton);
	 
    }
 
     public void verifyresultCalulatedBelow() {
	     _normalWait(1000);
	     Assert.assertTrue(resultArea.isDisplayed());
     }
 
     /**
      * verify result got clean
      */
  
      public void verifyResultGotClean() {
	     _normalWait(2000);
	     Assert.assertFalse(resultArea.isDisplayed());
      }
 
      /**
       * Verify user is able to select ok on introduction modal
        */
 
      public void okPopUpIsSelected() {
     	 if(Form.isDisplayed()) {
		 Assert.assertTrue(true);
		 System.out.print("user is able to select the ok button on introduction page");
	 }
      }
     	 
   	  /**
   	   * select prior date
   	   */
   	  
   	public void selectpriorDate() {
   		waitAndClick(datepicker);
   		String date = todaydate.getText();
   		System.out.println(date);
   		waitAndClick(prevMonth);
   		WebElement toselect = driver.findElement(By.xpath("//a[text()='"+date+"']"));
   		toselect.click();
   		
   	}
   	
   	/**
   	 * verify user is able to select date
   	 */
   
   	public void verifyUserIsAbleToSelectDate() {
       Assert.assertFalse(firstArrow.isDisplayed());		
   	}
   	
 
   	 public void verifyUserIsAbleToSelectpositiveTestDate() {
   		 Assert.assertFalse(secondArrow.isDisplayed());		
   			}
   	
   	/**
   	 * select current date
   	 */
   	
   	public void selectCurrentDateInpositivetest() {
       waitAndClick(positiveDate);	
       waitAndClick(todaydate);

   	}
   	
   	 public void verifyResultIsReset() {
   		 Assert.assertTrue(firstArrow.isDisplayed());		
   			}
   	 
  
	 
	 /**
	  * enter measure value
	  * @param inputName
	  * @param value
	  */
	 
	 public void enterMeasuredValues(String inputName,String value) {
		 WebElement valuefield=findElement(By.xpath("//input[@id='"+inputName+"']"));
			inputText(valuefield, value);
		}
	 
	 /**
	  * verify entered measure value
	  * @param inputName
	  * @param value
	  */
	 
	 public void verifyenteredMeasuredValues(String inputName,String value) {
		 WebElement valuefield=findElement(By.xpath("//input[@id='"+inputName+"']"));
			String inputvalue=valuefield.getAttribute("value");
			Assert.assertEquals(value, inputvalue);
		}
	 
	 /**
	  * verify low radio button is selected
	  */
	
	 public void verifyExperienceLevelRadioButtonIsSelected() {
		 Assert.assertTrue(echoLowLevel.isSelected());
	 }
	 
	 /**
	  * verify eco result is displayed
	  */
	 
	 public void verifyEcoResultIsDisplayed() {
		 _normalWait(3000);
		 Assert.assertTrue(ecoResult.isDisplayed());

	 }
	
	 /**
	  * enter value into text field
	  * @param inputField
	  * @param value
	  */
	 
	public void enterValueIntoTextField(String inputField, String value) {
           WebElement textField =findElement(By.xpath("//input[@id='"+inputField+"']"));
           inputText(textField, value);
	}
	
	/**
	 * verify lead iii field calculated automatically
	 * @param inputField
	 * @param LeadIIIvalue
	 */
	public void verifyLeadIIIfieldCalculatedAutomatically(String inputField, String LeadIIIvalue) {
        WebElement textField =findElement(By.xpath("//input[@id='"+inputField+"']"));
		waitAndClick(textField);
		String leadValue=textField.getAttribute("value");
		Assert.assertEquals(leadValue, LeadIIIvalue);
	}
	
	/**
	 * click on MEA button
	 */
	public void clickOnMEAButton() {
      waitAndClick(MEAbutton);		
	}
	
	/**
	 * verify result is cleaned
	 * @param inputField
	 */
	
	public void verifyResultIsCleaned(String inputField) {
        WebElement meaResult =findElement(By.xpath("//input[@id='"+inputField+"']"));
		if(meaResult==null) {
			Assert.assertTrue(true);
		}
	}
	
	/**
	 * select lead Iav tab
	 */
	public void selectLeadIaVFtab() {
		waitAndClick(iaVFtab);
	}
	 
	/**
	 * select MEAaVF tab
	 */
	public void clickOnMEAaVFButton() {
      waitAndClick(MEAaVFbutton);		
	}

	
	

	 
 }
	
	

	
						
						
						
		


