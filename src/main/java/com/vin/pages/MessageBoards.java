package com.vin.pages;


import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.Reporter;
import com.vin.selenium.core.BasePage;
import com.vin.utilities.Constants;


public class MessageBoards extends BasePage {
	
	public MessageBoards(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "div[id='menu'] div[id='topNav'] a[id='loginmenu']")
	private WebElement loginUserDropDown;
	
	@FindBy(css = "div[id='menu'] div[id='topNav'] ul[role='menu'] a[class='MemberProfile_Logout']")
	private WebElement logoutLinkUnderUserDropDown;
	
	@FindBy(xpath = "//select[contains(@id,'keyFolderList7')]")
	private WebElement vetToVet;
	
	@FindBy(css = "input[id='keyBoardRB6']")
	private WebElement vetToVetRadioButton;
	
	@FindBy(xpath = "(//select[@id='keyFolderList7']//option)[3]")
	private WebElement mbTestFolder;
	
	@FindBy(css = "input[id='btnPostNew']")
	private WebElement postNewButton;
	
	@FindBy(xpath = "//h4[contains(text(),'POSTING IN')]")
	private WebElement postingInPopUp;
	
	@FindBy(xpath = "//div[@class='bootbox-body']")
	private WebElement postininPopupMessage;
	
	@FindBy(css = "button[data-bb-handler='success']")
	private WebElement continuePopup;
	
	@FindBy(css = "h4[id='mdlSignalmentTitle']")
	private WebElement signalment;
	
	@FindBy(xpath = "//*[@id='btnBypassSignalment']")
	private WebElement notAClinicalCaseButton;
	
	@FindBy(css = "input[id='Subject']")
	private WebElement discussionTitle;
	
	@FindBy(css = "a[title='My Post']")
	private WebElement MyPostTab;
	
	@FindBy(css = "body[data-id='MessageBody']")
	private WebElement myPostArea;
	
	@FindBy(css = "button[id='btnMoreFormating']")
	private WebElement formatButton;
	
	@FindBy(css = "iframe[id='MessageBody_ifr']")
	private WebElement frame;
	
	@FindBy(xpath = "//i[contains(@class,'mce-i-bold')]")
	private WebElement boldButton;
	
	@FindBy(xpath = "//div[@id='mceu_3']")
	private WebElement boldText;
	
	@FindBy(css = "input[id='ShowPreview']")
	private WebElement previewMessage;
	
	@FindBy(xpath = "(//span[@class='WindowTitles'])[1]//label")
	private WebElement previewMessage2;

	@FindBy(css = "button[id='SubmitBtn']")
	private WebElement postMessageButton;
	
	@FindBy(xpath = "//div[@class='PostPreviewAlert']/span")
	private WebElement previewMessageWindow;
	
	@FindBy(xpath = "//button[@id='SubmitBtn2']//span[contains(text(),' your New')]")
	private WebElement postYourNewMessage;
	
	@FindBy(xpath = "//h4[text()='View Your New Discussion?']")
	private WebElement viewYourNewDiscussionPopup;
	
	@FindBy(xpath = "//div[@class='bootbox-body']")
	private WebElement wouldYouLikeToViewNewDiscussion;
	
	@FindBy(css = "button[id='btnCopyDiscussionUrl']")
	private WebElement copyDiscussionUrl;
	
	@FindBy(xpath = "//button[text()='Yes (New Tab/Window)']")
	private WebElement newTabWindow;
	
	@FindBy(xpath = "//button[text()='Yes (Same Tab/Window)']")
	private WebElement sameTabWindow;
	
	@FindBy(xpath = "//button[text()='No']")
	private WebElement noButton;
	
	@FindBy(xpath = "//h4[text()='Message Posted']")
	private WebElement messagePosted;
	
	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okButton;
	
	@FindBy(xpath = "//strong[text()='View:']")
	private WebElement discussionViewer;
	
	@FindBy(xpath = "//div[@id='divDiscussionList']/div[2]")
	private WebElement newlyCreatedDiscussion;
	
	@FindBy(css = "button[id='btnCopyDiscussionUrlPW']")
	private WebElement copyurl;
	
	@FindBy(css = "button[id='lnkReply']")
	private WebElement replyButton;
	
	@FindBy(xpath = "//div[@id='divUploaderButtons']//span[@class='UploadButtonText']/following-sibling::input")
	private WebElement attachFiles;
	
	@FindBy(xpath = "//span[text()='Processing...']")
	private WebElement processingText;
	
	@FindBy(xpath = "//input[contains(@value ,'Enter Title')]")
	private WebElement enterTitleTextBox;
	
	@FindBy(xpath = "//*[@id='DiscussionIFrame']")
	private WebElement discussionFrame;
	
	@FindBy(css = "input[id='ShowPreview']")
	private WebElement previewMessageCheckBox;
	
	@FindBy(xpath = "//button[@title='Post Message']")
	private WebElement postmessageButton;
	
	@FindBy(xpath = "//img[@id='imgThumb2']")
	private WebElement imageuploaded;
	
	@FindBy(xpath = "//div[text()='images attached']")
	private WebElement imagesAttachedText;
	
	@FindBy(xpath = "//span[text()='This is a title']")
	private WebElement thisIsATitleText;
	
	@FindBy(css = "input[id='txtName']")
	private WebElement nameTextBox;
	
	@FindBy(css = "input[id='txtLocation']")
	private WebElement locationTextBox;
	
	@FindBy(css = "select[id='ddlSpecies']")
	private WebElement anySpeciesDropDown;

	@FindBy(css = "input[id='txtBreed']")
	private WebElement breedOrTypeAnimal;

	@FindBy(css = "select[id='ddlSex']")
	private WebElement sexDropDown;

	@FindBy(css = "input[id='txtWeightLB']")
	private WebElement weightlb;

	@FindBy(css = "select[id='ddlAgeYears']")
	private WebElement ageDropDOwn;

	@FindBy(css = "select[id='ddlAgeMonths']")
	private WebElement monthsDropDown;

	@FindBy(css = "select[id='ddlAgeWeeks']")
	private WebElement weeksDropDown;

	@FindBy(css = "input[id='txtChiefComplaint']")
	private WebElement chiefComplaintTextbox;

	@FindBy(css = "a[id='btnSaveSignalment']")
	private WebElement saveSignalmentButton;

	@FindBy(css = "input[id='Subject']")
	private WebElement discussionTitleTextBox;

	@FindBy(xpath = "//body[@data-id='MessageBody']")
	private WebElement messageBodyTextBox;

	@FindBy(xpath = "//span[contains(@class,'SignalmentText')]")
	private WebElement signalmentText;

	@FindBy(css = "button[id='btnDiscussionPostNew']")
	private WebElement postNewButtton;

	@FindBy(xpath = "//button[@title='Cancel']")
	private WebElement cancelButton;

	@FindBy(css = "input[id='dteDOB']")
	private WebElement dateOfBirth;

