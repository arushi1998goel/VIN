package com.vin.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vin.pages.FacultyAndResidentsPage;
import com.vin.pages.InternsPage;
import com.vin.pages.LoginPage;
import com.vin.pages.RecentGraduatesPage;
import com.vin.pages.VinStudentsPage;
import com.vin.selenium.core.BaseTest;

public class VINPromoPageStudentAcademia extends BaseTest {
	
	
	private String ParentWin;
	
	public VINPromoPageStudentAcademia() {
		super();
	}
	
	@BeforeMethod
    public void getTestData() throws Exception {

        System.setProperty("className", getClass().getSimpleName());

      }
	
	
	/**
     * ====================================================================================================================
     * Test Case Name: Promo Page Student Academia
     * ====================================================================================================================
	 * @throws InterruptedException 
     *
     * 
     */
	
	@Test
	public void promoPageStudentAcademia() throws InterruptedException
	{
		
		reportLog("1.1: Go to https://beta.vin.com");
		promoPage.verifyPromoPageForLogin(LoginPage.class);
		
		reportLog("2.1: Select the 'Students and Academia' drop down option");
		promoPage.selectDropDown("Students and Academia");
		
		reportLog("2.2: Select 'Faculty and Residents");
		facultyandresidentPage=promoPage.selectOption("Faculty and Residents", FacultyAndResidentsPage.class);
		
		reportLog("2.3: Verify 'Faculty and Residents' page loads successfully");
		facultyandresidentPage.verifyFacultyAndResidentsPage();
		
		reportLog("2.4: Select the 'Students and Academia' drop down option");
		promoPage.selectDropDown("Students and Academia");

		reportLog("2.5: Select 'Interns'");
		internsPage=promoPage.selectOption("Interns",InternsPage.class);
		
		reportLog("2.6: Verify pages scrolls to Intern section of page");
		internsPage.verifyInternsPage();
		
		reportLog("3.1: Select the 'Students and Academia' drop down option");
		promoPage.selectDropDown("Students and Academia");

		reportLog("3.2: Select 'Recent Graduates'");
		recentGraduatesPage=promoPage.selectOption("Recent Graduates",RecentGraduatesPage.class);
		
		reportLog("3.3: Verify 'Recent Graduates' page loads successfully");
		ParentWin=switchToChildWindow();
		recentGraduatesPage.verifyRecentGraduatesPage();
		
		reportLog("3.4: Close the 'Recent Graduates' tab");
		switchParentWindowByClosingChild(ParentWin);
		
		reportLog("4.1: Select the 'Students and Academia' drop down option");
		promoPage.selectDropDown("Students and Academia");

		reportLog("4.2: Select 'VIN Students'");
		vinstudentsPage=promoPage.selectOption("VIN Students",VinStudentsPage.class);
		
		reportLog("4.3: Verify 'VIN Students' page loads successfully");
		switchToChildWindow();
		vinstudentsPage.verifyVinStudentsPage();
		
		reportLog("4.4: Close the 'VIN Students' tab");
		vinstudentsPage.closeTab();


	}

}
