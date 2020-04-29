package MRCS.Tests.AdminMenu;

import MRCS.Locators.AdminRepo;
import MRCS.Locators.LoginOutRepo;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.TestBase.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class Organization_VerifyGroupTab_TC24 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();

    @Test(description = "Verify that client groups are available or not.", groups = {"Admin Menu"})
    public void Organization_VerifyGroupTab_TC24() throws Exception {
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
        logTestStep("Clicked on Organization");
        sleep(2000);
        $x("//div[contains(text(),'Group')]").click();
        sleep(2000);
        logTestStep("Clicked on group tab .");
        if($x("//tr[1]//td[1]").isDisplayed()){
            logTestStepPass("Client groups are available.");
        }else{
            logTestStepFail("Client groups are not available.");
        }
        objLoginOut.logout();
    }
}