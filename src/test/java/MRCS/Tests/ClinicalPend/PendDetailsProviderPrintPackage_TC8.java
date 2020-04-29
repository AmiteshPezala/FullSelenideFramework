package MRCS.Tests.ClinicalPend;

import MRCS.Locators.PendRepo.RetrievalPendRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Pend.ClinicalPend;
import MRCS.Modules.Pend.RetrievalPend;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.waitForPageLoadToComplete;
import static com.codeborne.selenide.Selenide.sleep;

public class PendDetailsProviderPrintPackage_TC8 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    ClinicalPend objPend = new ClinicalPend();

    @Test(description = "Verify Provider packet is downloaded", groups = {"Clinical Pend"})
    public void PendDetailsProviderPrintPackage() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        objPend.PendLink();
        ClinicalPend.navigateToClinicalPend();
        Common.ClickElement(RetrievalPendRepo.FirstPend, "First RetrievalPend");
        waitForPageLoadToComplete();
        Common.ClickElement(RetrievalPendRepo.PrintProvider,"Print Provider");
        sleep(5000);
        Common.DownloadPdfDocument();
        objLoginOut.logout();
    }
}
