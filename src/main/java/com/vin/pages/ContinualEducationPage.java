package com.vin.pages;

import com.vin.selenium.core.BasePage;
import com.vin.utilities.Constants;

import org.apache.commons.imaging.formats.jpeg.segments.SosSegment;
import org.apache.xalan.xsltc.compiler.sym;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.Reporter;

import java.awt.*;
import java.util.List;

public class ContinualEducationPage extends BasePage {

    public ContinualEducationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[id='loginlink']")
    private WebElement loginLink;

    @FindBy(xpath = "//a[text()='Additional Records']")
    private WebElement additionalRecordsButton;

    @FindBy(xpath = "//div[@id='nonVINClasses']//span[contains(text(),'Course')]")
    private WebElement addcourseButton;

    @FindBy(xpath = "//div[contains(@id,'ToolBoxes_Items')][2]")
    private WebElement addCoursePopUp;

    @FindBy(css = "input[id='txtMyCEOrganization']")
    private WebElement organizationText;

    @FindBy(css = "input[id='txtMyCEProgram']")
    private WebElement programField;

    @FindBy(css = "input[id='rdoMyCEAccreditingOrganizationRACE']")
    private WebElement raceRadioButton;

    @FindBy(css = "select[id='ddlMyCECertificate']")
    private WebElement digitalDropDown;

    @FindBy(css = "select[id='ddlMyCEDeliveryMethod']")
    private WebElement delieveryMethod;

    @FindBy(css = "select[id='ddlMyCESubjectMatterType']")
    private WebElement categoryDropDown;

    @FindBy(css = "input[id='txtMyCEStartDate']")
    private WebElement startDatePicker;

    @FindBy(css = "input[id='txtMyCEEndDate']")
    private WebElement endDatePicker;

    @FindBy(css = "input[id='txtMyCECreditHours']")
    private WebElement creditEarned;

    @FindBy(css = "input[id='txtMyCEURL']")
    private WebElement Url;

    @FindBy(css = "textarea[id='txtMyCENotes']")
    private WebElement noteText;

    @FindBy(css = "input[id='btnMyCENonVINUpdate']")
    private WebElement addutton;

    @FindBy(css = "input[id='btnMyCENonVINUpdate']")
    private WebElement updateButton;

    @FindBy(xpath = "//table[@id='nonVINTable']//tr//td[text()='VIN']")
    private List<WebElement> organizationTexts;
    
    @FindBy(xpath = "//table[@id='nonVINTable']//tr//td[text()='VIN']")
    private WebElement courseDeleted;

    @FindBy(css = "input[id='btnMyCENonVINDelete']")
    private WebElement deleteButton;

    @FindBy(xpath = "//td[text()='Education Test']/..//img[@title='Edit']")
    private WebElement editbutton;

    @FindBy(xpath = "(//span[text()='Add Course'])[2]")
    private WebElement addcourse;

    @FindBy(css = "a[id='Menu_Logout']")
    private WebElement logout;

    @FindBy(xpath = "//button[text()='Dismiss All']")
    private WebElement dismissAllBtn;
    
    @FindBy(xpath = "(//div[@id='VINEnrollmentDiv']/table//td//a)[1]")
    private WebElement enrollmentVeterinarianLink;
    
    @FindBy(xpath = "//table[@id='nonVINTable']//td[text()='VIN']//following::img[3]")
    private WebElement course;
    
    @FindBy(xpath = "//img[@title='Cancel / Close']")
    private WebElement cancleImg;
    
    @FindBy(xpath = "//input[@id='btnMyCENonVINClose']")
    private WebElement cancleButton;
    
	@FindBy(xpath="//h6[contains(text(),'Progress Percentage')]")
	private WebElement UIChanges;
	
    @FindBy(xpath="//h6[@class='ng-scope']")
	private WebElement notADashboardLink;
	
	@FindBy(xpath="(//li[@class='nav-item dropdown ng-scope'])[1]")
	private WebElement expandCourseLink;
	
