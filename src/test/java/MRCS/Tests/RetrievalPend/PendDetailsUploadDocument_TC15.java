package MRCS.Tests.RetrievalPend;

import MRCS.Locators.PendRepo.RetrievalPendRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Pend.RetrievalPend;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

public class PendDetailsUploadDocument_TC15 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    RetrievalPend objPend = new RetrievalPend();

    @Test(description = "Verify Pend Details Upload Document", groups = {"Retrieval Pend"})
    public void PendDetailsUploadDocument() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        RetrievalPend.NavigateToPendDetails();
        Common.ClickElement(RetrievalPendRepo.DocumentsTab,"Doc");
        Common.ClickElement(RetrievalPendRepo.UploadDocumentButton,"button");
        Common.UploadDocument();
        RetrievalPend.VerifyUploadedDocument();
        objLoginOut.logout();
    }
}
