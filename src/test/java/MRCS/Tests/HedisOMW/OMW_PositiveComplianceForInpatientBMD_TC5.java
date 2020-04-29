package MRCS.Tests.HedisOMW;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.HedisOMW;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class OMW_PositiveComplianceForInpatientBMD_TC5 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Osteoporosis shows a +ve compliance when inpatient BMD date  between July 15th MY-2 and December 31st MY-1 ", groups = {"Hedis OMW"})
    public void OMW_PositiveComplianceForInpatientBMD_TC5() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisOMW.navigateToOMW();
        objRisk.membervalidation();
        sleep(2000);
        objMeasure.DeleteRow_OMW();
        sleep(2000);
        $x("(//div[contains(text(),'Inpatient - BMD test date during the inpatient sta')]//following::input)[1]").setValue("07/15/2017");
        sleep(2000);
        $x("(//div[contains(text(),'Inpatient - BMD test date during the inpatient sta')]//following::input)[2]").setValue("1");
        sleep(2000);
        $x("//div[contains(text(),'Inpatient - BMD test date during the inpatient sta')]").click();
        sleep(2000);
        objMeasure.PositiveCompliance_OMW();
        sleep(2000);
        objLoginOut.logout();
    }
}
