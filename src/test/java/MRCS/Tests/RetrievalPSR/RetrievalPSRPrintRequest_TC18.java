package MRCS.Tests.RetrievalPSR;

import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalPSR;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class RetrievalPSRPrintRequest_TC18 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify weather retrieval type is changed or not. ", groups = {"Retrieval PSR"})
    public void RetrievalPSRPrintRequest_TC18() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        RetrievalPSR.NavigateToPSR();
        logTestStep("Clicked on address id");
        $(RetrievalRepo.AIDFirstRow).click();
        $x("//*[text()='CHASES AT THIS ADDRESS']//following::p-tablecheckbox[1]").click();
        sleep(2000);
        logTestStep("Selecting first chase id");
        Retrieval.printRequest();
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
