package MRCS.Tests.Login;

import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class AuthenticationLoginLogout extends TestBase {

    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();

    @Test(description = "Assert HDV user can log out.", groups = {"Login"})
    public void loginToMrcs() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        sleep(2000);
        //objWait.implicitwait();
        objLoginOut.logout();
        sleep(2000);
        logTestStep("User get logged out");
        if($x("//span[contains(text(),'LOGIN')]").isDisplayed())
        {
            logTestStepPass("User logout successfully");
        }
        else
        {
            logTestStepFail("User not logout");
            Assert.fail("User not logout");
        }
    }
}
