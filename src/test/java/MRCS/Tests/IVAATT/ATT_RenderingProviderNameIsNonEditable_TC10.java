package MRCS.Tests.IVAATT;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.IVAATT;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class ATT_RenderingProviderNameIsNonEditable_TC10 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify rendering provider name is a non editable field.", groups = {"IVA ATT"})
    public void ATT_RenderingProviderNameIsNonEditable_TC10() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        IVAATT.navigateToATT();
        objRisk.membervalidation();
        sleep(2000);
        if ($x("(//div[contains(text(),'Encounter Details')]//following::input)[2]").isEnabled()) {
            logTestStepFail("Rendering provider name field is editable.");
        } else {
            logTestStepPass("Rendering provider name field is non editable.");
        }
        objLoginOut.logout();
    }
}
