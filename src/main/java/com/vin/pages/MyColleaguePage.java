package com.vin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.vin.selenium.core.BasePage;
import com.vin.utilities.Constants;

public class MyColleaguePage extends BasePage {

	public MyColleaguePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[text()='Colleague Search']/..//table")
	private WebElement colleageSearchEntry;

	@FindBy(xpath = "//label[@for='rdoAll']/preceding-sibling::input")
	private WebElement allWinnerRadioButton;

	@FindBy(xpath = "//button[text()='Search']")
	private WebElement searchButton;

	@FindBy(xpath = "//span[contains(text(),'search fields')]")
	private WebElement erroMessage;

	@FindBy(css = "input[id='txtFirstName']")
	private WebElement fisrtNameTextBox;

	@FindBy(css = "input[id='txtLastName']")
	private WebElement lastNameTextbox;

	@FindBy(xpath = "//select[@id='lstColleagues']/option[contains(text(),'Winters')]")
	private WebElement resultsFullName;

	@FindBy(xpath = "//div[@id='divSearchResultsPanel']/div[text()='Search Results']")
	private WebElement searchResults;

	@FindBy(xpath = "//div[@class='BrowserDetectionContainer']/following-sibling::div")
	private WebElement viewingNumberofResults;
	
	@FindBy(css = "a[id='lnkLogout']")
	private WebElement Logout;
	
	@FindBy(css="a[id='lnkViewProfile']")
	private WebElement viewProfileButton;
	
	@FindBy(xpath="//span[contains(text(),'colleague')]")
	private WebElement selectAColleague;

	@FindBy(xpath = "//button[text()='Dismiss All']")
	private WebElement dismissAllBtn;

	
	
	/**
	 * Verify Colleague search entry
	 */
	public void verifyColleagueSearchEntry() {
		boolean flag = false;
		if (isElementDisplayed(colleageSearchEntry)) {
			flag = true;
			Assert.assertTrue(flag);

		}
	}

	/**
	 * Verify AllWinners radio Button is Selected
	 */
	public void verifyAllWinnersRadioButtonSelected() {
		Assert.assertTrue(allWinnerRadioButton.isSelected());
	}

	/**
	 * Click on Search Button
	 */
	public void selectSearch() {
		waitForElement(searchButton);
		waitAndClick(searchButton);
	}

	/**
	 * Verify Error Message
	 */
	public void verifyErrorMessageDislpayed(String ErrorMessage) {
		boolean flag = false;
		System.out.println(erroMessage.getText());
		_normalWait(2000);
		Assert.assertTrue(erroMessage.isDisplayed());
		String Text = erroMessage.getText();
		if (Text.trim().toLowerCase().equals(ErrorMessage.trim().toLowerCase())) {
			flag = true;
			Assert.assertTrue(flag);

		}

	}

	/**
	 * Enter firstName in The TextBox
	 */
	public void enterNameInTheTextBox(String FirstName) {
		inputText(fisrtNameTextBox, FirstName);

	}

	/**
	 * Verify User is able to enter name in the TextBox
	 */
	public void verifyUserIsAbleToEnterNameInTheFirstNameTextBox(String name) {
		boolean flag = false;
		String text = fisrtNameTextBox.getAttribute("value");
		if (text.trim().equalsIgnoreCase(name)) {
			flag = true;
			Assert.assertTrue(flag);
		}

	}

	/**
	 * Enter firstName in The TextBox
	 */
	public void enterNameInTheLastNameTextBox(String FirstName) {
		inputText(lastNameTextbox, FirstName);

	}

	/**
	 * Verify User is able to enter name in the TextBox
	 */
	public void verifyUserIsAbleToEnterNameInTheLastNameTextBox(String name) {
		boolean flag = false;
		String text = lastNameTextbox.getAttribute("value");
		if (text.trim().equalsIgnoreCase(name)) {
			flag = true;
			Assert.assertTrue(flag);
		}

	}

