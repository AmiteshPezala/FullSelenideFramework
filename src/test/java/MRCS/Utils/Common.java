package MRCS.Utils;

import MRCS.Locators.*;
import MRCS.Locators.ClinicalRepo.ClinicalRepo;
import MRCS.Locators.PendRepo.RetrievalPendRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.Clinical;
import com.codeborne.selenide.*;
import MRCS.Start.Start;
import MRCS.Urls.Urls;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

import static MRCS.Utils.WaitTool.waitForElementToBeClickable;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

import static MRCS.Utils.TestBase.*;
import static java.lang.Thread.sleep;

/**
 * @author smartData
 * <h1>Common Functions</h1>
 * <p>Purpose: This class is for common function</p>
 * It is used to handle all the common functionalities which can be used in other classes
 */
public class Common extends Start {

    public static final long DEFAULT_WAIT = 90000;
    public static final long DEFAULT_IMPLICIT_WAIT_IN_SEC = 120;
    /**
     * <h1>Search Trading partner <h1/>
     * <p>Purpose:This method is used for browser initialization</p>
     */
    public static void Init() throws Exception {
        InitilizeBrowser();
    }

    /**
     * <h1>Login User <h1/>
     * <p>Purpose:This method is used for login to application</p>
     *
     * @param UserName,Password
     * @throws Exception
     */

    public static void LoginUser(String UserName, String Password) throws Exception {
        Log.info("Start Log in to application");
        Log.info("Enter user name");
        FindAnElement(LoginOutRepo.TxtUsername).sendKeys(UserName);
        //ClearAndSendKeys(LoginOutRepo.txtUsername,UserName,"Enter user name");
        Log.info("Enter password");
        FindAnElement(LoginOutRepo.TxtPassword).sendKeys(Password);
        //ClearAndSendKeys(LoginOutRepo.txtPassword, Password,"Enter password");
        $x("//span[contains(text(),'LOGIN')]").waitUntil(Condition.visible,DEFAULT_WAIT).click();
        //ClickElement(By.id("Login"), "Login button");
        sleep(2000);
        waitForPageLoadToComplete();
        Log.info("User logged in successfully.");
    }


    /**
     * <h1>Verify Element Exists <h1/>
     * <p>Purpose:This method is used to verify is element exists </p>
     *
     * @param by
     * @throws Exception
     */
    public static boolean IsElementExists(By by) {
        try {
            sleep(2000);
            return $(by).exists();
        } catch (Exception e) {
            return false;
        }
    }
    /** Java Overloading
     * Method with same name and different parameters**/
    public static void ClickElement(By Element, String detail) throws Exception {
        try {
            Log.info("Clicking on:" + detail);
            $(Element)
                    .waitUntil(visible, DEFAULT_WAIT)
                    .click();
        } catch (Exception e) {
            Log.error("Error on:" + detail);
            Log.error("There is exception: " + e.getMessage());
            throw e;
        }
    }

    /**
     * <h1>Click on Element <h1/>
     * <p>Purpose:This method is used to perform click functionality </p>
     *
     * @param Element,detail
     * @throws Exception
     */

    public static void ClickElement(WebElement Element, String detail) {
        try {
            Log.info("Clicking on:" + detail);
            $(Element)
                    .waitUntil(appear, DEFAULT_WAIT)
                    .click();
        } catch (Exception e) {
            Log.error("There is an exception: " + e.toString());
        }
    }

    /**
     * <h1>Find All Elements<h1/>
     * <p>Purpose:This method is used to get all web elements </p>
     *
     * @param Element,timeOutInSeconds
     * @throws Exception
     */

    public static List<WebElement> FindAllElements(By Element) throws Exception {
        List<WebElement> TempElement = null;
        try {
            WaitTool.waitForElementsPresentAndDisplay(Element);
            TempElement = WebDriverRunner.getWebDriver().findElements(Element);
            return TempElement;
        } catch (Exception e) {
            Log.error("There is exception: " + e.toString());
            throw e;
        }
    }

