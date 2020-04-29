package MRCS.Utils;

import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DynamicSuiteGenerator {
    public static void GenerateSuite() throws Exception {
        List<TestConfig> lstTestConfig = ExcelUtil.GetTestSuite();
        System.out.println("-----------------------------------------------------------");
        System.out.println("\t TEST SUITE CONFIGURATIONS");
        System.out.println("-----------------------------------------------------------");

        int totalModules =lstTestConfig.size();
        int totalTests=0;

        XmlSuite suite = new XmlSuite();
        suite.setName("MRCS Test Suite");
        suite.addListener("MRCS.Utils.ReportListener");
        List excludeGroup = new ArrayList<String>();
        excludeGroup.add("broken");

        //Add Tests into Suite
        for (TestConfig testConfig : lstTestConfig) {
            System.out.println("Test module details" + testConfig.toString());
            totalTests+=testConfig.getTestsList().size();
            XmlTest test = new XmlTest(suite);
            test.setName(testConfig.getModuleName() + "-Tests");
            test.setPreserveOrder(true);
            test.setExcludedGroups(excludeGroup);
            //If Test is parallel
            if (testConfig.getParallel().equalsIgnoreCase("Yes")) {
                int threadCount = Integer.parseInt(testConfig.getParallelCount());
                if (threadCount > 0) {
                    test.setParallel(XmlSuite.ParallelMode.CLASSES);
                    test.setThreadCount(Integer.parseInt(testConfig.getParallelCount()));
                }

            }
            //Set XmlClasses
            test.setXmlClasses(FilterXmlClasse(testConfig.getModuleName(), testConfig.getTestsList()));
        }

        System.out.println("\n-----------------------------------------------------------------------------------------------------------");
        System.out.println("\t\tTotal Enabled Modules # " +totalModules);
        System.out.println("\t\tTotal Enabled Tests   # " +totalTests);
        System.out.println("============================================================================================================\n");
        writeSuiteToFile(suite);
    }//End of function > GenerateSuite


    //Filter Xml Class based on Module and enabled test names
    private static List<XmlClass> FilterXmlClasse(String moduleName, List<String> tetsIds) {
        String packageName = "MRCS.Tests."+moduleName;
        List<XmlClass> xmlClasses = new ArrayList<XmlClass>();
        for (String testName : tetsIds) {
            String strClass = packageName + "." + testName;
            XmlClass xmlClass = new XmlClass(strClass);
            //Add current xml class to list
            xmlClasses.add(xmlClass);

        }
        return xmlClasses;
    }

    //Write Xml Suite to File
    private static void writeSuiteToFile(XmlSuite suite) {
        String xmlpath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "suite-xml-files" + File.separator + "MRCS Test Suite.xml";
        File f = new File(xmlpath);
        FileWriter fr = null;
        try {
            fr = new FileWriter(f);
            fr.write(suite.toXml().toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //close resources
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }//End finally
    }//End> writeSuiteToFile


    public static void removeOldXmlFiles(){
        try {
            File file = new File("src/test/resources/dynamic_suites_xml_files");
            //Delete all old files
            for (File delFile:file.listFiles()){
                if(delFile.isFile()){
                    if(delFile.getName().endsWith(".xml")){
                        delFile.delete();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Write Xml Suite to File
    private static void writeMultipleSuiteToFile(XmlSuite suite) {
        File file = new File("src/test/resources/dynamic_suites_xml_files");
        int count=file.listFiles().length+1;
        String xmlpath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "dynamic_suites_xml_files" + File.separator + "MRCS Test Suite"+count+".xml";
        System.out.println("Writing suite to file >"+xmlpath);
        File f = new File(xmlpath);
        FileWriter fr = null;
        try {
            fr = new FileWriter(f);
            fr.write(suite.toXml().toString());
            System.out.println("Xml Suite File written successfully  > "+xmlpath);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //close resources
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }//End finally
    }//End> writeSuiteToFile


    public static List<File> getSuiteXmlFiles(){
        List<File> xmlFiles= new ArrayList<>();
        try {
            File file = new File("src/test/resources/dynamic_suites_xml_files");
            //Delete all old files
            for (File xmlFile:file.listFiles()){
                if(xmlFile.isFile()){
                    if(xmlFile.getName().endsWith(".xml")){
                        xmlFiles.add(xmlFile);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xmlFiles;
    }


    public static void GenerateSuite(List<TestConfig> lstTestConfig) throws Exception {
        System.out.println("-----------------------------------------------------------");
        System.out.println("\t TEST SUITE CONFIGURATIONS");
        System.out.println("-----------------------------------------------------------");

        int totalModules =lstTestConfig.size();
        int totalTests=0;

        XmlSuite suite = new XmlSuite();
        suite.setName("MRCS Test Suite");
        suite.addListener("MRCS.Utils.ReportListener");
        List excludeGroup = new ArrayList<String>();
        excludeGroup.add("broken");

        //Add Tests into Suite
        for (TestConfig testConfig : lstTestConfig) {
            System.out.println("Test module details" + testConfig.toString());
            totalTests+=testConfig.getTestsList().size();
            XmlTest test = new XmlTest(suite);
            test.setName(testConfig.getModuleName() + "-Tests");
            test.setPreserveOrder(true);
            test.setExcludedGroups(excludeGroup);
            //If Test is parallel
            if (testConfig.getParallel().equalsIgnoreCase("Yes")) {
                int threadCount = Integer.parseInt(testConfig.getParallelCount());
                if (threadCount > 0) {
                    test.setParallel(XmlSuite.ParallelMode.CLASSES);
                    test.setThreadCount(Integer.parseInt(testConfig.getParallelCount()));
                }

            }
            //Set XmlClasses
            test.setXmlClasses(FilterXmlClasse(testConfig.getModuleName(), testConfig.getTestsList()));
        }

        System.out.println("\n-----------------------------------------------------------------------------------------------------------");
        System.out.println("\t\tTotal Enabled Modules # " +totalModules);
        System.out.println("\t\tTotal Enabled Tests   # " +totalTests);
        System.out.println("============================================================================================================\n");
        writeMultipleSuiteToFile(suite);
    }//End of function > GenerateSuite
}//End Class

