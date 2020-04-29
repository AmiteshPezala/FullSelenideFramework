package MRCS.Tests.RetrievalPSR;

import MRCS.Locators.RetrievalRepo.RetrievalPSRRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.RetrievalPSR;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Utils.TestBase.*;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class RetrievalPSRVerifyCancelButton_TC35 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    RetrievalPSR objRetrievalPSR = new RetrievalPSR();

    @Test(description = "Verify cancel button.", groups = {"Retrieval PSR"})
    public void RetrievalPSRVerifyCancelButton_TC35() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        sleep(2000);
        //objWait.implicitwait();
        objRetrievalPSR.NavigateToPSR();
        sleep(2000);
        logTestStep("Verifying the address details.");
        $(RetrievalRepo.AIDFirstRow).click();
        sleep(5000);
        $(RetrievalPSRRepo.EditAddress).click();
        sleep(2000);
        $(RetrievalPSRRepo.Emails).setValue("admin@yopmail.com");
        sleep(2000);
        $(RetrievalRepo.ApplyEdits).click();
        sleep(3000);
        $(RetrievalPSRRepo.FirstRecordInAID).click();
        logTestStep("Clicked on the first chase Id.");
        sleep(2000);
        $(RetrievalPSRRepo.EmailsRequest).click();
        sleep(3000);
        logTestStep("Verifying that cancel button is present or not.");
        if ($(RetrievalPSRRepo.CancelButton).isDisplayed()) {
            logTestStepPass("Cancel button is present.");
        } else {
            logTestStepFail("Cancel button is not present.");
        }
        $(RetrievalPSRRepo.CancelButton).click();
        objLoginOut.logout();
    }
}
