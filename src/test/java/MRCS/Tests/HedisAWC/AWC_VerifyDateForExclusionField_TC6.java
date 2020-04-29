package MRCS.Tests.HedisAWC;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.HedisAWC;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static MRCS.Utils.TestBase.*;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class AWC_VerifyDateForExclusionField_TC6 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify that Exclusion non compliance shows only for dates of 2019.", groups = {"Hedis AWC"})
    public void AWC_VerifyDateForExclusionField_TC6() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisAWC.navigateToAWC();
        objRisk.membervalidation();
        sleep(2000);
        for (int i = 1; i <= 5; i++) {
            $x("(//div[contains(text(),'Health History')]//following::button[@class='control__delete ng-star-inserted'])[" + (i + 0) + "]").click();
            sleep(2000);
        }
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
        Date date = new Date();
        String Date1 = dateFormat.format(date);
        Log.info(Date1);
        objMeasure.NegativeCompliance_ABA();
        sleep(2000);
        $x("//label[contains(text(),'Exclusion')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
        sleep(2000);
        $x("//span[contains(text(),'Hospice service or benefit used in 2019')]").click();
        sleep(2000);
        $x("(//label[contains(text(),'Exclusion')]//following::input)[2]").setValue(Date1);
        sleep(2000);
        $x("(//label[contains(text(),'Exclusion')]//following::input)[3]").setValue("1");
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(5000);
        String ChaseCompliace = $x("//td[@class='hdvi-gridcol hdvi-gridcol-chaseCompliance.code ng-star-inserted']").getText();
        sleep(2000);
        Log.info(ChaseCompliace);
        if (ChaseCompliace.contains("NC/E") || ChaseCompliace.contains("NC")) {
            logTestStepPass("Exclusion non compliance shows only for dates of 2019.");
        } else {
            logTestStepFail("Exclusion non compliance not shows.");
        }
        objLoginOut.logout();
    }
}