    /**
     * <h1>Find Elements By ExactText<h1/>
     * <p>Purpose:This method is used to find element by exacts text (String text) </p>
     *
     * @param text
     */

    public static WebElement FindAnElementByExactText(String text) {
        return $(byText(text)).waitUntil(appear, DEFAULT_WAIT).getWrappedElement();
    }

    public static WebElement FindAnElementByTextContains(String text) {
        return $(withText(text)).waitUntil(appear, DEFAULT_WAIT).getWrappedElement();
    }


    public static void HighlightElement(By by) {
        WebElement elm = $(by).getWrappedElement();
        // draw a border around the found element
        executeJavaScript("arguments[0].style.backgroundColor='#80ff80'", elm);
    }

    public static void HighlightElement(ElementsCollection elm) {
        // draw a border around the found element
        executeJavaScript("arguments[0].style.backgroundColor='#80ff80'", elm);
    }

    public static WebElement FindAnElement(By Element) {
        WebElement TempElement = null;
        try {
            TempElement = $(Element)
                    .waitUntil(appear, DEFAULT_WAIT).getWrappedElement();
        } catch (Exception e) {
            Log.error("There is an exception: " + e.toString());
            throw e;
        }
        return TempElement;
    }

    //Clear and Send Keys
    /** Java Overloading
     * Method with same name and different parameters**/
    public static void ClearAndSendKeys(WebElement Element, String KeysToSend, String Detail) throws Exception {
        try {
            Log.info("Input " + Detail);
            WebElement inputElement=$(Element)
                    .waitUntil(appear, DEFAULT_WAIT)
                    .waitUntil(enabled, DEFAULT_WAIT).getWrappedElement();
            inputElement.clear();
            inputElement.sendKeys(KeysToSend);
        } catch (Exception e) {
            Log.error("Error in setting a text value: " + e.toString());
            throw e;
        }
    }
    public static void ClearAndSendKeys(By Element, String KeysToSend, String Detail) throws Exception {
        try {
            Log.info("Input " + Detail);
            WebElement inputElement=$(Element)
                    .waitUntil(appear, DEFAULT_WAIT)
                    .waitUntil(enabled, DEFAULT_WAIT).getWrappedElement();
            inputElement.clear();
            inputElement.sendKeys(KeysToSend);
        } catch (Exception e) {
            Log.error("Error in setting a text value: " + e.toString());
            throw e;
        }
    }
    //TBD
    public static void ClickLink(String LinkToClick) {
        $(byLinkText(LinkToClick)).waitUntil(appear, DEFAULT_WAIT).click();
    }

    public static void ClickArrowIcon(By ArrowToClick) {
        try {
            WaitTool.waitForElementsPresentAndDisplay(ArrowToClick);
            List<WebElement> ArrowToOpenMenu = Common.FindAllElements(ArrowToClick);

            if (ArrowToOpenMenu.size() > 0) {
                if (ArrowToOpenMenu.size() > 1) {
                    ClickElement(ArrowToOpenMenu.get(1), "Arrow to open menu");
                } else {
                    ClickElement(ArrowToOpenMenu.get(0), "Arrow to open menu");
                }
            }
        } catch (Exception e) {
            Log.error("Error in ClickArrowIcon: " + e.toString());
        }
    }

