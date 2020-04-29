package MRCS.Tests.IVAHST;

import MRCS.Modules.CommonRisk;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static MRCS.Modules.Hedis.IVAHST.FilterByUserAndMeasure;
import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class HST_VerifyServiceDateToField_TC18 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk = new Risk();

    @Test(description = "Verify that validation message is displayed or not.", groups = {"IVA HST"})
    public void HST_VerifyServiceDateToField_TC18() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        FilterByUserAndMeasure();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        sleep(4000);
        CommonRisk.ENCasYes();
        CommonRisk.F2FasYes();
        sleep(2000);
        $x("//div[contains(text(),'Service Start Date')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
        sleep(2000);
        $x("//div[contains(text(),'Service Start Date')]//following::span[contains(text(),'Yes')]").click();
        sleep(2000);
        String EndDate=$x("(//div[contains(text(),'Service Start Date')]//following::input)[2]").getValue();
        Log.info("End date : " + EndDate);
        sleep(2000);
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(EndDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.YEAR, -2);
        String newDate = sdf.format(cal.getTime());
        System.out.println("new date" + newDate);
        try {
            cal.setTime(sdf.parse(newDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        $x("//div[contains(text(),'Service End Date')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
        sleep(2000);
        $x("//div[contains(text(),'Service End Date')]//following::span[contains(text(),'Yes')]").click();
        sleep(2000);
        $x("(//div[contains(text(),'Service End Date')]//following::input)[2]").setValue(newDate);
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
        if($x("//div[contains(text(),'Service End Date')]//following::div[@class='control__header__error ng-star-inserted']").isDisplayed()){
            logTestStepPass("Validation message displayed.");
        }else{
            logTestStepFail("Validation message not displayed.");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
