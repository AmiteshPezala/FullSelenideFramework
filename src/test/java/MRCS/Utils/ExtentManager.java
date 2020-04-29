package MRCS.Utils;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @author smartData
 * <h1>Reporting module</h1>
 * <p>Purpose: This class is part of ExtentManager Report </p>
 * It is used to manage ExtentManager Report
 */

public class ExtentManager {

    static ExtentReports extent;

    public synchronized static ExtentReports getReporter() {
        String FS = File.separator;
        String reportFileName=Common.GetProjectNameFromMavenPOM();
        String pattern = "MM-dd-yyyy"+"_"+"HH-mm-ss";
        String simpleDateFormat = new SimpleDateFormat(pattern).format(new Date());
        reportFileName+="_"+simpleDateFormat+"_TestReport.html";
        String filePath = System.getProperty("user.dir") + FS+"ExecutionReports"+FS+"HtmlReport"+FS+reportFileName;
        String configFilePath = "src" + FS + "main" + FS + "resources" + FS + "config.xml";
        if (extent == null) {
            //extent = new ExtentReports(filePath, false, DisplayOrder.NEWEST_FIRST);
            extent = new ExtentReports(filePath, true, DisplayOrder.NEWEST_FIRST);
            extent.loadConfig(new File(configFilePath));
        }

        return extent;
    }

}