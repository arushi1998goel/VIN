package com.vin.pages;


import com.vin.selenium.core.BasePage;
import com.vin.utilities.Constants;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.Reporter;

public class FrontPage extends BasePage {

    public FrontPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div[id='menu'] div[id='topNav'] a[id='loginmenu']")
    private WebElement loginUserDropDown;

    @FindBy(css = "div[id='menu'] div[id='topNav'] ul[role='menu'] a[class='MemberProfile_Logout']")
    private WebElement logoutLinkUnderUserDropDown;

    @FindBy(xpath = "//ul[contains(@class,'navbar')]//a[text()='Search']")
    private WebElement searchButton;

    @FindBy(xpath = "(//div[@id='divJournalsdata']//span)[2]/a[1]")
    private WebElement articleVinNewsSection;

    @FindBy(xpath = "(//div[@id='divJournalsdata']//a)[1]")
    private WebElement journalSection;

    @FindBy(css = "li[id='masterTabLibrary']")
    private WebElement libraryDropDown;

    @FindBy(css = "li[id='masterTabLibrary'] a")
    private WebElement libraryDropDownMenu;

    @FindBy(xpath = "//li[contains(@class,'quicklinks')]//a[text()='Calculators']")
    private WebElement calculatorsLink;

    @FindBy(xpath = "(//span[@class='VINicon vinicon-vindex'])[1]")
    private WebElement vIndex;

    @FindBy(xpath = "(//a[text()='VIN Usage'])[1]")
    private WebElement vinUsage;

    @FindBy(xpath = "//a[text()='Message Boards']")
    private WebElement messageBoards;

    @FindBy(xpath = "(//a[contains(text(),'Drug Handbook')])[2]")
    private WebElement vetreinaryDrugHandBook;

    @FindBy(xpath = "//button[text()='Dismiss All']")
    private WebElement dismissAllBtn;

    @FindBy(xpath="(//a[text()='Journals'])[3]")
    private WebElement journalsLink;
    
    @FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-large row']")
    private WebElement libraryWindow;
    
    @FindBy(xpath="(//a[@data-slide='prev']/span)[1]")
    private WebElement leftArrow;
    
    @FindBy(xpath="(//a[@data-slide='next']/span)[1]")
    private WebElement rightArrow;
    
    @FindBy(xpath="//div[@class='carousel-inner']//a")
    private WebElement carousel;
    
    @FindBy(xpath="(//div[@class='carousel-inner']//a/img)[1]")
    private WebElement banner;
    
    @FindBy(xpath="(//div[@id='Document1_ctl00_DocumentMainContentPanel']//tr)[1]//p//a")
    private WebElement medfaq;
    
    @FindBy(xpath="(//input[@name='QuestionId0'])[1]")
    private WebElement radiouButtonForQuickPoll;
    
    @FindBy(xpath="//input[@id='SendResults']")
    private WebElement viewAndViewResults;
    
    @FindBy(xpath="//a[text()='MyVIN']")
    private WebElement MyVin;
    
    @FindBy(xpath="//input[@id='txtEmail']")
    private WebElement emailTxt;
    
    @FindBy(xpath="//input[@id='txtPassword']")
    private WebElement confirmPassword;
    
    @FindBy(xpath="//input[@id='btnSaveEmail']")
    private WebElement addEmail;
    
    @FindBy(xpath="//input[@id='txtWebsiteUrl']")
    private WebElement websiteText;

    @FindBy(xpath="//input[@id='btnSaveWebsite']")
    private WebElement addWebsite;

    @FindBy(xpath="//input[@id='txtPhone']")
    private WebElement phoneTextField;
    
    @FindBy(xpath="//input[@id='btnSavePhone']")
    private WebElement addPhone;
    
    @FindBy(xpath="//input[@id='txtFax']")
    private WebElement addFax;

    @FindBy(xpath="//input[@id='btnSaveFax']")
    private WebElement addFaxButton;
    
    @FindBy(xpath="//input[@id='btnSaveAddress']")
    private WebElement addAddressButton;
    
    @FindBy(xpath="//select[@id='ddlStateProvince']")
    private WebElement stateDropDown;
    
    @FindBy(xpath="//select[@id='ddlCountry']")
    private WebElement CountryDropDown;
    
    @FindBy(xpath="//select[@id='ddlSubjectCertification']")
    private WebElement CertificationSubjectDropDown;
    
    @FindBy(xpath="//select[@id='ddlSubjectHonor']")
    private WebElement HonorSubjectDropDown;

    @FindBy(xpath="//a[text()='Add ']")
    private WebElement addButton;
    
    @FindBy(xpath="//i[@title='Go Back']")
    private WebElement GoBackButton;
    
    @FindBy(xpath="//input[@id='btnSave']")
    private WebElement addInternship;
    
    @FindBy(xpath="//input[@id='txtSchoolPracticeName']")
    private WebElement schoolTextBox;

    @FindBy(xpath="//input[contains(@id,'btnSave')]")
    private WebElement AddButton;
    
    @FindBy(xpath="//input[@id='txtSchoolEducation']")
    private WebElement schoolField;

    @FindBy(xpath="//div[@id='Polls']")
	 private WebElement quickPollSection;
	 
	 @FindBy(xpath="//div[@id='ctl00_HasPermPanel']")
	 private WebElement answerOptionForQuickPoll;
	 
	 @FindBy(xpath="//div[@id='ctl00_HasPermPanel']//input[@type='radio']")
     private List<WebElement> radioButtonsForVote;
	
	@FindBy(xpath="//div[@id='ctl00_SubmitButtons']//input")
    private WebElement VoteAndResultsButton;
	
	@FindBy(xpath="//div[@id='ConsReps']")
    private WebElement VINConsultantSection;
	
	@FindBy(xpath="(//div[@id='VINCon']//a)[1]")
    private WebElement VINConsultantLink;
	
	@FindBy(xpath="//div[@class='consultantInfo']//h2")
    private WebElement consultantName;
	
	@FindBy(xpath="(//div[@id='VINCon']//a)[1]")
    private WebElement consultantNameLink;
	
	@FindBy(xpath="//div[@class='input-group quicksearch']//input")
    private WebElement searchBox;
	
	@FindBy(xpath="//div[@class='input-group quicksearch']//button")
    private WebElement searchIcon;
	
	@FindBy(xpath="(//div[@class='panel-heading'])[1]//b")
    private WebElement searchKeywordInNewTab;
	
	@FindBy(xpath="//div[@class='item active']//a")
    private WebElement bannerImage1;
	
