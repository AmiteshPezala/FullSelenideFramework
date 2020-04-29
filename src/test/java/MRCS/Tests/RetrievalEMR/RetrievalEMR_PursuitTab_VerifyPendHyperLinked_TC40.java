package MRCS.Tests.RetrievalEMR;

import MRCS.Locators.RetrievalRepo.RetrievalEMRRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalEMR;
import MRCS.Modules.RetrievalModule.ThirdParty;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

public class RetrievalEMR_PursuitTab_VerifyPendHyperLinked_TC40 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify PEnd ID is hyperlinked", groups = {"Retrieval EMR"})
    public void VerifyPendHyperLinked() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RetrievalEMR.NavigateToEMR();
        Common.ClickElement(RetrievalEMRRepo.FirstEMRAID, "First Record");
        Common.waitForLoader();
        //$(RetrievalEMRRepo.pursuitsTab).click();
        ThirdParty.PursuitTab_PendCodeHyperlink();
        Common.waitForLoader();
        objLoginOut.logout();
    }
}
