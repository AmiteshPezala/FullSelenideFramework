package MRCS.Tests.RetrievalFT;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.RetrievalRepo.RetrievalFTRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalFT;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.DEFAULT_WAIT;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class RetrievalFTExportGrid_TC15 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify grid data export", groups = {"Retrieval FT"})
    public void RetrievalFTExportGrid() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RetrievalFT.NavigateToFT();
        $(CommonRepo.Loader).waitUntil(Condition.disappear,DEFAULT_WAIT);
        sleep(2000);
        $(RetrievalFTRepo.ExportAll).waitUntil(Condition.visible,DEFAULT_WAIT).click();
        sleep(5000);
        Common.DownloadCsv();
        objLoginOut.logout();
    }
}
