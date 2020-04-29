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
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class AWC_NegativeComplianceChaseSubmitted_TC8 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify that negative compliance chase can be submitted with NRC.", groups = {"Hedis AWC"})
    public void AWC_NegativeComplianceChaseSubmitted_TC8() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisAWC.navigateToAWC();
        objRisk.membervalidation();
        sleep(2000);
        for (int i = 1; i <= 5; i++) {
            $x("(//div[contains(text(),'Health History')]//following::button[@class='control__delete ng-star-inserted'])[" + (i + 0) + "]").click();
            sleep(2000);
        }
        objMeasure.NegativeCompliance_ABA();
        sleep(2000);
        $x("//label[contains(text(),'NRC - AWC Positive')]//following::input").setValue("");
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
        $x("(//label[contains(text(),'NRC - AWC Positive')]//following::input)[1]").setValue("a");
        sleep(2000);
        $x("(//label[contains(text(),'NRC - AWC Positive')]//following::input)[1]").sendKeys(Keys.ARROW_DOWN);
        sleep(2000);
        $x("(//label[contains(text(),'NRC - AWC Positive')]//following::input)[1]").sendKeys(Keys.ENTER);
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//span[contains(text(),'AWC Positive')]"));
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
