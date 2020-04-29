package MRCS.Tests.BulkActions;

import MRCS.Locators.BulkActionsRepo;
import MRCS.Locators.CommonRepo;
import MRCS.Locators.LoginOutRepo;
import MRCS.Modules.BulkActionsModule.BulkChanges;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.DEFAULT_WAIT;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.lang.Thread.sleep;

public class BulkChanges_Verify3rdPartyField_TC39 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    BulkChanges objBulkAction = new BulkChanges();

    @Test(description = "Verify that update 3rd party field option is available in bulk action drop down", groups = {"Bulk Actions"})
    public void BulkActions_VerifyBulkPendUpdate() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(2000);
        ClickElement(LoginOutRepo.NavigationBar,"Navigation bar ");
        BulkChanges.BulkChangesLink();
        sleep(5000);
        $$(BulkActionsRepo.DropDownIcon).filter(Condition.visible).get(0).click();
        $$(BulkActionsRepo.DropDownElement).filter(Condition.visible).get(1).click();
        $(CommonRepo.Loader).waitUntil(Condition.disappear,DEFAULT_WAIT);
        $$(BulkActionsRepo.DropDownIcon).filter(Condition.visible).get(1).click();
        String getTypeOfBulkUpdate=$$(BulkActionsRepo.DropDownElement).filter(Condition.visible).get(4).getText();
        Common.assertText(getTypeOfBulkUpdate,"Update 3rd Party Fields");
        logTestStepPass("Update 3rd party field option is available in bulk action drop down");
        objLoginOut.logout();
    }
}
