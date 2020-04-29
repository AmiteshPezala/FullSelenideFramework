package MRCS.Tests.RetrievalPSR;

import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.RetrievalPSR;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.waitForPageLoadToComplete;
import static MRCS.Utils.TestBase.logTestStep;
import static java.lang.Thread.sleep;

public class RetrievalPSRVerifySendFax_TC6 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    RetrievalPSR objRetrievalPSR = new RetrievalPSR();

    @Test(description = "Verify send fax functionality.", groups = {"Retrieval PSR"})
    public void RetrievalPSRVerifySendFax_TC6() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        RetrievalPSR.NavigateToPSR();
        sleep(2000);
        ClickElement(RetrievalRepo.AIDFirstRow, "Selecting first chase");
        waitForPageLoadToComplete();
        sleep(5000);
        objRetrievalPSR.SendFax();
        sleep(2000);
        objLoginOut.logout();
    }
}
