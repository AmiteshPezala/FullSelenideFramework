package MRCS.Tests.RetrievalEMR;

import MRCS.Locators.RetrievalRepo.RetrievalEMRRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalEMR;
import MRCS.Modules.RetrievalModule.RetrievalFT;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class RetrievalEMRDetailsPendChase_TC7 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify weather pend Code is associated with chase.", groups = {"Retrieval EMR"})
    public void RetrievalEMRPendChase() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RetrievalEMR.NavigateToEMR();
        ClickElement(RetrievalEMRRepo.FirstEMRAID,"First Record");
        logTestStep("Clicked on first address id ");
        sleep(5000);
        if($x("//tr[1]//td[2]").isDisplayed()) {
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
            else {
                System.out.println("In Else loop");
                RetrievalFT.PendChaseElsePended();
            }
        }else{
            logTestStep("Records are not present");
        }
        objLoginOut.logout();
    }
}
