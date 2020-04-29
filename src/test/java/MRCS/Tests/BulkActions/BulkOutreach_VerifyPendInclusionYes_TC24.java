package MRCS.Tests.BulkActions;

import MRCS.Locators.BulkActionsRepo;
import MRCS.Locators.LoginOutRepo;
import MRCS.Modules.BulkActionsModule.BulkOutreach;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.TestBase.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class BulkOutreach_VerifyPendInclusionYes_TC24 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    BulkOutreach objBulkOutreach = new BulkOutreach();

    @Test(description = "Verify yes option of pend inclusion.", groups = {"Bulk Outreach"})
    public void BulkOutreach_VerifyPendInclusionYes_TC24() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(5000);
        objBulkOutreach.FillingFormForSubmit();
        $(BulkActionsRepo.IncludePendsYes).click();
        sleep(2000);
        if($x("//label[contains(text(),'SELECT PEND(S)')]").isDisplayed() && $x("//label[contains(text(),'SELECT STATUS(S)')]//following::div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']").isDisplayed()){
            logTestStepPass("List of pend codes is displayed");
        }else{
            logTestStepFail("List of pend code is not displayed.");
        }
        sleep(2000);
        $(BulkActionsRepo.SelectAll).click();
        sleep(2000);
        if($(BulkActionsRepo.RunQuery).isEnabled()){
            logTestStepPass("User can run the query with pends selected.");
        }else{
            logTestStepFail("User can not run the query with selected pends.");
        }
        objLoginOut.logout();
    }
}
