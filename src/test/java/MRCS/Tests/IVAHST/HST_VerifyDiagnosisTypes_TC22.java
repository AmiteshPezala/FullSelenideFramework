package MRCS.Tests.IVAHST;

import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Modules.Hedis.IVAHST.FilterByUserAndMeasure;
import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class HST_VerifyDiagnosisTypes_TC22 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk = new Risk();

    @Test(description = "Verify three diagnosis types are present.", groups = {"IVA HST"})
    public void HST_VerifyDiagnosisTypes_TC22() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        FilterByUserAndMeasure();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        sleep(4000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//h3[contains(text(),'Diagnoses')]"));
        sleep(2000);
        String Encounters=$x("//h3[contains(text(),'Diagnoses')]").getText();
        Log.info(Encounters);
        String ActTotal=$x("(//span[contains(text(),'Total')])[2]").getText();
        Log.info(ActTotal);
        String ActAdmin=$x("(//span[contains(text(),'Admin')])[2]").getText();
        Log.info(ActAdmin);
        String ActAdded=$x("(//span[contains(text(),'Added')])[2]").getText();
        Log.info(ActAdded);
        if(Encounters.equals("DIAGNOSES")){
            assertText(ActTotal,"Total");
            logTestStep("Verified Diagnoses Total");
            assertText(ActAdmin,"Admin");
            logTestStep("Verified Diagnoses Admin");
            assertText(ActAdded,"Added");
            logTestStep("Verified Diagnoses Added");
        }else{
            Assert.fail("No Diagnoses types found");
        }
        Selenide.sleep(2000);
        objLoginOut.logout();
    }
}
