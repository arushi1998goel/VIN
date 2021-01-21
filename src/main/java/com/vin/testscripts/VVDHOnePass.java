package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.FrontPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class VVDHOnePass extends BaseTest {
  public VVDHOnePass() {
	  super();
  }
  /**
	 * ====================================================================================================================
	 * Test Case Name: VVDHOnePass
	 * ====================================================================================================================
	 * 
	 * @throws Exception
	 * 
	 * 
	 */
	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());

	}
	@Test
	public void VVDHOnePass() throws Exception{
		reportLog("1.1: Log in to VIN");
		promoPage.verifyPromoPage();
		loginPage = promoPage.clickOnLoginButton();
		loginPage.verifyUserLoginPage();
		
		reportLog("1.2: Login to VIN is successful");
		frontPage = loginPage.loginInApplication(FrontPage.class, UserID, UserPswrd);
		frontPage.verifyFrontPageDisplayed();
		
		reportLog("2.1: Select 'MyVIN' from the navigation menu");
		frontPage.clickOnMyVin();
		
		reportLog("2.2: MyVIN' pop up window  is displayed ");
        String parentWindow = switchToChildWindow();
		
		reportLog("3.1: Select 'Preferences'");
		frontPage.selectPreferencesDropDown();
		
		reportLog("3.2: A drop down menu under Preferences is displayed");
		frontPage.verifydropdownSection();

		reportLog("4.1: Select 'VVDH' from the Preferences drop down options.");
		frontPage.selectfromPreferencesdropdown(Constants.vVDHPage);
		
		reportLog("4.2: VVDH is selected");
		frontPage.verifyVVDHisSelected();
		
		reportLog("5.1: Select the bubble next to Expand/show all sections.");
        frontPage.selectExpandShowRadioButton();
        
		//reportLog("5.2: Display options for VVDH is updated");
        //this validation is covered from step 6.1 to 11.1
        
		reportLog("6.1: Select X to close MyVIN");
        switchParentWindowByClosingChild(parentWindow);

		reportLog("6.2: MyVIN pop up window is closed");
        frontPage.verifyPopModalClosed();
        
		reportLog("7.1: Select 'Library' from the navigation menu");
        frontPage.clickOnLibraryDropDown();
        
		reportLog("7.2: A Library Home and Quick Links pop up window is displayed");
        frontPage.verifyLibraryDropDown();
        
		reportLog("8.1: Select 'VIN Veterinary Drug Handbook' link.");
		vvdh = frontPage.clickOnDrugHandbookLink();

		reportLog("8.2: VIN Veterinary Drug Handbook page is displayed ");
		vvdh.verifyVeterinaryDrugHandBookPageDisplayed(Constants.VetrinaryDrugHandBook);

		reportLog("9.1: Select 'A' under the Browse By section");
		vvdh.selectAlphabetA();
		
		reportLog("9.2: A page listing drugs that begin with 'A' is displayed");
		vvdh.verifyListOfAllDrugsDisplayed(Constants.AlphabetA);
		
		reportLog("10.1: Select 'Albumin' from the list");
		vvdh.selectAlbuminFromTheList();

		reportLog("10.2: Albumin monograph page is displayed");
        vvdh.verifyLinkOpenedInNewWindow(Constants.albuminText);

		reportLog("11.1: Validate to make that all the sections on the drug monograph page are expanded.");
		reportLog("11.2: Display options for VVDH is updated");
        vvdh.verifyAllExpendedElement();

		reportLog("11.2: Display options for VVDH is updated");

		reportLog("12.1: Select 'MyVIN' from the navigation menu");
		frontPage.clickOnMyVin();

		reportLog("12.2: MyVIN' pop up window  is displayed ");
        parentWindow = switchToChildWindow();
		
		reportLog("13.1: Select 'Preferences'");
		frontPage.selectPreferencesDropDown();

		reportLog("13.2: A drop down menu under Preferences is displayed");
		frontPage.verifydropdownSection();

		reportLog("14.1: Select 'VVDH' from the Preferences drop down options.");
		frontPage.selectfromPreferencesdropdown(Constants.vVDHPage);

		reportLog("14.2: VVDH is selected");
		frontPage.verifyVVDHisSelected();
		
        reportLog("15.1: Select the bubble next to Collapse/hide all sections all sections.");
        frontPage.selectHideRadioButton();
        
		//reportLog("15.2: Display options for VVDH is updated");
        //this validation is covered from step 16.1 to 21.1
       
        reportLog("16.1: Select X to close MyVIN");
        switchParentWindowByClosingChild(parentWindow);

        reportLog("16.2: MyVIN pop up window is closed");
        frontPage.verifyPopModalClosed();

        reportLog("17.1: Select 'Library' from the navigation menu");
        frontPage.clickOnLibraryDropDown();

		reportLog("17.2: A Library Home and Quick Links pop up window is displayed");
        frontPage.verifyLibraryDropDown();

		reportLog("18.1: Select 'VIN Veterinary Drug Handbook' link.");
		vvdh = frontPage.clickOnDrugHandbookLink();

        reportLog("18.2: VIN Veterinary Drug Handbook page is displayed ");
		vvdh.verifyVeterinaryDrugHandBookPageDisplayed(Constants.VetrinaryDrugHandBook);

		reportLog("19.1: Select 'A' under the Browse By section");
		vvdh.selectAlphabetA();

		reportLog("19.2: A page listing drugs that begin with 'A' is displayed");
		vvdh.verifyListOfAllDrugsDisplayed(Constants.AlphabetA);

		reportLog("20.1: Select 'Albumin' from the list");
		vvdh.selectAlbuminFromTheList();

		reportLog("20.2: Albumin monograph page is displayed");
        vvdh.verifyLinkOpenedInNewWindow(Constants.albuminText);

    	reportLog("21.1: Validate to make that all the sections on the drug monograph page are collapsed and hidden.");
		reportLog("21.2: Display options for VVDH is updated");
     	vvdh.verifyAllHiddenElement();
    	
		reportLog("22.1: Select 'MyVIN' from the navigation menu");
		frontPage.clickOnMyVin();

        reportLog("22.2: MyVIN' pop up window  is displayed ");
        parentWindow = switchToChildWindow();

		reportLog("23.1: Select 'Preferences'");
		frontPage.selectPreferencesDropDown();

		reportLog("23.2: A drop down menu under Preferences is displayed");	
		frontPage.verifydropdownSection();

		reportLog("24.1: Select 'VVDH' from the Preferences drop down options.");
		frontPage.selectfromPreferencesdropdown(Constants.vVDHPage);

		reportLog("24.2: VVDH is selected");
		frontPage.verifyVVDHisSelected();

		reportLog("25.1: Select the bubble next to VIN Default.");
		frontPage.selectVINDefaultRadioButton();
	
    	//reportLog("25.2: Display options for VVDH is updated");
     	
		reportLog("26.1: Select X to close MyVIN");
        switchParentWindowByClosingChild(parentWindow);

		reportLog("26.2: MyVIN pop up window is closed");
        frontPage.verifyPopModalClosed();
        
        reportLog("27.1: Log out of VIN");
		logoutPage=frontPage.logoutApplication();

		reportLog("27.2: Log out of VIN is successful");
	    logoutPage.verifyLogoutPageDisplayed();

	
	}
}
	
