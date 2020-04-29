package MRCS.Tests.ThirdParty;

import MRCS.Locators.RetrievalRepo.ThirdPartyRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.ThirdParty;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class ProviderTab_VerifyProviderTabAssociatedWithAID_TC50 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    ThirdParty objThirdParty = new ThirdParty();

    @Test(description = "Verify that provider associated with AID are listed in the tab.", groups = {"Third party"})
    public void ProviderTab_VerifyProviderTabAssociatedWithAID_TC50() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        Thread.sleep(2000);
        //objWait.implicitwait();
        objThirdParty.ThirdPartyLink();
        sleep(2000);
        $(ThirdPartyRepo.FirstAID).click();
        logTestStep("Clicked on first AID.");
        sleep(2000);
        $(ThirdPartyRepo.ProviderTab).click();
        logTestStep("Clicked on provider tab.");
        sleep(2000);
        if($x("//td[2]").isDisplayed()){
            logTestStepPass("List of all providers associated with the AID is displayed in the tab");
        }else{
            logTestStepFail("List of provider is not displayed in the tab.");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
