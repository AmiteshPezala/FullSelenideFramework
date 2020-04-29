package MRCS.Tests.BulkActions;

import MRCS.Locators.CommonRepo;
import MRCS.Modules.BulkActionsModule.BulkOutreach;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.DEFAULT_WAIT;
import static MRCS.Utils.Common.assertText;
import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class BulkOutreach_VerifyMessageOnSubmitFaxPage_TC36 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    BulkOutreach objBulkOutreach = new BulkOutreach();

    @Test(description = "Verify successful message after submitting fax .", groups = {"Bulk Outreach"})
    public void BulkOutreach_VerifyMessageOnSubmitFaxPage_TC36() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(5000);
        objBulkOutreach.SubmitFaxRequest();
        $(CommonRepo.Loader).waitUntil(Condition.disappear, DEFAULT_WAIT);
        sleep(2000);
        String SuccessfulMessage1 = $x("//div//h2").getText();
        assertText(SuccessfulMessage1, "You're done! We'll do the rest.");
        String SuccessfulMessage2=$x("//div//h4").getText();
        assertText(SuccessfulMessage2, "Feel free to check back anytime to see the status of your pending faxes.");
        String SuccessfulMessage3=$x("//div//h3").getText();
        assertText(SuccessfulMessage3, "What do you want to do next?");
        objLoginOut.logout();
    }
}