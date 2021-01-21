package com.vin.pages;

import com.vin.selenium.core.BasePage;
import com.vin.utilities.Constants;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;

public class VIN_UsagePage extends BasePage {

    public VIN_UsagePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div[id='menu'] div[id='topNav'] a[id='loginmenu']")
    private WebElement loginUserDropDown;

    @FindBy(xpath = "(//a[text()='VIN Usage'])[1]")
    private WebElement vinUsage;

    @FindBy(css = "input[id='txtEndDate']")
    private WebElement enddateTextBox;

    @FindBy(xpath = "//div[@id='ui-datepicker-div']//tr[4]//td[5]/a[text()='25']")
    private WebElement enddatedatePicker;

    @FindBy(xpath = "(//label[@for='txtStartDate']/..//div[@class='notifyjs-container'])[1]")
    private WebElement startDate;

    @FindBy(xpath = "//label[@for='txtStartDate']/..//span[contains(text(),'Start Date')]")
    private WebElement startDateValidation;

    @FindBy(css = "input[id='txtStartDate']")
    private WebElement startDateTextBox;

    @FindBy(xpath = "//div[@id='ui-datepicker-div']//tr[1]//td[2]/a[text()='1']")
    private WebElement startDatedatePicker;

    @FindBy(xpath = "//div[@id='ui-datepicker-div']//select[@data-handler='selectMonth']")
    private WebElement monthDropDown;

    @FindBy(xpath = "//div[@id='divUsageHeader']")
    private WebElement endDateText;

    @FindBy(css = "input[id='btnCalculate']")
    private WebElement calculateButton;

    @FindBy(css = "input[id='btnGenerate']")
    private WebElement generatePdfButton;
    
    @FindBy(xpath = "//input[@id='btnGenerate']")
    private WebElement generatePdfButton1;
    

    @FindBy(css = "input[id='btnExport']")
    private WebElement exportMyCEButton;

    @FindBy(css = "p[id='pResults']")
    private WebElement workedHoursText;

    @FindBy(css = "input[id='btnReset']")
    private WebElement resetButton;

    @FindBy(xpath = "//span[contains(text(),'exported to MyCE')]")
    private WebElement exportMyCEMessage;

    @FindBy(xpath = "(//span[text()='VIN Usage'])[1]")
    private WebElement vinUsageText;

    @FindBy(css = "a[id='lnkLogout']")
    private WebElement vinUsageLogout;

    @FindBy(xpath = "//button[text()='Dismiss All']")
    private WebElement dismissAllBtn;
    
    @FindBy(xpath = "//input[@id='txtStartDate']")
    private WebElement startDateControl;
    
    @FindBy(xpath = "//select[@class='ui-datepicker-month']")
    private WebElement previousMonth;
    
    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']//tbody//tr[1]//a[text()='1']")
    private WebElement firstDate;
    
    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']//tbody//tr[5]//a")
    private List<WebElement> lastRowDate;
	
	@FindBy(xpath = "//p[@id='pResults']")
    private WebElement calculateMessage;

   
    /**
     * Verify Vin Usage Displayed
     */

    public void verifyVinUsageDisplayed() {
        _normalWait(1000);
        Assert.assertTrue(vinUsage.isDisplayed());
    }

    /**
     * Select Vin Usage From account_Info
     */
    public void selectVinUsageFromAccountInfo() {
        waitForElement(vinUsage);
        waitAndClick(vinUsage);
    }

    /**
     * Verify Pop up window after click on Vin usage from account_info
     */
    public void verifyPopWindowForVinUsage(String Url) {
        if (driver.getCurrentUrl().contains("beta")) {
            String Urlbeta = Constants.BetaUrl;
            Assert.assertTrue(true, Urlbeta + Url);

        } else {
            if (driver.getCurrentUrl().contains("alpha")) {
                String UrlAlpha = Constants.BetaUrl;
                Assert.assertTrue(true, UrlAlpha + Url);
            }
        }
    }

    /**
     * Click on End date
     */
    public void clickOnEndDate() {
        _normalWait(1000);
        waitAndClick(enddateTextBox);

    }

    /*
     * Select date from End date date picker
     */


