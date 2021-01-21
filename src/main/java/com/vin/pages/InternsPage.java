package com.vin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.vin.selenium.core.BasePage;

public class InternsPage extends BasePage {

	public InternsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h3[@class='subTitle hidden-xs' and text()='Interns']")
	private WebElement pageSubtitle;
	
	
	public void verifyInternsPage()
	{
		waitForPageLoaded();
		Assert.assertTrue(isElementDisplayed(pageSubtitle));
	}

}
