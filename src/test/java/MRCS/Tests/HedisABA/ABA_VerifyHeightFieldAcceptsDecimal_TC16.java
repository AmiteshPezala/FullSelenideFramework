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

import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class ABA_VerifyHeightFieldAcceptsDecimal_TC16 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify that height field value accept decimal values.", groups = {"Hedis ABA"})
    public void ABA_VerifyHeightFieldAcceptsDecimal_TC16() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisABA.navigateToABA();
        objRisk.membervalidation();
        sleep(2000);
        $x("//div[contains(text(),'Body Height Test')]//following::button[@class='control__delete ng-star-inserted']").click();
        sleep(2000);
        $x("(//div[contains(text(),'Body Height Test')]//following::input)[3]").sendKeys("11.1");
        sleep(3000);
        if($x("//div[contains(text(),'Body Height Test')]//following::div[@class='control__header__error ng-star-inserted']").isDisplayed()){
            logTestStepFail("Height field not accepts decimal vaules.");
        }else{
            logTestStepPass("Height field accepts decimal vaules.");
        }
        objLoginOut.logout();
    }
}
