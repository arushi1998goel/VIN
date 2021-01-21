package com.vin.pages;


import com.vin.selenium.core.BasePage;
import com.vin.selenium.core.Configuration;
import com.vin.utilities.Constants;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PromoPage extends BasePage {
    String setEnvironment, applicationUrl;
    
     public PromoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='main-actionButtons']/a[text()='Login']")
    private WebElement loginButton;
    
    @FindBy(xpath = "//div[contains(@class,'drawer')]")
    private WebElement ADAdrawer;
    
    @FindBy(xpath = "//a[@id='forgotPW']")
    private WebElement forgotLink;
    
    @FindBy(xpath = "//input[@value='A-']")
    private WebElement zoomOut;
    
    @FindBy(xpath = "//input[@value='A+']")
    private WebElement zoomIn;
    
    @FindBy(xpath = "//button[text()='Reset Settings']")
    private WebElement resetButton;
    
    @FindBy(xpath ="//div[@class='help-text']")
    private WebElement helpButton;
    
    @FindBy(xpath ="//div/h1[text()='Chat with us']")
    private WebElement chatWithUs;
    
    @FindBy(xpath ="//input[@name='name']")
    private WebElement inputName;
    
    @FindBy(xpath ="//input[contains(@id,'2val')]")
    private WebElement inputEmail;
    
    @FindBy(xpath ="//textarea[contains(@id,'3val')]")
    private WebElement inputMessage;
    
    @FindBy(xpath ="//button[contains(@class,'sc-iRbamj sc')]")
    private WebElement minusButton;
    
    @FindBy(xpath="(//a[contains(text(),'Read article')])[2]")
    private WebElement readArticle;
    
    @FindBy(xpath="//input[@id='projectSearchText']")
    private WebElement anxietyTextBox;
    
    @FindBy(xpath="//input[@id='btnGo']")
    private WebElement goButton;
    
    @FindBy(xpath="//h2[@id='consultantBanner_FeaturedCard_nameItem']/a")
    private WebElement nameLink;
    
    @FindBy(xpath="//div[@class='col-xs-4 col-sm-4 col-md-4 accordion-toggle collapsed']//span[2]")
    private WebElement browseCategory;
    
    @FindBy(xpath="//p[@style='color:#6C6C6C; padding-bottom:20px;']//img[@alt='Find us on Facebook']")
    private WebElement faceBookButton;
    
    @FindBy(xpath="//p[@style='color:#6C6C6C; padding-bottom:20px;']//img[@alt='Twitter']")
    private WebElement tweetButton;
    
    @FindBy(xpath="//ul[@class='list-inline mb-0']//li[2]//a")
    private WebElement dogIcon;
    
    @FindBy(xpath="//button[@class='btn btn-search btn-default dropdown-toggle']")
    private WebElement allValue;

    @FindBy(xpath="//span[@id='spn10']")
    private WebElement dogsValue;
    
    @FindBy(xpath="//input[@id='projectSearchText']")
    private WebElement searchBox;
    
    @FindBy(xpath="//div[@id='TreeIndexDiv']//ul//li[2]//a[1]")
    private WebElement articleLink;
    
    @FindBy(xpath="//input[@type='button']")
    private WebElement goButtonAfterSearch;
    
    @FindBy(xpath="(//div[@class='leftBtns'])[2]//following-sibling::div[1]//a[1]")
    private WebElement secondArticleLink;
    
    @FindBy(xpath="(//img[@class='navbar-logo-img'])[2]")
    private WebElement veterinaryPartnerLogo;
    
    @FindBy(xpath="(//div[@class='wow fadeInLeft animated'])[2]")
    private WebElement catsUnderArticle;
    
    @FindBy(xpath="(//a[@title='Open link in new window'])[2]")
    private WebElement openLink;
    
    @FindBy(xpath="//div[@class='pull-right']//a[2]")
    private WebElement emailIcon;
    
    @FindBy(xpath="//strong[text()=' Email this public article from Veterinary Partner']")
    private WebElement emailLabel;	
    
    @FindBy(xpath="//section[@id='promoPageNavLinks']//li[@class='hasSubMenu']/a")
    private List<WebElement> dropDowns;

    @FindBy(xpath="//section[@id='promoPageNavLinks']//ul[@class='dropdown subMenu open']//a")
    private List<WebElement> dropDownOptions;
  	  
  	@FindBy(xpath="//a[@class='btn btn-primary' and text()='More Consultants']")
    private WebElement moreConsultantsBtn;
  	  
  	@FindBy(xpath="//div[@class='DocumentTitle' and contains(text(),'About VIN')]")
    private WebElement aboutVINSubtitle;
  	  
  	@FindBy(xpath="//div[contains(text(),'Free Trial/Membership')]")
    private WebElement membershipSubTitle;
  	  
  	@FindBy(xpath="//h2[text()='The Veterinary Support Personnel Network (VSPN™) is an interactive online community.']")
    private WebElement vspnsubTitle;
  	  
  	@FindBy(xpath="//section[@id='promoPageNavLinks']//a[text()='Friends of VIN']")
    private WebElement friendsonVINBtn;
  	  
  	@FindBy(xpath="(//ul[@class='promoPages']/li/a)[1]")
    private WebElement vspn;
  	  
  	@FindBy(id="txtFromName")
    private WebElement ContactNamefIELD;
        
    @FindBy(id="txtFromEmail")
    private WebElement ContactEmailfIELD;
        
    @FindBy(id="txtRegarding")
    private WebElement ContactSubjectfIELD;
        
    @FindBy(id="txtMessage")
    private WebElement ContactMessagefIELD;
        
    @FindBy(xpath="(//ul[@class='promoPages']/li/a)[2]")
    private WebElement vinstudents;
        
    @FindBy(xpath="//div[@id='siteMap']//li/a[text()='Students Home']")
    private WebElement vinStudentssubTitle;
  	  
  	@FindBy(xpath = "//a[contains(@class,'CEPortal')]")
    private WebElement portalButton;
        
    @FindBy(xpath = "//a[text()='Join']")
    private WebElement JoinButton;
        
    @FindBy(xpath = "//img[@id='VINLogo']")
    private WebElement VINLogo;
  	  
  	@FindBy(xpath = "//span[@class='icon icon-disabled']")
    private WebElement ADAButton;


    /**
     * Verify promo page displayed
     * @throws InterruptedException
     */
    public void verifyPromoPage() throws InterruptedException {
        waitForPageLoaded();
        _normalWait(1000);
        assertByPageTitle(Constants.pageTitle_PromoPage);

    }

    /**
     * click on login button
     *
     * @return
     */
    public LoginPage clickOnLoginButton() {
        waitForElement(loginButton);
        waitAndClick(loginButton);
        return PageFactory.initElements(driver, LoginPage.class);
    }


    /**
     * Verify promo page displayed
     *
     * @throws InterruptedException
     */
    public void verifyPromoPageForDrugDilutionPage() throws InterruptedException {
        waitForPageLoaded();
        _normalWait(1000);
        assertByPageTitle(Constants.pageTitle_DrugDilutionPromoPage);

    }

    /**
     * Verify login page displayed
     */
    public LoginPage verifyUserLoginPageForDrugDilution() {
        waitForPageLoaded();
        _normalWait(1000);
        assertByPageTitle(Constants.pageTitle_LoginPage);
        return PageFactory.initElements(driver, LoginPage.class);
    }

    /**
     * Verify login page displayed
     */
    public LoginPage verifyUserLoginPageForVinUsage() {
        waitForPageLoaded();
        _normalWait(1000);
        assertByPageTitle(Constants.pageTitle_LoginPage);
        return PageFactory.initElements(driver, LoginPage.class);
    }


    /**
     * Verify login page displayed
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> T verifyUserLoginPageDisplayed(final Class className) {
        waitForPageLoaded();
        _normalWait(1000);
        assertByPageTitle(Constants.pageTitle_LoginPage);
        return (T) PageFactory.initElements(driver, className);
    }


    @SuppressWarnings("unchecked")
    public <T> T verifyPromoPageForLogin(final Class className) {
        waitForPageLoaded();
        _normalWait(1000);
        assertByPageTitle(Constants.pageTitle_PromoPage);
        return (T) PageFactory.initElements(driver, className);
    }

    @SuppressWarnings("unchecked")
	public void clickOnNameLinkUnderFeaturedSection()
    {
    	waitForPageLoaded();
    	JavascriptExecutor jse=(JavascriptExecutor)driver;
    	jse.executeScript("arguments[0].scrollIntoView(true)", nameLink);
    	
    }

    public ContinualEducationPage navigateToMyCePage() throws Exception {

        //setEnvironment = Configuration.readApplicationFile("targetEnv");
        // NW 091019 - this will only handle command line params - to be improved.
        applicationUrl = System.getProperty("targetEnv") + Configuration.readApplicationFile("myCE");
        driver.navigate().to(applicationUrl);
        return PageFactory.initElements(driver, ContinualEducationPage.class);
    }
    
    public LoginPage navigateToBodySurfaceHappyPath() throws Exception {
    	applicationUrl = System.getProperty("targetEnv") + Configuration.readApplicationFile("BodySurface");
        driver.navigate().to(applicationUrl);
        return PageFactory.initElements(driver, LoginPage.class);
    }
    
    public LoginPage navigateToDoseCalculatorHappyPath() throws Exception {
    	applicationUrl = System.getProperty("targetEnv") + Configuration.readApplicationFile("DoseCalculator");
        driver.navigate().to(applicationUrl);
        return PageFactory.initElements(driver, LoginPage.class);
    }
    
    public LoginPage navigateToGlucosePlotterHappyPath() throws Exception {
    	applicationUrl = System.getProperty("targetEnv") + Configuration.readApplicationFile("glucoseCalculator");
        driver.navigate().to(applicationUrl);
        return PageFactory.initElements(driver, LoginPage.class);
    }
    
    public LoginPage navigateToEmergencyDrugCalculator() throws Exception {
    	applicationUrl = System.getProperty("targetEnv") + Configuration.readApplicationFile("emergencyDrugCalculator");
        driver.navigate().to(applicationUrl);
        return PageFactory.initElements(driver, LoginPage.class);
    }
    
    
    public LoginPage navigateToFeedTubeHappyPath() throws Exception {
    	applicationUrl = System.getProperty("targetEnv") + Configuration.readApplicationFile("feedingtube");
        driver.navigate().to(applicationUrl);
        return PageFactory.initElements(driver, LoginPage.class);
    }

	 public LoginPage navigateToMyColleagueSearch() throws Exception {
    	applicationUrl = System.getProperty("targetEnv") + Configuration.readApplicationFile("mycolleague");
        driver.navigate().to(applicationUrl);
        return PageFactory.initElements(driver, LoginPage.class);
    }

	public LoginPage navigateToPhelotomyVolumeCalculatorPage() throws Exception {
		applicationUrl = System.getProperty("targetEnv") + Configuration.readApplicationFile("phlebotomyVolume");
        driver.navigate().to(applicationUrl);
        return PageFactory.initElements(driver, LoginPage.class);		
	}

	public StudentLoanSimPage navigateToStudentLoanSimulator() throws Exception {
		
		applicationUrl = System.getProperty("targetEnv") + Configuration.readApplicationFile("studentloansim");
        driver.navigate().to(applicationUrl);
        return PageFactory.initElements(driver, StudentLoanSimPage.class);	
	}

   public LoginPage navigateToBromideCalculatorKBrHappyPath() throws Exception {
		
		applicationUrl = System.getProperty("targetEnv") + Configuration.readApplicationFile("bromideCalculatorKBrHappyPath");
        driver.navigate().to(applicationUrl);
        return PageFactory.initElements(driver, LoginPage.class);	
	}
   public LoginPage FleaandTickProductFinderHappyPath() throws Exception {
	   	applicationUrl = System.getProperty("targetEnv") + Configuration.readApplicationFile("FleaandTickProductFinder");
	       driver.navigate().to(applicationUrl);
	       return PageFactory.initElements(driver, LoginPage.class);
	   }
   public LoginPage navigateToCalorieDistributionCalculatorPath() throws Exception {
	   applicationUrl = System.getProperty("targetEnv") + Configuration.readApplicationFile("CalorieDistributionCalculator");
	   driver.navigate().to(applicationUrl);
       return PageFactory.initElements(driver, LoginPage.class);	
   }
   public LoginPage navigateToEnergyRequirementsHappyPath() throws Exception {
	   	applicationUrl = System.getProperty("targetEnv") + Configuration.readApplicationFile("EnergyRequirements");
	       driver.navigate().to(applicationUrl);
	       return PageFactory.initElements(driver, LoginPage.class);
	   }
  public LoginPage FreeWaterDeficitHappyPath() throws Exception {
	   	applicationUrl = System.getProperty("targetEnv") + Configuration.readApplicationFile("FreeWaterDeficitcalculator");
	       driver.navigate().to(applicationUrl);
	       return PageFactory.initElements(driver, LoginPage.class);
	   }
  public LoginPage GestationCalculatorHappyPath() throws Exception {
	   	applicationUrl = System.getProperty("targetEnv") + Configuration.readApplicationFile("GestationCalculator");
	       driver.navigate().to(applicationUrl);
	       return PageFactory.initElements(driver, LoginPage.class);
	   }
  public LoginPage FluidTherapyHappyPath() throws Exception {
	   	applicationUrl = System.getProperty("targetEnv") + Configuration.readApplicationFile("FluidTherapy");
	       driver.navigate().to(applicationUrl);
	       return PageFactory.initElements(driver, LoginPage.class);
	   }
  public LoginPage RodenticideHappyPath() throws Exception {
	   	applicationUrl = System.getProperty("targetEnv") + Configuration.readApplicationFile("Rodenticide");
	       driver.navigate().to(applicationUrl);
	       return PageFactory.initElements(driver, LoginPage.class);
	   }
  public LoginPage TopicalTherapyHappyPath() throws Exception {
	   	applicationUrl = System.getProperty("targetEnv") + Configuration.readApplicationFile("TopicalTherapy");
	       driver.navigate().to(applicationUrl);
	       return PageFactory.initElements(driver, LoginPage.class);
	   }
  public LoginPage navigateToPremedicationDrugHappyPath() throws Exception {
	   	applicationUrl = System.getProperty("targetEnv") + Configuration.readApplicationFile("PremedicationDrug");
	       driver.navigate().to(applicationUrl);
	       return PageFactory.initElements(driver, LoginPage.class);
	   }
  public LoginPage navigateToNSAIDHappyPath() throws Exception {
		applicationUrl = System.getProperty("targetEnv") + Configuration.readApplicationFile("NSAIDPath");
		   driver.navigate().to(applicationUrl);
		   return PageFactory.initElements(driver, LoginPage.class);
		   }
  public LoginPage navigateToHeartwormHappyPath() throws Exception {
	   	applicationUrl = System.getProperty("targetEnv") + Configuration.readApplicationFile("HeartWorm");
	       driver.navigate().to(applicationUrl);
	       return PageFactory.initElements(driver, LoginPage.class);
	   }

  public LoginPage NavigateToEchocardiogramHappyPath() throws Exception {
	   	applicationUrl = System.getProperty("targetEnv") + Configuration.readApplicationFile("Echocardiogram");
	       driver.navigate().to(applicationUrl);
	       return PageFactory.initElements(driver, LoginPage.class);
	       
	   }
  public LoginPage NavigateToMeanElectricalAxisHappyPath() throws Exception {
	   	applicationUrl = System.getProperty("targetEnv") + Configuration.readApplicationFile("MeanElectricalAxis");
	       driver.navigate().to(applicationUrl);
	       return PageFactory.initElements(driver, LoginPage.class);
	       
	   }
  /**
   * navigate to given URL
   * @param <T>
   * @param className
   * @param givenURL
   * @return
   */
  
  public <T> T navigateToGivenURL(final Class className,String givenURL) {
    	waitForPageLoaded();
	   getDriver().navigate().to(givenURL);
   return (T) PageFactory.initElements(driver, className);

  }

   /**
    * Navigate to URL
    * @param vetzinsighturl
    */
    public void navigateToUrl(String url) {

    	getDriver().navigate().to(url);
	
     }
    /**
     * Click on read article
     */
  public void clickOnReadArticle() {

	  waitAndClick(getDriver().findElement(By.xpath("//div[@id='paginate-slider1']//a[text()='2']")));
	  waitAndClick(readArticle);
	  
}
  /**
   * Enter anxiety in vetzinsight textbox
   * @param anxietytext
   */
  public void enterAnxietyInSearchBox(String anxietytext) {

  	inputText(anxietyTextBox, anxietytext);

  	
  }
  /**
   * Select the go button
   */
  public void selecttheGoButton() {

  	waitAndClick(goButton);

  	
  }

  /**
   * Select Tweet button
   *
   */
    public void selectTweetButton() {

  	  waitAndClick(tweetButton);
  }

    /**
     * Select Facebook button
     */
  public void selectFaceBookButton() {
  	waitAndClick(faceBookButton);
  }

  /**
   * Navigate to veterinary URL
   * @param veterinaryurl
   */
    public void navigateToVeterinaryHappyPath(String veterinaryurl) {
  	  getDriver().navigate().to(veterinaryurl);
  	
  }

    
  public void selectBrowseCategoryButton() {
  	waitAndClick(browseCategory);
  }

   /**
   * Select the dog icon
   */
    public void selectTheDogIcon() {
  	waitAndClick(dogIcon);
  }

  /**
   * Select an article
   */
  public void selectAnArticleRightPane() {
  	waitAndClick(articleLink);
  }

  /**
   * Type pit bull in searchbox
   * @param pitbulltext
   */
  public void typePitBullInSearchBar(String pitbulltext) {
  	inputText(searchBox, pitbulltext);
  }

  /**
   * Select the all dropdown and select dogs
   */
  public void selectTheAllDropdownAndSelectDogs() {
  	waitAndClick(allValue);
  	_normalWait(2000);
  	waitAndClick(dogsValue);
  	
  }

  /**
   * Select the go button after search box
   */
  public void selecttheGoButtonAfterSearchBox() {
  	waitAndClick(goButtonAfterSearch);
  }

  /**
   * Select the second article link from result page
   */
  public void selectTheSecondArticleLinkFromrResultPage() {
  	waitAndClick(secondArticleLink);
  }

  /**
   * Select the veterinary partner logo
   */
  public void selectTheVeterinaryPartnerLogo() {
  	waitAndClick(veterinaryPartnerLogo);
  }

  /**
   * Click on cats under article by species section
   */
  public void clickOnCatsUnderArticleBySpeciesSection() {
  	waitAndClick(catsUnderArticle);
  }

  /**
   * Click on an icon to open an article
   */
  public void clickOnAnIconToOpenAnArticle() {

  	waitAndClick(openLink);
  }

  /**
   * select the email icon
   */
  public void selectEmailIcon() {
  	waitAndClick(emailIcon);
  }

  /**
   * Verify email popup
   */
  public void verifyEmailPopup() {
  	if(emailLabel.isDisplayed()) {
  		Assert.assertTrue(true);
  	}
  }


  public void selectDropDown(String TabName){
  	for(WebElement web:dropDowns )
  	{
  		if (web.getText().trim().contains(TabName)) {
  			JavascriptExecutor js =(JavascriptExecutor)driver;
  			js.executeScript("arguments[0].scrollIntoView(true)", web);
  			Actions act=new Actions(driver);
  			act.moveToElement(web).perform();
  			break;
  		}
  	}
  }


      @SuppressWarnings("unchecked")
      public <T> T selectOption(String optionName,final Class className) {
	      for(WebElement opt: dropDownOptions)
	       {
		    if (opt.getText().trim().contains(optionName)) {
			WebDriverWait wait=new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.elementToBeClickable(opt));
			javascriptButtonClick(opt);
			break;
		}
	   }
	     return (T) PageFactory.initElements(driver, className);
       }
      
      public void clickOnMoreConsultants(){
    	  waitForPageLoaded();
    	  JavascriptExecutor js =(JavascriptExecutor)driver;
		  js.executeScript("arguments[0].scrollIntoView(true)", nameLink);
    	  clickOn(moreConsultantsBtn);
    	
      }
      
      public void SelectAboutVinOption(){
    	  WebElement elementtobeclicked = driver.findElement(ByLocator("//ul[@class='dropdown subMenu open']//a[text()='About VIN']"));
    	  javascriptButtonClick(elementtobeclicked);
      }
       
      public void verifyAboutVINSubTitleDisplayed(){
    	  waitForPageLoaded();
    	  Assert.assertTrue(isElementDisplayed(aboutVINSubtitle));
      }
       
      public void verifyMemBershipSubtitle(){
    	  waitForPageLoaded();
    	  Assert.assertTrue(isElementDisplayed(membershipSubTitle));
      }
       
      public void verifyWhyVinSubtitle(String expectedTitle){
    	  waitForPageLoaded();
    	  String actualTitle = driver.getTitle();
    	  boolean flag=true;
    	 if (actualTitle.trim().equalsIgnoreCase(expectedTitle)) {
			flag=true;
		}
    	 Assert.assertTrue(flag);
      }
       
      public void verifyVSPnSubtitle(String expectedTitle){
        	  waitForPageLoaded();
        	  String actualTitle = driver.getTitle();
        	  boolean flag=true;
        	 if (actualTitle.trim().equalsIgnoreCase(expectedTitle)) {
    			flag=true;
    		}
        	 Assert.assertTrue(flag);
          }

      public <T> T selectFriendsOfVin(final Class className){
    	  clickOn(friendsonVINBtn);
		return (T) PageFactory.initElements(driver, className);
      }
      
      public void selectVspn(){
        waitAndClick(vspn);
      }
      
      public void selectVInStudents(){
    	  waitForPageLoaded();
    	  clickOn(vinstudents);
      }
      
      public void verifyVINStudentsSubtitle(){
    	  waitForPageLoaded();
    	  Assert.assertTrue(isElementDisplayed(vinStudentssubTitle));
      }
  
      public void EnterContactInformation(String Name,String Email,String Subject,String Message){
    	  inputText(ContactNamefIELD, Name);
    	  inputText(ContactEmailfIELD, Email);
    	  inputText(ContactSubjectfIELD, Subject);
    	  inputText(ContactMessagefIELD, Message);

      }
    
      /**
       * click on Join Button
       */
      public void clickONJoinButton() {
      	waitAndClick(JoinButton);
      }

      /**
       * click on CE Portal button
       */
      public void clickONCEPortalButton() {
      	waitAndClick(portalButton);
      }


      /**
       * Click on VIN logo
       */
      public void clickONVINLogo() {
      	waitAndClick(VINLogo);
      }


      /**
       * click on ADA button
       */
      public void clickONADAButton()  {
      	waitAndClick(ADAButton);
      }


      /**
       * verify ADA Drawer Displayed
       */
      public void verifyADADrawerDisplayed() {
      	Assert.assertTrue(ADAdrawer.isDisplayed());
      }

      /**
       * verify ADA Drawer is not displayed
       */
      public void verifyADADrawerIsNotDisplayed(String DrawerStyle) {
      	_normalWait(3000);
      	boolean flag = false;
      	if (ADAdrawer.getCssValue("right").contains(DrawerStyle)) {
      		flag = true;
      	}
      	Assert.assertTrue(flag);
      }


      /**
       * Click on forgot password link
       */
      public void clickONForgotPasswordLink() {
      	waitAndClick(forgotLink);
      }

      public void verifyPageTitle(String PageName) {
      	Assert.assertTrue(driver.getTitle().equalsIgnoreCase(PageName));

      }

      /**
       * selecy A-
       */  
      public void selectZoomInButton() {
      	waitAndClick(zoomOut);
      }

      /**
       * select A+
       */
      public void selectZoomOutButton() {
      	javascriptButtonClick(zoomIn);

      }

      /**
      * click on ADA Buttons
      */
      public void selectADAButtons(String ADAButtons ) {
      	waitAndClick(getDriver().findElement(By.xpath("//button[text()='" + ADAButtons + "']")));

      }

      /**
       * click on reset setting 
       */
      public void clickOnResetSetting() {
      	javascriptButtonClick(resetButton);

      }
      
        /**
         * verify changes of the pages
        */
      public void verifyChangeOfThePage(String changes) {
      		
      	WebElement fontchange = driver.findElement(ByLocator("//body[contains(@class,'"+changes+"')]"));

      	boolean flag=true;
      	try {
      		if (fontchange.isDisplayed()) {
      			flag=true;
      		}
      	} catch (Exception e) {
      	}
      	Assert.assertTrue(flag);
      }

      /**
       * verify Page changes are not longer displayed
       */
      public void verifyChangesAreNotDisplayed(String changes)
      {
      	boolean flag=true;
      	try { 	
      		WebElement greyscale = driver.findElement(ByLocator("//body[contains(@class,'"+changes+"')]"));

      		if (greyscale.isDisplayed()) {
      			flag=false;
      		}
      	} catch (Exception e) {
      	}
      	Assert.assertTrue(flag);
      }

      /**
       * select help button
       */
      public void selectHelpButton() {
     	   waitAndClick(helpButton);
     	   
     	   _normalWait(3000);
        }
        
        
        /**
         * enter name
         */
      public void verifyChatWithUsWindow() { 
     	  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='webWidget']")));	
     	   if(chatWithUs.isDisplayed()) {   
     	   inputText(inputName, "Selenium");
     	   inputText(inputEmail, "selenium@vin.com");
     	   inputText(inputMessage, "This is a Test");
     	   waitAndClick(minusButton);
        }
     	   else {
       	   waitAndClick(minusButton);
        }
        }
        
        
         

         

}
	



