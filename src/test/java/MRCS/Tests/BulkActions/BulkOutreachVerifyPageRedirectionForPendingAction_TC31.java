package MRCS.Tests.BulkActions;

import MRCS.Locators.BulkActionsRepo;
import MRCS.Locators.CommonRepo;
import MRCS.Locators.LoginOutRepo;
import MRCS.Modules.BulkActionsModule.BulkOutreach;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.DEFAULT_WAIT;
import static MRCS.Utils.TestBase.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class BulkOutreachVerifyPageRedirectionForPendingAction_TC31 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    BulkOutreach objBulkOutreach = new BulkOutreach();

    @Test(description = "Verify page redirection after click on view pending action.", groups = {"Bulk Outreach"})
    public void BulkOutreachVerifyPageRedirectionForPendingAction_TC31() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(5000);
        objBulkOutreach.SubmitFaxRequest();
        sleep(2000);
        $(BulkActionsRepo.ViewPendingAction).click();
        sleep(2000);
        if($x("//div[contains(text(),'New Bulk Action')]//following::a[@class='link active']").isDisplayed()){
            logTestStepPass("After click on 'View Pending Action' page is redirected to pending action tab.");
        }else{
            logTestStepFail("Page not redirect to pending action tab.");
        }
        objLoginOut.logout();
    }
}