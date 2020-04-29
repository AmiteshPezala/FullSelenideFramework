package MRCS.Tests.AdminMenu;

import MRCS.Locators.AdminRepo;
import MRCS.Locators.LoginOutRepo;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.assertText;
import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class Organization_VerifyOrgnizationDataUpdate_TC23 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();

    @Test(description = "Verify that admin can edit organization's all data except telephone and fax.", groups = {"Admin Menu"})
    public void VerifyOrgnizationDataUpdate_TC23() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        //sleep(5000);
        logTestStep("Clicking on Navigation bar");
        ClickElement(LoginOutRepo.NavigationBar, "Navigation bar ");
        Log.info("Clicked on Navigation bar");
        logTestStep("Clicking on Admin Link");
        ClickElement(AdminRepo.Admin, "Admin");
        Log.info("Clicked on Admin");
        ClickElement(AdminRepo.Organization, "Organization");
        Log.info("Clicked on Organization");
        sleep(3000);
        $x("(//label[contains(text(),'Telephone')]//following::input)[1]").shouldBe(Condition.readonly);
        $x("(//label[contains(text(),'Fax')]//following::input)[1]").shouldBe(Condition.readonly);
        objLoginOut.logout();
    }
}
