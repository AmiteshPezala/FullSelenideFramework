package MRCS.Tests.RetrievalEMR;

import MRCS.Locators.RetrievalRepo.RetrievalEMRRepo;
import MRCS.Locators.RetrievalRepo.RetrievalFTRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalEMR;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class RetrievalEMRCancelAppointment_TC17 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify whether appointment is Cancel.", groups = {"Retrieval EMR"})
    public void RetrievalEMRCancelAppointment() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RetrievalEMR.NavigateToEMR();
        Retrieval.cancelAppointment();
        sleep(2000);
        $x("//tr[1]/td[20]/app-button/p-button/button").click();
        $(RetrievalRepo.ScheduleButton).click();
        logTestStep("Clicked on schedule button");
        sleep(2000);
        objRetrieval.Appointment();
        $(RetrievalFTRepo.ScheduleTab).click();
        sleep(10000);
        $x("//tr[1]//td[9]").click();
        sleep(2000);
        $x("//*[text()='Cancel Appointment']").click();
        $x("//*[text()='Yes']").click();
        String getMsg=Common.getElementText(By.xpath("//*[@class='ui-toast-detail']"),5);
        String Expected="Appointment cancelled successfully.";
        Common.assertText(getMsg,Expected);
        logTestStepPass("Appointment get canceled");
        objLoginOut.logout();
    }
}
