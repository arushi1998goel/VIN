package com.vin.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Reporter;

import com.vin.selenium.core.BasePage;

public class LibraryQuickLink  extends BasePage{

	public LibraryQuickLink(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath ="//div/h2/a[text()='Learn Anatomy in 3D']")
    private WebElement IVALApage;
	
	@FindBy(xpath ="//a[text()='Start using 3D content']")
    private WebElement button3D;
	
	@FindBy(xpath ="//canvas[@id='ivalaPreviewCanvas']")
    private WebElement superProject3D;
	
	@FindBy(xpath ="//div[@id='project-viewport']/div[@id='unity-container']")
    private WebElement IvalaModule;
	
	@FindBy(xpath ="//div[@id='loading-bar-aligner']")
    private WebElement loading;

	@FindBy(css = "div[id='menu'] div[id='topNav'] a[id='loginmenu']")
	private WebElement loginUserDropDown;
	
	@FindBy(css = "div[id='menu'] div[id='topNav'] ul[role='menu'] a[class='MemberProfile_Logout']")
	private WebElement logoutLinkUnderUserDropDown;
	
	@FindBy(xpath="//a[text()='View all 3D Anatomy Models']")
	private WebElement viewall3DLink;
	
	public void verifyAnatomyPageDisplayed() {
		waitForPageLoaded();
		Assert.assertTrue(IVALApage.isDisplayed());
	}
	
	public void clickOnStartUsing3DContent() {
		scrollDown();
		javascriptButtonClick(button3D);
	}

	public void verifyIvalaModuleClosedAndUserIsViewingViewAll3DLink()
	{
		org.testng.Assert.assertTrue(isElementDisplayed(viewall3DLink));
	}
	public void select3DsuperProjectButton() {
		javascriptButtonClick(superProject3D);
	}

	public boolean verifyIvalaModuleIsDisplayed() {
		_normalWait(300000);

		try{
    		String path=System.getProperty("user.dir");
			Screen s=new Screen();
			String imagePath=path+"src/main/resources/testdata/uploadFile/IVALAPAGE.PNG";
			Pattern p=new Pattern(imagePath);
			Match m=s.exists(p);
			if(m!=null){
				//Thread.sleep();
				_normalWait(500000);
		        //s.wait(p,30000);
				return true;
		       
			}
			}catch (Exception e) {
    			Reporter.log("Unable to click ");
			}
		    return false;
	   }

       
	
	public boolean  verifyLoadingStartedForIvalaModule() {
		_normalWait(10000);
		try{
    		String path=System.getProperty("user.dir");
			Screen s=new Screen();
			String imagePath=path+"src/main/resources/testdata/uploadFile/IVALA.PNG";
			Pattern p=new Pattern(imagePath);
			Match m=s.exists(p);
			if(m!=null){
				//Thread.sleep();
				_normalWait(500000);
		        //s.wait(p,30000);
				return true;
		       
			}
			}catch (Exception e) {
				Reporter.log("  ");
			}
		    return false;
	   }
	
	/**
	 * Logout Application
	 */
	public LogoutPage logout() {
		_normalWait(1000);
		logger.debug("Click Logout");
		waitAndClick(loginUserDropDown);
		waitAndClick(logoutLinkUnderUserDropDown);
		return PageFactory.initElements(driver, LogoutPage.class);
	}
}

 
	
	


