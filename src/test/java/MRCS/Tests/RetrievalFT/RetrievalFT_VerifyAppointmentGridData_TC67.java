package MRCS.Tests.RetrievalFT;

import MRCS.Locators.RetrievalRepo.RetrievalEMRRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalFT;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class RetrievalFT_VerifyAppointmentGridData_TC67 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify gird data", groups = {"Retrieval FT"})
    public void VerifyAppointmentGridDisplay() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RetrievalFT.NavigateToFT();
        Common.ClickElement(RetrievalEMRRepo.FirstEMRAID, "First Record");
        Common.waitForLoader();
        Common.assertText(By.xpath("//th[2]"), "START DATE");
        Common.assertText(By.xpath("//th[3]"), "END DATE");
        Common.assertText(By.xpath("//th[4]"), "ASSIGNED TO");
        Common.assertText(By.xpath("//th[5]"), "CHASES");
        Common.assertText(By.xpath("//th[6]"), "STATUS");
        objLoginOut.logout();
    }
}
