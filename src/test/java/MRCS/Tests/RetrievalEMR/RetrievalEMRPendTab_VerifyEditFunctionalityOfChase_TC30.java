package MRCS.Tests.RetrievalEMR;

import MRCS.Locators.RetrievalRepo.RetrievalEMRRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.RetrievalEMR;
import MRCS.Modules.RetrievalModule.ThirdParty;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.waitForPageLoadToComplete;
import static java.lang.Thread.sleep;

public class RetrievalEMRPendTab_VerifyEditFunctionalityOfChase_TC30 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    ThirdParty objThirdParty = new ThirdParty();

    @Test(description = "Verify that If pend is edited from chases tab ,it reflects in pend tab", groups = {"Retrieval EMR"})
    public void RetrievalEMRPendTab_VerifyEditFunctionalityOfChase() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        Thread.sleep(2000);
        //objWait.implicitwait();
        RetrievalEMR.NavigateToEMR();
        Common.ClickElement(RetrievalEMRRepo.FirstEMRAID, "First Record");
        waitForPageLoadToComplete();
        sleep(5000);
       /* $x("//tr[3]//td[2]//a[1]").click();
        sleep(2000);*/
        objThirdParty.EditFunctionalityOfChase();
        sleep(2000);
        objLoginOut.logout();

    }
}
