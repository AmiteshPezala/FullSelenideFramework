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
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class CBP_VerifyComplianceForBPDate_TC7 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Compliance indicator shows +ve compliance when BP Date in MY", groups = {"Hedis CBP"})
    public void VerifyComplianceForBPDate_TC7() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisCBP.navigateToCBP();
        objRisk.membervalidation();
        sleep(2000);
//        String text= Common.getElementText(By.xpath("//*[contains(text(),'B/P Reading Date must be On or After the last Admin Date in')]"),5);
//        String[] arrSplit_3 = text.split("\\s");    // Splitting the line "Top 699 records"
//        String Date = null;
//        for (int i = 13; i < 14; i++) {
//            Date = arrSplit_3[i];
//            break;
//        }
//        System.out.println(Date);
        if ($x("//button[contains(text(),'×')]").exists()) {
            $x("//button[contains(text(),'×')]").click();
            sleep(2000);
        } else {
            Log.info("Record not available");
        }
        $x("//button[@class='control__add']").click();
        sleep(2000);
        $x("//input[@id='Date']").sendKeys("12/31/2020");
        sleep(2000);
        $x("//input[@id='Systolic']").sendKeys("70");
        sleep(2000);
        $x("//input[@id='Diastolic']").sendKeys("40");
        sleep(2000);
        $x("//input[@id='PageNumber']").sendKeys("1");
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//th[contains(text(),'Numerator')]"));
        sleep(2000);
        objMeasure.PositiveCompliance_ABA();
        sleep(2000);
        objLoginOut.logout();
    }
}
