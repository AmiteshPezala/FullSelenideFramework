package MRCS.Tests.AdminMenu;
import MRCS.Locators.AdminMenuRepo.UsersRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;
import static MRCS.Modules.AdminMenuModule.User.NavigateToUsers;
import static MRCS.Utils.Common.*;
import static com.codeborne.selenide.Selenide.*;

public class VerifyUserGridFilter_TC12 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Data get filtered as per the filter option selected", groups = {"Admin Menu"})
    public void VerifyUserGridFilter() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        //objWait.implicitwait();
        NavigateToUsers();
        sleep(2000);
        ClickElement(ProjectsRepo.Filter,"Filter");
        ClickElement(ProjectsRepo.Status,"Status");
        ClickElement(UsersRepo.InActiveRadioButton,"InActive Radio Button");
        ClickElement(ProjectsRepo.Update,"update");
        waitForPageLoadToComplete();
        sleep(5000);
        int StatusCount = $$x("//tr//td[6]").size();
        for(int i=0;i<=StatusCount-1;i++)
        {
            String Status=$x("//tr[\" + (i + 1) + \"]//td[6]").getText();
            assertText(Status,"Inactive");
        }
        objLoginOut.logout();
    }
}
