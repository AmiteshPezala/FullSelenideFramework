package MRCS.Tests.Login;


import MRCS.Locators.LoginOutRepo;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import MRCS.TestData.GlobalTestData;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class VerifyAbleToLogin extends TestBase {

    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();

    @Test(description = "To verify that User is able to login", groups = {"Login"})
    public void loginToMrcs() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        sleep(5000);
        Common.PopUp();
        //objWait.implicitwait();
        String svalue=$(LoginOutRepo.UatAdmin).getText();
        String username=(GlobalTestData.UserName_Users).getUserId();
        assertText(svalue,username);
        Log.info("User logged in successfully");
        objLoginOut.logout();
    }
}