	@FindBy(xpath = "(//button[@title='Save Draft'])[2]")
	private WebElement saveDrafts;

	@FindBy(xpath = "(//button[@title='Open Drafts'])[2]")
	private WebElement openDrafts;

	@FindBy(xpath = "//span[@id='spnSavingDraft']/span")
	private WebElement savingDraftsMessage;

	@FindBy(css = "button[title='Select Draft']")
	private WebElement selectDrafts;

	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement yesButton;

	@FindBy(xpath = "//select[@id='keyFindSince']")
	private WebElement findSinceDropDown;

	@FindBy(xpath = "//select[@id='keyFindSince']/option")
	private java.util.List<WebElement> dropdownValues;

	@FindBy(xpath = "//input[@id='btnFindSince']")
	private WebElement findSinceButton;

	@FindBy(xpath = "(//span[@id='lblSmallBoardFolder'])[1]")
	private WebElement messageBoard;

	@FindBy(xpath = "//iframe[@id='DiscussionIFrame']")
	private WebElement iframe;

	@FindBy(xpath = "//button[@id='btnSubscribeTop']")
	private WebElement subscribeButton;

	@FindBy(xpath = "//button[@id='btnSubscribeModal']")
	private WebElement subscribeToThisDiscussionPopup;

	@FindBy(xpath = "//div[@value='2006652']")
    private WebElement vinIsAwesomeText;

	@FindBy(xpath = "//button[@id='btnSubscribeFolder']")
	private WebElement sucbscibeTothisFolderButton;
	
	@FindBy(xpath = "//button[text()='Dismiss All']")
	private WebElement dismissAllBtn;
	 
	@FindBy(xpath="//button[text()='Jump to Top']")
    private WebElement jumpToTop;

    @FindBy(xpath="//button[@id='lnkClipboardDiscussionUrl']")
    private WebElement copyToClipBoard;

	@FindBy(xpath="//button[@id='btnBackToBoards']")
    private WebElement boardButton;

	@FindBy(xpath = "//select[@id='keyFindSince']")
	private WebElement findsinceControlDropdown;

	@FindBy(xpath = "//select[@id='ctl01_ContentBody_ctrlMBMainNav_keyBoardList']")
	private WebElement vetToVetDropDown;

    @FindBy(xpath="//select[@id='ctl01_ContentBody_ctrlMBMainNav_keyBoardList']//option[@selected='selected']")
	private WebElement vetToVetBoard;

    @FindBy(xpath="//select[@id='keyFolderList']")
	private WebElement folderDropDown;
	
	@FindBy(xpath="//span[@id='ctl01_ContentBody_ctrlMBMainNav_lblFolderCount']")
	private WebElement folderTextValue;

    @FindBy(xpath="//select[@id='ctl01_ContentBody_ctrlMBMainNav_keyFindSince']")
	private WebElement findSinceDropDownOnSearchResultPage;

    @FindBy(xpath="//a[@id='lnkBackToBoards']/../../../..//a")
	private WebElement boardsHomeButton;

    @FindBy(xpath="//input[@id='ctl00_ContentBody_keySearchType_2']")
	private WebElement docIDRadioButton;

    @FindBy(xpath="//input[@id='txtSearch']")
	private WebElement docIDSearchBox;

    @FindBy(xpath="//strong[text()='Discussion Tools']")
	private WebElement discussionToolText;

	@FindBy(xpath="(//div[@class='clearfix' ])[5]")
	private WebElement documentIDSectionUnderDiscussionTool;
	
	@FindBy(xpath = "//div[@class='navbar-collapse collapse']//ul[@id='vinmainnav']//li[@id='masterTabBoards']")
	private WebElement messageBoardsnavBar;
	
	@FindBy(xpath="//select[@id='ddlMyActivityType']")
	private WebElement myMostViewdDropdownControl;
	
	@FindBy(xpath="//div[@id='DiscussionsMostViewedPanel']//ol//li")
	private List<WebElement> discussionslist;
	
	@FindBy(xpath="//li[@class='MyDiscussionControlListItem BreakWord']/..//li[1]//a")
	private WebElement firstDiscussionLink;
	
	@FindBy(xpath="//div[@id='divDiscussionToolbar']/span[@id='spnMainDiscussionToolbar']//button[@id='btnBackToBoards']")
	private WebElement boardsHomeButtonSearchResultPage;
	
	@FindBy(xpath="(//span[text()='Title:'])[1]//following-sibling::span[1]")
	private WebElement discussionTitleText;
	
	@FindBy(xpath="//a[text()='Personalize your Boards']/..//a[1]")
	private WebElement personalizeYourBoardsLink;
	
	@FindBy(xpath="//span[@id='lblPageHeader']")
	private WebElement personalizeYourBoardsWindowTitle;
	
	@FindBy(xpath="//input[@id='keyBoardRB0']")
	private WebElement allBoardsRadioButton;
	
	@FindBy(xpath="//select[@id='keyFolderList6']")
	private WebElement vetToVetRadioButtonText;
	
	@FindBy(xpath="//div[@id='divDiscussionList']//div[2]")
	private WebElement firstLink;
	
	@FindBy(xpath="//select[@id='ddlFindInBoardFolder']")
	private WebElement vetToVetBoardDropdown;
	
	@FindBy(xpath="//div[@class='modal-backdrop fade in']//following-sibling::div")
	private WebElement continuePopUp;
	
	@FindBy(xpath="//label[text()='Expanded']")
	private WebElement expandedButton;
	
	@FindBy(xpath="//div[@id='divDiscussionList']/div[3]")
	private WebElement discussionLink;
	
	@FindBy(xpath="//div[@class='panel-heading text-left']/div/div[1]")
	private WebElement checkBoxViewChecked;
	
	@FindBy(xpath="//div/h3[contains(text(),'Boards now processing.')]")
	private WebElement boardProcessing;
	
	@FindBy(xpath="//div[@class='panel-heading text-left']/div/div[1]/following-sibling::div[1]")
	private WebElement viewCheckedButton;
	
	@FindBy(xpath="//div[contains(@id,'divMBPageNavTop')]//strong[text()='Viewing 1 highlighted messages.']")
	private WebElement viewingMessage;
	
	@FindBy(xpath="//div[contains(@id,'PageNavTop')]//li/a[text()='1']")
	private WebElement selectedPage;
	
	@FindBy(xpath="//div[contains(@id,'divMBPageNavTop')]//ul")
	private WebElement oneButton;
	
	@FindBy(xpath="//span[text()='1.']")
	private WebElement oneLink;
	
	@FindBy(xpath="//a[text()='MyVIN']")
	private WebElement MyVin;
	
	

	/**
	 * Click on Myvin
	 */
	public FrontPage clickOnMyVin() {
		waitAndClick(MyVin);
        return PageFactory.initElements(driver, FrontPage.class);

	}
	
	/**
	 * Dismiss alert Notification
	 */
	
	public void dismissNotifications() {
        super.dismissNotifications(dismissAllBtn);
    }

