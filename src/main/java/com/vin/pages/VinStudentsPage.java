package com.vin.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vin.selenium.core.BasePage;

public class VinStudentsPage extends BasePage {

	public VinStudentsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//section[@id='promoPageNavLinks']//a[text()='Students Home']")
	private WebElement subTitle;
	
	public void verifyVinStudentsPage()
	{
		waitForPageLoaded();
		Assert.assertTrue(isElementDisplayed(subTitle));
	}
	
	public void closeTab()
	{
		driver.close();
	}
	

}
