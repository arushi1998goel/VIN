package com.vin.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.vin.selenium.core.BasePage;


public class ConsultantsAndEditorsPage  extends BasePage{

	public ConsultantsAndEditorsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='consultants promoPage container']//a[text()='Alternative Medicine']")
	private WebElement alternateMedicine;
	
	@FindBy(xpath="//div[@id='consList_SpecialtyImgHolder']//em")
	private WebElement alternativeMedicinePage;

	@FindBy(xpath="//a[text()='Susan Wynn']")
	private WebElement susanWynn;
	
	@FindBy(xpath="//h2[text()='Susan Wynn']")
	private WebElement susanWynnPageTitle;
	
	@FindBy(xpath="//h2[text()='a']")
	private WebElement scroll;
	
	/**
	 * select alternative medicines
	 */
	
	public void selectAlternativeMedicines(){
		waitForPageLoaded();
		_normalWait(3000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,550)", "");
		clickOn(alternateMedicine);
	}
	
	/**
	 * verify Susan Wynn page title
	 */
	
	public void verifysusanWynnSubTitle(){
		waitForPageLoaded();
		Assert.assertTrue(isElementDisplayed(susanWynnPageTitle));
	}
	
	/**
	 * verify alternate medicine page displayed
	 */
	
	public void verifyAlternateMedicinesPageDisplayed(){
		waitForPageLoaded();
		Assert.assertTrue(isElementDisplayed(alternativeMedicinePage));
	}
	
	/**
	 * select Susan Wynn under consultants
	 */
	
	public void selectSusanWynnUnderConsultants(){
		clickOn(susanWynn);
	}
}
