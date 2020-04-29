package MRCS.Tests.RetrievalPSR;

import MRCS.Locators.RetrievalRepo.RetrievalPSRRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.RetrievalPSR;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.TestBase.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class RetrievalPSRVerifyScheduleTab_TC12 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    RetrievalPSR objRetrievalPSR = new RetrievalPSR();

    @Test(description = "Verify schedule tab is populated or not .", groups = {"Retrieval PSR"})
    public void RetrievalPSRVerifyScheduleTab_TC12() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        RetrievalPSR.NavigateToPSR();
        sleep(2000);
        $(RetrievalPSRRepo.ScheduleTab).click();
        sleep(2000);
        if($x("//th").isDisplayed()){
            logTestStepPass("Schedule tab is populated.");
        }else{
            logTestStepFail("Schedule tab is not populated.");
        }
        objLoginOut.logout();
    }
}
