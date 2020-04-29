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

public class VerifyChaseIdDetailPage_TC9 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    ApprovalCenter objApprovalCenter = new ApprovalCenter();

    @Test(description = "Verify that after clicked on chase id page redirect to chase id detailed page or not.", groups = {"Approve Chase Move"})
    public void VerifyChaseIdDetailPage_TC9() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        //objWait.implicitwait();
        objApprovalCenter.ApprovalChaseMoveLink();
        sleep(2000);
        $(ApprovalCenterRepo.ApproveChaseMove).click();
        sleep(5000);
        $x("//tr[1]//td[2]").click();
        sleep(2000);
        if($x("//i[@class='pi pi-times']").isDisplayed()){
            $x("//i[@class='pi pi-times']").click();
        }
        else{
            Log.info("Notification not displayed.");
        }
        if($x("//h3[@class='container-title']").isDisplayed()){
            logTestStepPass("Page redirect to chase Id detailed page.");
        }else{
            logTestStepFail("Page not redirect to chase detail page.");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}