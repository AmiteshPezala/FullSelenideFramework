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
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class ABA_VerifyComplianceForBothConditionForBMI_TC18 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify BMI compliance for both condition", groups = {"Hedis ABA"})
    public void VeryComplianceForBothConditionForBMI_TC18() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisABA.navigateToABA();
        objRisk.membervalidation();
        sleep(2000);
        ElementsCollection DeleteButton=$$x("//div[contains(text(),'BMI')]//following::button[@class='control__delete ng-star-inserted']");
        int count=DeleteButton.size();
        for(int i=1;i<=count;i++){
            $x("(//div[contains(text(),'BMI')]//following::button[@class='control__delete ng-star-inserted'])[" + (i +0) + "]").click();
            sleep(2000);
        }
        $x("(//button[@class='control__delete'])[1]").click();
        sleep(2000);
        $x("(//button[@class='control__delete'])[2]").click();
        sleep(2000);
        objMeasure.BMIDate_ABA();
        objMeasure.WeightRecorded_ABA();
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//th[contains(text(),'Numerator')]"));
        sleep(2000);
        objMeasure.PositiveCompliance_ABA();
        sleep(2000);
        objLoginOut.logout();
    }
}
