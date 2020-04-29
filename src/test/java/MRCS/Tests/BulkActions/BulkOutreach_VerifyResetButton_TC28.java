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
import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class BulkOutreach_VerifyResetButton_TC28 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    BulkOutreach objBulkOutreach = new BulkOutreach();

    @Test(description = "Verify functionality of reset button", groups = {"Bulk Outreach"})
    public void BulkOutreachVerifyResetButton_TC28() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(5000);
        objBulkOutreach.FillingFormForSubmit();
        sleep(2000);
        $(BulkActionsRepo.IncludePendsYes).click();
        sleep(2000);
        $(BulkActionsRepo.SelectAll).click();
        sleep(2000);
        $x("//span[contains(text(),'RESET')]").click();
        sleep(2000);
        String CurrentFaxNo=$(BulkActionsRepo.FaxNo).getText();
        Log.info("CurrentFaxNo = " + CurrentFaxNo);
        sleep(2000);
        if(CurrentFaxNo.isEmpty() && $(BulkActionsRepo.SelectAll).isDisplayed()){
            logTestStepPass("All data get reset after click on reset button");
        }else{
            logTestStepFail("Reset button not working.");
        }
        objLoginOut.logout();
    }
}