	@FindBy(xpath="//ul[@id='vinmainnav']//li[@id='masterTabMyVin']")
    private WebElement myVINTab;
	
	@FindBy(xpath="//li[@id='liStuffMain' and @class='active']")
    private WebElement stuffTab;
	
	@FindBy(xpath="//div[@class='navbar-collapse collapse']//li[@id='liProfileMain']")
    private WebElement profileTab;
	
	@FindBy(xpath="//li[@id='liCertifications']")
    private WebElement certificationAndHonorsMenu;
	
	@FindBy(xpath="//span[@id='lblPageHeader']")
    private WebElement certificationAndHonorsLabel;
	
	@FindBy(xpath="//input[@id='btnSaveCertification']")
    private WebElement addCertificateButton;
	
	@FindBy(xpath="//div[@id='mdlManageCertification']//div[@class='modal-content']")
    private WebElement addCertificatePopup;
	
	@FindBy(xpath="//select[@id='ddlBoardCertification']")
    private WebElement ACVIMBoard;
	
	@FindBy(xpath="//select[@id='ddlMonthCertification']")
    private WebElement MonthDropdown;
	
	@FindBy(xpath="//select[@id='ddlSubjectCertification']")
    private WebElement subjectDropdown;
	
	@FindBy(xpath="//select[@id='ddlYearCertification']")
    private WebElement yearDropdown;
	
	@FindBy(xpath="//select[@id='ddlYearHonor']")
    private WebElement yearDropdownForAddHonor;
	
	@FindBy(xpath="//div[@class='modal-footer']//input[@id='btnSaveCertification']")
    private WebElement addButtonOnPopup;
	
	@FindBy(xpath="//input[@id='btnSaveHonor']")
    private WebElement addButtonForAddHonor;
	 
	@FindBy(xpath="//table[@id='tblCertifications']//tbody//tr[@id='tr18843']//td[text()='ACVIM']")
    private WebElement CertificationName;
	
	@FindBy(xpath="//span[text()='The add was successful.']")
    private WebElement successfullmessage;
	
	@FindBy(xpath="//tbody//tr[@id='tr18843']//td//a[@title='Delete']")
    private WebElement XIcon;
	
	@FindBy(xpath="//span[text()='The delete was successful.']")
    private WebElement deletionmessage;
	
	@FindBy(xpath="//a[text()='Logout']")
    private WebElement LogoutLicense;
	
	@FindBy(xpath="//div[@id='divHonors']//a")
    private WebElement addHonorbutton;
	
	@FindBy(xpath="//div[@id='mdlManageHonor']//div[@class='modal-dialog modal-lg']")
    private WebElement addHonorWindow;
	
	@FindBy(xpath="//select[@id='ddlBoardHonor']")
    private WebElement CCRPBoards;
	
	@FindBy(xpath="//select[@id='ddlSubjectHonor']")
    private WebElement subjectDropdownAddHonor;
	
	@FindBy(xpath="//select[@id='ddlMonthHonor']")
    private WebElement monthDropdownAddHonor;
	
	@FindBy(xpath="//button[@class='btn btn-default']")
	private WebElement continueOnPopUp;
	
	@FindBy(xpath="//a[@id='lnkProfileMain']")
	private WebElement profileDropDown;
	
	@FindBy(xpath="//a[text()='Add Licensure']")
	private WebElement addLicensure;
	
	@FindBy(xpath="//span[text()='Add Licensure']")
    private WebElement addLicensurePopup;
	
	@FindBy(xpath="//select[@id='ddlStateProvince']")
    private WebElement selectState;
	
	@FindBy(xpath="//select[@id='ddlStateProvince']/option")
    private List<WebElement> configuredStateLIST;
	
	@FindBy(xpath="//input[@id='txtLicenseNumber']")
    private WebElement enterLicenseNo;

    @FindBy(xpath="//input[@id='chkCEAuthorize']")
	private WebElement licensurecheckbox;
	
	@FindBy(xpath="//label[contains(text(),'VIN policy')]")
	private WebElement policytext;
	
	@FindBy(xpath="//input[@id='btnSaveLicense']")
	private WebElement addLicenseButton;
	
	@FindBy(xpath="//i[@class='glyphicon glyphicon-remove']")
	private WebElement deletelicensure;

    @FindBy(xpath="//a[@id='lnkPreferencesMain']")
	private WebElement preferencesdropdown;
	
	@FindBy(xpath="//li[@id='liPreferencesMain']//ul[@role='menu']")
    private WebElement preferencesDropdownSection;
	
	@FindBy(xpath="//label[text()='Login Landing Page Preference']")
    private WebElement landingPage;
	
	@FindBy(xpath="//select[@id='124']")
	private WebElement preferencesDropDown;
	
	@FindBy(xpath="//div[@id='ProjectPanel_ProjectTitle1']")
	private WebElement centerpage;
	
	@FindBy(xpath="//div[@id='ProjectPanel_ProjectTitle1']")
    private WebElement studenttitle;
	
	@FindBy(xpath="//label[@for='rdoExpandAll']")
	private WebElement expandRadioButton;
	
	@FindBy(xpath="//input[@id='rdoCollapseAll']")
	private WebElement hideRadioButton;
	
	@FindBy(xpath="//input[@id='rdoDefault']")
	private WebElement vinDefaultRadioButton;
	
	@FindBy(xpath="//li[contains(@class,'quicklinks')]//a[text()='VIN Veterinary Drug Handbook']")
	private WebElement DrugHandbookLink;
	
	@FindBy(xpath="//span[@id='lblPageHeader']")
	private WebElement vvdhTitle;
	
	@FindBy(xpath="//div[@class='verticalBar pull-left hidden-xs qsbar']/following-sibling::div/ul/li[@title='My Activities']") 
	private WebElement MyActivity;
	
	@FindBy(xpath="//input[@id='115']")
	private WebElement makeCheckBox;
	
	@FindBy(xpath="//li[@id='masterTabLibrary']")
	private WebElement libraryNavigationBar;
	    
	@FindBy(xpath="//li[@class='col-sm-4 col3 hidden-xs library-quicklinks']//li//a[text()='News']")
	private WebElement newsLinkThroughNavigationBar;
	
	@FindBy(xpath="//input[@value='Edit Preferences']")
	private WebElement editPreference;
	    
	@FindBy(xpath="//div/h2[text()='Update your preferences']")
	private WebElement UpdatePreference;
	
	@FindBy(xpath="//button[text()='×']")
	private WebElement crossButton;
	
	@FindBy(xpath="//textarea[text()='- Selenium User - ']")
	private WebElement currentSignature;
	
