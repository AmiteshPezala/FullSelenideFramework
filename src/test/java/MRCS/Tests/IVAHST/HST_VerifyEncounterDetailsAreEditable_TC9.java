package MRCS.Tests.IVAHST;
import MRCS.Modules.CommonRisk;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Modules.Hedis.IVAHST.FilterByUserAndMeasure;
import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class HST_VerifyEncounterDetailsAreEditable_TC9 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify Encounter details are editable only when Specific service date = Yes and  F2F =Yes", groups = {"IVA HST"} )
    public void HST_VerifyEncounterDetailsAreEditable() throws Exception {
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
        sleep(4000);
        if($x("(//div[contains(text(),'Encounter Type')]//following::span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down'])[1]").isEnabled())
        {
            logTestStepPass("Encounter details enabled for further coding");
        }else
        {
            logTestStepFail("Encounter details not enabled for further coding");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
