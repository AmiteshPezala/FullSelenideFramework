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

public class BulkOutreach_VerifyFaxNoField_TC20 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    BulkOutreach objBulkOutreach = new BulkOutreach();

    @Test(description = "Verify that user can eneter fax number or not.", groups = {"Bulk Outreach"})
    public void BulkOutreach_VerifyFaxNoField_TC20() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(5000);
        String User = $(BulkActionsRepo.LoggedInUserName).getText();
        Log.info("User = " + User);
        ClickElement(LoginOutRepo.NavigationBar, "Navigation bar ");
        logTestStep("Clicked on Navigation bar");
        objBulkOutreach.BulkOutreachLink();
        sleep(2000);
        $(BulkActionsRepo.ActionTypeDropDown).click();
        sleep(2000);
        $(BulkActionsRepo.OptionFax).click();
        sleep(2000);
        $(BulkActionsRepo.WhoIsSendingFax).setValue(User);
        sleep(2000);
        $(BulkActionsRepo.FaxNo).setValue("1234");
        sleep(2000);
        String FaxNo=$(BulkActionsRepo.FaxNo).getValue();
        Log.info("FaxNo = " + FaxNo);
        sleep(2000);
        if(FaxNo.equals("1234")){
            logTestStepPass("Entered fax no is displayed.");
        }else{
            logTestStepFail("Entered fax no is not displayed.");
        }
        objLoginOut.logout();
    }
}