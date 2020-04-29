package MRCS.Tests.ThirdParty;

import MRCS.Locators.RetrievalRepo.ThirdPartyRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.ThirdParty;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Utils.TestBase.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class PursuitTab_PursuitRelatedAIDAvailableInPursuit_TC55 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    ThirdParty objThirdParty = new ThirdParty();

    @Test(description = "Verify that pursuits related to AID are available in the pursuit tab or not.", groups = {"Third party"})
    public void PursuitTab_PursuitRelatedAIDAvailableInPursuit_TC55() throws Exception {
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
        $(ThirdPartyRepo.PursuitTab).click();
        logTestStep("Clicked on pursuit tab.");
        sleep(2000);
        if($x("//td[2]").isDisplayed()){
            logTestStepPass("Pursuits related to AID are available in the pursuit tab.");
        }else{
            logTestStepFail("Pursuits related to AID are not available in the pursuit tab.");
        }
        sleep(2000);
    }
}
