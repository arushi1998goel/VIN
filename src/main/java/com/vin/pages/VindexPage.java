package com.vin.pages;

import com.vin.selenium.core.BasePage;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class VindexPage extends BasePage {
	
	public VindexPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "li[id='tab-links']")
	private WebElement vindexTab;

	@FindBy(xpath = "//div[@class='DocumentMainContent']//tr[2]//a")
	private WebElement medicalFaqLink;

	@FindBy(xpath = "//div[@class='DocumentMainContent']//tr[3]//a")
	private WebElement drugResourceLink;

	@FindBy(xpath = "//div[@class='DocumentMainContent']//tr//td/a")
	private List<WebElement> linksPresentInVindexTab;

	@FindBy(css = "input[id='showAgain']")
	private WebElement closeDisclaimer;

	@FindBy(css = "iframe[name='ifMyVINFramedContent']")
	private WebElement iframe;

	@FindBy(css = "input[id= 'btnNavCalculators']")
	private WebElement calculator;
	
	@FindBy(xpath="//span[text()='Contact Us']")
	private WebElement contactUs;
	
	@FindBy(xpath="//ul[contains(@class,'medium-txt')]/li//input")
	private WebElement filterResource;
	
	@FindBy(xpath="(//img[@title='eVetSites'])[1]")
	private WebElement eVetSites ;
	
	@FindBy(xpath="//h3[contains(text(),'VIN 101')]")
	private WebElement helpVinID ;
	
	@FindBy(xpath="//h2[contains(text(),'VIN Journals')]")
	private WebElement vinJournals;
	
	@FindBy(xpath="//div/h2[text()='Legal Specialty Center']")
	private WebElement legalSpecialityCentre;
	
	@FindBy(xpath="//a[text()='Message Boards']")
	private WebElement messageBoards;
	
	@FindBy(xpath="//h1[contains(text(),'Visual Procedures Manual')]")
	private WebElement visualProceduresManual;
	
	@FindBy(xpath="//td[text()='My most viewed discussions']")
	private WebElement activitiesMyMostViewedTab;
	
	@FindBy(xpath="//a[@id='lnkStuffMain']")
	private WebElement mysTuffPage;
	
	@FindBy(xpath="(//ul[contains(@class,'medium-txt')]/li/following-sibling::ul//input)[3]")
	private WebElement webCastFilter;
	
	@FindBy(xpath="//h1[contains(text(),'The VIN Library')]")
	private WebElement vinLibraryPage;
	
	@FindBy(xpath="//div[@id='seriesGraphicContainer']/img")
	private WebElement resourceImg;

	@FindBy(xpath="//li[@id='tab-favorites' and @class='active']")
	private WebElement favoriteTab;

	@FindBy(xpath = "//button[text()='Dismiss All']")
    private WebElement dismissAllBtn;
	
	
	
	
	
	/**
	 * Verify VINDEX window is displayed
	 */

	public void verifyVindexWindowDisplayed(String Title) {
		_normalWait(4000);
		Assert.assertTrue(driver.getTitle().contains(Title));

		driver.manage().window().maximize();
	}
	
	public WebDriver getWebDriver() {
		return driver;
	}

	/**
	 * Click on Vindex tab
	 */

	public void clickOnVindex() {
		waitAndClick(vindexTab);
	}

	/**
	 * Select 'Medical FAQs' link
	 */

	public void clickOnLInksPresentInTheVindexTab(String Title) {
		_normalWait(2000);
		
		for (WebElement we : linksPresentInVindexTab) {
			if (Title.trim().toLowerCase().contains(we.getText().trim().toLowerCase())) {
			if (Title.trim().toLowerCase().equalsIgnoreCase(we.getText().trim().toLowerCase())) {
				 Actions shiftClick = new Actions(driver);
				  shiftClick.keyDown(Keys.SHIFT).click(we).keyUp(Keys.SHIFT).perform();
				break;

			}
			}
		}
	}

	/**
	 * Verify Medical FAQs page is loaded
	 */
	public void verifyMedicalFaqWindowDisplayed(String Title) {
		waitForPageLoaded();
		_normalWait(1000);
		Assert.assertTrue(driver.getTitle().contains(Title));

	}

	/**
	 * verify page displayed after click on links present in Vindex Tab
	 */
	public void verifyPageDisplayed(String Title) {
	waitForPageLoaded();
	_normalWait(3000);
	Assert.assertTrue(driver.getTitle().contains(Title));
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
	 * Verify calculator page is opened
	 */

	public void verifyCalculatorPage() {
		boolean flag = false;
		waitForPageLoaded();
//		switchToFrame(iframe);
		driver.switchTo().frame(iframe);

		_normalWait(3000);
		waitAndClick(closeDisclaimer);

		if (calculator.isEnabled()) {
			flag = true;
			Assert.assertTrue(flag);
			switchToDefaultContent();
		}

	}
	
	/** 
	 * Verify Contact Us Page is displayed
	 */
	public void verifyContactUsPageISDisplayed() {
		_normalWait(1000);
		Assert.assertTrue(isElementDisplayed(contactUs));
		
	}
	
	/** 
	 * Verify Drug Resource Filter  is Selected
	 */
	public void verifyDrugResourceFilterIsSelected() {
		boolean flag=false;
		if (filterResource.isSelected()) {
			flag =true;
			
		}
		Assert.assertTrue(flag);
		
	}
	
	/** 
	 * Verify evetSite Page is displayed
	 */
	public void verifyEvetSitePageDisplayed() {
		_normalWait(2000);
		Assert.assertTrue(eVetSites.isDisplayed());
	}
	
	/**
	 * verify help centre id Displayed
	 */
	
	public void verifyHelpVinCentreIdDisplayed() {
		Assert.assertTrue(isElementDisplayed(helpVinID));
	}
	
	/**
	 *verify Vin Journals Page is displayed
	 */
	public void verifyVinJournalsPageISDisplayed() {
		_normalWait(1000);
		Assert.assertTrue(getDriver().getTitle().contains("Journals - VIN"));
		
	}
	
	/**
	 *verify legal Speciality centre is displayed
	 */
	public void verifyLegalSpecialityCentre() {
		_normalWait(1000);
		Assert.assertTrue(isElementDisplayed(legalSpecialityCentre));
		
	}
	
	/**
	 *verify Message board is displayed
	 */
	public void verifyMessageBoardIsDisplayed() {
		_normalWait(1000);
		Assert.assertTrue(isElementDisplayed(messageBoards));
		
	}
	
	/**
	 *verify Message board is displayed
	 */
	
	public void verifyVinMentorVisualProcedureManualIsDisplayed() {
		_normalWait(1000);
		Assert.assertTrue(isElementDisplayed(visualProceduresManual));
		
	}
	
	/**
	 * verify Activities My Most view tab is displayed
	 */
	public void verifyMyMostViewActivitiesIsDislpayed(String Title) {
		
		_normalWait(3000);
		waitForPageLoaded();
		Assert.assertTrue(driver.getTitle().trim().toLowerCase().contains(Title.trim().toLowerCase()));

	}
	
	/**
	 *verify My Stuff Page is displayed
	 */
	public void verifyMyStuffPageIsDisplayed() {
		_normalWait(1000);
		Assert.assertTrue(isElementDisplayed(mysTuffPage));
		
	}
	
	/** 
	 * Verify Drug Resource Filter  is Selected
	 */
	
	public void verifyVinRoundsFilterIsSelected() {
		boolean flag=false;
		if (filterResource.isSelected()) {
			flag =true;
			
		}
		Assert.assertTrue(flag);
		
	}
	
	/** 
	 * Verify WebCast Filter  is Selected
	 */
	public void verifyWebCastFilterIsSelected() {
		boolean flag=false;
		if (webCastFilter.isSelected()) {
			flag =true;
			
		}
		Assert.assertTrue(flag);
		
	}
	
	/***
	 * Verify the VIN Library page is Displaye
	 */
	public void verifyVinLibraryPageDislplayed() {
		_normalWait(1000);
		Assert.assertTrue(isElementDisplayed(vinLibraryPage));
	}
	
	/***
	 * Verify the WWW Resources page is Displayed
	 */
	public void verifyResourcePageDislplayed() {
		_normalWait(1000);
		Assert.assertTrue(isElementDisplayed(resourceImg));
	}

	
	/**
	 * Click on Associate Link
	 */
	public void clickOnAssociateLink(String Title) {
        _normalWait(2000);
		
		for (WebElement we : linksPresentInVindexTab) {
			if (we.getText().trim().toLowerCase().contains(Title.trim().toLowerCase())) {
				 Actions shiftClick = new Actions(driver);
				  shiftClick.keyDown(Keys.SHIFT).click(we).keyUp(Keys.SHIFT).perform();
				break;

			}
		}
		
	}

	public void verifyFavoriteTabIsByDefault() {
          Assert.assertTrue(favoriteTab.isDisplayed());		
	}
	
	/**
     * Dismiss alert notification if displayed
     * @return
     */
    public void dismissNotifications() {
		super.dismissNotifications(dismissAllBtn);
    }


}
