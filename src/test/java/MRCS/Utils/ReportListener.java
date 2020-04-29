package MRCS.Utils;

import org.testng.*;
import org.testng.xml.XmlSuite;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ReportListener implements IReporter {
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> iSuites, String s) {
        int totalFailed=0,totalPassed = 0,totalSkipped=0;
        List<String> passedTestNames =new ArrayList<>();
        List<String> failedTestNames =new ArrayList<>();
        List<String> skippedTestNames =new ArrayList<>();
        Date startDate = null,endDate=null;
        boolean isInit=false;

        System.out.println("==========================START: SUMMARY REPORT==========================");
        long startTime =System.currentTimeMillis();
        for(ISuite suite: iSuites){
            System.out.println("Suite: " +suite.getName());
            Map<String, ISuiteResult> tests = suite.getResults();
            for (ISuiteResult result : tests.values()) {
                ITestContext overview = result.getTestContext();
                totalPassed+=overview.getPassedTests().size();
                totalFailed+=overview.getFailedTests().size();
                totalSkipped+=overview.getSkippedTests().size();
                if(isInit==false){
                    isInit=true;
                    startDate =overview.getStartDate();
                }
                endDate =overview.getEndDate();

                 //Passed Test Detail
                IResultMap passedTestResultMap=overview.getPassedTests();
                for(ITestNGMethod method: passedTestResultMap.getAllMethods()){
                    passedTestNames.add(method.getMethodName());

                }

                //Failed Test Detail
                IResultMap failedTestResultMap=overview.getFailedTests();
                for(ITestNGMethod method: failedTestResultMap.getAllMethods()){
                    failedTestNames.add(method.getMethodName());
                }

                //Failed Test Detail
                IResultMap skippedTestResultMap=overview.getSkippedTests();
                for(ITestNGMethod method: skippedTestResultMap.getAllMethods()){
                    skippedTestNames.add(method.getMethodName());
                }
            }//end for

        }//end for

        long totalTimeMillis= (endDate.getTime()- startDate.getTime());
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Start Date :\t" +startDate);
        System.out.println("End Date   :\t" +endDate);
       // System.out.println("Time Taken :\t"+Common.convertMillisToTime(totalTimeMillis));
        System.out.println("----------------------------------------------------------------------");


        System.out.println("Total Tests  :\t" +(totalPassed+totalFailed+totalSkipped));
        System.out.println("Total Passed :\t" +totalPassed);
        System.out.println("Total Failed :\t" +totalFailed);
        System.out.println("Total Skipped:\t" +totalSkipped);

        System.out.println("List of Passed Tests: " +passedTestNames.toString());
        System.out.println("List of Failed Tests: " +failedTestNames.toString());
        System.out.println("List of Skipped Tests: " +skippedTestNames.toString());

        System.out.println("==========================END: SUMMARY REPORT==========================");
    }
}
