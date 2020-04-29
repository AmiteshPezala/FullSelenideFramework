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

public class ATT_FieldsGetEnabledAfterConfirmingEncounterDetailsYes_TC13 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify Service thru date is a non editable field.", groups = {"IVA ATT"})
    public void ATT_FieldsGetEnabledAfterConfirmingEncounterDetailsYes_TC13() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        IVAATT.navigateToATT();
        objRisk.membervalidation();
        sleep(2000);
        $x("//div[contains(text(),'Encounter Details')]//following::span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-caret-down']").click();
        sleep(2000);
        $x("//div[contains(text(),'Encounter Details')]//following::span[contains(text(),'No')]").click();
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
        if($x("(//div[contains(text(),'Is the provider signature acceptable?')]//following::input)[1]").isEnabled()){
            logTestStepFail("Fields are editable before confirming encounter details");
        }else{
            logTestStepPass("Fields are non editable, need to confirm encounter details");
        }
        objRisk.membervalidation();
        sleep(2000);
        $x("(//div[contains (text(),'Encounter Details')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[1]").click();
        sleep(2000);
        $x("(//span[contains(text(),'Yes')])[2]").click();
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
        if($x("(//div[contains(text(),'Is the provider signature acceptable?')]//following::input)[1]").isEnabled()){
            logTestStepPass("Fields are editable after confirming encounter details");
        }else{
            logTestStepFail("Fields are still disabled");
        }
    }
}