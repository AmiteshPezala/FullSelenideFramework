package MRCS.Tests.RetrievalEMR;
import MRCS.Locators.RetrievalRepo.RetrievalEMRRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalEMR;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class RetrievalEMRScheduleExport_TC18 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify Schedule export.", groups = {"Retrieval EMR"})
    public void RetrievalEMRScheduleExport() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RetrievalEMR.NavigateToEMR();
        $(RetrievalEMRRepo.ScheduleTab).click();
        logTestStep("User on Schedule tab");
        sleep(5000);
        $$(RetrievalEMRRepo.ExportAll).filter(Condition.visible).last().click();
        logTestStep("Exporting EMR Appointment");
        Common.DownloadCsv();
        objLoginOut.logout();
    }
}
