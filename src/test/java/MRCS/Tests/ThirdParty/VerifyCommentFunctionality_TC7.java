package MRCS.Tests.ThirdParty;

import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.ThirdParty;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Utils.TestBase.logTestStep;
import static java.lang.Thread.sleep;

public class VerifyCommentFunctionality_TC7 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    ThirdParty objThirdParty = new ThirdParty();

    @Test(description = "Verify comment functionality.", groups = {"Third party"})
    public void VerifyCommentFunctionality_TC7() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        sleep(2000);
        objThirdParty.AssigningToLoggedInUser();
        sleep(2000);
        objThirdParty.AddComment();
        sleep(2000);
        objLoginOut.logout();
    }
}
