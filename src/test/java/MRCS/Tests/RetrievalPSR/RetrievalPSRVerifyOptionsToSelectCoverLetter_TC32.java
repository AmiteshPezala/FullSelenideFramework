package MRCS.Tests.RetrievalPSR;

import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.RetrievalPSR;
import MRCS.Modules.RetrievalModule.ThirdParty;
import MRCS.Tests.ThirdParty.VerifyOptionForCoverLetterOfMail_TC23;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class RetrievalPSRVerifyOptionsToSelectCoverLetter_TC32 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    RetrievalPSR objRetrievalPSR = new RetrievalPSR();
    ThirdParty objThirdParty = new ThirdParty();

    @Test(description = "Verify that options are available for cover letter while sending email.", groups = {"Retrieval PSR"})
    public void RetrievalPSRVerifyOptionsToSelectCoverLetter_TC32() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        sleep(2000);
        //objWait.implicitwait();
        objRetrievalPSR.NavigateToPSR();
        sleep(2000);
        objThirdParty.OptionForCoverLetter();
        sleep(2000);
        objLoginOut.logout();

    }
}
