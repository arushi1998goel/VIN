package com.vin.pages;

import com.vin.selenium.core.BasePage;
import com.vin.utilities.Constants;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.Reporter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import static org.testng.Assert.assertTrue;

public class AddStuffPage extends BasePage {
    String articleHeaderText;
    
    public AddStuffPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(xpath = "(//div[@id='VINNews2a']//li)[2]/a[1]")
    private WebElement articleVinNewsSection;
    
    @FindBy(xpath = "//div[@class='DocumentTitle']")
    private WebElement articleTitle;
    
    @FindBy(css = "a[id='ctrlMasterToolbar_lnkAddToMyStuff']")
    private WebElement redHeartIcon;
    
    @FindBy(xpath = "//li[@id='liStuffMain']")
    private WebElement stuffTab;
    
    @FindBy(css = "input[title='New']")
    private WebElement newTab;
    
    @FindBy(xpath = "//div[@id='ButtonBar']// td[1]/input")
    private List<WebElement> buttonPresentsInMyStuff;
    
    @FindBy(xpath = "//iframe[@id='ifMyVINFramedContent']")
    private WebElement iFrame;
    
    @FindBy(xpath = "//span[contains(text(),'Folder')]")
    private WebElement folderPopup;
    
    @FindBy(xpath = "//div[@class='mstuff_basic']//input[@type='text']")
    private WebElement folderName;
    
    @FindBy(xpath = "//input[@id='btnSaveFolder']")
    private WebElement saveButton;
    
    @FindBy(xpath = "//a[text()='Selenium']/ancestor::div[contains(@style,'block')]")
    private WebElement folderCreated;
    
    @FindBy(xpath = "(//div[@class='treeview']//a[contains(text(),'Selenium')])[1]")
    private WebElement folderText;

    @FindBy(xpath = "//input[@id='btnAddLink']")
    private WebElement addLinkButton;
    
    @FindBy(xpath = "//div[@id='MainMiscContainer']//div[@id='DocumentTitlePanel']")
    private WebElement newsArticleTitle;
    
    @FindBy(xpath = "//tr[@class='bookmark-container']//a[@class='m_r_nolink']")
    private WebElement newsArticlePresentInTheFolder;
    
    @FindBy(xpath = "//input[@title='Modify']")
    private WebElement modifyButton;
    
    @FindBy(xpath = "(//input[@value='Delete' and @type='button'])[2]")
    private WebElement deleteButton;
    
    @FindBy(xpath = "//span[contains(text(),'Bookmark')]")
    private WebElement editBookMarkPopUp;
    
    @FindBy(xpath = "//input[contains(@id,'btnAddNote')]")
    private WebElement addNotesAndKeywoedButton;
    
    @FindBy(xpath = "//div[contains(@id,'notes')]/div[2]")
    private WebElement notesSection;
    
    @FindBy(xpath = "//div[contains(@id,'notes')]/div[2]/following-sibling::div[@class='ms_edit_header']")
    private WebElement keywordSection;
    
    @FindBy(css = "textarea[name='ctl01$txtNotes']")
    private WebElement notesTextBox;
    
    @FindBy(xpath = "//div[@class='ms_edit_notes_content']/input[@type='checkbox']")
    private WebElement checkBoxNotesSection;
    
    @FindBy(xpath = "//div[@class='ms_edit_enc_notes']/textarea[@type='text']")
    private WebElement keywordTextBox;
    
    @FindBy(xpath = "//input[@value='Save']")
    private WebElement saveEditBookMarks;
    
    @FindBy(xpath = "//td[@class='m_r_txt_n']")
    private WebElement notesIcon;
    
    @FindBy(xpath = "//input[@value='Add']")
    private WebElement addButton;
    
    @FindBy(xpath = "(//div[contains(@id,'anonymous_element')]//td/input[@type='text'])[1]")
    private WebElement editBookMarkTitle;
    
    @FindBy(xpath = "//input[@id='ctl01_txtURL']")
    private WebElement editBookMarkUrl;
    
    @FindBy(xpath = "//div[contains(@class,'treeview bookmarklistview')]//div//td/a[@class='m_r_nolink']")
    private List<WebElement> titlePresentUnderMyStuffSection;
    
    @FindBy(xpath = "//div[@class='contentcolumn column']//input[@id='txtSearchTerm']")
    private WebElement searchBox;
    
    @FindBy(xpath = "//div[contains(@class,'treeview bookmarklistview')]//div//td/a[@class='m_r_nolink']")
    private WebElement article;
    
    @FindBy(xpath = "//div[@class='contentcolumn column']//input[@id='btnSearchView']")
    private WebElement searchButton;
    
    @FindBy(xpath = "//div[@id='BookmarkList']/div[@id='divSearchFiltered']")
    private WebElement searchResults;
    
