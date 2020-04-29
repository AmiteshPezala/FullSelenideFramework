package MRCS.Utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import MRCS.Start.Start;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class ReportUtil {

    static Map extentTestMap = new HashMap();
    static ExtentReports extent = ExtentManager.getReporter();
    public static Set<String> started_tests = new HashSet<>();

    public static synchronized ExtentTest getTest() {
        return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }

    public static synchronized void endTest() {
        extent.endTest((ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId())));
        extent.flush();
    }

    public static synchronized ExtentTest startTest(String testName) {
        return startTest(testName, "");
    }

    public static synchronized ExtentTest startTest(String testName, String desc) {
        //Keep track of all the tests that are executed
        ExtentTest test = extent.startTest(testName, desc);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }

    public static synchronized ExtentTest startTest(String testName, String desc, String[] category) {
        String str_test=testName.replaceAll("_Test","").replaceAll("_","-");
        started_tests.add(str_test);
        ExtentTest test = extent.startTest(str_test, desc);
        for (String c : category) {
            test.assignCategory(c);
        }
        test.assignCategory(Start.currentBrowser);

        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }

    public static synchronized ExtentTest startTestForCoverage(String testName, String desc, String[] category) {
        String str_test=testName.replaceAll("_Test","").replaceAll("_","-");
        ExtentTest test = extent.startTest(str_test, desc);
        for (String c : category) {
            test.assignCategory(c);
        }
        test.assignCategory(Start.currentBrowser);

        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }

    public static synchronized ExtentTest addTest(ExtentTest test) {
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }

}
