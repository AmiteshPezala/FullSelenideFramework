package MRCS.Tests.IVAHST;

import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Modules.Hedis.IVAHST.FilterByUserAndMeasure;
import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class HST_VerifyNewEncounterAdd_TC4 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify new encounter add", groups = {"IVA HST"} )
    public void HST_VerifyNewEncounterAdd() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        FilterByUserAndMeasure();;
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        sleep(4000);
        objRisk.AddEncounter();
        sleep(2000);
        objLoginOut.logout();
    }
}