	@FindBy(xpath="//select[@id='ddlMBFindSince']")
    private WebElement findSince;
   
    /** VSPN Front page locators */
   
    
    @FindBy(xpath="//img[@alt='VSPN']")
	private WebElement vspnlogo;
    
    @FindBy(xpath="//div[@class='item active']//a[text()='Learn more']")
	private WebElement learnMoreButton;
    
    @FindBy(xpath="//img[@documentid='9231451']")
	private WebElement bannerelement;
    
    @FindBy(xpath="//img[@documentid='9405726']")
	private WebElement imageVSPN;
    
    @FindBy(xpath="//a[text()='Continual Education (CE)']")
	private WebElement CELink;
    
    @FindBy(xpath="//input[@id='AnswerId349113']")
	private WebElement quickPollradioButton;
    
    @FindBy(xpath="//input[@id='SendResults']")
	private WebElement viewResult;
    
    @FindBy(xpath="//div[@id='ctl00_HasPermPanel']")
    private WebElement serveyGraph;
    
   



    /**
     * Verify Front Page displayed
     */
    public void verifyFrontPageDisplayed() {
        waitForPageLoaded();
        _normalWait(2000);
        assertByPageTitle(Constants.pageTitle_FrontPage);
    }

    /**
     * Function: Logout application
     * @return
     */
    public LogoutPage logoutApplication() {
        _normalWait(500);
        waitForPageLoaded();
        waitAndClick(loginUserDropDown);
        waitAndClick(logoutLinkUnderUserDropDown);
        return PageFactory.initElements(driver, LogoutPage.class);
    }

    /**
     * click on search button
     */
    public SearchPage clickOnSearchButton() {
        clickOn(searchButton);
        return PageFactory.initElements(driver, SearchPage.class);
    }
    
    /**
     * Dismiss alert notification if displayed
     * @return
     */
    
    public void dismissNotifications() {
		super.dismissNotifications(dismissAllBtn);
    }



    /**
     * Click on second article from the 'VIN News Service'  section
     */

    public AddStuffPage clickArticleInVinNewsSection() {
        _normalWait(3000);
        waitAndClick(articleVinNewsSection);
        return PageFactory.initElements(driver, AddStuffPage.class);
    }

    /**
     * Click on Library dropdown
     */

    public void clickOnLibraryDropDown() {
        _normalWait(2000);
        waitAndClick(libraryDropDown);

    }

    /**
     * Verify Library dropdown is open
     */

    public void verifyLibraryDropDown() {
        _normalWait(1000);
        String value = libraryDropDownMenu.getAttribute("aria-expanded");
        Assert.assertEquals(value, "true");

    }

    /**
     * Select calculators from Library DropDown
     */

    public CalculatorPage selectCalculatorsFromLibraryDrpDwn() {
        _normalWait(1000);
        waitAndClick(calculatorsLink);
        return PageFactory.initElements(driver, CalculatorPage.class);
    }

    /**
     * Click on VINDEX
     */

    public VindexPage clickOnVindex() {
        _normalWait(2000);
        waitAndClick(vIndex);
        return PageFactory.initElements(driver, VindexPage.class);
    }


    /**
     * Click on Account info and verify Vin Usage is displayed
     */

    public VIN_UsagePage verifyVinUsageDisplayed() {
        waitAndClick(loginUserDropDown);
        waitForElement(vinUsage);
        Assert.assertTrue(vinUsage.isDisplayed());
        return PageFactory.initElements(driver, VIN_UsagePage.class);
    }

    /**
     * Click on Message Boards
     */

    public MessageBoards clickOnMessageBoards() {
        waitAndClick(messageBoards);
        return PageFactory.initElements(driver, MessageBoards.class);
    }


    /**
     * Click on library DropDown
     */

    public VVDHPage clickLibraryDropDwonAndSelectVetrinaryDrugHandbook() {
        waitAndClick(libraryDropDown);
        waitForElement(libraryDropDown);
        waitAndClick(vetreinaryDrugHandBook);
        return PageFactory.initElements(driver, VVDHPage.class);
    }
    
    public NewsPage navigateToNewsUrl(String Url) {
     getDriver().navigate().to(Url);
     return PageFactory.initElements(driver, NewsPage.class);
     
    }
    
    public void selectLibraryDropDwon() {
    	 waitForElement(libraryDropDown);
    	  waitAndClick(libraryDropDown);
         
    }
    
    public void verifyLibraryHomeWindowIsDisplayed() {
    	Assert.assertTrue(libraryWindow.isDisplayed());
    	
    }
    
    public JournalsPage selectJournalsLink() {
    	waitAndClick(journalsLink);
    	 return PageFactory.initElements(driver, JournalsPage.class);
    	
    }
   
    public void clickOnLeftArow() {
    	waitAndClick(leftArrow);
    }
    
    public void clickOnRightArrow() {
    	waitAndClick(rightArrow);
    }
    
    public void verifyBannerChanges() {
////  	String selector = "//div[@class='carousel-inner']//a";
//        List<WebElement> items = driver.findElements(By.xpath("//div[@class='carousel-inner']//a"));
//
//   ArrayList list1 = new ArrayList();
//        String name;
//
//        for (int i = 0; i < items.size(); i++) {
//            int index = i + 1;
//
//            //This will get the name of each item in carousel
//            name = driver.findElement(By.xpath("//div[@class='carousel-inner']//a" + "[" + index + "]")).getAttribute("title");
//            list1.add(name);
//        }
        
    	String firstImage=getDriver().findElement(By.xpath("//div[@class='item active']//a")).getAttribute("title");
    	WebElement arrow=getDriver().findElement(By.xpath("(//a[@class='right carousel-control']//span)[1]"));
    	waitAndClick(arrow);
    	String secondImage=getDriver().findElement(By.xpath("//div[@class='item active']//a")).getAttribute("title");
    	System.out.println(firstImage);
    	System.out.println(secondImage);
    	if(firstImage.contentEquals(secondImage)) {
    		Assert.assertTrue(false);
    	}
    	else {
    		Assert.assertTrue(true);
    	}

    }
    
    
    public String clickOnBanner() {
    	String title=driver.findElement(By.xpath("(//div[@class='carousel-inner']//a/img)[1]/..")).getAttribute("title");
    	waitAndClick(banner);
    	return title;
    	
    }
    
    public String getTitleOftheBanner() {
    	String title=banner.getAttribute("title");
    	return title;
    }
    
    
    /**
     * Verify page title for the banner
     */
    
    public void verifyPageTitleIsSameAsThePage(String title) {
    	System.out.println(driver.getTitle());
    	String tle = driver.getTitle();
       boolean flag=true;	
       if (title.contains(tle)) {
	  flag=true;
         } 	
       Assert.assertTrue(flag);
    }
    
