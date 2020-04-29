package MRCS.Tests.IVAHST;

import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Modules.Hedis.IVAHST.FilterByUserAndMeasure;
import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class HST_VerifyF2FCanNotSelectWhenServiceDateIsNo_TC13 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk = new Risk();

    @Test(description = "Verify that user cannot select F2F when Specific service date = No.", groups = {"IVA HST"})
    public void HST_VerifyF2FCanNotSelectWhenServiceDateIsNo_TC13() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        FilterByUserAndMeasure();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        sleep(4000);
        $x("(//div[contains(text(),'Specific service dates found in document (ENC)?')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[1]").click();
        sleep(2000);
        $x("(//div[contains(text(),'Specific service dates found in document (ENC)?')]//following::span[contains(text(),'No')])").click();
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(3000);
        $x("(//span[contains(text(),'Yes')])[2]").click();
        sleep(3000);
        $x("//div[@class='coding-container']").click();
        sleep(5000);
        if($x("//div[@class='ng-tns-c39-507 ui-dropdown ui-widget ui-state-default ui-corner-all ui-helper-clearfix ui-state-disabled control__input control__input--dropdown']").isDisplayed()){
            logTestStepFail("User can select F2F when Specific service date = No");
        }else{
            logTestStepPass("User cannot select F2F when Specific service date = No");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
