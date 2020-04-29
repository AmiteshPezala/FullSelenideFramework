package MRCS.Tests.OR1;
import MRCS.Modules.Clinical;
import MRCS.Modules.ClinicalModule.OR1;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;
import static MRCS.Utils.Common.*;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class VerifyMemberValidationAsYes_TC5 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Clinical objClinical = new Clinical();
    Risk objRisk=new Risk();

    @Test(description = "Member validation - Yes", groups = {"OR1"})
    public void VerifyMemberValidationAsYes() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        OR1.BulkAssignToUser();
        SelectChaseAndOpenChart();
        objRisk.membervalidation();
        objLoginOut.logout();

    }
}
