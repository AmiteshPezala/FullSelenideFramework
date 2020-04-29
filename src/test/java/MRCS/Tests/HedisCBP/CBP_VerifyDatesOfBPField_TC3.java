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
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class CBP_VerifyDatesOfBPField_TC3 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify dates of BP field is in timeframe or not", groups = {"Hedis CBP"})
    public void VerifyDatesOfBPField_TC3() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisCBP.navigateToCBP();
        objRisk.membervalidation();
        sleep(2000);
        if($x("//button[contains(text(),'×')]").exists())
        {
            $x("//button[contains(text(),'×')]").click();
            sleep(2000);
        }else{
            Log.info("Record not available");
        }
        $x("//button[@class='control__add']").click();
        sleep(2000);
        $x("//input[@id='Date']").sendKeys("02/01/2018");
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
        if($x("//input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled']").isDisplayed()){
            logTestStepPass("Validation message displayed");
        }else{
            logTestStepFail("Validation message not displayed");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
