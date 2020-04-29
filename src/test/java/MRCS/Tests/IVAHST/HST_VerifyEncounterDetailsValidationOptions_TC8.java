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

public class HST_VerifyEncounterDetailsValidationOptions_TC8 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk = new Risk();

    @Test(description = "Verify that validation options - Yes, No , Yes-with transformation are present or not.", groups = {"IVA HST"})
    public void HST_VerifyEncounterDetailsValidationOptions_TC8() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        FilterByUserAndMeasure();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        sleep(4000);
        CommonRisk.ENCasYes();
        sleep(2000);
        CommonRisk.F2FasYes();
        $x("//div[contains(text(),'Service Start Date')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
        sleep(3000);
        if($x("//div[contains(text(),'Service Start Date')]//following::span[contains(text(),'Yes')]").isDisplayed() && $x("//div[contains(text(),'Service Start Date')]//following::span[contains(text(),'No')]").isDisplayed() && $x("//div[contains(text(),'Service Start Date')]//following::span[contains(text(),'Yes - With Transformation')]").isDisplayed()){
            logTestStepPass("Three types of validations are available 'Yes,No and Yes with transformation'.");
        }else{
            logTestStepFail("Validation options are not present.");
        }
         objLoginOut.logout();
    }
}