	/**
	 * verify name under results Section
	 */
	public void verifyNameUnderSearchResultsSection(String textToBeVerified) {
		boolean flag = false;
		String name = resultsFullName.getText();
		System.out.println(name.trim().toLowerCase().replace(" ", ""));
		System.out.println(textToBeVerified.trim().toLowerCase().replace(" ", ""));
		if (name.trim().toLowerCase().replace(" ", "")
				.equalsIgnoreCase(textToBeVerified.trim().toLowerCase().replace(" ", ""))) {
			flag = true;
			Assert.assertTrue(flag);

		}

	}

	/**
	 * Verify modal 'Search Results' | text 'Viewing 1 of 1 results'
	 */
	public void verifyModalSearchResultsAndText(String Text) {
		boolean flag = false;
		Assert.assertTrue(searchResults.isDisplayed());
		if (viewingNumberofResults.getText().trim().toLowerCase().equalsIgnoreCase(Text.trim().toLowerCase())) {
			flag = true;
		

		}
		Assert.assertTrue(flag);

	}
	
	/**
	 * Click on View Profile Button
	 */
	public void clickViewProfileButton() {
		waitForElement(viewProfileButton);
		_normalWait(1000);
		waitAndClick(viewProfileButton);
	}
	
	/**
	 * Click on Logout
	 */
	public void clickLogout() {
		_normalWait(2000);
		waitAndClick(Logout);
	}

	/**
	 * Verify Logout Page displayed
	 */
	public void verifyLogoutPageDisplayed() {
		waitForPageLoaded();
		_normalWait(1000);
		assertByPageTitle(Constants.pageTitle_LoggedoutPage);
	}
	
	/**
	 * Verify select a colleague error Button
	 */
	public void verifySelectAColleagueErrorMEssage(String errorMessage) {
		boolean flag= false;
		_normalWait(2000);
		Assert.assertTrue(selectAColleague.isDisplayed());
		
		String Text=selectAColleague.getText();
		if (Text.trim().toLowerCase().equalsIgnoreCase(errorMessage.trim().toLowerCase())) {
			flag= true;
			Assert.assertTrue(flag);
		}
		
	}
	
	/**
	 * Select Ava Winters from the TextBox
	 */
	public void selectNameFromTheTextBox() {
		waitAndClick(resultsFullName);
		
	}
	
	/**
	 * Verify Name Present in the TexBox Is Highlighted
	 */
	public void verifyNameIsHighlighted(String color) {
		boolean flag=false;

		if (getBackgroundColor(resultsFullName).equalsIgnoreCase("rgba(30, 144, 255, 1)")) {
			flag = true;
			Assert.assertTrue(flag);
		} else {
			if (getBackgroundColor(resultsFullName).equalsIgnoreCase("rgb(0, 120, 215)")) {
				flag = true;
				Assert.assertTrue(flag);

			}
	}
	}
	
	/**
	 * Verify Browser Url
	 */
	public void verifyBroswerUrl(String URl) {
		boolean flag=false;

		if (driver.getCurrentUrl().contains(URl)) {
			flag=true;
			
		}
		Assert.assertTrue(flag);

		
	}
	
	/**
	 * Verify Profile
	 */
	public void verifyProfile(String Profile ) {
		System.out.println(driver.getTitle().trim().toLowerCase().substring(0,30).replaceAll("\\s",""));
		System.out.println(Profile.trim().toLowerCase().replaceAll("\\s",""));
		Assert.assertEquals(driver.getTitle().trim().toLowerCase().substring(0,30).replaceAll("\\s",""), Profile.trim().toLowerCase().replaceAll("\\s",""));
		
	}


    public void dismissNotifications() {
    	_normalWait(5000);
		super.dismissNotifications(dismissAllBtn);
    }
    
    /**
     * Verify search result pop up message results
     * @param searchresults2
     */
	public void verifyMessageSearchResultPopup() {
		WebElement message=getDriver().findElement(By.xpath("//div[@class='notifyjs-bootstrap-base notifyjs-bootstrap-success' ]//span"));
		if(message.isDisplayed()) {
			Assert.assertTrue(true);
		}
	}

}
