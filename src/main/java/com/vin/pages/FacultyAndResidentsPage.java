package com.vin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.vin.selenium.core.BasePage;

public class FacultyAndResidentsPage extends BasePage {

	public FacultyAndResidentsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@id='fac-res']//h3[@class='subTitle hidden-xs']")
	private WebElement subTitle;
	
	
	public void verifyFacultyAndResidentsPage()
	{
		waitForPageLoaded();
		Assert.assertTrue(isElementDisplayed(subTitle));
	}
	
	
	

}

