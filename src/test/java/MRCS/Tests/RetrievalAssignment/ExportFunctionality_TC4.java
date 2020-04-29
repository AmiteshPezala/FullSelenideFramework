package MRCS.Tests.RetrievalAssignment;

import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class ExportFunctionality_TC4 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify export functionality.", groups = {"Retrieval Assignment"})
    public void ExportFunctionality_TC4() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        logTestStep("Clicked on Retrieval link");
        objRetrieval.RetrievalLink();
        sleep(2000);
        $(RetrievalRepo.Assignment).click();
        logTestStep("Clicked on Assignment link");
        sleep(10000);
        $x("//span[contains(text(),'Export All')]").click();
        logTestStep("Clicked on Export all button");
        sleep(25000);
        Common.DownloadCsv();
        objLoginOut.logout();
    }
}
