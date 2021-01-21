package com.vin.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.vin.selenium.core.BasePage;

public class CRIPage extends BasePage {

	public CRIPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//button[text()='Dismiss All']")
	private WebElement dismissAllBtn;

	@FindBy(css = "input[id='dogRadio']")
	private WebElement dogRadioButton;

	@FindBy(css = "input[id='txtWeight']")
	private WebElement weightInLbs;

	@FindBy(css = "input[id='txtWeightKg']")
	private WebElement weightInKGTextBox;

	@FindBy(css = "input[id='chkSingleAgent']")
	private WebElement singleDrugRadioButton;
	
	@FindBy(xpath="//input[@id='chkMultipleAgent']")
	private WebElement multipleAgentRadioButton;

	@FindBy(css = "select[id='ddmDrugList']")
	private WebElement drugList;
	
	@FindBy(css="select[id='cmbCocktailList']")
	private WebElement cocktailTextBox;

	@FindBy(xpath = "//input[@id='txtInitDose']")
	private WebElement infusionRate;
	
	@FindBy(xpath = "//input[@id='txtInitDose2']")
	private WebElement lidocaine;
	
	@FindBy(xpath = "//input[@id='txtInitDose3']")
	private WebElement ketamine;

	@FindBy(xpath = "//input[@id='txtConc']")
	private WebElement drugConcentrationAmount;
	
	@FindBy(xpath = "//input[@id='txtConc2']")
	private WebElement drugConcentrationAmount2Lidocaine;
	
	@FindBy(xpath = "//input[@id='txtConc3']")
	private WebElement drugConcentrationAmount3Ketamine;

	@FindBy(xpath = "//input[contains(@title,'Add drug')]")
	private WebElement addingToVolumeRadioButton;

	@FindBy(xpath = "//input[@id='chkSimpleFluidRate']")
	private WebElement fluidRateRadioButton;

	@FindBy(xpath = "//input[@id='txtFluidRate']")
	private WebElement fluidRateTextBox;

	@FindBy(css = "button[id='submitBtn']")
	private WebElement calculateButton;

	@FindBy(xpath = "//td[contains(text(),'Volume of drug')]/..//td[text()='0.32 ml']")
	private WebElement volumeOfDrugToAddValue;

	@FindBy(xpath = "//td[contains(text(),'Infusion')]/..//td[text()='.2 mg/kg/hr']")
	private WebElement infusionDoseRateValue;

	@FindBy(xpath = "//td[contains(text(),'Flow')]/..//td[text()='1000 ml/hr (24000 ml/day )']")
	private WebElement flowRateValue;

	@FindBy(xpath = "//td[contains(text(),'Estimated')]/..//td[text()='1 hrs (0.042 days)']")
	private WebElement estimatedTimeValues;

	@FindBy(xpath = "//button[@id='clearDrugBtn']")
	private WebElement clearDrugRadioButton;
	
	@FindBy(css="input[id='chkReplace']")
	private WebElement replaceVolumeButton;
	
	@FindBy(xpath="//td[@id='totalVolValue']")
	private WebElement totalValueForDrugConcentraion;
	
	@FindBy(xpath="//td[@id='volValue']")
	private WebElement infusionrateVolume;
	
	@FindBy(xpath="//td[@id='volValue']/br")
	private WebElement infusionrateVolumes;
	
	@FindBy(xpath="//td[@id='doseValue']")
	private WebElement concentrationVolume;

	@FindBy(css = "button[id='resetBtn']")
	private WebElement resetButton;

	@FindBy(css = "div[id='menu'] div[id='topNav'] a[id='loginmenu']")
	private WebElement loginUserDropDown;
	
	@FindBy(css = "div[id='menu'] div[id='topNav'] ul[role='menu'] a[class='MemberProfile_Logout']")
	private WebElement logoutLinkUnderUserDropDown;
	
	@FindBy(xpath="//input[@id='catRadio']")
	private WebElement catRadioButton;
	
