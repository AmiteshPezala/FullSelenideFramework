package MRCS.Tests.ThirdParty;

import MRCS.Locators.RetrievalRepo.ThirdPartyRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.ThirdParty;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class PendTab_VerifyPendIsAssociatedWithChase_TC47 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    ThirdParty objThirdParty = new ThirdParty();

    @Test(description = "Verify pend is associated with the chase.", groups = {"Third party"})
    public void PendTab_VerifyPendIsAssociatedWithChase_TC47() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        Thread.sleep(2000);
        //objWait.implicitwait();
        objThirdParty.ThirdPartyLink();
        sleep(2000);
        //$(ThirdPartyRepo.FirstAID).click();
        logTestStep("Clicked on first AID.");
        $x("//tr[3]//td[2]//a[1]").click();
        sleep(2000);
        objThirdParty.PendAssociatedWithChase();
        sleep(2000);
        objLoginOut.logout();
    }
}
