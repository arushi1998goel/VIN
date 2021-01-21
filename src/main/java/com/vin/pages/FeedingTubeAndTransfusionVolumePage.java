package com.vin.pages;

import com.vin.selenium.core.BasePage;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class FeedingTubeAndTransfusionVolumePage extends BasePage {

	 public FeedingTubeAndTransfusionVolumePage(WebDriver driver) {
	        super(driver);
	    }
	 
    @FindBy(xpath = "//input[@value='OK']")
    private WebElement okButton;

    @FindBy(xpath = "//*[@id='txtWeight']")
    private WebElement weightLb;

    @FindBy(xpath = "//*[@id='txtWeightKg']")
    private WebElement weightInKG;
    
    @FindBy(xpath = "//select[@id='cmbWeaning']")
    private WebElement RerDropDown;
    
    @FindBy(xpath = "//select[@id='cmbFeedFreq']")
    private WebElement feedinPerDayDropDown;
    
    @FindBy(xpath = "//select[@id='cmbWeaning']/option")
    private List<WebElement> dropDownValuesForDaysUntil100RER;
    
    @FindBy(xpath = "//select[@id='cmbFeedFreq']/option")
    private List<WebElement> numberofFeeedingPerday;
    
    @FindBy(xpath = "//select[@id='cmbproductType']/option")
    private List<WebElement> recoveryDietDropDown;
    
    @FindBy(xpath = "//div[@id='dilutionInput']//input")
    private List<WebElement> dilutingThisRadioButtonDropDown;
    
    @FindBy(xpath = "//button[@id='submitBtn']")
    private WebElement calculateButton;
    
    @FindBy(xpath = "//button[@id='resetBtn']")
    private WebElement resetButton;
    
    @FindBy(xpath = "//select[@id='cmbproductType']")
    private WebElement selecARecoveryDiet;
    
    @FindBy(xpath = "//select[@id='cmbproductType']/option")
    private List<WebElement> selectARecoveryDietValues;
    
    @FindBy(css = "input[id='rbdiluteNo']")
    private WebElement noradioButton;
    
    @FindBy(css = "input[id='rbdiluteYes']")
    private WebElement yesRadioButton;
    
    @FindBy(css = "button[id='submitBtn']")
    private WebElement calculate;
    
    @FindBy(xpath = "//div[@id='resultStorage']/p[1]")
    private WebElement resultValue;
    
    @FindBy(xpath = "//div[@class='btn-group btnRow']/button")
    private List<WebElement> calculateAndResetButton;
    
    @FindBy(xpath = "//div[@id='resultsArea']")
    private WebElement resultArea;
    
    @FindBy(css = "div[id='menu'] div[id='topNav'] a[id='loginmenu']")
    private WebElement loginUserDropDown;
    
    @FindBy(css = "div[id='menu'] div[id='topNav'] ul[role='menu'] a[class='MemberProfile_Logout']")
    private WebElement logoutLinkUnderUserDropDown;
    
    @FindBy(css = "div[id='dilutionVolumes'] ")
    private WebElement dilutionVolumeSection;
    
    @FindBy(xpath = "//div[@id='dilutionVolumes']/div[contains(text(),'product')]")
    private WebElement volumeProduct;
    
    @FindBy(xpath = "//div[@id='dilutionVolumes']/div[contains(text(),'water')]")
    private WebElement volumeForWater;
    
    @FindBy(xpath = "//input[@id='txtDilute']")
    private WebElement productVolumeTextBox;
    
    @FindBy(xpath = "//input[@id='txtDiluteWater']")
    private WebElement waterVolumeTextBox;
    
    @FindBy(css = "input[id='chkCaloriesPerCan']")
    private WebElement caloriesPerCanRadioButton;
    
    @FindBy(css = "input[id='chkCalDensityDirectly']")
    private WebElement chkCalDensityButton;
    
    @FindBy(css = "input[id='txtCalPerCan']")
    private WebElement caloriesPerCanTextBox;
    
    @FindBy(css = "input[id='txtVolCan']")
    private WebElement volumePerCanTextBox;
    
    @FindBy(css = "input[id='txtCalDensity']")
    private WebElement caloricDensityTextBox;

    @FindBy(xpath = "//button[text()='Dismiss All']")
    private WebElement dismissAllBtn;
    
    @FindBy(xpath="//input[@id='txtWeight']")
    private WebElement weightInLbCheckbox;

   

    /**
     * Enter Values in the weightlb TextBox
     */

    public void enterValuesInTheWeightTextBox() {
        logger.debug("Enter Weight as 28");
        inputText(weightLb, "28");
    }

    /**
     * Verify User is able to enter amount and Kg are calculated automatically
     */

    public void verifyAmountInWeightBoxAndKgValuesAreChangedAutomatically(String weight) {

        // typing alphabets

        waitForWebElementEnable(weightLb);
        checkAlphabetsInWeightField(weightLb);

        // Typing alphanumeric
        waitForWebElementEnable(weightInKG);

        checkAlphabetsInWeightField(weightLb);

        checkAlphanumericInWeightField(weightInKG);

        //Enter provided Weight
        String weightValue = enterWeightInWeightField(weightLb, weight);

        //Verify Weight is KG is auto-populated
        String weightInKg = weightInKG.getAttribute("value");
        boolean flag = weightInKg.isEmpty();
        logger.debug("Verify Weight Value is KG is not empty :" + flag);
        Assert.assertFalse(flag);

        double kilograms = Integer.parseInt(weightValue) * 0.454;
        flag = Math.round(Double.parseDouble(weightInKg)) == Math.round(kilograms);
        logger.debug("Verify calculation is true for converting entered weight into Weight in KG :" + flag);
        Assert.assertTrue(flag);

    }

    /**
     * Verify User is able to enter amount and lbs are calculated automatically
     */

    public void verifyAmountInKGBoxAndLbsValuesAreChangedAutomatically(String weight) {

        // typing alphabets

        waitForElementPresent(weightInKG);

        checkAlphabetsInWeightField(weightInKG);

        // Typing alphanumeric
        checkAlphanumericInWeightField(weightInKG);

        //Enter provided Weight
        String weightValue = enterWeightInWeightField(weightInKG, weight);

        //Verify Weight is LBS is auto-populated
        String weightInlbs = weightLb.getAttribute("value");
        boolean flag = weightInlbs.isEmpty();
        logger.debug("Verify Weight Value is LBS is not empty :" + flag);
        Assert.assertFalse(flag);

        double kilograms = Integer.parseInt(weightValue) / 0.454;
        flag = Math.round(Double.parseDouble(weightInlbs)) == Math.round(kilograms);
        logger.debug("Verify calculation is true for converting entered weight into Weight in LBS :" + flag);
        Assert.assertTrue(flag);
    }


    /**
     * @param element
     * @param weight
     * @return entered Weight
     */
    private String enterWeightInWeightField(WebElement element, String weight) {
        element.clear();
        inputText(element, weight);

        String weightValue = element.getAttribute("value");
        boolean flag = weightValue.equals(weight);
        logger.debug("Verify weight value is accepted :" + flag);
        Assert.assertTrue(flag);

        return weightValue;
    }

    /**
     * Check If Weight Contains Alphabets, they are not accepted
     *
     * @param element
     */
    private void checkAlphabetsInWeightField(WebElement element) {
        element.clear();
        element.sendKeys("abc");
        String values = element.getAttribute("value");
        logger.debug("Verify Alphabets are not accepted");
        Assert.assertTrue(values.length() == 0, "Alphabets are not allowed");
    }

    /**
     * Check If Weight Contains Alphanumeric characters, they are not accepted
     *
     * @param element
     */
    private void checkAlphanumericInWeightField(WebElement element) {
        element.clear();
        element.sendKeys("#@$%^&");
        String values1 = element.getAttribute("value");
        logger.debug("Verify Alphanumerics are not accepted");
        Assert.assertTrue(values1.length() == 0, "Alphanumerics are not allowed");
    }

    /**
     * Verify User redirected to feedingTube page and Select ok
     */

    public void verifyFeedingTubePageAndSelectOk(String Title) {
        waitAndClick(okButton);
        logger.debug("Verify title of page is Feed tube :" + Title);
        Assert.assertTrue(driver.getTitle().trim().toLowerCase().equalsIgnoreCase(Title.trim().toLowerCase()));

    }

    /**
     * Select values from DropDown
     */

    public void selectValuesFromDaysUntilReferenceDropDown(String DropDownValues) {
        logger.debug("Select Value from Dropdown :" + DropDownValues);
        waitAndClick(RerDropDown);
        for (WebElement ele : dropDownValuesForDaysUntil100RER) {
            if (ele.getText().equalsIgnoreCase(DropDownValues)) {
                waitAndClick(ele);
                break;

            }
        }

    }

    /**
     * Verify Dropdown values is selected
     */
    public void verifyDropDownValuesSelected(String Value) {

        String text = RerDropDown.getAttribute("value");
        boolean flag = text.equalsIgnoreCase(Value);
        logger.debug("Verify Dropdown value is selected :" + flag);
        Assert.assertTrue(flag);

    }

    /**
     * Select values from DropDown
     */

    public void selectValuesFromFeedingPerDayDropDown(String DropDownValues) {
        logger.debug("Select Value from Dropdown :" + DropDownValues);
        waitAndClick(feedinPerDayDropDown);
        for (WebElement ele : numberofFeeedingPerday) {
            if (ele.getText().equalsIgnoreCase(DropDownValues)) {
                waitAndClick(ele);
                break;

            }
        }

    }

    /**
     * Verify Feeding per day Dropdown values is selected
     */
    public void verifyFeedingPerDayDropDownValuesSelected(String Value) {

        String text = feedinPerDayDropDown.getAttribute("value");
        boolean flag = text.equalsIgnoreCase(Value);
        logger.debug("Verify Dropdown value is selected :" + flag);
        Assert.assertTrue(flag);

    }

    /*
     * Select Hills Prescription Diet a/d canine/feline canned
     */

    public void selectValuesFromSelectArecoveryDiet(String dropDownValuesText) {
        waitAndClick(selecARecoveryDiet);
        logger.debug("Select Value from Dropdown :" + dropDownValuesText);
        for (WebElement we : selectARecoveryDietValues) {
            if (we.getText().equalsIgnoreCase(dropDownValuesText)) {
                waitAndClick(we);
                break;
            }
        }

    }

    /**
     * Verify User is able to Select From a DropDown Values
     */

    public void verifyrecoveryDietValueSelected(String Value) {
        boolean flag = false;

        for (WebElement we : selectARecoveryDietValues) {
            if (we.getText().equalsIgnoreCase(Value)) {
                flag = true;
                break;

            }
        }
        logger.debug("Verify User is able to Select From a DropDown Values :" + flag);
        Assert.assertTrue(flag);


    }

    /*
     * Select "No" Radio Button
     */

    public void selectNoRadioButton() {
        _normalWait(1000);
        logger.debug("Select Radio Button with value \"No\" ");
        waitForElement(noradioButton);
        waitAndClick(noradioButton);
    }

    /*
     * verify radio Button is selected
     */

    public void verifyradioButtonSelected() {
        logger.debug("Verify Radio button is selected");
        Assert.assertTrue(noradioButton.isSelected());
    }

    /**
     * Click calculate Button
     */

    public void selectCalculate() {
        _normalWait(5000);
        logger.debug("Click Calculate button");
        waitAndClick(calculate);
    }

    /**
     * Verify calculate button sleected
     */

    public void verifyCalculatebuttonSelected() {
        logger.debug("Verify Calculate button is selected");
        Assert.assertTrue(calculate.isEnabled());
    }
    
    /**
     * select reset button
     */
     public void selectresetbutton() {
    	 waitAndClick(resetButton);
     }
    /**
     * Verify result value
     */

    public void verifyResultValue(String resultValues) {
        _normalWait(2000);
        boolean flag = resultValue.getText().equalsIgnoreCase(resultValues);
        logger.debug("Verify that result value matches the imput ");
        Assert.assertTrue(flag);

    }

    /**
     * Click on Calculate and Reset Button
     */

    public void clickOnCalculateAndResetButton(String Button) {
        logger.debug("Click on Calculate and Reset button");
        for (WebElement we : calculateAndResetButton) {
            if (we.getText().equalsIgnoreCase(Button)) {
                _normalWait(2000);
                waitAndClick(we);
                break;
            }
        }

    }

    /**
     * Verify Alert Text
     */

    public void verifyAlertText() {

        String alertText = getAlertText();

        logger.debug("Verify Assert Text is :" + alertText);
        Assert.assertTrue(alertText.contains("Do you want to clear all your inputs?"));

    }

    /**
     * Verify Values are reset
     */

    public void verifyResetButtonIsSelected() {

        boolean flag = resultArea.getAttribute("style").contains("none");
        logger.debug("Verify values are reset :" + flag);
        Assert.assertTrue(flag);
    }

    /*
     * Logout Application
     */

    public LogoutPage logoutApplication() {
        _normalWait(500);
        waitForPageLoaded();
        logger.debug("Click Logout");
        waitAndClick(loginUserDropDown);
        waitAndClick(logoutLinkUnderUserDropDown);
        return PageFactory.initElements(driver, LogoutPage.class);
    }

    /**
     * Enter weight in the KG weight Box
     */

    public void enterWeightInTheWeightBox(String weight) {
        logger.debug("Enter weight as :" + weight);
        inputText(weightInKG, weight);

    }

    /**
     * Select Yes Radio button
     */
    public void selectYesRadioButton() {
        _normalWait(2000);
        logger.debug("Select \"Yes\" Radio button");
        waitAndClick(yesRadioButton);
    }

    /**
     * Verify yes Radio button is selected
     */

    public void verifyYesRadioButtonIsSelected() {
        logger.debug("Verify \"Yes\" radio button is selected");
        Assert.assertTrue(yesRadioButton.isSelected());
    }

    /**
     * Verify dilution Volume sections are populating
     */

    public void verifyVolumeSectionsArePopulating() {
        _normalWait(2000);

        boolean flag = dilutionVolumeSection.getAttribute("style").contains("display: none;");
        logger.debug("Dilution Volume section is displayed :" + flag);
        Assert.assertFalse(flag);
        Assert.assertTrue(volumeProduct.isDisplayed());
        Assert.assertTrue(volumeForWater.isDisplayed());
    }

    /**
     * Enter Amount in the Product volume
     */

    public void enterVolumeInTheTextBox(String value) {
        logger.debug("Enter Product Volume as :" + value);
        productVolumeTextBox.sendKeys(value);

    }

    /**
     * Verify Text Box will take only numeric values
     */

    public void verifyTextBoxTakesNumericValues(String volumeTextBoxName, String volume) {
        if (volumeProduct.getText().equalsIgnoreCase(volumeTextBoxName)) {

            checkAlphabetsInWeightField(productVolumeTextBox);

            //Enter provided Volume
            enterWeightInWeightField(productVolumeTextBox, volume);

        } else if ((volumeForWater.getText().equalsIgnoreCase(volumeTextBoxName))) {

            checkAlphabetsInWeightField(waterVolumeTextBox);

            //Enter provided Volume
            enterWeightInWeightField(waterVolumeTextBox, volume);

        }

    }

    /**
     * Enter Amount in the water volume Text Box
     */

    public void enterVolumeInTheWaterVolumesTextBox(String value) {
        logger.debug("Enter Water Volume as :" + value);
        waterVolumeTextBox.sendKeys(value);

    }

    /**
     * Click calories per can radio button
     */
    public void clickCaloriesPerCanRadioButton() {
        _normalWait(2000);
        logger.debug("Click calories per can radio button");
        waitAndClick(caloriesPerCanRadioButton);
    }

    /**
     * verify calories per can radio button is selected
     */

    public void verifyCaloriesPerCanRadioButtonIsSelected() {
        logger.debug("Verify \"Calories Per Can\" radio button is selected");
        Assert.assertTrue(caloriesPerCanRadioButton.isSelected());
    }

    /**
     * Enter values in the calories per can Text Box
     */

    public void enterValuesinTheCaloriesPerCanTextBox() {
        logger.debug("Enter value in \"Calories Per Can\" textbox as 100");
        inputText(caloriesPerCanTextBox, "100");
    }

    /**
     * Verify User is able to enter numeric amount in calories per can text box
     */

    public void verifyuserIsAbleOEnterNumericAmountInTheOtherProductTextBox() {
        boolean flag = caloriesPerCanTextBox.getAttribute("type").equalsIgnoreCase("number");
        logger.debug("Verify User is able to enter numeric amount in calories per can text box :" + flag);
        Assert.assertTrue(flag);

    }

    /**
     * Enter values in the volume per can Text Box
     */

    public void enterValuesinTheVolumePerCanTextBox() {
        logger.debug("Enter values in the volume per can Text Box as 10");
        inputText(volumePerCanTextBox, "10");
    }

    /**
     * Verify User is able to enter numeric amount in volume per can text box
     */

    public void verifyuserIsAbleOEnterNumericAmountInTheVolumePerCanTextBox() {
        boolean flag = volumePerCanTextBox.getAttribute("type").equalsIgnoreCase("number");
        logger.debug("Verify User is able to enter numeric amount in volume per can text box :" + flag);
        Assert.assertTrue(flag);

    }

    /**
     * Enter Values in the weightlb TextBox
     */

    public void enterValuesInTheWeightTextBox(String values) {
        logger.debug("Enter Values in the weightlb TextBox :" + values);
        inputText(weightLb, values);
    }

    /**
     * Click on Caloric density button
     */

    public void clickCaloricDensityButton() {
        logger.debug("Click on Caloric density button");
        waitAndClick(chkCalDensityButton);
    }

    /**
     * verify Caloric density radio button is selected
     */

    public void verifyCaloricDensityRadioButtonIsSelected() {
        boolean flag = chkCalDensityButton.isSelected();
        logger.debug("verify Caloric density radio button is selected :" + flag);
        Assert.assertTrue(flag);
    }

    /**
     * Enter Values in the Caloric Density Text Box
     */

    public void enterValuesInTheCaloricDensityTextBox() {
        logger.debug("Enter Values in the Caloric Density Text Box as 8");
        inputText(caloricDensityTextBox, "8");
    }



    public void dismissNotifications() {
        super.dismissNotifications(dismissAllBtn);
    }

    /**
     * Verify weight in lb
     * @param weight10lb
     */
    
	public void verifyWeightInLb(String weight10lb) {

		String value=weightInLbCheckbox.getAttribute("value");

		Assert.assertEquals(weight10lb, value);
	}

	/**
	 * Enter weight in lb
	 * @param weight10lb
	 */

	public void enterWeightInLb(String weight10lb) {
		
		inputText(weightInLbCheckbox, weight10lb);
	}
}
