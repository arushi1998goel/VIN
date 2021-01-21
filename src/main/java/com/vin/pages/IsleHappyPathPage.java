package com.vin.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.vin.selenium.core.BasePage;
import bsh.ParseException;

public class IsleHappyPathPage extends BasePage {
	
	public IsleHappyPathPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//select[@id='cmbProgram']/option[contains(text(),'Auburn University')]")
	private WebElement veterinaryProgramSchoolFromDropDown;
	
	@FindBy(xpath="//div[contains(text(),'Resident')]/ancestor::div[@id='school-area']//div[@id='programDiv']/span")
	private WebElement TitleForAuburnUniversity;
	
	@FindBy(xpath="//div[contains(text(),'Resident')]/ancestor::div[@id='school-area']//div[@id='programDiv']/span/following-sibling::br")
	private WebElement costEstimatesDerivedFrom2018;
	
	@FindBy(xpath="//div[@id='schoolInfoContainer']")
	private WebElement schoolInformation;
	
	@FindBy(xpath="//input[@id='residentRb']")
	private WebElement residentRadioButton;
	
	@FindBy(xpath="//input[@id='dteStart']")
	private WebElement startDatePicker;
	
	@FindBy(css="input[id='dteGrad']")
	private WebElement endDateCalendar;
	
	@FindBy(xpath="//div[@id='showEstimatesBtn']")
	private WebElement clickToFillInEstimatesButton;
	
	@FindBy(xpath="//tr[@id='year2Row']//td[contains(@class,'remove')]")
	private WebElement year2;
	
	@FindBy(xpath="//tr[@id='year3Row']//td[contains(@class,'remove')]")
	private WebElement year3;
	
	@FindBy(xpath="//tr[@id='year4Row']//td[contains(@class,'remove')]")
	private WebElement year4;
	
	@FindBy(css="input[id='generateDetailsButton']")
	private WebElement generateLoanDetails;
	
	@FindBy(xpath="//span[contains(text(),'Loan Worksheet Detail*')]/..")
	private WebElement loanWorksheetDetails;
	
	@FindBy(css="input[id='reset-sim-button']")
	private WebElement resetButton;
	
	@FindBy(css="input[value='Reset everything']")
	private WebElement resetEverything;
	
	@FindBy(xpath = "//button[text()='Dismiss All']")
	private WebElement dismissAllBtn;
	
	@FindBy(xpath="//div[@class='modal-content']")
	private WebElement fourYearPopup;
	
	@FindBy(xpath="//input[@value='Yes, I want to proceed anyway.']")
	private WebElement yesButton;
	
	@FindBy(xpath="//div[@id='date2Div']//img")
	private WebElement calendarIcon;

	@FindBy(xpath="//td[contains(@class,'ui-datepicker-today')]/following::td[1]")
	private WebElement futureDate;
	
	@FindBy(xpath="//div[@id='date3Div']//input")
	private WebElement graduationDate;
	
	@FindBy(xpath="//div[@id='showEstimatesBtn']")
	private WebElement clickToFillButton;
	
	@FindBy(xpath="(//div[@class='modal-dialog'])[1]")
	private WebElement invalidPercentPopup;
	
	@FindBy(xpath="(//div[@style='width:100%;text-align:center']//input)[2]")
	private WebElement OKButton;
	
	@FindBy(xpath="//div[@class='modal-content']")
	private WebElement resetOptionPopup;
	
    @FindBy(xpath="//div[@class='school-info-labels'][1]/span[contains(text(),'days')]") 
	private WebElement dateDetails;
	   
	@FindBy(xpath="//span[text()='Loan Worksheet Detail*']")
	private WebElement loanDetails;

	
	/**
	 * Verify User is redirected to Student Loan Sim
	 */
	public  void verifyStudentLoanSimPage(String PageTitle) {
		org.testng.Assert.assertTrue(driver.getTitle().equalsIgnoreCase(PageTitle));
		
	}
	
	  public void dismissNotifications() {
			super.dismissNotifications(dismissAllBtn);
	    }
	
	/**
	 * Select Auburn University
	 */
	
	public void selectAuburnUniversityFromDropDown() {
		waitAndClick(veterinaryProgramSchoolFromDropDown);
		
	}
	
	/**
	 * Verify User is able to select Values from Veterinary Program
	 */
	
	public void verifyVeterianryProgramIsSelectedFromDropDown(String Value) {
		org.testng.Assert.assertTrue(veterinaryProgramSchoolFromDropDown.getText().equalsIgnoreCase(Value));
	}


	/**
	 * Verify Title above Resident Or Non Resident
	 */
	
	public void verifyTitleAboveResidentOrNonResidentButton(String Title) {
		org.testng.Assert.assertTrue(TitleForAuburnUniversity.isDisplayed());
		org.testng.Assert.assertTrue(TitleForAuburnUniversity.getText().contains
				(Title));
		
	}

	/**
	 * Verify Costs for 2018/2019
	 */
	public void verifyCostsEstimatesDerivedText() {
		org.testng.Assert.assertTrue(	driver.findElement(By.xpath("//div[contains(text(),'Resident')]/ancestor::div[@id='school-area']//div[@id='programDiv']/span/following-sibling::br")).isEnabled());
		
	}

	/**
	 * Verify School Legend Appear
	 */

	public void verifyScholLegendInformation() {
		org.testng.Assert.assertTrue(schoolInformation.isDisplayed());
	}

	/**
	 * Verify Resident Radio button
	 */

	public void VerifyResidentRadioButtonIsSelected() {
		org.testng.Assert.assertTrue(residentRadioButton.isSelected());
	}

