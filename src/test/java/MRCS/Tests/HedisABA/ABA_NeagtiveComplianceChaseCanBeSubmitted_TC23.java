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

import static MRCS.Utils.Common.assertText;
import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class ABA_NeagtiveComplianceChaseCanBeSubmitted_TC23 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Neagtive compliance chase can be submitted.", groups = {"Hedis ABA"})
    public void ABA_NeagtiveComplianceChaseCanBeSubmitted_TC23() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisABA.navigateToABA();
        objRisk.membervalidation();
        sleep(2000);
        $x("//*[contains(text(),'BMI')]//following::button[@class='control__delete ng-star-inserted']").click();
        sleep(2000);
        objMeasure.WeightRecorded_ABA();
        $x("//*[contains(text(),'Body Height Test')]//following::button[@class='control__delete ng-star-inserted']").click();
        sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//label[contains(text(),'Exclusion')]"));
        sleep(2000);
        objMeasure.NegativeCompliance_ABA();
        sleep(2000);
        JavascriptExecutor js1 = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js1.executeScript("arguments[0].scrollIntoView();", $x("//*[contains(text(),'Body Weight Test')]"));
        sleep(2000);
        $x("//label[contains(text(),'NRC - BMI Positive')]//following::span[@class='ui-button-icon-left ui-clickable pi pi-caret-down']").click();
        sleep(2000);
        $x("//span[contains(text(),'No BMI found in 2019 or 2018')]").click();
        sleep(2000);
        objRisk.ChecklistForART();
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
