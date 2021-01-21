package com.vin.testscripts;

import com.vin.pages.LoginPage;
import com.vin.pages.PostGraduateTrainingPage;
import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PostGraduateTrainingHappyPath extends BaseTest {
    private String SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName;

    public PostGraduateTrainingHappyPath() {
        super();
    }

    @BeforeMethod
    public void getTestData() throws Exception {

        System.setProperty("className", getClass().getSimpleName());

        SecurityAnswerSecoreIDNumber = RegressionTestData.getProperty("SecurityAnswerSecoreIDNumber");
        SecurityAnswerMothersMaidenName = RegressionTestData.getProperty("SecurityAnswerMothersMaidenName");

    }

    @Test
    public void postGraduateTrainingHappyPath() throws Exception {

        reportLog("1.1: Launch VIN Application by going to https://www.vin.com/vin/ url");
        loginPage = promoPage.verifyPromoPageForLogin(LoginPage.class);
        
        reportLog("1.2: verify VIN promo page is loaded");
        promoPage.verifyPromoPage();

        reportLog("1.3: Call login method");
        securityQuestionPage = loginPage.loginForPostGraduateTraining(UserID, UserPswrd);

        reportLog("1.3.1: Verify Security Question Page displayed");
        securityQuestionPage.verifySecurityQuestionPageDisplayed();

        reportLog("1.3.2 Verify User will naviagate to Post Graduate Training Page when selecting URL");
        postGraduateTrainingPage = securityQuestionPage.enterSecurityAnswerAndLogin(
                PostGraduateTrainingPage.class, SecurityAnswerSecoreIDNumber,
                SecurityAnswerMothersMaidenName);
        
        reportLog("1:4: Verify User logged in");
        postGraduateTrainingPage.verifyUserLoginForPostGraduateTraining();
        
        reportLog("1:5: Dismiss alert Notifications if one pops up by clicking on dismiss button");
        postGraduateTrainingPage.dismissNotifications();
        
        reportLog("1.1: Click on MYVIN");
        postGraduateTrainingPage.clickOnMyVIN();
        
        
        /***
         * This steps is not coming
         */
        
        
        reportLog("1:2: Confirm MyVIN opens up in new pop up window");
        
        reportLog("1:3: Click on Profile in new pop up window and click on Post Graduate training from drop down list");
        postGraduateTrainingPage.clickOnProfile();
        postGraduateTrainingPage.clickOnPostGraduateTraining();
        
        reportLog("1.1: Verify post graduate training page is loaded");
        postGraduateTrainingPage.verifyPostGraduateTrainingPageIsLoaded();
        
        reportLog("1.2: Select 'Add Internship' button");
        postGraduateTrainingPage.addInternship();
        
        reportLog("1.3: Verify add internship pop up is loaded with \"Enter your details and click Add\" pop up message");
        postGraduateTrainingPage.verifyEnterYourDetailsPopup();
        
        reportLog("1:4: Select 'Brazil' from the Country drop down");
        postGraduateTrainingPage.selectCountry(Constants.PGTraining_Internship_InitialCountry);
        
        reportLog("1:5: Confirm country field has Brazil value");
        postGraduateTrainingPage.confirmBrazilValue("Brazil");
        
        reportLog("1:6: Select 'Animal Control' from the Subject drop down");
        postGraduateTrainingPage.selectSubject(Constants.PGTraining_Internship_InitialSubject);
        
        reportLog("1:7: Confirm Subject field has Animal Control value");
        postGraduateTrainingPage.confirmSubjectField("Animal Control");
        
        reportLog("1.8: Provide 'Test School' in the School/Organization/Institution text field");
        postGraduateTrainingPage.enterInsituteName(Constants.PGTraining_Internship_InitialInstitute);
        
        reportLog("1:8: Select 'Jan' from the Completion Date drop down");
        postGraduateTrainingPage.selectMonth(Constants.PGTraining_Internship_InitialMonth);
        
        reportLog("1:9: Confirm School/Organization/Institution field accepts type in value");
        postGraduateTrainingPage.confirmFieldsAcceptValue("Test School");
        
        reportLog("1.10: Select month'Jan' for month drop down and year '2002' for year drop down in Completion drop down");
        postGraduateTrainingPage.selectYear(Constants.PGTraining_Internship_InitialYear);
        
        reportLog("1.1: Click on 'Add' button");
        postGraduateTrainingPage.clickSaveButton();
        
        reportLog("1.2: Dismiss alert Notifications if one pops up by clicking on dismiss button");
        postGraduateTrainingPage.dismissNotifications();
        
        reportLog("1.3: Verify Created Record.");
        //postGraduateTrainingPage.verifyUpdateMessageDisplayed();
        postGraduateTrainingPage.verifyInternshipRecord(Constants.PGTraining_Internship_InitialInstitute, Constants.PGTraining_Internship_InitialSubject,
        Constants.PGTraining_Internship_InitialMonth, Constants.PGTraining_Internship_InitialYear);
        
        reportLog("1.4: Select 'Add Residency' button.");
        postGraduateTrainingPage.addResidency();
        
        reportLog("1.5: Select 'Argentina' from the Country drop down");
        postGraduateTrainingPage.selectCountry(Constants.PGTraining_Residency_ChangedCountry);
        
        reportLog("1.6: Select 'Avian Medicine' from the Subject drop down");
        postGraduateTrainingPage.selectSubject(Constants.PGTraining_Residency_ChangedSubject);
        
        reportLog("1.7: Provide 'Test Organization' in the School/Organization/Institution text field");
        postGraduateTrainingPage.enterInsituteName(Constants.PGTraining_Residency_ChangedInstitute);
        
        reportLog("1:8: Select 'June' from the Completion Date month drop down");
        postGraduateTrainingPage.selectMonth(Constants.PGTraining_Residency_ChangedMonth);
        
        reportLog("1:9: Select '2007' from the Completion date year drop down");
        postGraduateTrainingPage.selectYear(Constants.PGTraining_Residency_ChangedYear);
        
        reportLog("1.1: Select 'Add' button.");
        postGraduateTrainingPage.clickSaveButton();
        
        reportLog("1.2: Dismiss alert Notifications if one pops up by clicking on dismiss button");
        postGraduateTrainingPage.dismissNotifications();
        
        reportLog("1:3: Verify Record Added");
       // postGraduateTrainingPage.verifyUpdateMessageDisplayed();
        postGraduateTrainingPage.verifyResidencyRecord(Constants.PGTraining_Residency_ChangedInstitute, Constants.PGTraining_Residency_ChangedSubject,
        Constants.PGTraining_Residency_ChangedMonth, Constants.PGTraining_Residency_ChangedYear);
        
        reportLog("1:4: Click on 'Delete' button on added internship record");
        postGraduateTrainingPage.clickOnDeleteButtonOnAddedInternshipRecord();
        
        reportLog("1:5: Dismiss alert Notifications if one pops up by clicking on dismiss button");
        postGraduateTrainingPage.dismissNotifications();
        
        reportLog("1:6: Confirm record deleted");
        postGraduateTrainingPage.confirmRecordDeleted();
        
        reportLog("1:7: select 'Delete' button on added residency record");
        postGraduateTrainingPage.selectDeleteButtonForAddedResidency();
        
        reportLog("1:8: Dismiss alert Notifications if one pops up by clicking on dismiss button");
        postGraduateTrainingPage.dismissNotifications();
        
        reportLog("1.1: Verify Added Residency is deleted.");
        postGraduateTrainingPage.verifyRecordDeletedForAddedResidency();
        
        reportLog("1:2: Dismiss alert Notifications if one pops up by clicking on dismiss button");
        postGraduateTrainingPage.dismissNotifications();
        
        reportLog("1.3: Call Logout method");
        logoutPage=postGraduateTrainingPage.logout();
        
        reportLog("1:4: Verify Logging off from VIN is successful");
	     logoutPage.verifyLogoutPageDisplayed();
        

    }
}
