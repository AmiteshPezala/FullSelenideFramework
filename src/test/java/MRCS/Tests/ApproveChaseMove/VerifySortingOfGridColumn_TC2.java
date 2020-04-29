package MRCS.Tests.ApproveChaseMove;

import MRCS.Locators.ApprovalCenterRepo;
import MRCS.Modules.ApprovalCenter;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.TestBase.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class VerifySortingOfGridColumn_TC2 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    ApprovalCenter objApprovalCenter = new ApprovalCenter();

    @Test(description = "Verify sorting of grid column", groups = {"Approve Chase Move"})
    public void VerifySortingOfGridColumn_TC2() throws Exception {

        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        //objWait.implicitwait();
        objApprovalCenter.ApprovalChaseMoveLink();
        sleep(2000);
        $(ApprovalCenterRepo.ApproveChaseMove).click();
        sleep(5000);
        String FirstDate=$x("//tr[1]//td[9]").getText();
        Log.info(FirstDate);
        sleep(2000);
        $x("//th[9]").click();
        $x("//th[9]").click();
        sleep(5000);
        String NewDate=$x("//tr[1]//td[9]").getText();
        Log.info(NewDate);
        if(FirstDate != NewDate){
            logTestStepPass("Grid columns are sortable in ascending order");
        }else{
            logTestStepFail("Grid columns are not sortable in ascending order");
        }
        $x("//th[9]").click();
        sleep(5000);
        String Date3 =$x("//tr[1]//td[9]").getText();
        Log.info(Date3);
        sleep(2000);
        if(FirstDate.equals(Date3)){
            logTestStepPass("Grid columns are sortable in descending order");
        }else {
            logTestStepFail("Grid columns are not sortable in descending order");
        }
        objLoginOut.logout();
        sleep(2000);
    }
}