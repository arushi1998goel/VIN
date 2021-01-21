package com.vin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vin.selenium.core.BasePage;
import com.vin.utilities.Constants;

public class LogoutPage extends BasePage {
	
	public LogoutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[@title='vin.com']/h3[text()='Login to']")
	private WebElement vinLogIn;

	

	/**
	 * Verify Logout Page displayed
	 */
	public void verifyLogoutPageDisplayed() {
		waitForPageLoaded();
		_normalWait(1000);
		assertByPageTitle(Constants.pageTitle_LoggedoutPage);
	}
	
	/**
	 * login to VIN
	 */
	public PromoPage vinLogIn() {
		waitAndClick(vinLogIn);
        return PageFactory.initElements(driver, PromoPage.class);
	}

}
