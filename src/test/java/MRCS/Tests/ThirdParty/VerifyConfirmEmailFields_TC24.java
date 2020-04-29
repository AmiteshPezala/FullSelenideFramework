package MRCS.Tests.ThirdParty;

import MRCS.Locators.RetrievalRepo.RetrievalPSRRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.ThirdParty;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static MRCS.Utils.TestBase.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class VerifyConfirmEmailFields_TC24 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    ThirdParty objThirdParty = new ThirdParty();

    @Test(description = "Verify fields for the mail form.", groups = {"Third party"})
    public void VerifyConfirmEmailFields_TC24() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        sleep(2000);
        //objWait.implicitwait();
        objThirdParty.ThirdPartyLink();
        sleep(2000);
        objThirdParty.ConfirmEmailFields();
        objLoginOut.logout();
    }
}
