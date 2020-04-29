package MRCS.Tests.RetrievalFT;

import MRCS.Locators.RetrievalRepo.RetrievalFTRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalFT;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class RetrievalFTCreateAppointment_TC12 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify whether appointment is created or not.", groups = {"Retrieval FT"})
    public void RetrievalFTCreateAppointment() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RetrievalFT.NavigateToFT();
        Retrieval.cancelAppointment();
        String AID = $(RetrievalFTRepo.FirstFTAID).getText();
        sleep(2000);
        $x("//tr[1]/td[20]/app-button/p-button/button").click();
        $(RetrievalRepo.ScheduleButton).click();
        sleep(2000);
        logTestStep("Clicked on schedule button");
        objRetrieval.Appointment();
        objLoginOut.logout();
    }
}