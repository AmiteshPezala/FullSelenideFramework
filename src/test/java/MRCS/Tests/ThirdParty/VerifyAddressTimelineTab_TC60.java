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

public class VerifyAddressTimelineTab_TC60 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    ThirdParty objThirdParty = new ThirdParty();

    @Test(description = "Verify hide timeline tab.", groups = {"Third party"})
    public void VerifyAddressTimelineTab_TC60() throws Exception {
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
        $x("//span[contains(text(),'HIDE TIMELINE')]").click();
        logTestStep("Clicked on hide timeline option.");
        sleep(20000);
        if ($x("//span[contains(text(),'ADDRESS TIMELINE')]").isDisplayed()) {
            logTestStepPass("Address timeline tab is present");
        } else {
            logTestStepFail("Address timeline tab is not present.");
        }
        sleep(2000);
    }
}