    public void selectDateFromEndDatePickerAndVerifyErrorMessage() {
        //boolean flag = false;
//        driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//select[@data-handler='selectMonth']")).click();
//        selectDropDownByValue(monthDropDown, "2");
//        _normalWait(2000);
//        waitAndClick(enddatedatePicker);
        
        
        
        WebElement endDatePicker= getDriver().findElement(By.id("txtEndDate"));
		setDateUsingJavaScriptInCalendar(getDriver(),"06/02/2020",endDatePicker);
		
//        String attributeValue = startDate.getAttribute("style");
//        System.out.println(attributeValue);
//        if (attributeValue.contains("block")) {
//            flag = true;
//            Assert.assertTrue(flag);
//
//        }

    }
    
    
    public  void setDateUsingJavaScriptInCalendar(WebDriver driver, String value, WebElement dateLocator)
	{
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		String script= "arguments[0].setAttribute('value','"+value+"');";
		jse.executeScript(script, dateLocator);
	}

    /**
     * Click and select date from start date datePicker
     */
    public void selectDateFromStartDatePickerAndVerifydate() {
        boolean flag = false;
        driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//select[@data-handler='selectMonth']")).click();
        _normalWait(2000);
        WebElement drpDwn = driver.findElement(By.xpath("//select[@data-handler='selectMonth']//option[text()='Apr']"));
        _normalWait(1000);
        hoverOverElementAndClick(drpDwn, drpDwn);
        _normalWait(1000);
        waitAndClick(startDatedatePicker);

    }

    /**
     * Click on End date and Click out
     */
    public void clickOnEndDateAndClickOut() {
        waitAndClick(enddateTextBox);
        _normalWait(1000);
        enddateTextBox.clear();


        hoverOverElementAndClick(enddateTextBox, enddateTextBox);

    }

    /**
     * Verify error Message on End date Text Box
     */

    public void verifyErrorMessageOnEndDateTextBox() {
        boolean flag = false;

        String attributeValue = enddateTextBox.getAttribute("style");
        System.out.println(attributeValue);
        if (attributeValue.contains("block")) {
            flag = true;
            Assert.assertTrue(flag);

        }
    }

    /**
     * Verify error Message on start date Text Box
     */
    public void verifyErrorMessageOnStartDateTextBox() {
        boolean flag = false;
        Actions act = new Actions(driver);
        act.moveToElement(startDateTextBox).build().perform();
        String attributeValue = startDateTextBox.getAttribute("style");
        System.out.println(attributeValue);
        if (attributeValue.contains("block")) {
            flag = true;
            Assert.assertTrue(flag);

        }

    }

    /**
     * enter date in start date text box
     */
    public void enterDateInStartTextBox(String date) {
        Actions act = new Actions(driver);
        act.moveToElement(startDateTextBox).build().perform();
        _waitForJStoLoad();
        startDateTextBox.click();

        inputText(startDateTextBox, date);

    }

    /**
     * Click in end date and enter end date value
     */
    public void enterEndDate(String EndDate) {
        waitForWebElementEnable(enddateTextBox);
        inputText(enddateTextBox, EndDate);
        waitAndClick(endDateText);

    }

    /**
     * Verify text entry in date format.
     */
    public void verifyDateFromTextBox(String TextValue) {
        boolean flag = false;
        _normalWait(2000);
        if (enddateTextBox.getAttribute("value").toLowerCase().equalsIgnoreCase(TextValue)) {
            flag = true;
            Assert.assertTrue(flag);

        }

    }

    /**
     * Click on calculate button
     */
    public void clickCalculateButton() {
        _normalWait(1000);
        waitAndClick(calculateButton);
    }

    /**
     * Verify calculate button is enabled
     */
    public void verifyCalculateButtonIsSelected() {
        _normalWait(2000);
        Assert.assertTrue(calculateButton.isEnabled());
    }

    /**
     * Verify Generate Pdf and exports to MyCE are enabled
     */

    public void verifyGenerateAndPdfAreActivate(String WorkedHours) {
        boolean flag = false;
        _normalWait(1000);
        String Text = workedHoursText.getText();
        if (Text.trim().toLowerCase().equalsIgnoreCase(WorkedHours)) {
            flag = true;
            Assert.assertTrue(flag);

        }

        Assert.assertTrue(generatePdfButton.isEnabled());
        Assert.assertTrue(exportMyCEButton.isEnabled());

    }

    /**
     * Click on Generate Pdf Button
     */

    public void clickGeneratePdfButton() {
        //hoverOverElementAndClick(generatePdfButton, generatePdfButton);
    	_normalWait(3000);
        waitAndClick(generatePdfButton1);
    }

    /**
     * verify generate Pdf Button is active
     */

    public void verifyGeneratePdfButtonIsActive() {
        Assert.assertTrue(generatePdfButton.isEnabled());
    }

