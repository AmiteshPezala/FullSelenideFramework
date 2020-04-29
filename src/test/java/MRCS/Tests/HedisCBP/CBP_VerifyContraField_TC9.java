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
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static MRCS.Utils.TestBase.*;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class CBP_VerifyContraField_TC9 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Contra non compliance shows only when exclusion date is in 2019 and page number is available.", groups = {"Hedis CBP"})
    public void CBP_VerifyContraField_TC9() throws Exception {
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
        } else {
            Log.info("Record not available");
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
        String Date4 = Date1;
        SimpleDateFormat sdf3 = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal3 = Calendar.getInstance();
        try {
            cal3.setTime(sdf3.parse(Date4));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal3.add(Calendar.YEAR, -1);
        String newDate3 = sdf3.format(cal3.getTime());
        System.out.println("new date" + newDate3);
        try {
            cal3.setTime(sdf3.parse(newDate3));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String Date5 = Date1;
        SimpleDateFormat sdf4 = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal4 = Calendar.getInstance();
        try {
            cal4.setTime(sdf4.parse(Date5));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal4.add(Calendar.YEAR, +2);
        String newDate4 = sdf4.format(cal4.getTime());
        System.out.println("new date" + newDate4);
        try {
            cal4.setTime(sdf4.parse(newDate4));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        $x("//label[contains(text(),'Contra')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
        sleep(2000);
        $x("//p-dropdownitem//li//span").click();
        sleep(2000);
        $x("(//label[contains(text(),'Contra')]//following::input)[2]").setValue(newDate3);
        sleep(2000);
        $x("(//label[contains(text(),'Contra')]//following::input)[3]").setValue("1");
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(3000);
        if ($x("//label[contains(text(),'Exclusion')]//following::div[@class='control__header__error ng-star-inserted']").isDisplayed()) {
            logTestStepFail("Contra not shows .");
        } else {
            logTestStepPass("Contra shows.");
        }
        $x("(//label[contains(text(),'Contra')]//following::input)[2]").setValue(newDate4);
        sleep(2000);
        $x("(//label[contains(text(),'Contra')]//following::input)[3]").setValue("1");
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(7000);
        if ($x("//label[contains(text(),'Exclusion')]//following::div[@class='control__header__error ng-star-inserted']").isDisplayed()) {
            logTestStepPass("Contra non compliance shows only when exclusion date is in 2019 and page number is available.");
        } else {
            logTestStepFail("Dates are not in range still contra shows.");
        }
        objLoginOut.logout();
    }
}
