package com.vin.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.itextpdf.tool.xml.html.Break;
import com.vin.selenium.core.BasePage;

public class JournalsPage extends BasePage {

	public JournalsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='txtJournalSearch']")
	private WebElement inputTextBox;

	@FindBy(xpath = "//button[@id='btnJournalSearch']")
	private WebElement searchIconMagnifier;

	@FindBy(xpath = "//a[@class='SearchResult']")
	private List<WebElement> searchResults;

	@FindBy(xpath = "//table[@class='table table-hover table-condensed']")
	private WebElement tableContent;

	@FindBy(xpath = "//input[@id='vchk']")
	private List<WebElement> checkboxex;

	@FindBy(xpath = "//button[@id='btnClearSearch']")
	private WebElement clearButton;

	@FindBy(xpath = "//a[@aria-controls='profile']")
	private WebElement browseJournalList;

	@FindBy(xpath = "//h3[contains(text(),'Journals by Title')]")
	private WebElement titleJournals;

	@FindBy(xpath = "//li/a[@id='lnk_J']")
	private WebElement JButton;

	@FindBy(xpath = "//div[@id='ProjectPanelJList']//table[@class='body']//tr")
	private List<WebElement> textsWithJ;

	@FindBy(xpath = "//a[contains(text(),'American Veterinary Medical Association')]/../..//button")
	private WebElement passwordVault;

	@FindBy(xpath = "//select[@onchange='OnChange_JournalsCollection(this)']//option[@value='1']")
	private WebElement collectionText;

	@FindBy(xpath = "//label[contains(text(),'veterinariae')]/../..//button[contains(text(),'Browse on VIN')]")
	private WebElement browseOnVinForscientiae;

	@FindBy(xpath = "//label[contains(text(),'pharmaciae')]/../..//button[contains(text(),'Browse on VIN')]")
	private WebElement browseOnVinForPharma;

	@FindBy(xpath = "//a[text()='Directory of Open Access Journals']")
	private WebElement directoryOfOpenSource;

	@FindBy(xpath = "(//a[@title='Open link in new window'])[1]")
	private WebElement clinicalUpdates;

	@FindBy(xpath = "//strong[contains(text(),'VIN Clinical Update')]")
	private WebElement clinicalUpdatePage;

	@FindBy(css = "div[id='menu'] div[id='topNav'] a[id='loginmenu']")
	private WebElement loginUserDropDown;

	@FindBy(css = "div[id='menu'] div[id='topNav'] ul[role='menu'] a[class='MemberProfile_Logout']")
	private WebElement logoutLinkUnderUserDropDown;
	
	@FindBy(xpath="(//div[@id='ClinicalUpdatesJournal_body']//a)[1]")
	private WebElement clinicalLinktext;
	
	@FindBy(xpath="//div[@id='ContentBody_Document2_ctl00_DocumentTitlePanel']")
	private WebElement linkLabelInNewTab;
	
	@FindBy(xpath = "//span[@id='lblPageHeader']")
	private WebElement passwordVaultHeader;

	/**
	 * Verify Journals Page displayed
	 */
	public void verifyJournalsPageDisplayed() {
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Journals - VIN"));
	}

	/**
	 * Enter Pit bull in the textbox
	 */
	public void enterTextInTheSearchJournals() {
		inputText(inputTextBox, "pit bull");
	}

	/**
	 * Verify Text in the textBox
	 */
	public void verifyTextInTheTextBox() {
		Assert.assertEquals(inputTextBox.getAttribute("value"), "pit bull");
	}

	/**
	 * Select search icon magnifier
	 */
	public void selectSearcgIconMagnifier() {
		waitAndClick(searchIconMagnifier);
	}

	/**
	 * Verifying results is displayed on the page
	 */
	public void verifyLinksIsDisplayedOnThePages() {
		boolean flag = false;
//	Assert.assertTrue(tableContent.isDisplayed());
//	
		if (searchResults.size() > 0) {
			flag = true;
			Assert.assertTrue(flag);

		}
	}

	/**
	 * Verify checkbox is unchecked
	 */
	public void verifyCheckBoxIsUnchecked() {
		boolean flag = false;
		for (WebElement we : checkboxex) {
			if (we.isSelected()) {
				flag = true;

			}
			Assert.assertFalse(flag);

		}
	}

	/**
	 * Select clear Button
	 */
	public void seletClearButton() {
		waitAndClick(clearButton);

	}

	/**
	 * Verify no text Is Present in the textbox after clicking on clear button
	 */

	public void verifyNoTextIsPresentInTheTextBox() {
		Assert.assertEquals(inputTextBox.getAttribute("value"), "");
	}

	/**
	 * Select browse journal List
	 */
	public void selectBrowseJournalList() {
//		if(browseJournalList.isDisplayed()) {
//		waitAndClick(browseJournalList);
//		_normalWait(3000);
//		//Assert.assertTrue(titleJournals.getText().contains("Journals"));
//
//		}else {
//			waitAndClick(JButton);
//
//		}
		
		List<WebElement> li= driver.findElements(By.xpath("//a[@aria-controls='profile']"));
	    if(li.size()>0) {
	    	li.get(1).click();
	    	verifyTitleOfTheJournalsPAge();
	    }
	    else {
           System.out.println("browse journal list is not displayed");
	    }
		}
	

	/**
	 * Verify the title of the journals page
	 */

	public void verifyTitleOfTheJournalsPAge() {
		_normalWait(3000);
		Assert.assertTrue(titleJournals.getText().contains("Journals"));

	}

	/**
	 * Select A Button
	 */
	public void selectJButton() {
		waitAndClick(JButton);
	}

	/**
	 * Verify the text present in the list starts with j
	 */
	public void verifyTheTextInTheListStartsWithJ() {
		boolean flag = false;
		for (WebElement a : textsWithJ) {
//		scrollDown();
			if (a.getText().replace('j', 'J').contains("Journal")) {
				flag = true;

			}
			Assert.assertTrue(flag);
		}

	}

	/**
	 * Selecct password Vault button
	 */
	public void selectpasswordVaultButton() {
		_normalWait(2000);
        scrollDown();
        javascriptButtonClick(passwordVault);
	}

	/**
	 * Verify the Password vault page
	 */
	public void verifyPasswordVaultPageIsDisplayed() {
		Assert.assertTrue(passwordVaultHeader.isDisplayed());
	}

	/**
	 * Select drop down choose collection
	 * 
	 */

	public void selectDropDown() {
		driver.findElement(By.xpath("//select[@onchange='OnChange_JournalsCollection(this)']")).click();
	}

	/**
	 * Select current from the list
	 */
	public void selectCurrentFromTheList() {
		driver.findElement(By.xpath("//select[@onchange='OnChange_JournalsCollection(this)']//option[@value='1']"))
				.click();
	}

	/**
	 * Verify Value is selected as current
	 */
	public void verifyValueIsSelectedAsCurrent() {
		Assert.assertTrue(collectionText.getText().contains("Current"));

	}

	/**
	 * Select browse on vin for scientae
	 */
	public void selectBrowseOnVinButtonForScientae() {
		waitAndClick(browseOnVinForscientiae);
	}

	/**
	 * Verify Acta scientae page displayed
	 */
	public void verifyActaScientaepageDisplayed() {
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Acta Sci Vet"));
	}

	/**
	 * Verify Acta scientae page displayed
	 */
	public void verifyActaPharmaciaepageDisplayed() {
		Assert.assertTrue(driver.getTitle().contains("Pharm"));
	}

	/**
	 * Select In active Publication from the list
	 */
	public void selectinActivePublicationFromTheList() {
		driver.findElement(By.xpath("//select[@onchange='OnChange_JournalsCollection(this)']//option[@value='2']"))
				.click();
	}

	/**
	 * Verify Value is selected as in active Publication
	 */
	public void verifyValueIsSelectedAsPublication() {
		Assert.assertTrue(driver.findElement(By.xpath("//select[@onchange='OnChange_JournalsCollection(this)']"))
				.getAttribute("value").contains("publication"));
		Assert.assertTrue(collectionText.getText().contains("publication"));

	}

	/**
	 * Select browse on vin for scientae
	 */
	public void selectBrowseOnVinButtonForPharmacciae() {
		waitAndClick(browseOnVinForPharma);
	}

	/**
	 * Verify Acta scientae page displayed
	 */
	public void verifyActaHistoricapageDisplayed() {
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("historica"));
	}

	/**
	 * Select Directory of open source
	 */
	public void selectDirecotryOpenSource() {
		waitAndClick(directoryOfOpenSource);
	}

	/**
	 * Verify Directory open source Page displayed
	 */
	public void verifyOpenSourcepAgeDisplayed() {
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Directory of Open Access Journals"));
	}

	/**
	 * Select clinical update link
	 */
	
	
	public String selectClinicalUpdatesLink() {
		String linktext=clinicalLinktext.getText();
		waitAndClick(clinicalUpdates);
		return linktext;
	}

	/**
	 * Verify Clinical Updates Page is displayed
	 */
	
	public void verifyClincalPageeIsDisplayed(String nameToVerified) {
		Assert.assertEquals(nameToVerified,linkLabelInNewTab.getText());
	}

	/*
	 * Logout Application
	 */

	public LogoutPage logoutApplication() {
		_normalWait(500);
		waitForPageLoaded();
		waitAndClick(loginUserDropDown);
		waitAndClick(logoutLinkUnderUserDropDown);
		return PageFactory.initElements(driver, LogoutPage.class);
	}

	/**
	 * Select choose collection button
	 */
	
	@FindBy(xpath="")
	private WebElement chooseCollection;
	public void selectChooseCollectionButton() {

		waitAndClick(chooseCollection);
	}
}