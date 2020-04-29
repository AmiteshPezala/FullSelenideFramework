package MRCS.Tests.HedisMRP;

import MRCS.Locators.HedisRepo.HedisMRPRepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.HedisMRP;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class MRP_PositiveComplianceForMedicalReconcilation_TC6 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify that medication reconcilation shows +ve complaince if date is  THROUGH 31 DAYS OF DISCHARGE IN 2019 ", groups = {"Hedis MRP"})
    public void MRP_PositiveComplianceForMedicalReconcilation_TC6() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisMRP.navigateToMRP();
        objRisk.membervalidation();
        sleep(2000);
        HedisMRP.MedicationReconciliation();
        $x("//label[contains(text(),'NRC - Medication Reconciliation')]").click();
        objMeasure.PositiveCompliance_MRP();
        sleep(2000);
        objLoginOut.logout();
    }
}
