package MRCS.Tests.HedisABA;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.HedisABA;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static MRCS.Utils.TestBase.*;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class ABA_VerifyWeightFieldAcceptDecimal_TC10 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify that weight field accepts decimal values.", groups = {"Hedis ABA"})
    public void ABA_VerifyWeightFieldAcceptDecimal_TC10() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisABA.navigateToABA();
        objRisk.membervalidation();
        sleep(2000);
        logTestStep("Verifying the limit vaule field of weight module. ");
        $x("//div[contains(text(),'Body Weight Test')]//following::button[@class='control__delete ng-star-inserted']").click();
        sleep(2000);
        $x("(//div[contains(text(),'Body Weight Test')]//following::input)[3]").sendKeys("11.1");
        sleep(3000);
        if($x("//div[contains(text(),'BMI')]//following::div[@class='control__header__error ng-star-inserted']").isDisplayed()){
            logTestStepFail("Weight field not accept decimal vaules");
        }else{
            logTestStepPass("Weight field accept decimal vaules");
        }
        objLoginOut.logout();
    }
}
