package MRCS.Tests.RetrievalPSR;

import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Locators.RetrievalRepo.ThirdPartyRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.RetrievalPSR;
import MRCS.Modules.RetrievalModule.ThirdParty;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class RetrievalPSR_ProviderTab_VerifyExportAll_TC68 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    RetrievalPSR objRetrievalPSR=new RetrievalPSR();
    ThirdParty objThirdParty = new ThirdParty();

    @Test(description = "Verify export all functionality of provider tab.", groups = {"Retrieval PSR"})
    public void RetrievalPSR_ProviderTab_VerifyExportAll_TC68() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        sleep(2000);
        //objWait.implicitwait();
        objRetrievalPSR.NavigateToPSR();
        $(RetrievalRepo.AIDFirstRow).click();
        logTestStep("Selecting first AID.");
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
