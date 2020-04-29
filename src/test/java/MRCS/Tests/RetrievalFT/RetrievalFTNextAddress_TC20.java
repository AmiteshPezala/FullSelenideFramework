package MRCS.Tests.RetrievalFT;

import MRCS.Locators.RetrievalRepo.RetrievalEMRRepo;
import MRCS.Locators.RetrievalRepo.RetrievalFTRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalEMR;
import MRCS.Modules.RetrievalModule.RetrievalFT;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.waitForPageLoadToComplete;
import static java.lang.Thread.sleep;

public class RetrievalFTNextAddress_TC20 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify whether chase is assigned from one address to other", groups = {"Retrieval FT"})
    public void RetrievalFTNextAddress() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RetrievalFT.NavigateToFT();
        Common.ClickElement(RetrievalFTRepo.FirstFTAID,"First Record");
        waitForPageLoadToComplete();
        sleep(5000);
        Retrieval.MoveChase();
        objLoginOut.logout();
    }
}
