package MRCS.Tests.RetrievalPSR;

import MRCS.Locators.RetrievalRepo.RetrievalPSRRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.RetrievalPSR;
import MRCS.Modules.RetrievalModule.ThirdParty;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class RetrievalPSRVerifyConfirmFaxFields_TC37 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    ThirdParty objThirdParty = new ThirdParty();
    RetrievalPSR objRetrievalPSR = new RetrievalPSR();

    @Test(description = "Verify fields for the fax form.", groups = {"Retrieval PSR"})
    public void RetrievalPSRVerifyConfirmFaxFields_TC37() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        sleep(2000);
        //objWait.implicitwait();
        objRetrievalPSR.NavigateToPSR();
        sleep(2000);
        $(RetrievalRepo.AIDFirstRow).click();
        logTestStep("Clicked on the first AID.");
        sleep(5000);
        $(RetrievalPSRRepo.EditAddress).click();
        logTestStep("Clicked on the edit address option to update address details.");
        sleep(2000);
        $x("//input[@id='fax']").setValue("1111111111");
        sleep(2000);
        $(RetrievalRepo.ApplyEdits).click();
        sleep(3000);
        $(RetrievalPSRRepo.FirstRecordInAID).click();
        sleep(2000);
        $(RetrievalPSRRepo.FaxRequest).click();
        logTestStep("Clicked on fax request option.");
        sleep(3000);
        logTestStep("Checking the fields of fax field.");
        String To=$x("//div[contains(text(),'TO :')]").getText();
        String From=$x("//div[contains(text(),'FROM :')]").getText();
        String Fax=$x("//div[contains(text(),'FAX # :')]").getText();
        String TotalChases=$x("//div[contains(text(),'TOTAL CHASES :')]").getText();
        String SelectTemplate=$x("//div//label[contains(text(),'Select Template')]").getText();
        Log.info(SelectTemplate);
        if(To.equals("TO :")){
            logTestStepPass("To field is present.");
        }else{
            logTestStepFail("To field is not present.");
        }
        if(From.equals("FROM :")){
            logTestStepPass("From field is present.");
        }else{
            logTestStepFail("From field is not present.");
        }
        if(Fax.equals("FAX # :")){
            logTestStepPass("Fax field is present.");
        }else{
            logTestStepFail("Fax field is not present.");
        }if(TotalChases.equals("TOTAL CHASES :")){
            logTestStepPass("Total Chases field is present.");
        }else{
            logTestStepFail("Total Chases field is not present.");
        }if(SelectTemplate.equals("SELECT TEMPLATE")){
            logTestStepPass("Select Template field is present.");
        }else{
            logTestStepFail("Select Template field is not present.");
        }
        $x("//span[contains(text(),'Cancel')]").click();
        sleep(2000);
        objLoginOut.logout();
    }
}
