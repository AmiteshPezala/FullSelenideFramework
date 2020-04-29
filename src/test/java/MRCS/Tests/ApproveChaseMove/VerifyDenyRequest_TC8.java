package MRCS.Tests.ApproveChaseMove;

import MRCS.Locators.ApprovalCenterRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.ApprovalCenter;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class VerifyDenyRequest_TC8 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    ApprovalCenter objApprovalCenter = new ApprovalCenter();

    @Test(description = "Verify request deny functionality.", groups = {"Approve Chase Move"})
    public void VerifyDenyRequest_TC8() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        //objWait.implicitwait();
        objApprovalCenter.ApprovalChaseMoveLink();
        sleep(2000);
        $(ApprovalCenterRepo.ApproveChaseMove).click();
        sleep(5000);
        String ChaseId=$x("//tr[1]//td[2]").getText();
        Log.info("Chase Id " + ChaseId);
        String PreviousStatus=$x("//tr[1]//td[11]").getText();
        Log.info("Previous Status = "+ PreviousStatus);
        $x("//tr//td//app-button//p-button//button").click();
        sleep(2000);
        $x("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']//span[@class='ui-button-text ui-clickable'][contains(text(),'Deny')]").click();
        sleep(1000);
        String Successfulmessage = $x("//div[@class='ui-toast-detail']").getText();
        assertText(Successfulmessage, "1 Chase(s) requests denied.");
        sleep(4000);
        String NewChaseId=$x("//tr[1]//td[2]").getText();
        Log.info("New Chase Id " + NewChaseId);
        if(ChaseId.equals(NewChaseId)){
            logTestStepFail("Chase Id not assign to AID.");
        }else{
            logTestStepPass("Chase Id successfully assigned to AID");
        }
        $(ProjectsRepo.Filter).click();
        sleep(2000);
        $x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Chase')]").click();
        sleep(2000);
        $x("//input[@id='ChaseId']").setValue(ChaseId);
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(2000);
        String NewStatus=$x("//tr[1]//td[11]").getText();
        Log.info("New Status = "+ NewStatus);
        sleep(2000);
        if(NewStatus.equals("Denied")){
            logTestStepPass("Status of the chase Id get successfully changed from "+ " "+ PreviousStatus+" "+"to" +" "+ NewStatus);
        }
        else{
            logTestStepFail("Status of the chase Id not changed.");
        }
        objLoginOut.logout();
        sleep(2000);
    }
}
