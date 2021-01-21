package com.vin.testscripts;

import com.vin.pages.FrontPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class Vindex extends BaseTest {
	private String SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName, parentwin, parentWindow,
			mediacalFaqWindow, vindexPopOutWindow;
	private List<String> multipleWindows;

	public Vindex() {
		super();
	}

	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());

		SecurityAnswerSecoreIDNumber = RegressionTestData.getProperty("SecurityAnswerSecoreIDNumber");
		SecurityAnswerMothersMaidenName = RegressionTestData.getProperty("SecurityAnswerMothersMaidenName");

	}

	/**
	 * ====================================================================================================================
	 * Test Case Name: VINDEX
	 * ====================================================================================================================
	 * 
	 * @throws Exception
	 * 
	 * @throws ParseException
	 */

	@Test
	public void vinDex() throws Exception {

		reportLog("1.0: verify VIN Promo page is loaded ");
		promoPage.verifyPromoPage();

		reportLog("1.1.0: Call Login method");
		loginPage = promoPage.clickOnLoginButton();

		reportLog("1.1.1: Verify login page is displayed");
		loginPage.verifyUserLoginPage();

		reportLog("1.1.2: Log in to the Portal ");
		securityQuestionPage = loginPage.loginInApplication(UserID, UserPswrd);

		reportLog("1.1.3: Verify Security Question Page displayed");
		securityQuestionPage.verifySecurityQuestionPageDisplayed();

		reportLog("1.1.4: Enter Security Answer and Login if Security Question Page displayed");
		frontPage = securityQuestionPage.enterSecurityAnswerAndLogin(FrontPage.class,SecurityAnswerSecoreIDNumber,
				SecurityAnswerMothersMaidenName);
		
		reportLog("1.2: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();

		reportLog("2.1: Select 'VINdex' from the toolbar");
		vindexPage = frontPage.clickOnVindex();

		reportLog("2.1.1 Verify VINDEX pop out window is displayed ");
		parentwin = switchToChildWindow();
		vindexPage.verifyVindexWindowDisplayed(Constants.TitleVINDEX);

		reportLog("2.2:  Select the VINdex tab");
		vindexPage.clickOnVindex();

//		reportLog("4.2 Verify VINdex tab is loaded ");
//		vindexPage.verifyVindexWindowDisplayed(Constants.TitleVINDEX);

		reportLog("3.1  Select 'Medical FAQs' link");
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.MedicalFaqs);
		
		reportLog("3.2: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();

		reportLog("3.2.1:  Verify Medical FAQs page is loaded ");
		multipleWindows = getAllWindowsOpenInUI();
		parentWindow = multipleWindows.get(0);
		mediacalFaqWindow = multipleWindows.get(1);
		vindexPopOutWindow = multipleWindows.get(2);
		
		switchToWindow(parentWindow);
		switchToWindow(mediacalFaqWindow);
		switchToWindow(vindexPopOutWindow);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.MedicalFaqs);

		reportLog("4.1: Select 'Drug Resourc/es' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.DrugResources);
		
		reportLog("4.2: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();

		reportLog("4.2.1 Verify Drug Resources page is loaded ");
		multipleWindows = getAllWindowsOpenInUI();
		String parentWindow1 = multipleWindows.get(0);
		String mediacalFaqWindow = multipleWindows.get(1);
		String vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.DrugResourcesPageTitle);

		reportLog("5.1  Select 'Drug Hndbk. VIN (VVDH)' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.DrugHndbk);
		
		reportLog("5.2: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();

		reportLog("5.2.1: Verify VIN Veterinary Drug Handbook page is loaded ");
		multipleWindows = getAllWindowsOpenInUI();
		String mediacalFaqWindow1 = multipleWindows.get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.DrugHndbkPageTitle);
		
		reportLog("6.1: Select 'Drug Formulary, VIN Exotic' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.DrugFormuLary);
		
		
		reportLog("6.2: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();
		
		reportLog("6.2.1: Verify VIN Formulary page is loaded ");
		multipleWindows = getAllWindowsOpenInUI();
		 mediacalFaqWindow1 = multipleWindows.get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.DrugFormuLaryPageTitle);
		
		reportLog("7.1: Select '20 Years of VIN' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.TwentyYearsOfVin);
		
		reportLog("7.2: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();
		
		reportLog("7.2.1: Verify 20 years of VIN page is loaded ");
		multipleWindows = getAllWindowsOpenInUI();
		 mediacalFaqWindow1 = multipleWindows.get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.VIN20YearsPageTitle);
		
		reportLog("8.1: Select '3D Learning - IVALA' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.ThreeDLearning);
		
		reportLog("8.2: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();
		
		
		reportLog("8.2.1: Verify 3D Learning IVALA page is loaded ");
		multipleWindows = getAllWindowsOpenInUI();
		 mediacalFaqWindow1 = multipleWindows.get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.threeDLearningPageTitle);
		
		
		
		reportLog("9.1 Select 'Abbreviations' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.Abbreviation);
		
		reportLog("9.2: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();

		reportLog("9.2.1 Common Abbreviations And Acronyms page is loaded ");
		multipleWindows = getAllWindowsOpenInUI();
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.CommonAbbreviationsAndAcronymsPage);
		
		
		reportLog("10.1: Select 'About This Folder Pages' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.AboutThisFolderLink);
		
		reportLog("10.2: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();

		reportLog("10.2.1: Vet-to-Vet About Pages is loaded ");
		multipleWindows = getAllWindowsOpenInUI();
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.VetToVETAboutPage);
		
		
		reportLog("11.1: Select 'Anatomy in 3D' Link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.anatomyIn3D);
		
		reportLog("11.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();

		reportLog("11.2.1: Learn anatomy in 3d  Pages is loaded ");
		multipleWindows = getAllWindowsOpenInUI();
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.LearnAnatomyPage);
		
		reportLog("12.1: Select 'Anesthesia Protocols' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.anesthesiaLink);
		
		reportLog("12.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();
		
		reportLog("12.2.1: Learn anatomy in 3d  Pages is loaded ");
		multipleWindows = getAllWindowsOpenInUI();
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.anesthesiaLinkPage);
		
		
		
		reportLog("13.1 Select 'Article copies' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.ArticleCopies);
		
		reportLog("13.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();

		reportLog("13.2.1: How do I order the full text of an article? page is loaded ");
		multipleWindows = getAllWindowsOpenInUI();
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.HowDoOrderFullTextOfAnArticlePage);
		
		

		reportLog("14.1 Select 'Associate' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
        vindexPage.clickOnAssociateLink(Constants.Associate);
        
        
        reportLog("14.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();


		reportLog("14.2 Associate page is loaded ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.AssociatePage);
		
		
		reportLog("15.1: Select 'BestBETs for Vets' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
        vindexPage.clickOnAssociateLink(Constants.bestBETs);
        
        
        reportLog("15.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();
		
		reportLog("15.2.1: BestBETs for vets page is loaded");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.bestBETsPage);
		
		
		reportLog("16.1: Select 'BETA.VIN.COM' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
        vindexPage.clickOnAssociateLink(Constants.betaVINLink);
		
        reportLog("16.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();
		
		
		reportLog("16.2.1: BestBETs for vets page is loaded");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.pageTitle_FrontPage);
		
		reportLog("17.1: Select 'VIN Video Tips' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
        vindexPage.clickOnAssociateLink(Constants.VinVideoTips);
        
        
        reportLog("17.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();
		

		reportLog("17.2.1: BestBETs for vets page is loaded");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.VinVideoTipsPage);
		
		reportLog("18.1 Select 'Books' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.scrollDown();
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.BookLink);
		
		 reportLog("18.2: Dismiss Alert Notifications if displayed ");
		 frontPage.dismissNotifications();
		

		reportLog("18.2.1 Books & Manuals page is loaded ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.BookAndManualsLibraryPage);
		
		
		reportLog("19.1 Select 'VIN Store' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.VinStoreLink);
		
		 reportLog("19.2: Dismiss Alert Notifications if displayed ");
		 frontPage.dismissNotifications();

		reportLog("19.2.1 VIN Book store is loaded ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.VinBookstorePage);
		
		
		reportLog("20.1 Select 'Calculators/Conversions' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.CalculatorLink);

		reportLog("20.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();
		
		reportLog("20.2.1 Calculators page is loaded ");
		multipleWindows = getAllWindowsOpenInUI();
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyCalculatorPage();
		
		
		reportLog("21.1 Select 'Cases: Challenging & Fun' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.CasesChallenging_FunLink);
		
		reportLog("21.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();

		reportLog("21.2.1 Avian & Exotics page is loaded ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.Avian_ExoticsPage);
		
		
		reportLog("22.1 Select 'CE' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.CE);
		
		reportLog("22.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();

		reportLog("22.2.1 Continual Education page is loaded ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.ContinualEducationPage);
		
		
		reportLog("23.1 Select 'Classified Ads' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.ClassifiedAds);
		
		reportLog("23.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();


		reportLog("23.2.1 VETQuest Classified page is loaded ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.VetQuestClassifiedsPage);
		
		reportLog("24.1 Select 'Client Education' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.ClientEducation);
		
		reportLog("24.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();

		reportLog("24.2.1 Forms and Handouts page is loaded ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.FormsHandoutsPage);  
		
		
		reportLog("25.1 Select 'Clinical Trials/Research' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.ClinicalTrialsLink);
		
		reportLog("25.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();

		reportLog("25.2.1 Vet Clinical Trials page is loaded ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.VetClinicalTrialsPage);
		
		reportLog("26.1 Select 'Contact VIN' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.scrollDown();
		vindexPage._waitForJStoLoad();
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.ContactVINLink);
		
		reportLog("26.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();


		reportLog("26.2.1 Contact us page is loaded ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyContactUsPageISDisplayed();
		
		
		reportLog("27.1: Select 'Continual Education' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.scrollDown();
		vindexPage._waitForJStoLoad();
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.continualEducationLink);
		
		reportLog("27.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();
		
		reportLog("27.2.1 Contact us page is loaded ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.continualEducationPage);
		
		
		reportLog("28.1 Select 'Drug Label Database' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.scrollDown();
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.DrugLabelLink);
		
		reportLog("28.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();

		reportLog("28.2.1 DrugLabel database page displayed");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.drugDatabasePage);
		//vindexPage.verifyDrugResourceFilterIsSelected();
		
		
		reportLog("29.1: Select 'eVetsites' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.eVetsitesLink);
		
		reportLog("29.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();

		reportLog("29.2.1: eVETSItes page is loaded ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyEvetSitePageDisplayed();
		
		reportLog("30.1: Select 'FAQs - Medical' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.faqMedicalLink);
		
		reportLog("30.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();
		
		reportLog("30.2.1: Verify FAQ medical page is opened");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.MedicalFaqsPage);
		
		
		reportLog("31.1: Select 'Forms & Handouts' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.formsHandoutsLink);
		
		
		reportLog("31.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();
		
		
		reportLog("31.2.1: Verify FAQ medical page is opened");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.FormsHandoutsPage);
		
		reportLog("32.1: Select 'Front Page' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.frontPageLink);
		
		reportLog("32.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();
		
		
		reportLog("32.2.1: Verify Front page is opened");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.pageTitle_FrontPage);
		
		reportLog("33.1: Select 'Fun & Challenging Cases' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.CasesChallenging_FunLink);
		
		reportLog("33.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();
		
		
		reportLog("33.2.1: Verify Fun and challenging page is opened");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.funChallengingPage);
		
		
		reportLog("34.1 Select 'Help' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.HelpLink);
		
		reportLog("34.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();

		reportLog("34.2.1 VIN Help Resource Center id displayed ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyHelpVinCentreIdDisplayed();
		
		
		reportLog("35.1 Select 'Explore Discover Learn VIN' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.ExploreDiscoverLearnVINLink);
		
		reportLog("35.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();

		reportLog("35.2.1 Explore, Discover, Learn VIN or How to Use VIN is displayed ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.ExploreDiscoverLearnVINPage);
		
		
		reportLog("36.1 Select 'Image Library' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.ImageLibraryLink);
		
		reportLog("36.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();

		reportLog("36.2.1 Image Library is displayed ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.ImageLibraryPage); 
		
		reportLog("37.1 Select 'Proud to be a VINner' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.ImProudToBeViNner);
		
		reportLog("37.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();

		reportLog("37.2.1 Proud to be a VINner page is displayed");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.ProudToBeViNnerPage);
		
		
		reportLog("38.1 Select 'Insurance Options' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.scrollDown();
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.InsuranceOptionsLink);
		
		reportLog("38.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();
		

		reportLog("38.2.1 Insurance Products for Veterinarians is displayed  ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.InsuranceProductsPage);
		
		
		reportLog("39.1 Select 'Journals & Pubs' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.JournalsPubsLink);
		
		reportLog("39.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();
		

		reportLog("39.2.1 Welcome to VIN journals is displayed ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyVinJournalsPageISDisplayed();   
		
		reportLog("40.1 Select 'Legal Bites' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.LegalBitesLink);
		
		reportLog("40.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();
		

		reportLog("40.2.1 Legal Specialty Center is displayed ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyLegalSpecialityCentre();
		
		
		reportLog("41.1 Select ' Library' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.libraryLink);
		
		reportLog("41.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();

		reportLog("41.2.1 VIN Library page is displayed");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
//		vindexPage.verifyVinLibraryPageDislplayed();
		vindexPage.verifyPageDisplayed(Constants.booksAndManualPageTitle);

		
		
		reportLog("42.1: Select 'Medical FAQs' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.MedicalFaqLink);
		
		reportLog("42.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();
		
		reportLog("42.2.1 Medical FAQ page is displayed");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.MedicalFaqsPage);
		
		
		reportLog("43.1 Select 'Message Boards' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.MessageBoardsLink);
		
		reportLog("43.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();

		reportLog("43.2.1 VIN Message Boards is displayed ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyMessageBoardIsDisplayed();

		
		
		reportLog("44.1 Select 'Mentor-procedure videos' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.MentorprocedurevideosLinks);
		
		reportLog("44.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();

		reportLog("44.2.1 VIN Mentor: Visual Procedures Manual is displayed ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyVinMentorVisualProcedureManualIsDisplayed();
		
		
		reportLog("45.1: Select 'Mobile (VIN Homepage).");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.mobileVinHomePageLink);
		
		
		reportLog("45.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();
		
		
		reportLog("45.2.1 VIN Mobile page is displayed ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.vinHomePageMobileTitle);
		
		
		reportLog("46.1 Select 'MSDS Database' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.MSDSDatabaseLink);
		
		reportLog("46.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();

		reportLog("46.2.1 MSDS page is displayed ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.MSDSSDSPage);
		
		
		reportLog("47.1 Select 'MyActivities' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.MyActivitiesLink);
		
		reportLog("47.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();

		reportLog("47.2.1 Activities page is displayed with 'My most viewed discussion 'tab is selected ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyMyMostViewActivitiesIsDislpayed(Constants.pageTitle_MyActivity);
		
		
		reportLog("48.1 Select 'MyVIN' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.scrollDown();
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.MyVINLink);
		
		reportLog("48.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();

		reportLog("48.2.1 MyStuff page is displayed ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyMyStuffPageIsDisplayed();
		
		
		reportLog("49.1 Select 'News' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.NewsLink);
		
		reportLog("49.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();

		reportLog("49.2.1 VIN News page is displayed");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.NewsPage);
		
		reportLog("50.1: Select 'Password Vault (BETA)' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.passwordVaultLink);
		
		reportLog("50.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();
		
		reportLog("50.2.1: Password vault beta page is displayed");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.passwordVaultBetaPage);
		
		reportLog("51.1: Select 'Password Vault (WWW)' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.passwordVaultLinkwww);
		
		reportLog("51.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();
		
		
		reportLog("51.2.1: Password vault www page is displayed");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.passwordVaultwwwPage);
		
		reportLog("52.1: Select 'Podcasts (VINCasts)");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.podcastLink);
		
		reportLog("52.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();
		
		reportLog("52.2.1: podcast page is displayed");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.podcastPage);
		
		
		reportLog("53.1: Select 'Proceedings' link");

		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.ProceedingsLink);
		
		reportLog("53.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();

		reportLog("53.2.1 Proceedings by Conference page is displayed ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.ProceedingsByConferencePage); 
		
		reportLog("54.1: Select 'PUBMED\" link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.PubmedLink);
		
		reportLog("54.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();
		
		
		reportLog("54.2.1 Pubmed page is displayed ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.pubmedPage);
		
		
		reportLog("55.1 Select 'Recall Center' link");
        vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.RecallCenterLink);
		
		reportLog("55.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();

		reportLog("55.2.1 Drug and Food Recall Center is displayed ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.RecallCenterPage);
		
		
		reportLog("56.1 Select 'Rounds' link");

		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.scrollDown();
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.RoundsLink);
		
		reportLog("56.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();

		reportLog("56.2.1 Rounds Homepage is displayed ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.RoundsHomePage);
		
		reportLog("57.1: Select ' Rounds Transcripts' link");

		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.scrollDown();
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.RoundsTranscriptsLink);
		
		reportLog("57.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();

		reportLog("57.2.1: Search 4 page is displayed with VIN Rounds filter selected  ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.Search4Page);
		
		
		reportLog("58.1: Select ' Search' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.SearchLink);
		
		reportLog("58.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();

		reportLog("58.2.1: Search 4 page is displayed ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.Search4Page);
		
		
		reportLog("59.1 Select 'Specialty Centers' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.SpecialtyCentersLink);
		
		reportLog("59.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();

		reportLog("59.2.1 Specialty Centers page is displayed ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.SpecialtyCentersPage);
		
		
		reportLog("60.1: Select 'Student Center' link ");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.StudentCenterLink);
		
		reportLog("60.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();
		

		reportLog("60.2.1 VIN Student Center is displayed  ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.StudentCenterPage);
		
		reportLog("61.1: Select 'Surveys' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.SurveyLink);
		
		reportLog("61.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();
		
		reportLog("61.2.1 survey page is displayed  ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.SurveyPage);
		
		
		reportLog("62.1: Select 'Tough Questions/Answers' link ");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.ToughQuestions_AnswersLink);
		
		reportLog("62.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();

		reportLog("62.2.1: VINner Answers to Tough Questions is displayed  ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.ToughQuestions_AnswersPage); 
		
		
		reportLog("63.1: Select ' Veterinary Partner' link ");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.VeterinaryPartnerLink);
		
		reportLog("63.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();

		reportLog("63.2.1: Veterinary Partner page is displayed  ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.VeterinaryPartnerPage); 
		
		
		reportLog("64.1: Select 'VetQuest' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.VetQuestLink);
		
		reportLog("64.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();
		
		reportLog("64.2.1: Veterinary Partner page is displayed  ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.VetQuestPage); 
		
		reportLog("65.1 Select 'Vets4Vets' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.Vets4VetsLink);
		
		reportLog("65.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();

		reportLog("65.2.1 VETS4VETS page is displayed  ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.Vets4Vetspage);
		
		
		reportLog("66.1 Select 'VetzInsight' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.VetzInsightLink);
		
		reportLog("66.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();

		reportLog("66.2.1 VetzInsight portal is displayed  ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.VetzInsightPage);
		
		
		reportLog("67.1: Select 'VINCasts (Rounds Podcasts)' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.VINCastsLink);
		
		reportLog("67.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();


		reportLog("67.2.1:  Search page is loaded  ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.Search4Page);
		
		reportLog("68.1: Select 'VINcyclopedia (Associate)' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.VINCyclopediaLink);
		
		reportLog("68.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();
		
		reportLog("68.2.1:  Search page is loaded  ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.VINCyclopediaPage);
		
		reportLog("69.1: Select 'VIN Drug Hndbk. (VVDH)' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.VVDHLink);
		
		reportLog("69.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();
		
		reportLog("69.2.1:  VVDH page is loaded  ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.VVDHPage);
		
		reportLog("70.1: Select 'VIN Exotic Animal Formulary'");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.VINExoticLink);
		
		reportLog("70.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();
		
		reportLog("70.2.1:  VVDH page is loaded  ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.VINExoticPage);
		
		reportLog("71.1 Select 'VIN Foundation' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.VINFoundationLink);
		
		reportLog("71.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();

		reportLog("71.2.1 VIN Foundation portal is displayed ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.VINFoundationPage);
		
		
		reportLog("72.1 Select '  VIN Policies' link ");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.VINPoliciesLink);
		
		reportLog("72.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();

		reportLog("72.2.1 VIN Policies page is displayed ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.VINPoliciesPage);
		
		
		reportLog("73.1 Select 'VIN This Week' link ");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.VINThisWeekLink);
		
		reportLog("73.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();

		reportLog("73.2.1 VIN this week is displayed  ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.VINThisWeekPage);
		
		
		reportLog("74.1 Select 'VINx' link ");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.VINxLink);
		
		reportLog("74.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();

		reportLog("74.2.1 VINx page is displayed ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.VINxPage);
		
		
		reportLog("75.1 Select 'Virtual Clinic' link ");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.VirtualClinicLink);
		
		reportLog("75.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();

		reportLog("75.2.1 VIN Virtual Clinic portal is displayed ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.VirtualClinicPage);
		
		
		reportLog("76.1 Select 'VSPN' link");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.VSPNLink);
		
		reportLog("76.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();

		reportLog("76.2.1 VSPN page is displayed  ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyPageDisplayed(Constants.VSPNPage);
		
		
		reportLog("77.1 Select 'WWW Directory' link ");
		vindexPage.switchChildWindowByClosingParent( mediacalFaqWindow);
		vindexPage.clickOnLInksPresentInTheVindexTab(Constants.WWWDirectoryLink);
		
		reportLog("77.2: Dismiss Alert Notifications if displayed ");
		frontPage.dismissNotifications();

		reportLog("77.2.1: WWW Resources page is displayed ");
		mediacalFaqWindow = getAllWindowsOpenInUI().get(1);
		vindexPopOutWindow = getAllWindowsOpenInUI().get(2);
		switchToWindowWithBrowser(vindexPopOutWindow);
		vindexPage.verifyResourcePageDislplayed();
		vindexPage.getDriver().close();
		
		
		reportLog("78.1: Close VINdex window");
		switchToWindowWithBrowser(parentwin);
		
		reportLog("79.1: Call Logout Method");
		logoutPage=frontPage.logoutApplication();
		
		reportLog("79.2: Verify user logged out successfully");
		logoutPage.verifyLogoutPageDisplayed();		

	}
}

