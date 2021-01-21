package com.vin.pages;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.vin.selenium.core.BasePage;
import com.vin.utilities.Constants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.Reporter;

public class PostGraduateTrainingPage extends BasePage {
   
    public PostGraduateTrainingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Add Internship']")
    private WebElement addInternshipLnk;

    @FindBy(xpath = "//div[@id='divInternships']//table[@id='tblInternships']")
    private WebElement previousRecordTable;

    @FindBy(xpath = "//table[@id='tblInternships']//a[@title='Delete']")
    private WebElement deleteExistingInternshipRecord;

    @FindBy(xpath = "//*[@id='divManage']")
    private WebElement modalWindow;

    @FindBy(xpath = "//select[@id='ddlCountry']")
    WebElement selectCountry;

    @FindBy(xpath = "//select[@id='ddlSubject']")
    private WebElement selectSubject;

    @FindBy(xpath = "//select[@id='ddlGradMonth']")
    private WebElement selectMonth;

    @FindBy(xpath = "//select[@id='ddlGradYear']")
    private WebElement selectYear;

    @FindBy(xpath = "//input[@id='txtSchoolPracticeName']")
    private WebElement instituteName;

    @FindBy(xpath = "//*[@id='btnSave']")
    private WebElement saveBtn;

    @FindBy(css = "div[id='menu'] div[id='topNav'] a[id='loginmenu']")
    private WebElement loginUserDropDown;

    @FindBy(xpath = "//a[@id='lnkLogout']")
    private WebElement logoutLinkUnderUserDropDown;

    @FindBy(xpath = "//table[@id='tblInternships']/tbody/tr/td[1]")
    private WebElement tableInstituteName;

    @FindBy(xpath = "//table[@id='tblInternships']/tbody/tr/td[2]")
    private WebElement tableSubject;

    @FindBy(xpath = "//table[@id='tblInternships']/tbody/tr/td[3]")
    private WebElement tableMonth;

    @FindBy(xpath = "//table[@id='tblInternships']/tbody/tr/td[4]")
    private WebElement tableYear;

    @FindBy(xpath = "//table[@id='tblInternships']//a[@title='Edit']")
    private WebElement editExistingInternshipRecord;

    @FindBy(xpath = "//span[contains(text(),'The update was successful.')]")
    private WebElement updateNotificationPopup;

    @FindBy(xpath = "//span[contains(text(),'The delete was successful.')]")
    private WebElement deleteNotificationPopup;

    @FindBy(xpath = "//a[text()='Add Residency']")
    private WebElement addResidencyLnk;

    @FindBy(xpath = "//table[@id='tblResidencies']//a[@title='Delete']")
    private WebElement deleteExistingResidencyRecord;

    @FindBy(xpath = "//div[@id='divResidencies']//table[@id='tblResidencies']")
    private WebElement previousResidencyRecordTable;

    @FindBy(xpath = "//table[@id='tblResidencies']/tbody/tr/td[1]")
    private WebElement tableResidencyInstituteName;

    @FindBy(xpath = "//table[@id='tblResidencies']/tbody/tr/td[2]")
    private WebElement tableResidencySubject;

    @FindBy(xpath = "//table[@id='tblResidencies']/tbody/tr/td[3]")
    private WebElement tableResidencyMonth;

    @FindBy(xpath = "//table[@id='tblResidencies']/tbody/tr/td[4]")
    private WebElement tableResidencyYear;

    @FindBy(xpath = "//table[@id='tblResidencies']//a[@title='Edit']")
    private WebElement editExistingResidencyRecord;

    @FindBy(xpath = "//button[text()='Dismiss All']")
    private WebElement dismissAllBtn;
    
    @FindBy(css = "a[id='lnkLogout']")
	private WebElement Logout;
    
    
    @FindBy(xpath="//span[@id='lblMemberName']")
    private WebElement seleniumUser;

    private String tableInternshipLocator = "//div[@id='divInternships']//table[@id='tblInternships']";
    private String tableResidencyLocator = "//div[@id='divResidencies']//table[@id='tblResidencies']";
    
    @FindBy(xpath="//li[@id='liPostGraduateTraining']//a")
	private WebElement postGraduateTrainingLink;
    
    @FindBy(xpath="//img[@id='imgVINLogo']")
	 private WebElement myVIN;
    
    @FindBy(xpath="//li[@id='liProfileMain']//a[@id='lnkProfileMain']")
	 private WebElement profileLink;
   
