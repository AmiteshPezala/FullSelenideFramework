package MRCS.Tests.MemberChases;

import MRCS.Locators.AdminMenuRepo.UsersRepo;
import MRCS.Locators.CommonRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.MRR.MemberChases;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import static MRCS.Utils.Common.DEFAULT_WAIT;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class VerifyGridExport_TC3 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Verify grid export", groups = {"Member Chases"})
    public void VerifyGridExport() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        MemberChases.NavigateToMemberChases();
        MemberChases.MemberTab();
        //sleep(20000);
        Common.waitForLoader();
        if ($(CommonRepo.FirstChaseId).isDisplayed()) {
            $(UsersRepo.ExportButton).waitUntil(Condition.enabled, DEFAULT_WAIT).click();
            logTestStep("Clicked on Export all button");
            Common.DownloadCsv();
            logTestStepPass("Data get exported");
        }else{
            logTestStep("Records are not present");
        }
        objLoginOut.logout();
    }
}