    public static void SelectDropdownText(By Dropdown, String TextToSelect) {
        try {
            WaitTool.waitForElementPresentAndDisplay(Dropdown);
            Select drpToSelectFrom = new Select(WebDriverRunner.getWebDriver().findElement(Dropdown));
            drpToSelectFrom.selectByVisibleText(TextToSelect);
        } catch (Exception e) {
            Log.error("There is an exception: " + e.toString());
        }
    }
    public static void SelectDropdownValue(By Dropdown, String Value) {
        try {
            WaitTool.waitForElementPresentAndDisplay(Dropdown);
            Select drpToSelectFrom = new Select(WebDriverRunner.getWebDriver().findElement(Dropdown));
            drpToSelectFrom.selectByValue(Value);
        } catch (Exception e) {
            Log.error("There is an exception: " + e.toString());
        }
    }
    public static void SelectDropdownIndex(By Dropdown, int Index) {
        try {
            WaitTool.waitForElementPresentAndDisplay(Dropdown);
            Select drpToSelectFrom = new Select(WebDriverRunner.getWebDriver().findElement(Dropdown));
            drpToSelectFrom.selectByIndex(Index);
        } catch (Exception e) {
            Log.error("There is an exception: " + e.toString());
        }
    }
    public static void SelectDropdownText(WebElement Dropdown, String TextToSelect) {
        try {
            Select drpToSelectFrom = new Select(Dropdown);
            drpToSelectFrom.selectByVisibleText(TextToSelect);
        } catch (Exception e) {
            Log.error("There is an exception: " + e.toString());
        }
    }

    //TBD
    public static void SwitchToDefaultContent(int Interval) {
        try {
            System.out.println("Switching default");
            WebDriverRunner.getWebDriver().switchTo().defaultContent();
            Thread.sleep(Interval);
        } catch (Exception e) {
            Log.error("There is an exception: " + e.toString());
        }
    }

    public static void RefreshPage(int Interval) {
        try {
            Thread.sleep(6000);
            WebDriverRunner.getWebDriver().navigate().refresh();
            Thread.sleep(Interval);
        } catch (Exception e) {
            Log.error("There is an exception: " + e.toString());
        }
    }

