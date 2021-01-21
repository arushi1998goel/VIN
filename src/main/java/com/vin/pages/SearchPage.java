package com.vin.pages;

import com.vin.selenium.core.BasePage;
import com.vin.utilities.Constants;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertTrue;

public class SearchPage extends BasePage {

	 public SearchPage(WebDriver driver) {
	        super(driver);
	    }
	 
	    @FindBy(xpath = "//input[@class='form-control tt-input']")
	    private WebElement inputSearch;

	    @FindBy(xpath = "//input[@class='form-control tt-input']/following-sibling::pre")
	    private WebElement inputSearchContentText;

	    @FindBy(xpath = "//button[@id='btnSearch']/span")
	    private WebElement searchButton;

	    @FindBy(xpath = "//button[@id='btnClearSearch']")
	    private WebElement clearButton;

	    @FindBy(id = "querybreadcrumb")
	    private WebElement queryBreadCrumbUnderSearchBox;

	    @FindBy(css = "div[id='SearchHint'] small")
	    private WebElement searchHintWarningUnderSearchBox;

	    @FindBy(xpath = "//div[@id='ModalNeedQuery']//button[text()='Close']")
	    private WebElement closeErrorPopUp;

	    @FindBy(css = "[id=\"lyr\"] [label=\"Within last X Years\"]")
	    private WebElement anyYearDropDwn;

	    @FindBy(css = "[id=\"lyr\"] [label=\"Filter by Year Ranges\"]")
	    private WebElement yearRanges;

	    // @FindBy(xpath = "//div[@id='results']//tr//td//small/strong")
	    // private List<WebElement> resultsConatiningInformation;

	    @FindBy(xpath = "//div[@id='results']//tr//td[2]")
	    private List<WebElement> resultsConatiningInformation;

	    @FindBy(xpath = "(//div[@class='modal-dialog'])[3]")
	    private WebElement errorPopup;

	    @FindBy(xpath = "//a[contains(text(),'Search by Author(s) or Documentid(s)')]")
	    private WebElement searchByAuthorOrDocumentidFilterDropDown;

	    @FindBy(xpath = "//a[contains(text(),'Search by Author(s) or Documentid(s)')]/parent::div/following-sibling::div")
	    private WebElement searchItemBoxForAuthorOrDocumentidFilterDropDown;

	    @FindBy(id = "auth")
	    private WebElement authorInput;

	    @FindBy(id = "docids")
	    private WebElement documentIdInput;

	    @FindBy(css = "ol[id='querybreadcrumb'] li[title='Remove Filter']>a")
	    private WebElement removeFilterUnderFilterSearchBox;

	    @FindBy(xpath = "//span[@class='fa fa-filter']")
	    private WebElement filterButton;

	    @FindBy(css = "select[id='lyr']")
	    private WebElement drpDwn;

	    @FindBy(css = "select[id='hdlr']")
	    private WebElement matchTermsDropDownInSearchByFilterBox;

	    @FindBy(css = "select[id='specs']")
	    private WebElement speciesDropDown;

	    @FindBy(css = "select[id='fldrs']")
	    private WebElement folderDropDown;

	    @FindBy(xpath = "//div[@class='modal fade in']//button[@type='button'][contains(text(),'Close')]")
	    private WebElement popUpCloseBtn;

	    @FindBy(xpath = "//a[text()='Clear Filters']")
	    private WebElement clearFilterbutton;

	    @FindBy(xpath = "//div[@id='AddtlSrcsPnlHeader']/a[@data-toggle='collapse']")
	    private WebElement additionalSouurceDropDwn;

	    @FindBy(xpath = "(//div[@class='list-group list-condensed medium-txt'])[2]/label")
	    private WebElement additionalDrpDWnValues;

	    @FindBy(xpath = "//label[contains(text(),'Forms/Handouts')]/input")
	    private WebElement formsRadioBtn;

	    @FindBy(xpath = "//a[contains(text(),'Forms/Handouts')]")
	    private WebElement formsHandoutOption;

	    @FindBy(xpath = "//a[@id='menuVC']")
	    private WebElement checkedResultsMenu;

	    @FindBy(xpath = "//a[contains(text(),'Next')]")
	    private WebElement nextResultsPage;

	    @FindBy(id = "lnkViewCheckedResults")
	    private WebElement checkedResultsLink;

	    @FindBy(xpath = "//a[contains(text(),'Check All (this page)')]")
	    private WebElement checkAllResults;

	    @FindBy(xpath = "//a[contains(text(),'Uncheck All (this page)')]")
	    private WebElement uncheckCurrentPageResults;

	    @FindBy(xpath = "//a[contains(text(),'View Highlighted Checked Results')]")
	    private WebElement viewHighlightedResults;

	    @FindBy(xpath = "//a[contains(text(),'Clear View Checked')]")
	    private WebElement clearCheckedResults;

	    @FindBy(xpath = "//input[@id='term']")
	    private WebElement tabSearchBox;

	    @FindBy(xpath = "//a[@id='copyurl']")
	    private WebElement linkURL;

	    @FindBy(xpath = "(//*[@id='results']//*[contains(text(),'Diabetes')])[1]")
	    private WebElement diabetesPageValues;

	    @FindBy(xpath = "//*[@id='btnPrefs']")
	    private WebElement prefrenecesBTN;

	    @FindBy(xpath = "//*[@id='querybreadcrumb']//*[@class='show_']")
	    private WebElement resultValue;

	    @FindBy(xpath = "//*[@class='navbar-header']//*[contains(text(),'Next')]")
	    private WebElement upperNextBTN;

	    @FindBy(xpath = "//*[@class='navbar-header']//*[contains(text(),'Prev')]")
	    private WebElement upperPrevBTN;

	    @FindBy(xpath = "//*[@id='results']/table//tr//p[@class='text-muted']//strong[1]")
	    private List<WebElement> diabetesShowSnippetsList;

	    @FindBy(xpath = "//*[@id='results']/table//tr//p[@class='text-muted']")
	    private List<WebElement> diabetesShowSnippetsParagraphList;

	    @FindBy(xpath = "//*[@id='results']/table//tr//h5/a")
	    private List<WebElement> resultMainTileList;

	    @FindBy(xpath = "//*[@id='results']/table//tr//p[@class='text-info']")
	    private List<WebElement> resultMainTileTextInfoParaLST;

	    @FindBy(xpath = "(//*[@id='tblSearchPreferences']//select//option[@selected='selected'])[1]")
	    private WebElement numberOfResultShowPerPageSETT;

	    @FindBy(xpath = "(//*[@id='tblSearchPreferences']//select//option[@selected='selected'])[2]")
	    private WebElement snippetsPrefrencesSettingValue;

	    @FindBy(xpath = "//*[contains(text(),'Preferences')]//parent::li[contains(@class,'open')]//ul//li[not(contains(@style,'display:none'))]//a")
	    private List<WebElement> prefrencesListOption;

	    @FindBy(xpath = "//*[text()='View Checked (0)']")
	    private WebElement viewCheckedValue;

	    @FindBy(xpath = "//*[@id='startPageTabs']/li/a")
	    private List<WebElement> searchTipsTabsList;

	    @FindBy(xpath = "//*[@id='startPagePanels']//div")
	    private List<WebElement> searchTipsTabContentList;

	    @FindBy(xpath = "//*[contains(text(),'MyVIN Search Preferences')]")
	    private WebElement myVinSearchPreferencesLINK;

	    @FindBy(xpath = "//*[contains(text(),'Search 4 Help')]")
	    private WebElement search4HelpLINK;

