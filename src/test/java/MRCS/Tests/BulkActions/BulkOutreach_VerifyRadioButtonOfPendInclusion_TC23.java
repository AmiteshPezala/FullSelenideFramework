package MRCS.Tests.BulkActions;

import MRCS.Locators.BulkActionsRepo;
import MRCS.Locators.LoginOutRepo;
import MRCS.Modules.BulkActionsModule.BulkOutreach;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.ElementsCollection;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.TestBase.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class BulkOutreach_VerifyRadioButtonOfPendInclusion_TC23 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    BulkOutreach objBulkOutreach = new BulkOutreach();

    @Test(description = "Verify that radio buttons are available for pend inclusion or not.", groups = {"Bulk Outreach"})
    public void BulkOutreach_VerifyRadioButtonOfPendInclusion_TC23() throws Exception {
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
        sleep(5000);
        $(BulkActionsRepo.SelectAll).click();
        sleep(3000);
        ElementsCollection RadioButton=$$x("//div//p-radiobutton");
        int CountOfRadioButton=RadioButton.size();
        Log.info("CountOfRadioButton = "+ CountOfRadioButton);
        sleep(2000);
        if(CountOfRadioButton == 2){
            logTestStepPass("Yes and No radio buttons are available for pend inclusion.");
        }else{
            logTestStepFail("Radio buttons are not available for pend inclusion.");
        }
        objLoginOut.logout();
    }
}