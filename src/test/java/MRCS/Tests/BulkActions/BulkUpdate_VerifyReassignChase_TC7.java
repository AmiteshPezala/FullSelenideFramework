package MRCS.Tests.BulkActions;

import MRCS.Locators.BulkActionsRepo;
import MRCS.Locators.ClinicalRepo.ClinicalRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.BulkActionsModule.BulkChanges;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class BulkUpdate_VerifyReassignChase_TC7 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    BulkChanges objBulkAction = new BulkChanges();


    @Test(description = "Verify reassigned functionality.", groups = {"Bulk Update"})
    public void BulkUpdate_VerifyReassignChase_TC7() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(2000);
        objBulkAction.GettingAssignedUser();
        sleep(2000);
        if ($x("//tr[1]//td[2]").isDisplayed() && $x("//tr[2]//td[2]").isDisplayed()) {
            Log.info("Records are present");
            String ChaseId1 = $x("//tr[1]//td[2]//div").getText();
            sleep(2000);
            String ChaseId2 = $x("//tr[2]//td[2]//div").getText();
            String ChaseId = ChaseId1 + "," + ChaseId2;
            objBulkAction.BulkChangesLink();
            sleep(2000);
            $x("//label[contains(text(),'Select a Type of Bulk Update')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
            Selenide.sleep(2000);
            $x("//span[@class='ng-star-inserted'][contains(text(),'Chases')]").click();
            sleep(2000);
            $x("//label[contains(text(),'Choose a Bulk Action')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
            sleep(2000);
            $x("//span[contains(text(),'Reassign Chases')]").click();
            sleep(2000);
            $x("//label[contains(text(),'Select a Client')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
            sleep(2000);
            $x("//span[contains(text(),'Testing group 0')]").click();
            sleep(2000);
            $x("//textarea[@id='selectedChaseIds']").setValue(ChaseId);
            sleep(2000);
            $(BulkActionsRepo.Continue).click();
            sleep(2000);
            $x("//label[contains(text(),'Assign to User')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
            sleep(2000);
            $x("//p-dropdownitem//li//span[contains(text(),'Testing Admin')]").click();
            sleep(2000);
            $x("//textarea[@id='chasesNotes']").setValue("Testing purpose");
            sleep(2000);
            $(BulkActionsRepo.ContinueToValidation).click();
            sleep(2000);
            String Status1 = $x("//tr[1]//td[4]").getText();
            Log.info("Status1 = " + Status1);
            String Status2 = $x("//tr[2]//td[4]").getText();
            Log.info("Status2 = " + Status2);
            sleep(2000);
            if (Status1.equals("Success") && Status2.equals("Success")) {
                logTestStepPass("Users get reassigned successfully.");
                $(BulkActionsRepo.FinishBulkUpdate).click();
                sleep(1000);
                String Successfulmessage = $x("//div[@class='ui-toast-detail']").getText();
                assertText(Successfulmessage, "You have successfully completed bulk update.");
                sleep(2000);
                ClickElement(ClinicalRepo.Clinical, "Clinical link");
                sleep(2000);
                ClickElement(ClinicalRepo.MRR, "MRR");
                sleep(2000);
                $x("//div[@class='chip__item']").click();
                sleep(2000);
                $(ProjectsRepo.Filter).click();
                sleep(2000);
                $x("//span[contains(text(),'Chase ID / Client Chase Key')]").click();
                sleep(2000);
                $x("//input[@id='ChaseIdAndClientChaseKey']").setValue(ChaseId1);
                $(ProjectsRepo.Update).click();
                sleep(2000);
                $x("//app-icon[@class='fa fa-step-backward']").click();
                sleep(2000);
                String User1 = $x("//tr[1]//td[15]").getText();
                Log.info("User1 = " + User1);
                sleep(2000);
                $(ProjectsRepo.Filter).click();
                sleep(2000);
                $x("//span[contains(text(),'Chase ID / Client Chase Key')]").click();
                sleep(2000);
                $x("//input[@id='ChaseIdAndClientChaseKey']").setValue(ChaseId2);
                $(ProjectsRepo.Update).click();
                sleep(2000);
                String User2 = $x("//tr[1]//td[15]").getText();
                Log.info("User2 = " + User2);
                sleep(2000);
                if (User1.equals("Testing Admin") && User2.equals("Testing Admin")) {
                    logTestStepPass("Users reassigned successfully to new user.");
                } else {
                    logTestStepFail("Users not reassigned to new user.");
                }
            } else {
                logTestStepFail("Users not reassigned");
            }
        } else {
            logTestStep("Records not present .");
        }
        objLoginOut.logout();
    }
}