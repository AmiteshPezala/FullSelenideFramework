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

public class ProviderTab_UserMArkProviderAsValid_TC54 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    ThirdParty objThirdParty = new ThirdParty();

    @Test(description = "Verify that user can mark provider as valid.", groups = {"Third party"})
    public void ProviderTab_UserMArkProviderAsValid_TC54() throws Exception {
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
        logTestStep("Verifying that user can tick on check box or not .");
        if($x("//span[@class='ui-chkbox-icon ui-clickable pi pi-check']").isDisplayed()){
            logTestStep("Check box for valid option is already selected.");
        }else{
            $x("//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']").click();
            sleep(2000);
            logTestStep("User can click on the validate check box.");
        }
        objLoginOut.logout();
    }
}
