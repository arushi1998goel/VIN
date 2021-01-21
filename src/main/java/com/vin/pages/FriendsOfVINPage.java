package com.vin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.vin.selenium.core.BasePage;


public class FriendsOfVINPage extends BasePage{

	public FriendsOfVINPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//img[@title='American College of Veterinary Internal Medicine']/following::a[1]")
	private WebElement conferencehomelink;
	
	@FindBy(xpath="//span[text()='ABOUT ACVIM FORUM']")
	private WebElement acvimSubtitle;;
	
	@FindBy(xpath="//img[@title='American College of Veterinary Internal Medicine']/following::a[2]")
	private WebElement proceedingAccess;
	
	@FindBy(xpath="//strong[text()='The 2020 ACVIM Forum On Demand Proceedings are now available online. ']")
	private WebElement procedingaccessSubtitle;
	
	public void verifyProcedingAccessSubTitle()
	{
		waitForPageLoaded();
		Assert.assertTrue(isElementDisplayed(procedingaccessSubtitle));
	}
	
	public void selectProceedingAccesslink()
	{
		scrollDown();
		clickOn(proceedingAccess);
	}
	public void selectConfrerenceHomeLink()
	{
		waitForPageLoaded();
		clickOn(conferencehomelink);
	}

	public void verifyACVIMPage()
	{
		waitForPageLoaded();
		Assert.assertTrue(isElementDisplayed(acvimSubtitle));
	}
	
}
