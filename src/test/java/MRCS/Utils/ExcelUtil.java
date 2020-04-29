package MRCS.Utils;

import MRCS.TestData.GlobalTestData;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import MRCS.Start.Start;
import MRCS.Urls.Urls;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author smartData
 * <h1>Excel Utils</h1>
 * <p>Purpose: This class is used to perform get test data from excel sheet</p>
 * It is used to get the test data which is required to execute test case form excel sheet
 */

public class ExcelUtil {
    static Fillo fillo = new Fillo();

    /**
     * <h1>Get Data form Excel Sheet <h1/>
     * <p>Purpose: This method is used to get test date for execute test cases form excel file after passing
     * module name as sheet name and testId name as testcaseid as parameter
     * </p>
     *
     * @param module,testId
     * @throws Exception
     */
    public synchronized static Recordset GetTestData(String sheet, String module) throws Exception {
        try {
            String FS = File.separator;
            String testDataFilePath = "src" + FS + "test" + FS + "resources" + FS + "TestData" + FS + "TestData.xlsx";
            File f = new File(testDataFilePath);
            Connection connection = fillo.getConnection(f.getAbsolutePath());
            String strQuery = String.format("Select * from %s Where module='%s'", sheet, module);
            Recordset recordset = connection.executeQuery(strQuery);

            connection.close();
            return recordset;
        } catch (FilloException e) {
            Log.info("Error in test data reading");
            //Throw the exception To fail the test
            e.printStackTrace();
            throw new Exception(String.format("Test data not found for Module: '%s' and TestId: '%s'", sheet, module));
        }
    }//End function
    /**
     * <h1>Get Data form Excel Sheet <h1/>
     * <p>Purpose: This method is used to get test date for execute test cases form excel file after passing
     * module name as sheet name and testId name as testcaseid as parameter
     * </p>
     *
     * @param testId
     * @throws Exception
     */


    /**
     * <h1>Get Login Credentials <h1/>
     * <p>Purpose: This method is used to get get username, password
     * form Excel sheet (UserData.xlsx)
     * <p>
     * </p>
     *
     * @param
     * @throws Exception
     */

    public synchronized static void GetUserData() throws Exception {

        try {
            String FS = File.separator;
            String testDataFilePath = "src" + FS + "test" + FS + "resources" + FS + "TestData" + FS + "UserData.xls";
            File f = new File(testDataFilePath);
            Connection connection = fillo.getConnection(f.getAbsolutePath());

            String strQuery = String.format("Select * from Users");
            Recordset recordset = connection.executeQuery(strQuery);
            /*while (recordset.next()) {
                Urls.baseUrl = recordset.getField("UserURL");

                Start.currentBrowser = recordset.getField("Browser");
            }
            recordset.close();

              strQuery = String.format("Select * from Users");
             recordset = connection.executeQuery(strQuery);*/

            while (recordset.next()) {

                if (recordset.getField("UserType").equalsIgnoreCase("Admin")) {
                    //Get data from Excel
                    Urls.baseUrl = recordset.getField("UserURL");

                    Start.currentBrowser = recordset.getField("Browser");
                    GlobalTestData.UserName_Users.setUserId(recordset.getField("UserName"));
                    GlobalTestData.UserName_Users.setPassword(recordset.getField("Password"));
                    GlobalTestData.UserName_Users.setUserURL(recordset.getField("UserURL"));

                }
                if (recordset.getField("UserType").equalsIgnoreCase("Manager")) {
                    Urls.baseUrl = recordset.getField("UserURL");

                    Start.currentBrowser = recordset.getField("Browser");
                    GlobalTestData.Manager_Users.setUserId(recordset.getField("UserName"));
                    GlobalTestData.Manager_Users.setPassword(recordset.getField("Password"));
                    GlobalTestData.Manager_Users.setUserURL(recordset.getField("UserURL"));
                }
                if (recordset.getField("UserType").equalsIgnoreCase("NonAdmin")) {
                    Urls.baseUrl = recordset.getField("UserURL");

                    Start.currentBrowser = recordset.getField("Browser");
                    GlobalTestData.NonAdmin_Users.setUserId(recordset.getField("UserName"));
                    GlobalTestData.NonAdmin_Users.setPassword(recordset.getField("Password"));
                    GlobalTestData.NonAdmin_Users.setUserURL(recordset.getField("UserURL"));
                }
                if (recordset.getField("UserType").equalsIgnoreCase("ThirdPartyEmployee")) {
                    Urls.baseUrl = recordset.getField("UserURL");

                    Start.currentBrowser = recordset.getField("Browser");
                    GlobalTestData.ThirdPartyEmployee_Users.setUserId(recordset.getField("UserName"));
                    GlobalTestData.ThirdPartyEmployee_Users.setPassword(recordset.getField("Password"));
                    GlobalTestData.ThirdPartyEmployee_Users.setUserURL(recordset.getField("UserURL"));
                }if (recordset.getField("UserType").equalsIgnoreCase("NonManager")) {
                    Urls.baseUrl = recordset.getField("UserURL");

                    Start.currentBrowser = recordset.getField("Browser");
                    GlobalTestData.NonManager_Users.setUserId(recordset.getField("UserName"));
                    GlobalTestData.NonManager_Users.setPassword(recordset.getField("Password"));
                    GlobalTestData.NonManager_Users.setUserURL(recordset.getField("UserURL"));
                }
            }
            recordset.close();
            strQuery = String.format("Select * from Users");
            recordset = connection.executeQuery(strQuery);
            recordset.close();
            connection.close();

        } catch (FilloException e) {
            Log.info("Error in user test data reading");
            throw new Exception(String.format("User Test data not found ->" + e.getMessage()));
        }
    }//End of function

