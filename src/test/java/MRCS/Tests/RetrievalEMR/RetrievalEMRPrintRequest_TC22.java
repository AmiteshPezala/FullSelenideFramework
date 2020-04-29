package MRCS.Tests.RetrievalEMR;

import MRCS.Locators.RetrievalRepo.RetrievalEMRRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalEMR;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class RetrievalEMRPrintRequest_TC22 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify Provider packet get printed", groups = {"Retrieval EMR"})
    public void RetrievalEMRPrintRequest() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RetrievalEMR.NavigateToEMR();
        Common.ClickElement(RetrievalEMRRepo.FirstEMRAID,"First Record");
        $x("//span[contains(text(),'EDIT')]").click();
        sleep(2000);
        $x("//input[@id='email']").setValue("test@yopmail.com");
        sleep(2000);
        $x("//span[contains(text(),'APPLY EDITS')]").click();
        sleep(5000);
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
