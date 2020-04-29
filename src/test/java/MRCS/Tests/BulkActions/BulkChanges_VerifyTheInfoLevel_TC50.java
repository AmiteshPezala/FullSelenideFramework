package MRCS.Tests.BulkActions;
import MRCS.Locators.BulkActionsRepo;
import MRCS.Locators.CommonRepo;
import MRCS.Locators.LoginOutRepo;
import MRCS.Modules.BulkActionsModule.BulkChanges;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.DEFAULT_WAIT;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.lang.Thread.sleep;

public class BulkChanges_VerifyTheInfoLevel_TC50 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Verify the info label available near pend ID field", groups = {"Bulk Actions"})
    public void BulkChanges_VerifyTheInfoLevel() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(2000);
        ClickElement(LoginOutRepo.NavigationBar,"Navigation bar ");
        logTestStep("Clicked on Navigation bar");
        BulkChanges.BulkChangesLink();
        $$(BulkActionsRepo.DropDownIcon).filter(Condition.visible).get(0).click();
        $$(BulkActionsRepo.DropDownElement).filter(Condition.visible).get(1).click(); // selecting RetrievalPend from drop down
        $(CommonRepo.Loader).waitUntil(Condition.disappear,DEFAULT_WAIT);
        $$(BulkActionsRepo.DropDownIcon).filter(Condition.visible).get(1).click();
        $$(BulkActionsRepo.DropDownElement).filter(Condition.visible).get(4).click();
        String getMsg= Common.getElementText(By.cssSelector(".invoice-pendcode"),10);
        Common.assertText(getMsg,"Please make sure pend codes are invoice specific.");
        objLoginOut.logout();
    }
}
