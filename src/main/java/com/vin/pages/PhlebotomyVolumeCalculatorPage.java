package com.vin.pages;

import com.vin.selenium.core.BasePage;
import com.vin.utilities.Constants;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class PhlebotomyVolumeCalculatorPage extends BasePage {

    public PhlebotomyVolumeCalculatorPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//div[@id='speciesInput']//label")
    private List<WebElement> radioButons;

    @FindBy(xpath = "//input[@id='txtWeightKg']")
    private WebElement dogWeightKgTextBox;

    @FindBy(xpath = "//input[@id='txtWeight']")
    private WebElement dogWeightLbTextBox;

    @FindBy(css = "input[id='txtHCTa']")
    private WebElement actualHemacroticTextBox;

    @FindBy(xpath = "//div[@id='hctaLabel']")
    private WebElement actualHemacroticText;

    @FindBy(css = "input[id='txtHCTd']")
    private WebElement desiredHemacroticTextBox;

    @FindBy(xpath = "//div[@id='hctdLabel']")
    private WebElement desiredHematrocaticText;

    @FindBy(xpath = "//div[@class='bootstrap-dialog-title']")
    private WebElement popUpTitle;

    @FindBy(css = "input[id='txtWeightKg']")
    private WebElement weightInKGTextBox;

    @FindBy(css = "input[id='txtWeight']")
    private WebElement weightInLbs;

    @FindBy(xpath = "//div[@class='btn-group btnRow']/button")
    private List<WebElement> calculateAndResetButton;

    @FindBy(xpath = "//input[@value='OK']")
    private WebElement okButton;

    @FindBy(xpath = "//td[contains(text(),'volume')]/..//td[@class='tdRight']")
    private WebElement resultsForBloodVolume;

    @FindBy(xpath = "//table[@id='resultsTable']//td[contains(text(),'Difference')]/following-sibling::td")
    private WebElement differenceOfActualAndDesired;

    @FindBy(xpath = "//table[@id='resultsTable']//td[contains(text(),'Percentage')]/following-sibling::td")
    private WebElement percentageOfHemotacritRemoved;

    @FindBy(xpath = "//table[@id='resultsTable']//td[contains(text(),'To reach ')]/following-sibling::td")
    private WebElement toReachDesiredHemocritRemoved;

    @FindBy(css = "input[id='catRadio']")
    private WebElement catRadioButton;

    @FindBy(css = "input[id='txtWeight']")
    private WebElement weightlb;

    @FindBy(css = "div[id='menu'] div[id='topNav'] a[id='loginmenu']")
    private WebElement loginUserDropDown;

    @FindBy(css = "div[id='menu'] div[id='topNav'] ul[role='menu'] a[class='MemberProfile_Logout']")
    private WebElement logoutLinkUnderUserDropDown;

    @FindBy(xpath = "//button[text()='Dismiss All']")
    private WebElement dismissAllBtn;
    
    @FindBy(xpath="//input[@id='dogRadio']")
	private WebElement dogRadioButton;
	
	@FindBy(xpath="//img[@id='speciesImage']")
	private WebElement catGIF;
	
    @FindBy(xpath="//input[@id='txtWeight']")
	private WebElement LBtextBox;


    /**
     * Verify Phlebotomy volume calculator displayed
     */
    public void verifyPhlebotomyVolumeCalculatorDisplayed(String Name) {
        Assert.assertTrue(driver.getTitle().equalsIgnoreCase(Name));

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
     * Verify Radio Button Is selecteda
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
     * Enter Weight in the Text Box
     */
    public void enterWeightInTheKgWeightBox(String Weight) {
        inputText(dogWeightKgTextBox, Weight);

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
     * Verify User is able to enter amount and Kg are calculated automatically
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
     * Verify Kgs Weight TextBox Contains Value
     */
    public void verifyValuesInTheKgTextBox() {
        String weight = weightInKGTextBox.getAttribute("value");
        Assert.assertFalse(weight.isEmpty());

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
        System.out.println();

        if (actualHemacroticText.getText().contains(Text)) {
            Textbox = driver.findElement(By.xpath("//div[@id='hctaLabel']/..//input"));
            verifyUserIsAbleToEnterNumericValuesInTheTextBox(Textbox, Weight);

        }
    }

    /**
     * Enter Desired Hemotocrit Amount
     */
    public void EnterDesiredHemotocritAmount(String Weight) {
        inputText(desiredHemacroticTextBox, Weight);
    }

    public void verifyUserIsAbleToEnterNumericAmountInDesiredHematocritTextBoxes(String Text, String Weight) {
        WebElement Textbox = null;

        if (desiredHematrocaticText.getText().contains(Text)) {
            Textbox = driver.findElement(By.xpath("//div[@id='hctdLabel']/..//input"));
            System.out.println();
            verifyUserIsAbleToEnterNumericValuesInTheTextBox(Textbox, Weight);

        }
    }

    /**
     * Click on Calculate and Reset Button
     */
    public void clickOnCalculateAndResetButton(String Button) {
        for (WebElement we : calculateAndResetButton) {
            if (we.getText().equalsIgnoreCase(Button)) {
                _normalWait(2000);
                waitAndClick(we);
                break;

            }
        }

    }

    /**
     * Verify Popup Title
     */
    public void verifyPopUpTitle() {
        Assert.assertTrue(popUpTitle.getText().equalsIgnoreCase("Things to keep in mind"));
    }

    /**
     * verify numeric values in the weight lb Textbox
     */
    public void verifyNumericTextInTheWeightLbTextBox() {
        verifyuserIsAbleOEnterNumericAmountInTheTextBox(weightInLbs);

    }

    /**
     * Select Ok Button
     */
    public void selectOK() {
        waitAndClick(okButton);
    }


    /**
     * Verify Alert Popup
     */
    public void verifyAlertPopup() {
        Alert alt = driver.switchTo().alert();
        alt.getText().contains("Are you sure you want to remove blood");
        alt.accept();
    }

    /**
     * Select cat radio button
     */
    public void selectCatRadioButton() {
        _normalWait(1000);
        driver.findElement(By.xpath("//input[@id='catRadio']")).click();
    }


    /**
     * Verify species .gif is displayed
     */
    public void verifySpeciesImageDisplayed(String species) {
        boolean flag = false;
        if (driver.findElement(By.xpath("//div[@id='patientImageDiv']/img")).getAttribute("src").contains(species)) {
            flag = true;


        }
        Assert.assertTrue(flag);
    }

    /**
     * Verify cat radio button is selected
     */
    public void verifyCatRadioButttonIsSelected() {
        Assert.assertTrue(catRadioButton.isSelected());
    }


    /**
     * Verify Results Are Calculated
     */
    public void verifyResultsAreCalculatedForBloodVolume(String bloodvolume, String transfusevalue,
                                                         String donorWeight, String percentages) {
        String volume = resultsForBloodVolume.getText();
        Assert.assertTrue(volume.contains(bloodvolume));
        String transfuse = differenceOfActualAndDesired.getText();
        Assert.assertTrue(transfuse.contains(transfusevalue));
        String donorText = percentageOfHemotacritRemoved.getText();
        Assert.assertTrue(donorText.contains(donorWeight));
        String percentage = toReachDesiredHemocritRemoved.getText();
        Assert.assertTrue(percentage.contains(percentages));
    }

    /**
     * Verify Alert Text
     */
    public void verifyAlertText() {
        String alertText = getAlertText();
        Assert.assertTrue(alertText.contains("Do you want to clear all your inputs?"));

    }

    /**
     * Enter Value in the weight lb box
     */

    public void enterLbInTheWeightField(String weightInLB) {
        inputText(weightlb, weightInLB);
    }

    /**
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
     * Verify phlebotomy calculator page
     */
	public void verifyPhlebotomyCalculatorPage() {
		assertByPageTitle(Constants.PhlebotomyVolumeCalculator);
		
	}

	/**
	 * Select dog radio button or verify dog radio button selection
	 */
	public void selectDogRadioButtonOrVerifyDogRadioButtonIsSelected() {

		if(dogRadioButton.isSelected()) {
			Assert.assertTrue(true);
		}
		else {
			waitAndClick(dogRadioButton);
		}
	}


	/**
	 * Verify hemacrotic text
	 * @param string
	 */
	public void verifyHemacroticText(String string) {
		String value=actualHemacroticTextBox.getAttribute("value");
		Assert.assertEquals(string, value);
	}


	/**
	 * Verify cat GIF image
	 */
	public void verifyCatGIFImage() {
		if(catGIF.isDisplayed()) {
			Assert.assertTrue(true);
		}
	}


	/**
	 * Enter weight in 5lbs for cat
	 * @param weight5lb
	 */
	public void enterWeightInLbsForCat(String weight5lb) {
		inputText(LBtextBox, weight5lb);
		
	}

	/**
	 * Verify wight in lb for cat
	 * @param weight5lb
	 */
	public void verifyWeighInLbForCat(String weight5lb) {

		String value=LBtextBox.getAttribute("value");
		Assert.assertEquals(weight5lb, value);
	}

	/**
	 * Verify KGs are calculated automatically
	 * @param weightinkgautomatic
	 */
	public void verifyKGsAreCalculatedAutomatically(String weightinkgautomatic) {

		String value=weightInKGTextBox.getAttribute("value");
		Assert.assertEquals(weightinkgautomatic, value);
	}


	/**
	 * Verify desired hemocratic weight for cat
	 * @param desiredhemocratic67
	 */
	public void verifyDesiredWeightForCat(String desiredhemocratic67) {

		String value=desiredHemacroticTextBox.getAttribute("value");
		Assert.assertEquals(desiredhemocratic67, value);
	}

	/**
	 * Enter weight in lbs for dog
	 * @param weightlbsdog
	 */
	public void enterWeightInLBSforDog(String weightlbsdog) {
		inputText(weightInLbs, weightlbsdog);
		
	}

	/**
	 * Verify weight in lbs for dog
	 * @param weightlbsdog
	 */
	public void verifyWeightInLBSForDog(String weightlbsdog) {

		String value=weightInLbs.getAttribute("value");
		Assert.assertEquals(weightlbsdog, value);
	}


	public void verifyKGsCalculateAutomaticallyForDog(String kgautomaticfordog) {

		String value=weightInKGTextBox.getAttribute("value");
		Assert.assertEquals(kgautomaticfordog, value);
	}


	/**
	 * Verify desired hemocratic value for dog
	 * @param string
	 */
	public void verifyDesiredHemocraticForDog(String string) {

		String value=desiredHemacroticTextBox.getAttribute("value");
		Assert.assertEquals(string, value);
	}
}
	
	