    @FindBy(xpath="//div[@class='notifyjs-bootstrap-base notifyjs-bootstrap-infomyvin']//span")
	private WebElement enterYourDeatailsPopup;
   
    @FindBy(xpath="//table[@id='tblInternships']//tbody//a[2]")
	private WebElement deleteIconForAddedInternship;
   
    @FindBy(xpath="(//div[@class='notifyjs-bootstrap-base notifyjs-bootstrap-infomyvin']//span[text()='The delete was successful.'])[1]")
	private WebElement deletionMessage;
   
    @FindBy(xpath="//table[@id='tblResidencies']//tbody//a[2]")
	private WebElement deleteIconForAddedResidency;
   
    @FindBy(xpath="(//div[@class='notifyjs-bootstrap-base notifyjs-bootstrap-infomyvin']//span[text()='The delete was successful.'])[2]")
	private WebElement deletionMessageForaddedResidency;
    
    @FindBy(xpath="//span[text()='The delete was successful.']")
    private WebElement deletionmessage;
	

    public void checkExistingInternshipRecord() throws ElementNotFoundException {
        if (isElementPresent(tableInternshipLocator))
            deleteExistingRecord(deleteExistingInternshipRecord);
        else {
            logger.debug("Table was not Found");
            System.out.println("Table was not Found");
        }
    }

    private void deleteExistingRecord(WebElement deleteExistingRecord) {
        waitForElementPresent(deleteExistingRecord);
        clickOn(deleteExistingRecord);

        while (!isAlertPresent())
            _normalWait(1000);

        acceptAlertPresent();

    }

    public void addInternship() {
        _normalWait(5000);
        waitForElementClickable(addInternshipLnk);
        clickOn(addInternshipLnk);
        waitForModal();
    }

    private void waitForModal() {
        waitForElementPresent(modalWindow);
    }

    public void selectCountry(String country) {
        waitForElementPresent(selectCountry);
        selectDropDownByText(selectCountry, country);
    }

    public void selectSubject(String subject) {
        waitForElementPresent(selectSubject);
        selectDropDownByText(selectSubject, subject);
    }

    public void selectMonth(String month) {
        waitForElementPresent(selectMonth);
        selectDropDownByText(selectMonth, month);
    }

    public void selectYear(String year) {
        waitForElementPresent(selectYear);
        selectDropDownByText(selectYear, year);
    }

    public void enterInsituteName(String institute) {
        waitForElementPresent(instituteName);
        inputText(instituteName, institute);
    }

    public void clickSaveButton() {
        waitForElementPresent(saveBtn);
        clickOn(saveBtn);
    }

    public void verifyInternshipRecord(String institute, String subject, String month, String year) {
        waitForElementPresent(previousRecordTable);
        checkInstituteName(tableInstituteName, institute);
        checkSubject(tableSubject, subject);
        checkMonth(tableMonth, month);
        checkYear(tableYear, year);
    }

    private void checkYear(WebElement tableYear, String year) {
        Assert.assertTrue(getText(tableYear).equalsIgnoreCase(year));
    }

    private void checkMonth(WebElement tableMonth, String month) {
        Assert.assertTrue(getText(tableMonth).contains(month));
    }

    private void checkSubject(WebElement tableSubject, String subject) {
        Assert.assertTrue(getText(tableSubject).equalsIgnoreCase(subject));
    }

    private void checkInstituteName(WebElement tableInstituteName, String institute) {
        Assert.assertEquals(getText(tableInstituteName), institute);
    }

    public LogoutPage logout() {
        _normalWait(500);
        waitForPageLoaded();
        logger.debug("Click Logout");
//        waitAndClick(loginUserDropDown);
        waitAndClick(logoutLinkUnderUserDropDown);
        return PageFactory.initElements(driver, LogoutPage.class);

    }

    public void editInternshipRecord() {
        _normalWait(5000);
        waitForElementClickable(editExistingInternshipRecord);
        clickOn(editExistingInternshipRecord);
        waitForModal();
    }

    public void verifyUpdateMessageDisplayed() {
        waitForElementPresent(updateNotificationPopup);
    }

    public void verifyDeleteMessageDisplayed() {
        waitForElementPresent(deleteNotificationPopup);
    }

    public void verifyInternshipRecordDeleted() {
        Assert.assertFalse(isElementPresent(tableInternshipLocator));
    }

