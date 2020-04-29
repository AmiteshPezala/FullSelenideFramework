package MRCS.Tests.RetrievalFT;

import MRCS.Locators.RetrievalRepo.RetrievalFTRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalFT;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.*;

public class RetrievalFTDetailsPendChase_TC7 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify weather pend Code is associated with chase.", groups = {"Retrieval FT"})
    public void RetrievalFTDetailsPendChase() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RetrievalFT.NavigateToFT();
        logTestStep("Clicking on first record");
        ClickElement(RetrievalFTRepo.FirstFTAID,"AID");
        sleep(5000);
        String status = $x("//td[@class='hdvi-gridcol hdvi-gridcol-reportingStatusName ng-star-inserted']").getText();
        Log.info(status);
        //Checking weather the status is pended or not
        //If pended then go to IF loop
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
