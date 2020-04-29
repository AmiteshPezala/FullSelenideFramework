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

public class BulkOutreach_VerifyProjectSelectionOption_TC21 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    BulkOutreach objBulkOutreach = new BulkOutreach();

    @Test(description = "Verify project selection option.", groups = {"Bulk Outreach"})
    public void BulkOutreach_VerifyProjectSelectionOption_TC21() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(5000);
        String User = $(BulkActionsRepo.LoggedInUserName).getText();
        Log.info("User = " + User);
        ClickElement(LoginOutRepo.NavigationBar, "Navigation bar ");
        logTestStep("Clicked on Navigation bar");
        objBulkOutreach.BulkOutreachLink();
        sleep(5000);
        $(BulkActionsRepo.ActionTypeDropDown).click();
        sleep(2000);
        $(BulkActionsRepo.OptionFax).click();
        sleep(2000);
        $(BulkActionsRepo.WhoIsSendingFax).setValue(User);
        sleep(2000);
        $(BulkActionsRepo.FaxNo).setValue("1234");
        sleep(2000);
        $x("//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']").click();
        sleep(2000);
        if($x("//span[@class='ui-chkbox-icon ui-clickable pi pi-check']").isDisplayed()){
            logTestStepPass("Project is selected.");
        }else{
            logTestStepFail("Project is not selected.");
        }
        objLoginOut.logout();
    }
}