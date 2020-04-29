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
import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class ABA_VerifyBMIPercentileVaule_TC5 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify that message is displayed if we entered BMI percentile more than 100.", groups = {"Hedis ABA"})
    public void ABA_VerifyBMIPercentileVaule_TC5() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisABA.navigateToABA();
        objRisk.membervalidation();
        sleep(2000);
        logTestStep("Verify the limit of percentile field of BMI module.");
        $x("//div[contains(text(),'BMI')]//following::button[@class='control__delete ng-star-inserted']").click();
        sleep(2000);
        $x("(//div[contains(text(),'BMI')]//following::input)[4]").setValue("101");
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
        if($x("//div[contains(text(),'BMI')]//following::div[@class='control__header__error ng-star-inserted']").isDisplayed()){
            logTestStepPass("Validation message displayed.");
        }else{
            logTestStepFail("Validation message not displayed.");
        }
        objLoginOut.logout();
    }
}
