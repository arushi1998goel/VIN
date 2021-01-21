package com.vin.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.vin.selenium.core.BasePage;
import com.vin.utilities.Constants;

public class SearchHappyPathPage extends BasePage {
	
	public SearchHappyPathPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//button[text()='Dismiss']")
	private WebElement dismissButton;
	
	@FindBy(xpath="//div[@id='divNotificationContainer']")
	private WebElement notificationPopup;
	
	@FindBy(xpath = "//ul[contains(@class,'navbar')]//a[text()='Search']")
	private WebElement searchButton;
	
	@FindBy(xpath = "//input[@class='form-control tt-input']")
	private WebElement inputSearch;
	
	@FindBy(xpath="(//div[@class='tt-dataset-autosuggest']//strong[text()='taurine'])[1]")
	private WebElement taurineSuggestion;
	
	@FindBy(xpath="//span[@class='tt-dropdown-menu' and contains(@style,'display: block')]")
	private WebElement autoSggestionList;
	
	@FindBy(xpath = "//button[@id='btnSearch']/span")
	private WebElement searchMaginfier;
	
	@FindBy(xpath="//div[@id='results']//small/strong")
	private List<WebElement> keywords;
	
	@FindBy(xpath="//a[text()=' Taurine']/ancestor::h5/..//a[text()='VIN Veterinary Drug Handbook']")
	private WebElement hyperlinks;
	
	@FindBy(xpath="//input[@id='vchk']")
	private List<WebElement> checkboxex;
	
	@FindBy(xpath="(//a[text()=' Taurine'])[1]")
	private WebElement firstLink;
	
	@FindBy(css = "select[id='specs']")
	private WebElement speciesDropDown;
	
	@FindBy(css="li[id='masterTabBoards']")
	private WebElement messageBoards;
	
	@FindBy(xpath="//a[text()='My Searches']")
	private WebElement mySearches;
	
	@FindBy(xpath="(//a[text()='Search'])[2]")
	private WebElement searchFirstLink;
	
	@FindBy(xpath="//td[text()='My Search History']")
	private WebElement mySearchHstory;
	
	@FindBy(xpath = "//a[@id='menuVC']")
	private WebElement checkedResultsMenu;
	
	@FindBy(id = "lnkViewCheckedResults")
	private WebElement checkedResultsLink;
	
	@FindBy(css="a[id='lnkTitle']")
	private List<WebElement> viewCheckedResults;
	
	@FindBy(css = "div[id='menu'] div[id='topNav'] a[id='loginmenu']")
	private WebElement loginUserDropDown;

	@FindBy(css = "div[id='menu'] div[id='topNav'] ul[role='menu'] a[class='MemberProfile_Logout']")
	private WebElement logoutLinkUnderUserDropDown;
	
	@FindBy(xpath = "//tbody//td//input")
	private List<WebElement> checkboxes;
	
	@FindBy(xpath = "//a[@id='menuVC']")
	private WebElement viewCheckedControl;
	
	@FindBy(xpath = "//a[@id='lnkViewCheckedResults']")
	private WebElement viewCheckedResultsControl;
	
    @FindBy(xpath = "//button[text()='Dismiss All']")
    private WebElement dismissAllBtn;
	
	
	
	
	/**
	 * Select the dismiss Button
	 */
    public void selectDismissButton() {
    	waitAndClick(dismissButton);
    }
    
    
    
    /**
     * Verify  popup if  displayed select dismiss Button
     */
    public void verifyPopupIfDisplayAndSelectDismissButton() {
    	
    	if (notificationPopup.isDisplayed()) {
    		waitAndClick(dismissButton);
			
		}
    	else {
			System.out.println("No Alert  Popup Displayed");
		}
    	
    }
    
    public void dismissNotifications() {
        super.dismissNotifications(dismissAllBtn);
    }
    
    /**
     * Verify popup Dismissed
     */
    public void verifyPopupDismissed() {
    	Assert.assertFalse(notificationPopup.isDisplayed());
    }
    
    
    /***
	 * click on search button
	 */
	public void  clickOnSearchButton() {
		_normalWait(1000);
		clickOn(searchButton);

	}
	
	/**
	 * Verify Search page is loaded
	 */
      public  void verifySearchPageIsLoaded(String paggeTitle) {
	     Assert.assertTrue(driver.getTitle().equalsIgnoreCase(paggeTitle));
      }
 
	/**
	 * search input in the search box
	 */
	public void searchTermInTheSearchBox(String text) {
		_normalWait(2000);
		clickOn(inputSearch);
		inputSearch.clear();
		inputText(inputSearch, text);
	}
	
	/**
	 * Verify Fields Accept Entries and auttosuggestion List Is available
	 */
	public void verifyFieldsAcceptEntriesAndAutosuggestionListAvailable() {
		Assert.assertTrue(inputSearch.isEnabled());
		Assert.assertTrue(autoSggestionList.isDisplayed());
	}
	
	/**
	 * Verify First Suggestion as input enter in the text
	 */
	public void verifyFirstSuggestion() {
		Assert.assertTrue(taurineSuggestion.getText().equalsIgnoreCase("Taurine"));
	}
	
	/**
	 * Click on Search Magnifier
	 */
	public void clickOnMagnifier() {
		 waitAndClick(searchMaginfier);
	 }
	 
	 /**
	  * Verify  Search Results displayed
	  */
	 public void verifySearchResultsDisplayed() {
		 boolean flag=false;
		 for (WebElement we: keywords) {
			 if (we.getText().equalsIgnoreCase("taurine")) {
				 flag=true;
				
			}
			 Assert.assertTrue(flag);
			
		}
		 
	 }
	 