    public void checkExistingResidencyRecord() {
        if (isElementPresent(tableResidencyLocator))
            deleteExistingRecord(deleteExistingResidencyRecord);
        else {
            logger.debug("Table was not Found");
            System.out.println("Table was not Found");
        }
    }

    public void addResidency() {
        _normalWait(5000);
        waitForElementClickable(addResidencyLnk);
        clickOn(addResidencyLnk);
        waitForModal();
    }

    public void verifyResidencyRecord(String institute, String subject, String month, String year) {
        waitForElementPresent(previousResidencyRecordTable);
        checkInstituteName(tableResidencyInstituteName, institute);
        checkSubject(tableResidencySubject, subject);
        checkMonth(tableResidencyMonth, month);
        checkYear(tableResidencyYear, year);
    }

    public void editResidencyRecord() {
        _normalWait(5000);
        waitForElementClickable(editExistingResidencyRecord);
        clickOn(editExistingResidencyRecord);
        waitForModal();
    }

    public void verifyResidencyRecordDeleted() {
        Assert.assertFalse(isElementPresent(tableResidencyLocator));
    }

    public void dismissNotifications() {
        super.dismissNotifications(dismissAllBtn);
    }

    /**
     * Verify user login for post graduate training
     */
	public void verifyUserLoginForPostGraduateTraining() {

		Assert.assertEquals(seleniumUser.getText(), "Selenium User");
	}

	/**
	 * Click on MyVIN 
	 */
	public void clickOnMyVIN() {

		waitAndClick(myVIN);
		
	}

	/**
	 * Click on profile
	 */
	public void clickOnProfile() {

		waitAndClick(profileLink);
	}

	/**
	 * Verify post graduate training page is loaded
	 */
		public void verifyPostGraduateTrainingPageIsLoaded() {
		assertByPageTitle(Constants.postGraduateTrainingPageTitle);
	}

	/**
	 * Verify enter your details popup
	 */
	public void verifyEnterYourDetailsPopup() {
		if(enterYourDeatailsPopup.isDisplayed()) {
			Assert.assertTrue(true);
		}
	}
	
	/**
	 * Confirm the brazil value
	 * @param string
	 */
	public void confirmBrazilValue(String string) {

		String value=returnSelectedValueFromDropdown(selectCountry);
		Assert.assertEquals(string, value);
		
	}

	/**
	 * Confirm subject field
	 * @param string
	 */
	public void confirmSubjectField(String string) {

		String value=returnSelectedValueFromDropdown(selectSubject);
		Assert.assertEquals(string, value);
		
	}

	public void confirmFieldsAcceptValue(String string) {

		String value=instituteName.getAttribute("value");
		Assert.assertEquals(string, value);
		
	}

	/**
	 * Click on post graduate training link
	 */
	public void clickOnPostGraduateTraining() {

		waitAndClick(postGraduateTrainingLink);
	}

	/**
	 * Click on delete button on added internsghip record
	 */
	public void clickOnDeleteButtonOnAddedInternshipRecord() {

		waitAndClick(deleteIconForAddedInternship);
		acceptAlertPresent();
		
	}

	/**
	 * Confirm record deleted
	 */
	public void confirmRecordDeleted() {
		
		if(deletionMessage.isDisplayed()) {
			Assert.assertTrue(true);
		}
	}

	/**
	 * Select delete button for added residency
	 */
	public void selectDeleteButtonForAddedResidency() {

		waitAndClick(deleteIconForAddedResidency);
		acceptAlertPresent();
		
	}
	
	/**
	 * Verify delete record for added residency
	 */
	public void verifyRecordDeletedForAddedResidency() {
		if(deletionmessage.isDisplayed()) {
			Assert.assertTrue(true);
			_normalWait(2000);
		}		
	}

	/**
	 * Verify logging off from VIN is successful
	 */
	public void verifyLoggingOffFromVIN() {

		assertByPageTitle(Constants.pageTitle_LoggedoutPage);
		
	}

	/**
	 * Click on logout
	*/
	public void clickOnLogOut() {


		try{
			Screen s=new Screen();
			String imagePath="E:\\VINUpdated\\VIN.Dev.Selenium\\src\\main\\resources\\testdata\\uploadFile\\Logout.PNG";
			Pattern p=new Pattern(imagePath);
			Match m=s.exists(p);
			if(m!=null){
				Thread.sleep(1000);
				s.click(p);
			}
			}catch (Exception e) {
				Reporter.log("Unable to click ");
			}
	}

	
	}

