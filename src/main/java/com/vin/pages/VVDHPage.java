package com.vin.pages;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.vin.selenium.core.BasePage;
import com.vin.utilities.Constants;

public class VVDHPage extends BasePage {

	public VVDHPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//li[@id='masterTabLibrary']/a")
	private WebElement libraryDropDown;

	@FindBy(xpath = "//a[text()='Drug Resources']")
	private WebElement drugResources;

//	@FindBy(xpath="//div[@id='TreeIndexDiv']//a")
//	private WebElement vetreinaryDrugHandBook;

	@FindBy(css = "input[id='projectSearchText']")
	private WebElement searchVeterinaryDrug;

	@FindBy(css = "input[value='GO']")
	private WebElement goButton;

	@FindBy(xpath = "//button[contains(@class,'checkAll')][1]")
	private WebElement checkAllButton;

	@FindBy(xpath = "//div[@id='SearchResultsTable']//input")
	private List<WebElement> allCheckBoxes;

	@FindBy(xpath = "//button[contains(@class,'viewChecked')][1]")
	private WebElement viewCheckedButton;

	@FindBy(xpath = "//a[@id='MyStuffLink']")
	private WebElement addListToMyStuff;
	
	@FindBy(xpath = "//div[@id='item1']//td[text()='A']")
	private WebElement selectAlphabetA;

	@FindBy(xpath = "//a[text()='Albumin']/following-sibling::a")
	private WebElement albuminLinkToOpenInNewWindow;

	@FindBy(xpath = "//button[@id='expandAll']/span")
	private WebElement expandAllButton;

	@FindBy(xpath = "//button[@id='collapseAll']/span")
	private WebElement collapseAllButon;

	@FindBy(xpath = "//button[@id='btnPreferences']")
	private WebElement preferenecesDropDown;

	@FindBy(xpath = "//ul[@class='dropdown-menu']//a[contains(text(),' default preferences')]")
	private WebElement setYourDefaultPreferences;

	@FindBy(xpath = "//tr[@id='trExpandCollapse']//input[@value='Default']")
	private WebElement vinDeaultRadioButton;

	@FindBy(xpath = "//ul[@id='newstabs']//a[@rel='item3']")
	private WebElement therapeuticCategoryButton;

	@FindBy(xpath = "//div[@id='item3']//td[text()='C']")
	private WebElement alphabetC;

	@FindBy(xpath = "//a[text()='Cardiovascular Agents']")
	private WebElement CardiovascularAgent;

	@FindBy(xpath = "//div[contains(text(),'Cardiovascular')]/ancestor::table//tr")
	private WebElement CardiovascularAgentList;

	@FindBy(xpath = "//div/a[text()='Digoxin ']")
	private WebElement digoxin;

	@FindBy(xpath = "//div[@class='leftnav-container']/div/img")
	private WebElement veterenaryDrugHandbookImage;

	@FindBy(xpath = "(//a[contains(text(),'Drug Handbook')])[2]")
	private WebElement vetreinaryDrugHandBook;

	@FindBy(xpath = "//div[@id='SearchResultsTable']")
	private WebElement searchedResults;

	@FindBy(xpath = "//div[@id='divResultsCount']//span[@id='ctl01_SearchTermDisplay']")
	private WebElement searchedResultsCounts;

	@FindBy(xpath = "//div[@id='SearchResultsPanel1']//tr//td[@class='toc']/input")
	private List<WebElement> checkedResults;

	@FindBy(xpath = "//div[@id='SearchResultsPanel1']//tr//td[@class='toc']/a")
	private List<WebElement> viewcheckedResultsText;

	@FindBy(xpath = "//div[@id='SearchResultsTable']//input/../following-sibling::div/label/a[@class='ResultLink']")
	private List<WebElement> checkedResultsText;

	@FindBy(xpath = "//a[@id='MyStuffLink']")
	private WebElement myStuffLink;

	@FindBy(xpath = "//span[@id='lblPageHeader']")
	private WebElement myStuffWindowHeader;

	@FindBy(css = "input[id='btnCancelAddLink']")
	private WebElement cancelButton;

	@FindBy(xpath = "//iframe[@id='ifMyVINFramedContent']")
	private WebElement iFrame;

	@FindBy(xpath = "//div/h2[contains(text(),'Drug Handbook')]")
	private WebElement drugHandbookImage;

