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

public class RetrievalPSRVerifyButtonForNonManagerUser_TC30 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    RetrievalPSR objRetrievalPSR = new RetrievalPSR();

    @Test(description = "Verify that 'Chase move ' button for non manager user is 'Request move' or not .", groups = {"Retrieval PSR"})
    public void RetrievalPSRVerifyButtonForNonManagerUser_TC30() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        RetrievalPSR.NavigateToPSR();
        objRetrievalPSR.AssignAndVerifyButtonForNonManagerUser();
        sleep(2000);
        objLoginOut.logout();
    }
}
