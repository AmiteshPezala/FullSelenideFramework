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

public class HST_VerifyAcceptableSignature_TC15 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk = new Risk();

    @Test(description = "Verify that yes,no options are present for acceptable Credentials.", groups = {"IVA HST"})
    public void HST_VerifyAcceptableSignature_TC15() throws Exception {
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
        $x("//div[contains(text(),'Does the signature have acceptable Credentials?')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
        sleep(2000);
        if($x("//div[contains(text(),'Does the signature have acceptable Credentials?')]//following::span[contains(text(),'Yes')]").isDisplayed() && $x("//div[contains(text(),'Does the signature have an acceptable First Name?')]//following::span[contains(text(),'No')]").isDisplayed()){
            logTestStepPass("Drop down contains Yes and No options.");
        }else{
            logTestStepFail("Drop down not contains Yes and No options.");
        }
        sleep(2000);

    }
}
