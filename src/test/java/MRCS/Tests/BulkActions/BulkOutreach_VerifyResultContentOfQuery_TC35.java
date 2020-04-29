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

public class BulkOutreach_VerifyResultContentOfQuery_TC35 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    BulkOutreach objBulkOutreach = new BulkOutreach();

    @Test(description = "Verify all result data is present or not", groups = {"Bulk Outreach"})
    public void BulkOutreach_VerifyResultContentOfQuery_TC35() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(5000);
        objBulkOutreach.FillingFormForSubmit();
        $(BulkActionsRepo.IncludePendsYes).click();
        sleep(2000);
        $(BulkActionsRepo.SelectAll).click();
        sleep(3000);
        $(BulkActionsRepo.RunQuery).click();
        sleep(2000);
        $(CommonRepo.Loader).waitUntil(Condition.disappear,DEFAULT_WAIT);
        sleep(10000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//span[contains(text(),'SUBMIT FAX REQUEST')]"));
        sleep(2000);
        String ProjectName =$x("//div[contains(text(),'PROJECTS:')]//span").getText();
        String AIds=$x("//div[contains(text(),'AIDs:')]//span").getText();
        String Chases=$x("//div[contains(text(),'CHASES:')]//span").getText();
        String Sender=$x("//div[contains(text(),'SENDER:')]//span").getText();
        String FaxingFrom=$x("//div[contains(text(),'FAXING FROM #:')]//span").getText();
        sleep(2000);
        if(ProjectName.isEmpty()){
            logTestStepFail("Project name is not displayed.");
        }else{
            logTestStepPass("Project name is displayed.");
        }
        if(AIds.isEmpty()){
            logTestStepFail("AIDs are not displayed.");
        }else{
            logTestStepPass("AIDs are displayed.");
        }
        if(Chases.isEmpty()){
            logTestStepFail("Chases are not displayed.");
        }else{
            logTestStepPass("Chases are displayed.");
        }
        if(Sender.isEmpty()){
            logTestStepFail("Sender is not displayed.");
        }else{
            logTestStepPass("Sender is displayed.");
        }
        if(FaxingFrom.isEmpty()){
            logTestStepFail("Faxing From is not displayed.");
        }else{
            logTestStepPass("Faxing From is displayed.");
        }
        objLoginOut.logout();
    }
}