    @FindBy(xpath = "//div[@id='BookmarkList']//div[@class='treeview bookmarklistview']")
    private WebElement newsArticleAdded;
    
    @FindBy(xpath = "//div[@id='BookmarkList']//div[@class='treeview bookmarklistview']/div[1]")
    private WebElement firstArticle;
    
    @FindBy(xpath = "//div[@id='BookmarkList']//div[@class='treeview bookmarklistview']/div[1]//td[@class='bookmark-control']")
    private WebElement asteriskIcon;
    
    @FindBy(xpath = "//div[@id='BookmarkList']//div[@class='treeview bookmarklistview']/div[1]//td[@class='bookmark-control']/label")
    private WebElement asterisk;
    
    @FindBy(xpath = "(//span[@class='VINicon vinicon-vindex'])[1]")
    private WebElement vIndex;
    
    @FindBy(xpath = "//ul[@id='vindex-tabs']//li[@id='tab-favorites']")
    private WebElement myFaviouritesTab;
    
    @FindBy(xpath = "//div[@id='section-favorites']//table[@class='vindex']")
    private WebElement faviouritesList;
    
    @FindBy(xpath = "//div[@id='section-favorites']//table[@class='vindex']//a")
    private WebElement artcileInMyFavourites;
    
    @FindBy(xpath = "//div[@id='BookmarkList']//div[@class='treeview bookmarklistview']//td/a[@class='m_r_nolink']")
    private List<WebElement> bookmarkList;
    
    @FindBy(xpath = "(//div[@id='MainFolderList']//div)[5]//a")
    private WebElement renamedFolder;

    @FindBy(xpath = "//div[@treenodeparentid='481603']//a[contains(text(),'elenium')]")
    private List<WebElement> renamedFolderList;
    
    @FindBy(xpath = "(//tr[@class='bookmark-container'])[1]")
    private WebElement secondArticle;

    @FindBy(xpath = "(//tr[@class='bookmark-container'])[1]")
    private WebElement thisIsASeleniumArticle;
    
    @FindBy(xpath = "//div[@id='ctl01_NoResults']//li")
    private List<WebElement> contentsPresent;
 
    @FindBy(xpath = "(//input[@value='Delete'])[1]")
    private WebElement deleteFolderButton;
    
    @FindBy(xpath = "(//div[@id='MainFolderList']//div)[4]//td[2]")
    private WebElement folderPresent;

    @FindBy(xpath = "(//div[@class='container']//a[@title='MyProfile'])[1]/following-sibling::a[2]")
    private WebElement logoutBtn;

    @FindBy(xpath = "//button[text()='Dismiss All']")
    private WebElement dismissAllBtn;
    
    @FindBy(xpath = "//table//tr[@class='bookmark-container']")
    private List<WebElement> bookmarks;
    
    @FindBy(xpath = "//div[@id='ToolBoxes_Items_0']")
    private WebElement bookmarkWindow;
	
	@FindBy(xpath = "//input[@id='ctl01_btnAddNote']")
    private WebElement addNotesKeywords;
	
	@FindBy(xpath = "//input[@value='New']")
    private WebElement newButton;
	
	@FindBy(xpath = "//div[@id='ToolBoxes_Items_1']")
    private WebElement createNewFolderPopup;
	
	@FindBy(xpath = "//input[@id='ctl01_msFolderName']")
    private WebElement folderNameTextField;
	
	@FindBy(xpath = "//input[@id='btnSaveFolder']")
    private WebElement selectSave;

    
    
    /**
     * Verify Title Of news Article is displayed
     */
    public void verifyNewsArticleDisplayed() {
        waitForPageLoaded();
        _normalWait(1000);
        waitForElementPresent(articleTitle);
        boolean flag = articleTitle.getText().trim().toLowerCase()
                .contains(driver.getTitle().trim().replace(".", "").toLowerCase());
        logger.debug("Title of news article displayed :" + flag);
        assertTrue(flag);
    }

    /**
     * Click on Red Heart Icon
     */
    public void clickOnRedHeartIcon() {
        _normalWait(4000);
        logger.debug("Clicking Red Heart Icon");
        waitAndClick(redHeartIcon);
    }

    /**
     * Verify Add to MyStuff pop up window is displayed with a pop up information
     */
    public void verifyMyStuffPopUpWindowWithInFormation(String text) {
        _normalWait(3000);
        String alertText = getAlertText();
        logger.debug("Comparing Expected Alert Text " + alertText + " with Actual found Alert text " + text);
        Assert.assertEquals(alertText, text);

    }

    /**
     * verify default preferences open in Stuff tab
     */
    public void verifyWindowOpenInStuffTab() {
        waitForElementPresent(stuffTab);
        boolean flag = isElementDisplayed(stuffTab);
        logger.debug("Default preferences displayed :" + flag);
        Assert.assertTrue(flag);

    }

