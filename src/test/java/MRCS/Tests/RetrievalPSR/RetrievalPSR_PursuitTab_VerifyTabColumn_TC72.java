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
import static java.lang.Thread.sleep;

public class RetrievalPSR_PursuitTab_VerifyTabColumn_TC72 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    RetrievalPSR objRetrievalPSR=new RetrievalPSR();
    ThirdParty objThirdParty = new ThirdParty();

    @Test(description = "Verify grid data of pursuit tab.", groups = {"Retrieval PSR"})
    public void RetrievalPSR_PursuitTab_VerifyTabColumn_TC72() throws Exception {
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
        $(ThirdPartyRepo.PursuitTab).click();
        logTestStep("Clicked on pursuit tab.");
        sleep(2000);
        logTestStep("Verifying the pursuit tab grid data.");
        objThirdParty.PursuitTabGridData();
        sleep(2000);
        objLoginOut.logout();
    }
}
