package MRCS.Tests.BulkActions;

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

public class BulkOutreach_VerifyRedirectionOfPageForNewBulkAction_TC30 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    BulkOutreach objBulkOutreach = new BulkOutreach();

    @Test(description = "Verify page redirection after click on new bulk action.", groups = {"Bulk Outreach"})
    public void BulkOutreach_VerifyRedirectionOfPageForNewBulkAction_TC30() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(5000);
        objBulkOutreach.SubmitFaxRequest();
        sleep(200);
        $x("//span[contains(text(),'START A NEW BULK ACTION')]").click();
        sleep(2000);
        if($x("//label[contains(text(),'Action Type')]").isDisplayed() && $x("//label[contains(text(),'WHO IS SENDING THIS FAX')]").isDisplayed()){
            logTestStepPass("After click on 'New Bulk Action' page redirects to new bulk action tab.");
        }else{
            logTestStepFail("Page not redirects to new bulk action tab.");
        }
        objLoginOut.logout();
    }

}
