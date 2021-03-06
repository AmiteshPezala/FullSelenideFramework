package MRCS.Tests.RetrievalPend;
import MRCS.Locators.PendRepo.RetrievalPendRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Pend.RetrievalPend;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class PendDetailsDocumentsTab_TC20 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    RetrievalPend objPend = new RetrievalPend();

    @Test(description = "Verify Pend Details Document tab,User can download document", groups = {"Retrieval Pend"})
    public void PendDetailsDocumentsTab() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        RetrievalPend.NavigateToPendDetails();
        Common.ClickElement(RetrievalPendRepo.DocumentsTab,"Doc");
        Common.ClickElement(RetrievalPendRepo.UploadDocumentButton,"button");
        Common.UploadDocument();
        sleep(2000);
        RetrievalPend.VerifyUploadedDocument();
        sleep(2000);
        Common.ClickElement(RetrievalPendRepo.FirstUploadedDocument,"First Uploaded document");
        sleep(2000);
        Common.DownloadPdfDocument();
        objLoginOut.logout();
    }
}
