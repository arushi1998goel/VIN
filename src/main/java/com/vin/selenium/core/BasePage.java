/*
  Class to initialize all page methods for the actions available
  under that page. All scripts must call the respective methods from the respective
  pages to achieve any action.

  @author 360Logica
 * @since 1.0
 *
 * @version 1.0
 */
package com.vin.selenium.core;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.google.common.base.Function;
import com.relevantcodes.extentreports.ExtentTest;
import com.vin.utilities.Constants;
import com.vin.utilities.DateCalendar;
import com.vin.utilities.Utilities;
import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class BasePage {

    protected static final int DEFAULT_WAIT_4_ELEMENT = 100;
    protected static final int DEFAULT_IMPLICIT_WAIT = 2;
    protected static final int DEFAULT_WAIT_4_PAGE = 15;
    protected static final Logger logger = LoggerFactory.getLogger(BasePage.class);
    public static ExtentTest test;
    public static BaseTest baseTest;
    protected static WebDriverWait ajaxWait;
    static String resultPath;
    protected WebDriver driver;
    protected String title;
    protected long timeout = 30;
    protected DateCalendar dateCalendarRef = new DateCalendar();

    /**
     * @Inject @Named("framework.implicitTimeout") protected long timeout;
     */

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public static String generateRandomString(int lettersNum) {
        StringBuilder finalString = new StringBuilder();

        int numberOfLetters = 25;
        long randomNumber;
        for (int i = 0; i < lettersNum; i++) {
            char letter = 97;
            randomNumber = Math.round(Math.random() * numberOfLetters);
            letter += randomNumber;
            finalString.append(String.valueOf(letter));
        }
        return finalString.toString();
    }

    /*
     * Get all available files from directory
     */
    public static List<String> getAvailableFilesListFromDirectory(String filePath) {
        boolean fileExist = false;
        String fileName;
        List<String> fileList = new ArrayList<>();
        String FileLocation = System.getProperty("user.dir") + File.separator + filePath + File.separator;
        try {
            File dir = new File(FileLocation);
            File[] dir_contents = dir.listFiles();
            if (dir_contents.length > 0) {
                fileExist = true;
                for (int i = 0; i < dir_contents.length; i++) {
                    fileName = dir_contents[i].getName();
                    fileList.add(fileName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(fileExist);
        return fileList;
    }

    /**
     * Functin: Get random integer
     *
     * @param aStart
     * @param aEnd
     * @return
     */

    public int getRandomInteger(final long aStart, final long aEnd) {
        final Random aRandom = new Random();
        if (aStart > aEnd) {
            throw new IllegalArgumentException("Start cannot exceed End.");
        }
        // get the range, casting to long to avoid overflow problems
        final long range = aEnd - aStart + 1;
        // compute a fraction of the range, 0 <= frac < range
        final long fraction = (long) (range * aRandom.nextDouble());
        final int randomNumber = (int) (fraction + aStart);
        return randomNumber;
    }

    /**
     * Click action performed and then wait
     */

    public void waitAndClick(WebElement element) {
        waitForElement(element);
        element.click();
    }

    public void clickOn(WebElement element) {
        element.click();
    }

    /**
     * Click on WebElement by using java script
     */
    public void javascriptButtonClick(WebElement webElement) {
        waitForElement(webElement);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", webElement);
    }

    /**
     * Click on element by string locator
     */
    public void waitAndClick(String locator) {
        this.WaitForElementPresent(locator, DEFAULT_WAIT_4_ELEMENT);

        this.WaitForElementPresent(locator, DEFAULT_WAIT_4_ELEMENT);
        Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
        WebElement el = getDriver().findElement(ByLocator(locator));
        el.click();
    }

    /**
     * Click on element by string locator
     */
    public void clickOn(String locator) {
        WebElement el = getDriver().findElement(ByLocator(locator));
        el.click();
    }

    public String returnTitle() {
        return title;
    }

    /**
     * Scroll page down 250 pixel
     */
    public void scrollDown() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)", "");
    }

    /**
     * Scroll page down pixel
     *
     * @param pixel pixel to scroll down
     */
    public void scrollDown(String pixel) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0," + pixel + ")", "");
    }

    public void scrollToDocumentHeight() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void scrollToTopOfThePage() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0 )");
    }

    /**
     * Scroll page up 250 pixel
     */
    public void scrollUp() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(250, 0)", "");
    }

    /**
     * Scroll page up pixel
     *
     * @param pixel pixel to scroll down
     */
    public void scrollUp(String pixel) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(" + pixel + ", 0)", "");
    }

    /**
     * Setting up implicit wait that will be used internally
     */
    private void setImplicitWait(int timeInSec) {
        logger.info("setImplicitWait, timeInSec={}", timeInSec);
        driver.manage().timeouts().implicitlyWait(timeInSec, TimeUnit.SECONDS);
    }

    /**
     * Reset implicit wait
     */
    private void resetImplicitWait() {
        logger.info("resetImplicitWait");

        driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    /**
     * Wait for element
     */
    public void waitFor(ExpectedCondition<Boolean> expectedCondition) {
        setImplicitWait(0);

        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_4_ELEMENT);

        wait.until(expectedCondition);
        resetImplicitWait();
    }

    /**
     * Input text as string
     */
    public void inputText(WebElement element, String text) {

        waitForWebElementEnable(element);

        try {
            element.clear();
        } catch (NoSuchElementException e) {
            _normalWait(2000);
            element.clear();
        }
        element.sendKeys(text);
    }

    /**
     * Wait for element to be present
     */
    public void waitForElement(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_4_ELEMENT);

        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Wait for element by passing argument as string.
     */
    public void waitForElementToVisible(String locator, long timeOut) {

        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_4_ELEMENT);

        wait.until(ExpectedConditions.visibilityOfElementLocated(ByLocator(locator)));
    }

    /**
     * Wait for list to be present and visible
     */

    @SuppressWarnings({"unchecked", "rawtypes"})
