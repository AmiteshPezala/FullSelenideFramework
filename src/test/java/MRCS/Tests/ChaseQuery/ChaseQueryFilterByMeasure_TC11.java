package MRCS.Tests.ChaseQuery;

import MRCS.Modules.LoginOut;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

public class ChaseQueryFilterByMeasure_TC11 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Projects objProject=new Projects();
    WaitTool objWait= new WaitTool();

    @Test(description = "Chase Query - Filter By Measure", groups = {"Chase Query"})
    public void SearchByMeasures() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        logTestStep("Verifying that User should be able to query by Measures and see search results only for selected Measures ");
        objProject.ProjectsLink();
        logTestStep("Click on Chase Query ");
        objProject.ChaseQuery();
        objProject.ChaseQueryMeasure();
        logTestStep("Verified that User should be able to query by Measures");
        objLoginOut.logout();
    }

}
