package com.vin.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vin.selenium.core.BasePage;
import com.vin.utilities.Constants;

import org.testng.Assert;

public class PresenterFourMenu extends BasePage{

	public PresenterFourMenu(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[text()='Demo for p4']")
	private WebElement DemoForP4;
	
	@FindBy(xpath="//span[@class='navbar-toggler-icon']")
	private WebElement menu;
	
	@FindBy(xpath="//div[@class='dropdown-menu show']")
	private WebElement selectedMenu;
	
	@FindBy(xpath="//span[text()='Go to thread']")
	private WebElement gotoThread;

	@FindBy(xpath="//a[@ng-show='fullscreenActive' and @class='dropdown-item']")
	private WebElement fullScreen;
	
	@FindBy(xpath="//a[@ng-show='!fullscreenActive' and @class='dropdown-item']")
	private WebElement exitScreen;
	
	@FindBy(xpath="//div/h3[text()='Presenter Help']")
	private WebElement helpModel;

	@FindBy(xpath="//div/h4[text()='Icons']")
	private WebElement Icons;
	
	@FindBy(xpath="//div[@class='collapse show']")
	private WebElement IconsMenu;
	
	@FindBy(xpath="//a[@class='card-link collapsed']")
	private WebElement Iconcollapsed;
	
	@FindBy(xpath="//div/h4[text()='Menu Items']")
	private WebElement MenuItems;
	
	@FindBy(xpath="//button[text()='×']")
	private WebElement crossButton;
	
	@FindBy(xpath="//nav//button[@id='p4autobutton']")
	private WebElement autoButton;
	
	@FindBy(xpath = "//button[text()='Dismiss All']")
	private WebElement dismissAllBtn;





	
	/**
	 * verify demo for P4 page is  displayed
	 */
	public void verifyDemoForP4ScreenDisplayed() {
       Assert.assertTrue(DemoForP4.isDisplayed());  
    }
	
	 /**
     * Dismiss alert notification if displayed
     * @return
     */
    public void dismissNotifications() {
		super.dismissNotifications(dismissAllBtn);
    }
	
	/**
	 * select Menu
	 */
	public void selectMenu() {
		waitAndClick(menu);
	}
	
	/**
	 * verify menu can be selected by user
	 */
	public void verifyMenuCanBeSelectedByUser() {
		Assert.assertTrue(selectedMenu.isDisplayed());
	}
	
	/**
	 * select menu items 
	 */
	public void selectMenuItems(String menuitems) {
		WebElement menu = driver.findElement(By.xpath("//a[contains(text(),'"+menuitems+"')]"));
		waitAndClick(menu);

	}
	
	/**
	 * select go to thread
	 */
	public void selectGotoThread() {
		waitAndClick(gotoThread);
	}
	
	/**
	 * verify full screen is displayed
	 */
	public void verifyFullScreenIsDisplayed() {
		WebElement fullScreen = driver.findElement(ByLocator("//a[@ng-show='fullscreenActive' and @class='dropdown-item']"));

	      	boolean flag=true;
	      	try {
	      		if (fullScreen.isDisplayed()) {
	      			flag=true;
	      		}
	      	} catch (Exception e) {
	      	}
	      	Assert.assertTrue(flag);
	      }
	
	
	/**
	 * verify user is able to exit full screen
	 */
	public void verifyExitToFullscreen() {
		
		WebElement exitScreen = driver.findElement(ByLocator("//a[@ng-show='!fullscreenActive' and @class='dropdown-item']"));

      	boolean flag=true;
      	try {
      		if (exitScreen.isDisplayed()) {
      			flag=true;
      		}
      	} catch (Exception e) {
      	}
      	Assert.assertTrue(flag);
      }
	
	/**
	 * select icons in help model
	 */
	public void selectIconsInHelpModels() {
		waitAndClick(Icons);
	}
	
	/**
	 * verify help model is displayed
	 */
	public void verifyHelpModelIsDisplayed() {
		_normalWait(3000);
		Assert.assertTrue(helpModel.isDisplayed());
	}
	
	/**
	 * verify help model is not displayed
	 */
	public void verifyHelpModelIsNotDisplayed() {
		_normalWait(3000);
		Assert.assertFalse(helpModel.isDisplayed());
	}
	
	/**
	 * verify icons menu expends
	 */
	public void verifyMenuIsExpended() {
		Assert.assertTrue(IconsMenu.isDisplayed());
	}
	
	/**
	 * verify icons menu is collapses
	 */
	public void verifyMenuIsCollapses() {
		Assert.assertTrue(Iconcollapsed.isDisplayed());
	}
	
	/**
	 * select menu items
	 */
	public void selectMenuItems() {
		_normalWait(3000);
		waitAndClick(MenuItems);
	}
	
	/**
	 * click on crose icon
	 */
	public void clickOnCrossIcon() {
		waitAndClick(crossButton);
	}
	
	/**
	 * verify auto button shows up
	 */
	public void verifyAutoButonIsShowsUp() {
		Assert.assertTrue(autoButton.isDisplayed());
	}
	
	/**
	 * verify auto button removed
	 */
	public void verifyAutoButonIsRemoved() {
		//Assert.assertFalse(autoButton.isDisplayed());
		boolean flag=true;
      	try { 	
      		WebElement greyscale = driver.findElement(ByLocator("//nav//button[@id='p4autobutton']"));

      		if (greyscale.isDisplayed()) {
      			flag=false;
      		}
      	} catch (Exception e) {
      	}
      	Assert.assertTrue(flag);
	}
	
	 /**
     * Verify Front Page displayed
     */
    public void verifyPageDisplayed(String pageTitle) {
        waitForPageLoaded();
        _normalWait(2000);
        assertByPageTitle(pageTitle);
    }
    
}


    