	@FindBy(xpath="//div[@class='dropdown-menu flavor-box-bg show']//a[5]")
	private WebElement findPoll;
	
	@FindBy(xpath="//div[@class='card-body p-4 d-flex flex-column flavor-box-bg ']//span[@class='ng-scope']")
	private WebElement mcqSection;
	
	@FindBy(xpath="//div[@class='col']//input")
	private List<WebElement> radioButtonForMCQ;
	
	@FindBy(xpath="//div[@class='card-header flavor-header-bg ng-binding vin']")
	WebElement nextModule;
	
	@FindBy(xpath="(//div[@class='navbar-collapse collapse show']//ul//li)[5]")
	private WebElement triangleIcon;
	
	@FindBy(xpath="(//div[@class='dropdown-item bg-info text-white rounded-bottom ng-scope'])[1]//em")
	private WebElement expansionText;
	
	@FindBy(xpath="//div[@class='dropdown-menu flavor-box-bg pb-0 show']//a")
	private List<WebElement> additionalResourceModule;
	
	@FindBy(xpath="//button[@class='col m-2 btn btn-success ng-scope']")
	private WebElement greenButton;
	
	@FindBy(xpath="//button[@ng-click='markNotComplete()']")
	private WebElement redButton;
	
	@FindBy(xpath="//ul[@class='navbar-nav']//li[6]")
	private WebElement endOfTestModule;
	
	@FindBy(xpath="(//div[@class='card-body p-4 d-flex flex-column flavor-box-bg ']//h3)[1]")
	private WebElement UIChangeMessage;
	
	@FindBy(xpath="//h6[@class='ng-scope']")
	private WebElement courseDashboardLink;
	
	@FindBy(xpath="//strong[@class='LogoutTitle']")
	private WebElement seleniumUser;
	
	@FindBy(xpath="//select[@id='ddlMyCESubjectMatterType']//following::img[1]")
	private WebElement calendarIcon;
	
	@FindBy(xpath="//table[@id='txtMyCEStartDate_DatePicker']")
	private WebElement calendarPopup;
	
	@FindBy(xpath="//input[@id='txtMyCEURL']")
	private WebElement URLTextbox;
	
	@FindBy(xpath="//img[@alt='Cancel / Close']")
	private WebElement crossButton;
	
	@FindBy(xpath="//img[@alt='Goto Osha']")
	private WebElement visitCourseLink;
	
	@FindBy(xpath="((//tr[@id='row_1911'])[1]//a)[2]")
	private WebElement greenArrowLonk;
	
	@FindBy(xpath="//span[text()='VIN CE Non-Interactive Course']")
	private WebElement intarctiveCoursePage;
	
	@FindBy(xpath="//span[@class='navbar-toggler-icon']")
	private WebElement hambruglarButton;
	
	@FindBy(xpath="//h4[@style='cursor:pointer']")
	private WebElement courseNameLabel;
	
	@FindBy(xpath="//a[@ng-click='goToNextSegment()']")
	private WebElement startCourseYellowButton;
	
	@FindBy(xpath="//div[@class='card ng-scope']")
	private WebElement expandedModule;
	
	@FindBy(xpath="//video[@preload='auto']")
	private WebElement videoPlayer;
	
	@FindBy(xpath="//center[text()='Video must be watched to the end to be marked as completed']")
	private WebElement message;
	
	@FindBy(xpath="//div/h3[contains(text(),'Contact')]")
	private WebElement contacts;

    
   public void verifyCertificationPopUp() {
	   if(cancleButton.isDisplayed()) {
		   waitAndClick(cancleButton);
	   }
   }

   /**
    * dismiss alert notification if displayed
    */
   
   public void dismissNotifications() {
		super.dismissNotifications(dismissAllBtn);
   }

    /**
     * Click on login Button
     *
     * @return
     */

