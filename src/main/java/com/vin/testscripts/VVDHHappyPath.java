package com.vin.testscripts;

import com.vin.pages.FrontPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class VVDHHappyPath extends BaseTest {
	private String SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName, parentwin, articletext;

	public VVDHHappyPath() {
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
	 * Test Case Name: VVDHHappyPath
	 * ====================================================================================================================
	 * 
	 * @throws InterruptedException
	 * 
	 * @throws ParseException
	 */

	@Test
	public void vVDh() throws InterruptedException {

		reportLog("1.1: Verify VIN Promo page is loaded (Title: Veterinary Information Network®, Inc. – VIN)");
		promoPage.verifyPromoPage();

		reportLog("1.2: Select the LOGIN button");
		loginPage = promoPage.clickOnLoginButton();

		reportLog("1.3: Verify login page is displayed (Title: Login)");
		loginPage.verifyUserLoginPage();

		reportLog("1.4: Log in to the Portal");
		securityQuestionPage = loginPage.loginInApplication(UserID, UserPswrd);

		reportLog("1.5: Verify Security Question Page displayed (Title: VIN – Security Question)");
		securityQuestionPage.verifySecurityQuestionPageDisplayed();

		reportLog("1.6: Enter Security Answer and Login if Security Question Page displayed");
		frontPage = securityQuestionPage.enterSecurityAnswerAndLogin(FrontPage.class, SecurityAnswerSecoreIDNumber,
				SecurityAnswerMothersMaidenName);
		
		reportLog("1.7: Verify Front Page displayed (Title: Front Page – VIN)");
		frontPage.verifyFrontPageDisplayed();


		reportLog("1.8: Dismiss Alert Notifications if displayed");
		frontPage.dismissNotifications();

		reportLog("2.1: Select the 'Library' dropdown and then select 'VIN Veterinary Drug Handbook'");
		vvdh = frontPage.clickLibraryDropDwonAndSelectVetrinaryDrugHandbook();

		reportLog("3.1: Provide 'Adenosylmethionine' as a search term in search text box and then select 'GO'");
		vvdh.EnterValueAndSelectGo();

		reportLog("3.2: Verify Search results are displayed in the right pane");
		vvdh.verifySearchedResults(Constants.SAdenosylmethionine);
		
		reportLog("4.1: Click on checkbox for result # 1 and 2");
		vvdh.clickOnResult1and3ChkBox();

		reportLog("4.2: Verify All checkboxes displayed on the page are selected");
		List<String> values = vvdh.verifyResult1and3ChkBoxSelected();

		reportLog("5.1: Click on 'View Checked' button");
		vvdh.clickOnViewCheckButton();
		
		reportLog("5.2: Dismiss Alert Notifications if displayed");
		vvdh.dismissNotifications();

		reportLog("5.3: Verify Results are displayed on the new page");
		parentwin = switchToChildWindow();
		vvdh.verifyAllCheckboxesAreViewedCheck(values);

		reportLog("6.1: Select 'Add List to MyStuff' link");
		vvdh.selectMyStuffLink();

		reportLog("6.2: MyStuff window is displayed with a pop up message 'You are adding 'VIN Veterinary Drug Handbook -"
				+ " VIN' to your MyStuff. After you click OK, you may pick a folder for your link and don't forget to click Add link.'");
		reportLog("7.1: Select 'OK'");
		List<String> multipleWindows = getAllWindowsOpenInUI();
		switchToWindow(multipleWindows.get(2));
		vvdh.verifyAddToMYSTuffPopUpDisplayed(Constants.MyStuffPopUpText);

		reportLog("8.1: Select 'Cancel'");
		vvdh.clickOnCancelButton();

		reportLog("8.2: Verify MyStuff window is displayed");
		vvdh.verifyMyStuffDisplayed(Constants.MyStuff);

		reportLog("9.1: Close MyStuff window");
		vvdh.closeMyStuffWindow();
		switchToWindow(multipleWindows.get(1));

		reportLog("9.2: Verify MyStuff window is closed");
		reportLog("9.3: Close tab displaying View Checked results");
		reportLog("9.4: The tab displaying View Checked results is closed");
		vvdh.verifyMyStuffWindowIsClosed();
		
		reportLog("10.1 Select from the left navigation under Drug Name");
		vvdh.selectAlphabetA();

		reportLog("10.2 Verify  List of all A drugs are displayed in the right pane. ");
		vvdh.verifyListOfAllDrugsDisplayed(Constants.AlphabetA);

		reportLog("11.1 Select open in new window icon for Albumina");
		vvdh.selectAlbuminOpenLinkInNewWindow();
		
		reportLog("11.2: Dismiss Alert Notifications if displayed");
		vvdh.dismissNotifications();

		reportLog("11.3: Verify 'Albumin' drug is displayed in a new tab/window");
		List<String> multipleWindowsOpen = getAllWindowsOpenInUI();
		switchToWindow(multipleWindowsOpen.get(0));
		switchToWindow(multipleWindowsOpen.get(1));
		switchToWindow(multipleWindowsOpen.get(2));
        vvdh.verifyLinkOpenedInNewWindow(Constants.albuminText);

		reportLog("12.1: Click on 'Expand All' button");
		vvdh.selectExpandAllButton();

		reportLog("12.2: Verify All the sections for Albumin are expanded");
		vvdh.verifyListHaveExpanded();

		reportLog("13.1: Click on 'Collapse All' button");
		vvdh.selectCollpasedAllButton();
		vvdh.selectExpandAllButton();
		vvdh.selectCollpasedAllButton();

		reportLog("13.2: Verify All the sections for Albumin are collapsed");
		vvdh.verifyListHaveCollpased();

		reportLog("14.1: Select Preferences dropdown and then select 'Set your default preferences in MyVIN for VDH'");
		vvdh.selectPreferencesDropDownAndSelectLastOption();

		reportLog("14.2: Verify 'VIN Veterinary Drug Handbook preferences drop dowm window is displayed");
		List<String> multipleWindowsOpens = getAllWindowsOpenInUI();
		switchToWindow(multipleWindowsOpens.get(3));
		vvdh.verifyVinVeterinaryDrugHandbookWindowDisplayed();

		reportLog("15.1: Select 'Set VIN Default as the default view'");
		vvdh.selectVINDefaultCheckBox();
		
		reportLog("15.2 Verify VIN Default radio button is selected ");
		vvdh.verifyVinDefaultRadioButtonSelected();

		reportLog("16.1: Verify Preferences drop down window closes after selecting an option");
		vvdh.closePreferenceWindow();

		reportLog("16.2: Close 'Albumin' tab");
		reportLog("16.3: Verify 'Albumin' tab is closed");
		switchToWindow(multipleWindowsOpens.get(2));
		vvdh.verifyLinkOpenedInNewWindow(Constants.albuminText);

		reportLog("17.1: Select 'Therapeutic Category' tab from the left navigation under 'Browse By'");
		vvdh.selectTherapeuticCategory();

		reportLog("17.2: Verify 'Therapeutic Category' tab is selected");
		vvdh.verifyTherapeuticCategoryTabIsSelected();

		reportLog("18.1: Select 'C'");
		vvdh.selectCUnderTherapeuticCategory();
		
		reportLog("18.2: Dismiss Alert Notifications if displayed");
		vvdh.dismissNotifications();

		reportLog("18.3: Verify List of Therapeutic Category for C is displayed in the right pane");
		vvdh.verifyListOfAllDrugsDisplayed(Constants.AlphabetC);

		reportLog("19.1: Select 'Cardiovascular Agents'");
		vvdh.selectCardiovascularAgents();
		
		reportLog("19.2: Dismiss Alert Notifications if displayed");
		vvdh.dismissNotifications();

		reportLog("19.3: Verify List of 'Cardiovascular Agents' is displayed in the right pane");
		vvdh.verifyCardiovascularAgentIsShown();

		reportLog("20.1: Select 'Digoxin'");
		vvdh.selectDigoxin();
		
		reportLog("20.2: Dismiss Alert Notifications if displayed");
		vvdh.dismissNotifications();

		reportLog("20.3: Verify 'Digoxin' is displayed with 'Doses' and 'References' sections are expanded.");
		vvdh.verifyDosesAndReferenesAreaIsExpanded();

		reportLog("21.1: Select 'VIN Veterinary Drug Handbook' logo from the left upper corner");
		vvdh.selectVinVeterinaryLogo();

		reportLog("22.1: Verify 'VIN Veterinary Drug Handbook' main page is displayed");
		vvdh.verifyVeterinaryDrugHandBookPageDisplayed(Constants.VetrinaryDrugHandBook);

		reportLog("23.1: Logout Application");
		logoutPage = frontPage.logoutApplication();

		reportLog("23.2: Logging off from VIN is successful");
		logoutPage.verifyLogoutPageDisplayed();

	}
}
