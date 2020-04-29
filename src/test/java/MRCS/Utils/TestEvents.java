package MRCS.Utils;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static MRCS.Utils.Common.CaptureScreenForReport_Base64;
import static MRCS.Utils.Common.GetUserData;

public class TestEvents implements ITestListener {
    @Override
    public void onFinish(ITestContext arg0) {

    }

    @Override
    public void onStart(ITestContext arg0) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ReportUtil.getTest().log(LogStatus.FAIL, result.getThrowable());
        String testClassName = result.getTestClass().getRealClass().getSimpleName();
        Log.info("Test Case Failed: " + testClassName);
        if (GetUserData("EnableScreenShot").equalsIgnoreCase("Yes"))
            ReportUtil.getTest().log(LogStatus.INFO, "Test Case Failed Screenshot" + ReportUtil.getTest().addBase64ScreenShot("data:image/png;base64," + CaptureScreenForReport_Base64()));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String testClassName = result.getTestClass().getRealClass().getSimpleName();
        testClassName = testClassName + "." + result.getMethod().getMethodName();
        Log.info("Test Case Skipped: " + testClassName);
        Log.info("Summary: " + result.getMethod().getDescription());
        ReportUtil.startTest(testClassName, result.getMethod().getDescription(), result.getMethod().getGroups());
        ReportUtil.getTest().log(LogStatus.INFO, "Test Case Skipped ");
        ReportUtil.getTest().log(LogStatus.SKIP, "Skipped reason ->" + result.getThrowable());
        ExtentManager.getReporter().endTest(ReportUtil.getTest());
        ExtentManager.getReporter().flush();
    }

    @Override
    public void onTestStart(ITestResult test) {
        String testClassName = test.getTestClass().getRealClass().getSimpleName();
        testClassName = testClassName + "." + test.getMethod().getMethodName();
        Log.info("Test Case Started: " + testClassName);
        Log.info("Summary: " + test.getMethod().getDescription());
        ReportUtil.startTest(testClassName, test.getMethod().getDescription(), test.getMethod().getGroups());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log.info("Test Case Passed - " + result.getTestClass().getRealClass().getSimpleName());
        ReportUtil.getTest().log(LogStatus.PASS, "Test Case Passed");
    }

}//End class