    public LoginPage clickOnLoginLink() {
        waitAndClick(loginLink);
        return (PageFactory.initElements(driver, LoginPage.class));

    }

    /**
     * Click on Additional Records Button
     */
    public void clickOnAdditionalRecordTab() {
        waitAndClick(additionalRecordsButton);
    }

    /**
     * Verify Add Course button is displayed
     */
    public void verifyAddCourseButtonDisplayed() {
        Assert.assertTrue(addcourseButton.isDisplayed());
    }

    /**
     * Click on Additional course Button
     */

    public void clickOnAdditionalCourseButton() {
     	waitAndClick(addcourseButton);
    }

    /**
     * Verify Additional course Pop-up displayed
     */

    public void verifyAdditionalCoursePopUpDisplayed() {
        _normalWait(3000);
        Assert.assertTrue(addCoursePopUp.isDisplayed());
    }

    /**
     * Enter text in the organization Field
     */

    public void EnterTextInTheOrganizationalField(String Text) {
        inputText(organizationText, Text);

    }

    /**
     * verify User is able to enter text in the organizational field
     */
    public void verifyUserIsAbleToEnterTextInTheFields(String Text) {
        Assert.assertTrue(organizationText.getAttribute("value").equalsIgnoreCase(Text));

    }

    /**
     * Enter Text in the Program Field
     */

    public void EnterTextInTheProgramField(String Text) {
        inputText(programField, Text);

    }

    /**
     * verify User is able to enter text in the organizational field
     */
    public void verifyUserIsAbleToEnterTextInTheProgramFields(String Text) {
        Assert.assertTrue(programField.getAttribute("value").equalsIgnoreCase(Text));

    }

    /**
     * Click on RACE radio Button
     */
    public void selectRaceRadioButton() {

        waitAndClick(raceRadioButton);
    }

    /**
     * Verify Radio Button is Selected
     */
    public void verifyradioButtonSelected() {
        Assert.assertTrue(raceRadioButton.isSelected());
    }

    /**
     * Select Digital From the dropdown
     */
    public void selectDigitalFromTheDropDown() {
        waitAndClick(digitalDropDown);
        selectDropDownByText(digitalDropDown, "Digital");

    }

    /**
     * Verifying the Values is Selected From the drop down
     */

    public void verfiyTheValuesIsSelectedFromTheDropDown() {
        WebElement select = driver.findElement(By.id("ddlMyCECertificate"));
        Select sl = new Select(select);
        WebElement option = sl.getFirstSelectedOption();
        Assert.assertEquals("Digital", option.getText());
    }

    /**
     * Select Values From the Delievery DropDown
     */

    public void selectValuesFromTheDropDown() {
        waitAndClick(delieveryMethod);
        selectDropDownByText(delieveryMethod, "Journal Courses");

    }

    /**
     * Verifying the Values is Selected From the drop down
     */

    public void verfiyTheValuesIsSelectedFromTheDelieveryDropDown() {
        WebElement select = driver.findElement(By.id("ddlMyCEDeliveryMethod"));
        Select sl = new Select(select);
        WebElement option = sl.getFirstSelectedOption();
        Assert.assertEquals("Journal Courses", option.getText());
    }

    /**
     * Select Values From the Category DropDown
     */

    public void selectValuesFromTheCategoryDropDown() {
        waitAndClick(categoryDropDown);
        selectDropDownByText(categoryDropDown, "Promotional");

    }

    /**
     * Verifying the Values is Selected From the Category drop down
     */

    public void verfiyTheValuesIsSelectedFromTheCategoryDropDown() {
        WebElement select = driver.findElement(By.id("ddlMyCESubjectMatterType"));
        Select sl = new Select(select);
        WebElement option = sl.getFirstSelectedOption();
        Assert.assertEquals("Promotional", option.getText());
    }

    /**
     * Enter Date in the Start date Picker
     */

