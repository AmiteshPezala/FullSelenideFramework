package MRCS.Tests.BulkActions;

import MRCS.Modules.BulkActionsModule.BulkOutreach;
import MRCS.Modules.LoginOut;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.TestBase.*;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class BulkOutreach_VerifyRedirectionOfPageForArchiveTab_TC33 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    BulkOutreach objBulkOutreach = new BulkOutreach();

    @Test(description = "Verify page redirection of archive option.", groups = {"Bulk Outreach"})
    public void BulkOutreach_VerifyRedirectionOfPageForArchiveTab_TC33() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(5000);
        objBulkOutreach.SubmitFaxRequest();
        sleep(2000);
        $x("//span[contains(text(),'VIEW ARCHIVE')]").click();
        sleep(2000);
        if($x("//div[contains(text(),'Pending Actions')]//following::a[@class='link active']").isDisplayed()){
            logTestStepPass("After click on 'View archive' page is redirected to Archive tab.");
        }else {
            logTestStepFail("Page not redirect to archive tab.");
        }
        objLoginOut.logout();
    }
}
