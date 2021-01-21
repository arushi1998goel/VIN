/*
  Class to initialize all application page objects and manage WebDriver browser
  object. Each and every test script class must extend this. This class does
  not use any of the Selenium APIs directly, and adds support to make this
  framework tool independent.
 */
package com.vin.selenium.core;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.vin.enums.DriverType;
import com.vin.pages.*;
import com.vin.report.ScreenRecorder;
import com.vin.testscripts.SearchHappyPath;
import com.vin.utilities.ApplicationVerificationMessages;
import com.vin.utilities.UserClaims;
import com.vin.utilities.Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Optional;
import org.testng.annotations.*;

import java.io.*;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

//import com.vin.pages.SignalmentPage;

public abstract class BaseTest extends ScreenRecorder implements UserClaims, ApplicationVerificationMessages {

    public static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    public static final String[] IMAGES = {".\\screenshots\\DummyImage.png"};
    private static final String BREAK_LINE = "\n";
    public static ExtentTest test;
    public static ExtentReports extent;
    public static String resultPath;
    public static Document document = null;
    protected static String setEnvironment;
    protected static String targetURl;
    protected static String targetEnvironment;
    protected static Properties RegressionTestData, UserClaim;
    static Image img;
    static String message = "";
    private static String quitBrowser;
    private static String ChromeBrowser;
    private static String FirefoxBrowser;
    private static String IEBrowser;
    private static String LaunchBrowser = null;
    private static String filepathForDownloads = System.getProperty("user.dir")
            + "\\src\\main\\resources\\downloadedFiles\\";
    private static Map<Integer, ExtentTest> extentTestMap;
//	protected SignalmentPage signalmentPage;
    // pages object initialization
    protected LoginPage loginPage;
    protected PromoPage promoPage;
    protected SecurityQuestionPage securityQuestionPage;
    protected FrontPage frontPage;
    protected LogoutPage logoutPage;
    protected SearchPage searchPage;
    protected AddStuffPage addStuffPage;
    protected DrugDilution_Page drugDilutionPage;
    protected CalculatorPage calculatorpage;
    protected VindexPage vindexPage;
    protected VIN_UsagePage vinUsage;
    protected MessageBoards messageboards;
    protected MyColleaguePage myColleaguePage;
    protected FeedingTubeAndTransfusionVolumePage feedintubeAndTransfusionPage;
    protected VVDHPage vvdh;
    protected TransfusionVolumePage transfusionVolume;
    protected ContinualEducationPage  continualEducationpage;
    protected String browserType, UserID, UserPswrd;
    protected EmergencyDrugFelinePage  emergecyDrugFeline;
    protected ChocolateToxicityPage chocolatetoxicitypage;
    protected StudentLoanSimPage studentloansimpage;
    protected PostGraduateTrainingPage postGraduateTrainingPage;
    protected PhlebotomyVolumeCalculatorPage phlebotomyGraduateTrainingPage;
    protected IsleHappyPathPage islehappypathpage;
    protected SearchHappyPathPage searchhappypath;
    protected JournalsPage journalsPage;
    protected CRIPage criPage;
    protected NewsPage newsPage;
    protected FacultyAndResidentsPage facultyandresidentPage;
    protected InternsPage internsPage;
    protected RecentGraduatesPage recentGraduatesPage;
    protected VinStudentsPage vinstudentsPage;
    protected ConsultantsAndEditorsPage consultantAndEditorPage;
    protected RepresentativesPage representativePage;
    protected ProudToBeaVinnerPage proudToBeViNnerPage;
    protected FriendsOfVINPage friendsOfVinPage;
    protected VINxPage vinXPage;
    protected MyActivitiesPage myActivitiesPage;
    protected PresenterFourMenu presenterFourMenu;
    protected LibraryQuickLink libraryQuickLink;
    protected ViurtualClinicHappyPathPage virtualClinicHappyPath;
    


    //protected  VPPages vpPages;
    private WebDriver driver;
    protected CECourseInfoPage courseInfoPage;

