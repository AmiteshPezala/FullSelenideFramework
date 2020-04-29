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
import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class BulkOutreach_VerifySelectAllProjectOption_TC22 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    BulkOutreach objBulkOutreach = new BulkOutreach();

    @Test(description = "Verify select all project option.", groups = {"Bulk Outreach"})
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
        sleep(5000);
        ElementsCollection Checkbox=$$x("//label[contains(text(),'SELECT STATUS(S)')]//preceding::div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']");
        int CountBeforeSelecting=Checkbox.size();
        Log.info("CountBeforeSelecting = " + CountBeforeSelecting);
        sleep(2000);
        $(BulkActionsRepo.SelectAll).click();
        sleep(3000);
        ElementsCollection SelectedCheckbox=$$x("//label[contains(text(),'SELECT STATUS(S)')]//preceding::span[@class='ui-chkbox-icon ui-clickable pi pi-check']");
        int CountAfterSelecting=SelectedCheckbox.size();
        Log.info("CountAfterSelecting = " + CountAfterSelecting);
        sleep(2000);
        if(CountBeforeSelecting == CountAfterSelecting){
            logTestStepPass("All projects are selected with select all option.");
        }else{
            logTestStepFail("All projects are not selected with select all option.");
        }
        objLoginOut.logout();
    }
}