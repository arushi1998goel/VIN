package com.vin.testscripts;

import com.vin.pages.FrontPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchUI extends BaseTest {

    private String SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName, AuthorName, Documentid, parentwin;
    private List<String> sortOrderDefault, sortOrderNew;

    //	@Factory(dataProvider = "Browsers", dataProviderClass = DataProviders.class)
    public SearchUI() {
        super();
    }

    @BeforeMethod
    public void getTestData() throws Exception {

        System.setProperty("className", getClass().getSimpleName());


        SecurityAnswerSecoreIDNumber = RegressionTestData.getProperty("SecurityAnswerSecoreIDNumber");
        SecurityAnswerMothersMaidenName = RegressionTestData.getProperty("SecurityAnswerMothersMaidenName");
        AuthorName = RegressionTestData.getProperty("Author_Wilson");
        Documentid = RegressionTestData.getProperty("Documentid_3647679");

    }

    /**
     * ====================================================================================================================
     * Test Case Name: SearchUI
     * ====================================================================================================================
     *
     * @throws InterruptedException
     * @throws ParseException
     */

    @Test
    public void searchUI() throws InterruptedException {

        /* APPLICATION LOGIN */

        reportLog("Application Login");

        reportLog("1: verify VIN Promo page is loaded ");
        promoPage.verifyPromoPage();

        reportLog("2: Select the LOGIN button");
        loginPage = promoPage.clickOnLoginButton();

        reportLog("3: Verify login page is displayed");
        loginPage.verifyUserLoginPage();

        reportLog("4: Log in to the Portal ");
        securityQuestionPage = loginPage.loginInApplication(UserID, UserPswrd);

        reportLog("5: Verify Security Question Page displayed");
        securityQuestionPage.verifySecurityQuestionPageDisplayed();

        reportLog("6: Enter Security Answer and Login if Security Question Page displayed");
        frontPage = securityQuestionPage.enterSecurityAnswerAndLogin(FrontPage.class, SecurityAnswerSecoreIDNumber,
                SecurityAnswerMothersMaidenName);

        reportLog("7: Verify Front Page displayed");
        frontPage.verifyFrontPageDisplayed();

        reportLog("8 Dismiss Notifications");
         frontPage.dismissNotifications();
        

        /* Search UI 1 */

        reportLog("SearchUI_1:Search Term with Search Icon");

        reportLog("1.1 Opens the Search page");
        searchPage = frontPage.clickOnSearchButton();

        reportLog("2.1 Enter a search Term");
        searchPage.searchTermInTheSearchBox(Constants.Diabetes_Text);

        reportLog("2.2 Member is able to type the word diabetes into the box");
        searchPage.verifSearchBoxIsEnabled();

        reportLog("3.1 Click on Search icon");
        searchPage.clickOnSearchButton();

        reportLog("3.2 Results will appear on the page");
        searchPage.verifyResults(Diabetes_Text);

        reportLog("3.3 Error pop up modal will display if user attempts to search without entering text.");
        searchPage.verifyErrorPopUp();

        /* Search UI 2 */

        reportLog("SearchUI_2:Search Term with Enter");

        reportLog("4.1 Enter a new Search Term: Enter diabetes mellitus treatment into the Search box");
        searchPage.searchTermInTheSearchBox(Constants.Diabetes_mellitusS);

        reportLog("5.1 Enter a carriage return (Enter)");
        searchPage.enterCarriageReturnForSearchBoxOnTop();

        reportLog("5.2 Results will appear on the page");
        searchPage.verifyResults(Diabetes_mellitusS);

        reportLog("SearchUI_3:Select Year Filter");

        reportLog("6.1 & 7.1 Click on Year drop down and Select Last Year");
        searchPage.clickOnYearDropDownAndSelectYear(Constants.Last_Year);

        /*
         * Search UI 4
         */

        reportLog("SearchUI_4:Clear Filters");

        reportLog("8.1 Click on clear Filter button");
        searchPage.clearFilterByClickingX();

        reportLog("8.2 The filter line will be removed");
        searchPage.verifyFilterButtonIsNotPresent();

        reportLog("10.1 Click on >= 2015");
        searchPage.clickOnYearDropDownAndSelectYearfromRanges(Constants.Year_2015);

        reportLog(
                "10.2 Results filtered by date of publication being >=2015.  A filter is added on the line underneath the Search Term Query Box.");
        searchPage.verifySearchResultsAppearAsAFilterUnderSearchTermBox(Constants.Year_2015);

        reportLog("11.1 Click on the X in front of the filter");
        searchPage.clickOnClearFilterButton();

        reportLog("11.2 The filter line will be removed.  Results will show for all years");
        searchPage.verifyFilterButtonIsNotPresent();


        /* Search UI 5 */

        reportLog("SearchUI_5:Select Species");

        reportLog("12.1 Click on Any Species");
        searchPage.clickAndOpenSpeciesDropDown();

        reportLog("13.1 Click on Any Species");
        searchPage.selectOptionDisplayedUnderSpeciesDropDown("1");

        reportLog("13.2 Results filtered by amphibians, Filter will show up under search bar");
        searchPage.verifySelectedValueSpeciesDropDown("Amphibians");
        searchPage.verifyFilterIconIsPresent();

        reportLog("14.1 Clear Filter");
        searchPage.clickOnClearFilterButton();

        /* Search UI 6 */

        reportLog("SearchUI_6:Select Folder");

        reportLog("15.1 Click on Any Folder");
        searchPage.clickAndOpenFolderDropDown();

        reportLog("16.1 Click on Behavior");
        searchPage.selectOptionDisplayedUnderFolderDropDown("109");

        reportLog("16.2 Results filtered by amphibians, Filter will show up under search bar");
        searchPage.verifySelectedValueFolderDropDown("Behavior");
        searchPage.verifyFilterIconIsPresent();

        reportLog("17.1 Clear Filter");
        searchPage.clickOnClearFilterButton();

        /* Search UI 7 */

        reportLog("SearchUI_7:Filter by Source");

        reportLog("18.1 Click on Conference proceedings");
        String resultCount = searchPage.clickConferenceProceedings();

        reportLog("18.2 Results filter by conference proceedings.  A list of conference proceedings replaces the Filter by Sources list.");
        searchPage.checkFilteredvaluesCount(resultCount);
        searchPage.verifyFilterBySourcesNotPresent();
        searchPage.verifyFilterIconIsPresent();

        reportLog("19.1 Click on conference proceedings to deselect it");
        searchPage.deselectConferenceProceedings();

        reportLog("19.2 Conference proceedings list will close and Filter by Source menu will be displayed");
        searchPage.verifySearchFilterIsNotApplied();
        searchPage.verifyFilterBySourcesPresent();

        /* Search UI 8 */

        reportLog("SearchUI_8:Filter by Additional Sources");

        reportLog("20.1 Click on Additional Sources drop down");
        searchPage.clickOnAdditionalSourceDrpDwn();

        reportLog("20.2 Verify a drop down menu will be displayed of additional sources");
        searchPage.verifyAdditionalSourceDrpDwnIsOpen();

        reportLog("21.1 Click on Forms and handouts");
        searchPage.clickFormsHandoutOption();

        reportLog("21.2 Filter by Source and Additional Sources menus are replaced by a menu of forms and handouts.");
        searchPage.verifyFormsHandoutFilterTextPresent();

        reportLog("22.1 Clear Additional Source Filter with a button");
        searchPage.clickOnClearFilterButton();

        reportLog(" 22.2 The filter line will be removed.");
        searchPage.verifyFilterButtonIsNotPresent();

        // ERROR - Filter by Source is closed
        reportLog("22.3 Filter by Source menu will again reopen.");
//		searchPage.verifyAdditionalSourceDrpDwnIsOpen();

        /*
         * Search UI 9
         */

        reportLog("SearchUI_9:Filter by Author and Documentid");

        reportLog("23.1: click on search By Author Or Document id Filter Drop Down");
        searchPage.clickOnSearchByAuthorOrDocumentidFilterDropDown();

        reportLog("23.2: verify Search Item box Are Displayed For Author Or Document id Filter");
        searchPage.verifySearchItemBoxAreDisplayedForAuthorOrDocumentidFilter();

        reportLog("24.1: Enter Value Under Authors Search Box");
        searchPage.enterValueUnderAuthorsSearchBox(AuthorName);

        reportLog("25.1: Enter a Carriage return For Authors Search Box");
        searchPage.enterCarriageReturnForAuthorsSearchBox();

        reportLog("25.2: verify search Results appear as a filter under the search term box");
        searchPage.verifySearchResultsAppearAsAFilterUnderSearchTermBox(AuthorName);

        reportLog("26.1: Enter Value Under Documentid(s) Search Box");
        searchPage.enterValueUnderDocumentidsSearchBox(Documentid);

        reportLog("27.1: Enter a Carriage return For Document Id Search Box");
        searchPage.enterCarriageReturnForDocumentIdSearchBox();

        reportLog("27.2: verify search Results appear as a filter under the search term box");
        searchPage.verifySearchResultsAppearAsAFilterUnderSearchTermBox(Documentid);

        /**
         * Search UI 10
         */

        reportLog("SearchUI_10:Clear Button");

        reportLog("28.1: click on Search button");
        searchPage.clickOnClearButton();

        reportLog("28.2: verify Search Filter Is Not Applied");
        searchPage.verifySearchFilterIsNotApplied();

        /**
         * Search UI 11
         */

        reportLog("SearchUI_11:Match All Terms");

        reportLog("SearchUI_29 : Enter " + Constants.Diabetes_mellitusDiet_TreatMent + " in the search box");
        searchPage.searchTermInTheSearchBox(Constants.Diabetes_mellitusDiet_TreatMent);

        reportLog("SearchUI_30 : Enter a Carriage return For Search Box On Top");
        searchPage.enterCarriageReturnForSearchBoxOnTop();

        reportLog("30.1: verify Color Of Search Hint Warning Under Search Box");
        searchPage.verifyColorOfSearchHintWarningUnderSearchBox(Constants.ColorCode_Yelow_Peach);

        reportLog("30.2: verify text of Search Hint Warning Under Search Box");
        searchPage.verifyTextOfSearchHintWarningUnderSearchBox("more than 3 search terms");

        reportLog("31.1: click On Link Displayed In Search Hint Warning Under Search Box");
        searchPage.clickOnLinkDisplayedInSearchHintWarningUnderSearchBox();

        reportLog("31.2: verify Search Hint Warning Under Search Box Not Displayed");
        searchPage.verifySearchHintWarningUnderSearchBoxNotDisplayed();

        reportLog("31.3: verify search Results appear as a filter under the search term box");
        searchPage.verifySearchResultsAppearAsAFilterUnderSearchTermBox("Match ALL terms");

        reportLog("32.1: click And Open Match Terms Drop Down In Search By Filter Box");
        searchPage.clickAndOpenMatchTermsDropDownInSearchByFilterBox();

        reportLog("33.1: select Option Displayed Under Match Terms Drop Down In Search By Filter Box");
        searchPage.selectOptionDisplayedUnderMatchTermsDropDownInSearchByFilterBox("Limit Search to Title/Keywords");

        reportLog("33.2: verify search Results appear as a filter under the search term box");
        searchPage.verifySearchResultsAppearAsAFilterUnderSearchTermBox("Limit Search to Title/Keywords");

        /**
         * Search UI 12
         */

        reportLog("SearchUI_12:View Checked");

        reportLog("34.1 Select Top two results from the page");
        searchPage.selectResultsFromPage(Constants.twoResults);

        reportLog("34.2 User is able to select a check box and numbers will update for the \"View Checked\" link");
        searchPage.verifySelectedResultsCount(Constants.twoResults);

        reportLog("35.1 Click Next Page");
        searchPage.goToNextPage();

        reportLog("35.2 The next page of results will be displayed");
        searchPage.verifyResults(Constants.Diabetes_mellitusTreatMent);

        reportLog("35.3 View Checked link will continue to display 2");
        searchPage.verifySelectedResultsCount(Constants.twoResults);

        reportLog("36.1 Again select top two users from this page");
        searchPage.selectResultsFromPage(Constants.twoResults);

        reportLog("36.2 User is able to select a check box and numbers will update to 4 for the \"View Checked\" link");
        searchPage.verifySelectedResultsCount(Constants.fourResults);

        reportLog("37.1 Click View Checked Drop down");
        searchPage.openViewCheckedDropDownMenu();

        reportLog("37.2 View Checked drop down will open");
        searchPage.verifyCheckedResultsDropDown();

        reportLog("38.1 Click View Checked Results (4)");
        searchPage.clickViewCheckedResultsPopUp();

        reportLog("38.2 Pop-up modal will display with the 4 selected topics chosen by member.");
        String parentWindow = switchToChildWindow();
        searchPage.verifyPopModalDisplayed(Constants.fourResults);

        reportLog("39.1 Close Pop-up window by clicking Red X");
        switchParentWindowByClosingChild(parentWindow);

        reportLog("39.2 pop-up modal will close");
        searchPage.verifyPopModalClosed();

        reportLog("40.1 Click View Checked Drop down");
        searchPage.openViewCheckedDropDownMenu();

        reportLog("40.2 View Checked drop down will open");
        searchPage.verifyCheckedResultsDropDown();

        reportLog("41.1 Click Check All This page");
        searchPage.clickCheckAllResultsOption();

        reportLog("41.2 All check boxes will be marked and the View Checked number will change to 27");
        searchPage.verifySelectedResultsCount(fiftyTwoResults);

        reportLog("42.1Click View Checked Drop down");
        searchPage.openViewCheckedDropDownMenu();

        reportLog("42.2 View Checked drop down will open");
        searchPage.verifyCheckedResultsDropDown();

        reportLog("43.1 Click Uncheck All This page");
        searchPage.uncheckPageResults();

        reportLog("43.2 All check boxes will be unmarked and the View Checked number will change to 2");
        searchPage.verifySelectedResultsCount(twoResults);

        reportLog("44.1 Click View Checked Drop down");
        searchPage.openViewCheckedDropDownMenu();

        reportLog("44.2 View Checked drop down will open");
        searchPage.verifyCheckedResultsDropDown();

        reportLog("45.1 Click on View Highlighted Checked Results");
        searchPage.viewHighlightedResults();

        reportLog("45.2 Pop-up modal will display with the 2 selected results chosen by member.");
        parentWindow = switchToChildWindow();
        searchPage.verifyPopModalDisplayed(Constants.twoResults);

        reportLog("45.3 The search terms will be highlighted in yellow");
        searchPage.verifyHighlightedTextColor(Constants.ColorCode_Yellow);

        reportLog("46.1 Close Pop-up window by clicking Red X");
        switchParentWindowByClosingChild(parentWindow);

        reportLog("46.2 pop-up modal will close");
        searchPage.verifyPopModalClosed();

        reportLog("47.1 Click View Checked Drop down");
        searchPage.openViewCheckedDropDownMenu();

        reportLog("47.2 View Checked drop down will open");
        searchPage.verifyCheckedResultsDropDown();

        reportLog("48.1 Click on Clear View Checked");
        searchPage.clearCheckedResults();

        reportLog("48.2 View checked will revert to no results, result page does not change.");
        searchPage.verifySelectedResultsCount(noResults);

        reportLog("49.1 Select check box of returned results for the top 2 results");
        searchPage.selectResultsFromPage(Constants.twoResults);

        reportLog("49.2 User is able to select a check box and numbers will update for the \"View Checked\" link");
        searchPage.verifySelectedResultsCount(Constants.twoResults);

        reportLog("50.1 Click Next Page");
        searchPage.goToNextPage();

        reportLog("50.2 The next page of results will be displayed");
        searchPage.verifyResults(Constants.Diabetes_mellitusTreatMent);

        reportLog("50.3 View Checked link will display 2");
        searchPage.verifySelectedResultsCount(Constants.twoResults);

        reportLog("51.1 Click the Clear button");
        searchPage.clickOnClearButton();

        reportLog("51.2 the original search page is displayed");
        searchPage.verifyNoResultsPresent();

        reportLog("51.3 search term box is empty");
        searchPage.verifySearchBoxEmpty();

        reportLog("52.1 Enter " + "Diabetes Mellitus Treatment" + " in the search box");
        searchPage.searchTermInTheSearchBox(Constants.Diabetes_mellitusTreatMent);

        reportLog("53.1 Enter a Carriage return For Search Box On Top");
        searchPage.enterCarriageReturnForSearchBoxOnTop();

        reportLog("53.2 Results will appear on the page");
        searchPage.verifyResults(Diabetes_mellitusTreatMent);

        reportLog("53.3 View Checked should be at zero due to our Clear button");
        searchPage.verifySelectedResultsCount(Constants.noResults);

        reportLog("54.1: Click And Open Match Terms Drop Down In Search By Filter Box");
        searchPage.clickAndOpenMatchTermsDropDownInSearchByFilterBox();

        reportLog("55.1 Click on Search PubMed");
        searchPage.selectOptionDisplayedUnderMatchTermsDropDownInSearchByFilterBox("Search PubMed (new window)");

        reportLog("55.2 A new window or tab will open for Pub med");
        searchPage.verifyNewWindowDisplayed();
        parentWindow = switchToChildWindow();

        reportLog(
                "55.3 search terms populated in the search box and results will be displayed in this window from PubMed");
        searchPage.verifySearchTerm(Constants.Diabetes_mellitusTreatMent);

        reportLog("56.1 Close PubMed window");
        switchParentWindowByClosingChild(parentWindow);

        reportLog("56.2 Window is closed");
        searchPage.verifyPopModalClosed();


        /*As per instruction Steps removed*/
		/*reportLog("57.1 Mouse over the Search link");
		searchPage.mouseOverSearchLink();

		reportLog("57.2 Text will display to say Right click to copy link");
		searchPage.verifyToolTipTextforLinkURL();

		reportLog("58.1 Right Click on Link URL");
		searchPage.rightClickLinkURL();*?

		/**
		 * Search UI 15
		 */

        reportLog("SearchUI_15:Sort by Date");

        reportLog("59.1 Click Sort By Relevance Drop down");
        sortOrderDefault = searchPage.clickSortOrderDropDown(sortOrderDefault);

        reportLog("59.2 Verify Drop Down is Open");
        searchPage.verifySortDropDownOpen();

        reportLog("60.1 Click Sort by Date");
        searchPage.clickSortByDateOption();

        reportLog("60.2 Result order will change");
        searchPage.verifySortingOrderChanges(sortOrderDefault, sortOrderNew, false);

        reportLog("61.1 Click X in front of Sort by Date");
        searchPage.clearSortFilter();

        reportLog("61.2 Result order will revert to relevance order");
        searchPage.verifySortingOrderChanges(sortOrderDefault, sortOrderNew, true);

        /**
         * Search UI 16
         */

        reportLog("SearchUI_16:Keep Filters");

        reportLog("62.1 Click on Associate filter");
        String filterValue = searchPage.clickAssociateFilter();

        reportLog("62.2 Results will be narrowed to Associate");
        searchPage.checkFilteredvaluesCount(filterValue);

        reportLog("63.1 Add diet to the end of the current search terms");
        String originalStr = searchPage.addAnotherSearchTerm(Constants.String_Diet);

        reportLog("64.1 Click on the search icon to start the search.");
        searchPage.clickOnSearchButton();

        reportLog("64.2 A pop-up will appear, asking if you wish to keep your filters");
        searchPage.verifyPopModalElementsPresent();

        reportLog("65.1 Click on Keep Filters & Search");
        searchPage.clickKeepFilterOption();

        reportLog("65.2 The modal will close");
        searchPage.verifyPopModalElementsNotPresent();

        reportLog("65.3 search will execute, leaving the Associate source filter in place.");
        searchPage.verifyAssociateFilterPresent();

        reportLog("65.4  The Match All Terms warning will appear");
        searchPage.verifySearchHintWarningUnderSearchBoxDisplayed();

        reportLog("65.5 The source filter list changes to show only Associate.");
        searchPage.sourceFilterForAssociate();

        reportLog("66.1 Remove diet from the current set of search terms");
        searchPage.searchTermInTheSearchBox(originalStr);

        reportLog("67.1 Click on the search icon to start the search.");
        searchPage.clickOnSearchButton();

        reportLog("67.2 A pop-up will appear, asking if you wish to keep your filters");
        searchPage.verifyPopModalElementsPresent();

        reportLog("68.1 Click on Clear Filters & Search");
        searchPage.clickClearFilterOption();

        reportLog("68.2 The modal will close");
        searchPage.verifyPopModalElementsNotPresent();

        reportLog("68.3 search will execute, removing the Associate source filter");
        searchPage.verifyFilterButtonIsNotPresent();

        reportLog("69.1 Click on Associate filter");
        filterValue = searchPage.clickAssociateFilter();

        reportLog("69.2 Results will be narrowed to Associate");
        searchPage.checkFilteredvaluesCount(filterValue);

        reportLog("70.1 Add diet to the end of the current search terms");
        originalStr = searchPage.addAnotherSearchTerm(Constants.String_Diet);

        reportLog("71.1 Click on the search icon to start the search.");
        searchPage.clickOnSearchButton();

        reportLog("71.2 A pop-up will appear, asking if you wish to keep your filters");
        searchPage.verifyPopModalElementsPresent();

        reportLog("72.1 Click on Do Not Show Pop up");
        searchPage.clickDoNotShowOnPopupModal();

        reportLog("72.2 The modal will close");
        searchPage.verifyPopModalElementsNotPresent();

        reportLog("72.3 search will execute, leaving the Associate source filter ");
        searchPage.verifyAssociateFilterPresent();
        searchPage.sourceFilterForAssociate();

        reportLog("73.1 Remove diet from the current set of search terms");
        searchPage.searchTermInTheSearchBox(originalStr);

        reportLog("74.1 Click on the search icon to start the search.");
        searchPage.clickOnSearchButton();

        reportLog("74.2 The pop-up will not happen.");
        searchPage.verifyPopModalElementsNotPresent();

        reportLog("75.1 Click the Clear button");
        searchPage.clickOnClearButton();

        reportLog("75.2 the original search page is displayed; search term box is empty");
        searchPage.verifySearchFilterIsNotApplied();
        searchPage.verifyNoResultsPresent();

        reportLog("76.1 Enter diabetes into the Search Box");
        searchPage.searchTermInTheSearchBox(Constants.Diabetes_Text);
        searchPage.clickOnSearchButton();

        reportLog("77.1 Click on Client Education filter");
        filterValue = searchPage.clickClientEducationFilter();

        reportLog(
                "77.2 Results will be narrowed to Client education.  Filter by Source will be replaced with a list of client education sources");
        searchPage.checkFilteredvaluesCount(filterValue);

        reportLog("78.1 Add diet to the end of the current search terms");
        originalStr = searchPage.addAnotherSearchTerm(Constants.String_Diet);

        reportLog("79.1 Click on the search icon to start the search.");
        searchPage.clickOnSearchButton();

        reportLog("79.2 A pop-up will appear, asking if you wish to keep your filters");
        searchPage.verifyPopModalElementsPresent();

        reportLog("80.1 Click on Cancel");
        searchPage.clickCancelModalBtn();

        reportLog("80.2 The modal will close and the search page will remain the same.");
        searchPage.verifyPopModalElementsNotPresent();
        searchPage.checkFilteredvaluesCount(filterValue);

        /* Search UI 17 */

        reportLog("81.1 Click on My Searches icon");
        searchPage.clickOnMySearches();

        reportLog("81.2 A separate window will open to My Searches tab of My Activities");
        parentwin = switchToChildWindow();
        searchPage.verifyNewWindowDisplayed(Constants.pageTitle_MyActivity);

        reportLog("82.1 switchParentWindowByClosingChild");
        switchParentWindowByClosingChild(parentwin);

        reportLog("82.2 My Activities window will close and Search window will remain");
        searchPage.verifySearchWindowDisplayed(Constants.pageTitle_SearchPage);

        /* SearchUI_18 */

        reportLog("83.1 Click Help icon");
        searchPage.clickOnhelpIcon();

        reportLog("83.2 Verify A drop down will appear");
        searchPage.verifyDropDownIsOpen(Constants.Help_DropDownValue);

        reportLog("84.1 Click Search Help");
        searchPage.selectDropDownValues(Constants.Help_DropDownValue, Constants.SearchHelp);

        reportLog("84.2 A new tab or window will open to How to use Search document.");
        parentwin = switchToChildWindow();
        searchPage.verifyHowToUseSearchPageIsOpened();

        reportLog("85.1 Close Help window");
        switchParentWindowByClosingChild(parentwin);

        reportLog("85.2 Search help window will close and Search window will remain");
        searchPage.verifySearchWindowDisplayed(Constants.pageTitle_SearchPage);

        reportLog("86.1 Click Help icon");
        searchPage.clickOnhelpIcon();
     


        
        reportLog("86.2 Verify A drop down will appear");
        searchPage.verifyDropDownIsOpen(Constants.Help_DropDownValue);

        reportLog("87.1 Click Search feedback");
        searchPage.selectDropDownValues(Constants.Help_DropDownValue, Constants.SearchFeedback);

        reportLog("87.2 Verify A modal will open titled VIN Feedback.");
        searchPage.verifyVinFeedbackWindowDisplayed();

        reportLog("88.1 A blank message will yield an error pop-up.");
        searchPage.clickOnSendMessageButton();
        searchPage.verifyBlankmessageAppearedOnErrorPopUp();

        reportLog("88.2 Enter This is a Test in the box");
        searchPage.enterTextInTextArea();
        searchPage.verifyTextInTheTextBox(Constants.ThisIsATest);

        reportLog("89.1 Click on Send message");
        searchPage.clickOnSendMessageButton();

        reportLog("89.2 A window will open confirming that the email was sent. Search page is greyed out");
        searchPage.verifyFeedbackSendAndSearchPageGreyed();

        reportLog("90.1 Close feedback confirmation window");
        searchPage.closeFeedBackWindow();

        reportLog("90.2 Feedback window confirmation will close, search page is no longer greyed out.");
        searchPage.verifySearchPageNotGreyedOut();

        reportLog("91.1 Click Help icon");
        searchPage.clickOnhelpIcon();

        reportLog("91.2 A drop down will appear");
        searchPage.verifyDropDownIsOpen(Constants.Help_DropDownValue);

        reportLog("92.1 Click Common Questions");
        searchPage.selectDropDownValues(Constants.Help_DropDownValue, Constants.CommonQuestions);

        reportLog("92.2 A new tab or window will open to Common Search Questions document. ");
        parentwin = switchToChildWindow();
        searchPage.verifyNewWindowDisplayed(Constants.CommonQuestionsWindow);

        reportLog("93.1 Close Commonly asked questions window");
        switchParentWindowByClosingChild(parentwin);

        reportLog("94.1 Click Help icon");
        searchPage.clickOnhelpIcon();

        reportLog("94.2 A drop down will appear");
        searchPage.verifyDropDownIsOpen(Constants.Help_DropDownValue);

        reportLog("95.1 Set Your Default Preferences");
        searchPage.selectDropDownValues(Constants.Help_DropDownValue, Constants.SetYourDeFault);

        reportLog("95.2 A pop up window will open to My Stuff, on the Preferences tab");
        parentwin = switchToChildWindow();
        searchPage.verifyWindowOpenInPreferencesTab();

        reportLog("96.1 Close My VIN window");
        switchParentWindowByClosingChild(parentwin);

        reportLog("96.2 My VIN window will close, search page remains open.");
        searchPage.verifySearchWindowDisplayed(Constants.pageTitle_SearchPage);

        /* Search UI 19 */

        reportLog("SearchUI_19:Preferences - Rows");

        reportLog("97.1:Verify the Search page is opened");
        searchPage.verifSearchBoxIsEnabled();

        reportLog("97.2:Click the Clear button");
        searchPage.clickOnClearButton();

        reportLog("98.1:Enter a search Term " + Constants.Diabetes_Text + "");
        searchPage.searchTermInTheSearchBox(Constants.Diabetes_Text);

        reportLog("98.2:Enter a Carriage return");
        searchPage.enterCarriageReturnForSearchBoxOnTop();

        reportLog("99.2:Results will appear on the page");
        searchPage.verifyPageForDiabetesIsOpen();

        reportLog("100.1:Click on Preferences Drop Down");
        searchPage.clickOnPreferencesDropDown();

        reportLog("100.2:A drop down will open");
        searchPage.verifyDropDownIsOpen(Constants.Prefrences_DropDownValue);

        reportLog("101.1:Click on 10 Rows");
        searchPage.selectDropDownValues(Constants.Prefrences_DropDownValue, Constants.Rows10Text);

        reportLog("101.2:Only 10 results will be displayed on page 1");
        searchPage.verifyResultValuesShowing(Constants.Number10);

        reportLog("102.1:Click Next to open page 2");
        searchPage.clickOnUpperNextButton();

        reportLog("102.2:Page 2 will open, displaying results 11-20");
        searchPage.verifyResultValuesShowing(Constants.Number11TO20);

        reportLog("103.1:Click Prev to open page 1");
        searchPage.clickOnUpperPrevButton();

        reportLog("103.2:Page 1 results will be listed, items 1-10");
        searchPage.verifyResultValuesShowing(Constants.Number1TO10);

        reportLog("104.1:Click on Preferences Drop Down");
        searchPage.clickOnPreferencesDropDown();

        reportLog("104.2:A drop down will open");
        searchPage.verifyDropDownIsOpen(Constants.Prefrences_DropDownValue);

        reportLog("105.1:Click on 15 Rows");
        searchPage.selectDropDownValues(Constants.Prefrences_DropDownValue, Constants.Rows15Text);

        reportLog("105.2:Only 15 results will be displayed on page 1");
        searchPage.verifyResultValuesShowing(Constants.Number15);

        reportLog("106.1:Click on Preferences Drop Down");
        searchPage.clickOnPreferencesDropDown();

        reportLog("106.2:A drop down will open");
        searchPage.verifyDropDownIsOpen(Constants.Prefrences_DropDownValue);

        reportLog("107.1:Click on 25 Rows");
        searchPage.selectDropDownValues(Constants.Prefrences_DropDownValue, Constants.Rows25Text);

        reportLog("107.2:Only 25 results will be displayed on page 1");
        searchPage.verifyResultValuesShowing(Constants.Number25);

        reportLog("108.1:Click on Preferences Drop Down");
        searchPage.clickOnPreferencesDropDown();

        reportLog("108.2:A drop down will open");
        searchPage.verifyDropDownIsOpen(Constants.Prefrences_DropDownValue);

        reportLog("109.1:Click on 50 Rows");
        searchPage.selectDropDownValues(Constants.Prefrences_DropDownValue, Constants.Rows50Text);

        reportLog("109.2:Only 50 results will be displayed on page 1");
        searchPage.verifyResultValuesShowing(Constants.Number50);

        // *Search UI 20 */

        reportLog("SearchUI_20:Preferences - snippets");

        reportLog("110.1:Click on Preferences Drop Down");
        searchPage.clickOnPreferencesDropDown();

        reportLog("110.2:A drop down will open");
        searchPage.verifyDropDownIsOpen(Constants.Prefrences_DropDownValue);

        reportLog("111.1:Click on Show Snippets");
        searchPage.selectDropDownValues(Constants.Prefrences_DropDownValue, Constants.ShowSnippetsText);

        reportLog("111.1:Results will dsiplay with the terms diabetes and diet in bold for all of the results");
        searchPage.verifyDiabetesResultAccordingToShowSnippets();

        reportLog("112.1:Click on Preferences Drop Down");
        searchPage.clickOnPreferencesDropDown();

        reportLog("112.2:A drop down will open");
        searchPage.verifyDropDownIsOpen(Constants.Prefrences_DropDownValue);

        reportLog("113.1:Click on Show Only Keyword Snippets");
        searchPage.selectDropDownValues(Constants.Prefrences_DropDownValue, Constants.ShowOnlySnippetsText);

        reportLog("113.2:diabetes and diest will be bolded only in the keywords line.");
        searchPage.verifyDiabetesResultAccordingToShowOnlySnippets();

        reportLog("114.1:Click on Preferences Drop Down");
        searchPage.clickOnPreferencesDropDown();

        reportLog("114.2:A drop down will open");
        searchPage.verifyDropDownIsOpen(Constants.Prefrences_DropDownValue);

        reportLog("115.1:Click on No Snippets");
        searchPage.selectDropDownValues(Constants.Prefrences_DropDownValue, Constants.NoSnippetsText);

        reportLog("115.2:Results showing only the tile and type of document will be displayed");
        searchPage.verifyDiabetesResultAccordingToNoSnippets();

        // *Search UI 21 *//

        reportLog("SearchUI_21:Preferences - reset preferencesw");

        reportLog("116.1:Click on Preferences Drop Down");
        searchPage.clickOnPreferencesDropDown();

        reportLog("116.2:A drop down will open");
        searchPage.verifyDropDownIsOpen(Constants.Prefrences_DropDownValue);

        reportLog("117.1:Click on Show Search Results in New Window");
        searchPage.selectDropDownValues(Constants.Prefrences_DropDownValue, Constants.ShowSearchResultInNewWindow);

        reportLog("117.2:The preference drop down will close");
        searchPage.verifyDropDownClosed(Constants.Prefrences_DropDownValue);

        reportLog("118.1:Click on Search result one");
        searchPage.clickOnFirstSearchResult();

        reportLog("118.2:The document will open in another window or tab");
        String ParrentWin = switchToChildWindow();

        reportLog("119.1:Click on the X to close the document window");
        closeChildWindow();

        reportLog("119.2:The document window will close and the search page with results will be displayed");
        switchToWindow(ParrentWin);

        reportLog("120.1:Click on Preferences Drop Down");
        searchPage.clickOnPreferencesDropDown();

        reportLog("120.2:A drop down will open");
        searchPage.verifyDropDownIsOpen(Constants.Prefrences_DropDownValue);

        reportLog("121.1:Click on Show Search Results in Same Window");
        searchPage.selectDropDownValues(Constants.Prefrences_DropDownValue, Constants.ShowSearchResultInSameWindow);

        reportLog("121.2:The preference drop down will close");
        searchPage.verifyDropDownClosed(Constants.Prefrences_DropDownValue);

        reportLog("122.1:Click on Search result one");
        searchPage.clickOnFirstSearchResult();

        reportLog("122.2:The document will the same window or tab");
        searchPage.verifyCurrentWindow(ParrentWin);

        reportLog("123.1:Click on the browser back button to return to Search page");
        searchPage.navigateBack();

        reportLog("123.2:The document window will close and the search page with results will be displayed");
        searchPage.verifySearchResultPageIsShowing();

        // *Search UI 22 *//*

        reportLog("SearchUI_22:Preferences - Set your Default Preferences");

        reportLog("124.1:Click on Preferences Drop Down");
        searchPage.clickOnPreferencesDropDown();

        reportLog("124.2:A drop down will open");
        searchPage.verifyDropDownIsOpen(Constants.Prefrences_DropDownValue);

        reportLog("125.1:Click on Set Your Default Preferences");
        searchPage.selectDropDownValues(Constants.Prefrences_DropDownValue, Constants.DefaultPreferencesWindow);

        reportLog("125.2:A pop up window will open to Search Preferences, on the Preferences tab");
        String secondParentWindow = switchToChildWindow();
        searchPage.verifyPopUpWindowOpenToSearchPreferences();
        String valuePerPage = searchPage.getDefaultPrefrencesValuesForResultShownPerPage();
        String snippetsValue = searchPage.getDefaultPrefrencesValuesForSnippets();

        reportLog("126.1:Close My VIN window by clicking the X");
        closeChildWindow();
        switchToWindow(secondParentWindow);

        reportLog("126.1:My VIN window will close, search page remains open");
        searchPage.verifySearchResultPageIsShowing();

        // *Search UI 23 *//*

        reportLog("SearchUI_23:Preferences - reset preferences");

        reportLog("127.1:Click the Clear button");
        searchPage.clickOnClearButton();

        reportLog("127.2:the original search page is displayed; search term box is empty");
        searchPage.verifySearchFillterInputValueIsEmpty();

        reportLog("128.1:Enter diabetes mellitus treatment into the Search box");
        searchPage.searchTermInTheSearchBox(Constants.Diabetes_mellitusTreatMent);
        searchPage.pressEnter();

        reportLog("128.2:diabetes mellitus treatment is displayed in the Search Term box");
        searchPage.verifyTextInSearchBox(Constants.Diabetes_mellitusTreatMent);

        reportLog("129.1:Enter a carriage return (Enter)");
        searchPage.enterCarriageReturnForSearchBoxOnTop();

        reportLog("129.2:Results will appear on the page; View Checked should be at zero due to our Clear button");
        searchPage.verifyViewCheckedZeroPresent();

        reportLog("130.1:Click on Preferences Drop Down");
        searchPage.clickOnPreferencesDropDown();

        reportLog(
                "130.2:A drop down will open and the default preferences changed with all of the last search will be set back to the original settings");
        searchPage.verifyOptionOnPreferencesIsActive(valuePerPage);
        searchPage.verifyOptionOnPreferencesIsActive(snippetsValue);

        /* Search UI 24 */

        reportLog("SearchUI_24:Preferences - Search Tips");

        reportLog("131.1:Click the Clear button");
        searchPage.clickOnClearButton();

        reportLog("131.2:the original search page is displayed; search term box is empty");
        searchPage.verifySearchFillterInputValueIsEmpty();

        reportLog("132.1:Click the Authors Tab");
        searchPage.selectSearchTipsTabs(Constants.AuthorsSearchTipTab);

        reportLog("132.2:Author search tip is displayed");
        searchPage.serachTipsSelectedTabsSectionIsDisplayed(Constants.AuthorsSearchTipTabContent);

        reportLog("133.1:Click the PubMed Tip tab");
        searchPage.selectSearchTipsTabs(Constants.PubMedSearchTipTab);

        reportLog("133.2:PubMed Tip is displayed");
        searchPage.serachTipsSelectedTabsSectionIsDisplayed(Constants.PubMedSearchTipTabContent);

        reportLog("134.1:Click the Prefernces Tip Tab");
        searchPage.selectSearchTipsTabs(Constants.PreferencesSearchTipTab);

        reportLog("134.2:Preferences Tip opens");
        searchPage.serachTipsSelectedTabsSectionIsDisplayed(Constants.PreferencesSearchTipTabContent);

        reportLog("135.1:Click on My VIN Search Preferences");
        searchPage.clickOnLinkOnTipTabContent(Constants.MyVinSearchPreferencesLink);

        reportLog("135.2:A pop up window will open to Search Preferences");
        String windowPrefernces = switchToChildWindow();
        searchPage.verifyPopUpWindowOpenToSearchPreferences();

        reportLog("136.1:Close My VIN window by clicking the X");
        closeChildWindow();
        switchToWindow(windowPrefernces);

        reportLog("136.2:My VIN window will close, search page remains open.");
        searchPage.verifySearchResultPageIsShowing();

        reportLog("137.1:Click on More Tip Tab");
        searchPage.selectSearchTipsTabs(Constants.MoreSearchTipTab);

        reportLog("137.2:More tip is displayed");
        searchPage.serachTipsSelectedTabsSectionIsDisplayed(Constants.MoreSearchTipTabContent);

        reportLog("138.1:Click on Search 4 Help");
        searchPage.clickOnLinkOnTipTabContent(Constants.Search4helpLink);
        String windowSearchPrefernces = switchToChildWindow();

        reportLog(
                "138.2:A new tab or window will open to How to use Search document. https://beta.vin.com/members/cms/project/defaultadv1.aspx?id=6722340&pid=489&");
        //searchPage.verifyHowToUseSearchPageIsOpened();

        reportLog("139.1:Close help with Red x");
        closeChildWindow();

        reportLog("139.2:Help window will close and Search window will remain");
        switchToWindow(windowSearchPrefernces);

        reportLog("140.1:Click on Poor Results Tip Tab");
        searchPage.selectSearchTipsTabs(Constants.PoorResultsSearchTipTab);

        reportLog("140.2:Poor Results Tips will be displayed");
        searchPage.serachTipsSelectedTabsSectionIsDisplayed(Constants.PoorResultsSearchTipTabContent);

        reportLog("141.1:Click Search Feedback");
        searchPage.clickOnLinkOnTipTabContent(Constants.SearchFeedBack);

        reportLog("141.2:A modal will open titled VIN Feedback.");
        searchPage.verifyVinFeedbackWindowDisplayed();

        reportLog("142.3:A blank message will yield an error pop-up.");
        searchPage.clickOnSendMessageButton();
        searchPage.verifyBlankmessageAppearedOnErrorPopUp();

        reportLog("142.4:Enter This is a Test in the box");
        searchPage.enterTextInTextArea();

        reportLog("143.1:Click on Send message");
        searchPage.clickOnSendMessageButton();

        reportLog("143.2:A window will open confirming that the email was sent. Search page is greyed out");
        searchPage.verifyFeedbackSendAndSearchPageGreyed();

        reportLog("144.1:Click on greyed out search page");
        searchPage.clickOnSearchPageGreyed();
//		searchPage.closeFeedBackWindow();


        reportLog("144.2: Logout application");
        logoutPage = frontPage.logoutApplication();

        reportLog("144.3: Verify Logout Page displayed");
        logoutPage.verifyLogoutPageDisplayed();
    }
}