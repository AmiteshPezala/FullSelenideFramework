package MRCS.Tests.ThirdParty;

import MRCS.Locators.RetrievalRepo.ThirdPartyRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.ThirdParty;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class VerifyHideTimelineTab_TC59 extends TestBase {
        LoginOut objLoginOut = new LoginOut();
        ThirdParty objThirdParty = new ThirdParty();

        @Test(description = "Verify hide timeline tab.", groups = {"Third party"})
        public void PursuitTab_VerifyPendIdHyperlink_TC58() throws Exception {
            logTestStep("Log in to application");
            objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
            Common.PopUp();
            Thread.sleep(2000);
            //objWait.implicitwait();
            objThirdParty.ThirdPartyLink();
            sleep(2000);
            $(ThirdPartyRepo.FirstAID).click();
            logTestStep("Clicked on first AID");
            sleep(2000);
            logTestStep("verifying that hide timeline tab is displayed or not.");
            if($x("//span[contains(text(),'HIDE TIMELINE')]").isDisplayed()){
                logTestStepPass("Hide timeline tab is present");
            }else{
                logTestStepFail("Hide timeline tab is not present.");
            }
            sleep(2000);
            objLoginOut.logout();

        }
    }