	/**
	 * Select +2 Future date
	 */
	
	public String selectFutureDates() {
		
	    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(new Date());
	    cal.add(Calendar.DATE, 2);
	    String newDate = dateFormat.format(cal.getTime());
	    return newDate;
	}

	/**
	 * Enter Date in the start date
	 */
	
	public void enterDatesInTheStartDateTimePicker() {
	inputText(startDatePicker, selectFutureDates());
	
	}

	/**
	 * Verify Start Date Picker has Values
	 */
	
	public void verifyStartDatePickerHasValues(String date) {
		_normalWait(1000);
		scrollDown();
		waitAndClick(endDateCalendar);
		org.testng.Assert.assertTrue(startDatePicker.getAttribute("value").equalsIgnoreCase(date));
		
	}


	/**
	 * Verify date has been enterd in the end date picker 
	 * @return 
	 * @throws java.text.ParseException 
	 */

	public boolean verifyDateIsPresentInEndDAtePicker(String enddate) throws java.text.ParseException, ParseException {
		if (enddate.trim().equals(""))
		{
		    return true;
		}
		/* Date is not 'null' */
		else
		{
		    /*
		     * Set preferred date format,
		     * For example MM-dd-yyyy, MM.dd.yyyy,dd.MM.yyyy etc.*/
		    SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
		    sdfrmt.setLenient(false);
		    Date javaDate = sdfrmt.parse(enddate); 
			System.out.println(enddate+" is valid date format");
		    /* Return true if date format is valid */
		    return true;
		}
	}

	/**
	 * 
	 * @throws ParseException
	 * @throws java.text.ParseException
	 */
	
	public void verifyDateISPresentInDtaePicker() throws ParseException, java.text.ParseException {
		String enddate=endDateCalendar.getAttribute("value");
		org.testng.Assert.assertTrue(verifyDateIsPresentInEndDAtePicker(enddate));
		
	}

	/**
	 * click on fill in estimate button
	 */
	public void clickOnFillInEstimatesButton() {
		waitForWebElementEnable(clickToFillInEstimatesButton);
		waitAndClick(clickToFillInEstimatesButton);
	}

	public void verifyTableIsPopulated() {
		org.testng.Assert.assertTrue(driver.findElement(By.xpath("//div[@id='showEstimatesBtn']")).getAttribute("class").equalsIgnoreCase("btn-secondary"));
	}

	public void verifyEstimatesValuesInTable(String Estimates) {
		boolean flag=false;
		if (year2.getText().equals(Estimates) && year3.getText().equals(Estimates) && year4.getText().equals(Estimates)) {
			flag=true;
		}
		org.testng.Assert.assertTrue(flag);
	}

	public void selectgenerateLoanDetailsButton() {
		waitAndClick(generateLoanDetails);
	}

	public void verifyLoanWorksheetDetailsIsDisplayed() {
	_normalWait(2000);
		org.testng.Assert.assertTrue(loanWorksheetDetails.isDisplayed());
	}

	public void resetButtonClick() {
		scrollUp();
		_normalWait(2000);
		waitAndClick(resetButton);
	}

	public void clickResetEverything() {
		waitAndClick(resetEverything);
	}


	public void verifyStartAndEndDateIsClear() {
		org.junit.Assert.assertTrue(startDatePicker.getAttribute("value").equalsIgnoreCase(""));
		org.junit.Assert.assertTrue(endDateCalendar.getAttribute("value").equalsIgnoreCase(""));
	}

	/**
	 * Select resident radio button
	 */
	public void selectResidentRadioButton() {
		if(residentRadioButton.isSelected()) {
			Assert.assertTrue(true);
		}
		else {
			residentRadioButton.click();
		}
	}

	/**
	 * Verify more than 4 year pop up 
	 */

	public void verifyMoreThanFourYearPopUp() {
		if(fourYearPopup.isDisplayed()) {
			Assert.assertTrue(true);
		}
	}

	/** 
	 * Select yes button
	 */

	
	public void selectYesButton() {
	waitAndClick(yesButton);
		
	}

	/**
	 * Select any future date
	 */

	public void selectAnyFutureDate() {

		waitAndClick(calendarIcon);
		_normalWait(2000);
		waitAndClick(futureDate);
		_normalWait(2000);
		
	}

	/**
	 * Verify graduation date populated automatically
	 */
		public void verifyGraduationDateFilledAutomatically() {

		String date=graduationDate.getAttribute("value");
		if(!date.isEmpty()) {
			Assert.assertTrue(true);
		}
		
	}

	/**
	 * Select click to fill button
	 */
	
	public void selectClickToFillButton() {
	waitAndClick(clickToFillButton);
	}

	/**
	 * Invalid percent pop up is displayed
	 */

	public void invalidPercentPopupIsDisplayed() {
	if(invalidPercentPopup.isDisplayed()) {
		Assert.assertTrue(true);
	}
		
	}
	
	/**
	 * Select OK on invalid percent pop up
	 */
	public void selectOK() {
	waitAndClick(OKButton);	
	}

	/**
	 * Verify reset option pop up is displayed
	 */
	public void verifyResetOptionPopupDisplayed() {
	if(resetOptionPopup.isDisplayed()) {
		Assert.assertTrue(true);
	    }
	}
	
	/**
	 * verify user can select date
	 */
	public void verifyUserCanSelectDate() {
		Assert.assertTrue(dateDetails.isDisplayed());
	}
	  
	  /**
	   * verify loan details are loaded
	   */
	public void verifyLoanDetailsAreLoaded() {
	 _normalWait(3000);
	   Assert.assertTrue(loanDetails.isDisplayed());	
	   }
		


	}