//	public void waitForListpresentAndVisible(List list) {
//		WebDriverWait wait = new WebDriverWait(driver, timeout);
//		wait.until((Predicate<WebDriver>) ExpectedConditions.visibilityOfAllElements(list));
//	}

    /** normal wait for thread. */
    public void _normalWait(long timeOut) {
        try {
            Thread.sleep(timeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Wait for JSLoad to load
     */
    public boolean _waitForJStoLoad() {
        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = driver -> {
            try {
                return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
            } catch (Exception e) {
                return true;
            }
        };

        /** wait for JavaScript to load */
        ExpectedCondition<Boolean> jsLoad = driver -> {
            Object rsltJs = ((JavascriptExecutor) driver).executeScript("return document.readyState");
            if (rsltJs == null) {
                rsltJs = "";
            }
            return rsltJs.toString().equals("complete") || rsltJs.toString().equals("loaded");
        };


        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_4_ELEMENT);

        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }

    /**
     * Handle locator type
     */
    public By ByLocator(String locator) {
        By result;
        if (locator.startsWith("//")) {
            result = By.xpath(locator);
        } else if (locator.startsWith("css=")) {
            result = By.cssSelector(locator.replace("css=", ""));
        } else if (locator.startsWith("#")) {
            result = By.id(locator.replace("#", ""));
        } else if (locator.startsWith("name=")) {
            result = By.name(locator.replace("name=", ""));
        } else if (locator.startsWith("link=")) {
            result = By.linkText(locator.replace("link=", ""));
        } else {
            result = By.className(locator);
        }
        return result;
    }

    /**
     * Verify the URL
     */
    public boolean verifyURL(String url) {
        boolean value = false;
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.contains(url) || value;
    }

    /**
     * Return current URL
     *
     * @return
     */
    public String getURL() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }

    /**
     * Return driver instance
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Find webelement
     */
    public WebElement findElement(By by) {
        WebElement foundElement;

        if (driver instanceof ChromeDriver || driver instanceof InternetExplorerDriver) {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (int millis = 0; millis < 3000; millis = millis + 200) {
            try {
                foundElement = driver.findElement(by);
                return foundElement;
            } catch (Exception e) {
                // Utils.hardWaitMilliSeconds(200);
            }
        }
        return null;
    }

    /**
     * Use assert by page title
     */
    public void assertByPageTitle(String TitleToBeVerified) {

        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_4_ELEMENT);

        try {
            if (driver instanceof ChromeDriver || driver instanceof InternetExplorerDriver
                    || driver instanceof FirefoxDriver) {
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.titleContains(TitleToBeVerified));
        Assert.assertTrue(driver.getTitle().trim().contains(TitleToBeVerified));
    }

    /**
     * Find all links on current page
     */
    public List<String> findAllLinksOnPage() {
        List<String> links = new ArrayList<>();
        List<WebElement> linkElements = driver.findElements(By.tagName("a"));
        for (WebElement each : linkElements) {
            String link = each.getAttribute("href");
            if (link == null || link.contains("mailto") || link.contains("javascript")) {
                continue;
            }
            links.add(link);
        }
        return links;
    }

    /**
     * Check the response of link
     */
    public boolean isResponseForLinkTwoHundredOrThreeOTwo(String link) {
        int code;
        Reporter.log("Link: " + link);
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            code = connection.getResponseCode();
            Reporter.log("Code: " + code);
        } catch (Exception e) {
            Reporter.log(e.toString());
            return false;
        }
        return link.contains("pager") || code == 403 || code == 200 || code == 302;
    }


    /**
     * Set wait for driver
     */
    public void setWaitTime(WebDriver driver, int waitTime) {
        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
    }

    public void setWaitTimeToZero(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    /**
     * Condition to customize
     */
    public void customizableCondition(WebDriver driver, int waitTime, final Boolean condition) {
        // setWaitTimeToZero(driver);
        new WebDriverWait(driver, waitTime).until((ExpectedCondition<Boolean>) driver1 -> condition);
        // setWaitTime(driver, DEFAULT_WAIT_4_ELEMENT);
    }

    /**
     * Wait for element to be clickable
     */


    public WebElement waitForElementClickable(WebElement webElement) {
        WebElement element;
        try {
            // setWaitTimeToZero(driver);
            WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_4_ELEMENT);
            element = wait.until(ExpectedConditions.elementToBeClickable(webElement));

            return element;

        } catch (Exception e) {
        }
        return null;
    }

    /**
     * Wait for element to be present
     */

//    public WebElement waitForElementPresent(final By by) {
//        WebElement element;
//        try {
//            // setWaitTimeToZero(driver);
//            WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_4_ELEMENT);
//            element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
//
//            return element;
//        } catch (Exception e) {
//        }
//        return null;
//    }

    /**
     * Wait for element to be present by web element
     */

    public WebElement waitForElementPresent(WebElement webElement) {
        WebElement element;
        try {
            WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_4_ELEMENT);
            element = wait.until(ExpectedConditions.visibilityOf(webElement));
            return element;
        } catch (Exception e) {
            e.printStackTrace();
        return null;
    }
    }


    /**
     * @param webElement
     * @param text
     * @param timeOutInSeconds
     * @return
     */
    public boolean waitForTextPresentInElement(WebElement webElement, String text, int timeOutInSeconds) {
        boolean notVisible;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        notVisible = wait.until(ExpectedConditions.textToBePresentInElement(webElement, text));

        return notVisible;
    }

    

    /**
     * Verify that element is present
     */
    public Boolean isElementPresent(WebElement element) {
        waitForElement(element);
        return element.isDisplayed();
    }

    /**
     * Verify that element is not Visible
     */

    public Boolean isElementNotVisible(WebElement element) {
        Boolean result = false;
        try {
            if (!(element.isDisplayed()))
                ;
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean isElementDisplayed(WebElement element) {
        boolean flag = false;
        try {
            if (element.isDisplayed())
                ;
            flag = true;
        } catch (Exception e) {
        }
        return flag;
    }

    /**
     * Verify that element is present on web page
     */
    public Boolean isElementPresent(String locator) {
        Boolean result = false;
        try {
            getDriver().findElement(ByLocator(locator));
            result = true;
        } catch (Exception ex) {
        }
        return result;
    }

    /**
     * @param locator
     * @return
     */
    public boolean WaitForElementNotPresent(WebElement locator) {
        boolean flag = false;
        int timeOut = 10;
        for (int i = 0; i < timeOut; i++) {
            if (!isElementPresent(locator)) {
                flag = true;
                break;

            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    /**
     * @param locator
     * @param timeout
     */
    public void WaitForElementPresent(String locator, int timeout) {
        for (int i = 0; i < timeout; i++) {
            if (isElementPresent(locator)) {
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param container
     * @param element
     * @return
     */
    public int findNumberOfSpecificElementsInContainer(By container, By element) {
        WebElement mainDiv = driver.findElement(container);
        List<WebElement> divs = mainDiv.findElements(element);
        return divs.size();
    }

    /**
     * @param elementList of WebElements
     * @return size of list
     */
    public int sizeofTheList(List<WebElement> elementList) {
        int listSize = elementList.size();
        return listSize;
    }

    /**
     * @param toBeHovered
     * @param toBeClicked
     * @return
     */
    public WebDriver hoverOverElementAndClick(WebElement toBeHovered, WebElement toBeClicked) {
        Actions builder = new Actions(driver);
        builder.moveToElement(toBeHovered).build().perform();
        waitForElementPresent(toBeClicked);
        waitForPageLoaded();
        return driver;
    }

    /**
     * Select element by visible text
     *
     * @param targetValue: visible text
     */
    public void selectDropDownByText(WebElement element, String targetValue) {
        waitForElement(element);
        new Select(element).selectByVisibleText(targetValue);
    }

    public void selectDropDownWithOptGroups(WebElement select, String targetValue) {
        boolean selected = false;
        try {
            // WebElement select = driver.findElement(By.id("chzn-select"));
            List<WebElement> options = select.findElements(By.tagName("option"));
            for (WebElement option : options) {
                if (option.getText().contains(targetValue)) {
                    option.click();
                    selected = true;
                    break;
                }
            }
        } catch (Exception e) {
        }
    }
    
    /***
     * return selected option from dropdown
     * @param element
     * @return
     */
    
    public String returnSelectedValueFromDropdown(WebElement element)
    {
    	Select select=new Select(element);
    	WebElement option=select.getFirstSelectedOption();
    	String firstValue=option.getText();
    	return firstValue;
    }

    /**
     * Select element by Index
     */
    public void selectDropDownByIndex(WebElement element, int index) {
        waitForElement(element);
        new Select(element).selectByIndex(index);
    }

    /**
     * Select element by value
     *
     * @param targetValue: value
     */
    public void selectDropDownByValue(WebElement element, String targetValue) {
        // waitForElement(element);
        new Select(element).selectByValue(targetValue);
    }

    /**
     * @param by
     * @param driver
     */
    public void waitForElementToBecomeVisible(By by, WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_4_ELEMENT);

        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
     * @param by
     */
    public void waitForElementToBecomeInvisible(By by) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_4_ELEMENT);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    /**
     *
     */
    public void waitForAjaxRequestsToComplete() {
        (new WebDriverWait(driver, DEFAULT_WAIT_4_ELEMENT)).until((ExpectedCondition<Boolean>) d -> {

            JavascriptExecutor js = (JavascriptExecutor) d;
            return (Boolean) js.executeScript("return jQuery.active == 0");
        });
    }

    public void highLighterMethod(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }

    /**
     *
     */
    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState").equals("complete");
        Wait<WebDriver> wait = new WebDriverWait(driver, DEFAULT_WAIT_4_ELEMENT);

        wait.until(expectation);
    }

    /**
     * @param by
     * @return
     */
    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Verify that text is present on the page.
     */
    public boolean isTextPresentOnPage(String text) {
        return driver.findElement(By.tagName("body")).getText().contains(text);
    }

    /**
     * Verify selected element is mandatory
     *
     * @param element
     */
    public void verifyInputIsMandatory(WebElement element) {

        Assert.assertEquals(element.getCssValue("color"), "#cc472c");
        Assert.assertEquals(element.getCssValue("background-color"), "rgba(255, 217, 217, 1)");

    }

    /**
     * @param webElement
     * @return
     * @throws Exception
     */
    public boolean isFileAvailableForDownload(WebElement webElement) throws Exception {
        int code;
        String downloadUrl = webElement.getAttribute("href");
        URL url = new URL(downloadUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        code = connection.getResponseCode();
        Reporter.log("The response code for download is " + code);
        return code == 200;
    }

    /**
     * Store text from a locator
     */
    public String getText(WebElement element) {
        Assert.assertTrue(element.isDisplayed(), "Element Locator :" + element + " Not found");
        return element.getText();
    }

    public void takeRemoteWebDriverScreenShot(String fileName) {
        File screenshot = ((TakesScreenshot) new Augmenter().augment(driver)).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(fileName));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void waitForTextNotToBeVisible(String text, int timeoutInSeconds) {
        int startWait = 0;
        while (isTextPresentOnPage(text)) {
            // Utils.hardWaitSeconds(1);
            startWait++;
            if (startWait == timeoutInSeconds) {
                throw new TimeoutException();
            }
        }
    }

    /**
     * @param element
     * @return visibility of the element
     */
    public void waitForWebElementPresent(WebElement element) {

        WebDriverWait ajaxWait = new WebDriverWait(driver, DEFAULT_WAIT_4_ELEMENT);

        ajaxWait.until(ExpectedConditions.visibilityOf(element));

    }

    /**
     * Perform Drag and drop
     */
    public void dragAndDrop(WebElement drag, WebElement drop) {
        Actions builder = new Actions(driver);
        builder.clickAndHold(drag).moveToElement(drop).pause(500).release(drop).build().perform();
    }

    /**
     * Switch to next tab
     */
    public void switchToTab() {
        // Switch to current selected tab's content.
        driver.switchTo().defaultContent();
        // Switching between tabs using CTRL + tab keys.
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t");

        // Switching between tabs using CTRL + tab keys.
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t");
        // Switch to current selected tab's content.
        driver.switchTo().defaultContent();
    }

    public void scrollPageThroughWebElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        _normalWait(3000);
    }

    

    public void scrollIntoView(By by) {
        WebElement elem = getDriver().findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", new Object[]{elem});
    }

    /**
     * To load all the records by scrolling down the page
     *
     * @param totalPages
     */
    public void loadCompleteList(WebElement totalPages) {
        _normalWait(3000);
        if (totalPages.isDisplayed()) {
            String[] totalPagesCount = totalPages.getText().split("\\ /");
            int intialPagePos = 1;
            while (intialPagePos <= Integer.valueOf(totalPagesCount[1].replaceAll(" ", ""))) {
                scrollToDocumentHeight();
                _normalWait(3000);
                intialPagePos++;
            }
        }
    }

    /**
     * Capturing screenshot once script is failed
     */
    public void captureScreenshotOfPages(String result) {
        try {
            String screenshotName = Utilities.getFileName(result);
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = Utilities.getPath();
            String screen = path + "/test-output/screenshots/" + screenshotName + ".png";
            File screenshotLocation = new File(screen);
            FileUtils.copyFile(screenshot, screenshotLocation);
            Thread.sleep(2000);
            Reporter.log(
                    "<a href= '" + screen + "'target='_blank' ><img src='" + screen + "'>" + screenshotName + "</a>");
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    /**
     * Funtion: Select option from dropdown
     *
     * @param options
     * @param givenOption
     */
    public void selectDropdownOption(List<WebElement> options, String givenOption) {
        for (WebElement e : options) {
            if (e.getText().equals(givenOption)) {
                waitAndClick(e);
                break;
            }
        }
    }

    /**
     * Function: Get all drop down options list
     *
     * @param selectDropDownWebElement
     */
    public List<WebElement> getDropDownOptions(WebElement selectDropDownWebElement) {

        waitForElementPresent(selectDropDownWebElement);

        Select dropdown = new Select(selectDropDownWebElement);
        return dropdown.getOptions();
    }

    /**
     * Function: Get Selected drop down option
     *
     * @return
     */
    public WebElement getSelectedDropDownOption(WebElement selectDropDownWebElement) {

        waitForElementPresent(selectDropDownWebElement);

        Select dropdown = new Select(selectDropDownWebElement);
        return dropdown.getFirstSelectedOption();
    }

    
   /**  *
     * @function: Select accept alert.
     */
    public void acceptAlertPresent() {
        try
        {
            WebDriverWait wait = new WebDriverWait(getDriver(),DEFAULT_WAIT_4_PAGE );
            wait.until(ExpectedConditions.alertIsPresent());

            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * @return
     * @function: Select accept alert.
     */
    public String getAlertText() {
        String AlertMessage = null;
        WebDriverWait wait = new WebDriverWait(getDriver(),DEFAULT_WAIT_4_ELEMENT);
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
         AlertMessage = alert.getText();
         alert.accept();
         return AlertMessage;

    }
        
   

    /**
     * Funtion: Verify presence of alert popup
     *
     * @return
     */
    public boolean isAlertPresent() {
        try {

            _normalWait(5000);
            driver.switchTo().alert();
            driver.switchTo().alert();
            _normalWait(1000);

            logger.debug("Check if alert present");
            return true;
        } catch (final NoAlertPresentException e) {
            return false;
        }
    }

    public String currentDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String strDate = formatter.format(date);
        return strDate;
    }

    /**
     * Get Past week start and end dates
     *
     * @return
     */
    public List<String> pastWeekStartAndEndDates() {
        List<String> listToBeVerified = new ArrayList<String>();
        ZoneId US = ZoneId.of("America/New_York");
        final ZonedDateTime input = ZonedDateTime.now(US);
        final ZonedDateTime startOfLastWeek = input.minusWeeks(1).with(DayOfWeek.MONDAY);
        listToBeVerified.add(DateTimeFormatter.ofPattern("dd-MMM-yyyy").format(startOfLastWeek));
        final ZonedDateTime endOfLastWeek = startOfLastWeek.plusDays(6);
        listToBeVerified.add(DateTimeFormatter.ofPattern("dd-MMM-yyyy").format(endOfLastWeek));
        return listToBeVerified;
    }


    public WebElement waitForWebElementEnable(WebElement webElement) {

        try {
            new FluentWait<WebElement>(webElement).withTimeout(DEFAULT_WAIT_4_ELEMENT, TimeUnit.SECONDS)
                    .pollingEvery(10, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class)
                    .ignoring(ElementNotVisibleException.class).ignoring(ElementNotInteractableException.class)
                    .ignoring(TimeoutException.class).ignoring(ElementNotFoundException.class)
                    .until(new Function<WebElement, Boolean>() {
                        @Override
                        public Boolean apply(WebElement element) {
                            return element.isEnabled();
                        }
                    });

        } catch (Exception e) {

        }
        return null;
    }

    public void waitForSpinner(int timeout) {
        waitForAjaxRequestsToComplete();
        String locator = "//div[@class='ng-isolate-scope ng-hide']";
        WebElement element = driver.findElement(By.xpath(locator));
        waitForWebElementEnable(element);

    }

    /**
     * Select CheckBox From The List
     */
    public void clickCheckboxFromList(String xpathOfElement, String valueToSelect) {
        List<WebElement> element = driver.findElements(By.xpath(xpathOfElement));
        for (int i = 0; i < element.size(); i++) {
            List<WebElement> dr = element.get(i).findElements(By.tagName("input"));
            for (WebElement value : dr) {
                if (valueToSelect.equals(value.getText())) {
                    value.click();
                    break;
                }
            }
        }
    }

    /**
     * CheckBox Checking
     **/
    public boolean checkboxStatus(WebElement checkbox) {
        boolean checkstatus = false;
        try {
            if (checkbox.isSelected())
                checkstatus = true;
        } catch (Exception e) {

        }
        return checkstatus;
    }

    /**
     * Navigate to previous page
     **/

    public void navigateBack() {
        driver.navigate().back();
    }

    /**
     * Navigate to forward
     **/
    public void navigateForward() {
        driver.navigate().forward();
    }

    public void waitSpinnerToBecomeInvisible() {
        waitForAjaxRequestsToComplete();
        waitForElementToBecomeInvisible(By.xpath("//div[@class='spinner']"));
    }

    public void spinnerBecomeInvisible() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='ng-isolate-scope']")));
    }

    public void loaderBecomeInvisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        String[] data = element.toString().split(" -> ")[1]
                .substring(0, element.toString().split(" -> ")[1].lastIndexOf("]")).split(": ");
        String locator = data[0];
        String value = data[1];

        switch (locator) {
            case "xpath":
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(value)));
                break;
            case "css selector":
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(value)));
                break;
            case "id":
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(value)));
                break;
            case "tag name":
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.tagName(value)));
                break;
            case "name":
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.name(value)));
                break;
            case "link text":
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText(value)));
                break;
            case "class name":
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(value)));
                break;
            default:
                Assert.assertTrue(false, "Valid locator not found");
        }
    }

    public void waitSpinnerToBecomeVisible() {
        waitForAjaxRequestsToComplete();
        waitForElementToBecomeVisible(By.xpath("//div[@class='spinner']"), driver);
    }

    public void waitForElement() throws InterruptedException {
        Thread.sleep(2000);
    }

    /**
     * To Get The ToolTip Text
     *
     * @param element
     */
    public String getToolTip(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        String tootipMsg = element.getAttribute("title");
        return tootipMsg;
    }

    /**
     * @function: Double click on the element
     */
    public void doubleClickOnElement(WebElement element) {
        // javascripctHilightingElement(element);

        Actions actions = new Actions(driver).doubleClick(element);
        actions.build().perform();
    }

    public void switchToFrame(WebElement element) {
        waitForPageLoaded();
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_4_ELEMENT);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
        driver.switchTo().frame(element);
    }

    /**
     * Switch to default content
     */
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    /**
     * Get the current frame
     *
     * @return
     */

    public String getCurrentFrame() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return self.name");
    }

    /**
     * Switch to Create a desired frame
     */
    public void switchToEditingWindowFrame(WebElement frameParent, List<WebElement> frame) {
        waitForPageLoaded();
        _normalWait(1000);
        switchToFrame(frameParent);
        try {
            for (WebElement element : frame) {
                if (element.getAttribute("src").equalsIgnoreCase("about:blank")) {
                    continue;
                } else {
                    switchToFrame(element);
                }
            }
        } catch (Exception e) {

        }
    }

    /**
     * Mousehover on any element
     */
    public void mouseHoverOnAnElement(WebElement webElement) {
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).build().perform();
    }

    /**
     * click by mouse hover on any element
     */
    public void clickByMouseHoverOnAnElement(WebElement webElement) {
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).click().build().perform();
    }

    /**
     * open Application In New Window Tab
     */
    public String openApplicationInNewWindowTab(String appURL) {
        String parent = null, child;
        _normalWait(2000);
        try {
            Robot robObj = new Robot();
            robObj.keyPress(KeyEvent.VK_CONTROL);
            robObj.keyPress(KeyEvent.VK_T);
            robObj.keyRelease(KeyEvent.VK_T);
            robObj.keyRelease(KeyEvent.VK_CONTROL);
            _normalWait(1000);
            Set<String> windows = getDriver().getWindowHandles();
            Iterator<String> iterator = windows.iterator();
            parent = iterator.next();
            child = iterator.next();
            getDriver().switchTo().window(child);
            getDriver().navigate().to(appURL);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return parent;
    }

    /**
     * @param elementToBeCheck
     * @return
     * @function: To verify element's enable or disable status
     */
    public boolean elementStatus(WebElement elementToBeCheck) {
        boolean status = false;
        if (elementToBeCheck.isEnabled()) {
            status = true;
        } else if (!(elementToBeCheck.isEnabled())) {
            status = false;
        }
        return status;
    }

    /**
     * Get System current date time stamp in DD-MMM-YYYY format
     *
     * @return
     */
    public void verifyDateFormat(WebElement calenderWebelement) {

        boolean dateFormatFlag = false;

        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-uuuu");
        String systemFormatDateTime = currentTime.format(formatter);
        String dateStr = systemFormatDateTime.replace("-", "").replace(" ", "");

        String dateAndTimeSTR = calenderWebelement.getText();
        String formattedDate = dateAndTimeSTR.replace("-", "").replace(" ", "");

        /*
         * int k = formattedDate.indexOf(" ", formattedDate.indexOf(" ") + 1); String
         * dateFormat1 = formattedDate.substring(0, k);
         *
         * int i = dateFormat1.indexOf(" ", dateFormat1.indexOf(" ")); String
         * dateFormat3 = dateFormat1.substring(0, i);
         */

        if (dateStr.length() <= formattedDate.length()) {
            dateFormatFlag = true;
            Assert.assertTrue(dateFormatFlag, "Date displayed in DDMMMYYYY Format");

        } else {
            Assert.assertFalse(dateFormatFlag);
        }
    }

    /**
     * @function: Clear the previously filled input box
     */
    public void clearTextBox(WebElement inputBoxWebElement) {

        inputBoxWebElement.clear();
    }

    /**
     * @return Background color of the element
     * @function: Get background color of an element
     */
    public String getBackgroundColor(WebElement element) {
        String bgColor = element.getCssValue("background-color");
        return bgColor;
    }

    public String getTextColor(WebElement element) {
        String TextColor = element.getCssValue("color");
        return TextColor;
    }

    /**
     * @return
     * @function: Verify visibility of element on the page through list size
     */
    public boolean isElementVisibleListSize(List<WebElement> weList) {
        boolean visibility = false;
        if (weList.size() < 0) {
            visibility = false;
        } else if (weList.size() > 0) {
            visibility = true;
        }
        return visibility;

    }

    /**
     * @return
     * @function: Get any attribute value of an element
     * @param: Webelement and Attribute name
     */
    public String getAttributeValueOfElement(WebElement element, String attributeName) {
        isElementPresent(element);
        String attributeValue = element.getAttribute(attributeName);
        return attributeValue;
    }

    /* Refresh The Page */
    public void refreshPage() {
        driver.navigate().refresh();
        waitForElementToBecomeInvisible(By.xpath("//div[@id='modal-fade' and @class='smart-spinner']"));
        _normalWait(2000);
    }

    /**
     * Convert Sting value to Integer value
     */
    public int parseStringValueIntoInteger(String StringToBeEntered) {
        int result = Integer.parseInt(StringToBeEntered);
        return result;
    }

    /**
     * Get round Off To 2 Decimal Number
     */
    public Double getRoundOffTo2DecimalNumber(Double EnterNumber) {
        String roundOffDecimalNumber = String.format("%.2f", EnterNumber);
        Double number = Double.parseDouble(roundOffDecimalNumber);
        return number;
    }

    /*
     * This method going to perform enter action one the webelement
     *
     * @param element
     */

    /**
     * Add source file to Upload
     *
     * @throws InterruptedException
     */
    public void uploadFile(WebElement buttonToUploadFile, String filePath, String fileName)
            throws InterruptedException {
        String FileLocation = null;
        StringSelection ss;
        waitForElement(buttonToUploadFile);
        _normalWait(2000);
        try {
            Actions actions = new Actions(driver).click(buttonToUploadFile);
            actions.build().perform();
            FileLocation = System.getProperty("user.dir") + File.separator + filePath + File.separator + fileName;
            ss = new StringSelection(FileLocation);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
            _normalWait(500);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            _normalWait(500);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void performEnter(WebElement element) {
        element.sendKeys(Keys.ENTER);
    }

    /**
     * open file from directory
     *
     * @return
     */
    public boolean openFileFromDirectory(String filePath, String FileName, String fileType) {
        boolean flag = false;
        String FileLocation = System.getProperty("user.dir") + File.separator + filePath + File.separator + FileName
                + fileType;
        try {
            File file = new File(FileLocation);
            if (file.exists()) {
                // long startTime = System.currentTimeMillis();
                Desktop.getDesktop().open(file);
                _normalWait(4000);
                flag = true;
                // long endTime = System.currentTimeMillis();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(flag);
        return flag;
    }

    /**
     * Loading an existing document
     *
     * @param filePath
     * @param FileName
     * @param FileType
     * @return
     */
    public PDDocument loadingExistingPDFDocument(String filePath, String FileName, String FileType) {
        PDDocument document = null;
        String FileLocation = System.getProperty("user.dir") + File.separator + filePath + File.separator + FileName
                + FileType;
        try {
            File file = new File(FileLocation);
            document = PDDocument.load(file);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return document;
    }

    /*
     * This funnction creates a List and switches to window which is not current
     */

    public void switchToNewWindow() {

        String currentWindow = driver.getWindowHandle();
        Set<String> allHandles = driver.getWindowHandles();
        allHandles.remove(currentWindow);

        for (Iterator<String> it = allHandles.iterator(); ((Iterator) it).hasNext(); ) {
            String newHandle = it.next();
            driver.switchTo().window(newHandle);
        }
    }

    /**
     * right click on already moved to element
     */
    public void rightClickOnElement(WebElement webElement) {
        Actions actions = new Actions(driver);
        actions.contextClick(webElement).build().perform();
    }

    /**
     * Click Enter through Robot class
     *
     * @throws AWTException
     */

    public void clickEnter() throws AWTException {

        Robot robot = new Robot();
        _normalWait(4000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        robot.delay(2000);


    }
    
    
    /**
     * Click Tab through Robot class
     *
     * @throws AWTException
     */

    public void clickTab() throws AWTException {

        Robot robot = new Robot();
        _normalWait(4000);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.delay(2000);


    }
    
    

    
    /**
     * Click Escape button through Robot class
     *
     * @throws AWTException
     */

    public void clickESC() throws AWTException {
        Robot robot = new Robot();
        _normalWait(1000);
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        robot.delay(1000);
    }

        //robot.delay(2000);

    /**
     * verify Downloaded pdf File
     */
    public void verifyDownloadedPdfFile(String FileName, String FileType) {
        boolean flag = false;
        List<String> fileList;
        waitForPageLoaded();
        for (int i = 0; i < 5; i++) {
            _normalWait(1000);
            fileList = getAvailableFilesListFromDirectory(Constants.DownloadedFilePath);
            if (fileList.contains(FileName + FileType)) {
                flag = true;
                break;
            } else {
                continue;
            }
        }
        Assert.assertTrue(flag);
    }

    /**
     * Getting browser name  by using desired capabilities
     */
    public String browserName() {
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        return cap.getBrowserName().toLowerCase();

    }
    /***
	 * Verify The radio Button is Selected
	 */
	public void verifyRadioButtonIsSelected(WebElement we) {
		Assert.assertTrue(we.isSelected());
	}
	
	
	/**
     * Verify User is able to enter numeric Values in TextBox
     */

    public void verifyuserIsAbleOEnterNumericAmountInTheTextBox(WebElement we) {
        boolean flag = we.getAttribute("type").equalsIgnoreCase("number");
        logger.debug("Verify User is able to enter numeric amount in volume per can text box :" + flag);
        Assert.assertTrue(flag);

    }
    
    
    /**
     * Select Checkbox
     */
    public void selectCheckbox(WebElement we) {
    	waitAndClick(we);
    	
    }
    
    
	/**
	 * Verify user is able to select value of dropdown
	 */
	
	public void verifyOptionsIsSelectFromDropDown(String ChoclateName,WebElement we) {
		
		Select select = new Select(we);
		WebElement option = select.getFirstSelectedOption();
		String defaultItem = option.getText();
		Assert.assertEquals(defaultItem, ChoclateName);

	}

    public void closeDriver() {
        getDriver().quit();
    }

    public void dismissNotifications(WebElement el) {
    	boolean flag=true;
    	try {
    	if (el.isDisplayed()) {
   		 waitForElementPresent(el);
   	        clickOn(el);
   	        _normalWait(4000);
			flag=true;
		}
	} catch (Exception e) {
	}
    	
    Assert.assertTrue(flag);	
   }

    public void scrollDownUsingRobotClass() throws AWTException
    {
    	Robot robot=new Robot();
    	robot.setAutoDelay(3000);
    	robot.keyPress(KeyEvent.VK_PAGE_DOWN);
    	robot.setAutoDelay(3000);
    	robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
    	robot.setAutoDelay(3000);
    }
}
