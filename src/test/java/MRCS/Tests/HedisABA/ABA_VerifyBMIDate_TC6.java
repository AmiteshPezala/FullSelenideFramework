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
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class ABA_VerifyBMIDate_TC6 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure=new Measure();
    Common objcommon=new Common();

    @Test(description = "Verify that message is displayed if BMI date is not in 2017 or 2018", groups = {"Hedis ABA"})
    public void VerifyBMIDate_TC6() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisABA.navigateToABA();
        objRisk.membervalidation();
        sleep(2000);
        $x("(//div[contains(text(),'BMI')]//following::input)[1]").setValue("01/01/2016");
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(5000);
        String ValidationMessage= $x("//div[@class='control__header__error ng-star-inserted']").getText();
        sleep(2000);
        assertText(ValidationMessage, "Date between 01/01/2017 and 12/31/2018 expected;");
        sleep(2000);
        objLoginOut.logout();

    }
}
