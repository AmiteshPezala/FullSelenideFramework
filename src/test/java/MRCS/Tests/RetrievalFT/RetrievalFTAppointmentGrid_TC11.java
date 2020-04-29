package MRCS.Tests.RetrievalFT;

import MRCS.Locators.RetrievalRepo.RetrievalFTRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalFT;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class RetrievalFTAppointmentGrid_TC11 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify Appointment grid", groups = {"Retrieval FT"})
    public void RetrievalFTAppointmentGrid() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        RetrievalFT.NavigateToFT();
        $(RetrievalFTRepo.ScheduleTab).click();
        String FTUsers=Common.getElementText((RetrievalFTRepo.FTUsers),10);
        String FTAppointments=Common.getElementText((RetrievalFTRepo.FTAppointments),10);
        Common.assertText(FTUsers,"Field Tech USERS");
        Common.assertText(FTAppointments,"Field Tech APPOINTMENTS");
        logTestStepPass("Grid is populated with FT Users.Second grid is populated with FT Appointments.");
        objLoginOut.logout();
    }
}
