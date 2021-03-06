package MRCS.Tests.MRQA;

import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.MRQA;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

public class MRQADetailsAssigned_TC5 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Verify MRQA Details assigned",groups = {"MRQA"})
    public void MRQADetailsAssigned() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        MRQA.AssignToUser();
        MRQA.NavigateToDocumentPage();
        MRQA.MemberValidationMRQA();
        objLoginOut.logout();
    }
}