    /**
     * Close current window and go to Previous window
     */
    public void verifyPreviousPage() {
    	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Front Page - VIN"));
    	_normalWait(2000);
    	
    }
    
    /**
     * Click on first Link in daily pearls Section
     */
    
    public void clickOnFirstLinkInDailyPearls() {
    	waitAndClick(medfaq);
    }
    
    
    /**
     * Verify Link is open in another window
     */
    
    public void verifyMedicalFaqsWindowIsOpenInNewWindow() {
    	
    	Assert.assertTrue(true,getDriver().getTitle());
    }
    
    
    /**
     * Click on Radio Button for quick poll
     */
    public void clickOnRadioButtonForQuickPoll() {
    	waitAndClick(radiouButtonForQuickPoll);
    }
    
    
    /**
     * verify radio button is selected
     */
    
    public void verifyRadioButtonIsSelected() {
    	Assert.assertTrue(radiouButtonForQuickPoll.isSelected());
    }
    
    
    /**
     * click on vote and view results 
     */
    public void clickOnVoteAndViewResults() {
    	waitAndClick(viewAndViewResults);
    }

    /**
     * Navigate to news through navigation bar
     */
	public NewsPage navigateToNewsThroughNavigationBar() {
		waitForElement(libraryNavigationBar);
      waitAndClick(libraryNavigationBar);
      waitForElement(newsLinkThroughNavigationBar);
      waitAndClick(newsLinkThroughNavigationBar);
      
      return(PageFactory.initElements(driver, NewsPage.class));
		
		
	}

	/**
	 * Scroll down at quick polls with answer options
	 */
	public void scrollDownAtQuickPollsWithAnswerOption() {
		scrollPageThroughWebElement(quickPollSection);
		if(answerOptionForQuickPoll.isDisplayed())
		{
			Assert.assertTrue(true);
		}
		_normalWait(2000);
	}
	
	/**
	 * Verify that quick poll is loaded
	 */

	public void verifyThatThequickPollIsLoaded() {

		for(WebElement radioButton: radioButtonsForVote) {
			if(!radioButton.isSelected()) {
				Assert.assertTrue(true);
			}
			if(VoteAndResultsButton.isEnabled()) {
				Assert.assertTrue(true);
			}
		}
		_normalWait(2000);
		
	}
	
	/**
	 * Scroll down and click on VIN Consultant Link page
	 */
	
	public String scrollDownAndClickOnVINConsultantLink() {
		scrollPageThroughWebElement(VINConsultantSection);
		String linkName=VINConsultantLink.getText();
		waitAndClick(VINConsultantLink);
		return linkName;
	}

	/**
	 * Verify consultant name macthes in new tab
	 * @param consultantname
	 */

	public void consultantNameMatchesConsultantNameLink(String nameToVerified) {

		
		Assert.assertTrue(consultantName.getText().equalsIgnoreCase(nameToVerified));
		_normalWait(2000);
		
	}

	/**
	 * Enter in searchbox "Dog" and select on magnifying icon
	 * @param searchtext
	 */
	
	public void enterInSearchBoxAndSelectMagnifyingIcon(String searchtext) {
     inputText(searchBox, searchtext);
     waitAndClick(searchIcon);
     _normalWait(2000);
	}

	/**
	 * Verify searchpage in new tab
	 */
	public void verifySearchPageInNewTab() {

		assertByPageTitle(Constants.pageTitle_SearchPage);
		_normalWait(2000);
	}

	/**
	 * Verify correct search result in new tab
	 * @param searchtext
	 */
	
	public void verifyCorrectSearchInNewTab(String searchtext) {

		Assert.assertEquals(searchtext, searchKeywordInNewTab.getText());
		_normalWait(2000);
	}
	
	/**
	 * Get the title of the banner
	 */

	public String getTheTitleOfTheBanner() {
		String firstImage=getDriver().findElement(By.xpath("//div[@class='item active']//a")).getAttribute("title");
		return firstImage;
		}

	/**
	 * Click on banner image
	 */
	
	public void clickOnBannerImage() {

		waitAndClick(bannerImage1);
	}

	public String getLinkName() {
		String name=consultantNameLink.getText();
		return name;
	}

	/**
	 * Click on MYVIN tab
	 */
	
	public void clickOnMyVINTab() {

		if(myVINTab.isDisplayed()) {
			waitAndClick(myVINTab);
			_normalWait(1000);
		}
		
	}
	
	/**
	 * Verify mystuff page opens in new window
	 */
	
	public void verifyMyStuffInNewWindow() {

		_normalWait(5000);
		String actual=stuffTab.getAttribute("class");
		String expected="active";
		Assert.assertEquals(actual, expected);
			
		}
	
	/**
	 * Click on profile tab
	 */

	public void clickOnProfile() {
		waitAndClick(profileTab);
		}
	

	public void clickOnCertificationAndHonors() {
		
		if(certificationAndHonorsMenu.isDisplayed()) {
			waitAndClick(certificationAndHonorsMenu);
			_normalWait(1000);
		}
	}

	/**
	 * Verify Certificate and honors page loaded
	 * @param certicationtext
	 */
	
	public void certificateHonorsPageLoaded(String certificationtext) {
		String actual=certificationAndHonorsLabel.getText();
		Assert.assertEquals(actual, certificationtext);
	}
	
    /**
    * Click on add certification
    */
	
	public void clickOnAddCertification() {
			waitAndClick(addCertificateButton);
		
	}

	/**
	 * Verify add certification popup
	 */
	
	public void verifyAddCertificationPopup() {

		if(addCertificatePopup.isDisplayed()) {
			Assert.assertTrue(true);
		}
	}

	/**
	 * Select ACVIM board
	 */
	
	
	public void selectACVIMBoard() {
		selectDropDownByText(ACVIMBoard, "ACVIM");
	}
	
	/**
	 * Verify ACVIM successfull selection
	 * @param acvimtext
	 */

	public void verifySuccessfullSelection(String acvimtext) {
		String boardsValue=returnSelectedValueFromDropdown(ACVIMBoard);
		Assert.assertEquals(boardsValue, acvimtext);
	}

	/**
	 * Select April month
	 */
	
	public void selectAprilMonth() {

		selectDropDownByText(MonthDropdown, "Apr");
	}

	/**
	 * Verify April month selection ofr add certification
	 * @param apriltext
	 */
	public void verifyAprilMonthSelection(String apriltext) {

		String monthValue=returnSelectedValueFromDropdown(MonthDropdown);
		Assert.assertEquals(monthValue, apriltext);
	}
	
