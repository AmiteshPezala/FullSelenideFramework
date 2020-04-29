package MRCS.Tests.HedisART;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.HedisART;
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

public class ART_VerifyPositiveCompliance_TC5 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify positive compliance for chase", groups = {"Hedis ART"})
    public void VerifyPositiveCompliance_TC5() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisART.navigateToART();
        objRisk.membervalidation();
        sleep(2000);
        objMeasure.DataForDMARD();
        sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//span[contains(text(),'Ambulatory Prescription for DMARD')]"));
        sleep(2000);
        objMeasure.PositiveCompliance_ART();
        sleep(2000);
        objLoginOut.logout();
    }
}
