package MRCS.DynamicSuiteRunner;

import MRCS.Utils.DynamicSuiteGenerator;
import org.testng.TestNG;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SuiteRunner {
    @Test
    public void run_test_suite() throws Exception {
        DynamicSuiteGenerator.GenerateSuite();
        TestNG testNG = new TestNG();
        String xmlpath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "suite-xml-files" + File.separator + "MRCS Test Suite.xml";
        List<String> xmlSuite = new ArrayList<>();
        xmlSuite.add(xmlpath);
        System.out.printf("Going to run test suite");
        testNG.setTestSuites(xmlSuite);
        testNG.run();
        System.out.println("Test Suite Ended");
    }
}//End Class
