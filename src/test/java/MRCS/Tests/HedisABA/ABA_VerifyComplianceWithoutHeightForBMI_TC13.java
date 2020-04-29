package MRCS.Tests.HedisABA;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.HedisABA;
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

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class ABA_VerifyComplianceWithoutHeightForBMI_TC13 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify that if we not filled height data then compliance is negative", groups = {"Hedis ABA"})
    public void VerifyComplianceWithoutHeightForBMI_TC13() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisABA.navigateToABA();
        objRisk.membervalidation();
        sleep(2000);
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
        Date date = new Date();
        String Date1 = dateFormat.format(date);
        Log.info(Date1);
        String age = $x("//div[@class='container-header']//div[4]//div[2]").getText();
        Log.info(age);
        int Age = Integer.parseInt(age);
        if(Age < 20){
            objMeasure.BMIDate_ABA();
            sleep(2000);
            objMeasure.WeightRecorded_ABA();
            sleep(2000);
            $x("//div[contains(text(),'Body Height Test')]//following::button[@class='control__delete ng-star-inserted']").click();
            sleep(2000);
            JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
            js.executeScript("arguments[0].scrollIntoView();", $x("//th[contains(text(),'Numerator')]"));
            sleep(2000);
            objMeasure.NegativeCompliance_ABA();
        }else{
            logTestStep("Age is greater than 20 yrs");
        }
    }
}
