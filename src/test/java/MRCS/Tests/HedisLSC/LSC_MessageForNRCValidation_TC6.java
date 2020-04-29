package MRCS.Tests.HedisLSC;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.HedisLSC;
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

public class LSC_MessageForNRCValidation_TC6 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify that validation displayed if user tries to submit with out NRC for a non compliance chase", groups = {"Hedis LSC"})
    public void LSC_MessageForNRCValidation_TC6() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisLSC.NavigateToLSC();
        objRisk.membervalidation();
        sleep(2000);
        HedisLSC.DeleteAdd();
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//span[contains(text(),'Lead Screening')]"));
        sleep(2000);
        objMeasure.NegativeCompliance_LSC();
        sleep(2000);
        objRisk.ChecklistForART();
        $x("(//span[contains(text(),'Submit')])[position() =2]").click();
        sleep(1000);
        String Successfulmessage = $x("//span[@class='ui-messages-detail ng-tns-c5-1 ng-star-inserted']").getText();
        assertText(Successfulmessage, "Negative reason code is missing from non-compliant numerator \"Lead Screening\";");
        sleep(2000);
        objLoginOut.logout();
    }
}
