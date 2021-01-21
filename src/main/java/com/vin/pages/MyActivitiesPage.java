package com.vin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.vin.selenium.core.BasePage;
import com.vin.utilities.Constants;

public class MyActivitiesPage extends BasePage{
	
	public MyActivitiesPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div/h1[text()='MyActivities - ']")
	private WebElement MyActivitiesHeader;

	@FindBy(xpath="//input[@id='btnFilterDate']")
	private WebElement goButton;
	
	@FindBy(xpath="//button[@id='btnBackToBoards']")
	private WebElement boardButton;
	
	@FindBy(xpath="//button[@id='btnSearch']")
	private WebElement searchButton;
	
    @FindBy(css = "div[id='menu'] div[id='topNav'] a[id='loginmenu']")
	private WebElement loginUserDropDown;

	@FindBy(css = "div[id='menu'] div[id='topNav'] ul[role='menu'] a[class='MemberProfile_Logout']")
	private WebElement logoutLinkUnderUserDropDown;
	

	
	
	
	/**
	 * verify my activity page load successfully
	 */
	public  void verifyMyActivityPageSuccessfullyDisplayedInNewWindow()
	{
		getDriver().navigate().refresh();
		Assert.assertTrue(MyActivitiesHeader.isDisplayed());
		
	}
	
	/**
	 * verify discussion Viewed tab selected by default
	 */
	public void verifyDiscussionViewedTabSelectedByDefault() {
		
			boolean flag=true;
			try { 	
				WebElement DiscussionViewedTab = driver.findElement(ByLocator("//a[text()='Discussion Viewed']"));

				if (DiscussionViewedTab.isDisplayed()) {
					flag=false;
				}
			} catch (Exception e) {
			}
			Assert.assertTrue(flag);
		
	}
	
	/**
	 * select and enter date
	 * @param Date
	 * @param dateInput
	 */
	public void selectAndEnterDate(String Date,String dateInput) {
		WebElement dateField=findElement(By.xpath("//input[contains(@name,'"+Date+"')]"));
		waitAndClick(dateField);
		inputText(dateField, dateInput);
	}
	
	/**
	 * select go button
	 */
	public void selectGoButton() {
		waitAndClick(goButton);
		}
	
	/**
	 * select tabs
	 * @param tabNumber
	 */
	public void selectTabs(String tabNumber ) {
		_normalWait(3000);
		WebElement tab=findElement(By.xpath("//td[contains(@onclick,'"+tabNumber+"')]"));
		waitAndClick(tab);
		
	}
	
	public void selectFirstLinkUnderTitleColumn(String id) {
		WebElement titleLinks=findElement(By.xpath("//tr[@id='"+id+"']/td[3]"));
		waitAndClick(titleLinks);
	}

	/**
	 * select a linkunder titlecolumn
	 * @param titleLink
	 */
	public void selectALinkUnderTitleColumn(String titleLink) {
		WebElement link=findElement(By.xpath("//tr[1]/td/a[text()='"+titleLink+"']"));
		_normalWait(3000);
		waitAndClick(link);
		
	}
	
	/**
	 * verify message board page is displayed
	 */
	public void verifyNewTabDorMessageBoardsOpened() {
       Assert.assertTrue(boardButton.isDisplayed());		
	}
	
	public void verifyNewTabDorMessageSearchBoardsOpened() {
	       Assert.assertTrue(searchButton.isDisplayed());		
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
	 * Verify Logout Page displayed
	 */
	public void verifyLogoutPageDisplayed() {
		waitForPageLoaded();
		_normalWait(1000);
		assertByPageTitle(Constants.pageTitle_LoggedoutPage);
	}

	/**
	 * verify page load successfully
	 * @param columnType
	 */
	public void verifyThePageLoadsSuccessfully(String columnType) {
		WebElement element=findElement(By.xpath("//a[text()='"+columnType+"']"));
       Assert.assertTrue(element.isDisplayed());		
	}

	
	
	
}
