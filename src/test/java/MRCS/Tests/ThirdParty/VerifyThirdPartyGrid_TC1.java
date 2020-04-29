package MRCS.Tests.ThirdParty;

import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Locators.RetrievalRepo.ThirdPartyRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.ThirdParty;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class VerifyThirdPartyGrid_TC1 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    ThirdParty objThirdParty=new ThirdParty();

    @Test(description = "Verify that grid loads or not", groups = {"Third party"})
    public void VerifyThirdPartyGrid_TC1() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        sleep(2000);
        //objWait.implicitwait();
        objThirdParty.ThirdPartyLink();
        sleep(2000);
        if($x("//tr//th").isDisplayed()){
            logTestStepPass("Grid Loaded Successfully.");
        }else{
            logTestStepFail("Grid not loaded.");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
