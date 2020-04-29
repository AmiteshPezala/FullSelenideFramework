package MRCS.Tests.MRQA;

import MRCS.Locators.RetrievalRepo.MRQARepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.MRQA;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class MRQAGridExport_TC3 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval= new Retrieval();

    @Test(description = "Verify MRQA grid Export",groups = {"MRQA"})
    public void MRQAGridExport() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        MRQA.NavigateToDocQA();
        $(MRQARepo.ExportAll).click();
        Common.DownloadCsv();
        objLoginOut.logout();
    }
}