    /**
     * Click on tab present in My Stuff Window
     */
    public void clickOnTabPresentInMyStuffWindow(String tabToClick) {
        _normalWait(2000);
        driver.switchTo().frame(iFrame);
        for (WebElement we : buttonPresentsInMyStuff) {
            if (we.getAttribute("value").equalsIgnoreCase(tabToClick)) {
                logger.debug("Element found " + tabToClick + " and clickin`Y on it");
                waitAndClick(we);
                break;
            }
        }
    }

    /**
     * verify create New Folder Pop up Displayed
     */
    public void verifyCreateNewFolderPopupDisplayed(String title) {
        _normalWait(2000);
        logger.debug("Check Folder popup displayed");
        Assert.assertTrue(folderPopup.getText().contains(title));

    }

    /**
     * click on create Folder box and click on save
     */
    public void createFolderAndClickSave() {
        _normalWait(500);
        inputText(folderName, "Selenium");
        waitAndClick(saveButton);
    }

    /**
     * verify folder is created and is highlighted in the right pane
     */
    public void verifyFolderIsCreatedAndHighlighted(String EnterBackgroundColor) {
        _normalWait(5000);
        waitForPageLoaded();
        waitForElementPresent(folderCreated);

        boolean flag = (getBackgroundColor(folderCreated).equalsIgnoreCase("rgba(127, 206, 255, 1)"))
                ||
                (getBackgroundColor(folderCreated).equalsIgnoreCase("rgb(127, 206, 255)"));
        logger.debug("Folder created and highlighted " + flag);
        Assert.assertTrue(flag);
    }

    /**
     * Verify rename popup Open
     */
    public void verifyRenameFolderPopupDisplayed(String title) {
        _normalWait(1000);
        logger.debug("Verify rename folder popup displayed");
        Assert.assertTrue(folderPopup.getText().contains(title));

    }

    /**
     * Rename the Folder name
     * @param selenium1234
     */

    public void renameFolderName(String selenium1234) {
        _normalWait(2000);
        logger.debug("Input folder name and click save button");
        inputText(folderName, selenium1234);
        waitAndClick(saveButton);
    }

    /**
     * verify the Renamed folder name
     */
    public void verifyTheRenamedFolderName(String textToBeVerify) {
        _normalWait(2000);
        waitForElement(folderText);
        logger.debug("Verify renamed folder name is correct");
        Assert.assertTrue(folderText.getText().equalsIgnoreCase(textToBeVerify));

    }

    /**
     * Click on Add Link Button
     */ 
    public void addLinkButton() {
    	try{
    		String path=System.getProperty("user.dir");
    		Screen s=new Screen();
    		String imagePath=path+"/src/main/resources/testdata/uploadFile/ADDLINKBUTTON.PNG";
    		Pattern p=new Pattern(imagePath);
    		Match m=s.exists(p);
    		if(m!=null){
    			Thread.sleep(1000);
    			s.click(p);
    		}
    		}catch (Exception e) {
    			Reporter.log("Unable to click ");
    		}
    }

    /**
     * Text Of the News Article
     * @return
     */
    public String getTheTextOfTheNewsArticle() {
        String newsArticleText = articleTitle.getText();
        logger.debug("text of new article returned " + newsArticleText);
        return newsArticleText;
    }


    /**
     * verify Articles is saved under folder
     */
    public void verifyArticleIsSavedUnderFolder() {
        _normalWait(2000);
        boolean flag = articleHeaderText.contains(newsArticlePresentInTheFolder.getText());
        logger.debug("Article saved under folder " + flag);
        Assert.assertTrue(flag);
    }

    /**
     * Verify Notes and keyword section is expanded
     */

    public void verifyNotesAndKeywordSectionIsExpanded() {
        logger.debug("Verify Notes and Keyword section displayed");
        Assert.assertTrue(notesSection.isDisplayed());
        Assert.assertTrue(keywordSection.isDisplayed());
    }

    /**
     * click on modify Button
     */
    public void clickOnModifyButton() {
        _normalWait(2000);
        logger.debug("Clicking modify button");
        waitAndClick(modifyButton);

    }

    /**
     * Edit BookMark popUp Displayed
     */
    public void VerifyEditBookMarkPopUpDisplayed(String title) {
        _normalWait(3000);
        boolean flag = editBookMarkPopUp.getText().contains(title);
        logger.debug("Edit Bookmark pop-up displayed :" + flag);
        Assert.assertTrue(flag);

    }

    /**
     * Click on Add Notes And Keyword Button
     */
    public void clickOnAddNotesAndKeywordButton() {
        logger.debug("Clicking on Add Notes And Keyword Button");
        waitAndClick(addNotesAndKeywoedButton);
    }