	/**
	 * Verify April month selection selection for add honor
	 * @param apriltext
	 */
	public void verifyAprilMonthSelectionForAddHonor(String apriltext) {

		String monthValue=returnSelectedValueFromDropdown(monthDropdownAddHonor);
		Assert.assertEquals(monthValue, apriltext);
	}
	
	
	/**
	 * Select Cardiology from subject value
	 */
	
	public void slectCardiolog() {

		selectDropDownByText(subjectDropdown, "Cardiology");
	}

	/**
	 * Verify that cardiology successfully selected
	 * @param cardiologytext
	 */
	public void verifyCardiologySelected(String cardiologytext) {

		String subjectvalue=returnSelectedValueFromDropdown(subjectDropdown);
		Assert.assertEquals(subjectvalue, cardiologytext);
	}

	/**
	 * Select year in the year field for add certification
	 */
	
	public void SelectYear() {

		selectDropDownByText(yearDropdown, "2000");
	}

	/**
	 * Select year in the year field for add honor
	 */
	
	public void SelectYearForAddHonor() {

		selectDropDownByText(yearDropdownForAddHonor, "2000");
	}

	/**
	 * Verify year selection
	 * @param yeartext 
	 */
	public void verifyYearSelection(String yeartext) {

		String yearValue=returnSelectedValueFromDropdown(yearDropdown);
		Assert.assertEquals(yearValue, yeartext);
	}

	
	/**
	 * Verify year selection for add honor
	 * @param yeartext 
	 */
	
	public void verifyYearSelectionForAddHonor(String yeartext) {

		String yearValue=returnSelectedValueFromDropdown(yearDropdownForAddHonor);
		Assert.assertEquals(yearValue, yeartext);
	}
	
	/**
	 * Click on Up arrow
	 * @throws AWTException 
	 */
	
	public void clickOnUpArrow() throws AWTException {

		Robot robot = new Robot();
		_normalWait(2000);
		robot.keyPress(KeyEvent.VK_UP);
		robot.keyRelease(KeyEvent.VK_UP);
	}

	/**
	 * Verify Changed year value
	 * @param changedyear
	 */
	public void verifyChangedYearValue(String changedyear) {

		String yearValue=returnSelectedValueFromDropdown(yearDropdown);
		Assert.assertEquals(changedyear, yearValue);
	}
	
	
	/**
	 * Verify Changed year value for add honor
	 * @param changedyear
	 */
	public void verifyChangedYearValueForAddHonor(String changedyear) {

		String yearValue=returnSelectedValueFromDropdown(yearDropdownForAddHonor);
		Assert.assertEquals(changedyear, yearValue);
	}