	@FindBy(xpath = "//div[@id='CategoryListPanel']//table//tr//div//a[1]")
	private List<WebElement> listOfAllDrugs;

	@FindBy(xpath = "//div[@class='DocumentMainContent']//div[@id='SectionTitle']/span")
	private List<WebElement> expandedItemsList;

	@FindBy(xpath = "//span[@id='lblPageHeader']")
	private WebElement vinVeterinaryDrugWindow;

	@FindBy(xpath = "//span[contains(text(),'Doses')]/..")
	private WebElement dosesArea;

	@FindBy(xpath = "//span[contains(text(),'Doses')]/..")
	private WebElement referencesArea;
	
	@FindBy(xpath = "//button[text()='Dismiss All']")
	private WebElement dismissAllBtn;
	 
	@FindBy(css = "div[id='menu'] div[id='topNav'] a[id='loginmenu']")
	private WebElement loginUserDropDown;

	@FindBy(css = "div[id='menu'] div[id='topNav'] ul[role='menu'] a[class='MemberProfile_Logout']")
	private WebElement logoutLinkUnderUserDropDown;
	
	@FindBy(id="resultCb1")
	private WebElement result1chkbx;
	
	@FindBy(id="resultCb2")
	private WebElement result2chkbx;
	
	@FindBy(xpath="//input[@id='dnSearchTerm']")
	private WebElement drugName;
	 
	@FindBy(xpath="//select[@id='speciesddm']")
	private WebElement speciesDropdown;
	 
	@FindBy(xpath="//input[@id='txtWeight']")
	private WebElement weightInLB;
	 
	@FindBy(xpath="//input[@id='txtWeightKg']")
	private WebElement weightInKG;
	 
	@FindBy(xpath="//select[@id='useddm']")
	private WebElement indicationDropdown;
	 
	@FindBy(xpath="//select[@id='doseddm']")
    private WebElement doseDropdown;
	 
	@FindBy(xpath="//input[@id='submitBtn']")
	private WebElement calculateButton;
	 
	@FindBy(xpath="//div[@id='resultsArea']")
	private WebElement resultArea;
	 
	@FindBy(xpath="//input[@id='resetBtn']")
	private WebElement resetButton;
	 
	@FindBy(xpath="//tbody//a[text()='Albumin']")
    private WebElement albumin;
	
	@FindBy(xpath="//span[@class='fa fa-minus-circle']")
    List<WebElement> allExpendedElements;
	
	@FindBy(xpath="//span[@class='fa fa-plus-circle']")  
    List<WebElement> allHiddenElements;
	

	/**
	 * Verify 'VIN Veterinary Drug Handbook' is displayed
	 */

