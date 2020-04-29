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

public class VerifyOriginalAIDDetailPage_TC11 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    ApprovalCenter objApprovalCenter = new ApprovalCenter();

    @Test(description = "Verify that after clicked on original AID page redirect to AID detailed page or not.", groups = {"Approve Chase Move"})
    public void VerifyOriginalAIDDetailPage_TC11() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        //objWait.implicitwait();
        objApprovalCenter.ApprovalChaseMoveLink();
        sleep(2000);
        $(ApprovalCenterRepo.ApproveChaseMove).click();
        sleep(5000);
        String OriginalAID=$x("//tr[1]//td[5]").getText();
        Log.info("Destination AID = "+ OriginalAID);
        $x("//tr[1]//td[5]").click();
        sleep(2000);
        String Header=$x("//div[@class='address-summary__top--address-id']").getText();
        if(Header.endsWith(OriginalAID)){
            logTestStepPass("Page redirects to original AID detailed page");
        }
        else{
            logTestStepFail("Page not redirects to original AID detailed page.");
        }
        objLoginOut.logout();
    }
}
