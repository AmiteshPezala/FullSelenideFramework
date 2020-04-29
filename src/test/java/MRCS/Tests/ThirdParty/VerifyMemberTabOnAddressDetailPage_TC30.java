package MRCS.Tests.ThirdParty;

import MRCS.Locators.RetrievalRepo.ThirdPartyRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.ThirdParty;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.WebDriverRunner;
import javafx.scene.control.Tab;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class VerifyMemberTabOnAddressDetailPage_TC30 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    ThirdParty objThirdParty = new ThirdParty();

    @Test(description = "Verify member tab on address detail page.", groups = {"Third party"})
    public void VerifyMemberTabOnAddressDetailPage_TC30() throws Exception {
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
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//h3[contains(text(),'CHASES AT THIS ADDRESS')]"));
        sleep(2000);
        String TabNAme = $x("(//h3[contains(text(),'CHASES AT THIS ADDRESS')]//following::div[@class='button'])[2]").getText();
        Log.info(TabNAme);
        if (TabNAme.equals("Members")) {
            logTestStepPass("Member tab is present on the address detail page");
        } else {
            logTestStepFail("Member tab is not present on the address detail page.");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
