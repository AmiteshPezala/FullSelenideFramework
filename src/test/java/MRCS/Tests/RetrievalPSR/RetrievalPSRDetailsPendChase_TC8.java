package MRCS.Tests.RetrievalPSR;

import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalFT;
import MRCS.Modules.RetrievalModule.RetrievalPSR;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class RetrievalPSRDetailsPendChase_TC8 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify weather pend Code is associated with chase.", groups = {"Retrieval PSR"})
    public void RetrievalPSRPendChase_TC8() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        RetrievalPSR.NavigateToPSR();
        logTestStep("Clicking on first record");
       $(RetrievalRepo.AIDFirstRow).click();
       // $x("//tr[4]//td[1]").click();
        sleep(5000);
        String status = $x("//td[@class='hdvi-gridcol hdvi-gridcol-reportingStatusName ng-star-inserted']").getText();
        Log.info(status);
        String currentStatus = "Pended";
        if (status.equals(currentStatus)) {
            System.out.println("In if loop");
            RetrievalFT.PendChaseIfPended();
        }
        //If the status is other than pended then go to else loop
        else{
            System.out.println("In Else loop");
            RetrievalFT.PendChaseElsePended();
        }
        objLoginOut.logout();
    }
}