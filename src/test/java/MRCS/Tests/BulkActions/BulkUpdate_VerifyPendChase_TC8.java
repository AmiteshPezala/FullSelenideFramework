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

public class BulkUpdate_VerifyPendChase_TC8 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    BulkChanges objBulkAction = new BulkChanges();

    @Test(description = "Verify pend chase functionality.", groups = {"Bulk Update"})
    public void BulkUpdate_VerifyPendChase_TC8() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(2000);
        objBulkAction.GettingChaseIdOfSameClient();
        sleep(2000);
        if ($x("//tr[1]//td[2]").isDisplayed() && $x("//tr[2]//td[2]").isDisplayed()) {
            Log.info("Records are present");
            String ChaseId1 = $x("//tr[1]//td[2]//div").getText();
            Log.info(ChaseId1);
            sleep(2000);
            String ChaseId2 = $x("//tr[2]//td[2]//div").getText();
            Log.info(ChaseId2);
            String ChaseId = ChaseId1 + "," + ChaseId2;
            objBulkAction.BulkChangesLink();
            sleep(2000);
            $x("//label[contains(text(),'Select a Type of Bulk Update')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
            Selenide.sleep(2000);
            $x("//span[@class='ng-star-inserted'][contains(text(),'Chases')]").click();
            sleep(2000);
            $x("//label[contains(text(),'Choose a Bulk Action')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
            sleep(2000);
            $x("//span[contains(text(),'Pend Chases')]").click();
            sleep(2000);
            $x("//label[contains(text(),'Select a Client')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
            sleep(2000);
            $x("//span[contains(text(),'testing group')]").click();
            sleep(2000);
            $x("//textarea[@id='selectedChaseIds']").setValue(ChaseId);
            sleep(2000);
            $(BulkActionsRepo.Continue).click();
            sleep(2000);
            $x("//label[contains(text(),'Pend Code')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
            sleep(2000);
            $x("//span[contains(text(),'PC302-DOB is incomplete or missing')]").click();
            sleep(2000);
            $x("//label[contains(text(),'Severity')]//following::span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-caret-down']").click();
             sleep(2000);
            $x("//span[contains(text(),'Non Error')]").click();
            sleep(2000);
            $x("//textarea[@id='chasesNotes']").setValue("Testing purpose");
            sleep(2000);
            $(BulkActionsRepo.ContinueToValidation).click();
            sleep(2000);
            String Status1 = $x("//tr[1]//td[3]").getText();
            Log.info("Status1 = " + Status1);
            String Status2 = $x("//tr[2]//td[3]").getText();
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
                String PendCode1 = $x("//tr[1]//td[18]").getText();
                sleep(2000);
                $(ProjectsRepo.Filter).click();
                sleep(2000);
                $x("//span[contains(text(),'Chase ID / Client Chase Key')]").click();
                sleep(2000);
                $x("//input[@id='ChaseIdAndClientChaseKey']").setValue(ChaseId2);
                $(ProjectsRepo.Update).click();
                sleep(2000);
                String PendCode2 = $x("//tr[1]//td[18]").getText();
                sleep(2000);
                if (PendCode1.equals("PC302") && PendCode2.equals("PC302")) {
                    logTestStepPass("RetrievalPend code of both chase Id updated successfully.");
                } else {
                    logTestStepFail("RetrievalPend code of both chase Id not updated");
                }
            } else {
                logTestStepFail("RetrievalPend code not updated for chase Id.");
            }
        }
        else{
            logTestStep("Records are not present.");
        }
        objLoginOut.logout();
    }
}