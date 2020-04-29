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

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class MRP_PositiveChaseSubmitted_TC10 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify chase can be submitted when the complaince is +ve ", groups = {"Hedis MRP"})
    public void MRP_PositiveChaseSubmitted_TC10() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisMRP.navigateToMRP();
        objRisk.membervalidation();
        sleep(5000);
        HedisMRP.MedicationReconciliation();
        objMeasure.PositiveCompliance_MRP();
        $x("(//span[contains(text(),'Submit')])[position() =2]").click();
        sleep(1000);
        String SuccessfulMessage = $x("//div[@class='ui-toast-detail']").getText();
        assertText(SuccessfulMessage, "SUBMISSION SUCCEEDED!");
        sleep(4000);
        Common.StopWalkThru();
        sleep(2000);
        objLoginOut.logout();
    }
}
