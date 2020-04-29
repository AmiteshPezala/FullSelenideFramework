package MRCS.Tests.RetrievalEMR;

import MRCS.Locators.RetrievalRepo.RetrievalEMRRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalEMR;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.DEFAULT_WAIT;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class RetrievalEMRGridExport_TC15 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify Export grid", groups = {"Retrieval EMR"})
    public void RetrievalEMRGridExport() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        RetrievalEMR.NavigateToEMR();
        sleep(2000);
        $(RetrievalEMRRepo.ExportAll).waitUntil(Condition.enabled,DEFAULT_WAIT).click();
        Common.DownloadCsv();
        objLoginOut.logout();
    }
}