    /**
     * Click on Notes TextBox to be Entered in Notes Section
     */
    public void EnterTextInNotesSection(String text) {
        logger.debug("Clicking on Notes Textbox and entering text :" + text);
        inputText(notesTextBox, text);
    }

    /**
     * verify text present in the Notes text area
     */
    public void verifyTextPresentInTheNotesSection(String Text) {
        String text1 = notesTextBox.getAttribute("value");
        logger.debug("Text found in Notes section is : " + text1);
        Assert.assertEquals(text1, Text);
    }

    /**
     * click on checkbox Present in Notes Section
     */
    public void clickOnCheckBox() {
        logger.debug("Clicking on checkbox Present in Notes Section");
        waitAndClick(checkBoxNotesSection);
    }

    /**
     * verify CheckBox is Checked
     */
    public void verifyCheckBoxIsChecked() {
        boolean flag = checkBoxNotesSection.isSelected();
        logger.debug("Checkbox is selected :" + flag);
        Assert.assertTrue(flag);
    }

    /**
     * Click on Keyword TextBox to be Entered in KeyWord Section
     */
    public void EnterTextInKeywordSection(String text) {
        logger.debug("Clicking on Keyword Textbox and entering text :" + text);
        inputText(keywordTextBox, text);
    }
    
    /**
     * verify text present in the keyword text area
     */
    public void verifyTextPresentInTheKeywordSection(String Text) {
        String text1 = keywordTextBox.getAttribute("value");
        logger.debug("Text found in keyword section :" + text1);
        Assert.assertEquals(text1, Text);
    }

    /**
     * click on save button in Edit bookmarks
     */
    public void saveEditBookMarks() {
        logger.debug("Clicking on Save Button in Edit Bookmarks");
        waitAndClick(saveEditBookMarks);
        getDriver().switchTo().defaultContent();

    }

    /**
     * Verify Notes Icon is Displayed
     */
    public void verifyNotesIconIsDisplayed() {
        boolean flag = notesIcon.isDisplayed();
        logger.debug("Notes Icon displayed " + flag);
        Assert.assertTrue(flag);
    }

    /**
     * click on add button
     */
    public void clickOnAddbutton() {
        _normalWait(3000);
        logger.debug("Clicking on Add Button");
        waitAndClick(addButton);
    }

    /**
     * enter Title for Edit Bookmark
     * @param titleForEditBookMark
     */
    public void editBookmarkTitle(String titleForEditBookMark) {
        logger.debug("Entering title for Edit Bookmark");
        inputText(editBookMarkTitle, titleForEditBookMark);
    }

    /**
     * verify Title present in the edit bookmark text area
     */
    public void verifyTextPresentInTheEditBookMarkTitleBox(String Text) {
        String text1 = editBookMarkTitle.getAttribute("value");
        logger.debug("Text present in Edit Bookmark Title Box :" + text1);
        Assert.assertEquals(text1, Text);
    }

    /**
     * enter URL in Edit Bookmark
     */
    public void editBookmarkUrl() {
        inputText(editBookMarkUrl, "https://www.vin.com/members");
    }

    /**
     * verify URL present in the Notes text area
     */
    public void verifyLinkPresentInTheEditBookMarkTitleBox(String Text) {
        String text1 = editBookMarkUrl.getAttribute("value");
        logger.debug("Link present in Edit Bookmark Title Box :" + text1);
        Assert.assertEquals(text1, Text);
    }

    /**
     * Verify BookMark is saved
     */

    public void verifyBookMarkIsSaved(String title) {
        _normalWait(3000);
        waitForPageLoaded();
        boolean flag = false;

        for (WebElement we : titlePresentUnderMyStuffSection) {

            if (we.getText().contains(title)) {
                _normalWait(1000);
                flag = true;
                break;

            }

        }

        logger.debug("Bookmark found in the List :" + flag);
        Assert.assertTrue(flag);

    }

    /**
     * Click on Search Box
     *
     * @param searchSeleniumForVIN
     */
    public void enterTextInSearchBoxAndClickEnter(String searchSeleniumForVIN) {
        inputText(searchBox, searchSeleniumForVIN);
        logger.debug("String entered in Search box and Search button clicked");
        waitAndClick(searchButton);
    }

    /**
     * Verify Search Results Displayed
     */

    public void verifySearchResultsDisplayed(String SearchedResults) {
        _normalWait(5000);
        String text = searchResults.getText();
        boolean flag = text.contains(SearchedResults);
        logger.debug("Search text found on the page :" + text + "\n & Search result matches the searched string :" + flag);
        Assert.assertTrue(flag);

    }

    /**
     * Verify article added at the beginning of the script is displayed
     */