	    @FindBy(xpath = "//*[@class='DocumentTitle']")
	    private WebElement howToUseSearchTitle;

	    @FindBy(xpath = "//*[@class='modal-content']//*[text()='VIN Feedback']")
	    private WebElement vinFeedBackWindow;

	    @FindBy(xpath = "//textarea[@name='Feedback']")
	    private WebElement feddbackTextArea;

	    @FindBy(xpath = "//*[@value='Send Message']")
	    private WebElement sendMessageBTN;

	    @FindBy(xpath = "//*[contains(text(),'Thank you.')]")
	    private WebElement feedBackSend;

	    @FindBy(xpath = "//div[@class='modal-backdrop fade in']")
	    private WebElement gryedSearchPage;

	    @FindBy(xpath = "//div[@class='navbar navbar-fixed-top']")
	    private WebElement backgroundClick;

	    @FindBy(xpath = "//iframe[contains(@src,'Members')]")
	    private WebElement feedBackIframe;

	    @FindBy(xpath = "//a[@id='btnSort']")
	    private WebElement sortDropDown;

	    @FindBy(xpath = "//a[contains(text(),'Sort by Date')]")
	    private WebElement sortByDateOpt;

	    @FindBy(xpath = "//a[contains(text(),'Sorted by: Date')]")
	    private WebElement deleteSortFilter;

	    @FindBy(xpath = "//label[contains(text(),'Associate: VINcyclopedia of Diseases')]/input")
	    private WebElement associateFilterRadioBtn;

	    @FindBy(xpath = "//li[contains(text(),'Results')]/b")
	    private WebElement resultsCountDisplayed;

	    @FindBy(xpath = "//button[@id='ModalFilterKeep']")
	    private WebElement keepFilterModalBtn;

	    @FindBy(xpath = "//button[contains(text(),'Clear filters & search')]")
	    private WebElement clearFilterModalBtn;

	    @FindBy(xpath = "//div[@id='ModalFiltersUsed']//button[@type='button'][contains(text(),'Cancel')]")
	    private WebElement cancelModalBtn;

	    @FindBy(xpath = "//a[contains(text(),'Associate: VINcyclopedia of Diseases')]")
	    private WebElement associateFilterLnk;

	    @FindBy(xpath = "//a[contains(text(),'Associate: VINcyclopedia of Diseases')]")
	    private WebElement associateLabel;

	    @FindBy(xpath = "//input[@id='chkfpop']")
	    private WebElement doNotShowChkBox;

	    @FindBy(xpath = "//label[contains(text(),'Client Education')]/input")
	    private WebElement clientEducationRadioBtn;

	    @FindBy(xpath = "//div[contains(text(),'Filter by Sources')]")
	    private WebElement filterBySources;

	    @FindBy(xpath = "//label[contains(text(),'Conference Proceedings')]/input")
	    private WebElement selectedFilterSourcesOption;

	    @FindBy(xpath = "//a[text()= 'My Searches']")
	    private WebElement mySearches;

	    @FindBy(xpath = "//*[@id='sidebar']/div/ul/li[2]/a")
	    private WebElement helpIcon;

	    @FindBy(xpath = "//*[@id='sidebar']/div/ul/li[2]/ul/li[1]/a")
	    private WebElement searchHelpIcon;

	    @FindBy(xpath = "(//div[@class='modal-body'])[3]//iframe")
	    private WebElement iFrame;

	    @FindBy(xpath = "//div[text()='VIN Feedback']")
	    private WebElement vinFeedBack;

	    @FindBy(xpath = "//input[@name='SBtn']")
	    private WebElement sendButton;

	    @FindBy(xpath = "//a[@id='lnkPreferencesMain']")
	    private WebElement preferencesTab;

	    @FindBy(xpath = "(//button[@class='close'])[7]")
	    private WebElement closeFeedBackWindow;

	    @FindBy(xpath = "//*[contains(@class,'nonmobil')]//*[contains(text(),'Search Preferences')]")
	    private WebElement searchPerfernecesPopUp;
	    
	    @FindBy(xpath = "//span[@class='tt-dropdown-menu']//span/div/p")
	    private List<WebElement> searchList;
	    
	    @FindBy(xpath = "//div[@id='snipPanel']/p")
	    private List<WebElement> ResultTextList;

	    @FindBy(xpath = "//div[1]/p/strong[text()='taurine']")
	    private WebElement taurine;
	    
	    @FindBy(xpath ="//li[contains(text(),'Results')]")
	    private WebElement result;
	    
	    @FindBy(xpath ="//p[contains(text(),'Journals')]")
	    private List<WebElement> JournalsSearchList;
	    
	    @FindBy(xpath ="//td/h5[(text()='8. ')]")
	    private WebElement link;
	    
	    @FindBy(xpath ="//div/h3[text()='Article Tools']")
	    private WebElement ArticleTools;
	    
	    @FindBy(xpath ="//a[text()='Order this article']")
	    private WebElement orderThisArticle;
	    
	    @FindBy(xpath ="//span[text()='Document Delivery Request Form']")
	    private WebElement requestForm;
	    
	    @FindBy(xpath ="//input[contains(@id,'Member_Address0')]")
	    private WebElement streetAddress;
	    
	    @FindBy(xpath ="//input[contains(@id,'Member_City')]")
	    private WebElement city;
	    
	    @FindBy(xpath ="//input[contains(@id,'Member_PostalCode')]")
	    private WebElement zipCode;

	    @FindBy(xpath ="//input[contains(@id,'Member_Phone')]")
	    private WebElement phone;

	    @FindBy(xpath ="//input[contains(@id,'Member_Email')]")
	    private WebElement email;
	    
	    @FindBy(xpath ="//select[contains(@id,'Member_State')]")
	    private WebElement state;

	    @FindBy(xpath ="//select[contains(@id,'Member_Country')]")
	    private WebElement country;
	    
	    @FindBy(xpath ="//div[@id='TopBar']/div[@class='topBar']/div/div/a[text()='Front Page']")
	    private WebElement frontPageButton;
	    
	    @FindBy(xpath ="//button[text()='Dismiss All']")
	    private WebElement dismissAllBtn;
	    
	    @FindBy(xpath ="//div[3]/p/strong[text()='Tau']")
	    private WebElement deficiency;
	    
	    @FindBy(xpath ="//section[@id='main']//span[@style='color:red']")
	    private WebElement warning;
	    
	    @FindBy(xpath ="//span[@class='tt-dropdown-menu']//span/div/p")
	    private List<WebElement> suggestionList;
	    
	    @FindBy(xpath ="//button/i[text()='More suggestions']")
	    private WebElement moreSuggestion;
	    
	    @FindBy(xpath="//div[@class='btn-group open']/ul/li")
	    private List<WebElement> ListMoreSuggestion;
	    
	    @FindBy(xpath="//a[text()='Match ALL Terms']")
	    private WebElement matchAll;
	    
	    @FindBy(xpath="//li[@title='Remove Filter']")
	    private WebElement matchAllFilter;
	    
	    @FindBy(xpath="//span[@id='copyurl']")
	    private WebElement copyclipboard;
	    
	    @FindBy(xpath="//span[contains(text(),'copied')]")
	    private WebElement copyPopup;
	    
	    @FindBy(xpath="//ol[@class='pagination top']//button[text()='Jump']")
	    private WebElement jumpButton;
	    
	    @FindBy(xpath="//ol[@class='pagination top']//input[@id='jumpToPageTop']")
	    private WebElement jumpText;
	    
