package com.vin.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.vin.selenium.core.BasePage;

public class RepresentativesPage extends BasePage{

	public RepresentativesPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//div[@class='DocumentTitle'and contains(text(),'VIN Representatives')]")
	private WebElement SubTitle;
	
	@FindBy(xpath="//ul[@id='committeeList']/li/a[text()='Adrian Kreeger']")
	private WebElement adriankreegerlink;
	
	@FindBy(xpath="//h2[text()='Adrian Kreeger']")
	private WebElement kreegerTitle;
	
	public void verifyRepresentativeSubTitleDisplayed()
	{
		waitForPageLoaded();
		Assert.assertTrue(isElementDisplayed(SubTitle));
	}

	public void selectadrianKreegerLink()
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
//		jse.executeScript("arguments[0].scrollIntoView(true)", adriankreegerlink);
		clickOn(adriankreegerlink);
	}
	
	public void verifyAdrianKreegerPageTitle()
	{
		waitForPageLoaded();
		Assert.assertTrue(isElementDisplayed(kreegerTitle));
	}
}
