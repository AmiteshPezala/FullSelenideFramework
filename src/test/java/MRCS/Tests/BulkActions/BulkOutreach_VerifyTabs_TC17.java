package MRCS.Tests.BulkActions;

import MRCS.Locators.LoginOutRepo;
import MRCS.Modules.BulkActionsModule.BulkOutreach;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class BulkOutreach_VerifyTabs_TC17 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    BulkOutreach objBulkOutreach = new BulkOutreach();

    @Test(description = "Verify tabs of bulk outreach module.", groups = {"Bulk Outreach"})
    public void BulkOutreach_VerifyTabs_TC17() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(2000);
        ClickElement(LoginOutRepo.NavigationBar, "Navigation bar ");
        logTestStep("Clicked on Navigation bar");
        objBulkOutreach.BulkOutreachLink();
        sleep(5000);
        String Tab1=$x("(//div[@class='button'])[1]").getText();
        Log.info("Tab 1 = " + Tab1) ;
        String Tab2=$x("(//div[@class='button'])[2]").getText();
        Log.info("Tab 2 = "+ Tab2);
        String Tab3=$x("(//div[@class='button'])[3]").getText();
        Log.info("Tab 3 = " +Tab3);
        if(Tab1.equals("New Bulk Action")){
            logTestStepPass("First tab of New Bulk Action is present.");
        }else{
            logTestStepFail("First tab of New Bulk Action is not present.");
        }
        if(Tab2.equals("Pending Actions")){
            logTestStepPass("Second tab of Pending actions is present.");
        }
        else{
            logTestStepFail("Second tab of Pending actions is not present.");
        }
        if(Tab3.equals("Archive")){
            logTestStepPass("Third tab of Archive is present.");
        }else{
            logTestStepFail("Third tab of Archive is not present. ");
        }
        objLoginOut.logout();
    }
}