	 /**
	  * Verify Hyperlink is displayed
	  */
	 public void verifyHyperlinkDislpayed() {
		 Assert.assertTrue(hyperlinks.isDisplayed());
		 
	 }
	 
	 /**
	  * Verify checkbox is unchecked
	  */
	 public void verifyCheckBoxIsUnchecked() {
		 boolean flag=false;
		 for (WebElement we : checkboxex) {
			 if (we.isSelected()) {
				 flag=true;
				
			}
			 Assert.assertFalse(flag);
			
		}
	 }
	 
	 /**
	  * Click on First Link
	  */
	 public void clickOnFirstLink() {
		 waitAndClick(firstLink);
	 }
	 
	 
	 /***
	  * Verify the selected page is displayed
	  */
	 public void verifyTaurineIsDisplayed() {
		 Assert.assertTrue(driver.getTitle().contains("Taurine"));
	 }
	 
	 /**
     * click And Open Species Drop Down
     */
		public void clickAndOpenSpeciesDropDown() {
			clickByMouseHoverOnAnElement(speciesDropDown);
			clickByMouseHoverOnAnElement(speciesDropDown);
		}
		
		
		/**
		 * select Option Displayed under Species Drop Down Box
		 */
		public void selectOptionDisplayedUnderSpeciesDropDown(String dropDownIndex) {
			selectDropDownByValue(speciesDropDown, dropDownIndex);

		}
		
		
		/**
		 * Select message boards
		 */
		
	public void selectMessageBoards() {
		waitAndClick(messageBoards);
	}

	/**
	 * Select my searches
	 */
	public void selectMySearches() {
		waitAndClick(mySearches);
	}


	/**
	 * Verify  MyActivities Popup
	 */
	public void verifyMyActivitiesPopUp() {
		_normalWait(4000);
		Assert.assertTrue(driver.getTitle().contains("My Activity"));
	}


	/**
	 * Verify  my search history is selected
	 */
	public void verifyMySearchHistoryIsSelected() {
		Assert.assertTrue(mySearchHstory.isDisplayed());
	}

	/**
	 * Select 1st Link from the myActivities Popup
	 */
	public void selectFirstLink() {
		waitAndClick(firstLink);
	}

	/**
	 * Select First ,second and third Checkboxes 
	 */
	public void selectFirstThreeCheckBoxes() {
		List<WebElement> ele = driver.findElements(By.xpath("//input[@id='vchk']"));
		for (int i=0; i<3;i++) {
			ele.get(i).click();	
		}
			
		}


	/**
	 * Verify  first 3 checkboxes  
	 */
	public void verifyFirstThreeCheckboxesIsChecked() {
	List<WebElement> ele = driver.findElements(By.xpath("//input[@id='vchk']"));
		
		for (int i=0; i<3;i++) {
			Assert.assertTrue(ele.get(i).isSelected());
		
			
			
		}
	}
		
		/**
		 * Select first Link from my searches
		 */
		public void selectFirstLinkFromMySearchesPopup() {
			waitAndClick(searchFirstLink);
		}
		
		
		/**
		 * Open View Checked DropDown
		 */
		public void openViewCheckedDropDownMenu() {
			waitForPageLoaded();
			waitForElement(checkedResultsMenu);
			clickOn(checkedResultsMenu);
		}
		
		public void clickViewCheckedResultsPopUp() {
			waitForElement(checkedResultsLink);
			clickOn(checkedResultsLink);
		}
		
		
		/**
		 * Verify The text of selected checkbox title
		 */
		
		public List<String> verifyThetitleOfTheSelectedCheckbox() {
			 List<String> WinList = new ArrayList<>();
			List<WebElement> ele = driver.findElements(By.xpath("//input[@id='vchk']"));
		
			
			for (int i=0; i<3;i++) {
//				Assert.assertTrue(ele.get(i).isSelected());
			if (ele.get(i).isSelected()) {
				 WinList.add(ele.get(i).findElement(By.xpath(".//../following-sibling::td//a")).getText());
				
			}
				
				 
			}
			
			return  WinList;
			
		}

		
		/**
		 * Verify The checked results is same as the selected one Previously
		 */
		public void verifyValuesAreSameAfterSelectingViewCheckedResults(List<String>values) {
			  List<String> results = new ArrayList<>();
			
			        for (WebElement reasonChangeValues : viewCheckedResults) {
			      	
			        	results.add(getText(reasonChangeValues).trim());
			        }
			        
			        Assert.assertEquals(results, values, "values present");
				
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
	 * Verify Front Page displayed
	 */
	public void verifyFrontPageDisplayed() {
	    waitForPageLoaded();
//		_normalWait(1000);
	    assertByPageTitle(Constants.pageTitle_FrontPage);
	}


	/**
	 * Select the first two checkbox
	 */
	public void selectTheFirstTwoCheckbox() {
	for(int i=0;i<checkboxes.size();i++) {
		if(i==0||i==1) {
			checkboxes.get(i).click();
		}
		else {
			break;
		}
	}
		
	}

	/**
	 * Select View checked Control
	 */
	public void selectViewCheckedControl() {
	   waitAndClick(viewCheckedControl);
		
	}

	/**
	 * Select view checked results
	 */
	public void selectViewCheckedResults() {
	waitAndClick(viewCheckedResultsControl);
		
	}

	/**
	 * verify view checked window
	 */
	public void verifyViewCheckedWindow() {
		waitForPageLoaded();
		assertByPageTitle(Constants.viewCheckedWindow);
	}
	}

		
		













 