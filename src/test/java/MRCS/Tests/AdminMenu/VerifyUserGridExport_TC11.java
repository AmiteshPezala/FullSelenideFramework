package MRCS.Tests.AdminMenu;
import MRCS.Locators.AdminMenuRepo.UsersRepo;
import MRCS.Modules.AdminMenuModule.User;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import static MRCS.Modules.AdminMenuModule.User.NavigateToUsers;
import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.sleep;

public class VerifyUserGridExport_TC11 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Verify the exportAll functionality", groups = {"Admin Menu"})
    public void VerifyUserGridExport() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        //objWait.implicitwait();
        NavigateToUsers();
        sleep(20000);
        ClickElement(UsersRepo.ExportButton,"Export");
        logTestStep("Clicked on Export all button");
        Common.DownloadCsv();
        logTestStepPass("Data get exported");
        objLoginOut.logout();
    }
}
