package MRCS.Tests.OR2;

import MRCS.Modules.Clinical;
import MRCS.Modules.ClinicalModule.OR2;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class MemberValidation_TC5 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify Member validation Yes", groups = {"OR2"})
    public void MemberValidation_TC5() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_NonAdmin);
        Common.PopUp();
        //objWait.implicitwait();
        OR2.BulkAssignToUser();
        objcommon.SelectChaseAndOpenChart();
        sleep(2000);
        objRisk.membervalidation();
        sleep(2000);
        if($x("(//div[contains(text(),'Mammogram')]//following::input)[1]").isEnabled()){
            logTestStepPass("Fields are editable after member validation 'Yes'");
        }else {
            logTestStepFail("Fields are not editable .");
        }
        objLoginOut.logout();
    }
}
