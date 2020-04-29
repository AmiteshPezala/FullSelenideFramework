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
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class RetrievalPSRVerifyFaxButton_TC38 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    RetrievalPSR objRetrievalPSR=new RetrievalPSR();

    @Test(description = "Verify fax button.", groups = {"Retrieval PSR"})
    public void RetrievalPSRVerifyFaxButton_TC38() throws Exception {
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
        $x("//input[@id='fax']").setValue("1111111111");
        sleep(2000);
        $(RetrievalRepo.ApplyEdits).click();
        sleep(3000);
        $(RetrievalPSRRepo.FirstRecordInAID).click();
        logTestStep("Clicked on the first chase Id.");
        sleep(2000);
        $(RetrievalPSRRepo.FaxRequest).click();
        sleep(3000);
        logTestStep("Verifying that fax button is present or not.");
        if($(RetrievalPSRRepo.FaxButton).isDisplayed()){
            logTestStepPass("Fax button is present.");
        }else{
            logTestStepFail("Fax button is not present.");
        }
        $(RetrievalPSRRepo.CancelButton).click();
        objLoginOut.logout();
    }
}
