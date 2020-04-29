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

public class VerifyChaseViewOnAddressDetailPage_TC31 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    ThirdParty objThirdParty = new ThirdParty();

    @Test(description = "Verify chase view on address detail page.", groups = {"Third party"})
    public void VerifyChaseViewOnAddressDetailPage_TC31() throws Exception {
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
        if($x("//h3[contains(text(),'CHASES AT THIS ADDRESS')]//following::div[@class='sub-menu__container']").isDisplayed()){
            logTestStepPass("By default chase view is available on the address detail page.");
        }else{
            logTestStepFail("By default chase view is not available on the address detail page.");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
