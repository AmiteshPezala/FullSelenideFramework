package MRCS.Tests.MRQA;

import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.MRQA;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

public class MRQABulkUnAssign_TC24 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Verify MRQA Details Bulk Unassigned and document is in readonly mode",groups = {"MRQA"})
    public void MRQABulkUnAssign() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        MRQA.BulkAssignToUser();
        MRQA.BulkUnAssignUser();
        MRQA.NavigateToDocumentPage();
        MRQA.ReadOnlyView();
        objLoginOut.logout();
    }
}