	@FindBy(xpath="//div[@id='resultsArea']")
	private WebElement resultarea;



	public void dismissNotifications() {
		super.dismissNotifications(dismissAllBtn);
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
		inputText(weightInLbs, "35");

	}
	
	/**
	 * Enter Values in the Lb Text Box
	 */
	public void enterWeightInTheCatTextBox() {
		inputText(weightInLbs, "10");

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
	 * Select Single Drug Radio Button
	 */
	public void selectSingleRadioButton() {
		waitAndClick(singleDrugRadioButton);
	}

	/**
	 * Verify user is able to select a single radio Button
	 */
	public void verifySingleDrugRadioButtonIsSelected() {
		verifyRadioButtonIsSelected(singleDrugRadioButton);
	}
	
	/**
	 * Verify user is able to select a Multiple radio Button
	 */
	public void verifyMultipleDrugRadioButtonIsSelected() {
		verifyRadioButtonIsSelected(multipleAgentRadioButton);
	}

	/**
	 * Select aflfaxalone
	 */
	public void selectDrugFromTheDropDown() {
		driver.findElement(By.cssSelector("select[id='ddmDrugList']")).click();
		driver.findElement(By.xpath("//option[text()='alfaxalone']")).click();

	}
	
	/**
	 * Select Morphine-Lidocaine
	 */
	public void selectMorphineLidocaineDrugFromTheDropDown() {
		driver.findElement(By.cssSelector("select[id='cmbCocktailList']")).click();
		driver.findElement(By.xpath("//option[text()='Morphine-Lidocaine-Ketamine']")).click();

	}

	/**
	 * Verify Value is Selected
	 */

	public void verifyValueIsSelectedFromTheDropDown() {
		Assert.assertTrue(drugList.getAttribute("value").equalsIgnoreCase("alfaxalone"));

	}
	
	/**
	 * Verify Value is Selected
	 */

	public void verifyMorphineValueIsSelectedFromTheDropDown() {
		Assert.assertTrue(cocktailTextBox.getAttribute("value").contains("0.12"));

	}

	/**
	 * Enter amount in the infusion rate text box
	 */
	public void enterTextInTheInfusionRateTextbox() {
		inputText(infusionRate, ".2");
	}
	
	public void enterTextInTheInfusionRateTextboxForMorphine() {
		inputText(infusionRate, ".1");
	}

	/**
	 * verify text is present in the infusion rate textbox
	 */
	public void verifyTextIsPresentInTheInfusionRateTextbox() {
		Assert.assertTrue(infusionRate.getAttribute("value").equalsIgnoreCase(".2"));
	}
	
	
	/**
	 * verify text is present in the infusion rate textbox
	 */
	public void verifyTextIsPresentInTheInfusionRateTextboxForMorphine() {
		Assert.assertTrue(infusionRate.getAttribute("value").equalsIgnoreCase(".1"));
	}
	
	
	/**
	 * verify text is present in the infusion rate textbox
	 */
	public void verifyTextIsPresentInTheInfusionRateTextboxForMorphineDrugConcentration() {
		Assert.assertTrue(drugConcentrationAmount.getAttribute("value").equalsIgnoreCase("5"));
	}
	
	/**
	 * verify text is present in the lidocaine rate textbox
	 */
	public void verifyTextIsPresentInTheLidocianeRateTextbox() {
		Assert.assertTrue(lidocaine.getAttribute("value").equalsIgnoreCase("0"));
	}

	/**
	 * Enter Text in the drug concentration Textbox
	 */
	public void selectDrugConcentrationAmountFromTheDropDown() {
		driver.findElement(By.xpath("//select[@id='ddmConc']")).click();
		driver.findElement(By.xpath("//select[@id='ddmConc']//option[contains(text(),'10')]")).click();

	}

	/**
	 * Enter Text in the drug concentration Textbox
	 */
	public void enterAmountInTheLidocaineTextBox() {
		inputText(lidocaine, "0");
		

	}
	

	/**
	 * Enter Text in the drug concentration Textbox
	 */
	public void enterAmountInTheKetomaineTextBox() {
		inputText(ketamine, ".7");
		

	}
	
	
	/**
	 * Enter Text in the drug concentration Textbox
	 */
	public void verifyTextIsPresentInTheKetomaineTextBox() {
		Assert.assertTrue(ketamine.getAttribute("value").contains(".7"));
	
	}

	public void verifyValueIsPresentInTheLidocaineTextBox() {
		Assert.assertTrue(drugConcentrationAmount2Lidocaine.getAttribute("value").contains("1"));
	}
	
	/**
	 * Enter values in morphine drug concentration textbox
	 */
	public void enterTextInMorphineDrugConcentrationAmount() {
		inputText(drugConcentrationAmount, "5");
		
	}
	
	
	public void enterTextInKetamineDrugConcentrationAmount() {
		inputText(drugConcentrationAmount3Ketamine, "100");
		
	}
	
	/**
	 * Enter Text in the drug concentration Textbox
	 */
	public void verifyTextIsPresentInTheKetomaineDrugConcentrationTextBox() {
		Assert.assertTrue(drugConcentrationAmount3Ketamine.getAttribute("value").contains("100"));
		

	}
	
	
	/**
	 * Enter values in lidocaine drug concentration textbox
	 */
	public void enterTextInlidocaineDrugConcentrationAmount() {
		inputText(drugConcentrationAmount2Lidocaine, "1");
		
	}
	
	/**
	 * Verify user is able to select a drug conecntration amount
	 */
	public void verifyUserIsAbleToMakeASelectionFromTheDrugConcentrationAmount() {
		Assert.assertTrue(
				driver.findElement(By.xpath("//select[@id='ddmConc']//option[contains(text(),'10')]")).getAttribute("value").contains("10"));

	}

	/**
	 * Select Adding to volume Radio Button
	 */
	public void selectAddingToVolumeRadioButton() {
		waitAndClick(addingToVolumeRadioButton);
	}

	/**
	 * Verify Add to volume Radio button is selected
	 */
	public void addToVolumeRadioButtonIsSelected() {
		verifyRadioButtonIsSelected(addingToVolumeRadioButton);
	}

	/**
	 * Select bag size is Selected From the dropdown
	 */
	public void selectOptionFromTheDropDown() {
		driver.findElement(By.xpath("//select[@id='cmbBagSize']")).click();
		driver.findElement(By.xpath("//select[@id='cmbBagSize']/option[@value='1000']")).click();
	}
	
	
	/**
	 * Select bag size  500mlis Selected From the dropdown
	 */
	public void select500mlOptionFromTheDropDown() {
		driver.findElement(By.xpath("//select[@id='cmbBagSize']")).click();
		driver.findElement(By.xpath("//select[@id='cmbBagSize']/option[@value='500']")).click();
	}

	/**
	 * Verify user is Able to select option from the bag size dropdown
	 */
	public void verifyUserIsAbleToSelectOptionFromTheBagSizeDropDown() {
		Assert.assertTrue(
				driver.findElement(By.xpath("//select[@id='cmbBagSize']")).getText().contains("1000"));

	}
	
	
	/**
	 * Verify user is Able to select option from the bag size dropdown
	 */
	public void verifyUserIsAbleToSelectOption500FromTheBagSizeDropDown() {
		Assert.assertTrue(
				driver.findElement(By.xpath("//select[@id='cmbBagSize']")).getText().contains("500"));

	}

	/**
	 * Select Fluid radio button is selected
	 */
	public void verifyFluidRadioButtonIsSelected() {
		waitAndClick(fluidRateRadioButton);
	}

	/**
	 * Verify fluid rate radio button is selected
	 */
	public void fluidRadioButtonIsSelected() {
		verifyRadioButtonIsSelected(fluidRateRadioButton);
	}

	/**
	 * 8 Enter text in the fluid rate text box
	 */
	public void EnterAmountFluidRateTextBox() {
		inputText(fluidRateTextBox, "100");
	}

	/**
	 * Verify Fluid rate Box Contains the same value
	 */
	public void verifyAmountInTheFluidRateTextBox() {
		Assert.assertTrue(fluidRateTextBox.getAttribute("value").contains("100"));

	}

	/**
	 * Click on Calculate Button
	 */
	public void selectCalculateButton() {
		waitAndClick(calculateButton);
	}

	/**
	 * Verify volume of drug value is Displayed
	 */
	public void verifyVolumeOfDrugValuesIsDisplayed() {
		isElementDisplayed(volumeOfDrugToAddValue);
	}
	
	/**
	 * Verify volume of drug value is Displayed
	 */
	public void verifyVolumeValueIsDisplayed() {
		_normalWait(2000);
	Assert.assertTrue(totalValueForDrugConcentraion.getText().contains("0.61"));
	}

	/**
	 * Verify infusion rate value is Displayed
	 */
	public void verifyInfusionRateValuesIsDisplayed() {
		isElementDisplayed(infusionDoseRateValue);
	}

	/**
	 * Verify infusion rate value is Displayed
	 */
	public void verifyFlowRateValuesIsDisplayed() {
		isElementDisplayed(flowRateValue);
	}

	/**
	 * Verify Estimated time value is Displayed
	 */
	public void verifyEstimatedTimeValuesIsDisplayed() {
		isElementDisplayed(estimatedTimeValues);
	}

	/**
	 * Select Clear Drug info button
	 */
	public void selectClearDrugInfoButton() {
		waitAndClick(clearDrugRadioButton);
	}

	/**
	 * verify Values are cleared after selecting clear drug radio button
	 */
	public void verifyValuesAreclearedAfterSelectingClearDrugRadioButtonExcepWeightAndSpecies() {
		Assert.assertTrue(drugList.getAttribute("value").equalsIgnoreCase(""));
		Assert.assertTrue(infusionRate.getAttribute("value").equalsIgnoreCase(""));
		_normalWait(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='txtConc']")).getText().equalsIgnoreCase(""));
	}
	
	
	/**
	 * Select replace volume button
	 */
	public void selectReplaceVolumeButton() {
		waitAndClick(replaceVolumeButton);
	}
	
	
	public void verifyReplaceVolumeButtonIsSelected() {
		Assert.assertTrue(replaceVolumeButton.isSelected());
	}

	/**
	 * Select Reset Button
	 */
	public void selectResetButton() {
		waitAndClick(resetButton);
	}
	
	/**
	 * Select cat radio button
	 */
    public void selectCatRadioButton() {
	waitAndClick(catRadioButton);
}
	
	/**
	 * Verify Alert Text
	 */
	public void verifyAlertTexts() {
		_normalWait(4000);
		String alertText = getAlertText();
		logger.debug("Verify Assert Text is :" + alertText);
		Assert.assertTrue(alertText.trim().contains("Do you want to clear all your inputs?"));

	}
	
	/**
	 * Verify the  volume of each drug
	 */
	public void verifyThevolumeOfTheDrug() {
		Assert.assertTrue(infusionrateVolume.getText().contains("Morphine: 0.45 ml"));
		
	}

	public void verifyTheIfusionRates() {
		Assert.assertTrue(concentrationVolume.getText().contains("Morphine: .1 mg"));
		
	}
	
	/**
	 * Select multiple radio Button
	 */
	public void multipleRadioButton() {
		waitAndClick(multipleAgentRadioButton);
	}

	/**
	 * Logout Application
	 */
	public LogoutPage logout() {
		_normalWait(1000);
		logger.debug("Click Logout");
		waitAndClick(loginUserDropDown);
		waitAndClick(logoutLinkUnderUserDropDown);
		return PageFactory.initElements(driver, LogoutPage.class);
	}
}
