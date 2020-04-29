package MRCS.Tests.ChaseQuery;

import MRCS.Locators.Projects.ChaseQueryRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class ChaseQuery_VerifyButtonForCreateChase_TC29 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Projects objProject = new Projects();
    WaitTool objWait = new WaitTool();

    @Test(description = "Verify button for creating new chase is available or not.", groups = {"Chase Query"})
    public void ChaseQuery_VerifyButtonForCreateChase_TC29() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        logTestStep("Verifying ChaseQuery filter Status ");
        objProject.ProjectsLink();
        sleep(2000);
        $(ProjectsRepo.ChaseQueryHEDIS).click();
        logTestStep("Click on Chase Query");
        $(ProjectsRepo.Update).click();
        sleep(25000);
        logTestStep("Click on update button");
        Common.waitForPageLoadToComplete();
        sleep(5000);
        if($(ChaseQueryRepo.CreateNewChase).isDisplayed()){
            logTestStepPass("Button for creating new chase is available.");
        }else{
            logTestStepFail("Button for creating new chase is not available.");
        }
        objLoginOut.logout();
    }
}
