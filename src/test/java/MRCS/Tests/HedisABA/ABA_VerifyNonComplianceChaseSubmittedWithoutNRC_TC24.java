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
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class ABA_VerifyNonComplianceChaseSubmittedWithoutNRC_TC24 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify that message is displayed if chase is submitted without NRC", groups = {"Hedis ABA"})
    public void VerifyNonComplaintChaseSubmittedWithoutNRC_TC24() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisABA.navigateToABA();
        objRisk.membervalidation();
        sleep(2000);
        objMeasure.ClearData();
        sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//th[contains(text(),'Numerator')]"));
        sleep(2000);
        /*objRisk.ChecklistForART();
        sleep(2000);*/
        $x("(//span[contains(text(),'Submit')])[position() =2]").click();
        sleep(2000);
        String Message= $x("//span[@class='ui-messages-detail ng-tns-c5-1 ng-star-inserted']").getText();
        assertText(Message, "NEGATIVE REASON CODE IS MISSING FROM NON-COMPLIANT NUMERATOR \"BMI POSITIVE\";");
        sleep(2000);
        objLoginOut.logout();

    }
}