    public static synchronized ExtentTest getTest() {
        return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }

    public static synchronized ExtentTest startTest(String testName, String desc) {

        test = extent.startTest(testName, desc);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }

    public static String getMessage() {
        return message;
    }

    /**
     * Generate Random Numeric String of length
     */
    public static String GenerateRandomNumber(int charLength) {
        return String.valueOf(charLength < 1 ? 0
                : new Random().nextInt((9 * (int) Math.pow(10, charLength - 1)) - 1)
                + (int) Math.pow(10, charLength - 1));
    }

    /**
     * Function: Get random string
     *
     * @param lettersNum
     * @return
     */
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

    @BeforeSuite
    public void before() throws Exception {
        // Create Result repository for report.
        String timeStamp = getFormattedTimeStamp().replace("-", "").replace(":", "").replace(".", "");
        String path = Utilities.getPath();
        resultPath = path + "/Result/Suite_" + timeStamp;
        File ExtentReportsource = new File(path + "/Result/");

        if (ExtentReportsource.exists()) {

            try {
                FileUtils.deleteDirectory(ExtentReportsource);
            } catch (Exception e) {

            }

        }
        if (!(ExtentReportsource.exists())) {
            ExtentReportsource.mkdir();
        }
        new File(resultPath).mkdirs();
        extent = new ExtentReports(resultPath + "/CustomReport.html", true);
        // machineForRun = Configuration.readApplicationFile("RunOnLocalMachine");
        quitBrowser = Configuration.readApplicationFile("closeAndQuitBrowser");
        targetEnvironment = Configuration.readApplicationFile("defaultEnv");
        ChromeBrowser = Configuration.readApplicationFile("Chrome");
        FirefoxBrowser = Configuration.readApplicationFile("Firefox");
        IEBrowser = Configuration.readApplicationFile("IE");

        extentTestMap = new HashMap<Integer, ExtentTest>();

        if (System.getProperty("browser") != null) {
            browserType = System.getProperty("browser");

        }
        if (browserType == null || browserType.equals("true")) {
            if (ChromeBrowser.trim().equals("true")) {
                LaunchBrowser = "Chrome";
            } else if (FirefoxBrowser.trim().equals("true")) {
                LaunchBrowser = "Firefox";
            } else if (IEBrowser.trim().equals("true")) {
                LaunchBrowser = "IE";
            } else {
                throw new Exception("Please pass a valid browser type value");
            }
        }

        targetURl = System.getProperty("targetEnv");

        if (targetURl != null) {
            if (targetURl.startsWith("https://")) {
                setEnvironment = targetURl;
            } /*else if (targetURl.trim().equalsIgnoreCase("true") || targetURl.trim().equalsIgnoreCase("")) {
                setEnvironment = Configuration.readApplicationFile(targetEnvironment + "URL");
            }*/ else {
                setEnvironment = "https://"+targetURl+Configuration.readApplicationFile("suffixURL");
            }
        } else {
            setEnvironment = Configuration.readApplicationFile("defaultEnv");
        }

        System.setProperty("targetEnv",setEnvironment);

    }

