package com.vin.pages;


import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.Reporter;

import com.vin.selenium.core.BasePage;

public class CECourseInfoPage extends BasePage {
	
	public CECourseInfoPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@class='lead col-xs-12 col-md-9 col-md-pull-3']//a[text()='Enroll Now']")
    private WebElement enrollNowButton;
	
	@FindBy(xpath = "//a[text()='VIN']")
    private WebElement VINButton;
	
	@FindBy(xpath = "//a[text()='VSPN']")
    private WebElement VSPNButton;
	
	@FindBy(xpath = "//a[text()='CE Portal']")
    private WebElement CEPortal;
	
	@FindBy(xpath = "//a[text()='CE Participant Resource Center']")
    private WebElement CEParticipantResourceCenter;
	
	@FindBy(xpath = "//a[text()='CE Demo']")
    private WebElement CEDEmo;
	
	@FindBy(xpath = "//a[text()='Course Archives']")
    private WebElement CourseArchives;
	
	@FindBy(xpath = "//a[text()='Course Catalogs']")
    private WebElement CourseCatalog;
	
	@FindBy(xpath = "//a[text()='Course Suggestions']")
    private WebElement CourseSuggestions;
	
	@FindBy(xpath = "//span[@class='Header2']")
    private WebElement notAUserText;
	
	@FindBy(xpath = "//input[@id='ContentBody_nameTB']")
    private WebElement nameFieldOnCourseSuggestion;
	
	@FindBy(xpath = "//input[@id='ContentBody_emailTB']")
    private WebElement emailFieldOnCourseSuggestion;
	
	@FindBy(xpath = "//textarea[@id='ContentBody_messageTB']")
    private WebElement commentFieldOnCourseSuggestion;
	
	@FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
    private WebElement recaptchaCheckbox;
	
	@FindBy(xpath = "//button[@id='ContentBody_sendBtn']")
    private WebElement submitButtonCourseSuggestionPage;
	
	@FindBy(xpath = "//div[@class='col-sm-8 col-xs-8']//h3")
    private WebElement ContactLabelCourseSuggestionPage;
	
	@FindBy(xpath = "//section[@class='container-fluid tools']//ul//li[@class='printPage']")
    private WebElement printIcon;
	
	@FindBy(xpath = "//body/print-preview-app")
    private WebElement printPreviewApp;
	
	@FindBy(xpath = "//span[@class='fa fa-floppy-o']")
    private WebElement saveIcon;
	
	@FindBy(xpath = "//span[@class='fa fa-bookmark-o']")
    private WebElement bookmarkIcon;
	
	@FindBy(xpath = "//a[@class='btn btn-default enroll']")
    private WebElement enrollNowButtonInContent;
	
	@FindBy(xpath = "//a[text()='Participant Resource Center']")
    private WebElement paritcipantResourceLink;
	
	@FindBy(xpath = "//a[text()='CE at VIN' ]")
    private WebElement emailLink1InFooter;
	
	@FindBy(xpath = "//a[text()='CE at VSPN']")
    private WebElement emailLink2InFooter;
	
	@FindBy(xpath="//li[@id='consList_consListRptr_memberItem_4']")
    private WebElement presenterLabel;
	
	@FindBy(xpath="(//article[@id='courseInfo']//a)[1]")
	private WebElement presenterNameLink;
	
	
	
	/**
	 *  verify Course info page successfully displayed in new window
	 * @return 
	 */
	public  void verifyCourseInfoPageSuccessfullyDisplayedInNewWindow(){
		getDriver().navigate().refresh();
		Assert.assertTrue(enrollNowButton.isDisplayed());
		
	}

	/**
	 * Click on enroll now button
	 */
	public void clickOnEnrollNowButton() {
		if(enrollNowButton.isEnabled()) {
		waitAndClick(enrollNowButton);
		}
	}		

	/**
	 * Verify that VIN CE Registration page opens up in new window
	 */
	public void verifyVINCERegistrationPageInNewWindow() {
		Assert.assertTrue(notAUserText.isDisplayed());
		_normalWait(3000);
	}

    /**
    * Navigate back to previous page
    */
	public void naviagteBackToPage() {
		getDriver().close();
	}

     /**
     * Click on VIN Button
     */
   public void clickOnVINButton() {
        if(VINButton.isDisplayed()) {
		waitAndClick(VINButton);
	  }
     }

     /**
      * @param vinpagetitle
      */
     
    public void verifyVINFrontPageIsLoadedInNewWindow(String vinpagetitle) {
         assertByPageTitle(vinpagetitle);	
      }

     /** 
     * Click On VSPN Button
     */

    public void clickOnVSPNButton() {
        if(VSPNButton.isDisplayed()) {
		waitAndClick(VSPNButton);
	}
     }

    /**
    * @param vspnpagetitle
    * Verify VSPN Page title
    */

    public void verifyVSPNFrontPageLoadedInNewWindow(String vspnpagetitle) {
	      assertByPageTitle(vspnpagetitle);
      }

    /** 
    * Click on CE Portal
    */

    public void clickOnCEPortal() {
         if(CEPortal.isDisplayed()) {
		waitAndClick(CEPortal);
	   }
     }

     /** 
     * @param ceportalpagetitle
     * Verify CE Portal page
     */

    public void verifyCEPortalLoadedInNewWindow(String ceportalpagetitle) {
         assertByPageTitle(ceportalpagetitle);
     }

     /**
     * Click on CE Participant portal resourse center
     */

    public void clickOnCEParticipantResourseCenter() {
	if(CEParticipantResourceCenter.isDisplayed()) {
		waitAndClick(CEParticipantResourceCenter);
	  }
     }

    /**
    * Verify CE Participant Resource Center page title
    * @param participantresourcepagetitle
    */

    public void verifyCEParticipantResourceCenter(String participantresourcepagetitle) {
     	assertByPageTitle(participantresourcepagetitle);
    }

    /**
    * Click on CE Demo Button
    */

    public void clickOnCEDemo() {
       if(CEDEmo.isDisplayed()) {
	 waitAndClick(CEDEmo);
        }	
    }

     /**
     * Verify CE Practice area loaded in new window
     * @param cedemopagetitle
     */

     public void verifyCEPracticeAreaLoadedInNewWindow(String cedemopagetitle) {
	     assertByPageTitle(cedemopagetitle);
      }

     /**
     * Click on Course archives button
     */

     public void clickOnCourseArchives() {
	     if(CourseArchives.isDisplayed()) {
    	waitAndClick(CourseArchives);
	     }
     }

     /**
     * Verify Course archive loaded in new window
     * @param coursearchivespagetitle
      */

     public void verifyCourseArchivesLoadedInNewWindow(String coursearchivespagetitle) {
          assertByPageTitle(coursearchivespagetitle);	
      }


     /**
     * Click on Course catalogue button
     */

     public void clickOnCourseCatalogsButton() {
        if(CourseCatalog.isDisplayed()) {
	    waitAndClick(CourseCatalog);
      }
	 }

    /**
    * Verify Course catalogs Loaded in new window
    * @param coursecatalogpagetitle
    */

    public void verifyCourseCatalogsLoadedInNewWindow(String coursecatalogpagetitle) {
    	assertByPageTitle(coursecatalogpagetitle);
     }

    /**
    * Click on course suggestion button
    */

    public void clickOnCourseSuggestionButton() {
	    if(CourseSuggestions.isDisplayed()) {
		waitAndClick(CourseSuggestions);
	   }
	}


    /**
    * Verify the course suggestion window
    */

    public void verifyCourseSuggestionLoadedInNewWindow() {
        Assert.assertTrue(ContactLabelCourseSuggestionPage.isDisplayed());
    }

    /**
    * Click on print icon
    */
    
    public void clickOnPrintIcon() {
         WebElement rtx = driver.findElement(ByLocator("//a[@title='Print page']"));
	       try {
		    Thread.sleep(3000);
	   } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	    waitAndClick(rtx);
     }

    /**
    * Verify Print page opened new window 
    */

    public void verifyPrintPageOpenedInNewWindow() {
	  Assert.assertTrue(printPreviewApp.isDisplayed());
	}

    /**
    * Click on save icon
    */

    public void clickOnSaveIcon() {
        if(saveIcon.isDisplayed()) {
	  waitAndClick(saveIcon);
	  _normalWait(3000);
	  }
     }

     /**
     * Verify message in dialogue  box
     * @param message
     */

     public void verifyMessageInDialogBox(String message) {
	     String actualMessage=getDriver().switchTo().alert().getText();
	       if(message.equalsIgnoreCase(actualMessage)){
		Assert.assertTrue(true);
	    }
	 else {
		Assert.assertTrue(false);
	   }	
     }

    /**
    * Click on bookmark icon
    */

    public void clickOnBookmarkIcon() {
	if(bookmarkIcon.isDisplayed()) {
		waitAndClick(bookmarkIcon);
		_normalWait(3000);
	  }
     }

    /** 
    * scroll down the page to find the enroll now button
    */

    public void scrollDownThePageToFindTheEnrollNowButton() {
         By element =By.xpath("//a[@class='btn btn-default enroll']");
	       scrollIntoView(element);
	      _normalWait(3000);
       }

     /**
     * Click on participant resource center link in main body
     */

    public void clickOnParticipantResourcecenterLink() {
	    By element =By.xpath("//a[text()='Participant Resource Center']");
	       scrollIntoView(element);
	       _normalWait(3000);
           waitAndClick(paritcipantResourceLink);
	    }

    /**
    * Click on first Email Link in footer page
    */

    public void clickOnEmailLink1InFooter() {
	     By element =By.xpath("//a[text()='CE at VIN' ]");
	     scrollIntoView(element);
	     _normalWait(3000);
	      waitAndClick(emailLink1InFooter);
	     }
	
	
	/**
	 * Click on second Email Link in footer page
	 */

	public void clickOnEmailLink2InFooter() {
		_normalWait(2000);
		waitAndClick(emailLink2InFooter);
	   }

     /**
     * Click on presenter link text
     * @param presenterlinktext
     */

	public String clickOnPresenternameLink() {
       String linkName=presenterNameLink.getText().substring(0, 21);
        waitAndClick(presenterNameLink);
        return linkName;
	}

    /**
    * Click on cancel button on print preview window
    * @throws AWTException 
    */

    public void clickOnCancelButtonOnPrintWindow() throws AWTException {
	  WebElement rtx = driver.findElement(ByLocator("//a[@title='Print page']"));
	  clickOn(rtx);
	
	try{
		Screen s=new Screen();
		String imagePath="E:\\VINUpdated\\VIN.Dev.Selenium\\src\\main\\resources\\testdata\\uploadFile\\Cancel.PNG";
		Pattern p=new Pattern(imagePath);
		Match m=s.exists(p);
		if(m!=null){
			Thread.sleep(3000);
			s.click(p);
		}
		}catch (Exception e) {
			Reporter.log("Unable to click ");
		}
	}

    /**
    * Close Mail Server window
    */
    
   public void closeMailServerWindow() {
	try{
		Screen s=new Screen();
		String imagePath="E:\\VINUpdated\\VIN.Dev.Selenium\\src\\main\\resources\\testdata\\uploadFile\\Close.PNG";
		Pattern p=new Pattern(imagePath);
		Match m=s.exists(p);
		if(m!=null){
			Thread.sleep(1000);
			s.click(p);
		}
		}catch (Exception e) {
			Reporter.log("Unable to click ");
		}
	
	try{
		Screen s=new Screen();
		String imagePath="E:\\VINUpdated\\VIN.Dev.Selenium\\src\\main\\resources\\testdata\\uploadFile\\Cross.PNG";
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
      * verify present name matched on course Info page
      * @param name
      */
    

       public void verifyPresenterNameMatchedOnCourseInfoPage(String name) {
        	  Assert.assertEquals(presenterLabel.getText(),name);
          }
     }





