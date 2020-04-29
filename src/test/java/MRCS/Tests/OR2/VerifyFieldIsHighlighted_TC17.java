package MRCS.Tests.OR2;

import MRCS.Modules.Clinical;
import MRCS.Modules.ClinicalModule.OR2;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.TestBase.*;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class VerifyFieldIsHighlighted_TC17 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify field is highlighted or not.", groups = {"OR2"})
    public void VerifyFieldIsHighlighted_TC17() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_NonAdmin);
        Common.PopUp();
        //objWait.implicitwait();
        OR2.BulkAssignToUser();
        objcommon.SelectChaseAndOpenChart();
        sleep(2000);
        objRisk.membervalidation();
        sleep(2000);
        String PreviousBorderColour=$x("(//div[contains(text(),'Mammogram')]//following::input)[1]").getCssValue("border-color");
        Log.info(PreviousBorderColour);
        $x("(//div[contains(text(),'Mammogram')]//following::input)[1]").setValue("10/02/2017");
        sleep(2000);
        $x("(//div[contains(text(),'Mammogram')]//following::input)[2]").setValue("1");
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(3000);
        String CurrentBorderColour=$x("(//div[contains(text(),'Mammogram')]//following::input)[1]").getCssValue("border-color");
        Log.info(CurrentBorderColour);
        $x("//div[@class='coding-container']").click();
        sleep(3000);
        if(PreviousBorderColour.equals(CurrentBorderColour)){
            logTestStepFail("Fields are not highlighted.");
        }else{
            logTestStepPass("Fields are highlighted.");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