    public void verifyArticleAddedAtTheBeginning(String articleInSearchBox) {
        _normalWait(4000);
        boolean flag = articleInSearchBox.trim().toLowerCase().replaceAll("[^a-zA-Z0-9]", "")
                .contains(newsArticleAdded.getText().trim().toLowerCase().replaceAll("[^a-zA-Z0-9]", ""));
        logger.debug("News article found :" + flag);
        Assert.assertTrue(flag);
    }

    /**
     * Click On the Article at the beginning
     */

    public void clickOnTheArticleAtTheBeginning() {
        _normalWait(1000);
        logger.debug("First Article clicked");
        waitAndClick(firstArticle);
    }

    /**
     * verify Artcile is Highlighted
     */

    public void verifyArticleIsHighlighted(String EnterBackgroundColor) {
        boolean flag = getBackgroundColor(firstArticle).equalsIgnoreCase("rgb(127, 206, 255)")
                || getBackgroundColor(firstArticle).equalsIgnoreCase("rgba(181, 227, 255, 1)");

        logger.debug("Article highlighted " + flag);
        Assert.assertTrue(flag);
//		Assert.assertEquals(getBackgroundColor(firstArticle), EnterBackgroundColor);

    }

    /**
     * Click on Asterisk icon
     */

    public void clickOnAsteriskIcon() {

        _normalWait(3000);
        waitForWebElementEnable(asterisk);
        logger.debug("Clicking on Asterix Icon");
        clickByMouseHoverOnAnElement(asterisk);
        _normalWait(1000);

    }

    /*
     * close the my stuff wndow
     */

    public void closeMyStuffWindow() {
        _normalWait(2000);
        logger.debug("Closing MyStuff Window");
        driver.close();

    }

    /***
     * Verify MyStuff Window is Closed and back to Clinical updates page
     */

    public void verifyMyStuffWIndowClosedAndBackToCLinicalUpdatePage() {
        _normalWait(3000);
        boolean flag = isElementDisplayed(stuffTab);
        logger.debug("Check element is displayed after MyStuff window is closed :" + flag);
        Assert.assertFalse(flag);
        logger.debug("Assert Clinical Updates page is displayed");
        Assert.assertTrue(articleTitle.getText().trim().toLowerCase()
                .contains(driver.getTitle().trim().replace(".", "").toLowerCase()));

    }

    /**
     * Click on VINDEX
     */

    public void clickOnVindex() {
        _normalWait(2000);
        logger.debug("Clicking on Vindex");
        waitAndClick(vIndex);
    }

    /**
     * Verify VINDEX window is displayed
     */

    public void verifyVindexWindowDisplayed(String Title) {
        _normalWait(4000);
        boolean flag = driver.getTitle().contains(Title);
        logger.debug("Vindex window displayed :" + flag);
        Assert.assertTrue(flag);
    }

    /**
     * Click On My Favourites
     */

    public void clickOnMyFavouritestab() {
        _normalWait(2000);
        logger.debug("Clicking on My Favorites");
        waitAndClick(myFaviouritesTab);
    }

    /**
     * verify MyFavouritesTab Is Selected
     */

    public void verifyMyFavouritesTabISSelected() {
        _normalWait(1000);
        boolean flag = myFaviouritesTab.isDisplayed();
        logger.debug("My Favorites Tab displayed " + flag);
        Assert.assertTrue(flag);
        logger.debug("Checking if Favorites List is displayed");
        Assert.assertTrue(isElementDisplayed(faviouritesList));
    }

    /**
     * Click on article
     */
    public void clickOnArticlePresntInMyFavourites() {
        _normalWait(2000);
        logger.debug("Clicking on Article  in My Favorites");
        waitAndClick(artcileInMyFavourites);

    }

    /**
     * Click on The Folder present in My Stuff and verify the list of bookmark is
     * present
     */

    public void clickOnFolderPresentInMyStuffAndCheckBookmarkList() {
        logger.debug("Clicking on Folder Name");
        waitAndClick(folderName);
        waitForPageLoaded();
        logger.debug("Check Bookmarks List is displayed");
        Assert.assertTrue(bookmarkList.size() > 0);

    }

    /**
     * Verify Warning message is displayed indicating the bookmark already exists
     */

    public void verifyWarningMessageDisplayedBookmarkExist() {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        boolean selection = alert.getText().contains("Are you sure you want to add another?");
        if (selection) {
            alert.accept();
        }
        logger.debug("Verify Warning Message Displayed for existing Bookmark :" + selection);
        Assert.assertTrue(selection);
    }

    /**
     * verify popup showing for delete bookmark
     */

    public void verifyPopUpDisplayedDeleteBookmark() {

        Alert alert = driver.switchTo().alert();
        boolean selection = alert.getText().contains("Are you sure you want to delete this bookmark?");
        if (selection) {
            alert.accept();
        }
        logger.debug("Verify pop-up displayed for deletion :" + selection);
        Assert.assertTrue(selection);

    }

