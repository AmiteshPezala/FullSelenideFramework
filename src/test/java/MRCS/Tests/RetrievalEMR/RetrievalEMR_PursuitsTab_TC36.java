package MRCS.Tests.RetrievalEMR;

import MRCS.Locators.RetrievalRepo.RetrievalEMRRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalEMR;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.waitForPageLoadToComplete;
import static java.lang.Thread.sleep;

public class RetrievalEMR_PursuitsTab_TC36 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify Pursuits tab display", groups = {"Retrieval EMR"})
    public void RetrievalEMR_PursuitsTabDisplay() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RetrievalEMR.NavigateToEMR();
        Common.ClickElement(RetrievalEMRRepo.FirstEMRAID, "First Record");
        waitForPageLoadToComplete();
        sleep(5000);
        Common.assertText(RetrievalEMRRepo.pursuitsTab,"Pursuits");
        objLoginOut.logout();
    }
}
