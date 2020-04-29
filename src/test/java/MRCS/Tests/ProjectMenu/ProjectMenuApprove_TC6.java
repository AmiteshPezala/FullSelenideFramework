package MRCS.Tests.ProjectMenu;

import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.ElementsCollection;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class ProjectMenuApprove_TC6 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Projects objProject = new Projects();

    @Test(description = "Checking Approve option", groups = {"Project Menu"})
    public void ProjectMenuApprove_TC6() throws Exception {

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
        sleep(10000);
        if($x("//tr[1]//td[2]").exists()) {
            ElementsCollection col = $$(ProjectsRepo.Statusforapprovalcenter);
            System.out.println(col);
            int record = col.size(); // Will get total number of records
            System.out.println(record);
            String Status1 = "WaitingForApproval";
            Log.info("No of cols are : " + record);
            for (int i = 0; i <= record; i++) {
                String Status = $x("//tr[" + (i + 1) + "]//td[11]").getText();
                Log.info(Status);
                if (Status.matches("WaitingForApproval")) {
                    Log.info("in if loop");
                    sleep(2000);
                    $x("//tr[" + (i + 1) + "]//td[12]//app-button[1]//p-button[1]//button[1]//span[1]").click();
                    sleep(2000);
                    logTestStep("Clicked on approve option");
                    $x("//span[@class='ui-button-text ui-clickable'][contains(text(),'Approve')]").click();
                    sleep(10000);
                    String State = $x("//tr[" + (i + 1) + "]//td[11]").getText();
                    Log.info(State);
                    if (Status != State) {
                        Log.info("in 2nd if");
                        logTestStep("Approval request get approved successfully");
                        sleep(2000);
                    } else {
                        Log.info("in 2nd else");
                        Assert.fail("Approval request not approved");
                    }
                    break;
                } else {
                    Log.info("in else loop");
                }
            }
        }
        else{
            Assert.fail("No records found");
        }
        objLoginOut.logout();
    }
}
