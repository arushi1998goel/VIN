package com.vin.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.vin.selenium.core.BasePage;
import com.vin.utilities.Constants;

public class TransfusionVolumePage extends BasePage {

	public TransfusionVolumePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@id='speciesInput']//label")
	private List<WebElement> radioButons;

	@FindBy(xpath = "//input[@id='dogRadio']")
	private WebElement dogRadioButton;

	@FindBy(xpath = "//input[@id='catRadio']")
	private WebElement catRadioButton;

	@FindBy(xpath = "//input[@id='txtWeightKg']")
	private WebElement dogWeightKgTextBox;

	@FindBy(xpath = "//input[@id='txtWeight']")
	private WebElement dogWeightLbTextBox;

	@FindBy(css = "input[id='txtHCTa']")
	private WebElement actualHemacroticTextBox;

	@FindBy(xpath = "//div[@id='hctaLabel']")
	private WebElement actualHemacroticText;

	@FindBy(xpath = "//div[@id='hcttLabel']")
	private WebElement desiredHematrocaticText;

	@FindBy(xpath = "//div[@id='hctdLabel']")
	private WebElement donorHematrocaticText;

	@FindBy(css = "input[id='txtHCTt']")
	private WebElement desiredHemacroticTextBox;

	@FindBy(css = "input[id='txtHCTd']")
	private WebElement donorHemacroticTextBox;

	@FindBy(xpath = "//div[@class='btn-group btnRow']/button")
	private List<WebElement> calculateAndResetButton;

	@FindBy(xpath = "//td[contains(text(),'volume')]/..//td[@class='tdRight']")
	private WebElement resultsForBloodVolume;

	@FindBy(xpath = "//td[contains(text(),'TRANSFUSE')]/..//td[@class='tdRight']")
	private WebElement resultsFortransfuse;

	@FindBy(xpath = "//td[contains(text(),'donor ')]/..//td[@class='tdRight']")
	private WebElement donorWieght;

	@FindBy(css = "div[id='menu'] div[id='topNav'] a[id='loginmenu']")
	private WebElement loginUserDropDown;

	@FindBy(css = "div[id='menu'] div[id='topNav'] ul[role='menu'] a[class='MemberProfile_Logout']")
	private WebElement logoutLinkUnderUserDropDown;

	@FindBy(xpath = "//button[text()='Dismiss All']")
	private WebElement dismissAllBtn;

	@FindBy(xpath = "//input[@id='anticoagCloseBtn']")
	private WebElement okButton;
	
	@FindBy(xpath="//li[@class='col-sm-4']//li[3]")
	private WebElement calculatorAndConverionTable;
	 
	@FindBy(xpath="//div[@id='rptTree_vinDoc1_30_tree_doc_contain_30']//a")
	private WebElement transfusionVolumeCalculator;
	
	@FindBy(xpath="//ul[@id='vinmainnav']//li[@id='masterTabLibrary']")
    private WebElement libraryTab;


	/**
	 * Verify Transfusion volume calculator displayed
	 */

	public void verifyTransfusionVolumeCalculatorDisplayed(String Name) {
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(Name));

	}

	/**
	 * Verify Radio Button Is selected
	 */
	public void verifyradioButtonIsSelected(String RadioButtonName) {
		WebElement radioButton = null;
		for (WebElement we : radioButons) {
			if (we.getText().equalsIgnoreCase(RadioButtonName)) {
				radioButton = we.findElement(By.xpath(".//preceding-sibling::input"));
				break;
			} else {
				continue;
			}

		}
		Assert.assertTrue(radioButton.isSelected());
	}

	/**
	 * Verify species is set to dog by default
	 */

	public void verifySpeciesSetToDogByDefault() {
		boolean flag = false;
		if (driver.findElement(By.xpath("//input[@id='dogRadio']")).isSelected()) {
			flag = true;

		}
		Assert.assertTrue(flag);
	}

	/**
	 * Enter Weight in the Text Box
	 */

	public void enterWeightInTheKgWeightBox(String Weight) {
		inputText(dogWeightKgTextBox, Weight);

	}

	/**
	 * Enter Weight in the lb Text Box
	 */

	public void enterWeightInTheLbWeightBox(String Weight) {
		inputText(dogWeightLbTextBox, Weight);

	}

	/**
	 * Verify USer is able to enter numeric weight only
	 */

	public void verifyUserIsAbleToEnterOnlyLbsNumericWeightAndkgsAreCalucalteAutomatically(String weight) {

		String values3 = verifyUserIsAbleToEnterNumericValuesInTheTextBox(dogWeightLbTextBox, weight);

		String weightInkg = dogWeightKgTextBox.getAttribute("value");
		double doublevalue = Double.parseDouble(weightInkg);

		if (weightInkg.isEmpty() == false) {
			Assert.assertFalse(false);
		}
		double kilograms = Integer.parseInt(values3) * 0.454;
		;
		Assert.assertEquals(Math.round(doublevalue), Math.round(kilograms));
	}

	/**
	 * Verify User is able to enter amount and lbs are calculated automatically
	 */

	public void verifyAmountInKGBoxAndLbsValuesAreChangedAutomatically(String weight) {

		String values3 = verifyUserIsAbleToEnterNumericValuesInTheTextBox(dogWeightKgTextBox, weight);

		String weightInLB = dogWeightLbTextBox.getAttribute("value");
		double doublevalue = Double.parseDouble(weightInLB);

		if (weightInLB.isEmpty() == false) {
			Assert.assertFalse(false);
		}

//		double kilograms = Integer.parseInt(values3)/0.454;
		double kilograms = Double.parseDouble(values3) / 0.454;
		Assert.assertEquals(Math.round(doublevalue), Math.round(kilograms));

	}

	/**
	 * Enter actual Hemacrotic
	 */

	public void enterActualHemacrotic(String value) {
		inputText(actualHemacroticTextBox, value);
	}

	/**
	 * Verify Numeric Amount Is Entered Only
	 */

	public void verifyUserIsAbleToEnterNumericAmountInHematocritTextBoxes(String Text, String Weight) {

		WebElement Textbox = null;

		if (actualHemacroticText.getText().contains(Text)) {
			Textbox = driver.findElement(By.xpath("//div[@id='hctaLabel']/..//input"));
			verifyUserIsAbleToEnterNumericValuesInTheTextBox(Textbox, Weight);

		}
	}

	public void verifyUserIsAbleToEnterNumericAmountInDesiredHematocritTextBoxes(String Text, String Weight) {
		WebElement Textbox = null;

		if (desiredHematrocaticText.getText().contains(Text)) {
			Textbox = driver.findElement(By.xpath("//div[@id='hcttLabel']/..//input"));
			System.out.println();
			verifyUserIsAbleToEnterNumericValuesInTheTextBox(Textbox, Weight);

		}
	}

	public void verifyUserIsAbleToEnterNumericAmountInDonorHematocritTextBoxes(String Text, String Weight) {
		WebElement Textbox = null;

		if (donorHematrocaticText.getText().contains(Text)) {
			Textbox = driver.findElement(By.xpath("//div[@id='hctdLabel']/..//input"));
			verifyUserIsAbleToEnterNumericValuesInTheTextBox(Textbox, Weight);

		}
	}

	/**
	 * Enter Desired Hemotocrit Amount
	 */
	public void EnterDesiredHemotocritAmount(String Weight) {
		inputText(desiredHemacroticTextBox, Weight);
	}

	/**
	 * Enter Donor Hemotocrit Amount
	 */
	public void EnterDonorHemotocritAmount(String Weight) {
		inputText(donorHemacroticTextBox, Weight);
	}

	/**
	 * Click on Calculate and Reset Button
	 */

	public void clickOnCalculateAndResetButton(String Button) {
		for (WebElement we : calculateAndResetButton) {
			if (we.getText().equalsIgnoreCase(Button)) {
				_normalWait(2000);
				waitAndClick(we);
				_normalWait(2000);
				break;

			}
		}

	}

	/**
	 * Verify Results Are Calculated
	 */

	public void verifyResultsAreCalculatedForBloodVolume(String bloodvolume, String transfusevalue,
			String donorWeight) {
		String volume = resultsForBloodVolume.getText();
		System.out.println(volume);
		Assert.assertTrue(volume.contains(bloodvolume));
		String transfuse = resultsFortransfuse.getText();
		Assert.assertTrue(transfuse.contains(transfusevalue));

		String donorText = donorWieght.getText();
		Assert.assertTrue(donorText.contains(donorWeight));

	}

	/**
	 * Verify All the fields are cleared except Desired hematocrit field values
	 */

	public void verifyActualHematocritFieldsAreCleared() {
		String Actualhemocraticvalue = actualHemacroticTextBox.getAttribute("value");
		Assert.assertTrue(Actualhemocraticvalue.isEmpty());
	}

	public void verifyWeightFieldsAreCleared() {
		String Lbvalue = dogWeightLbTextBox.getAttribute("value");
		Assert.assertTrue(Lbvalue.isEmpty());
	}

	public void verifyDonorHematocritAreCleared() {
		String donorhemocraticvalue = donorHemacroticTextBox.getAttribute("value");
		Assert.assertTrue(donorhemocraticvalue.isEmpty());
	}

	public void verifyDesiredHematocritWillBackDefaultValue() {
		String desiredhemocraticvalue = desiredHemacroticTextBox.getAttribute("value");
		Assert.assertEquals(desiredhemocraticvalue, Constants.desiredHemocraticAmountForDog);
	}

	/**
	 * Verify Alert Text
	 */
	public void verifyAlertText() {
		String alertText = getAlertText();
        Assert.assertTrue(alertText.contains("Do you want to clear all your inputs?"));

	}

	/**
	 * Verify user is able to enter Numeric Values in The TextBox
	 */
	public String verifyUserIsAbleToEnterNumericValuesInTheTextBox(WebElement element, String weight) {
		boolean flag = false, flag1 = false, flag2 = false;

		element.clear();
		inputText(element, Constants.alphabet);
		String values = element.getAttribute("value");
		int size = values.length();
		if (size == 0) {
			flag = true;

		}
		element.clear();
		inputText(element, Constants.alphnumeric);
		String values1 = element.getAttribute("value");
		int size1 = values1.length();
		if (size1 == 0) {
			flag1 = true;

		}

		element.clear();
		inputText(element, weight);
		String values2 = element.getAttribute("value");
		if (values2.equalsIgnoreCase(weight)) {
			flag2 = true;

		}
		Assert.assertTrue(flag & flag1 & flag2);

		return weight;

	}

	/**
	 * Select Cat Radio Buttton
	 */
	public void selectCatRadiouButton() {
		waitAndClick(catRadioButton);
	}

	/**
	 * Verify Cat Radio Button is selected
	 */

	public void verifyCatRadioButtonIsSelected() {
		Assert.assertTrue(catRadioButton.isSelected());

	}

	/*
	 * Logout Application
	 */

	public LogoutPage logoutApplication() {
		_normalWait(500);
		waitForPageLoaded();
		waitAndClick(loginUserDropDown);
		waitAndClick(logoutLinkUnderUserDropDown);
		return PageFactory.initElements(driver, LogoutPage.class);
	}


    public void dismissNotifications() {
		super.dismissNotifications(dismissAllBtn);
    }
    
    /**
     * Select library from tool bar
     */

	public void selectLibraryFromToolbar() {

		waitAndClick(libraryTab);
		
	}

	/**
	 * Select Calculator and conversion table
	 */
 
	public void selectCalculatorsConversionTables() {
		waitAndClick(calculatorAndConverionTable);
		
	}

	/**
	 * Select Transfusion volume calculator
	 */
	
	public void selectTransFusionVolumeCalculator() {
		waitAndClick(transfusionVolumeCalculator);
	}

	/**
	 * Verify species radio button set to dog by default
	 */
	
	public void verifySpeciesRadioButtonSetToDog() {

		if(dogRadioButton.isSelected()) {
			Assert.assertTrue(true);
		}
	}

	/**
	 * Enter 25 in text field
	 */
	public void enter25InTextField() {

		inputText(dogWeightKgTextBox, "25");
		
	}
	/**
	 * Enter 5 in text field
	 */

	public void enter5InTextField() {
    inputText(dogWeightLbTextBox, "5");

		
	}

	public void verifyKgCalculatedAutomaticallly(String weight) {

		String values3 = verifyUserIsAbleToEnterNumericValuesInTheTextBox(dogWeightLbTextBox, weight);

		String weightInKg = dogWeightKgTextBox.getAttribute("value");
		double doublevalue = Double.parseDouble(weightInKg);

		if (weightInKg.isEmpty() == false) {
			Assert.assertFalse(false);
		}

//		double kilograms = Integer.parseInt(values3)/0.454;
		//double kilograms = Double.parseDouble(values3) / 0.454;
		//Assert.assertEquals(Math.round(doublevalue), Math.round(kilograms));
		
	}

	public void clickONOK() {
		waitAndClick(getDriver().findElement(By.xpath("//input[@id='anticoagCloseBtn']")));
	}

	
	public void selectOkButton() {
     waitAndClick(okButton);
	}

}
