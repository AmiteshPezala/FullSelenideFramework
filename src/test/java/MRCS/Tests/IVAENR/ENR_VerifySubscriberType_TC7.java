package MRCS.Tests.IVAENR;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.IVAENR;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class ENR_VerifySubscriberType_TC7 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify Subscriber type field.", groups = {"IVA ENR"})
    public void ENR_VerifySubscriberType_TC7() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        IVAENR.navigateToENR();
        objRisk.membervalidation();
        sleep(2000);
        if ($x("(//label[contains(text(),'Subscriber Type')]//following::input)[1]").isEnabled()){
            logTestStepFail("Subscriber type field is editable");

        } else {
            logTestStepPass("Subscriber type field is non editable");
            sleep(2000);
            String SubscriberType = $x("(//label[contains(text(),'Subscriber Type')]//following::input)[1]").getValue();
            Log.info(SubscriberType);
            sleep(2000);
            if ($x("(//label[contains(text(),'Subscriber Type')]//following::input)[1]").isDisplayed()) {
                logTestStepPass("Subscriber Type = " + SubscriberType);
            } else {
                logTestStepPass("Subscriber Type is not present");
            }
            sleep(2000);
            objLoginOut.logout();
        }
    }
}