    @SuppressWarnings({"static-access", "deprecation", "unused"})
    @BeforeMethod
    @Parameters("browser")
//	 @Parameters({ "Browser", "URL" }) String browser,String URL
    public void setUp(Method method, @Optional("") String browserParam) throws Exception {

        if (browserParam != null) {
            browserType = browserParam;
        }
        if (browserType == null || browserType.equalsIgnoreCase("") || browserType.equalsIgnoreCase("${browser}")) {
            browserType = LaunchBrowser;

        }

        @SuppressWarnings("rawtypes")
        Class className = this.getClass();

        /**
         * Initialize the reporting object
         */
        setReportTest(method, browserType);

        if (DriverType.Firefox.toString().toLowerCase().equals(browserType.toLowerCase())) {

            WebDriverManager.firefoxdriver().setup();
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            FirefoxProfile profile = new FirefoxProfile();
            FirefoxOptions option = new FirefoxOptions();

            profile.setAcceptUntrustedCertificates(true);
            profile.setPreference("browser.download.folderList", 2);
            profile.setPreference("browser.download.manager.showWhenStarting", false);
            profile.setPreference("browser.download.dir", filepathForDownloads);

            profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
            profile.setPreference("network.proxy.type", 0);
            profile.setPreference("pdfjs.disabled", true);
            profile.setPreference("media.gmp-gmpopenh264.autoupdate",false);
            capabilities.setCapability(FirefoxDriver.PROFILE, profile);
            capabilities.setCapability("marionette", true);
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            option.setProfile(profile);
            driver = new FirefoxDriver(option);

        } else if (DriverType.IE.toString().toLowerCase().equals(browserType.toLowerCase())) {

            WebDriverManager.iedriver().setup();
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            capabilities.setCapability("nativeEvents", false);
            driver = new InternetExplorerDriver(capabilities);
        } else if (DriverType.Chrome.toString().toLowerCase().equals(browserType.toLowerCase())) {

            WebDriverManager.chromedriver().setup();
            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.default_directory", filepathForDownloads);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-extensions");
            options.addArguments("disable-infobars");
            options.setExperimentalOption("prefs", chromePrefs);
            options.addArguments("enable-automation");
            // options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--no-sandbox");
            options.addArguments("--dns-prefetch-disable");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-extensions");
            options.setExperimentalOption("useAutomationExtension", false);
            options.addArguments("--proxy-server='direct://'");
            options.addArguments("--proxy-bypass-list=*");
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            // cap.setCapability(ChromeOptions.CAPABILITY, options);
            options.merge(cap);
            driver = new ChromeDriver(options);

        } else {
            throw new Exception("Browser type is not defined Please pass a valid value");
        }

        /**
         * Maximize window
         */
        driver.manage().window().maximize();

        /**
         * Delete cookies and set timeout
         */
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        /**
         * Open application URL
         */
        getWebDriver().navigate().to(setEnvironment);

        promoPage = PageFactory.initElements(getWebDriver(), PromoPage.class);

        /**
         * Set property file
         */
        RegressionTestData = Configuration.readTestData("RegressionTestData");

        reportLog("Initialize Browser - " + browserType + " ");
        reportLog("Invoke target Environment - " + setEnvironment + " ");

        String user = Configuration.readApplicationFile("Username");
        UserClaim = Configuration.readTestData("UserClaim");
        String username = System.getProperty("username");
        String password = System.getProperty("password");
        if(username == null || username == "" || password == null || password == "")
        {
//            System.out.println("Username/Password not provided as argument, picking it from configuration");
            logger.debug("Username/Password not provided as argument, picking it from configuration");
            UserID = UserClaims.UserName_VINuser;
            UserPswrd = UserClaims.Password_VINuser;
        }
        else
        {
            UserID = username;
            UserPswrd = password;
        }


