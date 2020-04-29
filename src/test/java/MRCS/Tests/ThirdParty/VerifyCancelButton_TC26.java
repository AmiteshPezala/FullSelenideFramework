package MRCS.Tests.ThirdParty;

import MRCS.Locators.RetrievalRepo.RetrievalPSRRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.ThirdParty;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class VerifyCancelButton_TC26 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    ThirdParty objThirdParty = new ThirdParty();

    @Test(description = "Verify cancel button.", groups = {"Third party"})
    public void VerifyCancelButton_TC26() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        sleep(2000);
        objThirdParty.AssigningToLoggedInUser();
        sleep(2000);
        $(RetrievalRepo.AIDFirstRow).click();
        logTestStep("Clicked on first AID.");
        Selenide.sleep(2000);
        $(RetrievalPSRRepo.EditAddress).click();
        logTestStep("Clicked on edit address to update address details.");
        Selenide.sleep(2000);
        $(RetrievalPSRRepo.Emails).setValue("admin@yopmail.com");
        Selenide.sleep(2000);
        $(RetrievalRepo.ApplyEdits).click();
        Selenide.sleep(5000);
        $(RetrievalPSRRepo.FirstRecordInAID).click();
        logTestStep("Selecting first chase ID");
        Selenide.sleep(2000);
        $(RetrievalPSRRepo.EmailsRequest).click();
        logTestStep("Clicked on email request option.");
        Selenide.sleep(3000);
        $$(RetrievalPSRRepo.SelectTemplateDropdown).filter(Condition.visible).last().click();
        Selenide.sleep(2000);
        $(RetrievalPSRRepo.InitialRequest).click();
        Selenide.sleep(2000);
        $x("//span[contains(text(),'Cancel')]").click();
        sleep(2000);
        if($x("//div[@class='ui-toast-detail']").isDisplayed()){
            logTestStepFail("Email request not canceled.");
        }else{
            logTestStepPass("Email request canceled .");
        }
        objLoginOut.logout();
    }
}
