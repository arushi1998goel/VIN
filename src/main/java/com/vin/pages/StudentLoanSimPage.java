package com.vin.pages;

import com.vin.selenium.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class StudentLoanSimPage extends BasePage {

    public StudentLoanSimPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "input[id='run-sim-button']")
    private WebElement runSimButton;

    @FindBy(xpath = "//div[contains(@data-target,'#loan-repayment-area')]")
    private WebElement loanRepayementArea;

    @FindBy(xpath = "//div[contains(@data-target,'#loan-repayment-area')]/following-sibling::div")
    private WebElement loanRepayementAreaValues;

    @FindBy(xpath = "//div[contains(@data-target,'#loan-repayment-area')]")
    private WebElement ForgivenessPlanningArea;

    @FindBy(xpath = "//div[contains(@data-target,'#loan-repayment-area')]/following-sibling::div")
    private WebElement ForgivenessPlanningAreaValues;

    @FindBy(xpath = "//div[contains(@data-target,'#loan-repayment-area')]")
    private WebElement totalLoanBalance;

    @FindBy(xpath = "//div[contains(@data-target,'#loan-repayment-area')]/following-sibling::div")
    private WebElement totalLoanBalanceArea;

    @FindBy(xpath = "//div[contains(@data-target,'#monthly-repayment')]")
    private WebElement monthlyRepayementArea;

    @FindBy(xpath = "//div[contains(@data-target,'#monthly-repayment')]/following-sibling::div")
    private WebElement monthlyRepayementAreaValues;


    @FindBy(xpath = "//div[contains(@data-target,'#loan-repayment-range-area')]")
    private WebElement loanRepayementRangeAreas;

    @FindBy(xpath = "//div[contains(@data-target,'#loan-repayment-range-area')]/following-sibling::div")
    private WebElement loanRepayementRangeAreasValues;

    @FindBy(xpath = "//div[contains(@data-target,'#monthly')]")
    private WebElement MonthlyReportAreas;

    @FindBy(xpath = "//div[contains(@data-target,'#monthly')]/following-sibling::div")
    private WebElement MonthlyReportAreasValues;

    @FindBy(xpath = "//input[@value='RESET']")
    private WebElement resetButton;

    @FindBy(xpath = "//div[@id='report-results']")
    private WebElement reportResult;

    @FindBy(xpath = "//select[@id='grad-year']")
    private WebElement graduateYearDropDown;

    @FindBy(xpath = "//select[@id='repayment-plan']")
    private WebElement repaymentPlan;

    @FindBy(xpath = "//select[@id='years-in-repayment']")
    private WebElement yearInRepayment;

    @FindBy(xpath = "//div[contains(text(),' Scenarios')]/../..")
    private WebElement presentScenariosDropDown;

    @FindBy(xpath = "//select[@id='repayment-plan']")
    private WebElement repaymentPlanDropDown;

    @FindBy(xpath = "//select[@id='repayment-plan' and @disabled='disabled' ] ")
    private WebElement repaymentPlanDropDownActive;

    @FindBy(xpath = "//select[@id='years-in-repayment']")
    private WebElement yearsInRepayement;

    @FindBy(xpath = "//button[text()='Dismiss All']")
    private WebElement dismissAllBtn;
    
    @FindBy(xpath="//select[@id='grad-year']")
    private WebElement yearDropdown;


    /**
     * Verify Student loan Sim pAge Title
     */
    public void verifyStudentLoanSimPage(String title) {
        org.testng.Assert.assertTrue(driver.getTitle().equalsIgnoreCase(title));
    }


    /**
     * Click on Run Sim Button
     */
    public void clickOnRunSimButton() {
        scrollDown();
        waitAndClick(runSimButton);
    }

    /***
     * Verify run sim button is enabled
     */

    public void verifyRunSimButtonISEnabled() {
        Assert.assertTrue(runSimButton.isEnabled());

    }

    /**
     * verify Loan Repayement Area is Populated
     */
    public void verifyLoanRepayementAreaIsPopulated() {
        _normalWait(4000);
        Assert.assertTrue(loanRepayementArea.getAttribute("class").contains("collapsible-header"));
        Assert.assertTrue(loanRepayementAreaValues.getAttribute("aria-expanded").contains("true"));
    }


    /**
     * Verify Forgiveness Planning Area Is Populated
     */
    public void verifyForgivenessPlanningModuleIsPopulated() {
        Assert.assertTrue(loanRepayementArea.getAttribute("class").contains("collapsible-header"));
        Assert.assertTrue(loanRepayementAreaValues.getAttribute("aria-expanded").contains("true"));
    }

    /*
     * Verify Forgiveness Planning Area Is Populated
     */
    public void verifyForgivenessPlanningModuleAreaIsPopulated() {
        Assert.assertTrue(ForgivenessPlanningArea.getAttribute("class").contains("collapsible-header"));
        Assert.assertTrue(ForgivenessPlanningAreaValues.getAttribute("aria-expanded").contains("true"));
    }


    /**
     * Verify total loan balance  Area Is Populated
     */
    public void verifyTotalLoanBalanceIsPopulated() {
        Assert.assertTrue(totalLoanBalance.getAttribute("class").contains("collapsible-header"));
        Assert.assertTrue(totalLoanBalanceArea.getAttribute("aria-expanded").contains("true"));
    }


    /**
     * Verify Monthly Area Is Populated
     */
    public void verifyMonthlyRepayementIsPopulated() {
        Assert.assertTrue(monthlyRepayementArea.getAttribute("class").contains("collapsible-header"));
        Assert.assertTrue(monthlyRepayementAreaValues.getAttribute("aria-expanded").contains("true"));
    }


    /**
     * Verify Loan Repayement Range Area Is Populated
     */
    public void verifyLoanRepayementRangeIsPopulated() {
        Assert.assertTrue(loanRepayementRangeAreas.getAttribute("class").contains("collapsible-header"));
        Assert.assertTrue(loanRepayementRangeAreasValues.getAttribute("aria-expanded").contains("true"));
    }


    /**
     * Verify monthly Report Area Is Populated
     */
    public void verifyMonthlyReportIsPopulated() {
        Assert.assertTrue(MonthlyReportAreas.getAttribute("class").contains("collapsible-header"));
        Assert.assertTrue(MonthlyReportAreasValues.getAttribute("aria-expanded").contains("true"));
    }

    /**
     * Click on Reset Button
     */

    public void selectResetButton() {
        waitAndClick(resetButton);
    }

    /**
     * Verify Values are cleared after reset Button
     */

    public void verifyValuesAreClearedAfterResetButton() {
        Assert.assertTrue(reportResult.getAttribute("class").contains("hidden"));
    }


    /***
     * Select  graduate year from drop down and select values from DropDown
     */
    public void selectGraduateYearDropDownAndSelectYearDropDown() {
        waitAndClick(graduateYearDropDown);
        driver.findElement(By.xpath("//select[@id='grad-year']/option[text()='2018']")).click();

    }

    /**
     * Verify Present Scenarios in Removed
     */
    public void verifypresentScenariosIsRemoved() {
        Assert.assertTrue(presentScenariosDropDown.getAttribute("style").contains("none"));

    }

    /**
     *Verify Repayment Plan Drop Down is activated.
     */
    public void verifyRepaymentPlanDropDownIsActivated() {
        Assert.assertTrue(presentScenariosDropDown.getAttribute("style").contains("none"));

    }

    /**
     * verify years In Repayement is Activated
     */
    public void verifyYearsInRepayementDropdownIsActivated() {
        Assert.assertTrue(presentScenariosDropDown.getAttribute("style").contains("none"));

    }

    /**
     * Select 1 from years in reapyement DropDown
     */
    public void selectYearsFromrepayementDropDown() {

        driver.findElement(By.xpath("//select[@id='years-in-repayment']/option[@value='2']")).click();
    }

    /**
     * Verify values is selected  From drop down
     */
    public void verifyValuesIsSelected() {
        Assert.assertTrue(driver.findElement(By.xpath("//select[@id='years-in-repayment']/option[@value='2']")).getText().equals("2"));
    }


    /**
     * Select standard 10 years in reapyement DropDown
     */
    public void selectStandard10FromrepayementDropDown() {

        driver.findElement(By.xpath("//select[@id='repayment-plan']/option[@value='Std10']")).click();
    }

    /**
     * Verify values is selected  From drop down
     */
    public void verifyRepaymentYearIsSelected() {
        Assert.assertTrue(driver.findElement(By.xpath("//select[@id='repayment-plan']/option[@value='Std10']")).getText().equals("Standard 10"));
    }

    public void dismissNotifications() {
        super.dismissNotifications(dismissAllBtn);
    }

    /***
     * Select 2018 from graduation year
     */

	public void select2018FromGraduationYear() {

		selectDropDownByText(yearDropdown, "2018");
		
	}
}