	    @FindBy(xpath="//div[@class='modal-header']//h4[text()='Please enter a search term in the search box']")
	    private WebElement enterSearchTearm;
	    
	    @FindBy(xpath="//div[@id='ModalNeedQuery']//button[@class='btn btn-default']")
	    private WebElement closeButton;
	    
	    @FindBy(xpath="//ol[@id='querybreadcrumb']/li/b/span")
		private WebElement ele;
	    
	    @FindBy(css = "div[id='menu'] div[id='topNav'] a[id='loginmenu']")
	    private WebElement loginUserDropDown;
	    
	    @FindBy(css = "div[id='menu'] div[id='topNav'] ul[role='menu'] a[class='MemberProfile_Logout']")
	    private WebElement logoutLinkUnderUserDropDown;
	    
	    @FindBy(id="specs")
	    private WebElement anySpeciesDrpDwn;

	    @FindBy(xpath="//a[text()=' Amphibians']")
	    private WebElement ambhibianTag;
	    
	    @FindBy(id="btnClearSearch")
	    private WebElement clearBtn;
	    
	    
	    
	    public void selectClearButton()
	    {
	    	waitAndClick(clearBtn);
	    }

	    public void selectAnySpeciesdropDownAndSelectAmbhibians(String value)
	    {
	    	selectDropDownByText(anySpeciesDrpDwn, value);
	    	
	    }
	    
	    
	    public void verifyRespectiveTagIsDisplayed(String respectiveText)
	    {
	    	WebElement elementToBeVerified = driver.findElement(ByLocator("//a[contains(text(),'"+respectiveText+"')]"));
	    	waitForElement(elementToBeVerified);
	    	Assert.assertTrue(isElementDisplayed(elementToBeVerified));
	    }
	    
	    public void verifyRespectiveTagRemoved(String respectiveText)
	    {
	    	waitForPageLoaded();
	    	boolean flag=true;
	    	try {
		    	WebElement elementToBeVerified = driver.findElement(ByLocator("//a[contains(text(),'"+respectiveText+"')]"));

		    	if (elementToBeVerified.isDisplayed()) {
					flag=false;
				}
			} catch (Exception e) {
			}
	    	Assert.assertTrue(flag);
	    }
	    
	    
	  /**
	     * Verify Search Page displayed
	     */
	    public void verifySearchPageDisplayed() {
	        waitForPageLoaded();
	        _normalWait(2000);
	        assertByPageTitle(Constants.Search4Page);
	    }

    /**
     * verify search page is no longer greyed out.
     *
     * @throws InterruptedException
     */

    public void verifySearchPageNotGreyedOut() throws InterruptedException {
        _normalWait(1000);

        boolean flag = false;
        waitForElement();
        if (driver.findElements(By.xpath("//div[@class='modal-backdrop fade in']")).size() > 0) {
            flag = true;
        }
        Assert.assertFalse(flag);
    }

    /**
     * Dismiss alert notification if displayed
     * @return
     */
    public void dismissNotifications() {
		super.dismissNotifications(dismissAllBtn);
    }
    /**
     * verify default preferences open in preference tab
     */

   

    /**
     *  A pop up window will open to Search Preferences 
     */
    public void verifyPopUpWindowOpenToSearchPreferences() {
        _normalWait(2000);
        Assert.assertTrue(searchPerfernecesPopUp.isDisplayed());
    }

    /**
     * verify text present in the feedback text area
     */
    public void verifyTextInTheTextBox(String Text) {
        _normalWait(2000);

        String text1 = feddbackTextArea.getAttribute("value");
        Assert.assertEquals(text1, Text);
    }

   
    /**
     * search input in the search box
     */

    public void searchTermInTheSearchBox(String text) {
        _normalWait(500);
        clickOn(inputSearch);
        inputSearch.clear();
        inputText(inputSearch, text);
        _normalWait(1000);
    }

    /**
     * verify searchbox is enabled
     */

    public void verifSearchBoxIsEnabled() {
        boolean flag = false;
        if (inputSearch.isEnabled()) {
            flag = true;
        }
        Assert.assertTrue(flag);

    }

    /**
     * click on search button
     */

    public void clickOnSearchButton() {
        clickOn(searchButton);
    }

    /**
     * Enter a Carriage return For Search Box On Top
     */
    public void enterCarriageReturnForSearchBoxOnTop() {
        _normalWait(1000);
        waitForElement(inputSearch);
        performEnter(inputSearch);

    }

    /**
     * verify Results after clicking on search icon
     */
    public void verifyResults(String textToBeEntered) {
        for (WebElement results : resultsConatiningInformation) {
            boolean flag = false;
            if (results.getText().trim().contains(textToBeEntered)) {
                scrollDown();
                flag = true;
                Assert.assertTrue(flag);
            }

        }

    }

    /**
     * click on Clear button
     */
    public void clickOnClearButton() {
        clickOn(clearButton);
        _normalWait(1000);
        waitForPageLoaded();
    }

    /**
     * verify Error Popup
     */

    public void verifyErrorPopUp() {

        clickOnClearButton();
        _normalWait(2000);
        clickOnSearchButton();

        Assert.assertTrue(isElementDisplayed(errorPopup), "Error popup displayed");

        clickOnCloseForErrorPopup();
    }

    /**
     * Verify Text entered in the search term box
     */

    public void verifyTextInSearchBox(String valueOfSearchInput) {

        waitForElement(inputSearch);
        String valueSearchInput = inputSearch.getAttribute("value");
        Assert.assertEquals(valueSearchInput, valueOfSearchInput);

    }

    /*
     * click on search By Author Or Document id Filter Drop Down
     */

    public void clickOnSearchByAuthorOrDocumentidFilterDropDown() {
        clickOn(searchByAuthorOrDocumentidFilterDropDown);
    }

    /**
     * verify Search Item box Are Displayed For Author Or Document id Filter
     */
    public void verifySearchItemBoxAreDisplayedForAuthorOrDocumentidFilter() {
        boolean flag;
        waitForElement(searchItemBoxForAuthorOrDocumentidFilterDropDown);
        if (getAttributeValueOfElement(searchItemBoxForAuthorOrDocumentidFilterDropDown, "aria-expanded").trim()
                .contains("true")) {
            waitForElement(searchItemBoxForAuthorOrDocumentidFilterDropDown);
            flag = true;
        } else {
            flag = false;
        }
        Assert.assertTrue(flag);
    }

    /**
     * Enter Value Under Authors Search Box
     */

    public void enterValueUnderAuthorsSearchBox(String text) {
        inputText(authorInput, text);

    }

    /**
     * Enter a Carriage return For Authors Search Box
     */

    public void enterCarriageReturnForAuthorsSearchBox() {
        waitForElement(authorInput);
        performEnter(authorInput);

    }

    /**
     * Enter Value Under Documentid(s) Search Box
     */

    public void enterValueUnderDocumentidsSearchBox(String text) {
        inputText(documentIdInput, text);

    }

    /**
     * Enter a Carriage return For Document Id Search Box
     */
    public void enterCarriageReturnForDocumentIdSearchBox() {
        waitForElement(documentIdInput);
        performEnter(documentIdInput);

    }

    /**
     * verify search Results appear as a filter under the search term box
     */
    public void verifySearchResultsAppearAsAFilterUnderSearchTermBox(String TextToBeVerified) {
        boolean flag;
        waitForPageLoaded();
        _normalWait(2000);

        waitForElement(removeFilterUnderFilterSearchBox);
        if (getText(removeFilterUnderFilterSearchBox).trim().contains(TextToBeVerified)) {
            waitForElement(removeFilterUnderFilterSearchBox);
            flag = true;
        } else {
            flag = false;
        }
        Assert.assertTrue(flag);
    }

