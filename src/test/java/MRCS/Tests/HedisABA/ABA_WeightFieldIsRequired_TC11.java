package MRCS.Tests.HedisABA;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.HedisABA;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import static MRCS.Utils.TestBase.logTestStep;
import static MRCS.Utils.TestBase.logTestStepPass;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class ABA_WeightFieldIsRequired_TC11 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify that Weight measure is required field.", groups = {"Hedis ABA"})
    public void ABA_WeightFieldIsRequired_TC11() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisABA.navigateToABA();
        objRisk.membervalidation();
        sleep(2000);
         objMeasure.BMIDate_ABA();
         $x("//div[contains(text(),'Body Weight Test')]//following::button[@class='control__delete ng-star-inserted']").click();
         sleep(2000);
        objMeasure.HeightRecorded_ABA();
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//label[contains(text(),'Exclusion')]"));
        sleep(2000);
        objMeasure.NegativeCompliance_ABA();
        logTestStepPass("Weight measure is required field.");
        objLoginOut.logout();
    }
}
