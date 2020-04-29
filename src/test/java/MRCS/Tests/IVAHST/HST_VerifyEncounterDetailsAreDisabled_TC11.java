package MRCS.Tests.IVAHST;

import MRCS.Modules.CommonRisk;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Modules.Hedis.IVAHST.FilterByUserAndMeasure;
import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class HST_VerifyEncounterDetailsAreDisabled_TC11 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify Encounter details are disabled when Specific service date = Yes and  F2F =No", groups = {"IVA HST"} )
    public void HST_VerifyEncounterDetailsAreDisabled() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        FilterByUserAndMeasure();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        sleep(4000);
        CommonRisk.ENCasYes();
        sleep(2000);
        CommonRisk.F2FasNo();
        sleep(2000);
        if($x("(.//*[normalize-space(text()) and normalize-space(.)='Page Number'])[1]/following::input[1]").isEnabled())
        {
            logTestStepFail("Encounter details are not disabled");
        }else
        {
            logTestStepPass("Encounter details are  disabled");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
