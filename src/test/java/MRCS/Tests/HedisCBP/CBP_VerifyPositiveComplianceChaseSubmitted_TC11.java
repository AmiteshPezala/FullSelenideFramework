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
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class CBP_VerifyPositiveComplianceChaseSubmitted_TC11 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify chase can be submitted when the complaince is +ve", groups = {"Hedis CBP"})
    public void VerifyPositiveComplianceChaseSubmitted_TC11() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisCBP.navigateToCBP();
        objRisk.membervalidation();
        sleep(2000);
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
        Date date = new Date();
        String Date1 = dateFormat.format(date);
        if ($x("//button[contains(text(),'×')]").exists()) {
            $x("//button[contains(text(),'×')]").click();
            sleep(2000);

        } else {
            Log.info("Record not available");
        }
        $x("//button[@class='control__add']").click();
        sleep(2000);
        $x("//input[@id='Date']").sendKeys(Date1);
        sleep(2000);
        $x("//input[@id='Systolic']").sendKeys("70");
        sleep(2000);
        $x("//input[@id='Diastolic']").sendKeys("40");
        sleep(2000);
        $x("//input[@id='PageNumber']").sendKeys("1");
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(4000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//th[contains(text(),'Numerator')]"));
        objMeasure.PositiveCompliance_ABA();
        sleep(2000);
        objRisk.ChecklistForART();
        sleep(2000);
        $x("(//span[contains(text(),'Submit')])[position() =2]").click();
        sleep(1000);
        String Successfulmessage = $x("//div[@class='ui-toast-detail']").getText();
        assertText(Successfulmessage, "SUBMISSION SUCCEEDED!");
        sleep(5000);
        Common.StopWalkThru();
        sleep(2000);
        objLoginOut.logout();
    }
}
