package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

public class VetzInsightHappyPath extends BaseTest {

	public VetzInsightHappyPath() {

		super();
	}
	
	@BeforeMethod
    public void getTestData() throws Exception {

        System.setProperty("className", getClass().getSimpleName());

    }

    /**
     * ====================================================================================================================
     * Test Case Name: VetzInsightHappyPath
     * ====================================================================================================================
     * @throws Exception
     *
     */
	
	
	@Test
	public void verifyVetzInsightHappyPath() throws Exception
	{
		reportLog("1.0: Bringing VIN Page");
		promoPage.verifyPromoPage();
		
		reportLog("1.1: Navigate to Vetzinsight (https://www.vin.com/vetzinsight/)");
		promoPage.navigateToUrl(Constants.vetzInsightURL);
		String mainWindowHandle = promoPage.getDriver().getWindowHandle();
		
		reportLog("2.1: Click 'Read Article' from the rotating banner on the top");
		promoPage.clickOnReadArticle();
		
		reportLog("2.2: Enter 'anxiety' in 'Search VETzInsight' search box and select 'Go'");
		
		promoPage.enterAnxietyInSearchBox(Constants.anxietyText);
		
		reportLog("3.1: Select the VETzInsight button");
		promoPage.selecttheGoButton();
		
		reportLog("3.2: Select 'Tweet' button");
		promoPage.selectTweetButton();
		promoPage.switchToNewWindow();
		
		
		reportLog("3.3: Select X to close the twitter window");
		promoPage.getDriver().close();
		promoPage.getDriver().switchTo().window(mainWindowHandle);
		
		reportLog("4.1: Select 'Facebook' button");
		promoPage.selectFaceBookButton();
		promoPage.switchToNewWindow();
		
		reportLog("4.2: Select X to close the Facebook window");
		promoPage.getDriver().close();
		promoPage.getDriver().switchTo().window(mainWindowHandle);
		
		
		
	}
}
