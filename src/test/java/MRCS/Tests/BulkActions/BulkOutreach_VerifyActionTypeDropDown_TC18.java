package MRCS.Tests.BulkActions;

import MRCS.Locators.BulkActionsRepo;
import MRCS.Locators.LoginOutRepo;
import MRCS.Modules.BulkActionsModule.BulkOutreach;
import MRCS.Modules.LoginOut;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.TestBase.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class BulkOutreach_VerifyActionTypeDropDown_TC18 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    BulkOutreach objBulkOutreach = new BulkOutreach();

    @Test(description = "Verify action type drop down.", groups = {"Bulk Outreach"})
    public void BulkOutreach_VerifyActionTypeDropDown_TC18() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(2000);
        ClickElement(LoginOutRepo.NavigationBar, "Navigation bar ");
        logTestStep("Clicked on Navigation bar");
        objBulkOutreach.BulkOutreachLink();
        sleep(5000);
        if($(BulkActionsRepo.ActionTypeDropDown).isDisplayed()){
            logTestStepPass("Drop down of action type is present.");
            sleep(2000);
            $(BulkActionsRepo.ActionTypeDropDown).click();
            sleep(2000);
            if($(BulkActionsRepo.OptionFax).isDisplayed()){
                logTestStepPass("Fax option is present.");
            }else{
                logTestStepFail("Fax option is not present.");
            }
        }else{
            logTestStepFail("Drop down of action type is not present.");
        }
        objLoginOut.logout();
    }
}