    /**
     * Click on export to MyCE
     */
    public void clickExportMyCEButton() {
        waitAndClick(exportMyCEButton);
    }

    /**
     * Verify User is able to select ExportMyCE
     */
    public void verifyMyExportsToMyCEIsEnabled() {
        Assert.assertTrue(exportMyCEButton.isEnabled());

    }

    /**
     * Click on Reset Button
     */
    public void clickOnResetButton() {
        waitAndClick(resetButton);
    }

    /**
     * Verify date fields clear are unavailable
     */
    public void verifyDateFieldsAreEmpty() {
        boolean flag = false;
        String Startdate = startDateTextBox.getAttribute("value");
        String Enddate = enddateTextBox.getAttribute("value");
        if (Startdate.isEmpty() && Enddate.isEmpty()) {
            flag = true;
            Assert.assertTrue(flag);

        }
    }

    /**
     * Verify Generate and Export buttons are unavailable
     */
    public void verifyGenerateAndExportButtonsUnAvailable() {

        Assert.assertFalse(generatePdfButton.isDisplayed());
        Assert.assertFalse(exportMyCEButton.isDisplayed());
    }

    /**
     * Verify ExportMyCE message displayed
     */
    public void verifyExportMyCEMessage(String exportMyCESMEssage) {
        boolean flag = false;
        _normalWait(1000);
        Assert.assertTrue(exportMyCEMessage.isDisplayed());
        String text = exportMyCEMessage.getAttribute("innerHTML");
        if (text.trim().toLowerCase().equalsIgnoreCase(exportMyCESMEssage.trim().toLowerCase())) {
            flag = true;
            Assert.assertTrue(flag);
        }

    }

    /**
     * Verify End date textbox is Empty
     */
    public void verifyEndTextBoxIsEmpty() {
        boolean flag = true;
        String Enddate = enddateTextBox.getAttribute("value");
        if (Enddate.isEmpty()) {
            flag = true;
            Assert.assertTrue(flag);

        }
    }

    /**
     * Verify login page displayed
     */
    public LoginPage verifyUserLoginPage() {
        waitForPageLoaded();
        _normalWait(1000);
        assertByPageTitle(Constants.pageTitle_LoginPage);
        return PageFactory.initElements(driver, LoginPage.class);
    }

    /**
     * Verify vin usage Displayed
     */
    public void verifyVinUsagePageDisplayed() {
        _normalWait(2000);
        Assert.assertTrue(vinUsageText.isDisplayed());

    }

    /**
     * Click on Logout
     */
    public void clickLogoutThroughVinUsage() {
        _normalWait(2000);
        waitAndClick(vinUsageLogout);
    }

    /**
     * Verify Logout Page displayed
     */
    public void verifyLogoutPageDisplayed() {
        waitForPageLoaded();
        _normalWait(1000);
        assertByPageTitle(Constants.pageTitle_LoggedoutPage);
    }

    public void dismissNotifications() {
        super.dismissNotifications(dismissAllBtn);
    }

    /**
     * Click on start date
     */
  
	public void clickOnStartDate() {

		waitAndClick(startDateControl);
	}

	/**
	 * Pick previous month
	 */
	
	public void pickPreviousMonth() {

		selectDropDownByValue(previousMonth, "1");
	}

	/**
	 * Verify pop up message to select day
	 * @param dayselectmessage 
	 */
	
	public void verifyPopUpMessageToSelectDay(String dayselectmessage) {
      String actualMessage=getDriver().findElement(By.xpath("//div[@class='notifyjs-bootstrap-base notifyjs-bootstrap-infomyvin']//span")).getText();
      System.out.println(actualMessage);
      Assert.assertEquals(actualMessage, dayselectmessage);
		
	}

	/**
	 * Select first date of selected month
	 */
	
	public void selectFirstDateOfSelectedMonth() {

		waitAndClick(firstDate);
		
	}
	
	/**
	 * Verify start date has selected date
	 */

	public void verifyStartDateHasSelectedDate() {

		String date=startDateTextBox.getAttribute("value");
		if(date!=null) {
			Assert.assertTrue(true);
		}
		
	}

	/**
	 * Click last date of selected month
	 */
	
	public void clickLastDateOfSelectedMonth() {
		for(int i=0;i<lastRowDate.size();i++) {
			if(i==lastRowDate.size()-1) {
				lastRowDate.get(i).click();
			}
		}
	}

	/**
	 * Verify calculated message
	 */
	
	public void verifyCalculatedMessage() {

		if(calculateMessage.isDisplayed()) {
			Assert.assertTrue(true);
		}
		
	}
}

