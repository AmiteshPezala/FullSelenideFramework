package MRCS.Tests.HedisIMA;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.HedisIMA;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class IMA_PositiveComplianceForTdap_TC5 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify Tdap shows +ve compliance when TDAP VACCINE ON OR BETWEEN THE MEMBER'S 10TH AND 13TH BIRTHDAY", groups = {"Hedis IMA"})
    public void PositiveComplianceForTdap_TC5() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisIMA.navigateToIMA();
        objRisk.membervalidation();
        sleep(2000);
        objMeasure.DeleteRow_IMA();
        sleep(2000);
        objMeasure.DataForTdap_IMA();
        sleep(2000);
        objMeasure.PositiveComplianceForTdap_IMA();
        sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//span[contains(text(),'Meningococcal')]"));
        sleep(2000);
        logTestStep("Checking the compliance for numerator Tdap");
        sleep(2000);
        objMeasure.DataForHPV_IMA();
        sleep(2000);
        objMeasure.PositiveComplianceForTdap_IMA();
        sleep(2000);
        objLoginOut.logout();
    }
}

