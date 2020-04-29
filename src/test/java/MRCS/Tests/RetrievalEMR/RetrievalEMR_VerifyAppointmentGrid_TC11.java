package MRCS.Tests.RetrievalEMR;

import MRCS.Locators.RetrievalRepo.RetrievalFTRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalEMR;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class RetrievalEMR_VerifyAppointmentGrid_TC11 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify Appointment Grid", groups = {"Retrieval EMR"})
    public void RetrievalEMR_VerifyAppointmentGrid() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RetrievalEMR.NavigateToEMR();
        Common.waitForLoader();
        $(RetrievalFTRepo.ScheduleTab).click();
        Common.waitForLoaderNew();
        String getText=Common.getElementText(By.xpath("//*[text()='EMR APPOINTMENTS']"),5);
        Common.assertText(getText,"EMR APPOINTMENTS");
        objLoginOut.logout();
    }
}
