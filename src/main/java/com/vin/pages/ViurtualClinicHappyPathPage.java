package com.vin.pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Reporter;

import com.vin.selenium.core.BasePage;

public class ViurtualClinicHappyPathPage extends BasePage {

	public ViurtualClinicHappyPathPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(xpath="//a[text()='Enter Virtual Clinic']")
	private WebElement enterVirtualClinicBtn;
	
	@FindBy(xpath ="//canvas[@id='ivalaPreviewCanvas']")
    private WebElement superProject3D;
	
	
	
	
	
	public void clickOnEnterVirtualClinicButton()
	{
		waitAndClick(enterVirtualClinicBtn);
	}
	
	public void selectPlayIcon()
	{
		waitAndClick(superProject3D);
//    	_normalWait(250000);

	}
	
	/**
     * Click on Add Link Button
	 * @throws AWTException 
     */ 
    public void selectStartCase() throws AWTException {
    	_normalWait(200000);
    	scrollDownUsingRobotClass();
//    	scrollDown();
    	try{
    		String path=System.getProperty("user.dir");
    		Screen s=new Screen();
    		String imagePath=path+"/src/main/resources/testdata/uploadFile/StartCase.PNG";
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
    
    public void clickOnStartCaseButton()
    {
    	try{
    		String path=System.getProperty("user.dir");
    		Screen s=new Screen();
    		String imagePath=path+"/src/main/resources/testdata/uploadFile/CaseStart.PNG";
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
    
    public void selectOkButton()
    {
    	_normalWait(250000);
    	try{
    		String path=System.getProperty("user.dir");
    		Screen s=new Screen();
    		String imagePath=path+"/src/main/resources/testdata/uploadFile/okBUtton.PNG";
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
    
    public void selectOkButtonOnPresenterWindow()
    {
    	try{
    		String path=System.getProperty("user.dir");
    		Screen s=new Screen();
    		String imagePath=path+"/src/main/resources/testdata/uploadFile/ButtonOk.PNG";
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

    public void selectYesButton()
    {
    	try{
    		String path=System.getProperty("user.dir");
    		Screen s=new Screen();
    		String imagePath=path+"/src/main/resources/testdata/uploadFile/yesButton.PNG";
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

    public void selectEvaluatePatient()
    {
    	try{
    		String path=System.getProperty("user.dir");
    		Screen s=new Screen();
    		String imagePath=path+"/src/main/resources/testdata/uploadFile/EvaluatePatient.PNG";
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
}
