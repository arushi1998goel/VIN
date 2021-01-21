package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class VeterinaryHappyPath extends BaseTest {
	
	public VeterinaryHappyPath() {

		super();
	}
	
	@BeforeMethod
    public void getTestData() throws Exception {

        System.setProperty("className", getClass().getSimpleName());

    }

    /**
     * ====================================================================================================================
     * Test Case Name: VeterinaryHappyPath
     * ====================================================================================================================
     * @throws InterruptedException 
     * @throws Exception
     *
     */
	

	@Test
	public void verifyVeterinaryHappyPath() throws InterruptedException
	{
		reportLog("1.0: Bringing VIN Page");
		promoPage.verifyPromoPage();
		
		reportLog("1.1: Navigate to Veterinary Partner - https://veterinarypartner.vin.com/ ");
		promoPage.navigateToVeterinaryHappyPath(Constants.veterinaryUrl);
		
		reportLog("2.1: Select the 'Browse Categories' button");
		promoPage.selectBrowseCategoryButton();
		
		reportLog("2.2: Select the 'Dog' icon");
		promoPage.selectTheDogIcon();
		
		reportLog("2.3: Select an article link from right pane");
		promoPage.selectAnArticleRightPane();
		
		reportLog("3.1: Type 'Pit Bull' in the search bar");
		promoPage.typePitBullInSearchBar(Constants.pitbullText);
		
		reportLog("3.2  Select the dropdown for 'All' and select 'Dogs'");
		promoPage.selectTheAllDropdownAndSelectDogs();
		
		reportLog("3.3: Click on the 'Go' button on the search bar");
		promoPage.selecttheGoButtonAfterSearchBox();
		
		reportLog("3.4: Select the second article link from the results page");
		promoPage.selectTheSecondArticleLinkFromrResultPage();
		
		reportLog("4.1: Select on the Veterinary Partner logo");
		promoPage.selectTheVeterinaryPartnerLogo();
		
		reportLog("5.1: Click on 'Cats' under the 'Articles by Species' section");
		promoPage.clickOnCatsUnderArticleBySpeciesSection();
		
		reportLog("5.2: Click on an icon to open an article in a new tab/window");
		promoPage.clickOnAnIconToOpenAnArticle();
		promoPage.switchToNewWindow();
		
		reportLog("6.1: Select the email icon");
		promoPage.selectEmailIcon();
		promoPage.switchToNewWindow();
		
		reportLog("6.2: Verify the email popup is displayed");
		promoPage.verifyEmailPopup();
		
		reportLog("6.3: Select Cancel");
		promoPage.getDriver().close();
	}
}
