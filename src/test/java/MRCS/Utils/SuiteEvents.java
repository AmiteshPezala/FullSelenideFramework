package MRCS.Utils;

import org.apache.commons.io.FileUtils;
import org.testng.IExecutionListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import java.io.File;

/**
 * @author smartData
 * <h1>Suite Events</h1>
 * <p>Purpose: This class is used to handle Events when executing suite</p>
 */

public class SuiteEvents implements ISuiteListener, IExecutionListener {
    private static boolean init = false;

    @Override
    public void onStart(ISuite iSuite) {
        Log.info("Test Suite started:" + iSuite.getName());
        //Get user Data from Excel
        try {
            ExcelUtil.GetUserData();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//End Function > onStart

    @Override
    public void onFinish(ISuite iSuite) {
        Log.info("Test Suite finished:" + iSuite.getName());
    }

    @Override
    public void onExecutionStart() {
        try {
            File ScreenShotFolder = new File(System.getProperty("user.dir") + "/ExecutionReports/HtmlReport/Screenshots");
            if (FileUtils.getFile(ScreenShotFolder).exists())
                FileUtils.cleanDirectory(ScreenShotFolder);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onExecutionFinish() {
        Common.KillChromeProcessForWindows();
        if (!init) {
            Log.info("Clean up process running...");
            Log.info("Clean up process finished...");
            init = true;
        }
    }
}//End class
