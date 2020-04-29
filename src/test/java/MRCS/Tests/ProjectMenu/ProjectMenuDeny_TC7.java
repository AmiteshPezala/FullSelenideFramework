package MRCS.Tests.ProjectMenu;

import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class ProjectMenuDeny_TC7 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Projects objProject = new Projects();

    @Test(description = "Checking Deny option", groups = {"Project Menu"})
    public void ProjectMenuDeny_TC7() throws Exception {

        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(2000);
        //objWait.implicitwait();
        Common.PopUp();
        objProject.ProjectsLink();
        logTestStep("Click on project link");
        sleep(2000);
        $(ProjectsRepo.ApprovalCenter).click();
        logTestStep("Clicked on approval center link");
        $x("//span[contains(text(),'Approve Chase Moves')]").click();
        sleep(10000);
        if($x("//tr[1]//td[2]").exists()) {
            String FirstId = $x("//tr[1]//td[2]").getText();
            Log.info(FirstId);
            sleep(2000);
            $x("//span[@class='fa fa-ellipsis-v ui-clickable ui-button-icon-left ng-star-inserted']").click();
            sleep(2000);
            logTestStep("Clicked on deny option");
            $x("(//span[@class='ui-button-text ui-clickable'][contains(text(),'Deny')])[2]").click();
            sleep(5000);
            String NewID = $x("//tr[1]//td[2]").getText();
            Log.info(NewID);
            sleep(2000);
            if (FirstId != NewID) {
                logTestStep("Id get denied successfully.");
            } else {
                Assert.fail("Id not get denied.");
            }
        }else {
            Assert.fail("No records found");
        }
        objLoginOut.logout();
    }
}
