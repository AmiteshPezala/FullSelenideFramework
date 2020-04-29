package MRCS.Tests.MRQA;

import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.MRQA;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

public class MRQADetailsUnassigned_TC6 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Verify MRQA Details Unassigned and document is in readonly mode",groups = {"MRQA"})
    public void MRQADetailsUnassigned() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        MRQA.AssignToUser();
        MRQA.UnAssignUser();
        MRQA.NavigateToDocumentPage();
        MRQA.ReadOnlyView();
        objLoginOut.logout();
    }
}
