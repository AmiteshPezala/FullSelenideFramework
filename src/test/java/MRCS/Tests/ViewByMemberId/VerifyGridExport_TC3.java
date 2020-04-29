package MRCS.Tests.ViewByMemberId;

import MRCS.Locators.AdminMenuRepo.UsersRepo;
import MRCS.Modules.AdminMenuModule.User;
import MRCS.Modules.LoginOut;
import MRCS.Modules.MemberCentric.Members;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class VerifyGridExport_TC3 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Verify grid export", groups = {"View By Member Id"})
    public void VerifyGridExport() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        Members.NavigateToMemberTab();
        sleep(20000);
        $(UsersRepo.ExportButton).click();
        logTestStep("Clicked on Export all button");
        Common.DownloadCsv();
        logTestStepPass("Data get exported");
        objLoginOut.logout();
    }
}
