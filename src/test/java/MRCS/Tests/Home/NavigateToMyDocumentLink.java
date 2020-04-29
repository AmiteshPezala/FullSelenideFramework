package MRCS.Tests.Home;

import MRCS.Modules.Home;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class NavigateToMyDocumentLink extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Home objHome=new Home();

    @Test(description = "Assert User can navigate to My Documents", groups = {"Home"})
    public void NavigateToMyDocument() throws Exception {
         logTestStep("Log in to application");
         objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
         Common.PopUp();
         objHome.Homelink();
         sleep(2000);
         objHome.ClickOnMyDocument();
         sleep(2000);
         Common.StopWalkThru();
         sleep(2000);
         String value= $x("//div[@class='header bold']").getText();
         assertText(value,"YOUR DOCUMENTS");
         logTestStep("My Documents link verified Successfully");
         Log.info("My Documents link verified successfully");
         objLoginOut.logout();
    }
}
