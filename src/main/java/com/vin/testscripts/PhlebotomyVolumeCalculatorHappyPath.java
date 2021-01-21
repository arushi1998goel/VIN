package com.vin.testscripts;

import com.vin.pages.LoginPage;
import com.vin.pages.PhlebotomyVolumeCalculatorPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PhlebotomyVolumeCalculatorHappyPath extends BaseTest {

    private String SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName;

    public PhlebotomyVolumeCalculatorHappyPath() {
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
     * Test Case Name: PhlebotomyVolumeCalculatorHappyPath
     * ====================================================================================================================
     *
     * @throws Exception
     */

    @Test(priority=1)

    public void verifyphlebotomyVolumeCalculatorHappyPath() throws Exception {
    	
    	reportLog("1.0: Bringing VIN Page");
		promoPage.verifyPromoPage();
		
		reportLog("1.1: Navigate to https://beta.vin.com/Members/cms/project/defaultadv1.aspx?pid=618&id=7132682");
		loginPage=promoPage.navigateToPhelotomyVolumeCalculatorPage();


        reportLog("1.2: Log in to the Portal ");
        securityQuestionPage = loginPage.loginForPhlebotomyCalculator(UserID, UserPswrd);

        reportLog("1.3: Verify Security Question Page displayed");
        securityQuestionPage.verifySecurityQuestionPageDisplayed();

       reportLog("1.4: Enter Security Answer and Login if Security Question Page displayed");
        phlebotomyGraduateTrainingPage = securityQuestionPage.enterSecurityAnswerAndLogin(
                PhlebotomyVolumeCalculatorPage.class, SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName);

        reportLog("1.5: Navigate to Phlebotomy Calculator");
        reportLog("1.6: User should be directed to Phlebotomy Calculator");
        phlebotomyGraduateTrainingPage.verifyPhlebotomyCalculatorPage();
        
        reportLog("1.7 Dismiss Notifications if displayed");
        phlebotomyGraduateTrainingPage.dismissNotifications();

        reportLog("1.8  Verify Pop up message");
        phlebotomyGraduateTrainingPage.verifyPopUpTitle();

       reportLog("1.9 select ok");
        phlebotomyGraduateTrainingPage.selectOK();
        
        reportLog("2.1: Verify Species is set to dog by default");
        phlebotomyGraduateTrainingPage.verifySpeciesSetToDogByDefault();
        
        reportLog("2.2: Select dog for species");
        phlebotomyGraduateTrainingPage.selectDogRadioButtonOrVerifyDogRadioButtonIsSelected();
        
        reportLog("2.3: Verify User is able to select the dog radio button");
        phlebotomyGraduateTrainingPage.selectDogRadioButtonOrVerifyDogRadioButtonIsSelected();
        
        reportLog("2.4  Verify Dog gif will display on right side of calculator");
        phlebotomyGraduateTrainingPage.verifySpeciesImageDisplayed("dog");

        reportLog("3.1 Enter 25kg weight for dog");
        phlebotomyGraduateTrainingPage.enterWeightInTheKgWeightBox(Constants.weight25Kg);

        reportLog("3.2 Verify  User is able to enter numeric text. Lbs are calculated automatically");
        phlebotomyGraduateTrainingPage.verifyAmountInKGBoxAndLbsValuesAreChangedAutomatically(Constants.weight25Kg);

        reportLog("4.1 Actual hematocrit text field Enter 70");
        phlebotomyGraduateTrainingPage.enterActualHemacrotic("70");
        
        reportLog("4.2: Verify User is able to enter numeric text");
        phlebotomyGraduateTrainingPage.verifyHemacroticText("70");
        
        reportLog("5.1 Desired hematocrit text field :: Enter 62"); 
        phlebotomyGraduateTrainingPage.EnterDesiredHemotocritAmount(Constants.donorHemocraticAmount);
        

        reportLog("5.2  Verify User is able to enter numeric text");
        phlebotomyGraduateTrainingPage.verifyUserIsAbleToEnterNumericAmountInDesiredHematocritTextBoxes(
        Constants.desiredHemocratic, Constants.donorHemocraticAmount);

        reportLog("6.1 Select Calculate");
        phlebotomyGraduateTrainingPage.clickOnCalculateAndResetButton(Constants.calculateButton);

        reportLog("6.2 Are you sure you want to remove blood pop-up modal will display. Select ok. ");
        phlebotomyGraduateTrainingPage.verifyAlertPopup();

        reportLog("7.1 Verify Results are calculated  :: Results: 2249/8/11.4,257  ");
        phlebotomyGraduateTrainingPage.verifyResultsAreCalculatedForBloodVolume("2249", "8", "11.4", "257");

        reportLog("8.1 Select Reset");
        phlebotomyGraduateTrainingPage.clickOnCalculateAndResetButton(Constants.resetButton);

       reportLog("8.2 Pop up modal will display asking the user if they want to clear results. Select ok");
        phlebotomyGraduateTrainingPage.verifyAlertText();

        reportLog("9.1 Select 'Logout' ");
        logoutPage = phlebotomyGraduateTrainingPage.logoutApplication();

        reportLog("9.2 VIN Logout page is displayed. ");
        logoutPage.verifyLogoutPageDisplayed();

    }
   
        @Test(priority=2)
   public void phlebotomyVolumeCalculatorRegressionTC2() throws Exception {
        	reportLog("1.0: Bringing VIN Page");
    		promoPage.verifyPromoPage();
    		
    		reportLog("1.1: Navigate to https://beta.vin.com/Members/cms/project/defaultadv1.aspx?pid=618&id=7132682");
    		loginPage=promoPage.navigateToPhelotomyVolumeCalculatorPage();

            reportLog("1.2: Log in to the Portal ");
            securityQuestionPage = loginPage.loginForPhlebotomyCalculator(UserID, UserPswrd);

            reportLog("1.3: Verify Security Question Page displayed");
            securityQuestionPage.verifySecurityQuestionPageDisplayed();

            reportLog("1.4: Enter Security Answer and Login if Security Question Page displayed");
            phlebotomyGraduateTrainingPage = securityQuestionPage.enterSecurityAnswerAndLogin(
                    PhlebotomyVolumeCalculatorPage.class, SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName);

            reportLog("1.5: Navigate to Phlebotomy Calculator");
            reportLog("1.6: User should be directed to Phlebotomy Calculator");
            phlebotomyGraduateTrainingPage.verifyPhlebotomyCalculatorPage();
            
            reportLog("1.7 Dismiss Notifications if displayed");
            phlebotomyGraduateTrainingPage.dismissNotifications();

            reportLog("1.8  Verify Pop up message");
            phlebotomyGraduateTrainingPage.verifyPopUpTitle();

            reportLog("1.9 select ok");
            phlebotomyGraduateTrainingPage.selectOK();
            
            reportLog("2.1: Verify Species is set to dog by default");
            phlebotomyGraduateTrainingPage.verifySpeciesSetToDogByDefault();
          
            reportLog("2.2: Select Cat Radio button");
            phlebotomyGraduateTrainingPage.selectCatRadioButton();
            
            reportLog("2.3: User is able to select 'cat' for speicies");
            phlebotomyGraduateTrainingPage.verifyCatRadioButttonIsSelected();
            
            reportLog("2.4: Verify Cat gif will display on right side of calculator");
            phlebotomyGraduateTrainingPage.verifyCatGIFImage();
            
            reportLog("3.1: Enter 5lbs");
            phlebotomyGraduateTrainingPage.enterWeightInLbsForCat(Constants.weight5lb);
            
            reportLog("3.2.1: Verify User is able to enter numeric text.");
            phlebotomyGraduateTrainingPage.verifyWeighInLbForCat(Constants.weight5lb);
            
            
            reportLog("3.2.2: kgs are calculated automatically");
            phlebotomyGraduateTrainingPage.verifyKGsAreCalculatedAutomatically(Constants.weightInKGAutomatic);
            
            reportLog("4.1: Actual hematocrit text field Enter 73");
            phlebotomyGraduateTrainingPage.enterActualHemacrotic("73");
            
            reportLog("4.2: Verify User is able to enter numeric text");
            phlebotomyGraduateTrainingPage.verifyHemacroticText("73");
            
            reportLog("5.1: Desired hematocrit text field :: Enter 67");
            phlebotomyGraduateTrainingPage.EnterDesiredHemotocritAmount(Constants.desiredHemocratic67);
            
            reportLog("5.2: Verify User is able to enter numeric text");
            phlebotomyGraduateTrainingPage.verifyDesiredWeightForCat(Constants.desiredHemocratic67);
            
           reportLog("6.1: Select Calculate");
           phlebotomyGraduateTrainingPage.clickOnCalculateAndResetButton(Constants.calculateButton);
            
          reportLog("6.2: Verify Results are calculated :: Results: 159/6/8.2,13");
          phlebotomyGraduateTrainingPage.verifyResultsAreCalculatedForBloodVolume("159", "6", "8.2", "13");
          
         reportLog("7.1: Select Reset");
         phlebotomyGraduateTrainingPage.clickOnCalculateAndResetButton(Constants.resetButton);
         
         reportLog("7.2: Pop up modal will display asking the user if they want to clear results. Select ok");
         phlebotomyGraduateTrainingPage.verifyAlertText();

         reportLog("8.1: Select 'Logout' ");
         logoutPage = phlebotomyGraduateTrainingPage.logoutApplication();

         reportLog("8.2: VIN Logout page is displayed. ");
        logoutPage.verifyLogoutPageDisplayed();       

    }
        
        
        @Test(priority=3)
        public void phlebotomyVolumeRegressionTC3() throws Exception {
        	
        	reportLog("1.0: Bringing VIN Page");
    		promoPage.verifyPromoPage();
    		
    		reportLog("1.1: Navigate to https://beta.vin.com/Members/cms/project/defaultadv1.aspx?pid=618&id=7132682");
    		loginPage=promoPage.navigateToPhelotomyVolumeCalculatorPage();

            reportLog("1.2: Log in to the Portal ");
            securityQuestionPage = loginPage.loginForPhlebotomyCalculator(UserID, UserPswrd);

            reportLog("1.3: Verify Security Question Page displayed");
            securityQuestionPage.verifySecurityQuestionPageDisplayed();

            reportLog("1.4: Enter Security Answer and Login if Security Question Page displayed");
            phlebotomyGraduateTrainingPage = securityQuestionPage.enterSecurityAnswerAndLogin(
                    PhlebotomyVolumeCalculatorPage.class, SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName);

            reportLog("1.5: Navigate to Phlebotomy Calculator");
            reportLog("1.6: User should be directed to Phlebotomy Calculator");
            phlebotomyGraduateTrainingPage.verifyPhlebotomyCalculatorPage();
            
            reportLog("1.7 Dismiss Notifications if displayed");
            phlebotomyGraduateTrainingPage.dismissNotifications();

            reportLog("1.8  Verify Pop up message");
            phlebotomyGraduateTrainingPage.verifyPopUpTitle();

            reportLog("1.9 select ok");
            phlebotomyGraduateTrainingPage.selectOK();
            
            reportLog("2.1: Verify Species is set to dog by default");
            phlebotomyGraduateTrainingPage.verifySpeciesSetToDogByDefault();
            
            reportLog("2.2: Select dog for species");
            phlebotomyGraduateTrainingPage.selectDogRadioButtonOrVerifyDogRadioButtonIsSelected();
            
            reportLog("2.3: Verify User is able to select the dog radio button");
            phlebotomyGraduateTrainingPage.selectDogRadioButtonOrVerifyDogRadioButtonIsSelected();
            
            reportLog("2.4  Verify Dog gif will display on right side of calculator");
            phlebotomyGraduateTrainingPage.verifySpeciesImageDisplayed("dog");
            
            reportLog("3.1: Enter 8.32 lbs ");
            phlebotomyGraduateTrainingPage.enterWeightInLBSforDog(Constants.weightLBSDog);
            
            reportLog("3.2.1: Verify User is able to enter numeric text.");
            phlebotomyGraduateTrainingPage.verifyWeightInLBSForDog(Constants.weightLBSDog);
            
            reportLog("3.2.2: kgs are calculated automatically");
            phlebotomyGraduateTrainingPage.verifyKGsCalculateAutomaticallyForDog(Constants.kgAutomaticForDog);
            
            reportLog("4.1: Actual hematocrit text field Enter 65");
            phlebotomyGraduateTrainingPage.enterActualHemacrotic("65");
            
            reportLog("4.2: Verify User is able to enter numeric text");
            phlebotomyGraduateTrainingPage.verifyHemacroticText("65");
            
            reportLog("5.1: Desired hematocrit text field :: Enter 60");
            phlebotomyGraduateTrainingPage.EnterDesiredHemotocritAmount("60");

            reportLog("5.2: Verify User is able to enter numeric text");
            phlebotomyGraduateTrainingPage.verifyDesiredHemocraticForDog("60");
            
            reportLog("6.1: Select Calculate");
            phlebotomyGraduateTrainingPage.clickOnCalculateAndResetButton(Constants.calculateButton);

            reportLog("6.2: Are you sure you want to remove blood pop-up modal will display. Select ok.");
            phlebotomyGraduateTrainingPage.verifyAlertPopup();
            
            reportLog("7.1: Verify Results are calculated :: Results: 339/5/7.7,26");
            phlebotomyGraduateTrainingPage.verifyResultsAreCalculatedForBloodVolume("339", "5", "7.7", "26");


            reportLog("8.1: Select Reset");
            phlebotomyGraduateTrainingPage.clickOnCalculateAndResetButton(Constants.resetButton);
            
            reportLog("8.2: Pop up modal will display asking the user if they want to clear results. Select ok");
            phlebotomyGraduateTrainingPage.verifyAlertText();
            
            reportLog("9.1: Select 'Logout'");
            logoutPage = phlebotomyGraduateTrainingPage.logoutApplication();

            
            reportLog("9.2: VIN Logout page is displayed.");
            logoutPage.verifyLogoutPageDisplayed();       



            

        }

}