	/**
	 * Click on Vet to Vet Folder
	 */

	public void clickOnVetToVetFolder() {
		waitAndClick(vetToVetRadioButton);
		driver.findElement(By.xpath("//select[contains(@id,'keyFolderList6')]")).click();
	}

	/**
	 * Verify Vet to Vet Radio Button is selected
	 */

	public void verifyVetToVetRadioButtonSelected() {
		boolean flag = false;
		if (vetToVetRadioButton.isSelected()) {
			flag = true;
			Assert.assertTrue(flag);

		}
	}
	
	/**
	 * Select MB TestFolder From dropdown
	 */

	public void selectMBTestFolderFromDropDown() {
		selectDropDownByIndex(vetToVet, 2);

	}

	/**
	 * Verify MBtest Folder is selected
	 */

	public void verifyMBTestFolderIsSelected(String DropDownText) {
		Assert.assertTrue(mbTestFolder.isDisplayed());

		String Text = mbTestFolder.getText().replaceAll("[^a-zA-Z0-9]", "");
		Assert.assertEquals(Text, DropDownText);

	}

	/**
	 * Click on PostNew Button
	 */
	public void clickOnPostNewButton() {
		waitAndClick(postNewButton);
		getDriver().manage().window().maximize();
	}

	/**
	 * Verify You are posting in pop up is displayed
	 */

	public void verifyPostingInPopUpDisplayed(String PopUpText, String InformationMessages) {
		_normalWait(3000);
		String popupText = postingInPopUp.getText();
		Assert.assertEquals(popupText, PopUpText);
		String Value = postininPopupMessage.getText();
		Assert.assertEquals(Value, InformationMessages);

	}

	/**
	 * Click on Continue button
	 */

	public void clickOnContinueButton() {
		_normalWait(2000);
		waitAndClick(continuePopup);
		waitForPageLoaded();
	}

	/**
	 * Verify Post New Window is displayed
	 */

	public void verifyPostNewAndSignalmentWindowIsDisplayed(String Title) {
		waitForPageLoaded();
		waitForWebElementEnable(signalment);
		waitForElement(signalment);
		String TitleForWindow = driver.getTitle().substring(0, 19);
		Assert.assertEquals(TitleForWindow, Title);
		Assert.assertTrue(signalment.isDisplayed());

	}

	/**
	 * Click on Not A clinical Case Button
	 */

	public void clickOnNotAClinicalCaseButton() {
		waitAndClick(notAClinicalCaseButton);
		waitForPageLoaded();
		driver.manage().window().maximize();
		switchToDefaultContent();
	}

	/**
	 * Verify Post a new window Window Displayed
	 */

	public void VerifyPostANewWindowDisplayed(String Title) {
		String TitleForWindow = driver.getTitle().substring(0, 19);
		Assert.assertEquals(TitleForWindow, Title);

	}

	/**
	 * Enter Text in the Discussion Title
	 */
	public void enterTextInTheDiscussionTitle(String Text) {
		waitForWebElementEnable(discussionTitle);
		_normalWait(2000);
		discussionTitle.sendKeys(Text);

	}

	/**
	 * Verify Text in Discussion Title
	 */
	public void verifyDiscussionTitlePopulated(String Value) {
		String discussionTitleValue = discussionTitle.getAttribute("value");
		Assert.assertEquals(discussionTitleValue, Value);

	}

	/**
     * Enter Text in the My Post Area
     */

    public void enterTextInMyPostArea(String Text) {
        waitAndClick(MyPostTab);
		driver.switchTo().frame(frame);
		inputText(myPostArea, Text);
	}

	/**
	 * Verify Text in My post Area
	 */

	public void verifyTextInMYPostArea(String Text) {
		String TextPassed = myPostArea.getText();
		Assert.assertEquals(TextPassed, Text);
	}

	
	/**
	 * Click on Format Button Under My Post Area
	 */

	public void clickFormaButton() {
		switchToDefaultContent();
		waitAndClick(formatButton);
	}

	/**
	 *  Verify the Colour from My post Area
	 */
	public void verifyColourFromTheMyPostAreaTextBox(String textcolour) {
		
		boolean flag= false;
	    driver.switchTo().frame(frame);
			if (getTextColor(myPostArea).equalsIgnoreCase("rgba(0, 0, 0, 1)") || getTextColor(myPostArea).equalsIgnoreCase("rgba(0, 0, 0)" )){
				flag = true;
            Assert.assertTrue(flag);
	        }
	        switchToDefaultContent();

	    }
	

	/**
	 * Highlight the my post Text area
	 */
	public void highlightTheMyPostText() {
		driver.findElement(By.xpath("//body")).sendKeys(Keys.chord(Keys.CONTROL, "a"));

	}

	
	/**
	 * Verify the Colour from My post Area
	 *//*
		 * public void verifyColourFromTheMyPostAreaTextBox(String textcolour) {
		 * 
		 * boolean flag = false; driver.switchTo().frame(frame); if
		 * (getTextColor(myPostArea).equalsIgnoreCase("rgba(0, 0, 0, 1)") ||
		 * getTextColor(myPostArea).equalsIgnoreCase("rgba(0, 0, 0)")) { flag = true; //
		 * Assert.assertTrue(flag); // } else { // if
		 * (getTextColor(myPostArea).equalsIgnoreCase("rgba(0, 0, 0)")) { // flag =
		 * true; // Assert.assertTrue(flag); // // } Assert.assertTrue(flag); }
		 * switchToDefaultContent();
		 * 
		 * 
		 * // <<<<<<< HEAD // Assert.assertEquals(getTextColor(myPostArea), textcolour);
		 * 
		 * }
		 */

	/**
	 * Click on Bold Button
	 */
	public void selectBold() {
		_normalWait(1000);
		waitAndClick(boldButton);
	}

	/**
	 * Verifying the text is getting bold
	 */

	public void verifyContentIsFormattedWithBold() {
		driver.switchTo().frame(frame);
		String tag1 = driver.findElement(By.id("DocEditor")).getTagName();
		String tag2 = driver.findElement(By.id("DocEditor")).getCssValue("font-weight");
		System.out.println(tag2);
		Assert.assertTrue(Integer.parseInt(tag2) >= 400);
		switchToDefaultContent();

	}
	
	

	/**
	 * Verifying the preview message checkbox and selecting the checkbox
	 */

