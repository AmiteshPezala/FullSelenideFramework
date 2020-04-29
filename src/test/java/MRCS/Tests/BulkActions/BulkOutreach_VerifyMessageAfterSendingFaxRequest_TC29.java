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
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.DEFAULT_WAIT;
import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class BulkOutreach_VerifyMessageAfterSendingFaxRequest_TC29 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    BulkOutreach objBulkOutreach = new BulkOutreach();

    @Test(description = "Verify options for 'what do you want next' are available or not. ", groups = {"Bulk Outreach"})
    public void BulkOutreach_VerifyMessageAfterSendingFaxRequest_TC29() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(5000);
        objBulkOutreach.SubmitFaxRequest();
        $(CommonRepo.Loader).waitUntil(Condition.disappear,DEFAULT_WAIT);
        sleep(2000);
        String SuccessfulPage=$x("//div//h2").getText();
        Log.info("SuccessfulPage = "+ SuccessfulPage);
        String Tab1=$x("(//span//p-button)[1]").getText();
        sleep(2000);
        String Tab2=$x("(//span//p-button)[2]").getText();
        sleep(2000);
        String Tab3=$x("(//span//p-button)[3]").getText();
        sleep(2000);
        if(Tab1.contains("START A NEW BULK ACTION") && Tab2.contains("VIEW PENDING ACTIONS") && Tab3.contains("VIEW ARCHIVE")){
            logTestStepPass("All tabs are present");
        }else {
            logTestStepFail("All tabs are not present");
        }
        objLoginOut.logout();
    }
}
