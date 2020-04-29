package MRCS.Tests.BulkActions;

import MRCS.Locators.BulkActionsRepo;
import MRCS.Locators.PendRepo.RetrievalPendRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.BulkActionsModule.BulkChanges;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class BulkUpdate_VerifyPendResolve_TC9 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    BulkChanges objBulkAction = new BulkChanges();

    @Test(description = "Verify pend resolve functionality.", groups = {"Bulk Update"})
    public void BulkUpdate_VerifyPendResolve_TC9() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(2000);
        objBulkAction.GettingPendIdToResolve();
        sleep(2000);
        if ($x("//tr[1]//td[2]").isDisplayed() && $x("//tr[2]//td[2]").isDisplayed()) {
            Log.info("Records are present");
            String PendCode1 = $x("//tr[1]//td[2]").getText();
            Log.info("PendCode1 = " + PendCode1);
            String PendCode2 = $x("//tr[2]//td[2]").getText();
            Log.info("PendCode2 = " + PendCode2);
            String PendId=PendCode1+","+PendCode2;
            sleep(2000);
            objBulkAction.BulkChangesLink();
            sleep(2000);
            $(BulkActionsRepo.BulkUpdateDropDown).click();
            sleep(2000);
            $x("//span[@class='ng-star-inserted'][contains(text(),'Pend')]").click();
            sleep(2000);
            $x("//label[contains(text(),'Choose a Bulk Action')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
            sleep(2000);
            $x("//span[contains(text(),'Resolve')]").click();
            sleep(2000);
            $x("//textarea[@id='selectedChaseIds']").setValue(PendId);
            sleep(2000);
            $x("//span[contains(text(),'CONTINUE')]").click();
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
                logTestStepPass("Status of pend id get changed successfully.");
                $(BulkActionsRepo.FinishBulkUpdate).click();
                sleep(1000);
                String Successfulmessage = $x("//div[@class='ui-toast-detail']").getText();
                assertText(Successfulmessage, "You have successfully completed bulk update.");
                sleep(2000);
                ClickElement(RetrievalPendRepo.Pend,"Clicking on RetrievalPend");
                logTestStep("Clicked on RetrievalPend Link");
                $x("//div[@class='statistics']//div[1]").click();
                sleep(3000);
                $x("//app-icon[@class='fa fa-step-backward']").click();
                sleep(2000);
                $(ProjectsRepo.Filter).click();
                sleep(2000);
                $x("//span[contains(text(),'Pend ID')]").click();
                sleep(2000);
                $x("//input[@id='chasePendId']").setValue(PendCode1);
                sleep(2000);
                $(ProjectsRepo.Update).click();
                sleep(2000);
                String CurrentStatus1=$x("//tr[1]//td[8]").getText();
                Log.info("CurrentStatus1" + CurrentStatus1);
                sleep(2000);
                $(ProjectsRepo.Filter).click();
                sleep(2000);
                $x("//span[contains(text(),'Pend ID')]").click();
                sleep(2000);
                $x("//input[@id='chasePendId']").setValue(PendCode2);
                sleep(2000);
                $(ProjectsRepo.Update).click();
                sleep(2000);
                String CurrentStatus2=$x("//tr[1]//td[8]").getText();
                Log.info("CurrentStatus2" + CurrentStatus2);
                sleep(2000);
                if(CurrentStatus1.equals("Resolved") && CurrentStatus2.equals("Resolved")){
                    logTestStepPass("Both RetrievalPend Id status changed to resolved state.");
                }else{
                    logTestStepFail("RetrievalPend Id status not changed to resolved.");
                }
            }
            else{
                 logTestStepFail("Failed to changed the status of RetrievalPend Id.");
            }
        }else{
            logTestStep("Records not found");
        }
            objLoginOut.logout();
    }
}