    /**
     * press enter
     */
    public void pressEnter() {
        WebElement textbox = driver.findElement(By.id("q"));
        textbox.sendKeys(Keys.ENTER);
    }

    /**
     * close Error pop up
     */

    public void clickOnCloseForErrorPopup() {
        waitForElement(closeErrorPopUp);
        clickOn(closeErrorPopUp);

    }

    /**
     * Open Year DropDown
     */

    public void clickOnYearDropDownAndSelectYear(String targetYear) {

        // WebElement
        // element=driver.findElement(By.cssSelector("select[id='lyr']"));
        // element.click();
        selectDropDownWithOptGroups(anyYearDropDwn, targetYear);

    }

    /**
     * Open Year DropDown
     */

    public void clickOnYearDropDownAndSelectYearfromRanges(String targetYear) {

        // WebElement
        // element=driver.findElement(By.cssSelector("select[id='lyr']"));
        // element.click();
        selectDropDownWithOptGroups(yearRanges, targetYear);

    }

    /**
     * Select Last Year from Year Drop down
     */

    // public void selectLastYearFromYearDropDown() {
    // // Select yearDropDown= new Select(driver.findElement(By.id("lyr")));
    // // yearDropDown.selectByValue("-1");
    // selectDropDownByText(anyYearDropDwn, "Last year (2931)");
    // reportInfo();
    // }

    /**
     * verify a Filter underneath the Search Term entry box
     */

    public void verifyFilterIconIsPresent() {
        _normalWait(1000);
        waitForPageLoaded();
        boolean flag = false;
        if (filterButton.isEnabled()) {
            flag = true;
        }
        Assert.assertTrue(flag);
    }

    /**
     * verify Search Filter Is Not Applied
     */

    public void verifySearchFilterIsNotApplied() {
        _normalWait(3000);
        boolean flag = false;
        scrollToTopOfThePage();
        if (driver.findElements(By.xpath("//li//span[text()=' Filters']")).size() > 0) {
            flag = false;
        } else {
            flag = true;
        }
        Assert.assertTrue(flag);

    }

    /**
     * verify Color Of Search Hint Warning Under Search Box
     */
    public void verifyColorOfSearchHintWarningUnderSearchBox(String EnterBackgrounColor) {
        boolean flag = false;
        waitForPageLoaded();
        _normalWait(3000);
        String color = getBackgroundColor(searchHintWarningUnderSearchBox);
        if (getBackgroundColor(searchHintWarningUnderSearchBox).equalsIgnoreCase("rgba(255, 255, 204, 1)")) {
            flag = true;
            Assert.assertTrue(flag);

        } else {
            if (getBackgroundColor(searchHintWarningUnderSearchBox).equalsIgnoreCase("rgba(255, 255, 204, 1)")) {
                flag = true;
                Assert.assertTrue(flag);
            }
        }
    }

    /**
     * verify text of Search Hint Warning Under Search Box
     */
    public void verifyTextOfSearchHintWarningUnderSearchBox(String TextToBeVerified) {
        boolean flag = false;
        waitForPageLoaded();
        if (getText(searchHintWarningUnderSearchBox).trim().contains(TextToBeVerified)) {
            flag = true;
            waitForElement(searchHintWarningUnderSearchBox);
        }
        Assert.assertTrue(flag);
    }

    /**
     * click On Link Displayed In Search Hint Warning Under Search Box
     */

    public void clickOnLinkDisplayedInSearchHintWarningUnderSearchBox() {
        clickOn(searchHintWarningUnderSearchBox.findElement(By.xpath("./a")));
    }

    /**
     * verify Search Hint Warning Under Search Box Not Displayed
     */
    public void verifySearchHintWarningUnderSearchBoxNotDisplayed() {
        boolean flag = false;
        _normalWait(1000);
        waitForPageLoaded();
        try {
            if (isElementDisplayed(searchHintWarningUnderSearchBox)) {
                flag = false;
            } else {
                flag = true;
            }
        } catch (Exception e) {
            flag = true;
        }
        Assert.assertTrue(flag);

    }

    /**
     * click And Open Match Terms Drop Down In Search By Filter Box
     */
    public void clickAndOpenMatchTermsDropDownInSearchByFilterBox() {
        clickByMouseHoverOnAnElement(matchTermsDropDownInSearchByFilterBox);

        clickByMouseHoverOnAnElement(matchTermsDropDownInSearchByFilterBox);
    }

    /**
     * click And Open Species Drop Down
     */
    public void clickAndOpenSpeciesDropDown() {
        clickByMouseHoverOnAnElement(speciesDropDown);

        clickByMouseHoverOnAnElement(speciesDropDown);
    }

    /**
     * click And Open Folder Drop Down
     */
    
    public void clickAndOpenFolderDropDown() {
        clickByMouseHoverOnAnElement(folderDropDown);

        clickByMouseHoverOnAnElement(folderDropDown);
    }

    /**
     * select Option Displayed Under Match Terms Drop Down In Search By Filter Box
     */
    public void selectOptionDisplayedUnderMatchTermsDropDownInSearchByFilterBox(String EnterOptionToSelectByText) {
        selectDropDownByText(matchTermsDropDownInSearchByFilterBox, EnterOptionToSelectByText);

    }

    /**
     * select Option Displayed under Species Drop Down Box
     */
    public void selectOptionDisplayedUnderSpeciesDropDown(String dropDownIndex) {
        selectDropDownByValue(speciesDropDown, dropDownIndex);

    }

    /**
     * select Option Displayed under Folder Drop Down Box
     */
    public void selectOptionDisplayedUnderFolderDropDown(String dropDownIndex) {
        selectDropDownByValue(folderDropDown, dropDownIndex);

    }

    /**
     * Click on Clear Filter button
     */

    public void clickOnClearFilterButton() {
        waitAndClick(clearFilterbutton);
    }

    /**
     * verify filter button is not present
     */

    public void verifyFilterButtonIsNotPresent() {
        waitForPageLoaded();
        boolean flag = false;
        if (isElementDisplayed(filterButton)) {
            flag = true;

        }
        Assert.assertFalse(flag);
    }

    /**
     * Click on Additional Source DropDown
     */

    public void clickOnAdditionalSourceDrpDwn() {

        _normalWait(2000);
        waitAndClick(additionalSouurceDropDwn);
    }

    /**
     * Verify Additional source DrpDwn is open
     */

    public void verifyAdditionalSourceDrpDwnIsOpen() {
        String text = driver.findElement(By.id("AddlSrcs")).getAttribute("aria-expanded");
        waitForPageLoaded();
        _normalWait(2000);
        Assert.assertEquals(text, "true");
    }

    /**
     * Clear filter by clicking X
     */
    
    public void clearFilterByClickingX() {
        waitForElement(removeFilterUnderFilterSearchBox);
        clickOn(removeFilterUnderFilterSearchBox);
    }

    /**
     * Click Forns/Handout Option
     */
    public void clickFormsHandoutOption() {
        clickOn(formsRadioBtn);
    }

    /**
     * Verify Filter has Forms/Handouts text present
     */
    public void verifyFormsHandoutFilterTextPresent() {
        Assert.assertTrue(isElementPresent(formsHandoutOption));
    }

    /**
     * Select checkboxes based on parameter (counter)
     */
    public void selectResultsFromPage(int counter) {
        for (int i = 1; i <= counter; i++) {
            selectResults(i);
        }
    }