    /**
     * Select the renamed folder
     */

    public void clickOnFolder() {
        driver.switchTo().frame(iFrame);
        _normalWait(4000);
        waitForElement(renamedFolder);
        logger.debug("Clicking on Renamed Folder");
        waitAndClick(renamedFolder);
    }

    /**
     * Verify rename Folder Is highlited
     */

    public void verifyRenameFolderIsHighlighted() {

        _normalWait(3000);
        waitForElementPresent(renamedFolder);
        boolean flag = getTextColor(renamedFolder).equalsIgnoreCase("rgb(34, 34, 34)")
                || getTextColor(renamedFolder).equalsIgnoreCase("rgba(34, 34, 34, 1)");
        logger.debug("Verify Renamed Folder is highlighted :" + flag);
        Assert.assertTrue(flag);


    }

    /**
     * Verify news Article is saved under folder
     */
    public void verifyBookMarkDeleted(String title) {
        _normalWait(3000);
        waitForPageLoaded();
        boolean flag = true;

        for (WebElement we : titlePresentUnderMyStuffSection) {
            if (title.toLowerCase().trim().contains(we.getText().toLowerCase().trim())) {
                _normalWait(1000);
                flag = false;
                break;
            }

        }
        logger.debug("Verify News Article is saved under folder :" + flag);
        Assert.assertTrue(flag);
    }

    /**
     * Verify news Article is saved under folder
     */
    
    public void verifynewsArticlePresntInsideTheFolder(String title) {
        _normalWait(5000);
        boolean flag = false;

        for (WebElement we : titlePresentUnderMyStuffSection) {
            waitForElementPresent(we);
            if (title.toLowerCase().trim().replaceAll("[^a-zA-Z0-9]", "")
                    .contains(we.getText().trim().toLowerCase().replaceAll("[^a-zA-Z0-9]", ""))) {
                _normalWait(1000);
                flag = true;
                break;

            }

        }
        logger.debug("Verify that news article is present in folder :" + flag);
        Assert.assertTrue(flag);
    }

    /**
     * verify Article is saved under my stuff folder
     */

    public void verifyArticle(String title) {
        _normalWait(3000);
        waitForPageLoaded();
        boolean flag = title.toLowerCase().trim().replaceAll("[^a-zA-Z0-9]", "").contains(article.getText().toLowerCase().trim().replaceAll("[^a-zA-Z0-9]", ""));
        logger.debug("Verify Article is saved under My Stuff folder :" + flag);
        Assert.assertTrue(flag);
    }

    /**
     * Click on Delete Button
     */

    public void clickDeleteBookmark() {
        _normalWait(5000);
        logger.debug("Click Delete Bookmark");
        clickOn(deleteButton);
    }

    /**
     * Select 2nd Article and click on delete
     */
    
    public void clickArticleAndSelectDelete(String Title) {
        _normalWait(5000);
        boolean flag = false;

        for (WebElement we : titlePresentUnderMyStuffSection) {
            if (Title.toLowerCase().trim().replaceAll("[^a-zA-Z0-9]", "")
                    .contains(we.getText().trim().toLowerCase().replaceAll("[^a-zA-Z0-9]", ""))) {
                _normalWait(1000);
                flag = true;
                logger.debug("Second Article Found :" + flag);
                logger.debug("Select found article and click Delete");
                waitForElementPresent(we);
                clickOn(we);
                _normalWait(2000);
                waitAndClick(deleteButton);
                break;

            }

        }
    }


    /**
     * Click Bookmark This is a Selenium Test
     *
     */
    
    public void clickThisIsASeleniumBookmark() {
        _normalWait(2000);
        logger.debug("Select Bookmark");
        clickOn(thisIsASeleniumArticle);
        _normalWait(1000);
        logger.debug("Click Delete button to remove the bookmark");
        waitAndClick(deleteButton);

    }

    /**
     * Verify content displayed in the right Pane
     */
    
    public void verifyContentInTheRightPane(List<String> contents) {
        List<String> reasonForChange = new ArrayList<>();
        for (WebElement reasonChangeValues : contentsPresent) {
            reasonForChange.add(getText(reasonChangeValues).trim());
        }
        Assert.assertEquals(reasonForChange, contents, "values present");
        driver.switchTo().defaultContent();
    }

    /**
     * Verify folder is deleted
     */
    public void verifyFolderISDeleted() {
        boolean flag = renamedFolder.isDisplayed();
        logger.debug("Check folder is deleted :" + flag);
        Assert.assertTrue(flag);
    }

    /**
     * verify popup showing for delete folder
     */

