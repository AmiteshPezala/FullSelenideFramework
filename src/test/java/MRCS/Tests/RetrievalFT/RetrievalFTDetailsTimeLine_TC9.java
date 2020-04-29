package MRCS.Tests.RetrievalFT;
import MRCS.Locators.RetrievalRepo.RetrievalFTRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalFT;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class RetrievalFTDetailsTimeLine_TC9 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify recent timeline events are present.", groups = {"Retrieval FT"})
    public void RetrievalFTTimeLine() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        RetrievalFT.NavigateToFT();
        logTestStep("Adding new comment to check whether it is added in timeline tab or not");
        $(RetrievalFTRepo.FirstFTAID).click();
        Retrieval.TimeLine();
        objLoginOut.logout();
    }
}