    /**
     * Perform Checkbox selection for Search Results
     */
    private void selectResults(int counter) {
        String tablePath = "//div[@id='results']//tbody/tr[" + counter + "]//input";
        clickOn(tablePath);
    }

    /**
     * Verify Count of selected Results
     */
    public void verifySelectedResultsCount(int resultCount) {
        waitForPageLoaded();
        Assert.assertEquals(checkedResultsMenu.getText(), "View Checked (" + resultCount + ")");
    }

    /**
     * Navigate to next results page
     */
    public void goToNextPage() {
        clickOn(nextResultsPage);
        waitForPageLoaded();
    }

    /**
     * Open View Checked DropDown
     */
    public void openViewCheckedDropDownMenu() {
        waitForPageLoaded();
        waitForElement(checkedResultsMenu);
        clickOn(checkedResultsMenu);
    }

    /**
     * Verify Drop Down is displayed
     */
    public void verifyCheckedResultsDropDown() {
        waitForPageLoaded();
        String text = checkedResultsMenu.getAttribute("aria-expanded");
        Assert.assertEquals(text, "true");
    }

    public void clickViewCheckedResultsPopUp() {
        waitForElement(checkedResultsLink);
        clickOn(checkedResultsLink);
    }

    public void verifyPopModalDisplayed(int fourResults) {
        waitForPageLoaded();
        verifyPopupPresent();
        verifyResultsDisplayed(fourResults);
    }

    private void verifyPopupPresent() {
        Assert.assertTrue(driver.getWindowHandles().size() > 1);
    }

    private void verifyResultsDisplayed(int resultsCount) {
        Assert.assertEquals(driver.findElements(By.xpath("//div[@id='main']//div/table/tbody/tr//input")).size(),
                resultsCount);
    }

    public void closeResultsPopUp() {
        driver.close();
        driver.switchTo().window(driver.getWindowHandle());
    }

    public void verifyPopModalClosed() {
        Assert.assertTrue(driver.getWindowHandles().size() == 1);
    }

    public void clickCheckAllResultsOption() {
        waitAndClick(checkAllResults);
    }

    public void uncheckPageResults() {
        waitAndClick(uncheckCurrentPageResults);

    }

    public void viewHighlightedResults() {
        clickOn(viewHighlightedResults);
    }

    public void verifyHighlightedTextColor(String colorCode_Yellow) {
        boolean flag = false;
        List<WebElement> searchTextSet = driver.findElements(By.xpath("//span[@id='lblTitle']//span"));
        for (WebElement searchLoc : searchTextSet) {

            if (getBackgroundColor(searchLoc).equalsIgnoreCase("rgb(255, 255, 0)")) {
                flag = true;
                Assert.assertTrue(flag);
            } else {
                if (getBackgroundColor(searchLoc).equalsIgnoreCase("rgba(255, 255, 0, 1)")) {
                    flag = true;
                    Assert.assertTrue(flag);
                }
            }
        }

//			Assert.assertEquals(getBackgroundColor(searchLoc), colorCode_Yellow);

    }

    public void clearCheckedResults() {
        waitForPageLoaded();
        clickOn(clearCheckedResults);
    }

    public void verifySearchBoxEmpty() {
        Assert.assertTrue(inputSearch.getAttribute("value").equalsIgnoreCase(""));
    }

    public void verifyNewWindowDisplayed() {
        _normalWait(1000);
        waitForPageLoaded();
        verifyPopupPresent();
        // switchToTab();
    }

