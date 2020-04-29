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
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class BulkOutreach_VerifyStatsResultPriorToFax_TC27 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    BulkOutreach objBulkOutreach = new BulkOutreach();

    @Test(description = "Verify that result of query is prior of sending fax request.", groups = {"Bulk Outreach"})
    public void BulkOutreach_VerifyStatsResultPriorToFax_TC27() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(5000);
        objBulkOutreach.FillingFormForSubmit();
        $(BulkActionsRepo.IncludePendsYes).click();
        sleep(2000);
        $(BulkActionsRepo.SelectAll).click();
        sleep(2000);
        if($(BulkActionsRepo.SubmitFax).isDisplayed()){
            logTestStepFail("To submit fax request query result is not important.");
        }else{
            logTestStepPass("To submit fax request query result is important.");
        }
        $x("//span[contains(text(),'RUN QUERY')]").click();
        sleep(2000);
        $(CommonRepo.Loader).waitUntil(Condition.disappear,DEFAULT_WAIT);
        sleep(10000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $(BulkActionsRepo.SubmitFax));
        sleep(2000);
        if($(BulkActionsRepo.SubmitFax).isDisplayed()){
            logTestStepPass("User is presented with a view of stats/results of the query prior to sending the bulk fax.");
        }else{
            logTestStepFail("User is not presented with a view of stats/results of the query prior to sending the bulk fax.");
        }
        objLoginOut.logout();
    }
}

