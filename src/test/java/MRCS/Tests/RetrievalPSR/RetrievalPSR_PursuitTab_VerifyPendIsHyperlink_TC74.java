package MRCS.Tests.RetrievalPSR;

import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Locators.RetrievalRepo.ThirdPartyRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.RetrievalPSR;
import MRCS.Modules.RetrievalModule.ThirdParty;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class RetrievalPSR_PursuitTab_VerifyPendIsHyperlink_TC74 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    RetrievalPSR objRetrievalPSR=new RetrievalPSR();
    ThirdParty objThirdParty = new ThirdParty();

    @Test(description = "Verify that pend code is hyperlinked.", groups = {"Retrieval PSR"})
    public void RetrievalPSR_PursuitTab_VerifyPendIsHyperlink_TC73() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        sleep(2000);
        //objWait.implicitwait();
        objRetrievalPSR.NavigateToPSR();
        $(RetrievalRepo.AIDFirstRow).click();
        logTestStep("Selecting first AID.");
        sleep(2000);
      // $x("//tr[3]//td[2]//a[1]").click();
        sleep(2000);
        objThirdParty.PursuitTab_PendCodeHyperlink();
        sleep(2000);
        objLoginOut.logout();
    }
}
