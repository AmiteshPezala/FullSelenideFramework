package MRCS.Tests.Home;

import MRCS.Modules.Home;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class NavigateToMySitesLink extends TestBase {

        LoginOut objLoginOut = new LoginOut();
        Home objHome=new Home();
        WaitTool objWait = new WaitTool();

        @Test(description = "To verify that user can navigate to My Sites link", groups = {"Home"})
        public void VerifyMySitesLink() throws Exception {
            logTestStep("Log in to application");
            objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
            Common.PopUp();
            logTestStep("Clicking on My sites link ");
            objHome.Homelink();
            objHome.clickOnMySites();
            sleep(2000);
            Common.StopWalkThru();
            sleep(2000);
            Log.info("Clicked on MySites link successful");
            String site=$x("//div[@class='header bold'][contains(text(),'YOUR ADDRESSES')]").getText();
            assertText(site,"YOUR ADDRESSES");
            logTestStep("My Sites link verified Successfully");
            Log.info("My Sites link verified successfully");
            objLoginOut.logout();
        }
    }


