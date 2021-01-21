package com.vin.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.vin.selenium.core.BasePage;

public class NewsPage extends BasePage {

	public NewsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//p[@align='right'])[1]//a")
	private WebElement readArticleLink;

	@FindBy(xpath = "(//h2[text()='Whatever happened with ... ?'])[1]")
	private WebElement firstLink;

	@FindBy(xpath = "(//ul[@class='list-group']//a)[1]")
	private WebElement firstLinkInLatestNews;

	@FindBy(xpath = "(//a[@class='title2'])[1]")
	private WebElement titleunderRecentStories;

	@FindBy(xpath = "//img[@alt='News Banner']")
	private WebElement vinNewsServiceLogo;

	@FindBy(xpath = "//input[@id='projectSearchText']")
	private WebElement inputtextForVinNewsService;

	@FindBy(xpath = "//input[@value='GO']")
	private WebElement goButton;

	@FindBy(xpath = "//div[@class='SearchResultCharacterization']")
	private List<WebElement> resultPageForPitBull;

	@FindBy(xpath = "(//div[@class='dropdown-content']/a[contains(text(),'Relevance')])[1]")
	private WebElement sortByRelevance;

	@FindBy(xpath = "(//div[@class='dropdown-content']/a[contains(text(),'Date')])[1]")
	private WebElement sortByDate;

	@FindBy(xpath = "(//button[@class='dropbtn'])[1]")
	private WebElement sortByRelevanceButton;

	@FindBy(xpath = "(//button[@class='dropbtn'])[1]/..//a")
	private List<WebElement> sortByRelevanceDropdownOptions;

	@FindBy(xpath = "//div[@class='SearchResultDescription']")
	private List<WebElement> listOfResultsDisplayedInDates;
	
	@FindBy(xpath="//label[@for='resultCb1']/a[@class='ResultLink']")
	private WebElement resultsLink;
	
	@FindBy(xpath="//label[@for='resultCb26']/a[@class='ResultLink']")
	private WebElement resultspage2;
	
	@FindBy(xpath="//div[@id='ProjectPanel4']//a")
	private WebElement viewAllArticles;

	@FindBy(xpath="//div[@id='SearchResultsDiv']")
	private WebElement artcilesPageDisplayed;
	
	@FindBy(xpath="//div[@id='SearchResultsTable']/following-sibling::button[@class='nextPage btn btn-warning']")
	private WebElement nextButton;
	
	@FindBy(xpath="(//div[@id='SearchResultsDiv']//button[@class='prevPage btn btn-warning'])[2]")
	private WebElement previouButton;
	
	@FindBy(xpath="(//button[text()='Sort by date']/..//button)[1]")
	private WebElement sortByDateButton;
	
	@FindBy(xpath="//p/a/img[@title='Sign Up Now']")
	private WebElement signupButton;
	
	@FindBy(xpath="//div[@id='mainmenu']//a[text()='About']")
	private WebElement aboutDropDown;
	
	@FindBy(xpath="//div[@id='mainmenu']//a[text()='About Evetsites']")
	private WebElement aboutEvetsites;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement searchInput;
	
	@FindBy(xpath="//tbody/tr[@class='basicText'][1]/td/strong")
	private WebElement selectArticle;
	
	@FindBy(xpath="//a[@id='ctl01_SearchResultItem_ResultLink_0']")
	private WebElement firstArticleLink;
	
	@FindBy(xpath="//div[@id='vlogo1']")
	private WebElement vinNewsButton;
	
	@FindBy(xpath="//img[@alt='Twitter']")
	private WebElement tweetButton;
	
	@FindBy(xpath="//img[contains(@alt,'Facebook')]")
	private WebElement facebookButton;
	
	@FindBy(xpath="//img[@alt='Subscribe to VIN News Alerts']")
	private WebElement emailButton;
	
	@FindBy(xpath="//div[@class='field-group']/input[@type='email']")
	private WebElement emailField;
	
    @FindBy(xpath="//div[@class='field-group']/input[@name='MERGE1']")
	private WebElement firstNameField;
	
