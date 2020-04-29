package MRCS.Tests.BulkActions;

import MRCS.Locators.BulkActionsRepo;
import MRCS.Locators.LoginOutRepo;
import MRCS.Modules.BulkActionsModule.BulkOutreach;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.TestBase.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class BulkOutreach_VerifyWhoIsSendingFaxField_TC19 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    BulkOutreach objBulkOutreach = new BulkOutreach();

    @Test(description = "Verify who is sending fax field.", groups = {"Bulk Outreach"})
    public void BulkOutreach_VerifyWhoIsSendingFaxField_TC19() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(2000);
        ClickElement(LoginOutRepo.NavigationBar, "Navigation bar ");
        logTestStep("Clicked on Navigation bar");
        String User = $(BulkActionsRepo.LoggedInUserName).getText();
        Log.info("User = " + User);
        objBulkOutreach.BulkOutreachLink();
        sleep(2000);
        String WhoIsSendingFax = $(BulkActionsRepo.WhoIsSendingFax).getValue();
        sleep(2000);
        Log.info("WhoIsSendingFax = " + WhoIsSendingFax);
        if(User.equals(WhoIsSendingFax)){
            logTestStepPass("Logged in user is default user for the field.");
            $(BulkActionsRepo.WhoIsSendingFax).setValue("Test");
            sleep(2000);
            String UserName =$(BulkActionsRepo.WhoIsSendingFax).getValue();
            sleep(2000);
            Log.info("UserName = " + UserName);
            if(UserName.equals("Test")){
                logTestStepPass("Default user name can be edited.");
            }else{
                logTestStepFail("Default user name can not be edited.");
            }
        }else{
            logTestStepFail("Logged in user is not default user for the field.");
        }
        objLoginOut.logout();
    }
}
