package MRCS.Tests.RetrievalPSR;

import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.RetrievalPSR;
import MRCS.Modules.RetrievalModule.ThirdParty;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Utils.TestBase.logTestStep;
import static java.lang.Thread.sleep;

public class RetrievalPSRVerifyConfirmEmailFields_TC33 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    ThirdParty objThirdParty = new ThirdParty();
    RetrievalPSR objRetrievalPSR=new RetrievalPSR();

    @Test(description = "Verify fields for the mail form.", groups = {"Retrieval PSR"})
    public void RetrievalPSRVerifyConfirmEmailFields_TC33() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        sleep(2000);
        //objWait.implicitwait();
        objRetrievalPSR.NavigateToPSR();
        sleep(2000);
        objThirdParty.ConfirmEmailFields();
        objLoginOut.logout();
    }
}