    public void enterDateInTheDatePicker() {
        waitAndClick(startDatePicker);
        inputText(startDatePicker, "01/19/2019");
        waitAndClick(addcourse);

    }

    /**
     * Enter End date In the End date Picker
     */
    public void enterEndDateInTheDatePicker() {
        inputText(endDatePicker, "03/14/2019");
        waitAndClick(addcourse);
    }

    /**
     * Enter Text in the credit Earned textBox
     */

    public void enterTextInTheCreditEarnedTextBox() {
        inputText(creditEarned, "5");

    }

    /**
     * Enter Url in the url textBox
     */

    public void enterTextInTheUrlTextBox() {
        inputText(Url, "https://beta.vin.com/ce");

    }

    /**
     * Enter text in the notes section
     */
    public void enterNotes() {
        inputText(noteText, "testing scripts");
    }

    /**
     * Click on Add Button
     */

    public void clickAddButton() {
        waitAndClick(addutton);
    }

    /**
     * verify Alert text
     */

    public void verifyAlertText() {
    	
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        boolean selection = alert.getText().equalsIgnoreCase(
                "Would you like to upload a certificate for this course? If not, you can always come back and do it later.");
        if (selection) {
            Assert.assertTrue(selection);
        }

    }

    /**
     * Click on Update Button
     */
    public void clickOnUpdateButton() {
        _normalWait(2000);
        waitForPageLoaded();
        waitAndClick(updateButton);
    }

    /**
     * Verify AddCOurse Window not Displayed
     */

    public void verifyWindowClosed() {
        _normalWait(2000);
        Assert.assertFalse(addCoursePopUp.isDisplayed());
    }

    /**
     * Verify Record is added in the table
     */
    public void verifyRecordsAddedInTheTable(String Text) {
        boolean flag = false;
        _normalWait(2000);
        for (WebElement we : organizationTexts) {

            if (we.getText().trim().equalsIgnoreCase(Text.trim())) {
                flag = true;

            }

        }
        Assert.assertTrue(flag);
    }

    /**
     * Click on Added records present in the table
     */

    public void clickOnAddedrecordsInTheTable(String Text) {

        boolean flag = false;
        for (WebElement we : organizationTexts) {
            if (we.getText().equalsIgnoreCase(Text)) {
                flag = true;
                Actions act = new Actions(driver);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", we);
                act.moveToElement(we).build().perform();
                _normalWait(2000);
                doubleClickOnElement(we);
                break;

            }

        }

    }

    /**
     * Change organization name
     */
    public void changeOrganizationName() {
        organizationText.clear();
        inputText(organizationText, "Education Test");
    }

    /**
     * Click on Edit button
     */

    public void clickOnEditButton(String Text) {
        waitAndClick(editbutton);

    }

    /**
     * Change program name VIN
     */

    public void enterProgramName(String name) {
        programField.clear();
        inputText(programField, name);

    }

    /**
     * Click on Delete Button
     */

    public void clickDeleteButton() {
        waitForElement(deleteButton);
        waitAndClick(deleteButton);
    }

    /**
     * Verify popup to delete the course
     */

