package MRCS.Tests.ThirdParty;

import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.RetrievalFT;
import MRCS.Modules.RetrievalModule.ThirdParty;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.sleep;

public class VerifyEditAddress_TC3 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    ThirdParty objThirdParty = new ThirdParty();

    @Test(description = "Verify edit address functionality.", groups = {"Third party"})
    public void VerifyEditAddress_TC3() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        Thread.sleep(2000);
        //objWait.implicitwait();
        objThirdParty.ThirdPartyLink();
        sleep(2000);
        objThirdParty.EditAddress();
        sleep(2000);
        objLoginOut.logout();
    }
}
