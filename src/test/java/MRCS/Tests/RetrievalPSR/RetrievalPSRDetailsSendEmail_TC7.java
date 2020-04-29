package MRCS.Tests.RetrievalPSR;

import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalPSR;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;

public class RetrievalPSRDetailsSendEmail_TC7 extends TestBase {
        LoginOut objLoginOut = new LoginOut();
        WaitTool objWait = new WaitTool();
        Retrieval objRetrieval = new Retrieval();

        @Test(description = "Verify email received to your email address.Email event is added to the site's Timeline.", groups = {"Retrieval PSR"})
        public void RetrievalPSRSendEmail_TC7() throws Exception {
            logTestStep("Log in to application");
            objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
            Common.PopUp();
            RetrievalPSR.NavigateToPSR();
            RetrievalPSR.SendEmail();
            objLoginOut.logout();
        }
    }