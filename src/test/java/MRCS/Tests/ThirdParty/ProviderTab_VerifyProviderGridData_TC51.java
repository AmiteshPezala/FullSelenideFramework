package MRCS.Tests.ThirdParty;

import MRCS.Locators.RetrievalRepo.ThirdPartyRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.ThirdParty;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class ProviderTab_VerifyProviderGridData_TC51 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    ThirdParty objThirdParty = new ThirdParty();

    @Test(description = "Verify grid data of provider tab.", groups = {"Third party"})
    public void ProviderTab_VerifyProviderGridData_TC51() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        Thread.sleep(2000);
        //objWait.implicitwait();
        objThirdParty.ThirdPartyLink();
        sleep(2000);
        $(ThirdPartyRepo.FirstAID).click();
        sleep(2000);
        $(ThirdPartyRepo.ProviderTab).click();
        logTestStep("clicked on the provider tab.");
        sleep(2000);
        logTestStep("Verifying the grid data.");
        objThirdParty.ProviderTabGridData();
        sleep(2000);
        objLoginOut.logout();


    }
}
