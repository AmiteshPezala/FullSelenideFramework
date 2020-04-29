package MRCS.Tests.HedisCBP;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.HedisCBP;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
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

public class CBP_NegativeChaseCanBeSubmitted_TC12 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Neagtive compliance chase can be submitted.", groups = {"Hedis CBP"})
    public void CBP_NegativeChaseCanBeSubmitted_TC12() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisCBP.navigateToCBP();
        objRisk.membervalidation();
        sleep(3000);
        if ($x("//button[contains(text(),'×')]").exists()) {
            $x("//button[contains(text(),'×')]").click();
            sleep(2000);
        } else {
            Log.info("Record not available");
        }
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//label[contains(text(),'Exclusion')]"));
        sleep(2000);
        objMeasure.NegativeCompliance_ABA();
        sleep(2000);
        $x("(//label[contains(text(),'NRC - BP Controlled')]//following::input)[1]").setValue("a");
        sleep(2000);
        $x("(//label[contains(text(),'NRC - BP Controlled')]//following::input)[1]").sendKeys(Keys.ARROW_DOWN);
        sleep(2000);
        $x("(//label[contains(text(),'NRC - BP Controlled')]//following::input)[1]").sendKeys(Keys.ENTER);
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
