package MRCS.Tests.IVAHST;

import MRCS.Locators.RiskRepo.ProviderLookUpRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import static MRCS.Modules.Hedis.IVAHST.FilterByUserAndMeasure;
import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class HST_VerifyMagnifyingIconDisplayedInEncounter_TC64 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk = new Risk();

    @Test(description = "Verify that magnifying icon is available near provider field in encounter details section.", groups = {"IVA HST"})
    public void HST_VerifyMagnifyingIconDisplayed_TC64() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        FilterByUserAndMeasure();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        sleep(4000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//div[contains(text(),'Service Start Date')]"));
        sleep(2000);
        if($(ProviderLookUpRepo.MagnifyingIconInEncounter).isDisplayed()){
            logTestStepPass("Magnifying icon is available near provider field in encounter details section.");
        }else{
            logTestStepFail("Magnifying icon is not available.");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
