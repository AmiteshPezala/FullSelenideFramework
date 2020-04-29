package MRCS.Tests.RetrievalFT;
import MRCS.Locators.RetrievalRepo.RetrievalFTRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalFT;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.*;
import static com.codeborne.selenide.Selenide.*;

public class RetrievalFTPrintRequest_TC22 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify Provider packet get printed", groups = {"Retrieval FT"})
    public void RetrievalFTPrintRequest() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RetrievalFT.NavigateToFT();
        logTestStep("Clicked on address id");
        ClickElement(RetrievalFTRepo.FirstFTAID,"First");
        waitForPageLoadToComplete();
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
        sleep(10000);
        objLoginOut.logout();
    }
}
