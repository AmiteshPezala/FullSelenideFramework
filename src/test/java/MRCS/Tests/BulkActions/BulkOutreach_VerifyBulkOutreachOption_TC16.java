package MRCS.Tests.BulkActions;

import MRCS.Locators.LoginOutRepo;
import MRCS.Modules.BulkActionsModule.BulkChanges;
import MRCS.Modules.BulkActionsModule.BulkOutreach;
import MRCS.Modules.LoginOut;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.assertText;
import static MRCS.Utils.TestBase.*;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class BulkOutreach_VerifyBulkOutreachOption_TC16 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    BulkOutreach objBulkOutreach = new BulkOutreach();

    @Test(description = "Verify that user can do bulk action with bulk outreach option.", groups = {"Bulk Outreach"})
    public void BulkOutreach_VerifyBulkOutreachOption_TC16() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(2000);
        ClickElement(LoginOutRepo.NavigationBar, "Navigation bar ");
        logTestStep("Clicked on Navigation bar");
        objBulkOutreach.BulkOutreachLink();
        sleep(5000);
        String Header = $x("//*[@class='description']").getText();
        sleep(2000);
        if (Header.equals("New Bulk Action")) {
            logTestStepPass("User can perform new bulk action.");
        } else {
            logTestStepFail("User can not perform new bulk action.");
        }
        objLoginOut.logout();
    }
}
