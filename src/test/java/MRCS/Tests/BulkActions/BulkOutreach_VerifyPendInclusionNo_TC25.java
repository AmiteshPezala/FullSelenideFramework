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

public class BulkOutreach_VerifyPendInclusionNo_TC25 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    BulkOutreach objBulkOutreach = new BulkOutreach();

    @Test(description = "Verify No option of pend inclusion.", groups = {"Bulk Outreach"})
    public void BulkOutreach_VerifyPendInclusionNo_TC25() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(5000);
       objBulkOutreach.FillingFormForSubmit();
        $(BulkActionsRepo.IncludePendsNo).click();
        sleep(2000);
        if($(BulkActionsRepo.RunQuery).isEnabled()){
            logTestStepPass("User can run the query without selecting pends.");
        }else{
            logTestStepFail("User can not run the query without selecting pends.");
        }
        objLoginOut.logout();
    }
}