	@FindBy(xpath="//div[@class='field-group']/input[@name='MERGE2']")
	private WebElement lastNameField;
	
	@FindBy(xpath="//label[@for='EMAILTYPE_TEXT']")
	private WebElement textRadioButton;
	
	@FindBy(xpath="(//td[@valign='top'])[2]//h4")
	private WebElement ReadArticleHeaderText;
	
	@FindBy(xpath="//div[@id='MainMiscContainer']//div[@id='DocumentTitlePanel']")
	private WebElement ReadArticleLabel;
	
	@FindBy(xpath="((//ul[@class='list-group']//li)[1]//a)[1]")
	private WebElement firstArticle;
	
	@FindBy(xpath="//div[@id='DocumentTitlePanel']")
	private WebElement firstArticleText;
	
	@FindBy(xpath="//span[@class='resultNo']")
	private List< WebElement> resultsInNumber;
	
	@FindBy(xpath="//div[@class='leftBtns']//input")
	private List< WebElement> uncheckedCheckbox;
	
	@FindBy(xpath="//div[@id='SearchResultsTable']//label")
	private List< WebElement> searchResults;


	
	/**
	 * Click on read article link
	 */
	public void clickOnReadArticleLinkAndVerifySelectedAricleIsDisplayed() {
		waitForElementPresent(ReadArticleHeaderText);
		String headerText=ReadArticleHeaderText.getText();
		waitAndClick(readArticleLink);
		_normalWait(5000);
		if(ReadArticleLabel.isDisplayed()) {
			Assert.assertEquals(headerText, ReadArticleLabel.getText());
		}
	}

	/**
	 * getting the text for the first article
	 */
	public String getTheTextOfTheFirstArticle() {
		String text = firstLink.getText();
		return text;

	}

	/**
	 * Click on first news article
	 */
	public void verifyTheFirstNewsLink(String title) {
		Assert.assertTrue(driver.getTitle().contains(title));
	}

