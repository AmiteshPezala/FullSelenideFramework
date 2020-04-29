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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static MRCS.Utils.Common.assertText;
import static MRCS.Utils.TestBase.logTestStep;
import static MRCS.Utils.TestBase.logTestStepPass;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class CBP_VerifyValidationMessageForDates_TC14 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Field shows a validation message when the date entered is outside the timeframe.", groups = {"Hedis CBP"})
    public void CBP_VerifyValidationMessageForDates_TC14() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisCBP.navigateToCBP();
        objRisk.membervalidation();
        sleep(3000);
        if ($x("//button[contains(text(),'×')]").exists()) {
            $x("//button[contains(text(),'×')]").click();
            sleep(2000);
            $x("//button[@class='control__add']").click();
            sleep(2000);
        } else {
            Log.info("Record not available");
            $x("//button[@class='control__add']").click();
            sleep(2000);
        }
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
        Date date = new Date();
        String Date1 = dateFormat.format(date);
        Log.info(Date1);
        String Date3 = Date1;
        SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal2 = Calendar.getInstance();
        try {
            cal2.setTime(sdf2.parse(Date3));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal2.add(Calendar.YEAR, -2);
        String newDate2 = sdf2.format(cal2.getTime());
        System.out.println("new date" + newDate2);
        try {
            cal2.setTime(sdf2.parse(newDate2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        $x("(//div[contains(text(),'B/P Reading Date must be On or After the last Admi')]//following::input)[1]").setValue(newDate2);
        sleep(2000);
        $x("//div[@class='control__header__label'][contains(text(),'B')]").click();
        sleep(2000);
        if($x("//div[@class='control__header__error ng-star-inserted']").isDisplayed()){
            logTestStepPass("Validation message is displayed if dates are out of time frame.");
        }else{
            logTestStepFail("Validation message is not displayed.");
        }
        objLoginOut.logout();
    }
}
