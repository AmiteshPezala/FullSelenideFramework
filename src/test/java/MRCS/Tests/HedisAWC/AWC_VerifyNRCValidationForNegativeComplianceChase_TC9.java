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
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class AWC_VerifyNRCValidationForNegativeComplianceChase_TC9 extends TestBase{
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify NRC validation for negative compliance", groups = {"Hedis AWC"})
    public void VerifyNRCValidationForNegativeComplianceChase_TC9() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisAWC.navigateToAWC();
        objRisk.membervalidation();
        sleep(2000);
        for (int i = 1; i <= 5; i++) {
            $x("(//div[contains(text(),'Health History')]//following::button[@class='control__delete ng-star-inserted'])[" + (i +0) + "]").click();
            sleep(2000);
        }
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//span[contains(text(),'AWC Positive')]"));
        sleep(2000);
        objMeasure.NegativeCompliance_ABA();
        sleep(2000);
        objRisk.ChecklistForART();
        $x("(//span[contains(text(),'Submit')])[position() =2]").click();
        sleep(2000);
        String Message= $(".ui-messages-detail").getText();
        assertText(Message, "Negative reason code is missing from non-compliant numerator \"AWC Positive\";");
        sleep(2000);
    }
}
