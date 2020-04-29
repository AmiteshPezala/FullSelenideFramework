package MRCS.Tests.ChaseQuery;

import MRCS.Modules.LoginOut;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class ChaseQueryFilterByProject_TC13 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Projects objProject = new Projects();
    WaitTool objWait = new WaitTool();

    @Test(description = "Chase Query - Filter By Project Name", groups = {"Chase Query"})
    public void FilterByProject() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        logTestStep("Click On ChaseQuery Link");
        objProject.ProjectsLink();
        logTestStep("Click on Chase Query");
        objProject.ChaseQuery();
        sleep(1000);
        objProject.FilterByProject();
        objLoginOut.logout();
    }

}
