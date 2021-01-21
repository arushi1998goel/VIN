package com.vin.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.vin.selenium.core.BasePage;
import com.vin.selenium.core.Configuration;

import com.vin.utilities.Constants;

public class LoginPage extends BasePage {
	private String applicationUrl;
	

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//input[starts-with(@id,'User')]")
	private WebElement userInput;

	@FindBy(xpath="//input[@id='Password']")
	private WebElement passwordInput;

	@FindBy(xpath = "//div[@class='panel-title']")
	private WebElement loginPage;
	
	@FindBy(xpath = "//div[@id='main-actionButtons']/a[text()='Login']")
	private WebElement loginButton;

	@FindBy(css = "input[id='LoginCtrl_Login']")
	private WebElement login;
	
	@FindBy(xpath = "//div[@class='form-group text-center']//button[text()='Log In']")
	private WebElement loginControl;

	
	/**
	 * Verify login page displayed
	 */
	public void verifyUserLoginPage() {
		waitForPageLoaded();
		_normalWait(1000);
		assertByPageTitle(Constants.pageTitle_LoginPageAuthentication);
	}

	/**
	 * Function: Login application.
	 * @param userName
	 * @param password
	 * @return
	 */
	 public <T> T loginInApplication(final Class<T> className, String userName, String password) {
			inputText(userInput, userName);
			inputText(passwordInput, password);
			clickOn(loginControl);
			_normalWait(3000);
			return (T) PageFactory.initElements(driver, className);
		}
	 
	public SecurityQuestionPage loginInApplication(String userName, String password) {
		inputText(userInput, userName);
		inputText(passwordInput, password);
		clickOn(loginControl);
		_normalWait(3000);
		return PageFactory.initElements(driver, SecurityQuestionPage.class);
	}
	
	public SecurityQuestionPage LoginForVinUsage(String userName, String password) throws Exception {
		applicationUrl = System.getProperty("targetEnv") + Configuration.readApplicationFile("viewUsage");
		driver.navigate().to(applicationUrl);
		inputText(userInput, userName);
		inputText(passwordInput, password);
		clickOn(loginControl);
		return PageFactory.initElements(driver, SecurityQuestionPage.class);
	}
	
	
	public SecurityQuestionPage loginForMyColleague(String userName, String password) throws Exception {
		applicationUrl = System.getProperty("targetEnv") + Configuration.readApplicationFile("mycolleague");
		driver.navigate().to(applicationUrl);
		inputText(userInput, userName);
		inputText(passwordInput, password);
		clickOn(loginControl);
		return PageFactory.initElements(driver, SecurityQuestionPage.class);
	}
	
	public SecurityQuestionPage loginForDrugDilution(String userName, String password) throws Exception {
		applicationUrl = System.getProperty("targetEnv") + Configuration.readApplicationFile("drugDilution");
		driver.navigate().to(applicationUrl);
		inputText(userInput, userName);
		inputText(passwordInput, password);
		clickOn(loginControl);
		return PageFactory.initElements(driver, SecurityQuestionPage.class);
	}
	
	
	public SecurityQuestionPage loginForTransfusionVolume(String userName, String password) throws Exception {
		applicationUrl = System.getProperty("targetEnv") + Configuration.readApplicationFile("transfusionVolume");
		driver.navigate().to(applicationUrl);
		inputText(userInput, userName);
		inputText(passwordInput, password);
		clickOn(loginControl);
		return PageFactory.initElements(driver, SecurityQuestionPage.class);
	}
	
	public SecurityQuestionPage loginForFeedingTube(String userName, String password) throws Exception {
		applicationUrl = System.getProperty("targetEnv") + Configuration.readApplicationFile("feedingtube");
		driver.navigate().to(applicationUrl);
		inputText(userInput, userName);
		inputText(passwordInput, password);
		clickOn(loginControl);
		return PageFactory.initElements(driver, SecurityQuestionPage.class);
	}
	
	public SecurityQuestionPage loginForEmergencyDrugCanine(String userName, String password) throws Exception {
		applicationUrl = System.getProperty("targetEnv") + Configuration.readApplicationFile("EmergencyDrugCanine");
		driver.navigate().to(applicationUrl);
		inputText(userInput, userName);
		inputText(passwordInput, password);
		clickOn(loginControl);
		return PageFactory.initElements(driver, SecurityQuestionPage.class);
	}
	
	
	public SecurityQuestionPage loginForChocolateToxicity(String userName, String password) throws Exception {
		applicationUrl = System.getProperty("targetEnv") + Configuration.readApplicationFile("ChocolateToxicity");
		driver.navigate().to(applicationUrl);
		inputText(userInput, userName);
		inputText(passwordInput, password);
		clickOn(loginControl);
		return PageFactory.initElements(driver, SecurityQuestionPage.class);
	}
	
	
	public SecurityQuestionPage loginForStudentLoanSim(String userName, String password) throws Exception {
		applicationUrl = System.getProperty("targetEnv") + Configuration.readApplicationFile("studentloansim");
		driver.navigate().to(applicationUrl);
//		inputText(userInput, userName);
//		inputText(passwordInput, password);
//		clickOn(login);
		return PageFactory.initElements(driver, SecurityQuestionPage.class);
	}

	public SecurityQuestionPage loginForPostGraduateTraining(String userName, String password) throws Exception {
		applicationUrl = System.getProperty("targetEnv") + Configuration.readApplicationFile("postGraduateTraining");
		driver.navigate().to(applicationUrl);
		inputText(userInput, userName);
		inputText(passwordInput, password);
		clickOn(loginControl);
		return PageFactory.initElements(driver, SecurityQuestionPage.class);
	}
	
	public SecurityQuestionPage loginForPhlebotomyCalculator(String userName, String password) throws Exception {
		applicationUrl = System.getProperty("targetEnv") + Configuration.readApplicationFile("phlebotomyVolume");
		driver.navigate().to(applicationUrl);
		inputText(userInput, userName);
		inputText(passwordInput, password);
		clickOn(loginControl);
		return PageFactory.initElements(driver, SecurityQuestionPage.class);
	}
	
	
	public SecurityQuestionPage loginForIsleHappyPath(String userName, String password) throws Exception {
		applicationUrl = System.getProperty("targetEnv") + Configuration.readApplicationFile("isleHappyPath");
		driver.navigate().to(applicationUrl);
		return PageFactory.initElements(driver, SecurityQuestionPage.class);
	}
	
	
	public SecurityQuestionPage loginForCRI(String userName, String password) throws Exception {
		applicationUrl = System.getProperty("targetEnv") + Configuration.readApplicationFile("CRI");
		driver.navigate().to(applicationUrl);
		inputText(userInput, userName);
		inputText(passwordInput, password);
		clickOn(loginControl);
		return PageFactory.initElements(driver, SecurityQuestionPage.class);
	}
	
	
	
	
	
	

}
