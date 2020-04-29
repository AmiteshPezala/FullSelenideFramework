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

public class NavigateToChaseLink extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Home objHome=new Home();
    WaitTool objWait = new WaitTool();

    @Test(description = "To verify that user can navigate to My Chases link", groups = {"Home"})
    public void VerifyMyChasesLink() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        logTestStep("Clicking on My Chases link ");
        objHome.Homelink();
        objHome.clickOnMyChases();
        sleep(2000);
        Common.StopWalkThru();
        sleep(2000);
        Log.info("Clicked on My Chases link successful");
        String site = $x("//div[@class='header bold'][contains(text(),'YOUR CHASES')]").getText();
        assertText(site, "YOUR CHASES");
        logTestStep("My Chases link verified Successfully");
        Log.info("My Chases link verified successfully");
        objLoginOut.logout();
    }
}
