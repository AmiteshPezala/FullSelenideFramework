package MRCS.Tests.IVAHST;

import MRCS.Modules.CommonRisk;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Modules.Hedis.IVAHST.FilterByUserAndMeasure;
import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class HST_VerifyEncounterDetailValidationOptions_TC19 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk = new Risk();

    @Test(description = "Verify that three validation options are present or not.", groups = {"IVA HST"})
    public void HST_VerifyEncounterDetailValidationOptions_TC19() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        FilterByUserAndMeasure();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        sleep(4000);
        CommonRisk.ENCasYes();
        CommonRisk.F2FasYes();
        sleep(2000);
        logTestStep("Validating for Service Start Date.");
        $x("//div[contains(text(),'Service Start Date')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
        sleep(2000);
        if($x("//div[contains(text(),'Service Start Date')]//following::span[contains(text(),'Yes')]").isDisplayed() && $x("//div[contains(text(),'Service Start Date')]//following::span[contains(text(),'No')]").isDisplayed() && $x("//div[contains(text(),'Service Start Date')]//following::span[contains(text(),'Yes - With Transformation')]").isDisplayed()){
            sleep(2000);
            logTestStepPass("All three validation options are present in the drop down.");
        }else{
            logTestStepFail("Validation options are not present in drop down.");
        }
        sleep(2000);
        logTestStep("Validating for Service End Date.");
        $x("//div[contains(text(),'Service End Date')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
        sleep(2000);
        if($x("//div[contains(text(),'Service End Date')]//following::span[contains(text(),'Yes')]").isDisplayed() && $x("//div[contains(text(),'Service End Date')]//following::span[contains(text(),'No')]").isDisplayed() && $x("//div[contains(text(),'Service End Date')]//following::span[contains(text(),'Yes - With Transformation')]").isDisplayed()){
            sleep(2000);
            logTestStepPass("All three validation options are present in the drop down.");
        }else{
            logTestStepFail("Validation options are not present in drop down.");
        }
        sleep(2000);
        logTestStep("Validating for Provider.");
        $x("(//div[contains(text(),'Provider')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[2]").click();
        sleep(2000);
        if($x("//div[contains(text(),'Provider')]//following::span[contains(text(),'Yes')]").isDisplayed() && $x("//div[contains(text(),'Provider')]//following::span[contains(text(),'No')]").isDisplayed() && $x("//div[contains(text(),'Provider')]//following::span[contains(text(),'Yes - With Transformation')]").isDisplayed()){
            sleep(2000);
            logTestStepPass("All three validation options are present in the drop down.");
        }else{
            logTestStepFail("Validation options are not present in drop down.");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