    public void verifyPopUpDisplayedFolderBookmark() {
        Alert alert = driver.switchTo().alert();
        boolean selection = alert.getText().contains("Are you sure you want to delete this folder?");
        if (selection) {
            logger.debug("If alert is present, click accept");
            alert.accept();
        }
        logger.debug("Is Alert present with required content :" + selection);
        Assert.assertTrue(selection);

    }

    /**
     * Select Ok
     */

    public void selectOK() {
        boolean flag = false;
        for (int i = 0; i <= 8; i++) {
            _normalWait(2000);
            flag = isAlertPresent();
            if (flag) {
                logger.debug("Alert Found, switching to it and accepting it");
                acceptAlertPresent();
                break;
            }

        }
        logger.debug("Alert Found :" + false);
    }

    /**
     * verify Add to MyStuff pop up window is displayed with a pop up
     */

    public void verifyAddToMYSTuffPopUpDisplayed() {
        String browserName = browserName();
        boolean flag = browserName.equalsIgnoreCase("chrome")
                || browserName.equalsIgnoreCase("firefox");

        if (flag) {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.alertIsPresent());

            Alert alert = driver.switchTo().alert();
            boolean selection = alert.getText()
                    .contains("After you click OK, you may pick a folder for your link and don't forget to click ADD LINK.");
            if (selection) {
                _normalWait(3000);
                logger.debug("Accept Alert");
                alert.accept();
            }
            logger.debug("Alert Found :" + selection);
            Assert.assertTrue(selection);
        }

    }



    /**
     * logout Application
     */
    public void logout() {
        _normalWait(3000);
        logger.debug("Click Logout and close driver");
        waitAndClick(logoutBtn);
        closeDriver();
    }

    /**
     * Verify Logout Page displayed
     */
    
    public void verifyLogoutPageDisplayed() {
        waitForPageLoaded();
        _normalWait(1000);
        logger.debug("Assert Logout page is displayed");
        assertByPageTitle(Constants.pageTitle_LogoutPage);
    }

    /**
     * Verify Folder Present
     */
    public void verifyFolderAndDelete() {
        _normalWait(10000);
        waitForPageLoaded();
        waitForTitle("MyVIN");
        waitForElementPresent(iFrame);

        driver.switchTo().frame(iFrame);
        if (renamedFolderList.size() > 0) {
            logger.debug("Folder List size > 0");
            _normalWait(1000);
            waitForElementPresent(renamedFolderList.get(0));
            WebElement we = renamedFolderList.get(0);
            if (we.getText().toLowerCase().contains("selenium")) {
                logger.debug("Folder Found");
                waitAndClick(we);
                _normalWait(2000);
                logger.debug("Delete the folder and accept the alert");
                waitAndClick(deleteFolderButton);
                _normalWait(2000);
                acceptAlertPresent();

            }
        }
    }

    private void waitForTitle(String myVIN) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.titleContains(myVIN));
    }

    public void deleteFolder() {
        _normalWait(3000);
        if (renamedFolder.isDisplayed()) {
            logger.debug("Folder found, Deleting it");
            waitAndClick(renamedFolder);
            waitAndClick(deleteFolderButton);
            _normalWait(1000);
            acceptAlertPresent();
        }

    }

    public void checkAlertAndAccept() {
        try {
            Assert.assertTrue(isAlertPresent());
            acceptAlertPresent();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getSecondWindowHandle(String parentwin) throws InterruptedException {

        List<String> WinList = new ArrayList<>();
        Set<String> windows = getDriver().getWindowHandles();
        windows.remove(parentwin);
        Iterator<String> iterator = windows.iterator();
        for (int i = 0; i <= windows.size() - 1; i++) {
            String win = iterator.next();
            WinList.add(win);
        }
        return WinList.get(0);

    }

    public void dismissNotifications() {
        super.dismissNotifications(dismissAllBtn);
    }

	
	/**
	 * Select and click recently added article
	 * @param articletext
	 */
    
	public void ClickAndDeleteOnRecentlyAddedArticle(String articletext) {

		for(int i=0;i<bookmarks.size();i++) {
				if(bookmarks.get(i).getText()==articletext) {
					bookmarks.get(i).click();
				}
			}
		}
	
	 public void slectArticle() {
		 _normalWait(5000);
		 WebElement elementToBeClicked = driver.findElement(By.xpath("(//a[text()='British veterinary practices undergo rapid consoli'])[1]"));
	     javascriptButtonClick(elementToBeClicked);
	 }

	 public void selectArticleFromTheList()
	 {
		 try{
	    		String path=System.getProperty("user.dir");
	    		Screen s=new Screen();
	    		String imagePath=path+"/src/main/resources/testdata/uploadFile/article.PNG";
	    		Pattern p=new Pattern(imagePath);
	    		Match m=s.exists(p);
	    		if(m!=null){
	    			Thread.sleep(1000);
	    			s.click(p);
	    		}
	    		}catch (Exception e) {
	    			Reporter.log("Unable to click ");
	    		}
			

	 }
	/**
	 * Select delete control
	 */
	public void selectDeleteControl() {

		try{
    		String path=System.getProperty("user.dir");
    		Screen s=new Screen();
    		String imagePath=path+"/src/main/resources/testdata/uploadFile/delete.PNG";
    		Pattern p=new Pattern(imagePath);
    		Match m=s.exists(p);
    		if(m!=null){
    			Thread.sleep(1000);
    			s.click(p);
    		}
    		}catch (Exception e) {
    			Reporter.log("Unable to click ");
    		}
		
	}

	/**
	 * Select another bookmark list
	 */
	
	public void selectAnotherBookMarkList() {

		try{
    		Screen s=new Screen();
    		String imagePath="E:\\VINUpdated\\VIN.Dev.Selenium\\src\\main\\resources\\testdata\\uploadFile\\ModiFyList.PNG";
    		Pattern p=new Pattern(imagePath);
    		Match m=s.exists(p);
    		if(m!=null){
    			Thread.sleep(1000);
    			s.click(p);
    		}
    		}catch (Exception e) {
    			Reporter.log("Unable to click ");
    		}
		
		
		
	}

	/**
	 * Select modify
	 */
	
	public void selectModiFy() {

		try{
    		Screen s=new Screen();
    		String imagePath="E:\\VINUpdated\\VIN.Dev.Selenium\\src\\main\\resources\\testdata\\uploadFile\\Modify.PNG";
    		Pattern p=new Pattern(imagePath);
    		Match m=s.exists(p);
    		if(m!=null){
    			Thread.sleep(1000);
    			s.click(p);
    		}
    		}catch (Exception e) {
    			Reporter.log("Unable to click ");
    		}
		_normalWait(3000);
		
	}
	
	/**
	 * Verify bookmark pop up window
	 */
	public void verifyBooKmarkpopupWindow() {
		getDriver().switchTo().frame("ifMyVINFramedContent");
		if(bookmarkWindow.isDisplayed()) {
			Assert.assertTrue(true);
		}
	}

	/**
	 * Select Add notes and keywords
	 */
	public void selectAddNotesAndKeywords() {
		waitAndClick(addNotesKeywords);
	}
	
   /**
   * Select new button
   */
	public void selectNewListedUnderMyFolder() {
		try{
    		Screen s=new Screen();
    		String imagePath="E:\\VINUpdated\\VIN.Dev.Selenium\\src\\main\\resources\\testdata\\uploadFile\\NewButton.PNG";
    		Pattern p=new Pattern(imagePath);
    		Match m=s.exists(p);
    		if(m!=null){
    			Thread.sleep(1000);
    			s.click(p);
    		}
    		}catch (Exception e) {
    			Reporter.log("Unable to click ");
    		}
		_normalWait(3000);
	}

	/**
	 * Verify create new folder pop up
	 */
	public void verifyCreateNewFolderPopUp() {
		getDriver().switchTo().frame("ifMyVINFramedContent");

		if(createNewFolderPopup.isDisplayed()) {
			Assert.assertTrue(true);
		}
	}

	/**
	 * Enter text in folder name text field
	 */
	
	public void enterTextInFolderNameTextField(String seleniumtext) {

		inputText(folderNameTextField, seleniumtext);
	}

	/**
	 * Select Save for create folder popup
	 */
	
	public void selectSave() {

		waitAndClick(selectSave);
	}

	/**
	 * Select Selenium folder
	 */
	public void selectSeleniumFolder() {

		try{
    		Screen s=new Screen();
    		String imagePath="E:\\VINUpdated\\VIN.Dev.Selenium\\src\\main\\resources\\testdata\\uploadFile\\Selenium.PNG";
    		Pattern p=new Pattern(imagePath);
    		Match m=s.exists(p);
    		if(m!=null){
    			Thread.sleep(1000);
    			s.click(p);
    		}
    		}catch (Exception e) {
    			Reporter.log("Unable to click ");
    		}
		_normalWait(3000);
		
	}

	public void selectDeleteUnderMyFolder() {

		try{
    		Screen s=new Screen();
    		String imagePath="E:\\VINUpdated\\VIN.Dev.Selenium\\src\\main\\resources\\testdata\\uploadFile\\DeleteButton.PNG";
    		Pattern p=new Pattern(imagePath);
    		Match m=s.exists(p);
    		if(m!=null){
    			Thread.sleep(1000);
    			s.click(p);
    		}
    		}catch (Exception e) {
    			Reporter.log("Unable to click ");
    		}
		_normalWait(3000);
		
	}

	public void verifyDeleteThisFolder() {
		 acceptAlertPresent();
	}	
		
	}
		
	

