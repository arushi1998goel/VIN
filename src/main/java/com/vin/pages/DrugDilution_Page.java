package com.vin.pages;

import com.vin.selenium.core.BasePage;
import com.vin.utilities.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class DrugDilution_Page extends BasePage {
	
	public DrugDilution_Page(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[id='txtDrugName']")
    private WebElement drugTextField;
    
    @FindBy(css = "input[id='txtstartDrug']")
    private WebElement concentrationTextField;
    
    @FindBy(css = "select[id='cbstartDrugUnitsMenu']")
    private WebElement concentrationDrugUnit;
    
    @FindBy(css = "select[id='cbstartDrugVolUnitsMenu']")
    private WebElement concentrationDrugVolumeUnit;
    
    @FindBy(css = "div[id='startDrugInput'] option")
    private List<WebElement> conconcentrationDropDownValues;
    
    @FindBy(css = "input[id='txtstartVolDrug']")
    private WebElement volumeTextField;
    
    @FindBy(css = "select[id='cbstartDrugVolWeightUnitsMenu']")
    private WebElement volumeDropDown;
    
    @FindBy(css = "select[id='cbstartDrugVolWeightUnitsMenu'] option")
    private List<WebElement> volumeDropDownList;
    
    @FindBy(id = "lblAnswer")
    private WebElement securityQuestion;
    
    @FindBy(id = "txtAnswer")
    private WebElement secureIDNumberInput;
    
    @FindBy(id = "btnAnswer")
    private WebElement loginButton;
    
    @FindBy(css = "input[id='txtDilName']")
    private WebElement diluentTextBox;
    
    @FindBy(css = "input[id='txtdiluentVolDrug']")
    private WebElement diluentVolumeTextBox;
    
    @FindBy(css = "select[id='cbdiluentVolWeightUnitsMenu']")
    private WebElement dilutantVolumeDropDown;
    
    @FindBy(css = "select[id='cbdiluentVolWeightUnitsMenu'] option")
    private List<WebElement> dilutantVolumeDropDownList;
    
    @FindBy(css = "input[id='addRadio']")
    private WebElement addToVolumeRadioButton;
    
    @FindBy(xpath = "//div[@class='btn-group']/button[1]")
    private WebElement calculateButton;
    
    @FindBy(css = "input[id='txtendDrug']")
    private WebElement finalDrugConcentrationAmount;
    
    @FindBy(css = "select[id='cbendDrugUnitsMenu']")
    private WebElement finalDrugConcentrationUnitAmount;
    
    @FindBy(xpath = "//span[@id='endPerSlash']")
    private WebElement endSlash;
    
    @FindBy(css = "select[id='cbendDrugWeightUnitsMenu']")
    private WebElement finalDrugConcentrationVolumeAmount;
    
    @FindBy(css = "input[id='txtendVolDrug']")
    private WebElement finalDrugVolumeAmount;
    
    @FindBy(css = "select[id='cbendDrugVolWeightUnitsMenu']")
    private WebElement finalDrugVolumeDropDown;
    
    @FindBy(xpath = "//button[text()='Reset']")
    private WebElement resetButton;
    
    @FindBy(css = "input[id='addRadio']")
    private WebElement addToVolume;
    
    @FindBy(css = "div[id='resultsArea']")
    private WebElement finalDrug;
    
    @FindBy(xpath = "//label[text()='Final Drug']/../following-sibling::div[@id='resultsArea']")
    private WebElement resultSectionUnderFinalDrugSection;
    
    @FindBy(css = "div[id='menu'] div[id='topNav'] a[id='loginmenu']")
    private WebElement loginUserDropDown;
    
    @FindBy(css = "div[id='menu'] div[id='topNav'] ul[role='menu'] a[class='MemberProfile_Logout']")
    private WebElement logoutLinkUnderUserDropDown;

    @FindBy(xpath = "//button[text()='Dismiss All']")
    private WebElement dismissAllBtn;

    

    /**
     * Verify Drug Dilution Page Title
     */

    public void verifyDrugDilutionPageTitle(String pageTitle) {
        waitForPageLoaded();
        _normalWait(3000);
        logger.debug("Verify Page Title of Drug Dilution Page");
        Assert.assertTrue(driver.getTitle().equalsIgnoreCase(pageTitle));
    }

    /**
     * Enter Security Answer and Login
     *
     * @return
     */
    public DrugDilution_Page enterSecurityAnswerAndLogin(String EnterSecurityIDAnswer, String EnterSecurityNameAnswer) {

        if (isElementDisplayed(secureIDNumberInput)) {
            if (getText(securityQuestion).contains("Mother")) {
                logger.debug("Enter Security Name");
                inputText(secureIDNumberInput, EnterSecurityNameAnswer);
            } else {
                logger.debug("Enter Security ID");
                inputText(secureIDNumberInput, EnterSecurityIDAnswer);
            }
            logger.debug("Click on Login after sepcifying Security Details");
            clickOn(loginButton);
        }
        return PageFactory.initElements(driver, DrugDilution_Page.class);
    }

    /**
     * Enter drug Text Field
     */

    public void enterDrugTextField(String Text) {
        logger.debug("Click Drug Text field and enter input: " + Text);
        waitAndClick(drugTextField);
        _normalWait(1000);
        inputText(drugTextField, Text);

    }

    /**
     * verify user is able to enter drug name in the text field
     */

    public void verifyDrugTextBoxIsEnabled(String DrugName) {
        _normalWait(2000);
        String DrugText = drugTextField.getAttribute("value");
        logger.debug("Verify Drug Text (" + DrugText + ") and Drug Name (" + DrugName + ") are same");
        Assert.assertEquals(DrugText, DrugName);
    }

    /**
     * Enter amount in concentration text field
     */

    public void enterConcentrationAmountInConcentrationTextField(String drugConcentrationAmount) {
        _normalWait(1000);
        logger.debug("Click concentration field and enter amount " + drugConcentrationAmount);
        waitAndClick(concentrationTextField);
        inputText(concentrationTextField, drugConcentrationAmount);
    }

    /**
     * verify user is able to enter concentration amount in the text field
     */
    public void verifyConcentrationAmountFieldIsEnabled(String concentrationAmount) {
        _normalWait(2000);
        String concentration = concentrationTextField.getAttribute("value");
        logger.debug("Verify Concentration Amount Entered (" + concentrationAmount + ") and Found (" + concentration + ") are same");
        Assert.assertEquals(concentration, concentrationAmount);
    }

    /**
     * Select a unit measurement from drop down (gm)
     */

    public void selectMeaseurementFromDrpDwn() {
        _normalWait(1000);
        logger.debug("Select Unit Measurement from drop down");
        waitAndClick(concentrationDrugUnit);
        //TODO Hardcoded value
        selectDropDownByValue(concentrationDrugUnit, "1000");

    }

    /**
     * Verify user is able to select from dropdown
     */

    public void verifyUserIsAbleToSelectFromDropDown(String DropDownValues) {
        _normalWait(1000);
        boolean flag = false;

        for (WebElement we : conconcentrationDropDownValues) {

            if (we.getText().equalsIgnoreCase(DropDownValues)) {
                flag = true;
                break;
            }
        }
        logger.debug("Check drug concentration units are in drop down :" + flag);
        Assert.assertTrue(flag);

    }

    /**
     * Select a unit measurement from drop down (Volume)
     */

    public void selectMeaseurementFromVolumeDrpDwn() {

        logger.debug("Select Drug Volume from drop down");
        waitAndClick(concentrationDrugUnit);
        selectDropDownByValue(concentrationDrugVolumeUnit, "1000");

    }

    /**
     * Enter volume Text Field
     */
    public void enterVolumeTextField(String volume) {
        logger.debug("Click Voume Text field and enter volume as :" + volume);
        waitAndClick(volumeTextField);
        _normalWait(1000);
        inputText(volumeTextField, volume);

    }

    /**
     * Verify user is able to enter Amount in the text field
     */

    public void verifyUserIsAbleToEnterAmountInTheVolumeField(String volumeText) {
        _normalWait(3000);
        boolean flag = volumeTextField.getAttribute("value").equalsIgnoreCase(volumeText);
        logger.debug("Verify Volume Entered and Found are same :" + flag);
        Assert.assertTrue(flag);

    }

    /**
     * Select a unit measurement from drop down (ml)
     */

    public void selectVolumeFromDropDown() {
        _normalWait(1000);
        logger.debug("Select Unit Measurement from drop down");
        waitAndClick(volumeDropDown);
        selectDropDownByText(volumeDropDown, "ml");
        waitAndClick(volumeDropDown);

    }

    /**
     * Verify user is able to select from dropdown
     */
    public void verifyUserIsAbleToSelectFromVolumeDropDown(String DropDownValues) {
        _normalWait(1000);
        boolean flag = false;

        for (WebElement we : volumeDropDownList) {

            if (we.getText().equalsIgnoreCase(DropDownValues)) {
                flag = true;
                break;
            }
        }
        logger.debug("Verify Drop down unit is present in drop-down :" + flag);
        Assert.assertTrue(flag);

    }

    /**
     * Click on Diluent TextBox
     */
    public void clickOnDiluentTextBox(String diluentText) {
        _normalWait(1000);
        logger.debug("Enter text is Diluent Textbox as :" + diluentText);
        inputText(this.diluentTextBox, diluentText);

    }

    /**
     * Verify User is Able to enter in the TextBox
     */
    public void verifyUserIsAbleToEnterInTheDiluentTextBox(String TextValueEntered) {
        _normalWait(1000);
        boolean flag = diluentTextBox.getAttribute("value").equalsIgnoreCase(TextValueEntered);
        logger.debug("Verify Diluat Entered and Found are same :" + flag);
        Assert.assertTrue(flag);

    }

    /**
     * Enter Dilutant volume amount
     */
    public void enterDilutantVolumeValue(String Volume) {
        _normalWait(2000);
        logger.debug("Click Diluant Textbox and enter volume as :" + Volume);
        waitAndClick(diluentVolumeTextBox);
        inputText(diluentVolumeTextBox, Volume);

    }

    /**
     * Verify User is Able to enter volume in the TextBox
     */

    public void verifyUserIsAbleToEnterInTheDiluentVolumeTextBox(String TextValueEntered) {
        _normalWait(1000);
        boolean flag = diluentVolumeTextBox.getAttribute("value").equalsIgnoreCase(TextValueEntered);
        logger.debug("Verify Diluent Volume Entered and Found are same :" + flag);
        Assert.assertTrue(flag);

    }

    /**
     * Select a unit measurement from dilutant Volume drop down (ml)
     */

    public void selectDiutantVolumeFromDropDown() {
        _normalWait(1000);
        logger.debug("Select ml from Dilutant Drop-Down");
        waitAndClick(dilutantVolumeDropDown);
        selectDropDownByText(dilutantVolumeDropDown, "ml");
        waitAndClick(dilutantVolumeDropDown);

    }

    /**
     * Verify user is able to select from dilutant volume dropdown
     */

    public void verifyUserIsAbleToSelectFromDilutantVolumeDropDown(String DropDownValues) {
        boolean flag = false;
        _normalWait(1000);

        for (WebElement we : dilutantVolumeDropDownList) {

            if (we.getText().equalsIgnoreCase(DropDownValues)) {
                flag = true;
                break;
            }
        }
        logger.debug("Verify user is able to select from dilutant volume dropdown :" + flag);
        Assert.assertTrue(flag);

    }


    /**
     * verify add to volume radio button is selected by default
     */
    public void veridyAddToVolumeRadioButton() {
        _normalWait(2000);
        boolean flag = addToVolumeRadioButton.isSelected();
        logger.debug("Verify Add to Volume Radio Button is selected by default :" + flag);
        Assert.assertTrue(flag);
    }

    /**
     * Click on Calculate Button
     */

    public void clickOnCalculateButton() {
        waitForElement(calculateButton);
        _normalWait(2000);
        logger.debug("Clicking on Calculate Button");
        waitAndClick(calculateButton);

    }


    /**
     * Verify user is able to select the calculate button
     */

    public void verifyUserIsAbleToSelectCalculateButton() {
        _normalWait(2000);
        boolean flag = calculateButton.isEnabled();
        logger.debug("Verify Calculation Button is enabled :" + flag);
        Assert.assertTrue(flag);
    }

    /**
     * Select a unit measurement from drop down (mg)
     */

    public void selectMeasurementFromConcentrationDropDown() {
        _normalWait(1000);
        waitAndClick(concentrationDrugUnit);
        logger.debug("Select Unit Measurement as 1");
        selectDropDownByValue(concentrationDrugUnit, "1");

    }

    /**
     * Select Concentration Volume From Volume DropDown
     */
    public void selectUnitVolumeFromDropDown() {
        waitAndClick(concentrationDrugUnit);
        logger.debug("Select Concentration volume as 1");
        selectDropDownByValue(concentrationDrugVolumeUnit, "1");
    }

    public void verifyFinalDrugConcentrationAmount() {
        _normalWait(2000);
        String drugAmount = finalDrugConcentrationAmount.getAttribute("value");
        String finalDrugUnitVolumeDropDown = getText(getSelectedDropDownOption(finalDrugConcentrationUnitAmount));
        String Text = endSlash.getText();
        String finalDrugVolumeDropDown = getText(getSelectedDropDownOption(finalDrugConcentrationVolumeAmount));
        logger.debug("Final Drug Concentration Amount equals 5mg/ml");
        Assert.assertEquals(drugAmount + finalDrugUnitVolumeDropDown + Text + finalDrugVolumeDropDown, "5mg/ml");
    }

    /**
     * Verify Final Drug Volume Amount
     */

    public void verifyFinalDrugVolumeAmount() {
        logger.debug("Verify Final Drug Volume amount equals 100ml");
        Assert.assertEquals(finalDrugVolumeAmount.getAttribute("value")
                + getText(getSelectedDropDownOption(finalDrugVolumeDropDown)), "100ml");

    }


    /**
     * Click on reset button
     */

    public void clickOnResetButton() {
        _normalWait(2000);
        waitAndClick(resetButton);
    }

    /**
     * verify user is able to reset calculations
     */
    
    public void verifyValuesIsReset() {
        acceptAlertPresent();
        logger.debug("Check Drug Concentraion Value has been reset");
        Assert.assertEquals(finalDrugConcentrationAmount.getAttribute("value"), "");
        logger.debug("Check Drug Volume  has been reset");
        Assert.assertEquals(finalDrugVolumeAmount.getAttribute("value"), "");
    }

    /**
     * Verify  Result is displayed Under Final Drug Section
     */
    
    public void verifyResultDisplayedUnderFinalDrugSection() {
        Assert.assertTrue(finalDrug.isDisplayed());
        Assert.assertTrue(resultSectionUnderFinalDrugSection.isDisplayed());
        boolean flag = finalDrug.getAttribute("style").contains("block");

        logger.debug("Verify Result is present under final drug section :" + flag);
        Assert.assertTrue(flag);
    }


    /**
     * Click on Logout
     */
    
    public void clickLogoutThroughDrugDilution() {
        _normalWait(500);
        waitForPageLoaded();
        logger.debug("Clicking on Logout");
        waitAndClick(loginUserDropDown);
        waitAndClick(logoutLinkUnderUserDropDown);

    }

    /**
     * Verify Logout Page displayed
     */
    
    public void verifyLogoutPageDisplayed() {
        waitForPageLoaded();
        _normalWait(1000);
        logger.debug("Verify Logout Page displayed");
        assertByPageTitle(Constants.pageTitle_LoggedoutPage);
    }


    public void dismissNotifications() {
        super.dismissNotifications(dismissAllBtn);
    }
}