    /**
     * <h1>Get Test Suite</h1>
     * <p>Purpose: This method will read the TestSelection excel file and return the enabled modules and tests.
     * </p>
     *
     * @return List<TestConfig>
     * @throws Exception
     */
    public static List<TestConfig> GetTestSuite() throws Exception {
        //Create A TestConfig object to Hold the list that will be returned
        List<TestConfig> lstTestConfig = new ArrayList<>();

        //Map for holding enabled modules
        List<Map<String, String>> lstModules = new ArrayList<>();
        try {
            String FS = File.separator;
            String testDataFilePath = "src" + FS + "test" + FS + "resources" + FS + "SuiteControl" + FS + "TestSelection.xls";
            File f = new File(testDataFilePath);
            Connection connection = fillo.getConnection(f.getAbsolutePath());

            //Get all enabled moduled from Sheet SuiteControl
            String strQuery = String.format("Select * from SuiteControl Where Enable='Yes'");
            Recordset recordset;
            try {
                recordset = connection.executeQuery(strQuery);
                while (recordset.next()) {
                    Map<String, String> module = new HashMap<>();
                    module.put("Module", recordset.getField("Module"));
                    module.put("Parallel", recordset.getField("Parallel"));
                    module.put("ParallelCount", recordset.getField("ParallelCount"));
                    lstModules.add(module);
                }
//            System.out.println("=============================");
//            System.out.println("Total Enabled modules: " +lstModules.size());
//            System.out.println("=============================");
                recordset.close();

            } catch (Exception ex) {
                System.err.println("There is No module enabled to run.");
            }


            //Find enabled test from the Modules
            for (Map<String, String> module : lstModules) {
                //Hold Single Test Configuration
                TestConfig testConfig = new TestConfig();
                testConfig.setModuleName(module.get("Module"));
                testConfig.setParallel(module.get("Parallel"));
                testConfig.setParallelCount(module.get("ParallelCount"));

                //Select all the enabled test from current module
                strQuery = String.format("Select * from %s Where Enable='Yes'", module.get("Module"));
                //List to hold All Enabled test for current module
                List<String> lstTestToRun = new ArrayList<>();
                try {
                    recordset = connection.executeQuery(strQuery);
                    while (recordset.next()) {
                        //System.out.println("|"+recordset.getField("TestID"));
                        lstTestToRun.add(recordset.getField("TestID"));
                    }//End while
                    //Close the recordset
                    recordset.close();
                } catch (Exception ex) {
                }

                //System.out.println(module.get("Module") +" - Total Enabled Test: " +recordset.getCount() );

                //Add Tests list for current module into testConfig object
                testConfig.setTestsList(lstTestToRun);

                //Add Single Test Configuration into List
                lstTestConfig.add(testConfig);


            }//End for
            //Close connection with file
            connection.close();

            //Return List of TestConfig object
            return lstTestConfig;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Test Suite configuration failed");
        }//End catch

    }//End function > GetTestSuite

    public static void UpdateQuery(String filePath, String query) throws FilloException {
        {
            File f = null;
            Connection connection = null;
            try {
                f = new File(filePath);
                connection = fillo.getConnection(f.getAbsolutePath());
                connection.executeUpdate(query);
                System.out.println("Record updated");
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();

            }//End catch
        }
    }//End function

}//End class
