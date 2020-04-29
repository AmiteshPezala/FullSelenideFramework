package MRCS.Tests.RetrievalPSR;

import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalPSR;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class RetrievalPSRSetCommitmentDate_TC21 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify whether Commitment date is available in chase grid or not", groups = {"Retrieval PSR"})
    public void RetrievalPSRSetCommitmentDate() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        sleep(2000);
        Common.PopUp();
        RetrievalPSR.NavigateToPSR();
        $x("//tr[1]//td[2]").click();
        logTestStep("Clicked on first address id");
        sleep(5000);
        $x("//*[text()='CHASES AT THIS ADDRESS']//following::p-tablecheckbox[1]").click();
        sleep(2000);
        logTestStep("Selecting first chase id ");
        $(RetrievalRepo.CommitmentDate).click();
        sleep(2000);
        logTestStep("Clicked on commitment date");
        $(RetrievalRepo.DateDropdown).click();
        sleep(2000);
        $(RetrievalRepo.NextMonth).click();
        sleep(2000);
        $(RetrievalRepo.SelectedDate1).click();
        sleep(2000);
        $x("//span[contains(text(),'SUBMIT')]").click();
        String message =Common.getElementText(By.xpath("//div[@class='ui-toast-detail']"),5);
        Log.info(message);
        assertText(message,"Commitment Date updated successfully.");
        sleep(2000);
        objLoginOut.logout();
    }
}