	/**
	 * Verify the latest on news Vin page
	 */
	public void verifyUserISLandedBackToLatestNewsPage() {
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("News - VIN"));
	}

	/**
	 * Close Current window
	 */
	public void closeCurrentWindow() {
		getDriver().close();
	}

	/**
	 * Verify the artcle is same as opened in the new tab after click on the link in
	 * the previous tab
	 */
	public String verifyTheLinkOpenedIsSame() {
		String text = firstLinkInLatestNews.getText();
		return text;
	}

	/**
	 * Click on first link under latest news section
	 */

	public void clickOnFirstLinkUnderLatestNewsAndverifyCorrectPageLoad() {
		
		String firstLinkText=firstLinkInLatestNews.getText();
		waitAndClick(firstLinkInLatestNews);
		if(ReadArticleLabel.isDisplayed()) {
			Assert.assertEquals(firstLinkText, ReadArticleLabel.getText());
		}
		

	}

	/**
	 * Verify the page opened is same as we clicked on the link
	 */
	public void verifyThePageOpenedIsSame(String text) {
		_normalWait(4000);
		Assert.assertTrue(getDriver().getTitle().contains(text));

	}

	/**
	 * 8 click on link under recent stories
	 */
	public void clickOnLinkUnderRecenStories() {
		waitAndClick(titleunderRecentStories);
	}

	/**
	 * Click on Vin News Service logo
	 */
	public void clickOnVinNewsServiceLogo() {
		waitAndClick(vinNewsServiceLogo);
	}
	
	/**
	 * ente text in the vin news service section
	 */
	public void enterTextInTheVinNewsServiceTextbox() {
		inputText(inputtextForVinNewsService, "pit bull");

	}

	/**
	 * Click on go button
	 */
	public void clickOnGoButton() {
		waitAndClick(goButton);
	}

	/**
	 * Verify results are displayed under search option
	 */
	public void verifyPitbullResultsAreShown(String Text) {
		boolean flag = false;
		for (WebElement we : resultPageForPitBull) {
			if (we.getText().contains(Text)) {
				flag = true;
			}
			Assert.assertTrue(flag);
		}

	}

	/**
	 * Select Sort by relevance dropdown
	 */
	public void selectSortByRelevanceAndSortByDateDropDown(String text) {
//		waitAndClick(sortByRelevance);
//		mouseHoverOnAnElement(sortByRelevanceButton);
		waitAndClick(sortByRelevanceButton);
		
		for (WebElement we : sortByRelevanceDropdownOptions) {
			_normalWait(5000);
			waitForWebElementEnable(we);
			if (we.getText().contains(text)) {
				waitAndClick(we);
				break;

			}
		}

	}

	/**
	 * Sort the dates by descending order
	 */
	public void sortTheListByDescendingOrder() {
		List<String> listIntegers = new ArrayList<String>();
		for (WebElement we : listOfResultsDisplayedInDates) {
			listIntegers.add(we.getText().replaceAll("\\D", ""));

		}
		List<String> tempList = listIntegers;
		System.out.println("Before sorting: " + listIntegers);
		Collections.sort(tempList);
		System.out.println("After sorting: " + listIntegers);
		Collections.reverse(listIntegers);
		Assert.assertEquals(listIntegers, tempList);
	}
	
	/**
	 * Click on link on results page
	 */
	public void clickOnFirstLinkOnResultPage() {
		waitAndClick(resultsLink);
	}
	
	/**
	 * Getting the text of the first Link
	 */
	public String getTextFromTheFirstLinkOnTheResultPage() {
		String Text=resultsLink.getText();
		return Text;
	}
	
	
	/**
	 * Click on View All articles
	 */
	public void selectViewAllArtciles() {
		waitAndClick(viewAllArticles);
	}
	
	/**
	 * verify the page has been Opened
	 */
	public void verifyArticlesPageIsOpened() {
		Assert.assertTrue(artcilesPageDisplayed.isDisplayed());
		
	}
	
	/**
	 * Verify list of dropdown is displayed
	 */
	public void verifyListOfDropDownIsDisplayed() {
		_normalWait(2000);
		Assert.assertTrue(sortByRelevance.isDisplayed());
		Assert.assertTrue(sortByDate.isDisplayed());
	}
	
	/**
	 * Click on next button
	 */
	public void selectNextButton() {
		waitAndClick(nextButton);
	}
	
	/**
	 * Verify the previous button is displayed when click on next button
	 */
	public void verifypreviousButtonIsDisplayedAndNextLinkIsDisplayed() {
		Assert.assertTrue(previouButton.isDisplayed());
	}
	
	/**
	 * Click on news article when moving to the next page
	 */
	public void clickOnNextArticleOnMovingToTheNextPage() {
		waitAndClick(resultspage2);
	}
	
	/**
	 * get the text of the article when moving to the next page
	 */
	public String getTheTextOfTheArticle() {
		_normalWait(3000);
		String text=resultspage2.getText();
		return text;
		
	}

	/**
	 * Select the first article under VIN News Service and verify that link opens in same tab
	 */
	public void selectTheFirstArticleUnderVINNewsService() {
		String linkText=firstArticle.getText();
		waitAndClick(firstArticle);
		if(getDriver().getTitle().equalsIgnoreCase("Covetrus CEO: First year was ‘mixed bag’ - VIN")) {
			Assert.assertTrue(true);
			String textToVerified=getDriver().getTitle();
			Assert.assertEquals(linkText, textToVerified.replace(" - VIN", ""));
		}
	}

	/**
	 * Type AVMA in textbox
	 * @param avmatext
	 */
	public void TypeAVMAOnTheTextBoxUnderSearchVINNewsService(String avmatext) {
		inputText(inputtextForVinNewsService, avmatext);
		String text=inputtextForVinNewsService.getAttribute("value");
		Assert.assertEquals(avmatext, text);
	}

	/**
	 * Verify search results are displayed for VIN News service
	 * @param avmatext
	 */
	public void verifySearchResultsAreDisplayed(String avmatext) {
		for(WebElement result: searchResults) {
			Assert.assertTrue(result.getText().contains(avmatext));
		}
	}

	/**
	 * Verify each result is mark with number
	 */
	public void verifyEachResultMarkedWithNumberAndUncheckCheckBoxIcon() {

		for(WebElement number: resultsInNumber) {
			int nmbr=Integer.parseInt(number.getText().replace(".","" ));
			if(nmbr>0) {
				Assert.assertTrue(true);
			}
		}
		
		for(WebElement checkbox: uncheckedCheckbox) {
			if(checkbox.isSelected()) {
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
	}

	/**
	 * Select sort by relevance button
	 * @param relevancetext
	 */
	public void selectSortByRelevanceButton(String relevancetext,String dateText) {

		waitAndClick(sortByRelevanceButton);
		if(getDriver().findElement(By.xpath("(//a[text()='"+relevancetext+"']/..//a)[1]")).isDisplayed()) {
			waitAndClick(getDriver().findElement(By.xpath("(//a[text()='"+relevancetext+"']/..//a)[1]")));
			if(sortByRelevanceButton.isDisplayed()) {
				Assert.assertTrue(true);	
			}
		}
		
		waitAndClick(sortByRelevanceButton);
		if(getDriver().findElement(By.xpath("(//a[text()='"+dateText+"']/..//a)[2]")).isDisplayed()) {
			waitAndClick(getDriver().findElement(By.xpath("(//a[text()='"+dateText+"']/..//a)[2]")));
			if(sortByDateButton.isDisplayed()) {
				Assert.assertTrue(true);	
			}
		}
		
		waitAndClick(sortByDateButton);
		if(getDriver().findElement(By.xpath("(//a[text()='"+relevancetext+"']/..//a)[1]")).isDisplayed()) {
			waitAndClick(getDriver().findElement(By.xpath("(//a[text()='"+relevancetext+"']/..//a)[1]")));
			if(sortByRelevanceButton.isDisplayed()) {
				Assert.assertTrue(true);	
			}
		}
	}
	
	/**
	 * click on signup button
	 */
	public void clickOnSignUpButton() {
		waitAndClick(signupButton);
	}
	
	/**
	 * select about drop down
	 */
	public void selectAboutDropDown() {
		waitAndClick(aboutDropDown);
	}
	
	/**
	 * select evetsite from aboutlist
	 */
	public void selectEvetSiteFromAboutDropDown() {
		waitAndClick(aboutEvetsites);
	}
	
	/**
	 * enter search text
	 */
	public void inputIntoSearchField() {
		searchInput.sendKeys("Web Hosting");
		searchInput.submit();
	}

	/**
	 * select artical link
	 */
	public void selectArticleLink() {
     waitAndClick(selectArticle);		
	}
	
	/**
	 *select facebook button
	 */
	public void selectFacebookButton() {
	    waitAndClick(facebookButton);		
		}
	
	/**
	 * verify page title
	 */
	public void verifyPageTitle(String title) {
	    _normalWait(5000);
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(title));
	}
	
	/**
	 * click on first Article link
	 */
	public void clickOnFirstArticleLink() {
		waitAndClick(firstArticleLink);
	}
	
	/**
	 * select vin news service button
	 */
	public void selectVinNewsServiceButton() {
		waitAndClick(vinNewsButton);
	}
   
	/**
    * select tweet button
    */
	public void selectTweetButton() {
       waitAndClick(tweetButton);		
	}
	
	/**
    * select email button
    */
	public void selectEmailButton() {
       waitAndClick(emailButton);		
	}
	
	/**
	 *input email
	 */
	 public void inputEmailInEmailField() {
		 inputText(emailField, "Selenium@VIN.com");
	 }
	 
	 /**
	 *input first name 
	  */
	 public void inputFirstNameInNameField() {
	    inputText(firstNameField, "Selenium");
		 }
	 
	 /**
	 *input email
	 */
	 public void inputLastNameInNameField() {
		  inputText(lastNameField, "User");
			 }

	 /**
	  * select plain text radio button
	  */
	public void selectPlainTextRadioButton() {
       waitAndClick(textRadioButton);		
	}
	
	
}


	

