package MRCS.Tests.ChaseQuery;

import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.DEFAULT_WAIT;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ChaseQueryVerifyExportFunctionality_TC1 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Projects objProject = new Projects();

    @Test(description = "Verify export all functionality.", groups = {"Chase Query"})
    public void ChaseQueryVerifyExportFunctionality_TC1() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        //objWait.implicitwait();
        objProject.ProjectsLink();
        logTestStep("Click on project link");
        $(ProjectsRepo.ChaseQueryHEDIS).click();
        logTestStep("Click on Chase Query");
        sleep(10000);
        $(ProjectsRepo.Project).click();
        logTestStep("Click on filter project");
        sleep(10000);
        $x("//span[contains(text(),'2020 HEDIS 1')]").click();
        sleep(2000);
        ClickElement(ProjectsRepo.Update, "Clicking on Update");
        Thread.sleep(2000);
        Common.waitForPageLoadToComplete();
        Thread.sleep(10000);
        $x("//span[contains(text(),'Export All')]").waitUntil(visible, DEFAULT_WAIT).click();
        sleep(20000);
        Common.DownloadCsv();
        sleep(5000);
        objLoginOut.logout();
    }
}
