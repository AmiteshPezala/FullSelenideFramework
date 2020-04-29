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

public class ATT_ValidationForMemberValidationNo_TC5 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Submit button get enabled only when both the fields are having values.", groups = {"IVA ATT"})
    public void ATT_ValidationForMemberValidationNo_TC5() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        IVAATT.navigateToATT();
        $x("//span[contains(text(),'No')]").click();
        sleep(3000);
        logTestStep("Checking weather submit button is disabled or enabled");
        $x("(//div[contains(text(),'Member Information')]//preceding::input)[2]").setValue("1");
        sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='No'])[1]/following::select[1]").click();
        sleep(2000);
        $x("//option[contains(text(),'No Encounter Date of Service Matches Claim in Medical Record')]").click();
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
        if($x("//span[contains(text(),'Submit')]").isEnabled()) {
            logTestStepPass("Button is enabled.");
        }else{
            logTestStepFail("Button is still disabled");
        }
        logTestStep("Submit button is enabled only after selecting reason code and entering page no.");
        sleep(2000);
        objLoginOut.logout();
    }
}