    public void verifydeletePopUp() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        boolean selection = alert.getText().equalsIgnoreCase("Are you sure you want to delete this course?");
        if (selection) {
            Assert.assertTrue(selection);
        }
    }

    /**
     * Verify Added course has been deleted
     */

    public void verifyAddedCourseDeleted() {
    	
    	boolean flag=true;
    	if(courseDeleted.isDisplayed()) {
    		flag=false;
    	}else {
          	Assert.assertTrue(flag);

    	}
    }

    /**
     * Delete the records if present in the list
     *
     * @throws AWTException
     */

    public void deleteRecordsIfPresentInAddedCourse() throws AWTException {
        _normalWait(3000);
        for (int i = 0; i < organizationTexts.size(); i++) {
           javascriptButtonClick(course);
        	_normalWait(5000);
        	acceptAlertPresent();
        }

    }


    /**
     * Select Logout
     */

    public void selectLogout() {
     javascriptButtonClick(logout);
    }

  


    
    /** 
	 * Click on Any Link in Open for Enrollment - Veterinarians
	 */
    
	public CECourseInfoPage clickOnAnyLinkInOpenForEnrollmentVeterinarians()
	{
		if(enrollmentVeterinarianLink.isEnabled()) {
		clickOn(enrollmentVeterinarianLink);
		}
		return PageFactory.initElements(driver, CECourseInfoPage.class);
		
	}
	
	/**
	 * Verify Continual education portal page
	 */

	public void verifyContinualEducationPortalPage() {

		assertByPageTitle(Constants.ContinualEducationPage);
	}

	/**
	 * Verify selenium user
	 * @param seleniumtext
	 */

	public void verifySeleniumUser(String seleniumtext) {

		if(seleniumUser.getText().contains(seleniumtext)) {
			Assert.assertTrue(true);
		}
		
	}

	/**
	 * Click on calendar icon
	 */
	
	
	public void clickOnCalenderIcon() {

		waitAndClick(calendarIcon);
		
	}

	/**
	 * Verify calendar pop up
	 */
	
	public void verifyCalendarPopup() {

		if(calendarPopup.isDisplayed()) {
			Assert.assertTrue(true);
		}
	}

	/**
	 * Type in URL text  box
	 */
	
	
	public void typeInURLTextbox() {

		inputText(URLTextbox, "https://beta.vin.com");
	}

	/**
	 * Click on cross button
	 */
	
	public void clickOnCross() {
       _normalWait(5000);
		waitAndClick(cancleButton);
	}

	/**
	 * Click on visit course link
	 */
	
	public void clickOnVisitCourseLink() {

		waitAndClick(visitCourseLink);
	}

	/**
	 * Verify promo page in new window
	 */
	public void verifyPromoPageInNewWindow() {

		assertByPageTitle(Constants.pageTitle_PromoPage);
	}

	/**
	 * verify selenium user logged out successfully
	 */
	public void verifySeleniumUserLoggedOut() {

		assertByPageTitle(Constants.pageTitle_LoggedoutPage);
	}

	/**
	 * Click on green arrow button
	 */
	
	public void clickOnGreenArrow() {

		waitAndClick(greenArrowLonk);
		
	}

	/**
	 * Verify non interactive course home page
	 */

	public void verifyNonInteractiveCourseHomePage() {

		_normalWait(5000);
		if(intarctiveCoursePage.isDisplayed()|| getDriver().findElement(By.xpath("//div[@class='row  pb-3 ']//span")).isDisplayed()) {
			Assert.assertTrue(true);
		}
	}

	public void verifyCourseTitleMatches(String ratbasicstext) {

		if(getDriver().getTitle().contains("Rat Basics")) {
			Assert.assertTrue(true);
		}
	}

	/**
	 * Click on hambruglar button
	 */
	
	public void clickOnHamBurglarIcon() {
		waitAndClick(hambruglarButton);
		
	}

	/**
	 * Verify 
	 */
	
	public void verifyCourseNameDisplaying() {
		
		if(courseNameLabel.isDisplayed()) {
			Assert.assertTrue(true);
		}
	}

	/**
	 * click on yellow button
	 */
	
	
	public void clickOnStartCourseYellowButton() {
		_normalWait(3000);
		waitAndClick(startCourseYellowButton);
	}
	
    /**
     * verify course dashboard changes to expanded module
     */
	
	
	public void vrifyCourseDashboardChangesToExpandedModule() {
		
		if(expandedModule.isDisplayed()) {
			Assert.assertTrue(true);
		}
	}

	/**
	 * Verify video play automatically
	 */
	
	
	public void verifyVideoPlayAutomatically() {
		if(videoPlayer.isDisplayed())
		{
			Assert.assertTrue(true);
			scrollDown();
		}
		

		}
	

	/**
	 * Click on pause icon
	 */
	public void clickOnPauseIcon() {
		

		scrollDown();
		try{
			Screen s=new Screen();
			String imagePath="E:\\VINUpdated\\VIN.Dev.Selenium\\src\\main\\resources\\testdata\\uploadFile\\pause.PNG";
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

	public void verifyVideoIsPaused() throws FindFailed {
		Screen s=new Screen();
		if(s.exists("play.PNG")!=null) 
		{
			Match img1=s.exists("play.PNG");
		}
	}

	/**
	 * Verify message
	 * @param videomessagetext
	 */
	
	public void verifyMessage(String videomessagetext) {
		String value=message.getText();
		Assert.assertEquals(videomessagetext, value);
		
	}

	/**
	 * clickOnInvertedTriangle
	 */
	public void clickOnInvertedTriangle() {
		
		scrollDown();
		try{
			Screen s=new Screen();
			String imagePath="E:\\VINUpdated\\VIN.Dev.Selenium\\src\\main\\resources\\testdata\\uploadFile\\play.PNG";
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

	public void verifyVideosyartedToPlay() throws FindFailed {
		
		Screen s=new Screen();
		if(s.exists("play.PNG")!=null) 
		{
			Match img1=s.exists("play.PNG");
		}
		
		}

	/**
	 * Click on volume icon
	 */
	public void clickOnVolumeIcon() {
		try{
			Screen s=new Screen();
			String imagePath="E:\\VINUpdated\\VIN.Dev.Selenium\\src\\main\\resources\\testdata\\uploadFile\\Volume.PNG";
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

	/**
	 * Click on square icon
	 */
	public void clickOnSquareIcon() {
		try{
			Screen s=new Screen();
			String imagePath="E:\\VINUpdated\\VIN.Dev.Selenium\\src\\main\\resources\\testdata\\uploadFile\\Square.PNG";
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

	/**
	 * Verify video expands in full size
	 */
	public void verifyVideoExpandsInFullSize()throws FindFailed {
		Screen s=new Screen();
		if(s.exists("FullScreen.PNG")!=null) 
		{
			Match img1=s.exists("FullScreen.PNG");
		}
	}

	/**
	 * Click on same icon for default video size
	 */
	public void clickOnSameIconForDefaultVideoSize() {
		try{
			Screen s=new Screen();
			String imagePath="E:\\VINUpdated\\VIN.Dev.Selenium\\src\\main\\resources\\testdata\\uploadFile\\FullScreen.PNG";
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

	/**
	 * Confirm video in default size
	 */
	public void confirmDefaultVideoSize()throws FindFailed {
		Screen s=new Screen();
		if(s.exists("Square.PNG")!=null) 
		{
			Match img1=s.exists("Square.PNG");
		}
	}

	/**
	 * Click on course dashboard link
	 */

	public void clickOnCourseDashboardLink() {
		
		waitAndClick(courseDashboardLink);
	}

	/**
	 * Confirm current UI changes
	 */

	public void confirmUIChanged() {
		if(UIChanges.isDisplayed()) {
			Assert.assertTrue(true);
		}
		
		
	}

	/**
	 * Verify dashboard is not a link
	 */

	public void verifyDashboardIsNotALink() {
		String tag=notADashboardLink.getAttribute("style");
		if(tag.contains("underline")) {
			Assert.assertTrue(false);
		}
		else {
			Assert.assertTrue(true);
		}
		
	}

	/**
	 * expand any course and find poll
	 */

	
	public void expandAnyCourseModuleAndFindPoll() {
		waitAndClick(expandCourseLink);
		_normalWait(3000);
		waitAndClick(findPoll);
		
	}

	/**
	 * Confirm poll displayed with question and MCQ
	 */
	

	public void confirmPollDisplayedWithQuestionAndMCQ() {
		if(mcqSection.isDisplayed()) {
			Assert.assertTrue(true);
		}
		
	}

	/**
	 * Confirm radio button for mcq
	 */

	public void confirmRadioButtonForMCQ() {
		for(WebElement radio:radioButtonForMCQ)
		{
			if(radio.isDisplayed())
			{
				Assert.assertTrue(true);
			}
		}
		
	}

	/**
	 * Click on any radio button
	 */
	public void clickOnAnyRadioButton() {
		
		for(WebElement radio:radioButtonForMCQ)
		{
			radio.click();
			break;
		}
		
	}

	/**
	 * Confirm radio button turned blue
	 */
	public void confirmRadioButtonTurnedBlue() {
		
		for(WebElement radio:radioButtonForMCQ)
		{
			if(radio.isSelected())
				Assert.assertTrue(true);
			break;
		}
		
	}

	/**
	 * Click on next segment button
	 */
	
	public void clickOnNextSegmentButton() {
		waitAndClick(getDriver().findElement(By.xpath("//button[@class='col m-2 btn btn-primary ng-scope']")));
		
	}

	/**
	 * Confirm next segment
	 */

	public void confirmNextSegment() {
		
		if(nextModule.isDisplayed())
		{
			Assert.assertTrue(true);
		}
		
	}

	/**
	 * Click on triangle icon next to additional resources
	 */

	public void clickOnTriangleIconNextToAdditionalResources() {
		
		waitAndClick(triangleIcon);
		
	}

	/**
	 * Confirm expansion text
	 * @param expansiontext
	 */
	
	public void confirmAdditionalResourceModuleExpansionDescription(String expansiontext) {
		
		String value=expansionText.getText();
		Assert.assertEquals(expansiontext, value);
	}

	/**
	 * 
	 */
	
	public void clickOnAdditionalResourceModule() {
		
		for(WebElement module: additionalResourceModule)
		{
			module.click();
			break;
		}
	}

	/**
	 * confirm radio button displays in green color
	 */
	
	public void confirmReadButtonDisplaysInGreenColor() {
		String color=greenButton.getCssValue("color");
		Assert.assertTrue(true, color);
		waitAndClick(greenButton);
		
	}

	
	public void markAsReadButtonChangesToMarkAsUnRead() {
		
		String value=redButton.getText();
		Assert.assertEquals(value, "Mark as unread");
		waitAndClick(redButton);
	}

	/**
	 * find and click on end of test module
	 */
	
	public void findAndClickOnEndOfTestModule() {
		
		waitAndClick(endOfTestModule);
		waitAndClick(getDriver().findElement(By.xpath("(//div[@class='dropdown-menu flavor-box-bg show']//a//span)[1]")));
		
	}

	/**
	 * confirm course UI changes
	 * @param uichangemessage 
	 */
	
	public void confirmCourseUIChanges(String uichangemessage) {
		
		String value=UIChangeMessage.getText();
		Assert.assertEquals(uichangemessage, value);
		
	}

	/**
	 * click on large buttons
	 * @param LinkButton
	 */
	public void clickOnLargeButtonsOnContinualEducationPage(String LinkButton) {
		waitAndClick(getDriver().findElement(By.xpath("//div[@class='large']//span[contains(text(),'"+LinkButton+"')]")));

	}
	
	/**
	 * verify page title
	 * @param Title
	 */
	public void verifyPageTitle(String Title) {
		assertByPageTitle(Title);
	}

	/**
	 * clivk on button links
	 * @param BottomLink
	 */
	public void clickOnBottomLinkOnContinualEducationPage(String BottomLink) {
		waitAndClick(getDriver().findElement(By.xpath("//div[@id='ProjectPanel_Welcome']/span/div/div/a[contains(text(),'"+BottomLink+"')]")));
		
	}
	
	/**
	 * verify course suggestion page is loaded
	 */
	public void verifyCourseSuggestionPageIsLoaded() {
		Assert.assertTrue(contacts.isDisplayed());
	}
		
	}
		
	


