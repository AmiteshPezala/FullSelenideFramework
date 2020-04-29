package MRCS.Tests.HedisWCC;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.HedisWCC;
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

public class WCC_ToCheckNRCValidation_TC18 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify NRC validation", groups = {"Hedis WCC"})
    public void ToCheckNRCValidation_TC18() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisWCC.navigateToWcc();
        objRisk.membervalidation();
        sleep(2000);
        objMeasure.NRCValidation_WCC();
        sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//span[contains(text(),'BMI')]"));
        sleep(2000);
        objRisk.ChecklistForART();
        sleep(2000);
        $x("(//span[contains(text(),'Submit')])[position() =2]").click();
        sleep(1000);
        String SuccessfulMessage = $x("//span[@class='ui-messages-detail ng-tns-c5-1 ng-star-inserted']").getText();
        assertText(SuccessfulMessage, "NEGATIVE REASON CODE IS MISSING FROM NON-COMPLIANT NUMERATOR \"BMI\"; NEGATIVE REASON CODE IS MISSING FROM NON-COMPLIANT NUMERATOR \"NUTRITION COUNSELING\"; NEGATIVE REASON CODE IS MISSING FROM NON-COMPLIANT NUMERATOR \"PHYSICAL ACTIVITY COUNSELING\";");
        sleep(2000);
        $x("//i[@class='pi pi-times']").click();
        sleep(2000);
        objLoginOut.logout();
    }
}
