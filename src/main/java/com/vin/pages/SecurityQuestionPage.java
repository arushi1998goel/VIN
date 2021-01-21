package com.vin.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vin.selenium.core.BasePage;
import com.vin.utilities.Constants;

public class SecurityQuestionPage extends BasePage {

	public SecurityQuestionPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "input[id='txtAnswer']")
	private WebElement securityQuestion;

	@FindBy(id = "txtAnswer")
	private List<WebElement> securityIDNumberInput;

	@FindBy(id = "txtAnswer")
	private WebElement secureIDNumberInput;

	@FindBy(id = "btnAnswer")
	private WebElement loginButton;

	@FindBy(xpath = "//div[@class='panel panel-primary']")
	private WebElement secondary;
	
	@FindBy(xpath = "//button[text()='Dismiss All']")
    private WebElement dismissAllBtn;

	/**
	 * Verify Security Question Page displayed
	 */
	public void verifySecurityQuestionPageDisplayed() {
		waitForPageLoaded();

		boolean SecurityPage;
		SecurityPage = verifyURL(Constants.securityPageUrl);

		if (SecurityPage) {

			assertByPageTitle(Constants.pageTitle_SecurityQuestionPage);
			_normalWait(4000);
		}
	}

	/**
	 * Enter Security Answer and Login
	 * 
	 * @return
	 */
	public <T> T enterSecurityAnswerAndLogin(final Class<T> className, String EnterSecurityIDAnswer,
			String EnterSecurityNameAnswer) {

		boolean SecurityPage;
		SecurityPage = verifyURL(Constants.securityPageUrl);

		if (SecurityPage) {

			if (isElementDisplayed(secureIDNumberInput)) {
				if (getText(securityQuestion).contains("Mother")) {
					inputText(secureIDNumberInput, EnterSecurityNameAnswer);
				} else {
					inputText(secureIDNumberInput, EnterSecurityIDAnswer);
				}
				clickOn(loginButton);
			}
		}
		return (T) PageFactory.initElements(driver, className);
	}

	public VVDHPage dismissNotifications() {
        super.dismissNotifications(dismissAllBtn);
        return PageFactory.initElements(driver, VVDHPage.class);
		
	}
	
	public CalculatorPage dismissNotificationsPopUp() {
        super.dismissNotifications(dismissAllBtn);
        return PageFactory.initElements(driver, CalculatorPage.class);
		
	}


}
