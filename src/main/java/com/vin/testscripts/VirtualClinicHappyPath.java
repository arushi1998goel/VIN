package com.vin.testscripts;

import java.awt.AWTException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.LibraryQuickLink;
import com.vin.pages.LoginPage;
import com.vin.pages.ViurtualClinicHappyPathPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class VirtualClinicHappyPath extends BaseTest {

	@BeforeMethod
	public void getTestData() throws Exception {
		System.setProperty("className", getClass().getSimpleName());
	}

	public VirtualClinicHappyPath()
	{super();}
	
	/**
	 * ====================================================================================================================
	 * Test Case Name: VirtualClinicHappyPath
	 * ====================================================================================================================
	 * @throws AWTException 
	 * 
	 * 
	 * 
	 */
	
	
	@Test
	public void verifyVirtualClinicHappyPath() throws AWTException
	{
		reportLog("1.1 Navigate to https://www.vin.com/members/cms/project/defaultadv1.aspx?pid=16170");
		loginPage=promoPage.navigateToGivenURL(LoginPage.class,Constants.VirtualClinicHappyPathURL);

		reportLog("1.2 Call Login Method");
		virtualClinicHappyPath=loginPage.loginInApplication(ViurtualClinicHappyPathPage.class,UserID, UserPswrd);
		
		reportLog("1.3: Select the 'Enter Virtual Clinic' button");
		virtualClinicHappyPath.clickOnEnterVirtualClinicButton();
		
		reportLog("1.4: Dismiss Alert Notifications if displayed");
		
		reportLog("3.1: Select the 'Play' icon on the 'VIN Virtual Clinic' thumbnail -"
				+ " *Note: Be aware that Virtual Clinic may take a while to load");
		virtualClinicHappyPath.selectPlayIcon();
		
		reportLog("3.2: Select 'Start Case' next to 'Cheyenne'");
		virtualClinicHappyPath.selectStartCase();
		virtualClinicHappyPath.clickOnStartCaseButton();
		
		reportLog("3.3: Select 'OK' on the case introduction text window");
		virtualClinicHappyPath.selectOkButton();
		
		reportLog("3.4: Select 'OK' on the presenter window");
		virtualClinicHappyPath.selectOkButtonOnPresenterWindow();
		
		reportLog("3.5: Select 'Yes' on the enabling feedback during case playthrough window");
		virtualClinicHappyPath.selectYesButton();
		
		reportLog("3.6: Select 'Evaluate Patient'");
		virtualClinicHappyPath.selectEvaluatePatient();
		
		reportLog("3.7: Select 'Vitals'");
		
		reportLog("3.8: Select 'OK' on the 'Vitals' window");
		reportLog("3.9: Select 'Hematocrit'");
		reportLog("3.10: Select 'OK' on the 'Hematocrit' window");


	}
}
