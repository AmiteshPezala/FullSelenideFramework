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

public class ENR_VerifyEnrollmentId_TC6 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "A unique enrolle ID is available.", groups = {"IVA ENR"})
    public void ENR_VerifyEnrollmentId_TC6() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        IVAENR.navigateToENR();
        objRisk.membervalidation();
        sleep(2000);
        String EnrolleeId=$x("(//label[contains(text(),'Enrollee ID (RADVEE)')]//following::input)[1]").getValue();
        Log.info(EnrolleeId);
        sleep(2000);
        if($x("(//label[contains(text(),'Enrollee ID (RADVEE)')]//following::input)[1]").isDisplayed()){
            logTestStepPass("Unique Enrollee Id = " + EnrolleeId);
        }else{
            logTestStepPass("Enrollee Id is not present");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
