package MRCS.Tests.HedisCIS;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.HedisCIS;
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

public class CIS_PositiveComplianceForPCV_TC23 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "PCV shows +ve compliance when 4 x PCV between DOB + 42 days and DOB + 2 years.", groups = {"Hedis CIS"})
    public void CIS_PositiveComplianceForPCV_TC23() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisCIS.navigateToCIS();
        objRisk.membervalidation();
        sleep(2000);
        objMeasure.DeleteRow_CIS();
        sleep(2000);
        objMeasure.DataForPCV_CIS();
        $x("//div[@class='coding-container']").click();
        sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//span[contains(text(),'PCV')]"));
        sleep(2000);
        objMeasure.PositiveCompliancePCV_CIS();
        sleep(2000);
        objLoginOut.logout();
    }
}