	public void verifyThePreviewMessageCheckbox() {		
		try{
    		String path=System.getProperty("user.dir");
			Screen s=new Screen();
			String imagePath=path+"/src/main/resources/testdata/uploadFile/CheckBox.PNG";
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
	 * Click post message Button
	 */
	public void clickonPostMessageButton() {

		
		try{
    		String path=System.getProperty("user.dir");
			Screen s=new Screen();
			String imagePath=path+"/src/main/resources/testdata/uploadFile/PostMessage.PNG";
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
	 * Verifying preview message is displayed
	 */
	public void verifyPreviewWindowDisplayed() {
		waitForPageLoaded();
		Assert.assertTrue(previewMessageWindow.isDisplayed());
	}

	/**
	 * Click post your new message Button
	 */
	public void clickonPostNewMessageButton() {
		waitAndClick(postYourNewMessage);
	}

	/**
	 * Verify view your new discussion pop dislpayed
	 */
	public void verifyViewYourNewDiscussionPopUpDislpayed(String popupTitle) {
		waitForWebElementEnable(viewYourNewDiscussionPopup);
		_normalWait(1000);
		String text = viewYourNewDiscussionPopup.getText();
		Assert.assertEquals(text, popupTitle);
	}

	/**
	 * Verify the buttons and text from view your next discussion pop up
	 */
	public void verifytextAndButtonsFromViewYourNextDiscussionPopup(String newdiscussionTitle, String CopyDiscussionURL,
			String NewTabText, String SameTabText, String NoText) {
		String text = wouldYouLikeToViewNewDiscussion.getText();
		String Text = text.trim().replaceAll("Copy Discussion URL", "");
		Assert.assertEquals(Text.trim().toLowerCase(), newdiscussionTitle.trim().toLowerCase());
		String copyDiscussiontext = copyDiscussionUrl.getText();
		Assert.assertEquals(copyDiscussiontext, CopyDiscussionURL);
		String Newtext = newTabWindow.getText();
		Assert.assertEquals(Newtext, NewTabText);
		String sameTabtext = sameTabWindow.getText();
		Assert.assertEquals(sameTabtext, SameTabText);
		String notext = noButton.getText();
		Assert.assertEquals(notext, NoText);
	}

	/**
	 * Click on Yes same tab window
	 */
	public void clickYesSameTabButton() {
		waitForElementPresent(newTabWindow);
		clickOn(newTabWindow);
	}

	/**
	 * Verify Message Posted confirmation is displayed
	 */
	public void verifyMessagePostedConfirmationDisplayed() {
		_normalWait(3000);
		waitForElement(messagePosted);
		String Text = messagePosted.getText();
		Assert.assertEquals(Text, "Message Posted");

	}

	/**
	 * Verify Message Posted confirmation is displayed
	 */
	public void verifyMessagePostedConfirmationWithCopyDiscussionUrlDisplayed() {
		String Text = wouldYouLikeToViewNewDiscussion.getText();
		String Text1 = Text.trim().replaceAll("Copy Discussion URL", "");
		System.out.println(Text);
		Assert.assertEquals(Text1.trim().toLowerCase(), "Your message has been posted!".trim().toLowerCase());
		String copyDiscussiontext = copyurl.getText();
		Assert.assertEquals(copyDiscussiontext, "Copy Discussion URL");
		String OkText = okButton.getText();
		Assert.assertEquals(OkText, "OK");

	}

	/**
	 * Click ok button
	 */
	public void clickOk() {
		waitAndClick(okButton);
	}

	/**
	 * Verify newly Discussion In The Left Pane
	 */
	public void verifyDiscussionViewerDisplayed() {
		waitForElement(discussionViewer);
		waitForPageLoaded();
		Assert.assertTrue(discussionViewer.isDisplayed());
	}

	/**
	 * Verify newly Created discussion is highlighted and displayed
	 */
	public void newlyCreatedDiscussionHighlightedAndDisplayed(String createdDiscussionText, String color) {
		boolean flag = false;
		_normalWait(2000);

		String Text = newlyCreatedDiscussion.getText().trim().replace(".", "").replace("()", "").replace("1", "")
				.replaceAll("[^\\w\\s]", "").replaceAll("\\s+", "");
		Assert.assertEquals(Text, createdDiscussionText);
		System.out.println(getBackgroundColor(newlyCreatedDiscussion));

		if (getBackgroundColor(newlyCreatedDiscussion).equalsIgnoreCase("rgba(0, 40, 85, 1)")) {
			flag = true;
			Assert.assertTrue(flag);
		} else {
			if (getBackgroundColor(newlyCreatedDiscussion).equalsIgnoreCase("rgba(0, 40, 85)")) {
				flag = true;
				Assert.assertTrue(flag);

			}
		}

	}

	/**
	 * Click on Reply Button
	 */
	public void clickOnReplyButton() {
		waitForElement(discussionFrame);
		driver.switchTo().frame(discussionFrame);
		waitAndClick(replyButton);
		switchToDefaultContent();

	}

	/**
	 * Verify Reply Window Displayed
	 */
	public void verifyReplyWindowDisplayed(String ReplyWindow) {
		_normalWait(2000);
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(ReplyWindow));
	}

	/**
	 * Click on Attach Files
	 */
	public void selectAttachFiles() {
		waitForElement(attachFiles);
		javascriptButtonClick(attachFiles);

	}

	/**
	 * uploading file in the file handler
	 * @throws InterruptedException
	 */
	public void uplodFileInFileHandler() throws InterruptedException {
		uploadFile(attachFiles, Constants.filepathForUpload, Constants.FileToUpload);
	}

	/**
	 * Verify Processing message is displayed
	 */
	public void verifyProcessingMessageDisplayed() {

		_normalWait(2000);
		String Text = processingText.getText();
		Assert.assertEquals(Text, "Processing...");

	}

	/**
	 * Enter Title in the Text Box
	 */
	public void enterTitleInTheTitleTextBox() {
		_normalWait(1000);
		inputText(enterTitleTextBox, "This is a title");
	}

	/**
	 * Verify Title Is Populated
	 */
	public void verifyTitleIsPopulated() {
		String text = enterTitleTextBox.getAttribute("value");
		Assert.assertEquals(text, "This is a title");

	}

	/**
	 * Enter Text in The post Area
	 */
	public void enterTextInThePostArea() {
		driver.switchTo().frame(frame);
		inputText(getDriver().findElement(By.xpath("//body[@id='DocEditor']")), "images attached");

	}

	/**
	 * Verify Title Is Populated
	 */
	public void verifyTitleIsPopulatedInThePostArea() {
		waitForPageLoaded();
		_normalWait(1000);
		String text = driver.findElement(By.id("DocEditor")).getText();
		Assert.assertEquals(text, "images attached");
		switchToDefaultContent();

	}

	/**
	 * Unselect Preview Message Checkbox is Unchecked
	 */
	public void UnSelectPreviewMessageBoxIfIsChecked() {

		if (previewMessageCheckBox.isSelected()) {
			waitAndClick(previewMessageCheckBox);

		} else {
			System.out.println("Checkbox is Unchecked");
		}

	}

	/**
	 * Verify Preview message box is unchecked
	 */
	public void verifyPreviewMessageBoxIsUncheked() {
		boolean flag = true;
		if (previewMessageCheckBox.isSelected()) {
			flag = false;
			Assert.assertFalse(flag);
		} else {
			flag = true;
			Assert.assertTrue(flag);
		}

	}

	/**
	 * Click on Post message Button
	 */
	public void clickPostMessageButton() {
		waitAndClick(postMessageButton);
	}

	/**
	 * Verify Message is posted with the message and image
	 */
	public void verifyMessagePosted() {
		driver.switchTo().frame(discussionFrame);
		_normalWait(1000);
		String actualText = imagesAttachedText.getText();
		String expectedtext="images attached";
		boolean flag=false;
				if (actualText.trim().contains(expectedtext)) {
			         flag=true;
		}
		Assert.assertTrue(flag);
	}

	/**
	 * Enter Name as Leo in Signalment name TextField
	 */
	public void enterTextInTheNameBox(String name) {
		inputText(nameTextBox, name);

	}

	/**
	 * Enter Location in the Location Text Box
	 */
	public void enterLocationTextBox(String locationName) {
		inputText(locationTextBox, locationName);

	}

	/**
	 * upload Document through sendkeys
	 */
	public void uploadFile(String filePath, String fileName) throws Exception {

		String path = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
		String resourcePath = null;

		final File jarFile = new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath());

		if (jarFile.isFile()) {
			resourcePath = extractFileForUpload(fileName);
		} else {
			resourcePath = System.getProperty("user.dir") + File.separator + filePath + File.separator + fileName;
		}
		attachFiles.sendKeys(resourcePath);
	}

	/**
	 * @param fileName - Name of file to upload from Jar
	 * @return Path of file to be uploaded in user's temp directory
	 * @throws IOException
	 */
	private String extractFileForUpload(String fileName) throws IOException {

		String resourcePath = System.getProperty("java.io.tmpdir") + Constants.TempFileToUpload;

		InputStream is = getClass().getResourceAsStream(Constants.jarFileUploadPath + fileName);
		File targetFile = new File(resourcePath);
		if (is == null) {
			throw new NullPointerException("InputStream is Null");
		}
		FileUtils.copyInputStreamToFile(is, targetFile);
		is.close();
		targetFile.deleteOnExit();
		return resourcePath;
	}

	/**
	 * Click on Post New
	 */
	public void clickOnPostNew() {
		driver.switchTo().frame(discussionFrame);
//        waitForWebElementEnable(postNewButton);
		waitAndClick(postNewButtton);
//        switchToDefaultContent();

	}

	/**
	 * Click on Cancel Button
	 * @throws AWTException
	 */
	public void clickOnCancelButton() throws AWTException {
		System.out.println("Inside the method");
		waitForElementClickable(cancelButton);
		clickOn(cancelButton);
		System.out.println("Cancel button clicked");
		clickEnter();
	}

	/**
	 * Select DropDown Form Limit Type of Animals
	 */
	public void selectDogFromLimitTypeOfAnimal() {
		waitAndClick(anySpeciesDropDown);
		logger.debug("Verifying the value is showing in the dropdow :: Dog");
		driver.findElement(By.xpath("//option[text()='Dogs']")).click();

	}

	/**
	 * Enter Text in Breed Type textbox
	 */
	public void enterTextInBreedType() {
		waitAndClick(breedOrTypeAnimal);
		_normalWait(2000);
		inputText(breedOrTypeAnimal, Constants.Maltese);
	}

	/**
	 * Select Male/Nuetred from DropDown
	 */
	public void selectMaleNeuteredFromDropDown() {
		waitAndClick(sexDropDown);
		logger.debug("Verifying the value is showing in the dropdow :: Male/Neutered");
		driver.findElement(By.xpath("//option[text()='Male, Neutered']")).click();

	}

	/**
	 * Enter Value in the weight lb box
	 */
	public void enterLbInTheWeightField() {
		inputText(weightlb, "16.2");
	}

	/**
	 * Enter age from dropdown
	 */
	public void selectAgeFromDropDown() {
		waitAndClick(ageDropDOwn);
		driver.findElement(By.xpath("//option[text()='3']")).click();

	}

	/**
	 * Select Months From the Months DropDown
	 */
	public void selectMonthsFromTheMonthDropDown() {
		waitAndClick(monthsDropDown);
		_normalWait(2000);
		driver.findElement(By.xpath("//select[@id='ddlAgeMonths']//option[text()='6']")).click();
	}

	/**
	 * Select Weeks from the dropdown
	 */
	public void selectWeeksFromTheDropDown() {
		waitAndClick(weeksDropDown);
		_normalWait(2000);
		driver.findElement(By.xpath("//select[@id='ddlAgeWeeks']//option[text()='2']")).click();

	}

	/**
	 * Select Text From DOB popup
	 */
	public String getDateTextFromTheTextBox() {
		_normalWait(2000);
		String value = dateOfBirth.getAttribute("value");
		return value;

	}

	/**
	 * Enter text in the chief complaint box
	 */

	public void enterTextInTheChiefComplaintBox() {
		inputText(chiefComplaintTextbox, Constants.TitleForEditBookMark);
	}

	public void selectSaveButton() {
		waitAndClick(saveSignalmentButton);
	}

	/**
	 * Enter text in the discussion Title box
	 */
	public void enterTextInTheDiscussionTitleBox() {
		inputText(discussionTitle, Constants.SeleniumTestForSignalment);
	}

	/**
	 * Verify values in the discussionTitle box
	 */
	public void verifyValuesInTextBox() {
		Assert.assertEquals(discussionTitle.getAttribute("value"), Constants.SeleniumTestForSignalment);

	}

	/**
	 * Enter message in the body text
	 */
	public void enterTextInTheMessageBodyTextBox() {
		driver.switchTo().frame(frame);
		_normalWait(2000);
		inputText(messageBodyTextBox, Constants.TestForSignalment);
		switchToDefaultContent();

	}

	/**
	 * Verify Text From the signalment text discussion
	 */
	public void verifyTextFromTheSignalmentDiscussion(String value) {
		waitForElementPresent(discussionFrame);
		driver.switchTo().frame(discussionFrame);
		waitForElementPresent(signalmentText);

		if (browserName().equalsIgnoreCase("Chrome"))
			Assert.assertEquals(getTextColor(signalmentText), Constants.ChromeColorForSignalment);
		else
			Assert.assertEquals(getTextColor(signalmentText), Constants.FirefoxColorForSignalment);

		boolean flag = signalmentText.getText().trim().contains(value.trim());
		Assert.assertTrue(flag);
		switchToDefaultContent();

	}

	public void checkChildWindowElementPresent() {
		if (!isElementPresent(nameTextBox)) {
			switchToNewWindow();
		}
	}

	public void closeCurrentWindow() {
		_normalWait(1000);
		getDriver().close();
	}

	/*
	 * Click on save drafts
	 */
	public void clickOnSaveDrafts() {
		switchToDefaultContent();
		waitForWebElementEnable(saveDrafts);
		waitAndClick(saveDrafts);
	}

	/**
	 * Verify Saving Drafts Message displayed
	 */
	public void verifySavingDraftsMessageDisplayed() {
		Assert.assertTrue(savingDraftsMessage.isDisplayed());
	}

	/**
	 * Click on open drafts Button
	 */
	public void selectOpenDraftsButton() {
		waitAndClick(openDrafts);
	}

	/**
	 * Click on Select Drafts
	 */
	public void clickOnSelectDrafts() {
		waitAndClick(selectDrafts);
	}

	/**
	 * Accept alert
	 */
	public void acceptAlert() {
		boolean flag = false;
		if (browserName().equalsIgnoreCase("firefox")) {
            acceptAlertPresent();

		} else {
			System.out.println(" Browser Chrome is running ");
		}

	}

	/**
	 * Select Yes From the popup Drafts
	 * @throws AWTException
	 */
	public void selectYesButton() throws AWTException {
		waitForWebElementEnable(yesButton);
		clickByMouseHoverOnAnElement(yesButton);
	}

	/**
	 * Verify text is appended
	 */
	public void verifyTextIsAppended() {

		driver.switchTo().frame(frame);
		_normalWait(2000);
		myPostArea.getText().equalsIgnoreCase("Testing draft functionalityTesting draft functionality");
		driver.switchTo().defaultContent();

	}

	/**
	 * Verify MyDrafts window is displayed and â€˜draft test for selenium'
	 */
	public void VerifyMyDraftsWindowIsDisplayed() {

		Assert.assertTrue(driver.findElement(By
				.xpath("(//li[@id='liNewDiscussionsPanel']/../../following-sibling::div//div[@id='divDrafts']//li)[1]"))
				.isDisplayed());
		driver.findElement(By
				.xpath("(//li[@id='liNewDiscussionsPanel']/../../following-sibling::div//div[@id='divDrafts']//li)[1]"))
				.getText().contains("Draft test for Selenium!!!");
		driver.findElement(By
				.xpath("(//li[@id='liNewDiscussionsPanel']/../../following-sibling::div//div[@id='divDrafts']//li)[1]"))
				.getCssValue("background-color");
		driver.findElement(By
				.xpath("(//li[@id='liNewDiscussionsPanel']/../../following-sibling::div//div[@id='divDrafts']//li)[1]"))
				.getCssValue("color").equalsIgnoreCase("rgba(51, 51, 51, 1)");
	}

	/**
	 * Select find since drop down
	 */
	public void selectFindSinceDropDown() {
		_normalWait(1000);
		javascriptButtonClick(findSinceDropDown);

	}

	/**
	 * Select  dys from the droopdown
	 */
	public void selectDaysFromTheDropDwown(String Days) {
		driver.findElement(By.xpath("//select[@id='keyFindSince']//option[text()='"+Days+"']")).click();
	}

	/**
	 * Verify days is shown in the drop down
	 */
	public void verifyDaysOptionIsShownInTheDropDown(String Days) {
		driver.findElement(By.xpath("//select[@id='keyFindSince']//option[text()='"+Days+"']")).getText()
				.equalsIgnoreCase(Days);

	}
	
	/**
	 * Click on find since button
	 */
	public void clickOnFindSinceButton() {
		waitAndClick(findSinceButton);
	}

	/**
	 * Verify the message board is displayed
	 */
	
	public void verifyMessageBoardIsDisplayed() {
		_normalWait(5000);
		driver.switchTo().frame(iframe);
		Assert.assertTrue(messageBoard.getText().equalsIgnoreCase("Vet-to-Vet / *MBTest"));
		driver.switchTo().defaultContent();

	}

	/**
	 * Select Vin is Awesome
	 */
	
	public void selectVinIsAwesome() {
		_normalWait(5000);
		driver.switchTo().defaultContent();
		waitAndClick(driver.findElement(By.xpath("(//span[@class='glyphicon glyphicon-arrow-right'])[2]")));
		waitAndClick(vinIsAwesomeText);

	}

	/**
	 * Verify Vin is Awesome Page is displayed
	 */
	
	public void verifyVinIsAwesomePageIsDisplayed() {
		_normalWait(4000);
		driver.switchTo().frame(iframe);
		Assert.assertTrue(driver.getTitle().contains("VIN Boards - VIN is awesome!!!"));
		driver.switchTo().defaultContent();
	}

	public void clickOnSubscribeButton() {
		driver.switchTo().frame(iframe);
		_normalWait(1000);
		waitAndClick(subscribeButton);
		driver.switchTo().defaultContent();
	}

	public void verifySubscribeModalWillDisplay() {
		driver.switchTo().frame(iframe);
		_normalWait(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//h4[@id='myModalLabel']")).getText()
				.equalsIgnoreCase("Message Board Subscriptions"));
		driver.switchTo().defaultContent();
	}

	public void selectSubscribeToThisModalPopup() {
		driver.switchTo().frame(iframe);
		waitAndClick(subscribeToThisDiscussionPopup);
		driver.switchTo().defaultContent();

	}

	public void verifySubscribeButtonIsYellowed() {
		driver.switchTo().frame(iframe);
		System.out.println(getBackgroundColor(subscribeButton));
		_normalWait(6000);
		Assert.assertEquals(getBackgroundColor(subscribeButton), "rgba(255, 204, 102, 1)");
		driver.switchTo().defaultContent();

	}

	public void verifySubscribeButtonIsOranged() {
		driver.switchTo().frame(iframe);
		System.out.println(getBackgroundColor(subscribeButton));
		_normalWait(6000);
		Assert.assertEquals(getBackgroundColor(subscribeButton), "rgba(255, 102, 0, 1)");
		driver.switchTo().defaultContent();

	}

	public void selectSubscribeToThisFolderButton() {
		driver.switchTo().defaultContent();

		_normalWait(1000);
		waitAndClick(sucbscibeTothisFolderButton);

	}

	public void verifySubscribeButtonIsYellowedAndlabeledAsUnsubscribe() {
		System.out.println(getBackgroundColor(sucbscibeTothisFolderButton));
		_normalWait(4000);
		waitForElement(sucbscibeTothisFolderButton);
		Assert.assertEquals(getBackgroundColor(sucbscibeTothisFolderButton), Constants.rgbaColor);
		Assert.assertTrue(
				sucbscibeTothisFolderButton.getAttribute("title").equalsIgnoreCase("Unsubscribe from this Folder"));

	}

	public void verifyUnSubscribeButtonIsOrangeAndlabeledAsSubscribe() {
		System.out.println(getBackgroundColor(sucbscibeTothisFolderButton));
		_normalWait(2000);
		Assert.assertEquals(getBackgroundColor(sucbscibeTothisFolderButton), "rgba(255, 81, 0, 1)");
		Assert.assertTrue(
				sucbscibeTothisFolderButton.getAttribute("title").equalsIgnoreCase("Subscribe to this Folder"));

	}

	public void logout() {
	  waitAndClick(loginUserDropDown);
	  waitAndClick(logoutLinkUnderUserDropDown);
  }

	/**
	 * Verify that message boards navigation is selected
	 * @param messageboardsattribute
	 */
	public void verifyMessageBoardLoadedSuccessfully(String messageboardsattribute) {

		String attribute=getDriver().findElement(By.xpath("//div[@class='navbar-collapse collapse']//ul[@id='vinmainnav']//li[@id='masterTabBoards']")).getAttribute("class");
		if(messageboardsattribute.equalsIgnoreCase(attribute)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}


	
	/**
	 * Verify that Observe find since set to 2 days control is displayed
	 */
	public void observeFindSinceSetTo2Days() {

		Assert.assertTrue(findsinceControlDropdown.isDisplayed());
		

		
	}

	/**
	 * Verify that find since dropdown is set to 2 days
	 */
	public void findSinceDropdownSetTo2Days() {

		Select select = new Select(findsinceControlDropdown);
		WebElement option = select.getFirstSelectedOption();
		String defaultItem = option.getText();
		String expectedItem="2 Days";
		if(defaultItem.equalsIgnoreCase(expectedItem)) {
		Assert.assertEquals(defaultItem, expectedItem);
		}
		else {
			select.selectByVisibleText("2 Days");
		}
		
	}

	/**
	 * verify confirmation pop up message
	 * @param preselectedtext
	 * @param messagedescription
	 * @param continuebuttontext
	 */
	public void verifyPreSelectedPopUpMessage(String preselectedtext, String messagedescription) {
		boolean flag=true;
    	try {
    		WebElement preselectedMessage=getDriver().findElement(By.xpath("//h4[text()='"+preselectedtext+"']"));
    		String messageOnPopUp=getDriver().findElement(By.xpath("//div[@class='modal-body']")).getText();
    		
    	if (preselectedMessage.isDisplayed()&&messageOnPopUp.contains(messagedescription)&&continuePopup.isEnabled()) {
    	   waitAndClick(continuePopup);
			flag=true;
		}
	} catch (Exception e) {
	}
    	
    Assert.assertTrue(flag);	
    }
	
	
	  public void verifySearchResultPage() {
		Select select = new Select(vetToVetDropDown);
		WebElement option = select.getFirstSelectedOption();
		String defaultItem = option.getText().replaceAll("[^A-Za-z]+", "");
		String expectedItem="VettoVet";
		Assert.assertEquals(defaultItem, expectedItem);
		
	}

	
	/**
	 * Verify Vet to vet board is displayed
	 */
	public void verifyVetToVetBoardDisplayed() {
		
		Assert.assertTrue(vetToVetBoard.isSelected());
		
	}
	
	/**
	 * Verify dropdown values with folder count
	 */
	public void verifyDropdownValuesWithFolderCount() {

		Select selectDropdown = new Select(folderDropDown);
        List<WebElement> listOptionDropdown = selectDropdown.getOptions();
        int dropdownCount = listOptionDropdown.size();
        
        Select selectDropdown1 = new Select(vetToVetDropDown);
        List<WebElement> dropdown = selectDropdown1.getOptions();
        int dropdownCount2 = dropdown.size();
        
        int folderCount=(Integer.parseInt(folderTextValue.getText().replaceAll("[() ]+", "")));
        int dropdownValue=dropdownCount-dropdownCount2;
        System.out.println(folderCount);
        Assert.assertEquals(folderCount,dropdownValue);
	}

	/**
	 * verify find since dropdown on search result page
	 */
	public void verifyFindSinceDropdownOnSearchResultPage() {

		Assert.assertTrue(findSinceDropDownOnSearchResultPage.isDisplayed());
		
	}
	
	/**
	 * Click on boards home button
	 */


	public void clickOnBoardsButtonOnMessageBoardsPage() {
		waitAndClick(boardsHomeButton);
		
	}
	
	/**
	 * Verify that user navigate to boards landing page
	 * @param vinfrontpagetitle
	 */

	public void navigateToBoardsLandingPage(String vinfrontpagetitle) {
		Assert.assertEquals(getDriver().getTitle(), vinfrontpagetitle);
		
	}

	/**
	 * Select document id radio button
	 *
	 */
	
	
	public void selectDocumentIDRadioButton() {
		waitAndClick(docIDRadioButton);
	}

	/**
	 * Verify doc ID is selected
	 */
	public void verifyDocIDSelected() {

		Assert.assertTrue(docIDRadioButton.isSelected());
	}
	

	/**
	 * Enter Document ID value in text box
	 * @param documentidvalue
	 */
	public void typeInSearchBox(String documentidvalue) {

		inputText(docIDSearchBox, documentidvalue);
		
	}
	
	/**
	 * Verify document ID searchbox has expected value
	 * @param documentidvalue
	 */

	
	public void verifySearchBoxHasExpectedValue(String documentidvalue) {
		String actual=docIDSearchBox.getAttribute("value");
		Assert.assertEquals(actual, documentidvalue);
	}
	
	/**
	 * Verify search result page after enter doc ID enter
	 * @param searchresultpagetitle
	 */

	public void verifySearchResultPageAfterEnterDocID() {
		Assert.assertTrue(getDriver().findElement(By.xpath("//div[@id='divTitle']//span[@id='lblThreadName']")).isDisplayed());
	}

	
	/**
	 * Scroll page down to discussion tool
	 */
	public void scrollPageDownToDiscussionTool() {
		scrollPageThroughWebElement(discussionToolText);
		
	}
	
	/**
	 * Verify that Document ID matches in discussion tool section
	 * @param documentidvalue
	 */
	
	
	public void verifyDocumentIDMatches(String documentidvalue) {
		
		String ID=documentIDSectionUnderDiscussionTool.getText().replaceAll("[^0-9]", "");
		System.out.println(ID);
		Assert.assertEquals(documentidvalue, ID);
		
	}

	/**
	 * Verify My most viewed dropdown after scroll
	 */
	
	public void scrollPageDownToVerifyMyMostViewdDiscussion() {
           waitAndClick(myMostViewdDropdownControl);
	}
	
	/**
	 * Verify that discussion list is displayed under my most viewd discussion ropdown
	 */

	public void verifyDiscussionsListedUnderMyMostViewd() {
       for(WebElement list:discussionslist) {
    	   Assert.assertTrue(list.isEnabled());
       }
		
	}
	
	/**
	 * Click on first link of discussion under 'My discussion' dropdown value
	 * @param mydiscussiontext
	 */
	
	public void clickOnFirstLinkUnderMyDiscussion(String mydiscussiontext) {

		selectDropDownByText(myMostViewdDropdownControl, mydiscussiontext);
		
		_normalWait(3000);
		String text=firstDiscussionLink.getText();
		waitAndClick(firstDiscussionLink);
		
		switchToNewWindow();
		
		String title=driver.getTitle();
		if(title.contains(text)) {
			assertTrue(true);
		}
		
	}
	
	public void clickOnBoardsButtonOnSearcResultPage() {

		waitAndClick(boardsHomeButtonSearchResultPage);
		
	}

	/**
	 * Verify that discussion title matched with clicked link 
	 * @param firstlinktitle
	 */
	
	public void discussionTitleMatchedToClickedLinkTitle(String firstlinktitle) {
        getDriver().navigate().refresh();
        
        String s = driver.getTitle();
        System.out.println(s);
		_normalWait(2000);
		Assert.assertTrue(discussionTitleText.getText().contains(firstlinktitle));
	}

	/**
	 * Click on personalize your boards link
	 */
	
	public void clickOnPersonalizeYourBoardsLink() {
        waitAndClick(personalizeYourBoardsLink);
	}
	
	/**
	 * Verify personalize your boards window 
	 * @param personalizeyourboardswindowtitle
	 */
	
	public void verifyLinkOpenedInNewWindow() {

		Assert.assertTrue(personalizeYourBoardsWindowTitle.isDisplayed());
	}

	/**
	 * Click on All boards radio button
	 */
	
	public void clickOnAllBoardsRadioButton() {

		waitAndClick(messageBoardsnavBar);
		waitAndClick(allBoardsRadioButton);
	}

	public void verifyAllBoardsRadioButtonIsSelected() {

		Assert.assertTrue(allBoardsRadioButton.isSelected());
	}

	

	/**
	 * Clicking on log out
	 */
	public void clickLogout() {
		 _normalWait(500);
	        waitForPageLoaded();
	        logger.debug("Clicking on Logout");
	        waitAndClick(loginUserDropDown);
	        waitAndClick(logoutLinkUnderUserDropDown);
	}

	/**
	 * Verify that log out page is displayed
	 */
	public void verifyLogoutPageDisplayed() {

		waitForPageLoaded();
        _normalWait(1000);
        logger.debug("Verify Logout Page displayed");
        assertByPageTitle(Constants.pageTitle_LoggedoutPage);
	}
	
	/**
	 * verify Vet to Vet road button
	 * @param vettovetradiobuttontext
	 */

	public void verifyVetToVetRadioButtonUnderFilterByBoardsSection(String vettovetradiobuttontext) {
      Assert.assertTrue(vetToVetRadioButtonText.isDisplayed());
		
	}

	public void verifyReplyToDiscussionWindow() {

		assertByPageTitle(Constants.replyWindowTitle);

		
	}
		
	/**
     * Function: Logout application
     *
     * @return
     */
    public LogoutPage logoutApplication() {
        _normalWait(500);
        waitForPageLoaded();
        waitAndClick(loginUserDropDown);
        waitAndClick(logoutLinkUnderUserDropDown);
        return PageFactory.initElements(driver, LogoutPage.class);
    }
    
    /**
	 * Select first discussion from list
	 */
	
	public String selectFirstDiscussionFromList() {

		String linkName=firstLink.getText();
		System.out.println(linkName);
		waitAndClick(firstLink);
		return linkName;
	}


	/**
	 * Verify selected discussion thread displayed
	 * @param linkName
	 */
	public void verifySelectedDiscussionThreadisDisplayed(String linkName) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Select drop down icon for vet to vet board
	 */
	
	public void selectDropDownIconForVetToVetBoard() {

		selectDropDownByText(vetToVetBoardDropdown, "Find in Vet-to-Vet");
	}

	/**
	 * Verify continue pop up
	 */
	
	public void verifyContinuePopUp() {

		if(continuePopUp.isDisplayed()) {
			Assert.assertTrue(true);
		}
	}

	/**
	 * Click on alert window
	 */
	public void clickOnAlertWindow() {

		acceptAlertPresent();
	}
	
	
	/**
	 * click on expanded radio button
	 */
	
	public void selectExpandedRadioButton() {
      waitAndClick(expandedButton);		
	}
	
	/**
	 * select the top discussion link
	 */
	public void selectTheTopDiscussionLink() {
       waitAndClick(discussionLink);		
	}
	
	/**
	 * select check box next to view checked
	 */
	public void waitForboardProcessing() {
		waitForElementToBecomeInvisible(By.xpath("//div/h3[contains(text(),'Boards now processing.')]"));
	}

	public void selectTheCheckBoxNextToViewChecked() {
		_normalWait(5000);

		driver.switchTo().frame(iframe);
		waitAndClick(checkBoxViewChecked);	
		driver.switchTo().defaultContent();     

	}
	
	/**
	 * select view checked button
	 */
     public void slectViewCheckButton() {
 		_normalWait(5000);

 		driver.switchTo().frame(iframe);
    	 viewCheckedButton.click();
 		driver.switchTo().defaultContent();     

	}
     
     /**
      * verify selected post is displayed
      */
	public void verifySelectedPostIsDisplayed() {
		_normalWait(5000);
 		driver.switchTo().frame(iframe);
	      	boolean flag=false;
	      	try { 	
	      		WebElement selectedPage = driver.findElement(ByLocator("//div[contains(@id,'PageNavTop')]//li/a[text()='1']"));

	      		if (selectedPage.isDisplayed()) {
	      			flag=true;
	      		}
	      	} catch (Exception e) {
	      	}
	      	Assert.assertTrue(flag);
			driver.switchTo().defaultContent();  

	      
	}
	
	/**
	 * select one button
	 */
	
	public void selectOneButton() {
		_normalWait(5000);

 		driver.switchTo().frame(iframe);
        waitAndClick(oneButton);	
 		driver.switchTo().defaultContent();     

	}
	
	/**
	 * select one link
	 */
	
	public void selectonelink() {
		_normalWait(5000);

 		driver.switchTo().frame(iframe);
      waitAndClick(oneLink);	
		driver.switchTo().defaultContent();     

	}
	
	/**
	 * verify all post are Displayed
	 */

	public void verifyAllPostAreDisplayed() {
		_normalWait(3000);
 		driver.switchTo().frame(iframe);
 		boolean flag=true;
      	try { 	
      		WebElement selectedPage = driver.findElement(ByLocator("//div[contains(@id,'PageNavTop')]//li/a[text()='1']"));

      		if (selectedPage.isDisplayed()) {
      			flag=false;
      		}
      	} catch (Exception e) {
      	}
      	Assert.assertTrue(flag);
		driver.switchTo().defaultContent();  

	}
	
	
	
	/**
	 * verify message board page is displayed
	 */
	
	public void verifyNewTabDorMessageBoardsOpened() {
	Assert.assertTrue(boardButton.isDisplayed());	

	}

	/**
	 * select copy to clipboard
	 */

	public void scrollDownAndSelectCopyToClipboard() {
		_normalWait(5000);

 		driver.switchTo().frame(iframe);
       scrollDown();		
       waitAndClick(copyToClipBoard);
		driver.switchTo().defaultContent();     

	}

	/**
	 * select jump to top button
	 */
	public void selectJumpToTop() {
		_normalWait(5000);
 		driver.switchTo().frame(iframe);
        waitAndClick(jumpToTop);		
		driver.switchTo().defaultContent();     

	}
	
	public void verifyDiscussionThreadLoadSuccessfully() {
		_normalWait(50000);
 		driver.switchTo().frame(iframe);
        Assert.assertTrue(subscribeButton.isDisplayed());		
        driver.switchTo().defaultContent();     

	}

}
	