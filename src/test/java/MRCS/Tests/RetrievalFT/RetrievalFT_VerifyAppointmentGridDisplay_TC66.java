package MRCS.Tests.RetrievalFT;

import MRCS.Locators.RetrievalRepo.RetrievalEMRRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalFT;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class RetrievalFT_VerifyAppointmentGridDisplay_TC66 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify appointment grid display all the appointment related to the AID", groups = {"Retrieval FT"})
    public void VerifyAppointmentGridDisplay() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RetrievalFT.NavigateToFT();
        Common.ClickElement(RetrievalEMRRepo.FirstEMRAID, "First Record");
        Common.waitForLoader();
        Common.assertText(By.xpath("//*[text()='APPOINTMENTS']"),"APPOINTMENTS");
        $x("//*[contains(text(),'Schedule Appointment')]").click();
        sleep(2000);
        logTestStep("Clicked on schedule button");
        objRetrieval.Appointment();
        objLoginOut.logout();
    }
}
