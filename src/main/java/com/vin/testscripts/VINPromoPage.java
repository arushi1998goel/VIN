package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.ConsultantsAndEditorsPage;
import com.vin.pages.FriendsOfVINPage;
import com.vin.pages.LoginPage;
import com.vin.pages.PromoPage;
import com.vin.pages.ProudToBeaVinnerPage;
import com.vin.pages.RepresentativesPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class VINPromoPage extends BaseTest {
	
	private String ParentWin;
	
	public VINPromoPage(){
		super();
	}
	
	
	@BeforeMethod
    public void getTestData() throws Exception {

        System.setProperty("className", getClass().getSimpleName());

      }
	
	
	/**
     * ====================================================================================================================
     * Test Case Name: VIN Promo Page 
     * ====================================================================================================================
	 * @throws InterruptedException 
	 *  
     *
     * 
     */
	
	@Test
	public void vinpromopage() throws InterruptedException
	{
		reportLog("1.1: Go to https://beta.vin.com");
		promoPage.verifyPromoPageForLogin(LoginPage.class);
		
		reportLog("1.2: Scroll down and select the name link under the 'Featured' section");
		promoPage.clickOnNameLinkUnderFeaturedSection();
		
		reportLog("1.3: Select the 'Home' button");
		promoPage.selectOption("Home", PromoPage.class);
		
		reportLog("1.4: Scroll down and select 'More Consultants'");
		promoPage.clickOnMoreConsultants();
		
		reportLog("2.1: Select the 'About VIN' drop down option");
		promoPage.selectDropDown("About VIN");
		
		reportLog("2.2: Select 'About VIN'.");
		promoPage.SelectAboutVinOption();
		
		reportLog("2.3: Verify 'About VIN' page loads successfully");
		promoPage.verifyAboutVINSubTitleDisplayed();
		
		reportLog("3.1: Select the 'About VIN' drop down option");
		promoPage.selectDropDown("About VIN");
		
		reportLog("3.2: Select 'Consultants and Editors'");
		consultantAndEditorPage=promoPage.selectOption("Consultants and Editors", ConsultantsAndEditorsPage.class);
		
		reportLog("3.3: Select 'Alternative Medicine'");
		consultantAndEditorPage.selectAlternativeMedicines();
		
		reportLog("3.4: Verify 'Alternative Medicine' page loads successfully");
		consultantAndEditorPage.verifyAlternateMedicinesPageDisplayed();
		
		reportLog("3.5: Select 'Susan Wynn'");
		consultantAndEditorPage.selectSusanWynnUnderConsultants();
		
		reportLog("3.6: Verify 'Susan Wynn' page loads successfully");
		consultantAndEditorPage.verifysusanWynnSubTitle();
		
		reportLog("4.1: Select the 'About VIN' drop down option");
		promoPage.selectDropDown("About VIN");

		reportLog("4.2: Select 'Representatives'");
		representativePage=promoPage.selectOption("Representatives", RepresentativesPage.class);
		
		reportLog("4.3: Verify 'Representatives' page loads successfully");
		representativePage.verifyRepresentativeSubTitleDisplayed();
		
		reportLog("4.4: Select 'Adrian Kreeger'");
		representativePage.selectadrianKreegerLink();
		
		reportLog("4.5: Verify 'Adrian Kreeger' page loads successfully");
		ParentWin=switchToChildWindow();
		representativePage.verifyAdrianKreegerPageTitle();

		reportLog("4.6: Close the 'Adrian Kreeger' tab.");
		switchParentWindowByClosingChild(ParentWin);

		reportLog("5.1: Select the 'About VIN' drop down option");
		promoPage.selectDropDown("About VIN");

		reportLog("5.2: Select 'Membership'");
		promoPage.selectOption("Membership", PromoPage.class);

		reportLog("5.3: Verify 'Membership' page loads successfully");
		promoPage.verifyMemBershipSubtitle();
		
		reportLog("6.1: Select the 'About VIN' drop down option");
		promoPage.selectDropDown("About VIN");

		reportLog("6.2: Select 'Proud to be a VINner!'");
		proudToBeViNnerPage=promoPage.selectOption("Proud to be a VINner!", ProudToBeaVinnerPage.class);

		reportLog("6.3: Verify 'Proud to be a VINner!' page loads successfully");
		proudToBeViNnerPage.verifyProudToBeViNerSubTitle();
		
		reportLog("6.4: Select the 'VIN Bookstore' link under 'Pre-printed Veterinary Partner referral cards.'");
		proudToBeViNnerPage.selectVinBookSoreLink();
		
		reportLog("6.5: Verify 'VIN Bookstore' page loads successfully");
		ParentWin=switchToChildWindow();
		proudToBeViNnerPage.verifyBookStorePage();
		
		reportLog("6.6: Close the 'VIN Bookstore' tab.");
		switchParentWindowByClosingChild(ParentWin);

		reportLog("6.7: Select 'Community Store' link");
		proudToBeViNnerPage.selectCommunityStoreLink();
		
		reportLog("6.8: Verify 'Community Store' page loads successfully");
		ParentWin=switchToChildWindow();
		proudToBeViNnerPage.verifyCommintyStorePage(Constants.homepage);
		
		reportLog("6.9: Close the 'Community Store' tab.");
		switchParentWindowByClosingChild(ParentWin);
		
		reportLog("7.1: Select the 'Why VIN' drop down option");
		promoPage.selectDropDown("Why VIN");

		reportLog("7.2: Select 'Why VIN'.");
		promoPage.selectOption("Why VIN", PromoPage.class);

		reportLog("7.3: Verify 'Why VIN' page loads successfully");
		promoPage.verifyWhyVinSubtitle(Constants.whyvin_title);
		
		reportLog("7.4: Select the 'Why VIN' drop down option");
		promoPage.selectDropDown("Why VIN");
		
		reportLog("7.5: Select 'Membership");
		promoPage.selectOption("Membership", PromoPage.class);

		reportLog("7.6: Verify 'Membership' page loads successfully");
		promoPage.verifyMemBershipSubtitle();
		
		reportLog("8.1: Select the 'VIN Family' drop down option");
		promoPage.selectDropDown("VIN Family");

		reportLog("8.2: Select 'VSPN'");
		promoPage.selectVspn();
		
		reportLog("8.3: Verify 'VSPN' page loads successfully");
		ParentWin=switchToChildWindow();
		promoPage.verifyVSPnSubtitle(Constants.personnelNetwork);

		reportLog("8.4: Close the 'VSPN' tab");
		switchParentWindowByClosingChild(ParentWin);

		reportLog("8.4: Select the 'VIN Family' drop down option");
		promoPage.selectDropDown("VIN Family");

		reportLog("8.6: Select 'VIN Students'");
		promoPage.selectVInStudents();
		
		reportLog("8.7: Verify 'VIN Students' page loads successfully");
		ParentWin=switchToChildWindow();
		promoPage.verifyVINStudentsSubtitle();
		
		reportLog("8.8: Close the 'VIN Students' tab"); 
		switchParentWindowByClosingChild(ParentWin);
		
		reportLog("9.1: Select 'Friends of VIN'");
		friendsOfVinPage=promoPage.selectFriendsOfVin( FriendsOfVINPage.class);

		reportLog("9.2: Select the 'Conference Home' link under 'ACVIM'");
		friendsOfVinPage.selectConfrerenceHomeLink();
		
		reportLog("9.3: Verify 'ACVIM' page loads successfully");
		ParentWin=switchToChildWindow();
		friendsOfVinPage.verifyACVIMPage();
		
		reportLog("9.4: Close the 'ACVIM' tab");
		switchParentWindowByClosingChild(ParentWin);

		reportLog("9.5: Select the 'Proceedings Access' link under 'ACVIM'");
		friendsOfVinPage.selectProceedingAccesslink();
		
		reportLog("9.6: Verify 'ACVIM Proceedings' page loads successfully");
		ParentWin=switchToChildWindow();
		friendsOfVinPage.verifyProcedingAccessSubTitle();

		reportLog("9.7: Close the ACVIM Proceedings tab");
		switchParentWindowByClosingChild(ParentWin);
		
		reportLog("10.1: Select the 'Contact' drop down option");
		promoPage.selectDropDown("Contact");

		reportLog("10.2: Select 'Contact'");
		promoPage.selectOption("Contact", PromoPage.class);
		
		reportLog("10.3: Under the 'Name' text field, type 'Selenium'");
		reportLog("10.4: Under the 'Email' text field, type 'selenium@vin.com'");
		reportLog("10.5: Under the 'Subject' text field, type 'Selenium test'");
		reportLog("10.6: Under the 'Message:', type 'This is a Test'");
		promoPage.EnterContactInformation(Constants.Name, Constants.Email, Constants.Subject, Constants.Message);
		
		reportLog("11.1: Select the 'Contact' drop down option");
		promoPage.selectDropDown("Contact");

		reportLog("11.2: Select 'Membership'");
		promoPage.selectOption("Membership", PromoPage.class);
		
		reportLog("11.3: Verify 'Membership' page loads successfully");
		promoPage.verifyMemBershipSubtitle();
		
		reportLog("Close Browser");
		promoPage.closeDriver();
		
		


		
	}

}
