package MRCS.Tests.ApproveChaseMove;

import MRCS.Locators.ApprovalCenterRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.ApprovalCenter;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class VerifyFilterFunctionality_TC4 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    ApprovalCenter objApprovalCenter = new ApprovalCenter();

    @Test(description = "Verify filter functionality", groups = {"Approve Chase Move"})
    public void VerifyFilterFunctionality_TC4() throws Exception {

        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        //objWait.implicitwait();
        objApprovalCenter.ApprovalChaseMoveLink();
        sleep(2000);
        $(ApprovalCenterRepo.ApproveChaseMove).click();
        sleep(5000);
        String ChaseId1=$x("//tr[1]//td[2]").getText();
        Log.info(ChaseId1);
        sleep(2000);
        $(ProjectsRepo.Filter).click();
        sleep(2000);
        $(ApprovalCenterRepo.Chase).click();
        sleep(2000);
        $x("//input[@id='ChaseId']").click();
        sleep(2000);
        $x("//input[@id='ChaseId']").setValue(ChaseId1);
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(5000);
        String ChaseId2=$x("//tr[1]//td[2]").getText();
        Log.info(ChaseId2);
        if(ChaseId1.equals(ChaseId2)){
            logTestStepPass("Grid data get filtered as per the filter selected");
        }
        else{
            logTestStepFail("Grid data not filtered as per the filter selected");
        }
        objLoginOut.logout();
    }
}
