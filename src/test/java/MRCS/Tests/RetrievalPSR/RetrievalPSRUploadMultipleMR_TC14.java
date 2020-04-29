package MRCS.Tests.RetrievalPSR;

import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalPSR;
import MRCS.Modules.RetrievalModule.ThirdParty;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.sleep;

public class RetrievalPSRUploadMultipleMR_TC14 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    ThirdParty objThirdParty = new ThirdParty();

    @Test(description = "Verify weather MR is upload or not", groups = {"Retrieval PSR"})
    public void RetrievalPSRUploadMultipleMR_TC14() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        sleep(2000);
        Common.PopUp();
        RetrievalPSR.NavigateToPSR();
        objThirdParty.UploadMultipleMR();
        Thread.sleep(2000);
        objLoginOut.logout();

    }
}
