package MRCS.Tests.HedisAWC;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.HedisAWC;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class AWC_VerifyAWCPositiveCompliance_TC4 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify that compliance shows positive when dates of all numerator are in range", groups = {"Hedis AWC"})
    public void VerifyAWCPositiveCompliance_TC4() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisAWC.navigateToAWC();
        objRisk.membervalidation();
        sleep(2000);
        objMeasure.FillAllDetails_AWC();
        sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//span[contains(text(),'AWC Positive')]"));
        sleep(2000);
        objMeasure.PositiveCompliance_ABA();
        sleep(4000);
        objLoginOut.logout();
    }
}
