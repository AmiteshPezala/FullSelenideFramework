package MRCS.Tests.HedisOMW;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.HedisOMW;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class OMW_PositiveComplainceForPrescriptionDate_TC6 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Osteoporosis shows a +ve compliance when prescription date is on the IESD ", groups = {"Hedis OMW"})
    public void OMW_PositiveComplainceForPrescriptionDate_TC6() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisOMW.navigateToOMW();
        objRisk.membervalidation();
        sleep(2000);
        objMeasure.DeleteRow_OMW();
        sleep(2000);
        String IESDDate = $x("//label[contains(text(),'Date (admin)')]//following::input").getValue();
        Log.info(IESDDate);
        sleep(2000);
        $x("(//div[contains(text(),'Rx')]//following::input)[1]").setValue(IESDDate);
        sleep(2000);
        $x("(//div[contains(text(),'Rx')]//following::span[@class='ui-button-icon-left ui-clickable pi pi-caret-down'])").click();
        sleep(2000);
        $x("//span[contains(text(),'Abaloparatide')]").click();
        sleep(2000);
        $x("(//div[contains(text(),'Rx')]//following::input)[3]").setValue("1");
        sleep(2000);
        $x("//div[contains(text(),'Rx')]").click();
        sleep(2000);
        objMeasure.PositiveCompliance_OMW();
        sleep(2000);
        objLoginOut.logout();
    }
}
