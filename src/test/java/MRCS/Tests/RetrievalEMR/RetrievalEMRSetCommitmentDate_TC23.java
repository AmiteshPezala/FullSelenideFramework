package MRCS.Tests.RetrievalEMR;

import MRCS.Locators.RetrievalRepo.RetrievalEMRRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalEMR;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;

public class RetrievalEMRSetCommitmentDate_TC23 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify weather Commintment date is available in chase grid or not", groups = {"Retrieval EMR"})
    public void RetrievalEMRSetCommitmentDate_TC23() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RetrievalEMR.NavigateToEMR();
        Common.ClickElement(RetrievalEMRRepo.FirstEMRAID,"First Record");
        logTestStep("Clicked on first address id");
        $x("//*[text()='CHASES AT THIS ADDRESS']//following::p-tablecheckbox[1]").click();
        sleep(2000);
        logTestStep("Selecting first chase id");
        $(RetrievalRepo.CommitmentDate).click();
        logTestStep("Clicked on commitment date");
        $x("(.//*[normalize-space(text()) and normalize-space(.)='Commitment Date'])[1]/following::span[2]").click();
        sleep(2000);
        $(".ui-datepicker-next-icon.pi.pi-chevron-right").click();
        sleep(2000);
        $x("//tr[3]/td[2]/a").click();
        sleep(2000);
        $x("//span[contains(text(),'SUBMIT')]").click();
        String message =$x("//div[@class='ui-toast-detail']").getText();
        Log.info(message);
        assertText(message,"Commitment Date updated successfully.");
        objLoginOut.logout();
    }
}
