package MRCS.Tests.HedisCBP;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.HedisCBP;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class CBP_VerifyTwoAdminDates_TC1 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify that chase having two admin dates", groups = {"Hedis CBP"})
    public void VerifyTwoAdminDates_TC1() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisCBP.navigateToCBP();
        objRisk.membervalidation();
        sleep(2000);
        logTestStep("Checking that there are how many admin dates are available");
        sleep(2000);
        if($x("//input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled']").isDisplayed()){
            logTestStepPass("2 admin dates available in MY or MY-1");
        }else{
            logTestStepFail("2 admin dates not available in MY or MY-1");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
