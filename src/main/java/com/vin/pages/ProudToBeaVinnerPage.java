package com.vin.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.vin.selenium.core.BasePage;


public class ProudToBeaVinnerPage extends BasePage {

	public ProudToBeaVinnerPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//div[@class='DocumentTitle' and contains(text(),'Proud to be a VINner!')]")
	private WebElement proudtovevinnerSubtitle;
	
	@FindBy(xpath="//strong[text()='Pre-printed Veterinary Partner referral cards.']/../a[text()='VIN Bookstore']")
	private WebElement vinBookStorelink;
	
	@FindBy(xpath="//div[@id='logo']//img[@alt='VIN Bookstore']/..")
	private WebElement SubTitleBookStore;
	
	@FindBy(xpath="//a[text()='Community Store']")
	private WebElement communityStoreLink;
	
	public void verifyCommintyStorePage(String expectedTitle)
	{
		waitForPageLoaded();
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	public void verifyProudToBeViNerSubTitle()
	{
		
		waitForPageLoaded();
		Assert.assertTrue(isElementDisplayed(proudtovevinnerSubtitle));
	}
	
	public void selectVinBookSoreLink()
	{
	    scrollDown("200");
		clickOn(vinBookStorelink);
	}
	
	public void verifyBookStorePage()
	{
		waitForPageLoaded();
		Assert.assertTrue(isElementDisplayed(SubTitleBookStore));
	}
	
	public void selectCommunityStoreLink()
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,550)", "");
		clickOn(communityStoreLink);
	}
}
