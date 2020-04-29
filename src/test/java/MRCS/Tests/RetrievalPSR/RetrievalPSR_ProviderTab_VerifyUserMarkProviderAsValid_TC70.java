package MRCS.Tests.RetrievalPSR;

import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Locators.RetrievalRepo.ThirdPartyRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.RetrievalPSR;
import MRCS.Modules.RetrievalModule.ThirdParty;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class RetrievalPSR_ProviderTab_VerifyUserMarkProviderAsValid_TC70 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    RetrievalPSR objRetrievalPSR=new RetrievalPSR();
    ThirdParty objThirdParty = new ThirdParty();

    @Test(description = "Verify that user can mark provider as valid.", groups = {"Retrieval PSR"})
    public void RetrievalPSR_ProviderTab_VerifyUserMarkProviderAsValid_TC70() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        sleep(2000);
        //objWait.implicitwait();
        objRetrievalPSR.NavigateToPSR();
        $(RetrievalRepo.AIDFirstRow).click();
        logTestStep("Selecting first AID.");
        sleep(2000);
        $(ThirdPartyRepo.ProviderTab).click();
        logTestStep("Clicked on provider tab.");
        sleep(2000);
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
