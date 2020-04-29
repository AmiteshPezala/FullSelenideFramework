package MRCS.Tests.RetrievalPSR;

import MRCS.Locators.RetrievalRepo.RetrievalPSRRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.RetrievalPSR;
import MRCS.Modules.RetrievalModule.ThirdParty;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class RetrievalPSRVerifyEmailButton_TC34 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    RetrievalPSR objRetrievalPSR=new RetrievalPSR();

    @Test(description = "Verify email button.", groups = {"Retrieval PSR"})
    public void RetrievalPSRVerifyEmailButton_TC34() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        sleep(2000);
        //objWait.implicitwait();
        objRetrievalPSR.NavigateToPSR();
        sleep(2000);
        $(RetrievalRepo.AIDFirstRow).click();
        sleep(5000);
        logTestStep("Verifying the address details.");
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
        logTestStep("Verifying that email button is present or not.");
        if($(RetrievalPSRRepo.EmailButton).isDisplayed()){
            logTestStepPass("Email button is present.");
        }else{
            logTestStepFail("Email button is not present.");
        }
        $(RetrievalPSRRepo.CancelButton).click();
        objLoginOut.logout();
    }
}