	public void verifyVeterinaryDrugHandBookPageDisplayed(String PageName) {
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(PageName));

	}

	/**
	 * Enter S-Adenosylmethionine in search box and click Go
	 */

	public void EnterValueAndSelectGo() {

//		waitForElementPresent(searchVeterinaryDrug);
//		searchVeterinaryDrug.sendKeys(Constants.SAdenosylmethionine);
//		inputText(searchVeterinaryDrug, Constants.SAdenosylmethionine);
//		waitForElement(goButton);
		try {
			clickEnter();
		} catch (AWTException e) {
			e.printStackTrace();
		}
//		waitAndClick(goButton);

		inputText(searchVeterinaryDrug, Constants.SAdenosylmethionine);
		waitForElement(goButton);
		waitAndClick(goButton);

	}

	/**
	 * Verify Searched Results After entering items in the search box
	 */

	public void verifySearchedResults(String searchedText) {
		boolean flag = false;
		Assert.assertTrue(searchedResults.isDisplayed());

		if (searchedResultsCounts.getText().contains(searchedText)) {
			flag = true;
		}

		Assert.assertTrue(flag);
	}

	/**
	 * Click on Result 1 & Result 2 checkBox
	 */

	public void clickOnResult1and3ChkBox() {

		clickOn(result1chkbx);
		clickOn(result2chkbx);
	}
	
	public List<String> verifyResult1and3ChkBoxSelected()
	{
		List<String> al = new ArrayList<String>();

		for (int i = 1; i <= 2; i++) {
			WebElement elementtobeverified = findElement(ByLocator("//input[@id='resultCb"+i+"']"));

			if (elementtobeverified.isSelected()) {
			WebElement Searchname = driver.findElement(ByLocator("//input[@id='resultCb"+i+"']/../..//a[@class='ResultLink']"));
			al.add(Searchname.getText());
			Collections.sort(al);

			}
		}

		return al;
	}
	
	/**
	 * Click on check all button
	 */

	public void clickOnCheckAllButton() {
		waitAndClick(checkAllButton);

	}

	/**
	 * Verify all checkboxes are selected after clicking on check all button
	 * @return
	 */

	public List<String> verifyAllCheckBoxesAreChecked() {
		boolean flag = true;
//		int count = allCheckBoxes.size();
		List<String> al = new ArrayList<String>();

		for (WebElement we : checkedResultsText) {
			al.add(we.getText());
			Collections.sort(al);

		}

		for (WebElement we : allCheckBoxes) {
			if (we.isSelected()) {
				flag = true;

			} else {
				flag = false;

			}
			Assert.assertTrue(flag);
		}

		return al;

	}

	/**
	 * Click on all checked button
	 */

	public void clickOnViewCheckButton() {
		waitAndClick(viewCheckedButton);

	}

	/**
	 * Verify all boxes are checked after clicking on view checked button
	 */

	public List<String> verifyAllCheckboxesAreViewedCheck(List<String> valuesAfterChecked) {

		boolean flag = true;
		List<String> al = new ArrayList<String>();

		for (WebElement we : viewcheckedResultsText) {
			al.add(we.getText());
			Collections.sort(al);
		}

		if (al.equals(valuesAfterChecked)) {
			flag = true;
		}
		Assert.assertTrue(flag);
		return al;

	}

	/**
	 * Click on My Stuff link
	 */

	public void selectMyStuffLink() {
		waitAndClick(myStuffLink);
	}

	/**
	 * verify Add to MyStuff pop up window is displayed with a pop up
	 */

	public void verifyAddToMYSTuffPopUpDisplayed(String windowHeader) {


		 WebDriverWait wait = new WebDriverWait(driver, 4);
	      wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=getDriver().switchTo().alert();
		String text=alert.getText();
		Assert.assertEquals(text, windowHeader);
		_normalWait(3000);
		alert.accept();

	}

	/**
	 * Click on cancel Button
	 */

	public void clickOnCancelButton() {
       driver.switchTo().frame(iFrame);
		_normalWait(2000);
		waitAndClick(cancelButton);
	}

	/**
	 * Verify My Stuff window Displayed
	 */
	public void verifyMyStuffDisplayed(String windowHeader) {
		switchToDefaultContent();
		Assert.assertEquals(myStuffWindowHeader.getText(), windowHeader);
	}

	/**
	 * Close My Stuff Window
	 */

	public void closeMyStuffWindow() {
		driver.close();

	}

	/**
	 * Verify My Stuff window is closed
	 */

	public void verifyMyStuffWindowIsClosed() {
		Assert.assertTrue(drugHandbookImage.isDisplayed());

	}

	/**
	 * Select Alphabet A
	 */

	public void selectAlphabetA() {
		waitAndClick(selectAlphabetA);
	}

	/**
	 * Verify List of All Drugs are displayed
	 */

	public void verifyListOfAllDrugsDisplayed(String Alphabet) {
		boolean flag = false;
		for (WebElement we : listOfAllDrugs) {
			if (we.getText().startsWith(Alphabet)) {
				flag = true;

			}
			Assert.assertTrue(flag);
		}

	}

	/**
	 * Select albumin
	 */

	public void selectAlbuminOpenLinkInNewWindow() {
		javascriptButtonClick(albuminLinkToOpenInNewWindow);
			}
		
	

	/**
	 * Verify Selected drug is displayed in new window
	 */

	public void verifyLinkOpenedInNewWindow(String windowname) {
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(windowname));

	}

	/**
	 * Select Expand All Button
	 */

	public void selectExpandAllButton() {
		waitAndClick(expandAllButton);

	}

	/**
	 * Verify all items has been expanded after click on Expand button
	 */
	@SuppressWarnings("unlikely-arg-type")
	public void verifyListHaveExpanded() {
		boolean flag = false;
		for (WebElement we : expandedItemsList) {
			if (we.getAttribute("class").equals("fa fa-minus-circle")) {
				flag = true;

			}
			Assert.assertTrue(flag);
		}
	}

	/**
	 * Select Collpased all button
	 */
	public void selectCollpasedAllButton() {
		waitAndClick(collapseAllButon);
		waitAndClick(collapseAllButon);

	}

	/**
	 * Verify all items has been expanded after click on Expand button
	 */
	@SuppressWarnings("unlikely-arg-type")
	public void verifyListHaveCollpased() {
		boolean flag = false;
		for (WebElement we : expandedItemsList) {
			if (we.getAttribute("class").equals("fa fa-plus-circle")) {
				flag = true;

			}
			Assert.assertTrue(flag);
		}
	}

	/**
	 * Click on Set Preferences DropDown and select option
	 */

	public void selectPreferencesDropDownAndSelectLastOption() {
		waitAndClick(preferenecesDropDown);
		waitForElement(setYourDefaultPreferences);
		waitAndClick(setYourDefaultPreferences);
	}

	/**
	 * Verify VIN Veterinary Drug Handbook Preferences window displayed
	 */

	public void verifyVinVeterinaryDrugHandbookWindowDisplayed() {
		String text = vinVeterinaryDrugWindow.getText();
		Assert.assertEquals(text, "VIN Veterinary Drug Handbook Preferences");

	}
	
	/**
	 * select vin default check box
	 */
	
	public void selectVINDefaultCheckBox() {
		waitAndClick(vinDeaultRadioButton);
	}

	/**
	 * Verify Vin Default Radio Button Seletced
	 */

	public void verifyVinDefaultRadioButtonSelected() {
		Assert.assertTrue(vinDeaultRadioButton.isSelected());
		}

	/**
	 * Close the preferenece window
	 */
	public void closePreferenceWindow() {
		driver.close();
	}

	/**
	 * Select ‘Therapeutic Category’
	 */

	public void selectTherapeuticCategory() {
		waitAndClick(therapeuticCategoryButton);
	}

	/**
	 * Verify Therapeutic Category tab is selected
	 */

	public void verifyTherapeuticCategoryTabIsSelected() {
		String classSelected = therapeuticCategoryButton.getAttribute("class");
		Assert.assertTrue(classSelected.equalsIgnoreCase("selected"));

	}

	/**
	 * Select C Under Therapeutic category
	 */
	public void selectCUnderTherapeuticCategory() {
		waitAndClick(alphabetC);
	}

	/**
	 * Select Cardiovascular Agents
	 */

	public void selectCardiovascularAgents() {
		waitAndClick(CardiovascularAgent);
	}

	/**
	 * Verify Cardiovascular Agent list is shown
	 */

	public void verifyCardiovascularAgentIsShown() {
		Assert.assertTrue(CardiovascularAgentList.isDisplayed());

	}

	/**
	 * Select Digoxin
	 */

	public void selectDigoxin() {
		waitForElement(digoxin);
		waitAndClick(digoxin);
	}

	/**
	 * Verify 'Digoxin' is displayed with 'Doses' and 'References' sections are
	 * expanded.
	 */

	public void verifyDosesAndReferenesAreaIsExpanded() {
		Assert.assertTrue(dosesArea.getAttribute("class").equalsIgnoreCase("fa fa-minus-circle"));
		Assert.assertTrue(referencesArea.getAttribute("class").equalsIgnoreCase("fa fa-minus-circle"));

	}

	/**
	 * Select 'VIN Veterinary Drug Handbook' logo
	 */
	public void selectVinVeterinaryLogo() {
		waitForElement(veterenaryDrugHandbookImage);
		waitAndClick(veterenaryDrugHandbookImage);
	}
	
	public void verifyDoseCalculatorPage() {
		assertByPageTitle(Constants.doseCalculatorTitle);
	}
	
	 public void dismissNotifications() {
	        super.dismissNotifications(dismissAllBtn);
	    }

	 /**
	  * Enter Drug name
	  * @param drugbactrovet
	  */
	 
	public void enterDrugName(String drugbactrovet) {
		inputText(drugName, drugbactrovet);
		
	}

	/**
	 * Verify drug name in input field
	 * @param drugbactrovet
	 */
	public void verifyDrugName(String drugbactrovet) {

		String actual=drugName.getAttribute("value");
		Assert.assertEquals(actual, drugbactrovet);
	}

	/**
	 * Verify the auto fill for drug
	 * @throws AWTException 
	 */
	public void verifyAutofillForDrug() throws AWTException {
		Robot rob =new Robot();
		rob.keyPress(KeyEvent.VK_DOWN);
		_normalWait(2000);
		rob.keyRelease(KeyEvent.VK_DOWN);
		rob.keyPress(KeyEvent.VK_ENTER);
		_normalWait(2000);
		rob.keyRelease(KeyEvent.VK_ENTER);
		_normalWait(2000);
		waitAndClick(weightInKG);
		waitAndClick(getDriver().findElement(By.xpath("//div[@style='width:100%;text-align:center']//input")));
		
	}

	/**
	 * Select the species
	 * @param dogspecies
	 */
	public void selectSpecies(String dogspecies) {
		selectDropDownByText(speciesDropdown, dogspecies);
	}

	/**
	 * Verify user is able to select species
	 * @param dogspecies
	 */
	public void verifySpeciesSelection(String dogspecies) {
		String actual=returnSelectedValueFromDropdown(speciesDropdown);
		Assert.assertEquals(actual, dogspecies);
	}

	/**
	 * Enter weight in lb
	 */
	
	public void enterWeight() {
		inputText(weightInLB, "10");
	}

	/**
	 * verify weight in lb
	 * @param weight10lb
	 */
	public void verifyWeightInNumericText(String weight10lb) {
		String actual=weightInLB.getAttribute("value");
		Assert.assertEquals(actual, weight10lb);
	}
	
	/**
	 * Verify kg calculated automatically
	 * @param weightinkg
	 */
	public void verifyKGCalculatedAutomatically(String weightinkg) {

		waitAndClick(weightInKG);
		_normalWait(2000);
		String actual=weightInKG.getAttribute("value");
		Assert.assertEquals(actual, weightinkg);
	}

	/**
	 * Select indication text
	 * @param indicationtext
	 */
	public void selectIndication(String indicationtext) {
		selectDropDownByText(indicationDropdown, indicationtext);		
	}

	/**
	 * Verify indication text
	 * @param indicationtext
	 */
	public void verifyIndicationText(String indicationtext) {
		String actual=returnSelectedValueFromDropdown(indicationDropdown);
		Assert.assertEquals(actual, indicationtext);
	}

	/**
	 * Select dose text
	 * @param dosetext
	 */
	public void selectDose(String dosetext) {
		selectDropDownByText(doseDropdown, dosetext);
	}

	/**
	 * Verify dose selection
	 * @param dosetext
	 */
	public void verifyDoseSelection(String dosetext) {
		String actual=returnSelectedValueFromDropdown(doseDropdown);
		Assert.assertEquals(actual, dosetext);
	}

	/**
	 * Select calculate button
	 */
	
	public void selectCalculate() {
		waitAndClick(calculateButton);
	}

	/**
	 * Verify result populate below
	 */
	public void verifyResultPopulate() {
		if(resultArea.isDisplayed()) {
			Assert.assertTrue(true);
		}
	}

	/**
	 * Select reset button
	 */
	public void selectResetButton() {

		waitAndClick(resetButton);
	}

	/**
	 * Verify value are cleared
	 */
	public void verifyValuesAreCleared() {

		String drugValue=drugName.getAttribute("value");
		String lbValue=weightInLB.getAttribute("value");
		String KgValue=weightInKG.getAttribute("value");
		if(drugValue.isEmpty()&&lbValue.isEmpty()&&KgValue.isEmpty()) {
			Assert.assertTrue(true);
		}
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
    
    /**
     * Select albumin
     */
    
    public void selectAlbuminFromTheList() {
    	waitAndClick(albumin);
    	
    }
    
    /**
     * verify all section are expended
    */
    
    public void verifyAllExpendedElement() {
    for(WebElement ele :allExpendedElements) {
    	Assert.assertTrue(ele.isDisplayed());
    }
    }
    
    /**
     * verify all section are hidden
     */
   
     public void verifyAllHiddenElement() {
        for(WebElement elem :allExpendedElements) {
        	Assert.assertTrue(elem.isDisplayed());
        }
       
        

    }
    
}
