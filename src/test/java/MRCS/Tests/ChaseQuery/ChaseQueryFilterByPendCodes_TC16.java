package MRCS.Tests.ChaseQuery;

import MRCS.Modules.LoginOut;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

public class ChaseQueryFilterByPendCodes_TC16 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Projects objProject=new Projects();
    WaitTool objWait = new WaitTool();

    @Test(description = "Chase Query Filter By Pend codes", groups = {"Chase Query"})
    public void SearchByPendCodes() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        logTestStep("Verifying ChaseQuery filter Pend Codes ");
        objProject.ProjectsLink();
        logTestStep("Click on Chase Query ");
        objProject.ChaseQuery();
        objProject.FilterByPendCode();
        logTestStep("Verified that User should be able to query by Pend codes");
        objLoginOut.logout();
    }

}
