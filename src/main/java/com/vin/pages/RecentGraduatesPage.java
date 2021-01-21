package com.vin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.vin.selenium.core.BasePage;

public class RecentGraduatesPage extends BasePage {

	public RecentGraduatesPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//h2[text()='Recent Graduates']")
	private WebElement subTitle;
	
	public void verifyRecentGraduatesPage()
	{
		waitForPageLoaded();
		Assert.assertTrue(isElementDisplayed(subTitle));
	}

	
	public void closeCurrentTab()
	{
		driver.close();
		
	}
}
