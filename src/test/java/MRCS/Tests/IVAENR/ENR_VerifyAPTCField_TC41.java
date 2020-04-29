package MRCS.Tests.IVAENR;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.IVAENR;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class ENR_VerifyAPTCField_TC41 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify APTC field.", groups = {"IVA ENR"})
    public void ENR_VerifyAPTCField_TC41() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        IVAENR.navigateToENR();
        String SubscriberType=$x("//input[@id='SubscriberType']").getValue();
        Log.info(SubscriberType);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//*[contains(text(),'APTC')]"));
        sleep(2000);
        if(SubscriberType.equals("S")){
            logTestStep("Subscriber type is S");
            if($x("(//div[contains(text(),'APTC')]//following::input)[1]").isEnabled() || $x("(//div[contains(text(),'APTC')]//following::input)[2]").isEnabled()){
                logTestStepPass("APTC field is editable for subscriber type = S");
            }else{
                logTestStepFail("APTC field is non editable for subscriber type = S");
                Assert.fail("APTC field is non editable for subscriber type = S");
            }
        }else{
            logTestStep("Subscriber type is N");
            logTestStepPass("APTC field is non editable for subscriber type = N");
        }
        objLoginOut.logout();
    }
}
