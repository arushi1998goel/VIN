package com.vin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.vin.selenium.core.BasePage;



public class VINxPage extends BasePage {
	
	 public VINxPage(WebDriver driver) {
		super(driver);
		}
	 
    @FindBy(xpath = "//img[@class='brand-img img-responsive']")
    private WebElement VINxLogo;
    
    @FindBy(xpath = "//div[@class='panel-collapse in']")
    private WebElement openPanel;

	 
	 /**
	  * hover navigate items
	  * @param text
	  */
	public void hoverOnNavigateDropDown(String text) {
  
		WebElement dropdown = findElement(By.xpath("//a[contains(text(),'"+text+"')]"));
		mouseHoverOnAnElement(dropdown);
		//waitAndClick(dropdown);
	}
	
	/**
	  * hover navigate items
	  * @param text
	  */
	public void clickOnNavigateItems(String text) {
 
		WebElement dropdown = findElement(By.xpath("//a[contains(text(),'"+text+"')]"));
		waitAndClick(dropdown);
	}
	
	/**
	 * verify page title
	 * @param Title
	 */
	public void verifyThePagetitle(String Title) {
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(Title));
	}
	
	public void title() {
		String s= driver.getTitle();
		System.out.println(s);
	}
	
	/**
	 * click on VETtool logo
	 */
    public void clickOnVetToolLogo() {
    	waitAndClick(VINxLogo);
    }

    /**
     * scroll down and click on arrow button
     */
    public void scrollDownAndclickOnArrowButton(String text) {
    	scrollDown();
    	WebElement locator = findElement(By.xpath("//a[contains(text(),'"+text+"')]"));
		waitAndClick(locator);
    }
    
    /**
     * verify panel is expended
     */
    public void verifyPanelIsExpended() {
    	Assert.assertTrue(openPanel.isDisplayed());
    }
}
