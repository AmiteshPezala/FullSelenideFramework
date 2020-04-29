package MRCS.Tests.HedisIMA;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.HedisIMA;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class IMA_VerifyNRCValidation_TC14 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Negative compliance chase can be submitted if we select NRC.", groups = {"Hedis IMA"})
    public void VerifyNRCValidation_TC14() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisIMA.navigateToIMA();
        objRisk.membervalidation();
        sleep(2000);
        objMeasure.DeleteRow_IMA();
        sleep(2000);
        objMeasure.DataForMeningococcal_IMA();
        sleep(2000);
        objMeasure.DataForTdap_IMA();
        $x("(//button[@class='control__add'])[position()=3]").click();
        sleep(3000);
        $x("(//label[contains(text(),'NRC - HPV')]//following::span[@class='ui-button-icon-left ui-clickable pi pi-caret-down'])[1]").click();
        sleep(2000);
        $x("//span[contains(text(),'Immunization record missing')]").click();
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
        String ChaseCompliace = $x("//tr[3]//td[2]").getText();
        sleep(2000);
        Log.info(ChaseCompliace);
        if (ChaseCompliace.contains("NC")) {
            logTestStepPass("Compliance shows Negative");
        } else {
            logTestStepFail("Compliance shows positive");
        }
        sleep(2000);
        objRisk.ChecklistForART();
        sleep(2000);
        /*$x("(//span[contains(text(),'Submit')])[position() =2]").click();
        sleep(1000);
        String Successfulmessage = $x("//div[@class='ui-toast-detail']").getText();
        assertText(Successfulmessage, "SUBMISSION SUCCEEDED!");
        sleep(4000);
        Common.StopWalkThru();
        sleep(2000);*/
        objLoginOut.logout();
    }
}