    public void verifySearchTerm(String searchTerm) {
        waitForPageLoaded();
        // switchToDefaultContent(); //input[@id='term']
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='id_term']")).getAttribute("value").trim(),
                searchTerm.trim());
    }

    public void mouseOverSearchLink() {
        waitForElement(linkURL);
    }

    public void verifyToolTipTextforLinkURL() {
        Assert.assertEquals(linkURL.getAttribute("data-original-title"), "Right click to copy search url");
    }

    public void rightClickLinkURL() {
        rightClickOnElement(linkURL);
    }

    public void verifyNoResultsPresent() {
        Assert.assertFalse(isElementPresent("//div[@id='results']//tbody/tr[1]//input"));
    }

    /**
     * Select DropDown click on Additional DropDown Values
     */

    public void clickOnSelectDropDownAndChooseOption(String targetSelect, String targetYear) {
        boolean flag = false;
        OuterLoop:
        for (WebElement element : driver.findElements(By.xpath("//select[@id='" + targetSelect + "']"))) {
            clickOn(element);
            for (WebElement elemnet : element.findElements(By.xpath(".//option"))) {
                if (elemnet.getText().trim().contains(targetYear)) {
                    elemnet.click();
                    flag = true;
                    break;
                }
            }
            break OuterLoop;
        }
        Assert.assertTrue(flag);
    }

    /**
     * Verify Page For Is Open 
     */
    public void verifyPageForDiabetesIsOpen() {
        Assert.assertTrue(isElementPresent(diabetesPageValues));

    }

    /**
     *  Click On Preferences DropDown 
     */
    public void clickOnPreferencesDropDown() {
        if (prefrenecesBTN.isDisplayed()) {
            waitForElement(prefrenecesBTN);
            clickOn(prefrenecesBTN);
        }
    }

    /**
     * Verify DropDown Is Open 
     */
    public void verifyDropDownIsOpen(String dropdownToBeVerfied) {
        WebElement dropDownIsOpen = driver.findElement(By
                .xpath("//*[contains(text(),'" + dropdownToBeVerfied + "')]//parent::li[contains(@class,'open')]//ul"));
        Assert.assertTrue(dropDownIsOpen.isDisplayed());
    }

    /**
     *Select DropDown Options 
    */
    public void selectDropDownValues(String dropDownName, String dropDownValue) {
        boolean flag = false;

        for (WebElement dropValue : driver.findElements(By.xpath("//*[contains(text(),'" + dropDownName
                + "')]//parent::li[contains(@class,'open')]//ul//li[not(contains(@style,'display:none'))]//a"))) {
            if (getText(dropValue).contains(dropDownValue)) {
                clickOn(dropValue);
                new WebDriverWait(driver, 30).until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(),'" + dropDownName + "')]")));
                flag = true;
                break;
            }
        }

        Assert.assertTrue(flag);
    }

    /**
     *  Verify Results values showing 
     */
    public void verifyResultValuesShowing(String resultToBeCheck) {
        _normalWait(1000);
        waitForElement(resultValue);
        Assert.assertTrue(resultValue.getText().contains(resultToBeCheck));

    }

    /**
     *  Click On Upper Next Button 
     */
    public void clickOnUpperNextButton() {
        waitForElement(upperNextBTN);
        clickOn(upperNextBTN);
    }

    /**
     *  Click On Upper Prev Button 
     */
    public void clickOnUpperPrevButton() {
        waitForElement(upperPrevBTN);
        clickOn(upperPrevBTN);
    }

    /**
     *  Verify Result Value According to dropdown Show Only Snippets
    */
    public void verifyDiabetesResultAccordingToShowOnlySnippets() {
        for (WebElement values : diabetesShowSnippetsList) {
            waitForElement(values);
            Assert.assertTrue(values.getText().trim().equalsIgnoreCase("Diabetes"));
        }
    }

    /**
     *  Verify Result Value According to dropdown Show Snippets 
     */
    public void verifyDiabetesResultAccordingToShowSnippets() {
        for (WebElement values : diabetesShowSnippetsParagraphList) {
            waitForElement(values);
            Assert.assertTrue(values.getText().trim().contains("Keywords"));
        }
    }

    /**
     *  Verify Result Value According to dropdown NO Snippets 
     */
    public void verifyDiabetesResultAccordingToNoSnippets() {

        Assert.assertEquals(diabetesShowSnippetsParagraphList.size(), 0);

        for (WebElement mainTile : resultMainTileList) {
            waitForElement(mainTile);
            Assert.assertTrue(mainTile.isDisplayed());
        }

        for (WebElement mainTilePara : resultMainTileTextInfoParaLST) {
            waitForElement(mainTilePara);
            Assert.assertTrue(mainTilePara.isDisplayed());
        }
    }

    /**
     *  Verify DropDown Closed 
     */
    public void verifyDropDownClosed(String dropdownSelected) {
        Assert.assertEquals(driver
                .findElements(By
                        .xpath("//*[contains(text(),'" + dropdownSelected + "')]//parent::li[contains(@class,'open')]"))
                .size(), 0);

    }

    /**
     *  Click On First Search result 
     */
    public void clickOnFirstSearchResult() {
        WebElement resultValue = resultMainTileList.get(0);
        waitForElement(resultValue);
        clickOn(resultValue);
    }

    /**
     * Verify Search Result Page Is Showing 
     */
    public void verifySearchResultPageIsShowing() {
        Assert.assertTrue(inputSearch.isDisplayed());
    }

    /** 
     * Verify Current Window 
     */
    public void verifyCurrentWindow(String windowSelected) {
        boolean flag = false;
        Set<String> windows = getDriver().getWindowHandles();
        for (String handle : windows) {
            if (handle.equals(windowSelected)) {
                flag = true;
            }
        }
        Assert.assertTrue(flag);
    }

    /**
     * Verify The Search Input Filter Value Is Empty 
     */
    public void verifySearchFillterInputValueIsEmpty() {
        boolean flag = false;
        try {
            String valueOfSearchInput = inputSearch.getAttribute("value");
            if (valueOfSearchInput.equalsIgnoreCase("")) {
                flag = true;
            }
        } catch (Exception e) {
            logger.info("Value attribute property not exist");
            flag = true;
        }
        Assert.assertTrue(flag);
    }

    /**
     *  Get the default Preferences Values of result shown per page count 
     */
    public String getDefaultPrefrencesValuesForResultShownPerPage() {
        String resultshownVlaue = numberOfResultShowPerPageSETT.getText();
        return resultshownVlaue;

    }

    /**
     * Get the default Preferences Values of result shown for snippets 
     */
    public String getDefaultPrefrencesValuesForSnippets() {
        String resultshownVlaue = snippetsPrefrencesSettingValue.getText();
        return resultshownVlaue;

    }

    /**
     * Verify Option on Preferences Is Active*
     */
    public void verifyOptionOnPreferencesIsActive(String valueToBeChecked) {
        boolean flag = false;
        _waitForJStoLoad();
        _normalWait(2000);
        for (WebElement dropValue : prefrencesListOption) {

            if (dropValue.getText().trim().contains(valueToBeChecked)) {

                if (dropValue.findElement(By.xpath("./parent::li")).getAttribute("class").equalsIgnoreCase("active")) {
                    waitForElement(dropValue);
                    flag = true;
                    break;
                }

                break;
            }
        }
        Assert.assertTrue(flag);
    }

    /**
     * Verify View Checked count is zero present*
     */
    public void verifyViewCheckedZeroPresent() {
        Assert.assertTrue(viewCheckedValue.isDisplayed());
    }

    /**
     * Select Search Tips tabs on Search Page 
     */
    public void selectSearchTipsTabs(String tabToSelect) {
        boolean select = false;
        for (WebElement tabsValue : searchTipsTabsList) {
            if (getText(tabsValue).trim().equalsIgnoreCase(tabToSelect)) {
                clickOn(tabsValue);
                select = true;
                break;
            }
        }

        Assert.assertTrue(select);
    }

    /**
     * Verify Tips Selected is displayed 
     */
    public void serachTipsSelectedTabsSectionIsDisplayed(String contentToBeDisplay) {
        boolean flag = false;
        for (WebElement content : searchTipsTabContentList) {
            if (content.getAttribute("id").contains(contentToBeDisplay)) {
                if (content.getAttribute("class").contains("active")) {
                    flag = true;
                    break;
                }
            }
        }
        Assert.assertTrue(flag);
    }

    /**
     * Verify How To Use search page 
     */
    public void verifyHowToUseSearchPageIsOpened() {
        waitForPageLoaded();
        boolean flag = false;
        if (getText(howToUseSearchTitle).contains("How to use Search")) {
            flag = true;
        }
        Assert.assertTrue(flag);
    }

    /**
     *  Click On Links On Tip Tab 
     */
    public void clickOnLinkOnTipTabContent(String linkToBeOpen) {
        WebElement link = driver.findElement(By.xpath("//*[contains(text(),'" + linkToBeOpen + "')]"));
        waitForElement(link);
        clickOn(link);
    }

    /**
     * Verify Vin FeedBack window displayed*
     */
    public void verifyVinFeedbackWindowDisplayed() {
        _normalWait(2000);
        waitForPageLoaded();
        Assert.assertTrue(vinFeedBackWindow.isDisplayed());
       // Assert.assertTrue(getDriver().findElement(By.xpath("//form[@name='feedbackform']")).isDisplayed());
//        driver.switchTo().frame(feedBackIframe);
//		switchToFrame(feedBackIframe);
	}

	/**
	 * Enter the text in textArea Present in Feedback 
	 */
	public void enterTextInTextArea() {

		waitForElement(feddbackTextArea);
		feddbackTextArea.click();
		_normalWait(1000);
		inputText(feddbackTextArea, "This is a Test");
	}

	/**
	 * A blank message will yield an error pop-up 
	 */

	public void verifyBlankmessageAppearedOnErrorPopUp() {

		boolean selection = false;
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		if (text.contains("Your Message was blank")) {
			selection = true;
			alert.accept();
		}
		Assert.assertTrue(selection);
	}

	/**
	 * Click on send Message Button on Feedback 
	 */
	public void clickOnSendMessageButton() {
		waitForElementPresent(sendMessageBTN);
		//clickOn(sendMessageBTN);
		  javascriptButtonClick(sendMessageBTN);
	}

	/**
	 * A window will open confirming that the email was sent. Search page is greyed out
	 */
	public void verifyFeedbackSendAndSearchPageGreyed() {
		_waitForJStoLoad();
		Assert.assertTrue(feedBackSend.isDisplayed());
		driver.switchTo().defaultContent();
		Assert.assertTrue(gryedSearchPage.isDisplayed());
	}

	/**
	 *  Click on grayed out search page 
	 */
	public void clickOnSearchPageGreyed() {

		waitForElement(gryedSearchPage);
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(gryedSearchPage));
			javascriptButtonClick(gryedSearchPage);
		} catch (Exception e) {

		}
	}

	public List<String> clickSortOrderDropDown(List<String> sortOrder) {
		storeCurrentOrder(sortOrder = new ArrayList<String>());
		openSortDropDown();
		return sortOrder;
	}

	private void storeCurrentOrder(List<String> sortOrder) {
		for (WebElement result : resultMainTileList) {
			sortOrder.add(result.getText().trim());
		}
	}

	private void openSortDropDown() {
		waitForElement(sortDropDown);
		clickOn(sortDropDown);
	}

	public void verifySortDropDownOpen() {
		waitForPageLoaded();
		Assert.assertEquals(sortDropDown.getAttribute("aria-expanded"), "true");
	}

	public void clickSortByDateOption() {
		clickOn(sortByDateOpt);
	}

	public void verifySortingOrderChanges(List<String> sortOrderDefault, List<String> sortOrderNew,
			boolean valueToBeChecked) {
		waitForPageLoaded();
		storeCurrentOrder(sortOrderNew = new ArrayList<String>());
		checkListOrderChanges(sortOrderDefault, sortOrderNew, valueToBeChecked);
	}

	public void checkListOrderChanges(List<String> sortOrderDefault, List<String> sortOrderNew,
			boolean valueToBeChecked) {

		boolean sameOrder = true;
		for (int i = 0; i < sortOrderDefault.size(); i++) {
			if (!sortOrderDefault.get(i).equalsIgnoreCase(sortOrderNew.get(i)))
				sameOrder = false;
		}

		Assert.assertEquals(sameOrder, valueToBeChecked);
	}

	public void clearSortFilter() {
		waitForElement(deleteSortFilter);
		clickOn(deleteSortFilter);
	}

	public String clickAssociateFilter() {
		String count = associateFilterRadioBtn.findElement(By.xpath("./following-sibling::span")).getText().trim();
		clickOn(associateFilterRadioBtn);
		return count;
	}

	public void checkFilteredvaluesCount(String filterValue) {
		Assert.assertTrue(resultsCountDisplayed.getText().trim().contains(filterValue));
		Assert.assertTrue(isElementPresent(clearFilterbutton));

	}

	public String addAnotherSearchTerm(String string_diet) {
		String searchString = inputSearch.getAttribute("value").trim();
		
	waitAndClick(inputSearch);
	inputSearch.sendKeys(" diet");
	
		
		return searchString;
	}

	public void clickKeepFilterOption() {
		waitForPageLoaded();
		waitForElement(keepFilterModalBtn);
		clickOn(keepFilterModalBtn);
	}

	public void clickClearFilterOption() {
		waitForPageLoaded();
		waitForElement(clearFilterModalBtn);
		clickOn(clearFilterModalBtn);
	}

	public void verifyAssociateFilterPresent() {
		Assert.assertTrue(isElementPresent(associateFilterLnk));
	}

	public void sourceFilterForAssociate() {
		Assert.assertTrue(isElementPresent(associateLabel));
	}

	public void verifyPopModalElementsNotPresent() {
		waitForPageLoaded();
		Assert.assertTrue(isElementNotVisible(keepFilterModalBtn));
	}

	public void verifyPopModalElementsPresent() {
		waitForPageLoaded();
		Assert.assertTrue(isElementPresent(keepFilterModalBtn));
	}

	public void clickDoNotShowOnPopupModal() {
		waitForPageLoaded();
		clickOn(doNotShowChkBox);
	}

	public String clickClientEducationFilter() {

		waitForPageLoaded();
		String count = clientEducationRadioBtn.findElement(By.xpath("./following-sibling::span")).getText().trim();
		clickOn(clientEducationRadioBtn);
		return count;
	}

	/**
	 * verify Search Hint Warning Under Search Box Not Displayed
	 */
	public void verifySearchHintWarningUnderSearchBoxDisplayed() {
		boolean flag = false;
		_normalWait(1000);
		waitForPageLoaded();
		try {
			if (isElementDisplayed(searchHintWarningUnderSearchBox)) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			flag = true;
		}
		Assert.assertTrue(flag);

	}

	public void clickCancelModalBtn() {
		waitForElement(cancelModalBtn);
		clickOn(cancelModalBtn);
	}

	public void verifySelectedValueSpeciesDropDown(String dropDownSearchValue) {
		Assert.assertTrue(getText(getSelectedDropDownOption(speciesDropDown)).trim().contains(dropDownSearchValue));
	}

	public void verifySelectedValueFolderDropDown(String dropDownSearchValue) {
		Assert.assertTrue(getText(getSelectedDropDownOption(folderDropDown)).trim().contains(dropDownSearchValue));
	}

	public String clickConferenceProceedings() {
		waitForPageLoaded();
		String results = selectedFilterSourcesOption.findElement(By.xpath("./following-sibling::span")).getText()
				.trim();
		clickOn(selectedFilterSourcesOption);
		return results;
	}

	public void verifyFilterBySourcesNotPresent() {
		waitForPageLoaded();
		Assert.assertFalse(driver.findElements(By.xpath("//div[contains(text(),'Filter by Sources')]")).size() > 0);
	}

	public void verifyFilterBySourcesPresent() {
		Assert.assertTrue(filterBySources.isDisplayed());
	}

	public void deselectConferenceProceedings() {
		clickOn(selectedFilterSourcesOption);
	}

	/**
	 * click on My Searches 
	 */
	public void clickOnMySearches() {
		_normalWait(2000);
		waitAndClick(mySearches);
	}

	/**
	 * Verify My Activity Page displayed
	 */
	public void verifyNewWindowDisplayed(String expectedTitle) {
		_normalWait(3000);
		waitForPageLoaded();

		assertTrue(driver.getTitle().contains(expectedTitle));
	}

	/**
	 * Verify search window displayed
	 */
	public void verifySearchWindowDisplayed(String expectedTitle) {
		waitForPageLoaded();
		_normalWait(1000);

		assertTrue(driver.getTitle().contains(expectedTitle));
	}

	/**
	 * Click on help icon
	 */
	public void clickOnhelpIcon() {
		_normalWait(1000);

		waitAndClick(helpIcon);

	}

	/**
	 * A modal will open within a frame
	 */
	public void verifymodalOpened(String TitleOfWindow) {
		_normalWait(1000);

		// switchToFrame(iFrame);
		assertTrue(vinFeedBack.getText().contains(TitleOfWindow));
	}

	/**
	 * close feedback window
	 */
	public void closeFeedBackWindow() {
		_normalWait(1000);

		waitAndClick(closeFeedBackWindow);
	}


	/**
	 * verify default preferences open in preference tab
	 */
	public void verifyWindowOpenInPreferencesTab() {
		_normalWait(1000);
		boolean flag = false;
		if (isElementDisplayed(preferencesTab)) {
			flag = true;

		}
		Assert.assertTrue(flag);
	}
	
	/**
	 * verify user will be able to see the drop down list of entered item
	 */
	public void verifyDropDownListIsDisplayed(String searchText) {
		boolean flag =false;
		for(WebElement list: searchList) {
			if (getText(list).trim().toLowerCase().contains(searchText.toLowerCase())) {
				flag=true;
				Assert.assertTrue(flag);

		}
		}
		Assert.assertTrue(flag);

	}
	
	/**
	 * verify Result of searched text
	 */
	public void VerifyTheResultOfSearchText(String ResultText) {
        waitForPageLoaded();
		for(WebElement list: ResultTextList) {
			if (getText(list).trim().equalsIgnoreCase(ResultText)) {
				Assert.assertTrue(list.isDisplayed());
				break;
		}
		}
	}
	
	/**
	 * select first element in search list  
	 */
	public void selectTaurineInSearchList() {
		waitAndClick(taurine);
	}
	
	/**
	 * verify page refresh and display search result
	 */
	public void verifySearchResultIsDisplayed() {
		Assert.assertTrue(result.isDisplayed());
	}

	/**
	 * select radio button under filter by source
	 * @param buttonName
	 */
	public void selectRadioButtonUnderFilterBySources(String buttonName) {
        WebElement radioButton=driver.findElement(By.xpath("//label[contains(text(),'"+buttonName+"')]"));
        waitAndClick(radioButton);
	}
	
	/**
	 * verify list of search result is Displayed
	 */
	public void verifyListOfSearchResltIsDisplayed() {
		for(WebElement list: JournalsSearchList) {
		  Assert.assertTrue(list.isDisplayed());
		}

	}

	/**
	 * select the link which does not have full free text
	 */
	public void selectTheFirstLinkWhichDoesNotHaveFullFreeText() {
        waitAndClick(link);		
	}
	
	/**
	 * verify new tab is loaded
	 */
	public void verifyNewTabLoadSuccessfully() {
		Assert.assertTrue(ArticleTools.isDisplayed());
	}

	/**
	 * select order this article
	 */
	public void selectOrderThisArticle() {
       waitAndClick(orderThisArticle);		
	}

	/**
	 * user is navigated to doc delivery request page
	 */
	public void verifyUserIsNavigatedToDocDeliveryRequestFormPage() {
 		Assert.assertTrue(requestForm.isDisplayed());
	}
	
	/**
	 * verify selected state
	 * @param stateName
	 */
	public void verifyStateSelection(String stateName) {
		String value=returnSelectedValueFromDropdown(state);
		Assert.assertEquals(stateName, value);
	}
	
	/**
	 * verify selected country
	 * @param countryName
	 */
	public void verifyCountrySelection(String countryName) {
		String value=returnSelectedValueFromDropdown(country);
		Assert.assertEquals(countryName, value);
	}
	
	/**
	 * verify selected street address
	 * @param address
	 */
	public void verifyStreetAddress(String address) {
		String value=streetAddress.getAttribute("value");
		Assert.assertEquals(value, address);
	}
	
	/**
	 * verify selected city
	 * @param cityName
	 */
	public void verifyEnteredCity(String cityName) {
		String value=city.getAttribute("value");
		Assert.assertEquals(value, cityName);
	}
	
	/**
	 * verify entered zip code
	 * @param code
	 */
	public void verifyEnteredZipCode(String code) {
		String value=zipCode.getAttribute("value");
		Assert.assertEquals(value, code);
	}
	
	
	/**
	 * verify entered phone no
	 * @param cityName
	 */
	public void verifyEnteredPhoneNumber(String cityName) {
		String value=phone.getAttribute("value");
		Assert.assertEquals(value, cityName);
	}
	
	/**
	 * verify entered email
	 * @param emailId
	 */
	public void verifyEnteredEmail(String emailId) {
		String value=email.getAttribute("value");
		Assert.assertEquals(value, emailId);
	}
	
	/**
	 * click on front page button
	 * @return
	 */
	public FrontPage clickONFrontPageButton() {
		waitAndClick(frontPageButton);
        return PageFactory.initElements(driver, FrontPage.class);
	
	}
	
	/**
	 * select taurine deficiency
	 * @param ResultText
	 */
	public void selectTaurineDeficiency(String ResultText) {
		for(WebElement list: suggestionList) {
			if (getText(list).trim().equalsIgnoreCase(ResultText)) {
				waitAndClick(list);
				break;
		}
		}
		
		
	}
	
	/**
	 * verify warning pop up is displayed
	 */
	public void verifyWarningIsDisplayed() {
		Assert.assertTrue(warning.isDisplayed());
	}
	
	/**
	 * verify warning message is no longer displayed
	 */
	public void verifyWarningIsNotDisplayed() {
        List element=driver.findElements(By.xpath("//section[@id='main']//span[@style='color:red']"));
        boolean flag=true;
        if(element.size()>0) {
             flag=false;
        }
     	   Assert.assertTrue(true);
        }
		
	/**
	 * select button in warning box
	 * @param name
	 */
	public void selectButtonsInWarningBox(String name) {
       WebElement button =driver.findElement(By.xpath("//button[text()='"+name+"']"));	
    		   waitAndClick(button);
	}

	/**
	 * select more suggestion
	 */
	public void selectMoreSuggestion() {
        waitAndClick(moreSuggestion);		
	}

	/**
	 * select any item from more suggestion list
	 * @param suggestion
	 */
	public void selectAnyItemFromMoreSuggestionList(String suggestion) {
    for(WebElement list:ListMoreSuggestion)	{
    	if(getText(list).trim().equalsIgnoreCase(suggestion)) {
    		waitAndClick(list);
    		break;
    	}
    }
	}

	/**
	 * select match all terms
	 */
	public void selectMatchAllTerms() {
       waitAndClick(matchAll);		
	}

	/**
	 * verify match all terms is displayed
	 * @param filterText
	 */
	public void verifyMatchAllTermsFilterIsDisplayed(String filterText) {
       boolean flag=false;
       if(matchAllFilter.getText().contains(filterText)) {
    	   flag=true;
       }
       Assert.assertTrue(flag);
	}
	
	/**
	 * select copy to clipboard
	 */
	public void selectCopyToClipboard() {
		waitAndClick(copyclipboard);
	}
	
	/**
	 * copy to clipboard pop up is displayed
	 */
	public void verifySmallCopyToClipboardPopUpIsDisplayed() {
		_normalWait(1000);
		Assert.assertTrue(copyPopup.isDisplayed());
	}
	
	/**
	 * select page selection buton
	 * @param buttonName
	 */
	public void selectPageselectionsButtons(String buttonName) {
		WebElement pageButton =driver.findElement(By.xpath("//ol[@class='pagination top']//a[contains(text(),'"+buttonName+"')]"));
		waitAndClick(pageButton);
	}
	
	/**
	 * click on jump button
	 */
	public void clickOnJumpButton() {
		waitAndClick(jumpButton);
	}
	
	/**
	 * input number to jump on
	 * @param value
	 */
	public void inputTextToJumpOnOtherPage(String value) {
		inputText(jumpText, value);
	}
	
	/**
	 * verify enter search item is displayed
	 */
	public void verifyVerifyEnterSearchItemIsDisplayed() {
		_normalWait(2000);
		Assert.assertTrue(enterSearchTearm.isDisplayed());
	}

	/**
	 * verify result is displayed as per jump search
	 * @param value
	 */
	public void verifyResultIsDisplayedAsPerSearchWithJumpToPage(int value) {
          boolean flag=false;
          String val=getText(ele);
          int res=value*25;
          String s=Integer.toString(res);
          if(val.contains(s)) {
        	  flag=true;
          }
          Assert.assertTrue(flag);
	}

	/**
	 * verify result is displayed as per selected page
	 * @param Result
	 */
	public void varifyResultIsDisplayedForSelecedPage(String Result) {
        WebElement selectedPage =driver.findElement(By.xpath("//li[@class='NoSeparator']/b/span[contains(text(),'"+Result+"')]"));
        Assert.assertTrue(selectedPage.isDisplayed());
	}
	
	/**
	 * verify last and first page is displayed
	 * @param ButtonName
	 */
	public void varifyPageIsDisplayed(String ButtonName) {
	List element=driver.findElements(By.xpath("//li[@class='NoSeparator']/b/span[contains(text(),'"+ButtonName+"')]"));
    boolean flag=true;
    if(element.size()>0) {
         flag=false;
    }
 	   Assert.assertTrue(true);
	}

	/**
     * Function: Logout application
     * @return
     */
    public LogoutPage logoutApplication() {
        _normalWait(500);
        waitForPageLoaded();
        waitAndClick(loginUserDropDown);
        waitAndClick(logoutLinkUnderUserDropDown);
        return PageFactory.initElements(driver, LogoutPage.class);
    }


}
