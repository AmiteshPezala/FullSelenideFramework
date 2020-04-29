package MRCS.Tests.RetrievalPSR;

import MRCS.Locators.CommonRepo;
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
import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class RetrievalPSRVerifyAfterApprovalChaseMoveToNewAID_TC28 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    RetrievalPSR objRetrievalPSR = new RetrievalPSR();

    @Test(description = "Verify thar after approve chase moved to new AID.", groups = {"Retrieval PSR"})
    public void RetrievalPSR_VerifyAfterApprovalChaseMoveToNewAID_TC28() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        RetrievalPSR.NavigateToPSR();
        logTestStep("Clicked on address id");
        ClickElement(RetrievalRepo.AIDFirstRow, "Selecting first chase");
        waitForPageLoadToComplete();
        sleep(5000);
        $(CommonRepo.BackwardButton).click();
        objRetrievalPSR.VerifyChaseMoveToNewAID();
        sleep(2000);
        objLoginOut.logout();

    }
}

