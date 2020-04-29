package MRCS.Tests.HedisPPC;

import MRCS.Modules.Hedis.HedisPPC;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class PPC_VerifyMRDOD_TC6 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify MR DOD field", groups = {"Hedis PPC"} )
    public void PPC_VerifyPrenetalDateRange() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisPPC.NavigateToPPC();
        objRisk.membervalidation();
        sleep(2000);
        logTestStep_ColorGreen("Verifying MR DOD");
        HedisPPC.DODFromMedRecords();
        objLoginOut.logout();
    }
}
