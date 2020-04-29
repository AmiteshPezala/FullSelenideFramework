package MRCS.Utils;

import com.relevantcodes.extentreports.LogStatus;
import MRCS.TestData.UserData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.*;

import static MRCS.Utils.Common.GetUserData;
import static MRCS.Utils.ReportUtil.getTest;

@Listeners({TestEvents.class, SuiteEvents.class})

public class TestBase {

    public static String ProductJson;
    //public static Date d = new Date(System.currentTimeMillis());
    UserData UsrData;

    public static enum COLOR {
        RED("red"), GREEN("green"), BLUE("blue"), PURPLE("purple"), ORANGE("OrangeRed"), MAGENTA("Magenta");
        private String value;

        private COLOR(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }//end enm

    private static Logger log = LogManager.getLogger(TestBase.class);

    /**
     * <h1>Log test step info in html report</h1>
     *
     * @param step
     */
    public static void logTestStep(String step) {
        log.info(step);
        ReportUtil.getTest().log(LogStatus.INFO, step);
    }

    public static void logTestStep_ColorRed(String step) {
        log.info(step);
        String html = "<span style='color:red;'>" + step + "</span>";
        ReportUtil.getTest().log(LogStatus.INFO, html);
    }

    public static void logTestStep_ColorGreen(String step) {
        log.info(step);
        String html = "<span style='color:green;'>" + step + "</span>";
        ReportUtil.getTest().log(LogStatus.INFO, html);
    }

    /**
     * <h1>Log test step pass or fail with soft assert</h1>
     * <p>Purpose: This method will log pass or fail in html report. But will not stop test execution.
     * But overall result will be fail</p>
     *
     * @param step
     */
    public static void logStepWithSoftAssert(boolean result, String step) {
        if (result) {
            logTestStepPass(step);
        } else {
            logTestStepFail(step);
        }
    }

    public static void logInfoStepColored(COLOR color, String message) {
        Log.info(message);
        String html = String.format("<span style='color:%s;'>%s</span>", color.getValue(), message);
        getTest().log(LogStatus.INFO, html);
    }


    public static boolean logStepWithSoftAssertForTextVerification(String fieldName, String expectedText, String actualText) {
        String message = String.format("Verify field <b>'%s'</b> value should be '%s' | Actual value found '%s' ", fieldName, expectedText, actualText);
        boolean result = expectedText.equalsIgnoreCase(actualText);
        TestBase.logStepWithSoftAssert(result, message);
        return result;
    }

    /**
     * <h1>Log test step pass in html report</h1>
     *
     * @param step
     */
    public static void logTestStepPass(String step) {
        log.info("Test Step PASS - " + step);
        String PassLabel = "<span style='border:1px solid green;border-radius: 5px; padding:1px;background:green;color:white;margin-right:2px;'>PASS</span>";
        String html = PassLabel + "<span style='color:green;'>" + step + "</span>";
        ReportUtil.getTest().log(LogStatus.PASS, html);
    }

    /**
     * <h1>Log test step fail in html report</h1>
     *
     * @param step
     */

    public static void logTestStepFail(String step) {
        log.info("Test Step FAIL - " + step);
        String FailLabel = "<span style='border:1px solid red;border-radius: 5px; padding:1px;background:red;color:white;margin-right:2px;'>FAIL</span>";
        String html = FailLabel + "<span style='color:red;'>" + step + "</span>";
        ReportUtil.getTest().log(LogStatus.FAIL, html);
    }

    /**
     * <h1>Log test step pass/fail in html report</h1>
     *
     * @param result,step
     * @throws Exception
     */

    public static void logTestStepPassOrFail(boolean result, String step) throws Exception {
        if (result) {
            logTestStepPass(step);
        } else {
            logTestStepFail(step);
            throw new TestStepFailException(step);
        }
    }//End- Log Step

    public static void logScreenshot(String name) {
        ReportUtil.getTest().log(LogStatus.INFO, name);

        if (GetUserData("EnableScreenShot").equalsIgnoreCase("Yes"))
            ReportUtil.getTest().log(LogStatus.INFO, "Informative screenshot" + ReportUtil.getTest().addBase64ScreenShot("data:image/png;base64," + Common.CaptureScreenForReport_Base64()));
    }

       @AfterClass
    public void close() {
        //Common.LogoutUser();
        Common.closeBrowser();
        ProductJson=null;
 }

    //Html Repoting
    @AfterMethod
    protected void afterMethod(ITestResult result) {
        ExtentManager.getReporter().endTest(ReportUtil.getTest());
        ExtentManager.getReporter().flush();

    }

    @BeforeClass
    public void beforeClass() throws Exception {
        Common.Init();
    }
}
