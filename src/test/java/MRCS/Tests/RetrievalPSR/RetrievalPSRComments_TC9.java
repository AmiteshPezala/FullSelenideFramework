package MRCS.Tests.RetrievalPSR;

import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalPSR;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

public class RetrievalPSRComments_TC9 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify weather comment is added or not.", groups = {"Retrieval PSR"})
    public void RetrievalPSRComments_TC9() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RetrievalPSR.NavigateToPSR();
        $(RetrievalRepo.AIDFirstRow).click();
        logTestStep("Clicked on first address id ");
        Retrieval.Comments();
        objLoginOut.logout();
    }
}
