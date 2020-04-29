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

public class ProviderTab_ExportAllFunctionality_TC52 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    ThirdParty objThirdParty = new ThirdParty();

    @Test(description = "Verify Export all functionality.", groups = {"Third party"})
    public void ProviderTab_ExportAllFunctionality_TC52() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        Thread.sleep(2000);
        //objWait.implicitwait();
        objThirdParty.ThirdPartyLink();
        sleep(2000);
        $(ThirdPartyRepo.FirstAID).click();
        logTestStep("Clicked on first AID.");
        sleep(2000);
        $(ThirdPartyRepo.ProviderTab).click();
        logTestStep("Clicked on provider tab.");
        sleep(2000);
        $(ThirdPartyRepo.ExportAll).click();
        logTestStep("Clicked on export all option.");
        sleep(2000);
        logTestStep("Verifying that file is downloaded or not .");
        Common.DownloadCsv();
        objLoginOut.logout();
    }
}
