
package com.vin.testscripts;


import com.vin.selenium.core.BaseTest;
import com.vin.utilities.Constants;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class StudentLoanSimHappyPath extends BaseTest {

    private String SecurityAnswerSecoreIDNumber, SecurityAnswerMothersMaidenName;

    public StudentLoanSimHappyPath() {
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
     * Test Case Name: StudentLoanSimHappyPath
     * ====================================================================================================================
     *
     * @throws Exception
     */

    @Test
    public void studentLoanSimulatorHappyPath() throws Exception {
    	
    	reportLog("1.0: Bringing VIN  page");
		promoPage.verifyPromoPage();
		
		reportLog("1.1: Navigate to Student loan Sim beta.vin.com/studentdebtcenter/default.aspx?pid=14352&id=7578014");
		studentloansimpage=promoPage.navigateToStudentLoanSimulator();


	    reportLog("2.1: Verify user is able to naviagate to Student Loan Simulator when selecting URL");
	    studentloansimpage.verifyStudentLoanSimPage(Constants.studentDebtCenterTitle);
	    
        reportLog("2.4 Click on  Run Sim button");
        studentloansimpage.clickOnRunSimButton();
        
        reportLog("2.5 Verify User is selecting to run simulator with default input values. ");
        studentloansimpage.verifyRunSimButtonISEnabled();
	    
        reportLog("3.1  Verify Loan Payment Summary table will populate with default calculations.");
        studentloansimpage.verifyLoanRepayementAreaIsPopulated();
        
        reportLog("3.2 Verify  Forgiveness Planning Module will populate with default calculations. ");
        studentloansimpage.verifyForgivenessPlanningModuleAreaIsPopulated();

        reportLog("3.3  Verify Total Loan Balance During Repayment table will populate.  ");
        studentloansimpage.verifyTotalLoanBalanceIsPopulated();
        
        reportLog("3.3 Verify  Monthly Repayment Summary will display for the 6 loan types. ");
        studentloansimpage.verifyMonthlyRepayementIsPopulated();
        
       reportLog("3.2 Verify Loan Repayment Range of Minimum Monthly Payments (by period) table will populate.");
       studentloansimpage.verifyLoanRepayementRangeIsPopulated();
       
       reportLog("3.2 Verify Monthly Report Summary will display for the 6 loans types. ");
       studentloansimpage.verifyMonthlyReportIsPopulated();
       
       reportLog("4.1 Click on  Reset Button");
       studentloansimpage.selectResetButton();
       
       reportLog("4.2  Verify  Values are cleared.");
       studentloansimpage.verifyValuesAreClearedAfterResetButton();
           
    }


    /**
     * ====================================================================================================================
     * Test Case Name: StudentLoanSim
     * ====================================================================================================================
     *
     * @throws Exception
     */

    @Test
    public void StudentLoanSimulator2yearRepayment() throws Exception {
    	
    	reportLog("1.0: Bringing VIN  page");
		promoPage.verifyPromoPage();
		
		reportLog("1.1: Navigate to Student loan Sim beta.vin.com/studentdebtcenter/default.aspx?pid=14352&id=7578014");
		studentloansimpage=promoPage.navigateToStudentLoanSimulator();


	    reportLog("1.2: Verify user is able to naviagate to Student Loan Simulator when selecting URL");
	    studentloansimpage.verifyStudentLoanSimPage(Constants.studentDebtCenterTitle);
	    
	    reportLog("2.1: Select 2018 from Graduation Year drop down");
	    studentloansimpage.select2018FromGraduationYear();
	    
	    reportLog("2.2:  Verify User is able to select 2018 from drop down.");
        studentloansimpage.selectGraduateYearDropDownAndSelectYearDropDown();
        
        reportLog("2.3  Verify Present Scenario Drop Down is removed.");
        studentloansimpage.verifypresentScenariosIsRemoved();
        
        reportLog("2.4  Verify Repayment Plan Drop Down is activated.");
        studentloansimpage.verifyRepaymentPlanDropDownIsActivated();
        
        reportLog("2.5  Verify Years in Repayment Drop Down is Activated ");
        studentloansimpage.verifyYearsInRepayementDropdownIsActivated();
        
        reportLog("3.1 Select Standard 10 from Repayment Plan Drop Down ");
        studentloansimpage.selectStandard10FromrepayementDropDown();

        reportLog("3.2 Verify User is able to select Standard 10");
        studentloansimpage.verifyRepaymentYearIsSelected();

        reportLog("4.1:  Select 2 from Years in Repayment Drop Down ");
        studentloansimpage.selectYearsFromrepayementDropDown();
        
        reportLog("4.2:  Verify User is able to select 2 ");
        studentloansimpage.verifyValuesIsSelected();
        
        reportLog("5.1:	Click on  Run Sim button");
        studentloansimpage.clickOnRunSimButton();
        
        reportLog("5.2: Verify User is able to select Rum Sim button.");
        studentloansimpage.verifyRunSimButtonISEnabled();
        
        reportLog("6.1:  Verify Loan Payment Summary table will populate with calculations");
        studentloansimpage.verifyLoanRepayementAreaIsPopulated();
        
        reportLog("6.2: Verify Forgiveness Planning Module will populate with calculations.");
        studentloansimpage.verifyForgivenessPlanningModuleAreaIsPopulated();
        
        reportLog("7.1: Verify Total Loan Balance During Repayment table will populate.  ");
        studentloansimpage.verifyTotalLoanBalanceIsPopulated();
        
        reportLog("8.1: Verify  Monthly Repayment Summary will display for the 6 loan types. ");
        studentloansimpage.verifyMonthlyRepayementIsPopulated();
        
        reportLog("9.1: Verify Loan Repayment Range of Minimum Monthly Payments (by period) table will populate.");
        studentloansimpage.verifyLoanRepayementRangeIsPopulated();
        
        reportLog("10.1: Verify Monthly Report Summary will display for the 6 loans types. ");
        studentloansimpage.verifyMonthlyReportIsPopulated();
        
        reportLog("11.1: Click on  Reset Button");
        studentloansimpage.selectResetButton();
        
        reportLog("12.1:  Verify  Values are cleared.");
        studentloansimpage.verifyValuesAreClearedAfterResetButton();
      
    }
}

