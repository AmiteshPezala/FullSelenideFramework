package MRCS.Tests.BulkActions;

import MRCS.Locators.BulkActionsRepo;
import MRCS.Locators.LoginOutRepo;
import MRCS.Modules.BulkActionsModule.BulkChanges;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$$;
import static java.lang.Thread.sleep;

public class BulkChanges_VerifyBulkPendUpdate_TC38 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    BulkChanges objBulkAction = new BulkChanges();

    @Test(description = "Verify user can select bulk action update when bulk type update =pend", groups = {"Bulk Actions"})
    public void BulkActions_VerifyBulkPendUpdate() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(2000);
        ClickElement(LoginOutRepo.NavigationBar,"Navigation bar ");
        BulkChanges.BulkChangesLink();
        sleep(5000);
        $$(BulkActionsRepo.DropDownIcon).filter(Condition.visible).first().click();
        String getTypeOfBulkUpdate=$$(BulkActionsRepo.DropDownElement).filter(Condition.visible).get(1).getText();
        Common.assertText(getTypeOfBulkUpdate,"Pend");
        logTestStepPass("User can select bulk action update when bulk type update =pend");
        objLoginOut.logout();
    }
}