    /**
     * <h1>Close Browser <h1/>
     * <p>Purpose:This method is used for close open browser after test executions</p>
     *
     * @throws Exception
     */
    public static void closeBrowser() {
        try {
            if (WebDriverRunner.getWebDriver() != null) {
                WebDriverRunner.getWebDriver().quit();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void assertText(By Element, String ExpectedText) {
        String actual = $(Element).waitUntil(appear, DEFAULT_WAIT).getText().trim();
        String message = "|Expected Text: " + ExpectedText + "| |Actual Text: " + actual + "|";
        String html = "<span style='color:blue;'>" + message + " </span>";
        TestBase.logTestStep(html);
        Assert.assertEquals(actual.toUpperCase(), ExpectedText.toUpperCase().trim());
    }

    public static void assertText(String actualText, String ExpectedText) {
        String message = "|Expected Text: " + ExpectedText + "| |Actual Text: " + actualText + "|";
        String html = "<span style='color:blue;'>" + message + " </span>";
        TestBase.logTestStep(html);
        Assert.assertEquals(actualText.toUpperCase(), ExpectedText.toUpperCase().trim());
    }

    public static boolean checkExistenceOfElement(By Element) {
        boolean elementStatus = false;
        try {
            WaitTool.waitForElementPresentAndDisplay(Element);
            elementStatus = WebDriverRunner.getWebDriver().findElements(Element).size() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return elementStatus;
    }

    /**
     * <h1> Get Text<h1/>
     * <p>Purpose: If null is returned then the comparison fails and execution of fails </p>
     *
     * @param Element,timeOutInSeconds
     * @throws Exception
     */

    public static String getElementText(By Element, int timeOutInSeconds) {
        return $(Element).waitUntil(appear, DEFAULT_WAIT).getText();
    }
    public static String getElementText(WebElement Element, int timeOutInSeconds) {
        return $(Element).waitUntil(appear, DEFAULT_WAIT).getText();
    }

    public static void waitForLoader()
    {
        try {
            $(CommonRepo.Loader)
                    .waitUntil(disappear, DEFAULT_WAIT);

        } catch (Exception e) {
            Log.error("There is an exception: " + e.toString());
        }
    }


    public static void waitForLoaderNew()
    {
        try {
            $(".ui-table-loading-icon")
                    .waitUntil(disappear, DEFAULT_WAIT);

        } catch (Exception e) {
            Log.error("There is an exception: " + e.toString());
        }
    }
    /**
     * <h1>Select Duedate<h1/>
     * <p>Purpose: This method is used for select due date </p>
     *
     * @param element,Interval
     * @throws Exception
     */

    /**
     * <h1>ProjectDirectory<h1/>
     * <p>Purpose: This method is used for get project directory to get the file to upload document in document library </p>
     *
     * @throws Exception
     */

    public static String getProjectDirectory() {
        return System.getProperty("user.dir");
    }

    public static String getFileToUpload(String fileType) {
        String FS = File.separator;
        String filePath = getProjectDirectory() + FS + "src" + FS + "test" + FS + "resources" + FS + "DocumentTypes";

        switch (fileType) {
            case ".txt":
                filePath = filePath + FS + "textDoc.txt";
                break;
            case ".png":
                filePath = filePath + FS + "test.png";
                break;
            default:
                filePath = filePath + FS + "textDoc.txt";
                break;
        }
        return filePath;
    }

    public static void waitForPageLoadToComplete() throws Exception {
        WaitTool.waitForPageLoadToComplete();
    }

    public static void RefreshPage() throws Exception {
        WebDriverRunner.getWebDriver().navigate().refresh();
        WaitTool.waitForPageLoadToComplete();
    }

    /**
     * <h1>Click Element Using JS<h1/>
     * <p>Purpose: This method is used for click on any element using java scripts  </p>
     *
     * @throws Exception
     */

    public static void clickUsingJS(WebElement elm, String detail) throws Exception {
        try {
            Log.info("Click:" + detail);
            executeJavaScript("arguments[0].click();", elm);
        } catch (Exception e) {
            Log.error("Error in ClickUsingJs ");
            Log.error("Exception: " + e.getMessage());
            throw e;
        }
    }

    public static void setFocusUsingJS(WebElement elm) throws Exception {
        executeJavaScript("arguments[0].focus();", elm);
    }

    /**
     * Load all the  Properties File
     *
     * @param propsFilePath PropsFile which
     * @return Properties
     * return the properties loaded from the file .
     * @throws IOException Any IOException thrown , you will need to catch it.
     */
    private static Properties loadProperties(String propsFilePath) throws IOException {
        Properties props = null;
        try (FileInputStream fis = new FileInputStream(propsFilePath)) {
            props = new Properties();
            props.load(fis);
            fis.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return props;
    }//End of loadProperties

    /**
     * <h1>Get Data From Property File<h1/>
     * <p>Purpose: This method is used to get form name from property file  </p>
     *
     * @param key
     * @throws Exception
     */
    public static String GetUserData(String key) {
        String value = "";
        String filePath = "src/test/resources/users.properties";
        try {
            value = (String) loadProperties(filePath).get(key);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return value;
    }

    public static void updateProperties(String filePath, Properties prop) {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            prop.store(fos, "Save data");
        } catch (Exception ex) {
            Log.error("Problem in data Saving ro property file> " + filePath);
            ex.printStackTrace();
        }
    }//End function

    public static String CaptureScreenForReport(String ImagesPath) {
        TakesScreenshot oScn = (TakesScreenshot) WebDriverRunner.getWebDriver();
        File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
        File oDest = new File(ImagesPath + ".jpg");
        try {
            FileUtils.copyFile(oScnShot, oDest);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //Create relative path
        return oDest.getName();
    }

    public static String CaptureScreenForReport_Base64() {
        TakesScreenshot oScn = (TakesScreenshot) WebDriverRunner.getWebDriver();
        return oScn.getScreenshotAs(OutputType.BASE64);
    }

    public static String GetTimeStamp() {
        String timeStamp = new SimpleDateFormat("HHmmss").format(new Date());
        return timeStamp;
    }
    public static String GetCurrentTimeStamp(){
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
        Date date = new Date();
        String Date1 = dateFormat.format(date);
        return Date1;
    }
    public static String GetCurrentDate() {
        String timeStamp = new SimpleDateFormat("M/d/YY").format(new Date());
        return timeStamp;
    }

    public static void executeStep(boolean result, String step) throws Exception {
        if (result) {
            Log.info("Execution of: " + step + "-PASS");
        } else {
            throw new Exception("Execution of: " + step + "-FAILED");
        }

    }

    public static void verifyStep(boolean result, String step) throws Exception {
        if (result) {
            Log.info("Verification of: " + step + "-PASS");
        } else {
            throw new Exception("Verification of: " + step + "-FAILED");
        }

    }

    public static void url() {
        WebDriverRunner.getWebDriver().get(Urls.baseUrl);
    }


    public static void switchToActiveFrame() throws InterruptedException {
        switchTo().defaultContent();
        Log.info("Switching to active frame");
        WebElement element = $(".active.oneContent").$("iframe").waitUntil(appear, DEFAULT_WAIT);
        sleep(2000);
        WebDriverRunner.getWebDriver().switchTo().frame(element);
        Log.info("Switched to active frame successfull");
    }


    public static String GetCurrentUrl() {
        if (WebDriverRunner.getWebDriver() != null) {
            return WebDriverRunner.getWebDriver().getCurrentUrl();
        } else
            return "";
    }

    public static void clickUsingJS(By by) throws Exception {
        try {
            executeJavaScript("arguments[0].click();",$(by).waitUntil(appear,DEFAULT_WAIT).getWrappedElement());
        } catch (Exception e) {
            Log.error("Error in ClickUsingJs ");
            Log.error("Exception: " + e.getMessage());
            throw e;
        }
    }

    /**
     * <h1>Select Due Date<h1/>
     * <p>Purpose:This method is used to select tp compliance due date </p>
     *
     * @param element,element2,element3
     * @throws Exception
     */

    public static void selectDate(By element, By element2, By element3) throws Exception {

        Actions action = new Actions(WebDriverRunner.getWebDriver());
        Thread.sleep(1000);
        WaitTool.isElementPresentAndDisplay(element);
        action.moveToElement(WebDriverRunner.getWebDriver().findElement(element))
                .click(WebDriverRunner.getWebDriver().findElement(element2)).build().perform();
        Thread.sleep(1000);
        Common.ClickElement(element3, "SelectData");
    }

    /**
     * <h1>Click Search Items<h1/>
     * <p>Purpose:This method is used to click on search list(Ex Requests,Workflows etc </p>
     *
     * @param item
     * @throws Exception
     */


    /**
     * <h1>Click Element Using pixel points<h1/>
     * <p>Purpose: This method is used To click element using pixel points  </p>
     *
     * @throws Exception
     */

    public void clickElementPoint(By by) throws Exception {
        waitForElementToBeClickable(by);
        try {
            JavascriptExecutor jse = (JavascriptExecutor) WebDriverRunner.getWebDriver();
            jse.executeScript("window.scrollTo(" + WebDriverRunner.getWebDriver().findElement(by).getLocation().x + ",0)");
            Thread.sleep(1000);
            WebDriverRunner.getWebDriver().findElement(by).click();
        } catch (Exception e) {
            Log.error("Exception thrown: " + e.getMessage());
        }
    }

    /**
     * <h1>Set Focus on Web Element<h1/>
     * <p>Purpose:This method is used to set a focus on web element</p>
     */
    public void setFocus(By by) {
        executeJavaScript("arguments[0].focus();", $(by).getWrappedElement());
    }

    /**
     * <h1>Set Focus on Web Element<h1/>
     * <p>Purpose:This method is used to set a focus on web element</p>
     */
    public void setFocus(WebElement elm) {
        executeJavaScript("arguments[0].focus();", elm);
    }

    public static String GetOSName() {
        return System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
    }

    public static boolean isWindows() {
        return (GetOSName().indexOf("win") >= 0);
    }

    public static boolean isMac() {
        return (GetOSName().indexOf("mac") >= 0);
    }

    public static boolean isUnix() {
        return (GetOSName().indexOf("nix") >= 0 || GetOSName().indexOf("nux") >= 0 || GetOSName().indexOf("aix") > 0);
    }

    public static boolean isLinux() {
        return GetOSName().indexOf("nux") >= 0;
    }

    public static void KillChromeProcessForWindows() {
        if (isWindows()) {
            try {
                for (Integer pid : GetChromeProcessesForWindow()) {
                    Log.info("Kill Chrome Process Id#" +pid);
                    Runtime.getRuntime().exec("taskkill /F /PID " + pid);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }//End method

    public static Set<Integer> GetChromeProcessesForWindow() {
        Set<Integer> winChromeProcess = new HashSet<>();
        String out;
        Process p = null;
        if (Common.isWindows()) {
            try {
                p = Runtime.getRuntime().exec("tasklist /FI \"IMAGENAME eq chromedriver.exe*\"");
                BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
                while ((out = input.readLine()) != null) {
                    String[] items = StringUtils.split(out, " ");
                    if (items.length > 1 && StringUtils.isNumeric(items[1])) {
                        winChromeProcess.add(NumberUtils.toInt(items[1]));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }//End if
        return winChromeProcess;
    }

    public static String GetProjectNameFromMavenPOM(){
        String mavenProjectName="";
        try {
            MavenXpp3Reader reader = new MavenXpp3Reader();
            Model model = reader.read(new FileReader("pom.xml"));
            mavenProjectName=model.getGroupId();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return  mavenProjectName;
    }


    /**
     * <h1>Get Text By Label</h1>
     * <p>
     * This method will return Text based on Label internally it will find first form element that is under Related tab and then return a text
     * </p>
     */


    public static void getDocumentToUpload() throws AWTException {
          Robot robot=new Robot();

        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_V);
        robot.delay(2000);
        robot.keyRelease(KeyEvent.VK_V);
        robot.delay(2000);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(2000);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(2000);
    }
    /** upload document through selenide **/
    public static void UploadDocument()
    {
        logTestStep("Uploading PDF Document");
        File file=new File("./src/test/resources/DocumentTypes/Test.pdf");
        $(RetrievalPendRepo.UploadMR).uploadFile(file);
        Selenide.sleep(2000);
    }
    /** download pdf document **/
    public static void DownloadPdfDocument() throws InterruptedException {
        $(CommonRepo.Loader).waitUntil(Condition.disappear,DEFAULT_WAIT);
        sleep(10000);
        File folder = new File(System.getProperty("user.dir"));
        //We find the download links
        //List the files on that folder
        boolean DownloadingFilePresence = false;
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].getName().endsWith(".pdf")) {
                // File has been found, it can now be deleted:
                DownloadingFilePresence = listOfFiles[i].getName().endsWith(".pdf");
                logInfoStepColored(COLOR.BLUE,listOfFiles[i].getName());
                logTestStepPass("User downloaded document");
                listOfFiles[i].delete();
            }
        }
        Assert.assertTrue(DownloadingFilePresence, "Downloaded document is not found");
    }

    public static void DownloadCsv() throws InterruptedException {
        $(CommonRepo.Loader).waitUntil(Condition.disappear,DEFAULT_WAIT);
        sleep(10000);
        File folder = new File(System.getProperty("user.dir"));
        //We find the download links
        //List the files on that folder
        boolean DownloadingFilePresence = false;
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].getName().endsWith(".csv")) {
                // File has been found, it can now be deleted:
                DownloadingFilePresence = listOfFiles[i].getName().endsWith(".csv");
                logInfoStepColored(COLOR.BLUE,listOfFiles[i].getName());
                logTestStepPass("User downloaded document");
                listOfFiles[i].delete();
            }
        }
        Assert.assertTrue(DownloadingFilePresence, "Downloaded document is not found");
    }


    public static void PopUp() throws Exception {
       // Boolean popup = $x("//div[@class='wm-close-button walkme-x-button']").isDisplayed();
        if($x("//div[@class='wm-close-button walkme-x-button']").isDisplayed())
        {
            //logTestStep("in if loop");
            Common.ClickElement(By.xpath("//div[@class='wm-close-button walkme-x-button']"),"PopUp");
        }
        else {
           Log.info("PopUp not found");
        }
    }
    public static void StopWalkThru(){
       // Boolean StopWalk = $x("//div[@title='Stop Walk-thru']").isDisplayed();
        if($x("//div[@title='Stop Walk-thru']").isDisplayed())
        {
            logTestStep("in if loop");
            $x("//div[@title='Stop Walk-thru']").click();
        }else{
            Log.info("PopUp not found");
        }
    }
    public static void SelectChaseAndOpenChart() throws Exception {
        logTestStep("Clicking on First chase id");
        ClickElement(By.xpath("//tr[1]//td[2]"),"Selecting Chase id");
        logTestStep("Clicking on Chart");
        ClickElement(RetrievalRepo.Chart,"Click on Chart");
        sleep(2000);
        Common.waitForLoader();
        //Common.waitForPageLoadToComplete();
    }
    public static void getUserAndAssignTo() throws Exception {
        Clinical objclinical = new Clinical();
        sleep(5000);
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement($(LoginOutRepo.UatAdmin)).perform();
        sleep(2000);
        ClickElement(By.xpath("//div[@class='menu--item'][contains(.,'My Profile')]"),"My profile");
         Common.waitForLoader();
         sleep(4000);
        String FirstName = $(By.id("firstName")).getValue();
        sleep(1000);
        String LastName = $(By.id("lastName")).getValue();
        sleep(1000);
        String User = FirstName + " " + LastName;
        sleep(2000);
        objclinical.ClinicalLink();
        ClickElement(ClinicalRepo.MRR,"MRR");
        $(CommonRepo.Loader).waitUntil(Condition.disappear,DEFAULT_WAIT);
        waitForPageLoadToComplete();
        ClickElement(ProjectsRepo.Filter,"Filter");
        sleep(2000);
        logTestStep("Clicking on Assigned To link");
        ClickElement($x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Assigned To')]"),"AssignedTo");
        sleep(2000);
        $x("//input[@id='AssignedToUserId']").sendKeys(User);
        sleep(2000);
        $x("//input[@id='AssignedToUserId']").sendKeys(Keys.ARROW_DOWN);
        sleep(2000);
        $x("//input[@id='AssignedToUserId']").sendKeys(Keys.ENTER);
        sleep(2000);
    }

    public  static  String  GetUserName() throws Exception {
        sleep(5000);
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement($(LoginOutRepo.UatAdmin)).perform();
        waitForElementToBeClickable(By.xpath("//div[@class='menu--item'][contains(.,'My Profile')]")).click();
        Common.waitForLoader();
        sleep(4000);
        String FirstName = $(By.cssSelector("#firstName")).getValue();
        sleep(1000);
        System.out.println(FirstName);
        String LastName = $(By.cssSelector("#lastName")).getValue();
        sleep(1000);
        System.out.println(LastName);
        String User = FirstName + " " + LastName;
        System.out.println(User);
        sleep(2000);
        return User;
    }
    public static void selectMeasure() throws Exception {
        Clinical objClinical = new Clinical();
        objClinical.ClinicalLink();
        ClickElement(ClinicalRepo.MRR,"MRR");
        $(CommonRepo.Loader).waitUntil(Condition.disappear,DEFAULT_WAIT);
        waitForPageLoadToComplete();
        waitForElementToBeClickable(ProjectsRepo.Filter).click();
        waitForElementToBeClickable(ProjectsRepo.Measure).click();
    }
    public static WebElement SelectMeasure(String MeasureName) throws Exception {
        WebElement TempElement = null;
        try {
            TempElement = $(byText(MeasureName));
        } catch (Exception e) {
            Log.error("There is an exception: " + e.toString());
            throw e;
        }
        return TempElement;

    }
    public static void ChaseRecord()
    {
        if($(CommonRepo.FirstChaseId).isDisplayed())
        {
            logTestStepPass("Record Found");
        }
        else
        {
            logTestStepFail("No Record Found");
            Assert.fail("No Record Found");
        }
    }
}//End Class