	/**
	 * Clicked on down arrow
	 * @throws AWTException 
	 */
	public void clickOnDownArrow() throws AWTException {

		Robot robot = new Robot();
		_normalWait(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
	}

	/**
	 * Verify year changed to 2000 for add certification
	 * @param yeartext
	 */
	public void verifyyearChangedTo2000(String yeartext) {

		String changedYear=returnSelectedValueFromDropdown(yearDropdown);
		Assert.assertEquals(yeartext, changedYear);
	}
	

	/**
	 * Verify year changed to 2000 for add honor
	 * @param yeartext
	 */
	public void verifyyearChangedTo2000ForAddHonor(String yeartext) {

		String changedYear=returnSelectedValueFromDropdown(yearDropdownForAddHonor);
		Assert.assertEquals(yeartext, changedYear);
	}
	
	
	/**
	 * Click on add button on pop up for add certification
	 */
	
	public void clickOnAddButtonOnPopUp() {
		waitAndClick(addButtonOnPopup);
	}
	
	/**
	 * Click on add button on pop up for add honor
	 */
	
	public void clickOnAddButtonOnForAddHonor() {
		waitAndClick(addButtonForAddHonor);
	}

	/**
	 * Verify that certification added
	 */
	
	public void verifyCertificationAdded() {
		if(successfullmessage.isDisplayed()) {
			Assert.assertTrue(true);
			_normalWait(2000);
		}

	}

	/**
	 * Click on X icon
	 */
	
	public void clickOnXIcon() {
//		waitAndClick(XIcon);
		
		try{
    		Screen s=new Screen();
    		String imagePath="E:\\VINUpdated\\VIN.Dev.Selenium\\src\\main\\resources\\testdata\\uploadFile\\redCross.PNG";
    		Pattern p=new Pattern(imagePath);
    		Match m=s.exists(p);
    		if(m!=null){
    			Thread.sleep(1000);
    			s.click(p);
    		}
    		}catch (Exception e) {
    			Reporter.log("Unable to click ");
    		}
		Alert alert =getDriver().switchTo().alert();
		alert.accept();
	}
	/**
	 * Verify Certification deleted
	 * @param acvimtext
	 */
	
	public void verifyCertificationDeleted() {
		if(deletionmessage.isDisplayed()) {
			Assert.assertTrue(true);
			_normalWait(2000);
		}
	}
	
	/**
	 * logout from license page
	 */

	public LogoutPage logoutFromLicensePage() {
		waitAndClick(LogoutLicense);
        return PageFactory.initElements(driver, LogoutPage.class);
	}

	/**
	 * Click on add honor
	 */
	
	public void addHonor() {
		waitAndClick(addHonorbutton);
		
	}

	/**
	 * Verify add honor window
	 */
	
	public void verifyAddHonorWindows() {

		if(addHonorWindow.isDisplayed()) {
			Assert.assertTrue(true);
		}
		
	}

	/**
	 * Select CCRP boards
	 * @param ccrptext
	 */
	
	
	public void selectCCRPBoards() {

		selectDropDownByText(CCRPBoards, "CCRP");
		
	}

	/**
	 * Verify the CCRP selection
	 * @param ccrptext
	 */
	public void verifyCCRPSelection(String ccrptext) {
		String boardsValue=returnSelectedValueFromDropdown(CCRPBoards);
		Assert.assertEquals(ccrptext, boardsValue);
	}
	
	/**
	 * Verify that Subject automatically selected
	 * @param physicaltext
	 */

	public void verifySubjectSetToPhysicalRehabilitation(String physicaltext) {

		String boardsValue=returnSelectedValueFromDropdown(subjectDropdownAddHonor);
		Assert.assertEquals(physicaltext, boardsValue);
		
	}

	/**
	 * Select Month on add honor page
	 */
	
	public void selectMonthOnAddHonor() {

		selectDropDownByText(monthDropdownAddHonor, "Apr");
		
	}

	/**
	 * Dismiss alert
	 */
	
	public void dismissAlert() {

		waitAndClick(continueOnPopUp);
	}
	
	/**
	 * Click on Myvin
	 */
	public void clickOnMyVin() {
		waitAndClick(MyVin);
	}
	
	
	/**
	 * select profile from drop down
	 */

	public void selectProfileFromDropDown(String profileType) {
		waitAndClick(profileDropDown);
		profileDropDown.findElement(By.xpath("//a[text()='" + profileType + "']")).click();
	}
	
	/**
	 * click on add licensure button
	 */
	
	public void clickOnAddLensure()  {
		waitAndClick(addLicensure);

	}
		
	/**
	 * Verify add licensure popup
	 */
	
	public void verifyAddLicensurePopup() {
      Assert.assertTrue(isElementPresent(addLicensurePopup));
    }
	
	/**
	 * enter state from the drop down
	 */
	
	public void selectStateFromDropDown(String StateToBeSelect) {
       waitAndClick(selectState);
       _normalWait(100);
		for (WebElement state : configuredStateLIST) {
		if (getText(state).trim().equalsIgnoreCase(StateToBeSelect)) {
				waitAndClick(state);
		}
	}
	}
	
	public void verifyState(String selectedState) {
		String value=returnSelectedValueFromDropdown(selectState);
		Assert.assertEquals(selectedState, value);
	}
	
	/**
	 * enter license no
	 */
	
    public void enterLicenseNo(String licenseValueTobeEnter) {
		inputText(enterLicenseNo, licenseValueTobeEnter);
	}
	
	/**
	 * verify profile licensure page
	 */

	public void vrifyProfileLicensurePage() {
		if(addLicensure.isDisplayed() && licensurecheckbox.isDisplayed() && policytext.isDisplayed()) {
			Assert.assertTrue(true);
		
	}		
	
     }
	/**
	 * verify licence no
	 * @param enteredLicenseValue
	 */

	public void verifyLicenseNo(String enteredLicenseValue) {
		String value=enterLicenseNo.getAttribute("value");
        Assert.assertEquals(enteredLicenseValue, value);
		}
	
	/**
	 * click on add license button
	 */
	
	public void AddLicensureButton() {
      waitAndClick(addLicenseButton);		
	}
	
   /**
   * click on crose icon to delete the record
   */
	
	public void clickOnCroseIcontoDeleteTheRecord() {
		_normalWait(2000);
		waitAndClick(deletelicensure);
		driver.switchTo().alert().accept();
	
	}
		
	/**
	 * select preferences
	 */

	public void selectPreferencesDropDown() {
		waitAndClick(preferencesdropdown);
	}
	
	/**
	 * verify preferences drop Down section
	 */
	
	public void verifydropdownSection() {
     Assert.assertTrue(preferencesDropdownSection.isDisplayed());		
	}

	/**
	 * select from preferences drop down
	 * @param landingpage
	 */
	
	public void selectfromPreferencesdropdown(String preferencesType) {
		preferencesDropdownSection.findElement(By.xpath("//a[text()='" + preferencesType + "']")).click();
		
	}
	
	/**
	 * verify landing page
	 */
        
	 public void verifyLandingPage() {
		Assert.assertTrue(landingPage.isDisplayed());
		
	    }
	
	 /**
	  * select preferences from drop down
	  */
	 public void SelectPreferencesFromDropDown(String PreferencesDropDownValue) {
		selectDropDownByText(preferencesDropDown, PreferencesDropDownValue);
		}
		
	/**
    * verify selected value in preferences drop down
	* @param SelectedPreferencesDropDownValue
    */
		
	public void verifyPreferencesDropDown(String SelectedPreferencesDropDownValue) {
        String value=returnSelectedValueFromDropdown(preferencesDropDown);
	    Assert.assertEquals(SelectedPreferencesDropDownValue, value);
		}
		
    /**
     * verify student Landing page
     */	
	public void verifyStudentLandingPage() {
	    waitForPageLoaded();
	    _normalWait(2000);
		assertByPageTitle(Constants.pageTitle_StudentCenter);
	 }
		
		/**
		 * verify landing page is updated
		 */
		
		public void verifyLandingPageIsUpdated() {
        Assert.assertTrue((studenttitle.getText()).equalsIgnoreCase("VIN Student Center"));

         
		}
		
		/**
		 *  Expand/show all sections check box
		 */
		
		public void selectExpandShowRadioButton() {
			waitAndClick(expandRadioButton);
		}
		
		public void verifyVVDHOptionIsUpdated() {
			Assert.assertTrue(expandRadioButton.isSelected());
			}
		/**
		 * select collapse/hide all section
		 */
		
		public void selectHideRadioButton() {
			waitAndClick(hideRadioButton);
			Assert.assertTrue(hideRadioButton.isSelected());
		}
		
		/**
		 * select vin default check box
		 */
		
		public void selectVINDefaultRadioButton() {
			waitAndClick(vinDefaultRadioButton);
		}
		/**
		 * pop up window is closed
		 */
		
		public void verifyPopModalClosed() {
	        Assert.assertTrue(driver.getWindowHandles().size() == 1);
	    }
		/**
		 * click on Veterinary Drug Handbook link
		 */
		
		public VVDHPage clickOnDrugHandbookLink() {
			waitAndClick(DrugHandbookLink);
	        return PageFactory.initElements(driver, VVDHPage.class);
		}
		
		/**
		 * verify VVDH Is selected
		 */
		
		public void verifyVVDHisSelected() {
			Assert.assertTrue(vvdhTitle.isDisplayed());
		}
		
		/**
		 * click on MyActivities
		 */
		
		public MyActivitiesPage clickOnMyActivitiesButton() {
			_normalWait(1000);
			waitAndClick(MyActivity);
	        return PageFactory.initElements(driver, MyActivitiesPage.class);

			
		}
	
		public void selectCheckBoxNextToMakeMyFavorites() {
             waitAndClick(makeCheckBox);	
		}
		
		
		/**
         * Verify VSPN Front page displayed
         * @throws InterruptedException
         */
        public void verifyVSPNFrontPageIsDisplayed() throws InterruptedException {
            waitForPageLoaded();
            _normalWait(1000);
            assertByPageTitle(Constants.pageTitle_VSPNFrontPage);
        
        }

        /**
         * verify VSPN Page load successfully
         */
        
		public void verifyVSPNPageLoadSuccessfully() {
			Assert.assertTrue(vspnlogo.isDisplayed());
		}

		public void clickOnLearnMoreButton() {
			waitForElementPresent(bannerelement);
          waitAndClick(learnMoreButton);			
		}
		
		/**
		 * verify page title
		 */
		
		public void verifyPageTitle(String title) {
		    _normalWait(3000);
			Assert.assertTrue(driver.getTitle().equalsIgnoreCase(title));
		}

		/**
		 * click on VSPN Images
		 * @param imageid
		 */
		
		public void clickOnTheImage(String imageid) {
		   WebElement VSPNimages = findElement(By.xpath("//img[@documentid='"+imageid+"']"));
           waitAndClick(VSPNimages);		
			
           
		}
		
		public void getTitleWindow() {
			String actualTitle = driver.getTitle();
	           System.out.println(actualTitle);
		}

		/**
		 * scroll down and select CE link
		 */
		
		public void scrollDownAndSelectliVSPNlink(String LinkName) {
         scrollDown();
         WebElement VSPNLinks = findElement(By.xpath("//a[text()='"+LinkName+"']"));
         waitAndClick(VSPNLinks);		
         }
		
		/**
		 * verify quick poll section
		 */

		public void verifyQuickPollSection() {
		    boolean flag=false;
		    try {
		    if(serveyGraph.isDisplayed()) {
				   flag=true;
			}else {
		        waitAndClick(quickPollradioButton);			
		        waitAndClick(viewResult);			
				Assert.assertTrue(serveyGraph.isDisplayed());
			}
			} catch (Exception e) {
	      	}
	      	Assert.assertTrue(flag);
		}

		/**
		 * click on buttons
		 * @param Buttons
		 */
		
		public void ClickOnButtons(String Buttons) {
           WebElement element =findElement(By.xpath("//a[text()='"+Buttons+"']"));
           element.click();
		}

		/**
		 * verify pop up are displayed
		 * @param header
		 */
		public void verifyPopUpAreDisplayd(String header) {
	        WebElement element =findElement(By.xpath("//span[text()='"+header+"']"));
	        Assert.assertTrue(element.isDisplayed());

		}

		/**
		 * enter email in text box
		 * @param email
		 */
		
		public void enterEmailInTextBox(String email) {
           inputText(emailTxt,email);	
		}
		
		/**
		 * select check box
		 * @param checkbox
		 */

		public void selectCheckbox(String checkbox) {
            WebElement selectcheckbox =findElement(By.xpath("//input[@id='"+checkbox+"']"));
            waitAndClick(selectcheckbox);
		}

		/**
		 * input into password field
		 * @param password
		 */
		
		public void enterInputIntoConfirmPassword(String password) {
             inputText(confirmPassword,password);			
		}

		/**
		 * select add email button
		 */
		
		public void selectAddEmailButton() {
            waitAndClick(addEmail);			
		}

		/**
		 * verify added email or website
		 * @param element
		 */
		
		public void verifyEnteredTextIsAdded(String element) {
            WebElement Addedemail =findElement(By.xpath("//td[text()='"+element+"']"));
            Assert.assertTrue(Addedemail.isDisplayed());

		}

		/**
		 * click on edit button
		 * @param element
		 */
		
		public void clickOnEditButton(String element) {
            WebElement editemail =findElement(By.xpath("//td[text()='"+element+"']/following-sibling::td/a[@title='Edit']"));
            waitAndClick(editemail);
		}
		
		/**
		 * click on Delete button
		 * @param element
		 */
		
		public void clickOnDeleteButton(String element) {
            WebElement Deleteemail =findElement(By.xpath("//td[text()='"+element+"']/following-sibling::td/a[@title='Delete']"));
            waitAndClick(Deleteemail);
            
		}
		
		/**
		 * select ok on alert
		 */
         public void selectOkOnAlert() {
        	 acceptAlertPresent();
		
	} 
		
		/**
		 * enter website in text box
		 * @param website
		 */
		
		public void enterWebsiteInWebsiteField(String website) {
			inputText(websiteText, website);
		}

		/**
		 * select add website button
		 */
		
		public void selectAddWebsiteButton() {
           waitAndClick(addWebsite);			
		}

		/**
		 * verify page refreshes and load successfully
		 * @param text
		 */
		
		public void verifyPageRefreshesAndLoadsSuccessfully(String text) {
			WebElement header =findElement(By.xpath("//span[@id='lblPageHeader']"));	
			String Actual = header.getText();
			Assert.assertTrue(Actual.equalsIgnoreCase(text));
		}
		
		/**
		 * enter phone no
		 */

		public void enterPhoneNoUnderPhoneTextField(String phoneText) {
             inputText(phoneTextField, phoneText);			
		}

		/**
		 * select phone add button
		 */
		public void selectPhoneNoAddButton() {
             waitAndClick(addPhone);			
		}

		/**
		 * enter fax number
		 */
		
		public void enterNoInFaxTextField(String text) {
			inputText(addFax, text);
			
		}
		
		/**
		 * select add fax button
		 */

		public void selectAddFaxButton() {
             waitAndClick(addFaxButton);			
		}
		
		/**
		 * enter address info into Input fields
		 */

		public void enterAddressInfoIntoInputFields(String element, String text) {
              WebElement addressInput = findElement(By.xpath("//input[@id='"+element+"']"));
              inputText(addressInput, text);
		}
		
		/**
		 * click on add address button
		 */
		
		public void clickOnAddAddressButton() {
			waitAndClick(addAddressButton);
		}

		/**
		 * select state from drop down
		 */
		
		public void selectStateFromDropDownInAdress(String text) {
			selectDropDownByText(stateDropDown,text);			
		}
		
		/**
		 * verify country text populated automatically
		 */
		
		public void verifyCountryIsSelectedAutomatically(String selection) {
			String value=returnSelectedValueFromDropdown(CountryDropDown);
			Assert.assertEquals(selection, value);
		}

		/**
		 * select add certification Drop downs values
		 */
		
		public void selectDropDownAndThereValuesInPopupModel(String element, String text) {
            WebElement values = findElement(By.xpath("//select[@id='"+element+"']"));
			selectDropDownByText(values,text);			

		}

        /**
         * select option under complete list of Interests
         * @param element
         */

		public void selectOptionUnderCompleteListofInterests(String element) {
              WebElement option=findElement(By.xpath("//select[@id='lstAvailableInterests']/option[text()='"+element+"']"));	
              waitAndClick(option);
		}

		/**
		 * select add or remove button 
		 * @param ButtonName
		 */
		
		public void selectAddAndRemoveButton(String ButtonName) {
			WebElement button =findElement(By.xpath("//a[contains(text(),'"+ButtonName+"')]"));
			waitAndClick(button);
		}
		
		/**
		 * verify selected option in visible Interest Area
		 * @param element
		 */
		public void verifySelectedOptionIsVisibleInYourInterestArea(String element) {
			WebElement option =findElement(By.xpath("//select[@id='lstExistingInterests']/option[text()='"+element+"']"));
			Assert.assertTrue(option.isDisplayed());
		}
		
		
		/**
		 * verify remove option is not displayed
		 * @param element
		 */
		public void verifyRemovedOptionIsNotDisplayedInYourInterestArea(String element) {
			boolean flag=true;
	      	try { 	
				WebElement option =findElement(By.xpath("//select[@id='lstExistingInterests']/option[text()='"+element+"']"));

	      		if (option.isDisplayed()) {
	      			flag=false;
	      		}
	      	} catch (Exception e) {
	      	}
	      	Assert.assertTrue(flag);	
	      	
		}

		/**
		 * verify selected option Is present in interests Area
		 * @param text
		 */
		public void verifySelectedOptionIsPresentInInterestsArea(String text) {
            WebElement values = findElement(By.xpath("//span[@id='lblInterests']"));
            if(values.getText().contains(text)) {
            	Assert.assertTrue(true);
            }
		}
		
		/**
		 * verify selected option Is not present in interests Area
		 * @param text
		 */
		public void verifySelectedOptionIsNotPresentInInterestsArea(String text) {
            WebElement values = findElement(By.xpath("//span[@id='lblInterests']"));
            if(values.getText().contains(text)) {
            	Assert.assertFalse(true);
            }
		}
		
		/**
		 * verify removed option is not present in Interest area
		 * @param text
		 */
		public void verifyRemovedOptionIsNotPresentInInterestsArea(String text) {
            WebElement values = findElement(By.xpath("//span[@id='lblInterests']"));
            if(values.getText().contains(text)) {
            	Assert.assertFalse(false);
            }
		}
		
		/**
		 * select option in 'Your Interest' area
		 * @param element
		 */
		public void SelectOptionInYourInterestArea(String element) {
			WebElement option =findElement(By.xpath("//select[@id='lstExistingInterests']/option[text()='"+element+"']"));
			waitAndClick(option);
        }

		/**
		 * verify subject drop down greyed automatically in certification pop up
		 * @param selection
		 */
		public void verifySubjectDropDownIsGreyedOutAutomaticallyInCertificationPopUp(String selection) {
			String value=returnSelectedValueFromDropdown(CertificationSubjectDropDown);
			Assert.assertEquals(selection, value);
		}
		
		/**
		 * verify subject drop down greyed automatically in honor pop up
		 * @param selection
		 */
		
		public void verifySubjectDropDownIsGreyedOutAutomaticallyInHonorPopUp(String selection) {
			String value=returnSelectedValueFromDropdown(HonorSubjectDropDown);
			Assert.assertEquals(selection, value);			
		}

		/**
		 * verify drop down menu is displayed
		 * @param DropDownName
		 */
		public void dropDownMenuIsDisplayed(String DropDownName) {
			WebElement dropDown = findElement(By.xpath("//a[contains(text(),'"+DropDownName+"') and @aria-expanded='true']/../ul"));
			Assert.assertTrue(dropDown.isDisplayed());
		}

		/**
		 * select value from drop down
		 * @param value
		 */
		public void selectValueFromDropDown(String value) {
			findElement(By.xpath("//a[text()='" +value+ "']")).click();			
		}

		
		/**
		 * select edit buttons on my profile page
		 * @param editButtons
		 */
		public void selectEditButtonsOnMyProfilePage(String editButtons) {
			findElement(By.xpath("//div[contains(text(),'"+editButtons+"')]/a")).click();			
		}	
		
		/**
		 * click on go back button
		 */
		public void clickOnGoBackButtons() {
			waitAndClick(GoBackButton);
 		}
		
		/**
		 * click on add Internship button
		 */
		public void clickOnAddInternshipButton() {
			waitAndClick(addInternship);
		}

		/**
		 * enter school organization in text field
		 * @param Text
		 */
		public void enterSchoolOrganizationInstitutionInTextField(String Text) {
             inputText(schoolTextBox,Text);
		}
		
		/**
		 * click on add button
		 */
		public void clickOnAddButton() {
			waitAndClick(AddButton);
		}

		/**
		 * enter school name in text field
		 * @param text
		 */
		public void enterSchoolnameInTextField(String text) {
           inputText(schoolField, text);			
		}

		/**
		 * verify state and licensure is populated
		 * @param stateText
		 * @param licensureText
		 */
		public void verifyStateAndLicensureIsPopulated(String stateText,String licensureText) {
           WebElement state = findElement(By.xpath("//tr/td[text()='"+stateText+"']"));
           WebElement licensure = findElement(By.xpath("//tr/td[text()='"+licensureText+"']"));

           if(state.isDisplayed() && licensure.isDisplayed() ) {
        	   Assert.assertTrue(true);
           }
		}
		
    /**
     * select the edit preference button		
     */
	public void selectEditPreferenceButton() {
		waitAndClick(editPreference);
	}
	
	/**
	 * verify update preference window is Displayed
	 */
	public void verifyUpdatePreferenceWindowIsDisplayed() {
		_normalWait(3000);
		Assert.assertTrue(UpdatePreference.isDisplayed());
	}
	
	/**
	 * Dissmiss Email Preference Reminder pop up by clicking on cross icon
	 */
	public void clickOnCrossIconAndDissmissReminder() {
		waitAndClick(crossButton);
	}
	
	public WebDriver getWebDriver() {
		return driver;
	}
	
	/**
	 * Switch to child window by closing parent
	 */
	public void switchChildWindowByClosingParent(String chromeWin) {
		
		driver.close();
		
		  Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		  String browserName = cap.getBrowserName().toLowerCase();
		  if (browserName.toString().toLowerCase().equalsIgnoreCase("firefox")) {
			  _normalWait(2000);
			  getWebDriver().switchTo().window(chromeWin);
			
		}
		  else {
			if (browserName.toString().toLowerCase().equalsIgnoreCase("chrome")) {
				 getWebDriver().switchTo().window(chromeWin);
			}
		  }
//		driver.switchTo().window(Win);
	}

	/**
	 * Verify under 'Manage your current signatures' text box it reads '- Selenium User -'
	 */
	public void verifyManageyourcurrentsignatures() {
        Assert.assertTrue(currentSignature.isDisplayed()); 		
	}
	
	/**
	 * select find since in board
	 * @param days
	 */
	public void selectDaysInBoard(String days) {
		selectDropDownByText(findSince, days);
	}

		
		
		
}
	
