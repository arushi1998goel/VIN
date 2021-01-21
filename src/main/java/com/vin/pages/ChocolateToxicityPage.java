package com.vin.pages;

import com.vin.selenium.core.BasePage;
import com.vin.utilities.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class ChocolateToxicityPage extends BasePage {

    public ChocolateToxicityPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[id='txtWeight']")
    private WebElement weightInLbs;

    @FindBy(css = "input[id='txtWeightKg']")
    private WebElement weightInKGTextBox;

    @FindBy(css = "select[id='cmbChocType']")
    private WebElement typeOfChoclateDropDown;

    @FindBy(xpath = "//select[@id='cmbChocType']/option")
    private List<WebElement> typeOFChoclateDropDownValues;

    @FindBy(css = "input[id='txtAmount']")
    private WebElement quantityTextBox;

    @FindBy(css = "select[id='cmbAmountUnits']")
    private WebElement quantityDropDown;

    @FindBy(css = "input[id='chkAnimationOn']")
    private WebElement animationRadioButton;

    @FindBy(css = "button[id='submitBtn']")
    private WebElement calculateButton;

    @FindBy(xpath = "//div[@id='triangleDiv']/img")
    private WebElement traingle;

    @FindBy(css = "button[id='resetBtn']")
    private WebElement resetButton;

    @FindBy(xpath = "//input[contains(@value,'YES, I want')]")
    private WebElement confirmResetButton;

    @FindBy(xpath = "//h3[text()='CONFIRM RESET']")
    private WebElement confirmResetPopup;

    @FindBy(css = "div[id='menu'] div[id='topNav'] a[id='loginmenu']")
    private WebElement loginUserDropDown;

    @FindBy(css = "div[id='menu'] div[id='topNav'] ul[role='menu'] a[class='MemberProfile_Logout']")
    private WebElement logoutLinkUnderUserDropDown;

    @FindBy(xpath = "//div[@id='outcomeText']//label")
    private List<WebElement> outcomeText;

    @FindBy(xpath = "//button[text()='Dismiss All']")
    private WebElement dismissAllBtn;

    public void verifyChocolateToxicityPage(String Title) {
        driver.getTitle().equalsIgnoreCase(Title);
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
     * dissmiss alert notification if displayed
     */

    public void dismissNotifications() {
        super.dismissNotifications(dismissAllBtn);
    }
    
    /**
     * Enter Values in the Lb Text Box
     */
    
    public void enterWeightInTheTextBox(String weight) {
        inputText(weightInLbs, weight);

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
     * Select Choclate DropDown
     */

    public void clickDropDownAndSelectWhiteChocolate() {
        waitAndClick(typeOfChoclateDropDown);
        driver.findElement(By.xpath("//option[text()='White Chocolate']")).click();

    }

    /**
     * Enter Values in quantity Text
     */
    
    public void enterQuantityText(String quantity) {
        inputText(quantityTextBox, quantity);

    }

    /**
     * Verify User is able to select dropdown values
     */

    public void verifyUserIsAbleToSelectDropDownValues() {
        verifyOptionsIsSelectFromDropDown(Constants.milkChoclate, typeOfChoclateDropDown);
    }

    /**
     * Verify User is able to select White choclate dropdown values
     */

    public void verifyUserIsAbleToSelectWhiteChocolateDropDownValues() {
        verifyOptionsIsSelectFromDropDown(Constants.whiteChoclate, typeOfChoclateDropDown);
    }


    /**
     * Verify user is able to enter Numeric text
     */
    public void verifyUserIsAbleToEnterNumericText(String ChoclateName) {
        Assert.assertTrue(quantityTextBox.getAttribute("value").equalsIgnoreCase(ChoclateName));

    }

    /**
     * Verify User is able to select dropdown values
     */

    public void verifyUserIsAbleToSelectDarkSweetChocolateDropDownValues() {
        verifyOptionsIsSelectFromDropDown(Constants.darkSweetChocolate, typeOfChoclateDropDown);
    }

    /**
     * Verify User is able to select dropdown values
     */

    public void verifyUserIsAbleToSelectSemiSweetChocolateDropDownValues() {
        verifyOptionsIsSelectFromDropDown(Constants.semiweetChocolate, typeOfChoclateDropDown);
    }

    /**
     * Verify User is able to select dropdown values
     */

    public void verifyUserIsAbleToSelect60CocoaChocolateDropDownValues() {
        verifyOptionsIsSelectFromDropDown(Constants.Cocoa, typeOfChoclateDropDown);
    }

    /**
     * Verify User is able to select dropdown values
     */

    public void verifyUserIsAbleToSelect80CocoaChocolateDropDownValues() {
        verifyOptionsIsSelectFromDropDown(Constants.Cocoa86, typeOfChoclateDropDown);
    }

    /**
     * Verify User is able to select dropdown values
     */

    public void verifyUserIsAbleToSelectBakerChocolateDropDownValues() {
        verifyOptionsIsSelectFromDropDown(Constants.bakerChocolate, typeOfChoclateDropDown);
    }

    /**
     * Verify User is able to select dropdown values
     */

    public void verifyUserIsAbleToSelectInstantCocoaDropDownValues() {
        verifyOptionsIsSelectFromDropDown(Constants.instantCocoapowder, typeOfChoclateDropDown);
    }


    /**
     * Verify User is able to select dropdown values
     */

    public void verifyUserIsAbleToSelectCoffeeBeanDropDownValues() {
        verifyOptionsIsSelectFromDropDown(Constants.CofeeBeanGrounds, typeOfChoclateDropDown);
    }

    /**
     * Verify quantity dropdown
     */

    public void selectQuantityDropDown() {
        waitAndClick(quantityDropDown);
        driver.findElement(By.xpath("//option[text()='oz']")).click();
    }

    /**
     * Select gm dropdown
     */

    public void selectGmQuantityDropDown() {
        waitAndClick(quantityDropDown);
        driver.findElement(By.xpath("//option[text()='gm']")).click();
    }

    /**
     * Verify Quantity value from the drop down
     */

    public void verifyQuantityValueFromtheDropDown() {
        verifyOptionsIsSelectFromDropDown(Constants.quantityDropDownValues, quantityDropDown);

    }

    /**
     * Verify Quantity value from the drop down
     */

    public void verifyQuantityGmValueFromtheDropDown() {
        verifyOptionsIsSelectFromDropDown(Constants.gmquantityDropDownValues, quantityDropDown);

    }

    /**
     * Select Animation on radio button
     */

    public void selectAnimationOnRadioButton() {
        waitAndClick(animationRadioButton);
    }

    /**
     * Verify Radio Button Is Selected
     */

    public void verifyRadioButtonIsSelected() {
        Assert.assertTrue(animationRadioButton.isSelected());
    }

    /**
     * Verify user is Able to Enter Numeric values in the quantity textbox
     */

    public void verifyNumericValuesInTheQuantityTextBox() {
        verifyuserIsAbleOEnterNumericAmountInTheTextBox(quantityTextBox);
    }

    /**
     * Click on Calculate Button
     */
    
    public void selectCalculateButton() {
        waitAndClick(calculateButton);
    }

    /**
     * Verify Scale Canvas
     */
    
    public void verifyScaleCanvasValues(String values) {
    	_normalWait(4000);
    	Assert.assertTrue(traingle.getAttribute("style").contains(values));
    }

    /**
     * Verify the sections are  as potential death
     */
    
    public void verifyOkScaleCanvas() {
        boolean flag = false;
        int value = driver.findElement(By.xpath("//div[@id='canvasDiv']")).getSize().getWidth();
        int meanValue = value / 5;
        if (meanValue >= 0 && meanValue <= 269) {
            flag = true;
        }
        Assert.assertTrue(flag);
    }


    /**
     * Verify the sections are  as potential death
     */
    
    public void verifyPotentialDeathScaleCanvas() {
        boolean flag = false;

        int value = driver.findElement(By.xpath("	")).getSize().getWidth();
        int meanValue = (value / 5) * 4;
        if (meanValue >= 1076) {
            flag = true;

        }
        Assert.assertTrue(flag);
    }


    /**
     * Verify the sections are  as potential death
     */
    
    public void verifyVomittingAndDiarhoeaaScaleCanvas() {
        boolean flag = false;

        int value = driver.findElement(By.xpath("//div[@id='canvasDiv']")).getSize().getWidth();
        int meanValue = (value / 5) * 2;
        if (meanValue >= 269 && meanValue <= 538) {
            flag = true;
        }
        Assert.assertTrue(flag);
    }

    /**
     * Verify the sections are  tremors and seizures
     */
    
    public void verifyTremorsAndSeizuresScaleCanvas() {
        boolean flag = false;
        
        int value = driver.findElement(By.xpath("//div[@id='canvasDiv']")).getSize().getWidth();
        int meanValue = (value / 5) * 4;
        if (meanValue >= 807 && meanValue <= 1076) {
            flag = true;
        }
        Assert.assertTrue(flag);
    }


    /**
     * Verify the sections are  tremors and seizures
     */
    
    public void verifyTachyarrythmiasScaleCanvas() {
        boolean flag = false;

        int value = driver.findElement(By.xpath("//div[@id='canvasDiv']")).getSize().getWidth();
        int meanValue = (value / 5) * 3;
        if (meanValue >= 807 && meanValue <= 1076) {
            flag = true;
        }
        Assert.assertTrue(flag);
    }

    /**
     * Select Reset Button
     */
    
    public void selectResetButton() {
        _normalWait(2000);
        waitAndClick(resetButton);
    }

    /**
     * Click on yes button
     */

    public void clickOnYesButtonAfterReset() {
        waitAndClick(confirmResetButton);
    }

    /**
     * Verify Confirm reset popup
     */

    public void VerifyRestPopup() {
    	_normalWait(2000);
        Assert.assertTrue(confirmResetPopup.isDisplayed());
    }

    /**
     * Verify Values are reset
     */

    public void VerifyValuesAreReset() {
        Assert.assertTrue(traingle.getAttribute("style").contains("0"));
    }

    /**
     * Enter weight For Dog
     */
    
    public void enterWeightForDog(String Text) {
        inputText(weightInKGTextBox, Text);
    }

    /**
     * Verify lbs Weight TextBox Contains Value
     */

    public void verifyValuesInThelbsTextBox() {
        String weight = weightInLbs.getAttribute("value");
        Assert.assertFalse(weight.isEmpty());
    }

    /**
     * verify numeric values in the weight lb Textbox
     */
    
    public void verifyNumericTextInTheWeightKGTextBox() {
        verifyuserIsAbleOEnterNumericAmountInTheTextBox(weightInKGTextBox);

    }

    /**
     * Select Milk Choclate From DropDown
     */

    public void clickDropDownAndSelectMilkChocolate() {
        waitAndClick(typeOfChoclateDropDown);
        driver.findElement(By.xpath("//option[text()='Milk Chocolate']")).click();

    }

    /**
     * Verify ok scale canvas for  dropdown gm values
     */

    public void verifyOkScaleCanvasForGmDropDown() {
        waitAndClick(typeOfChoclateDropDown);
        driver.findElement(By.xpath("//option[text()='Milk Chocolate']")).click();
    }

    /**
     * Select Values From DropDown
     */
    
    public void selectValuesFromDropDown(String DropDownText) {
        for (WebElement we : typeOFChoclateDropDownValues) {
            if (we.getText().equalsIgnoreCase(DropDownText)) {
                waitAndClick(we);
                break;
            }
        }
    }
    
   
}
