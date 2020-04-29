package MRCS.Tests.RetrievalPend;
import MRCS.Locators.PendRepo.RetrievalPendRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Pend.RetrievalPend;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class PendDetailsProviderPrintPackage_TC8 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    RetrievalPend objPend = new RetrievalPend();

    @Test(description = "Verify Provider packet is downloaded", groups = {"Retrieval Pend"})
    public void PendDetailsProviderPrintPackage() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        RetrievalPend.NavigateToPendDetails();
        sleep(5000);
        Common.ClickElement(RetrievalPendRepo.PrintProvider,"Print Provider");
        if($x("//div[@class='ui-toast-detail']").isDisplayed())
        {
            String PrintMsg=$x("//div[@class='ui-toast-detail']").getText();
            sleep(2000);
            String Expected="No provider packet available for download.";
            assertText(PrintMsg,Expected);
            logTestStep("No document found to delete");
        }
        else
        {
            sleep(2000);
            Common.DownloadPdfDocument();
        }
        objLoginOut.logout();
    }
}