        /**
         * Create new folder to download files from browser
         */
        File downloadedFiles = new File(filepathForDownloads);
        if (!(downloadedFiles.exists())) {
            downloadedFiles.mkdirs();
        } else {
            FileUtils.cleanDirectory(downloadedFiles);
        }

    }

    public void setReportTest(Method method, String browserType) {

        System.setProperty("testcaseName", method.getName().toString());

        test = startTest(browserType.toUpperCase() + " - " + method.getName(), this.getClass().getName());
        test.assignCategory(browserType.toUpperCase());

    }

    @AfterMethod
    public void afterMainMethod(ITestResult result) throws IOException, InterruptedException {

        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                getTest().log(LogStatus.FAIL, "Failed test step is: " + result.getName() + " => " + getMessage());
                getTest().log(LogStatus.FAIL, result.getThrowable());
                captureScreenshot(result);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (!(result.getStatus() == (ITestResult.SUCCESS) || result.getStatus() == (ITestResult.FAILURE))) {
            try {
                getTest().log(LogStatus.SKIP, "Skipped Test Case is: " + result.getName() + " => " + getMessage());
                captureScreenshot(result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        extent.endTest(test);

        if (quitBrowser.equals("true")) {
            driver.quit();
        }

    }

    @SuppressWarnings("unused")
    @AfterSuite /* (alwaysRun = true) */
    public void tearDownSuite() throws IOException {
        boolean direExists = false;
        boolean deskdirExists = false;

        File dest = new File(Utilities.getPath() + "/target/");
        File resultSourceFolder = new File(Utilities.getPath() + "/Result");

        extent.flush();
        // Copy report to target directory for CI
        File source = new File(resultPath + "/CustomReport.html");
        if (dest.exists()) {
            try {
                FileUtils.cleanDirectory(dest);
            } catch (Exception e) {

            }
        }

        File ExtentReportsource = new File(resultPath);
        File ExtentReportDest = new File(Utilities.getPath() + "/target/ExtentReports/");
        if (ExtentReportDest.exists()) {
            ExtentReportDest.deleteOnExit();
        }
        if (!(ExtentReportDest.exists())) {
            ExtentReportDest.mkdir();
            direExists = true;
            if (direExists == true) {

                try {
                    FileUtils.copyDirectory(ExtentReportsource, ExtentReportDest);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        String timeStamp = getFormattedTimeStamp().replace("-", "").replace(":", "").replace(".", "").replaceAll(" ",
                "");
        String sourcePath = Utilities.getPath() + "/target/";
        String archivedReportFolder = "/ArchiveReports";
        String archivedReportPath = "/ArchiveReports/ArchivedReports_" + timeStamp;

        File finalReportDest = new File(Utilities.getPath() + archivedReportPath);
        File archiveReportFolder = new File(Utilities.getPath() + archivedReportFolder);
        File sourceDir = new File(sourcePath + "/surefire/");
        try {
            FileUtils.deleteDirectory(sourceDir);
        } catch (Exception e) {

        }

        if (archiveReportFolder.exists())
            try {
                FileUtils.cleanDirectory(archiveReportFolder);
            } catch (Exception e) {

            }

        if (!(finalReportDest.exists())) {
            finalReportDest.mkdirs();
            direExists = true;
            String zipFilePath = Utilities.getPath() + archivedReportPath;
            if (direExists == true) {
                try {
                    zipDir(sourcePath, zipFilePath + "/Combined_Reports.zip");

                } catch (IOException e2) {

                }
            }

            // Copy Archive Reports on Desktop
            File reportPath_Dekstop = new File(System.getProperty("user.home") + "/Desktop/ArchiveReports/ConsentNow/");
            if (!(reportPath_Dekstop.exists())) {
                reportPath_Dekstop.mkdirs();
            }
            try {
                FileUtils.copyDirectory(archiveReportFolder, reportPath_Dekstop);

            } catch (IOException e2) {

            }

        }
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    /**
     * Get All windows open in UI
     *
     * @throws InterruptedException
     * @return: Parent window name
     */
    public List<String> getAllWindowsOpenInUI() throws InterruptedException {
        Thread.sleep(2000);
        List<String> WinList = new ArrayList<>();
        Set<String> windows = getWebDriver().getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        for (int i = 0; i <= windows.size() - 1; i++) {
            String win = iterator.next();
            WinList.add(win);
        }
        return WinList;
    }

    /**
     * Handle child windows
     *
     * @throws InterruptedException
     * @return: Parent window name
     */
    public String switchToChildWindow() throws InterruptedException {
//        Thread.sleep(2000);
        Set<String> windows = getWebDriver().getWindowHandles();

        Iterator<String> iterator = windows.iterator();
        String parent = iterator.next();
        String child = iterator.next();
        getWebDriver().switchTo().window(child);
        return parent;
    }

    /**
     * close child window
     */
    public void switchParentWindowByClosingChild(String Win) {
        getWebDriver().close();
        getWebDriver().switchTo().window(Win);
    }

    /* Close Driver */
    public void closeChildWindow() {
        driver.close();
    }

    /**
     * Switch To window
     *
     * @throws InterruptedException
     */
    public void switchToWindow(String Win) throws InterruptedException {
        //Thread.sleep(2000);
        getWebDriver().switchTo().window(Win);
    }

    /**
     * Get absolute path
     *
     * @return: Absolute path
     */
    public String getPathUpload() {
        String path;
        File file = new File("");
        String absolutePathOfFirstFile = file.getAbsolutePath();
        path = absolutePathOfFirstFile.replaceAll("/", "//");
        return path;
    }

    /**
     * Capturing screenshot once script is failed
     *
     * @return
     * @throws IOException
     * @throws MalformedURLException
     * @throws BadElementException
     */
    public Image captureScreenshot(ITestResult result) throws BadElementException, MalformedURLException, IOException {
        String fileName = System.getProperty("className");
        String screen = "";
        try {
            String screenshotName = Utilities.getFileName(fileName);
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = resultPath + "/" + fileName;
            new File(path).mkdirs();
            screen = path + "/" + "Failed_" + screenshotName + "_" + browserType + ".png";
            File screenshotLocation = new File(screen);
            FileUtils.copyFile(screenshot, screenshotLocation);
            Thread.sleep(1500);
            InputStream is = new FileInputStream(screenshotLocation);
            byte[] imageBytes = IOUtils.toByteArray(is);
            Thread.sleep(2000);
            String base64 = Base64.getEncoder().encodeToString(imageBytes);

            if (result.getStatus() == ITestResult.FAILURE) {

                getTest().log(LogStatus.FAIL, "Failed_" + fileName + " \n Snapshot below: "
                        + getTest().addBase64ScreenShot("data:image/png;base64," + base64));
                getTest().addScreenCapture(screen);
            }
            if (result.getStatus() == ITestResult.SKIP) {
                getTest().log(LogStatus.SKIP, "Skipped_" + fileName + " \n Snapshot below: "
                        + getTest().addBase64ScreenShot("data:image/png;base64," + base64));
                getTest().addScreenCapture(screen);
            }
            if (!(result.getStatus() == (ITestResult.SUCCESS) || result.getStatus() == (ITestResult.FAILURE))) {
                getTest().log(LogStatus.SKIP, "Skipped_" + fileName + " \n Snapshot below: "
                        + getTest().addBase64ScreenShot("data:image/png;base64," + base64));
                getTest().addScreenCapture(screen);
            }

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return Image.getInstance(screen);
    }

    /**
     * Report logs
     *
     * @param : message
     * @throws DocumentException
     * @throws IOException
     * @throws MalformedURLException
     * @throws BadElementException
     */
    public void reportLog(String msg) {
        message = msg;

        getTest().log(LogStatus.PASS, message);

        message = BREAK_LINE + message;

        logger.info(" || Browser: " + browserType + " || Message: " + message + BREAK_LINE);
        Reporter.log(message);
    }

    /**
     * Capturing image with hilighting the locators
     *
     */

    /**
     * function : Fetch the System's current date with time
     */
    public String getTimeStamp() {
        Date date = new Date();
        return new Timestamp(date.getTime()).toString().replace(" ", "");
    }

    /**
     * @return
     * @function: Get formatted Time stamp
     */
    public String getFormattedTimeStamp() {

        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-uuuu HH:mm:ss");
        String formatDateTime = currentTime.format(formatter);
        return formatDateTime;

    }

    /**
     * Function: Get current date.
     *
     * @return
     */
    public String currentDate() {
        final DateFormat format = new SimpleDateFormat("dd-MMM-YYYY");
        Date date = new Date();
        final String currentDate = format.format(date);
        return currentDate;
    }

    /**
     * Generate AlphanumericString of length
     */
    public String generateRandomAlphanumericString(int lenthOfString) {
        String generatedString = RandomStringUtils.randomAlphanumeric(lenthOfString);
        return generatedString;
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
     * Compressing Reports folder in a compressed Zip file for archiving reports
     */

    public void zipDir(String dirName, String nameZipFile) throws IOException {
        ZipOutputStream zip = null;
        FileOutputStream fW = null;
        fW = new FileOutputStream(nameZipFile);
        zip = new ZipOutputStream(fW);
        addFolderToZip("", dirName, zip);
        zip.close();
        fW.close();
    }

    public void addFolderToZip(String path, String srcFolder, ZipOutputStream zip) throws IOException {
        File folder = new File(srcFolder);
        if (folder.list().length == 0) {
            addFileToZip(path, srcFolder, zip, true);
        } else {
            for (String fileName : folder.list()) {
                if (path.equals("")) {
                    addFileToZip(folder.getName(), srcFolder + "/" + fileName, zip, false);
                } else {
                    addFileToZip(path + "/" + folder.getName(), srcFolder + "/" + fileName, zip, false);
                }
            }
        }
    }

    /**
     * Get Past week start and end dates
     */
    public ArrayList<String> pastWeekStartAndEndDates() {
        ArrayList<String> listToBeVerified = new ArrayList<>();
        ZoneId US = ZoneId.of("America/New_York");
        final ZonedDateTime input = ZonedDateTime.now(US);
        final ZonedDateTime startOfLastWeek = input.minusWeeks(1).with(DayOfWeek.MONDAY);
        listToBeVerified.add(DateTimeFormatter.ofPattern("dd-MMM-yyyy").format(startOfLastWeek));
        final ZonedDateTime endOfLastWeek = startOfLastWeek.plusDays(6);
        listToBeVerified.add(DateTimeFormatter.ofPattern("dd-MMM-yyyy").format(endOfLastWeek));
        return listToBeVerified;
    }

    @SuppressWarnings("resource")
    public void addFileToZip(String path, String srcFile, ZipOutputStream zip, boolean flag) throws IOException {
        File folder = new File(srcFile);
        if (flag) {
            zip.putNextEntry(new ZipEntry(path + "/" + folder.getName() + "/"));
        } else {
            if (folder.isDirectory()) {
                addFolderToZip(path, srcFile, zip);
            } else {
                byte[] buf = new byte[1024];
                int len;
                FileInputStream in = new FileInputStream(srcFile);
                zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
                while ((len = in.read(buf)) > 0) {
                    zip.write(buf, 0, len);
                }
            }
        }
    }

    /**
     * Updating test data and get newly updated data from properties files.
     */
    public String updateAndReturnNewValueInPropertiesFile(String keyName, String keyValue) throws Exception {
        String RegressionTestDataFile = null;
        if (setEnvironment.equals("test")) {
            RegressionTestDataFile = "RegressionTestData_TestEnv";
        } else if (setEnvironment.equals("stg")) {
            RegressionTestDataFile = "RegressionTestData_STGEnv";
        }
        Properties properties = Configuration.readTestData(RegressionTestDataFile);
        Configuration.updatePropertyTestData(RegressionTestDataFile, keyName, keyValue);
        String NewKeyValue = properties.getProperty(keyName);
        return NewKeyValue;
    }

    public void switchToWindowWithBrowser(String ChromeWin) throws Exception {
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = cap.getBrowserName().toLowerCase();
        if (browserName.toString().toLowerCase().equalsIgnoreCase("firefox")) {
            switchToWindow(ChromeWin);

        } else {
            if (browserName.toString().toLowerCase().equalsIgnoreCase("chrome")) {
                switchToWindow(ChromeWin);
            }
        }

    }


    /**
     * Navigate to URl Through the target environment declared
     *
     * @throws Exception
     */

    public void navigateToUrl() throws Exception {
        targetEnvironment = Configuration.readApplicationFile("targetEnv");
        String Url = driver.getCurrentUrl();
        if (Url.contains("alpha")) {
            String ChangeUrl = Url.replace("alpha", targetEnvironment);

            driver.get(ChangeUrl);

        }
    }

    public String getCurrentWindowHandle() throws InterruptedException {
        Thread.sleep(2000);
        return driver.getWindowHandle();
    }



}
	
