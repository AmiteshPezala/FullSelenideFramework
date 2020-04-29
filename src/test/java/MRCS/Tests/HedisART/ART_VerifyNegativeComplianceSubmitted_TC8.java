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

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.getDefaultUncaughtExceptionHandler;
import static java.lang.Thread.sleep;

public class ART_VerifyNegativeComplianceSubmitted_TC8 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify chase can be submitted when chase shows -ve compliance", groups = {"Hedis ART"})
    public void VerifyNegativeComplianceSubmitted_TC8() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisART.navigateToART();
        objRisk.membervalidation();
        sleep(2000);
        $x("//div[contains(text(),'DMARD')]//following::button[@class='control__delete ng-star-inserted']").click();
        sleep(2000);
        $x("//label[contains(text(),'NRC - Ambulatory Prescription for DMARD')]//following::span[@class='ui-button-icon-left ui-clickable pi pi-caret-down']").click();
        sleep(2000);
        $x("//span[contains(text(),'No DMARDs prescribed in timeframe')]").click();
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//span[contains(text(),'Ambulatory Prescription for DMARD')]"));
        sleep(2000);
        objMeasure.NegativeCompliance_ART();
        sleep(2000);
        objRisk.ChecklistForART();
        sleep(2000);
       $x("(//span[contains(text(),'Submit')])[position() =2]").click();
        sleep(1000);
        String Successfulmessage = $x("//div[@class='ui-toast-detail']").getText();
        assertText(Successfulmessage, "SUBMISSION SUCCEEDED!");
        sleep(4000);
        Common.StopWalkThru();
        sleep(2000);
        objLoginOut.logout();
    }
}
